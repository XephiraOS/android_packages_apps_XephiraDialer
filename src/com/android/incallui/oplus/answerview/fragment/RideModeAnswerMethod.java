package com.android.incallui.oplus.answerview.fragment;

import O1.m;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.K;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.RideModeAnswerMethodLayout;
import com.android.incallui.oplus.answerview.view_model.AnswerMethodModel;
import com.android.incallui.oplus.answerview.view_model.RideModeAnswerMethodModel;
import g2.InterfaceC1035b;
import g2.InterfaceC1036c;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: RideModeAnswerMethod.kt */
/* loaded from: classes.dex */
public final class RideModeAnswerMethod extends AnswerMethod {

    /* renamed from: g, reason: collision with root package name */
    public static final a f18735g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public final m9.d f18736f;

    /* compiled from: RideModeAnswerMethod.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public RideModeAnswerMethod() {
        m9.d a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<RideModeAnswerMethodModel>() { // from class: com.android.incallui.oplus.answerview.fragment.RideModeAnswerMethod$mRideModeAnswerMethodModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final RideModeAnswerMethodModel invoke() {
                return (RideModeAnswerMethodModel) new K(RideModeAnswerMethod.this).a(RideModeAnswerMethodModel.class);
            }
        });
        this.f18736f = a10;
    }

    @Override // com.android.incallui.oplus.answerview.fragment.AnswerMethod
    public AnswerMethodModel h1() {
        return t1();
    }

    @Override // g2.InterfaceC1035b
    public void m() {
        Log.d("FlingUpAnswerMethod", "onHideAnswerView: ");
        RideModeAnswerMethodLayout rideModeAnswerMethodLayout = j1().f2603M;
        if (!(rideModeAnswerMethodLayout instanceof InterfaceC1035b)) {
            rideModeAnswerMethodLayout = null;
        }
        if (rideModeAnswerMethodLayout != null) {
            rideModeAnswerMethodLayout.m();
        }
        RideModeAnswerMethodLayout rideModeAnswerMethodLayout2 = j1().f2603M;
        if (!(rideModeAnswerMethodLayout2 instanceof InterfaceC1036c)) {
            rideModeAnswerMethodLayout2 = null;
        }
        if (rideModeAnswerMethodLayout2 != null) {
            rideModeAnswerMethodLayout2.setTriggerEventListener(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.incall_ride_mode_answer_method, viewGroup, false);
        m i12 = m.i1(inflate);
        i12.k1(t1());
        i12.b1(getViewLifecycleOwner());
        i.e(i12, "bind(it).apply {\n       …ecycleOwner\n            }");
        r1(i12);
        return inflate;
    }

    public final RideModeAnswerMethodModel t1() {
        return (RideModeAnswerMethodModel) this.f18736f.getValue();
    }

    @Override // g2.InterfaceC1035b
    public void v0() {
        Log.d("FlingUpAnswerMethod", "onDisplayAnswerView: ");
        RideModeAnswerMethodLayout rideModeAnswerMethodLayout = j1().f2603M;
        RideModeAnswerMethodLayout rideModeAnswerMethodLayout2 = null;
        if (!(rideModeAnswerMethodLayout instanceof InterfaceC1036c)) {
            rideModeAnswerMethodLayout = null;
        }
        if (rideModeAnswerMethodLayout != null) {
            rideModeAnswerMethodLayout.setTriggerEventListener(this);
        }
        RideModeAnswerMethodLayout rideModeAnswerMethodLayout3 = j1().f2603M;
        if (rideModeAnswerMethodLayout3 instanceof InterfaceC1035b) {
            rideModeAnswerMethodLayout2 = rideModeAnswerMethodLayout3;
        }
        if (rideModeAnswerMethodLayout2 != null) {
            rideModeAnswerMethodLayout2.v0();
        }
    }
}
