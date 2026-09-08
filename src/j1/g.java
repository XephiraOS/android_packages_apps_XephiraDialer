package J1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import com.android.incallui.InCallPresenter;
import com.android.incallui.clean.domain.bean.CallUiType;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.clean.domain.interactor.UseCase0;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: UIUseCases.kt */
/* loaded from: classes.dex */
public final class g extends J1.b {

    /* renamed from: b, reason: collision with root package name */
    public final I1.e f1563b;

    /* renamed from: c, reason: collision with root package name */
    public final NonNullObservableField<CallUiType> f1564c;

    /* renamed from: d, reason: collision with root package name */
    public final LiveData<InCallPresenter.InCallState> f1565d;

    /* renamed from: e, reason: collision with root package name */
    public final v<Boolean> f1566e;

    /* renamed from: f, reason: collision with root package name */
    public final UseCase0<q> f1567f;

    /* renamed from: g, reason: collision with root package name */
    public final UseCase0<q> f1568g;

    /* renamed from: h, reason: collision with root package name */
    public final UseCase0<q> f1569h;

    /* renamed from: i, reason: collision with root package name */
    public final UseCase0<q> f1570i;

    /* compiled from: UIUseCases.kt */
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
            g.this.f1563b.U0();
        }
    }

    /* compiled from: UIUseCases.kt */
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
            g.this.f1563b.S0();
        }
    }

    /* compiled from: UIUseCases.kt */
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
            g.this.f1563b.B0();
        }
    }

    /* compiled from: UIUseCases.kt */
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
            g.this.f1563b.F0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(I1.e repository) {
        super(repository);
        i.f(repository, "repository");
        this.f1563b = repository;
        this.f1564c = repository.Q();
        this.f1565d = repository.i();
        this.f1566e = repository.U();
        this.f1567f = new c();
        this.f1568g = new b();
        this.f1569h = new d();
        this.f1570i = new a();
    }

    public final LiveData<InCallPresenter.InCallState> c() {
        return this.f1565d;
    }

    public final NonNullObservableField<CallUiType> d() {
        return this.f1564c;
    }

    public final UseCase0<q> e() {
        return this.f1570i;
    }

    public final UseCase0<q> f() {
        return this.f1568g;
    }

    public final UseCase0<q> g() {
        return this.f1567f;
    }

    public final UseCase0<q> h() {
        return this.f1569h;
    }

    public final v<Boolean> i() {
        return this.f1566e;
    }
}
