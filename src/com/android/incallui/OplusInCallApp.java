package com.android.incallui;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.oplus.share.OplusInCallUIReceiver;
import com.internal_dependency.AddOnSdkDepends;
import com.internal_dependency.ApiAdapterDepends;
import com.internal_dependency.SettingsUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public class OplusInCallApp extends InCallApp {
    public static final String LOG_TAG = "OplusInCallApp";
    private static Application sMe;
    private OplusInCallUIReceiver mOplusInCallUIReceiver;
    private static final String OPLUS_ACTION_PHONE_LOG_SWITCH = "phone.log.switch.broadcast";
    private static final IntentFilter OPLUS_ACTION_PHONE_LOG_SWITCH_FILTER = new IntentFilter(OPLUS_ACTION_PHONE_LOG_SWITCH);
    public static boolean sIsRtlLanguage = false;
    private static Context mOverrideDefaultDisplayUiContext = null;
    private final BroadcastReceiver mOplusLogSwitchedReceiver = new BroadcastReceiver() { // from class: com.android.incallui.OplusInCallApp.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i(OplusInCallApp.LOG_TAG, "mOplusLogSwitchedReceiver : " + intent);
            Log.oplusRefreshLogSwitch(context);
        }
    };
    private ContentObserver mLogSwitchObserver = new ContentObserver(new Handler()) { // from class: com.android.incallui.OplusInCallApp.2
        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            Log.oplusRefreshLogSwitch(OplusInCallApp.getAppContext());
        }
    };

    /* loaded from: classes.dex */
    public static class DefaultDisplayUiContext {
        private static final Context mInstance = L1.c.b(OplusInCallApp.sMe, 2);

        private DefaultDisplayUiContext() {
        }
    }

    public OplusInCallApp() {
        setInCallAppInstance(this);
    }

    public static Context getAppContext() {
        Application application = sMe;
        if (application != null) {
            return application.getApplicationContext();
        }
        throw new IllegalStateException("No OplusInCallApp here!");
    }

    public static Context getDefaultDisplayUiContext() {
        Context context = mOverrideDefaultDisplayUiContext;
        if (context == null) {
            return DefaultDisplayUiContext.mInstance;
        }
        return context;
    }

    public static Application getInCallAppInstance() {
        return sMe;
    }

    public static void setDefaultDisplayUiContext(Context context) {
        mOverrideDefaultDisplayUiContext = context;
    }

    public static void setInCallAppInstance(Application application) {
        sMe = application;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        context.setTheme(R.style.Theme_COUI_Blue);
        super.attachBaseContext(context);
        ApiAdapterDepends.getSInstance().init(context);
    }

    public void init() {
        OplusFeatureOption.AutoInject.autoInject(getAppContext());
        ResponsiveConfigRepository.f18540a.f();
        boolean z10 = false;
        OplusPhoneUtils.updateFloatingWindowStateSecureValues(getAppContext(), false);
        InCallUIAide.getInstance().setUp(getDefaultDisplayUiContext());
        InCallUIAide.getInstance().checkFontChange();
        Log.oplusRefreshLogSwitch(getAppContext());
        getAppContext().registerReceiver(this.mOplusLogSwitchedReceiver, OPLUS_ACTION_PHONE_LOG_SWITCH_FILTER, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
        getAppContext().getContentResolver().registerContentObserver(SettingsUtils.INSTANCE.getSystemUriFor("log_switch_type"), true, this.mLogSwitchObserver);
        WearInfoQueryUtils.INSTANCE.init(getAppContext());
        this.mOplusInCallUIReceiver = new OplusInCallUIReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.ACTION_AUDIO_RECORD_START");
        getAppContext().registerReceiver(this.mOplusInCallUIReceiver, new IntentFilter("android.intent.action.USER_BACKGROUND"), OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
        getAppContext().registerReceiver(this.mOplusInCallUIReceiver, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            z10 = true;
        }
        sIsRtlLanguage = z10;
        if (!OplusPhoneUtils.isUserUnlocked(getAppContext())) {
            getAppContext().registerReceiver(new BroadcastReceiver() { // from class: com.android.incallui.OplusInCallApp.3
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    com.android.incallui.mvvm.repository.dynamic.b.f18561a.a().o(Boolean.FALSE);
                }
            }, new IntentFilter("android.intent.action.USER_UNLOCKED"), 2);
        }
        AddOnSdkDepends.getSInstance().registerTelephonyExtCallback(getAppContext());
        if (Log.sDebug) {
            Log.d(LOG_TAG, "OplusInCallApp onCreate...end");
        }
    }

    @Override // com.android.incallui.InCallApp, android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z10 = true;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            z10 = false;
        }
        sIsRtlLanguage = z10;
        super.onConfigurationChanged(configuration);
        if (!L1.c.f()) {
            OplusPhoneUtils.setDefaultDisplayResources(getAppContext().getResources());
        }
        OplusPhoneUtils.setDefaultDisplayResources(getDefaultDisplayUiContext().getResources());
    }

    @Override // com.android.incallui.InCallApp, android.app.Application
    public void onCreate() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "OplusInCallApp onCreate...");
        }
        super.onCreate();
        init();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onTrimMemory level:" + i10);
        }
    }

    public OplusInCallApp(Application application) {
        setInCallAppInstance(application);
    }
}
