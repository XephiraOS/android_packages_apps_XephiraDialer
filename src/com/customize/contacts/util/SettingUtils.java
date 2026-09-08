package com.customize.contacts.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;
import v9.InterfaceC1637a;

/* compiled from: SettingUtils.kt */
/* loaded from: classes3.dex */
public final class SettingUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final SettingUtils f21935a = new SettingUtils();

    /* renamed from: b, reason: collision with root package name */
    public static final m9.d f21936b;

    /* renamed from: c, reason: collision with root package name */
    public static final m9.d f21937c;

    /* renamed from: d, reason: collision with root package name */
    public static final m9.d f21938d;

    static {
        m9.d b10;
        m9.d b11;
        m9.d b12;
        b10 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.util.SettingUtils$phoneSupportSpeedDial$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean j10;
                j10 = SettingUtils.f21935a.j(P7.a.f2961a.a());
                return Boolean.valueOf(j10);
            }
        });
        f21936b = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.util.SettingUtils$customVibrationColumnAdded$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean h10;
                h10 = SettingUtils.f21935a.h(P7.a.f2961a.a());
                return Boolean.valueOf(h10);
            }
        });
        f21937c = b11;
        b12 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.util.SettingUtils$customVibrationSettingAppReady$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean m10;
                m10 = SettingUtils.f21935a.m(P7.a.f2961a.a());
                return Boolean.valueOf(m10);
            }
        });
        f21938d = b12;
    }

    public static final boolean g() {
        return f21935a.d();
    }

    public static final boolean i() {
        return f21935a.e();
    }

    public static final boolean l() {
        return f21935a.f();
    }

    public final boolean d() {
        return ((Boolean) f21937c.getValue()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f21938d.getValue()).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) f21936b.getValue()).booleanValue();
    }

    public final boolean h(Context context) {
        return M7.a.h(context, "com.android.providers.contacts", "custom_vibration", "true");
    }

    public final boolean j(Context context) {
        return M7.a.h(context, "com.android.phone", "speed_dial_support", "true");
    }

    public final boolean k(Context context) {
        return false;
    }

    public final boolean m(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("oplus.intent.action.settings.VIBRATE_PICKER"), 65536);
        kotlin.jvm.internal.i.e(queryIntentActivities, "packageManager.queryInte…CH_DEFAULT_ONLY\n        )");
        if (queryIntentActivities.size() > 0) {
            return true;
        }
        return false;
    }
}
