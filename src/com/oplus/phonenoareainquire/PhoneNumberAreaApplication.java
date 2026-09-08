package com.oplus.phonenoareainquire;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import com.oplus.phonenoareainquire.utils.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class PhoneNumberAreaApplication extends Application {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f28829a = false;

    /* renamed from: b, reason: collision with root package name */
    public static PhoneNumberAreaApplication f28830b;

    /* loaded from: classes3.dex */
    public class a extends AsyncTask<Void, Void, Void> {
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            PhoneNumberAreaApplication phoneNumberAreaApplication = PhoneNumberAreaApplication.this;
            boolean d10 = phoneNumberAreaApplication.d(phoneNumberAreaApplication);
            if (PhoneNumberAreaApplication.f28829a) {
                Log.d("PhoneNoApplication", "update_success = " + d10);
            }
            if (!d10) {
                k kVar = new k(phoneNumberAreaApplication);
                int j10 = kVar.j();
                kVar.h(true);
                Log.d("PhoneNoApplication", "revert database result = " + j10);
                return null;
            }
            return null;
        }

        public void b() {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }

        public a() {
        }
    }

    public static InputStream b(String str, String str2) {
        try {
            if (!new File(str2).exists()) {
                com.oplus.phonenoareainquire.utils.f.a(str, str2);
            }
            return new FileInputStream(str2);
        } catch (Exception e10) {
            Log.e("PhoneNoApplication", "Exception when open file " + str2 + " " + e10);
            return null;
        }
    }

    public static PhoneNumberAreaApplication c() {
        return f28830b;
    }

    public static void f(PhoneNumberAreaApplication phoneNumberAreaApplication) {
        f28830b = phoneNumberAreaApplication;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        f(this);
    }

    public final boolean d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("update_state", true);
    }

    public final void e() {
        try {
            LogUtil.d(getApplicationContext());
            LogUtil.f(getApplicationContext());
        } catch (Exception e10) {
            Log.e("PhoneNoApplication", "initDebugParam error" + e10);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        e();
        new a().b();
    }
}
