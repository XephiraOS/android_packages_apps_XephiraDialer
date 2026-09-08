package E9;

import kotlinx.coroutines.G;

/* compiled from: Tasks.kt */
/* loaded from: classes4.dex */
public final class j extends g {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f755c;

    public j(Runnable runnable, long j10, h hVar) {
        super(j10, hVar);
        this.f755c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f755c.run();
        } finally {
            this.f753b.a();
        }
    }

    public String toString() {
        return "Task[" + G.a(this.f755c) + '@' + G.b(this.f755c) + ", " + this.f752a + ", " + this.f753b + ']';
    }
}
