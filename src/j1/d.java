package J1;

import com.android.incallui.clean.domain.interactor.UseCase0;
import kotlin.jvm.internal.i;

/* compiled from: CallStateUseCases.kt */
/* loaded from: classes.dex */
public final class d extends J1.b {

    /* renamed from: b, reason: collision with root package name */
    public final I1.a f1504b;

    /* renamed from: c, reason: collision with root package name */
    public final I1.a f1505c;

    /* compiled from: CallStateUseCases.kt */
    /* loaded from: classes.dex */
    public static final class a extends UseCase0<H1.g<H1.b>> {
        public a() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public H1.g<H1.b> h() {
            return d.this.f1504b.b();
        }
    }

    /* compiled from: CallStateUseCases.kt */
    /* loaded from: classes.dex */
    public static final class b extends UseCase0<H1.g<H1.b>> {
        public b() {
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public H1.g<H1.b> h() {
            return d.this.f1505c.b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(I1.a primaryCallRepository, I1.a secondaryCallRepository) {
        super(null, 1, 0 == true ? 1 : 0);
        i.f(primaryCallRepository, "primaryCallRepository");
        i.f(secondaryCallRepository, "secondaryCallRepository");
        this.f1504b = primaryCallRepository;
        this.f1505c = secondaryCallRepository;
    }

    public final UseCase0<H1.g<H1.b>> d() {
        return new a();
    }

    public final UseCase0<H1.g<H1.b>> e() {
        return new b();
    }
}
