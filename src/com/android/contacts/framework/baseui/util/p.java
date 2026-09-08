package com.android.contacts.framework.baseui.util;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import kotlin.Result;

/* compiled from: PlaceCallUtils.kt */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f15954a = new p();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f15955b;

    public static final void a(Context context, Intent intent) {
        b(context, intent, null);
    }

    public static final void b(Context context, Intent intent, t tVar) {
        Object b10;
        if (CommonFeatureOption.j()) {
            H7.b.f("HM_APP_GAP", "contacts.place_call begin");
            if (intent != null) {
                intent.putExtra("start_dialing", System.currentTimeMillis());
            }
            if (OsUtils.f28275a.j()) {
                if (intent == null) {
                    H7.b.i("PlaceCallUtils", "addNewOutgoingCall intent is null");
                    return;
                }
                if (f15955b) {
                    f(context, intent);
                } else {
                    e(intent);
                }
                if (tVar != null) {
                    tVar.a(0, context, intent.getData());
                    return;
                }
                return;
            }
            try {
                Result.a aVar = Result.f34166a;
                if (C7.b.b()) {
                    U8.a.a(intent);
                } else {
                    P6.c.a(intent);
                }
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            if (Result.d(b10) != null) {
                H7.b.c("PlaceCallUtils", "TelecomManagerNative addNewOutgoingCall error");
                return;
            }
            return;
        }
        H7.b.i("PlaceCallUtils", "addNewOutgoingCall is not DialerSupport");
    }

    public static final TelecomManager c() {
        Object b10;
        Context a10;
        try {
            Result.a aVar = Result.f34166a;
            a10 = P7.a.f2961a.a();
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (a10 == null) {
            H7.b.i("PlaceCallUtils", "getTelecomManager: context is null");
            b10 = Result.b(m9.q.f35511a);
            if (Result.d(b10) != null) {
                H7.b.c("PlaceCallUtils", "getTelecomManager getSystemService error");
            }
            return null;
        }
        Object systemService = a10.getSystemService("telecom");
        if (!(systemService instanceof TelecomManager)) {
            return null;
        }
        return (TelecomManager) systemService;
    }

    public static final void d(TelecomManager telecomManager, Bundle bundle) {
        Object b10;
        kotlin.jvm.internal.i.f(telecomManager, "telecomManager");
        kotlin.jvm.internal.i.f(bundle, "bundle");
        try {
            Result.a aVar = Result.f34166a;
            P6.c.c(telecomManager, bundle);
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("PlaceCallUtils", "oplusCancelMissedCallsNotification error :" + d10);
        }
    }

    public static final void e(Intent intent) {
        kotlin.jvm.internal.i.f(intent, "intent");
        TelecomManager c10 = c();
        if (c10 != null) {
            c10.placeCall(intent.getData(), intent.getExtras());
        } else {
            H7.b.c("PlaceCallUtils", "placeCall telecomManager is null");
        }
    }

    public static final void f(Context context, Intent intent) {
        Object obj;
        TelephonyManager telephonyManager;
        boolean z10;
        String schemeSpecificPart;
        Boolean bool;
        kotlin.jvm.internal.i.f(intent, "intent");
        Bundle bundle = null;
        if (context != null) {
            obj = context.getSystemService("phone");
        } else {
            obj = null;
        }
        if (obj instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) obj;
        } else {
            telephonyManager = null;
        }
        Uri data = intent.getData();
        if (data != null && (schemeSpecificPart = data.getSchemeSpecificPart()) != null) {
            if (telephonyManager != null) {
                bool = Boolean.valueOf(telephonyManager.isEmergencyNumber(schemeSpecificPart));
            } else {
                bool = null;
            }
            if (bool != null) {
                z10 = bool.booleanValue();
                if (context == null && !z10) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uri = R0.b.f3177k;
                    ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (acquireUnstableContentProviderClient != null) {
                        String authority = uri.getAuthority();
                        kotlin.jvm.internal.i.c(authority);
                        bundle = acquireUnstableContentProviderClient.call(authority, "method_is_login", null, null);
                    }
                    if (bundle != null && bundle.getInt("is_Login", 0) == 1) {
                        intent.setAction("com.oplus.chaken.call.action");
                        intent.setFlags(67108864);
                        context.startActivity(intent);
                        return;
                    }
                    e(intent);
                    return;
                }
                e(intent);
            }
        }
        z10 = false;
        if (context == null) {
        }
        e(intent);
    }
}
