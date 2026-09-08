package com.oplus.foundation.appsupport.ui.widget.recyclerview.scrollmonitor;

import androidx.recyclerview.widget.RecyclerView;
import com.oplus.foundation.appsupport.ui.statemonitor.IdleStateMonitor;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.n;

/* compiled from: RecyclerViewScrollStateMonitor.kt */
/* loaded from: classes3.dex */
public class RecyclerViewScrollStateMonitor extends IdleStateMonitor {

    /* renamed from: c, reason: collision with root package name */
    public final E f28261c;

    /* renamed from: d, reason: collision with root package name */
    public final i<com.oplus.foundation.appsupport.ui.widget.recyclerview.scrollmonitor.a> f28262d;

    /* renamed from: e, reason: collision with root package name */
    public final a f28263e;

    /* compiled from: RecyclerViewScrollStateMonitor.kt */
    /* loaded from: classes3.dex */
    public static final class a extends RecyclerView.s {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            boolean z10;
            kotlin.jvm.internal.i.f(recyclerView, "recyclerView");
            RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor = RecyclerViewScrollStateMonitor.this;
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            recyclerViewScrollStateMonitor.g(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewScrollStateMonitor(E scope) {
        super(scope);
        kotlin.jvm.internal.i.f(scope, "scope");
        this.f28261c = scope;
        this.f28262d = n.a(new com.oplus.foundation.appsupport.ui.widget.recyclerview.scrollmonitor.a(true));
        this.f28263e = new a();
    }

    @Override // com.oplus.foundation.appsupport.ui.statemonitor.IdleStateMonitor
    public m<com.oplus.foundation.appsupport.ui.statemonitor.a> c() {
        return this.f28262d;
    }

    @Override // com.oplus.foundation.appsupport.ui.statemonitor.IdleStateMonitor
    public E d() {
        return this.f28261c;
    }

    public void g(boolean z10) {
        C1248i.d(d(), null, null, new RecyclerViewScrollStateMonitor$notifyScrollStateChange$1(this, z10, null), 3, null);
    }

    public final void h(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.f28263e);
        }
    }

    public final void i(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.f28263e);
        }
    }
}
