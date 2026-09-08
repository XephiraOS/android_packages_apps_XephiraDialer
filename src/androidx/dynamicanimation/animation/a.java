package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import p.i;

/* compiled from: AnimationHandler.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<a> f9670g = new ThreadLocal<>();

    /* renamed from: d, reason: collision with root package name */
    public c f9674d;

    /* renamed from: a, reason: collision with root package name */
    public final i<b, Long> f9671a = new i<>();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f9672b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final C0116a f9673c = new C0116a();

    /* renamed from: e, reason: collision with root package name */
    public long f9675e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9676f = false;

    /* compiled from: AnimationHandler.java */
    /* renamed from: androidx.dynamicanimation.animation.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0116a {
        public C0116a() {
        }

        public void a() {
            a.this.f9675e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f9675e);
            if (a.this.f9672b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    /* compiled from: AnimationHandler.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean doAnimationFrame(long j10);
    }

    /* compiled from: AnimationHandler.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final C0116a f9678a;

        public c(C0116a c0116a) {
            this.f9678a = c0116a;
        }

        public abstract void a();
    }

    /* compiled from: AnimationHandler.java */
    /* loaded from: classes.dex */
    public static class d extends c {

        /* renamed from: b, reason: collision with root package name */
        public final Choreographer f9679b;

        /* renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f9680c;

        /* compiled from: AnimationHandler.java */
        /* renamed from: androidx.dynamicanimation.animation.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class ChoreographerFrameCallbackC0117a implements Choreographer.FrameCallback {
            public ChoreographerFrameCallbackC0117a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                d.this.f9678a.a();
            }
        }

        public d(C0116a c0116a) {
            super(c0116a);
            this.f9679b = Choreographer.getInstance();
            this.f9680c = new ChoreographerFrameCallbackC0117a();
        }

        @Override // androidx.dynamicanimation.animation.a.c
        public void a() {
            this.f9679b.postFrameCallback(this.f9680c);
        }
    }

    public static a d() {
        ThreadLocal<a> threadLocal = f9670g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }

    public void a(b bVar, long j10) {
        if (this.f9672b.size() == 0) {
            e().a();
        }
        if (!this.f9672b.contains(bVar)) {
            this.f9672b.add(bVar);
        }
        if (j10 > 0) {
            this.f9671a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    public final void b() {
        if (this.f9676f) {
            for (int size = this.f9672b.size() - 1; size >= 0; size--) {
                if (this.f9672b.get(size) == null) {
                    this.f9672b.remove(size);
                }
            }
            this.f9676f = false;
        }
    }

    public void c(long j10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f9672b.size(); i10++) {
            b bVar = this.f9672b.get(i10);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.doAnimationFrame(j10);
            }
        }
        b();
    }

    public c e() {
        if (this.f9674d == null) {
            this.f9674d = new d(this.f9673c);
        }
        return this.f9674d;
    }

    public final boolean f(b bVar, long j10) {
        Long l10 = this.f9671a.get(bVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() < j10) {
            this.f9671a.remove(bVar);
            return true;
        }
        return false;
    }

    public void g(b bVar) {
        this.f9671a.remove(bVar);
        int indexOf = this.f9672b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f9672b.set(indexOf, null);
            this.f9676f = true;
        }
    }
}
