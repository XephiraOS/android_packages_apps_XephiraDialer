package androidx.lifecycle;

import kotlinx.coroutines.G0;
import kotlinx.coroutines.S;

/* compiled from: ViewModel.kt */
/* loaded from: classes.dex */
public final class J {
    public static final kotlinx.coroutines.E a(I i10) {
        kotlin.jvm.internal.i.f(i10, "<this>");
        kotlinx.coroutines.E e10 = (kotlinx.coroutines.E) i10.d("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (e10 != null) {
            return e10;
        }
        Object f10 = i10.f("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new C0479b(G0.b(null, 1, null).r(S.c().i0())));
        kotlin.jvm.internal.i.e(f10, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (kotlinx.coroutines.E) f10;
    }
}
