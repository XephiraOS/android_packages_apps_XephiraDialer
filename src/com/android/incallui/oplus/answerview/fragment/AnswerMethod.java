package com.android.incallui.oplus.answerview.fragment;

import O1.k;
import O1.m;
import O1.o;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.InterfaceC0485h;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.w;
import com.android.incallui.mvvm.utils.y;
import com.android.incallui.oplus.answerview.view_model.AnswerMethodModel;
import g2.InterfaceC1034a;
import g2.InterfaceC1035b;
import g2.InterfaceC1037d;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: AnswerMethod.kt */
/* loaded from: classes.dex */
public abstract class AnswerMethod extends Fragment implements InterfaceC1037d, InterfaceC1035b {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f18728a = new Runnable() { // from class: com.android.incallui.oplus.answerview.fragment.a
        @Override // java.lang.Runnable
        public final void run() {
            AnswerMethod.p1(AnswerMethod.this);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f18729b = new Runnable() { // from class: com.android.incallui.oplus.answerview.fragment.b
        @Override // java.lang.Runnable
        public final void run() {
            AnswerMethod.o1(AnswerMethod.this);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public o f18730c;

    /* renamed from: d, reason: collision with root package name */
    public k f18731d;

    /* renamed from: e, reason: collision with root package name */
    public m f18732e;

    public static final void n1(l tmp0, Object obj) {
        i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void o1(AnswerMethod this$0) {
        i.f(this$0, "this$0");
        this$0.m();
    }

    public static final void p1(AnswerMethod this$0) {
        i.f(this$0, "this$0");
        this$0.v0();
    }

    @Override // g2.InterfaceC1037d
    public void Q0(com.android.incallui.oplus.answerview.protocol.a aVar, int i10) {
        Context context = getContext();
        if (context != null && aVar != null) {
            aVar.a(context, l1(), i10);
        }
    }

    public abstract AnswerMethodModel h1();

    public final k i1() {
        k kVar = this.f18731d;
        if (kVar != null) {
            return kVar;
        }
        i.q("inCallFlingUpAnswerBinding");
        return null;
    }

    public final m j1() {
        m mVar = this.f18732e;
        if (mVar != null) {
            return mVar;
        }
        i.q("inCallRideModeAnswerBinding");
        return null;
    }

    public final o k1() {
        o oVar = this.f18730c;
        if (oVar != null) {
            return oVar;
        }
        i.q("inCallStaticAnswerBinding");
        return null;
    }

    public final InterfaceC1034a l1() {
        InterfaceC0485h parentFragment = getParentFragment();
        if (parentFragment instanceof InterfaceC1034a) {
            return (InterfaceC1034a) parentFragment;
        }
        return null;
    }

    public final void m1() {
        y<Boolean> i10 = h1().i();
        InterfaceC0492o viewLifecycleOwner = getViewLifecycleOwner();
        final l<Boolean, q> lVar = new l<Boolean, q>() { // from class: com.android.incallui.oplus.answerview.fragment.AnswerMethod$initViewModelObserver$1
            {
                super(1);
            }

            public final void b(Boolean bool) {
                View view;
                Runnable runnable;
                Runnable runnable2;
                Runnable runnable3;
                Runnable runnable4;
                View view2 = AnswerMethod.this.getView();
                if (view2 != null) {
                    runnable4 = AnswerMethod.this.f18728a;
                    view2.removeCallbacks(runnable4);
                }
                View view3 = AnswerMethod.this.getView();
                if (view3 != null) {
                    runnable3 = AnswerMethod.this.f18729b;
                    view3.removeCallbacks(runnable3);
                }
                if (i.b(bool, Boolean.TRUE)) {
                    View view4 = AnswerMethod.this.getView();
                    if (view4 != null) {
                        runnable2 = AnswerMethod.this.f18728a;
                        view4.post(runnable2);
                        return;
                    }
                    return;
                }
                if (i.b(bool, Boolean.FALSE) && (view = AnswerMethod.this.getView()) != null) {
                    runnable = AnswerMethod.this.f18729b;
                    view.post(runnable);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                b(bool);
                return q.f35511a;
            }
        };
        i10.i(viewLifecycleOwner, new w() { // from class: com.android.incallui.oplus.answerview.fragment.c
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                AnswerMethod.n1(l.this, obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        m1();
    }

    public final void q1(k kVar) {
        i.f(kVar, "<set-?>");
        this.f18731d = kVar;
    }

    public final void r1(m mVar) {
        i.f(mVar, "<set-?>");
        this.f18732e = mVar;
    }

    public final void s1(o oVar) {
        i.f(oVar, "<set-?>");
        this.f18730c = oVar;
    }
}
