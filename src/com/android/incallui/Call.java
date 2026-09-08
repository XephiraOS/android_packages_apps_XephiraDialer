package com.android.incallui;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Trace;
import android.telecom.Call;
import android.telecom.DisconnectCause;
import android.telecom.InCallService;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.VideoProfile;
import android.text.TextUtils;
import com.android.incallui.Call;
import com.android.incallui.ContactInfoCache;
import com.android.oplus.module.castScreen.CastScreen;
import com.internal_dependency.AddOnSdkDepends;
import com.internal_dependency.IncommingRingtoneListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.codeaurora.ims.QtiImsExtListenerBaseImpl;
import org.codeaurora.ims.internal.IQtiImsExt;

/* loaded from: classes.dex */
public class Call {
    protected static final int DISCONNECT_GUARD_TIME_DUA = 1000;
    private static final String EVENT_CALL_ALERTING_NOTIFICATION = "mediatek.telecom.event.EVENT_CALL_ALERTING_NOTIFICATION";
    public static final String EXTRA_TELECOM_CALL_ID = "android.telecom.extra.TELECOM_CALL_ID";
    private static final String ID_PREFIX = "DialerCall_";
    private static final String IMS_EVENT_NOTIFICATION_RINGTONE = "mediatek.telecom.event.IMS_EVENT_NOTIFICATION_RINGTONE";
    private static final String LOG_TAG = "Call";
    protected static final int MSG_RESET_DISCONNECT_GUARD = 1000;
    private static int sIdCounter;
    private boolean isRemotelyHeld;
    private boolean mAnswerFail;
    private Call mCall;
    private String mCallSubject;
    private int mCameraDirection;
    protected final List<String> mChildCallIds;
    private String mChildNumber;
    protected final Context mContext;
    protected int mCurrentChildSize;
    private DisconnectCause mDisconnectCause;
    protected boolean mDisconnectGuard;
    private Uri mHandle;
    protected Handler mHandler;
    private final String mId;
    public boolean mIsActiveSub;
    protected boolean mIsCallChanged;
    private boolean mIsCallSubjectSupported;
    private boolean mIsEmergencyCall;
    private boolean mIsIncomingRingtone;
    protected boolean mIsUpdateSinglePartyUI;
    protected int mLastChildSize;
    private String mLastForwardedNumber;
    private final List<F1.a> mListeners;
    private LogState mLogState;
    private Handler mMainHandler;
    private int mModifyToVideoState;
    protected boolean mNotShowInCallUIForIncoming;
    protected final List<String> mOldChildCallIds;
    protected boolean mOplusAutoReplySms;
    protected boolean mOplusAutoSpeaker;
    protected boolean mOplusClickToVoice;
    private boolean mOplusIsCallForwarded;
    protected boolean mOplusIsCdmaPhone;
    protected boolean mOplusIsVideoResume;
    protected boolean mOplusIsVideoRingTone;
    private float mOplusPeerVideoRatio;
    protected boolean mOplusUsedToBeConferenceCall;
    protected int mOplusVideoState;
    private PhoneAccountHandle mPhoneAccountHandle;
    private boolean mPickup;
    private QtiImsInterfaceImpl mQtiImsInterfaceImpl;
    private QtiImsExtListenerBaseImpl mQtiImsInterfaceListener;
    private final U5.b mRealImpl;
    private int mRecordStatus;
    private int mSessionModificationState;
    protected boolean mSetConnectingFirst;
    protected boolean mShouldRingForContact;
    protected boolean mShowSingleParty;
    protected Call mSingleParty;
    protected int mState;
    protected android.telecom.Call mTelecomCall;
    private Call.Callback mTelecomCallCallback;
    protected String mTelecommCallId;
    private InCallService.VideoCall mVideoCall;
    private InCallVideoCallCallback mVideoCallCallback;
    private final VideoSettings mVideoSettings;
    private boolean rttStatusChange;

    /* renamed from: com.android.incallui.Call$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends Call.Callback {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConnectionEvent$0() {
            CallList.getInstance().onUpdate(Call.this.mCall);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConnectionEvent$1() {
            CallList.getInstance().onUpdate(Call.this.mCall);
        }

        @Override // android.telecom.Call.Callback
        public void onCallDestroyed(android.telecom.Call call) {
            if (Log.sDebug) {
                Log.d(Call.LOG_TAG, "TelecommCallCallback onCallDestroyed call=" + call);
            }
            call.unregisterCallback(Call.this.mTelecomCallCallback);
        }

        @Override // android.telecom.Call.Callback
        public void onCannedTextResponsesLoaded(android.telecom.Call call, List<String> list) {
            if (Log.sDebug) {
                Log.d(Call.LOG_TAG, "TelecommCallCallback onStateChanged call=" + call + " cannedTextResponses=" + list);
            }
            Call.this.update();
        }

        @Override // android.telecom.Call.Callback
        public void onChildrenChanged(android.telecom.Call call, List<android.telecom.Call> list) {
            Call.this.update();
        }

        @Override // android.telecom.Call.Callback
        public void onConferenceableCallsChanged(android.telecom.Call call, List<android.telecom.Call> list) {
            if (Log.sDebug) {
                Log.d(Call.LOG_TAG, "onConferenceableCallsChanged call=" + call);
            }
            Call call2 = Call.this;
            call2.mIsCallChanged = true;
            call2.update();
        }

        @Override // android.telecom.Call.Callback
        public void onConnectionEvent(android.telecom.Call call, String str, Bundle bundle) {
            boolean z10;
            Log.v("DialerCall.onConnectionEvent", "Call: " + call + ", Event: " + str + ", Extras: " + bundle);
            str.hashCode();
            boolean z11 = true;
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1727264373:
                    if (str.equals(Call.EVENT_CALL_ALERTING_NOTIFICATION)) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -731255741:
                    if (str.equals("android.telecom.event.CALL_REMOTELY_UNHELD")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 255456062:
                    if (str.equals(Call.IMS_EVENT_NOTIFICATION_RINGTONE)) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 758141852:
                    if (str.equals("android.telephony.event.EVENT_NOTIFY_INTERNATIONAL_CALL_ON_WFC")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 1161109851:
                    if (str.equals("android.telecom.event.CALL_MERGE_FAILED")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 1317277546:
                    if (str.equals("android.telecom.event.CALL_REMOTELY_HELD")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 1673445297:
                    if (str.equals("android.telephony.event.EVENT_HANDOVER_TO_WIFI_FAILED")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 2024477568:
                    if (str.equals("android.telephony.event.EVENT_HANDOVER_VIDEO_FROM_WIFI_TO_LTE")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 2026866822:
                    if (str.equals("org.codeaurora.event.PHONE_ACCOUNT_CHANGED")) {
                        c10 = '\b';
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    if (Call.this.mCall != null) {
                        CallList callList = CallList.getInstance();
                        if (Call.this.mCall.getState() != 5 && (Call.this.mCall.getState() != 4 || (callList.getBackgroundCall() == null && !callList.isAnyOtherSubActive(callList.getActiveSubId())))) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        Log.d(Call.LOG_TAG, "EVENT_CALL_ALERTING_NOTIFICATION isCallWaiting " + z10 + ",mOplusIsCallForwarded =" + Call.this.mOplusIsCallForwarded);
                        if (Call.this.getCallStatusLabel() == null && !z10 && !Call.this.mOplusIsCallForwarded) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt(OplusAutoRedialNotificationUI.TYPE, 11);
                            Call.this.parseBundleData(bundle2);
                            Call.this.mMainHandler.post(new Runnable() { // from class: com.android.incallui.g
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Call.AnonymousClass1.this.lambda$onConnectionEvent$1();
                                }
                            });
                            break;
                        }
                    }
                    break;
                case 1:
                    Call.this.isRemotelyHeld = false;
                    Call.this.update();
                    Call.this.refreshUI();
                    break;
                case 2:
                    Call.this.parseBundleData(bundle);
                    Call.this.mMainHandler.post(new Runnable() { // from class: com.android.incallui.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            Call.AnonymousClass1.this.lambda$onConnectionEvent$0();
                        }
                    });
                    break;
                case 3:
                    Call.this.notifyInternationalCallOnWifi();
                    break;
                case 4:
                    Call.this.update();
                    break;
                case 5:
                    Call.this.isRemotelyHeld = true;
                    Call.this.update();
                    Call.this.refreshUI();
                    break;
                case 6:
                    Call.this.notifyHandoverToWifiFailed();
                    break;
                case 7:
                    Call.this.notifyWiFiToLteHandover();
                    break;
                case '\b':
                    Call.this.update();
                    break;
            }
            if (call == null || !call.getDetails().can(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE)) {
                z11 = false;
            }
            Log.d(Call.LOG_TAG, "onConnectionEvent isIncomingRingtoneNew " + z11 + "mIsIncomingRingtone =" + Call.this.mIsIncomingRingtone);
            if (Call.this.mIsIncomingRingtone && !z11) {
                InCallPresenter.getInstance().realInstance().startRinging("InComingRingtoneFallback");
            }
            Call.this.mIsIncomingRingtone = z11;
        }

        @Override // android.telecom.Call.Callback
        public void onDetailsChanged(android.telecom.Call call, Call.Details details) {
            if (Log.sDebug) {
                Log.d(Call.LOG_TAG, "TelecommCallCallback onDetailsChanged call=" + call + " details=" + details + "  callState = " + call.getState());
            }
            Call.this.oplusOnDetailsChanged(call);
        }

        @Override // android.telecom.Call.Callback
        public void onParentChanged(android.telecom.Call call, android.telecom.Call call2) {
            if (Log.sDebug) {
                Log.d(Call.LOG_TAG, "TelecommCallCallback onParentChanged call=" + call + " newParent=" + call2);
            }
            TelecomAdapter.getInstance().oplusTelecomAdapter().dealWithParentChanged();
            Call.this.update();
        }

        @Override // android.telecom.Call.Callback
        public void onPostDialWait(android.telecom.Call call, String str) {
            if (Log.sDebug) {
                Log.d(Call.LOG_TAG, "TelecommCallCallback onStateChanged call=" + call + " remainingPostDialSequence=" + str);
            }
            Call.this.update();
        }

        @Override // android.telecom.Call.Callback
        public void onRttInitiationFailure(android.telecom.Call call, int i10) {
            Log.i("TelecomCallCallback.onRttInitiationFailure", "reason=%d", Integer.valueOf(i10));
            Call.this.update();
        }

        @Override // android.telecom.Call.Callback
        public void onRttModeChanged(android.telecom.Call call, int i10) {
            Log.i("TelecomCallCallback.onRttModeChanged", "mode=%d", Integer.valueOf(i10));
        }

        @Override // android.telecom.Call.Callback
        public void onRttRequest(android.telecom.Call call, int i10) {
            Log.i("TelecomCallCallback.onRttRequest", "id=%d", Integer.valueOf(i10));
        }

        @Override // android.telecom.Call.Callback
        public void onRttStatusChanged(android.telecom.Call call, boolean z10, Call.RttCall rttCall) {
            Log.i("TelecomCallCallback.onRttStatusChanged", "enabled=%b", Boolean.valueOf(z10));
            Call.this.rttStatusChange = true;
            Call.this.update();
        }

        @Override // android.telecom.Call.Callback
        public void onStateChanged(android.telecom.Call call, int i10) {
            Log.d(this, "TelecommCallCallback onStateChanged call=" + call + " newState=" + i10);
            Call.this.oplusOnStateChanged(call, i10);
            Call callByTelecommCall = CallList.getInstance().getCallByTelecommCall(call);
            if (callByTelecommCall != null) {
                CastScreen.f19196a.a().o(callByTelecommCall.getState(), CallList.getInstance().getCallByTelecommCall(call).getId(), "");
            }
        }

        @Override // android.telecom.Call.Callback
        public void onVideoCallChanged(android.telecom.Call call, InCallService.VideoCall videoCall) {
            if (Log.sDebug) {
                Log.d(Call.LOG_TAG, "TelecommCallCallback onVideoCallChanged call=" + call + " videoCall=" + videoCall);
            }
            Call.this.update();
        }
    }

    /* loaded from: classes.dex */
    public static class CameraDirection {
        public static final int CAMERA_DIRECTION_BACK_FACING = 1;
        public static final int CAMERA_DIRECTION_FRONT_FACING = 0;
        public static final int CAMERA_DIRECTION_UNKNOWN = -1;
    }

    /* loaded from: classes.dex */
    public static class LogState {
        public static final int INITIATION_CALL_DETAILS = 10;
        public static final int INITIATION_CALL_LOG = 7;
        public static final int INITIATION_CALL_LOG_FILTER = 8;
        public static final int INITIATION_DIALPAD = 2;
        public static final int INITIATION_EXTERNAL = 12;
        public static final int INITIATION_INCOMING = 1;
        public static final int INITIATION_QUICK_CONTACTS = 11;
        public static final int INITIATION_REGULAR_SEARCH = 6;
        public static final int INITIATION_REMOTE_DIRECTORY = 4;
        public static final int INITIATION_SMART_DIAL = 5;
        public static final int INITIATION_SPEED_DIAL = 3;
        public static final int INITIATION_VOICEMAIL_LOG = 9;
        public static final int LOOKUP_EMERGENCY = 5;
        public static final int LOOKUP_LOCAL_CACHE = 3;
        public static final int LOOKUP_LOCAL_CONTACT = 2;
        public static final int LOOKUP_REMOTE_CONTACT = 4;
        public static final int LOOKUP_UNKNOWN = 0;
        public static final int LOOKUP_VOICEMAIL = 6;
        public DisconnectCause disconnectCause;
        public boolean isIncoming = false;
        public int contactLookupResult = 0;
        public int callInitiationMethod = 12;
        public long duration = 0;

        private static String initiationToString(int i10) {
            switch (i10) {
                case 1:
                    return "Incoming";
                case 2:
                    return "Dialpad";
                case 3:
                    return "Speed Dial";
                case 4:
                    return "Remote Directory";
                case 5:
                    return "Smart Dial";
                case 6:
                    return "Regular Search";
                case 7:
                    return "Call Log";
                case 8:
                    return "Call Log Filter";
                case 9:
                    return "Voicemail Log";
                case 10:
                    return "Call Details";
                case 11:
                    return "Quick Contacts";
                default:
                    return "Unknown";
            }
        }

        private static String lookupToString(int i10) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 5) {
                            if (i10 != 6) {
                                return "Not found";
                            }
                            return "Voicemail";
                        }
                        return "Emergency";
                    }
                    return "Remote";
                }
                return "Cache";
            }
            return "Local";
        }

        public String toString() {
            return String.format(Locale.US, "[%s, isIncoming: %s, contactLookup: %s, callInitiation: %s, duration: %s]", this.disconnectCause, Boolean.valueOf(this.isIncoming), lookupToString(this.contactLookupResult), initiationToString(this.callInitiationMethod), Long.valueOf(this.duration));
        }
    }

    /* loaded from: classes.dex */
    public static class QtiImsInterfaceImpl {
        private static final String IMS_SERVICE_PKG_NAME = "org.codeaurora.ims";
        private IQtiImsExt mQtiImsInterface = null;
        private boolean mImsServiceBound = false;
        private Context mContext = null;
        private ServiceConnection mConnection = new ServiceConnection() { // from class: com.android.incallui.Call.QtiImsInterfaceImpl.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                QtiImsInterfaceImpl.this.mQtiImsInterface = IQtiImsExt.Stub.N7(iBinder);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                QtiImsInterfaceImpl.this.mQtiImsInterface = null;
            }
        };

        public IQtiImsExt getQtiImsInterface() {
            if (this.mImsServiceBound) {
                return this.mQtiImsInterface;
            }
            return null;
        }

        public void stopQtiImsInterface() {
            if (this.mImsServiceBound && this.mContext != null) {
                Log.d(this, "stopQtiImsInterface: UnBinding IQtiImsExt...");
                this.mImsServiceBound = false;
                this.mContext.unbindService(this.mConnection);
                this.mContext = null;
                return;
            }
            Log.d(this, "stopQtiImsInterface: Service Bound - " + this.mImsServiceBound + " or contex is null");
        }
    }

    /* loaded from: classes.dex */
    public static class SessionModificationState {
        public static final int NO_REQUEST = 0;
        public static final int RECEIVED_UPGRADE_TO_VIDEO_REQUEST = 3;
        public static final int REQUEST_FAILED = 2;
        public static final int REQUEST_REJECTED = 5;
        public static final int UPGRADE_TO_VIDEO_REQUEST_TIMED_OUT = 4;
        public static final int WAITING_FOR_RESPONSE = 1;
    }

    /* loaded from: classes.dex */
    public static class State {
        public static final int ACTIVE = 3;
        public static final int BLOCKED = 14;
        public static final int CALL_WAITING = 5;
        public static final int CONFERENCED = 11;
        public static final int CONNECTING = 13;
        public static final int DIALING = 6;
        public static final int DISCONNECTED = 10;
        public static final int DISCONNECTING = 9;
        public static final int IDLE = 2;
        public static final int INCOMING = 4;
        public static final int INVALID = 0;
        public static final int NEW = 1;
        public static final int ONHOLD = 8;
        public static final int PULLING = 15;
        public static final int REDIALING = 7;
        public static final int SELECT_PHONE_ACCOUNT = 12;

        public static boolean isActiveOrHold(int i10) {
            if (i10 != 3 && i10 != 8) {
                return false;
            }
            return true;
        }

        public static boolean isConnectingOrConnected(int i10) {
            if (i10 == 11 || i10 == 13 || i10 == 15) {
                return true;
            }
            switch (i10) {
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return true;
                default:
                    return false;
            }
        }

        public static boolean isConnectingOrDialing(int i10) {
            if (i10 != 6 && i10 != 13 && i10 != 15 && i10 != 7) {
                return false;
            }
            return true;
        }

        public static boolean isConnectingOrDialingOrIncomming(int i10) {
            if (i10 != 6 && i10 != 13 && i10 != 15 && i10 != 7 && i10 != 4) {
                return false;
            }
            return true;
        }

        public static boolean isDialing(int i10) {
            if (i10 != 6 && i10 != 15 && i10 != 7) {
                return false;
            }
            return true;
        }

        public static boolean isDisconnectingOrDisconnected(int i10) {
            if (i10 != 9 && i10 != 10) {
                return false;
            }
            return true;
        }

        public static boolean isInComming(int i10) {
            if (i10 == 4) {
                return true;
            }
            return false;
        }

        public static boolean isRing(int i10) {
            if (i10 != 4 && i10 != 5) {
                return false;
            }
            return true;
        }

        public static String toString(int i10) {
            switch (i10) {
                case 0:
                    return "INVALID";
                case 1:
                    return "NEW";
                case 2:
                    return "IDLE";
                case 3:
                    return "ACTIVE";
                case 4:
                    return "INCOMING";
                case 5:
                    return "CALL_WAITING";
                case 6:
                    return "DIALING";
                case 7:
                    return "REDIALING";
                case 8:
                    return "ONHOLD";
                case 9:
                    return "DISCONNECTING";
                case 10:
                    return "DISCONNECTED";
                case 11:
                    return "CONFERENCED";
                case 12:
                    return "SELECT_PHONE_ACCOUNT";
                case 13:
                    return "CONNECTING";
                case 14:
                    return "BLOCKED";
                case 15:
                    return "PULLING";
                default:
                    return "UNKNOWN-" + i10;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class VideoSettings {
        public static final int CAMERA_DIRECTION_BACK_FACING = 1;
        public static final int CAMERA_DIRECTION_FRONT_FACING = 0;
        public static final int CAMERA_DIRECTION_UNKNOWN = -1;
        private int mCameraDirection = -1;

        public int getCameraDir() {
            return this.mCameraDirection;
        }

        public void setCameraDir(int i10) {
            if (i10 != 0 && i10 != 1) {
                this.mCameraDirection = -1;
            } else {
                this.mCameraDirection = i10;
            }
        }

        public String toString() {
            return "(CameraDir:" + getCameraDir() + ")";
        }
    }

    public Call(int i10) {
        this.mChildCallIds = new ArrayList();
        this.mListeners = new CopyOnWriteArrayList();
        this.mState = 0;
        this.mCameraDirection = -1;
        this.mIsActiveSub = false;
        this.mVideoSettings = new VideoSettings();
        this.mModifyToVideoState = 0;
        this.mOplusIsCallForwarded = false;
        this.mIsCallChanged = false;
        this.mOldChildCallIds = new ArrayList();
        this.mDisconnectGuard = false;
        this.mSetConnectingFirst = true;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mRealImpl = U5.a.a();
        this.mOplusClickToVoice = false;
        this.mOplusIsCdmaPhone = false;
        this.mOplusIsVideoRingTone = false;
        this.mOplusIsVideoResume = false;
        this.mOplusAutoSpeaker = false;
        this.mOplusAutoReplySms = false;
        this.mOplusVideoState = 0;
        this.mOplusUsedToBeConferenceCall = false;
        this.mOplusPeerVideoRatio = 0.0f;
        this.mShouldRingForContact = true;
        this.mNotShowInCallUIForIncoming = false;
        this.rttStatusChange = false;
        this.mTelecomCallCallback = new AnonymousClass1();
        this.mLogState = new LogState();
        this.mQtiImsInterfaceImpl = new QtiImsInterfaceImpl();
        this.mQtiImsInterfaceListener = new QtiImsExtListenerBaseImpl() { // from class: com.android.incallui.Call.2
            @Override // org.codeaurora.ims.QtiImsExtListenerBaseImpl, org.codeaurora.ims.internal.IQtiImsExtListener
            public void receiveCallTransferResponse(int i11, int i12) {
                Log.w(this, "receiveCallTransferResponse: " + i12);
            }
        };
        this.mPickup = false;
        this.mAnswerFail = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.android.incallui.Call.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1000) {
                    if (Log.sDebug) {
                        Log.d(Call.LOG_TAG, "MSG_RESET_DISCONNECT_GUARD message received...");
                    }
                    Call call = Call.this;
                    call.mDisconnectGuard = false;
                    if (call.getState() == 9) {
                        if (Log.sDebug) {
                            Log.d(Call.LOG_TAG, "should to hang up call");
                        }
                        android.telecom.Call telecommCall = Call.this.getTelecommCall();
                        if (telecommCall != null) {
                            telecommCall.disconnect();
                            return;
                        }
                        Log.e(this, "error disconnectCall, diconnectCall is null " + Call.this.getId());
                    }
                }
            }
        };
        this.mRecordStatus = 0;
        this.mTelecomCall = null;
        StringBuilder sb = new StringBuilder();
        sb.append(ID_PREFIX);
        int i11 = sIdCounter;
        sIdCounter = i11 + 1;
        sb.append(Integer.toString(i11));
        this.mId = sb.toString();
        this.mContext = InCallPresenter.getInstance().getContext();
        setState(i10);
    }

    public static boolean areSame(Call call, Call call2) {
        if (call == null && call2 == null) {
            return true;
        }
        if (call != null && call2 != null) {
            return call.getId().equals(call2.getId());
        }
        return false;
    }

    public static boolean areSameNumber(Call call, Call call2) {
        if (call == null && call2 == null) {
            return true;
        }
        if (call != null && call2 != null) {
            return TextUtils.equals(call.getNumber(), call2.getNumber());
        }
        return false;
    }

    public static String getNumberFromHandle(Uri uri) {
        if (uri == null) {
            return "";
        }
        return uri.getSchemeSpecificPart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        CallList.getInstance().onUpdate(this.mCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(int i10, int i11) {
        Log.d(LOG_TAG, "onCallInfoupdate infoType=" + i10 + ",reasonCode=" + i11);
        setCallLabledata(i10, i11);
        this.mMainHandler.post(new Runnable() { // from class: com.android.incallui.e
            @Override // java.lang.Runnable
            public final void run() {
                Call.this.lambda$new$0();
            }
        });
    }

    private static int translateState(int i10) {
        switch (i10) {
            case 0:
            case 9:
                return 13;
            case 1:
                return 6;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 3;
            case 5:
            case 6:
            default:
                return 0;
            case 7:
                return 10;
            case 8:
                return 12;
            case 10:
                return 9;
            case 11:
                return 15;
        }
    }

    private void updateEmergencyCallState() {
        String schemeSpecificPart;
        Uri handle = this.mTelecomCall.getDetails().getHandle();
        if (handle == null) {
            schemeSpecificPart = "";
        } else {
            schemeSpecificPart = handle.getSchemeSpecificPart();
        }
        boolean isEmergencyNumber = OplusPhoneUtils.isEmergencyNumber(schemeSpecificPart, this);
        this.mIsEmergencyCall = isEmergencyNumber;
        if (isEmergencyNumber && this.mRealImpl != null) {
            Log.d(LOG_TAG, "updateEmergencyCallState: init map");
            this.mRealImpl.b();
        }
    }

    private void updateFromTelecommCall() {
        ArrayList<String> stringArrayList;
        PhoneAccount phoneAccount;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateFromTelecommCall: " + this.mTelecomCall.toString());
        }
        int translateState = translateState(this.mTelecomCall.getState());
        if (this.mState != translateState) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "mIsCallChanged mState != newState");
            }
            this.mIsCallChanged = true;
            setState(translateState);
        }
        DisconnectCause disconnectCause = this.mTelecomCall.getDetails().getDisconnectCause();
        DisconnectCause disconnectCause2 = this.mDisconnectCause;
        if ((disconnectCause2 != null && !disconnectCause2.equals(disconnectCause)) || (disconnectCause != null && !disconnectCause.equals(this.mDisconnectCause))) {
            setDisconnectCause(this.mTelecomCall.getDetails().getDisconnectCause());
            this.mIsCallChanged = true;
            if (Log.sDebug) {
                Log.d(LOG_TAG, "mIsCallChanged mDisconnectCause != mTelecommCall.getDetails().getDisconnectCause()");
            }
        }
        if (this.mTelecomCall.getVideoCall() != null) {
            if (this.mVideoCallCallback == null) {
                this.mVideoCallCallback = new InCallVideoCallCallback(this);
                this.mIsCallChanged = true;
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "mIsCallChanged mVideoCallCallback = " + this.mVideoCallCallback);
                }
                this.mTelecomCall.getVideoCall().registerCallback(this.mVideoCallCallback);
                A2.l.d().m(this.mTelecommCallId);
            } else {
                this.mTelecomCall.getVideoCall().registerCallback(this.mVideoCallCallback);
            }
        }
        this.mVideoCall = this.mTelecomCall.getVideoCall();
        oplusUpdateFromTelecommCall();
        this.mOldChildCallIds.clear();
        this.mOldChildCallIds.addAll(this.mChildCallIds);
        this.mChildCallIds.clear();
        for (int i10 = 0; i10 < this.mTelecomCall.getChildren().size(); i10++) {
            this.mChildCallIds.add(CallList.getInstance().getCallByTelecommCall(this.mTelecomCall.getChildren().get(i10)).getId());
        }
        if (this.mChildCallIds.size() != this.mOldChildCallIds.size()) {
            this.mLastChildSize = this.mOldChildCallIds.size();
            this.mCurrentChildSize = this.mChildCallIds.size();
            Log.d(LOG_TAG, "updateFromTelecommCall childSize from " + this.mLastChildSize + " to " + this.mCurrentChildSize);
        }
        String str = null;
        if (isConferenceCall()) {
            boolean z10 = this.mShowSingleParty;
            if (this.mLastChildSize > this.mCurrentChildSize && OplusPhoneUtils.showSingleReplaceOfConference(this.mContext, this)) {
                this.mShowSingleParty = true;
                this.mIsUpdateSinglePartyUI = true;
                Call callById = CallList.getInstance().getCallById(getChildCallIds().get(0));
                if (callById != null) {
                    this.mSingleParty = callById;
                }
            } else {
                this.mShowSingleParty = false;
                this.mSingleParty = null;
            }
            Log.d(LOG_TAG, "updateFromTelecommCall mShowSingleParty " + this.mShowSingleParty);
            if (z10 != this.mShowSingleParty) {
                copyContactInfoFromParty(this.mSingleParty);
            }
        } else {
            this.mShowSingleParty = false;
            this.mSingleParty = null;
        }
        if (!this.mIsCallChanged && !this.mOldChildCallIds.equals(this.mChildCallIds)) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "mIsCallChanged : mOldChildCallIds.equals(mChildCallIds) is false!");
            }
            this.mIsCallChanged = true;
        }
        this.mOldChildCallIds.clear();
        Bundle extras = this.mTelecomCall.getDetails().getExtras();
        if (extras != null) {
            try {
                if (extras.containsKey(EXTRA_TELECOM_CALL_ID)) {
                    this.mTelecommCallId = extras.getString(EXTRA_TELECOM_CALL_ID);
                    Log.d(LOG_TAG, "updateFromTelecommCall : mTelecommCallId = " + this.mTelecommCallId);
                }
                if (extras.containsKey("android.telecom.extra.CHILD_ADDRESS")) {
                    String string = extras.getString("android.telecom.extra.CHILD_ADDRESS");
                    if (!Objects.equals(string, this.mChildNumber)) {
                        this.mChildNumber = string;
                        CallList.getInstance().onChildNumberChange(this);
                        this.mIsCallChanged = true;
                        if (Log.sDebug) {
                            Log.d(LOG_TAG, "mIsCallChanged !Objects.equals(childNumber, mChildNumber)");
                        }
                    }
                }
                if (extras.containsKey("android.telecom.extra.LAST_FORWARDED_NUMBER") && (stringArrayList = extras.getStringArrayList("android.telecom.extra.LAST_FORWARDED_NUMBER")) != null) {
                    if (!stringArrayList.isEmpty()) {
                        str = stringArrayList.get(stringArrayList.size() - 1);
                    }
                    if (!Objects.equals(str, this.mLastForwardedNumber)) {
                        this.mLastForwardedNumber = str;
                        CallList.getInstance().onLastForwardedNumberChange(this);
                        this.mIsCallChanged = true;
                        if (Log.sDebug) {
                            Log.d(LOG_TAG, "mIsCallChanged !Objects.equals(lastForwardedNumber, mLastForwardedNumber)");
                        }
                    }
                }
                if (extras.containsKey("android.telecom.extra.CALL_SUBJECT")) {
                    String string2 = extras.getString("android.telecom.extra.CALL_SUBJECT");
                    if (!Objects.equals(this.mCallSubject, string2)) {
                        this.mCallSubject = string2;
                        this.mIsCallChanged = true;
                        if (Log.sDebug) {
                            Log.d(LOG_TAG, "mIsCallChanged !Objects.equals(mCallSubject, callSubject)");
                        }
                    }
                }
            } catch (IllegalArgumentException e10) {
                Log.d(LOG_TAG, "call get extras exception: " + e10.getMessage());
            }
        }
        Uri handle = this.mTelecomCall.getDetails().getHandle();
        if (!Objects.equals(this.mHandle, handle)) {
            this.mHandle = handle;
            updateEmergencyCallState();
            this.mIsCallChanged = true;
        }
        PhoneAccountHandle accountHandle = this.mTelecomCall.getDetails().getAccountHandle();
        if (!Objects.equals(this.mPhoneAccountHandle, accountHandle)) {
            this.mPhoneAccountHandle = accountHandle;
            if (accountHandle != null && (phoneAccount = InCallPresenter.getInstance().getTelecomManager().getPhoneAccount(this.mPhoneAccountHandle)) != null) {
                this.mIsCallSubjectSupported = phoneAccount.hasCapabilities(64);
            }
            this.mIsCallChanged = true;
        }
        if (isConferenceCall() && !isUsedToBeConferenceCall()) {
            setUsedToBeConferenceCall(true);
        }
    }

    public void addListener(F1.a aVar) {
        N1.a.c();
        this.mListeners.add(aVar);
    }

    public void answer(int i10) {
        Log.i("DialerCall.answer", "videoState: " + i10);
        this.mTelecomCall.answer(i10);
    }

    public boolean can(int i10) {
        int callCapabilities = this.mTelecomCall.getDetails().getCallCapabilities();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "can capabilities = " + OplusPhoneCapabilities.toString(i10) + "  supportedCapabilities  = " + OplusPhoneCapabilities.toString(callCapabilities));
        }
        if ((i10 & 4) != 0) {
            if (InCallServiceImpl.isDsdaEnabled()) {
                List<android.telecom.Call> conferenceableCalls = this.mTelecomCall.getConferenceableCalls();
                if (!conferenceableCalls.isEmpty()) {
                    int subId = getSubId();
                    Iterator<android.telecom.Call> it = conferenceableCalls.iterator();
                    while (it.hasNext()) {
                        PhoneAccountHandle accountHandle = it.next().getDetails().getAccountHandle();
                        if (accountHandle != null && A2.d.d(accountHandle) == subId) {
                            break;
                        }
                    }
                }
                if ((callCapabilities & 4) == 0) {
                    return false;
                }
            } else if (this.mTelecomCall.getConferenceableCalls().isEmpty() && (callCapabilities & 4) == 0) {
                return false;
            }
            i10 &= -5;
        }
        if (i10 != (this.mTelecomCall.getDetails().getCallCapabilities() & i10)) {
            return false;
        }
        return true;
    }

    public PhoneAccountHandle getAccountHandle() {
        android.telecom.Call call = this.mTelecomCall;
        if (call == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "getAccountHandle telecomCall is null, return mPhoneAccountHandle = " + this.mPhoneAccountHandle);
            }
            return this.mPhoneAccountHandle;
        }
        PhoneAccountHandle accountHandle = call.getDetails().getAccountHandle();
        if (Log.sOplusDebug) {
            Log.d(LOG_TAG, "getAccountHandle retAccountHandle = " + accountHandle + ", mPhoneAccountHandle = " + this.mPhoneAccountHandle);
        }
        if (accountHandle != null) {
            return accountHandle;
        }
        return this.mPhoneAccountHandle;
    }

    public boolean getAutoReplySms() {
        return this.mOplusAutoReplySms;
    }

    public boolean getAutoSpeaker() {
        return this.mOplusAutoSpeaker;
    }

    public String getCallStateString() {
        return null;
    }

    public String getCallStatusLabel() {
        return null;
    }

    public String getCallSubject() {
        return this.mCallSubject;
    }

    public int getCallType() {
        return 0;
    }

    public int getCameraDir() {
        return this.mCameraDirection;
    }

    public List<String> getCannedSmsResponses() {
        return this.mTelecomCall.getCannedTextResponses();
    }

    public List<String> getChildCallIds() {
        return this.mChildCallIds;
    }

    public String getChildNumber() {
        return this.mChildNumber;
    }

    public String getCnapName() {
        android.telecom.Call call = this.mTelecomCall;
        if (call == null) {
            return null;
        }
        return call.getDetails().getCallerDisplayName();
    }

    public int getCnapNamePresentation() {
        android.telecom.Call call = this.mTelecomCall;
        if (call == null) {
            return -1;
        }
        return call.getDetails().getCallerDisplayNamePresentation();
    }

    public long getConnectTimeMillis() {
        android.telecom.Call call = this.mTelecomCall;
        if (call == null) {
            return 0L;
        }
        return call.getDetails().getConnectTimeMillis();
    }

    public ContactInfoCache.ContactCacheEntry getContactInfo() {
        return null;
    }

    public long getCreationTimeMillis() {
        long creationTimeMillis = this.mTelecomCall.getDetails().getCreationTimeMillis();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getCreationTimeMillis, creationTime = " + creationTimeMillis);
        }
        return creationTimeMillis;
    }

    public Uri getCustomContactUri() {
        return null;
    }

    public DisconnectCause getDisconnectCause() {
        int i10 = this.mState;
        if (i10 != 10 && i10 != 2) {
            return new DisconnectCause(0);
        }
        return this.mDisconnectCause;
    }

    public Bundle getExtras() {
        android.telecom.Call call = this.mTelecomCall;
        if (call == null) {
            return null;
        }
        return call.getDetails().getExtras();
    }

    public int getFakeState() {
        return 0;
    }

    public Uri getHandle() {
        android.telecom.Call call = this.mTelecomCall;
        if (call == null) {
            return null;
        }
        return call.getDetails().getHandle();
    }

    public boolean getHasSRVCC() {
        return false;
    }

    public String getId() {
        return this.mId;
    }

    public boolean getInComingVideoPaused() {
        return false;
    }

    public boolean getIsCdmaPhone() {
        return this.mOplusIsCdmaPhone;
    }

    public boolean getIsFakeGuard() {
        return false;
    }

    public boolean getIsInComingRingtoneCall() {
        return false;
    }

    public boolean getIsRemotelyHeld() {
        return this.isRemotelyHeld;
    }

    public boolean getIsSilence() {
        return false;
    }

    public boolean getIsVideoResume() {
        return this.mOplusIsVideoResume;
    }

    public boolean getIsVideoRingTone() {
        return this.mOplusIsVideoRingTone;
    }

    public String getLastForwardedNumber() {
        return this.mLastForwardedNumber;
    }

    public int getModifyToVideoState() {
        return this.mModifyToVideoState;
    }

    public String getNotesGuid() {
        return null;
    }

    public String getNumber() {
        Call call;
        if (this.mShowSingleParty && (call = this.mSingleParty) != null) {
            return call.getNumber();
        }
        return G2.e.b(this.mTelecomCall);
    }

    public int getNumberPresentation() {
        android.telecom.Call call = this.mTelecomCall;
        if (call == null) {
            return -1;
        }
        return call.getDetails().getHandlePresentation();
    }

    public boolean getOplusClickToVoice() {
        return this.mOplusClickToVoice;
    }

    public float getOplusPeerVideoRatio() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getOplusPeerVideoRatio  = " + this.mOplusPeerVideoRatio);
        }
        return this.mOplusPeerVideoRatio;
    }

    public Call getParentCall() {
        android.telecom.Call parent = this.mTelecomCall.getParent();
        if (parent != null) {
            return CallList.getInstance().getCallByTelecommCall(parent);
        }
        return null;
    }

    public String getParentId() {
        Call callByTelecommCall;
        android.telecom.Call parent = this.mTelecomCall.getParent();
        if (parent != null && (callByTelecommCall = CallList.getInstance().getCallByTelecommCall(parent)) != null) {
            return callByTelecommCall.getId();
        }
        return null;
    }

    public int getPreVideoState() {
        return 0;
    }

    public int getRealCallStateFromTelecommCall() {
        int i10;
        android.telecom.Call call = this.mTelecomCall;
        if (call != null) {
            i10 = translateState(call.getState());
        } else {
            i10 = 0;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getRealCallStateFromTelecommCall id " + this.mId + " newState  = " + i10);
        }
        return i10;
    }

    public int getRecordStatus() {
        return this.mRecordStatus;
    }

    public int getRequestedVideoState() {
        InCallVideoCallCallback inCallVideoCallCallback = this.mVideoCallCallback;
        if (inCallVideoCallCallback != null) {
            return inCallVideoCallCallback.getRequestedVideoState();
        }
        return 0;
    }

    public int getSessionModificationState() {
        return this.mSessionModificationState;
    }

    public int getSlotId() {
        PhoneAccountHandle accountHandle = getAccountHandle();
        if (accountHandle == null || A2.d.c(accountHandle) == -1) {
            return -1;
        }
        return A2.d.c(accountHandle);
    }

    public int getState() {
        android.telecom.Call call = this.mTelecomCall;
        if (call != null && call.getParent() != null) {
            return 11;
        }
        return this.mState;
    }

    public int getSubId() {
        PhoneAccountHandle accountHandle = getAccountHandle();
        if (accountHandle == null || A2.d.d(accountHandle) == -1) {
            return -1;
        }
        return A2.d.d(accountHandle);
    }

    public android.telecom.Call getTelecommCall() {
        return this.mTelecomCall;
    }

    public String getTelecommCallId() {
        return this.mTelecommCallId;
    }

    public InCallService.VideoCall getVideoCall() {
        return this.mVideoCall;
    }

    public boolean getVideoPaused() {
        return false;
    }

    public VideoSettings getVideoSettings() {
        return this.mVideoSettings;
    }

    public int getVideoState() {
        int videoState = this.mTelecomCall.getDetails().getVideoState();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getVideoState videoState =" + videoState);
        }
        return videoState;
    }

    public boolean hasProperty(int i10) {
        return this.mTelecomCall.getDetails().hasProperty(i10);
    }

    public boolean isActive() {
        boolean z10;
        if (!isCdmaDialing() && this.mState == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "Call id " + this.mId + " isActive  = " + z10);
        }
        return z10;
    }

    public boolean isAnswerFail() {
        return this.mAnswerFail;
    }

    public boolean isCallSubjectSupported() {
        return this.mIsCallSubjectSupported;
    }

    public boolean isCdmaDialing() {
        return false;
    }

    public boolean isConferenceCall() {
        return hasProperty(1);
    }

    public boolean isDisconnectGuard() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isDisconnectGuard  bRet = " + this.mDisconnectGuard);
        }
        return this.mDisconnectGuard;
    }

    public boolean isEmergencyCall() {
        return this.mIsEmergencyCall;
    }

    public boolean isFakeAnswerState() {
        return false;
    }

    public boolean isIncoming() {
        if (this.mState == 4) {
            return true;
        }
        return false;
    }

    public boolean isNotShowInCallUIForIncoming() {
        return this.mNotShowInCallUIForIncoming;
    }

    public boolean isPickup() {
        return this.mPickup;
    }

    public boolean isSRVCCConference() {
        return false;
    }

    public boolean isShouldRingForContact() {
        return this.mShouldRingForContact;
    }

    public boolean isUsedToBeConferenceCall() {
        return this.mOplusUsedToBeConferenceCall;
    }

    public boolean isUsedToBeIMSChildCall() {
        if (getTelecommCallId() != null && !getTelecommCallId().startsWith("TC@") && !isUsedToBeConferenceCall()) {
            return true;
        }
        return false;
    }

    public boolean isVideoCall() {
        return CallUtils.isVideoCall(getVideoState());
    }

    public boolean isVipContact() {
        return false;
    }

    public boolean needTurnOnSpeaker() {
        boolean hasProperty = hasProperty(4194304);
        if (Log.sDebug) {
            Log.d(this, "needTurnOnSpeaker  bRet =  " + hasProperty);
        }
        return hasProperty;
    }

    public void notifyHandoverToWifiFailed() {
        Log.i("DialerCall.notifyHandoverToWifiFailed", "");
        Iterator<F1.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onHandoverToWifiFailure();
        }
    }

    public void notifyInternationalCallOnWifi() {
        Log.e(this, "DialerCall.notifyInternationalCallOnWifi");
        Iterator<F1.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onInternationalCallOnWifi();
        }
    }

    public void notifyWiFiToLteHandover() {
        Log.i("DialerCall.notifyWiFiToLteHandover", "");
        Iterator<F1.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onWiFiToLteHandover();
        }
    }

    public boolean oplusGetIsCallForwarded() {
        return this.mOplusIsCallForwarded;
    }

    public void oplusSetIsCallForwarded(boolean z10) {
        this.mOplusIsCallForwarded = z10;
    }

    public boolean originalCanSeparate() {
        return false;
    }

    public boolean placeCallInNavigation() {
        boolean hasProperty = hasProperty(OplusPhoneCapabilities.CAPABILITY_INVITE_PARTICIPANTS);
        if (Log.sDebug) {
            Log.d(this, "placeCallInNavigation  bRet =  " + hasProperty);
        }
        return hasProperty;
    }

    public void refreshUI() {
        boolean z10;
        boolean z11;
        Log.d(LOG_TAG, "refreshUI isRemotelyHeld = " + this.isRemotelyHeld);
        InCallPresenter inCallPresenter = InCallPresenter.getInstance();
        if (inCallPresenter != null && inCallPresenter.getActivity() != null && inCallPresenter.getActivity().getCallButtonFragment() != null) {
            OplusCallButtonFragment callButtonFragment = inCallPresenter.getActivity().getCallButtonFragment();
            boolean z12 = true;
            if (can(1) && OplusPhoneUtils.shouldEnableHoldButton(this)) {
                z10 = true;
            } else {
                z10 = false;
            }
            callButtonFragment.enableHold(z10);
            if (this.isRemotelyHeld) {
                callButtonFragment.enableChangeToVideo(false);
                callButtonFragment.enableButton(11, false);
                return;
            }
            if (OplusPhoneUtils.isOplusVideoCallEnableAndImsRegistered(getSlotId()) && getState() != 8 && !isConferenceCall()) {
                z11 = true;
            } else {
                z11 = false;
            }
            callButtonFragment.enableChangeToVideo(z11);
            if (getState() == 8 || isConferenceCall()) {
                z12 = false;
            }
            callButtonFragment.enableButton(11, z12);
        }
    }

    public void reject(boolean z10, String str) {
        Log.i("DialerCall.reject", "");
        this.mTelecomCall.reject(z10, str);
    }

    public void setAutoReplySms(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setAutoReplySms  autoReplySms = " + z10);
        }
        this.mOplusAutoReplySms = z10;
    }

    public void setAutoSpeaker(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setAutoSpeaker  autoSpeaker = " + z10);
        }
        this.mOplusAutoSpeaker = z10;
    }

    public void setDisconnectCause(DisconnectCause disconnectCause) {
        this.mDisconnectCause = disconnectCause;
        this.mLogState.disconnectCause = disconnectCause;
    }

    public void setIsAnswerFail(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setIsAnswerFail  fail = " + z10);
        }
        this.mAnswerFail = z10;
    }

    public void setIsVideoResume(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setIsVideoResume  isVideoResume = " + z10);
        }
        this.mOplusIsVideoResume = z10;
    }

    public void setIsVideoRingTone(boolean z10) {
        boolean z11;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setIsVideoRingTone  isVideoRingTone = " + z10 + " mOplusIsVideoRingTone = " + this.mOplusIsVideoRingTone);
        }
        if (z10 != this.mOplusIsVideoRingTone) {
            this.mOplusIsVideoRingTone = z10;
            if (State.isConnectingOrDialing(getState())) {
                f2.c cVar = f2.c.f31677a;
                if (TextUtils.equals(cVar.c().getValue(), getId())) {
                    com.android.incallui.mvvm.utils.h<Boolean> g10 = cVar.g();
                    if (this.mOplusIsVideoRingTone && VideoProfile.isReceptionEnabled(getVideoState())) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    g10.o(Boolean.valueOf(z11));
                }
            }
            InCallPresenter inCallPresenter = InCallPresenter.getInstance();
            if (inCallPresenter != null && inCallPresenter.getProximitySensor() != null) {
                InCallPresenter.getInstance().getProximitySensor().updateProximitySensorMode();
            }
            if (inCallPresenter != null && inCallPresenter.getActivity() != null && inCallPresenter.getActivity().getCallButtonFragment() != null) {
                inCallPresenter.getActivity().getCallButtonFragment().enableSwitchCamera(!this.mOplusIsVideoRingTone);
            }
        }
    }

    public void setModifyToVideoState(int i10) {
        this.mModifyToVideoState = i10;
    }

    public void setNotShowInCallUIForIncoming(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setNotShowInCallUIForIncoming  = " + z10);
        }
        this.mNotShowInCallUIForIncoming = z10;
    }

    public void setOplusClickToVoice(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setOplusClickToVoice = " + z10);
        }
        this.mOplusClickToVoice = z10;
    }

    public void setOplusPeerVideoRatio(int i10, int i11) {
        if (i11 > 0) {
            this.mOplusPeerVideoRatio = i10 / i11;
            if (Log.sDebug) {
                Log.d(LOG_TAG, "setOplusPeerVideoRatio  = " + this.mOplusPeerVideoRatio);
            }
        }
    }

    public void setPhoneAccountHandle(PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle != null) {
            this.mPhoneAccountHandle = phoneAccountHandle;
        }
    }

    public void setPickup(boolean z10) {
        this.mPickup = z10;
    }

    public void setRecordStatus(int i10) {
        this.mRecordStatus = i10;
    }

    public void setSessionModificationState(int i10) {
        if (i10 == 3) {
            Log.e(this, "setSessionModificationState not valid for RECEIVED_UPGRADE_TO_VIDEO_REQUEST");
            return;
        }
        boolean z10 = false;
        if (this.mSessionModificationState == 3) {
            InCallPresenter.getInstance().realInstance().dismissVideoUpgradeRequestDialog();
            setModifyToVideoState(0);
        }
        if (this.mSessionModificationState != i10) {
            z10 = true;
        }
        this.mSessionModificationState = i10;
        Log.d(this, "setSessionModificationState " + i10 + " mSessionModificationState=" + this.mSessionModificationState);
        if (z10) {
            if (R5.a.b() && i10 != 0 && getModifyToVideoState() != 0) {
                InCallPresenter.getInstance().onCallListChange(CallList.getInstance());
            }
            CallList.getInstance().onSessionModificationStateChange(this, i10);
        }
    }

    public void setSessionModificationTo(int i10) {
        Log.d(this, "setSessionModificationTo - video state= " + i10);
        if (i10 == getVideoState()) {
            this.mSessionModificationState = 0;
            Log.w(this, "setSessionModificationTo - Clearing session modification state");
        } else {
            this.mSessionModificationState = 3;
            if (!OplusFeatureOption.OPLUS_VERSION_EXP && ((OplusCallList) CallList.getInstance()).oplusGetCallSize() > 1) {
                InCallPresenter.getInstance().declineUpgradeRequest();
                return;
            } else {
                setModifyToVideoState(i10);
                CallList.getInstance().onUpgradeToVideo(this);
            }
        }
        Log.d(this, "setSessionModificationTo - mSessionModificationState=" + this.mSessionModificationState + " video state= " + i10);
        update();
    }

    public void setShouldRingForContact(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setShouldRingForContact  = " + z10);
        }
        this.mShouldRingForContact = z10;
    }

    public void setState(int i10) {
        this.mState = i10;
        if (i10 == 4) {
            this.mLogState.isIncoming = true;
            return;
        }
        if (i10 == 10) {
            LogState logState = this.mLogState;
            long j10 = 0;
            if (getConnectTimeMillis() != 0) {
                j10 = System.currentTimeMillis() - getConnectTimeMillis();
            }
            logState.duration = j10;
        }
    }

    public void setUsedToBeConferenceCall(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setUsedToBeConferenceCall  isConference = " + z10);
        }
        this.mOplusUsedToBeConferenceCall = z10;
    }

    public boolean shouldAutoRecord() {
        return false;
    }

    public boolean showSingleParty() {
        return this.mShowSingleParty;
    }

    public String toSimpleString() {
        return super.toString();
    }

    public String toString() {
        if (this.mTelecomCall == null) {
            return String.valueOf(this.mId);
        }
        return String.format(Locale.US, "[%s, %s, %s, %s, children:%s, parent:%s, conferenceable:%s, videoState:%s, CameraDir:%s]", this.mId, State.toString(getState()), Call.Details.capabilitiesToString(this.mTelecomCall.getDetails().getCallCapabilities()), Call.Details.propertiesToString(this.mTelecomCall.getDetails().getCallProperties()), this.mChildCallIds, getParentId(), this.mTelecomCall.getConferenceableCalls(), VideoProfile.videoStateToString(this.mTelecomCall.getDetails().getVideoState()), Integer.valueOf(getCameraDir()));
    }

    public void unhold() {
        Log.i("DialerCall.unhold", "");
        this.mTelecomCall.unhold();
    }

    public void update() {
        if (Log.sSystraceDebug) {
            Trace.beginSection("Update");
        }
        int state = getState();
        android.telecom.Call call = this.mTelecomCall;
        if (call == null) {
            Log.w(LOG_TAG, "update mTelecomCall  is null return ");
            return;
        }
        int state2 = call.getState();
        if (state == 13 && state2 == 8) {
            this.mIsCallChanged = false;
            Log.d(LOG_TAG, "update CONNECTING change to SELECT_PHONE_ACCOUNT is not valid return ");
            return;
        }
        if (state == 9 && state2 != 7) {
            this.mIsCallChanged = false;
            Log.d(LOG_TAG, "update DISCONNECTING change to other is not valid return ");
            return;
        }
        if (state == 10 && (state2 == 1 || state2 == 4)) {
            this.mIsCallChanged = false;
            Log.d(LOG_TAG, "update DISCONNECTED change to STATE_DIALING is not valid return ");
            return;
        }
        if (state == 2 && state2 == 1) {
            this.mIsCallChanged = false;
            Log.d(LOG_TAG, "update IDLE change to STATE_DIALING is not valid return ");
            return;
        }
        if (state == 2 && (state2 == 7 || state2 == 10)) {
            this.mIsCallChanged = false;
            Log.d(LOG_TAG, "update IDLE change to STATE_DISCONNECTED or STATE_DISCONNECTING is not valid return ");
            return;
        }
        updateFromTelecommCall();
        if (state != getState() && state == 6) {
            setIsVideoRingTone(false);
        }
        Log.d(LOG_TAG, "update mIsCallChanged: " + this.mIsCallChanged);
        if (state != getState() && getState() == 10) {
            CallList.getInstance().onDisconnect(this);
            this.mQtiImsInterfaceImpl.stopQtiImsInterface();
            setIsVideoRingTone(false);
        } else if (this.mIsCallChanged) {
            CallList.getInstance().onUpdate(this);
        }
        this.mIsCallChanged = false;
        if (this.rttStatusChange) {
            Iterator<F1.a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onDialerCallUpdate();
            }
            this.rttStatusChange = false;
        }
        if (Log.sSystraceDebug) {
            Trace.endSection();
        }
    }

    public void answer() {
        answer(this.mTelecomCall.getDetails().getVideoState());
    }

    public void copyContactInfoFromParty(Call call) {
    }

    public void onDestroy() {
    }

    public void oplusOnDetailsChanged(android.telecom.Call call) {
    }

    public void oplusUpdateFromTelecommCall() {
    }

    public void parseBundleData(Bundle bundle) {
    }

    public void setCallType(int i10) {
    }

    public void setFakeAnswerVideoState(int i10) {
    }

    public void setFakeState(int i10) {
    }

    public void setHasSRVCC(boolean z10) {
    }

    public void setInComingVideoPaused(boolean z10) {
    }

    public void setIsFakeGuard(boolean z10) {
    }

    public void setIsSRVCCConference(boolean z10) {
    }

    public void setIsSilence(boolean z10) {
    }

    public void setNotesGuid(String str) {
    }

    public void setVideoPaused(boolean z10) {
    }

    public Call(android.telecom.Call call) {
        this.mChildCallIds = new ArrayList();
        this.mListeners = new CopyOnWriteArrayList();
        this.mState = 0;
        this.mCameraDirection = -1;
        this.mIsActiveSub = false;
        this.mVideoSettings = new VideoSettings();
        this.mModifyToVideoState = 0;
        this.mOplusIsCallForwarded = false;
        this.mIsCallChanged = false;
        this.mOldChildCallIds = new ArrayList();
        this.mDisconnectGuard = false;
        this.mSetConnectingFirst = true;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mRealImpl = U5.a.a();
        this.mOplusClickToVoice = false;
        this.mOplusIsCdmaPhone = false;
        this.mOplusIsVideoRingTone = false;
        this.mOplusIsVideoResume = false;
        this.mOplusAutoSpeaker = false;
        this.mOplusAutoReplySms = false;
        this.mOplusVideoState = 0;
        this.mOplusUsedToBeConferenceCall = false;
        this.mOplusPeerVideoRatio = 0.0f;
        this.mShouldRingForContact = true;
        this.mNotShowInCallUIForIncoming = false;
        this.rttStatusChange = false;
        this.mTelecomCallCallback = new AnonymousClass1();
        this.mLogState = new LogState();
        this.mQtiImsInterfaceImpl = new QtiImsInterfaceImpl();
        this.mQtiImsInterfaceListener = new QtiImsExtListenerBaseImpl() { // from class: com.android.incallui.Call.2
            @Override // org.codeaurora.ims.QtiImsExtListenerBaseImpl, org.codeaurora.ims.internal.IQtiImsExtListener
            public void receiveCallTransferResponse(int i11, int i12) {
                Log.w(this, "receiveCallTransferResponse: " + i12);
            }
        };
        this.mPickup = false;
        this.mAnswerFail = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.android.incallui.Call.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1000) {
                    if (Log.sDebug) {
                        Log.d(Call.LOG_TAG, "MSG_RESET_DISCONNECT_GUARD message received...");
                    }
                    Call call2 = Call.this;
                    call2.mDisconnectGuard = false;
                    if (call2.getState() == 9) {
                        if (Log.sDebug) {
                            Log.d(Call.LOG_TAG, "should to hang up call");
                        }
                        android.telecom.Call telecommCall = Call.this.getTelecommCall();
                        if (telecommCall != null) {
                            telecommCall.disconnect();
                            return;
                        }
                        Log.e(this, "error disconnectCall, diconnectCall is null " + Call.this.getId());
                    }
                }
            }
        };
        this.mRecordStatus = 0;
        this.mCall = this;
        this.mTelecomCall = call;
        StringBuilder sb = new StringBuilder();
        sb.append(ID_PREFIX);
        int i10 = sIdCounter;
        sIdCounter = i10 + 1;
        sb.append(Integer.toString(i10));
        this.mId = sb.toString();
        this.mContext = InCallPresenter.getInstance().getContext();
        this.mOplusVideoState = getVideoState();
        updateFromTelecommCall();
        this.mTelecomCall.registerCallback(this.mTelecomCallCallback);
        AddOnSdkDepends.getSInstance().setincommingRingtoneListener(new IncommingRingtoneListener() { // from class: com.android.incallui.d
            @Override // com.internal_dependency.IncommingRingtoneListener
            public final void onCallInfoupdate(int i11, int i12) {
                Call.this.lambda$new$1(i11, i12);
            }
        });
    }

    public void oplusOnStateChanged(android.telecom.Call call, int i10) {
    }

    public void setCallLabledata(int i10, int i11) {
    }

    public void updatePlaceCallContactInfo(String str, String str2, boolean z10) {
    }
}
