package com.android.incallui;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import s8.C1569l;

/* loaded from: classes.dex */
public class OplusPhoneUserActionStatistics {
    public static final String ACTION_ACTIVITY_FINISHING = "activity_finishing";
    public static final String ACTION_CALL_NULL_SHOW_NOTIFICATION = "call_null_show_notification";
    public static final String ACTION_FINISH_ACTIVITY_BY_BROADCAST = "finish_by_receive_action";
    public static final String ACTION_ICON_RECYCLED = "large_icon_recycled";
    public static final String ACTION_INCALL_NOT_DISTURB = "incall_not_disturb";
    public static final String ACTION_NOTIFICATION_NOT_SHOW = "notification_not_show";
    public static final String ACTION_NOTIFY_ERROR = "notify_error";
    public static final String ACTION_NO_CALL_UI = "call_no_ui";
    public static final String ACTION_SHOULD_HIDE_ACTIVITY = "hide_ui";
    public static final int ANSWER_CALL_FAIL = 201090047;
    public static final int AUTO_RECORD_STATUS = 201090050;
    public static final String CALL_AUTO_RECORD = "call_auto_record";
    public static final String CALL_GAME_MODE_WATCH_INCALL = "call_game_mode_watch_incall";
    public static final int CALL_RECORD_SDCARD_POPUP = 201090065;
    public static final int CLICK_ADD_CALL_BUTTON = 201090006;
    public static final int CLICK_DIALER_BUTTON = 201090005;
    public static final int CLICK_MUTE_BUTTON = 201090007;
    public static final int CLICK_NOTES_BUTTON = 201090010;
    public static final int CLICK_RECORD_BUTTON = 201090004;
    public static final String CONTACT_AUTO_RECORD = "contact_auto_record";
    public static final int DAY_UI_SHOWING_TIME = 201090061;
    public static final int EVENT_HIDE_RING_UI_BY_PRESS_HOME_KEY = 201090058;
    public static final int EVENT_NO_ATTRIBUTION = 201090054;
    public static final int EVENT_RECORD_PROMPT_DIALOG_CLICK = 201090056;
    public static final int EVENT_SHOW_RECORD_PROMPT = 201090055;
    public static final int EVENT_SHOW_RING_UI_AFTER_PRESS_HOME_KEY = 201090057;
    public static final int INCOMING_CALL_CLICK_CONFIRM_INTERCEPT_BUTTON = 201090064;
    public static final int INCOMING_CALL_CLICK_DECLINE_AND_INTERCEPT_ICON = 201090063;
    public static final String LOG_TAG = "OplusPhoneUserActionStatistics";
    public static final String NO_ATTRIBUTION = "no_attribution";
    public static final String NUMBER_MARK_FRAGMENT_ADD_BLACKLIST = "number_mark_fragment_add_blacklist";
    public static final String NUMBER_MARK_FRAGMENT_MARK = "number_mark_fragment_mark";
    public static final String NUMBER_MARK_FRAGMENT_SAVE_NEW_NUMBER = "number_mark_fragment_save_number";
    public static final String RECORD_FOR_THIRD_PARTY = "record_for_third_party";
    public static final String SEND_CALL_RECORD_PATH = "feature_send_call_record_path";
    public static final String STRANGER_AUTO_RECORD = "stranger_auto_record";
    public static final String TAG_AUTO_RECORD = "2010910";
    public static final String TAG_BIND_INTERACT_ERROR = "bind_interact_error";
    public static final String TAG_DIAL_AND_SCREEN = "2010903";
    public static final String TAG_FLOATING_WINDOW = "2010911";
    public static final String TAG_HARASS_INTERCEPT = "2010902";
    public static final String TAG_MTC_NO_RING = "incoming_no_ring";
    public static final String TAG_NUMBER_RECOGNITION = "2010909";
    public static final String TAG_TECHNOLOGY_STATISTIC = "2010907";
    public static final String TAG_VIDEO_CALL = "2010901";
    public static final String USER_ACTION_BINDER_IS_NULL = "binder_is_null";
    public static final String USER_ACTION_BIND_REMOTE_ERROR = "bind_remote_error";
    public static final String USER_ACTION_CALL_RECORD_FAILED = "call_recording_failed";
    public static final String USER_ACTION_DIR_PATH_IS_NULL = "dir_path_is_null";
    public static final String USER_ACTION_FILE_NOT_EXIT = "file_not_exit";
    public static final String USER_ACTION_FLOATING_WINDOW_ANSWER = "floating_window_answer";
    public static final String USER_ACTION_FLOATING_WINDOW_DISPLAY_SCREEN = "floating_window_display_screen";
    public static final String USER_ACTION_FLOATING_WINDOW_SHOW = "incoming_floating_window";
    public static final String USER_ACTION_FLOATING_WINDOW_TURN_ON_SPEAKER = "floating_window_turn_on_speaker";
    public static final int USER_ACTION_HARASS_INTERCEPT_DIALOG_CANCEL = 201090041;
    public static final int USER_ACTION_HARASS_INTERCEPT_DIALOG_CLICK = 201090042;
    public static final int USER_ACTION_HARASS_INTERCEPT_DIALOG_DISPLAY = 201090040;
    public static final String USER_ACTION_INCOMING_CALL_ID_NULL = "incoming_call_id_null";
    public static final String USER_ACTION_INCOMING_CALL_NULL = "incoming_call_null";
    public static final String USER_ACTION_MKDIRS_FAILED = "mkdirs_failed";
    public static final String USER_ACTION_RECORD_NAME_IS_NULL = "record_name_is_null";
    public static final String USER_ACTION_RELEASE_RECORDER_EXCEPTION = "release_recorder_exception";
    public static final String USER_ACTION_START_RECORD_EXCEPTION = "start_record_exception";
    public static final String USER_ACTION_STOP_RECORDER_EXCEPTION = "stop_recorder_exception";
    public static final int VIDEO_ACCEPT_VIDEO_REQUEST_BY_LOCAL_WHEN_CALL = 201090038;
    public static final int VIDEO_CAMERA_CLOSE_BY_REMOTE_WHEN_CALL = 201090031;
    public static final int VIDEO_CLICK_BIG_SURFACE_WHEN_CALL = 201090029;
    public static final int VIDEO_CLICK_CHANGE_TO_AUDIO_WHEN_CALL = 201090026;
    public static final int VIDEO_CLICK_CHANGE_TO_VIDEO_WHEN_CALL = 201090034;
    public static final int VIDEO_CLICK_SMALL_SURFACE_WHEN_CALL = 201090025;
    public static final int VIDEO_MOVE_SURFACE_WHEN_CALL = 201090027;
    public static final int VIDEO_RECEIVE_VIDEO_REQUEST_WHEN_CALL = 201090036;
    public static final int VIDEO_REJECT_VIDEO_REQUEST_BY_LOCAL_WHEN_CALL = 201090037;
    public static final int VIDEO_SCREEN_TO_BACKGROUND_WHEN_CALL = 201090032;
    public static final int VIDEO_SWITCH_CAMERE_WHEN_CALL = 201090024;

    /* loaded from: classes.dex */
    public @interface Keys {
        public static final String IS_PRIMARY_SLOT_ID = "is_primary_slotId";
        public static final String WIFI_CONNECTED = "wifi_connected";
    }

    public static void addAutoRecordAction(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        Log.d(LOG_TAG, "addAutoRecordAction key = " + str);
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        onCommon(context, TAG_TECHNOLOGY_STATISTIC, CALL_AUTO_RECORD, hashMap);
    }

    public static void addBindInteractError(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        onCommon(context, TAG_TECHNOLOGY_STATISTIC, TAG_BIND_INTERACT_ERROR, hashMap);
    }

    public static void addCallRecordFailedAction(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        onCommon(context, TAG_AUTO_RECORD, USER_ACTION_CALL_RECORD_FAILED, hashMap);
    }

    public static void addNoCallUIAction(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        onCommon(context, TAG_TECHNOLOGY_STATISTIC, ACTION_NO_CALL_UI, hashMap);
    }

    public static void addNoIncomingRingAction(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        onCommon(context, TAG_TECHNOLOGY_STATISTIC, TAG_MTC_NO_RING, hashMap);
    }

    public static void gameModeWatchInCallActivity(Context context, Call call) {
        boolean z10;
        if (context != null && call != null) {
            int slotId = call.getSlotId();
            HashMap hashMap = new HashMap();
            if (slotId == OplusPhoneUtils.getPrimarySlotId(context)) {
                z10 = true;
            } else {
                z10 = false;
            }
            hashMap.put(Keys.IS_PRIMARY_SLOT_ID, String.valueOf(z10));
            hashMap.put(Keys.WIFI_CONNECTED, String.valueOf(OplusPhoneUtils.isWifiConnected(context)));
            onCommon(context, TAG_TECHNOLOGY_STATISTIC, CALL_GAME_MODE_WATCH_INCALL, hashMap);
        }
    }

    public static void markNoAttribution(Context context, String str) {
        String removeNumberPrefix;
        Log.d(LOG_TAG, "markNoAttribution number = " + D2.g.l(str));
        if (context != null && !TextUtils.isEmpty(str) && (removeNumberPrefix = OplusPhoneUtils.removeNumberPrefix(OplusPhoneUtils.getFormattingNumber(str))) != null && removeNumberPrefix.length() == 11) {
            String substring = removeNumberPrefix.substring(0, 7);
            HashMap hashMap = new HashMap();
            hashMap.put(NO_ATTRIBUTION, substring);
            onCommon(context, TAG_TECHNOLOGY_STATISTIC, EVENT_NO_ATTRIBUTION, hashMap);
        }
    }

    public static void onCommon(Context context, String str, int i10, Map map) {
        if (context == null) {
            return;
        }
        try {
            C1569l.s(context, str, String.valueOf(i10), map);
        } catch (Exception e10) {
            Log.d(LOG_TAG, "Exception: " + e10.toString());
        }
    }

    public static void onCommon(Context context, String str, String str2, Map map) {
        if (context == null) {
            return;
        }
        try {
            C1569l.s(context, str, str2, map);
        } catch (Exception e10) {
            Log.d(LOG_TAG, "Exception: " + e10.toString());
        }
    }
}
