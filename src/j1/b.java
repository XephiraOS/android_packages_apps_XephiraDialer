package J1;

import com.android.incallui.clean.domain.interactor.UseCase0;
import d2.InterfaceC0949b;
import m9.q;

/* compiled from: BaseUseCases.kt */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final UseCase0<q> f1498a;

    /* compiled from: BaseUseCases.kt */
    /* loaded from: classes.dex */
    public static final class a extends UseCase0<q> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0949b f1499a;

        public a(InterfaceC0949b interfaceC0949b) {
            this.f1499a = interfaceC0949b;
        }

        @Override // com.android.incallui.clean.domain.interactor.UseCase0
        public /* bridge */ /* synthetic */ q h() {
            i();
            return q.f35511a;
        }

        public void i() {
            InterfaceC0949b interfaceC0949b = this.f1499a;
            if (interfaceC0949b != null) {
                interfaceC0949b.f();
            }
        }
    }

    public b(InterfaceC0949b interfaceC0949b) {
        this.f1498a = new a(interfaceC0949b);
    }

    public final UseCase0<q> a() {
        return this.f1498a;
    }

    public /* synthetic */ b(InterfaceC0949b interfaceC0949b, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? null : interfaceC0949b);
    }
}
