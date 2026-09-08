package Z2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5900a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f5901b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler.java */
    /* loaded from: classes.dex */
    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((j) message.obj).b();
                return true;
            }
            return false;
        }
    }

    public synchronized void a(j<?> jVar, boolean z10) {
        try {
            if (!this.f5900a && !z10) {
                this.f5900a = true;
                jVar.b();
                this.f5900a = false;
            }
            this.f5901b.obtainMessage(1, jVar).sendToTarget();
        } catch (Throwable th) {
            throw th;
        }
    }
}
