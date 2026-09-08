package J1;

import androidx.lifecycle.LiveData;
import com.android.incallui.Call;
import com.android.incallui.clean.domain.interactor.UseCase0;
import com.android.incallui.clean.domain.interactor.UseCase1;
import java.util.ArrayList;

/* compiled from: CallUseCases.kt */
/* loaded from: classes.dex */
public final class e extends J1.b {

    /* renamed from: A, reason: collision with root package name */
    public final UseCase1<String, m9.q> f1508A;

    /* renamed from: B, reason: collision with root package name */
    public final UseCase0<Boolean> f1509B;

    /* renamed from: C, reason: collision with root package name */
    public final UseCase1<Boolean, m9.q> f1510C;

    /* renamed from: D, reason: collision with root package name */
    public final UseCase0<Boolean> f1511D;

    /* renamed from: b, reason: collision with root package name */
    public final I1.c f1512b;

    /* renamed from: c, reason: collision with root package name */
    public final UseCase1<Integer, m9.q> f1513c;

    /* renamed from: d, reason: collision with root package name */
    public final UseCase1<String, m9.q> f1514d;

    /* renamed from: e, reason: collision with root package name */
    public final com.android.incallui.clean.domain.interactor.f<String, Boolean, String, m9.q> f1515e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.lifecycle.v<Boolean> f1516f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.v<Boolean> f1517g;

    /* renamed from: h, reason: collision with root package name */
    public final LiveData<Boolean> f1518h;

    /* renamed from: i, reason: collision with root package name */
    public final UseCase0<Call> f1519i;

    /* renamed from: j, reason: collision with root package name */
    public final UseCase0<Call> f1520j;

    /* renamed from: k, reason: collision with root package name */
    public final UseCase0<Call> f1521k;

    /* renamed from: l, reason: collision with root package name */
    public final UseCase0<Call> f1522l;

    /* renamed from: m, reason: collision with root package name */
    public final com.android.incallui.clean.domain.interactor.e<Integer, Integer, Call> f1523m;

    /* renamed from: n, reason: collision with root package name */
    public final UseCase1<Integer, m9.q> f1524n;

    /* renamed from: o, reason: collision with root package name */
    public final UseCase0<Boolean> f1525o;

    /* renamed from: p, reason: collision with root package name */
    public final UseCase0<ArrayList<String>> f1526p;

    /* renamed from: q, reason: collision with root package name */
    public final UseCase0<m9.q> f1527q;

    /* renamed from: r, reason: collision with root package name */
    public final com.android.incallui.clean.domain.interactor.e<Call, Call, m9.q> f1528r;

    /* renamed from: s, reason: collision with root package name */
    public final UseCase1<String, m9.q> f1529s;

    /* renamed from: t, reason: collision with root package name */
    public final UseCase0<Call> f1530t;

    /* renamed from: u, reason: collision with root package name */
    public final UseCase0<Boolean> f1531u;

    /* renamed from: v, reason: collision with root package name */
    public final UseCase0<Call> f1532v;

    /* renamed from: w, reason: collision with root package name */
    public final UseCase0<Long> f1533w;

    /* renamed from: x, reason: collision with root package name */
    public final UseCase1<Long, m9.q> f1534x;

    /* renamed from: y, reason: collision with root package name */
    public final UseCase0<m9.q> f1535y;

    /* renamed from: z, reason: collision with root package name */
    public final UseCase0<m9.q> f1536z;

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class a extends UseCase1<Integer, m9.q> {
        public a() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ m9.q h(Integer num) {
            i(num.intValue());
            return m9.q.f35511a;
        }

        public void i(int i10) {
            e.this.f1512b.C(i10);
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class b extends com.android.incallui.clean.domain.interactor.e<Call, Call, m9.q> {
        public b() {
        }

        @Override // com.android.incallui.clean.domain.interactor.e
        public /* bridge */ /* synthetic */ m9.q f(Call call, Call call2) {
            g(call, call2);
            return m9.q.f35511a;
        }

        public void g(Call p12, Call p22) {
            kotlin.jvm.internal.i.f(p12, "p1");
            kotlin.jvm.internal.i.f(p22, "p2");
            e.this.f1512b.J0();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class c extends UseCase1<String, m9.q> {
        public c() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ m9.q h(String str) {
            i(str);
            return m9.q.f35511a;
        }

        public void i(String str) {
            e.this.f1512b.E(str);
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class d extends UseCase0<m9.q> {
        public d() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ m9.q h() {
            i();
            return m9.q.f35511a;
        }

        public void i() {
            e.this.f1512b.n0();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* renamed from: J1.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0033e extends UseCase1<String, m9.q> {
        public C0033e() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ m9.q h(String str) {
            i(str);
            return m9.q.f35511a;
        }

        public void i(String p12) {
            kotlin.jvm.internal.i.f(p12, "p1");
            e.this.f1512b.S(p12);
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class f extends UseCase0<Call> {
        public f() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Call h() {
            return e.this.f1512b.y1();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class g extends UseCase0<Call> {
        public g() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Call h() {
            return e.this.f1512b.e1();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class h extends UseCase0<Call> {
        public h() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Call h() {
            return e.this.f1512b.j1();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class i extends UseCase0<Call> {
        public i() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Call h() {
            return e.this.f1512b.E0();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class j extends UseCase0<Long> {
        public j() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Long h() {
            return Long.valueOf(e.this.f1512b.P());
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class k extends UseCase0<Call> {
        public k() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Call h() {
            return e.this.f1512b.j0();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class l extends UseCase0<Call> {
        public l() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Call h() {
            return e.this.f1512b.J();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class m extends com.android.incallui.clean.domain.interactor.e<Integer, Integer, Call> {
        public m() {
        }

        @Override // com.android.incallui.clean.domain.interactor.e
        public /* bridge */ /* synthetic */ Call f(Integer num, Integer num2) {
            return g(num.intValue(), num2.intValue());
        }

        public Call g(int i10, int i11) {
            return e.this.f1512b.H(i10, i11);
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class n extends UseCase0<ArrayList<String>> {
        public n() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public ArrayList<String> h() {
            return e.this.f1512b.k1();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class o extends UseCase0<Boolean> {
        public o() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean h() {
            return Boolean.valueOf(e.this.f1512b.T0());
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class p extends UseCase0<Boolean> {
        public p() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean h() {
            return Boolean.valueOf(e.this.f1512b.A1());
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class q extends UseCase0<Boolean> {
        public q() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean h() {
            return Boolean.valueOf(e.this.f1512b.t());
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class r extends UseCase0<Boolean> {
        public r() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean h() {
            return Boolean.valueOf(e.this.f1512b.P0());
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class s extends UseCase0<m9.q> {
        public s() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ m9.q h() {
            i();
            return m9.q.f35511a;
        }

        public void i() {
            e.this.f1512b.Y0();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class t extends UseCase1<Boolean, m9.q> {
        public t() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ m9.q h(Boolean bool) {
            i(bool.booleanValue());
            return m9.q.f35511a;
        }

        public void i(boolean z10) {
            e.this.f1512b.r(z10);
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class u extends com.android.incallui.clean.domain.interactor.f<String, Boolean, String, m9.q> {
        public u() {
        }

        @Override // com.android.incallui.clean.domain.interactor.f
        public /* bridge */ /* synthetic */ m9.q b(String str, Boolean bool, String str2) {
            c(str, bool.booleanValue(), str2);
            return m9.q.f35511a;
        }

        public void c(String p12, boolean z10, String str) {
            kotlin.jvm.internal.i.f(p12, "p1");
            e.this.f1512b.a1(p12, z10, str);
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class v extends UseCase1<Integer, m9.q> {
        public v() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ m9.q h(Integer num) {
            i(num.intValue());
            return m9.q.f35511a;
        }

        public void i(int i10) {
            e.this.f1512b.M(i10);
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class w extends UseCase1<Long, m9.q> {
        public w() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ m9.q h(Long l10) {
            i(l10.longValue());
            return m9.q.f35511a;
        }

        public void i(long j10) {
            e.this.f1512b.A0(j10);
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class x extends UseCase0<m9.q> {
        public x() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ m9.q h() {
            i();
            return m9.q.f35511a;
        }

        public void i() {
            e.this.f1512b.b();
        }
    }

    /* compiled from: CallUseCases.kt */
    /* loaded from: classes.dex */
    public static final class y extends UseCase1<String, m9.q> {
        public y() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ m9.q h(String str) {
            i(str);
            return m9.q.f35511a;
        }

        public void i(String p12) {
            kotlin.jvm.internal.i.f(p12, "p1");
            e.this.f1512b.y0(p12);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(I1.c repository) {
        super(repository);
        kotlin.jvm.internal.i.f(repository, "repository");
        this.f1512b = repository;
        this.f1513c = new a();
        this.f1514d = new c();
        this.f1515e = new u();
        this.f1516f = repository.Q0();
        this.f1517g = repository.o0();
        this.f1518h = repository.g();
        this.f1519i = new f();
        this.f1520j = new i();
        this.f1521k = new k();
        this.f1522l = new l();
        this.f1523m = new m();
        this.f1524n = new v();
        this.f1525o = new p();
        this.f1526p = new n();
        this.f1527q = new x();
        this.f1528r = new b();
        this.f1529s = new C0033e();
        this.f1530t = new h();
        this.f1531u = new o();
        this.f1532v = new g();
        this.f1533w = new j();
        this.f1534x = new w();
        this.f1535y = new s();
        this.f1536z = new d();
        this.f1508A = new y();
        this.f1509B = new q();
        this.f1510C = new t();
        this.f1511D = new r();
    }

    public final UseCase1<Integer, m9.q> c() {
        return this.f1513c;
    }

    public final com.android.incallui.clean.domain.interactor.e<Call, Call, m9.q> d() {
        return this.f1528r;
    }

    public final UseCase1<String, m9.q> e() {
        return this.f1514d;
    }

    public final UseCase0<m9.q> f() {
        return this.f1536z;
    }

    public final UseCase0<Call> g() {
        return this.f1519i;
    }

    public final UseCase0<Call> h() {
        return this.f1532v;
    }

    public final UseCase0<Call> i() {
        return this.f1530t;
    }

    public final UseCase0<Call> j() {
        return this.f1520j;
    }

    public final UseCase0<Long> k() {
        return this.f1533w;
    }

    public final com.android.incallui.clean.domain.interactor.e<Integer, Integer, Call> l() {
        return this.f1523m;
    }

    public final UseCase0<ArrayList<String>> m() {
        return this.f1526p;
    }

    public final UseCase0<Boolean> n() {
        return this.f1531u;
    }

    public final UseCase0<Boolean> o() {
        return this.f1509B;
    }

    public final UseCase0<m9.q> p() {
        return this.f1535y;
    }

    public final UseCase1<Boolean, m9.q> q() {
        return this.f1510C;
    }

    public final com.android.incallui.clean.domain.interactor.f<String, Boolean, String, m9.q> r() {
        return this.f1515e;
    }

    public final UseCase1<Integer, m9.q> s() {
        return this.f1524n;
    }

    public final UseCase1<Long, m9.q> t() {
        return this.f1534x;
    }

    public final UseCase0<m9.q> u() {
        return this.f1527q;
    }

    public final UseCase1<String, m9.q> v() {
        return this.f1508A;
    }

    public final androidx.lifecycle.v<Boolean> w() {
        return this.f1517g;
    }

    public final androidx.lifecycle.v<Boolean> x() {
        return this.f1516f;
    }

    public final LiveData<Boolean> y() {
        return this.f1518h;
    }

    public final UseCase0<Boolean> z() {
        return this.f1511D;
    }
}
