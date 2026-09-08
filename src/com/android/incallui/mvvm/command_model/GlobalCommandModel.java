package com.android.incallui.mvvm.command_model;

import D2.g;
import android.bluetooth.BluetoothDevice;
import b2.InterfaceC0519a;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusCallButtonFragment;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.VideoCallPresenter;
import com.android.incallui.mvvm.utils.A;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: GlobalCommandModel.kt */
/* loaded from: classes.dex */
public final class GlobalCommandModel {

    /* renamed from: a, reason: collision with root package name */
    public static final GlobalCommandModel f18535a = new GlobalCommandModel();

    /* renamed from: b, reason: collision with root package name */
    public static final l<Integer, q> f18536b = new l<Integer, q>() { // from class: com.android.incallui.mvvm.command_model.GlobalCommandModel$applyAudioMode$1
        public final void b(int i10) {
            Log.d("GlobalCommandModel", "applyAudioMode " + i10);
            TelecomAdapter.getInstance().setAudioRoute(i10);
        }

        @Override // v9.l
        public /* bridge */ /* synthetic */ q invoke(Integer num) {
            b(num.intValue());
            return q.f35511a;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final l<BluetoothDevice, q> f18537c = new l<BluetoothDevice, q>() { // from class: com.android.incallui.mvvm.command_model.GlobalCommandModel$applyBluetoothAudioMode$1
        public final void b(BluetoothDevice bluetoothDevice) {
            i.f(bluetoothDevice, "bluetoothDevice");
            Log.d("GlobalCommandModel", "applyBluetoothAudioMode " + g.o(bluetoothDevice));
            TelecomAdapter.getInstance().requestBluetoothAudio(bluetoothDevice);
        }

        @Override // v9.l
        public /* bridge */ /* synthetic */ q invoke(BluetoothDevice bluetoothDevice) {
            b(bluetoothDevice);
            return q.f35511a;
        }
    };

    public final void a() {
        boolean z10;
        VideoCallPresenter videoCallPresenter;
        OplusCallButtonFragment c10;
        VideoCallPresenter videoCallPresenter2;
        InCallPresenter inCallPresenter = InCallPresenter.getInstance();
        boolean z11 = false;
        if (inCallPresenter != null && (videoCallPresenter2 = inCallPresenter.getVideoCallPresenter()) != null) {
            z10 = videoCallPresenter2.isIsRingToneMode();
        } else {
            z10 = false;
        }
        InterfaceC0519a a10 = A.a();
        if (a10 != null && (c10 = a10.c()) != null) {
            z11 = c10.getIsVideoCall();
        }
        if ((z10 || z11) && (videoCallPresenter = InCallPresenter.getInstance().getVideoCallPresenter()) != null) {
            videoCallPresenter.doAutoToggleFullScreen();
        }
    }

    public final l<Integer, q> b() {
        return f18536b;
    }

    public final l<BluetoothDevice, q> c() {
        return f18537c;
    }
}
