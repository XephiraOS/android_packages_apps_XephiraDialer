package o2;

import A2.c;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telecom.DisconnectCause;
import android.text.TextUtils;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.v;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.CallUtils;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.oplus.brand.BrandCenter;
import kotlin.Pair;
import r2.InterfaceC1504a;

/* compiled from: CallStateRepository.kt */
/* loaded from: classes.dex */
public final class f implements InterfaceC1504a, InCallPresenter.IncomingCallListener, InCallPresenter.InCallStateListener, CallList.CallUpdateListener, c.b {

    /* renamed from: i, reason: collision with root package name */
    public static final a f35698i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final OplusCallList f35699a;

    /* renamed from: b, reason: collision with root package name */
    public final v<Call> f35700b;

    /* renamed from: c, reason: collision with root package name */
    public final ObservableBoolean f35701c;

    /* renamed from: d, reason: collision with root package name */
    public final ObservableBoolean f35702d;

    /* renamed from: e, reason: collision with root package name */
    public final NonNullObservableField<InCallPresenter.InCallState> f35703e;

    /* renamed from: f, reason: collision with root package name */
    public final v<Pair<Call, InCallPresenter.InCallState>> f35704f;

    /* renamed from: g, reason: collision with root package name */
    public final LocalObservableField<String> f35705g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f35706h;

    /* compiled from: CallStateRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CallStateRepository.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35707a;

        static {
            int[] iArr = new int[InCallPresenter.InCallState.values().length];
            try {
                iArr[InCallPresenter.InCallState.INCOMING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InCallPresenter.InCallState.PENDING_OUTGOING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InCallPresenter.InCallState.OUTGOING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InCallPresenter.InCallState.INCALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[InCallPresenter.InCallState.NO_CALLS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[InCallPresenter.InCallState.WAITING_FOR_ACCOUNT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f35707a = iArr;
        }
    }

    /* compiled from: CallStateRepository.kt */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Integer num;
            if (message != null) {
                Log.d("FloatingWindowCallStateRepository", "handleMessage: msg = " + message.what);
            } else {
                Log.w("FloatingWindowCallStateRepository", "handleMessage: msg is null return");
            }
            if (message != null) {
                num = Integer.valueOf(message.what);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 3001) {
                f.this.W1(false);
                return;
            }
            if (num != null && num.intValue() == 3002) {
                Call value = f.this.W().getValue();
                if (Log.sDebug) {
                    Log.d("FloatingWindowCallStateRepository", "handleMessage: MSG_CHECK_IDLE_STATE mCall = " + value);
                }
                if (value == null) {
                    return;
                }
                if (value.getState() != 2) {
                    f.this.Y1();
                } else {
                    f.this.Z1(null);
                }
            }
        }
    }

    public f() {
        CallList callList = CallList.getInstance();
        kotlin.jvm.internal.i.d(callList, "null cannot be cast to non-null type com.android.incallui.OplusCallList");
        this.f35699a = (OplusCallList) callList;
        this.f35700b = new v<>();
        this.f35701c = new ObservableBoolean(false);
        this.f35702d = new ObservableBoolean(false);
        this.f35703e = new NonNullObservableField<>(InCallPresenter.InCallState.NO_CALLS, null, null, null, 14, null);
        this.f35704f = new v<>();
        this.f35705g = new LocalObservableField<>(null, null, null, null, 15, null);
        this.f35706h = new c(Looper.getMainLooper());
    }

    public static final void G1(final f this$0, final boolean z10) {
        Call activeOrBackgroundCall;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Call value = this$0.W().getValue();
        if (Log.sDebug) {
            Log.d("FloatingWindowCallStateRepository", "answerIncomingCall: mCall = " + value + " isVideoAnswer = " + z10);
        }
        if (value == null) {
            return;
        }
        if (value.isAnswerFail()) {
            if (z10 || (activeOrBackgroundCall = this$0.N1().getActiveOrBackgroundCall()) == null) {
                return;
            }
            this$0.f35706h.sendEmptyMessageDelayed(3001, 500L);
            this$0.T1().disconnectCall(activeOrBackgroundCall.getId());
            return;
        }
        Call oplusGetOutgoingCall = this$0.N1().oplusGetOutgoingCall();
        if (oplusGetOutgoingCall != null) {
            Log.d("FloatingWindowCallStateRepository", "answerIncomingCall: has outgoing call, will delay to answer");
            this$0.T1().disconnectCall(oplusGetOutgoingCall.getId());
            this$0.f35706h.postDelayed(new Runnable() { // from class: o2.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.H1(f.this, z10);
                }
            }, 500L);
            return;
        }
        this$0.W1(z10);
    }

    public static final void H1(f this$0, boolean z10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.W1(z10);
    }

    public static final void K1(f this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Call value = this$0.W().getValue();
        if (Log.sDebug) {
            Log.d("FloatingWindowCallStateRepository", "endCall = " + value);
        }
        if (value == null) {
            return;
        }
        if (value.isFakeAnswerState() && !this$0.C0().hasCatchSwitchError()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowCallStateRepository", "endCall: Can not end call when in fake state ");
                return;
            }
            return;
        }
        this$0.T1().disconnectCall(value.getId());
    }

    public static final void X1(f this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Call value = this$0.W().getValue();
        if (Log.sDebug) {
            Log.d("FloatingWindowCallStateRepository", "rejectIncomingCall: mCall = " + value);
        }
        if (value != null) {
            this$0.T1().rejectCall(value.getId(), false, null);
        }
    }

    public static final void a2(f this$0, Call call, int i10, String from) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(call, "$call");
        kotlin.jvm.internal.i.f(from, "$from");
        String telecommCallId = this$0.T1().oplusTelecomAdapter().getTelecommCallId(call.getId());
        if (telecommCallId != null) {
            this$0.S1().l(telecommCallId, i10, from);
        } else {
            OplusPhoneUserActionStatistics.addNoIncomingRingAction(this$0.L1(), OplusPhoneUserActionStatistics.USER_ACTION_INCOMING_CALL_ID_NULL, from);
        }
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return InterfaceC1504a.C0347a.f(this);
    }

    public final boolean I1(Call call) {
        if (N1().oplusGetIncomingCall() != null && !N1().hasCDMADialingCall()) {
            return false;
        }
        if (!N1().allConferenceChildCallDisconnected()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowCallStateRepository", "conference hangup ,can not DisplayElapsedTime...");
            }
            return false;
        }
        if (call != null && call.getState() != 3 && call.getFakeState() != 1) {
            return false;
        }
        return true;
    }

    public final void J1(OplusCallList oplusCallList, InCallPresenter.InCallState inCallState, Integer num) {
        Integer num2;
        if (num == null || num.intValue() != 10) {
            return;
        }
        if (oplusCallList != null) {
            num2 = Integer.valueOf(oplusCallList.oplusGetCallSize());
        } else {
            num2 = null;
        }
        if (num2 != null && num2.intValue() == 1) {
            Y1();
        } else if (num2 != null && num2.intValue() == 2 && inCallState == InCallPresenter.InCallState.WAITING_FOR_ACCOUNT) {
            Y1();
        }
    }

    @Override // r2.InterfaceC1504a
    public void K(final boolean z10) {
        this.f35706h.post(new Runnable() { // from class: o2.d
            @Override // java.lang.Runnable
            public final void run() {
                f.G1(f.this, z10);
            }
        });
    }

    public Application L1() {
        return InterfaceC1504a.C0347a.a(this);
    }

    public BrandCenter M1() {
        return InterfaceC1504a.C0347a.b(this);
    }

    public OplusCallList N1() {
        return this.f35699a;
    }

    @Override // r2.InterfaceC1504a
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public v<Pair<Call, InCallPresenter.InCallState>> s1() {
        return this.f35704f;
    }

    public A2.c P1() {
        return InterfaceC1504a.C0347a.c(this);
    }

    public Context Q1() {
        return InterfaceC1504a.C0347a.d(this);
    }

    @Override // r2.InterfaceC1504a
    public LocalObservableField<String> R() {
        return this.f35705g;
    }

    @Override // r2.InterfaceC1504a
    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public v<Call> W() {
        return this.f35700b;
    }

    public A2.l S1() {
        return InterfaceC1504a.C0347a.e(this);
    }

    public TelecomAdapter T1() {
        return InterfaceC1504a.C0347a.g(this);
    }

    public final boolean U1(Call call) {
        if (CallUtils.isVideoCall(call) && !CallUtils.isAudioCallRingtone(L1(), call)) {
            return true;
        }
        return false;
    }

    public final boolean V1(Call call) {
        return OplusPhoneUtils.changeToVowifiIcon(call, N1().getActiveSubId());
    }

    public final void W1(boolean z10) {
        int i10;
        if (Log.sDebug) {
            Log.d("FloatingWindowCallStateRepository", "realAnswerIncomingCall: " + W().getValue() + " isVideoAnswer = " + z10);
        }
        Call value = W().getValue();
        if (value == null) {
            return;
        }
        TelecomAdapter T12 = T1();
        String id = value.getId();
        if (z10) {
            i10 = 3;
        } else {
            i10 = 0;
        }
        T12.answerCall(id, i10);
    }

    @Override // r2.InterfaceC1504a
    public ObservableBoolean X0() {
        return this.f35702d;
    }

    public final void Y1() {
        if (this.f35706h.hasMessages(3002)) {
            return;
        }
        if (Log.sDebug) {
            Log.d("FloatingWindowCallStateRepository", "sendCheckIdleStateMessage: ");
        }
        this.f35706h.sendEmptyMessageDelayed(3002, 1000L);
    }

    public final void Z1(Call call) {
        String str;
        Call value = W().getValue();
        String str2 = null;
        if (value != null) {
            str = value.getId();
        } else {
            str = null;
        }
        if (call != null) {
            str2 = call.getId();
        }
        Log.d("FloatingWindowCallStateRepository", "setFocusCall: prevFocusCallId = " + str + ", nextFocusCallId = " + str2);
        if (!kotlin.jvm.internal.i.b(str, str2)) {
            if (str != null) {
                N1().removeCallUpdateListener(str, this);
            }
            if (str2 != null) {
                N1().addCallUpdateListener(str2, this);
            }
        }
        W().m(call);
    }

    @Override // r2.InterfaceC1504a
    public void a() {
        this.f35706h.post(new Runnable() { // from class: o2.a
            @Override // java.lang.Runnable
            public final void run() {
                f.K1(f.this);
            }
        });
    }

    @Override // r2.InterfaceC1504a
    public boolean d() {
        if (M1().d() != null) {
            return true;
        }
        return false;
    }

    @Override // r2.InterfaceC1504a
    public void d0(final Call call, final int i10, final String from) {
        kotlin.jvm.internal.i.f(call, "call");
        kotlin.jvm.internal.i.f(from, "from");
        this.f35706h.post(new Runnable() { // from class: o2.c
            @Override // java.lang.Runnable
            public final void run() {
                f.a2(f.this, call, i10, from);
            }
        });
    }

    @Override // r2.InterfaceC1504a
    public void e() {
        this.f35706h.post(new Runnable() { // from class: o2.b
            @Override // java.lang.Runnable
            public final void run() {
                f.X1(f.this);
            }
        });
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        C0().addIncomingCallListener(this);
        C0().addListener(this);
        P1().b(this);
    }

    @Override // r2.InterfaceC1504a
    public ObservableBoolean g() {
        return this.f35701c;
    }

    @Override // r2.InterfaceC1504a
    public Integer h(boolean z10) {
        T5.a d10 = M1().d();
        if (d10 != null) {
            return Integer.valueOf(d10.h(z10));
        }
        return null;
    }

    @Override // r2.InterfaceC1504a
    public String h0(Call call) {
        T5.a d10 = M1().d();
        if (d10 != null) {
            return d10.r(call, Q1());
        }
        return null;
    }

    @Override // r2.InterfaceC1504a
    public NonNullObservableField<InCallPresenter.InCallState> i() {
        return this.f35703e;
    }

    @Override // r2.InterfaceC1504a
    public void i1() {
        P1().h();
    }

    @Override // r2.InterfaceC1504a
    public String l1() {
        T5.a d10 = M1().d();
        if (d10 != null) {
            return d10.s(Q1());
        }
        return null;
    }

    @Override // r2.InterfaceC1504a
    public void m() {
        if (N1().hasAnyLiveCall()) {
            C0().sendIncallActivityStateMessage();
        }
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onCallChanged(Call call) {
        if (call == null) {
            if (Log.sDebug) {
                Log.d("FloatingWindowCallStateRepository", "onCallChanged: call is null return");
                return;
            }
            return;
        }
        if (Log.sDebug) {
            Log.d("FloatingWindowCallStateRepository", "onCallChanged: callId = " + call.getId() + " state = " + call.getState());
        }
        if (call.getState() == 4) {
            if (g().s0() && !U1(call)) {
                if (Log.sDebug) {
                    Log.d("FloatingWindowCallStateRepository", "Video drop...");
                }
                g().t0(false);
                return;
            }
            return;
        }
        N1().removeCallUpdateListener(call.getId(), this);
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState oldState, InCallPresenter.InCallState newState, Call call) {
        kotlin.jvm.internal.i.f(oldState, "oldState");
        kotlin.jvm.internal.i.f(newState, "newState");
        if (Log.sDebug) {
            Log.d("FloatingWindowCallStateRepository", "onIncomingCall: oldState = " + oldState + " newState = " + newState + " call = " + call);
        }
        onStateChange(oldState, newState, N1());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        if (r6.placeCallInNavigation() != false) goto L31;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x003e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ac  */
    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStateChange(com.android.incallui.InCallPresenter.InCallState r4, com.android.incallui.InCallPresenter.InCallState r5, com.android.incallui.CallList r6) {
        /*
            r3 = this;
            java.lang.String r0 = "oldState"
            kotlin.jvm.internal.i.f(r4, r0)
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.i.f(r5, r0)
            boolean r0 = com.android.incallui.Log.sDebug
            if (r0 == 0) goto L2c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onStateChange: oldState = "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = " + newState = "
            r0.append(r4)
            r0.append(r5)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "FloatingWindowCallStateRepository"
            com.android.incallui.Log.d(r0, r4)
        L2c:
            boolean r4 = r6 instanceof com.android.incallui.OplusCallList
            r0 = 0
            if (r4 == 0) goto L35
            r4 = r6
            com.android.incallui.OplusCallList r4 = (com.android.incallui.OplusCallList) r4
            goto L36
        L35:
            r4 = r0
        L36:
            int[] r1 = o2.f.b.f35707a
            int r2 = r5.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L78;
                case 2: goto L69;
                case 3: goto L69;
                case 4: goto L63;
                case 5: goto L5f;
                case 6: goto L47;
                default: goto L41;
            }
        L41:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L47:
            if (r4 == 0) goto L4f
            com.android.incallui.Call r6 = r4.oplusGetActiveCall()
            if (r6 != 0) goto L7e
        L4f:
            if (r4 == 0) goto L5d
            int r6 = r4.oplusGetCallSize()
            r1 = 2
            if (r6 != r1) goto L5d
            com.android.incallui.Call r6 = r4.getDisconnectedCall()
            goto L7e
        L5d:
            r6 = r0
            goto L7e
        L5f:
            r3.Y1()
            goto L5d
        L63:
            r1 = 0
            com.android.incallui.Call r6 = D2.b.g(r6, r0, r0, r0, r1)
            goto L7e
        L69:
            if (r4 == 0) goto L5d
            com.android.incallui.Call r6 = r4.oplusGetOutgoingCall()
            if (r6 == 0) goto L5d
            boolean r1 = r6.placeCallInNavigation()
            if (r1 == 0) goto L5d
            goto L7e
        L78:
            if (r4 == 0) goto L5d
            com.android.incallui.Call r6 = r4.oplusGetIncomingCall()
        L7e:
            r3.Z1(r6)
            com.android.incallui.clean.domain.interactor.NonNullObservableField r1 = r3.i()
            r1.x0(r5)
            androidx.databinding.ObservableBoolean r1 = r3.g()
            boolean r2 = r3.U1(r6)
            r1.t0(r2)
            androidx.databinding.ObservableBoolean r1 = r3.X0()
            boolean r2 = r3.V1(r6)
            r1.t0(r2)
            androidx.lifecycle.v r1 = r3.s1()
            kotlin.Pair r2 = new kotlin.Pair
            r2.<init>(r6, r5)
            r1.m(r2)
            if (r6 == 0) goto Lb4
            int r6 = r6.getState()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
        Lb4:
            r3.J1(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.f.onStateChange(com.android.incallui.InCallPresenter$InCallState, com.android.incallui.InCallPresenter$InCallState, com.android.incallui.CallList):void");
    }

    @Override // r2.InterfaceC1504a
    public void p() {
        P1().c();
        R().x0(null);
    }

    @Override // r2.InterfaceC1504a
    public boolean p1(Call call, boolean z10, InCallPresenter.InCallState inCallState) {
        T5.a d10 = M1().d();
        if (d10 != null) {
            return d10.z(call, z10, inCallState);
        }
        return false;
    }

    @Override // r2.InterfaceC1504a
    public Integer q() {
        T5.a d10 = M1().d();
        if (d10 != null) {
            return d10.x(Q1());
        }
        return null;
    }

    @Override // r2.InterfaceC1504a
    public boolean u(Call call, InCallPresenter.InCallState inCallState) {
        T5.a d10 = M1().d();
        if (d10 == null || !d10.u(call, inCallState, Q1())) {
            return false;
        }
        return true;
    }

    @Override // r2.InterfaceC1504a, A2.c.b
    public void updateCallTime() {
        Call value = W().getValue();
        if (!I1(value)) {
            R().x0(null);
        }
        if (value != null && value.getState() == 3) {
            if (!OplusPhoneUtils.isCDMATelecomCustomize() && N1().isCDMADialingCall(value)) {
                return;
            }
            long connectTimeMillis = value.getConnectTimeMillis();
            if (connectTimeMillis == 0) {
                if (Log.sDebug) {
                    Log.d("FloatingWindowCallStateRepository", "updateCallTime callStart is zero invalid values return");
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - connectTimeMillis;
            if (Log.sDebug) {
                Log.d("FloatingWindowCallStateRepository", "updateCallTime: callStart = " + connectTimeMillis + " duration = " + currentTimeMillis);
            }
            R().x0(D2.b.a(Q1(), currentTimeMillis / 1000));
        }
    }

    @Override // r2.InterfaceC1504a
    public Integer v1() {
        T5.a d10 = M1().d();
        if (d10 != null) {
            return d10.E(Q1());
        }
        return null;
    }

    @Override // r2.InterfaceC1504a
    public String x1(Call call) {
        kotlin.jvm.internal.i.f(call, "call");
        String d10 = D2.b.d(L1(), call);
        DisconnectCause disconnectCause = call.getDisconnectCause();
        if (d10 != null) {
            return L1().getString(R.string.card_title_call_ended) + "  " + d10;
        }
        if (disconnectCause.getCode() != 7) {
            String string = L1().getString(R.string.card_title_call_ended);
            kotlin.jvm.internal.i.e(string, "application.getString(R.…ng.card_title_call_ended)");
            return string;
        }
        if (TextUtils.isEmpty(disconnectCause.getLabel())) {
            String string2 = L1().getString(R.string.card_title_call_ended);
            kotlin.jvm.internal.i.e(string2, "application.getString(R.…ng.card_title_call_ended)");
            return string2;
        }
        if (!OplusPhoneUtils.isNeedPlayBusyTone(7)) {
            String string3 = L1().getString(R.string.card_title_call_ended);
            kotlin.jvm.internal.i.e(string3, "application.getString(R.…ng.card_title_call_ended)");
            return string3;
        }
        return disconnectCause.getLabel().toString();
    }
}
