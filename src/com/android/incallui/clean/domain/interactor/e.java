package com.android.incallui.clean.domain.interactor;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: UseCase.kt */
/* loaded from: classes.dex */
public abstract class e<P1, P2, R> extends g<R> {
    public e() {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(e eVar, Object obj, Object obj2, Executor executor, l lVar, int i10, Object obj3) {
        if (obj3 == null) {
            if ((i10 & 8) != 0) {
                lVar = null;
            }
            eVar.c(obj, obj2, executor, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(e this$0, Object obj, Object obj2, l lVar) {
        i.f(this$0, "this$0");
        Object f10 = this$0.f(obj, obj2);
        if (lVar != 0) {
            lVar.invoke(f10);
        }
    }

    public final R b(P1 p12, P2 p22) {
        return f(p12, p22);
    }

    public final void c(final P1 p12, final P2 p22, Executor executor, final l<? super R, q> lVar) {
        i.f(executor, "executor");
        executor.execute(new Runnable() { // from class: com.android.incallui.clean.domain.interactor.d
            @Override // java.lang.Runnable
            public final void run() {
                e.e(e.this, p12, p22, lVar);
            }
        });
    }

    public abstract R f(P1 p12, P2 p22);
}
