package D2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.telecom.DisconnectCause;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.android.incallui.Call;
import com.android.incallui.CallCardPresenter;
import com.android.incallui.CallList;
import com.android.incallui.CallUtils;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.Log;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.internal_dependency.InternalSdkDepends;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/* compiled from: OplusCallCardInfoUtils.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f426a = Arrays.asList("si_LK", "in_ID");

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f427b = {"*611", "*300", "*350", "*700", "*111", "*555"};

    public static String a(Context context, long j10) {
        if (context == null) {
            return DateUtils.formatElapsedTime(j10);
        }
        String locale = Locale.getDefault().toString();
        Log.d("OplusCallCardInfoUtils", "formatElapsedTime language = " + locale);
        if (f426a.contains(locale)) {
            return b(context, j10);
        }
        return DateUtils.formatElapsedTime(j10);
    }

    public static String b(Context context, long j10) {
        long j11;
        long j12;
        if (context == null) {
            return "";
        }
        if (j10 >= 3600) {
            j11 = j10 / 3600;
            j10 -= 3600 * j11;
        } else {
            j11 = 0;
        }
        if (j10 >= 60) {
            j12 = j10 / 60;
            j10 -= 60 * j12;
        } else {
            j12 = 0;
        }
        Formatter formatter = new Formatter(new StringBuilder(8), Locale.getDefault());
        String string = context.getResources().getString(R.string.elapsed_time_short_format_mm_ss);
        String string2 = context.getResources().getString(R.string.elapsed_time_short_format_h_mm_ss);
        if (j11 > 0) {
            return formatter.format(string2, Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j10)).toString();
        }
        return formatter.format(string, Long.valueOf(j12), Long.valueOf(j10)).toString();
    }

    public static Drawable c(Context context, int i10, Call call) {
        ContactInfoCache.ContactCacheEntry contactInfo = call.getContactInfo();
        if (contactInfo == null) {
            return null;
        }
        if (i10 != 0) {
            if (i10 != 2 && i10 != 3) {
                return null;
            }
            return contactInfo.yellowPageInfo.f101i;
        }
        return contactInfo.photo;
    }

    public static String d(Context context, Call call) {
        String str = null;
        if (call != null && call.isPickup() && !Call.State.isDialing(call.getState()) && !CallList.getInstance().isCDMADialingCall(call)) {
            long connectTimeMillis = call.getConnectTimeMillis();
            if (call.getConnectTimeMillis() != 0) {
                long currentTimeMillis = System.currentTimeMillis() - connectTimeMillis;
                if (Log.sDebug) {
                    Log.d("OplusCallCardInfoUtils", "getPrimaryCallTime duration = " + currentTimeMillis);
                }
                if (currentTimeMillis == 0) {
                    return null;
                }
                str = a(context, currentTimeMillis / 1000);
            }
        }
        if (Log.sDebug) {
            Log.d("OplusCallCardInfoUtils", "getPrimaryCallTime" + str);
        }
        return str;
    }

    public static String e(Context context, DisconnectCause disconnectCause, String str) {
        if (context == null) {
            return null;
        }
        int i10 = R.string.card_title_call_ended;
        switch (disconnectCause.getCode()) {
            case 7:
                if (OplusPhoneUtils.isNeedPlayBusyTone(7) && !TextUtils.isEmpty(disconnectCause.getLabel())) {
                    return disconnectCause.getLabel().toString();
                }
                break;
        }
        return context.getString(i10);
    }

    public static String f(Context context, Call call) {
        ContactInfoCache.ContactCacheEntry contactInfo;
        if (call == null || context == null || (contactInfo = call.getContactInfo()) == null) {
            return null;
        }
        if (!TextUtils.isEmpty(contactInfo.name)) {
            return contactInfo.name;
        }
        if (TextUtils.isEmpty(contactInfo.name) && !TextUtils.isEmpty(contactInfo.number)) {
            String replace = contactInfo.number.replace(" ", "");
            int numberHideSettings = OplusPhoneUtils.getNumberHideSettings(context);
            if (numberHideSettings != 0) {
                if (Log.sDebug) {
                    Log.d("OplusCallCardInfoUtils", "getDisplayName: numberHideSettings:" + numberHideSettings);
                }
                return OplusPhoneUtils.getRecordFileNameMaskedStr(replace, numberHideSettings);
            }
            return replace;
        }
        if (!TextUtils.isEmpty(contactInfo.name) || !TextUtils.isEmpty(contactInfo.number)) {
            return null;
        }
        return k(context);
    }

    public static Call g(CallList callList, Call call, Call call2, Call call3, boolean z10) {
        DisconnectCause disconnectCause;
        String str;
        OplusCallList oplusCallList = callList.oplusCallList();
        Call activeCall = oplusCallList.getActiveCall();
        if (p(activeCall, call, call2, call3)) {
            if (Log.sDebug) {
                Log.d("OplusCallCardInfoUtils", "get call >>>ActiveCall = " + activeCall.getId());
            }
            return activeCall;
        }
        if (!z10) {
            Call disconnectingCall = oplusCallList.getDisconnectingCall();
            if (p(disconnectingCall, call, call2, call3)) {
                if (Log.sDebug) {
                    Log.d("OplusCallCardInfoUtils", "get call >>>DisconnectingCall = " + disconnectingCall.getId());
                }
                return disconnectingCall;
            }
            Call disconnectedCall = oplusCallList.getDisconnectedCall();
            if (disconnectedCall != null) {
                disconnectCause = disconnectedCall.getDisconnectCause();
            } else {
                disconnectCause = null;
            }
            if (disconnectCause != null) {
                str = disconnectCause.getReason();
            } else {
                str = null;
            }
            if (Log.sDebug) {
                Log.d("OplusCallCardInfoUtils", "disconnectCauseReson = " + str);
            }
            if (!"IMS_MERGED_SUCCESSFULLY".equals(str) && disconnectedCall != null && !disconnectedCall.isUsedToBeIMSChildCall() && p(disconnectedCall, call, call2, call3)) {
                if (Log.sDebug) {
                    Log.d("OplusCallCardInfoUtils", "get call >>>DisconnectedCall = " + disconnectedCall.getId());
                }
                return disconnectedCall;
            }
        }
        Call backgroundCall = oplusCallList.getBackgroundCall();
        if (p(backgroundCall, call, call2, call3)) {
            if (Log.sDebug) {
                Log.d("OplusCallCardInfoUtils", "get call >>>BackgroundCall = " + backgroundCall.getId());
            }
            return backgroundCall;
        }
        Call secondBackgroundCall = oplusCallList.getSecondBackgroundCall();
        if (p(secondBackgroundCall, call, call2, call3)) {
            if (Log.sDebug) {
                Log.d("OplusCallCardInfoUtils", "get call >>>SecondBackgroundCall = " + secondBackgroundCall.getId());
            }
            return secondBackgroundCall;
        }
        Call oplusGetOutgoingCall = oplusCallList.oplusGetOutgoingCall();
        if (!p(oplusGetOutgoingCall, call, call2, call3)) {
            return null;
        }
        android.util.Log.d("OplusCallCardInfoUtils", "getCallToDisplay: outgoing call " + oplusGetOutgoingCall);
        return oplusGetOutgoingCall;
    }

    public static String h(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return str2;
            }
            return str + " " + str2;
        }
        return str;
    }

    public static String i(Context context, int i10, Call call) {
        if (call.isEmergencyCall()) {
            return context.getString(R.string.oplus_emergency_number);
        }
        ContactInfoCache.ContactCacheEntry contactInfo = call.getContactInfo();
        if (contactInfo == null) {
            return null;
        }
        if (i10 != 3) {
            if (i10 == 4 || i10 == 5 || i10 == 6) {
                return null;
            }
            return contactInfo.location;
        }
        return context.getString(R.string.oplus_yellow_page_number);
    }

    public static String j(Context context, int i10, Call call) {
        ContactInfoCache.ContactCacheEntry contactInfo = call.getContactInfo();
        String str = null;
        if (contactInfo == null) {
            return null;
        }
        switch (i10) {
            case 0:
            case 1:
                str = contactInfo.name;
                break;
            case 2:
                str = contactInfo.yellowPageInfo.f97e;
                break;
            case 3:
                str = contactInfo.yellowPageInfo.f95c;
                break;
            case 4:
                str = contactInfo.location;
                break;
            case 5:
                if (call.showSingleParty()) {
                    str = contactInfo.name;
                    break;
                } else {
                    str = context.getString(R.string.card_title_conf_call);
                    break;
                }
            case 6:
                str = context.getString(R.string.oplus_cdma_multi_call);
                break;
            case 7:
                str = contactInfo.yellowPageInfo.f96d;
                break;
        }
        if (TextUtils.isEmpty(str)) {
            if (call.isEmergencyCall()) {
                return context.getString(R.string.oplus_emergency_call_dialog_number_for_display);
            }
            if (q(call.getNumber())) {
                return context.getString(R.string.oplus_co_service_center);
            }
            return str;
        }
        return str;
    }

    public static String k(Context context) {
        int i10;
        if (OplusFeatureOption.OPLUSOS_FEATURE_INCALLUI_SHOW_PRIVATE_NUMBER) {
            i10 = R.string.private_num;
        } else {
            i10 = R.string.oplus_unknown;
        }
        return context.getString(i10);
    }

    public static int l(Context context, Call call) {
        if (!call.showSingleParty() && call.isConferenceCall()) {
            boolean isCdmaPhoneActive = CallList.getInstance().oplusCallList().isCdmaPhoneActive();
            Log.d("OplusCallCardInfoUtils", "setPrimary: isConference, isCdmaPhoneActive=" + isCdmaPhoneActive);
            if (isCdmaPhoneActive) {
                return 6;
            }
            return 5;
        }
        ContactInfoCache.ContactCacheEntry contactInfo = call.getContactInfo();
        if (contactInfo == null) {
            return 1;
        }
        String number = call.getNumber();
        if (!TextUtils.isEmpty(number)) {
            number = PhoneNumberUtils.formatNumber(number, null, InternalSdkDepends.getSInstance().getCurrentCountryIso(context));
        }
        if (contactInfo.person_id == -1) {
            if (!OplusFeatureOption.OPLUS_CMCC_TEST && !TextUtils.isEmpty(contactInfo.location) && f.y(number)) {
                return 4;
            }
            if (t(contactInfo, number, context)) {
                return 3;
            }
            if (!TextUtils.isEmpty(contactInfo.yellowPageInfo.f96d) && !contactInfo.isWhiteListNumber) {
                return 7;
            }
            if (TextUtils.isEmpty(contactInfo.yellowPageInfo.f97e)) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public static m2.b m(Context context, Call call) {
        boolean z10;
        Log.d("OplusCallCardInfoUtils", "getPrimaryInfo: ");
        if (context == null || call == null) {
            return null;
        }
        int l10 = l(context, call);
        Log.d("OplusCallCardInfoUtils", "getPrimaryInfo: numberType=" + l10);
        m2.b bVar = new m2.b();
        bVar.q(call.getId());
        String j10 = j(context, l10, call);
        if ((l10 == 5 || l10 == 6) && !call.showSingleParty()) {
            bVar.u(j10);
            return bVar;
        }
        String number = call.getNumber();
        boolean isEmergencyNumber = OplusPhoneUtils.isEmergencyNumber(number);
        bVar.p(isEmergencyNumber);
        String str = "";
        if (!TextUtils.isEmpty(number)) {
            number = PhoneNumberUtils.formatNumber(number.replaceAll(" ", "").replaceAll("-", ""), null, InternalSdkDepends.getSInstance().getCurrentCountryIso(context));
        }
        if (!TextUtils.isEmpty(j10) && !TextUtils.equals(j10, number)) {
            z10 = false;
        } else {
            z10 = true;
        }
        bVar.v(z10);
        ContactInfoCache.ContactCacheEntry contactInfo = call.getContactInfo();
        if (contactInfo != null) {
            String str2 = contactInfo.number;
            if (!TextUtils.isEmpty(str2)) {
                number = PhoneNumberUtils.formatNumber(str2.replaceAll(" ", "").replaceAll("-", ""), null, InternalSdkDepends.getSInstance().getCurrentCountryIso(context));
            }
        }
        int numberHideSettings = OplusPhoneUtils.getNumberHideSettings(context);
        if (numberHideSettings != 0) {
            if (Log.sDebug) {
                Log.d("OplusCallCardInfoUtils", "getPrimaryInfo: numberHideSettings:" + numberHideSettings);
            }
            number = OplusPhoneUtils.getNumberMaskedStr(number, numberHideSettings);
            j10 = OplusPhoneUtils.getHidedNumberInName(j10, numberHideSettings, context);
        }
        bVar.u(j10);
        if (!TextUtils.isEmpty(number)) {
            bVar.w("\u200e" + number);
        }
        bVar.n(OplusPhoneUtils.getCardIcon(context, call.getSlotId(), isEmergencyNumber));
        if (contactInfo == null) {
            return bVar;
        }
        String i10 = i(context, l10, call);
        if (OplusPhoneUtils.needShowLocation(context) && i10 != null && !i10.equals(context.getString(R.string.unknown)) && !i10.equals(context.getString(R.string.oplusUnknown))) {
            str = i10;
        }
        bVar.s(str);
        bVar.m(c(context, l10, call));
        if (l10 == 0) {
            if (ContactInfoCache.ContactType.isVipContact(contactInfo.contactType)) {
                bVar.o(context.getString(R.string.incoming_call_type_vip_contacts));
            }
            bVar.r(h(contactInfo.company, contactInfo.title));
        } else if (l10 == 2) {
            bVar.t(contactInfo.yellowPageInfo.f98f);
        }
        bVar.y(contactInfo.isVoiceMail);
        bVar.x(contactInfo.isPenetratedIncomingCall);
        return bVar;
    }

    public static String n(String str, String str2, boolean z10, boolean z11) {
        if (!OplusFeatureOption.OPLUS_CMCC_TEST && !TextUtils.isEmpty(str) && !"anonymous".equals(str)) {
            if (!TextUtils.isEmpty(str2)) {
                if (z10 && !z11) {
                    return "\u200e" + str2;
                }
                return "\u200e" + str + "  " + str2;
            }
            return str;
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void o(android.content.Context r20, com.android.incallui.Call r21, D2.b.a r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D2.b.o(android.content.Context, com.android.incallui.Call, D2.b$a, boolean):void");
    }

    public static boolean p(Call call, Call call2, Call call3, Call call4) {
        if (call != null && call != call2 && call != call3 && call != call4) {
            return true;
        }
        return false;
    }

    public static boolean q(String str) {
        if (!OplusFeatureOption.OPLUS_VERSION_EXP || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if ("CO".equals(G2.d.a("persist.sys.oplus.region"))) {
                for (String str2 : f427b) {
                    if (str2.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (RuntimeException e10) {
            Log.e("OplusCallCardInfoUtils", "RuntimeException" + e10.getMessage());
        }
        return false;
    }

    public static boolean r(Context context, Call call) {
        boolean z10;
        if (u(call) && s(context, call)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d("OplusCallCardInfoUtils", "isOnlyShowTimeForVideo  = " + z10);
        }
        return z10;
    }

    public static boolean s(Context context, Call call) {
        if (call != null && CallUtils.isVideoCall(call) && !CallUtils.isAudioCallRingtone(context, call)) {
            return true;
        }
        return false;
    }

    public static boolean t(ContactInfoCache.ContactCacheEntry contactCacheEntry, String str, Context context) {
        if (contactCacheEntry != null && context != null) {
            if (contactCacheEntry.isYellowPageNumber) {
                return true;
            }
            String str2 = contactCacheEntry.location;
            if (!TextUtils.isEmpty(contactCacheEntry.yellowPageInfo.f95c)) {
                String string = context.getString(R.string.unknown);
                String string2 = context.getString(R.string.oplus_local_number);
                String string3 = context.getString(R.string.oplus_special_number);
                if (!TextUtils.isEmpty(str2) && !string.equals(str2) && !string2.equals(str2) && !string3.equals(str2)) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (f.y(str)) {
                            contactCacheEntry.isYellowPageNumber = false;
                            return false;
                        }
                        contactCacheEntry.isYellowPageNumber = true;
                        return true;
                    }
                } else {
                    contactCacheEntry.isYellowPageNumber = true;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean u(Call call) {
        boolean z10;
        if (call != null && (call.getState() == 3 || call.getState() == 8)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d("OplusCallCardInfoUtils", "primaryCallIsActive = " + z10);
        }
        return z10;
    }

    public static void v(Context context, String str, String str2, boolean z10, String str3, Drawable drawable, int i10, String str4, String str5, Call call, a aVar, boolean z11, long j10, boolean z12, int i11, String str6, boolean z13) {
        String str7;
        String str8;
        String string;
        String string2;
        String str9;
        String str10 = str3;
        boolean r10 = r(context, call);
        if (Log.sDebug) {
            Log.d("OplusCallCardInfoUtils", "setPrimaryInfo number = " + g.l(str) + " nameIsNumber = " + z10 + " name = " + g.l(str2) + " photo = " + drawable + " slotId = " + i10 + " markInfo = " + str4 + " isFloatingWindow = " + z11 + " yellowPageMark = " + str6 + " isYellowPageNumber = " + z13);
        }
        if (aVar != null && context != null && call != null) {
            int state = call.getState();
            boolean z14 = z11 && j10 == -1 && !Call.State.isRing(state) && !Call.State.isConnectingOrDialing(state);
            boolean z15 = state == 8;
            if (Log.sDebug) {
                Log.d("OplusCallCardInfoUtils", "isFloatingWindowActvie = " + z14 + "  isHold = " + z15 + "  callState = " + state);
            }
            if (!OplusPhoneUtils.needShowLocation(context) || str10 == null || str10.equals(context.getString(R.string.unknown)) || str10.equals(context.getString(R.string.oplusUnknown))) {
                str10 = "";
            }
            if (!z10 && str2 == null && OplusPhoneUtils.isEmergencyNumber(str)) {
                str2 = context.getString(R.string.oplus_emergency_call_dialog_number_for_display);
            }
            if (z10 && str == null) {
                str7 = str2;
                str8 = null;
            } else {
                str7 = str;
                str8 = str2;
            }
            if (str7 != null) {
                str7 = PhoneNumberUtils.formatNumber(str7.replaceAll(" ", "").replaceAll("-", ""), null, InternalSdkDepends.getSInstance().getCurrentCountryIso(context));
            }
            if (z10 && (str8 == null || !str8.equals(str7))) {
                str8 = "\u200e" + str7;
                str7 = null;
            }
            int numberHideSettings = OplusPhoneUtils.getNumberHideSettings(context);
            if (numberHideSettings != 0) {
                if (Log.sDebug) {
                    Log.d("OplusCallCardInfoUtils", "setPrimaryInfo: numberHideSettings:" + numberHideSettings);
                }
                str7 = OplusPhoneUtils.getNumberMaskedStr(str7, numberHideSettings);
                str8 = OplusPhoneUtils.getHidedNumberInName(str8, numberHideSettings, context);
            }
            if (!z14) {
                aVar.h1(str8, r10);
            }
            String n10 = n(str7, str10, z11, z13);
            int i12 = (r10 || call.isEmergencyCall()) ? -1 : i10;
            if (z14) {
                OplusCallList oplusCallList = CallList.getInstance().oplusCallList();
                if (oplusCallList.oplusGetCallSize() > 1 && oplusCallList.isCdmaPhoneActive()) {
                    str8 = context.getString(R.string.oplus_cdma_multi_call);
                }
                aVar.h1(str8, r10);
                if (z15) {
                    str9 = context.getResources().getString(R.string.card_title_on_hold);
                } else {
                    str9 = "  ";
                }
                aVar.e0(str9, i12, r10, z15);
                aVar.r1(null);
            } else {
                aVar.e0(n10, i12, r10, false);
                aVar.r1(str6);
            }
            if (!r10 && call.getContactInfo() != null && call.getContactInfo().contactType == 1) {
                aVar.B(true);
            } else {
                aVar.B(false);
            }
            if (z11) {
                if (Call.State.isConnectingOrDialing(state)) {
                    if (OplusPhoneUtils.getCallStateLabelWhenVoLTEVoWifi(context) != null) {
                        string2 = OplusPhoneUtils.getCallStateLabelWhenVoLTEVoWifi(context);
                    } else {
                        string2 = context.getString(R.string.oplus_card_title_dialing);
                    }
                    aVar.k0(string2, null, null, -1);
                } else {
                    aVar.k0(null, null, null, -1);
                }
            } else if (state == 4) {
                aVar.k0(str7, str4, str5, i11);
            } else if (!r10) {
                aVar.k0(str7, str4, null, i11);
            } else {
                aVar.k0(str7, null, null, -1);
            }
            aVar.G(drawable);
            boolean isRing = Call.State.isRing(call.getState());
            if (isRing && s(context, call)) {
                string = context.getString(R.string.oplus_request_video_call);
            } else {
                string = (isRing && call.oplusGetIsCallForwarded()) ? context.getString(R.string.oplus_call_forward_info) : null;
            }
            if (call.getSessionModificationState() == 1) {
                string = context.getString(R.string.oplus_waiting_video_call);
            }
            aVar.o(string);
            if (isRing && z12) {
                aVar.N0(context.getString(R.string.oplus_penetrated_incoming_call_prompt));
            } else if (isRing && !OplusPhoneUtils.isUserUnlocked(context)) {
                aVar.N0(context.getString(R.string.oplus_fbe_read_contact_rejected));
            } else {
                aVar.N0(null);
            }
            if (isRing) {
                aVar.o1(OplusPhoneUtils.shouldShowVoiceTips(context));
                return;
            } else {
                aVar.o1(false);
                return;
            }
        }
        if (Log.sDebug) {
            Log.d("OplusCallCardInfoUtils", "setPrimaryInfo called but ui or mContext is null!");
        }
    }

    public static void w(Context context, Call call, CallCardPresenter.CallCardUi callCardUi) {
        m2.b m10;
        Log.d("OplusCallCardInfoUtils", "updatePrimaryDisplayInfo: ");
        if (callCardUi != null && context != null && call != null && (m10 = m(context, call)) != null) {
            callCardUi.setPrimary(m10);
        }
    }

    public static void x(Context context, Call call, CallCardPresenter.CallCardUi callCardUi, String str) {
        boolean z10;
        Log.d("OplusCallCardInfoUtils", "updateSecondaryDisplayInfo: ");
        if (callCardUi == null) {
            return;
        }
        if (context != null && call != null) {
            m2.c cVar = new m2.c();
            cVar.j(call.getId());
            String j10 = j(context, l(context, call), call);
            String number = call.getNumber();
            if (!OplusPhoneUtils.isEmergencyNumber(number) && q(number)) {
                j10 = context.getString(R.string.oplus_co_service_center);
            }
            if (!TextUtils.isEmpty(number)) {
                number = PhoneNumberUtils.formatNumber(call.getNumber(), null, InternalSdkDepends.getSInstance().getCurrentCountryIso(context));
            }
            int numberHideSettings = OplusPhoneUtils.getNumberHideSettings(context);
            if (numberHideSettings != 0) {
                if (Log.sDebug) {
                    Log.d("OplusCallCardInfoUtils", "updateSecondaryDisplayInfo: numberHideSettings:" + numberHideSettings);
                }
                number = OplusPhoneUtils.getNumberMaskedStr(number, numberHideSettings);
                j10 = OplusPhoneUtils.getHidedNumberInName(j10, numberHideSettings, context);
            }
            cVar.h(OplusPhoneUtils.getCardSecondIcon(context, call.getSlotId(), OplusPhoneUtils.isEmergencyNumber(number)));
            if (!TextUtils.isEmpty(j10) && !TextUtils.equals(j10, number)) {
                z10 = false;
            } else {
                z10 = true;
            }
            cVar.l(z10);
            cVar.k(j10);
            cVar.i(str);
            cVar.m("\u200e" + number);
            callCardUi.setSecondary(cVar);
            return;
        }
        callCardUi.setSecondary(new m2.c());
    }

    /* compiled from: OplusCallCardInfoUtils.java */
    /* loaded from: classes.dex */
    public interface a {
        void h1(String str, boolean z10);

        default void B(boolean z10) {
        }

        default void G(Drawable drawable) {
        }

        default void N0(String str) {
        }

        default void o(String str) {
        }

        default void o1(boolean z10) {
        }

        default void r1(String str) {
        }

        default void e0(String str, int i10, boolean z10, boolean z11) {
        }

        default void k0(String str, String str2, String str3, int i10) {
        }
    }
}
