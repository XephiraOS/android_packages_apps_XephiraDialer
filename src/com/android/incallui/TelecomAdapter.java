package com.android.incallui;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Looper;
import android.telecom.InCallService;
import android.telecom.PhoneAccountHandle;
import com.android.oplus.module.castScreen.CastScreen;
import java.util.List;

/* loaded from: classes.dex */
public class TelecomAdapter implements InCallServiceListener {
    public static final String ADD_CALL_MODE_KEY = "add_call_mode";
    public static final String ADD_PARTICIPANT_KEY = "add_participant";
    private static TelecomAdapter sInstance;
    protected InCallService mInCallService;

    public static TelecomAdapter getInstance() {
        boolean z10;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.u(z10);
        if (sInstance == null) {
            sInstance = new OplusTelecomAdapter();
        }
        return sInstance;
    }

    public void addCall() {
        if (this.mInCallService != null) {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            intent.putExtra(ADD_CALL_MODE_KEY, true);
            intent.putExtra(OplusCallButtonFragment.START_FROM_INCALLUI_BUTTON, true);
            OplusPhoneUtils.dismissKeyguard();
            intent.setPackage(ConfigurationConstants.getContactsPackageName());
            try {
                Log.d(this, "Sending the add Call intent");
                this.mInCallService.startActivity(intent);
            } catch (Exception e10) {
                Log.e(this, "Activity for adding calls isn't found.", e10);
            }
        }
    }

    public void answerCall(String str, int i10) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        Call callById = CallList.getInstance().getCallById(str);
        if (i10 == 0 && callById != null) {
            callById.setOplusClickToVoice(true);
        }
        if (telecommCallById != null) {
            telecommCallById.answer(i10);
            return;
        }
        Log.e(this, "error answerCall, call not in call list: " + str);
    }

    public boolean canAddCall() {
        InCallService inCallService = this.mInCallService;
        if (inCallService == null) {
            return true;
        }
        return inCallService.canAddCall();
    }

    @Override // com.android.incallui.InCallServiceListener
    public void clearInCallService() {
        this.mInCallService = null;
    }

    public void disconnectCall(String str) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            telecommCallById.disconnect();
            return;
        }
        Log.e(this, "error disconnectCall, call not in call list " + str);
    }

    public android.telecom.Call getTelecommCallById(String str) {
        Call callById = CallList.getInstance().getCallById(str);
        if (callById == null) {
            return null;
        }
        return callById.getTelecommCall();
    }

    public void holdCall(String str) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            telecommCallById.hold();
            return;
        }
        Log.e(this, "error holdCall, call not in call list " + str);
    }

    public void merge(String str) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            List<android.telecom.Call> conferenceableCalls = telecommCallById.getConferenceableCalls();
            if (!conferenceableCalls.isEmpty()) {
                telecommCallById.conference(conferenceableCalls.get(0));
                return;
            } else {
                if (telecommCallById.getDetails().can(4)) {
                    telecommCallById.mergeConference();
                    return;
                }
                return;
            }
        }
        Log.e(this, "error merge, call not in call list " + str);
    }

    public void mute(boolean z10) {
        if (this.mInCallService != null) {
            AudioModeProvider.getInstance().setFakeMute(z10);
            this.mInCallService.setMuted(z10);
            CastScreen.f19196a.a().setMute(z10);
            return;
        }
        Log.e(this, "error mute, mInCallService is null");
    }

    public OplusTelecomAdapter oplusTelecomAdapter() {
        return (OplusTelecomAdapter) sInstance;
    }

    public void phoneAccountSelected(String str, PhoneAccountHandle phoneAccountHandle, boolean z10) {
        if (phoneAccountHandle == null) {
            Log.e(this, "error phoneAccountSelected, accountHandle is null");
        }
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            telecommCallById.phoneAccountSelected(phoneAccountHandle, z10);
            return;
        }
        Log.e(this, "error phoneAccountSelected, call not in call list " + str);
    }

    public void playDtmfTone(String str, char c10) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            telecommCallById.playDtmfTone(c10);
            return;
        }
        Log.e(this, "error playDtmfTone, call not in call list " + str);
    }

    public void postDialContinue(String str, boolean z10) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            telecommCallById.postDialContinue(z10);
            return;
        }
        Log.e(this, "error postDialContinue, call not in call list " + str);
    }

    public void rejectCall(String str, boolean z10, String str2) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            telecommCallById.reject(z10, str2);
            return;
        }
        Log.e(this, "error rejectCall, call not in call list: " + str);
    }

    public void requestBluetoothAudio(BluetoothDevice bluetoothDevice) {
        InCallService inCallService = this.mInCallService;
        if (inCallService != null) {
            inCallService.requestBluetoothAudio(bluetoothDevice);
            CastScreen.f19196a.a().a(0);
        } else {
            Log.e(this, "error requestBluetoothAudio, mInCallService is null");
        }
    }

    public void separateCall(String str) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            telecommCallById.splitFromConference();
            return;
        }
        Log.e(this, "error separateCall, call not in call list " + str);
    }

    public void setAudioRoute(int i10) {
        InCallService inCallService = this.mInCallService;
        if (inCallService != null) {
            inCallService.setAudioRoute(i10);
        } else {
            Log.e(this, "error setAudioRoute, mInCallService is null");
        }
    }

    public void setAudioRouteToTelecom(int i10) {
        InCallService inCallService = this.mInCallService;
        if (inCallService != null) {
            inCallService.setAudioRoute(i10);
        } else {
            Log.e(this, "error setAudioRoute, mInCallService is null");
        }
    }

    @Override // com.android.incallui.InCallServiceListener
    public void setInCallService(InCallService inCallService) {
        this.mInCallService = inCallService;
    }

    public void stopDtmfTone(String str) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            telecommCallById.stopDtmfTone();
            return;
        }
        Log.e(this, "error stopDtmfTone, call not in call list " + str);
    }

    public void swap(String str) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            if (telecommCallById.getDetails().can(8)) {
                telecommCallById.swapConference();
            }
        } else {
            Log.e(this, "error swap, call not in call list " + str);
        }
    }

    public void unholdCall(String str) {
        android.telecom.Call telecommCallById = getTelecommCallById(str);
        if (telecommCallById != null) {
            telecommCallById.unhold();
            return;
        }
        Log.e(this, "error unholdCall, call not in call list " + str);
    }
}
