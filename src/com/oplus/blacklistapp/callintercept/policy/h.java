package com.oplus.blacklistapp.callintercept.policy;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.blacklistapp.callintercept.CallInterceptController;
import com.oplus.blacklistapp.callintercept.policy.f;
import com.oplus.utils.C0846g;
import java.util.HashMap;
import t6.C1594b;
import v6.C1627a;
import v6.C1632f;

/* compiled from: YellowPageQueryHelper.java */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    public static Handler f26729d;

    /* renamed from: e, reason: collision with root package name */
    public static h f26730e;

    /* renamed from: a, reason: collision with root package name */
    public d f26731a = new d();

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, f> f26732b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final Handler f26733c = new a(Looper.getMainLooper());

    /* compiled from: YellowPageQueryHelper.java */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f fVar;
            if (C1627a.f37411c) {
                C1627a.c("YellowPageQueryHelper", "mResultHandler handleMessage...");
            }
            if (message.what == 100 && (fVar = (f) message.obj) != null) {
                f clone = fVar.clone();
                h.this.f26732b.put(fVar.f26718a, fVar);
                clone.f26718a = clone.f26719b;
                C1627a.m("YellowPageQueryHelper", "EVENT_QUERY_INFO_COMPLETE number =  " + clone);
                CallInterceptController.e().g().w().a(clone);
                if (clone.f26726i == 3 && clone.f26720c == null && clone.f26721d == null) {
                    h.this.f26732b.remove(clone.f26718a);
                }
            }
        }
    }

    /* compiled from: YellowPageQueryHelper.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f26735a;

        /* renamed from: b, reason: collision with root package name */
        public String f26736b;

        /* renamed from: c, reason: collision with root package name */
        public Context f26737c;

        /* renamed from: d, reason: collision with root package name */
        public int f26738d;

        /* renamed from: e, reason: collision with root package name */
        public int f26739e;

        /* renamed from: f, reason: collision with root package name */
        public f.a f26740f;

        public b() {
            this.f26739e = -1;
        }
    }

    /* compiled from: YellowPageQueryHelper.java */
    /* loaded from: classes3.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1000) {
                try {
                    b bVar = (b) message.obj;
                    C1594b.a().e(bVar.f26737c, bVar.f26735a, bVar.f26736b, bVar.f26738d, bVar.f26740f, bVar.f26739e);
                } catch (Exception e10) {
                    Log.e("YellowPageQueryHelper", "e = " + e10);
                }
            }
        }
    }

    /* compiled from: YellowPageQueryHelper.java */
    /* loaded from: classes3.dex */
    public class d implements f.a {
        public d() {
        }

        @Override // com.oplus.blacklistapp.callintercept.policy.f.a
        public void a(f fVar) {
            Message obtain = Message.obtain();
            obtain.what = 100;
            C1627a.m("YellowPageQueryHelper", "onQueryYellowPageComplete find info = " + fVar);
            obtain.obj = fVar;
            h.this.f26733c.sendMessage(obtain);
        }
    }

    public h() {
        try {
            HandlerThread handlerThread = new HandlerThread("YellowPageHelperAsyncWorker");
            handlerThread.start();
            f26729d = new c(handlerThread.getLooper());
        } catch (Exception e10) {
            Log.e("YellowPageQueryHelper", "e = " + e10);
        }
    }

    public static synchronized h d() {
        h hVar;
        synchronized (h.class) {
            try {
                if (f26730e == null) {
                    f26730e = new h();
                }
                hVar = f26730e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public void c() {
        Handler handler = f26729d;
        if (handler != null) {
            handler.getLooper().quitSafely();
            f26729d = null;
        }
        synchronized (h.class) {
            f26730e = null;
        }
        if (this.f26732b != null) {
            if (C1627a.f37411c) {
                C1627a.c("YellowPageQueryHelper", "clear yellow page info");
            }
            this.f26732b.clear();
        }
    }

    public void e(String str) {
        if (C1627a.f37411c) {
            C1627a.c("YellowPageQueryHelper", "removeCache");
        }
        HashMap<String, f> hashMap = this.f26732b;
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }

    public void f(Context context, String str, int i10, int i11) {
        C1627a.m("YellowPageQueryHelper", "startYellowPageQueryAsync number = " + C0846g.f(str));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String h10 = C1632f.h(str);
        f fVar = this.f26732b.get(h10);
        if (fVar != null) {
            f clone = fVar.clone();
            clone.f26718a = str;
            CallInterceptController.e().g().w().a(clone);
            return;
        }
        b bVar = new b();
        bVar.f26735a = h10;
        bVar.f26737c = context;
        bVar.f26738d = i10;
        bVar.f26736b = str;
        bVar.f26740f = this.f26731a;
        bVar.f26739e = SubscriptionManager.getSlotIndex(i11);
        Message obtainMessage = f26729d.obtainMessage(1000);
        obtainMessage.obj = bVar;
        f26729d.sendMessage(obtainMessage);
        if (C1627a.f37411c) {
            C1627a.c("YellowPageQueryHelper", "startYellowPageQueryAsync send message to WorkHandler");
        }
    }
}
