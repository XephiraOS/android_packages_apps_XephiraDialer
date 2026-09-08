package com.android.incallui.oplus.incomingfloatingwindow.presentation.utils;

import android.view.View;
import kotlin.jvm.internal.i;
import m9.q;
import q2.C1481a;
import v9.l;

/* compiled from: FloatingWindowGestureDetector.kt */
/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: h, reason: collision with root package name */
    public final l<Integer, q> f18927h;

    /* renamed from: i, reason: collision with root package name */
    public final Runnable f18928i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(View layout, boolean z10, final q2.c cVar, l<? super Integer, q> singleTapAction) {
        super(layout, z10, cVar);
        i.f(layout, "layout");
        i.f(singleTapAction, "singleTapAction");
        this.f18927h = singleTapAction;
        this.f18928i = new Runnable() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                b.k(q2.c.this);
            }
        };
    }

    public static final void k(q2.c cVar) {
        if (cVar != null) {
            cVar.f(new C1481a(2));
        }
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.d
    public Runnable f() {
        return this.f18928i;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.d
    public l<Integer, q> g() {
        return this.f18927h;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.d
    public boolean h(float f10) {
        if (f10 > 0.0f) {
            return true;
        }
        return false;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.d
    public boolean i(float f10) {
        if (f10 > 0.0f) {
            return true;
        }
        return false;
    }
}
