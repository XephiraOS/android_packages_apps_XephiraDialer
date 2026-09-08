package com.oplus.phonenoareainquire.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.provider.Settings;
import android.util.Log;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.phonenoareainquire.DebugStatusChangeReceiver;
import com.oplus.phonenoareainquire.PhoneNumberAreaApplication;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.S;
import m9.q;

/* compiled from: LogUtil.kt */
/* loaded from: classes3.dex */
public final class LogUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final LogUtil f28874a = new LogUtil();

    /* compiled from: LogUtil.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f28875a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(null);
            this.f28875a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            LogUtil.d(this.f28875a);
        }
    }

    public static final void a(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        if (PhoneNumberAreaApplication.f28829a) {
            Log.d(tag, msg);
        }
    }

    public static final void b(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        Log.e(tag, msg);
    }

    public static final void c(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        Log.i(tag, msg);
    }

    public static final void d(Context context) {
        i.f(context, "context");
        C1244g.d(C1241e0.f34422a, S.b(), null, new LogUtil$refreshLogSwitch$1(context, null), 2, null);
    }

    public static final void e(Context context) {
        Object b10;
        i.f(context, "context");
        DebugStatusChangeReceiver debugStatusChangeReceiver = new DebugStatusChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("phonenumberattribution.log.switch.broadcast");
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(context.registerReceiver(debugStatusChangeReceiver, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b("LogUtil", "registerDebugStatusChangeReceiver th = " + d10);
        }
    }

    public static final void f(Context context) {
        i.f(context, "context");
        C1244g.d(C1241e0.f34422a, S.b(), null, new LogUtil$registerLogObserver$1(context, null), 2, null);
    }

    public static final void g(Context context) {
        Object b10;
        i.f(context, "context");
        a aVar = new a(context);
        try {
            Result.a aVar2 = Result.f34166a;
            context.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), true, aVar);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar3 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b("LogUtil", "registerLogSwitchObserver th = " + d10);
        }
    }

    public static final void h(String tag, String msg) {
        i.f(tag, "tag");
        i.f(msg, "msg");
        if (PhoneNumberAreaApplication.f28829a) {
            Log.w(tag, msg);
        }
    }
}
