package com.android.incallui.oplus.answerview.fragment;

import O1.k;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.K;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.FlingUpAnswerMethodLayout;
import com.android.incallui.oplus.answerview.view_model.AnswerMethodModel;
import com.android.incallui.oplus.answerview.view_model.FlingUpAnswerMethodModel;
import g2.InterfaceC1035b;
import g2.InterfaceC1036c;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: FlingUpAnswerMethod.kt */
/* loaded from: classes.dex */
public final class FlingUpAnswerMethod extends AnswerMethod {

    /* renamed from: g, reason: collision with root package name */
    public static final a f18733g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public final m9.d f18734f;

    /* compiled from: FlingUpAnswerMethod.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public FlingUpAnswerMethod() {
        m9.d a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<FlingUpAnswerMethodModel>() { // from class: com.android.incallui.oplus.answerview.fragment.FlingUpAnswerMethod$mFlingUpAnswerMethodModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final FlingUpAnswerMethodModel invoke() {
                return (FlingUpAnswerMethodModel) new K(FlingUpAnswerMethod.this).a(FlingUpAnswerMethodModel.class);
            }
        });
        this.f18734f = a10;
    }

    @Override // com.android.incallui.oplus.answerview.fragment.AnswerMethod
    public AnswerMethodModel h1() {
        return t1();
    }

    @Override // g2.InterfaceC1035b
    public void m() {
        Log.d("FlingUpAnswerMethod", "onHideAnswerView: ");
        FlingUpAnswerMethodLayout flingUpAnswerMethodLayout = i1().f2582G;
        if (!(flingUpAnswerMethodLayout instanceof InterfaceC1035b)) {
            flingUpAnswerMethodLayout = null;
        }
        if (flingUpAnswerMethodLayout != null) {
            flingUpAnswerMethodLayout.m();
        }
        FlingUpAnswerMethodLayout flingUpAnswerMethodLayout2 = i1().f2582G;
        if (!(flingUpAnswerMethodLayout2 instanceof InterfaceC1036c)) {
            flingUpAnswerMethodLayout2 = null;
        }
        if (flingUpAnswerMethodLayout2 != null) {
            flingUpAnswerMethodLayout2.setTriggerEventListener(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.incall_fling_up_answer_method, viewGroup, false);
        k i12 = k.i1(inflate);
        i12.k1(t1());
        i12.b1(getViewLifecycleOwner());
        i.e(i12, "bind(it).apply {\n       …ecycleOwner\n            }");
        q1(i12);
        return inflate;
    }

    public final FlingUpAnswerMethodModel t1() {
        return (FlingUpAnswerMethodModel) this.f18734f.getValue();
    }

    @Override // g2.InterfaceC1035b
    public void v0() {
        Log.d("FlingUpAnswerMethod", "onDisplayAnswerView: ");
        FlingUpAnswerMethodLayout flingUpAnswerMethodLayout = i1().f2582G;
        FlingUpAnswerMethodLayout flingUpAnswerMethodLayout2 = null;
        if (!(flingUpAnswerMethodLayout instanceof InterfaceC1036c)) {
            flingUpAnswerMethodLayout = null;
        }
        if (flingUpAnswerMethodLayout != null) {
            flingUpAnswerMethodLayout.setTriggerEventListener(this);
        }
        FlingUpAnswerMethodLayout flingUpAnswerMethodLayout3 = i1().f2582G;
        if (flingUpAnswerMethodLayout3 instanceof InterfaceC1035b) {
            flingUpAnswerMethodLayout2 = flingUpAnswerMethodLayout3;
        }
        if (flingUpAnswerMethodLayout2 != null) {
            flingUpAnswerMethodLayout2.v0();
        }
    }
}
