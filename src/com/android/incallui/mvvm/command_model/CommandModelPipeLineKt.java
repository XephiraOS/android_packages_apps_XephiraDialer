package com.android.incallui.mvvm.command_model;

import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.F;
import kotlinx.coroutines.S;
import v9.InterfaceC1637a;
import v9.l;

/* compiled from: CommandModelPipeLine.kt */
/* loaded from: classes.dex */
public final class CommandModelPipeLineKt {
    public static final <R, F extends InterfaceC1637a<? extends R>> void a(F f10, CoroutineDispatcher dispatcher) {
        i.f(f10, "<this>");
        i.f(dispatcher, "dispatcher");
        C1248i.d(F.a(dispatcher), null, null, new CommandModelPipeLineKt$coroutineInvoke$1(f10, null), 3, null);
    }

    public static final <P1, R, F extends l<? super P1, ? extends R>> void b(F f10, P1 p12, CoroutineDispatcher dispatcher) {
        i.f(f10, "<this>");
        i.f(dispatcher, "dispatcher");
        C1248i.d(F.a(dispatcher), null, null, new CommandModelPipeLineKt$coroutineInvoke$2(f10, p12, null), 3, null);
    }

    public static /* synthetic */ void c(InterfaceC1637a interfaceC1637a, CoroutineDispatcher coroutineDispatcher, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineDispatcher = S.c();
        }
        a(interfaceC1637a, coroutineDispatcher);
    }

    public static /* synthetic */ void d(l lVar, Object obj, CoroutineDispatcher coroutineDispatcher, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            coroutineDispatcher = S.c();
        }
        b(lVar, obj, coroutineDispatcher);
    }
}
