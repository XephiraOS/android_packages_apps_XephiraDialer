package D2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.CallUtils;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.Log;
import com.android.incallui.OplusCall;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.internal_dependency.InternalSdkDepends;
import java.util.Iterator;

/* compiled from: OplusInCallNotification.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f428a = false;

    public static void a(Context context, int i10) {
        if (context == null) {
            Log.i("OplusInCallNotification", "cancelNotification: context is null for notificationId " + i10);
            return;
        }
        Log.d("OplusInCallNotification", "cancelNotification notificationId " + i10);
        if (i10 == 5) {
            f428a = false;
        }
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(i10);
        } catch (Exception e10) {
            Log.e("OplusInCallNotification", "cancelNotification with exception: e = " + e10);
        }
    }

    public static NotificationChannel b(Context context, String str, CharSequence charSequence, int i10) {
        if (context == null) {
            Log.i("OplusInCallNotification", "createChannel: context is null for channelId " + str);
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        if (notificationChannel == null) {
            NotificationChannel notificationChannel2 = new NotificationChannel(str, charSequence, i10);
            notificationManager.createNotificationChannel(notificationChannel2);
            return notificationChannel2;
        }
        return notificationChannel;
    }

    public static String c(Context context, Call call) {
        String str;
        if (call == null) {
            return null;
        }
        ContactInfoCache.ContactCacheEntry contactInfo = call.getContactInfo();
        if (contactInfo.person_id != -1 && !TextUtils.isEmpty(contactInfo.name)) {
            str = contactInfo.name;
        } else {
            String str2 = contactInfo.number;
            if (str2 != null) {
                str2 = str2.replaceAll(" ", "").replaceAll("-", "");
            }
            if (context != null && str2 != null) {
                str2 = PhoneNumberUtils.formatNumber(str2, null, InternalSdkDepends.getSInstance().getCurrentCountryIso(context));
            }
            int numberHideSettings = OplusPhoneUtils.getNumberHideSettings(context);
            if (numberHideSettings != 0) {
                if (Log.sDebug) {
                    Log.d("OplusInCallNotification", "getDisplayName: numberHideSettings:" + numberHideSettings);
                }
                str = OplusPhoneUtils.getNumberMaskedStr(str2, numberHideSettings);
            } else {
                str = str2;
            }
        }
        Log.d("OplusInCallNotification", "getDisplayName: = " + g.o(str) + " for call: " + call.getId());
        return str;
    }

    public static Intent d(Context context, OplusCall oplusCall, boolean z10) {
        if (oplusCall == null) {
            Log.i("OplusInCallNotification", "getNotesIntent: call is null");
            return null;
        }
        Intent intent = new Intent("action.nearme.note.textnote");
        intent.setPackage(OplusPhoneUtils.NOTES_PACKAGE_NAME);
        intent.addFlags(335544320);
        String notesGuid = oplusCall.getNotesGuid();
        Log.d("OplusInCallNotification", "getNotesIntent, guid = " + notesGuid + "  for call: " + oplusCall);
        if (TextUtils.isEmpty(notesGuid)) {
            intent.putExtra("view", false);
        } else {
            intent.putExtra("view", true);
            intent.putExtra("guid", notesGuid);
        }
        intent.putExtra("call_id", oplusCall.getId());
        if (oplusCall.isConferenceCall()) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = oplusCall.getChildCallIds().iterator();
            while (it.hasNext()) {
                Call callById = CallList.getInstance().getCallById(it.next());
                if (callById != null) {
                    stringBuffer.append(c(context, callById));
                    stringBuffer.append(",");
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            Log.d("OplusInCallNotification", "getNotesIntent, displayNameList = " + g.o(stringBuffer.toString()));
            intent.putExtra("phone_contacts", stringBuffer.toString());
        } else {
            intent.putExtra("phone_contacts", c(context, oplusCall));
        }
        intent.putExtra("call_type", oplusCall.getCallType());
        intent.putExtra("edit_note_flag", z10);
        return intent;
    }

    public static void e(Context context) {
        if (context == null) {
            Log.i("OplusInCallNotification", "sendHdNotification: context is null");
            return;
        }
        if (f428a) {
            Log.i("OplusInCallNotification", "hd notification is showing");
            return;
        }
        Log.i("OplusInCallNotification", "send HD Voice Call Notification");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        b(context, "incall_hd_voice_call", context.getString(R.string.inCallLabel), 3);
        Notification.Builder builder = new Notification.Builder(context, "incall_hd_voice_call");
        String string = context.getString(R.string.notification_hd_voice_call_title);
        builder.setOngoing(true).setSmallIcon(R.drawable.incall_ic_notification_hd_voice).setContentTitle(string).setContentText(context.getString(R.string.notification_hd_voice_call_content));
        notificationManager.notify(5, builder.build());
        f428a = true;
    }

    public static void f(Context context, OplusCall oplusCall) {
        if (context == null) {
            Log.i("OplusInCallNotification", "sendNotesNotification: context is null");
            return;
        }
        if (oplusCall == null) {
            Log.i("OplusInCallNotification", "sendNotesNotification: call is null");
            return;
        }
        Log.i("OplusInCallNotification", "sendNotesNotification");
        Notification.Builder builder = new Notification.Builder(context);
        NotificationChannel b10 = b(context, "InCallNotes", context.getResources().getString(R.string.oplus_notes), 3);
        String string = context.getString(R.string.oplus_click_to_view_notes);
        PendingIntent activity = PendingIntent.getActivity(context, 0, d(context, oplusCall, false), 201326592);
        builder.setSmallIcon(R.drawable.incall_ic_launcher).setOngoing(false).setVisibility(1).setShowWhen(true).setWhen(System.currentTimeMillis()).setPriority(0).setTicker(string).setContentTitle(string).setContentIntent(activity).setFullScreenIntent(activity, true).setAutoCancel(true).setDefaults(3).setChannelId(b10.getId());
        try {
            ((NotificationManager) context.getSystemService("notification")).notify(3, builder.build());
        } catch (AndroidRuntimeException e10) {
            Log.i("OplusInCallNotification", "sendNotesNotification with exception: ae = " + e10);
        } catch (Exception e11) {
            Log.i("OplusInCallNotification", "sendNotesNotification with exception: e = " + e11);
        }
    }

    public static boolean g(Context context, Call call) {
        if (context == null) {
            Log.i("OplusInCallNotification", "shouldShowHdNotification: context is null");
            return false;
        }
        if (call == null) {
            Log.i("OplusInCallNotification", "shouldShowHdNotification: call is null");
            return false;
        }
        if (!CallUtils.isAudioCall(call)) {
            Log.i("OplusInCallNotification", "not a audio call");
            return false;
        }
        int audioQualityType = OplusPhoneUtils.getAudioQualityType(call, false);
        if (audioQualityType != 1 && audioQualityType != 2) {
            return false;
        }
        Log.i("OplusInCallNotification", "call audio quality is high");
        return true;
    }
}
