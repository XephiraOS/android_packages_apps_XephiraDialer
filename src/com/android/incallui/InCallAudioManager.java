package com.android.incallui;

import android.telecom.VideoProfile;

/* loaded from: classes.dex */
public class InCallAudioManager {
    private static final String LOG_TAG = "InCallAudioManager";
    private static InCallAudioManager sInCallAudioManager;

    private InCallAudioManager() {
    }

    private static boolean canEnableSpeaker(int i10, int i11) {
        if (!VideoProfile.isVideo(i10) && VideoProfile.isVideo(i11) && isSpeakerEnabledForVideoCalls()) {
            return true;
        }
        return false;
    }

    private static void enableEarpiece() {
        TelecomAdapter telecomAdapter = TelecomAdapter.getInstance();
        if (telecomAdapter == null) {
            Log.e(LOG_TAG, "enableEarpiece: TelecomAdapter is null");
            return;
        }
        int audioMode = AudioModeProvider.getInstance().getAudioMode();
        Log.v(LOG_TAG, "enableEarpiece: Current audio mode is - " + audioMode);
        if (QtiCallUtils.isNotEnabled(7, audioMode)) {
            Log.v(LOG_TAG, "enableEarpiece: Set audio route to earpiece");
            telecomAdapter.setAudioRoute(1);
        }
    }

    public static void enableSpeaker() {
        com.android.incallui.mvvm.repository.dynamic.a aVar = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
        if (!aVar.D1() && !aVar.h1()) {
            TelecomAdapter telecomAdapter = TelecomAdapter.getInstance();
            if (telecomAdapter == null) {
                Log.e(LOG_TAG, "enableSpeaker: TelecomAdapter is null");
                return;
            }
            int audioMode = AudioModeProvider.getInstance().getAudioMode();
            Log.v(LOG_TAG, "enableSpeaker: Current audio mode is - " + audioMode);
            if (QtiCallUtils.isNotEnabled(14, audioMode)) {
                Log.v(LOG_TAG, "enableSpeaker: Set audio route to speaker");
                telecomAdapter.setAudioRoute(8);
            }
        }
    }

    public static synchronized InCallAudioManager getInstance() {
        InCallAudioManager inCallAudioManager;
        synchronized (InCallAudioManager.class) {
            try {
                if (sInCallAudioManager == null) {
                    sInCallAudioManager = new InCallAudioManager();
                }
                inCallAudioManager = sInCallAudioManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return inCallAudioManager;
    }

    private static boolean isSpeakerEnabledForVideoCalls() {
        return true;
    }

    public void onAcceptUpgradeRequest(Call call, int i10) {
        Log.v(this, "onAcceptUpgradeRequest: Call = " + call + "video state = " + i10);
        if (canEnableSpeaker(call.getVideoState(), i10)) {
            enableSpeaker();
        }
    }

    public void onMergeClicked() {
        Log.v(this, "onMergeClicked");
        if (CallUtils.isVideoCall(CallList.getInstance().getBackgroundCall()) || CallUtils.isVideoCall(CallList.getInstance().getActiveCall())) {
            enableSpeaker();
        }
    }

    public void onModifyCallClicked(Call call, int i10) {
        Log.v(this, "onModifyCallClicked: Call = " + call + "new video state = " + i10);
        if (!VideoProfile.isVideo(i10)) {
            enableEarpiece();
            return;
        }
        if (canEnableSpeaker(call.getVideoState(), i10) && !OplusPhoneUtils.isVideoCrbt(call, i10)) {
            enableSpeaker();
        } else if (call.getSessionModificationState() == 1) {
            enableSpeaker();
        }
    }
}
