package J1;

import androidx.lifecycle.LiveData;
import kotlin.jvm.internal.i;

/* compiled from: ConfigUseCases.kt */
/* loaded from: classes.dex */
public final class f extends b {

    /* renamed from: b, reason: collision with root package name */
    public final LiveData<Boolean> f1562b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(I1.d repository) {
        super(repository);
        i.f(repository, "repository");
        this.f1562b = repository.L0();
    }

    public final LiveData<Boolean> b() {
        return this.f1562b;
    }
}
