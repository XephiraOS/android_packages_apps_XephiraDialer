package com.android.incallui.clean.data.datasource;

import I1.b;
import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.telecom.CallAudioState;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.Call;
import com.android.incallui.Log;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.y;
import java.util.Collection;
import java.util.Iterator;
import v9.l;

/* compiled from: CallAudioRepository.kt */
/* loaded from: classes.dex */
public final class CallAudioRepository implements I1.b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f18298e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f18299a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public Integer f18300b;

    /* renamed from: c, reason: collision with root package name */
    public final com.android.incallui.mvvm.utils.h<CallAudioState> f18301c;

    /* renamed from: d, reason: collision with root package name */
    public final y<Boolean> f18302d;

    /* compiled from: CallAudioRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public CallAudioRepository() {
        com.android.incallui.mvvm.repository.dynamic.a aVar = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
        this.f18301c = aVar.G();
        this.f18302d = IgnoreEqualsLiveDataKt.C(aVar.G(), false, new l<CallAudioState, Boolean>() { // from class: com.android.incallui.clean.data.datasource.CallAudioRepository$isSpeakerOn$1
            {
                super(1);
            }

            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(CallAudioState it) {
                boolean z10;
                kotlin.jvm.internal.i.f(it, "it");
                int audioMode = CallAudioRepository.this.h1().getAudioMode();
                CallAudioRepository callAudioRepository = CallAudioRepository.this;
                if (audioMode == 8) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    callAudioRepository.f18300b = Integer.valueOf(audioMode);
                }
                return Boolean.valueOf(z10);
            }
        }, 1, null);
    }

    public static final void I1(CallAudioRepository this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        int E12 = this$0.E1();
        Log.d("CallAudioRepository", "turnOffSpeaker: old mode = " + this$0.f18300b + ", next mode = " + E12);
        if (E12 == 128) {
            OplusPhoneUtils.putUserSwitchRoute(128);
        }
        this$0.F1().setAudioRoute(E12);
        this$0.z().m(Boolean.FALSE);
    }

    public static final void J1(CallAudioRepository this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Log.d("CallAudioRepository", "asyncTurnOnSpeaker: ");
        OplusPhoneUtils.putUserSwitchRoute(8);
        this$0.F1().setAudioRoute(8);
        this$0.z().m(Boolean.TRUE);
    }

    public static final void k0(CallAudioRepository this$0, Integer num) {
        int i10;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Application N02 = this$0.N0();
        if (num != null) {
            i10 = num.intValue();
        } else {
            i10 = 0;
        }
        OplusPhoneUtils.changeCallCastAudioModeForPcOrPad(N02, i10, this$0.r1());
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return b.a.e(this);
    }

    @Override // I1.b
    public void D0(final Integer num) {
        this.f18299a.post(new Runnable() { // from class: com.android.incallui.clean.data.datasource.b
            @Override // java.lang.Runnable
            public final void run() {
                CallAudioRepository.k0(CallAudioRepository.this, num);
            }
        });
    }

    public A2.l D1() {
        return b.a.d(this);
    }

    public final int E1() {
        Integer num = this.f18300b;
        if (num != null) {
            if (!G1(num.intValue())) {
                num = null;
            }
            if (num != null) {
                int intValue = num.intValue();
                if ((intValue & 2) != 0 && e0()) {
                    return 5;
                }
                return intValue;
            }
        }
        if (G1(D2.a.f421b)) {
            if (e0()) {
                return 5;
            }
            return 2;
        }
        if (G1(D2.a.f422c)) {
            return 4;
        }
        return 1;
    }

    @Override // I1.b
    public boolean F(int i10) {
        if ((i10 & 1) != 0) {
            return true;
        }
        return false;
    }

    public TelecomAdapter F1() {
        return b.a.f(this);
    }

    public final boolean G1(int i10) {
        if (i10 == (AudioModeProvider.getInstance().getSupportedModes() & i10)) {
            return true;
        }
        return false;
    }

    @Override // I1.b
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public y<Boolean> z() {
        return this.f18302d;
    }

    public Application N0() {
        return b.a.a(this);
    }

    @Override // I1.b
    public void b() {
        OplusPhoneUtils.silenceRinger(N0());
    }

    @Override // I1.b
    public void c() {
        this.f18299a.post(new Runnable() { // from class: com.android.incallui.clean.data.datasource.a
            @Override // java.lang.Runnable
            public final void run() {
                CallAudioRepository.I1(CallAudioRepository.this);
            }
        });
    }

    public final boolean e0() {
        Collection<BluetoothDevice> supportedBluetoothDevices = h1().getAudioState().getSupportedBluetoothDevices();
        kotlin.jvm.internal.i.e(supportedBluetoothDevices, "audioModeProvider.audioS…supportedBluetoothDevices");
        Collection<BluetoothDevice> collection = supportedBluetoothDevices;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!D1().g(((BluetoothDevice) it.next()).getAddress())) {
                return false;
            }
        }
        return true;
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        b.a.g(this);
    }

    @Override // I1.b
    public int g1() {
        return com.android.incallui.mvvm.repository.dynamic.a.f18559a.B();
    }

    public AudioModeProvider h1() {
        return b.a.b(this);
    }

    @Override // I1.b
    public void j() {
        this.f18299a.post(new Runnable() { // from class: com.android.incallui.clean.data.datasource.c
            @Override // java.lang.Runnable
            public final void run() {
                CallAudioRepository.J1(CallAudioRepository.this);
            }
        });
    }

    @Override // I1.b
    public void k(Call call, boolean z10) {
        kotlin.jvm.internal.i.f(call, "call");
        h1().autoTurnOnSpeaker(call, z10);
    }

    @Override // I1.b
    public boolean l0(int i10) {
        if ((i10 & 128) != 0) {
            return true;
        }
        return false;
    }

    @Override // I1.b
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public com.android.incallui.mvvm.utils.h<CallAudioState> b1() {
        return this.f18301c;
    }

    @Override // I1.b
    public boolean p0() {
        return AudioModeProvider.getInstance().isShowBluetoothIcon();
    }

    public OplusCallList r1() {
        return b.a.c(this);
    }

    @Override // I1.b
    public boolean s0(int i10) {
        if ((i10 & 64) != 0) {
            return true;
        }
        return false;
    }

    @Override // I1.b
    public boolean u1(CallAudioState callAudioState) {
        Boolean bool;
        Collection<BluetoothDevice> supportedBluetoothDevices;
        if (callAudioState != null && (supportedBluetoothDevices = callAudioState.getSupportedBluetoothDevices()) != null) {
            Collection<BluetoothDevice> collection = supportedBluetoothDevices;
            boolean z10 = false;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (A2.l.d().g(((BluetoothDevice) it.next()).getAddress())) {
                        z10 = true;
                        break;
                    }
                }
            }
            bool = Boolean.valueOf(z10);
        } else {
            bool = null;
        }
        Log.d("CallAudioRepository", "isWatchSupport: " + bool);
        return kotlin.jvm.internal.i.b(bool, Boolean.TRUE);
    }
}
