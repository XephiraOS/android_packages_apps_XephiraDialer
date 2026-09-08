package com.oplus.foundation.appsupport.lifecycle;

import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.p;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.flow.a;
import m9.q;
import v9.l;

/* compiled from: FlowExt.kt */
/* loaded from: classes3.dex */
public final class FlowExtKt {
    public static final <V> void a(a<? extends V> aVar, InterfaceC0492o lifecycleOwner, Lifecycle.State state, l<? super V, q> block) {
        i.f(aVar, "<this>");
        i.f(lifecycleOwner, "lifecycleOwner");
        i.f(state, "state");
        i.f(block, "block");
        C1248i.d(p.a(lifecycleOwner), null, null, new FlowExtKt$observe$2(lifecycleOwner, state, aVar, block, null), 3, null);
    }

    public static /* synthetic */ void b(a aVar, InterfaceC0492o interfaceC0492o, Lifecycle.State state, l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        a(aVar, interfaceC0492o, state, lVar);
    }

    public static final <V> void c(a<? extends V> aVar, InterfaceC0492o lifecycleOwner, l<? super V, q> block) {
        i.f(aVar, "<this>");
        i.f(lifecycleOwner, "lifecycleOwner");
        i.f(block, "block");
        C1248i.d(p.a(lifecycleOwner), null, null, new FlowExtKt$observeWhenStarted$1(lifecycleOwner, aVar, block, null), 3, null);
    }
}
