package com.android.incallui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.telecom.Call;
import android.view.accessibility.AccessibilityManager;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.InCallPresenter;
import java.lang.ref.WeakReference;
import m2.C1327a;

/* loaded from: classes.dex */
public class CallCardPresenter extends Presenter<CallCardUi> implements InCallPresenter.InCallStateListener, InCallPresenter.IncomingCallListener, InCallPresenter.InCallDetailsListener, InCallPresenter.InCallEventListener, CallList.CallUpdateListener {
    private static final String TAG = "CallCardPresenter";
    private Context mContext;
    private Call mPrimary;
    private ContactInfoCache.ContactCacheEntry mPrimaryContactInfo;
    private Call mSecondary;
    private ContactInfoCache.ContactCacheEntry mSecondaryContactInfo;
    private final EmergencyCallListener mEmergencyCallListener = H2.a.a();
    private boolean mSpinnerShowing = false;

    /* loaded from: classes.dex */
    public static class ContactLookupCallback implements ContactInfoCache.ContactInfoCacheCallback {
        private final WeakReference<CallCardPresenter> mCallCardPresenter;
        private final boolean mIsPrimary;

        public ContactLookupCallback(CallCardPresenter callCardPresenter, boolean z10) {
            this.mCallCardPresenter = new WeakReference<>(callCardPresenter);
            this.mIsPrimary = z10;
        }

        @Override // com.android.incallui.ContactInfoCache.ContactInfoCacheCallback
        public void onContactInfoComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
            CallCardPresenter callCardPresenter = this.mCallCardPresenter.get();
            if (callCardPresenter != null) {
                callCardPresenter.onContactInfoComplete(str, contactCacheEntry, this.mIsPrimary);
            }
        }

        @Override // com.android.incallui.ContactInfoCache.ContactInfoCacheCallback
        public void onImageLoadComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
            CallCardPresenter callCardPresenter = this.mCallCardPresenter.get();
            if (callCardPresenter != null) {
                callCardPresenter.onImageLoadComplete(str, contactCacheEntry);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface EmergencyCallListener {
        void onCallUpdated(BaseFragment baseFragment, boolean z10);
    }

    private Call getCallToDisplay(CallList callList, Call call, boolean z10) {
        Call activeCall = callList.getActiveCall();
        if (activeCall != null && activeCall != call) {
            return activeCall;
        }
        if (!z10) {
            Call disconnectingCall = callList.getDisconnectingCall();
            if (disconnectingCall != null && disconnectingCall != call) {
                return disconnectingCall;
            }
            Call disconnectedCall = callList.getDisconnectedCall();
            if (disconnectedCall != null && disconnectedCall != call) {
                return disconnectedCall;
            }
        }
        Call backgroundCall = callList.getBackgroundCall();
        if (backgroundCall != null && backgroundCall != call) {
            return backgroundCall;
        }
        return callList.getSecondBackgroundCall();
    }

    private String getNumberFromHandle(Uri uri) {
        if (uri == null) {
            return "";
        }
        return uri.getSchemeSpecificPart();
    }

    private boolean isPrimaryCallActive() {
        Call call = this.mPrimary;
        if (call != null && call.getState() == 3) {
            return true;
        }
        return false;
    }

    private void maybeSendAccessibilityEvent(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2) {
        InCallPresenter.InCallState inCallState3;
        Context context = this.mContext;
        if (context == null || !((AccessibilityManager) context.getSystemService("accessibility")).isEnabled()) {
            return;
        }
        InCallPresenter.InCallState inCallState4 = InCallPresenter.InCallState.OUTGOING;
        if (((inCallState != inCallState4 && inCallState2 == inCallState4) || (inCallState != (inCallState3 = InCallPresenter.InCallState.INCOMING) && inCallState2 == inCallState3)) && getUi() != null) {
            getUi().sendAccessibilityAnnouncement();
        }
    }

    private void maybeShowManageConferenceCallButton() {
        getUi().showManageConferenceCallButton(shouldShowManageConference());
    }

    private void maybeShowProgressSpinner(int i10, int i11) {
        boolean z10 = true;
        if (i11 != 1 || i10 != 3) {
            z10 = false;
        }
        if (z10 != this.mSpinnerShowing) {
            getUi().setProgressSpinnerVisible(z10);
            this.mSpinnerShowing = z10;
        }
    }

    private boolean shouldShowEndCallButton(Call call, int i10) {
        if (call == null) {
            return false;
        }
        if ((!Call.State.isConnectingOrConnected(i10) && i10 != 9) || i10 == 4 || this.mPrimary.getSessionModificationState() == 3) {
            return false;
        }
        return true;
    }

    private boolean shouldShowManageConference() {
        Call call = this.mPrimary;
        if (call == null) {
            return false;
        }
        return call.can(128);
    }

    private void updateContactEntry(ContactInfoCache.ContactCacheEntry contactCacheEntry, boolean z10) {
        if (z10) {
            this.mPrimaryContactInfo = contactCacheEntry;
            updatePrimaryDisplayInfo();
        } else {
            this.mSecondaryContactInfo = contactCacheEntry;
            updateSecondaryDisplayInfo();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updatePrimaryDisplayInfo() {
        CallCardUi ui = getUi();
        if (ui == 0) {
            Log.d(TAG, "updatePrimaryDisplayInfo called but ui is null!");
            return;
        }
        Call call = this.mPrimary;
        if (call == null) {
            ui.setPrimary(new m2.b());
            return;
        }
        if (!call.showSingleParty() && this.mPrimary.isConferenceCall()) {
            Log.d(TAG, "Update primary display info for conference call.");
            ui.setPrimary(new m2.b());
        } else if (this.mPrimaryContactInfo != null) {
            Log.d(TAG, "Update primary display info for " + this.mPrimaryContactInfo);
            ui.setPrimary(new m2.b());
        } else {
            ui.setPrimary(new m2.b());
        }
        if (this.mEmergencyCallListener != null) {
            this.mEmergencyCallListener.onCallUpdated((BaseFragment) ui, OplusPhoneUtils.isEmergencyNumber(getNumberFromHandle(this.mPrimary.getHandle())));
        }
    }

    private void updateSecondaryDisplayInfo() {
        CallCardUi ui = getUi();
        if (ui == null) {
            return;
        }
        Call call = this.mSecondary;
        if (call == null) {
            ui.setSecondary(new m2.c());
            return;
        }
        if (!call.showSingleParty() && this.mSecondary.isConferenceCall()) {
            ui.setSecondary(new m2.c());
            return;
        }
        if (this.mSecondaryContactInfo != null) {
            Log.d(TAG, "updateSecondaryDisplayInfo() " + this.mSecondaryContactInfo);
            ui.setSecondary(new m2.c());
            return;
        }
        ui.setSecondary(new m2.c());
    }

    public void init(Context context, Call call) {
        boolean z10;
        this.mContext = (Context) com.google.common.base.k.o(context);
        if (call != null) {
            this.mPrimary = call;
            CallList.getInstance().addCallUpdateListener(call.getId(), this);
            if (call.isConferenceCall() && !call.showSingleParty()) {
                updateContactEntry(null, true);
            } else {
                if (call.getState() == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                startContactInfoSearch(call, true, z10);
            }
        }
        onStateChange(null, InCallPresenter.getInstance().getInCallState(), CallList.getInstance());
    }

    public void maybeStartSearch(Call call, boolean z10) {
        boolean z11;
        if (call != null) {
            if (!call.isConferenceCall() || call.showSingleParty()) {
                if (call.getState() == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                startContactInfoSearch(call, z10, z11);
            }
        }
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onChildNumberChange() {
        Log.v(this, "onChildNumberChange");
        if (this.mPrimary == null) {
            return;
        }
        updatePrimaryDisplayInfo();
    }

    public void onContactInfoComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry, boolean z10) {
        updateContactEntry(contactCacheEntry, z10);
    }

    @Override // com.android.incallui.InCallPresenter.InCallDetailsListener
    public void onDetailsChanged(Call call, Call.Details details) {
        updatePrimaryCallState();
        if (call.can(128) != Call.Details.can(details.getCallCapabilities(), 128)) {
            maybeShowManageConferenceCallButton();
        }
    }

    @Override // com.android.incallui.InCallPresenter.InCallEventListener
    public void onFullscreenModeChanged(boolean z10) {
        CallCardUi ui = getUi();
        if (ui == null) {
            return;
        }
        ui.setCallCardVisible(!z10);
        ui.setSecondaryInfoVisible(!z10);
    }

    public void onImageLoadComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        Call call;
        if (getUi() != null && contactCacheEntry.photo != null && (call = this.mPrimary) != null && str.equals(call.getId())) {
            getUi().setPrimaryImage(contactCacheEntry.photo, !VideoCallPresenter.showIncomingVideo(this.mPrimary.getVideoState(), this.mPrimary.getState(), this.mPrimary));
        }
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        onStateChange(inCallState, inCallState2, CallList.getInstance());
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onLastForwardedNumberChange() {
        Log.v(this, "onLastForwardedNumberChange");
        if (this.mPrimary == null) {
            return;
        }
        updatePrimaryDisplayInfo();
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onSessionModificationStateChange(Call call, int i10) {
        boolean z10;
        Log.d(this, "onSessionModificationStateChange : sessionModificationState = " + i10);
        Call call2 = this.mPrimary;
        if (call2 == null) {
            return;
        }
        maybeShowProgressSpinner(call2.getState(), i10);
        CallCardUi ui = getUi();
        if (i10 != 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        ui.setEndCallButtonEnabled(z10, true);
        updatePrimaryCallState();
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        Call outgoingCall;
        Call callToDisplay;
        Call call;
        Call call2;
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        boolean z13;
        Log.d(this, "onStateChange() " + inCallState2);
        CallCardUi ui = getUi();
        if (ui == null) {
            return;
        }
        boolean z14 = true;
        if (inCallState2 == InCallPresenter.InCallState.INCOMING) {
            call2 = callList.getIncomingCall();
            call = null;
        } else {
            if (inCallState2 != InCallPresenter.InCallState.PENDING_OUTGOING && inCallState2 != InCallPresenter.InCallState.OUTGOING) {
                if (inCallState2 == InCallPresenter.InCallState.INCALL) {
                    outgoingCall = getCallToDisplay(callList, null, false);
                    callToDisplay = getCallToDisplay(callList, outgoingCall, true);
                } else {
                    call2 = null;
                    call = null;
                }
            } else {
                outgoingCall = callList.getOutgoingCall();
                if (outgoingCall == null) {
                    outgoingCall = callList.getPendingOutgoingCall();
                }
                callToDisplay = getCallToDisplay(callList, null, true);
            }
            Call call3 = outgoingCall;
            call = callToDisplay;
            call2 = call3;
        }
        Log.d(this, "Primary call: " + call2);
        Log.d(this, "Secondary call: " + call);
        if (Call.areSame(this.mPrimary, call2) && Call.areSameNumber(this.mPrimary, call2)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (Call.areSame(this.mSecondary, call) && Call.areSameNumber(this.mSecondary, call)) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.mSecondary = call;
        Call call4 = this.mPrimary;
        this.mPrimary = call2;
        if (call2 != null && (z10 || ui.isManageConferenceVisible() != shouldShowManageConference())) {
            if (call4 != null) {
                maybeShowProgressSpinner(call4.getState(), 0);
                CallList.getInstance().removeCallUpdateListener(call4.getId(), this);
            }
            CallList.getInstance().addCallUpdateListener(this.mPrimary.getId(), this);
            Context context = this.mContext;
            Call call5 = this.mPrimary;
            if (call5.getState() == 4) {
                z13 = true;
            } else {
                z13 = false;
            }
            this.mPrimaryContactInfo = ContactInfoCache.buildCacheEntryFromCall(context, call5, z13);
            updatePrimaryDisplayInfo();
            maybeStartSearch(this.mPrimary, true);
            this.mPrimary.setSessionModificationState(0);
        }
        if (call4 != null && this.mPrimary == null) {
            maybeShowProgressSpinner(call4.getState(), 0);
            CallList.getInstance().removeCallUpdateListener(call4.getId(), this);
        }
        Call call6 = this.mSecondary;
        if (call6 == null) {
            this.mSecondaryContactInfo = null;
            updateSecondaryDisplayInfo();
        } else if (z11) {
            Context context2 = this.mContext;
            if (call6.getState() == 4) {
                z12 = true;
            } else {
                z12 = false;
            }
            this.mSecondaryContactInfo = ContactInfoCache.buildCacheEntryFromCall(context2, call6, z12);
            updateSecondaryDisplayInfo();
            maybeStartSearch(this.mSecondary, false);
            this.mSecondary.setSessionModificationState(0);
        }
        if (!isPrimaryCallActive()) {
            Log.d(this, "Canceling the calltime timer");
            ui.setPrimaryCallElapsedTime(false, 0L);
        }
        Call call7 = this.mPrimary;
        if (call7 != null) {
            i10 = call7.getState();
            updatePrimaryCallState();
        } else {
            getUi().setCallState(new C1327a());
            i10 = 2;
        }
        maybeShowManageConferenceCallButton();
        CallCardUi ui2 = getUi();
        boolean shouldShowEndCallButton = shouldShowEndCallButton(this.mPrimary, i10);
        if (i10 == 4) {
            z14 = false;
        }
        ui2.setEndCallButtonEnabled(shouldShowEndCallButton, z14);
        maybeSendAccessibilityEvent(inCallState, inCallState2);
    }

    public void secondaryInfoClicked() {
        if (this.mSecondary == null) {
            Log.w(this, "Secondary info clicked but no secondary call.");
            return;
        }
        Log.i(this, "Swapping call to foreground: " + this.mSecondary);
        TelecomAdapter.getInstance().unholdCall(this.mSecondary.getId());
    }

    public void startContactInfoSearch(Call call, boolean z10, boolean z11) {
        ContactInfoCache.getInstance(this.mContext).findInfo(call, z11, new ContactLookupCallback(this, z10));
    }

    public void updatePrimaryCallState() {
        getUi().setCallState(new C1327a());
    }

    @Override // com.android.incallui.Presenter
    public void onUiReady(CallCardUi callCardUi) {
        super.onUiReady((CallCardPresenter) callCardUi);
        if (this.mPrimaryContactInfo != null) {
            updatePrimaryDisplayInfo();
        }
        InCallPresenter.getInstance().addListener(this);
        InCallPresenter.getInstance().addIncomingCallListener(this);
        InCallPresenter.getInstance().addDetailsListener(this);
        InCallPresenter.getInstance().addInCallEventListener(this);
    }

    @Override // com.android.incallui.Presenter
    public void onUiUnready(CallCardUi callCardUi) {
        super.onUiUnready((CallCardPresenter) callCardUi);
        InCallPresenter.getInstance().removeListener(this);
        InCallPresenter.getInstance().removeIncomingCallListener(this);
        InCallPresenter.getInstance().removeDetailsListener(this);
        InCallPresenter.getInstance().removeInCallEventListener(this);
        if (this.mPrimary != null) {
            CallList.getInstance().removeCallUpdateListener(this.mPrimary.getId(), this);
        }
        this.mPrimary = null;
        this.mPrimaryContactInfo = null;
        this.mSecondaryContactInfo = null;
    }

    /* loaded from: classes.dex */
    public interface CallCardUi extends Ui {
        void displayManageConferencePanel(boolean z10);

        boolean isManageConferenceVisible();

        void sendAccessibilityAnnouncement();

        void setCallCardVisible(boolean z10);

        void setCallState(C1327a c1327a);

        void setDialpad(boolean z10);

        void setEndCallButtonEnabled(boolean z10, boolean z11);

        void setPrimary(m2.b bVar);

        void setPrimaryCallElapsedTime(boolean z10, long j10);

        void setPrimaryCallElapsedTime(boolean z10, String str, String str2);

        void setPrimaryImage(Drawable drawable, boolean z10);

        void setProgressSpinnerVisible(boolean z10);

        void setSecondary(m2.c cVar);

        void setSecondaryConnectionLabel(String str);

        void setSecondaryInfoVisible(boolean z10);

        @Override // com.android.incallui.Ui
        void setVisible(boolean z10);

        void showManageConferenceCallButton(boolean z10);

        void updateCallStatusPrompt(String str);

        void updateCallStatusPrompt(String str, long j10);

        void updateSecondaryIcon(boolean z10);

        default void showLocationUi() {
        }
    }

    public void manageConferenceButtonClicked() {
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onCallChanged(Call call) {
    }

    @Override // com.android.incallui.InCallPresenter.InCallEventListener
    public void onSecondaryCallerInfoVisibilityChanged(boolean z10, int i10) {
    }
}
