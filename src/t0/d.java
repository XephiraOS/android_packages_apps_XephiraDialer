package t0;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import w0.C1641a;

/* compiled from: SimCardManager.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static Context f37134b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile d f37135c;

    /* renamed from: d, reason: collision with root package name */
    public static ConcurrentHashMap<Integer, String> f37136d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public static volatile List<b> f37137e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f37138f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static volatile boolean f37139g = false;

    /* renamed from: a, reason: collision with root package name */
    public Handler f37140a;

    /* compiled from: SimCardManager.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                String str = (String) message.obj;
                int i10 = message.arg1;
                if (H7.a.b()) {
                    H7.b.b("SimCardManager", "MESSAGE_SIM_STATE_CHANGED simState:" + str + " slotId:" + i10);
                }
                if (TextUtils.equals("LOADED", str)) {
                    String b10 = C1577a.b(d.f37134b, i10);
                    if (!TextUtils.isEmpty(b10)) {
                        d.f37136d.put(Integer.valueOf(i10), b10);
                    }
                } else if (TextUtils.equals("ABSENT", str)) {
                    d.f37136d.remove(Integer.valueOf(i10));
                }
                d.f37139g = C1641a.m(d.f37134b);
                d.this.d(str, i10);
            }
        }
    }

    /* compiled from: SimCardManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(String str, int i10);
    }

    public d(Context context) {
        this.f37140a = null;
        f37134b = context;
        HandlerThread handlerThread = new HandlerThread("simManager");
        handlerThread.start();
        this.f37140a = new a(handlerThread.getLooper());
    }

    public static d c(Context context) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return null;
        }
        if (f37135c == null) {
            synchronized (d.class) {
                try {
                    if (f37135c == null) {
                        f37135c = new d(applicationContext);
                    }
                } finally {
                }
            }
        }
        return f37135c;
    }

    public void d(String str, int i10) {
        synchronized (f37138f) {
            for (int i11 = 0; i11 < f37137e.size(); i11++) {
                try {
                    b bVar = f37137e.get(i11);
                    if (bVar != null) {
                        bVar.a(str, i10);
                    }
                } catch (Exception e10) {
                    H7.b.c("SimCardManager", "notifySimStateChange e:" + e10.getMessage());
                }
            }
        }
    }

    public void e(String str, int i10) {
        Handler handler;
        if (H7.a.b()) {
            H7.b.b("SimCardManager", "onSimStateChanged simState:" + str + " slotId:" + i10);
        }
        if ((TextUtils.equals("LOADED", str) || TextUtils.equals("ABSENT", str)) && (handler = this.f37140a) != null) {
            this.f37140a.sendMessage(handler.obtainMessage(1, i10, i10, str));
        }
    }

    public void f(b bVar) {
        if (bVar != null) {
            synchronized (f37138f) {
                f37137e.add(bVar);
            }
        }
    }
}
