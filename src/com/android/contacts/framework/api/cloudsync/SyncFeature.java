package com.android.contacts.framework.api.cloudsync;

import G0.c;
import H7.b;
import android.content.Context;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: SyncFeature.kt */
/* loaded from: classes.dex */
public final class SyncFeature {

    /* renamed from: a, reason: collision with root package name */
    public static final SyncFeature f15571a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f15572b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f15573c;

    static {
        d b10;
        SyncFeature syncFeature = new SyncFeature();
        f15571a = syncFeature;
        b10 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.api.cloudsync.SyncFeature$dynamicRecommendationSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(CommonOSPublicFeature.f() && OsUtils.h());
            }
        });
        f15572b = b10;
        f15573c = syncFeature.a();
    }

    public static final boolean b(Context context) {
        i.f(context, "context");
        if (!f15571a.c()) {
            return false;
        }
        return context.getSharedPreferences("cloudkit_sync", 0).getBoolean("cloud_service_recommendation", true);
    }

    public static final boolean d() {
        return f15573c;
    }

    public static final void f(Context context, boolean z10) {
        i.f(context, "context");
        if (f15571a.c()) {
            context.getSharedPreferences("cloudkit_sync", 0).edit().putBoolean("cloud_service_recommendation", z10).apply();
            return;
        }
        b.i("SyncFeature", "setDynamicRecommendationState: " + z10 + ", not support!");
    }

    public final boolean a() {
        try {
            if (c.d(P7.a.f2961a.a(), 1, "contacts_sync_state", -2) != 1) {
                return false;
            }
            return true;
        } catch (SecurityException e10) {
            b.c("SyncFeature", "isCloudSyncSwitchOn: " + e10);
            return false;
        }
    }

    public final boolean c() {
        return ((Boolean) f15572b.getValue()).booleanValue();
    }

    public final boolean e() {
        return c();
    }
}
