package Y7;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

/* compiled from: StateMachine.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f5560a;

    /* renamed from: b, reason: collision with root package name */
    public d f5561b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f5562c;

    /* compiled from: StateMachine.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public c f5563a;

        /* renamed from: b, reason: collision with root package name */
        public long f5564b;

        /* renamed from: c, reason: collision with root package name */
        public int f5565c;

        /* renamed from: d, reason: collision with root package name */
        public String f5566d;

        /* renamed from: e, reason: collision with root package name */
        public Y7.a f5567e;

        /* renamed from: f, reason: collision with root package name */
        public Y7.a f5568f;

        /* renamed from: g, reason: collision with root package name */
        public Y7.a f5569g;

        public b(c cVar, Message message, String str, Y7.a aVar, Y7.a aVar2, Y7.a aVar3) {
            a(cVar, message, str, aVar, aVar2, aVar3);
        }

        public void a(c cVar, Message message, String str, Y7.a aVar, Y7.a aVar2, Y7.a aVar3) {
            int i10;
            this.f5563a = cVar;
            this.f5564b = System.currentTimeMillis();
            if (message != null) {
                i10 = message.what;
            } else {
                i10 = 0;
            }
            this.f5565c = i10;
            this.f5566d = str;
            this.f5567e = aVar;
            this.f5568f = aVar2;
            this.f5569g = aVar3;
        }

        public String toString() {
            String name;
            String name2;
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("time=");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.f5564b);
            sb.append(String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar));
            sb.append(" processed=");
            Y7.a aVar = this.f5567e;
            String str2 = "<null>";
            if (aVar == null) {
                name = "<null>";
            } else {
                name = aVar.getName();
            }
            sb.append(name);
            sb.append(" org=");
            Y7.a aVar2 = this.f5568f;
            if (aVar2 == null) {
                name2 = "<null>";
            } else {
                name2 = aVar2.getName();
            }
            sb.append(name2);
            sb.append(" dest=");
            Y7.a aVar3 = this.f5569g;
            if (aVar3 != null) {
                str2 = aVar3.getName();
            }
            sb.append(str2);
            sb.append(" what=");
            c cVar = this.f5563a;
            if (cVar != null) {
                str = cVar.j(this.f5565c);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                sb.append(this.f5565c);
                sb.append("(0x");
                sb.append(Integer.toHexString(this.f5565c));
                sb.append(")");
            } else {
                sb.append(str);
            }
            if (!TextUtils.isEmpty(this.f5566d)) {
                sb.append(" ");
                sb.append(this.f5566d);
            }
            return sb.toString();
        }
    }

    /* compiled from: StateMachine.java */
    /* renamed from: Y7.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0088c {

        /* renamed from: a, reason: collision with root package name */
        public Vector<b> f5570a;

        /* renamed from: b, reason: collision with root package name */
        public int f5571b;

        /* renamed from: c, reason: collision with root package name */
        public int f5572c;

        /* renamed from: d, reason: collision with root package name */
        public int f5573d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f5574e;

        public synchronized void a(c cVar, Message message, String str, Y7.a aVar, Y7.a aVar2, Y7.a aVar3) {
            try {
                this.f5573d++;
                if (this.f5570a.size() < this.f5571b) {
                    this.f5570a.add(new b(cVar, message, str, aVar, aVar2, aVar3));
                } else {
                    b bVar = this.f5570a.get(this.f5572c);
                    int i10 = this.f5572c + 1;
                    this.f5572c = i10;
                    if (i10 >= this.f5571b) {
                        this.f5572c = 0;
                    }
                    bVar.a(cVar, message, str, aVar, aVar2, aVar3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized void b() {
            this.f5570a.clear();
        }

        public synchronized boolean c() {
            return this.f5574e;
        }

        public C0088c() {
            this.f5570a = new Vector<>();
            this.f5571b = 20;
            this.f5572c = 0;
            this.f5573d = 0;
            this.f5574e = false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes3.dex */
    public static class d extends Handler {

        /* renamed from: r, reason: collision with root package name */
        public static final Object f5575r = new Object();

        /* renamed from: a, reason: collision with root package name */
        public boolean f5576a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5577b;

        /* renamed from: c, reason: collision with root package name */
        public Message f5578c;

        /* renamed from: d, reason: collision with root package name */
        public C0088c f5579d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f5580e;

        /* renamed from: f, reason: collision with root package name */
        public C0089c[] f5581f;

        /* renamed from: g, reason: collision with root package name */
        public int f5582g;

        /* renamed from: h, reason: collision with root package name */
        public C0089c[] f5583h;

        /* renamed from: i, reason: collision with root package name */
        public int f5584i;

        /* renamed from: j, reason: collision with root package name */
        public a f5585j;

        /* renamed from: k, reason: collision with root package name */
        public b f5586k;

        /* renamed from: l, reason: collision with root package name */
        public c f5587l;

        /* renamed from: m, reason: collision with root package name */
        public HashMap<Y7.b, C0089c> f5588m;

        /* renamed from: n, reason: collision with root package name */
        public Y7.b f5589n;

        /* renamed from: o, reason: collision with root package name */
        public Y7.b f5590o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f5591p;

        /* renamed from: q, reason: collision with root package name */
        public ArrayList<Message> f5592q;

        /* compiled from: StateMachine.java */
        /* loaded from: classes3.dex */
        public class a extends Y7.b {
            public a() {
            }

            @Override // Y7.b
            public boolean c(Message message) {
                d.this.f5587l.k(message);
                return true;
            }
        }

        /* compiled from: StateMachine.java */
        /* loaded from: classes3.dex */
        public class b extends Y7.b {
            public b() {
            }

            @Override // Y7.b
            public boolean c(Message message) {
                return false;
            }
        }

        /* compiled from: StateMachine.java */
        /* renamed from: Y7.c$d$c, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0089c {

            /* renamed from: a, reason: collision with root package name */
            public Y7.b f5595a;

            /* renamed from: b, reason: collision with root package name */
            public C0089c f5596b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f5597c;

            public C0089c() {
            }

            public String toString() {
                String name;
                StringBuilder sb = new StringBuilder();
                sb.append("state=");
                sb.append(this.f5595a.getName());
                sb.append(",active=");
                sb.append(this.f5597c);
                sb.append(",parent=");
                C0089c c0089c = this.f5596b;
                if (c0089c == null) {
                    name = "null";
                } else {
                    name = c0089c.f5595a.getName();
                }
                sb.append(name);
                return sb.toString();
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Y7.b s10;
            int i10;
            c cVar;
            int i11;
            int i12;
            if (!this.f5576a) {
                c cVar2 = this.f5587l;
                if (cVar2 != null && (i12 = message.what) != -2 && i12 != -1) {
                    cVar2.s(message);
                }
                if (this.f5577b) {
                    this.f5587l.m("handleMessage: E msg.what=" + message.what);
                }
                this.f5578c = message;
                boolean z10 = this.f5580e;
                if (!z10 && (i11 = message.what) != -1) {
                    if (!z10 && i11 == -2 && message.obj == f5575r) {
                        this.f5580e = true;
                        m(0);
                        s10 = null;
                    } else {
                        throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
                    }
                } else {
                    s10 = s(message);
                }
                r(s10, message);
                if (this.f5577b && (cVar = this.f5587l) != null) {
                    cVar.m("handleMessage: X");
                }
                c cVar3 = this.f5587l;
                if (cVar3 != null && (i10 = message.what) != -2 && i10 != -1) {
                    cVar3.r(message);
                }
            }
        }

        public final C0089c i(Y7.b bVar, Y7.b bVar2) {
            C0089c c0089c;
            String name;
            if (this.f5577b) {
                c cVar = this.f5587l;
                StringBuilder sb = new StringBuilder();
                sb.append("addStateInternal: E state=");
                sb.append(bVar.getName());
                sb.append(",parent=");
                if (bVar2 == null) {
                    name = "";
                } else {
                    name = bVar2.getName();
                }
                sb.append(name);
                cVar.m(sb.toString());
            }
            if (bVar2 != null) {
                c0089c = this.f5588m.get(bVar2);
                if (c0089c == null) {
                    c0089c = i(bVar2, null);
                }
            } else {
                c0089c = null;
            }
            C0089c c0089c2 = this.f5588m.get(bVar);
            if (c0089c2 == null) {
                c0089c2 = new C0089c();
                this.f5588m.put(bVar, c0089c2);
            }
            C0089c c0089c3 = c0089c2.f5596b;
            if (c0089c3 != null && c0089c3 != c0089c) {
                throw new RuntimeException("state already added");
            }
            c0089c2.f5595a = bVar;
            c0089c2.f5596b = c0089c;
            c0089c2.f5597c = false;
            if (this.f5577b) {
                this.f5587l.m("addStateInternal: X stateInfo: " + c0089c2);
            }
            return c0089c2;
        }

        public final void j() {
            if (this.f5587l.f5562c != null) {
                getLooper().quit();
                this.f5587l.f5562c = null;
            }
            this.f5587l.f5561b = null;
            this.f5587l = null;
            this.f5578c = null;
            this.f5579d.b();
            this.f5581f = null;
            this.f5583h = null;
            this.f5588m.clear();
            this.f5589n = null;
            this.f5590o = null;
            this.f5592q.clear();
            this.f5576a = true;
        }

        public final void k() {
            if (this.f5577b) {
                this.f5587l.m("completeConstruction: E");
            }
            int i10 = 0;
            for (C0089c c0089c : this.f5588m.values()) {
                int i11 = 0;
                while (c0089c != null) {
                    c0089c = c0089c.f5596b;
                    i11++;
                }
                if (i10 < i11) {
                    i10 = i11;
                }
            }
            if (this.f5577b) {
                this.f5587l.m("completeConstruction: maxDepth=" + i10);
            }
            this.f5581f = new C0089c[i10];
            this.f5583h = new C0089c[i10];
            v();
            sendMessageAtFrontOfQueue(obtainMessage(-2, f5575r));
            if (this.f5577b) {
                this.f5587l.m("completeConstruction: X");
            }
        }

        public final Y7.a l() {
            return this.f5581f[this.f5582g].f5595a;
        }

        public final void m(int i10) {
            int i11 = i10;
            while (true) {
                int i12 = this.f5582g;
                if (i11 <= i12) {
                    if (i10 == i12) {
                        this.f5591p = false;
                    }
                    if (this.f5577b) {
                        this.f5587l.m("invokeEnterMethods: " + this.f5581f[i11].f5595a.getName());
                    }
                    this.f5581f[i11].f5595a.a();
                    this.f5581f[i11].f5597c = true;
                    i11++;
                } else {
                    this.f5591p = false;
                    return;
                }
            }
        }

        public final void n(C0089c c0089c) {
            C0089c c0089c2;
            while (true) {
                int i10 = this.f5582g;
                if (i10 >= 0 && (c0089c2 = this.f5581f[i10]) != c0089c) {
                    Y7.b bVar = c0089c2.f5595a;
                    if (this.f5577b) {
                        this.f5587l.m("invokeExitMethods: " + bVar.getName());
                    }
                    bVar.b();
                    C0089c[] c0089cArr = this.f5581f;
                    int i11 = this.f5582g;
                    c0089cArr[i11].f5597c = false;
                    this.f5582g = i11 - 1;
                } else {
                    return;
                }
            }
        }

        public final boolean o(Message message) {
            if (message.what == -1 && message.obj == f5575r) {
                return true;
            }
            return false;
        }

        public final void p() {
            for (int size = this.f5592q.size() - 1; size >= 0; size--) {
                Message message = this.f5592q.get(size);
                if (this.f5577b) {
                    this.f5587l.m("moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.f5592q.clear();
        }

        public final int q() {
            int i10 = this.f5582g + 1;
            int i11 = i10;
            for (int i12 = this.f5584i - 1; i12 >= 0; i12--) {
                if (this.f5577b) {
                    this.f5587l.m("moveTempStackToStateStack: i=" + i12 + ",j=" + i11);
                }
                this.f5581f[i11] = this.f5583h[i12];
                i11++;
            }
            this.f5582g = i11 - 1;
            if (this.f5577b) {
                this.f5587l.m("moveTempStackToStateStack: X mStateStackTop=" + this.f5582g + ",startingIndex=" + i10 + ",Top=" + this.f5581f[this.f5582g].f5595a.getName());
            }
            return i10;
        }

        public final void r(Y7.b bVar, Message message) {
            boolean z10;
            Y7.b bVar2 = this.f5581f[this.f5582g].f5595a;
            if (this.f5587l.v(this.f5578c) && message.obj != f5575r) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.f5579d.c()) {
                if (this.f5590o != null) {
                    C0088c c0088c = this.f5579d;
                    c cVar = this.f5587l;
                    Message message2 = this.f5578c;
                    c0088c.a(cVar, message2, cVar.i(message2), bVar, bVar2, this.f5590o);
                }
            } else if (z10) {
                C0088c c0088c2 = this.f5579d;
                c cVar2 = this.f5587l;
                Message message3 = this.f5578c;
                c0088c2.a(cVar2, message3, cVar2.i(message3), bVar, bVar2, this.f5590o);
            }
            Y7.b bVar3 = this.f5590o;
            if (bVar3 != null) {
                while (true) {
                    if (this.f5577b) {
                        this.f5587l.m("handleMessage: new destination call exit/enter");
                    }
                    C0089c w10 = w(bVar3);
                    this.f5591p = true;
                    n(w10);
                    m(q());
                    p();
                    Y7.b bVar4 = this.f5590o;
                    if (bVar3 == bVar4) {
                        break;
                    } else {
                        bVar3 = bVar4;
                    }
                }
                this.f5590o = null;
            }
            if (bVar3 != null) {
                if (bVar3 == this.f5586k) {
                    this.f5587l.t();
                    j();
                } else if (bVar3 == this.f5585j) {
                    this.f5587l.q();
                }
            }
        }

        public final Y7.b s(Message message) {
            C0089c c0089c = this.f5581f[this.f5582g];
            if (this.f5577b) {
                this.f5587l.m("processMsg: " + c0089c.f5595a.getName());
            }
            if (o(message)) {
                x(this.f5586k);
            } else {
                while (true) {
                    if (c0089c.f5595a.c(message)) {
                        break;
                    }
                    c0089c = c0089c.f5596b;
                    if (c0089c == null) {
                        this.f5587l.D(message);
                        break;
                    }
                    if (this.f5577b) {
                        this.f5587l.m("processMsg: " + c0089c.f5595a.getName());
                    }
                }
            }
            if (c0089c != null) {
                return c0089c.f5595a;
            }
            return null;
        }

        public final void t() {
            if (this.f5577b) {
                this.f5587l.m("quitNow:");
            }
            sendMessageAtFrontOfQueue(obtainMessage(-1, f5575r));
        }

        public final void u(Y7.b bVar) {
            if (this.f5577b) {
                this.f5587l.m("setInitialState: initialState=" + bVar.getName());
            }
            this.f5589n = bVar;
        }

        public final void v() {
            if (this.f5577b) {
                this.f5587l.m("setupInitialStateStack: E mInitialState=" + this.f5589n.getName());
            }
            C0089c c0089c = this.f5588m.get(this.f5589n);
            this.f5584i = 0;
            while (c0089c != null) {
                C0089c[] c0089cArr = this.f5583h;
                int i10 = this.f5584i;
                c0089cArr[i10] = c0089c;
                c0089c = c0089c.f5596b;
                this.f5584i = i10 + 1;
            }
            this.f5582g = -1;
            q();
        }

        public final C0089c w(Y7.b bVar) {
            this.f5584i = 0;
            C0089c c0089c = this.f5588m.get(bVar);
            do {
                C0089c[] c0089cArr = this.f5583h;
                int i10 = this.f5584i;
                this.f5584i = i10 + 1;
                c0089cArr[i10] = c0089c;
                c0089c = c0089c.f5596b;
                if (c0089c == null) {
                    break;
                }
            } while (!c0089c.f5597c);
            if (this.f5577b) {
                this.f5587l.m("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.f5584i + ",curStateInfo: " + c0089c);
            }
            return c0089c;
        }

        public final void x(Y7.a aVar) {
            if (this.f5591p) {
                Log.wtf(this.f5587l.f5560a, "transitionTo called while transition already in progress to " + this.f5590o + ", new target state=" + aVar);
            }
            this.f5590o = (Y7.b) aVar;
            if (this.f5577b) {
                this.f5587l.m("transitionTo: destState=" + this.f5590o.getName());
            }
        }

        public d(Looper looper, c cVar) {
            super(looper);
            this.f5576a = false;
            this.f5577b = false;
            this.f5579d = new C0088c();
            this.f5582g = -1;
            this.f5585j = new a();
            this.f5586k = new b();
            this.f5588m = new HashMap<>();
            this.f5591p = false;
            this.f5592q = new ArrayList<>();
            this.f5587l = cVar;
            i(this.f5585j, null);
            i(this.f5586k, null);
        }
    }

    public c(String str, Looper looper) {
        l(str, looper);
    }

    public final void A(Y7.b bVar) {
        this.f5561b.u(bVar);
    }

    public void B() {
        d dVar = this.f5561b;
        if (dVar != null) {
            dVar.k();
        }
    }

    public final void C(Y7.a aVar) {
        this.f5561b.x(aVar);
    }

    public void D(Message message) {
        if (this.f5561b.f5577b) {
            n(" - unhandledMessage: msg.what=" + message.what);
        }
    }

    public final void g(Y7.b bVar) {
        this.f5561b.i(bVar, null);
    }

    public final Handler h() {
        return this.f5561b;
    }

    public String i(Message message) {
        return "";
    }

    public String j(int i10) {
        return null;
    }

    public final void l(String str, Looper looper) {
        this.f5560a = str;
        this.f5561b = new d(looper, this);
    }

    public void m(String str) {
        Log.d(this.f5560a, str);
    }

    public void n(String str) {
        Log.e(this.f5560a, str);
    }

    public final Message o(int i10) {
        return Message.obtain(this.f5561b, i10);
    }

    public final Message p(int i10, int i11) {
        return Message.obtain(this.f5561b, i10, i11, 0);
    }

    public String toString() {
        String str;
        String str2 = "(null)";
        try {
            str = this.f5560a.toString();
            try {
                str2 = this.f5561b.l().getName().toString();
            } catch (ArrayIndexOutOfBoundsException | NullPointerException unused) {
            }
        } catch (ArrayIndexOutOfBoundsException | NullPointerException unused2) {
            str = "(null)";
        }
        return "name=" + str + " state=" + str2;
    }

    public final void u() {
        d dVar = this.f5561b;
        if (dVar != null) {
            dVar.t();
        }
    }

    public boolean v(Message message) {
        return true;
    }

    public final void w(int i10) {
        d dVar = this.f5561b;
        if (dVar == null) {
            return;
        }
        dVar.removeMessages(i10);
    }

    public void x(int i10) {
        d dVar = this.f5561b;
        if (dVar == null) {
            return;
        }
        dVar.sendMessage(o(i10));
    }

    public void y(int i10, int i11) {
        d dVar = this.f5561b;
        if (dVar == null) {
            return;
        }
        dVar.sendMessage(p(i10, i11));
    }

    public void z(int i10, long j10) {
        d dVar = this.f5561b;
        if (dVar == null) {
            return;
        }
        dVar.sendMessageDelayed(o(i10), j10);
    }

    public void q() {
    }

    public void t() {
    }

    public void k(Message message) {
    }

    public void r(Message message) {
    }

    public void s(Message message) {
    }
}
