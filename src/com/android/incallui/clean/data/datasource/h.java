package com.android.incallui.clean.data.datasource;

import D2.l;
import I1.c;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.telecom.Call;
import android.telecom.InCallService;
import android.telecom.VideoProfile;
import android.text.TextUtils;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.v;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.CallUtils;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.VideoCallPresenter;
import com.android.oplus.brand.BrandCenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: CallRepository.kt */
/* loaded from: classes.dex */
public final class h implements I1.c {

    /* renamed from: B, reason: collision with root package name */
    public static final a f18315B = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public final d f18316A;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f18317a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final int f18318b;

    /* renamed from: c, reason: collision with root package name */
    public final ObservableBoolean f18319c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18320d;

    /* renamed from: e, reason: collision with root package name */
    public Call f18321e;

    /* renamed from: f, reason: collision with root package name */
    public Call f18322f;

    /* renamed from: g, reason: collision with root package name */
    public InCallPresenter.InCallState f18323g;

    /* renamed from: h, reason: collision with root package name */
    public long f18324h;

    /* renamed from: i, reason: collision with root package name */
    public final v<Boolean> f18325i;

    /* renamed from: j, reason: collision with root package name */
    public final com.android.incallui.mvvm.utils.h<Boolean> f18326j;

    /* renamed from: k, reason: collision with root package name */
    public final v<Boolean> f18327k;

    /* renamed from: l, reason: collision with root package name */
    public final ObservableInt f18328l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<String> f18329m;

    /* renamed from: n, reason: collision with root package name */
    public final com.android.incallui.mvvm.utils.h<Boolean> f18330n;

    /* renamed from: o, reason: collision with root package name */
    public final String[] f18331o;

    /* renamed from: p, reason: collision with root package name */
    public final Call[] f18332p;

    /* renamed from: q, reason: collision with root package name */
    public final b f18333q;

    /* renamed from: r, reason: collision with root package name */
    public final InCallPresenter.InCallStateListener f18334r;

    /* renamed from: x, reason: collision with root package name */
    public final InCallPresenter.InCallDetailsListener f18335x;

    /* renamed from: y, reason: collision with root package name */
    public final e f18336y;

    /* renamed from: z, reason: collision with root package name */
    public final f f18337z;

    /* compiled from: CallRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CallRepository.kt */
    /* loaded from: classes.dex */
    public static final class c implements InCallPresenter.InCallStateListener {

        /* compiled from: CallRepository.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f18340a;

            static {
                int[] iArr = new int[InCallPresenter.InCallState.values().length];
                try {
                    iArr[InCallPresenter.InCallState.INCOMING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[InCallPresenter.InCallState.OUTGOING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[InCallPresenter.InCallState.PENDING_OUTGOING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[InCallPresenter.InCallState.INCALL.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f18340a = iArr;
            }
        }

        public c() {
        }

        @Override // com.android.incallui.InCallPresenter.InCallStateListener
        public void onStateChange(InCallPresenter.InCallState oldState, InCallPresenter.InCallState newState, CallList callList) {
            Call outgoingCall;
            String str;
            kotlin.jvm.internal.i.f(oldState, "oldState");
            kotlin.jvm.internal.i.f(newState, "newState");
            if (Log.sDebug) {
                Log.d("CallRepository", "onStateChange oldState = " + oldState + "  newState = " + newState);
            }
            kotlin.jvm.internal.i.d(callList, "null cannot be cast to non-null type com.android.incallui.OplusCallList");
            OplusCallList oplusCallList = (OplusCallList) callList;
            if (!oplusCallList.allConferenceChildCallDisconnected()) {
                if (Log.sDebug) {
                    Log.d("CallRepository", "onStateChange ConferenceCall not hangup all return...");
                    return;
                }
                return;
            }
            InCallPresenter.InCallState inCallState = InCallPresenter.InCallState.INCALL;
            Call call = null;
            boolean z10 = false;
            if (newState == inCallState) {
                h.this.f18321e = oplusCallList.getActiveOrBackgroundCall();
                if (h.this.f18321e != null) {
                    h.this.f18319c.t0(CallUtils.isVideoCall(h.this.f18321e));
                    CallUtils.isVideoCall(h.this.f18321e);
                }
            } else if (newState == InCallPresenter.InCallState.OUTGOING || newState == InCallPresenter.InCallState.PENDING_OUTGOING) {
                h hVar = h.this;
                if (newState == InCallPresenter.InCallState.PENDING_OUTGOING) {
                    outgoingCall = oplusCallList.getPendingOutgoingCall();
                } else {
                    outgoingCall = oplusCallList.getOutgoingCall();
                }
                hVar.f18321e = outgoingCall;
                if (h.this.f18321e != null) {
                    if (Log.sDebug) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("OUTGOING mCallId = ");
                        Call call2 = h.this.f18321e;
                        if (call2 != null) {
                            str = call2.getId();
                        } else {
                            str = null;
                        }
                        sb.append(str);
                        Log.d("CallRepository", sb.toString());
                    }
                    h.this.f18319c.t0(CallUtils.isBidirectionalVideoCall(h.this.f18321e));
                    TelecomAdapter.getInstance().mute(false);
                    Call call3 = h.this.f18321e;
                    if (call3 != null && call3.needTurnOnSpeaker()) {
                        AudioModeProvider.getInstance().autoTurnOnSpeaker(h.this.f18321e, true);
                    }
                }
            }
            h.this.h2(oldState, newState, callList);
            InCallPresenter.InCallState inCallState2 = InCallPresenter.InCallState.NO_CALLS;
            if (newState != inCallState2 && h.this.f18321e != null) {
                h.this.o0().m(Boolean.FALSE);
            }
            h hVar2 = h.this;
            int i10 = a.f18340a[newState.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 4) {
                            call = oplusCallList.getActiveOrBackgroundCall();
                        }
                    } else {
                        call = oplusCallList.getPendingOutgoingCall();
                    }
                } else {
                    call = oplusCallList.getOutgoingCall();
                }
            } else {
                call = oplusCallList.getIncomingCall();
            }
            hVar2.f18322f = call;
            Log.d("CallRepository", "isIncall = " + newState.isInCall(h.this.f18322f));
            v<Boolean> Q02 = h.this.Q0();
            if (!newState.isInCall(h.this.f18322f) && (newState == inCallState || newState == inCallState2)) {
                z10 = true;
            }
            Q02.m(Boolean.valueOf(z10));
        }
    }

    /* compiled from: CallRepository.kt */
    /* loaded from: classes.dex */
    public static final class d implements InCallPresenter.IncomingCallListener {
        public d() {
        }

        @Override // com.android.incallui.InCallPresenter.IncomingCallListener
        public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
            kotlin.jvm.internal.i.f(call, "call");
            int phoneId = h.this.V1().getPhoneId(call.getSubId());
            Log.d(this, "onIncomingCall: " + this);
            if (h.this.V1().getVideoUpgradeRequestCall() != null) {
                Log.d(this, "declining upgrade request id: ");
                h.this.o0().m(Boolean.FALSE);
                h.this.C0().declineUpgradeRequest();
            }
            if (!kotlin.jvm.internal.i.b(call.getId(), h.this.f18331o[phoneId])) {
                h.this.i2(call);
            }
        }
    }

    /* compiled from: CallRepository.kt */
    /* loaded from: classes.dex */
    public static final class f implements CallList.ActiveSubChangeListener {
        public f() {
        }

        @Override // com.android.incallui.CallList.ActiveSubChangeListener
        public void onActiveSubChanged(int i10) {
            Call E02 = h.this.E0();
            int phoneId = h.this.V1().getPhoneId(i10);
            if (E02 != null && E02.getId() == h.this.f18331o[phoneId]) {
                Log.d(this, "Show incoming for call id: " + h.this.f18331o[phoneId] + ' ' + this);
                h.this.o0().m(Boolean.TRUE);
                h.this.P1(h.this.V1().getTextResponses(E02.getId()));
                return;
            }
            if (E02 == null && h.this.V1().hasAnyLiveCall(i10)) {
                h.this.o0().m(Boolean.FALSE);
                Log.d(this, "Hide incoming for call id: " + h.this.f18331o[phoneId] + ' ' + this);
                return;
            }
            Log.d(this, "No incoming call present for sub = " + i10 + ' ' + this);
        }
    }

    public h() {
        int a10 = l.a(T1());
        this.f18318b = a10;
        this.f18319c = new ObservableBoolean(false);
        Boolean bool = Boolean.FALSE;
        this.f18325i = new v<>(bool);
        this.f18326j = new com.android.incallui.mvvm.utils.h<>(bool, false);
        this.f18327k = new v<>(bool);
        this.f18328l = new ObservableInt(0);
        this.f18329m = new ArrayList<>();
        this.f18330n = new com.android.incallui.mvvm.utils.h<>(bool, false);
        this.f18331o = new String[a10];
        this.f18332p = new Call[a10];
        this.f18333q = new b();
        this.f18334r = new c();
        this.f18335x = new InCallPresenter.InCallDetailsListener() { // from class: com.android.incallui.clean.data.datasource.d
            @Override // com.android.incallui.InCallPresenter.InCallDetailsListener
            public final void onDetailsChanged(Call call, Call.Details details) {
                h.Y1(h.this, call, details);
            }
        };
        this.f18336y = new e();
        this.f18337z = new f();
        this.f18316A = new d();
    }

    public static final void O1(h this$0, int i10) {
        String str;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        int R12 = this$0.R1();
        StringBuilder sb = new StringBuilder();
        sb.append("onAnswer  mCallId:");
        String arrays = Arrays.toString(this$0.f18331o);
        kotlin.jvm.internal.i.e(arrays, "toString(this)");
        sb.append(arrays);
        sb.append(" phoneId = ");
        sb.append(R12);
        Log.d("CallRepository", sb.toString());
        if (R12 == -1) {
            return;
        }
        com.android.incallui.Call call = this$0.f18332p[R12];
        if (call != null && call.getSessionModificationState() == 3) {
            this$0.C0().acceptUpgradeRequest(i10, this$0.T1());
            return;
        }
        TelecomAdapter X12 = this$0.X1();
        com.android.incallui.Call call2 = this$0.f18332p[R12];
        if (call2 != null) {
            str = call2.getId();
        } else {
            str = null;
        }
        X12.answerCall(str, i10);
    }

    public static final void Q1(h this$0, String str) {
        String str2;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        int R12 = this$0.R1();
        StringBuilder sb = new StringBuilder();
        sb.append("onDecline mCallId:");
        String arrays = Arrays.toString(this$0.f18331o);
        kotlin.jvm.internal.i.e(arrays, "toString(this)");
        sb.append(arrays);
        Log.d("CallRepository", sb.toString());
        if (this$0.a2(R12)) {
            return;
        }
        com.android.incallui.Call call = this$0.f18332p[R12];
        if (call != null && call.getSessionModificationState() == 3) {
            this$0.C0().declineUpgradeRequest(this$0.T1());
            return;
        }
        TelecomAdapter X12 = this$0.X1();
        com.android.incallui.Call call2 = this$0.f18332p[R12];
        if (call2 != null) {
            str2 = call2.getId();
        } else {
            str2 = null;
        }
        X12.rejectCall(str2, !TextUtils.isEmpty(str), str);
    }

    private final int R1() {
        int length = this.f18332p.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.f18332p[i11] != null) {
                i10 = i11;
            }
        }
        return i10;
    }

    public static final void Y1(h this$0, com.android.incallui.Call call, Call.Details details) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.g().m(Boolean.valueOf(this$0.d2(call)));
    }

    public static final void g2(h this$0) {
        String str;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.f18321e == null) {
            if (Log.sDebug) {
                D2.g.f("CallRepository", "onEndCallClicked, mCall is null return ... ");
                return;
            }
            return;
        }
        if (Log.sDebug) {
            D2.g.b("CallRepository", "onEndCallClicked, mCall = " + this$0.f18321e);
        }
        TelecomAdapter telecomAdapter = TelecomAdapter.getInstance();
        com.android.incallui.Call call = this$0.f18321e;
        if (call != null) {
            str = call.getId();
        } else {
            str = null;
        }
        telecomAdapter.disconnectCall(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        if (Log.sDebug) {
            Log.d("CallRepository", "onStateChange father > oldState = " + inCallState + "  newState = " + inCallState2);
        }
        com.android.incallui.Call call = null;
        if (inCallState2 == InCallPresenter.InCallState.PENDING_OUTGOING) {
            if (callList != null) {
                call = callList.getPendingOutgoingCall();
            }
            this.f18321e = call;
        } else if (inCallState2 == InCallPresenter.InCallState.OUTGOING) {
            if (callList != null) {
                call = callList.getOutgoingCall();
            }
            this.f18321e = call;
        } else if (inCallState2 == InCallPresenter.InCallState.INCALL) {
            if (callList != null) {
                call = callList.getActiveOrBackgroundCall();
            }
            this.f18321e = call;
            if (this.f18323g == InCallPresenter.InCallState.INCOMING && callList != null && callList.oplusCallList().oplusGetCallSize() == 1 && (callList.getDisconnectingCall() != null || callList.getDisconnectedCall() != null)) {
                return;
            }
        } else {
            this.f18321e = null;
        }
        this.f18323g = inCallState2;
    }

    @Override // I1.c
    public void A0(long j10) {
        this.f18324h = j10;
    }

    @Override // I1.c
    public boolean A1() {
        return V1().hasConferenceCall();
    }

    @Override // I1.c
    public void C(final int i10) {
        this.f18317a.post(new Runnable() { // from class: com.android.incallui.clean.data.datasource.f
            @Override // java.lang.Runnable
            public final void run() {
                h.O1(h.this, i10);
            }
        });
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return c.a.d(this);
    }

    @Override // I1.c
    public void E(final String str) {
        this.f18317a.post(new Runnable() { // from class: com.android.incallui.clean.data.datasource.g
            @Override // java.lang.Runnable
            public final void run() {
                h.Q1(h.this, str);
            }
        });
    }

    @Override // I1.c
    public com.android.incallui.Call E0() {
        return V1().getIncomingCall();
    }

    @Override // I1.c
    public com.android.incallui.Call H(int i10, int i11) {
        return V1().getParentCallWithState(i10, i11);
    }

    @Override // I1.c
    public com.android.incallui.Call J() {
        return V1().oplusGetOutgoingCall();
    }

    @Override // I1.c
    public void J0() {
        C(S1().s0());
    }

    @Override // I1.c
    public void M(int i10) {
        S1().t0(i10);
    }

    @Override // I1.c
    public long P() {
        return this.f18324h;
    }

    @Override // I1.c
    public boolean P0() {
        com.android.incallui.Call call = this.f18321e;
        if (call == null || !call.getVideoPaused()) {
            return false;
        }
        return true;
    }

    public final void P1(List<String> list) {
        boolean z10;
        if (list != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f18320d = z10;
    }

    @Override // I1.c
    public v<Boolean> Q0() {
        return this.f18327k;
    }

    @Override // I1.c
    public void S(String callId) {
        kotlin.jvm.internal.i.f(callId, "callId");
        X1().disconnectCall(callId);
    }

    public ObservableInt S1() {
        return this.f18328l;
    }

    @Override // I1.c
    public boolean T0() {
        return C0().hasCatchSwitchError();
    }

    public Application T1() {
        return c.a.a(this);
    }

    public BrandCenter U1() {
        return c.a.b(this);
    }

    public OplusCallList V1() {
        return c.a.c(this);
    }

    public final List<String> W1() {
        if (V1().getIncomingCall() != null) {
            List<String> cannedSmsResponses = V1().getIncomingCall().getCannedSmsResponses();
            kotlin.jvm.internal.i.e(cannedSmsResponses, "callList.incomingCall.cannedSmsResponses");
            return cannedSmsResponses;
        }
        return new ArrayList();
    }

    public TelecomAdapter X1() {
        return c.a.e(this);
    }

    @Override // I1.c
    public void Y0() {
        this.f18317a.post(new Runnable() { // from class: com.android.incallui.clean.data.datasource.e
            @Override // java.lang.Runnable
            public final void run() {
                h.g2(h.this);
            }
        });
    }

    public final boolean Z1() {
        boolean z10 = true;
        for (com.android.incallui.Call call : this.f18332p) {
            if (z10 && (call == null || call.getState() == 10 || call.getState() == 9)) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // I1.c
    public void a1(String callId, boolean z10, String str) {
        kotlin.jvm.internal.i.f(callId, "callId");
        X1().rejectCall(callId, z10, str);
    }

    public final boolean a2(int i10) {
        if (i10 >= 0 && i10 < this.f18318b) {
            return false;
        }
        return true;
    }

    @Override // I1.c
    public void b() {
        OplusPhoneUtils.silenceRinger(T1());
    }

    public final boolean b2(com.android.incallui.Call call) {
        if (call == null || !Call.State.isConnectingOrDialing(call.getState())) {
            return false;
        }
        return VideoProfile.isReceptionEnabled(call.getVideoState());
    }

    @Override // I1.c
    /* renamed from: c2, reason: merged with bridge method [inline-methods] */
    public com.android.incallui.mvvm.utils.h<Boolean> g() {
        return this.f18326j;
    }

    public final boolean d2(com.android.incallui.Call call) {
        if (!CallUtils.isVideoCall(call) || CallUtils.isAudioCallRingtone(T1(), call) || b2(call)) {
            return false;
        }
        return true;
    }

    @Override // I1.c
    public com.android.incallui.Call e1() {
        return this.f18321e;
    }

    public final boolean e2(com.android.incallui.Call call) {
        if (call.getSessionModificationState() == 3) {
            return true;
        }
        return false;
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        Log.d("CallRepository", "set up");
        V1().addListener(this.f18336y);
        V1().addActiveSubChangeListener(this.f18337z);
        C0().addIncomingCallListener(this.f18316A);
        C0().addDetailsListener(this.f18335x);
        C0().addListener(this.f18334r);
        k2();
    }

    public final void f2(com.android.incallui.Call call) {
        g().m(Boolean.valueOf(d2(call)));
        this.f18330n.m(Boolean.valueOf(OplusPhoneUtils.changeToVowifiIcon(call, V1().getActiveSubId())));
    }

    public final void i2(com.android.incallui.Call call) {
        int subId = call.getSubId();
        int phoneId = V1().getPhoneId(subId);
        Log.d("CallRepository", "processIncomingCall... " + call + ", subId = " + subId + ", phoneId = " + phoneId);
        if (phoneId == -1) {
            return;
        }
        int length = this.f18332p.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f18332p[i10] = null;
        }
        this.f18331o[phoneId] = call.getId();
        this.f18332p[phoneId] = call;
        V1().addListener(this.f18336y);
        V1().addCallUpdateListener(this.f18331o[phoneId], this.f18333q);
        V1().notifyCallUpdateListeners(V1().getCallById(this.f18331o[phoneId]));
        Log.d("CallRepository", "Showing incoming for call id: " + this.f18331o[phoneId]);
        f2(call);
        o0().m(Boolean.TRUE);
        P1(V1().getTextResponses(call.getId()));
    }

    @Override // I1.c
    public com.android.incallui.Call j0() {
        return V1().oplusGetBackgroundCall();
    }

    @Override // I1.c
    public com.android.incallui.Call j1() {
        return V1().oplusGetDisconnectingCall();
    }

    public final void j2(com.android.incallui.Call call) {
        Log.d("CallRepository", " processVideoUpgradeRequestCall call=" + call);
        int phoneId = V1().getPhoneId(call.getSubId());
        this.f18331o[phoneId] = call.getId();
        this.f18332p[phoneId] = call;
        V1().addCallUpdateListener(this.f18331o[phoneId], this.f18333q);
        if (call.getVideoState() == call.getModifyToVideoState()) {
            Log.w("CallRepository", "processVideoUpgradeRequestCall: Video states are same. Return.");
        } else {
            C0().showVideoUpgradeRequestDialog();
        }
    }

    @Override // I1.c
    public ArrayList<String> k1() {
        if (this.f18329m.isEmpty()) {
            this.f18329m.addAll(W1());
        }
        return this.f18329m;
    }

    public final void k2() {
        com.android.incallui.Call E02;
        int i10 = this.f18318b;
        boolean z10 = false;
        for (int i11 = 0; i11 < i10; i11++) {
            int subId = V1().getSubId(i11);
            if (subId != -1) {
                com.android.incallui.Call callWithState = V1().getCallWithState(4, 0, subId);
                if (callWithState == null) {
                    callWithState = V1().getCallWithState(5, 0, subId);
                }
                if (callWithState != null) {
                    i2(callWithState);
                    z10 = true;
                }
            } else {
                Log.d("CallRepository", "No valid sub");
            }
        }
        if (!z10 && (E02 = E0()) != null) {
            i2(E02);
        }
    }

    @Override // I1.c
    public void n0() {
        C0().declineUpgradeRequest();
    }

    @Override // I1.c
    public v<Boolean> o0() {
        return this.f18325i;
    }

    @Override // I1.c
    public void r(boolean z10) {
        InCallService.VideoCall videoCall;
        com.android.incallui.Call call = this.f18321e;
        if (call != null) {
            videoCall = call.getVideoCall();
        } else {
            videoCall = null;
        }
        VideoCallPresenter videoCallPresenter = C0().getVideoCallPresenter();
        if (videoCall != null && videoCallPresenter != null) {
            call.setVideoPaused(z10);
            T5.a d10 = U1().d();
            if (d10 != null) {
                d10.C(call, videoCall, z10);
            }
            if (!z10 && call.isConferenceCall()) {
                OplusPhoneUtils.setVideoPausedForConf(false);
            }
            videoCallPresenter.enableCamera(videoCall, !z10);
            return;
        }
        Log.w(this, "pauseVideoClicked: videoCall or videoCallPresenter is null.");
    }

    @Override // I1.c
    public boolean t() {
        return V1().hasLiveCall();
    }

    @Override // I1.c
    public void y0(String fromTag) {
        kotlin.jvm.internal.i.f(fromTag, "fromTag");
        C0().startRinging(fromTag);
    }

    @Override // I1.c
    public com.android.incallui.Call y1() {
        return V1().oplusGetActiveCall();
    }

    /* compiled from: CallRepository.kt */
    /* loaded from: classes.dex */
    public static final class b implements CallList.CallUpdateListener {
        public b() {
        }

        @Override // com.android.incallui.CallList.CallUpdateListener
        public void onCallChanged(com.android.incallui.Call call) {
            List<String> textResponses;
            boolean z10;
            kotlin.jvm.internal.i.f(call, "call");
            Log.d("CallRepository", "onCallStateChange() " + call);
            if (call.getState() == 4) {
                h.this.f2(call);
            }
            if (call.getState() != 10 && call.getState() != 9) {
                h.this.Q0().m(Boolean.FALSE);
            } else {
                h.this.k1().clear();
                h.this.Q0().m(Boolean.valueOf(h.this.Z1()));
            }
            if (call.getState() != 4) {
                boolean e22 = h.this.e2(call);
                int phoneId = h.this.V1().getPhoneId(call.getSubId());
                if (!e22 && ((phoneId == 0 || phoneId == 1) && call.getId() != null && kotlin.jvm.internal.i.b(call.getId(), h.this.f18331o[phoneId]))) {
                    h.this.V1().removeCallUpdateListener(h.this.f18331o[phoneId], this);
                }
                com.android.incallui.Call E02 = h.this.E0();
                v<Boolean> o02 = h.this.o0();
                if (E02 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                o02.m(Boolean.valueOf(z10));
                if ((phoneId == 0 || phoneId == 1) && call.getId() != null && kotlin.jvm.internal.i.b(call.getId(), h.this.f18331o[phoneId])) {
                    h.this.f18331o[phoneId] = null;
                }
                h.this.f18320d = false;
                return;
            }
            if (!h.this.f18320d && (textResponses = h.this.V1().getTextResponses(call.getId())) != null) {
                h.this.P1(textResponses);
            }
        }

        @Override // com.android.incallui.CallList.CallUpdateListener
        public void onSessionModificationStateChange(com.android.incallui.Call call, int i10) {
            boolean z10;
            Log.d("CallRepository", "onSessionModificationStateChange() " + call + ", state = " + i10 + ", isVideo = " + CallUtils.isVideoCall(call));
            if (i10 == 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.this.g().m(Boolean.valueOf(h.this.d2(call)));
            if (!z10) {
                int i11 = h.this.f18318b;
                for (int i12 = 0; i12 < i11; i12++) {
                    if (h.this.f18331o[i12] != null) {
                        h.this.V1().removeCallUpdateListener(h.this.f18331o[i12], this);
                    }
                }
                if (h.this.C0().getInCallState() != InCallPresenter.InCallState.INCOMING) {
                    h.this.o0().m(Boolean.FALSE);
                }
            }
        }

        @Override // com.android.incallui.CallList.CallUpdateListener
        public void onChildNumberChange() {
        }

        @Override // com.android.incallui.CallList.CallUpdateListener
        public void onLastForwardedNumberChange() {
        }
    }

    /* compiled from: CallRepository.kt */
    /* loaded from: classes.dex */
    public static final class e implements CallList.Listener {
        public e() {
        }

        @Override // com.android.incallui.CallList.Listener
        public void onDisconnect(com.android.incallui.Call call) {
            kotlin.jvm.internal.i.f(call, "call");
            int phoneId = h.this.V1().getPhoneId(call.getSubId());
            if (kotlin.jvm.internal.i.b(call, h.this.f18332p[phoneId])) {
                h.this.f18332p[phoneId] = null;
                h.this.Q0().m(Boolean.valueOf(h.this.Z1()));
            }
        }

        @Override // com.android.incallui.CallList.Listener
        public void onUpgradeToVideo(com.android.incallui.Call call) {
            kotlin.jvm.internal.i.f(call, "call");
            Log.d("CallRepository", "onUpgradeToVideo: " + this + " call= " + call);
            boolean e22 = h.this.e2(call);
            if (e22 && h.this.C0().getInCallState() == InCallPresenter.InCallState.INCOMING) {
                Log.d("CallRepository", "declining upgrade request");
                h.this.C0().declineUpgradeRequest(h.this.T1());
            } else if (e22) {
                Log.d("CallRepository", "process upgrade request as no MT call");
                h.this.j2(call);
            }
        }

        @Override // com.android.incallui.CallList.Listener
        public void onCallListChange(CallList callList) {
        }

        @Override // com.android.incallui.CallList.Listener
        public void onIncomingCall(com.android.incallui.Call call) {
        }
    }
}
