package E3;

import F0.c;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.calllog.A;
import com.android.contacts.calllog.I;
import com.android.contacts.calllog.y;
import com.android.contacts.framework.baseui.util.w;
import com.customize.contacts.util.C0801l;
import com.oplus.dialer.R;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ExternalCallLogAdapter.kt */
/* loaded from: classes3.dex */
public class u extends RecyclerView.Adapter<RecyclerView.B> implements Runnable, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: A, reason: collision with root package name */
    public static final b f687A = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f688a;

    /* renamed from: b, reason: collision with root package name */
    public Cursor f689b;

    /* renamed from: c, reason: collision with root package name */
    public final d f690c;

    /* renamed from: d, reason: collision with root package name */
    public final e f691d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedList<c> f692e;

    /* renamed from: f, reason: collision with root package name */
    public A f693f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f694g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f695h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f696i;

    /* renamed from: j, reason: collision with root package name */
    public Thread f697j;

    /* renamed from: k, reason: collision with root package name */
    public HashSet<String> f698k;

    /* renamed from: l, reason: collision with root package name */
    public C7.d<String, y> f699l;

    /* renamed from: m, reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f700m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f701n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f702o;

    /* renamed from: p, reason: collision with root package name */
    public w f703p;

    /* renamed from: q, reason: collision with root package name */
    public final ReentrantLock f704q;

    /* renamed from: r, reason: collision with root package name */
    public final Condition f705r;

    /* renamed from: x, reason: collision with root package name */
    public I f706x;

    /* renamed from: y, reason: collision with root package name */
    public final ContentObserver f707y;

    /* renamed from: z, reason: collision with root package name */
    public final Handler f708z;

    /* compiled from: ExternalCallLogAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f709a;

        /* renamed from: b, reason: collision with root package name */
        public long f710b;

        /* renamed from: c, reason: collision with root package name */
        public long f711c;

        /* renamed from: d, reason: collision with root package name */
        public int f712d;

        /* renamed from: e, reason: collision with root package name */
        public int f713e;

        /* renamed from: f, reason: collision with root package name */
        public Uri f714f;

        /* renamed from: g, reason: collision with root package name */
        public String f715g;

        public a(String str, long j10, long j11, int i10, int i11, Uri uri, String str2) {
            this.f709a = str;
            this.f710b = j10;
            this.f711c = j11;
            this.f712d = i10;
            this.f713e = i11;
            this.f714f = uri;
            this.f715g = str2;
        }

        public final String a() {
            return this.f715g;
        }

        public final long b() {
            return this.f710b;
        }

        public final Uri c() {
            return this.f714f;
        }

        public final String d() {
            return this.f709a;
        }

        public final long e() {
            return this.f711c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (kotlin.jvm.internal.i.b(this.f709a, aVar.f709a) && this.f710b == aVar.f710b && this.f711c == aVar.f711c && this.f712d == aVar.f712d && this.f713e == aVar.f713e && kotlin.jvm.internal.i.b(this.f714f, aVar.f714f) && kotlin.jvm.internal.i.b(this.f715g, aVar.f715g)) {
                return true;
            }
            return false;
        }

        public final int f() {
            return this.f712d;
        }

        public final int g() {
            return this.f713e;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.f709a;
            int i10 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int hashCode3 = ((((((((hashCode * 31) + Long.hashCode(this.f710b)) * 31) + Long.hashCode(this.f711c)) * 31) + Integer.hashCode(this.f712d)) * 31) + Integer.hashCode(this.f713e)) * 31;
            Uri uri = this.f714f;
            if (uri == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = uri.hashCode();
            }
            int i11 = (hashCode3 + hashCode2) * 31;
            String str2 = this.f715g;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return i11 + i10;
        }

        public String toString() {
            return "CallLogInfo(name=" + this.f709a + ", duration=" + this.f710b + ", recordTime=" + this.f711c + ", ringTime=" + this.f712d + ", simId=" + this.f713e + ", lookupUri=" + this.f714f + ", countryISO=" + this.f715g + ")";
        }
    }

    /* compiled from: ExternalCallLogAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ExternalCallLogAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public String f716a;

        /* renamed from: b, reason: collision with root package name */
        public a f717b;

        public c(String number, a aVar) {
            kotlin.jvm.internal.i.f(number, "number");
            this.f716a = number;
            this.f717b = aVar;
        }

        public final a a() {
            return this.f717b;
        }

        public final String b() {
            return this.f716a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (kotlin.jvm.internal.i.b(this.f716a, cVar.f716a) && kotlin.jvm.internal.i.b(this.f717b, cVar.f717b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f716a.hashCode() * 31;
            a aVar = this.f717b;
            if (aVar == null) {
                hashCode = 0;
            } else {
                hashCode = aVar.hashCode();
            }
            return hashCode2 + hashCode;
        }

        public String toString() {
            return "ContactInfoRequest(number=" + this.f716a + ", callLogInfo=" + this.f717b + ")";
        }
    }

    /* compiled from: ExternalCallLogAdapter.kt */
    /* loaded from: classes3.dex */
    public interface d {
        void onItemClick(View view, int i10);
    }

    /* compiled from: ExternalCallLogAdapter.kt */
    /* loaded from: classes3.dex */
    public interface e {
        void onContentChanged();
    }

    /* compiled from: ExternalCallLogAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class f extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f718a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f719b;

        /* renamed from: c, reason: collision with root package name */
        public final CheckBox f720c;

        /* renamed from: d, reason: collision with root package name */
        public final View f721d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(View view) {
            super(view);
            kotlin.jvm.internal.i.f(view, "view");
            View findViewById = view.findViewById(R.id.name);
            kotlin.jvm.internal.i.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f718a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.number);
            kotlin.jvm.internal.i.d(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f719b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.check_box);
            kotlin.jvm.internal.i.d(findViewById3, "null cannot be cast to non-null type android.widget.CheckBox");
            this.f720c = (CheckBox) findViewById3;
            this.f721d = view.findViewById(R.id.bottom_divider);
        }

        public final View e() {
            return this.f721d;
        }

        public final CheckBox f() {
            return this.f720c;
        }

        public final TextView g() {
            return this.f718a;
        }

        public final TextView h() {
            return this.f719b;
        }
    }

    /* compiled from: ExternalCallLogAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class g extends ContentObserver {
        public g(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            u.this.p();
        }
    }

    /* compiled from: ExternalCallLogAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class h extends Handler {
        public h(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            int i10 = msg.what;
            if (i10 == 0) {
                u.this.t();
            } else if (i10 == 1) {
                u.this.notifyDataSetChanged();
            }
        }
    }

    public u(Context context, Cursor cursor, d clickListener, e contentChangeListener) {
        kotlin.jvm.internal.i.f(clickListener, "clickListener");
        kotlin.jvm.internal.i.f(contentChangeListener, "contentChangeListener");
        this.f688a = context;
        this.f689b = cursor;
        this.f690c = clickListener;
        this.f691d = contentChangeListener;
        this.f692e = new LinkedList<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f704q = reentrantLock;
        this.f705r = reentrantLock.newCondition();
        this.f706x = new I(context);
        this.f693f = new A(context, null);
        this.f699l = C7.d.c(100);
        this.f703p = w.e();
        this.f700m = null;
        this.f707y = new g(new Handler(Looper.getMainLooper()));
        this.f708z = new h(Looper.getMainLooper());
    }

    public static final void k(u this$0, int i10, View it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        d dVar = this$0.f690c;
        kotlin.jvm.internal.i.e(it, "it");
        dVar.onItemClick(it, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (H7.a.b()) {
            H7.b.b("ExternalCallLogAdapter", "onContentChanged() ---------- ");
        }
        this.f691d.onContentChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        this.f701n = false;
        Thread thread = new Thread(this, "ContactLookup");
        this.f697j = thread;
        thread.setPriority(1);
        Thread thread2 = this.f697j;
        if (thread2 != null) {
            thread2.start();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Cursor cursor = this.f689b;
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x00e6, code lost:
    
        if (android.text.TextUtils.equals(r4.d(), r11 != null ? r11.f14058c : null) == false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(E3.u.f r24, android.database.Cursor r25, final int r26) {
        /*
            Method dump skipped, instructions count: 871
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E3.u.j(E3.u$f, android.database.Cursor, int):void");
    }

    public final void l(Cursor cursor) {
        if (kotlin.jvm.internal.i.b(this.f689b, cursor)) {
            return;
        }
        Cursor cursor2 = this.f689b;
        this.f689b = cursor;
        if (cursor2 != null) {
            cursor2.unregisterContentObserver(this.f707y);
        }
        Cursor cursor3 = this.f689b;
        if (cursor3 != null) {
            cursor3.registerContentObserver(this.f707y);
        }
        notifyDataSetChanged();
    }

    public final void m(String str, a aVar) {
        c cVar = new c(str, aVar);
        ReentrantLock reentrantLock = this.f704q;
        reentrantLock.lock();
        try {
            if (!this.f692e.contains(cVar)) {
                this.f692e.add(cVar);
                this.f705r.signalAll();
            }
            m9.q qVar = m9.q.f35511a;
            reentrantLock.unlock();
            if (this.f702o) {
                t();
                this.f702o = false;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final Cursor n() {
        return this.f689b;
    }

    public final void o() {
        C7.d<String, y> dVar = this.f699l;
        if (dVar != null) {
            dVar.e();
        }
        this.f700m = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.B r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.i.f(r4, r0)
            boolean r0 = r4 instanceof E3.u.f
            if (r0 == 0) goto L4d
            android.database.Cursor r0 = r3.f689b
            r1 = 0
            if (r0 == 0) goto L20
            boolean r2 = r0.isClosed()
            if (r2 != 0) goto L15
            goto L16
        L15:
            r0 = r1
        L16:
            if (r0 == 0) goto L20
            E3.u$f r4 = (E3.u.f) r4
            r3.j(r4, r0, r5)
            m9.q r4 = m9.q.f35511a
            goto L21
        L20:
            r4 = r1
        L21:
            if (r4 != 0) goto L4d
            android.database.Cursor r3 = r3.f689b
            if (r3 == 0) goto L2f
            boolean r4 = r3.isClosed()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
        L2f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "cursor = "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = " isClosed = "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = "ExternalCallLogAdapter"
            H7.b.c(r4, r3)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: E3.u.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$B, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        View inflate = LayoutInflater.from(this.f688a).inflate(R.layout.external_call_log_list_item, (ViewGroup) null, false);
        kotlin.jvm.internal.i.e(inflate, "from(context).inflate(R.…g_list_item, null, false)");
        return new f(inflate);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (this.f702o) {
            this.f708z.sendEmptyMessageDelayed(0, 1000L);
            this.f702o = false;
            return true;
        }
        return true;
    }

    public final boolean q(String str, a aVar) {
        String str2;
        String str3;
        y yVar;
        boolean z10;
        Uri c10;
        if (aVar == null || (c10 = aVar.c()) == null || (str2 = c10.getLastPathSegment()) == null) {
            str2 = "";
        }
        String str4 = str2;
        y yVar2 = null;
        if (aVar != null) {
            str3 = aVar.a();
        } else {
            str3 = null;
        }
        A a10 = this.f693f;
        if (a10 != null) {
            yVar = a10.j(str, str3, str4, -1L);
        } else {
            yVar = null;
        }
        if (yVar == null) {
            return false;
        }
        boolean z11 = true;
        if (!yVar.f14072q && !TextUtils.isEmpty(str) && PhoneNumberUtils.isEmergencyNumber(str)) {
            yVar.f14072q = true;
            z10 = true;
        } else {
            z10 = false;
        }
        if (aVar != null && yVar.f14057b == null) {
            F0.c a11 = new c.a().h(str).c(Integer.valueOf(yVar.f14059d)).e(Long.valueOf(aVar.b())).j(Integer.valueOf(aVar.f())).i(Long.valueOf(aVar.e())).k(Integer.valueOf(aVar.g())).f(Boolean.TRUE).b(Boolean.valueOf(C0801l.o(yVar.f14059d))).a();
            if (B3.a.u() && E0.b.F(a11)) {
                z10 = true;
            }
        }
        C7.d<String, y> dVar = this.f699l;
        if (dVar != null) {
            yVar2 = dVar.g(str);
        }
        if (yVar2 == null) {
            H7.b.e("ExternalCallLogAdapter", "existingInfo == null");
            return false;
        }
        w wVar = this.f703p;
        if (wVar != null && wVar.c(str) && TextUtils.isEmpty(yVar.f14058c)) {
            w wVar2 = this.f703p;
            kotlin.jvm.internal.i.c(wVar2);
            yVar.f14058c = wVar2.d(str).a();
        }
        if (TextUtils.equals(yVar.f14058c, yVar2.f14058c) && yVar.f14056a == yVar2.f14056a) {
            z11 = z10;
        }
        C7.d<String, y> dVar2 = this.f699l;
        if (dVar2 != null) {
            dVar2.i(str, yVar);
        }
        v(str, yVar, aVar);
        if (H7.a.b()) {
            H7.b.b("ExternalCallLogAdapter", "updated = " + z11);
        }
        return z11;
    }

    public final void r(boolean z10) {
        if (H7.a.b()) {
            H7.b.b("ExternalCallLogAdapter", "setIsFling fling = " + z10);
        }
        this.f696i = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        boolean z10 = false;
        while (!this.f701n) {
            ReentrantLock reentrantLock = this.f704q;
            reentrantLock.lock();
            try {
                if (!this.f692e.isEmpty()) {
                    cVar = this.f692e.removeFirst();
                    m9.q qVar = m9.q.f35511a;
                } else {
                    if (z10) {
                        if (this.f696i) {
                            this.f708z.removeMessages(1);
                            this.f708z.sendEmptyMessageDelayed(1, 1000L);
                        } else {
                            this.f708z.sendEmptyMessage(1);
                        }
                        z10 = false;
                    }
                    try {
                        this.f705r.await(1000L, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        m9.q qVar2 = m9.q.f35511a;
                    }
                    cVar = null;
                }
                reentrantLock.unlock();
                c cVar2 = cVar;
                if (cVar2 != null && !this.f701n && q(cVar2.b(), cVar2.a())) {
                    z10 = true;
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final void s() {
        this.f695h = true;
    }

    public final void u() {
        this.f708z.removeMessages(0);
        this.f701n = true;
        Thread thread = this.f697j;
        if (thread != null) {
            thread.interrupt();
        }
        this.f697j = null;
    }

    public final void v(String str, y yVar, a aVar) {
        ContentValues contentValues = new ContentValues();
        if (aVar != null) {
            if (!TextUtils.equals(yVar.f14058c, aVar.d())) {
                contentValues.put("name", yVar.f14058c);
            } else {
                return;
            }
        } else {
            contentValues.put("name", yVar.f14058c);
            contentValues.put("numbertype", Integer.valueOf(yVar.f14059d));
            contentValues.put("numberlabel", yVar.f14060e);
            contentValues.put("lookup_uri", U7.g.c(yVar.f14057b));
            contentValues.put("matched_number", yVar.f14061f);
            contentValues.put(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, yVar.f14063h);
            contentValues.put("countryiso", yVar.f14074s);
        }
        Context context = this.f688a;
        if (context != null) {
            G7.c.g(context.getContentResolver(), CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, contentValues, "number = ? ", new String[]{str});
        }
    }

    public final void w(HashSet<String> hashSet) {
        this.f698k = hashSet;
    }
}
