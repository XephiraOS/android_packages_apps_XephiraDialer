package com.android.incallui;

import android.os.Handler;
import android.os.Looper;
import android.telecom.CallAudioState;
import com.android.incallui.AudioModeProvider;
import com.android.oplus.module.castScreen.CastScreen;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class AudioModeProvider implements O2.a {
    private static final String LOGTAG = "AudioModeProvider";
    private static final String LOG_TAG = "AudioModeProvider";
    public static final int SUPPORTED_AUDIO_ROUTE_ALL = 15;
    private static AudioModeProvider sAudioModeProvider = new AudioModeProvider();
    public int mAudioMode = 1;
    private CallAudioState mAudioState;
    public int mCastScreenAudioMode;
    public int mCastScreenSupportedModes;
    public int mCurrentAudioState;
    private final C8.c<Boolean> mCurrentMuted;
    private Handler mHandler;
    private final List<AudioModeListener> mListeners;
    private int mSupportedModes;

    @Deprecated
    private AudioModeProvider() {
        C8.c<Boolean> cVar = new C8.c<>(Boolean.FALSE);
        this.mCurrentMuted = cVar;
        this.mSupportedModes = 15;
        this.mCastScreenAudioMode = 0;
        this.mCastScreenSupportedModes = 0;
        this.mCurrentAudioState = 1;
        this.mListeners = com.google.common.collect.n.f();
        this.mAudioState = new CallAudioState(false, 1, 15);
        this.mHandler = null;
        cVar.addObserver(new Observer() { // from class: com.android.incallui.a
            @Override // java.util.Observer
            public final void update(Observable observable, Object obj) {
                AudioModeProvider.this.lambda$new$1(observable, obj);
            }
        });
        CastScreen.f19196a.a().b(this);
    }

    public static int getAutoTurnOnSpeakerDelayTime(Call call) {
        if (call == null || !OplusPhoneUtils.isCrsCall(call)) {
            return 200;
        }
        if (OplusPhoneUtils.getOriginalCallType(call) == 0) {
            return VibrateUtils.STRENGTH_OFFSET;
        }
        if (OplusPhoneUtils.getOriginalCallType(call) != 3 || call.getVideoState() != 0) {
            return 200;
        }
        return 900;
    }

    public static AudioModeProvider getInstance() {
        return sAudioModeProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$autoTurnOnSpeaker$2(boolean z10) {
        int audioMode = getAudioMode();
        if (Log.sDebug) {
            Log.d("AudioModeProvider", "autoTurnOnSpeaker audioMode = " + audioMode);
        }
        if (audioMode == 8) {
            return;
        }
        if (!z10) {
            int supportedModes = getInstance().getSupportedModes();
            if (isSupported(2) || isSupported(4)) {
                if (Log.sDebug) {
                    K2.a.e("AudioModeProvider", "autoTurnOnSpeaker has BLUETOOTH or WIRED_HEADSET = " + supportedModes);
                    return;
                }
                return;
            }
        }
        if (Log.sDebug) {
            K2.a.e("AudioModeProvider", "autoTurnOnSpeaker Sending new Audio Mode : speaker");
        }
        TelecomAdapter.getInstance().setAudioRoute(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Object obj, AudioModeListener audioModeListener) {
        audioModeListener.onMute(((Boolean) obj).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Observable observable, final Object obj) {
        this.mListeners.forEach(new Consumer() { // from class: com.android.incallui.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                AudioModeProvider.lambda$new$0(obj, (AudioModeProvider.AudioModeListener) obj2);
            }
        });
    }

    public void addListener(AudioModeListener audioModeListener) {
        if (!this.mListeners.contains(audioModeListener)) {
            this.mListeners.add(audioModeListener);
            audioModeListener.onSupportedAudioMode(getSupportedModes());
            audioModeListener.onAudioMode(getAudioMode());
            audioModeListener.onMute(getMute());
        }
    }

    public void autoTurnOnSpeaker(Call call, boolean z10) {
        autoTurnOnSpeaker(getAutoTurnOnSpeakerDelayTime(call), z10);
    }

    public int getAudioMode() {
        int i10;
        if (Log.sOplusDebug) {
            Log.d("AudioModeProvider", " get  AudioMode = " + this.mAudioMode + "  CastAudioMode = " + this.mCastScreenAudioMode);
        }
        if (CastScreen.f19196a.a().k0() && (i10 = this.mCastScreenAudioMode) != 0) {
            return i10;
        }
        return this.mAudioMode;
    }

    public CallAudioState getAudioState() {
        return this.mAudioState;
    }

    public boolean getMute() {
        return this.mCurrentMuted.b().booleanValue();
    }

    public int getSupportedModes() {
        if (Log.sOplusDebug) {
            Log.d("AudioModeProvider", " getSupportedModes = " + this.mSupportedModes + "  CastSupportedModes = " + this.mCastScreenSupportedModes);
        }
        if (CastScreen.f19196a.a().k0()) {
            return this.mCastScreenSupportedModes | this.mSupportedModes;
        }
        return this.mSupportedModes;
    }

    public boolean isShowBluetoothIcon() {
        if (OplusPhoneUtils.PRODUCT_FLAVOR == 1 && getAudioMode() == D2.a.f421b) {
            return true;
        }
        return false;
    }

    public boolean isSupported(int i10) {
        if (i10 == (getSupportedModes() & i10)) {
            return true;
        }
        return false;
    }

    public void onAudioModeChange(int i10, boolean z10) {
        int i11;
        int i12;
        if (this.mAudioMode != i10) {
            Log.d("AudioModeProvider", "Mode = " + this.mAudioMode + " -> " + i10);
            int i13 = this.mAudioMode;
            this.mAudioMode = i10;
            CastScreen.a aVar = CastScreen.f19196a;
            if (aVar.a().k0()) {
                int i14 = this.mAudioMode;
                if ((i14 == 2 || i14 == 4) && i13 == 1 && ((i11 = this.mCastScreenAudioMode) == 64 || i11 == 128)) {
                    aVar.a().a(0);
                } else if (i14 == 8 && this.mCurrentAudioState != i14 && ((i12 = this.mCastScreenAudioMode) == 64 || i12 == 128)) {
                    TelecomAdapter.getInstance().setAudioRouteToTelecom(5);
                }
                for (AudioModeListener audioModeListener : this.mListeners) {
                    int i15 = this.mCastScreenAudioMode;
                    if (i15 == 0) {
                        i15 = this.mAudioMode;
                    }
                    audioModeListener.onAudioMode(i15);
                }
            } else {
                Iterator<AudioModeListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().onAudioMode(this.mAudioMode);
                }
            }
        }
        this.mCurrentMuted.e(Boolean.valueOf(z10));
    }

    public void onAudioStateChanged(CallAudioState callAudioState) {
        this.mAudioState = callAudioState;
        Log.d("AudioModeProvider", "onAudioStateChanged = " + callAudioState);
        onAudioModeChange(callAudioState.getRoute(), callAudioState.isMuted());
        onSupportedAudioModeChange(callAudioState.getSupportedRouteMask());
        com.android.incallui.mvvm.repository.dynamic.a.f18559a.G().o(callAudioState);
    }

    public void onCastScreenAudioMode(int i10, boolean z10) {
        if (this.mCastScreenAudioMode != i10) {
            Log.d("AudioModeProvider", "CastScreen Mode = " + this.mCastScreenAudioMode + " -> " + i10);
            this.mCastScreenAudioMode = i10;
            if (i10 != 0) {
                Iterator<AudioModeListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().onAudioMode(this.mCastScreenAudioMode);
                }
            } else {
                Iterator<AudioModeListener> it2 = this.mListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onAudioMode(this.mAudioMode);
                }
            }
        }
        Log.d("AudioModeProvider", "CastScreen muted = " + z10);
        this.mCurrentMuted.e(Boolean.valueOf(z10));
        com.android.incallui.mvvm.repository.dynamic.a.f18559a.G().o(this.mAudioState);
    }

    public void onCastScreenSupportedAudioMode(int i10) {
        this.mCastScreenSupportedModes = i10;
        Log.d("AudioModeProvider", "CastScreen newModeMask = " + i10);
        Iterator<AudioModeListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSupportedAudioMode(this.mSupportedModes | this.mCastScreenSupportedModes);
        }
        com.android.incallui.mvvm.repository.dynamic.a.f18559a.G().o(this.mAudioState);
    }

    public void onSupportedAudioModeChange(int i10) {
        this.mSupportedModes = i10;
        Log.d("AudioModeProvider", " newModeMask = " + i10);
        if (CastScreen.f19196a.a().k0()) {
            Iterator<AudioModeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onSupportedAudioMode(this.mSupportedModes | this.mCastScreenSupportedModes);
            }
        } else {
            Iterator<AudioModeListener> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onSupportedAudioMode(this.mSupportedModes);
            }
        }
    }

    public void removeListener(AudioModeListener audioModeListener) {
        if (this.mListeners.contains(audioModeListener)) {
            this.mListeners.remove(audioModeListener);
        }
    }

    public void setCurrentAudioState(int i10) {
        this.mCurrentAudioState = i10;
    }

    public void setFakeMute(boolean z10) {
        this.mCurrentMuted.d(Boolean.valueOf(z10));
    }

    public void autoTurnOnSpeaker(int i10, final boolean z10) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.android.incallui.b
            @Override // java.lang.Runnable
            public final void run() {
                AudioModeProvider.this.lambda$autoTurnOnSpeaker$2(z10);
            }
        }, i10);
    }

    /* loaded from: classes.dex */
    public interface AudioModeListener {
        default void onAudioMode(int i10) {
        }

        default void onMute(boolean z10) {
        }

        default void onSupportedAudioMode(int i10) {
        }
    }
}
