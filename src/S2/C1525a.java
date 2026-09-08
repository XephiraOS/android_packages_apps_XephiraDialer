package s2;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.clean.domain.interactor.UseCase0;
import com.android.incallui.clean.domain.interactor.UseCase1;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import m9.q;
import r2.InterfaceC1504a;

/* compiled from: CallStateUseCases.kt */
/* renamed from: s2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1525a extends J1.b {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1504a f36679b;

    /* renamed from: c, reason: collision with root package name */
    public final LiveData<Call> f36680c;

    /* renamed from: d, reason: collision with root package name */
    public final ObservableBoolean f36681d;

    /* renamed from: e, reason: collision with root package name */
    public final ObservableBoolean f36682e;

    /* renamed from: f, reason: collision with root package name */
    public final NonNullObservableField<InCallPresenter.InCallState> f36683f;

    /* renamed from: g, reason: collision with root package name */
    public final LiveData<Pair<Call, InCallPresenter.InCallState>> f36684g;

    /* renamed from: h, reason: collision with root package name */
    public final LocalObservableField<String> f36685h;

    /* renamed from: i, reason: collision with root package name */
    public final UseCase1<Boolean, q> f36686i;

    /* renamed from: j, reason: collision with root package name */
    public final UseCase0<q> f36687j;

    /* renamed from: k, reason: collision with root package name */
    public final UseCase0<q> f36688k;

    /* renamed from: l, reason: collision with root package name */
    public final com.android.incallui.clean.domain.interactor.f<Call, Integer, String, q> f36689l;

    /* renamed from: m, reason: collision with root package name */
    public final UseCase0<q> f36690m;

    /* renamed from: n, reason: collision with root package name */
    public final UseCase0<q> f36691n;

    /* renamed from: o, reason: collision with root package name */
    public final UseCase0<q> f36692o;

    /* renamed from: p, reason: collision with root package name */
    public final UseCase0<q> f36693p;

    /* compiled from: CallStateUseCases.kt */
    /* renamed from: s2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0352a extends UseCase1<Boolean, q> {
        public C0352a() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ q h(Boolean bool) {
            i(bool.booleanValue());
            return q.f35511a;
        }

        public void i(boolean z10) {
            C1525a.this.f36679b.K(z10);
        }
    }

    /* compiled from: CallStateUseCases.kt */
    /* renamed from: s2.a$b */
    /* loaded from: classes.dex */
    public static final class b extends UseCase0<q> {
        public b() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            C1525a.this.f36679b.p();
        }
    }

    /* compiled from: CallStateUseCases.kt */
    /* renamed from: s2.a$c */
    /* loaded from: classes.dex */
    public static final class c extends UseCase0<q> {
        public c() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            C1525a.this.f36679b.a();
        }
    }

    /* compiled from: CallStateUseCases.kt */
    /* renamed from: s2.a$d */
    /* loaded from: classes.dex */
    public static final class d extends UseCase0<q> {
        public d() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            C1525a.this.f36679b.e();
        }
    }

    /* compiled from: CallStateUseCases.kt */
    /* renamed from: s2.a$e */
    /* loaded from: classes.dex */
    public static final class e extends UseCase0<q> {
        public e() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            C1525a.this.f36679b.m();
        }
    }

    /* compiled from: CallStateUseCases.kt */
    /* renamed from: s2.a$f */
    /* loaded from: classes.dex */
    public static final class f extends UseCase0<q> {
        public f() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            C1525a.this.f36679b.i1();
        }
    }

    /* compiled from: CallStateUseCases.kt */
    /* renamed from: s2.a$g */
    /* loaded from: classes.dex */
    public static final class g extends com.android.incallui.clean.domain.interactor.f<Call, Integer, String, q> {
        public g() {
        }

        @Override // com.android.incallui.clean.domain.interactor.f
        public /* bridge */ /* synthetic */ q b(Call call, Integer num, String str) {
            c(call, num.intValue(), str);
            return q.f35511a;
        }

        public void c(Call p12, int i10, String p32) {
            i.f(p12, "p1");
            i.f(p32, "p3");
            C1525a.this.f36679b.d0(p12, i10, p32);
        }
    }

    /* compiled from: CallStateUseCases.kt */
    /* renamed from: s2.a$h */
    /* loaded from: classes.dex */
    public static final class h extends UseCase0<q> {
        public h() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            C1525a.this.f36679b.updateCallTime();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1525a(InterfaceC1504a repository) {
        super(repository);
        i.f(repository, "repository");
        this.f36679b = repository;
        this.f36680c = repository.W();
        this.f36681d = repository.g();
        this.f36682e = repository.X0();
        this.f36683f = repository.i();
        this.f36684g = repository.s1();
        this.f36685h = repository.R();
        this.f36686i = new C0352a();
        this.f36687j = new d();
        this.f36688k = new c();
        this.f36689l = new g();
        this.f36690m = new f();
        this.f36691n = new h();
        this.f36692o = new b();
        this.f36693p = new e();
    }

    public final UseCase1<Boolean, q> c() {
        return this.f36686i;
    }

    public final String d(Call call) {
        i.f(call, "call");
        return this.f36679b.x1(call);
    }

    public final NonNullObservableField<InCallPresenter.InCallState> e() {
        return this.f36683f;
    }

    public final LiveData<Pair<Call, InCallPresenter.InCallState>> f() {
        return this.f36684g;
    }

    public final LocalObservableField<String> g() {
        return this.f36685h;
    }

    public final UseCase0<q> h() {
        return this.f36692o;
    }

    public final UseCase0<q> i() {
        return this.f36688k;
    }

    public final LiveData<Call> j() {
        return this.f36680c;
    }

    public final UseCase0<q> k() {
        return this.f36687j;
    }

    public final String l(Call call) {
        return this.f36679b.h0(call);
    }

    public final String m() {
        return this.f36679b.l1();
    }

    public final Integer n() {
        return this.f36679b.v1();
    }

    public final Integer o(boolean z10) {
        return this.f36679b.h(z10);
    }

    public final Integer p() {
        return this.f36679b.q();
    }

    public final UseCase0<q> q() {
        return this.f36693p;
    }

    public final UseCase0<q> r() {
        return this.f36690m;
    }

    public final com.android.incallui.clean.domain.interactor.f<Call, Integer, String, q> s() {
        return this.f36689l;
    }

    public final UseCase0<q> t() {
        return this.f36691n;
    }

    public final boolean u() {
        return this.f36679b.d();
    }

    public final ObservableBoolean v() {
        return this.f36681d;
    }

    public final ObservableBoolean w() {
        return this.f36682e;
    }

    public final boolean x(Call call, InCallPresenter.InCallState inCallState) {
        return this.f36679b.u(call, inCallState);
    }

    public final boolean y(Call call, boolean z10, InCallPresenter.InCallState inCallState) {
        return this.f36679b.p1(call, z10, inCallState);
    }
}
