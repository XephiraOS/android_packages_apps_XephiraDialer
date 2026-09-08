package A2;

import com.android.incallui.CallTimer;
import com.android.incallui.Log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OplusCallTimerManager.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    public static c f111e = new c();

    /* renamed from: a, reason: collision with root package name */
    public CallTimer f112a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f113b = false;

    /* renamed from: c, reason: collision with root package name */
    public List<b> f114c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    public Runnable f115d = new a();

    /* compiled from: OplusCallTimerManager.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Log.sDebug) {
                Log.d("OplusCallTimerManager", "do CallBack mTimerCallBacks = " + c.this.f114c);
            }
            for (b bVar : c.this.f114c) {
                if (bVar != null) {
                    bVar.updateCallTime();
                }
            }
        }
    }

    /* compiled from: OplusCallTimerManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void updateCallTime();
    }

    public static c d() {
        return f111e;
    }

    public void b(b bVar) {
        if (Log.sDebug) {
            Log.d("OplusCallTimerManager", "addTimerCallBack = " + bVar);
        }
        List<b> list = this.f114c;
        if (list != null) {
            list.add(bVar);
        }
        if (Log.sDebug) {
            Log.d("OplusCallTimerManager", "addTimerCallBack done = " + this.f114c);
        }
    }

    public void c() {
        if (Log.sDebug) {
            Log.d("OplusCallTimerManager", "cancelCallTimer...");
        }
        CallTimer callTimer = this.f112a;
        if (callTimer != null && this.f113b) {
            callTimer.cancel();
            g(false);
        }
    }

    public void e() {
        if (this.f112a != null) {
            return;
        }
        this.f112a = new CallTimer(this.f115d);
    }

    public void f(b bVar) {
        if (Log.sDebug) {
            Log.d("OplusCallTimerManager", "removeTimerCallBack = " + bVar);
        }
        List<b> list = this.f114c;
        if (list != null) {
            list.remove(bVar);
        }
    }

    public void g(boolean z10) {
        this.f113b = z10;
    }

    public void h() {
        if (Log.sDebug) {
            Log.d("OplusCallTimerManager", "startCallTimer...");
        }
        this.f115d.run();
        CallTimer callTimer = this.f112a;
        if (callTimer != null && !this.f113b) {
            callTimer.start(1000L);
            g(true);
        }
    }

    public void i() {
        if (Log.sDebug) {
            Log.d("OplusCallTimerManager", "startCallTimerForAudioRecord...");
        }
        this.f115d.run();
        CallTimer callTimer = this.f112a;
        if (callTimer != null) {
            callTimer.start(1000L);
            g(true);
        }
    }
}
