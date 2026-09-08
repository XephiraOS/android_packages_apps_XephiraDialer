package A2;

import A2.A;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: OplusYellowPageQueryHelper.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: d, reason: collision with root package name */
    public static Handler f182d;

    /* renamed from: e, reason: collision with root package name */
    public static y f183e;

    /* renamed from: a, reason: collision with root package name */
    public d f184a = new d();

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, A> f185b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final Handler f186c = new a(Looper.getMainLooper());

    /* compiled from: OplusYellowPageQueryHelper.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            A a10;
            if (Log.sDebug) {
                Log.d("OplusYellowPageQueryHelper", "mResultHandler handleMessage...");
            }
            if (message.what == 100 && (a10 = (A) message.obj) != null) {
                A clone = a10.clone();
                v oplusSelectPhoneAccountManager = InCallPresenter.getInstance().realInstance().getOplusSelectPhoneAccountManager();
                if ((oplusSelectPhoneAccountManager != null && oplusSelectPhoneAccountManager.i() != null) || CallList.getInstance().oplusCallList().oplusGetCallSize() != 0) {
                    y.this.f185b.put(a10.f93a, a10);
                }
                clone.f93a = clone.f94b;
                D2.g.k("OplusYellowPageQueryHelper", "EVENT_QUERY_INFO_COMPLETE number =  " + clone);
                j.J().L().a(clone);
                if (clone.f103k == 3 && clone.f95c == null && clone.f97e == null && TextUtils.isEmpty(clone.f96d)) {
                    y.this.f185b.remove(clone.f93a);
                }
            }
        }
    }

    /* compiled from: OplusYellowPageQueryHelper.java */
    /* loaded from: classes.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1000) {
                try {
                    b bVar = (b) message.obj;
                    com.android.incallui.oplus.third.a.a().e(bVar.f190c, bVar.f188a, bVar.f189b, bVar.f191d, bVar.f193f, bVar.f192e);
                } catch (Exception e10) {
                    Log.d("OplusYellowPageQueryHelper", "Exception: " + e10.toString());
                }
            }
        }
    }

    /* compiled from: OplusYellowPageQueryHelper.java */
    /* loaded from: classes.dex */
    public class d implements A.a {
        public d() {
        }

        @Override // A2.A.a
        public void a(A a10) {
            Message obtain = Message.obtain();
            obtain.what = 100;
            D2.g.k("OplusYellowPageQueryHelper", "onQueryYellowPageComplete find info = " + a10);
            obtain.obj = a10;
            y.this.f186c.sendMessage(obtain);
        }
    }

    public y() {
        try {
            HandlerThread handlerThread = new HandlerThread("YellowPageHelperAsyncWorker");
            handlerThread.start();
            f182d = new c(handlerThread.getLooper());
        } catch (Exception e10) {
            Log.d("OplusYellowPageQueryHelper", "Exception: " + e10.toString());
        }
    }

    public static synchronized y d() {
        y yVar;
        synchronized (y.class) {
            try {
                if (f183e == null) {
                    f183e = new y();
                }
                yVar = f183e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return yVar;
    }

    public void c() {
        Handler handler = f182d;
        if (handler != null) {
            handler.getLooper().quitSafely();
            f182d = null;
        }
        synchronized (this) {
            f183e = null;
        }
        if (this.f185b != null) {
            if (Log.sDebug) {
                Log.d("OplusYellowPageQueryHelper", "clear yellow page info");
            }
            Iterator<A> it = this.f185b.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f185b.clear();
        }
    }

    public void e(Context context, String str, int i10, int i11) {
        D2.g.k("OplusYellowPageQueryHelper", "startYellowPageQueryAsync number = " + D2.g.l(str));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String filterSpecialCharacters = OplusPhoneUtils.filterSpecialCharacters(str);
        A a10 = this.f185b.get(filterSpecialCharacters);
        if (a10 != null) {
            A clone = a10.clone();
            clone.f93a = str;
            j.J().L().a(clone);
            return;
        }
        b bVar = new b(null);
        bVar.f188a = filterSpecialCharacters;
        bVar.f190c = context;
        bVar.f191d = i10;
        bVar.f189b = str;
        bVar.f193f = this.f184a;
        bVar.f192e = SubscriptionManager.getSlotIndex(i11);
        Message obtainMessage = f182d.obtainMessage(1000);
        obtainMessage.obj = bVar;
        f182d.sendMessage(obtainMessage);
        if (Log.sDebug) {
            Log.d("OplusYellowPageQueryHelper", "startYellowPageQueryAsync send message to WorkHandler");
        }
    }

    /* compiled from: OplusYellowPageQueryHelper.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f188a;

        /* renamed from: b, reason: collision with root package name */
        public String f189b;

        /* renamed from: c, reason: collision with root package name */
        public Context f190c;

        /* renamed from: d, reason: collision with root package name */
        public int f191d;

        /* renamed from: e, reason: collision with root package name */
        public int f192e;

        /* renamed from: f, reason: collision with root package name */
        public A.a f193f;

        public b() {
            this.f192e = -1;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
