package com.oplus.foundation.appsupport.ui.statemonitor;

import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.m;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: IdleStateMonitor.kt */
/* loaded from: classes3.dex */
public abstract class IdleStateMonitor {

    /* renamed from: a, reason: collision with root package name */
    public final E f28207a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC1637a<q> f28208b;

    public IdleStateMonitor(E scope) {
        i.f(scope, "scope");
        this.f28207a = scope;
    }

    public abstract m<a> c();

    public abstract E d();

    public final void e(InterfaceC1637a<q> block) {
        i.f(block, "block");
        this.f28208b = block;
        C1248i.d(d(), null, null, new IdleStateMonitor$runWhenIdle$1(this, null), 3, null);
    }
}
