package J1;

import android.telecom.CallAudioState;
import androidx.lifecycle.LiveData;
import com.android.incallui.Call;
import com.android.incallui.clean.domain.interactor.UseCase0;
import com.android.incallui.clean.domain.interactor.UseCase1;
import m9.q;

/* compiled from: AudioUseCases.kt */
/* loaded from: classes.dex */
public final class a extends J1.b {

    /* renamed from: b, reason: collision with root package name */
    public final I1.b f1473b;

    /* renamed from: c, reason: collision with root package name */
    public final LiveData<CallAudioState> f1474c;

    /* renamed from: d, reason: collision with root package name */
    public final UseCase1<Integer, Boolean> f1475d;

    /* renamed from: e, reason: collision with root package name */
    public final UseCase1<Integer, Boolean> f1476e;

    /* renamed from: f, reason: collision with root package name */
    public final UseCase1<Integer, Boolean> f1477f;

    /* renamed from: g, reason: collision with root package name */
    public final UseCase1<CallAudioState, Boolean> f1478g;

    /* renamed from: h, reason: collision with root package name */
    public final LiveData<Boolean> f1479h;

    /* renamed from: i, reason: collision with root package name */
    public final UseCase0<Integer> f1480i;

    /* renamed from: j, reason: collision with root package name */
    public final UseCase0<Boolean> f1481j;

    /* renamed from: k, reason: collision with root package name */
    public final UseCase0<q> f1482k;

    /* renamed from: l, reason: collision with root package name */
    public final UseCase0<q> f1483l;

    /* renamed from: m, reason: collision with root package name */
    public final com.android.incallui.clean.domain.interactor.e<Call, Boolean, q> f1484m;

    /* renamed from: n, reason: collision with root package name */
    public final UseCase0<q> f1485n;

    /* renamed from: o, reason: collision with root package name */
    public final UseCase1<Integer, q> f1486o;

    /* compiled from: AudioUseCases.kt */
    /* renamed from: J1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0032a extends com.android.incallui.clean.domain.interactor.e<Call, Boolean, q> {
        public C0032a() {
        }

        @Override // com.android.incallui.clean.domain.interactor.e
        public /* bridge */ /* synthetic */ q f(Call call, Boolean bool) {
            g(call, bool.booleanValue());
            return q.f35511a;
        }

        public void g(Call p12, boolean z10) {
            kotlin.jvm.internal.i.f(p12, "p1");
            a.this.f1473b.k(p12, z10);
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class b extends UseCase1<Integer, q> {
        public b() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ q h(Integer num) {
            i(num);
            return q.f35511a;
        }

        public void i(Integer num) {
            a.this.f1473b.D0(num);
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class c extends UseCase0<Integer> {
        public c() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer h() {
            return Integer.valueOf(a.this.f1473b.g1());
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class d extends UseCase1<Integer, Boolean> {
        public d() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ Boolean h(Integer num) {
            return i(num.intValue());
        }

        public Boolean i(int i10) {
            return Boolean.valueOf(a.this.f1473b.s0(i10));
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class e extends UseCase1<Integer, Boolean> {
        public e() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ Boolean h(Integer num) {
            return i(num.intValue());
        }

        public Boolean i(int i10) {
            return Boolean.valueOf(a.this.f1473b.F(i10));
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class f extends UseCase1<Integer, Boolean> {
        public f() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ Boolean h(Integer num) {
            return i(num.intValue());
        }

        public Boolean i(int i10) {
            return Boolean.valueOf(a.this.f1473b.l0(i10));
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class g extends UseCase0<Boolean> {
        public g() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean h() {
            return Boolean.valueOf(a.this.f1473b.p0());
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class h extends UseCase1<CallAudioState, Boolean> {
        public h() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean h(CallAudioState callAudioState) {
            return Boolean.valueOf(a.this.f1473b.u1(callAudioState));
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class i extends UseCase0<q> {
        public i() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            a.this.f1473b.b();
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class j extends UseCase0<q> {
        public j() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            a.this.f1473b.c();
        }
    }

    /* compiled from: AudioUseCases.kt */
    /* loaded from: classes.dex */
    public static final class k extends UseCase0<q> {
        public k() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            a.this.f1473b.j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(I1.b repository) {
        super(repository);
        kotlin.jvm.internal.i.f(repository, "repository");
        this.f1473b = repository;
        this.f1474c = repository.b1();
        this.f1475d = new f();
        this.f1476e = new d();
        this.f1477f = new e();
        this.f1478g = new h();
        this.f1479h = repository.z();
        this.f1480i = new c();
        this.f1481j = new g();
        this.f1482k = new k();
        this.f1483l = new j();
        this.f1484m = new C0032a();
        this.f1485n = new i();
        this.f1486o = new b();
    }

    public final com.android.incallui.clean.domain.interactor.e<Call, Boolean, q> c() {
        return this.f1484m;
    }

    public final LiveData<CallAudioState> d() {
        return this.f1474c;
    }

    public final UseCase1<Integer, q> e() {
        return this.f1486o;
    }

    public final UseCase0<Integer> f() {
        return this.f1480i;
    }

    public final UseCase0<q> g() {
        return this.f1485n;
    }

    public final UseCase0<q> h() {
        return this.f1483l;
    }

    public final UseCase0<q> i() {
        return this.f1482k;
    }

    public final UseCase1<Integer, Boolean> j() {
        return this.f1476e;
    }

    public final UseCase1<Integer, Boolean> k() {
        return this.f1477f;
    }

    public final UseCase1<Integer, Boolean> l() {
        return this.f1475d;
    }

    public final UseCase0<Boolean> m() {
        return this.f1481j;
    }

    public final LiveData<Boolean> n() {
        return this.f1479h;
    }

    public final UseCase1<CallAudioState, Boolean> o() {
        return this.f1478g;
    }
}
