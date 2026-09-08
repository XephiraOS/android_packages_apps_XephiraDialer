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
public abstract class UseCase1<P1, R> extends g<R> {
    public UseCase1() {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(UseCase1 useCase1, Object obj, Executor executor, l lVar, int i10, Object obj2) {
        if (obj2 == null) {
            if ((i10 & 4) != 0) {
                lVar = null;
            }
            useCase1.c(obj, executor, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(UseCase1 useCase1, Object obj, E e10, l lVar, int i10, Object obj2) {
        if (obj2 == null) {
            if ((i10 & 4) != 0) {
                lVar = null;
            }
            useCase1.d(obj, e10, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(UseCase1 this$0, Object obj, l lVar) {
        i.f(this$0, "this$0");
        Object h10 = this$0.h(obj);
        if (lVar != 0) {
            lVar.invoke(h10);
        }
    }

    public final R b(P1 p12) {
        return h(p12);
    }

    public final void c(final P1 p12, Executor executor, final l<? super R, q> lVar) {
        i.f(executor, "executor");
        executor.execute(new Runnable() { // from class: com.android.incallui.clean.domain.interactor.c
            @Override // java.lang.Runnable
            public final void run() {
                UseCase1.g(UseCase1.this, p12, lVar);
            }
        });
    }

    public final void d(P1 p12, E scope, l<? super R, q> lVar) {
        i.f(scope, "scope");
        C1248i.d(scope, S.a(), null, new UseCase1$invoke$3(this, p12, lVar, null), 2, null);
    }

    public abstract R h(P1 p12);
}
