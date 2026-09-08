package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.B;
import androidx.lifecycle.Lifecycle;

/* compiled from: ProcessLifecycleOwner.kt */
/* loaded from: classes.dex */
public final class A implements InterfaceC0492o {

    /* renamed from: i, reason: collision with root package name */
    public static final b f10220i = new b(null);

    /* renamed from: j, reason: collision with root package name */
    public static final A f10221j = new A();

    /* renamed from: a, reason: collision with root package name */
    public int f10222a;

    /* renamed from: b, reason: collision with root package name */
    public int f10223b;

    /* renamed from: e, reason: collision with root package name */
    public Handler f10226e;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10224c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10225d = true;

    /* renamed from: f, reason: collision with root package name */
    public final q f10227f = new q(this);

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f10228g = new Runnable() { // from class: androidx.lifecycle.z
        @Override // java.lang.Runnable
        public final void run() {
            A.h(A.this);
        }
    };

    /* renamed from: h, reason: collision with root package name */
    public final B.a f10229h = new d();

    /* compiled from: ProcessLifecycleOwner.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10230a = new a();

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            kotlin.jvm.internal.i.f(activity, "activity");
            kotlin.jvm.internal.i.f(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    /* compiled from: ProcessLifecycleOwner.kt */
    /* loaded from: classes.dex */
    public static final class b {
        public b() {
        }

        public final InterfaceC0492o a() {
            return A.f10221j;
        }

        public final void b(Context context) {
            kotlin.jvm.internal.i.f(context, "context");
            A.f10221j.g(context);
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ProcessLifecycleOwner.kt */
    /* loaded from: classes.dex */
    public static final class c extends C0483f {

        /* compiled from: ProcessLifecycleOwner.kt */
        /* loaded from: classes.dex */
        public static final class a extends C0483f {
            final /* synthetic */ A this$0;

            public a(A a10) {
                this.this$0 = a10;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                kotlin.jvm.internal.i.f(activity, "activity");
                this.this$0.d();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                kotlin.jvm.internal.i.f(activity, "activity");
                this.this$0.e();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.C0483f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.i.f(activity, "activity");
        }

        @Override // androidx.lifecycle.C0483f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            A.this.c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.i.f(activity, "activity");
            a.a(activity, new a(A.this));
        }

        @Override // androidx.lifecycle.C0483f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            A.this.f();
        }
    }

    public static final void h(A this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.i();
        this$0.j();
    }

    public final void c() {
        int i10 = this.f10223b - 1;
        this.f10223b = i10;
        if (i10 == 0) {
            Handler handler = this.f10226e;
            kotlin.jvm.internal.i.c(handler);
            handler.postDelayed(this.f10228g, 700L);
        }
    }

    public final void d() {
        int i10 = this.f10223b + 1;
        this.f10223b = i10;
        if (i10 == 1) {
            if (this.f10224c) {
                this.f10227f.i(Lifecycle.Event.ON_RESUME);
                this.f10224c = false;
            } else {
                Handler handler = this.f10226e;
                kotlin.jvm.internal.i.c(handler);
                handler.removeCallbacks(this.f10228g);
            }
        }
    }

    public final void e() {
        int i10 = this.f10222a + 1;
        this.f10222a = i10;
        if (i10 == 1 && this.f10225d) {
            this.f10227f.i(Lifecycle.Event.ON_START);
            this.f10225d = false;
        }
    }

    public final void f() {
        this.f10222a--;
        j();
    }

    public final void g(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        this.f10226e = new Handler();
        this.f10227f.i(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.i.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    @Override // androidx.lifecycle.InterfaceC0492o
    public Lifecycle getLifecycle() {
        return this.f10227f;
    }

    public final void i() {
        if (this.f10223b == 0) {
            this.f10224c = true;
            this.f10227f.i(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void j() {
        if (this.f10222a == 0 && this.f10224c) {
            this.f10227f.i(Lifecycle.Event.ON_STOP);
            this.f10225d = true;
        }
    }

    /* compiled from: ProcessLifecycleOwner.kt */
    /* loaded from: classes.dex */
    public static final class d implements B.a {
        public d() {
        }

        @Override // androidx.lifecycle.B.a
        public void b() {
            A.this.d();
        }

        @Override // androidx.lifecycle.B.a
        public void onStart() {
            A.this.e();
        }

        @Override // androidx.lifecycle.B.a
        public void a() {
        }
    }
}
