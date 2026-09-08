package com.android.incallui.clean.data.datasource;

import I1.e;
import androidx.lifecycle.v;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallActivity;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.clean.domain.bean.CallUiType;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import t2.C1581a;

/* compiled from: UIRepository.kt */
/* loaded from: classes.dex */
public final class k implements I1.e, InCallPresenter.IncomingCallListener, InCallPresenter.InCallStateListener {

    /* renamed from: d, reason: collision with root package name */
    public static final a f18350d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final NonNullObservableField<CallUiType> f18351a = new NonNullObservableField<>(CallUiType.TYPE_DEFAULT, null, null, null, 14, null);

    /* renamed from: b, reason: collision with root package name */
    public final com.android.incallui.mvvm.utils.h<InCallPresenter.InCallState> f18352b = new com.android.incallui.mvvm.utils.h<>(InCallPresenter.InCallState.NO_CALLS, false, 2, null);

    /* renamed from: c, reason: collision with root package name */
    public final v<Boolean> f18353c = new v<>(Boolean.FALSE);

    /* compiled from: UIRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // I1.e
    public void B0() {
        C0().showInCall(false, false);
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return e.a.a(this);
    }

    @Override // I1.e
    public void F0() {
        C0().updateNotificationWhenResumeAndPause();
    }

    @Override // I1.e
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public com.android.incallui.mvvm.utils.h<InCallPresenter.InCallState> i() {
        return this.f18352b;
    }

    @Override // I1.e
    public NonNullObservableField<CallUiType> Q() {
        return this.f18351a;
    }

    @Override // I1.e
    public void S0() {
        OplusInCallActivity activity = C0().getActivity();
        if (activity != null) {
            activity.finish();
        }
        OplusPhoneUtils.sendBroadcastInCallActivityStateIfBackground(C0().getContext());
    }

    @Override // I1.e
    public v<Boolean> U() {
        return this.f18353c;
    }

    @Override // I1.e
    public void U0() {
        C1581a floatingWindowController = C0().getFloatingWindowController();
        if (floatingWindowController != null) {
            floatingWindowController.F();
        }
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        C0().addIncomingCallListener(this);
        C0().addListener(this);
    }

    public final void h1(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2) {
        InCallPresenter.InCallState inCallState3;
        CallUiType callUiType;
        Log.d("UIRepository", "updateUiType: oldState = " + inCallState + " -> newState = " + inCallState2);
        com.android.incallui.mvvm.utils.h<InCallPresenter.InCallState> i10 = i();
        if (inCallState2 == null) {
            inCallState3 = InCallPresenter.InCallState.NO_CALLS;
        } else {
            inCallState3 = inCallState2;
        }
        i10.m(inCallState3);
        if (inCallState2 != null && inCallState2.isIncoming()) {
            callUiType = CallUiType.TYPE_INCOMING;
        } else if (inCallState2 != null && inCallState2.isDialing()) {
            callUiType = CallUiType.TYPE_OUTGOING;
        } else if (inCallState2 == InCallPresenter.InCallState.INCALL && inCallState == InCallPresenter.InCallState.NO_CALLS) {
            callUiType = CallUiType.TYPE_OUTGOING;
        } else if (inCallState2 == InCallPresenter.InCallState.NO_CALLS) {
            callUiType = CallUiType.TYPE_DEFAULT;
        } else {
            return;
        }
        Q().x0(callUiType);
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        h1(inCallState, inCallState2);
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        h1(inCallState, inCallState2);
    }
}
