package G1;

import android.content.Context;
import android.telecom.DisconnectCause;
import android.text.TextUtils;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.CallUtils;
import com.android.incallui.Log;
import com.android.incallui.OplusCall;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.oplus.brand.BrandCenter;
import kotlin.jvm.internal.i;

/* compiled from: CallStateConverter.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1089a = new b();

    public final H1.b a(Call call) {
        if (call == null) {
            return null;
        }
        String id = call.getId();
        int subId = call.getSubId();
        int slotId = call.getSlotId();
        int state = call.getState();
        String d10 = d(call);
        boolean isVideoCall = CallUtils.isVideoCall(call);
        boolean isConferenceCall = call.isConferenceCall();
        int size = call.getChildCallIds().size();
        boolean isShowConferenceManageButton = OplusPhoneUtils.isShowConferenceManageButton(call);
        return new H1.b(id, slotId, subId, state, 0, OplusPhoneUtils.getAudioQualityType(call, false), d10, isVideoCall, call.getConnectTimeMillis(), isConferenceCall, OplusPhoneUtils.isVowifiState(call, CallList.getInstance().getActiveSubId()), false, false, g(call), size, isShowConferenceManageButton, false, call.showSingleParty(), 71696, null);
    }

    public final H1.b b(Call call) {
        if (call == null) {
            return null;
        }
        return new H1.b(call.getId(), 0, 0, call.getState(), 0, 0, e(call), false, call.getConnectTimeMillis(), call.isConferenceCall(), false, false, false, false, 0, false, false, call.showSingleParty(), 130230, null);
    }

    public final String c(int i10, DisconnectCause disconnectCause, Context context, Call call) {
        i.f(disconnectCause, "disconnectCause");
        i.f(context, "context");
        i.f(call, "call");
        OplusCall oplusCall = null;
        String str = null;
        if (2 == i10) {
            return null;
        }
        if (3 == i10) {
            if (h(call)) {
                str = context.getString(R.string.oplus_card_title_dialing);
            }
            Call activeCall = CallList.getInstance().getActiveCall();
            if (activeCall != null && activeCall.getFakeState() == 1 && !activeCall.getIsFakeGuard()) {
                return context.getString(R.string.oplus_card_title_answering);
            }
            return str;
        }
        if (8 == i10) {
            return context.getString(R.string.card_title_on_hold);
        }
        if (6 != i10 && 13 != i10) {
            if (7 == i10) {
                return context.getString(R.string.card_title_redialing);
            }
            if (4 != i10 && 5 != i10) {
                if (9 == i10) {
                    return context.getString(R.string.oplus_card_title_hanging_up);
                }
                if (10 == i10) {
                    String d10 = D2.b.d(context, call);
                    String e10 = D2.b.e(context, disconnectCause, d10);
                    if (d10 != null) {
                        return e10 + "  " + d10;
                    }
                    return e10;
                }
                Log.w("CallStateConverter", "updateCallStateWidgets: unexpected call: " + i10);
                return null;
            }
            String string = context.getString(R.string.card_title_incoming_call);
            T5.a d11 = BrandCenter.f19187a.a().d();
            if (d11 != null) {
                Call incomingCall = CallList.getInstance().getIncomingCall();
                if (incomingCall instanceof OplusCall) {
                    oplusCall = (OplusCall) incomingCall;
                }
                if (oplusCall != null && oplusCall.isRttCall()) {
                    return d11.G(context);
                }
            }
            return string;
        }
        String callStateLabelWhenVoLTEVoWifi = OplusPhoneUtils.getCallStateLabelWhenVoLTEVoWifi(context);
        if (TextUtils.isEmpty(callStateLabelWhenVoLTEVoWifi)) {
            callStateLabelWhenVoLTEVoWifi = call.getCallStateString();
        }
        T5.a d12 = BrandCenter.f19187a.a().d();
        if (d12 != null && ((OplusCall) call).isRttCall()) {
            callStateLabelWhenVoLTEVoWifi = d12.H(context);
        }
        String str2 = callStateLabelWhenVoLTEVoWifi;
        if (TextUtils.isEmpty(str2)) {
            return context.getString(R.string.oplus_card_title_dialing);
        }
        return str2;
    }

    public final String d(Call call) {
        boolean z10;
        if (call == null) {
            return null;
        }
        Context context = OplusInCallApp.getAppContext();
        int state = call.getState();
        DisconnectCause disconnectCause = call.getDisconnectCause();
        i.e(disconnectCause, "call.disconnectCause");
        int sessionModificationState = call.getSessionModificationState();
        if (CallUtils.isVideoCall(call) && !CallUtils.isAudioCallRingtone(context, call)) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean oplusGetIsCallForwarded = call.oplusGetIsCallForwarded();
        boolean isRing = Call.State.isRing(state);
        if (isRing && z10) {
            return context.getString(R.string.call_card_video_incoming_label);
        }
        if (isRing && oplusGetIsCallForwarded) {
            return context.getString(R.string.oplus_call_forward_info);
        }
        if (sessionModificationState == 1) {
            return context.getString(R.string.oplus_waiting_video_call);
        }
        i.e(context, "context");
        return c(state, disconnectCause, context, call);
    }

    public final String e(Call call) {
        if (call == null) {
            return null;
        }
        Context appContext = OplusInCallApp.getAppContext();
        int state = call.getState();
        if (2 == state) {
            return null;
        }
        if (3 == state) {
            String string = appContext.getString(R.string.card_title_in_call);
            if (call.getFakeState() == 1 && !call.getIsFakeGuard()) {
                return appContext.getString(R.string.oplus_card_title_answering);
            }
            return string;
        }
        if (8 == state) {
            return appContext.getString(R.string.card_title_on_hold);
        }
        if (6 != state && 13 != state) {
            if (7 == state) {
                return appContext.getString(R.string.card_title_redialing);
            }
            if (4 != state && 5 != state) {
                if (9 == state) {
                    return appContext.getString(R.string.oplus_card_title_hanging_up);
                }
                if (10 == state) {
                    String d10 = D2.b.d(appContext, call);
                    String e10 = D2.b.e(appContext, call.getDisconnectCause(), d10);
                    if (d10 != null) {
                        return e10 + "  " + d10;
                    }
                    return e10;
                }
                Log.w("CallStateConverter", "updateCallStateWidgets: unexpected call: " + state);
                return null;
            }
            return appContext.getString(R.string.card_title_incoming_call);
        }
        return appContext.getString(R.string.oplus_card_title_dialing);
    }

    public final boolean f(Call call) {
        if (call != null) {
            CallList callList = CallList.getInstance();
            i.d(callList, "null cannot be cast to non-null type com.android.incallui.OplusCallList");
            if (1 == ((OplusCallList) callList).oplusGetCallSize() && CallList.getInstance().isCDMADialingCall(call)) {
                return true;
            }
        }
        return false;
    }

    public final boolean g(Call call) {
        if (call == null || call.getState() != 3) {
            return false;
        }
        if ((call.getFakeState() != 0 && !call.getIsFakeGuard()) || call.getConnectTimeMillis() == 0) {
            return false;
        }
        if ((!OplusPhoneUtils.isCDMATelecomCustomize() && call.isCdmaDialing()) || call.getSessionModificationState() == 1) {
            return false;
        }
        return true;
    }

    public final boolean h(Call call) {
        if (!OplusPhoneUtils.isCDMATelecomCustomize() && f(call)) {
            return true;
        }
        return false;
    }
}
