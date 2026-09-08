package M8;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import kotlin.jvm.internal.i;

/* compiled from: VideoShowControllerImpl.kt */
/* loaded from: classes.dex */
public final class g implements M8.a, O8.d, O8.c {

    /* renamed from: k, reason: collision with root package name */
    public static final a f1816k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final O8.b f1817a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1818b;

    /* renamed from: c, reason: collision with root package name */
    public P8.b<Object> f1819c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1820d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1821e;

    /* renamed from: f, reason: collision with root package name */
    public ViewGroup f1822f;

    /* renamed from: g, reason: collision with root package name */
    public Q8.a f1823g;

    /* renamed from: h, reason: collision with root package name */
    public Rect f1824h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f1825i;

    /* renamed from: j, reason: collision with root package name */
    public final N8.d f1826j;

    /* compiled from: VideoShowControllerImpl.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public g(Context context, O8.b mVideoShowCallback) {
        i.f(context, "context");
        i.f(mVideoShowCallback, "mVideoShowCallback");
        this.f1817a = mVideoShowCallback;
        this.f1820d = true;
        this.f1824h = new Rect(0, 0, 0, 0);
        this.f1825i = new Handler(Looper.getMainLooper());
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowControllerImpl", "VideoShowControllerImpl constructor");
        }
        this.f1826j = N8.e.f2391a.a(context, this);
    }

    public static final void o(int i10, g this$0) {
        i.f(this$0, "this$0");
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowControllerImpl", "callTelecomStartRing real ringingType = " + i10);
        }
        this$0.a().a(i10);
    }

    public static final void r(g this$0) {
        N8.d g10;
        O8.a a10;
        i.f(this$0, "this$0");
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowControllerImpl", "delayToCheckStartPlay mCanPlay = " + this$0.f1818b);
        }
        if (this$0.f1818b && (g10 = this$0.g()) != null && (a10 = g10.a()) != null && !a10.a()) {
            if (aVar.f()) {
                aVar.h("VideoShowControllerImpl", "delayToCheckStartPlay need to playing");
            }
            this$0.h();
        }
    }

    public static final void t(g this$0) {
        i.f(this$0, "this$0");
        this$0.b();
    }

    public static final void w(ViewGroup it, g this$0) {
        i.f(it, "$it");
        i.f(this$0, "this$0");
        it.removeView(this$0.f1823g);
        this$0.f1823g = null;
        this$0.f1822f = null;
    }

    @Override // O8.d
    public O8.b a() {
        return this.f1817a;
    }

    @Override // M8.a
    public void b() {
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowControllerImpl", "cleanup  when state is not incoming ...");
        }
        v(true);
        x(false);
        this.f1820d = false;
        N8.d g10 = g();
        if (g10 != null) {
            g10.b();
        }
        Q8.a aVar2 = this.f1823g;
        if (aVar2 != null) {
            aVar2.a();
        }
        a().c();
    }

    @Override // M8.a
    public void c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            R8.a aVar = R8.a.f3357a;
            if (aVar.f()) {
                aVar.b("VideoShowControllerImpl", "setParentViewGroup null");
            }
            v(false);
            this.f1822f = viewGroup;
            return;
        }
        if (i.b(viewGroup, this.f1822f)) {
            R8.a aVar2 = R8.a.f3357a;
            if (aVar2.f()) {
                aVar2.b("VideoShowControllerImpl", "setParentViewGroup same parentViewGroup return");
                return;
            }
            return;
        }
        if (this.f1822f != null) {
            R8.a aVar3 = R8.a.f3357a;
            if (aVar3.f()) {
                aVar3.b("VideoShowControllerImpl", "setParentViewGroup new parentViewGroup should remove the elder one = " + this.f1822f);
            }
            v(false);
        }
        R8.a aVar4 = R8.a.f3357a;
        if (aVar4.f()) {
            aVar4.b("VideoShowControllerImpl", "setParentViewGroup group=" + viewGroup);
        }
        this.f1822f = viewGroup;
        m();
        p();
    }

    @Override // M8.a
    public void d(boolean z10) {
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowControllerImpl", "setCanOutOfSurface: " + z10);
        }
        this.f1821e = z10;
    }

    @Override // O8.c
    public void e(int i10) {
        int i11;
        int i12;
        O8.a a10;
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowControllerImpl", "PlayStateChanged state = " + R8.b.f3364a.a(i10));
        }
        if (i10 != 2) {
            if (i10 == 8) {
                a().d(1);
                this.f1825i.post(new Runnable() { // from class: M8.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.t(g.this);
                    }
                });
                return;
            }
            return;
        }
        N8.d g10 = g();
        if (g10 != null && (a10 = g10.a()) != null) {
            i12 = a10.c();
            i11 = a10.f();
        } else {
            i11 = 0;
            i12 = 0;
        }
        Rect rect = new Rect(0, 0, i12, i11);
        this.f1824h = rect;
        Q8.a aVar2 = this.f1823g;
        if (aVar2 != null) {
            aVar2.setVideoSourceRect(rect);
        }
        if (this.f1821e) {
            h();
        }
    }

    @Override // M8.a
    public void f(P8.b<Object> bVar) {
        if (i.b(this.f1819c, bVar)) {
            Log.d("VideoShowControllerImpl", "setVideoSource same source return");
            return;
        }
        this.f1819c = bVar;
        Log.d("VideoShowControllerImpl", "observe videoSource change:" + this.f1819c);
        if (!P8.c.a(this.f1819c)) {
            x(false);
            a().d(0);
            b();
        } else {
            u(this.f1819c);
            x(true);
            p();
        }
    }

    @Override // O8.d
    public N8.d g() {
        return this.f1826j;
    }

    @Override // O8.d
    public void h() {
        O8.a a10;
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowControllerImpl", "startPlayer mVideoOnly = " + this.f1820d);
        }
        N8.d g10 = g();
        if (g10 != null && (a10 = g10.a()) != null) {
            a10.e(this.f1820d);
        }
    }

    public final void m() {
        if (s()) {
            R8.a.f3357a.d("VideoShowControllerImpl", "addVideoShowSurfaceView  already added return ");
            return;
        }
        ViewGroup viewGroup = this.f1822f;
        if (viewGroup != null) {
            if (this.f1823g == null) {
                Context context = viewGroup.getContext();
                i.e(context, "it.context");
                this.f1823g = new Q8.a(context, this, this.f1824h);
            }
            viewGroup.setVisibility(0);
            viewGroup.addView(this.f1823g, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void n() {
        final int i10;
        if (!this.f1820d) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowControllerImpl", "callTelecomStartRing...ringingType = " + i10);
        }
        this.f1825i.post(new Runnable() { // from class: M8.d
            @Override // java.lang.Runnable
            public final void run() {
                g.o(i10, this);
            }
        });
    }

    public final void p() {
        if (!this.f1818b) {
            R8.a aVar = R8.a.f3357a;
            if (aVar.f()) {
                aVar.b("VideoShowControllerImpl", "checkAndStartVideoShow cannot play return");
                return;
            }
            return;
        }
        if (this.f1821e) {
            R8.a aVar2 = R8.a.f3357a;
            if (aVar2.f()) {
                aVar2.b("VideoShowControllerImpl", "checkAndStartVideoShow start player out of surface");
            }
            h();
            n();
            return;
        }
        if (s()) {
            R8.a aVar3 = R8.a.f3357a;
            if (aVar3.f()) {
                aVar3.b("VideoShowControllerImpl", "checkAndStartVideoShow surface not ready");
            }
            n();
            return;
        }
        R8.a aVar4 = R8.a.f3357a;
        if (aVar4.f()) {
            aVar4.b("VideoShowControllerImpl", "checkAndStartVideoShow do nothing");
        }
    }

    public final void q() {
        this.f1825i.postDelayed(new Runnable() { // from class: M8.f
            @Override // java.lang.Runnable
            public final void run() {
                g.r(g.this);
            }
        }, 500L);
    }

    public final boolean s() {
        ViewGroup viewGroup;
        Q8.a aVar = this.f1823g;
        if (aVar == null || (viewGroup = this.f1822f) == null || viewGroup.indexOfChild(aVar) == -1) {
            return false;
        }
        return true;
    }

    public final void u(P8.b<Object> bVar) {
        O8.a a10;
        N8.d g10 = g();
        if (g10 != null && (a10 = g10.a()) != null) {
            if (P8.c.a(bVar)) {
                a10.b(bVar);
                q();
                return;
            } else {
                R8.a aVar = R8.a.f3357a;
                if (aVar.f()) {
                    aVar.h("VideoShowControllerImpl", "prepareToPlay source invalid return ");
                    return;
                }
                return;
            }
        }
        R8.a.f3357a.h("VideoShowControllerImpl", "prepareToPlay VideoShowPlayer layerControl null return ");
    }

    public void v(boolean z10) {
        final ViewGroup viewGroup = this.f1822f;
        if (viewGroup == null) {
            R8.a aVar = R8.a.f3357a;
            if (aVar.f()) {
                aVar.b("VideoShowControllerImpl", "removeSurfaceView  mVideoParentViewGroup null return ");
                return;
            }
            return;
        }
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            if (z10) {
                R8.a aVar2 = R8.a.f3357a;
                if (aVar2.f()) {
                    aVar2.b("VideoShowControllerImpl", "removeSurfaceView  cleanUp");
                }
                viewGroup.postDelayed(new Runnable() { // from class: M8.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.w(viewGroup, this);
                    }
                }, 50L);
                return;
            }
            R8.a aVar3 = R8.a.f3357a;
            if (aVar3.f()) {
                aVar3.b("VideoShowControllerImpl", "removeSurfaceView immediately mVideoShowView = " + this.f1823g);
            }
            viewGroup.removeView(this.f1823g);
        }
    }

    public final void x(boolean z10) {
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowControllerImpl", "setCanPlay lod =  " + this.f1818b + " can = " + z10);
        }
        this.f1818b = z10;
    }
}
