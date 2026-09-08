package J1;

import com.android.incallui.clean.domain.interactor.UseCase0;
import kotlin.jvm.internal.i;

/* compiled from: CallInfoUseCases.kt */
/* loaded from: classes.dex */
public final class c extends J1.b {

    /* renamed from: b, reason: collision with root package name */
    public final I1.a f1500b;

    /* renamed from: c, reason: collision with root package name */
    public final I1.a f1501c;

    /* compiled from: CallInfoUseCases.kt */
    /* loaded from: classes.dex */
    public static final class a extends UseCase0<H1.g<H1.a>> {
        public a() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public H1.g<H1.a> h() {
            return c.this.f1500b.a();
        }
    }

    /* compiled from: CallInfoUseCases.kt */
    /* loaded from: classes.dex */
    public static final class b extends UseCase0<H1.g<H1.a>> {
        public b() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public H1.g<H1.a> h() {
            return c.this.f1501c.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(I1.a primaryCallRepository, I1.a secondaryCallRepository) {
        super(null, 1, 0 == true ? 1 : 0);
        i.f(primaryCallRepository, "primaryCallRepository");
        i.f(secondaryCallRepository, "secondaryCallRepository");
        this.f1500b = primaryCallRepository;
        this.f1501c = secondaryCallRepository;
    }

    public final UseCase0<H1.g<H1.a>> d() {
        return new a();
    }

    public final UseCase0<H1.g<H1.a>> e() {
        return new b();
    }
}
