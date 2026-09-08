package C8;

import android.os.Handler;
import kotlin.jvm.internal.i;

/* compiled from: CanFakedField.kt */
/* loaded from: classes3.dex */
public class b<SCOPE> extends c<SCOPE> {

    /* renamed from: d, reason: collision with root package name */
    public final long f409d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f410e;

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f411f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SCOPE scope, long j10, Handler processHandler) {
        super(scope);
        i.f(processHandler, "processHandler");
        this.f409d = j10;
        this.f410e = processHandler;
        this.f411f = new Runnable() { // from class: C8.a
            @Override // java.lang.Runnable
            public final void run() {
                b.g(b.this);
            }
        };
    }

    public static final void g(b this$0) {
        i.f(this$0, "this$0");
        this$0.a();
    }

    @Override // C8.c
    public synchronized void d(SCOPE scope) {
        super.d(scope);
        this.f410e.removeCallbacks(this.f411f);
        this.f410e.postDelayed(this.f411f, this.f409d);
    }

    @Override // C8.c
    public synchronized void e(SCOPE scope) {
        this.f410e.removeCallbacks(this.f411f);
        super.e(scope);
    }
}
