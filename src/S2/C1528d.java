package s2;

import com.android.incallui.clean.domain.interactor.UseCase1;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: StatisticsUseCases.kt */
/* renamed from: s2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1528d extends J1.b {

    /* renamed from: b, reason: collision with root package name */
    public final UseCase1<Integer, q> f36735b;

    /* renamed from: c, reason: collision with root package name */
    public final com.android.incallui.clean.domain.interactor.e<Integer, Boolean, q> f36736c;

    /* renamed from: d, reason: collision with root package name */
    public final com.android.incallui.clean.domain.interactor.e<Integer, Integer, q> f36737d;

    /* renamed from: e, reason: collision with root package name */
    public final UseCase1<Integer, q> f36738e;

    /* compiled from: StatisticsUseCases.kt */
    /* renamed from: s2.d$a */
    /* loaded from: classes.dex */
    public static final class a extends com.android.incallui.clean.domain.interactor.e<Integer, Boolean, q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r2.d f36739a;

        public a(r2.d dVar) {
            this.f36739a = dVar;
        }

        @Override // com.android.incallui.clean.domain.interactor.e
        public /* bridge */ /* synthetic */ q f(Integer num, Boolean bool) {
            g(num, bool.booleanValue());
            return q.f35511a;
        }

        public void g(Integer num, boolean z10) {
            this.f36739a.f0(num, z10);
        }
    }

    /* compiled from: StatisticsUseCases.kt */
    /* renamed from: s2.d$b */
    /* loaded from: classes.dex */
    public static final class b extends UseCase1<Integer, q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r2.d f36740a;

        public b(r2.d dVar) {
            this.f36740a = dVar;
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ q h(Integer num) {
            i(num.intValue());
            return q.f35511a;
        }

        public void i(int i10) {
            this.f36740a.s(i10);
        }
    }

    /* compiled from: StatisticsUseCases.kt */
    /* renamed from: s2.d$c */
    /* loaded from: classes.dex */
    public static final class c extends UseCase1<Integer, q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r2.d f36741a;

        public c(r2.d dVar) {
            this.f36741a = dVar;
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase1
        public /* bridge */ /* synthetic */ q h(Integer num) {
            i(num);
            return q.f35511a;
        }

        public void i(Integer num) {
            this.f36741a.c1(num);
        }
    }

    /* compiled from: StatisticsUseCases.kt */
    /* renamed from: s2.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0355d extends com.android.incallui.clean.domain.interactor.e<Integer, Integer, q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r2.d f36742a;

        public C0355d(r2.d dVar) {
            this.f36742a = dVar;
        }

        @Override // com.android.incallui.clean.domain.interactor.e
        public /* bridge */ /* synthetic */ q f(Integer num, Integer num2) {
            g(num, num2.intValue());
            return q.f35511a;
        }

        public void g(Integer num, int i10) {
            this.f36742a.n(num, i10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1528d(r2.d repository) {
        super(repository);
        i.f(repository, "repository");
        this.f36735b = new b(repository);
        this.f36736c = new a(repository);
        this.f36737d = new C0355d(repository);
        this.f36738e = new c(repository);
    }

    public final com.android.incallui.clean.domain.interactor.e<Integer, Boolean, q> b() {
        return this.f36736c;
    }

    public final UseCase1<Integer, q> c() {
        return this.f36735b;
    }

    public final UseCase1<Integer, q> d() {
        return this.f36738e;
    }

    public final com.android.incallui.clean.domain.interactor.e<Integer, Integer, q> e() {
        return this.f36737d;
    }
}
