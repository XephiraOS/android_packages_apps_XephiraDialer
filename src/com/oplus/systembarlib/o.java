package com.oplus.systembarlib;

import android.view.View;
import android.view.Window;
import androidx.core.view.V;
import androidx.core.view.Y;

/* compiled from: SystemBarController.kt */
/* loaded from: classes3.dex */
public final class o implements h {

    /* renamed from: d, reason: collision with root package name */
    public static final a f29017d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Window f29018a;

    /* renamed from: b, reason: collision with root package name */
    public final d f29019b;

    /* renamed from: c, reason: collision with root package name */
    public String f29020c;

    /* compiled from: SystemBarController.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SystemBarController.kt */
    /* loaded from: classes3.dex */
    public class b extends d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f29021b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(o this$0) {
            super(this$0);
            kotlin.jvm.internal.i.f(this$0, "this$0");
            this.f29021b = this$0;
        }

        @Override // com.oplus.systembarlib.o.d
        public void a(int i10) {
            boolean z10;
            p.k(this, this.f29021b.f29018a, "setStatusBarColor");
            Window window = this.f29021b.f29018a;
            if (window == null) {
                return;
            }
            window.setStatusBarColor(i10);
            if (i10 != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            window.setStatusBarContrastEnforced(z10);
        }

        @Override // com.oplus.systembarlib.o.d, com.oplus.systembarlib.f
        public void h0(int i10) {
            boolean z10;
            p.k(this, this.f29021b.f29018a, "setNaviBarColor");
            Window window = this.f29021b.f29018a;
            if (window == null) {
                return;
            }
            window.setNavigationBarColor(i10);
            if (i10 != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            window.setNavigationBarContrastEnforced(z10);
        }
    }

    /* compiled from: SystemBarController.kt */
    /* loaded from: classes3.dex */
    public final class c extends b {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f29022c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(o this$0) {
            super(this$0);
            kotlin.jvm.internal.i.f(this$0, "this$0");
            this.f29022c = this$0;
        }
    }

    /* compiled from: SystemBarController.kt */
    /* loaded from: classes3.dex */
    public class d implements h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f29023a;

        public d(o this$0) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            this.f29023a = this$0;
        }

        @Override // com.oplus.systembarlib.h
        public boolean B() {
            p.k(this, this.f29023a.f29018a, "hasVirtualKey");
            Window window = this.f29023a.f29018a;
            if (window == null) {
                return false;
            }
            View decorView = window.getDecorView();
            kotlin.jvm.internal.i.e(decorView, "win.decorView");
            return p.b(decorView);
        }

        public void a(int i10) {
            throw null;
        }

        public void b(int i10) {
            Y a10;
            p.k(this, this.f29023a.f29018a, "setSystemBarBehavior");
            Window window = this.f29023a.f29018a;
            if (window != null && (a10 = V.a(window, window.getDecorView())) != null) {
                a10.e(i10);
            }
        }

        @Override // com.oplus.systembarlib.h
        public void b0() {
            p.k(this, this.f29023a.f29018a, "setImmersiveSystemBar");
            Window window = this.f29023a.f29018a;
            if (window == null) {
                return;
            }
            V.b(window, false);
            a(0);
            b(1);
        }

        public void h0(int i10) {
            throw null;
        }

        @Override // com.oplus.systembarlib.g
        public void v(boolean z10) {
            Y a10;
            p.k(this, this.f29023a.f29018a, "setStatusBarAppearance");
            Window window = this.f29023a.f29018a;
            if (window != null && (a10 = V.a(window, window.getDecorView())) != null) {
                o oVar = this.f29023a;
                if (a10.b() != z10) {
                    SystemBarLog.b(oVar.f29020c, kotlin.jvm.internal.i.l("setStatusBarAppearance: isLight=", Boolean.valueOf(z10)));
                    a10.d(z10);
                }
            }
        }
    }

    public o(Window window) {
        this.f29018a = window;
        this.f29020c = "SystemBarController";
        this.f29019b = new c(this);
    }

    @Override // com.oplus.systembarlib.h
    public boolean B() {
        return this.f29019b.B();
    }

    @Override // com.oplus.systembarlib.h
    public void b0() {
        this.f29019b.b0();
    }

    public void c(Window window) {
        this.f29018a = window;
    }

    public void d(String tag) {
        kotlin.jvm.internal.i.f(tag, "tag");
        this.f29020c = kotlin.jvm.internal.i.l("SystemBarController.", tag);
    }

    @Override // com.oplus.systembarlib.f
    public void h0(int i10) {
        this.f29019b.h0(i10);
    }

    @Override // com.oplus.systembarlib.g
    public void v(boolean z10) {
        this.f29019b.v(z10);
    }

    public /* synthetic */ o(Window window, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? null : window);
    }
}
