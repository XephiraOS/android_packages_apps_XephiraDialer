package com.android.incallui;

import android.content.Context;
import android.telecom.VideoProfile;
import com.android.incallui.Call;
import com.internal_dependency.SettingsUtils;

/* loaded from: classes.dex */
public class CallUtils {
    private static int INCOMING_RINGTOINE_OR_OUTGOINGRINGTONE = 3;
    private static int ONLY_INCOMING_RINGTOINE = 2;
    private static String SETTING_VIDEO_EARLY_MEDIA_MODE = "video_early_media_mode";
    private static String TAG = "CallUtils";

    public static boolean canVideoPause(Call call) {
        if (isVideoCall(call) && call.getState() == 3) {
            return true;
        }
        return false;
    }

    public static int getPausedVideoState(int i10) {
        return i10 | 4;
    }

    public static int getUnPausedVideoState(int i10) {
        return i10 & (-5);
    }

    public static boolean hasVideoUpgradeRequest(int i10) {
        if (i10 == 1) {
            return true;
        }
        return false;
    }

    public static boolean isActiveUnPausedVideoCall(Call call) {
        if (isActiveVideoCall(call) && !VideoProfile.isPaused(call.getVideoState())) {
            return true;
        }
        return false;
    }

    public static boolean isActiveVideoCall(Call call) {
        if (isVideoCall(call) && call.getState() == 3) {
            return true;
        }
        return false;
    }

    public static boolean isAudioCall(Call call) {
        return call != null && VideoProfile.isAudioOnly(call.getVideoState());
    }

    public static boolean isAudioCallRingtone(Context context, Call call) {
        if (call == null || context == null || !isInCommingCallRingtone(context, call) || !VideoProfile.isReceptionEnabled(call.getVideoState()) || VideoProfile.isTransmissionEnabled(call.getVideoState())) {
            return false;
        }
        return true;
    }

    public static boolean isBidirectionalVideoCall(Call call) {
        return call != null && isBidirectionalVideoCall(call.getVideoState());
    }

    public static boolean isInCommingCallRingtone(Context context, Call call) {
        if (call == null) {
            Log.i(TAG, "isInCommingCallRingtone call is null");
            return false;
        }
        if (call.getState() != 4) {
            return false;
        }
        if ((!isSupportInCommingCallRingtone(context, call) || !call.can(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE)) && !OplusPhoneUtils.isCrsCall(call)) {
            return false;
        }
        return true;
    }

    public static boolean isIncomingVideoCall(Call call) {
        if (!isVideoCall(call)) {
            return false;
        }
        int state = call.getState();
        if (state != 4 && state != 5) {
            return false;
        }
        return true;
    }

    public static boolean isModifyCallPreview(Call call) {
        if (call == null || call.getSessionModificationState() != 1 || !VideoProfile.isTransmissionEnabled(call.getModifyToVideoState())) {
            return false;
        }
        return true;
    }

    public static boolean isOutgoingVideoCall(Call call) {
        if (!isVideoCall(call)) {
            return false;
        }
        int state = call.getState();
        if (!Call.State.isDialing(state) && state != 13 && state != 12) {
            return false;
        }
        return true;
    }

    public static boolean isSupportInCommingCallRingtone(Context context, Call call) {
        if (call != null && context != null) {
            int globalSettingsInt = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), SETTING_VIDEO_EARLY_MEDIA_MODE + call.getSubId(), -1);
            Log.i(TAG, "isSupportInCommingCallRingtone =" + globalSettingsInt + "getSubId =" + call.getSubId());
            if (globalSettingsInt != ONLY_INCOMING_RINGTOINE && globalSettingsInt != INCOMING_RINGTOINE_OR_OUTGOINGRINGTONE) {
                return false;
            }
            return true;
        }
        Log.i(TAG, "isInCommingCallRingtone call or context is null");
        return false;
    }

    public static boolean isVideoCall(Call call) {
        return call != null && (isVideoCall(call.getVideoState()) || (R5.a.b() && hasVideoUpgradeRequest(call.getSessionModificationState())));
    }

    public static boolean isVideoCallorAudioCallRingtone(Context context, Call call) {
        if (!isVideoCall(call) && !isAudioCallRingtone(context, call)) {
            return false;
        }
        return true;
    }

    public static VideoProfile makeVideoPauseProfile(Call call) {
        com.google.common.base.k.o(call);
        com.google.common.base.k.u(!VideoProfile.isAudioOnly(call.getVideoState()));
        return new VideoProfile(getPausedVideoState(call.getVideoState()));
    }

    public static VideoProfile makeVideoUnPauseProfile(Call call) {
        com.google.common.base.k.o(call);
        return new VideoProfile(getUnPausedVideoState(call.getVideoState()));
    }

    public static boolean rejectVideoUpgradeRequest(int i10) {
        if (i10 != 5 && i10 != 2 && i10 != 4) {
            return false;
        }
        return true;
    }

    public static boolean isAudioCall(int i10) {
        return VideoProfile.isAudioOnly(i10);
    }

    public static boolean isBidirectionalVideoCall(int i10) {
        return VideoProfile.isBidirectional(i10);
    }

    public static boolean isVideoCall(int i10) {
        return VideoProfile.isVideo(i10);
    }
}
