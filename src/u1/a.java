package U1;

import com.android.incallui.clean.domain.interactor.UseCase0;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: FoldConfigUseCases.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final UseCase0<Boolean> f3828a;

    /* renamed from: b, reason: collision with root package name */
    public final UseCase0<Boolean> f3829b;

    /* renamed from: c, reason: collision with root package name */
    public final UseCase0<q> f3830c;

    /* compiled from: FoldConfigUseCases.kt */
    /* renamed from: U1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0071a extends UseCase0<q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T1.a f3831a;

        public C0071a(T1.a aVar) {
            this.f3831a = aVar;
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            this.f3831a.collapseDragonflyPanels();
        }
    }

    /* compiled from: FoldConfigUseCases.kt */
    /* loaded from: classes.dex */
    public static final class b extends UseCase0<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T1.a f3832a;

        public b(T1.a aVar) {
            this.f3832a = aVar;
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean h() {
            return Boolean.valueOf(this.f3832a.R0());
        }
    }

    /* compiled from: FoldConfigUseCases.kt */
    /* loaded from: classes.dex */
    public static final class c extends UseCase0<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T1.a f3833a;

        public c(T1.a aVar) {
            this.f3833a = aVar;
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean h() {
            return Boolean.valueOf(this.f3833a.m1());
        }
    }

    public a(T1.a repository) {
        i.f(repository, "repository");
        this.f3828a = new b(repository);
        this.f3829b = new c(repository);
        this.f3830c = new C0071a(repository);
    }

    public final UseCase0<q> a() {
        return this.f3830c;
    }

    public final UseCase0<Boolean> b() {
        return this.f3828a;
    }
}
