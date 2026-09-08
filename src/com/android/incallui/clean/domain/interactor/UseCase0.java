package com.android.incallui.clean.domain.interactor;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;
import v9.l;

/* compiled from: UseCase.kt */
/* loaded from: classes.dex */
public abstract class UseCase0<R> extends g<R> {
    public UseCase0() {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(UseCase0 useCase0, Executor executor, l lVar, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                lVar = null;
            }
            useCase0.c(executor, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(UseCase0 useCase0, E e10, l lVar, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                lVar = null;
            }
            useCase0.d(e10, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
    }

    public static final void g(UseCase0 this$0, l lVar) {
        i.f(this$0, "this$0");
        Object h10 = this$0.h();
        if (lVar != null) {
            lVar.invoke(h10);
        }
    }

    public final R b() {
        return h();
    }

    public final void c(Executor executor, final l<? super R, q> lVar) {
        i.f(executor, "executor");
        executor.execute(new Runnable() { // from class: com.android.incallui.clean.domain.interactor.b
            @Override // java.lang.Runnable
            public final void run() {
                UseCase0.g(UseCase0.this, lVar);
            }
        });
    }

    public final void d(E scope, l<? super R, q> lVar) {
        i.f(scope, "scope");
        C1248i.d(scope, S.a(), null, new UseCase0$invoke$3(this, lVar, null), 2, null);
    }

    public abstract R h();
}
