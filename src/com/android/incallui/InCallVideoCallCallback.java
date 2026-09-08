package com.android.incallui;

import android.telecom.InCallService;
import android.telecom.VideoProfile;
import com.android.oplus.brand.BrandCenter;
import y2.C1703b;

/* loaded from: classes.dex */
public class InCallVideoCallCallback extends InCallService.VideoCall.Callback {
    private static final int MTK_STATE_BASE = 65536;
    public static final int STATE_CANCEL_UPGRADE = 65536;
    private Call mCall;
    C1703b mOplusVideoCallExt;
    private int mRequestedVideoState = 0;

    public InCallVideoCallCallback(Call call) {
        this.mCall = call;
        if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK && OplusFeatureOption.OPLUS_PHONE_VILTE_DATD_BITRATE) {
            this.mOplusVideoCallExt = new C1703b(OplusInCallApp.getAppContext());
        }
    }

    public int getRequestedVideoState() {
        return this.mRequestedVideoState;
    }

    @Override // android.telecom.InCallService.VideoCall.Callback
    public void onCallDataUsageChanged(long j10) {
        Log.d(this, "onCallDataUsageChanged: dataUsage = " + j10);
        InCallVideoCallCallbackNotifier.getInstance().callDataUsageChanged(j10);
    }

    @Override // android.telecom.InCallService.VideoCall.Callback
    public void onCallSessionEvent(int i10) {
        C1703b c1703b;
        InCallVideoCallCallbackNotifier.getInstance().callSessionEvent(this.mCall, i10);
        if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK && OplusFeatureOption.OPLUS_PHONE_VILTE_DATD_BITRATE && (c1703b = this.mOplusVideoCallExt) != null) {
            c1703b.b(this.mCall, i10);
        }
    }

    @Override // android.telecom.InCallService.VideoCall.Callback
    public void onCameraCapabilitiesChanged(VideoProfile.CameraCapabilities cameraCapabilities) {
        if (cameraCapabilities != null) {
            InCallVideoCallCallbackNotifier.getInstance().cameraDimensionsChanged(this.mCall, cameraCapabilities.getWidth(), cameraCapabilities.getHeight());
        }
    }

    @Override // android.telecom.InCallService.VideoCall.Callback
    public void onPeerDimensionsChanged(int i10, int i11) {
        InCallVideoCallCallbackNotifier.getInstance().peerDimensionsChanged(this.mCall, i10, i11);
    }

    @Override // android.telecom.InCallService.VideoCall.Callback
    public void onSessionModifyRequestReceived(VideoProfile videoProfile) {
        Log.d(this, " onSessionModifyRequestReceived videoProfile=" + videoProfile);
        int unPausedVideoState = CallUtils.getUnPausedVideoState(this.mCall.getVideoState());
        int unPausedVideoState2 = CallUtils.getUnPausedVideoState(videoProfile.getVideoState());
        InCallPresenter.getInstance().wakeUpScreen();
        if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK && unPausedVideoState2 == 65536) {
            InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoFail(4, this.mCall);
            this.mCall.setSessionModificationState(0);
            return;
        }
        boolean isVideoCall = CallUtils.isVideoCall(unPausedVideoState);
        boolean isVideoCall2 = CallUtils.isVideoCall(unPausedVideoState2);
        Log.d(this, " onSessionModifyRequestReceived  wasVideoCall  " + isVideoCall + "isVideoCall " + isVideoCall2 + " newVideoState =" + unPausedVideoState2 + " previousVideoState =" + unPausedVideoState);
        if (isVideoCall && !isVideoCall2) {
            InCallVideoCallCallbackNotifier.getInstance().downgradeToAudio(this.mCall);
            if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK) {
                this.mCall.getVideoCall().sendSessionModifyResponse(videoProfile);
                return;
            }
            return;
        }
        if (unPausedVideoState != unPausedVideoState2) {
            this.mRequestedVideoState = unPausedVideoState2;
            if (unPausedVideoState2 == 2 && (unPausedVideoState == 0 || unPausedVideoState == 3)) {
                if (OplusPhoneUtils.isCMCCNumberPrefix(CallList.getInstance().getActiveCall(), OplusInCallApp.getAppContext().getApplicationContext())) {
                    this.mCall.getVideoCall().sendSessionModifyResponse(videoProfile);
                    return;
                } else {
                    InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoRequest(this.mCall, unPausedVideoState2);
                    return;
                }
            }
            if (unPausedVideoState2 == 1) {
                this.mCall.getVideoCall().sendSessionModifyResponse(videoProfile);
                return;
            }
            if (unPausedVideoState2 == 3 && unPausedVideoState == 1) {
                if (R5.a.b()) {
                    InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoRequest(this.mCall, unPausedVideoState2);
                    return;
                } else {
                    this.mCall.getVideoCall().sendSessionModifyResponse(videoProfile);
                    return;
                }
            }
            if (unPausedVideoState2 == 3 && unPausedVideoState == 2) {
                if (OplusPhoneUtils.isCMCCNumberPrefix(CallList.getInstance().getActiveCall(), OplusInCallApp.getAppContext().getApplicationContext())) {
                    InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoRequest(this.mCall, unPausedVideoState2);
                    return;
                } else {
                    this.mCall.getVideoCall().sendSessionModifyResponse(videoProfile);
                    return;
                }
            }
            InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoRequest(this.mCall, unPausedVideoState2);
        }
    }

    @Override // android.telecom.InCallService.VideoCall.Callback
    public void onSessionModifyResponseReceived(int i10, VideoProfile videoProfile, VideoProfile videoProfile2) {
        Log.d(this, "onSessionModifyResponseReceived status=" + i10 + " requestedProfile=" + videoProfile + " responseProfile=" + videoProfile2);
        boolean z10 = true;
        if (i10 != 1) {
            if (videoProfile != null && videoProfile2 != null && CallUtils.isVideoCall(videoProfile.getVideoState()) && CallUtils.isVideoCall(videoProfile2.getVideoState())) {
                this.mCall.setSessionModificationState(0);
                Log.e(this, "onSessionModifyResponseReceived open or close local camera fail");
                return;
            }
            if (videoProfile != null && videoProfile2 != null && !CallUtils.isVideoCall(videoProfile.getVideoState()) && CallUtils.isVideoCall(videoProfile2.getVideoState())) {
                this.mCall.setSessionModificationState(0);
                Log.e(this, "onSessionModifyResponseReceived downgrade to audio call fail");
                this.mCall.setOplusClickToVoice(false);
                return;
            } else {
                if (i10 == 4) {
                    this.mCall.setSessionModificationState(4);
                } else if (i10 == 5) {
                    this.mCall.setSessionModificationState(5);
                } else {
                    this.mCall.setSessionModificationState(2);
                }
                this.mRequestedVideoState = 0;
                InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoFail(i10, this.mCall);
            }
        } else if (videoProfile != null && videoProfile2 != null) {
            if (videoProfile.getVideoState() != videoProfile2.getVideoState()) {
                z10 = false;
            }
            boolean isVideoCall = CallUtils.isVideoCall(videoProfile2.getVideoState());
            if (z10 && isVideoCall) {
                InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoSuccess(this.mCall);
                InCallAudioManager.getInstance().onModifyCallClicked(this.mCall, videoProfile2.getVideoState());
                this.mCall.setOplusClickToVoice(false);
            } else if (!z10 && isVideoCall) {
                InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoFail(i10, this.mCall);
            } else if (z10 && !isVideoCall) {
                InCallVideoCallCallbackNotifier.getInstance().downgradeToAudio(this.mCall);
            }
        } else {
            Log.d(this, "onSessionModifyResponseReceived request and response Profiles are null");
        }
        T5.a d10 = BrandCenter.f19187a.a().d();
        if (d10 != null) {
            d10.q(this.mCall.mContext, i10);
        }
        this.mCall.setSessionModificationState(0);
    }

    @Override // android.telecom.InCallService.VideoCall.Callback
    public void onVideoQualityChanged(int i10) {
        InCallVideoCallCallbackNotifier.getInstance().videoQualityChanged(this.mCall, i10);
    }
}
