package com.android.incallui.oplus.answerview.fragment;

import O1.o;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.K;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.StaticAnswerMethodLayout;
import com.android.incallui.oplus.answerview.view_model.AnswerMethodModel;
import com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel;
import g2.InterfaceC1035b;
import g2.InterfaceC1036c;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: StaticAnswerMethod.kt */
/* loaded from: classes.dex */
public final class StaticAnswerMethod extends AnswerMethod {

    /* renamed from: g, reason: collision with root package name */
    public static final a f18737g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public final m9.d f18738f;

    /* compiled from: StaticAnswerMethod.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public StaticAnswerMethod() {
        m9.d a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<StaticAnswerMethodModel>() { // from class: com.android.incallui.oplus.answerview.fragment.StaticAnswerMethod$mStaticAnswerMethodModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final StaticAnswerMethodModel invoke() {
                return (StaticAnswerMethodModel) new K(StaticAnswerMethod.this).a(StaticAnswerMethodModel.class);
            }
        });
        this.f18738f = a10;
    }

    @Override // com.android.incallui.oplus.answerview.fragment.AnswerMethod
    public AnswerMethodModel h1() {
        return t1();
    }

    @Override // g2.InterfaceC1035b
    public void m() {
        Log.d("StaticAnswerMethod", "onHideAnswerView: ");
        StaticAnswerMethodLayout staticAnswerMethodLayout = k1().f2609G;
        if (!(staticAnswerMethodLayout instanceof InterfaceC1035b)) {
            staticAnswerMethodLayout = null;
        }
        if (staticAnswerMethodLayout != null) {
            staticAnswerMethodLayout.m();
        }
        StaticAnswerMethodLayout staticAnswerMethodLayout2 = k1().f2609G;
        if (!(staticAnswerMethodLayout2 instanceof InterfaceC1036c)) {
            staticAnswerMethodLayout2 = null;
        }
        if (staticAnswerMethodLayout2 != null) {
            staticAnswerMethodLayout2.setTriggerEventListener(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.incall_static_answer_method, viewGroup, false);
        o i12 = o.i1(inflate);
        i12.k1(t1());
        i12.b1(getViewLifecycleOwner());
        i.e(i12, "bind(it).apply {\n       …ecycleOwner\n            }");
        s1(i12);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public final StaticAnswerMethodModel t1() {
        return (StaticAnswerMethodModel) this.f18738f.getValue();
    }

    @Override // g2.InterfaceC1035b
    public void v0() {
        Log.d("StaticAnswerMethod", "onDisplayAnswerView: ");
        StaticAnswerMethodLayout staticAnswerMethodLayout = k1().f2609G;
        StaticAnswerMethodLayout staticAnswerMethodLayout2 = null;
        if (!(staticAnswerMethodLayout instanceof InterfaceC1036c)) {
            staticAnswerMethodLayout = null;
        }
        if (staticAnswerMethodLayout != null) {
            staticAnswerMethodLayout.setTriggerEventListener(this);
        }
        StaticAnswerMethodLayout staticAnswerMethodLayout3 = k1().f2609G;
        if (staticAnswerMethodLayout3 instanceof InterfaceC1035b) {
            staticAnswerMethodLayout2 = staticAnswerMethodLayout3;
        }
        if (staticAnswerMethodLayout2 != null) {
            staticAnswerMethodLayout2.v0();
        }
    }
}
