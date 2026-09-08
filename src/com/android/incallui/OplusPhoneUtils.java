package com.android.incallui;

import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ActivityNotFoundException;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.icu.text.MeasureFormat;
import android.icu.util.Measure;
import android.icu.util.MeasureUnit;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.UserManager;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telecom.VideoProfile;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.Call;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.oplus.share.OplusInCallDialogActivity;
import com.android.oplus.brand.BrandCenter;
import com.android.oplus.module.castScreen.CastScreen;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.theme.COUIThemeOverlay;
import com.google.common.collect.Maps;
import com.internal_dependency.AddOnSdkDepends;
import com.internal_dependency.InternalSdkDepends;
import com.internal_dependency.SettingsUtils;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import z2.C1731b;

/* loaded from: classes.dex */
public class OplusPhoneUtils {
    public static final String ACTION_CALL_PRIVILEGED = "android.intent.action.CALL_PRIVILEGED";
    public static final String ACTION_SUBINFO_RECORD_UPDATED = "android.intent.action.ACTION_SUBINFO_RECORD_UPDATED";
    private static final int ANDROID_VERSION_S2 = 32;
    public static final String ANSWER_FROM_DEVICE = "answer_call_from_device";
    private static final int BLACK_SCREEN_MODE_OFF = 0;
    private static final int BLACK_SCREEN_MODE_ON = 1;
    private static final int BREATH_MODE_ON = 1;
    protected static final String CALL_START_TIME = "call_start_time";
    private static final String CALL_STATE = "call_state";
    private static final int CALL_STATE_ACTIVE = 3;
    private static final int CALL_STATE_DIALING = 1;
    private static final int CALL_STATE_IDLE = 0;
    private static final int CALL_STATE_RINGING = 2;
    private static final String CMCC_INCOMMING_RINGTONE_FIRST = "1";
    private static final String CMCC_INCOMMING_RINGTONE_RUS_VALUE = "cmcc_incomming_ringtone_rus_value";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_NUMBER = "number";
    private static final String COMMON_DEVICE_LOCKED_STATUS = "common_device_locked_status";
    private static final String CONFIG_OPLUS_SUPPORT_VIWIFI_BOOL = "config_oplus_support_viwifi_bool";
    private static final float DEFAULT_FONT_SCALE = 1.0f;
    private static final String DEFAULT_PHOTO_STYLE_SETTING = "default_contact_photo_style_setting";
    public static final String DEFAULT_PREFIX = "003768";
    private static final float DENSITYDPI_TO_DDENSITY = 160.0f;
    private static final int DISPLAY_DENSITY_INVALID = -1;
    public static final int DRAGONFLY_DISPLAY = 1;
    private static final String EMPTY_STRING = "";
    private static final int END = 2;
    public static final String EXTRA_ADD_COUNT = "extra_add_count";
    public static final String EXTRA_SECURE_TYPE = "extra_secure_type";
    private static final String FDN_ENABLE = "fdn_enable_key";
    private static final String FEATURE_DRIVE_MODE = "com.oplus.ocar.drivemode.enable";
    public static final String FIRST_VIDEO_CALL_AFTER_RESET_PHONE_PREFERENCE = "oplus_customize_incall_first_video_call_after_reset_phone_preference";
    public static final int FLAG_RECEIVER_INCLUDE_BACKGROUND = 16777216;
    private static final String FREE_NUM = "400";
    public static final int FULL_INTERNAL = 11;
    public static final int FULL_SD_TO_FULL_INTERNAL = 4;
    public static final int FULL_SD_TO_INTERNAL = 9;
    public static final int FULL_SD_TO_INTERNAL_FULL = 8;
    private static final int HOUR_IN_SEC = 3600;
    private static final String IMS_VOLTE_ENABLE = "volte";
    private static final String IMS_VOWIFI_ENABLE = "vowifi";
    private static final String INCALLSCREEN_CLASS_NAME = "com.android.incallui.OplusInCallActivity";
    protected static final String INCALL_SCREEN_FORGROUND = "incall_screen_forground";
    protected static final String INCALL_SCREEN_NAME_TAG = "incall_screen_name_tag";
    public static final String INCOMING_CALL_VOICE_CONTROL = "oplus_customize_incoming_call_voice_control";
    public static final int INTERNAL_FULL = 10;
    public static final int INVALID_PHONE_INDEX = -1;
    private static final String JAPAN_DOMESTIC_CODE = "0";
    private static final String JAPAN_WEATHER_NUMBER = "177";
    private static final String KEY_BLACK_SCREEN_MODE = "black_screen_mode";
    public static final String KEY_NAV_STATE = "hide_navigationbar_enable";
    private static final String KEY_RECORD_SD_STORAGE_SWITCH = "oplus_customize_sdcard_storage_switch_com_android_incallui";
    private static final String LOG_TAG = "OplusPhoneUtils";
    private static final String MASK_STRING = "****";
    public static final String METHOD_SET_SECURE_ITEM = "setSecureItem";
    private static final int MIDDLE = 1;
    private static final int MIN_IN_SEC = 60;
    private static final int MIN_LENGTH = 6;
    public static final int MT_CALL_DISPLAY_FLOAT = 0;
    public static final String MT_CALL_DISPLAY_MODE = "mt_call_display_mode";
    public static final int NAV_STATE_INVALID = -1;
    public static final int NAV_STATE_SWIPE_SIDE_GESTURE = 3;
    public static final int NAV_STATE_SWIPE_UP_GESTURE = 2;
    public static final int NAV_STATE_VIRTUAL_KEY = 0;
    public static final int NAV_STATE_VIRTUAL_KEY_AND_HIDE = 1;
    public static final String NEED_PRIVACY_TOAST = "need_privacy_toast";
    private static final int NETWORK_TYPE_LTE_CA = 19;
    private static final String NO_NUMBER_PATTERN_STR = "[^0-9]";
    public static final int NUMBER_HIDE = 1;
    public static final int NUMBER_SHOW = 0;
    private static final String OCAR_AUTHORITY = "content://com.oplus.ocar.OCarEntryProvider";
    private static final String OCAR_METHOD = "getRunningMode";
    private static final String OCAR_MODE = "mode";
    private static final int OCAR_MODE_VALUE = 1000;
    private static final String OPENMARKET_INCOMMING_RINGTONE_FIRST = "1";
    private static final String OPENMARKET_INCOMMING_RINGTONE_RUS_VALUE = "openmarket_incomming_ringtone_rus_value";
    public static final String OPLUS_AOD_RAMLESS_SUPPORT = "oplus.aod.ramless.support";
    public static final String OPLUS_AOD_SUPPORT = "oplus.software.display.aod_support";
    private static final String OPLUS_INCALLUI_FLOATING_WINDOW_STATE = "oplus_common_center_incallui_floating_window_state";
    private static final int OPLUS_INCALLUI_FLOATING_WINDOW_STATE_HIDE = 0;
    private static final int OPLUS_INCALLUI_FLOATING_WINDOW_STATE_SHOW = 1;
    private static final String OPLUS_NETWORK_PRIMARY_SLOT = "oplus_customize_multi_sim_network_primary_slot";
    public static final String OPLUS_NO_DISPLAY_RECORD = "com.android.incallui.no_display_record";
    private static final String OPLUS_SMART_APPERCEIVE_AUTO_ANSWER = "oplus_smart_apperceive_auto_answer";
    private static final String OP_BREATH_MODE_KEY = "op_breath_mode_status";
    public static final int PC_ANSWER_CHANGE_TO_PC = 1;
    public static final int PC_ANSWER_CHANGE_TO_PC_AGAIN = 11;
    public static final int PC_ANSWER_NO_CHANGE_TO_PC = 2;
    public static final int PC_ANSWER_NO_CHANGE_TO_PC_AGAIN = 12;
    public static final int PC_NEED_PRIVACY_TOAST = 1;
    public static final int PC_NO_NEED_PRIVACY_TOAST = 0;
    public static final int PC_SHOW_AUDIO_PRIVACY_TOAST = 2;
    public static final int PC_SHOW_AUDIO_PRIVACY_TOAST_AGAIN = 12;
    public static final int PC_SHOW_VIDEO_PRIVACY_TOAST = 3;
    public static final int PC_SHOW_VIDEO_PRIVACY_TOAST_AGAIN = 13;
    public static final int PERCENT_START_FLOAT = 10;
    public static final String PERMISSION_OPLUS_COMPONENT_SAFE = "oplus.permission.OPLUS_COMPONENT_SAFE";
    private static final String PERSIST_SYS_DISPLAY_DENSITY = "persist.sys.display.density";
    private static final int PERSIST_SYS_DISPLAY_DENSITY_DEFAULT = -1;
    public static final int PHONE_ANSWER_CHANGE_TO_PHONE = 3;
    public static final int PHONE_ANSWER_CHANGE_TO_PHONE_AGAIN = 13;
    public static final int PHONE_ANSWER_NO_CHANGE_TO_PHONE = 4;
    public static final int PHONE_ANSWER_NO_CHANGE_TO_PHONE_AGAIN = 14;
    public static final String PREFIX_MX_COUNTRY = "+52";
    public static final int PROPERTY_HIGH_DEF_AUDIO_EVS = 1048576;
    public static final String PROPERTY_ICC_OPERATOR_NUMERIC = "gsm.sim.operator.numeric";
    private static final String PRO_IMS_TYPE = "gsm.ims.type";
    private static final String RAKUTEN_MNO_SIM = "44011";
    public static final String RAKUTEN_PREFIX = "oplus_customize_rakuten_prefix";
    public static final String RAKUTEN_PREFIX_PREFERENCE = "oplus_customize_rakuten_prefix_preference";
    public static final int RAKUTEN_PREFIX_PREFERENCE_ALWAYS = 0;
    public static final int RAKUTEN_PREFIX_PREFERENCE_ASK = 2;
    public static final int RAKUTEN_PREFIX_PREFERENCE_NEVER = 1;
    private static final String RECORD_FILE_NAME_MASK_STRING = "----";
    private static final int RESOLUTION_AUTO_VALUE = 1;
    private static final int RESOLUTION_DEFAULT_DISPLAY = 430;
    private static final int RESOLUTION_QHD_VALUE = 2;
    private static final String RESOLUTION_SWITCH_VALUE = "oplus_customize_screen_resolution_adjust";
    public static final int SD_FULL_TO_FULL_INTERNAL = 7;
    public static final int SD_FULL_TO_INTERNAL = 1;
    public static final int SD_FULL_TO_INTERNAL_FULL = 3;
    public static final int SD_INVALID_TO_FULL_INTERNAL = 5;
    public static final int SD_INVALID_TO_INTERNAL = 2;
    public static final int SD_INVALID_TO_INTERNAL_FULL = 6;
    public static final int SESSION_MODIFY_REQUEST_NOT_SUPPORT_BY_REMOTE = 100;
    public static final String SHOW_PRIVACY_TOAST = "show_privacy_toast";
    private static final int SLOT_1 = 0;
    private static final String SPECIAL_DEVICE_LOCKED_STATUS = "special_device_locked_status";
    private static final String SPECIAL_JAPAN_CODE_PREFIX = "01081";
    private static final String SPECIAL_PLUS_CODE_PREFIX = "+";
    private static final String SPECIAL_REMOVE_CODE_PREFIX = "010";
    public static final String SUBSCRIPTION_KEY = "subscription";
    public static final String TELSTRA_DEFAULT_VOICE_MAIL = "+61101";
    public static final String TYPE_STRANGE_NUMBER = "strange_number";
    public static final int USER_SWITCH_OTHER = 1;
    public static final int USER_SWITCH_OTHER_AGAIN = 11;
    public static final int USER_SWITCH_PC = 0;
    public static final int USER_SWITCH_PC_AGAIN = 10;
    public static final String USER_SWITCH_REOUTE = "user_switch_route";
    protected static final String VIDEO_CALL = "video_call";
    private static final int sInitialDisplayDensity = 480;
    private static boolean sOplusVolteVideoCallEnable;
    private static boolean sOplusVowifiVideoCallEnable;
    public static final String OPLUS_CALL_RECORDER_APK_PACKAGE = OplusInCallApp.getAppContext().getString(R.string.OPLUS_CALL_RECORDER_APK_PACKAGE);
    public static final String ACTION_INCALLSCREEN_STATE = OplusInCallApp.getAppContext().getString(R.string.ACTION_INCALLSCREEN_STATE);
    public static final HashMap<String, NumberAttributionInfo> mNumberAttributionCache = Maps.f();
    public static final Uri SAFE_AUTHORITY_URI = Uri.parse("content://com.oplus.provider.SafeProvider");
    public static final Uri SHADOW_CONTENT_URI = Uri.parse("content://call_log_shadow/calls");
    public static final String NOTES_PACKAGE_NAME = OplusInCallApp.getAppContext().getString(R.string.NOTES_PACKAGE_NAME);
    public static final String ACTION_CANCEL_INTERCEPT_NOTIFICATION = OplusInCallApp.getAppContext().getString(R.string.ACTION_CANCEL_INTERCEPT_NOTIFICATION);
    public static final String CONTACTS_ACTION = OplusInCallApp.getAppContext().getString(R.string.CONTACTS_ACTION);
    public static final String OPLUS_HARASSMENT_ACTION = OplusInCallApp.getAppContext().getString(R.string.OPLUS_HARASSMENT_ACTION);
    public static final String OPLUS_BLACK_LIST_PACKAGE = ConfigurationConstants.getBlackListPackageName();
    public static final String OPLUS_BLACK_LIST_CLASS_NAME = OplusInCallApp.getAppContext().getString(R.string.OPLUS_BLACK_LIST_CLASS_NAME);
    public static final String COUNT_DELAY_TYPE = OplusInCallApp.getAppContext().getString(R.string.COUNT_DELAY_TYPE);
    public static final String COUNT_UNKNOWN_TYPE = OplusInCallApp.getAppContext().getString(R.string.COUNT_UNKNOWN_TYPE);
    public static final String COUNT_STRANGER_TYPE = OplusInCallApp.getAppContext().getString(R.string.COUNT_STRANGER_TYPE);
    public static final String COUNT_INTERCEPT_CALL = OplusInCallApp.getAppContext().getString(R.string.COUNT_INTERCEPT_CALL);
    public static final String AUDIO_RECORD_APK_PACKAGE = OplusInCallApp.getAppContext().getString(R.string.AUDIO_RECORD_APK_PACKAGE);
    public static final int PRODUCT_FLAVOR = OplusInCallApp.getAppContext().getResources().getInteger(R.integer.product_flavor);
    private static final String[] JAPAN_MCC = {"440", "441"};
    private static final String[] SPECIAL_RESERVED_CODE_PREFIX = {"184", "186"};
    private static final String[] DTAC_NUMERIC = {"52005", "52018"};
    private static final String[] KDDI_NUMERIC = {"44050", "44051"};
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9+()\\s,\\-\u200e]*");
    private static final List<String> CN_ECC_NUMBER_LIST = Arrays.asList("110", "120", "119", "122", "112");
    private static final int MASK_LENGTH = 4;
    public static boolean sIsLockScreenWhenFirstCallInComing = false;
    public static boolean sIsNumberStranger = false;
    public static boolean sIsInEmergencyCall = false;
    protected static int sCardSize = -1;
    protected static int sImsConferenceSize = 0;
    protected static String sOplusShowDigits = null;
    private static androidx.appcompat.app.b sRecordDialog = null;
    private static boolean sNeedMarkNumber = false;
    private static String sMarkNumber = null;
    private static boolean sIsHangUpConfernceCall = false;
    private static boolean sShowLockScreenAnswerView = false;
    private static Map<String, Boolean> sEmergencyNumCache = new HashMap();
    private static boolean sVideoPausedForConf = false;
    private static String sOperatorMccMnc = null;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AudioQuality {
        public static final int NORMAL = 0;
        public static final int QUALITY_HIGH = 1;
        public static final int QUALITY_HIGH_EVS = 2;
    }

    /* loaded from: classes.dex */
    public static final class DeviceState {
        public static final String INVALID_STATUS = "-1";
        public static final String LOCK_DEVICE = "1";
        public static final String UNLOCK_DEVICE = "0";

        private DeviceState() {
        }
    }

    /* loaded from: classes.dex */
    public static class NumberAttributionInfo {
        public String mAreano;
        public String mLocation;

        private NumberAttributionInfo() {
        }
    }

    public static String addRakutenPrefix(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String replaceAll = str.replaceAll(" ", "");
        if (!TextUtils.isEmpty(replaceAll)) {
            replaceAll = replaceAll.replaceAll("-", "");
        }
        if (TextUtils.isEmpty(replaceAll)) {
            return str;
        }
        String rakutenPrefixString = getRakutenPrefixString(context);
        String[] strArr = SPECIAL_RESERVED_CODE_PREFIX;
        if (replaceAll.startsWith(strArr[0])) {
            String substring = replaceAll.substring(strArr[0].length());
            if (!TextUtils.isEmpty(substring) && !substring.startsWith(rakutenPrefixString)) {
                return strArr[0] + rakutenPrefixString + substring;
            }
            return str;
        }
        if (replaceAll.startsWith(strArr[1])) {
            String substring2 = replaceAll.substring(strArr[1].length());
            if (!TextUtils.isEmpty(substring2) && !substring2.startsWith(rakutenPrefixString)) {
                return strArr[1] + rakutenPrefixString + substring2;
            }
            return str;
        }
        if (replaceAll.startsWith(rakutenPrefixString)) {
            replaceAll = replaceAll.substring(rakutenPrefixString.length());
            if (TextUtils.isEmpty(replaceAll)) {
                return str;
            }
        }
        if (replaceAll.startsWith(SPECIAL_JAPAN_CODE_PREFIX)) {
            replaceAll = replaceAll.replaceFirst(SPECIAL_JAPAN_CODE_PREFIX, "0");
        } else if (replaceAll.startsWith(SPECIAL_PLUS_CODE_PREFIX)) {
            replaceAll = replaceAll.substring(1);
        } else if (replaceAll.startsWith("010")) {
            replaceAll = replaceAll.substring(3);
        }
        if (TextUtils.isEmpty(replaceAll)) {
            return str;
        }
        return rakutenPrefixString + replaceAll;
    }

    private static void answerOnPCAndPutAnswerValue(Context context) {
        if (context == null) {
            return;
        }
        int globalGetInt = AppSettingsUtils.globalGetInt(context, ANSWER_FROM_DEVICE, 1);
        com.android.incallui.mvvm.repository.dynamic.a aVar = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
        if (aVar.G1() && !aVar.D1()) {
            if (globalGetInt < 11) {
                AppSettingsUtils.globalPutInt(context, ANSWER_FROM_DEVICE, 11);
            } else {
                AppSettingsUtils.globalPutInt(context, ANSWER_FROM_DEVICE, 1);
            }
            TelecomAdapter.getInstance().setAudioRoute(128);
            return;
        }
        if (globalGetInt < 11) {
            AppSettingsUtils.globalPutInt(context, ANSWER_FROM_DEVICE, 12);
        } else {
            AppSettingsUtils.globalPutInt(context, ANSWER_FROM_DEVICE, 2);
        }
    }

    public static void answerOnPhoneAndPutAnswerValue(Context context) {
        if (context == null) {
            return;
        }
        int globalGetInt = AppSettingsUtils.globalGetInt(context, ANSWER_FROM_DEVICE, 1);
        if (com.android.incallui.mvvm.repository.dynamic.a.f18559a.D1()) {
            if (globalGetInt < 11) {
                AppSettingsUtils.globalPutInt(context, ANSWER_FROM_DEVICE, 13);
            } else {
                AppSettingsUtils.globalPutInt(context, ANSWER_FROM_DEVICE, 3);
            }
            CastScreen.f19196a.a().a(0);
            return;
        }
        if (globalGetInt < 11) {
            AppSettingsUtils.globalPutInt(context, ANSWER_FROM_DEVICE, 14);
        } else {
            AppSettingsUtils.globalPutInt(context, ANSWER_FROM_DEVICE, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void autoReplySms(Context context, String str, int i10) {
        String str2;
        SmsManager smsManagerForSubscriptionId;
        if (!TextUtils.isEmpty(str) && context != null) {
            if (!SubscriptionManager.isValidSubscriptionId(i10)) {
                Log.w(LOG_TAG, "autoReplySms, couldn't send SMS message: Invalid SubId: " + i10);
                return;
            }
            C1731b d10 = C1731b.d();
            C1731b.f e10 = d10.e(1);
            C1731b.f e11 = d10.e(2);
            if (C1731b.h.a(e10.a()) && C1731b.h.a(e11.a())) {
                if (Log.sDebug) {
                    K2.a.e(LOG_TAG, "autoReplySms both smart drive data and ride mode data is null.");
                    return;
                }
                return;
            }
            C1731b.l lVar = (C1731b.l) e10.d();
            C1731b.j jVar = (C1731b.j) e11.d();
            if (lVar.f38295d) {
                str2 = lVar.f38296e;
            } else if (isRideMode()) {
                str2 = jVar.f38288e;
            } else {
                str2 = null;
            }
            if (Log.sDebug) {
                K2.a.e(LOG_TAG, "autoReplySms number = " + D2.g.l(str) + " msg= " + D2.g.o(str2));
            }
            if (!TextUtils.isEmpty(str2) && (smsManagerForSubscriptionId = SmsManager.getSmsManagerForSubscriptionId(i10)) != null) {
                try {
                    ArrayList<String> divideMessage = smsManagerForSubscriptionId.divideMessage(str2);
                    if (divideMessage != null && divideMessage.size() > 0) {
                        int size = divideMessage.size();
                        Intent intent = new Intent(context, (Class<?>) OplusRespondViaSmsReceiver.class);
                        intent.setAction(OplusRespondViaSmsReceiver.MESSAGE_SEND_ACTION);
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 67108864);
                        ArrayList<PendingIntent> arrayList = new ArrayList<>(size);
                        for (int i11 = 0; i11 < size; i11++) {
                            arrayList.add(i11, broadcast);
                        }
                        smsManagerForSubscriptionId.sendMultipartTextMessage(str, null, divideMessage, arrayList, null);
                        K2.a.e(LOG_TAG, "autoReplySms sendMultipartTextMessage.");
                    }
                } catch (IllegalArgumentException e12) {
                    K2.a.f(LOG_TAG, "autoReplySms, Couldn't send SMS message: " + e12.getMessage());
                }
            }
        }
    }

    public static Bitmap bitmapToRoundCorner(Bitmap bitmap, float f10) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        canvas.drawRoundRect(rectF, f10, f10, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static boolean canDisplayCardIcon(Context context) {
        if (context == null) {
            return false;
        }
        if (sCardSize == -1) {
            sCardSize = getAvailableCardSize(context);
        }
        if (sCardSize < 2) {
            return false;
        }
        return true;
    }

    public static void changeCallCastAudioModeForPcOrPad(Context context, int i10, OplusCallList oplusCallList) {
        if (context != null && oplusCallList != null) {
            if (oplusCallList.getIncomingCall() == null || oplusCallList.getActiveOrBackgroundCall() != null) {
                return;
            }
            if (SettingsUtils.INSTANCE.getSecureSettingsInt(context.getContentResolver(), "pc_connect_state", 0) == 0) {
                Log.d(LOG_TAG, "changeCallCastAudioModeForPcOrPad pc not connected, return");
                return;
            }
            com.android.incallui.mvvm.repository.dynamic.a aVar = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
            if ((aVar.o() && !hasWatchDevice()) || aVar.k0()) {
                if (aVar.D1()) {
                    CastScreen.f19196a.a().a(0);
                    return;
                }
                return;
            } else if (i10 != 999 && i10 != 998) {
                answerOnPhoneAndPutAnswerValue(context);
                return;
            } else {
                answerOnPCAndPutAnswerValue(context);
                return;
            }
        }
        Log.d(LOG_TAG, "changeCallCastAudioModeForPcOrPad context or oplusCallList is null, return");
    }

    public static boolean changeToVowifiIcon(Call call, int i10) {
        if (!OplusFeatureOption.OPLUSOS_FEATURE_INCALLUI_DISPLAY_VOWIFI_ICON_ACTIVE.value().booleanValue()) {
            return isVowifiState(call, i10);
        }
        return false;
    }

    public static void checkAutoReplySms(final Context context, final String str, final int i10) {
        if (!TextUtils.isEmpty(str) && context != null) {
            C2.b.a().execute(new Runnable() { // from class: com.android.incallui.OplusPhoneUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!SubscriptionManager.isValidSubscriptionId(i10)) {
                        K2.a.f(OplusPhoneUtils.LOG_TAG, "autoReplySms, couldn't send SMS message: Invalid SubId: " + i10);
                        return;
                    }
                    C1731b.d().e(1).b(context, null);
                    OplusPhoneUtils.autoReplySms(context, str, i10);
                    if (Log.sDebug) {
                        K2.a.e(OplusPhoneUtils.LOG_TAG, "checkAutoReplySms end");
                    }
                }
            });
        }
    }

    public static void cleanMccmncCache() {
        sOperatorMccMnc = null;
    }

    public static void clearEmergencyNumberCache() {
        sEmergencyNumCache.clear();
    }

    public static void closeSafty(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                Log.d(LOG_TAG, "exception: " + e10.toString());
            }
        }
    }

    public static void dismissKeyguard() {
        Log.d(LOG_TAG, "dismissKeyguard");
        AddOnSdkDepends.getSInstance().dismissKeyguard(OplusInCallApp.getAppContext(), InCallPresenter.getInstance().mInCallActivity);
    }

    public static String editNumberWithoutArea(String str) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "EditNumberWithoutArea number = " + D2.g.l(str));
        }
        if (str == null) {
            return str;
        }
        if (!str.startsWith("0")) {
            return str;
        }
        String str2 = "";
        String replaceAll = str.replaceAll(" ", "");
        NumberAttributionInfo numberAttributionInfo = mNumberAttributionCache.get(replaceAll);
        if (numberAttributionInfo != null) {
            str2 = numberAttributionInfo.mAreano;
        }
        if (Log.sDebug) {
            Log.i(LOG_TAG, "Output Call Number: " + D2.g.o(str2));
        }
        if (str2 != null && replaceAll != null && str2.length() <= replaceAll.length()) {
            return replaceAll.substring(str2.length());
        }
        return replaceAll;
    }

    public static String filterSpecialCharacters(String str) {
        int i10;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "filterSpecialCharacter number = " + D2.g.l(str));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str = str.replace(" ", "");
            int length = str.length();
            int indexOf = str.indexOf(",");
            int indexOf2 = str.indexOf(Constants.DataMigration.SPLIT_TAG);
            if (indexOf != -1 && indexOf2 == -1) {
                i10 = indexOf;
            } else if (indexOf == -1 && indexOf2 != -1) {
                i10 = indexOf2;
            } else if (indexOf != -1 && indexOf2 != -1) {
                i10 = Math.min(indexOf, indexOf2);
            } else {
                i10 = -1;
            }
            if (i10 != -1 && i10 < length) {
                str = str.substring(0, i10);
            }
            if (Log.sDebug) {
                Log.d(LOG_TAG, "filterSpecialCharacter length = " + length + "  commaPos = " + indexOf + " semicolonPos = " + indexOf2 + " number = " + D2.g.l(str));
            }
        } catch (Exception e10) {
            Log.d(LOG_TAG, "Exception: " + e10);
        }
        return str;
    }

    public static String formatDuration(long j10) {
        int i10;
        int i11 = (int) (j10 / 1000);
        if (i11 < 0) {
            i11 = -i11;
        }
        int i12 = 0;
        if (i11 >= HOUR_IN_SEC) {
            i10 = i11 / HOUR_IN_SEC;
            i11 -= i10 * HOUR_IN_SEC;
        } else {
            i10 = 0;
        }
        if (i11 >= 60) {
            i12 = i11 / 60;
            i11 -= i12 * 60;
        }
        ArrayList arrayList = new ArrayList();
        if (i10 > 0) {
            arrayList.add(new Measure(Integer.valueOf(i10), MeasureUnit.HOUR));
        }
        if (i12 > 0) {
            arrayList.add(new Measure(Integer.valueOf(i12), MeasureUnit.MINUTE));
        }
        arrayList.add(new Measure(Integer.valueOf(i11), MeasureUnit.SECOND));
        if (Log.sDebug) {
            Log.d(LOG_TAG, "formatDuration Locale.getDefault begin!");
        }
        Locale.getDefault();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "formatDuration Locale.getDefault end!");
        }
        String formatMeasures = MeasureFormat.getInstance(Locale.getDefault(), MeasureFormat.FormatWidth.WIDE).formatMeasures((Measure[]) arrayList.toArray(new Measure[arrayList.size()]));
        if (Log.sDebug) {
            Log.d(LOG_TAG, "formatDuration = " + formatMeasures);
        }
        return formatMeasures;
    }

    public static String formatQueryNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '(' && charAt != ')' && charAt != '-' && charAt != ' ') {
                sb.append(charAt);
            }
        }
        Log.d(LOG_TAG, "formatQueryNumber number = " + D2.g.l(sb.toString()));
        return sb.toString();
    }

    public static int getActiveSimId(Context context) {
        int i10;
        Call firstCall = CallList.getInstance().getFirstCall();
        if (firstCall != null) {
            i10 = firstCall.getSubId();
        } else {
            i10 = -1;
        }
        log("getActiveSimId simId: = " + i10);
        return i10;
    }

    public static String getAlias(BluetoothDevice bluetoothDevice) {
        if (androidx.core.content.b.a(OplusInCallApp.getAppContext(), "android.permission.BLUETOOTH_CONNECT") != 0) {
            return OplusInCallApp.getAppContext().getString(R.string.oplus_audio_mode_bluetooth_string);
        }
        return bluetoothDevice.getAlias();
    }

    public static int getAudioQualityDrawableId(Context context, Call call, boolean z10) {
        int i10;
        int i11 = -1;
        if (context != null && call != null) {
            int audioQualityType = getAudioQualityType(call, z10);
            if (isNotShowHDIcon(call)) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "not show hd icon ");
                }
                return -1;
            }
            if (isVowifiState(call, CallList.getInstance().getActiveSubId())) {
                if (shouldReplaceHDIconToVoWifiIcon(call.getState())) {
                    if (CallUtils.isVideoCall(call)) {
                        i10 = R.drawable.incall_ic_vowifi_video;
                    } else {
                        i10 = R.drawable.incall_ic_vowifi_voice;
                    }
                    Log.d(LOG_TAG, "getVoWifidrawableId = " + i10);
                    return i10;
                }
            } else {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "OPLUS_PHONE_HIDE_HD_ICON = " + OplusFeatureOption.OPLUS_PHONE_HIDE_HD_ICON);
                }
                if (OplusFeatureOption.OPLUS_PHONE_HIDE_HD_ICON) {
                    return -1;
                }
            }
            if (audioQualityType != 1) {
                if (audioQualityType == 2) {
                    i11 = R.drawable.incall_ic_cu_hd_plus_voice;
                }
            } else if (OplusFeatureOption.OPLUS_VERSION_EXP) {
                i11 = R.drawable.incall_ic_hd_voice;
            } else if (isImsRegistered(context, CallList.getInstance().getActiveSubId())) {
                i11 = R.drawable.incall_ic_ims_hd_voice;
            } else {
                i11 = R.drawable.incall_ic_cu_hd_voice;
            }
            if (Log.sDebug) {
                Log.d(LOG_TAG, "getAudioQualityDrawableId audioQualityType = " + audioQualityType + " drawableId = " + i11);
            }
            return i11;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getAudioQualityDrawableId null return context = " + context + " call = " + call);
        }
        return -1;
    }

    public static int getAudioQualityType(Call call, boolean z10) {
        int i10 = 0;
        if (call == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "getAudioQualityType, call is null return false!");
            }
            return 0;
        }
        int state = call.getState();
        if ((z10 && state == 3) || state == 3 || state == 8) {
            if (call.hasProperty(PROPERTY_HIGH_DEF_AUDIO_EVS)) {
                i10 = 2;
            } else if (call.hasProperty(16)) {
                i10 = 1;
            }
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getAudioQualityType isMultiCall = " + z10 + " state = " + state + " qualityType = " + i10);
        }
        return i10;
    }

    public static int getAvailableCardSize(Context context) {
        List<SubscriptionInfo> activeSubscriptionInfoList;
        if (context == null) {
            return 0;
        }
        boolean isOplusHasSoftSimCard = AddOnSdkDepends.getSInstance().isOplusHasSoftSimCard(context);
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") != 0 || (activeSubscriptionInfoList = SubscriptionManager.from(context).getActiveSubscriptionInfoList()) == null) {
            return 0;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getAvailableCardSize subInfosSize = " + activeSubscriptionInfoList.size() + "  softSimCardSize = " + (isOplusHasSoftSimCard ? 1 : 0));
        }
        return activeSubscriptionInfoList.size() - (isOplusHasSoftSimCard ? 1 : 0);
    }

    public static boolean getBluetoothAvailable() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean z10 = false;
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            if (androidx.core.content.b.a(OplusInCallApp.getAppContext(), "android.permission.BLUETOOTH_CONNECT") != 0) {
                return false;
            }
            if (defaultAdapter.getProfileConnectionState(1) == 2) {
                z10 = true;
            }
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getBluetoothAvailable available = " + z10);
        }
        return z10;
    }

    public static boolean getBooleanCarrierConfig(Context context, String str, int i10) {
        return InternalSdkDepends.getSInstance().getBooleanCarrierConfig(context, str, i10);
    }

    public static String getCallStateLabelWhenVoLTEVoWifi(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        Log.d(LOG_TAG, "getCallStateLabelWhenVoLTEVoWifi: ");
        if (OplusFeatureOption.OPLUS_PHONE_DISPLAY_VOLTE_VOWIFI) {
            Log.d(LOG_TAG, "feature status = true");
            Call firstCallWithState = CallList.getInstance().getFirstCallWithState(6);
            if (firstCallWithState == null) {
                firstCallWithState = CallList.getInstance().getFirstCallWithState(13);
            }
            if (firstCallWithState != null) {
                boolean isImsRegistered = isImsRegistered(context, firstCallWithState.getSubId());
                boolean isVideoCall = CallUtils.isVideoCall(firstCallWithState);
                boolean hasProperty = firstCallWithState.hasProperty(8);
                Log.d(LOG_TAG, "isImsRegistered = " + isImsRegistered + " isVideoCall = " + isVideoCall + " isVoWifi = " + hasProperty);
                if (!isImsRegistered) {
                    return null;
                }
                if (isVideoCall) {
                    return context.getString(R.string.oplus_card_title_dialing);
                }
                str = context.getString(R.string.oplus_card_title_dialing_volte);
                if (hasProperty) {
                    str = context.getString(R.string.oplus_card_title_dialing_vowifi);
                }
            }
        }
        Log.d(LOG_TAG, "callStateLabel: " + str);
        return str;
    }

    public static Call getCallToShow(CallList callList) {
        if (callList == null) {
            return null;
        }
        Call incomingCall = callList.getIncomingCall();
        if (incomingCall == null) {
            incomingCall = callList.getOutgoingCall();
        }
        if (incomingCall == null) {
            incomingCall = callList.getPendingOutgoingCall();
        }
        if (incomingCall == null) {
            return callList.getActiveOrBackgroundCall();
        }
        return incomingCall;
    }

    public static String getCallerIdName(Context context, int i10) {
        if (context == null) {
            return null;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                if (i10 != 4) {
                    return null;
                }
                return context.getString(R.string.oplus_card_name_payphone);
            }
            return context.getString(R.string.oplus_card_name_unknown);
        }
        return context.getString(R.string.oplus_card_name_anonymous);
    }

    public static int getCardIcon(Context context, int i10, boolean z10) {
        if (z10 || context == null || !canDisplayCardIcon(context)) {
            return -1;
        }
        if (i10 == 0) {
            return R.drawable.incall_ic_callcard_card_sim1;
        }
        if (i10 != 1) {
            return -1;
        }
        return R.drawable.incall_ic_callcard_card_sim2;
    }

    public static int getCardSecondIcon(Context context, int i10, boolean z10) {
        if (z10 || context == null || !canDisplayCardIcon(context)) {
            return -1;
        }
        if (i10 == 0) {
            return R.drawable.incall_call_card_secondary_icon_sim1;
        }
        if (i10 != 1) {
            return -1;
        }
        return R.drawable.incall_call_card_secondary_icon_sim2;
    }

    public static int getCardSize() {
        return sCardSize;
    }

    private static int getDefaultDisplayDensity(int i10, Context context) {
        try {
            int intSystemProperties = InternalSdkDepends.getSInstance().getIntSystemProperties(PERSIST_SYS_DISPLAY_DENSITY, -1);
            Log.d(LOG_TAG, "getDefaultDisplayDensity propDensity = " + intSystemProperties);
            if (intSystemProperties != -1) {
                return intSystemProperties;
            }
            return InternalSdkDepends.getSInstance().getInitialDisplayDensity(i10);
        } catch (Exception e10) {
            Log.d(LOG_TAG, "getDefaultDisplayDensity RemoteException " + e10);
            return -1;
        }
    }

    public static String getDeviceLockedStatus(Context context) {
        if (context == null) {
            Log.i(LOG_TAG, "context is null");
            return DeviceState.INVALID_STATUS;
        }
        SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
        String secureSettingsString = settingsUtils.getSecureSettingsString(context.getContentResolver(), COMMON_DEVICE_LOCKED_STATUS, "");
        String secureSettingsString2 = settingsUtils.getSecureSettingsString(context.getContentResolver(), SPECIAL_DEVICE_LOCKED_STATUS, "");
        Log.d(LOG_TAG, "getDeviceLockedStatus:" + secureSettingsString + "deviceLockedStatusSpecial:" + secureSettingsString2);
        if (secureSettingsString == null) {
            return secureSettingsString2;
        }
        return secureSettingsString;
    }

    public static boolean getDirectlyCallEnable(Context context) {
        if (context == null || AppSettingsUtils.globalGetInt(context, FDN_ENABLE, 0) != 1 || !isUserUnlocked(context) || !OplusFeatureOption.OPLUS_PHONE_DISPLAY_FDN_CALL) {
            return false;
        }
        return true;
    }

    private static Display getDisplay(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay();
        }
        return null;
    }

    public static String getFormattingNumber(String str) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getFormattingNumber number = " + D2.g.l(str));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String filterSpecialCharacters = filterSpecialCharacters(editNumberWithoutArea(str));
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getFormattingNumber done number = " + D2.g.l(filterSpecialCharacters));
        }
        return filterSpecialCharacters;
    }

    public static String getHidedNumberInName(String str, int i10, Context context) {
        if (!TextUtils.isEmpty(str) && context != null) {
            if (str.matches(NUMBER_PATTERN.pattern())) {
                return getNumberMaskedStr(str, i10);
            }
            if (!str.startsWith(context.getString(R.string.contact_label)) && !str.startsWith(context.getString(R.string.contact_label_exp))) {
                return str;
            }
            String replaceAll = str.replaceAll(NO_NUMBER_PATTERN_STR, "");
            String numberMaskedStr = getNumberMaskedStr(replaceAll, i10);
            if (TextUtils.isEmpty(numberMaskedStr)) {
                return str;
            }
            return str.replace(replaceAll, numberMaskedStr);
        }
        return str;
    }

    public static int getImsConferenceSize() {
        return sImsConferenceSize;
    }

    public static int getImsPhoneId(Context context) {
        int defaultDataPhoneId = SubscriptionManager.from(context).getDefaultDataPhoneId();
        if (!SubscriptionManager.isValidPhoneId(defaultDataPhoneId)) {
            return 0;
        }
        return defaultDataPhoneId;
    }

    private static boolean getImsRegistered(boolean z10, int i10) {
        PhoneAccountHandle phoneAccountHandle;
        String stringSystemProperties = InternalSdkDepends.getSInstance().getStringSystemProperties(PRO_IMS_TYPE + i10, "");
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getImsRegistered imsType = " + stringSystemProperties);
        }
        Call callToShow = getCallToShow(CallList.getInstance());
        if (callToShow != null && callToShow.getHasSRVCC()) {
            Log.d(LOG_TAG, "getImsRegistered, return false because of srvcc!");
            return false;
        }
        if (TextUtils.isEmpty(stringSystemProperties) && callToShow != null && callToShow.can(512)) {
            Log.d(LOG_TAG, "getImsRegistered, return true because of vt localt tx!");
            return true;
        }
        if (z10) {
            if (callToShow != null) {
                phoneAccountHandle = callToShow.getAccountHandle();
            } else {
                phoneAccountHandle = null;
            }
            int networkTypeGemini = AddOnSdkDepends.getSInstance().getNetworkTypeGemini(OplusInCallApp.getAppContext(), i10, A2.d.d(phoneAccountHandle));
            if (Log.sDebug) {
                Log.d(LOG_TAG, "getImsRegistered, networkType = " + networkTypeGemini);
            }
            if (networkTypeGemini != 13 && networkTypeGemini != 19 && networkTypeGemini != 20 && networkTypeGemini != 18) {
                return false;
            }
            return IMS_VOLTE_ENABLE.equals(stringSystemProperties);
        }
        return IMS_VOWIFI_ENABLE.equals(stringSystemProperties);
    }

    public static boolean getIsHangUpConfernceCall() {
        return sIsHangUpConfernceCall;
    }

    public static boolean getIsHangUpFromHeadset(Context context) {
        boolean f10 = A2.l.d().f();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getIsHangUpFromHeadset ... isHangUpFromHeadset = " + f10);
        }
        return f10;
    }

    public static boolean getIsLockScreenWhenFirstCallInComing() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getIsLockScreenWhenFirstCallInComing adfafd= " + sIsLockScreenWhenFirstCallInComing);
        }
        return sIsLockScreenWhenFirstCallInComing;
    }

    public static String getMarkNumber() {
        return sMarkNumber;
    }

    public static int getNavigationBarHeight(Context context) {
        int i10 = 0;
        if (context == null) {
            Log.d(LOG_TAG, "getNavigationBarHeight context is null, return 0;");
            return 0;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0 && hasSoftNavigationBar(context) && InCallPresenter.getInstance().isNavigationBarShow()) {
            i10 = resources.getDimensionPixelSize(identifier);
        }
        Log.d(LOG_TAG, "getNavigationBarHeight navigationBarHeight = " + i10);
        return i10;
    }

    public static boolean getNeedMarkNumber(Context context) {
        boolean z10;
        if (context == null) {
            return false;
        }
        if (OplusFeatureOption.OPLUS_VERSION_EXP && !OplusFeatureOption.FEATURE_NUMBER_RECOGNITION.value().booleanValue()) {
            Log.d(LOG_TAG, "exp veriosn that not support number recognition, return false.");
            return false;
        }
        if (SettingsUtils.INSTANCE.getSystemSettingsInt(context.getContentResolver(), "suspicious_number_confirmed_switch", 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.d(LOG_TAG, "getNeedMarkNumber: markSwitch = " + z10 + ", sNeedMarkNumber = " + sNeedMarkNumber + ", isHangUpConfernceCall = " + getIsHangUpConfernceCall());
        if (!z10 || !sNeedMarkNumber || getIsHangUpConfernceCall()) {
            return false;
        }
        return true;
    }

    public static int getNotificationId(String str) {
        if (str == null) {
            return 0;
        }
        try {
            String trim = Pattern.compile(NO_NUMBER_PATTERN_STR).matcher(str).replaceAll("").trim();
            Log.d(LOG_TAG, "getNotificationId number = " + D2.g.l(trim));
            if (TextUtils.isEmpty(trim)) {
                return 0;
            }
            if (trim.length() >= 10) {
                trim = trim.substring(trim.length() - 8);
            }
            return Integer.parseInt(trim);
        } catch (Exception unused) {
            Log.d(LOG_TAG, "The error of formating number");
            return 0;
        }
    }

    public static int getNumberHideSettings(Context context) {
        return AddOnSdkDepends.getSInstance().getNumberHideSettings(context);
    }

    public static String getNumberLocation(String str, Context context) {
        if (context == null) {
            return "";
        }
        context.getResources();
        if (str == null) {
            return "";
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "Input Call Number: " + D2.g.l(str));
        }
        String replaceAll = str.replaceAll(" ", "");
        NumberAttributionInfo numberAttributionInfo = mNumberAttributionCache.get(replaceAll);
        if (numberAttributionInfo != null) {
            return numberAttributionInfo.mLocation;
        }
        if (!TextUtils.isEmpty(replaceAll)) {
            log("the length of number is: " + replaceAll.length());
        } else {
            log("the  number is  null ");
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getNumberLocation: location = " + D2.g.o(""));
        }
        return "";
    }

    public static String getNumberMaskedStr(String str, int i10) {
        int i11;
        int i12;
        if (!TextUtils.isEmpty(str) && str.length() >= 6 && !str.startsWith(FREE_NUM)) {
            int length = str.length();
            if (i10 == 1) {
                int i13 = MASK_LENGTH;
                i11 = (length - i13) / 2;
                i12 = i13 + i11;
            } else if (i10 == 2) {
                i11 = length - MASK_LENGTH;
                i12 = length;
            } else {
                return str;
            }
            return str.substring(0, i11) + MASK_STRING + str.substring(i12);
        }
        return str;
    }

    public static int getOriginalCallType(Call call) {
        if (call != null && call.getExtras() != null) {
            int i10 = call.getExtras().getInt("originalCallType", -1);
            Log.d(LOG_TAG, "getOriginalCallType originalCallType=" + i10);
            return i10;
        }
        Log.d(LOG_TAG, "getOriginalCallType call or extras is null!");
        return -1;
    }

    public static boolean getPhoneScreenLockState(Context context) {
        if (context == null) {
            log("getPhoneScreenLockState  context is null");
            return false;
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (keyguardManager == null) {
            return false;
        }
        return keyguardManager.isKeyguardLocked();
    }

    public static int getPhoneTypeByAccountHandle(PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle != null && phoneAccountHandle.getId() != null && !"E".equals(phoneAccountHandle.getId())) {
            return getPhoneTypeBySlotId(A2.d.c(phoneAccountHandle));
        }
        return -1;
    }

    public static int getPhoneTypeBySlotId(int i10) {
        return InternalSdkDepends.getSInstance().getPhoneTypeBySlotId(OplusInCallApp.getAppContext(), i10);
    }

    public static int getPhoneTypeBySubId(int i10) {
        return getPhoneTypeBySlotId(SubscriptionManager.getSlotIndex(i10));
    }

    public static int getPrimarySlotId(Context context) {
        if (context == null) {
            return -1;
        }
        return SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), OPLUS_NETWORK_PRIMARY_SLOT, 0);
    }

    public static int getRakutenPrefixPreferenceValue(Context context) {
        int i10;
        int i11 = 2;
        if (context != null) {
            i10 = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), RAKUTEN_PREFIX_PREFERENCE, 2);
        } else {
            i10 = 2;
        }
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            i11 = i10;
        }
        Log.d(LOG_TAG, "getRakutenPrefixPreferenceValue = " + i11);
        return i11;
    }

    public static String getRakutenPrefixString(Context context) {
        String str;
        if (context != null) {
            str = SettingsUtils.INSTANCE.getGlobalSettingsString(context.getContentResolver(), RAKUTEN_PREFIX, "");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = DEFAULT_PREFIX;
        }
        Log.d(LOG_TAG, "getRakutenPrefixString = " + str);
        return str;
    }

    public static String getRecordFileNameMaskedStr(String str, int i10) {
        int i11;
        int i12;
        if (!TextUtils.isEmpty(str) && str.length() >= 6 && !str.startsWith(FREE_NUM)) {
            int length = str.length();
            if (i10 == 1) {
                i11 = (length - 4) / 2;
                i12 = i11 + 4;
            } else if (i10 == 2) {
                i11 = length - 4;
                i12 = length;
            } else {
                return str;
            }
            return str.substring(0, i11) + RECORD_FILE_NAME_MASK_STRING + str.substring(i12);
        }
        return str;
    }

    public static int getRotation(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            Display display = context.getDisplay();
            if (display == null) {
                return 0;
            }
            return display.getRotation();
        } catch (Exception e10) {
            Log.e(LOG_TAG, "getRotation exception :" + e10.getMessage());
            return 0;
        }
    }

    public static boolean getShowLockScreenAnswerView() {
        return sShowLockScreenAnswerView;
    }

    public static int getStatusBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        Log.d(LOG_TAG, "getStatusBarHeight: height = " + dimensionPixelSize);
        return dimensionPixelSize;
    }

    public static TelecomManager getTelecomManager(Context context) {
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "getTelecomManager context is null return !!!");
                return null;
            }
            return null;
        }
        return (TelecomManager) context.getSystemService("telecom");
    }

    public static boolean getVideoPausedForConf() {
        return sVideoPausedForConf;
    }

    public static boolean getVideoResumeState(boolean z10, int i10) {
        Log.d(LOG_TAG, "getVideoResumeState event " + i10);
        if (i10 != 4011 && i10 != 1) {
            if (i10 == 4012 || i10 == 2) {
                return true;
            }
            return z10;
        }
        return false;
    }

    public static void goToSleep(Context context) {
        InternalSdkDepends.getSInstance().goToSleep(context);
    }

    public static Boolean hasReadStoragePermission(Context context) {
        boolean z10;
        if (context == null) {
            return Boolean.FALSE;
        }
        if (androidx.core.content.b.a(context, "android.permission.READ_MEDIA_AUDIO") == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    public static boolean hasSoftNavigationBar(Context context) {
        boolean z10 = true;
        try {
            Display display = getDisplay(context);
            if (display == null) {
                return true;
            }
            z10 = InternalSdkDepends.getSInstance().hasNavigationBar(display.getDisplayId());
            Log.d(LOG_TAG, "hasSoftNavigationBar result = " + z10);
            return z10;
        } catch (Exception e10) {
            Log.d(LOG_TAG, "hasSoftNavigationBar exception = " + e10.getMessage());
            return z10;
        }
    }

    public static boolean hasSpeechAssistPermission(Context context) {
        if (context == null) {
            Log.d(LOG_TAG, "hasSpeechAssistPermission context is null, return false!");
            return false;
        }
        Bundle bundle = null;
        try {
            bundle = context.getContentResolver().call(Uri.parse("content://com.heytap.speechassist.instruction"), "method_has_user_grant_permission", (String) null, (Bundle) null);
        } catch (Exception e10) {
            Log.w(LOG_TAG, "hasSpeechAssistPermission call catch exception:" + e10);
        }
        if (bundle == null) {
            Log.d(LOG_TAG, "hasSpeechAssistPermission bundle is null, return false!");
            return false;
        }
        boolean z10 = bundle.getBoolean("key_user_grant_permission", false);
        Log.d(LOG_TAG, "hasSpeechAssistPermission hasPermission = " + z10);
        return z10;
    }

    public static boolean hasVideoCall() {
        if (CallList.getInstance() != null) {
            return ((OplusCallList) CallList.getInstance()).hasVideoCall();
        }
        return false;
    }

    public static boolean hasVideoRingToneCall() {
        if (CallList.getInstance() != null) {
            return ((OplusCallList) CallList.getInstance()).hasVideoRingToneCall();
        }
        return false;
    }

    public static boolean hasWatchDevice() {
        Iterator<BluetoothDevice> it = AudioModeProvider.getInstance().getAudioState().getSupportedBluetoothDevices().iterator();
        while (it.hasNext()) {
            if (A2.l.d().g(it.next().getAddress())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isApkInstalled(Context context, String str) {
        boolean z10;
        if (context == null) {
            Log.d(LOG_TAG, "isApkInstalled, context is null");
            return false;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Log.d(LOG_TAG, "isApkInstalled, result = " + z10);
            return z10;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.d(LOG_TAG, "isApkInstalled, exception = " + e10.getMessage());
            return false;
        }
    }

    public static boolean isAutoSpeakerOn() {
        Call firstCall = CallList.getInstance().getFirstCall();
        if (firstCall != null) {
            return firstCall.needTurnOnSpeaker();
        }
        return false;
    }

    public static boolean isBreathMode(Context context) {
        if (context == null || SettingsUtils.INSTANCE.getSecureSettingsInt(context.getContentResolver(), OP_BREATH_MODE_KEY, 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isCDMATelecomCustomize() {
        if (Log.sDebug) {
            log("isCDMATelecomCustomize = " + OplusFeatureOption.OPLUS_CT_OPTR);
        }
        return OplusFeatureOption.OPLUS_CT_OPTR;
    }

    public static boolean isCMCCNumberPrefix(Call call, Context context) {
        boolean z10 = false;
        if (OplusFeatureOption.FEATURE_CMCC_MOBILE_VIDEO && context != null && call != null) {
            String number = call.getNumber();
            if (TextUtils.isEmpty(number)) {
                Log.d(LOG_TAG, "callNumber is null return false");
                return false;
            }
            String formatNumber = PhoneNumberUtils.formatNumber(number.replaceAll(" ", ""), InternalSdkDepends.getSInstance().getCurrentCountryIso(OplusInCallApp.getAppContext().getApplicationContext()));
            if (formatNumber == null) {
                return false;
            }
            if (formatNumber.startsWith("10086")) {
                Log.d(LOG_TAG, "isCMCCNumberPrefix start 10086 return true");
                return true;
            }
            String[] stringArray = context.getResources().getStringArray(R.array.cmcc_mobile_video_number_list);
            if (stringArray == null) {
                Log.d(LOG_TAG, "isCMCCNumberPrefix mobileVideoNumbers is null");
                return false;
            }
            int length = stringArray.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (formatNumber.equals(stringArray[i10])) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            Log.d(LOG_TAG, "isCMCCNumberPrefix isCmccPrefix = " + z10);
            return z10;
        }
        Log.d(LOG_TAG, "feature or context or call is null return false");
        return false;
    }

    public static boolean isCarrierInCommingRingtoneFirst(Context context) {
        if (context == null) {
            return false;
        }
        return DeviceState.LOCK_DEVICE.equals(SettingsUtils.INSTANCE.getGlobalSettingsString(context.getContentResolver(), CMCC_INCOMMING_RINGTONE_RUS_VALUE, ""));
    }

    public static boolean isCrsCall(Call call) {
        if (call != null && call.getExtras() != null) {
            int i10 = call.getExtras().getInt("crsType", 0);
            Log.d(LOG_TAG, "isCrsCall crsTypeExtras = " + i10);
            if (i10 != 1 && i10 != 3) {
                return false;
            }
            return true;
        }
        Log.d(LOG_TAG, "isCrsCall call or extras is null!");
        return false;
    }

    private static boolean isDTACOperator(int i10, int i11) {
        if (sOperatorMccMnc == null) {
            sOperatorMccMnc = D2.l.b(OplusInCallApp.getAppContext(), i10, i11);
            Log.d(LOG_TAG, "isDTACOperator operator mnc =  " + D2.g.o(sOperatorMccMnc));
        }
        for (String str : DTAC_NUMERIC) {
            if (str.equals(sOperatorMccMnc)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDeviceLocked(Context context) {
        if (!OplusFeatureOption.OPLUS_VERSION_EXP) {
            return false;
        }
        boolean equals = TextUtils.equals(getDeviceLockedStatus(context), DeviceState.LOCK_DEVICE);
        Log.d(LOG_TAG, "isDeviceLocked:" + equals);
        return equals;
    }

    public static boolean isDeviceProvisioned(Context context) {
        boolean z10 = false;
        if (SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), "device_provisioned", 0) != 0) {
            z10 = true;
        }
        Log.d(LOG_TAG, "provisioned = " + z10);
        return z10;
    }

    public static boolean isDeviceRestricted(Context context) {
        if (context == null) {
            return false;
        }
        if (isDeviceProvisioned(context) && !isDeviceLocked(context) && isUserUnlocked(context)) {
            return false;
        }
        return true;
    }

    public static boolean isEmergencyNumber(String str) {
        return isEmergencyNumber(str, null);
    }

    public static boolean isFirstVideoCallAfterResetPhone(Context context) {
        boolean z10 = false;
        if (context == null) {
            Log.e(LOG_TAG, "isFirstVideoCallAfterResetPhone: context is null, return false");
            return false;
        }
        SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
        int globalSettingsInt = settingsUtils.getGlobalSettingsInt(context.getContentResolver(), FIRST_VIDEO_CALL_AFTER_RESET_PHONE_PREFERENCE, 0);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isFirstVideoCallAfterResetPhone = " + globalSettingsInt);
        }
        if (globalSettingsInt == 0) {
            z10 = true;
            settingsUtils.putGlobalSettingsInt(context.getContentResolver(), FIRST_VIDEO_CALL_AFTER_RESET_PHONE_PREFERENCE, 1);
            if (Log.sDebug) {
                Log.d(LOG_TAG, "set FIRST_VIDEO_CALL_AFTER_RESET_PHONE_PREFERENCE = 1");
            }
        }
        return z10;
    }

    public static boolean isImsRegistered(Context context, int i10) {
        int slotIndex;
        if (context == null || i10 == -1) {
            Log.i(LOG_TAG, "isImsRegistered, context is null or sudId is -1 !");
            return false;
        }
        Call callToShow = getCallToShow(CallList.getInstance());
        if (callToShow != null && callToShow.getHasSRVCC()) {
            Log.d(LOG_TAG, "isImsRegistered, return false because of srvcc!");
            return false;
        }
        if (callToShow != null) {
            slotIndex = callToShow.getSlotId();
        } else {
            slotIndex = SubscriptionManager.getSlotIndex(i10);
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isImsRegistered, subId = " + i10 + ", slotId = " + slotIndex);
        }
        if (isImsRegistered(slotIndex)) {
            return true;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isImsRegistered, return false.");
        }
        return false;
    }

    private static boolean isImsVowifi(int i10) {
        int slotIndex = SubscriptionManager.getSlotIndex(i10);
        String str = PRO_IMS_TYPE + slotIndex;
        String stringSystemProperties = InternalSdkDepends.getSInstance().getStringSystemProperties(str, "");
        if (Log.sDebug) {
            Log.d(LOG_TAG, "slotId = " + slotIndex + " ims = " + str + " imsType = " + stringSystemProperties);
        }
        return IMS_VOWIFI_ENABLE.equals(stringSystemProperties);
    }

    public static boolean isInBlackScreenMode(Context context) {
        if (context == null) {
            Log.e(LOG_TAG, "isInBlackScreenMode: context is null, return false");
            return false;
        }
        int globalSettingsInt = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), KEY_BLACK_SCREEN_MODE, 0);
        Log.d(LOG_TAG, "isInBlackScreenMode KEY_BLACK_SCREEN_MODE = " + globalSettingsInt);
        if (globalSettingsInt != 1) {
            return false;
        }
        return true;
    }

    private static boolean isInEmergencyCall(Context context) {
        return InternalSdkDepends.getSInstance().isInEmergencyCall(context);
    }

    public static boolean isInLockTaskMode() {
        return InternalSdkDepends.getSInstance().isInLockTaskMode(OplusInCallApp.getAppContext());
    }

    public static boolean isInSplitScreenMode() {
        return AddOnSdkDepends.getSInstance().isInSplitScreenMode();
    }

    public static boolean isJpKddiOperatorNumeric(int i10, int i11) {
        String c10 = D2.l.c(OplusInCallApp.getAppContext(), i10, i11);
        if (TextUtils.isEmpty(c10)) {
            return false;
        }
        for (String str : KDDI_NUMERIC) {
            if (str.equals(c10)) {
                log("isj_kOperatorNumeric return true");
                return true;
            }
        }
        return false;
    }

    public static boolean isKDDIConferenceCall(Call call) {
        if (call == null || !call.isConferenceCall()) {
            return false;
        }
        String b10 = D2.l.b(OplusInCallApp.getAppContext(), call.getSlotId(), call.getSubId());
        if (TextUtils.isEmpty(b10)) {
            return false;
        }
        return Arrays.asList(KDDI_NUMERIC).contains(b10);
    }

    public static boolean isLargeSuspensionFrame(Context context) {
        int i10;
        int i11;
        boolean z10 = false;
        if (context == null) {
            log("isLargeSuspensionFrame context is null");
            return false;
        }
        log("isLargeSuspensionFrame bein");
        try {
            Rect floatWindowRect = AddOnSdkDepends.getSInstance().getFloatWindowRect();
            if (floatWindowRect != null) {
                i11 = floatWindowRect.width();
                i10 = floatWindowRect.height();
            } else {
                i10 = 0;
                i11 = 0;
            }
            if (i11 > 0 && i10 > 0) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                int width = windowManager.getDefaultDisplay().getWidth();
                int height = windowManager.getDefaultDisplay().getHeight();
                if (width != 0 && height != 0) {
                    int i12 = ((i11 * i10) * 100) / (width * height);
                    log("isLargeSuspensionFrame suspensionFrameWidth = " + i11 + " suspensionFrameHeight = " + i10 + "\n phoneWidth = " + width + " phoneHeight = " + height + " percent = " + i12);
                    if (i12 >= 10) {
                        z10 = true;
                    }
                }
            }
        } catch (Exception e10) {
            Log.d(LOG_TAG, "Exception: " + e10);
        }
        log("isLargeSuspensionFrame end flag = " + z10);
        return z10;
    }

    public static boolean isMTCallDisplayFloat(Context context) {
        boolean z10;
        if (context != null && SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), MT_CALL_DISPLAY_MODE, 0) != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        log("isMTCallDisplayFloat isFloatMode = " + z10);
        boolean simlockLockdevice = AddOnSdkDepends.getSInstance().getSimlockLockdevice(context);
        log("isMTCallDisplayFloat isLockDevice = " + simlockLockdevice);
        if (!z10 || simlockLockdevice) {
            return false;
        }
        return true;
    }

    public static boolean isMotorCameraUp(Context context) {
        return AddOnSdkDepends.getSInstance().isMotorCameraUp(context);
    }

    public static boolean isMultiSimEnabled() {
        if (InCallServiceImpl.sPhoneCount >= 2) {
            return true;
        }
        return false;
    }

    public static boolean isNeedHideCallHarassInterceptSetting() {
        boolean z10 = OplusFeatureOption.FEATURE_HIDE_CALL_HARASS_INTERCEPT;
        Log.d(LOG_TAG, "isNeedHideCallHarassInterceptSetting  = " + z10);
        return z10;
    }

    public static boolean isNeedHideHoldOption(Call call, Call call2, int i10, boolean z10) {
        if (call == null || call2 == null || call.getSlotId() == call2.getSlotId()) {
            return false;
        }
        if (z10) {
            Log.d(LOG_TAG, "isNeedHideHoldOption: dsda hold not Support");
            return true;
        }
        if (call.isVideoCall() || VideoProfile.isVideo(i10)) {
            return true;
        }
        if (!InCallServiceImpl.isDsdaEnabled()) {
            Log.d(LOG_TAG, "isNeedHideHoldOption: dsda not enable");
            return true;
        }
        return false;
    }

    public static boolean isNeedHideRecord(Context context) {
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "isNeedHideRecord context is null return");
            }
            return false;
        }
        T5.a d10 = BrandCenter.f19187a.a().d();
        if (d10 != null && d10.w(context)) {
            return d10.l(context);
        }
        if (OplusFeatureOption.FEATURE_SEND_CALL_RECORD_PATH || OplusFeatureOption.FEATURE_RECORD_FOR_THIRD_PARTY) {
            return true;
        }
        if (OplusFeatureOption.VERSION_STORE && !isApkInstalled(context, OPLUS_CALL_RECORDER_APK_PACKAGE)) {
            return true;
        }
        if (OplusFeatureOption.VERSION_STORE && context.getContentResolver() != null) {
            OplusFeatureOption.OPLUS_FEATURE_INCALLUI_NO_DISPLAY_RECORD = AddOnSdkDepends.Companion.getSInstance().isFeatureSupport(context.getContentResolver(), OPLUS_NO_DISPLAY_RECORD);
        }
        log("isNeedHideRecord  hasFeature = " + OplusFeatureOption.OPLUS_FEATURE_INCALLUI_NO_DISPLAY_RECORD);
        if (!OplusFeatureOption.OPLUS_FEATURE_INCALLUI_NO_DISPLAY_RECORD) {
            return false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isNeedHideRecord true");
        }
        return true;
    }

    public static boolean isNeedHideVideoCallButton() {
        if (PRODUCT_FLAVOR == 1 && OplusFeatureOption.FEATURE_HIDE_VIDEO_CALL.value().booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean isNeedPlayBusyTone(int i10) {
        if (i10 == 7 && OplusFeatureOption.FEATURE_PLAY_BUSY_TONE) {
            return true;
        }
        return false;
    }

    public static boolean isNeedShowTransferButton(Context context) {
        if (context == null || !OplusFeatureOption.FEATURE_SHOW_TRANSFER_BUTTON.value().booleanValue()) {
            return false;
        }
        OplusCallList oplusCallList = CallList.getInstance().oplusCallList();
        if (InCallServiceImpl.isDsdaEnabled() || oplusCallList == null || oplusCallList.oplusGetCallSize() != 2) {
            return false;
        }
        return true;
    }

    public static boolean isNeedShowVideoCallHold(Context context, Call call) {
        if (context != null && call != null) {
            return getBooleanCarrierConfig(context, "allow_hold_video_call_bool", call.getSubId());
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isNeedShowVideoCallHold context is null or call is null return");
            return false;
        }
        return false;
    }

    public static boolean isNotShowHDIcon(Call call) {
        boolean z10 = false;
        if (call == null) {
            return false;
        }
        int slotId = call.getSlotId();
        boolean isImsRegistered = isImsRegistered(slotId);
        if (!isImsRegistered && isNotShowHDIconForOperator(slotId, call.getSubId())) {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "result = " + z10 + ", isImsRegistered = " + isImsRegistered);
        }
        return z10;
    }

    public static boolean isNotShowHDIconForOperator(int i10, int i11) {
        String c10 = D2.l.c(OplusInCallApp.getAppContext(), i10, i11);
        boolean z10 = false;
        if (!TextUtils.isEmpty(c10)) {
            String[] strArr = A2.e.f117a;
            int length = strArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                if (strArr[i12].equals(c10)) {
                    z10 = true;
                    break;
                }
                i12++;
            }
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isNotShowHDIcon notShow = " + z10);
        }
        return z10;
    }

    public static boolean isNotesInstalled(Context context) {
        PackageInfo packageInfo;
        if (context == null) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(NOTES_PACKAGE_NAME, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.d(LOG_TAG, "isNotesInstalled: NameNotFoundException for package " + NOTES_PACKAGE_NAME);
            packageInfo = null;
        }
        if (packageInfo != null) {
            Log.d(LOG_TAG, "isNotesInstalled: found package " + NOTES_PACKAGE_NAME);
            return true;
        }
        Log.d(LOG_TAG, "isNotesInstalled: not installed");
        return false;
    }

    public static boolean isOcarDriveMode(Context context) {
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "isOcarDriveMode context is null return");
            }
            return false;
        }
        Bundle bundle = null;
        try {
            bundle = context.getContentResolver().call(Uri.parse(OCAR_AUTHORITY), OCAR_METHOD, (String) null, (Bundle) null);
        } catch (IllegalArgumentException e10) {
            Log.d(LOG_TAG, "get car mode error message = " + e10.getMessage());
        }
        if (bundle == null) {
            return false;
        }
        int i10 = bundle.getInt(OCAR_MODE);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "mode = " + i10);
        }
        if (i10 == 1000) {
            return false;
        }
        return true;
    }

    public static boolean isOpenMarketInCommingRingtoneFirst(Context context) {
        if (context == null) {
            return false;
        }
        return DeviceState.LOCK_DEVICE.equals(SettingsUtils.INSTANCE.getGlobalSettingsString(context.getContentResolver(), OPENMARKET_INCOMMING_RINGTONE_RUS_VALUE, ""));
    }

    public static boolean isOplusVideoCallEnableAndImsRegistered(int i10) {
        if (InternalSdkDepends.getSInstance().isNotSystemUser()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "video call not supported for child user");
            }
            return false;
        }
        if ((!sOplusVolteVideoCallEnable || !getImsRegistered(true, i10)) && (!sOplusVowifiVideoCallEnable || !getImsRegistered(false, i10))) {
            return false;
        }
        return true;
    }

    public static boolean isRamLessAodSupport(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        return packageManager.hasSystemFeature(OPLUS_AOD_RAMLESS_SUPPORT);
    }

    public static boolean isReplyWithSmsAllowed(Context context) {
        return InternalSdkDepends.getSInstance().isReplyWithSmsAllowed(context);
    }

    public static boolean isRideMode() {
        if (OplusFeatureOption.OPLUS_PHONE_SUPPORT_RIDE_MODE_SECRET) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "isRideMode support secret, return false.");
            }
            return false;
        }
        C1731b.f e10 = C1731b.d().e(2);
        if (C1731b.h.a(e10.a())) {
            return false;
        }
        return ((C1731b.j) e10.d()).f38284a;
    }

    public static boolean isRttFeatureOn() {
        return OplusFeatureOption.FEATURE_ENABLE_RTT_UI;
    }

    public static boolean isRttSettingOn(Context context) {
        if (context == null || SettingsUtils.INSTANCE.getSecureSettingsInt(context.getContentResolver(), "rtt_calling_mode", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isScreenLocked(Context context) {
        boolean z10 = false;
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "isScreenLocked context is null. ret = false");
            }
            return false;
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (keyguardManager != null) {
            z10 = keyguardManager.inKeyguardRestrictedInputMode();
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isScreenLocked  ret = " + z10);
        }
        return z10;
    }

    public static boolean isScreenOn(Context context) {
        boolean z10;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            z10 = powerManager.isInteractive();
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isScreenOn ... ret = " + z10);
        }
        return z10;
    }

    public static boolean isShowConferenceManageButton(Call call) {
        if (call == null || !call.can(128)) {
            return false;
        }
        if (OplusFeatureOption.OPLUS_PHONE_HIDE_CONFERENCE_MANAGE_BUTTON_AFTER_SRVCC && call.isSRVCCConference()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "isShowConferenceManageButton, return false because call is SRVCCConference!");
            }
            return false;
        }
        return true;
    }

    public static boolean isShowPrivacyToast(Context context, Integer num, OplusCallList oplusCallList, boolean z10) {
        if (context != null && oplusCallList != null) {
            if (oplusCallList.getIncomingCall() == null || oplusCallList.getActiveOrBackgroundCall() != null) {
                return false;
            }
            if (SettingsUtils.INSTANCE.getSecureSettingsInt(context.getContentResolver(), "pc_connect_state", 0) == 0) {
                Log.d(LOG_TAG, "changeCallCastAudioModeForPcOrPad pc not connected, return");
                return false;
            }
            com.android.incallui.mvvm.repository.dynamic.a aVar = com.android.incallui.mvvm.repository.dynamic.a.f18559a;
            if ((aVar.o() && !hasWatchDevice()) || aVar.k0()) {
                if (aVar.D1()) {
                    CastScreen.f19196a.a().a(0);
                }
                return false;
            }
            if (num.intValue() != 999 && num.intValue() != 998) {
                return false;
            }
            return setPrivacyValue(context, z10);
        }
        Log.d(LOG_TAG, "changeCallCastAudioModeForPcOrPad context or oplusCallList is null, return");
        return false;
    }

    public static boolean isSmartAutoAnswerOn(Context context) {
        boolean z10 = false;
        if (context != null) {
            if (SettingsUtils.INSTANCE.getSystemSettingsInt(context.getContentResolver(), OPLUS_SMART_APPERCEIVE_AUTO_ANSWER, 0) != 0) {
                z10 = true;
            }
            if (Log.sDebug) {
                Log.d(LOG_TAG, "isSmartAutoAnswerOn autoAnswer = " + z10);
            }
        }
        return z10;
    }

    public static boolean isSoftwareAodSupport() {
        return AddOnSdkDepends.Companion.getSInstance().hasFeature(OPLUS_AOD_SUPPORT);
    }

    public static boolean isSupportHideMTCallUiByWatch(Context context) {
        return D2.h.a(context, "com.android.server.telecom", "hide_mt_call_by_watch_support", "true");
    }

    public static Boolean isSupportLightEffect(Context context) {
        return Boolean.valueOf(D2.h.a(context, "com.android.phone", "support_aod_teleservice", "true"));
    }

    public static boolean isSupportWCG(Context context) {
        if (context == null) {
            Log.d(LOG_TAG, "isSupportWCG: context is null!");
            return false;
        }
        if (!OplusFeatureOption.IS_WCG_DISPLAY_SUPPORTED) {
            Log.d(LOG_TAG, "isSupportWCG: feature not support");
            return false;
        }
        if (!context.getResources().getConfiguration().isScreenWideColorGamut()) {
            Log.d(LOG_TAG, "isSupportWCG: wide color not support");
            return false;
        }
        return true;
    }

    public static boolean isSystemUser(Context context) {
        if (context == null) {
            Log.d(LOG_TAG, "isSystemUser: context is null, return true");
            return true;
        }
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        if (userManager == null) {
            return true;
        }
        return userManager.isSystemUser();
    }

    public static boolean isTelephonyIdle(Context context) {
        return InternalSdkDepends.getSInstance().isTelephonyIdle(context);
    }

    public static boolean isTelephonyRinging(Context context) {
        return InternalSdkDepends.getSInstance().isRinging(context);
    }

    public static boolean isTelstraVoiceMail() {
        String e10 = D2.l.e(OplusInCallApp.getAppContext());
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isTelstraVoiceMail vmNumber = " + D2.g.l(e10));
        }
        if (OplusFeatureOption.OPLUS_PHONE_TELSTRA_DEFAULT_VM && e10 != null && e10.equals(TELSTRA_DEFAULT_VOICE_MAIL)) {
            return true;
        }
        return false;
    }

    public static boolean isUserGestureMode(Context context) {
        if (context == null) {
            Log.e(LOG_TAG, "isUserGestureMode: context is null");
            return false;
        }
        int secureSettingsInt = SettingsUtils.INSTANCE.getSecureSettingsInt(context.getContentResolver(), KEY_NAV_STATE, -1);
        Log.d(LOG_TAG, "isUserGestureMode: mode = " + secureSettingsInt);
        if (secureSettingsInt != 2 && secureSettingsInt != 3) {
            return false;
        }
        return true;
    }

    public static boolean isUserUnlocked(Context context) {
        UserManager userManager;
        if (context == null || (userManager = (UserManager) context.getSystemService(UserManager.class)) == null) {
            return true;
        }
        return userManager.isUserUnlocked();
    }

    public static boolean isUstOplusExport() {
        T5.a d10 = BrandCenter.f19187a.a().d();
        if (d10 != null && d10.k()) {
            return true;
        }
        return false;
    }

    public static boolean isVideoCrbt(Call call, int i10) {
        if (call != null && Call.State.isConnectingOrDialing(call.getState()) && !VideoProfile.isTransmissionEnabled(i10) && VideoProfile.isReceptionEnabled(i10)) {
            return true;
        }
        return false;
    }

    public static boolean isVowifiState(Call call, int i10) {
        if (call != null && call.getHasSRVCC()) {
            Log.d(LOG_TAG, "isVowifiState, return false because of srvcc!");
            return false;
        }
        if (call != null && call.getState() != 6 && call.getState() != 13) {
            return call.hasProperty(8);
        }
        return isImsVowifi(i10);
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1)) == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean isZenMode() {
        return InternalSdkDepends.getSInstance().isZenModeOn(OplusInCallApp.getAppContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateIsInEmergencyCallValue$0() {
        sIsInEmergencyCall = isInEmergencyCall(OplusInCallApp.getAppContext());
    }

    public static void lockScreenIfNeeded(Context context) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "LockScreenIfNeeded adfadfas");
        }
        if (getIsHangUpFromHeadset(context) && getIsLockScreenWhenFirstCallInComing()) {
            goToSleep(context);
        }
        setIsLockScreenWhenFirstCallInComing(false);
    }

    private static void log(String str) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, str);
        }
    }

    public static void messageSentToast(Context context) {
        Toast c10;
        Log.d(LOG_TAG, "messageSentToast...");
        if (context != null && (c10 = A2.b.b().c(R.string.oplus_sms_sent, 1)) != null) {
            c10.show();
        }
    }

    public static boolean needSetMaskForVideoCall() {
        boolean z10 = false;
        if (!OplusFeatureOption.FEATURE_CMCC_MOBILE_VIDEO) {
            Log.d(LOG_TAG, "no needSetMaskForVideoCall ");
            return false;
        }
        Call activeCall = CallList.getInstance().oplusCallList().getActiveCall();
        if (activeCall != null) {
            String number = activeCall.getNumber();
            if (!TextUtils.isEmpty(number) && OplusInCallApp.getAppContext().getApplicationContext() != null) {
                String formatNumber = PhoneNumberUtils.formatNumber(number.replaceAll(" ", ""), InternalSdkDepends.getSInstance().getCurrentCountryIso(OplusInCallApp.getAppContext().getApplicationContext()));
                if (formatNumber == null) {
                    return false;
                }
                String[] stringArray = OplusInCallApp.getAppContext().getApplicationContext().getResources().getStringArray(R.array.cmcc_mobile_video_number_list);
                if (stringArray == null) {
                    Log.d(LOG_TAG, "needSetMaskForVideoCall mobileVideoNumbers is null");
                    return false;
                }
                int length = stringArray.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    if (formatNumber.equals(stringArray[i10])) {
                        z10 = true;
                        break;
                    }
                    i10++;
                }
            }
        }
        Log.d(LOG_TAG, "needSetMaskForVideoCall needSet = " + z10);
        return z10;
    }

    public static boolean needShowLocation(Context context) {
        boolean z10;
        if (getNumberHideSettings(context) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sOplusDebug) {
            Log.d(LOG_TAG, "needShowLocation = " + z10);
        }
        return z10;
    }

    public static boolean needShowSeparateButton(Context context, Call call) {
        boolean z10;
        if (!OplusFeatureOption.OPLUS_VERSION_EXP || context == null || call == null) {
            return true;
        }
        if (call.can(128) && call.isSRVCCConference()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "needShowSeparateButton, return false because call.isSRVCCConference!");
            }
            return false;
        }
        Call parentCall = call.getParentCall();
        if (parentCall != null && parentCall.isSRVCCConference()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "needShowSeparateButton, return false because parentCall.isSRVCCConference!");
            }
            return false;
        }
        OplusCall oplusCall = (OplusCall) getCallToShow(CallList.getInstance());
        if (oplusCall != null) {
            z10 = oplusCall.isIms();
            if (Log.sDebug) {
                Log.d(LOG_TAG, "needShowSeparateButton, the callToShow isIms = " + z10);
            }
        } else {
            z10 = false;
        }
        if (!isImsRegistered(context, call.getSubId()) && !z10) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "needShowSeparateButton, return true");
            }
            return true;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "needShowSeparateButton, return false because ims registered or SRVCC conference");
        }
        return false;
    }

    public static boolean needShowSideWaveView(Context context) {
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "needShowSideWaveView, context is null return false");
            }
            return false;
        }
        if (isSoftwareAodSupport() && !isRamLessAodSupport(context)) {
            if (!isSupportLightEffect(context).booleanValue()) {
                Log.d(LOG_TAG, "teleservice Not support side wave view");
                return false;
            }
            if (CallList.getInstance().getActiveOrBackgroundCall() != null) {
                Log.d(LOG_TAG, "Has active or background call, hide side wave view");
                return false;
            }
            SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
            String secureSettingsString = settingsUtils.getSecureSettingsString(context.getContentResolver(), "oplus_customize_comm_incallui_curved_display_notification_color", "");
            Log.d(LOG_TAG, "needShowSideWaveView, lightEffectColor = " + secureSettingsString);
            if (!"red".equals(secureSettingsString) && !"gold".equals(secureSettingsString) && !"blue".equals(secureSettingsString)) {
                return false;
            }
            int secureSettingsInt = settingsUtils.getSecureSettingsInt(context.getContentResolver(), "oplus_customize_aod_curved_display_call_switch", 0);
            Log.d(LOG_TAG, "needShowSideWaveView, notifyOption = " + secureSettingsInt);
            if (secureSettingsInt != 1) {
                return false;
            }
            return true;
        }
        Log.d(LOG_TAG, "Not support side wave view");
        return false;
    }

    public static boolean noNeedHandleClickForCMCC() {
        boolean z10;
        Call activeCall = CallList.getInstance().oplusCallList().getActiveCall();
        if (isCMCCNumberPrefix(activeCall, OplusInCallApp.getAppContext().getApplicationContext()) && activeCall != null && activeCall.getVideoState() == 3 && activeCall.getState() == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "noNeedHandleClickForCMCC: " + z10);
        }
        return z10;
    }

    public static void oplusAddOnSubscriptionsChangedListener(Context context, SubscriptionManager.OnSubscriptionsChangedListener onSubscriptionsChangedListener) {
        if (context != null && onSubscriptionsChangedListener != null) {
            SubscriptionManager.from(context).addOnSubscriptionsChangedListener(onSubscriptionsChangedListener);
        } else {
            Log.d(LOG_TAG, "oplusAddOnSubscriptionsChangedListener fail ");
        }
    }

    public static void oplusPokeUserActivity(Context context) {
        InternalSdkDepends.getSInstance().oplusPokeUserActivity(context);
    }

    public static void oplusRemoveOnSubscriptionsChangedListener(Context context, SubscriptionManager.OnSubscriptionsChangedListener onSubscriptionsChangedListener) {
        if (context != null && onSubscriptionsChangedListener != null) {
            SubscriptionManager.from(context).removeOnSubscriptionsChangedListener(onSubscriptionsChangedListener);
        } else {
            Log.d(LOG_TAG, "oplusRemoveOnSubscriptionsChangedListener fail ");
        }
    }

    public static void putUserSwitchRoute(int i10) {
        if (com.android.incallui.mvvm.repository.dynamic.a.f18559a.B() != 128 && i10 != 128) {
            return;
        }
        AppSettingsUtils appSettingsUtils = AppSettingsUtils.INSTANCE;
        int globalGetInt = AppSettingsUtils.globalGetInt(OplusInCallApp.getAppContext(), USER_SWITCH_REOUTE, 0);
        if (i10 == 128) {
            if (globalGetInt < 10) {
                AppSettingsUtils.globalPutInt(OplusInCallApp.getAppContext(), USER_SWITCH_REOUTE, 10);
                return;
            } else {
                AppSettingsUtils.globalPutInt(OplusInCallApp.getAppContext(), USER_SWITCH_REOUTE, 0);
                return;
            }
        }
        if (globalGetInt < 10) {
            AppSettingsUtils.globalPutInt(OplusInCallApp.getAppContext(), USER_SWITCH_REOUTE, 11);
        } else {
            AppSettingsUtils.globalPutInt(OplusInCallApp.getAppContext(), USER_SWITCH_REOUTE, 1);
        }
    }

    public static long queryCallTimeByNumber(Context context, String str) {
        long j10 = 0;
        if (context == null) {
            Log.d(LOG_TAG, "queryCallLogTimeByNumber Context is null");
            return 0L;
        }
        Uri parse = Uri.parse("content://call_log/oppo_calls");
        if (TextUtils.isEmpty(str)) {
            str = DeviceState.INVALID_STATUS;
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(parse, C1731b.f38272d, new StringBuilder("number=?").toString(), new String[]{str}, "date DESC");
            if (cursor != null && cursor.moveToFirst()) {
                j10 = cursor.getLong(cursor.getColumnIndexOrThrow(BreenoCallContract.BaseColumns.DATE));
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "queryCallLogTimeByNumber callsDate = " + j10);
                }
            }
            return j10;
        } catch (SQLiteException e10) {
            Log.e(LOG_TAG, "Catch a SQLiteException when query: ", (Exception) e10);
            return j10;
        } catch (Exception e11) {
            Log.d(LOG_TAG, "Exception: " + e11);
            return j10;
        } finally {
            closeSafty(cursor);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0045, code lost:
    
        if (r2.moveToFirst() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005d, code lost:
    
        if (removeFdnNumberPrefix(r2.getString(r2.getColumnIndex("number"))).equals(removeFdnNumberPrefix(r11)) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0070, code lost:
    
        if (r2.moveToNext() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        r1 = r2.getString(r2.getColumnIndex("name"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0072, code lost:
    
        if (r2 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0074, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
    
        if (r2 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String queryFdnName(android.content.Context r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "OplusPhoneUtils"
            java.lang.String r1 = ""
            if (r10 == 0) goto L87
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 == 0) goto Le
            goto L87
        Le:
            java.lang.String r2 = " "
            java.lang.String r11 = r11.replaceAll(r2, r1)
            r2 = 0
            java.lang.String r3 = "content://icc/fdn"
            android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            if (r2 == 0) goto L72
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            r10.<init>()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            java.lang.String r3 = "query queryFdnName cur count:"
            r10.append(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            int r3 = r2.getCount()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            r10.append(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            com.android.incallui.Log.d(r0, r10)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            boolean r10 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            if (r10 == 0) goto L72
        L47:
            java.lang.String r10 = "number"
            int r10 = r2.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            java.lang.String r10 = r2.getString(r10)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            java.lang.String r10 = removeFdnNumberPrefix(r10)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            java.lang.String r3 = removeFdnNumberPrefix(r11)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            boolean r10 = r10.equals(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            if (r10 == 0) goto L6c
            java.lang.String r10 = "name"
            int r10 = r2.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            java.lang.String r1 = r2.getString(r10)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            goto L72
        L6a:
            r10 = move-exception
            goto L81
        L6c:
            boolean r10 = r2.moveToNext()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L78
            if (r10 != 0) goto L47
        L72:
            if (r2 == 0) goto L80
        L74:
            r2.close()
            goto L80
        L78:
            java.lang.String r10 = "Uri error!"
            com.android.incallui.Log.e(r0, r10)     // Catch: java.lang.Throwable -> L6a
            if (r2 == 0) goto L80
            goto L74
        L80:
            return r1
        L81:
            if (r2 == 0) goto L86
            r2.close()
        L86:
            throw r10
        L87:
            boolean r10 = com.android.incallui.Log.sDebug
            if (r10 == 0) goto L90
            java.lang.String r10 = "context or number is null, do nothing and return."
            com.android.incallui.Log.d(r0, r10)
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.OplusPhoneUtils.queryFdnName(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.android.incallui.OplusPhoneUtils$1] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static void queryNumberAttribution(String str, Context context) {
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "context is null, do nothing and return.");
                return;
            }
            return;
        }
        if (str == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "number is null, do nothing and return.");
                return;
            }
            return;
        }
        HashMap<String, NumberAttributionInfo> hashMap = mNumberAttributionCache;
        if (hashMap.get(str) != null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Cache has number = " + D2.g.l(str) + " attribution, return.");
                return;
            }
            return;
        }
        String replaceAll = str.replaceAll(" ", "");
        if (Log.sDebug) {
            Log.d(LOG_TAG, "query number attribution begin...");
        }
        ?? r22 = 0;
        r22 = 0;
        r22 = 0;
        try {
            try {
                Cursor query = context.getContentResolver().query(Uri.withAppendedPath(Uri.parse(ConfigurationConstants.getInquirenoareaAuthority()), replaceAll).buildUpon().appendQueryParameter("countryiso", InternalSdkDepends.getSInstance().getCurrentCountryIso(context)).appendQueryParameter("is_need_carrier_name", "true").build(), null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(query.getColumnIndex("cityname"));
                            String string2 = query.getString(query.getColumnIndex("areano"));
                            NumberAttributionInfo numberAttributionInfo = new NumberAttributionInfo();
                            numberAttributionInfo.mLocation = string;
                            numberAttributionInfo.mAreano = string2;
                            hashMap.put(replaceAll, numberAttributionInfo);
                            if (Log.sDebug) {
                                Log.d(LOG_TAG, "query number attribution end, number = " + D2.g.l(replaceAll) + " location = " + D2.g.o(string) + " areano = " + D2.g.o(string2));
                            }
                        }
                        query.close();
                    } catch (Exception unused) {
                        r22 = query;
                        Log.e(LOG_TAG, "URI error!");
                        if (r22 == 0) {
                            return;
                        }
                        r22.close();
                    } catch (Throwable th) {
                        th = th;
                        r22 = query;
                        if (r22 != 0) {
                            r22.close();
                        }
                        throw th;
                    }
                } else {
                    r22 = query;
                }
                if (r22 == 0) {
                    return;
                }
            } catch (Exception unused2) {
            }
            r22.close();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void refreshOplusVideoCallEnable(android.telecom.Call call) {
        refreshOplusVideoCallEnable(call == null ? null : call.getDetails().getAccountHandle());
    }

    public static String removeFdnNumberPrefix(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(PREFIX_MX_COUNTRY)) {
            return str.substring(3);
        }
        return str;
    }

    public static String removeNumberPrefix(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("+86")) {
            return str.substring(3);
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x008a, code lost:
    
        if (com.android.incallui.Call.State.isDisconnectingOrDisconnected(r5) == false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void sendBroadcastInCallActivityState(android.content.Context r9, boolean r10) {
        /*
            java.lang.String r0 = "OplusPhoneUtils"
            if (r9 != 0) goto Le
            boolean r9 = com.android.incallui.Log.sDebug
            if (r9 == 0) goto Ld
            java.lang.String r9 = "sendBroadcastInCallActivityState, context is null return!!!"
            com.android.incallui.Log.d(r0, r9)
        Ld:
            return
        Le:
            com.android.incallui.CallList r1 = com.android.incallui.CallList.getInstance()
            boolean r1 = r1.hasAnyLiveCall()
            if (r1 != 0) goto L22
            boolean r9 = com.android.incallui.Log.sDebug
            if (r9 == 0) goto L21
            java.lang.String r9 = "sendBroadcastInCallActivityState, hasAnyLiveCall is false!"
            com.android.incallui.Log.d(r0, r9)
        L21:
            return
        L22:
            com.android.incallui.InCallPresenter r1 = com.android.incallui.InCallPresenter.getInstance()
            com.android.incallui.OplusInCallPresenter r1 = (com.android.incallui.OplusInCallPresenter) r1
            t2.a r1 = r1.getFloatingWindowController()
            boolean r1 = r1.G()
            if (r1 == 0) goto L3e
            if (r10 != 0) goto L3e
            boolean r9 = com.android.incallui.Log.sDebug
            if (r9 == 0) goto L3d
            java.lang.String r9 = "floatingWindowIsShowing return !!!"
            com.android.incallui.Log.d(r0, r9)
        L3d:
            return
        L3e:
            com.android.incallui.CallList r1 = com.android.incallui.CallList.getInstance()
            com.android.incallui.Call r1 = getCallToShow(r1)
            r2 = 3
            r3 = -1
            if (r1 == 0) goto L5c
            int r5 = r1.getState()
            if (r5 != r2) goto L5c
            boolean r5 = r1.isCdmaDialing()
            if (r5 != 0) goto L5c
            long r5 = r1.getConnectTimeMillis()
            goto L5d
        L5c:
            r5 = r3
        L5d:
            r7 = 0
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 != 0) goto L64
            goto L65
        L64:
            r3 = r5
        L65:
            if (r1 == 0) goto L8f
            int r5 = r1.getState()
            boolean r6 = com.android.incallui.Call.State.isConnectingOrDialing(r5)
            if (r6 != 0) goto L8d
            boolean r6 = r1.isCdmaDialing()
            if (r6 == 0) goto L78
            goto L8d
        L78:
            boolean r6 = com.android.incallui.Call.State.isRing(r5)
            if (r6 == 0) goto L80
            r2 = 2
            goto L90
        L80:
            boolean r6 = com.android.incallui.Call.State.isActiveOrHold(r5)
            if (r6 != 0) goto L90
            boolean r5 = com.android.incallui.Call.State.isDisconnectingOrDisconnected(r5)
            if (r5 == 0) goto L8f
            goto L90
        L8d:
            r2 = 1
            goto L90
        L8f:
            r2 = 0
        L90:
            boolean r1 = com.android.incallui.CallUtils.isBidirectionalVideoCall(r1)
            boolean r5 = com.android.incallui.Log.sDebug
            if (r5 == 0) goto Lc4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "sendBroadcastInCallActivityState...>>"
            r5.append(r6)
            r5.append(r10)
            java.lang.String r6 = "  startTime time: "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r6 = "  video call: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = "  call state: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.android.incallui.Log.d(r0, r5)
        Lc4:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r5 = com.android.incallui.OplusPhoneUtils.ACTION_INCALLSCREEN_STATE
            r0.<init>(r5)
            java.lang.String r5 = "incall_screen_forground"
            r0.putExtra(r5, r10)
            java.lang.String r10 = "incall_screen_name_tag"
            java.lang.String r5 = "com.android.incallui.OplusInCallActivity"
            r0.putExtra(r10, r5)
            java.lang.String r10 = "call_start_time"
            r0.putExtra(r10, r3)
            java.lang.String r10 = "video_call"
            r0.putExtra(r10, r1)
            java.lang.String r10 = "call_state"
            r0.putExtra(r10, r2)
            java.lang.String r10 = "oplus.permission.OPLUS_COMPONENT_SAFE"
            r9.sendBroadcast(r0, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.OplusPhoneUtils.sendBroadcastInCallActivityState(android.content.Context, boolean):void");
    }

    public static void sendBroadcastInCallActivityStateIfBackground(Context context) {
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "sendBroadcastInCallActivityStateIfBackground, context is null return!!!");
                return;
            }
            return;
        }
        OplusInCallPresenter oplusInCallPresenter = (OplusInCallPresenter) InCallPresenter.getInstance();
        if (oplusInCallPresenter != null && oplusInCallPresenter.getActivity() != null && oplusInCallPresenter.getActivity().mIsForegroundActivity) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "sendBroadcastInCallActivityStateIfBackground, it's Foreground return!!!");
                return;
            }
            return;
        }
        sendBroadcastInCallActivityState(context, false);
    }

    public static void sendBroadcastIncomingCallStart(Context context) {
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "sendBroadcastIncomingCallStart, context is null return!!!");
            }
        } else {
            Intent intent = new Intent("com.oplus.aod.ACTION_INCOMMING_START");
            intent.setPackage("com.oplus.aod");
            context.sendBroadcast(intent);
        }
    }

    public static void sendBroadcastIncomingCallStop(Context context) {
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "sendBroadcastIncomingCallStop, context is null return!!!");
            }
        } else {
            Intent intent = new Intent("com.oplus.aod.ACTION_INCOMMING_STOP");
            intent.setPackage("com.oplus.aod");
            context.sendBroadcast(intent);
        }
    }

    public static void sendSecureData(Context context, String str, int i10) {
        ContentResolver contentResolver;
        ContentProviderClient contentProviderClient = null;
        try {
            try {
                contentResolver = context.getContentResolver();
            } catch (Exception e10) {
                Log.d(LOG_TAG, "Exception: " + e10.toString());
                if (0 == 0) {
                    return;
                }
            }
            if (contentResolver == null) {
                return;
            }
            contentProviderClient = contentResolver.acquireUnstableContentProviderClient(SAFE_AUTHORITY_URI);
            if (contentProviderClient == null) {
                if (contentProviderClient != null) {
                    contentProviderClient.close();
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(EXTRA_SECURE_TYPE, str);
                bundle.putInt(EXTRA_ADD_COUNT, i10);
                contentProviderClient.call(METHOD_SET_SECURE_ITEM, context.getPackageName(), bundle);
                contentProviderClient.close();
            }
        } catch (Throwable th) {
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            throw th;
        }
    }

    public static void setCardSize(int i10) {
        Log.i(LOG_TAG, "setCardSize = " + i10);
        sCardSize = i10;
    }

    public static void setDefaultDisplayResources(Resources resources) {
        if (resources == null) {
            return;
        }
        int defaultDisplayDensity = getDefaultDisplayDensity(0, OplusInCallApp.getAppContext());
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setDefaultDisplayResources defaultDisplayDensity = " + defaultDisplayDensity);
        }
        if (defaultDisplayDensity == -1) {
            return;
        }
        Configuration configuration = resources.getConfiguration();
        int i10 = configuration.densityDpi;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setDefaultDisplayResources origConfig.densityDpi = " + configuration.densityDpi);
        }
        configuration.densityDpi = defaultDisplayDensity;
        if (OplusFeatureOption.OPLUS_RESOLUTION_SWITCH) {
            int secureSettingsIntForSystemUser = InternalSdkDepends.getSInstance().getSecureSettingsIntForSystemUser(OplusInCallApp.getAppContext().getContentResolver(), RESOLUTION_SWITCH_VALUE, 1);
            Log.d(LOG_TAG, "setDefaultDisplayResources screenDensityId: " + secureSettingsIntForSystemUser);
            if (secureSettingsIntForSystemUser == 2) {
                configuration.densityDpi = RESOLUTION_DEFAULT_DISPLAY;
            }
        }
        int i11 = configuration.densityDpi;
        if (i11 != 0) {
            configuration.screenWidthDp = (i10 * configuration.screenWidthDp) / i11;
        }
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setDefaultDisplayResources origin displayMetrics: " + displayMetrics);
        }
        displayMetrics.densityDpi = defaultDisplayDensity;
        displayMetrics.density = defaultDisplayDensity / 160.0f;
        resources.updateConfiguration(configuration, displayMetrics);
        Log.d(LOG_TAG, "setDefaultDisplayResources displayMetrics " + displayMetrics);
    }

    public static Context setDefaultFontScaleAndDisplay(Context context) {
        if (context == null) {
            Log.d(LOG_TAG, "setDefaultFontScaleAndDisplay context = null");
            return context;
        }
        int defaultDisplayDensity = getDefaultDisplayDensity(0, context);
        Configuration configuration = context.getResources().getConfiguration();
        int i10 = configuration.densityDpi;
        if (defaultDisplayDensity == -1) {
            defaultDisplayDensity = 480;
        }
        configuration.densityDpi = defaultDisplayDensity;
        if (OplusFeatureOption.OPLUS_RESOLUTION_SWITCH) {
            int secureSettingsIntForSystemUser = InternalSdkDepends.getSInstance().getSecureSettingsIntForSystemUser(context.getContentResolver(), RESOLUTION_SWITCH_VALUE, 1);
            Log.d(LOG_TAG, "setDefaultFontScaleAndDisplay screenDensityId: " + secureSettingsIntForSystemUser);
            if (secureSettingsIntForSystemUser == 2) {
                configuration.densityDpi = RESOLUTION_DEFAULT_DISPLAY;
            }
        }
        int i11 = configuration.densityDpi;
        if (i11 != 0) {
            configuration.screenWidthDp = (i10 * configuration.screenWidthDp) / i11;
        }
        Log.d(LOG_TAG, "setDefaultFontScaleAndDisplay origConfig.densityDpi = " + configuration.densityDpi + "origConfig.fontScale = " + configuration.fontScale + "origConfig.screenWidthDp = " + configuration.screenWidthDp);
        return context.createConfigurationContext(configuration);
    }

    public static void setFontSize(Context context, TextView textView, int i10) {
        if (context == null) {
            Log.d(LOG_TAG, "context is null, return.");
        } else if (textView == null) {
            Log.d(LOG_TAG, "textView is null, return.");
        } else {
            textView.setTextSize(0, (int) COUIChangeTextUtil.getSuitableFontSize(textView.getTextSize(), context.getResources().getConfiguration().fontScale, i10));
        }
    }

    public static void setImsConferenceSize(int i10) {
        Log.i(LOG_TAG, "setImsConferenceSize = " + i10);
        sImsConferenceSize = i10;
    }

    public static void setIsHangUpConfernceCall(boolean z10) {
        Log.d(LOG_TAG, "setIsHangUpConfernceCall value = " + z10);
        sIsHangUpConfernceCall = z10;
    }

    public static void setIsLockScreenWhenFirstCallInComing(boolean z10) {
        sIsLockScreenWhenFirstCallInComing = z10;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setIsLockScreenWhenFirstCallInComing adfad= " + sIsLockScreenWhenFirstCallInComing);
        }
    }

    public static void setNeedMarkNumber(boolean z10, String str) {
        Log.d(LOG_TAG, "setNeedMarkNumber value = " + z10 + ", number = " + D2.g.l(str));
        sNeedMarkNumber = z10;
        sMarkNumber = str;
    }

    public static boolean setPrivacyValue(Context context, boolean z10) {
        if (context == null) {
            return false;
        }
        int globalGetInt = AppSettingsUtils.globalGetInt(context, NEED_PRIVACY_TOAST, 0);
        Log.d(LOG_TAG, "needToastValue" + globalGetInt);
        if (globalGetInt != 1) {
            return false;
        }
        int globalGetInt2 = AppSettingsUtils.globalGetInt(context, SHOW_PRIVACY_TOAST, 2);
        if (z10) {
            if (globalGetInt2 < 13) {
                AppSettingsUtils.globalPutInt(context, SHOW_PRIVACY_TOAST, 13);
            } else {
                AppSettingsUtils.globalPutInt(context, SHOW_PRIVACY_TOAST, 3);
            }
        } else if (globalGetInt2 < 12) {
            AppSettingsUtils.globalPutInt(context, SHOW_PRIVACY_TOAST, 12);
        } else {
            AppSettingsUtils.globalPutInt(context, SHOW_PRIVACY_TOAST, 2);
        }
        return true;
    }

    public static void setRakutenPrefixPreferenceValue(Context context, int i10) {
        if (context != null) {
            SettingsUtils.INSTANCE.putGlobalSettingsInt(context.getContentResolver(), RAKUTEN_PREFIX_PREFERENCE, i10);
            Log.d(LOG_TAG, "setRakutenPrefixPreferenceValue = " + i10);
        }
    }

    public static void setRecordSdcardSwitch(Context context, boolean z10) {
        if (context == null) {
            return;
        }
        Log.d(LOG_TAG, "setRecordSdcardSwitch = " + z10);
        SettingsUtils.INSTANCE.putSystemSettingsInt(context.getContentResolver(), KEY_RECORD_SD_STORAGE_SWITCH, z10 ? 1 : 0);
    }

    public static void setShowLockScreenAnswerView(boolean z10) {
        sShowLockScreenAnswerView = z10;
    }

    public static void setVideoPausedForConf(boolean z10) {
        Log.d(LOG_TAG, "setVideoPausedForConf:" + z10);
        sVideoPausedForConf = z10;
    }

    public static boolean shouldAddScreenOnFlag() {
        if (CallList.getInstance().getPendingOutgoingCall() == null && CallList.getInstance().getOutgoingCall() == null) {
            return false;
        }
        return true;
    }

    public static boolean shouldCheckRakutenPrefix(Context context, Uri uri, int i10, int i11) {
        Resources resources;
        if (context == null || uri == null) {
            return false;
        }
        if ((i10 != 0 && i10 != 1) || !OplusFeatureOption.OPLUS_PHONE_RAKUTEN_PREFIX) {
            return false;
        }
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return false;
        }
        String replaceAll = schemeSpecificPart.replaceAll(" ", "");
        if (!TextUtils.isEmpty(replaceAll)) {
            replaceAll = replaceAll.replaceAll("-", "");
        }
        if (TextUtils.isEmpty(replaceAll)) {
            return false;
        }
        String simOperatorGemini = AddOnSdkDepends.getSInstance().getSimOperatorGemini(context, i10, i11);
        if (TextUtils.isEmpty(simOperatorGemini)) {
            Log.d(LOG_TAG, "shouldCheckRakutenPrefix simPlmn is null, return false");
            return false;
        }
        if (simOperatorGemini.equals(RAKUTEN_MNO_SIM)) {
            Log.d(LOG_TAG, "shouldCheckRakutenPrefix simPlmn equals RAKUTEN_MNO_SIM, return false");
            return false;
        }
        if (replaceAll.startsWith(getRakutenPrefixString(context))) {
            return true;
        }
        if (JAPAN_WEATHER_NUMBER.equals(replaceAll) || (resources = context.getResources()) == null) {
            return false;
        }
        if (replaceAll.startsWith("0") && replaceAll.endsWith(JAPAN_WEATHER_NUMBER)) {
            HashSet hashSet = new HashSet(Arrays.asList(resources.getStringArray(R.array.japan_area_code)));
            int length = replaceAll.length() - 3;
            if (length > 1 && hashSet.contains(replaceAll.substring(1, length))) {
                return false;
            }
        }
        String[] stringArray = resources.getStringArray(R.array.rakuten_prefix_number);
        if (stringArray == null) {
            return false;
        }
        for (String str : stringArray) {
            if (replaceAll.startsWith(str)) {
                return false;
            }
        }
        String[] stringArray2 = resources.getStringArray(R.array.rakuten_special_number);
        if (stringArray2 == null) {
            return false;
        }
        for (String str2 : stringArray2) {
            if (str2.equals(replaceAll)) {
                return false;
            }
        }
        String[] stringArray3 = resources.getStringArray(R.array.rakuten_four_digits_number);
        if (stringArray3 == null) {
            return false;
        }
        for (String str3 : stringArray3) {
            if (str3.equals(replaceAll)) {
                return false;
            }
        }
        if (replaceAll.equals(D2.l.e(context))) {
            return false;
        }
        String networkOperatorGemini = AddOnSdkDepends.getSInstance().getNetworkOperatorGemini(context, i10, i11);
        Log.d(LOG_TAG, "shouldCheckRakutenPrefix networkPlmn = " + D2.g.o(networkOperatorGemini));
        if (TextUtils.isEmpty(networkOperatorGemini)) {
            return false;
        }
        String[] strArr = JAPAN_MCC;
        if (!networkOperatorGemini.startsWith(strArr[0]) && !networkOperatorGemini.startsWith(strArr[1])) {
            return false;
        }
        return true;
    }

    public static boolean shouldEnableHoldButton(Call call) {
        if (!OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK && call != null && call.getState() == 3) {
            if (call.getIsRemotelyHeld() && isDTACOperator(call.getSlotId(), call.getSubId())) {
                Log.d(LOG_TAG, "shouldEnableHoldButton return false");
                return false;
            }
            if (isKDDIConferenceCall(call)) {
                Log.d(LOG_TAG, "shouldEnableHoldButton return false for KDDI ConferenceCall");
                return false;
            }
        }
        return true;
    }

    public static boolean shouldReplaceHDIconToVoWifiIcon(int i10) {
        if (OplusFeatureOption.OPLUSOS_FEATURE_INCALLUI_DISPLAY_VOWIFI_ICON_ACTIVE.value().booleanValue() && Call.State.isActiveOrHold(i10)) {
            return true;
        }
        if (!OplusFeatureOption.OPLUSOS_FEATURE_INCALLUI_DISPLAY_VOWIFI_ICON_ACTIVE.value().booleanValue() && !Call.State.isRing(i10)) {
            return true;
        }
        return false;
    }

    public static boolean shouldShowDialogForJapan(Context context, Uri uri, int i10, int i11) {
        if (uri == null) {
            return false;
        }
        return shouldShowDialogForJapan(context, uri.getSchemeSpecificPart(), i10, i11);
    }

    public static boolean shouldShowPcRecordDialog(int i10) {
        if (i10 == 128) {
            return true;
        }
        return false;
    }

    public static boolean shouldShowRttUi(Context context) {
        if (context == null || !isRttSettingOn(context) || !isRttFeatureOn()) {
            return false;
        }
        return true;
    }

    public static boolean shouldShowVoiceTips(Context context) {
        boolean z10;
        if (context == null) {
            return false;
        }
        int secureSettingsInt = SettingsUtils.INSTANCE.getSecureSettingsInt(context.getContentResolver(), INCOMING_CALL_VOICE_CONTROL, -1);
        if (!OplusFeatureOption.OPLUS_VERSION_EXP && !OplusFeatureOption.OPLUS_PHONE_DISABLE_VOICECONTROL) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (Log.sOplusDebug) {
            Log.d(LOG_TAG, "OPLUS_PHONE_DISABLE_VOICECONTROL  = " + OplusFeatureOption.OPLUS_PHONE_DISABLE_VOICECONTROL + ", setting value = " + secureSettingsInt);
        }
        if (z10) {
            return false;
        }
        String locale = Locale.getDefault().toString();
        if (locale != null && !locale.equalsIgnoreCase("zh_CN") && !locale.equalsIgnoreCase("zh_TW")) {
            return false;
        }
        OplusCallList oplusCallList = CallList.getInstance().oplusCallList();
        if (oplusCallList != null && oplusCallList.oplusGetCallSize() > 1) {
            return false;
        }
        C1731b.l lVar = (C1731b.l) C1731b.d().e(1).d();
        if (!lVar.f38299h) {
            return false;
        }
        if (!lVar.f38292a && secureSettingsInt != 1) {
            return false;
        }
        return true;
    }

    public static void showNumberMarkView() {
        Context appContext = OplusInCallApp.getAppContext();
        InCallPresenter.getInstance().onDismissDialog();
        if (appContext.getResources().getConfiguration().orientation == 1) {
            try {
                if (getNeedMarkNumber(appContext) && isUserUnlocked(appContext) && isSystemUser(appContext) && !isScreenLocked(appContext) && !AddOnSdkDepends.getSInstance().getTopIsFullscreen() && ResponsiveConfigRepository.f18540a.E1()) {
                    new OplusNumberMarkController(appContext).showNumberMarkView();
                }
            } catch (Exception e10) {
                Log.w(LOG_TAG, "getTopIsFullscreen, throw excption = " + e10.getMessage());
            }
        }
        setIsHangUpConfernceCall(false);
    }

    public static void showRecordDialog(Context context, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (context == null) {
            Log.d(LOG_TAG, "showRecordDialog context is null");
            return;
        }
        if (OplusFeatureOption.FEATURE_RECORD_FOR_THIRD_PARTY) {
            Log.d(LOG_TAG, "showRecordDialog it's third record");
            return;
        }
        androidx.appcompat.app.b bVar = sRecordDialog;
        if (bVar != null) {
            bVar.dismiss();
            sRecordDialog = null;
        }
        Log.d(LOG_TAG, "showRecordDialog type = " + i10);
        switch (i10) {
            case 1:
                i11 = R.string.oplus_record_sd_full_to_internal_title;
                i12 = R.string.oplus_record_sd_full_invalid_to_internal_message;
                break;
            case 2:
                i11 = R.string.oplus_record_sd_invalid_to_internal_title;
                i12 = R.string.oplus_record_sd_full_invalid_to_internal_message;
                break;
            case 3:
                i11 = R.string.oplus_record_sd_to_internal_title;
                i12 = R.string.oplus_record_try_save_internal_msg;
                break;
            case 4:
                i11 = R.string.oplus_record_full_sd_to_full_internal_title;
                i12 = -1;
                break;
            case 5:
                i11 = R.string.oplus_record_sd_invalid_to_full_internal_title;
                i12 = -1;
                break;
            case 6:
                i11 = R.string.oplus_record_sd_invalid_to_internal_full_title;
                i12 = R.string.oplus_record_try_save_internal_msg;
                break;
            case 7:
                i11 = R.string.oplus_record_sd_to_internal_title;
                i12 = R.string.oplus_record_sd_full_to_full_internal_msg;
                break;
            case 8:
                i11 = R.string.oplus_record_sd_to_internal_title;
                i12 = R.string.oplus_record_full_sd_to_internal_full_msg;
                break;
            case 9:
                i11 = R.string.oplus_record_sd_full_to_internal_title;
                i12 = R.string.oplus_record_full_sd_to_internal_msg;
                break;
            case 10:
                i11 = R.string.oplus_mobile_storage_full;
                i12 = -1;
                break;
            case 11:
                i11 = R.string.oplus_mobile_storage_full;
                i12 = -1;
                break;
            default:
                i11 = -1;
                i12 = -1;
                break;
        }
        if (i11 == -1 && i12 == -1) {
            return;
        }
        if (OplusFeatureOption.VERSION_STORE) {
            if (ResponsiveConfigRepository.f18540a.a0().getValue().booleanValue()) {
                i14 = R.style.Theme_COUI_Main_Dark;
            } else {
                i14 = R.style.Theme_COUI_Main;
            }
            Context wrapColorContext = COUIAlertDialogBuilder.wrapColorContext(OplusInCallApp.getAppContext(), i14, R.style.COUIAlertDialog_Center);
            COUIThemeOverlay.getInstance().applyThemeOverlays(context);
            sRecordDialog = new COUIAlertDialogBuilder(wrapColorContext).setPositiveButton(R.string.oplus_know_ok, (DialogInterface.OnClickListener) null).setCancelable(false).create();
        } else {
            sRecordDialog = new COUIAlertDialogBuilder(context).setPositiveButton(R.string.oplus_know_ok, (DialogInterface.OnClickListener) null).setCancelable(false).create();
        }
        if (i11 != -1 && i12 != -1) {
            sRecordDialog.setTitle(i11);
            sRecordDialog.h(context.getResources().getString(i12));
        } else if (i11 != -1) {
            sRecordDialog.setTitle(i11);
        }
        Window window = sRecordDialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        A2.d.e(attributes);
        window.setAttributes(attributes);
        Window window2 = sRecordDialog.getWindow();
        if (OplusFeatureOption.VERSION_STORE) {
            i13 = 2038;
        } else {
            i13 = 2008;
        }
        window2.setType(i13);
        sRecordDialog.getWindow().addFlags(2);
        sRecordDialog.setCanceledOnTouchOutside(false);
        sRecordDialog.show();
        HashMap hashMap = new HashMap();
        hashMap.put("callrecord_sdcard_abnormalpopup", String.valueOf(i10));
        OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_AUTO_RECORD, OplusPhoneUserActionStatistics.CALL_RECORD_SDCARD_POPUP, hashMap);
    }

    public static boolean showSingleReplaceOfConference(Context context, Call call) {
        if (!OplusFeatureOption.OPLUS_VERSION_EXP) {
            return false;
        }
        if (context != null && call != null && call.isConferenceCall() && !call.isVideoCall()) {
            if (call.getChildCallIds().size() == 1) {
                if (OplusFeatureOption.FEATURE_SHOW_SINGLE_REPLACE_OF_CONFERENCE.a(call.getSlotId()).booleanValue()) {
                    Log.d(LOG_TAG, "showSingleReplaceOfConference return true 01");
                    return true;
                }
            }
            return false;
        }
        Log.d(LOG_TAG, "showSingleReplaceOfConference return false 00");
        return false;
    }

    public static void silenceRinger(Context context) {
        if (context == null) {
            return;
        }
        TelecomManager telecomManager = getTelecomManager(context);
        if (telecomManager != null) {
            telecomManager.silenceRinger();
        }
        stopRingForSpeechAssistant(context);
    }

    public static void startOplusInCallDialogActivity(Context context, int i10) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) OplusInCallDialogActivity.class);
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.putExtra("dialog_id", i10);
        context.startActivity(intent);
    }

    public static void startSafeActivity(Context context, Intent intent) {
        if (context == null) {
            Log.d(LOG_TAG, "startSafeActivity error: context is null, return.");
            return;
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            Log.d(LOG_TAG, "startSafeActivity activityNotFound = " + e10.getMessage());
        } catch (Exception e11) {
            Log.d(LOG_TAG, "startSafeActivity exception  = " + e11.getMessage());
        }
    }

    public static void stopRingForSpeechAssistant(Context context) {
        log("notify oplus speech assistant to silence ringer");
        if (context == null) {
            return;
        }
        context.sendBroadcast(new Intent("SILENCE_ACTION_FOR_OPLUS_SPEECH"), PERMISSION_OPLUS_COMPONENT_SAFE);
    }

    public static void updateFloatingWindowStateSecureValues(Context context, boolean z10) {
        Log.d(LOG_TAG, "updateFloatingWindowStateSecureValues = " + z10);
        if (context == null) {
            return;
        }
        SettingsUtils.INSTANCE.putSecureSettingsInt(context.getContentResolver(), OPLUS_INCALLUI_FLOATING_WINDOW_STATE, z10 ? 1 : 0);
    }

    public static void updateIsInEmergencyCallValue() {
        C2.b.a().execute(new Runnable() { // from class: com.android.incallui.Y
            @Override // java.lang.Runnable
            public final void run() {
                OplusPhoneUtils.lambda$updateIsInEmergencyCallValue$0();
            }
        });
    }

    public static boolean isEmergencyNumber(String str, Call call) {
        boolean isEmergencyNumber;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (sEmergencyNumCache.containsKey(str)) {
            isEmergencyNumber = sEmergencyNumCache.get(str).booleanValue();
            if (Log.sDebug) {
                Log.d(LOG_TAG, "isEmergencyNumber from cache " + isEmergencyNumber);
            }
        } else {
            if (call == null) {
                call = CallList.getInstance().getFirstCall();
            }
            if (call != null && call.getSubId() != -1) {
                boolean isEmergencyNumber2 = InternalSdkDepends.getSInstance().isEmergencyNumber(OplusInCallApp.getAppContext(), call.getSubId(), str);
                sEmergencyNumCache.put(str, isEmergencyNumber2 ? Boolean.TRUE : Boolean.FALSE);
                isEmergencyNumber = isEmergencyNumber2;
            } else {
                isEmergencyNumber = InternalSdkDepends.getSInstance().isEmergencyNumber(OplusInCallApp.getAppContext(), str);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("isEmergencyNumber ");
            sb.append(isEmergencyNumber);
            sb.append(", call is null: ");
            sb.append(call == null);
            Log.d(LOG_TAG, sb.toString());
        }
        return isEmergencyNumber;
    }

    public static void refreshOplusVideoCallEnable(PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle == null) {
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "refreshVideoCallEnable begin");
        }
        int c10 = A2.d.c(phoneAccountHandle);
        int d10 = A2.d.d(phoneAccountHandle);
        sOplusVolteVideoCallEnable = InternalSdkDepends.getSInstance().getOplusVolteVideoCallEnable(OplusInCallApp.getAppContext(), c10, d10, sOplusVolteVideoCallEnable);
        sOplusVowifiVideoCallEnable = InternalSdkDepends.getSInstance().getOplusVowifiVideoCallEnable(OplusInCallApp.getAppContext(), c10, d10, sOplusVolteVideoCallEnable);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "refreshVideoCallEnable volteVideoCallEnable = " + sOplusVolteVideoCallEnable + " vowifiVideoCallEnable = " + sOplusVowifiVideoCallEnable);
        }
    }

    public static boolean shouldShowDialogForJapan(Context context, String str, int i10, int i11) {
        if (context == null || TextUtils.isEmpty(str) || str.startsWith(SPECIAL_PLUS_CODE_PREFIX) || str.startsWith("00") || !OplusFeatureOption.FEATURE_ROAM_CALL_SHOW_DIALOG) {
            return false;
        }
        String telephonyProperty = InternalSdkDepends.getSInstance().getTelephonyProperty(context, i10, PROPERTY_ICC_OPERATOR_NUMERIC, "");
        boolean isNetworkRoamingGemini = AddOnSdkDepends.getSInstance().isNetworkRoamingGemini(context, i10, i11);
        Log.d(LOG_TAG, "shouldShowDialogForJapan isNetworkRoaming = " + isNetworkRoamingGemini + " simNumeric = " + D2.g.o(telephonyProperty));
        if (isNetworkRoamingGemini && !TextUtils.isEmpty(telephonyProperty) && (telephonyProperty.startsWith("440") || telephonyProperty.startsWith("441"))) {
            Log.d(LOG_TAG, "shouldShowDialogForJapan is true!");
            return true;
        }
        return false;
    }

    public static boolean isNotShowHDIcon(int i10, int i11) {
        boolean isImsRegistered = isImsRegistered(i10);
        boolean z10 = !isImsRegistered && isNotShowHDIconForOperator(i10, i11);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "result = " + z10 + ", isImsRegistered = " + isImsRegistered);
        }
        return z10;
    }

    private static boolean isImsRegistered(int i10) {
        String stringSystemProperties = InternalSdkDepends.getSInstance().getStringSystemProperties(PRO_IMS_TYPE + i10, "");
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isImsRegistered imsType = " + stringSystemProperties);
        }
        return IMS_VOLTE_ENABLE.equals(stringSystemProperties) || IMS_VOWIFI_ENABLE.equals(stringSystemProperties);
    }
}
