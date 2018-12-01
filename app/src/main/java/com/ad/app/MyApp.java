package com.ad.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.ad.service.MyIntentService;
import com.ad.utils.LogUtils;
import com.ad.utils.SpUtils;
import com.ad.utils.Utils;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class MyApp extends Application {
    /**
     * Application实例
     */
    private static Context context;
    private static AudioManager am;
    private static int maxvolume;
    private static int defaultvolume;
    private static MyApp cInstance;
    public static boolean vodAllAuth = false;
    public static String mac;

    public static RequestQueue getQueue() {
        return queue;
    }

    public static void setQueue(RequestQueue queue) {
        MyApp.queue = queue;
    }

    public static Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        gson = new GsonBuilder().create();
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        maxvolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        defaultvolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        LogUtils.d("maxvolume" + maxvolume + " " + "defaultvolume" + defaultvolume);
        SpUtils.putInt(context, "vol", defaultvolume);

        //未捕获异常处理
//        CrashHandler.getInstance().init(getApplicationContext());

        // 初始化第三方模块
        initThird();

        cInstance = this;

        // 初始化自身功能模块
        initMyself();

        //初始化GreenDao.
        initGreenDao();

        collectStartUp();

        vodAuth();

        queue = Volley.newRequestQueue(getApplicationContext());
        mac = Utils.getMACAddress();
        startService(new Intent(this, MyIntentService.class));
    }

    // 设置音量
    public static void setStreamVolume(int percent) {
        int volume = (int) Math.round((double) maxvolume * percent / 100);
        am.setStreamVolume(AudioManager.STREAM_MUSIC, volume, AudioManager.FLAG_SHOW_UI);
    }


    // 建立请求队列
    public static RequestQueue queue;

    public static RequestQueue getHttpQueue() {
        return queue;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static boolean getVodAuth() {
        return vodAllAuth;
    }

    private void vodAuth() {

    }

    private void initGreenDao() {
    }

//    public static DaoSession getDaoSession() {
//        return session;
//    }

    /**
     * 初始化自身功能模块
     */
    private void initMyself() {
//        VooleProxyManager.initVooleProxy(getApplicationContext());
    }

    /**
     * 初始化第三方模块
     */
    private void initThird() {

        // LeakCanary 初始化放在最优先
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        enabledStrictMode();
//        LeakCanary.install(this);


        // 初始化腾讯Bugly
//        CrashReport.initCrashReport(getApplicationContext(), "4d8682fdeb", true);
        // 腾讯Bugly崩溃测试
        // CrashReport.testJavaCrash();
        // 初始化第三方工具类库
//        Utils.init(getApplicationContext());
    }

    public static MyApp getInstance() {
        return cInstance;
    }

    private static void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }


    /**
     * 记录启动日志
     */
    private void collectStartUp() {
        StringBuilder value = new StringBuilder();
        value.append("{\"data\":{");
        value.append("\"dataType\":\"\",");
        value.append("\"FilmName\":\"AndroidTV启动\",");
        value.append("\"Mid\":\"AndroidTVStartUp\"");
        value.append("}}");

//        DataCollectManager.getInstance().collect("startUp", value.toString());
    }

    /**
     * 获取设备当前屏幕宽高
     */

    public String getWH(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)
                context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);

        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;
        return screenWidth + "x" + screenHeight;
    }

    public static <T> T jsonToObject(String json, TypeToken<T> typeToken) {
        //  new TypeToken<AJson<Object>>() {}.getType()   对象参数
        // new TypeToken<AJson<List<Object>>>() {}.getType() 集合参数

        if (TextUtils.isEmpty(json) || json.equals("null"))
            return null;
        try {
            return gson.fromJson(json, typeToken.getType());
        } catch (Exception e) {
            return null;
        }
    }


}
