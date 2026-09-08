package com.android.incallui;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.android.incallui.OplusFeatureOption;
import java.util.HashMap;
import java.util.Map;
import z8.InterfaceC1764a;
import z8.InterfaceC1765b;

/* loaded from: classes.dex */
public class OplusFeatureOption {
    public static InterfaceC1765b<Boolean> FEATURE_CLEAR_CODE_CLARO;
    public static boolean FEATURE_CMCC_MOBILE_VIDEO;
    public static boolean FEATURE_DISABLE_ADD_CALL_BUTTON;
    public static boolean FEATURE_DISPLAY_SINGLE_PARTY_CONFERENCE_CALL;
    public static boolean FEATURE_DRIVE_MODE;
    public static boolean FEATURE_ENABLE_RTT_UI;
    public static boolean FEATURE_FOLD;
    public static boolean FEATURE_FOLD_REMAP_DISPLAY_DISABLED;
    public static boolean FEATURE_HIDE_CALL_HARASS_INTERCEPT;
    public static InterfaceC1764a<Boolean> FEATURE_HIDE_VIDEO_CALL;
    public static boolean FEATURE_INCOMMING_RINGTONE_PRIORITY_SETTING;
    public static InterfaceC1764a<Boolean> FEATURE_NUMBER_RECOGNITION;
    public static boolean FEATURE_PLAY_BUSY_TONE;
    public static boolean FEATURE_PMS_APP_FROZEN;
    public static boolean FEATURE_RECORD_FOR_THIRD_PARTY;
    public static boolean FEATURE_ROAM_CALL_SHOW_DIALOG;
    public static boolean FEATURE_SEND_CALL_RECORD_PATH;
    public static boolean FEATURE_SHOW_CNAPNAME;
    public static InterfaceC1765b<Boolean> FEATURE_SHOW_SINGLE_REPLACE_OF_CONFERENCE;
    public static InterfaceC1764a<Boolean> FEATURE_SHOW_TRANSFER_BUTTON;
    public static boolean FEATURE_SOFTWARE_SUPPORT_SECONDARY_MINI_APP;
    public static boolean FEATURE_SUPPORT_HOLD_VILTE_CALL;
    public static boolean FEATURE_VIDEO_RINGTONE_FULL_SCREEN;
    public static boolean HIDE_MERGE_BUTTON_SUPPORT;
    public static boolean IS_ASSURANCE_MODE;
    public static boolean IS_METRO_MODE;
    public static boolean IS_SUPPOR_ECHOLOCATE;
    public static boolean IS_USS_MODE;
    public static boolean IS_UST_MODE;
    public static boolean IS_WCG_DISPLAY_SUPPORTED;
    public static InterfaceC1764a<Boolean> OPLUSOS_FEATURE_INCALLUI_DISPLAY_VOWIFI_ICON_ACTIVE;
    public static boolean OPLUSOS_FEATURE_INCALLUI_SHOW_PRIVATE_NUMBER;
    public static boolean OPLUS_CMCC_TEST;
    public static boolean OPLUS_CTA_SUPPORT;
    public static boolean OPLUS_CT_OPTR;
    public static boolean OPLUS_EYESIGHT_CAMERA_GESTURE_SUPPORT;
    public static InterfaceC1764a<Boolean> OPLUS_FEATURE_DSDA_HOLD_NOT_SUPPORT;
    public static boolean OPLUS_FEATURE_INCALLUI_NO_DISPLAY_RECORD;
    public static boolean OPLUS_HARDWARE_MOTOR_SUPPORT;
    public static boolean OPLUS_HW_MANUFACTURER_MTK;
    public static boolean OPLUS_HW_MANUFACTURER_QUALCOMM;
    public static boolean OPLUS_INFRARED_GESTURE_SUPPORT;
    public static boolean OPLUS_PHONE_ADD_HARASS_INTERCEPT_TYPE;
    public static boolean OPLUS_PHONE_AT_COMMAND;
    public static boolean OPLUS_PHONE_DISABLE_VOICECONTROL;
    public static boolean OPLUS_PHONE_DISPLAY_CALLER_ID_NAME;
    public static boolean OPLUS_PHONE_DISPLAY_FDN_CALL;
    public static boolean OPLUS_PHONE_DISPLAY_VOLTE_VOWIFI;
    public static boolean OPLUS_PHONE_END_CALL_OUT_OF_SERVICE;
    public static boolean OPLUS_PHONE_HARASS_INTERCEPT_OFF;
    public static boolean OPLUS_PHONE_HIDE_CONFERENCE_MANAGE_BUTTON_AFTER_SRVCC;
    public static boolean OPLUS_PHONE_HIDE_HD_ICON;
    public static boolean OPLUS_PHONE_HIDE_INTERCEPT_CALL_NOTIFICATION;
    public static boolean OPLUS_PHONE_RAKUTEN_PREFIX;
    public static boolean OPLUS_PHONE_REMOVE_OPLUS_MMS;
    public static boolean OPLUS_PHONE_SCREEN_HETEROMORPHISM;
    public static boolean OPLUS_PHONE_SHOW_CNAPNAME_WHEN_IS_NUMBER;
    public static boolean OPLUS_PHONE_SHOW_HD_NOTIFICATION;
    public static boolean OPLUS_PHONE_SUPPORT_RIDE_MODE_SECRET;
    public static boolean OPLUS_PHONE_TELSTRA_DEFAULT_VM;
    public static boolean OPLUS_PHONE_VILTE_AUTO_TEST;
    public static boolean OPLUS_PHONE_VILTE_DATD_BITRATE;
    public static boolean OPLUS_PHONE_VILTE_NOT_FULLSCREEN;
    public static boolean OPLUS_RESOLUTION_SWITCH;
    public static boolean OPLUS_VERSION_EXP;
    public static boolean VERSION_STORE;

    /* loaded from: classes.dex */
    public final class AutoInject {
        private static final String TAG = "OplusFeatureOption";
        private static boolean sLoggable;
        private static final boolean sVersionOverR = true;

        public static final void autoInject(Context context) {
            autoInject(context, false);
        }

        public static Map<String, Object> dumpToMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("HIDE_MERGE_BUTTON_SUPPORT", Boolean.valueOf(OplusFeatureOption.HIDE_MERGE_BUTTON_SUPPORT));
            hashMap.put("FEATURE_SOFTWARE_SUPPORT_SECONDARY_MINI_APP", Boolean.valueOf(OplusFeatureOption.FEATURE_SOFTWARE_SUPPORT_SECONDARY_MINI_APP));
            hashMap.put("FEATURE_ENABLE_RTT_UI", Boolean.valueOf(OplusFeatureOption.FEATURE_ENABLE_RTT_UI));
            hashMap.put("FEATURE_INCOMMING_RINGTONE_PRIORITY_SETTING", Boolean.valueOf(OplusFeatureOption.FEATURE_INCOMMING_RINGTONE_PRIORITY_SETTING));
            hashMap.put("VERSION_STORE", Boolean.valueOf(OplusFeatureOption.VERSION_STORE));
            hashMap.put("OPLUS_VERSION_EXP", Boolean.valueOf(OplusFeatureOption.OPLUS_VERSION_EXP));
            hashMap.put("FEATURE_SEND_CALL_RECORD_PATH", Boolean.valueOf(OplusFeatureOption.FEATURE_SEND_CALL_RECORD_PATH));
            hashMap.put("FEATURE_HIDE_VIDEO_CALL", OplusFeatureOption.FEATURE_HIDE_VIDEO_CALL.value());
            hashMap.put("OPLUS_FEATURE_INCALLUI_NO_DISPLAY_RECORD", Boolean.valueOf(OplusFeatureOption.OPLUS_FEATURE_INCALLUI_NO_DISPLAY_RECORD));
            hashMap.put("IS_ASSURANCE_MODE", Boolean.valueOf(OplusFeatureOption.IS_ASSURANCE_MODE));
            hashMap.put("FEATURE_PMS_APP_FROZEN", Boolean.valueOf(OplusFeatureOption.FEATURE_PMS_APP_FROZEN));
            hashMap.put("OPLUS_PHONE_RAKUTEN_PREFIX", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_RAKUTEN_PREFIX));
            hashMap.put("OPLUSOS_FEATURE_INCALLUI_DISPLAY_VOWIFI_ICON_ACTIVE", OplusFeatureOption.OPLUSOS_FEATURE_INCALLUI_DISPLAY_VOWIFI_ICON_ACTIVE.value());
            hashMap.put("FEATURE_RECORD_FOR_THIRD_PARTY", Boolean.valueOf(OplusFeatureOption.FEATURE_RECORD_FOR_THIRD_PARTY));
            hashMap.put("OPLUS_PHONE_ADD_HARASS_INTERCEPT_TYPE", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_ADD_HARASS_INTERCEPT_TYPE));
            hashMap.put("FEATURE_DISPLAY_SINGLE_PARTY_CONFERENCE_CALL", Boolean.valueOf(OplusFeatureOption.FEATURE_DISPLAY_SINGLE_PARTY_CONFERENCE_CALL));
            hashMap.put("FEATURE_CLEAR_CODE_CLARO", OplusFeatureOption.FEATURE_CLEAR_CODE_CLARO);
            hashMap.put("IS_WCG_DISPLAY_SUPPORTED", Boolean.valueOf(OplusFeatureOption.IS_WCG_DISPLAY_SUPPORTED));
            hashMap.put("OPLUS_PHONE_END_CALL_OUT_OF_SERVICE", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_END_CALL_OUT_OF_SERVICE));
            hashMap.put("OPLUS_INFRARED_GESTURE_SUPPORT", Boolean.valueOf(OplusFeatureOption.OPLUS_INFRARED_GESTURE_SUPPORT));
            hashMap.put("FEATURE_FOLD", Boolean.valueOf(OplusFeatureOption.FEATURE_FOLD));
            hashMap.put("OPLUS_CT_OPTR", Boolean.valueOf(OplusFeatureOption.OPLUS_CT_OPTR));
            hashMap.put("OPLUS_HARDWARE_MOTOR_SUPPORT", Boolean.valueOf(OplusFeatureOption.OPLUS_HARDWARE_MOTOR_SUPPORT));
            hashMap.put("FEATURE_SHOW_SINGLE_REPLACE_OF_CONFERENCE", OplusFeatureOption.FEATURE_SHOW_SINGLE_REPLACE_OF_CONFERENCE);
            hashMap.put("FEATURE_CMCC_MOBILE_VIDEO", Boolean.valueOf(OplusFeatureOption.FEATURE_CMCC_MOBILE_VIDEO));
            hashMap.put("OPLUS_PHONE_DISPLAY_VOLTE_VOWIFI", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_DISPLAY_VOLTE_VOWIFI));
            hashMap.put("FEATURE_VIDEO_RINGTONE_FULL_SCREEN", Boolean.valueOf(OplusFeatureOption.FEATURE_VIDEO_RINGTONE_FULL_SCREEN));
            hashMap.put("FEATURE_SHOW_TRANSFER_BUTTON", OplusFeatureOption.FEATURE_SHOW_TRANSFER_BUTTON.value());
            hashMap.put("FEATURE_DISABLE_ADD_CALL_BUTTON", Boolean.valueOf(OplusFeatureOption.FEATURE_DISABLE_ADD_CALL_BUTTON));
            hashMap.put("OPLUS_PHONE_VILTE_AUTO_TEST", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_VILTE_AUTO_TEST));
            hashMap.put("OPLUSOS_FEATURE_INCALLUI_SHOW_PRIVATE_NUMBER", Boolean.valueOf(OplusFeatureOption.OPLUSOS_FEATURE_INCALLUI_SHOW_PRIVATE_NUMBER));
            hashMap.put("FEATURE_SHOW_CNAPNAME", Boolean.valueOf(OplusFeatureOption.FEATURE_SHOW_CNAPNAME));
            hashMap.put("OPLUS_PHONE_SHOW_CNAPNAME_WHEN_IS_NUMBER", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_SHOW_CNAPNAME_WHEN_IS_NUMBER));
            hashMap.put("OPLUS_PHONE_DISPLAY_CALLER_ID_NAME", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_DISPLAY_CALLER_ID_NAME));
            hashMap.put("OPLUS_PHONE_DISPLAY_FDN_CALL", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_DISPLAY_FDN_CALL));
            hashMap.put("OPLUS_PHONE_SHOW_HD_NOTIFICATION", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_SHOW_HD_NOTIFICATION));
            hashMap.put("FEATURE_HIDE_CALL_HARASS_INTERCEPT", Boolean.valueOf(OplusFeatureOption.FEATURE_HIDE_CALL_HARASS_INTERCEPT));
            hashMap.put("FEATURE_FOLD_REMAP_DISPLAY_DISABLED", Boolean.valueOf(OplusFeatureOption.FEATURE_FOLD_REMAP_DISPLAY_DISABLED));
            hashMap.put("OPLUS_PHONE_TELSTRA_DEFAULT_VM", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_TELSTRA_DEFAULT_VM));
            hashMap.put("FEATURE_ROAM_CALL_SHOW_DIALOG", Boolean.valueOf(OplusFeatureOption.FEATURE_ROAM_CALL_SHOW_DIALOG));
            hashMap.put("IS_SUPPOR_ECHOLOCATE", Boolean.valueOf(OplusFeatureOption.IS_SUPPOR_ECHOLOCATE));
            hashMap.put("OPLUS_PHONE_DISABLE_VOICECONTROL", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_DISABLE_VOICECONTROL));
            hashMap.put("FEATURE_DRIVE_MODE", Boolean.valueOf(OplusFeatureOption.FEATURE_DRIVE_MODE));
            hashMap.put("OPLUS_PHONE_SUPPORT_RIDE_MODE_SECRET", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_SUPPORT_RIDE_MODE_SECRET));
            hashMap.put("IS_UST_MODE", Boolean.valueOf(OplusFeatureOption.IS_UST_MODE));
            hashMap.put("OPLUS_PHONE_AT_COMMAND", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_AT_COMMAND));
            hashMap.put("OPLUS_PHONE_REMOVE_OPLUS_MMS", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_REMOVE_OPLUS_MMS));
            hashMap.put("FEATURE_NUMBER_RECOGNITION", OplusFeatureOption.FEATURE_NUMBER_RECOGNITION.value());
            hashMap.put("OPLUS_HW_MANUFACTURER_MTK", Boolean.valueOf(OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK));
            hashMap.put("OPLUS_RESOLUTION_SWITCH", Boolean.valueOf(OplusFeatureOption.OPLUS_RESOLUTION_SWITCH));
            hashMap.put("OPLUS_FEATURE_DSDA_HOLD_NOT_SUPPORT", OplusFeatureOption.OPLUS_FEATURE_DSDA_HOLD_NOT_SUPPORT.value());
            hashMap.put("FEATURE_SUPPORT_HOLD_VILTE_CALL", Boolean.valueOf(OplusFeatureOption.FEATURE_SUPPORT_HOLD_VILTE_CALL));
            hashMap.put("OPLUS_CTA_SUPPORT", Boolean.valueOf(OplusFeatureOption.OPLUS_CTA_SUPPORT));
            hashMap.put("OPLUS_PHONE_HIDE_HD_ICON", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_HIDE_HD_ICON));
            hashMap.put("OPLUS_PHONE_VILTE_DATD_BITRATE", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_VILTE_DATD_BITRATE));
            hashMap.put("OPLUS_HW_MANUFACTURER_QUALCOMM", Boolean.valueOf(OplusFeatureOption.OPLUS_HW_MANUFACTURER_QUALCOMM));
            hashMap.put("OPLUS_PHONE_VILTE_NOT_FULLSCREEN", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN));
            hashMap.put("OPLUS_PHONE_HIDE_INTERCEPT_CALL_NOTIFICATION", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_HIDE_INTERCEPT_CALL_NOTIFICATION));
            hashMap.put("IS_METRO_MODE", Boolean.valueOf(OplusFeatureOption.IS_METRO_MODE));
            hashMap.put("IS_USS_MODE", Boolean.valueOf(OplusFeatureOption.IS_USS_MODE));
            hashMap.put("FEATURE_PLAY_BUSY_TONE", Boolean.valueOf(OplusFeatureOption.FEATURE_PLAY_BUSY_TONE));
            hashMap.put("OPLUS_PHONE_HARASS_INTERCEPT_OFF", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_HARASS_INTERCEPT_OFF));
            hashMap.put("OPLUS_EYESIGHT_CAMERA_GESTURE_SUPPORT", Boolean.valueOf(OplusFeatureOption.OPLUS_EYESIGHT_CAMERA_GESTURE_SUPPORT));
            hashMap.put("OPLUS_PHONE_SCREEN_HETEROMORPHISM", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_SCREEN_HETEROMORPHISM));
            hashMap.put("OPLUS_CMCC_TEST", Boolean.valueOf(OplusFeatureOption.OPLUS_CMCC_TEST));
            hashMap.put("OPLUS_PHONE_HIDE_CONFERENCE_MANAGE_BUTTON_AFTER_SRVCC", Boolean.valueOf(OplusFeatureOption.OPLUS_PHONE_HIDE_CONFERENCE_MANAGE_BUTTON_AFTER_SRVCC));
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean lambda$autoInject$3(int i10) {
            return Boolean.FALSE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean lambda$autoInject$5(int i10) {
            return Boolean.FALSE;
        }

        private static final void print(String str) {
            print(str, false);
        }

        public static final void autoInject(Context context, boolean z10) {
            sLoggable = z10;
            print("AutoInject Feature Value begin");
            PackageManager packageManager = context.getPackageManager();
            context.getContentResolver();
            OplusFeatureOption.OPLUS_CTA_SUPPORT = false;
            OplusFeatureOption.OPLUSOS_FEATURE_INCALLUI_SHOW_PRIVATE_NUMBER = false;
            OplusFeatureOption.OPLUS_FEATURE_INCALLUI_NO_DISPLAY_RECORD = false;
            OplusFeatureOption.FEATURE_PLAY_BUSY_TONE = false;
            OplusFeatureOption.OPLUSOS_FEATURE_INCALLUI_DISPLAY_VOWIFI_ICON_ACTIVE = new InterfaceC1764a() { // from class: com.android.incallui.D
                @Override // z8.InterfaceC1764a
                public final Object value() {
                    Boolean bool;
                    bool = Boolean.TRUE;
                    return bool;
                }
            };
            OplusFeatureOption.OPLUS_INFRARED_GESTURE_SUPPORT = false;
            OplusFeatureOption.OPLUS_EYESIGHT_CAMERA_GESTURE_SUPPORT = false;
            OplusFeatureOption.OPLUS_CMCC_TEST = false;
            OplusFeatureOption.OPLUS_CT_OPTR = false;
            OplusFeatureOption.OPLUS_VERSION_EXP = true;
            OplusFeatureOption.OPLUS_PHONE_AT_COMMAND = false;
            OplusFeatureOption.OPLUS_PHONE_TELSTRA_DEFAULT_VM = false;
            OplusFeatureOption.OPLUS_PHONE_VILTE_DATD_BITRATE = false;
            OplusFeatureOption.OPLUS_PHONE_VILTE_AUTO_TEST = false;
            OplusFeatureOption.OPLUS_PHONE_SCREEN_HETEROMORPHISM = true;
            OplusFeatureOption.OPLUS_HARDWARE_MOTOR_SUPPORT = false;
            OplusFeatureOption.OPLUS_PHONE_DISPLAY_VOLTE_VOWIFI = false;
            OplusFeatureOption.OPLUS_PHONE_DISPLAY_FDN_CALL = false;
            OplusFeatureOption.OPLUS_PHONE_DISABLE_VOICECONTROL = true;
            OplusFeatureOption.OPLUS_PHONE_SUPPORT_RIDE_MODE_SECRET = false;
            OplusFeatureOption.OPLUS_PHONE_RAKUTEN_PREFIX = false;
            OplusFeatureOption.FEATURE_SUPPORT_HOLD_VILTE_CALL = false;
            OplusFeatureOption.OPLUS_RESOLUTION_SWITCH = false;
            OplusFeatureOption.FEATURE_VIDEO_RINGTONE_FULL_SCREEN = false;
            OplusFeatureOption.OPLUS_PHONE_REMOVE_OPLUS_MMS = false;
            OplusFeatureOption.OPLUS_PHONE_SHOW_HD_NOTIFICATION = false;
            OplusFeatureOption.OPLUS_PHONE_HIDE_CONFERENCE_MANAGE_BUTTON_AFTER_SRVCC = false;
            OplusFeatureOption.OPLUS_PHONE_HIDE_HD_ICON = false;
            OplusFeatureOption.FEATURE_DISPLAY_SINGLE_PARTY_CONFERENCE_CALL = false;
            OplusFeatureOption.OPLUS_PHONE_DISPLAY_CALLER_ID_NAME = false;
            OplusFeatureOption.OPLUS_PHONE_HIDE_INTERCEPT_CALL_NOTIFICATION = false;
            OplusFeatureOption.OPLUS_PHONE_ADD_HARASS_INTERCEPT_TYPE = false;
            OplusFeatureOption.OPLUS_PHONE_END_CALL_OUT_OF_SERVICE = false;
            OplusFeatureOption.OPLUS_PHONE_SHOW_CNAPNAME_WHEN_IS_NUMBER = false;
            OplusFeatureOption.FEATURE_SHOW_TRANSFER_BUTTON = new InterfaceC1764a() { // from class: com.android.incallui.E
                @Override // z8.InterfaceC1764a
                public final Object value() {
                    Boolean bool;
                    bool = Boolean.FALSE;
                    return bool;
                }
            };
            OplusFeatureOption.FEATURE_HIDE_CALL_HARASS_INTERCEPT = false;
            OplusFeatureOption.FEATURE_ROAM_CALL_SHOW_DIALOG = false;
            OplusFeatureOption.FEATURE_NUMBER_RECOGNITION = new InterfaceC1764a() { // from class: com.android.incallui.F
                @Override // z8.InterfaceC1764a
                public final Object value() {
                    Boolean bool;
                    bool = Boolean.FALSE;
                    return bool;
                }
            };
            OplusFeatureOption.FEATURE_DISABLE_ADD_CALL_BUTTON = false;
            OplusFeatureOption.FEATURE_RECORD_FOR_THIRD_PARTY = false;
            OplusFeatureOption.FEATURE_CLEAR_CODE_CLARO = new InterfaceC1765b() { // from class: com.android.incallui.G
                @Override // z8.InterfaceC1765b
                public final Object a(int i10) {
                    Boolean lambda$autoInject$3;
                    lambda$autoInject$3 = OplusFeatureOption.AutoInject.lambda$autoInject$3(i10);
                    return lambda$autoInject$3;
                }
            };
            OplusFeatureOption.FEATURE_CMCC_MOBILE_VIDEO = false;
            OplusFeatureOption.FEATURE_SHOW_CNAPNAME = false;
            OplusFeatureOption.FEATURE_SEND_CALL_RECORD_PATH = false;
            OplusFeatureOption.FEATURE_HIDE_VIDEO_CALL = new InterfaceC1764a() { // from class: com.android.incallui.H
                @Override // z8.InterfaceC1764a
                public final Object value() {
                    Boolean bool;
                    bool = Boolean.FALSE;
                    return bool;
                }
            };
            OplusFeatureOption.FEATURE_ENABLE_RTT_UI = false;
            OplusFeatureOption.FEATURE_INCOMMING_RINGTONE_PRIORITY_SETTING = false;
            OplusFeatureOption.FEATURE_PMS_APP_FROZEN = false;
            OplusFeatureOption.IS_SUPPOR_ECHOLOCATE = false;
            OplusFeatureOption.FEATURE_DRIVE_MODE = false;
            OplusFeatureOption.IS_UST_MODE = false;
            OplusFeatureOption.IS_METRO_MODE = false;
            OplusFeatureOption.IS_ASSURANCE_MODE = false;
            OplusFeatureOption.IS_USS_MODE = false;
            OplusFeatureOption.FEATURE_SHOW_SINGLE_REPLACE_OF_CONFERENCE = new InterfaceC1765b() { // from class: com.android.incallui.I
                @Override // z8.InterfaceC1765b
                public final Object a(int i10) {
                    Boolean lambda$autoInject$5;
                    lambda$autoInject$5 = OplusFeatureOption.AutoInject.lambda$autoInject$5(i10);
                    return lambda$autoInject$5;
                }
            };
            OplusFeatureOption.FEATURE_FOLD = false;
            OplusFeatureOption.FEATURE_FOLD_REMAP_DISPLAY_DISABLED = false;
            OplusFeatureOption.IS_WCG_DISPLAY_SUPPORTED = packageManager.hasSystemFeature("oplus.software.display.wcg_2.0_support");
            OplusFeatureOption.HIDE_MERGE_BUTTON_SUPPORT = false;
            OplusFeatureOption.OPLUS_FEATURE_DSDA_HOLD_NOT_SUPPORT = new InterfaceC1764a() { // from class: com.android.incallui.J
                @Override // z8.InterfaceC1764a
                public final Object value() {
                    Boolean bool;
                    bool = Boolean.FALSE;
                    return bool;
                }
            };
            OplusFeatureOption.FEATURE_SOFTWARE_SUPPORT_SECONDARY_MINI_APP = false;
            print("AutoInject Feature Value End");
        }

        private static final void print(String str, boolean z10) {
            if (z10) {
                android.util.Log.i(TAG, str);
            }
            if (sLoggable) {
                android.util.Log.d(TAG, str);
            }
        }

        public void getFeatureIdBySlotId() {
        }
    }

    static {
        String str = Build.HARDWARE;
        OPLUS_HW_MANUFACTURER_QUALCOMM = str.matches("qcom");
        OPLUS_HW_MANUFACTURER_MTK = str.matches("mt[0-9]*");
        OPLUS_PHONE_HARASS_INTERCEPT_OFF = true;
        OPLUS_PHONE_VILTE_NOT_FULLSCREEN = true;
        VERSION_STORE = true;
    }
}
