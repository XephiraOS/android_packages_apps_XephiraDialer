package com.android.oplus.module;

import com.android.incallui.Log;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.f;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: ModuleCenter.kt */
/* loaded from: classes.dex */
public final class ModuleCenter {

    /* renamed from: b, reason: collision with root package name */
    public static final a f19192b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final d<ModuleCenter> f19193c;

    /* renamed from: a, reason: collision with root package name */
    public final N2.a<O2.b> f19194a = new b();

    /* compiled from: ModuleCenter.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final ModuleCenter a() {
            return (ModuleCenter) ModuleCenter.f19193c.getValue();
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: ModuleCenter.kt */
    /* loaded from: classes.dex */
    public static final class b extends N2.a<O2.b> {
        @Override // N2.a
        public String d() {
            return "com.oplus.callcastscreen.CallCastScreen";
        }
    }

    static {
        d<ModuleCenter> a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<ModuleCenter>() { // from class: com.android.oplus.module.ModuleCenter$Companion$sInstance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ModuleCenter invoke() {
                return new ModuleCenter();
            }
        });
        f19193c = a10;
    }

    public O2.b b() {
        Log.d("BrandCenter", "getCallCastScreen: =" + this.f19194a.b());
        return this.f19194a.b();
    }
}
