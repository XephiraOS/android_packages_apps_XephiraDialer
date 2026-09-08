package com.android.incallui.mvvm.repository.dynamic;

import A2.l;
import android.bluetooth.BluetoothDevice;
import android.telecom.CallAudioState;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.mvvm.utils.h;
import d2.InterfaceC0949b;

/* compiled from: AudioBluetoothRepository.kt */
/* loaded from: classes.dex */
public final class a implements InterfaceC0949b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f18559a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final h<CallAudioState> f18560b = new h<>(new CallAudioState(false, 1, 1), false, 2, null);

    public final int B() {
        int audioMode = AudioModeProvider.getInstance().getAudioMode();
        if (audioMode == 4 && !k0() && e0()) {
            return 1;
        }
        return audioMode;
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return InterfaceC0949b.a.j(this);
    }

    public final boolean D1() {
        if ((B() & 128) != 0) {
            return true;
        }
        return false;
    }

    public final boolean E1() {
        if ((B() & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean F1() {
        String str;
        if (N0()) {
            BluetoothDevice activeBluetoothDevice = f18560b.getValue().getActiveBluetoothDevice();
            if (activeBluetoothDevice != null) {
                str = activeBluetoothDevice.getAddress();
            } else {
                str = null;
            }
            if (l.d().g(str)) {
                return true;
            }
        }
        return false;
    }

    public final h<CallAudioState> G() {
        return f18560b;
    }

    public final boolean G1() {
        if ((AudioModeProvider.getInstance().getSupportedModes() & 128) == 128) {
            return true;
        }
        return false;
    }

    public final boolean H1() {
        if ((AudioModeProvider.getInstance().getSupportedModes() & 8) == 8) {
            return true;
        }
        return false;
    }

    public final boolean N0() {
        if ((B() & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean c0() {
        if ((AudioModeProvider.getInstance().getSupportedModes() & 64) == 64) {
            return true;
        }
        return false;
    }

    public final boolean e0() {
        if ((AudioModeProvider.getInstance().getSupportedModes() & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        InterfaceC0949b.a.m(this);
    }

    public final boolean h1() {
        if ((B() & 64) != 0) {
            return true;
        }
        return false;
    }

    public final boolean k0() {
        if ((AudioModeProvider.getInstance().getSupportedModes() & 4) == 4) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        if ((AudioModeProvider.getInstance().getSupportedModes() & 2) == 2) {
            return true;
        }
        return false;
    }

    public final boolean o1() {
        if ((B() & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean r1() {
        if ((B() & 4) != 0) {
            return true;
        }
        return false;
    }
}
