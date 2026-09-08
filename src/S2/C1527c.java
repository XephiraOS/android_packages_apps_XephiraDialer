package s2;

import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.UseCase0;
import com.android.incallui.clean.domain.interactor.UseCase1;
import kotlin.jvm.internal.i;
import m9.q;
import r2.InterfaceC1506c;

/* compiled from: NavigationUseCases.kt */
/* renamed from: s2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1527c extends J1.b {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1506c f36717b;

    /* renamed from: c, reason: collision with root package name */
    public final LocalObservableField<Integer> f36718c;

    /* renamed from: d, reason: collision with root package name */
    public final UseCase1<Integer, q> f36719d;

    /* renamed from: e, reason: collision with root package name */
    public final UseCase0<q> f36720e;

    /* renamed from: f, reason: collision with root package name */
    public final UseCase0<q> f36721f;

    /* renamed from: g, reason: collision with root package name */
    public final UseCase1<InCallPresenter.InCallState, q> f36722g;

    /* renamed from: h, reason: collision with root package name */
    public final UseCase0<q> f36723h;

    /* renamed from: i, reason: collision with root package name */
    public final UseCase0<q> f36724i;

    /* renamed from: j, reason: collision with root package name */
    public final UseCase1<Call, q> f36725j;

    /* renamed from: k, reason: collision with root package name */
    public final UseCase0<q> f36726k;

    /* compiled from: NavigationUseCases.kt */
    /* renamed from: s2.c$a */
    /* loaded from: classes.dex */
    public static final class a extends UseCase0<q> {
        public a() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            C1527c.this.f36717b.t1();
        }
    }

    /* compiled from: NavigationUseCases.kt */
    /* renamed from: s2.c$b */
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
            C1527c.this.f36717b.t0();
        }
    }

    /* compiled from: NavigationUseCases.kt */
    /* renamed from: s2.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0354c extends UseCase0<q> {
        public C0354c() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            C1527c.this.f36717b.w0(null);
        }
    }

    /* compiled from: NavigationUseCases.kt */
    /* renamed from: s2.c$d */
    /* loaded from: classes.dex */
    public static final class d extends UseCase1<Integer, q> {
        public d() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ q h(Integer num) {
            i(num.intValue());
            return q.f35511a;
        }

        public void i(int i10) {
            C1527c.this.f36717b.w0(Integer.valueOf(i10));
        }
    }

    /* compiled from: NavigationUseCases.kt */
    /* renamed from: s2.c$e */
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
            C1527c.this.f36717b.V0();
        }
    }

    /* compiled from: NavigationUseCases.kt */
    /* renamed from: s2.c$f */
    /* loaded from: classes.dex */
    public static final class f extends UseCase1<InCallPresenter.InCallState, q> {
        public f() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ q h(InCallPresenter.InCallState inCallState) {
            i(inCallState);
            return q.f35511a;
        }

        public void i(InCallPresenter.InCallState p12) {
            i.f(p12, "p1");
            C1527c.this.f36717b.d1(p12);
        }
    }

    /* compiled from: NavigationUseCases.kt */
    /* renamed from: s2.c$g */
    /* loaded from: classes.dex */
    public static final class g extends UseCase1<Call, q> {
        public g() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ q h(Call call) {
            i(call);
            return q.f35511a;
        }

        public void i(Call p12) {
            i.f(p12, "p1");
            C1527c.this.f36717b.i0(p12);
        }
    }

    /* compiled from: NavigationUseCases.kt */
    /* renamed from: s2.c$h */
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
            C1527c.this.f36717b.K0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1527c(InterfaceC1506c repository) {
        super(repository);
        i.f(repository, "repository");
        this.f36717b = repository;
        this.f36718c = repository.W0();
        this.f36719d = new d();
        this.f36720e = new C0354c();
        this.f36721f = new b();
        this.f36722g = new f();
        this.f36723h = new h();
        this.f36724i = new e();
        this.f36725j = new g();
        this.f36726k = new a();
    }

    public final void c() {
        InterfaceC1506c.a.a(this.f36717b, false, 1, null);
    }

    public final void d() {
        InterfaceC1506c.a.b(this.f36717b, false, 1, null);
    }

    public final UseCase0<q> e() {
        return this.f36726k;
    }

    public final UseCase0<q> f() {
        return this.f36721f;
    }

    public final UseCase0<q> g() {
        return this.f36720e;
    }

    public final UseCase1<Integer, q> h() {
        return this.f36719d;
    }

    public final UseCase0<q> i() {
        return this.f36724i;
    }

    public final UseCase1<InCallPresenter.InCallState, q> j() {
        return this.f36722g;
    }

    public final UseCase1<Call, q> k() {
        return this.f36725j;
    }

    public final UseCase0<q> l() {
        return this.f36723h;
    }

    public final LocalObservableField<Integer> m() {
        return this.f36718c;
    }

    public final boolean n() {
        return this.f36717b.V();
    }

    public final boolean o() {
        return this.f36717b.I0();
    }

    public final boolean p(Integer num, boolean z10) {
        return this.f36717b.g0(num, z10);
    }

    public final boolean q() {
        return this.f36717b.r0();
    }

    public final boolean r() {
        return this.f36717b.w();
    }

    public final boolean s() {
        return this.f36717b.x0();
    }
}
