package com.android.incallui;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import com.android.incallui.CallerInfoAsyncQuery;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class CallerInfoUtils {
    private static final List<String> NOT_SHOW_CNAPNAME = Arrays.asList("Unavailable");
    private static final int QUERY_TOKEN = -1;
    private static final String TAG = "CallerInfoUtils";

    public static CallerInfo buildCallerInfo(Context context, Call call) {
        CallerInfo callerInfo = new CallerInfo();
        String cnapName = call.getCnapName();
        callerInfo.cnapName = cnapName;
        if (!OplusFeatureOption.OPLUS_PHONE_DISPLAY_CALLER_ID_NAME && cnapName != null && NOT_SHOW_CNAPNAME.contains(cnapName.replaceAll("\\s", ""))) {
            callerInfo.cnapName = null;
        }
        callerInfo.name = callerInfo.cnapName;
        callerInfo.numberPresentation = call.getNumberPresentation();
        callerInfo.namePresentation = call.getCnapNamePresentation();
        callerInfo.contactRefUri = call.getCustomContactUri();
        String number = call.getNumber();
        if (!TextUtils.isEmpty(number)) {
            String[] split = number.split("&");
            String str = split[0];
            if (split.length > 1) {
                callerInfo.forwardingNumber = split[1];
            }
            callerInfo.phoneNumber = modifyForSpecialCnapCases(context, callerInfo, str, callerInfo.numberPresentation);
        }
        if ((call.getHandle() != null && "voicemail".equals(call.getHandle().getScheme())) || isVoiceMailNumber(context, call)) {
            callerInfo.markAsVoiceMail(context);
        }
        return callerInfo;
    }

    public static CallerInfo getCallerInfoForCall(Context context, Call call, CallerInfoAsyncQuery.OnQueryCompleteListener onQueryCompleteListener) {
        CallerInfo buildCallerInfo = buildCallerInfo(context, call);
        if (buildCallerInfo.numberPresentation == 1) {
            Log.d(TAG, "==> Actually starting CallerInfoAsyncQuery.startQuery()...");
            CallerInfoAsyncQuery.startQuery(-1, context, buildCallerInfo, onQueryCompleteListener, call);
        }
        return buildCallerInfo;
    }

    private static boolean isCnapSpecialCaseRestricted(String str) {
        if (!str.equals("PRIVATE") && !str.equals("P") && !str.equals("RES")) {
            return false;
        }
        return true;
    }

    private static boolean isCnapSpecialCaseUnknown(String str) {
        if (!str.equals("UNAVAILABLE") && !str.equals("UNKNOWN") && !str.equals("UNA") && !str.equals("U")) {
            return false;
        }
        return true;
    }

    public static boolean isVoiceMailNumber(Context context, Call call) {
        if (call == null) {
            return false;
        }
        if (call.getContactInfo() != null && call.getContactInfo().isVoiceMailComplete) {
            return call.getContactInfo().isVoiceMail;
        }
        if (call.getTelecommCall() == null) {
            return false;
        }
        TelecomManager telecomManager = (TelecomManager) context.getSystemService("telecom");
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            return false;
        }
        return telecomManager.isVoiceMailNumber(call.getTelecommCall().getDetails().getAccountHandle(), call.getNumber());
    }

    public static String modifyForSpecialCnapCases(Context context, CallerInfo callerInfo, String str, int i10) {
        if (callerInfo != null && str != null) {
            String str2 = TAG;
            Log.d(str2, "modifyForSpecialCnapCases: initially, number=" + toLogSafePhoneNumber(str) + ", presentation=" + i10 + " ci.numberPresentation " + callerInfo.numberPresentation);
            if (Arrays.asList(context.getResources().getStringArray(R.array.absent_num)).contains(str) && i10 == 1) {
                str = D2.b.k(context);
                callerInfo.numberPresentation = 3;
            }
            int i11 = callerInfo.numberPresentation;
            if (i11 == 1 || (i11 != i10 && i10 == 1)) {
                if (isCnapSpecialCaseRestricted(str)) {
                    str = context.getString(R.string.private_num);
                    callerInfo.numberPresentation = 2;
                } else if (isCnapSpecialCaseUnknown(str)) {
                    str = D2.b.k(context);
                    callerInfo.numberPresentation = 3;
                }
                Log.d(str2, "SpecialCnap: number=" + toLogSafePhoneNumber(str) + "; presentation now=" + callerInfo.numberPresentation);
            }
            Log.d(str2, "modifyForSpecialCnapCases: returning number string=" + toLogSafePhoneNumber(str));
        }
        return str;
    }

    public static String toLogSafePhoneNumber(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '-' && charAt != '@' && charAt != '.' && charAt != '&') {
                sb.append('x');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static boolean isVoiceMailNumber(Context context, PhoneAccountHandle phoneAccountHandle, String str) {
        if (phoneAccountHandle == null || TextUtils.isEmpty(str)) {
            return false;
        }
        TelecomManager telecomManager = (TelecomManager) context.getSystemService("telecom");
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            return false;
        }
        return telecomManager.isVoiceMailNumber(phoneAccountHandle, str);
    }
}
