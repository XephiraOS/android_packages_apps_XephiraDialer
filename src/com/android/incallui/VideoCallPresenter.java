package com.android.incallui;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telecom.Call;
import android.telecom.InCallService;
import android.telecom.VideoProfile;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.InCallPresenter;
import com.android.incallui.InCallVideoCallCallbackNotifier;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.usecase.VideoBackgroundUseCase;
import com.android.oplus.brand.BrandCenter;
import e2.C0968c;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class VideoCallPresenter extends Presenter<VideoCallUi> implements InCallPresenter.IncomingCallListener, InCallPresenter.InCallOrientationListener, InCallPresenter.InCallStateListener, InCallPresenter.InCallDetailsListener, InCallVideoCallCallbackNotifier.SurfaceChangeListener, InCallVideoCallCallbackNotifier.VideoEventListener, InCallPresenter.InCallEventListener, InCallUiStateNotifierListener, CallList.CallUpdateListener {
    private static final int OPLUS_MSG_AUTO_TOOGLE_FULL_SCREEN = 1;
    private static final int OPLUS_MSG_AUTO_TOOGLE_FULL_SCREEN_DELAY = 10000;
    private static final int OPLUS_MSG_VIDEO_RING_TONE_TOOGLE_FULL_SCREEN_DELAY = 5000;
    private static final int OPLUS_RESET_TEXTUREVIEW_ALPHA_FIRST_VIDEO_CALL_AFTER_RESET_PHONE_DELAY = 800;
    private static final int OPLUS_RESET_TEXTUREVIEW_ALPHA_LONG_DELAY = 1500;
    private static final int OPLUS_RESET_TEXTUREVIEW_ALPHA_MIDDLE_DELAY = 550;
    private static final int OPLUS_RESET_TEXTUREVIEW_ALPHA_SHORT_DELAY = 450;
    private static final int OPLUS_SHOW_DISPLAY_VIDEO_PAUSE_DELAY = 1000;
    private static final int OPLUS_SHOW_DOWNGRADE_TO_AUDIO_DELAY = 800;
    public static final int SESSION_EVENT_RX_PAUSE = 4011;
    public static final int SESSION_EVENT_RX_RESUME = 4012;
    public static final String TAG = "VideoCallPresenter";
    private static boolean mIsRingToneMode = false;
    private static boolean mIsVideoMode = false;
    private InCallCameraManager mCameraManager;
    private Context mContext;
    private int mCurrentVideoState;
    private int mDownPointX;
    private int mDownPointY;
    private Handler mHandler;
    private Animation mHideCallButtonAnimation;
    private boolean mIsInBackground;
    private int mLastX;
    private int mLastY;
    private float mMinimumVideoDimension;
    private Call mOplusPrimaryCall;
    private Call mPrimaryCall;
    private Animation mShowCallButtonAnimation;
    private int mSmallSurfaceLeftMinMargin;
    private int mSmallSurfaceRightMargin;
    private int mSmallSurfaceRoundRect;
    private int mSmallSurfaceTopMargin;
    private int mUpPointX;
    private int mUpPointY;
    private InCallService.VideoCall mVideoCall;
    private int mVideoSmallSurfaceHeight;
    private int mVideoSmallSurfaceWidth;
    private Runnable mAutoFullscreenRunnable = new Runnable() { // from class: com.android.incallui.VideoCallPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoCallPresenter.this.mAutoFullScreenPending && !InCallPresenter.getInstance().isDialpadVisible()) {
                if (Log.sDebug) {
                    Log.v(VideoCallPresenter.TAG, "Automatically entering fullscreen mode.");
                }
                InCallPresenter.getInstance().setFullScreen(true);
                VideoCallPresenter.this.mAutoFullScreenPending = false;
                return;
            }
            if (Log.sDebug) {
                Log.v(VideoCallPresenter.TAG, "Skipping scheduled fullscreen mode.");
            }
        }
    };
    private int mCurrentCallState = 0;
    private int mDeviceOrientation = 0;
    private int mPreviewSurfaceState = 0;
    private ContactInfoCache.ContactCacheEntry mProfileInfo = null;
    private boolean mIsAutoFullscreenEnabled = false;
    private int mAutoFullscreenTimeoutMillis = 0;
    private boolean mAutoFullScreenPending = false;
    private boolean mAllowedToggleFullScreen = false;
    private int mOplusSmallSurface = 2;
    private boolean mOplusNeedShowVideoPause = true;
    private boolean mOplusCanShowVideoPause = false;
    private int mLeft = 0;
    private int mTop = 0;
    private int mRight = 0;
    private int mBottom = 0;
    private boolean mOplusFirstEnterVideoMode = false;
    private boolean mFirstShowPreviewSmallSurface = false;
    private boolean mOplusIsFullScreen = false;
    private final androidx.lifecycle.w<Integer> mStatusObserver = new androidx.lifecycle.w<Integer>() { // from class: com.android.incallui.VideoCallPresenter.3
        @Override // androidx.lifecycle.w
        public void onChanged(Integer num) {
            Log.d(VideoCallPresenter.TAG, "onChanged...status = " + num);
            if (VideoCallPresenter.this.mPrimaryCall == null || !CallUtils.isVideoCall(VideoCallPresenter.this.mPrimaryCall) || VideoCallPresenter.this.getUi() == null) {
                return;
            }
            int currentRotation = VideoCallPresenter.this.getUi().getCurrentRotation();
            if (Log.sDebug) {
                Log.d(VideoCallPresenter.TAG, "observeFoldScreenChange rotation:" + currentRotation + " mDeviceOrientation:" + VideoCallPresenter.this.mDeviceOrientation);
            }
            if (num.intValue() == 1 && !L1.c.f() && VideoCallPresenter.this.getUi() != null && VideoCallPresenter.this.getUi().oplusGetDispalyVideoTextureView() != null) {
                VideoCallPresenter.this.getUi().oplusGetDispalyVideoTextureView().setRotation(0.0f);
            }
            if (num.intValue() == 0 && !Call.State.isConnectingOrDialingOrIncomming(VideoCallPresenter.this.mPrimaryCall.getState()) && VideoCallPresenter.this.getUi() != null && VideoCallPresenter.this.getUi().oplusGetDispalyVideoTextureView() != null) {
                VideoCallPresenter.this.getUi().oplusGetDispalyVideoTextureView().setRotation(VideoCallPresenter.this.mDeviceOrientation);
            }
            if (VideoCallPresenter.this.mPrimaryCall.isActive()) {
                VideoCallPresenter videoCallPresenter = VideoCallPresenter.this;
                videoCallPresenter.oplusRefreshFrameLayoutLayoutParams(videoCallPresenter.mOplusSmallSurface, true);
                VideoCallPresenter videoCallPresenter2 = VideoCallPresenter.this;
                videoCallPresenter2.refreshSmallSurfaceFrameLayout(videoCallPresenter2.mOplusSmallSurface);
            }
        }
    };
    private Runnable oplusShowDowngradeToAudioRunnable = new Runnable() { // from class: com.android.incallui.VideoCallPresenter.6
        @Override // java.lang.Runnable
        public void run() {
            if (VideoCallPresenter.this.mPrimaryCall != null && VideoCallPresenter.this.mContext != null && VideoCallPresenter.this.getUi() != null) {
                int state = VideoCallPresenter.this.mPrimaryCall.getState();
                if (Log.sDebug) {
                    Log.d(VideoCallPresenter.TAG, "oplusShowDowngradeToAudioRunnable :state = " + state);
                }
                if (state != 2 && !Call.State.isDisconnectingOrDisconnected(state)) {
                    if (!OplusPhoneUtils.isOplusVideoCallEnableAndImsRegistered(VideoCallPresenter.this.mPrimaryCall.getSlotId())) {
                        VideoCallPresenter.this.getUi().oplusDowngradeToAudioNotice(R.string.oplus_not_support_vt_local);
                    } else if (!VideoCallPresenter.this.mPrimaryCall.getOplusClickToVoice()) {
                        VideoCallPresenter.this.getUi().oplusDowngradeToAudioNotice(R.string.oplus_not_support_vt_remote);
                    }
                    VideoCallPresenter.this.mPrimaryCall.setOplusClickToVoice(false);
                }
            }
        }
    };
    private Runnable oplusShowDisplayVideoPauseRunnable = new Runnable() { // from class: com.android.incallui.VideoCallPresenter.7
        @Override // java.lang.Runnable
        public void run() {
            if (VideoCallPresenter.this.getUi() != null && VideoCallPresenter.mIsVideoMode && VideoCallPresenter.this.mOplusNeedShowVideoPause) {
                VideoCallPresenter.this.getUi().oplusShowDisplayVideoPause(true);
                if (VideoCallPresenter.this.mOplusPrimaryCall != null) {
                    VideoCallPresenter.this.mOplusPrimaryCall.setInComingVideoPaused(true);
                }
            }
        }
    };
    private Runnable oplusResetPreviewTextureViewAlphaRunnable = new Runnable() { // from class: com.android.incallui.VideoCallPresenter.8
        @Override // java.lang.Runnable
        public void run() {
            if (VideoCallPresenter.this.mCameraManager == null || VideoCallPresenter.this.mCameraManager.isUsingFrontFacingCamera() || !VideoCallPresenter.this.mOplusFirstEnterVideoMode) {
                VideoCallPresenter.this.setOplusFirstEnterVideoMode(false);
                if (VideoCallPresenter.this.getUi() != null) {
                    VideoCallPresenter.this.getUi().showPreviewVideoCallMask(VideoCallPresenter.this.isVideoCallCardVisible());
                }
                if (VideoCallPresenter.this.getUi() != null && VideoCallPresenter.this.getUi().oplusGetPreviewVideoTextureView() != null && VideoCallPresenter.mIsVideoMode) {
                    VideoCallPresenter.this.getUi().oplusGetPreviewVideoTextureView().setAlpha(1.0f);
                    if (ResponsiveConfigRepository.f18540a.F1() && !L1.c.f()) {
                        int rotation = OplusPhoneUtils.getRotation(OplusInCallApp.getDefaultDisplayUiContext());
                        if (Log.sDebug) {
                            Log.d(VideoCallPresenter.TAG, "oplusResetPreviewTextureViewAlphaRunnable : set preView rotation :" + rotation);
                        }
                        VideoCallPresenter.this.getUi().oplusGetPreviewVideoTextureView().setRotation(360 - (rotation * 90));
                    }
                    if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN && VideoCallPresenter.this.mPrimaryCall != null && VideoCallPresenter.this.mOplusSmallSurface == 1 && !Call.State.isConnectingOrDialingOrIncomming(VideoCallPresenter.this.mPrimaryCall.getState())) {
                        VideoCallPresenter.this.getUi().oplusShowPreviewVideoBackground(true);
                    }
                    if (Log.sDebug) {
                        Log.d(VideoCallPresenter.TAG, "oplusResetPreviewTextureViewAlphaRunnable re-setAlpha");
                        return;
                    }
                    return;
                }
                return;
            }
            Log.d(VideoCallPresenter.TAG, "oplusResetPreviewTextureViewAlphaRunnable return , it is not FrontFacingCamera first time");
            VideoCallPresenter.this.setOplusFirstEnterVideoMode(false);
        }
    };
    private Runnable oplusResetDisplayTextureViewAlphaRunnable = new Runnable() { // from class: com.android.incallui.VideoCallPresenter.9
        @Override // java.lang.Runnable
        public void run() {
            if (VideoCallPresenter.this.getUi() != null && VideoCallPresenter.this.getUi().oplusGetDispalyVideoTextureView() != null && VideoCallPresenter.mIsVideoMode) {
                if (VideoCallPresenter.this.mPrimaryCall != null && ((!VideoCallPresenter.this.mPrimaryCall.getIsVideoRingTone() && Call.State.isConnectingOrDialing(VideoCallPresenter.this.mPrimaryCall.getState())) || (!CallUtils.isInCommingCallRingtone(VideoCallPresenter.this.mContext, VideoCallPresenter.this.mPrimaryCall) && Call.State.isInComming(VideoCallPresenter.this.mPrimaryCall.getState())))) {
                    if (Log.sDebug) {
                        Log.d(VideoCallPresenter.TAG, "oplusResetDisplayTextureViewAlphaRunnable return for it's not video ringtone when dialing");
                        return;
                    }
                    return;
                }
                if (VideoCallPresenter.this.mPrimaryCall != null && !Call.State.isConnectingOrDialingOrIncomming(VideoCallPresenter.this.mPrimaryCall.getState()) && VideoCallPresenter.this.isNotFoldOpen()) {
                    VideoCallPresenter.this.getUi().oplusGetDispalyVideoTextureView().setRotation(VideoCallPresenter.this.mDeviceOrientation);
                }
                VideoCallPresenter.this.getUi().oplusGetDispalyVideoTextureView().setAlpha(1.0f);
                if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN) {
                    VideoCallPresenter.this.getUi().oplusShowDisplayVideoBackground(true);
                    VideoCallPresenter.this.getUi().showDisplayVideoCallMask(VideoCallPresenter.this.isVideoCallCardVisible());
                }
                if (Log.sDebug) {
                    Log.d(VideoCallPresenter.TAG, "oplusResetDisplayTextureViewAlphaRunnable re-setAlpha");
                }
                if (VideoCallPresenter.this.mPrimaryCall != null && Call.State.isConnectingOrDialingOrIncomming(VideoCallPresenter.this.mPrimaryCall.getState()) && VideoCallPresenter.this.getUi() != null && VideoCallPresenter.this.getUi().oplusGetDisplayVideoContainer() != null) {
                    VideoCallPresenter.this.getUi().oplusGetDisplayVideoContainer().bringToFront();
                    if (Log.sDebug) {
                        Log.d(VideoCallPresenter.TAG, "oplusResetDisplayTextureViewAlphaRunnable bring display to front");
                    }
                    VideoCallPresenter.this.updateVideoRingToneUIState(true);
                }
                if (VideoCallPresenter.this.mPrimaryCall != null && VideoCallPresenter.this.mPrimaryCall.getVideoState() == 2 && OplusPhoneUtils.isCMCCNumberPrefix(CallList.getInstance().getActiveCall(), OplusInCallApp.getAppContext().getApplicationContext()) && !Call.State.isConnectingOrDialingOrIncomming(VideoCallPresenter.this.mPrimaryCall.getState())) {
                    if (Log.sDebug) {
                        Log.d(VideoCallPresenter.TAG, "oplusResetDisplayTextureViewAlphaRunnable hide previewView");
                    }
                    VideoCallPresenter.this.updateVideoRingToneUIState(true);
                }
                if (VideoCallPresenter.this.mOplusSmallSurface == 1 && VideoCallPresenter.this.mPrimaryCall != null && !Call.State.isConnectingOrDialingOrIncomming(VideoCallPresenter.this.mPrimaryCall.getState()) && VideoCallPresenter.this.getUi() != null && VideoCallPresenter.this.getUi().oplusGetDisplayVideoContainer() != null) {
                    VideoCallPresenter.this.getUi().setPreviewSize(VideoCallPresenter.this.getUi().getScreenSize().x, VideoCallPresenter.this.getUi().getScreenSize().y);
                    if (Log.sDebug) {
                        Log.d(VideoCallPresenter.TAG, "oplusResetDisplayTextureViewAlphaRunnable bring display for SURFACE_DISPLAY");
                    }
                    VideoCallPresenter.this.getUi().oplusGetDisplayVideoContainer().bringToFront();
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public class PreviewSurfaceState {
        private static final int CAMERA_SET = 1;
        private static final int CAPABILITIES_RECEIVED = 2;
        private static final int NONE = 0;
        private static final int SURFACE_SET = 3;

        private PreviewSurfaceState() {
        }
    }

    /* loaded from: classes.dex */
    public interface VideoCallUi extends Ui {
        void adjustPreviewLocation(boolean z10, int i10);

        void cleanupSurfaces();

        int getCurrentRotation();

        Surface getDisplayVideoSurface();

        Point getPreviewSize();

        Surface getPreviewVideoSurface();

        Point getScreenSize();

        void hideVideoUi();

        boolean isDisplayVideoSurfaceCreated();

        boolean isPreviewVideoSurfaceCreated();

        void oplusDowngradeToAudioNotice(int i10);

        View oplusGetDispalyVideoTextureView();

        View oplusGetDisplayVideoContainer();

        View oplusGetPreviewVideoContainer();

        View oplusGetPreviewVideoTextureView();

        void oplusRefreshVideoSize(float f10);

        void oplusReleasePreviewSurface();

        void oplusSetDisplayVideoVisibility(boolean z10);

        void oplusSetPreviewVideoVisibility(boolean z10);

        void oplusSetVideoRatio(boolean z10, int i10, int i11);

        void oplusShowDisplayVideoBackground(boolean z10);

        void oplusShowDisplayVideoPause(boolean z10);

        void oplusShowPreviewVideoBackground(boolean z10);

        void oplusShowPreviewVideoPause(boolean z10);

        void setDisplayVideoSize(int i10, int i11);

        void setPreviewSize(int i10, int i11);

        void setPreviewSurfaceSize(int i10, int i11);

        void showDisplayVideoCallMask(boolean z10);

        void showPreviewVideoCallMask(boolean z10);

        void showVideoViews(boolean z10, boolean z11, int i10);
    }

    private void changePreviewDimensions(int i10, int i11) {
        float f10;
        VideoCallUi ui = getUi();
        if (ui == null) {
            return;
        }
        ui.setPreviewSurfaceSize(i10, i11);
        if (i10 > 0 && i11 > 0) {
            f10 = i10 / i11;
        } else {
            f10 = 1.0f;
        }
        setPreviewSize(this.mDeviceOrientation, f10);
    }

    private void changeVideoCall(Call call) {
        boolean z10;
        InCallService.VideoCall videoCall = call.getTelecommCall().getVideoCall();
        if (Log.sDebug) {
            Log.d(TAG, "changeVideoCall to videoCall=" + videoCall + " mVideoCall=" + this.mVideoCall);
        }
        if (this.mVideoCall == null && videoCall != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mVideoCall = videoCall;
        if (videoCall == null) {
            if (Log.sDebug) {
                Log.d(TAG, "Video call is null, return.");
            }
        } else if (CallUtils.isVideoCallorAudioCallRingtone(this.mContext, call) && z10) {
            enterVideoMode(call);
        }
    }

    private void checkForCallStateChange(Call call) {
        boolean z10;
        boolean isVideoCall = CallUtils.isVideoCall(call);
        if (this.mCurrentCallState != call.getState()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(TAG, "checkForCallStateChange: isVideoCall= " + isVideoCall + " hasCallStateChanged=" + z10 + " isVideoMode=" + isVideoMode());
        }
        if (!z10) {
            return;
        }
        if (isVideoCall) {
            InCallCameraManager inCallCameraManager = InCallPresenter.getInstance().getInCallCameraManager();
            String activeCameraId = inCallCameraManager.getActiveCameraId();
            updateCameraSelection(call);
            if ((!Objects.equals(activeCameraId, inCallCameraManager.getActiveCameraId()) || Call.State.isRing(this.mCurrentCallState)) && CallUtils.isActiveVideoCall(call)) {
                enableCamera(call.getVideoCall(), true);
            }
        }
        showVideoUi(call.getVideoState(), call.getState());
        if (isVideoCall && OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN && getUi() != null && getUi().oplusGetDispalyVideoTextureView() != null && call.getState() == 3 && isNotFoldOpen()) {
            if (Log.sDebug) {
                Log.d(TAG, "checkForCallStateChange: isVideoCall= " + isVideoMode());
            }
            getUi().oplusGetDispalyVideoTextureView().setRotation(this.mDeviceOrientation);
        }
    }

    private void checkForOrientationAllowedChange(Call call) {
        int currentOrientationMode = OrientationModeHandler.getInstance().getCurrentOrientationMode();
        int orientation = OrientationModeHandler.getInstance().getOrientation(call);
        if (orientation != currentOrientationMode) {
            InCallPresenter.getInstance().setInCallAllowsOrientationChange(call, orientation);
        }
    }

    private void checkForVideoCallChange(Call call) {
        InCallService.VideoCall videoCall = call.getTelecommCall().getVideoCall();
        if (Log.sDebug) {
            Log.d(TAG, "checkForVideoCallChange: videoCall=" + videoCall + " mVideoCall=" + this.mVideoCall);
        }
        if (!Objects.equals(videoCall, this.mVideoCall)) {
            changeVideoCall(call);
        }
    }

    private void checkForVideoStateChange(Call call) {
        boolean z10;
        boolean isVideoCall = CallUtils.isVideoCall(call);
        boolean z11 = true;
        if (this.mCurrentVideoState == call.getVideoState() && (!OplusPhoneUtils.isUstOplusExport() || !CallUtils.rejectVideoUpgradeRequest(call.getSessionModificationState()))) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d(TAG, "checkForVideoStateChange: isVideoCall= " + isVideoCall + " hasVideoStateChanged=" + z10 + " isVideoMode=" + isVideoMode() + " previousVideoState: " + VideoProfile.videoStateToString(this.mCurrentVideoState) + " newVideoState: " + VideoProfile.videoStateToString(call.getVideoState()));
        }
        if (CallUtils.isModifyCallPreview(call)) {
            isVideoCall |= CallUtils.isVideoCall(call.getModifyToVideoState());
            if (this.mCurrentVideoState == call.getModifyToVideoState()) {
                z11 = false;
            }
            z10 |= z11;
        }
        if (!z10) {
            return;
        }
        updateCameraSelection(call);
        if (isVideoCall) {
            enterVideoMode(call);
        } else if (isVideoMode()) {
            exitVideoMode();
        }
    }

    private void cleanupSurfaces() {
        VideoCallUi ui = getUi();
        if (ui == null) {
            Log.w(TAG, "cleanupSurfaces");
        } else {
            ui.cleanupSurfaces();
        }
    }

    private void createAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.oplus_animation_show_conceal_button);
        this.mShowCallButtonAnimation = loadAnimation;
        if (loadAnimation != null) {
            loadAnimation.setAnimationListener(new com.android.incallui.anim.c("show_call_button_fragment", loadAnimation) { // from class: com.android.incallui.VideoCallPresenter.11
            });
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext, R.anim.oplus_animation_hide_conceal_button);
        this.mHideCallButtonAnimation = loadAnimation2;
        if (loadAnimation2 != null) {
            loadAnimation2.setAnimationListener(new com.android.incallui.anim.c("hide_call_button_fragment", loadAnimation2) { // from class: com.android.incallui.VideoCallPresenter.12
                @Override // com.android.incallui.anim.c, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (VideoCallPresenter.this.oplusGetInCallActivity() != null && VideoCallPresenter.this.oplusGetInCallActivity().getCallButtonFragment() != null && VideoCallPresenter.this.oplusGetInCallActivity().getCallButtonFragment().getView() != null && VideoCallPresenter.this.oplusGetInCallActivity().getCallCardFragment().getView() != null) {
                        boolean isVisible = VideoCallPresenter.this.oplusGetInCallActivity().getCallCardFragment().isVisible();
                        if (Log.sDebug) {
                            Log.d(VideoCallPresenter.TAG, "mHideCallButtonAnimation onAnimationEnd isCallCardFragmentVisible:" + isVisible);
                        }
                        if (!isVisible) {
                            VideoCallPresenter.this.oplusGetInCallActivity().getCallButtonFragment().setVisible(false, true);
                        }
                    }
                }
            });
        }
    }

    private void enterVideoMode(Call call) {
        InCallService.VideoCall videoCall = call.getVideoCall();
        int videoState = call.getVideoState();
        if (Log.sDebug) {
            Log.d(TAG, "enterVideoMode videoCall= " + videoCall + " videoState: " + videoState);
        }
        VideoCallUi ui = getUi();
        if (ui == null) {
            Log.e(TAG, "Error VideoCallUi is null so returning");
            return;
        }
        if (CallUtils.isModifyCallPreview(call)) {
            if (Log.sDebug) {
                Log.d(TAG, "modifying video state = " + videoState + " to video state: " + call.getModifyToVideoState());
            }
            videoState = call.getModifyToVideoState();
        }
        showVideoUi(videoState, call.getState());
        if (videoCall != null) {
            if (ui.isDisplayVideoSurfaceCreated()) {
                if (Log.sDebug) {
                    Log.d(TAG, "Calling setDisplaySurface with " + ui.getDisplayVideoSurface());
                }
                videoCall.setDisplaySurface(ui.getDisplayVideoSurface());
            }
            videoCall.setDeviceOrientation(this.mDeviceOrientation);
            enableCamera(videoCall, isCameraRequired(videoState));
        }
        this.mCurrentVideoState = videoState;
        mIsVideoMode = true;
        maybeAutoEnterFullscreen(call);
        if (Call.State.isConnectingOrDialing(call.getState())) {
            setOplusFirstEnterVideoMode(true);
        }
        if (call.getIsVideoResume()) {
            Log.d(TAG, "enterVideoMode onCallSessionEvent resume");
            if (Call.State.isConnectingOrDialingOrIncomming(call.getState())) {
                updateVideoRingToneUIState(true);
            }
            onCallSessionEvent(call, SESSION_EVENT_RX_RESUME);
        }
    }

    private void exitVideoMode() {
        if (Log.sDebug) {
            Log.d(TAG, "exitVideoMode");
        }
        showVideoUi(0, 3);
        enableCamera(this.mVideoCall, false);
        InCallPresenter.getInstance().setFullScreen(false);
        mIsVideoMode = false;
        setOplusFirstEnterVideoMode(false);
        this.mAllowedToggleFullScreen = false;
        if (getUi() != null) {
            getUi().oplusShowDisplayVideoPause(false);
            getUi().oplusShowPreviewVideoPause(false);
        }
        if (getUi() != null) {
            if (getUi().oplusGetPreviewVideoTextureView() != null) {
                getUi().oplusGetPreviewVideoTextureView().setRotation(0.0f);
            }
            if (getUi().oplusGetDispalyVideoTextureView() != null) {
                getUi().oplusGetDispalyVideoTextureView().setRotation(0.0f);
            }
        }
        oplusResetFullScreen();
        Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        oplusRefreshFrameLayoutLayoutParams(2, true);
        oplusRefreshFrameLayoutLayoutParams(1, true);
        this.mFirstShowPreviewSmallSurface = false;
        this.mOplusCanShowVideoPause = false;
        Call call = this.mPrimaryCall;
        if (call != null) {
            call.setIsVideoRingTone(false);
        }
        updateVideoRingToneUIState(false);
    }

    private static boolean isCameraDirectionSet(Call call) {
        if (CallUtils.isVideoCall(call) && call.getVideoSettings().getCameraDir() != -1) {
            return true;
        }
        return false;
    }

    private boolean isCameraRequired(int i10) {
        return (VideoProfile.isBidirectional(i10) || VideoProfile.isTransmissionEnabled(i10)) && !this.mIsInBackground;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVideoCallCardVisible() {
        InCallActivity oplusGetInCallActivity = oplusGetInCallActivity();
        if (oplusGetInCallActivity != null && oplusGetInCallActivity.getCallButtonFragment() != null && oplusGetInCallActivity.getCallCardFragment() != null) {
            return oplusGetInCallActivity.getCallCardFragment().isVisible();
        }
        return false;
    }

    private boolean isVideoMode() {
        return mIsVideoMode;
    }

    private void listenToCallUpdates(Call call) {
        if (!QtiCallUtils.shallShowPreviewWhileWaiting(this.mContext)) {
            return;
        }
        if (this.mPrimaryCall != null) {
            CallList.getInstance().removeCallUpdateListener(this.mPrimaryCall.getId(), this);
        }
        if (call != null) {
            CallList.getInstance().addCallUpdateListener(call.getId(), this);
        }
    }

    private void maybeEnableCamera() {
        if (this.mPreviewSurfaceState == 0 && isCameraRequired()) {
            enableCamera(this.mVideoCall, true);
        }
    }

    private void onPrimaryCallChanged(Call call) {
        boolean isVideoCallorAudioCallRingtone = CallUtils.isVideoCallorAudioCallRingtone(this.mContext, call);
        boolean isVideoMode = isVideoMode();
        if (Log.sDebug) {
            Log.d(TAG, "onPrimaryCallChanged: isVideoCall=" + isVideoCallorAudioCallRingtone + " isVideoMode=" + isVideoMode);
        }
        listenToCallUpdates(call);
        if (!isVideoCallorAudioCallRingtone && isVideoMode) {
            if (Log.sDebug) {
                Log.d(TAG, "onPrimaryCallChanged: Exiting video mode...");
            }
            exitVideoMode();
            return;
        }
        if (isVideoCallorAudioCallRingtone) {
            if (isVideoMode && CallUtils.isOutgoingVideoCall(call) && this.mOplusSmallSurface == 2) {
                Log.d(TAG, "onPrimaryCallChanged: Clear preview video margin");
                if (getUi() != null && getUi().oplusGetPreviewVideoContainer() != null) {
                    View oplusGetPreviewVideoContainer = getUi().oplusGetPreviewVideoContainer();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) oplusGetPreviewVideoContainer.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    oplusGetPreviewVideoContainer.setLayoutParams(layoutParams);
                }
                this.mFirstShowPreviewSmallSurface = false;
            }
            if (Log.sDebug) {
                Log.d(TAG, "onPrimaryCallChanged: Entering video mode...");
            }
            checkForOrientationAllowedChange(call);
            updateCameraSelection(call);
            enterVideoMode(call);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InCallActivity oplusGetInCallActivity() {
        InCallPresenter inCallPresenter = InCallPresenter.getInstance();
        if (inCallPresenter != null && inCallPresenter.getActivity() != null) {
            return inCallPresenter.getActivity();
        }
        if (Log.sDebug) {
            Log.d(TAG, "oplusGetInCallActivity is null");
            return null;
        }
        return null;
    }

    private boolean oplusIsIncoming() {
        CallList callList = CallList.getInstance();
        if (callList != null && callList.getIncomingCall() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oplusRefreshFrameLayoutLayoutParams(int i10, boolean z10) {
        View oplusGetDisplayVideoContainer;
        VideoCallUi ui = getUi();
        if (ui == null) {
            return;
        }
        if (i10 == 2) {
            oplusGetDisplayVideoContainer = ui.oplusGetPreviewVideoContainer();
        } else {
            oplusGetDisplayVideoContainer = ui.oplusGetDisplayVideoContainer();
        }
        if (oplusGetDisplayVideoContainer == null) {
            return;
        }
        if (Log.sDebug) {
            Log.d(TAG, "oplusRefreshFrameLayoutLayoutParams : reSet = " + z10 + " mLeft = " + this.mLeft + " mTop = " + this.mTop + " mRight = " + this.mRight + " mBottom = " + this.mBottom);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) oplusGetDisplayVideoContainer.getLayoutParams();
        if (z10) {
            layoutParams.setMargins(0, 0, 0, 0);
            this.mLeft = 0;
            this.mTop = 0;
            this.mRight = 0;
            this.mBottom = 0;
        } else if (ui.getScreenSize() != null && this.mTop >= 0 && this.mRight > 0) {
            int i11 = ui.getScreenSize().x;
            int i12 = ui.getScreenSize().y;
            int i13 = this.mTop;
            int i14 = this.mRight;
            if (this.mOplusSmallSurface == 1) {
                if (this.mBottom == i12 || layoutParams.height + i13 > i12) {
                    i13 = i12 - layoutParams.height;
                }
                if (this.mLeft == 0 || i14 < layoutParams.width) {
                    i14 = layoutParams.width;
                }
            }
            int i15 = i11 - i14;
            if (i15 <= 0) {
                i15 = 0;
            }
            if (Log.sDebug) {
                Log.d(TAG, "oplusRefreshFrameLayoutLayoutParams : screenWidth = " + i11 + " screenHeight = " + i12 + " params.height = " + layoutParams.height + " params.width = " + layoutParams.width + ", top=" + i13 + "paramsRight= " + i15);
            }
            layoutParams.setMargins(0, i13, i15, 0);
        }
        oplusGetDisplayVideoContainer.setLayoutParams(layoutParams);
    }

    private void oplusRefreshPreviewOrDisplayForRatio(boolean z10) {
        Point screenSize;
        VideoCallUi ui = getUi();
        if (ui == null || (screenSize = ui.getScreenSize()) == null) {
            return;
        }
        if (!this.mAllowedToggleFullScreen && !oplusIsIncoming()) {
            if (z10) {
                ui.setPreviewSize(screenSize.x, screenSize.y);
                return;
            } else {
                ui.setDisplayVideoSize(screenSize.x, screenSize.y);
                return;
            }
        }
        if (this.mOplusSmallSurface == 2) {
            if (z10) {
                ui.setPreviewSize(this.mVideoSmallSurfaceWidth, this.mVideoSmallSurfaceHeight);
                return;
            } else {
                ui.setDisplayVideoSize(screenSize.x, screenSize.y);
                return;
            }
        }
        if (z10) {
            ui.setPreviewSize(screenSize.x, screenSize.y);
        } else {
            ui.setDisplayVideoSize(this.mVideoSmallSurfaceWidth, this.mVideoSmallSurfaceHeight);
        }
    }

    private void oplusResetDisplayTextureViewAlphaDelay() {
        long j10;
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        Runnable runnable = this.oplusResetDisplayTextureViewAlphaRunnable;
        if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_QUALCOMM) {
            j10 = 450;
        } else {
            j10 = 550;
        }
        handler.postDelayed(runnable, j10);
    }

    private void oplusResetPreviewTextureViewAlphaDelay() {
        int i10;
        if (this.mHandler == null) {
            return;
        }
        boolean z10 = OplusFeatureOption.OPLUS_HW_MANUFACTURER_QUALCOMM;
        if (z10) {
            i10 = OPLUS_RESET_TEXTUREVIEW_ALPHA_SHORT_DELAY;
        } else {
            i10 = 550;
        }
        if (z10 && OplusPhoneUtils.isFirstVideoCallAfterResetPhone(this.mContext)) {
            i10 = 800;
        }
        if (Log.sDebug) {
            Log.d(TAG, "oplusResetPreviewTextureViewAlphaDelay " + i10);
        }
        this.mHandler.postDelayed(this.oplusResetPreviewTextureViewAlphaRunnable, i10);
    }

    private void oplusSetCallButtonVisibility(boolean z10) {
        if (Log.sDebug) {
            Log.d(TAG, "oplusSetCallButtonVisibility visible = " + z10);
        }
        InCallActivity oplusGetInCallActivity = oplusGetInCallActivity();
        if (oplusGetInCallActivity != null && oplusGetInCallActivity.getCallButtonFragment() != null) {
            OplusCallButtonFragment callButtonFragment = oplusGetInCallActivity.getCallButtonFragment();
            if (mIsRingToneMode) {
                OplusAnimationUtils.cancelViewAnimation(callButtonFragment.getView());
                if (z10) {
                    callButtonFragment.setVisible(true, true);
                    OplusAnimationUtils.startViewVisibilityAnimation(callButtonFragment.getView(), this.mShowCallButtonAnimation);
                    return;
                } else {
                    OplusAnimationUtils.startViewVisibilityAnimation(callButtonFragment.getView(), this.mHideCallButtonAnimation);
                    return;
                }
            }
            callButtonFragment.setVisible(z10, true);
        }
    }

    private void oplusSetCallCardVisibility(boolean z10) {
        if (Log.sDebug) {
            Log.d(TAG, "oplusSetCallCardVisibility visible = " + z10);
        }
        InCallActivity oplusGetInCallActivity = oplusGetInCallActivity();
        if (oplusGetInCallActivity != null && oplusGetInCallActivity.getCallCardFragment() != null) {
            oplusGetInCallActivity.getCallCardFragment().setVisible(z10, true);
        }
    }

    private void oplusSetSystemUiVisibility(boolean z10) {
        if (Log.sDebug) {
            Log.d(TAG, "oplusSetSystemUiVisibility visible = " + z10);
        }
        InCallActivity oplusGetInCallActivity = oplusGetInCallActivity();
        if (oplusGetInCallActivity == null) {
            if (Log.sDebug) {
                Log.d(TAG, "activity is null");
            }
        } else if (z10) {
            D2.j.a(oplusGetInCallActivity.getWindow());
        } else {
            D2.j.b(oplusGetInCallActivity.getWindow());
        }
    }

    private void oplusShowDisplayVideoPauseDelay() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(this.oplusShowDisplayVideoPauseRunnable, 1000L);
    }

    private void oplusShowDowngradeToAudioToast() {
        if (this.mHandler == null) {
            return;
        }
        if (Log.sDebug) {
            Log.d(TAG, "oplusShowDowngradeToAudioToast: 800");
        }
        this.mHandler.postDelayed(this.oplusShowDowngradeToAudioRunnable, 800L);
    }

    private void reSetPreviewSize(int i10, int i11) {
        float f10;
        float f11;
        VideoCallUi ui = getUi();
        if (ui == null) {
            return;
        }
        if (i10 > 0 && i11 > 0) {
            f10 = i10 / i11;
        } else {
            f10 = 1.0f;
        }
        if (f10 > 1.0f) {
            f11 = f10;
        } else {
            f11 = 1.0f / f10;
        }
        int i12 = this.mVideoSmallSurfaceWidth;
        int i13 = (int) (i12 * f11);
        int min = Math.min(i12, i13);
        int max = Math.max(this.mVideoSmallSurfaceWidth, i13);
        if (oplusIsLandscape()) {
            max = min;
            min = max;
        }
        if (Log.sDebug) {
            Log.i(TAG, "reSetPreviewSize IMS: Aspect Ratio :" + f10 + " width : " + min + " height : " + max);
        }
        ui.setPreviewSize(min, max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOplusFirstEnterVideoMode(boolean z10) {
        if (Log.sDebug) {
            Log.d(TAG, "setOplusFirstEnterVideoMode : " + z10);
        }
        this.mOplusFirstEnterVideoMode = z10;
    }

    private void setPreviewSize(int i10, float f10) {
        float f11;
        if (getUi() == null) {
            return;
        }
        if (f10 > 1.0f) {
            f11 = f10;
        } else {
            f11 = 1.0f / f10;
        }
        float f12 = this.mMinimumVideoDimension;
        float f13 = (int) (f11 * f12);
        int min = (int) Math.min(f12, f13);
        int max = (int) Math.max(this.mMinimumVideoDimension, f13);
        if (i10 == 90 || i10 == 270) {
            min = max;
            max = min;
        }
        if (Log.sDebug) {
            Log.i(TAG, "IMS: Aspect Ratio :" + f10 + " width : " + min + " height : " + max);
        }
    }

    public static boolean showIncomingVideo(int i10, int i11, Call call) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean isPaused = VideoProfile.isPaused(i10);
        if (i11 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!Call.State.isDialing(i11) && i11 != 13) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i11 == 4) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (Log.sDebug) {
            Log.v(TAG, "showIncomingVideo : isCallIncoming = " + z12);
        }
        VideoBackgroundUseCase videoBackgroundUseCase = VideoBackgroundUseCase.f18569a;
        if (videoBackgroundUseCase.n() && videoBackgroundUseCase.k().getValue().intValue() == 2) {
            return false;
        }
        if (z12 && videoBackgroundUseCase.n() && videoBackgroundUseCase.k().getValue().intValue() == 1 && CallUtils.isInCommingCallRingtone(OplusInCallApp.getAppContext(), call)) {
            if (OplusFeatureOption.FEATURE_INCOMMING_RINGTONE_PRIORITY_SETTING) {
                if (OplusPhoneUtils.isCarrierInCommingRingtoneFirst(OplusInCallApp.getAppContext())) {
                    return true;
                }
            } else if (OplusPhoneUtils.isOpenMarketInCommingRingtoneFirst(OplusInCallApp.getAppContext())) {
                Log.d(TAG, "showIncomingVideo : isVideoShowEnable OPENMARKET_INCOMMING_RINGTONE_FIRST");
                return true;
            }
            return false;
        }
        if (isPaused) {
            return false;
        }
        if (!z10 && !z11 && (!z12 || !CallUtils.isInCommingCallRingtone(OplusInCallApp.getAppContext(), call))) {
            return false;
        }
        if (!VideoProfile.isReceptionEnabled(i10) && !CallUtils.isAudioCallRingtone(OplusInCallApp.getAppContext(), call)) {
            return false;
        }
        return true;
    }

    public static boolean showOutgoingVideo(int i10, int i11) {
        if (VideoProfile.isTransmissionEnabled(i10) && i11 != 4) {
            return true;
        }
        return false;
    }

    private void showVideoUi(int i10, int i11) {
        boolean z10;
        boolean z11;
        VideoCallUi ui = getUi();
        if (ui == null) {
            Log.e(TAG, "showVideoUi, VideoCallUi is null returning");
            return;
        }
        boolean showIncomingVideo = showIncomingVideo(i10, i11, this.mOplusPrimaryCall);
        boolean showOutgoingVideo = showOutgoingVideo(i10, i11);
        if (Log.sDebug) {
            Log.v(TAG, "showVideoUi : showIncoming = " + showIncomingVideo + " showOutgoing = " + showOutgoingVideo);
        }
        Call call = this.mOplusPrimaryCall;
        boolean z12 = false;
        if (call != null) {
            z10 = call.getInComingVideoPaused();
        } else {
            z10 = false;
        }
        if (!showIncomingVideo && !showOutgoingVideo) {
            ui.hideVideoUi();
        } else {
            if (showIncomingVideo && !z10) {
                z11 = true;
            } else {
                z11 = false;
            }
            ui.showVideoViews(showOutgoingVideo, z11, i11);
            if (VideoProfile.isReceptionEnabled(i10)) {
                loadProfilePhotoAsync();
            }
        }
        InCallPresenter inCallPresenter = InCallPresenter.getInstance();
        if (VideoProfile.isAudioOnly(i10) && !CallUtils.isAudioCallRingtone(this.mContext, this.mOplusPrimaryCall)) {
            z12 = true;
        }
        inCallPresenter.enableScreenTimeout(z12);
    }

    private static int toCameraDirection() {
        return 0;
    }

    private static String toSimpleString(Call call) {
        if (call == null) {
            return null;
        }
        return call.toSimpleString();
    }

    private void updateCallCache(Call call) {
        if (call == null) {
            this.mCurrentVideoState = 0;
            this.mCurrentCallState = 0;
            this.mVideoCall = null;
            this.mPrimaryCall = null;
            return;
        }
        this.mCurrentVideoState = call.getVideoState();
        this.mVideoCall = call.getVideoCall();
        this.mCurrentCallState = call.getState();
        this.mPrimaryCall = call;
    }

    private void updateCameraSelection(Call call) {
        boolean z10;
        if (Log.sDebug) {
            Log.d(TAG, "updateCameraSelection: call=" + call);
            Log.d(TAG, "updateCameraSelection: call=" + toSimpleString(call));
        }
        Call activeCall = CallList.getInstance().getActiveCall();
        int i10 = -1;
        if (call == null) {
            if (Log.sDebug) {
                Log.e(TAG, "updateCameraSelection: Call object is null. Setting camera direction to default value (CAMERA_DIRECTION_UNKNOWN)");
            }
        } else if (CallUtils.isModifyCallPreview(call)) {
            i10 = toCameraDirection();
            call.getVideoSettings().setCameraDir(i10);
        } else if (CallUtils.isAudioCall(call)) {
            call.getVideoSettings().setCameraDir(-1);
        } else if (CallUtils.isVideoCall(activeCall) && CallUtils.isIncomingVideoCall(call)) {
            i10 = activeCall.getVideoSettings().getCameraDir();
        } else if (CallUtils.isOutgoingVideoCall(call) && !isCameraDirectionSet(call)) {
            i10 = toCameraDirection();
            call.getVideoSettings().setCameraDir(i10);
        } else if (CallUtils.isOutgoingVideoCall(call)) {
            i10 = call.getVideoSettings().getCameraDir();
        } else if (CallUtils.isActiveVideoCall(call) && !isCameraDirectionSet(call)) {
            i10 = toCameraDirection();
            call.getVideoSettings().setCameraDir(i10);
        } else {
            i10 = CallUtils.isActiveVideoCall(call) ? call.getVideoSettings().getCameraDir() : toCameraDirection();
        }
        if (Log.sDebug) {
            Log.d(TAG, "updateCameraSelection: Setting camera direction to " + i10 + " Call=" + call);
        }
        InCallCameraManager inCallCameraManager = InCallPresenter.getInstance().getInCallCameraManager();
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        inCallCameraManager.setUseFrontFacingCamera(z10);
    }

    private void updateVideoCall(Call call) {
        checkForVideoCallChange(call);
        checkForVideoStateChange(call);
        checkForCallStateChange(call);
        checkForOrientationAllowedChange(call);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoRingToneUIState(boolean z10) {
        Log.d(this, "updateVideoRingToneUIState: isVideoRingtone=" + z10);
        VideoCallUi ui = getUi();
        if (ui != null) {
            if (z10) {
                C0968c value = f2.c.f31677a.e().getValue();
                if (value != null && value.b() != null && value.a() != -1) {
                    ui.oplusSetPreviewVideoVisibility(true);
                    ui.oplusSetDisplayVideoVisibility(false);
                } else {
                    ui.oplusSetPreviewVideoVisibility(false);
                    ui.oplusSetDisplayVideoVisibility(true);
                }
            } else {
                ui.oplusSetPreviewVideoVisibility(true);
                ui.oplusSetDisplayVideoVisibility(true);
            }
        }
        oplusSetVideoRingToneFullScreen(z10);
    }

    public void cancelAutoFullScreen() {
        if (!this.mAutoFullScreenPending) {
            if (Log.sDebug) {
                Log.v(TAG, "cancelAutoFullScreen : none pending.");
            }
        } else {
            if (Log.sDebug) {
                Log.v(TAG, "cancelAutoFullScreen : cancelling pending");
            }
            this.mAutoFullScreenPending = false;
        }
    }

    public void doAutoToggleFullScreen() {
        long j10;
        Log.d(TAG, "doAutoToggleFullScreen: mIsRingToneMode=" + mIsRingToneMode);
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        Message obtainMessage = this.mHandler.obtainMessage(1);
        Handler handler2 = this.mHandler;
        if (mIsRingToneMode) {
            j10 = 5000;
        } else {
            j10 = 10000;
        }
        handler2.sendMessageDelayed(obtainMessage, j10);
    }

    public void enableCamera(InCallService.VideoCall videoCall, boolean z10) {
        Call call;
        if (Log.sDebug) {
            Log.d(TAG, "enableCamera: VideoCall=" + videoCall + " enabling=" + z10);
        }
        if (videoCall == null) {
            Log.w(TAG, "enableCamera: VideoCall is null.");
            return;
        }
        Call call2 = this.mOplusPrimaryCall;
        if (call2 != null && call2.isIncoming()) {
            Log.d(TAG, "enableCamera: primary call is incoming, not enable camera");
            return;
        }
        Call call3 = this.mOplusPrimaryCall;
        if (call3 != null && call3.getVideoPaused() && z10) {
            if (getUi() != null && mIsVideoMode) {
                getUi().oplusShowPreviewVideoPause(true);
            }
            if (Log.sDebug) {
                Log.d(TAG, "enableCamera: getVideoPaused is true, don't enable camera");
                return;
            }
            return;
        }
        if (z10) {
            videoCall.setCamera(InCallPresenter.getInstance().getInCallCameraManager().getActiveCameraId());
            this.mPreviewSurfaceState = 1;
            if (getUi() != null) {
                getUi().oplusShowPreviewVideoPause(false);
            }
            videoCall.requestCameraCapabilities();
            return;
        }
        this.mPreviewSurfaceState = 0;
        if (getUi() != null && mIsVideoMode && (call = this.mOplusPrimaryCall) != null && call.getVideoPaused()) {
            getUi().oplusShowPreviewVideoPause(true);
        }
        videoCall.setCamera(null);
    }

    public int getDeviceOrientation() {
        return this.mDeviceOrientation;
    }

    public void init(Context context) {
        this.mContext = context;
        this.mMinimumVideoDimension = context.getResources().getDimension(R.dimen.video_preview_small_dimension);
        this.mVideoSmallSurfaceWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.oplus_video_small_surface_width);
        this.mVideoSmallSurfaceHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.oplus_video_small_surface_height);
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.android.incallui.VideoCallPresenter.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    VideoCallPresenter.this.toggleFullScreen(true);
                }
            }
        };
        this.mAutoFullscreenTimeoutMillis = this.mContext.getResources().getInteger(R.integer.video_call_auto_fullscreen_timeout);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.oplus_video_small_surface_min_right_margin);
        this.mSmallSurfaceLeftMinMargin = dimensionPixelSize;
        this.mSmallSurfaceRightMargin = dimensionPixelSize;
        this.mSmallSurfaceTopMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.oplus_video_small_surface_min_top_margin);
        this.mSmallSurfaceRoundRect = this.mContext.getResources().getDimensionPixelSize(R.dimen.oplus_video_small_surface_round_rect);
        this.mCameraManager = InCallPresenter.getInstance().getInCallCameraManager();
        if (OplusFeatureOption.FEATURE_VIDEO_RINGTONE_FULL_SCREEN) {
            createAnimation();
        }
    }

    public boolean isConnectingOrDialing() {
        boolean z10;
        Call call = this.mOplusPrimaryCall;
        if (call != null && Call.State.isConnectingOrDialing(call.getState())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(this, "isConnectingOrDialing " + z10);
        }
        return z10;
    }

    public boolean isConnectingOrDialingOrIncomming() {
        boolean z10;
        Call call = this.mOplusPrimaryCall;
        if (call != null && (Call.State.isConnectingOrDialing(call.getState()) || (4 == this.mOplusPrimaryCall.getState() && CallUtils.isInCommingCallRingtone(this.mContext, this.mOplusPrimaryCall)))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(this, "isConnectingOrDialingOrIncomming " + z10);
        }
        return z10;
    }

    public boolean isIsRingToneMode() {
        return mIsRingToneMode;
    }

    public boolean isNotFoldOpen() {
        if (L1.c.f() || !ResponsiveConfigRepository.f18540a.F1()) {
            return true;
        }
        return false;
    }

    public void loadProfilePhotoAsync() {
        if (getUi() == null) {
            return;
        }
        new AsyncTask<Void, Void, Void>() { // from class: com.android.incallui.VideoCallPresenter.5
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0084, code lost:
            
                r3.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x00ab, code lost:
            
                if (r3.isClosed() == false) goto L24;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x009d, code lost:
            
                if (r3.isClosed() == false) goto L24;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x0082, code lost:
            
                if (r3.isClosed() == false) goto L24;
             */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.os.AsyncTask
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.lang.Void doInBackground(java.lang.Void... r12) {
                /*
                    r11 = this;
                    java.lang.String r12 = "VideoCallPresenter"
                    java.lang.String r0 = "display_name"
                    java.lang.String r1 = "lookup"
                    java.lang.String r2 = "photo_uri"
                    com.android.incallui.VideoCallPresenter r3 = com.android.incallui.VideoCallPresenter.this
                    com.android.incallui.ContactInfoCache$ContactCacheEntry r3 = com.android.incallui.VideoCallPresenter.access$600(r3)
                    r4 = 0
                    if (r3 != 0) goto Lba
                    com.android.incallui.VideoCallPresenter r3 = com.android.incallui.VideoCallPresenter.this
                    com.android.incallui.ContactInfoCache$ContactCacheEntry r5 = new com.android.incallui.ContactInfoCache$ContactCacheEntry
                    r5.<init>()
                    com.android.incallui.VideoCallPresenter.access$602(r3, r5)
                    com.android.incallui.VideoCallPresenter r3 = com.android.incallui.VideoCallPresenter.this     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a android.database.sqlite.SQLiteException -> L8d
                    android.content.Context r3 = com.android.incallui.VideoCallPresenter.access$700(r3)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a android.database.sqlite.SQLiteException -> L8d
                    android.content.ContentResolver r5 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a android.database.sqlite.SQLiteException -> L8d
                    android.net.Uri r6 = android.provider.ContactsContract.Profile.CONTENT_URI     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a android.database.sqlite.SQLiteException -> L8d
                    java.lang.String r3 = "_id"
                    java.lang.String[] r7 = new java.lang.String[]{r3, r2, r1, r0}     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a android.database.sqlite.SQLiteException -> L8d
                    r9 = 0
                    r10 = 0
                    r8 = 0
                    android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a android.database.sqlite.SQLiteException -> L8d
                    if (r3 == 0) goto L7c
                    boolean r5 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    if (r5 == 0) goto L7c
                    com.android.incallui.VideoCallPresenter r5 = com.android.incallui.VideoCallPresenter.this     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    com.android.incallui.ContactInfoCache$ContactCacheEntry r5 = com.android.incallui.VideoCallPresenter.access$600(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    int r1 = r3.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    java.lang.String r1 = r3.getString(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    r5.lookupKey = r1     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    int r1 = r3.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    java.lang.String r1 = r3.getString(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    com.android.incallui.VideoCallPresenter r2 = com.android.incallui.VideoCallPresenter.this     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    com.android.incallui.ContactInfoCache$ContactCacheEntry r2 = com.android.incallui.VideoCallPresenter.access$600(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    if (r1 != 0) goto L5e
                    r1 = r4
                    goto L62
                L5e:
                    android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                L62:
                    r2.displayPhotoUri = r1     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    com.android.incallui.VideoCallPresenter r11 = com.android.incallui.VideoCallPresenter.this     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    com.android.incallui.ContactInfoCache$ContactCacheEntry r11 = com.android.incallui.VideoCallPresenter.access$600(r11)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    int r0 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    r11.name = r0     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78 android.database.sqlite.SQLiteException -> L7a
                    goto L7c
                L75:
                    r11 = move-exception
                    r4 = r3
                    goto Lae
                L78:
                    r11 = move-exception
                    goto L90
                L7a:
                    r11 = move-exception
                    goto La0
                L7c:
                    if (r3 == 0) goto Lba
                    boolean r11 = r3.isClosed()
                    if (r11 != 0) goto Lba
                L84:
                    r3.close()
                    goto Lba
                L88:
                    r11 = move-exception
                    goto Lae
                L8a:
                    r11 = move-exception
                    r3 = r4
                    goto L90
                L8d:
                    r11 = move-exception
                    r3 = r4
                    goto La0
                L90:
                    java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> L75
                    com.android.incallui.Log.e(r12, r11)     // Catch: java.lang.Throwable -> L75
                    if (r3 == 0) goto Lba
                    boolean r11 = r3.isClosed()
                    if (r11 != 0) goto Lba
                    goto L84
                La0:
                    java.lang.String r0 = "Catch a SQLiteException when query: "
                    com.android.incallui.Log.e(r12, r0, r11)     // Catch: java.lang.Throwable -> L75
                    if (r3 == 0) goto Lba
                    boolean r11 = r3.isClosed()
                    if (r11 != 0) goto Lba
                    goto L84
                Lae:
                    if (r4 == 0) goto Lb9
                    boolean r12 = r4.isClosed()
                    if (r12 != 0) goto Lb9
                    r4.close()
                Lb9:
                    throw r11
                Lba:
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.VideoCallPresenter.AnonymousClass5.doInBackground(java.lang.Void[]):java.lang.Void");
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Void r12) {
                ContactInfoCache.ContactCacheEntry unused = VideoCallPresenter.this.mProfileInfo;
            }
        }.execute(new Void[0]);
    }

    public void maybeAutoEnterFullscreen(Call call) {
        if (!this.mIsAutoFullscreenEnabled) {
            return;
        }
        if (call != null && call.getState() == 3 && CallUtils.isVideoCall(call) && !InCallPresenter.getInstance().isFullscreen()) {
            if (this.mAutoFullScreenPending) {
                if (Log.sDebug) {
                    Log.v(TAG, "maybeAutoEnterFullscreen : already pending.");
                    return;
                }
                return;
            } else {
                if (Log.sDebug) {
                    Log.v(TAG, "maybeAutoEnterFullscreen : scheduled");
                }
                this.mAutoFullScreenPending = true;
                this.mHandler.postDelayed(this.mAutoFullscreenRunnable, this.mAutoFullscreenTimeoutMillis);
                return;
            }
        }
        cancelAutoFullScreen();
    }

    public void maybeExitFullscreen(Call call) {
        if (call == null) {
            return;
        }
        if (!CallUtils.isVideoCall(call) || call.getState() == 4) {
            InCallPresenter.getInstance().setFullScreen(false);
        }
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.VideoEventListener
    public void onCallDataUsageChange(long j10) {
        if (Log.sDebug) {
            Log.d(TAG, "onCallDataUsageChange dataUsage=" + j10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.VideoEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCallSessionEvent(com.android.incallui.Call r6, int r7) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.VideoCallPresenter.onCallSessionEvent(com.android.incallui.Call, int):void");
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SurfaceChangeListener
    public void onCameraDimensionsChange(Call call, int i10, int i11) {
        InCallService.VideoCall videoCall;
        if (Log.sDebug) {
            K2.a.g(TAG, "onCameraDimensionsChange call=" + call + " width=" + i10 + " height=" + i11);
        }
        VideoCallUi ui = getUi();
        if (ui == null) {
            K2.a.h(TAG, "onCameraDimensionsChange ui is null");
            return;
        }
        if (!call.equals(this.mPrimaryCall)) {
            K2.a.h(TAG, "Call is not primary call");
            return;
        }
        ui.oplusSetVideoRatio(true, i10, i11);
        oplusRefreshPreviewOrDisplayForRatio(true);
        changePreviewDimensions(i10, i11);
        if (this.mPreviewSurfaceState == 0) {
            K2.a.h(TAG, "Received camera capabilities when camera is closed");
            return;
        }
        this.mPreviewSurfaceState = 2;
        if (ui.isPreviewVideoSurfaceCreated() && (videoCall = this.mVideoCall) != null) {
            this.mPreviewSurfaceState = 3;
            videoCall.setPreviewSurface(ui.getPreviewVideoSurface());
            oplusResetPreviewTextureViewAlphaDelay();
        }
    }

    public void onConfigurationChanged() {
        if (Log.sDebug) {
            Log.d(TAG, "onConfigurationChanged");
        }
        Call call = this.mPrimaryCall;
        if (call != null && CallUtils.isVideoCall(call) && getUi() != null) {
            Point previewSize = getUi().getPreviewSize();
            int currentRotation = getUi().getCurrentRotation();
            if (Log.sDebug) {
                Log.d(TAG, "onConfigurationChanged activity rotation:" + currentRotation + "VideoRatio :" + this.mPrimaryCall.getOplusPeerVideoRatio());
            }
            if (getUi().oplusGetPreviewVideoTextureView() != null) {
                if (Log.sDebug) {
                    Log.d(TAG, "onConfigurationChanged need set preview rotation");
                }
                getUi().oplusGetPreviewVideoTextureView().setRotation(360 - (currentRotation * 90));
                if (previewSize != null && this.mPrimaryCall.isActive()) {
                    reSetPreviewSize(previewSize.x, previewSize.y);
                }
            }
            if (this.mPrimaryCall.getOplusPeerVideoRatio() == 0.0f) {
                if (previewSize != null && isConnectingOrDialing()) {
                    getUi().oplusSetVideoRatio(true, previewSize.x, previewSize.y);
                }
            } else {
                getUi().oplusRefreshVideoSize(this.mPrimaryCall.getOplusPeerVideoRatio());
            }
            if (this.mOplusSmallSurface != 1 && !isConnectingOrDialing()) {
                oplusRefreshPreviewOrDisplayForRatio(false);
            } else {
                oplusRefreshPreviewOrDisplayForRatio(false);
                oplusRefreshPreviewOrDisplayForRatio(true);
            }
        }
    }

    @Override // com.android.incallui.InCallPresenter.InCallDetailsListener
    public void onDetailsChanged(Call call, Call.Details details) {
        if (Log.sDebug) {
            Log.d(TAG, " onDetailsChanged call=" + call + " details=" + details + " mPrimaryCall=" + this.mPrimaryCall);
        }
        if (call == null) {
            return;
        }
        if (!call.equals(this.mPrimaryCall)) {
            if (Log.sDebug) {
                Log.d(TAG, " onDetailsChanged: Details not for current active call so returning. ");
            }
        } else {
            updateVideoCall(call);
            updateCallCache(call);
        }
    }

    @Override // com.android.incallui.InCallPresenter.InCallOrientationListener
    public void onDeviceOrientationChanged(int i10) {
        if (Log.sDebug) {
            K2.a.g(TAG, "onDeviceOrientationChanged mDeviceOrientation = " + this.mDeviceOrientation + " orientation = " + i10);
        }
        if (OplusPhoneUtils.isCMCCNumberPrefix(CallList.getInstance().getActiveCall(), OplusInCallApp.getAppContext().getApplicationContext())) {
            K2.a.g(TAG, "isCMCC5GVideoServiceNumber");
            i10 = 0;
        }
        this.mDeviceOrientation = i10;
        VideoCallUi ui = getUi();
        if (ui == null) {
            K2.a.h(TAG, "onDeviceOrientationChanged: VideoCallUi is null");
            return;
        }
        Point previewSize = ui.getPreviewSize();
        if (previewSize == null) {
            K2.a.h(TAG, "onDeviceOrientationChanged: previewDimensions is null");
            return;
        }
        if (!mIsVideoMode) {
            K2.a.h(TAG, "onDeviceOrientationChanged: mIsVideoMode is false");
            return;
        }
        changePreviewDimensions(previewSize.x, previewSize.y);
        CallList callList = CallList.getInstance();
        if ((callList == null || callList.getPendingOutgoingCall() != null || callList.getOutgoingCall() != null || callList.getFirstCallWithState(4) != null) && isNotFoldOpen()) {
            if (Log.sDebug) {
                Log.d(TAG, "onDeviceOrientationChanged : it's dialing, no need to rotation");
                return;
            }
            return;
        }
        if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN) {
            if (getUi() != null && getUi().oplusGetDispalyVideoTextureView() != null) {
                if (isNotFoldOpen()) {
                    if (Log.sDebug) {
                        Log.d(TAG, "onDeviceOrientationChanged : it Fold status, display need rotation");
                    }
                    getUi().oplusGetDispalyVideoTextureView().setRotation(this.mDeviceOrientation);
                }
                if (this.mPrimaryCall != null) {
                    getUi().oplusRefreshVideoSize(this.mPrimaryCall.getOplusPeerVideoRatio());
                }
            }
            if (getUi() != null && getUi().oplusGetPreviewVideoTextureView() != null && ResponsiveConfigRepository.f18540a.F1() && !L1.c.f() && oplusIsLandscape() && this.mDeviceOrientation != 180) {
                int currentRotation = getUi().getCurrentRotation();
                if (Log.sDebug) {
                    Log.d(TAG, "onDeviceOrientationChanged : it UnFold status" + currentRotation);
                }
                getUi().oplusGetPreviewVideoTextureView().setRotation(360 - this.mDeviceOrientation);
            }
            oplusRefreshPreviewOrDisplayForRatio(false);
            int i11 = this.mOplusSmallSurface;
            if (i11 == 1) {
                oplusRefreshFrameLayoutLayoutParams(i11, false);
            }
        }
    }

    @Override // com.android.incallui.InCallPresenter.InCallEventListener
    public void onFullscreenModeChanged(boolean z10) {
        cancelAutoFullScreen();
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        onStateChange(inCallState, inCallState2, CallList.getInstance());
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SurfaceChangeListener
    public void onPeerDimensionsWithAngleChanged(Call call, int i10, int i11, int i12) {
        Log.d(this, "onPeerDimensionsWithAngleChanged: width= " + i10 + " height= " + i11 + " rotation" + i12);
        VideoCallUi ui = getUi();
        if (ui == null) {
            Log.e(this, "VideoCallUi is null. Bail out");
            return;
        }
        if (!call.equals(this.mPrimaryCall)) {
            Log.e(this, "Current call is not equal to primary call. Bail out");
            return;
        }
        ui.oplusSetVideoRatio(false, i10, i11);
        oplusRefreshPreviewOrDisplayForRatio(false);
        call.setOplusPeerVideoRatio(i10, i11);
        int i13 = this.mOplusSmallSurface;
        if (i13 == 1) {
            oplusRefreshFrameLayoutLayoutParams(i13, false);
        }
    }

    @Override // com.android.incallui.InCallPresenter.InCallEventListener
    public void onSecondaryCallerInfoVisibilityChanged(boolean z10, int i10) {
        if (Log.sDebug) {
            Log.d(TAG, "onSecondaryCallerInfoVisibilityChanged : isVisible = " + z10 + " height = " + i10);
        }
        getUi().adjustPreviewLocation(z10, i10);
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onSessionModificationStateChange(Call call, int i10) {
        if (Log.sDebug) {
            Log.d(TAG, "onSessionModificationStateChange : sessionModificationState = " + i10 + " call:" + call);
        }
        if (call == this.mPrimaryCall && i10 != 0 && i10 != 4) {
            if (!VideoProfile.isTransmissionEnabled(call.getModifyToVideoState())) {
                call.setModifyToVideoState(0);
                return;
            }
            if (i10 != 1) {
                call.setModifyToVideoState(0);
            }
            checkForVideoStateChange(call);
            if (i10 == 5 || i10 == 2) {
                this.mCurrentVideoState = call.getVideoState();
            }
        }
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        Call call;
        Call call2;
        InCallPresenter.InCallState inCallState3;
        Handler handler;
        if (Log.sDebug) {
            Log.d(TAG, "onStateChange oldState" + inCallState + " newState=" + inCallState2 + " isVideoMode=" + isVideoMode());
        }
        InCallPresenter.InCallState inCallState4 = InCallPresenter.InCallState.NO_CALLS;
        if (inCallState == inCallState4 && inCallState2 != inCallState && getUi() != null) {
            getUi().oplusReleasePreviewSurface();
        }
        if (inCallState2 == inCallState4) {
            if (isVideoMode()) {
                exitVideoMode();
            }
            if (getUi() != null && getUi().oplusGetPreviewVideoContainer() != null) {
                getUi().oplusGetPreviewVideoContainer().bringToFront();
            }
            this.mOplusSmallSurface = 2;
            if (getUi() != null && getUi().oplusGetDispalyVideoTextureView() != null) {
                getUi().oplusGetDispalyVideoTextureView().setRotation(0.0f);
            }
            if (getUi() != null && getUi().oplusGetPreviewVideoTextureView() != null) {
                getUi().oplusGetPreviewVideoTextureView().setRotation(0.0f);
            }
        }
        InCallPresenter.InCallState inCallState5 = InCallPresenter.InCallState.INCOMING;
        if (inCallState2 == inCallState5) {
            call = callList.getActiveCall();
            call2 = callList.getIncomingCall();
            if (!CallUtils.isActiveVideoCall(call)) {
                call = callList.getIncomingCall();
            }
        } else {
            if (inCallState2 == InCallPresenter.InCallState.OUTGOING) {
                call = callList.getOutgoingCall();
            } else if (inCallState2 == InCallPresenter.InCallState.PENDING_OUTGOING) {
                call = callList.getPendingOutgoingCall();
            } else if (inCallState2 == InCallPresenter.InCallState.INCALL) {
                call = callList.getActiveCall();
                if (CallUtils.isVideoCall(call)) {
                    this.mAllowedToggleFullScreen = true;
                }
            } else {
                call = null;
            }
            call2 = call;
        }
        boolean z10 = !Objects.equals(this.mPrimaryCall, call);
        if (Log.sDebug) {
            Log.d(TAG, "onStateChange primaryChanged=" + z10);
            Log.d(TAG, "onStateChange primary= " + call);
            Log.d(TAG, "onStateChange mPrimaryCall = " + this.mPrimaryCall);
        }
        if (!z10 && call != null && this.mCurrentVideoState != call.getVideoState() && CallUtils.isAudioCall(call)) {
            if (this.mCurrentVideoState == 2 && !OplusPhoneUtils.isCMCCNumberPrefix(CallList.getInstance().getActiveCall(), OplusInCallApp.getAppContext().getApplicationContext())) {
                call.setOplusClickToVoice(false);
            } else {
                oplusShowDowngradeToAudioToast();
            }
        }
        this.mOplusPrimaryCall = call;
        if (z10) {
            onPrimaryCallChanged(call);
        } else if (this.mPrimaryCall != null) {
            updateVideoCall(call);
        }
        updateCallCache(call);
        maybeExitFullscreen(call2);
        maybeAutoEnterFullscreen(call2);
        if (call != null && !call.getIsVideoRingTone() && !CallUtils.isInCommingCallRingtone(OplusInCallApp.getAppContext(), call) && CallUtils.isVideoCall(call) && getUi() != null) {
            getUi().oplusSetPreviewVideoVisibility((call.isConferenceCall() || call.isUsedToBeConferenceCall()) ? false : true);
            if ((call.isConferenceCall() || call.isUsedToBeConferenceCall()) && this.mOplusSmallSurface == 1) {
                onSurfaceClick(1);
            }
        }
        VideoCallUi ui = getUi();
        if (ui == null) {
            return;
        }
        if (call != null && !Call.State.isConnectingOrDialingOrIncomming(call.getState()) && !call.isConferenceCall() && !call.isUsedToBeConferenceCall()) {
            updateVideoRingToneUIState(false);
        }
        if (!isVideoMode()) {
            if (z10 || inCallState2 != InCallPresenter.InCallState.INCALL || inCallState != InCallPresenter.InCallState.OUTGOING || ui.oplusGetPreviewVideoTextureView() == null || ui.oplusGetPreviewVideoContainer() == null) {
                return;
            }
            ui.oplusGetPreviewVideoContainer().bringToFront();
            return;
        }
        Point screenSize = ui.getScreenSize();
        if (inCallState2 != inCallState5 && inCallState2 != (inCallState3 = InCallPresenter.InCallState.OUTGOING) && inCallState2 != InCallPresenter.InCallState.PENDING_OUTGOING) {
            if (inCallState2 == InCallPresenter.InCallState.INCALL) {
                int i10 = this.mOplusSmallSurface;
                if (i10 == 2) {
                    if (!this.mFirstShowPreviewSmallSurface) {
                        Log.d(TAG, "onStateChange: first show preview small surface");
                        this.mFirstShowPreviewSmallSurface = true;
                        if (this.mTop != 0 || this.mRight != 0) {
                            oplusRefreshFrameLayoutLayoutParams(this.mOplusSmallSurface, false);
                        }
                        refreshSmallSurfaceFrameLayout(this.mOplusSmallSurface);
                        if (ui.oplusGetPreviewVideoContainer() != null) {
                            ui.oplusGetPreviewVideoContainer().bringToFront();
                        }
                    }
                    ui.setPreviewSize(this.mVideoSmallSurfaceWidth, this.mVideoSmallSurfaceHeight);
                    ui.setDisplayVideoSize(screenSize.x, screenSize.y);
                } else if (i10 == 1 && !this.mFirstShowPreviewSmallSurface) {
                    Log.d(TAG, "onStateChange: first show display small surface");
                    this.mFirstShowPreviewSmallSurface = true;
                    refreshSmallSurfaceFrameLayout(this.mOplusSmallSurface);
                }
                this.mAllowedToggleFullScreen = true;
                if (call != null && isVideoMode() && (handler = this.mHandler) != null && !handler.hasMessages(1)) {
                    doAutoToggleFullScreen();
                }
                if (z10) {
                    return;
                }
                if ((inCallState != inCallState3 && inCallState != inCallState5) || ui.oplusGetPreviewVideoTextureView() == null || ui.oplusGetDispalyVideoTextureView() == null) {
                    return;
                }
                if (ui.oplusGetPreviewVideoContainer() != null) {
                    ui.oplusGetPreviewVideoContainer().bringToFront();
                }
                ui.oplusGetDispalyVideoTextureView().setAlpha(0.01f);
                ui.oplusShowDisplayVideoBackground(false);
                Call call3 = this.mPrimaryCall;
                if (call3 != null && call3.getIsVideoResume() && this.mHandler != null) {
                    Log.d(TAG, "onStateChange onCallSessionEvent resume when active");
                    this.mHandler.postDelayed(new Runnable() { // from class: com.android.incallui.VideoCallPresenter.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoCallPresenter.this.mPrimaryCall != null && VideoCallPresenter.this.mPrimaryCall.getIsVideoResume()) {
                                VideoCallPresenter videoCallPresenter = VideoCallPresenter.this;
                                videoCallPresenter.onCallSessionEvent(videoCallPresenter.mPrimaryCall, VideoCallPresenter.SESSION_EVENT_RX_RESUME);
                            }
                        }
                    }, 1500L);
                }
                if (Log.sDebug) {
                    Log.d(TAG, "onStateChange setAlpha when active");
                    return;
                }
                return;
            }
            return;
        }
        if (Objects.equals(call2, call)) {
            ui.setPreviewSize(screenSize.x, screenSize.y);
        }
        oplusResetFullScreen();
        this.mAllowedToggleFullScreen = false;
    }

    public void onSurfaceClick(int i10) {
        VideoCallUi ui;
        String str;
        if (Log.sDebug) {
            Log.d(TAG, "onSurfaceClick surfaceId = " + i10 + " mOplusSmallSurface = " + this.mOplusSmallSurface + "  mAllowedToggleFullScreen = " + this.mAllowedToggleFullScreen);
        }
        if ((this.mAllowedToggleFullScreen || mIsRingToneMode) && (ui = getUi()) != null && ui.oplusGetDisplayVideoContainer() != null && ui.oplusGetPreviewVideoContainer() != null) {
            Point screenSize = ui.getScreenSize();
            HashMap hashMap = new HashMap();
            if (i10 == 2 && this.mOplusSmallSurface == 2) {
                hashMap.put("CLICK_SURFACE", "local");
                OplusPhoneUserActionStatistics.onCommon(this.mContext, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_CLICK_SMALL_SURFACE_WHEN_CALL, hashMap);
                if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN) {
                    ui.oplusShowDisplayVideoBackground(false);
                    ui.oplusShowPreviewVideoBackground(true);
                }
                ui.setPreviewSize(screenSize.x, screenSize.y);
                ui.setDisplayVideoSize(this.mVideoSmallSurfaceWidth, this.mVideoSmallSurfaceHeight);
                ui.oplusGetDisplayVideoContainer().bringToFront();
                this.mOplusSmallSurface = 1;
                ui.showDisplayVideoCallMask(false);
                ui.showPreviewVideoCallMask(isVideoCallCardVisible());
                oplusRefreshFrameLayoutLayoutParams(1, true);
                oplusRefreshFrameLayoutLayoutParams(2, true);
                refreshSmallSurfaceFrameLayout(this.mOplusSmallSurface);
                return;
            }
            if (i10 == 1 && this.mOplusSmallSurface == 1) {
                hashMap.put("CLICK_SURFACE", "remote");
                OplusPhoneUserActionStatistics.onCommon(this.mContext, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_CLICK_SMALL_SURFACE_WHEN_CALL, hashMap);
                if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN) {
                    ui.oplusShowDisplayVideoBackground(true);
                    ui.oplusShowPreviewVideoBackground(false);
                }
                ui.setPreviewSize(this.mVideoSmallSurfaceWidth, this.mVideoSmallSurfaceHeight);
                ui.setDisplayVideoSize(screenSize.x, screenSize.y);
                ui.oplusGetPreviewVideoContainer().bringToFront();
                this.mOplusSmallSurface = 2;
                ui.showDisplayVideoCallMask(isVideoCallCardVisible());
                ui.showPreviewVideoCallMask(false);
                oplusRefreshFrameLayoutLayoutParams(2, true);
                oplusRefreshFrameLayoutLayoutParams(1, true);
                refreshSmallSurfaceFrameLayout(this.mOplusSmallSurface);
                return;
            }
            if (this.mOplusIsFullScreen) {
                str = "hide";
            } else {
                str = "show";
            }
            hashMap.put("CURRENT_BUTTON_STATE", str);
            OplusPhoneUserActionStatistics.onCommon(this.mContext, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_CLICK_BIG_SURFACE_WHEN_CALL, hashMap);
            toggleFullScreen();
        }
    }

    public void onSurfaceCreated(int i10) {
        InCallService.VideoCall videoCall;
        if (Log.sDebug) {
            Log.d(TAG, "onSurfaceCreated surface=" + i10 + " mVideoCall=" + this.mVideoCall);
            StringBuilder sb = new StringBuilder();
            sb.append("onSurfaceCreated PreviewSurfaceState=");
            sb.append(this.mPreviewSurfaceState);
            Log.d(TAG, sb.toString());
            Log.d(TAG, "onSurfaceCreated presenter=" + this);
        }
        VideoCallUi ui = getUi();
        if (ui != null && (videoCall = this.mVideoCall) != null) {
            if (this.mCurrentVideoState == 0) {
                Log.w(TAG, "onSurfaceCreated: it's not video state...");
                return;
            }
            if (i10 == 2) {
                if (this.mPreviewSurfaceState == 2) {
                    this.mPreviewSurfaceState = 3;
                    videoCall.setPreviewSurface(ui.getPreviewVideoSurface());
                    oplusResetPreviewTextureViewAlphaDelay();
                    return;
                }
                maybeEnableCamera();
                return;
            }
            if (i10 == 1) {
                videoCall.setDisplaySurface(ui.getDisplayVideoSurface());
                return;
            }
            return;
        }
        Log.w(TAG, "onSurfaceCreated: Error bad state VideoCallUi=" + ui + " mVideoCall=" + this.mVideoCall);
    }

    public void onSurfaceDestroyed(int i10) {
        if (Log.sDebug) {
            Log.d(TAG, "onSurfaceDestroyed: mSurfaceId=" + i10);
        }
        if (this.mVideoCall == null) {
            return;
        }
        boolean isChangingConfigurations = InCallPresenter.getInstance().isChangingConfigurations();
        if (Log.sDebug) {
            Log.d(TAG, "onSurfaceDestroyed: isChangingConfigurations=" + isChangingConfigurations);
        }
        if (i10 == 2) {
            if (!isChangingConfigurations) {
                enableCamera(this.mVideoCall, false);
            } else {
                Log.w(TAG, "onSurfaceDestroyed: Activity is being destroyed due to configuration changes. Not closing the camera.");
            }
        }
    }

    public void onSurfaceReleased(int i10) {
        if (Log.sDebug) {
            Log.d(TAG, "onSurfaceReleased: mSurfaceId=" + i10);
        }
        InCallService.VideoCall videoCall = this.mVideoCall;
        if (videoCall == null) {
            Log.w(TAG, "onSurfaceReleased: VideoCall is null. mSurfaceId=" + i10);
            return;
        }
        if (i10 == 1) {
            videoCall.setDisplaySurface(null);
        } else if (i10 == 2) {
            videoCall.setPreviewSurface(null);
            enableCamera(this.mVideoCall, false);
        }
    }

    public boolean onSurfaceTouch(int i10, View view, MotionEvent motionEvent) {
        View oplusGetDisplayVideoContainer;
        if (Log.sDebug) {
            Log.d(TAG, "onSurfaceTouch surfaceId = " + i10 + " mOplusSmallSurface = " + this.mOplusSmallSurface + "  mAllowedToggleFullScreen = " + this.mAllowedToggleFullScreen);
        }
        if (!this.mAllowedToggleFullScreen && !mIsRingToneMode) {
            return true;
        }
        if (i10 != this.mOplusSmallSurface && !mIsRingToneMode) {
            return false;
        }
        int action = motionEvent.getAction();
        VideoCallUi ui = getUi();
        if (ui == null || ui.oplusGetDisplayVideoContainer() == null || ui.oplusGetPreviewVideoContainer() == null) {
            return true;
        }
        int i11 = ui.getScreenSize().x;
        int i12 = ui.getScreenSize().y;
        if (i10 == 2) {
            oplusGetDisplayVideoContainer = ui.oplusGetPreviewVideoContainer();
        } else {
            oplusGetDisplayVideoContainer = ui.oplusGetDisplayVideoContainer();
        }
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int rawX = ((int) motionEvent.getRawX()) - this.mLastX;
                    int rawY = ((int) motionEvent.getRawY()) - this.mLastY;
                    this.mLeft = oplusGetDisplayVideoContainer.getLeft() + rawX;
                    this.mTop = oplusGetDisplayVideoContainer.getTop() + rawY;
                    this.mRight = oplusGetDisplayVideoContainer.getRight() + rawX;
                    this.mBottom = oplusGetDisplayVideoContainer.getBottom() + rawY;
                    if (this.mLeft < 0) {
                        this.mLeft = 0;
                        this.mRight = oplusGetDisplayVideoContainer.getWidth();
                    }
                    if (this.mRight > i11) {
                        this.mRight = i11;
                        this.mLeft = i11 - oplusGetDisplayVideoContainer.getWidth();
                    }
                    if (this.mTop < 0) {
                        this.mTop = 0;
                        this.mBottom = oplusGetDisplayVideoContainer.getHeight();
                    }
                    if (this.mBottom > i12) {
                        this.mBottom = i12;
                        this.mTop = i12 - oplusGetDisplayVideoContainer.getHeight();
                    }
                    oplusGetDisplayVideoContainer.layout(this.mLeft, this.mTop, this.mRight, this.mBottom);
                    this.mLastX = (int) motionEvent.getRawX();
                    this.mLastY = (int) motionEvent.getRawY();
                }
            } else {
                this.mUpPointX = (int) motionEvent.getRawX();
                this.mUpPointY = (int) motionEvent.getRawY();
                if (Math.sqrt((Math.abs(this.mDownPointX - this.mUpPointX) * Math.abs(this.mDownPointX - this.mUpPointX)) + (Math.abs(this.mDownPointY - this.mUpPointY) * Math.abs(this.mDownPointY - this.mUpPointY))) < 20.0d) {
                    return false;
                }
                oplusRefreshFrameLayoutLayoutParams(this.mOplusSmallSurface, false);
                OplusPhoneUserActionStatistics.onCommon(this.mContext, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_MOVE_SURFACE_WHEN_CALL, (Map) null);
                return true;
            }
        } else {
            this.mLastX = (int) motionEvent.getRawX();
            this.mLastY = (int) motionEvent.getRawY();
            this.mDownPointX = (int) motionEvent.getRawX();
            this.mDownPointY = (int) motionEvent.getRawY();
        }
        return false;
    }

    @Override // com.android.incallui.InCallUiStateNotifierListener
    public void onUiShowing(boolean z10) {
        boolean z11;
        if (Log.sDebug) {
            Log.d(TAG, "onUiShowing, showing = " + z10 + " mPrimaryCall = " + this.mPrimaryCall + " mPreviewSurfaceState = " + this.mPreviewSurfaceState);
        }
        Call call = this.mPrimaryCall;
        if (call != null && CallUtils.isVideoCall(call) && !z10) {
            OplusPhoneUserActionStatistics.onCommon(this.mContext, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_SCREEN_TO_BACKGROUND_WHEN_CALL, (Map) null);
        }
        this.mIsInBackground = !z10;
        Call call2 = this.mPrimaryCall;
        if (call2 != null && (CallUtils.isActiveVideoCall(call2) || CallUtils.isIncomingVideoCall(this.mPrimaryCall) || CallUtils.isOutgoingVideoCall(this.mPrimaryCall))) {
            T5.a d10 = BrandCenter.f19187a.a().d();
            if (d10 != null) {
                z11 = d10.k();
            } else {
                z11 = false;
            }
            if (z10) {
                maybeEnableCamera();
                return;
            } else {
                if (!z11 && this.mPreviewSurfaceState != 0) {
                    enableCamera(this.mVideoCall, false);
                    return;
                }
                return;
            }
        }
        Log.w(TAG, "onUiShowing, received for non-active or non-incoming or non-outgoing video call");
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SurfaceChangeListener
    public void onUpdatePeerDimensions(Call call, int i10, int i11) {
        if (Log.sDebug) {
            K2.a.g(TAG, "onUpdatePeerDimensions: width= " + i10 + " height= " + i11);
        }
        VideoCallUi ui = getUi();
        if (ui == null) {
            K2.a.h(TAG, "VideoCallUi is null. Bail out");
            return;
        }
        if (!call.equals(this.mPrimaryCall)) {
            K2.a.h(TAG, "Current call is not equal to primary call. Bail out");
            return;
        }
        ui.oplusSetVideoRatio(false, i10, i11);
        oplusRefreshPreviewOrDisplayForRatio(false);
        call.setOplusPeerVideoRatio(i10, i11);
        int i12 = this.mOplusSmallSurface;
        if (i12 == 1) {
            oplusRefreshFrameLayoutLayoutParams(i12, false);
        }
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.VideoEventListener
    public void onVideoQualityChanged(Call call, int i10) {
        if (this.mContext.getResources().getBoolean(R.bool.config_regional_noti_move_away_lte_video_call)) {
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (androidx.core.content.b.a(OplusInCallApp.getAppContext(), "android.permission.READ_PHONE_STATE") == 0 && telephonyManager.getDataNetworkType() != 13) {
                Toast.makeText(this.mContext, R.string.video_call_downgrade_without_lte_toast, 0).show();
            }
        }
    }

    public void oplusCheckSystemUiVisibility() {
        if (oplusGetIsFullScreen()) {
            oplusSetSystemUiVisibility(false);
        }
    }

    public void oplusCheckVideoRingToneMode() {
        if (mIsRingToneMode) {
            if (oplusGetIsFullScreen()) {
                toggleFullScreen();
            } else {
                doAutoToggleFullScreen();
            }
        }
    }

    public boolean oplusGetIsFullScreen() {
        if (Log.sDebug) {
            Log.d(TAG, "oplusGetIsFullScreen = " + this.mOplusIsFullScreen);
        }
        return this.mOplusIsFullScreen;
    }

    public boolean oplusIsLandscape() {
        boolean z10;
        int i10;
        boolean z11 = true;
        if (isNotFoldOpen() && ((i10 = this.mDeviceOrientation) == 90 || i10 == 270)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUi() != null && ResponsiveConfigRepository.f18540a.F1() && (getUi().getCurrentRotation() == 1 || getUi().getCurrentRotation() == 3)) {
            Log.d(TAG, "oplusIsLandscape bRet = " + z10 + " getCurrentRotation = " + getUi().getCurrentRotation());
        } else {
            z11 = z10;
        }
        if (Log.sDebug) {
            Log.d(TAG, "oplusIsLandscape bRet = " + z11 + " mDeviceOrientation = " + this.mDeviceOrientation);
        }
        return z11;
    }

    public void oplusResetFullScreen() {
        this.mOplusIsFullScreen = false;
        oplusSetCallCardVisibility(true);
        oplusSetSystemUiVisibility(true);
        oplusSetCallButtonVisibility(true);
    }

    public void oplusSetVideoRingToneFullScreen(boolean z10) {
        if (!OplusFeatureOption.FEATURE_VIDEO_RINGTONE_FULL_SCREEN) {
            if (Log.sDebug) {
                K2.a.g(TAG, "Video ring tone not support full screen");
                return;
            }
            return;
        }
        C0968c value = f2.c.f31677a.e().getValue();
        if (value != null && value.b() != null && value.a() != -1) {
            if (Log.sDebug) {
                K2.a.g(TAG, "OMOJI number not support video ringtone full screen");
                return;
            }
            return;
        }
        if (Log.sDebug) {
            K2.a.g(TAG, "oplusSetVideoRingToneFullScreen isVideoRingTone = " + z10 + " mIsRingToneMode = " + mIsRingToneMode);
        }
        if (z10) {
            mIsRingToneMode = true;
            doAutoToggleFullScreen();
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        if (oplusGetIsFullScreen()) {
            toggleFullScreen();
        }
        oplusResetFullScreen();
        mIsRingToneMode = false;
    }

    public void refreshSmallSurfaceFrameLayout(int i10) {
        View oplusGetDisplayVideoContainer;
        FrameLayout.LayoutParams layoutParams;
        Log.d(TAG, "smallSurfaceIdChange surfaceId = " + i10);
        VideoCallUi ui = getUi();
        if (ui == null) {
            return;
        }
        if (i10 == 2) {
            oplusGetDisplayVideoContainer = ui.oplusGetPreviewVideoContainer();
        } else {
            oplusGetDisplayVideoContainer = ui.oplusGetDisplayVideoContainer();
        }
        if (oplusGetDisplayVideoContainer == null || (layoutParams = (FrameLayout.LayoutParams) oplusGetDisplayVideoContainer.getLayoutParams()) == null) {
            return;
        }
        layoutParams.setMargins(0, this.mSmallSurfaceTopMargin, this.mSmallSurfaceRightMargin, 0);
        oplusGetDisplayVideoContainer.setOutlineProvider(new ViewOutlineProvider() { // from class: com.android.incallui.VideoCallPresenter.10
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), VideoCallPresenter.this.mSmallSurfaceRoundRect);
            }
        });
        oplusGetDisplayVideoContainer.setClipToOutline(true);
    }

    public void toggleFullScreen() {
        toggleFullScreen(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleFullScreen(boolean z10) {
        InCallActivity oplusGetInCallActivity;
        if (!((this.mAllowedToggleFullScreen && mIsVideoMode) || mIsRingToneMode) || CallUtils.isInCommingCallRingtone(this.mContext, this.mPrimaryCall) || (oplusGetInCallActivity = oplusGetInCallActivity()) == null || oplusGetInCallActivity.getCallButtonFragment() == null || oplusGetInCallActivity.getCallCardFragment() == null) {
            return;
        }
        boolean isVisible = oplusGetInCallActivity.getCallCardFragment().isVisible();
        if (Log.sDebug) {
            Log.d(TAG, "toggleFullScreen: currentVisible = " + isVisible + " forceHide = " + z10);
        }
        if (isVisible) {
            Handler handler = this.mHandler;
            if (handler != null && handler.hasMessages(1)) {
                this.mHandler.removeMessages(1);
            }
        } else if (z10) {
            return;
        } else {
            doAutoToggleFullScreen();
        }
        this.mOplusIsFullScreen = isVisible;
        oplusSetCallCardVisibility(!isVisible);
        oplusSetCallButtonVisibility(!isVisible);
        if (getUi() != null) {
            getUi().showDisplayVideoCallMask(!isVisible);
            getUi().showPreviewVideoCallMask(!isVisible);
        }
        oplusSetSystemUiVisibility(!isVisible);
    }

    @Override // com.android.incallui.Presenter
    public void onUiReady(VideoCallUi videoCallUi) {
        super.onUiReady((VideoCallPresenter) videoCallUi);
        if (Log.sDebug) {
            Log.d(TAG, "onUiReady:");
        }
        InCallPresenter.getInstance().addListener(this);
        InCallPresenter.getInstance().addIncomingCallListener(this);
        InCallPresenter.getInstance().addOrientationListener(this);
        InCallPresenter.getInstance().addDetailsListener(this);
        InCallPresenter.getInstance().addInCallEventListener(this);
        InCallVideoCallCallbackNotifier.getInstance().addSurfaceChangeListener(this);
        InCallVideoCallCallbackNotifier.getInstance().addVideoEventListener(this);
        InCallUiStateNotifier.getInstance().addListener(this);
        this.mCurrentVideoState = 0;
        this.mCurrentCallState = 0;
        InCallPresenter.InCallState inCallState = InCallPresenter.getInstance().getInCallState();
        onStateChange(inCallState, inCallState, CallList.getInstance());
        ResponsiveConfigRepository.f18540a.h1().j(this.mStatusObserver);
    }

    @Override // com.android.incallui.Presenter
    public void onUiUnready(VideoCallUi videoCallUi) {
        super.onUiUnready((VideoCallPresenter) videoCallUi);
        if (Log.sDebug) {
            Log.d(TAG, "onUiUnready:");
        }
        int i10 = this.mCurrentCallState;
        if (i10 != 3 && i10 != 6 && i10 != 4) {
            cleanupSurfaces();
        }
        InCallPresenter.getInstance().removeListener(this);
        InCallPresenter.getInstance().removeDetailsListener(this);
        InCallPresenter.getInstance().removeIncomingCallListener(this);
        InCallPresenter.getInstance().removeOrientationListener(this);
        InCallPresenter.getInstance().removeInCallEventListener(this);
        InCallVideoCallCallbackNotifier.getInstance().removeSurfaceChangeListener(this);
        InCallVideoCallCallbackNotifier.getInstance().removeVideoEventListener(this);
        InCallUiStateNotifier.getInstance().removeListener(this);
        Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        ResponsiveConfigRepository.f18540a.h1().n(this.mStatusObserver);
    }

    private boolean isCameraRequired() {
        Call call = this.mPrimaryCall;
        if (call != null) {
            return isCameraRequired(call.getVideoState());
        }
        return false;
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onCallChanged(Call call) {
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onChildNumberChange() {
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onLastForwardedNumberChange() {
    }
}
