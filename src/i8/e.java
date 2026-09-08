package i8;

import android.view.Choreographer;

/* compiled from: ChoreographerCompat.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    public a f32217d;

    /* renamed from: b, reason: collision with root package name */
    public Choreographer.FrameCallback f32215b = new Choreographer.FrameCallback() { // from class: i8.d
        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j10) {
            e.this.b(j10);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public boolean f32216c = false;

    /* renamed from: a, reason: collision with root package name */
    public Choreographer f32214a = Choreographer.getInstance();

    /* compiled from: ChoreographerCompat.java */
    /* loaded from: classes3.dex */
    public interface a {
        void doFrame(long j10);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(long j10) {
        this.f32216c = false;
        if (this.f32217d != null) {
            if (f8.b.a()) {
                f8.b.d("PhysicsWorld-Frame", "doFrame ----------------------- frameTime =:" + j10);
            }
            this.f32217d.doFrame(j10);
        }
    }

    public void d() {
        if (!this.f32216c && this.f32217d != null) {
            this.f32214a.postFrameCallback(this.f32215b);
            if (f8.b.a()) {
                f8.b.d("PhysicsWorld-Frame", "scheduleNextFrame ----------------------- ");
            }
            this.f32216c = true;
        }
    }

    public void e(a aVar) {
        this.f32217d = aVar;
    }

    public void f() {
        if (this.f32216c) {
            if (f8.b.a()) {
                f8.b.d("PhysicsWorld-Frame", "unScheduleNextFrame ----------------------- ");
            }
            this.f32214a.removeFrameCallback(this.f32215b);
            this.f32216c = false;
        }
    }
}
