package s2;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import com.android.incallui.Call;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.UseCase0;
import com.android.incallui.clean.domain.interactor.UseCase1;
import kotlin.jvm.internal.i;
import m9.q;
import r2.InterfaceC1505b;

/* compiled from: ContactInfoUseCases.kt */
/* renamed from: s2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1526b extends J1.b {

    /* renamed from: b, reason: collision with root package name */
    public final ObservableBoolean f36702b;

    /* renamed from: c, reason: collision with root package name */
    public final ObservableInt f36703c;

    /* renamed from: d, reason: collision with root package name */
    public final LocalObservableField<String> f36704d;

    /* renamed from: e, reason: collision with root package name */
    public final LocalObservableField<String> f36705e;

    /* renamed from: f, reason: collision with root package name */
    public final LocalObservableField<String> f36706f;

    /* renamed from: g, reason: collision with root package name */
    public final LocalObservableField<String> f36707g;

    /* renamed from: h, reason: collision with root package name */
    public final LocalObservableField<String> f36708h;

    /* renamed from: i, reason: collision with root package name */
    public final UseCase0<q> f36709i;

    /* renamed from: j, reason: collision with root package name */
    public final UseCase1<Call, q> f36710j;

    /* renamed from: k, reason: collision with root package name */
    public final UseCase0<q> f36711k;

    /* renamed from: l, reason: collision with root package name */
    public final com.android.incallui.clean.domain.interactor.e<String, Integer, q> f36712l;

    /* compiled from: ContactInfoUseCases.kt */
    /* renamed from: s2.b$a */
    /* loaded from: classes.dex */
    public static final class a extends UseCase0<q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1505b f36713a;

        public a(InterfaceC1505b interfaceC1505b) {
            this.f36713a = interfaceC1505b;
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            this.f36713a.N();
        }
    }

    /* compiled from: ContactInfoUseCases.kt */
    /* renamed from: s2.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0353b extends UseCase0<q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1505b f36714a;

        public C0353b(InterfaceC1505b interfaceC1505b) {
            this.f36714a = interfaceC1505b;
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            this.f36714a.y();
        }
    }

    /* compiled from: ContactInfoUseCases.kt */
    /* renamed from: s2.b$c */
    /* loaded from: classes.dex */
    public static final class c extends com.android.incallui.clean.domain.interactor.e<String, Integer, q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1505b f36715a;

        public c(InterfaceC1505b interfaceC1505b) {
            this.f36715a = interfaceC1505b;
        }

        @Override // com.android.incallui.clean.domain.interactor.e
        public /* bridge */ /* synthetic */ q f(String str, Integer num) {
            g(str, num);
            return q.f35511a;
        }

        public void g(String p12, Integer num) {
            i.f(p12, "p1");
            this.f36715a.q1(p12, num);
        }
    }

    /* compiled from: ContactInfoUseCases.kt */
    /* renamed from: s2.b$d */
    /* loaded from: classes.dex */
    public static final class d extends UseCase1<Call, q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1505b f36716a;

        public d(InterfaceC1505b interfaceC1505b) {
            this.f36716a = interfaceC1505b;
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ q h(Call call) {
            i(call);
            return q.f35511a;
        }

        public void i(Call call) {
            this.f36716a.Y(call);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1526b(InterfaceC1505b repository) {
        super(repository);
        i.f(repository, "repository");
        this.f36702b = repository.D();
        this.f36703c = repository.O0();
        this.f36704d = repository.w1();
        this.f36705e = repository.q0();
        this.f36706f = repository.M0();
        this.f36707g = repository.x();
        this.f36708h = repository.n1();
        this.f36709i = new a(repository);
        this.f36710j = new d(repository);
        this.f36711k = new C0353b(repository);
        this.f36712l = new c(repository);
    }

    public final UseCase0<q> b() {
        return this.f36709i;
    }

    public final ObservableBoolean c() {
        return this.f36702b;
    }

    public final ObservableInt d() {
        return this.f36703c;
    }

    public final LocalObservableField<String> e() {
        return this.f36707g;
    }

    public final LocalObservableField<String> f() {
        return this.f36704d;
    }

    public final LocalObservableField<String> g() {
        return this.f36708h;
    }

    public final UseCase0<q> h() {
        return this.f36711k;
    }

    public final LocalObservableField<String> i() {
        return this.f36705e;
    }

    public final LocalObservableField<String> j() {
        return this.f36706f;
    }

    public final com.android.incallui.clean.domain.interactor.e<String, Integer, q> k() {
        return this.f36712l;
    }

    public final UseCase1<Call, q> l() {
        return this.f36710j;
    }
}
