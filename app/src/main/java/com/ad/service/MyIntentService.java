package com.ad.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.TextViewCompat;
import android.view.KeyEvent;
import android.widget.TextView;

import com.ad.app.MyApp;
import com.ad.model.bean.BasicMasseage;
import com.ad.model.bean.Register;
import com.ad.model.bean.SkinPublish;
import com.ad.model.bean.VolPlan;
import com.ad.utils.LogUtils;
import com.ad.utils.SpUtils;
import com.ad.utils.Utils;
import com.ad.utils.adb;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;
import java.util.List;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.ad.service.action.FOO";
    private static final String ACTION_BAZ = "com.ad.service.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.ad.service.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.ad.service.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        System.out.println("test services");
        mobile();
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);

            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }


    //    private String url = "http://192.168.2.25:8100/phone";
    private String url = "http://192.168.2.170:8787";


//    private String url = "http://192.168.2.15:8102/phone";
//    private String url = "http://192.168.2.3:8102/phone";

    public Socket socket;

    private void mobile() {

        try {
            socket = IO.socket(url);
            initAction();
        } catch (Exception e) {
            e.printStackTrace();
        }


        socket.connect();
    }


    private String connect_error = "connect_error";
    private String disconnect = "disconnect";
    private String connect = "connect";
    private String autho_mess = "autho_mess";//系统未授权，强行退出
    private String switch_status = "switch_status";
    private String basic_masseage = "basic_masseage";
    private String skinPublish = "skinPublish";
    private String theme = "theme";
    private String addtheme = "add-theme";
    private String deltheme = "del-theme";
    private String setStb = "setStb";
    private String setvol = "set-vol";
    private String setvolplan = "set-vol-plan";
    private String reboot = "reboot";
    private String shutDown = "shutDown";
    private String install = "install";
    private String uninstall = "uninstall";
    private String roll_msg = "roll_msg";
    private String test = "helloPush";
    private String site_info = "site-info";

    private void initAction() {
        eventAction(connect_error);
        eventAction(disconnect);
        eventAction(connect);
        eventAction(autho_mess);
        eventAction(switch_status);
        eventAction(basic_masseage);
        eventAction(skinPublish);
        eventAction(theme);
        eventAction(addtheme);
        eventAction(deltheme);
        eventAction(setStb);
        eventAction(setvol);
        eventAction(setvolplan);
        eventAction(shutDown);
        eventAction(reboot);
        eventAction(install);
        eventAction(uninstall);
        eventAction(roll_msg);
        eventAction(site_info);
        eventAction(test);
    }

    private void eventAction(final String actionname) {

        socket.on(actionname, new Emitter.Listener() {

            public void call(Object... arg0) {
                // TODO Auto-generated method stub
                try {
                    if (test.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (connect_error.equals(actionname)) {
                        LogUtils.d(MyApp.mac + "连接失败----");
                    }
                    if (disconnect.equals(actionname)) {
                        LogUtils.d("断开连接----");

                    }
                    if (connect.equals(actionname)) {
                        LogUtils.d("连接成功----");
                        Register register = new Register();
                        register.setMac(MyApp.mac);
                        register.setVersion(Utils.getVersion(context));
                        register.setVoice(Utils.getCurrentVolume(context));
                        register.setResolution(Utils.getWH(context));
//                        "RAM:" + Utils.getSystemAvaialbeMemorySize(context) + "/" + Utils.getSysteTotalMemorySize(context)
//                                + " ROM:" +
                        register.setRam(Utils.getSDAvailableSize(context) + "/" + Utils.getSDTotalSize(context));
                        String jsonString = new Gson().toJson(register);
                        LogUtils.d(jsonString);
//                        socket.emit("register", jsonString);
                    }
                    if (connect.equals(autho_mess)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (switch_status.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (basic_masseage.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                        BasicMasseage basicMasseage = MyApp.jsonToObject(json, new TypeToken<BasicMasseage>() {
                        });
                    }
                    if (skinPublish.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                        List<SkinPublish> skinPublishes = MyApp.jsonToObject(json, new TypeToken<List<SkinPublish>>() {
                        });
                        LogUtils.d(actionname + "@" + skinPublishes.size());
                    }
                    if (theme.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (addtheme.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (deltheme.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (setStb.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (setvol.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                        Integer percent = MyApp.jsonToObject(json, new TypeToken<Integer>() {
                        });
                        MyApp.setStreamVolume(percent);
                        SpUtils.putInt(context, "vol", percent);
                    }
                    if (setvolplan.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                        volPlans = MyApp.jsonToObject(json, new TypeToken<List<VolPlan>>() {
                        });
                        if (!volPlans.isEmpty()) {
                            startvolplan();
                            endvolplan();
                        }
                    }
                    if (shutDown.equals(actionname)) {
                        LogUtils.d(actionname);
                        adb.InputEvent(KeyEvent.KEYCODE_POWER);
                    }
                    if (reboot.equals(actionname)) {
                        LogUtils.d(actionname);
                        adb.reboot();
                    }
                    if (install.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (uninstall.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (roll_msg.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                    if (site_info.equals(actionname)) {
                        String json = arg0[0].toString();
                        LogUtils.d(actionname + "@" + json);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }

        });


    }

    List<VolPlan> volPlans = new ArrayList<>();
    final int STARTVOLPLAN = 0;
    final int ENDVOLPLAN = 1;
    int startvolplan = 0;
    int endvolplan = 0;
    Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case STARTVOLPLAN:
                    int percent = volPlans.get(startvolplan).getVol();
                    LogUtils.d("start " + startvolplan + "th volplan" + percent + "%");
                    MyApp.setStreamVolume(percent);
                    startvolplan();
                    break;
                case ENDVOLPLAN:
                    int oldpercent = SpUtils.getInt(context, "vol", 0);
                    LogUtils.d("end " + startvolplan + "th volplan" + oldpercent + "%");
                    MyApp.setStreamVolume(oldpercent);
                    endvolplan();
                    break;
            }
        }
    };

    private void startvolplan() {
        if (startvolplan > volPlans.size() - 1) {
            startvolplan = 0;
        }

        long starttime = volPlans.get(startvolplan).getStartTime() - System.currentTimeMillis();
        handler.removeMessages(STARTVOLPLAN);
        if (starttime < 0) {
            handler.sendEmptyMessage(STARTVOLPLAN);
        } else {
            handler.sendEmptyMessageDelayed(STARTVOLPLAN, starttime);
        }
        startvolplan++;
    }

    private void endvolplan() {
        if (endvolplan > volPlans.size() - 1) {
            endvolplan = 0;
        }

        long endtime = volPlans.get(endvolplan).getStartTime() - System.currentTimeMillis();
        handler.removeMessages(ENDVOLPLAN);
        if (endtime < 0) {
            handler.sendEmptyMessage(ENDVOLPLAN);
        } else {
            handler.sendEmptyMessageDelayed(ENDVOLPLAN, endtime);
        }
        endvolplan++;
    }

}
