package com.android.incallui.mvvm.view_model;

import D2.k;
import android.bluetooth.BluetoothDevice;
import android.telecom.CallAudioState;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.mvvm.base.BaseViewModel;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.usecase.FragmentStateUseCase;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.y;
import e2.C0966a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.i;
import m9.g;
import v9.l;

/* compiled from: ActionButtonViewModel.kt */
/* loaded from: classes.dex */
public final class ActionButtonViewModel extends BaseViewModel {

    /* renamed from: d, reason: collision with root package name */
    public final y<Boolean> f18660d = IgnoreEqualsLiveDataKt.D(FragmentStateUseCase.f18563a.d(), false, new l<Boolean, Boolean>() { // from class: com.android.incallui.mvvm.view_model.ActionButtonViewModel$mDialPadVisible$1
        public final Boolean b(boolean z10) {
            Boolean valueOf = Boolean.valueOf(z10);
            Log.d("ActionButtonViewModel", "mDialPadVisible = " + z10);
            return valueOf;
        }

        @Override // v9.l
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
            return b(bool.booleanValue());
        }
    }, 1, null);

    /* renamed from: e, reason: collision with root package name */
    public final List<C0966a> f18661e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final y<List<C0966a>> f18662f;

    /* renamed from: g, reason: collision with root package name */
    public final y<Integer> f18663g;

    /* renamed from: h, reason: collision with root package name */
    public final y<Boolean> f18664h;

    /* renamed from: i, reason: collision with root package name */
    public final y<Triple<Integer, Integer, Integer>> f18665i;

    /* renamed from: j, reason: collision with root package name */
    public final y<Integer> f18666j;

    public ActionButtonViewModel() {
        y<List<C0966a>> yVar = new y<>(false, 1, null);
        this.f18662f = yVar;
        this.f18663g = IgnoreEqualsLiveDataKt.D(ResponsiveConfigRepository.f18540a.o1(), false, new l<Double, Integer>() { // from class: com.android.incallui.mvvm.view_model.ActionButtonViewModel$mBottomShrinkPadding$1
            {
                super(1);
            }

            public final Integer b(double d10) {
                Integer valueOf = Integer.valueOf(Math.max(ResponsiveConfigRepository.f18540a.N0().getValue().intValue(), (int) (ActionButtonViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.fragment_action_button_bottom_padding) * d10)));
                Log.d("ActionButtonViewModel", "mBottomShrinkPadding change to >>> " + valueOf.intValue());
                return valueOf;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Double d10) {
                return b(d10.doubleValue());
            }
        }, 1, null);
        com.android.incallui.mvvm.repository.dynamic.a aVar = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
        this.f18664h = IgnoreEqualsLiveDataKt.C(aVar.G(), false, new l<CallAudioState, Boolean>() { // from class: com.android.incallui.mvvm.view_model.ActionButtonViewModel$mAudioModeActivated$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(CallAudioState callAudioState) {
                boolean z10;
                i.f(callAudioState, "<anonymous parameter 0>");
                com.android.incallui.mvvm.repository.dynamic.a aVar2 = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
                if (aVar2.B() != 8 && !aVar2.c0() && !aVar2.o() && !aVar2.G1()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                Boolean valueOf = Boolean.valueOf(z10);
                Log.d("ActionButtonViewModel", "mAudioModeActivated = " + z10);
                return valueOf;
            }
        }, 1, null);
        this.f18665i = IgnoreEqualsLiveDataKt.u(aVar.G(), true, new l<CallAudioState, Triple<? extends Integer, ? extends Integer, ? extends Integer>>() { // from class: com.android.incallui.mvvm.view_model.ActionButtonViewModel$mAudioImageInfo$1
            {
                super(1);
            }

            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Triple<Integer, Integer, Integer> invoke(CallAudioState audioState) {
                boolean z10;
                i.f(audioState, "audioState");
                com.android.incallui.mvvm.repository.dynamic.a aVar2 = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
                if (!aVar2.o() && !aVar2.c0() && !aVar2.G1()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                boolean F12 = aVar2.F1();
                ActionButtonViewModel.this.o(audioState);
                int B10 = aVar2.B();
                Log.d("ActionButtonViewModel", "mAudioImageInfo = " + z10 + " >>> " + F12 + " >>> " + B10);
                if (B10 != 1) {
                    if (B10 != 2) {
                        if (B10 != 4) {
                            if (B10 != 8) {
                                if (B10 != 64) {
                                    if (B10 != 128) {
                                        return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_speaker), Integer.valueOf(R.drawable.incall_btn_audiomode_speaker_selected)), Integer.valueOf(R.string.oplus_audio_mode_speaker_string));
                                    }
                                    return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_pc), Integer.valueOf(R.drawable.incall_btn_audiomode_pc_selected)), Integer.valueOf(R.string.oplus_audio_mode_pc_string));
                                }
                                return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_ocar), Integer.valueOf(R.drawable.incall_btn_audiomode_ocar_selected)), Integer.valueOf(R.string.oplus_audio_mode_ocar_string));
                            }
                            return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_speaker), Integer.valueOf(R.drawable.incall_btn_audiomode_speaker_selected)), Integer.valueOf(R.string.oplus_audio_mode_speaker_string));
                        }
                        if (z10) {
                            return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_headset), Integer.valueOf(R.drawable.incall_btn_audiomode_headset_selected)), Integer.valueOf(R.string.oplus_audio_mode_wired_headset_string));
                        }
                        return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_speaker), Integer.valueOf(R.drawable.incall_btn_audiomode_speaker_selected)), Integer.valueOf(R.string.oplus_audio_mode_speaker_string));
                    }
                    if (F12) {
                        return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_watch), Integer.valueOf(R.drawable.incall_btn_audiomode_watch_selected)), Integer.valueOf(R.string.oplus_audio_mode_bluetooth_string));
                    }
                    return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_bluetooth), Integer.valueOf(R.drawable.incall_btn_audiomode_bluetooth_selected)), Integer.valueOf(R.string.oplus_audio_mode_bluetooth_string));
                }
                if (z10) {
                    return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_earpiece), Integer.valueOf(R.drawable.incall_btn_audiomode_earpiece_selected)), Integer.valueOf(R.string.oplus_audio_mode_earpiece_string));
                }
                return IgnoreEqualsLiveDataKt.s(g.a(Integer.valueOf(R.drawable.incall_btn_audiomode_speaker), Integer.valueOf(R.drawable.incall_btn_audiomode_speaker_selected)), Integer.valueOf(R.string.oplus_audio_mode_speaker_string));
            }
        });
        this.f18666j = IgnoreEqualsLiveDataKt.t(yVar, 0, true, new l<List<C0966a>, Integer>() { // from class: com.android.incallui.mvvm.view_model.ActionButtonViewModel$mAudioModeInfoListSize$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(List<C0966a> list) {
                Integer valueOf = Integer.valueOf(list.size());
                Log.d("ActionButtonViewModel", "mAudioModeInfoListSize = " + valueOf.intValue());
                return valueOf;
            }
        });
    }

    public final y<Triple<Integer, Integer, Integer>> i() {
        return this.f18665i;
    }

    public final y<Boolean> j() {
        return this.f18664h;
    }

    public final y<List<C0966a>> k() {
        return this.f18662f;
    }

    public final y<Integer> l() {
        return this.f18666j;
    }

    public final y<Integer> m() {
        return this.f18663g;
    }

    public final boolean n(BluetoothDevice bluetoothDevice) {
        Boolean bool;
        i.f(bluetoothDevice, "bluetoothDevice");
        Object a10 = k.a(bluetoothDevice, "isLeOnlyDevice");
        if (a10 instanceof Boolean) {
            bool = (Boolean) a10;
        } else {
            bool = null;
        }
        Log.d("ActionButtonViewModel", "isLeOnlyDevice: " + bool);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void o(CallAudioState callAudioState) {
        boolean z10;
        boolean z11;
        boolean z12;
        String str;
        this.f18661e.clear();
        BluetoothDevice activeBluetoothDevice = callAudioState.getActiveBluetoothDevice();
        Collection<BluetoothDevice> supportedBluetoothDevices = callAudioState.getSupportedBluetoothDevices();
        com.android.incallui.mvvm.repository.dynamic.a aVar = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
        if (aVar.H1()) {
            this.f18661e.add(new C0966a(null, R.string.oplus_audio_mode_speaker_string, R.drawable.incall_ic_audiomode_item_speaker, 8, null, aVar.E1(), false, 81, null));
        }
        if (aVar.e0()) {
            this.f18661e.add(new C0966a(null, R.string.oplus_audio_mode_earpiece_string, R.drawable.incall_ic_audiomode_item_earpiece, 1, null, aVar.o1(), false, 81, null));
        }
        ArrayList<BluetoothDevice> arrayList = new ArrayList();
        ArrayList<BluetoothDevice> arrayList2 = new ArrayList();
        if (supportedBluetoothDevices != null) {
            for (BluetoothDevice it : supportedBluetoothDevices) {
                A2.l d10 = A2.l.d();
                if (it != null) {
                    str = it.getAddress();
                } else {
                    str = null;
                }
                boolean g10 = d10.g(str);
                if (g10) {
                    i.e(it, "it");
                    arrayList2.add(it);
                }
                if (!g10) {
                    i.e(it, "it");
                    if (!n(it)) {
                        arrayList.add(it);
                    }
                }
            }
        }
        boolean N02 = com.android.incallui.mvvm.repository.dynamic.a.f18559a.N0();
        for (BluetoothDevice bluetoothDevice : arrayList) {
            List<C0966a> list = this.f18661e;
            String alias = OplusPhoneUtils.getAlias(bluetoothDevice);
            int i10 = R.string.oplus_audio_mode_bluetooth_string;
            int i11 = R.drawable.incall_ic_audiomode_item_bluetooth;
            if (N02 && i.b(activeBluetoothDevice, bluetoothDevice)) {
                z12 = true;
            } else {
                z12 = false;
            }
            list.add(new C0966a(alias, i10, i11, 2, bluetoothDevice, z12, false, 64, null));
        }
        com.android.incallui.mvvm.repository.dynamic.a aVar2 = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
        if (aVar2.k0()) {
            this.f18661e.add(new C0966a(null, R.string.oplus_audio_mode_wired_headset_string, R.drawable.incall_ic_audiomode_item_headset, 4, null, aVar2.r1(), false, 81, null));
        }
        for (BluetoothDevice bluetoothDevice2 : arrayList2) {
            if (N02 && i.b(activeBluetoothDevice, bluetoothDevice2)) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f18661e.add(new C0966a(OplusPhoneUtils.getAlias(bluetoothDevice2), R.string.oplus_audio_mode_bluetooth_string, R.drawable.incall_ic_audiomode_item_watch, 2, bluetoothDevice2, z11, z11));
        }
        com.android.incallui.mvvm.repository.dynamic.a aVar3 = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
        if (aVar3.c0()) {
            this.f18661e.add(new C0966a(null, R.string.oplus_audio_mode_ocar_string, R.drawable.incall_ic_audiomode_item_ocar, 64, null, aVar3.h1(), false, 81, null));
        }
        if (aVar3.G1()) {
            List<C0966a> list2 = this.f18661e;
            int i12 = R.string.oplus_audio_mode_pc_string;
            int i13 = R.drawable.incall_ic_audiomode_item_pc;
            boolean D12 = aVar3.D1();
            if ((!aVar3.o() || OplusPhoneUtils.hasWatchDevice()) && !aVar3.k0()) {
                z10 = true;
            } else {
                z10 = false;
            }
            list2.add(new C0966a(null, i12, i13, 128, null, D12, z10, 17, null));
        }
        List<C0966a> list3 = this.f18661e;
        this.f18662f.o(list3);
        Log.d("ActionButtonViewModel", "mAudioModeInfoList = " + list3.size());
    }
}
