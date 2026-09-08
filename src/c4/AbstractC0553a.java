package c4;

import android.os.SystemClock;
import android.view.Choreographer;

/* compiled from: AndroidSpringLooperFactory.java */
/* renamed from: c4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0553a {

    /* compiled from: AndroidSpringLooperFactory.java */
    /* renamed from: c4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0152a extends k {

        /* renamed from: b, reason: collision with root package name */
        public final Choreographer f12744b;

        /* renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f12745c = new ChoreographerFrameCallbackC0153a();

        /* renamed from: d, reason: collision with root package name */
        public boolean f12746d;

        /* renamed from: e, reason: collision with root package name */
        public long f12747e;

        /* compiled from: AndroidSpringLooperFactory.java */
        /* renamed from: c4.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class ChoreographerFrameCallbackC0153a implements Choreographer.FrameCallback {
            public ChoreographerFrameCallbackC0153a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                if (C0152a.this.f12746d && C0152a.this.f12780a != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    C0152a.this.f12780a.f(uptimeMillis - r0.f12747e);
                    C0152a.this.f12747e = uptimeMillis;
                    C0152a.this.f12744b.postFrameCallback(C0152a.this.f12745c);
                }
            }
        }

        public C0152a(Choreographer choreographer) {
            this.f12744b = choreographer;
        }

        public static C0152a i() {
            return new C0152a(Choreographer.getInstance());
        }

        @Override // c4.k
        public void b() {
            if (this.f12746d) {
                return;
            }
            this.f12746d = true;
            this.f12747e = SystemClock.uptimeMillis();
            this.f12744b.removeFrameCallback(this.f12745c);
            this.f12744b.postFrameCallback(this.f12745c);
        }

        @Override // c4.k
        public void c() {
            this.f12746d = false;
            this.f12744b.removeFrameCallback(this.f12745c);
        }
    }

    public static k a() {
        return C0152a.i();
    }
}
