package t2;

import O1.A;
import O1.C;
import O1.E;
import O1.G;
import O1.y;
import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.i;
import androidx.databinding.o;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowControllerViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviLandscapeFloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviPortraitFloatingWindowViewModel;
import com.android.x.uwb.androidx.annotation.MainThread;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: FloatingWindowViewController.kt */
/* renamed from: t2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1588h {

    /* renamed from: l, reason: collision with root package name */
    public static final a f37162l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Executor f37163a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f37164b;

    /* renamed from: c, reason: collision with root package name */
    public final FloatingWindowControllerViewModel f37165c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f37166d;

    /* renamed from: e, reason: collision with root package name */
    public final WindowManager f37167e;

    /* renamed from: f, reason: collision with root package name */
    public View f37168f;

    /* renamed from: g, reason: collision with root package name */
    public final PathInterpolator f37169g;

    /* renamed from: h, reason: collision with root package name */
    public final long f37170h;

    /* renamed from: i, reason: collision with root package name */
    public final long f37171i;

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f37172j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f37173k;

    /* compiled from: FloatingWindowViewController.kt */
    /* renamed from: t2.h$a */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: FloatingWindowViewController.kt */
    /* renamed from: t2.h$b */
    /* loaded from: classes.dex */
    public static final class b extends com.android.incallui.anim.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1588h f37174a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, ViewPropertyAnimator viewPropertyAnimator, C1588h c1588h) {
            super(str, viewPropertyAnimator);
            this.f37174a = c1588h;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            i.f(animator, "animator");
            Log.d("FloatingWindowViewController", "onAnimationCancel");
            this.f37174a.z();
        }

        @Override // com.android.incallui.anim.e, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.f(animator, "animator");
            super.onAnimationEnd(animator);
            this.f37174a.z();
        }
    }

    /* compiled from: FloatingWindowViewController.kt */
    /* renamed from: t2.h$c */
    /* loaded from: classes.dex */
    public static final class c extends i.a {
        public c() {
        }

        @Override // androidx.databinding.i.a
        public void d(androidx.databinding.i iVar, int i10) {
            C1588h.this.q().post(C1588h.this.f37172j);
        }
    }

    /* compiled from: FloatingWindowViewController.kt */
    /* renamed from: t2.h$d */
    /* loaded from: classes.dex */
    public static final class d extends i.a {
        public d() {
        }

        @Override // androidx.databinding.i.a
        public void d(androidx.databinding.i iVar, int i10) {
            C1588h.this.q().post(C1588h.this.f37173k);
        }
    }

    public C1588h(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        C2.b a10 = C2.b.a();
        kotlin.jvm.internal.i.e(a10, "getInstance()");
        this.f37163a = a10;
        this.f37164b = new Handler(Looper.getMainLooper());
        this.f37165c = new FloatingWindowControllerViewModel(a10);
        Context b10 = L1.c.b(context, 2038);
        this.f37166d = b10;
        this.f37167e = (WindowManager) b10.getSystemService(WindowManager.class);
        this.f37169g = new PathInterpolator(0.22f, 0.34f, 0.05f, 1.0f);
        this.f37170h = 200L;
        this.f37171i = 483L;
        this.f37172j = new Runnable() { // from class: t2.b
            @Override // java.lang.Runnable
            public final void run() {
                C1588h.E(C1588h.this);
            }
        };
        this.f37173k = new Runnable() { // from class: t2.c
            @Override // java.lang.Runnable
            public final void run() {
                C1588h.D(C1588h.this);
            }
        };
    }

    public static final void D(C1588h this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.C();
    }

    public static final void E(C1588h this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.B();
    }

    public static final void s(o viewStub, com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b eventBus, ViewStub viewStub2, View view) {
        y yVar;
        kotlin.jvm.internal.i.f(viewStub, "$viewStub");
        kotlin.jvm.internal.i.f(eventBus, "$eventBus");
        kotlin.jvm.internal.i.f(viewStub2, "<anonymous parameter 0>");
        kotlin.jvm.internal.i.f(view, "<anonymous parameter 1>");
        ViewDataBinding g10 = viewStub.g();
        if (g10 instanceof y) {
            yVar = (y) g10;
        } else {
            yVar = null;
        }
        if (yVar != null) {
            yVar.i1(new DefaultFloatingWindowViewModel(eventBus));
        }
    }

    public static final void u(o viewStub, com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b eventBus, ViewStub viewStub2, View view) {
        A a10;
        kotlin.jvm.internal.i.f(viewStub, "$viewStub");
        kotlin.jvm.internal.i.f(eventBus, "$eventBus");
        kotlin.jvm.internal.i.f(viewStub2, "<anonymous parameter 0>");
        kotlin.jvm.internal.i.f(view, "<anonymous parameter 1>");
        ViewDataBinding g10 = viewStub.g();
        if (g10 instanceof A) {
            a10 = (A) g10;
        } else {
            a10 = null;
        }
        if (a10 != null) {
            a10.i1(new DriveModeFloatingWindowViewModel(eventBus));
        }
    }

    public static final void w(o viewStub, com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b eventBus, ViewStub viewStub2, View view) {
        C c10;
        kotlin.jvm.internal.i.f(viewStub, "$viewStub");
        kotlin.jvm.internal.i.f(eventBus, "$eventBus");
        kotlin.jvm.internal.i.f(viewStub2, "<anonymous parameter 0>");
        kotlin.jvm.internal.i.f(view, "<anonymous parameter 1>");
        ViewDataBinding g10 = viewStub.g();
        if (g10 instanceof C) {
            c10 = (C) g10;
        } else {
            c10 = null;
        }
        if (c10 != null) {
            c10.i1(new NaviLandscapeFloatingWindowViewModel(eventBus));
        }
    }

    public static final void y(o viewStub, com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b eventBus, ViewStub viewStub2, View view) {
        E e10;
        kotlin.jvm.internal.i.f(viewStub, "$viewStub");
        kotlin.jvm.internal.i.f(eventBus, "$eventBus");
        kotlin.jvm.internal.i.f(viewStub2, "<anonymous parameter 0>");
        kotlin.jvm.internal.i.f(view, "<anonymous parameter 1>");
        ViewDataBinding g10 = viewStub.g();
        if (g10 instanceof E) {
            e10 = (E) g10;
        } else {
            e10 = null;
        }
        if (e10 != null) {
            e10.i1(new NaviPortraitFloatingWindowViewModel(eventBus));
        }
    }

    public void A() {
        this.f37165c.H();
        this.f37165c.u().f(new c());
        this.f37165c.x().f(new d());
    }

    @MainThread
    public final synchronized void B() {
        try {
            if (this.f37165c.u().s0().booleanValue() && this.f37168f == null) {
                Log.d("FloatingWindowViewController", "triggerWindowVisibility: addView");
                try {
                    View p10 = p();
                    WindowManager windowManager = this.f37167e;
                    if (windowManager != null) {
                        windowManager.addView(p10, this.f37165c.x().s0().a());
                    }
                    this.f37168f = p10;
                } catch (Exception e10) {
                    Log.i("FloatingWindowViewController", "WindowManager#addView exception: " + e10.getMessage());
                }
            } else if (!this.f37165c.u().s0().booleanValue()) {
                Log.d("FloatingWindowViewController", "triggerWindowVisibility: removeView");
                View view = this.f37168f;
                if (view != null) {
                    int t10 = this.f37165c.t();
                    if (t10 != 1) {
                        if (t10 != 2) {
                            if (t10 == 3) {
                                m(view);
                            }
                        } else {
                            z();
                        }
                    } else {
                        k(view);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @MainThread
    public final synchronized void C() {
        if (this.f37168f == null) {
            return;
        }
        Log.d("FloatingWindowViewController", "updateWindowParams: ");
        try {
            WindowManager windowManager = this.f37167e;
            if (windowManager != null) {
                windowManager.updateViewLayout(this.f37168f, this.f37165c.x().s0().a());
            }
        } catch (Exception e10) {
            Log.i("FloatingWindowViewController", "WindowManager#updateViewLayout exception: " + e10.getMessage());
        }
    }

    public final void j(View view) {
        ViewPropertyAnimator animate = view.animate();
        animate.setDuration(this.f37171i);
        animate.translationY(view.getHeight());
        kotlin.jvm.internal.i.e(animate, "this");
        animate.setListener(o("defaultBottomExit", animate));
        animate.start();
    }

    public final void k(View view) {
        int v10 = this.f37165c.v();
        if (v10 != 48) {
            if (v10 == 80) {
                j(view);
                return;
            }
            return;
        }
        l(view);
    }

    public final void l(View view) {
        ViewPropertyAnimator animate = view.animate();
        animate.setDuration(this.f37171i);
        animate.translationY(-view.getHeight());
        animate.setInterpolator(animate.getInterpolator());
        kotlin.jvm.internal.i.e(animate, "this");
        animate.setListener(o("defaultTopExit", animate));
        animate.start();
    }

    public final void m(View view) {
        ViewPropertyAnimator animate = view.animate();
        animate.setDuration(this.f37170h);
        animate.alpha(0.0f);
        animate.setInterpolator(animate.getInterpolator());
        kotlin.jvm.internal.i.e(animate, "this");
        animate.setListener(o("fadeExit", animate));
        animate.start();
    }

    public final FloatingWindowControllerViewModel n() {
        return this.f37165c;
    }

    public final com.android.incallui.anim.e o(String str, ViewPropertyAnimator viewPropertyAnimator) {
        return new b(str, viewPropertyAnimator, this);
    }

    public final View p() {
        OplusPhoneUtils.setDefaultDisplayResources(this.f37166d.getResources());
        View inflate = LayoutInflater.from(this.f37166d).inflate(R.layout.oplus_incall_floating_view, (ViewGroup) null);
        G i12 = G.i1(inflate);
        com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b bVar = new com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b(this.f37165c, this.f37163a);
        i12.l1(new FloatingWindowViewModel(bVar));
        i12.k1(new FloatingWindowCommandViewModel(bVar));
        o floatingViewDefault = i12.f2504G;
        kotlin.jvm.internal.i.e(floatingViewDefault, "floatingViewDefault");
        r(floatingViewDefault, bVar);
        o floatingViewDriveMode = i12.f2505H;
        kotlin.jvm.internal.i.e(floatingViewDriveMode, "floatingViewDriveMode");
        t(floatingViewDriveMode, bVar);
        o floatingViewNaviLandscape = i12.f2506I;
        kotlin.jvm.internal.i.e(floatingViewNaviLandscape, "floatingViewNaviLandscape");
        v(floatingViewNaviLandscape, bVar);
        o floatingViewNaviPortrait = i12.f2507J;
        kotlin.jvm.internal.i.e(floatingViewNaviPortrait, "floatingViewNaviPortrait");
        x(floatingViewNaviPortrait, bVar);
        kotlin.jvm.internal.i.e(inflate, "from(windowContext).infl…)\n            }\n        }");
        return inflate;
    }

    public final Handler q() {
        return this.f37164b;
    }

    public final void r(final o oVar, final com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b bVar) {
        oVar.l(new ViewStub.OnInflateListener() { // from class: t2.f
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                C1588h.s(o.this, bVar, viewStub, view);
            }
        });
    }

    public final void t(final o oVar, final com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b bVar) {
        oVar.l(new ViewStub.OnInflateListener() { // from class: t2.g
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                C1588h.u(o.this, bVar, viewStub, view);
            }
        });
    }

    public final void v(final o oVar, final com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b bVar) {
        oVar.l(new ViewStub.OnInflateListener() { // from class: t2.e
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                C1588h.w(o.this, bVar, viewStub, view);
            }
        });
    }

    public final void x(final o oVar, final com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.b bVar) {
        oVar.l(new ViewStub.OnInflateListener() { // from class: t2.d
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                C1588h.y(o.this, bVar, viewStub, view);
            }
        });
    }

    public final void z() {
        Object b10;
        Log.d("FloatingWindowViewController", "removeFloatingWindow");
        try {
            Result.a aVar = Result.f34166a;
            View view = this.f37168f;
            if (view != null) {
                view.setVisibility(4);
            }
            WindowManager windowManager = this.f37167e;
            if (windowManager != null) {
                windowManager.removeView(this.f37168f);
            }
            this.f37168f = null;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.i("FloatingWindowViewController", "WindowManager#removeView exception:" + d10);
        }
        this.f37165c.F();
    }
}
