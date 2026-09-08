package o2;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.OplusProximitySensor;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.mvvm.usecase.VideoBackgroundUseCase;
import com.android.oplus.brand.BrandCenter;
import p2.C1430a;
import r2.InterfaceC1506c;

/* compiled from: NavigationRepository.kt */
/* loaded from: classes.dex */
public final class j implements InterfaceC1506c {

    /* renamed from: c, reason: collision with root package name */
    public static final a f35721c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f35722a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final LocalObservableField<Integer> f35723b = new LocalObservableField<>(null, null, null, null, 15, null);

    /* compiled from: NavigationRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void N0() {
        OplusPhoneUtils.showNumberMarkView();
    }

    public Application B() {
        return InterfaceC1506c.a.c(this);
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return InterfaceC1506c.a.f(this);
    }

    public OplusCallList G() {
        return InterfaceC1506c.a.d(this);
    }

    @Override // r2.InterfaceC1506c
    public boolean I0() {
        return C1430a.f(C1430a.b());
    }

    @Override // r2.InterfaceC1506c
    public void K0() {
        if (Log.sDebug) {
            Log.d("FloatingWindowNavigationRepository", "updatePSensor ...");
        }
        OplusProximitySensor e02 = e0();
        if (e02 != null) {
            e02.delayToAcquireIncomingProximitySensor();
        }
    }

    @Override // r2.InterfaceC1506c
    public boolean V() {
        return C0().inCallActivityIsForeground();
    }

    @Override // r2.InterfaceC1506c
    public void V0() {
        this.f35722a.post(new Runnable() { // from class: o2.i
            @Override // java.lang.Runnable
            public final void run() {
                j.N0();
            }
        });
    }

    @Override // r2.InterfaceC1506c
    public LocalObservableField<Integer> W0() {
        return this.f35723b;
    }

    @Override // r2.InterfaceC1506c
    public synchronized void Z0(boolean z10) {
        if (OplusFeatureOption.VERSION_STORE && !Settings.canDrawOverlays(B())) {
            return;
        }
        Call oplusGetOutgoingCall = G().oplusGetOutgoingCall();
        if (oplusGetOutgoingCall != null && oplusGetOutgoingCall.placeCallInNavigation()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMO: show navigation floating window for MO");
            }
            w0(5);
        } else {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMO: not allowed MO in FloatingWindow");
            }
            w0(null);
        }
    }

    public Context c0() {
        return InterfaceC1506c.a.e(this);
    }

    @Override // r2.InterfaceC1506c
    public void d1(InCallPresenter.InCallState state) {
        kotlin.jvm.internal.i.f(state, "state");
        if (Log.sDebug) {
            Log.d("FloatingWindowNavigationRepository", "startInCallActivity");
        }
        C0().startUi(state);
    }

    public OplusProximitySensor e0() {
        return InterfaceC1506c.a.g(this);
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        C1430a.e(c0());
    }

    @Override // r2.InterfaceC1506c
    public boolean g0(Integer num, boolean z10) {
        return OplusPhoneUtils.isShowPrivacyToast(B(), num, G(), z10);
    }

    @Override // r2.InterfaceC1506c
    public void i0(Call call) {
        kotlin.jvm.internal.i.f(call, "call");
        C0().updateFloatingWindowIncomingCallNotification(call);
    }

    public final void k0(Integer num) {
        int i10;
        OplusInCallPresenter C02 = C0();
        if (num != null && num.intValue() == 1) {
            i10 = 3;
        } else if ((num != null && num.intValue() == 4) || (num != null && num.intValue() == 5)) {
            i10 = 4;
        } else {
            return;
        }
        C02.setIncomingInterfaceType(i10);
    }

    @Override // r2.InterfaceC1506c
    public synchronized void m0(boolean z10) {
        if (OplusFeatureOption.VERSION_STORE && !Settings.canDrawOverlays(OplusInCallApp.getAppContext())) {
            return;
        }
        if (!z10 && W0().s0() != null) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: window type has initialized as " + W0().s0());
            }
            return;
        }
        if (V()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: InCallActivity is foreground, not need to show floating window");
            }
            w0(null);
            return;
        }
        if (BrandCenter.f19187a.a().h()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: RttInCallActivity is foreground, not need to show floating window");
            }
            w0(null);
            return;
        }
        if (OplusPhoneUtils.isInBlackScreenMode(B())) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: show floating window in black screen mode");
            }
            w0(1);
            return;
        }
        if (OplusPhoneUtils.getPhoneScreenLockState(B())) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: Screen is locked, not need to show floating window");
            }
            return;
        }
        if (!InCallPresenter.getInstance().isScreenInteractive()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: Screen is off, not need to show floating window");
            }
            return;
        }
        if (G2.a.a(B())) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: talkback is enabled, return!");
            }
            return;
        }
        if (OplusPhoneUtils.isRideMode()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: Ride mode is on, not need to show floating window");
            }
            return;
        }
        if (OplusPhoneUtils.isSmartAutoAnswerOn(B()) && OplusPhoneUtils.isMotorCameraUp(B())) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: motor camera is up and auto-answer is open");
            }
            return;
        }
        if (OplusPhoneUtils.isInSplitScreenMode()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: show floating window in span mode");
            }
            w0(1);
            return;
        }
        ComponentName b10 = C1430a.b();
        Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: topComponentName is " + b10);
        if (C1430a.f(b10)) {
            w0(4);
            return;
        }
        int c10 = C1430a.c(b10);
        if (3 == c10) {
            w0(null);
            return;
        }
        if (2 == c10) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: show navigation floating window");
            }
            w0(5);
            return;
        }
        if (C1430a.g()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: show  normal floating window");
            }
            w0(1);
            return;
        }
        if (Settings.Global.getInt(B().getContentResolver(), "oplus_customize_comm_phone_show_ussd_dialog", 0) == 1) {
            if (Log.sDebug) {
                Log.d("FloatingWindowNavigationRepository", "initWindowTypeForMT: show normal floating window for ussd dialog");
            }
            w0(1);
        } else {
            if (OplusPhoneUtils.isLargeSuspensionFrame(B())) {
                w0(1);
                return;
            }
            Call incomingCall = CallList.getInstance().getIncomingCall();
            if (incomingCall != null && !incomingCall.isShouldRingForContact()) {
                w0(1);
                return;
            }
            if (OplusPhoneUtils.isMTCallDisplayFloat(B())) {
                w0(1);
            } else {
                w0(null);
            }
        }
    }

    @Override // r2.InterfaceC1506c
    public boolean r0() {
        return VideoBackgroundUseCase.f18569a.n();
    }

    @Override // r2.InterfaceC1506c
    public void t0() {
        C0().registerHomeRecevier();
    }

    @Override // r2.InterfaceC1506c
    public void t1() {
        OplusPhoneUtils.sendBroadcastInCallActivityState(B(), true);
    }

    @Override // r2.InterfaceC1506c
    public boolean w() {
        if (4 == C1430a.c(C1430a.b())) {
            return true;
        }
        return false;
    }

    @Override // r2.InterfaceC1506c
    public synchronized void w0(Integer num) {
        Log.d("FloatingWindowNavigationRepository", "setWindowType: " + num);
        W0().x0(num);
        k0(num);
    }

    @Override // r2.InterfaceC1506c
    public boolean x0() {
        return InterfaceC1506c.a.h(this);
    }
}
