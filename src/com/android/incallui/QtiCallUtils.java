package com.android.incallui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.RemoteException;
import android.telecom.InCallService;
import android.telecom.VideoProfile;
import android.widget.Toast;
import com.android.oplus.brand.BrandCenter;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.google.android.material.internal.ViewUtils;
import com.internal_dependency.InternalSdkDepends;
import com.internal_dependency.SettingsUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.codeaurora.internal.IExtTelephony;

/* loaded from: classes.dex */
public class QtiCallUtils {
    private static String LOG_TAG = "QtiCallUtils";
    public static final int TARGET_SET_FOR_AUDIO_WITHOUT_SMS = 0;
    public static final int TARGET_SET_FOR_AUDIO_WITH_SMS = 1;
    public static final int TARGET_SET_FOR_QTI_AUDIO_WITHOUT_SMS = 1007;
    public static final int TARGET_SET_FOR_QTI_AUDIO_WITH_SMS = 1008;
    public static final int TARGET_SET_FOR_QTI_BIDIRECTIONAL_VIDEO_ACCEPT_REJECT_REQUEST = 1004;
    public static final int TARGET_SET_FOR_QTI_VIDEO_ACCEPT_REJECT_REQUEST = 1003;
    public static final int TARGET_SET_FOR_QTI_VIDEO_RECEIVE_ACCEPT_REJECT_REQUEST = 1006;
    public static final int TARGET_SET_FOR_QTI_VIDEO_TRANSMIT_ACCEPT_REJECT_REQUEST = 1005;
    public static final int TARGET_SET_FOR_QTI_VIDEO_WITHOUT_SMS = 1000;
    public static final int TARGET_SET_FOR_QTI_VIDEO_WITH_SMS = 1001;
    public static final int TARGET_SET_FOR_VIDEO_ACCEPT_REJECT_REQUEST = 4;
    public static final int TARGET_SET_FOR_VIDEO_WITHOUT_SMS = 2;
    public static final int TARGET_SET_FOR_VIDEO_WITH_SMS = 3;
    static Boolean dsdaEnabled;
    private static IExtTelephony sIExtTelephony;
    public static int selectType;

    private QtiCallUtils() {
    }

    public static String callTypeToString(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return "";
                }
                return "VT";
            }
            return "VT_RX";
        }
        return "VT_TX";
    }

    private static void changeToVideoClicked(Call call, VideoProfile videoProfile) {
        changeToVideoClicked(call, videoProfile, null);
    }

    public static void displayModifyCallOptions(final Call call, final Context context) {
        if (call == null) {
            Log.d(LOG_TAG, "Can't display modify call options. Call is null");
            return;
        }
        if (isTtyEnabled(context)) {
            Log.w(LOG_TAG, "Call session modification is allowed only when TTY is off.");
            displayToast(context, R.string.video_call_not_allowed_if_tty_enabled);
            return;
        }
        if (context.getResources().getBoolean(R.bool.config_enable_enhance_video_call_ui)) {
            if (selectType != -1) {
                VideoProfile videoProfile = new VideoProfile(selectType);
                Log.v(LOG_TAG, "Videocall: Enhance videocall: upgrade/downgrade to " + callTypeToString(selectType));
                changeToVideoClicked(call, videoProfile, context);
                return;
            }
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Resources resources = context.getResources();
        if (hasVoiceCapabilities(call)) {
            arrayList.add(resources.getText(R.string.modify_call_option_voice));
            arrayList2.add(0);
        }
        if (hasBidirectionalVideoCapabilities(call)) {
            if (!OplusPhoneUtils.isUstOplusExport()) {
                arrayList.add(resources.getText(R.string.modify_call_option_vt_rx));
                arrayList2.add(2);
            }
            arrayList.add(resources.getText(R.string.modify_call_option_vt_tx));
            arrayList2.add(1);
            arrayList.add(resources.getText(R.string.modify_call_option_vt));
            arrayList2.add(3);
        }
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(context);
        cOUIAlertDialogBuilder.setTitle(R.string.modify_call_option_title);
        cOUIAlertDialogBuilder.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), arrayList2.indexOf(Integer.valueOf(CallUtils.getUnPausedVideoState(call.getVideoState()))), new DialogInterface.OnClickListener() { // from class: com.android.incallui.QtiCallUtils.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                Toast.makeText(context, (CharSequence) arrayList.get(i10), 0).show();
                int intValue = ((Integer) arrayList2.get(i10)).intValue();
                Log.v(this, "Videocall: ModifyCall: upgrade/downgrade to " + QtiCallUtils.callTypeToString(intValue));
                QtiCallUtils.changeToVideoClicked(call, new VideoProfile(intValue), context);
                dialogInterface.dismiss();
            }
        });
        cOUIAlertDialogBuilder.create().show();
    }

    public static void displayToast(Context context, String str) {
    }

    public static void downgradeToVoiceCall(Call call) {
        changeToVideoClicked(call, new VideoProfile(0));
    }

    public static IExtTelephony getIExtTelephony() {
        IExtTelephony iExtTelephony = sIExtTelephony;
        if (iExtTelephony != null) {
            return iExtTelephony;
        }
        try {
            sIExtTelephony = IExtTelephony.Stub.N7((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "extphone"));
        } catch (ClassNotFoundException e10) {
            Log.e(LOG_TAG, " ex: " + e10);
        } catch (IllegalAccessException e11) {
            Log.e(LOG_TAG, " ex: " + e11);
        } catch (IllegalArgumentException e12) {
            Log.e(LOG_TAG, " ex: " + e12);
        } catch (NoSuchMethodException e13) {
            Log.e(LOG_TAG, " ex: " + e13);
        } catch (SecurityException e14) {
            Log.e(LOG_TAG, " ex: " + e14);
        } catch (InvocationTargetException e15) {
            Log.e(LOG_TAG, " ex: " + e15);
        }
        return sIExtTelephony;
    }

    public static int getIncomingCallAnswerOptions(Context context, boolean z10) {
        if (!useExt(context)) {
            if (z10) {
                return 3;
            }
            return 2;
        }
        if (z10) {
            return 1001;
        }
        return 1000;
    }

    public static int getSessionModificationOptions(Context context, int i10, int i11) {
        if (!useExt(context)) {
            return 4;
        }
        if (showVideoUpgradeOptions(i10, i11)) {
            return 1003;
        }
        if (isEnabled(3, i11)) {
            return 1004;
        }
        if (isEnabled(1, i11)) {
            return 1005;
        }
        if (!isEnabled(2, i11)) {
            return 1003;
        }
        return 1006;
    }

    public static boolean hasBidirectionalVideoCapabilities(Call call) {
        if (call != null && call.can(ViewUtils.EDGE_TO_EDGE_FLAGS) && call.can(3072)) {
            return true;
        }
        return false;
    }

    public static boolean hasVoiceCapabilities(Call call) {
        if (call != null && !call.can(4194304)) {
            return true;
        }
        return false;
    }

    public static boolean isConfigEnabled(Context context, int i10) {
        return InternalSdkDepends.getSInstance().isConfigEnabled(context, i10);
    }

    public static boolean isEmergencyNumber(String str) {
        try {
            return getIExtTelephony().Q2(str);
        } catch (RemoteException e10) {
            Log.e(LOG_TAG, "Exception : " + e10);
            return false;
        } catch (NullPointerException e11) {
            Log.e(LOG_TAG, "Exception : " + e11);
            return false;
        }
    }

    public static boolean isEnabled(int i10, int i11) {
        if ((i11 & i10) == i10) {
            return true;
        }
        return false;
    }

    public static boolean isNotEnabled(int i10, int i11) {
        if ((i10 & i11) == 0) {
            return true;
        }
        return false;
    }

    private static boolean isTtyEnabled(Context context) {
        if (context == null) {
            Log.w(context, "Context is null...");
            return false;
        }
        if (SettingsUtils.INSTANCE.getSecureSettingsInt(context.getContentResolver(), "preferred_tty_mode", 0) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isVideoRxOnly(Call call) {
        if (call == null) {
            return false;
        }
        int videoState = call.getVideoState();
        if (VideoProfile.isTransmissionEnabled(videoState) || !VideoProfile.isReceptionEnabled(videoState)) {
            return false;
        }
        return true;
    }

    public static boolean shallShowPreviewWhileWaiting(Context context) {
        if (context == null) {
            Log.w(context, "Context is null...");
            return false;
        }
        if (OplusPhoneUtils.isUstOplusExport()) {
            return BrandCenter.f19187a.a().f(context);
        }
        return context.getResources().getBoolean(R.bool.config_enable_modify_call_preview);
    }

    private static boolean showVideoUpgradeOptions(int i10, int i11) {
        if (i10 == 0 && isEnabled(3, i11)) {
            return true;
        }
        return false;
    }

    public static int toUiOrientationMode(int i10) {
        if (i10 != 1) {
            if (i10 == 2) {
                return 1;
            }
            if (i10 != 3) {
                return -1;
            }
            return 10;
        }
        return 0;
    }

    public static boolean useExt(Context context) {
        if (context == null) {
            Log.w(context, "Context is null...");
        }
        if (context != null && context.getResources().getBoolean(R.bool.video_call_use_ext)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void changeToVideoClicked(Call call, VideoProfile videoProfile, Context context) {
        InCallService.VideoCall videoCall = call.getVideoCall();
        if (videoCall == null) {
            return;
        }
        videoCall.sendSessionModifyRequest(videoProfile);
        if (shallShowPreviewWhileWaiting(context)) {
            call.setModifyToVideoState(videoProfile.getVideoState());
        }
        call.setSessionModificationState(1);
        InCallAudioManager.getInstance().onModifyCallClicked(call, videoProfile.getVideoState());
    }

    public static void displayToast(Context context, int i10) {
        displayToast(context, context.getResources().getString(i10));
    }
}
