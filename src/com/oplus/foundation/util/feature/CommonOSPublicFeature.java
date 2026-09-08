package com.oplus.foundation.util.feature;

import android.content.Context;
import kotlin.LazyThreadSafetyMode;
import kotlin.a;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: CommonOSPublicFeature.kt */
/* loaded from: classes3.dex */
public final class CommonOSPublicFeature {

    /* renamed from: a, reason: collision with root package name */
    public static final CommonOSPublicFeature f28307a = new CommonOSPublicFeature();

    /* renamed from: b, reason: collision with root package name */
    public static Context f28308b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f28309c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f28310d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f28311e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f28312f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f28313g;

    static {
        d a10;
        d a11;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f34162b;
        a10 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.CommonOSPublicFeature$roamSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = CommonOSPublicFeature.f28308b;
                return Boolean.valueOf(M7.a.h(context, "com.android.providers.contacts", "roam_support", "true"));
            }
        });
        f28312f = a10;
        a11 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.CommonOSPublicFeature$cacheIdentifySupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = CommonOSPublicFeature.f28308b;
                return Boolean.valueOf(M7.a.h(context, "com.android.providers.contacts", "support_cache_calllog", "true"));
            }
        });
        f28313g = a11;
    }

    public static final boolean e() {
        return f28307a.b();
    }

    public static final boolean f() {
        return f28311e;
    }

    public static final boolean h() {
        if (f28311e && f28307a.c()) {
            return true;
        }
        return false;
    }

    public static final boolean i() {
        return f();
    }

    public final boolean b() {
        return ((Boolean) f28313g.getValue()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f28312f.getValue()).booleanValue();
    }

    public final void d(Context context, boolean z10, boolean z11, boolean z12) {
        f28308b = context;
        f28309c = z10;
        f28310d = z11;
        f28311e = z12;
    }

    public final boolean g() {
        return true;
    }
}
