package j2;

import D2.l;
import android.content.Context;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.android.incallui.Call;
import com.android.incallui.CallButtonPresenter;
import com.android.incallui.CallList;
import com.android.incallui.Log;
import com.android.incallui.OplusCall;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.oplus.callbutton.callbuttonview.InCallButtonItem;
import com.android.oplus.brand.BrandCenter;
import java.util.HashMap;
import java.util.Iterator;
import k2.c;
import k2.e;
import k2.f;
import l2.C1289a;

/* compiled from: CallButtonController.java */
/* renamed from: j2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1159a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f33843a;

    /* renamed from: c, reason: collision with root package name */
    public C1289a f33845c;

    /* renamed from: d, reason: collision with root package name */
    public RecyclerView f33846d;

    /* renamed from: e, reason: collision with root package name */
    public Context f33847e;

    /* renamed from: f, reason: collision with root package name */
    public CallButtonPresenter f33848f;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<Integer, Integer> f33844b = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public SparseArray<e> f33849g = new SparseArray<>(b.f33851f);

    /* renamed from: h, reason: collision with root package name */
    public Q5.b f33850h = Q5.a.a();

    public C1159a(Context context, RecyclerView recyclerView, CallButtonPresenter callButtonPresenter, C1289a c1289a) {
        this.f33846d = recyclerView;
        this.f33847e = context;
        this.f33848f = callButtonPresenter;
        this.f33845c = c1289a;
    }

    public final void A(boolean z10) {
        e eVar = this.f33849g.get(10);
        if (z10) {
            if (eVar == null) {
                e m10 = m(10);
                if (m10 == null) {
                    return;
                }
                z(m10);
                this.f33849g.put(10, m10);
                return;
            }
            z(eVar);
            eVar.setVisible(true);
            return;
        }
        if (eVar != null) {
            eVar.setVisible(false);
        }
    }

    public final void B(e eVar) {
        if (OplusPhoneUtils.changeToVowifiIcon(CallList.getInstance().getFirstCall(), CallList.getInstance().getActiveSubId())) {
            eVar.l(R.drawable.incall_btn_vowifi_change_to_voice);
            eVar.m(R.drawable.incall_btn_vowifi_change_to_voice_selected);
        } else {
            eVar.l(R.drawable.incall_btn_change_to_voice);
            eVar.m(R.drawable.incall_btn_change_to_voice_selected);
        }
    }

    public final void C(boolean z10) {
        e eVar = this.f33849g.get(11);
        if (z10) {
            if (eVar == null) {
                e m10 = m(11);
                if (m10 == null) {
                    return;
                }
                B(m10);
                this.f33849g.put(11, m10);
                return;
            }
            B(eVar);
            eVar.setVisible(true);
            return;
        }
        if (eVar != null) {
            eVar.setVisible(false);
        }
    }

    public final void D(e eVar) {
        eVar.o(true);
        eVar.h(0.3f);
    }

    public void E(boolean z10) {
        s(3, z10);
    }

    public final void F(boolean z10) {
        Log.d("CallButtonController", "setHoldSwapButtonVis, show:" + z10 + ", mPresenter.shouldShowSwapButton():" + this.f33848f.shouldShowSwapButton());
        if (z10) {
            if (this.f33848f.shouldShowSwapButton()) {
                P(4, true);
                P(3, false);
                return;
            } else {
                P(4, false);
                P(3, true);
                return;
            }
        }
        P(4, false);
        P(3, false);
    }

    public final void G(boolean z10) {
        this.f33843a = z10;
        Log.d("CallButtonController", "setIsFirstRefreshRecyclerView, isFirstRefresh: " + z10);
    }

    public final void H(boolean z10) {
        if (z10) {
            P(7, true);
            P(6, false);
        } else {
            P(7, false);
            P(6, true);
        }
    }

    public void I(boolean z10) {
        e h10 = h(8);
        if (h10 != null) {
            h10.a(z10);
        }
    }

    public final void J() {
        if (OplusPhoneUtils.isNeedHideRecord(this.f33847e)) {
            if (OplusPhoneUtils.isNeedShowTransferButton(this.f33847e)) {
                P(2, true);
                P(1, false);
            } else {
                P(2, false);
                P(1, true);
            }
            P(0, false);
        } else {
            P(2, false);
            P(1, false);
            P(0, true);
        }
        A(true);
        c(false);
        P(9, false);
        C(false);
        P(5, false);
    }

    public final void K() {
        if (c.u() != null && c.u().getIsVideoCall()) {
            P(13, false);
        } else if (OplusPhoneUtils.isNotesInstalled(this.f33847e.getApplicationContext())) {
            P(13, true);
        } else {
            P(13, false);
        }
    }

    public final void L(boolean z10) {
        s(0, z10);
    }

    public final void M() {
        P(12, O());
    }

    public void N(boolean z10) {
        String string;
        InCallButtonItem i10 = i(5, false);
        e h10 = h(5);
        if (h10 == null) {
            return;
        }
        h10.a(z10);
        if (z10) {
            string = this.f33847e.getResources().getString(R.string.camera_on_description);
        } else {
            string = this.f33847e.getResources().getString(R.string.camera_off_description);
        }
        h10.c(string);
        if (i10 != null) {
            i10.setText(h10.n());
        }
    }

    public final boolean O() {
        Call currentCall = this.f33848f.getCurrentCall();
        Log.i("CallButtonController", "isShowRtt call: " + currentCall);
        if (currentCall == null) {
            return false;
        }
        boolean isRttFeatureOn = OplusPhoneUtils.isRttFeatureOn();
        boolean b10 = R5.a.b();
        if (currentCall.isConferenceCall()) {
            return false;
        }
        if (((OplusCall) currentCall).isRttCall()) {
            return true;
        }
        if (isRttFeatureOn && b10 && currentCall.isEmergencyCall()) {
            return true;
        }
        if (isRttFeatureOn && OplusPhoneUtils.isRttSettingOn(this.f33847e)) {
            return true;
        }
        if (!b10 || !currentCall.isEmergencyCall() || l.h(this.f33847e) || !OplusPhoneUtils.isRttSettingOn(this.f33847e)) {
            return false;
        }
        return true;
    }

    public final void P(int i10, boolean z10) {
        e eVar = this.f33849g.get(i10);
        if (z10) {
            w(eVar, i10);
        } else {
            u(eVar);
        }
    }

    public void Q(boolean z10, boolean z11) {
        H(z10);
        if (!z10) {
            this.f33848f.getUi().enableAddCall(z11);
        }
        p();
    }

    public void R() {
        int i10;
        Q5.b a10 = Q5.a.a();
        boolean z10 = false;
        if (a10 != null) {
            i10 = a10.getState();
        } else {
            i10 = 0;
        }
        if (Log.sDebug) {
            Log.d("CallButtonController", "updateRecordButton ...status = " + i10);
        }
        if (i10 != 0) {
            z10 = true;
        }
        L(z10);
        S();
    }

    public void S() {
        String h10;
        int i10 = 0;
        InCallButtonItem i11 = i(0, false);
        e h11 = h(0);
        if (h11 == null) {
            return;
        }
        Q5.b bVar = this.f33850h;
        if (bVar != null) {
            i10 = bVar.getState();
        }
        Q5.b bVar2 = this.f33850h;
        String str = "";
        if (bVar2 == null) {
            h10 = "";
        } else {
            h10 = bVar2.h();
        }
        if (i10 == 2 && !TextUtils.isEmpty(h10)) {
            h11.c(h10);
            Q5.b bVar3 = this.f33850h;
            if (bVar3 != null) {
                str = bVar3.f();
            }
            h11.j(str);
        } else if (i10 == 1) {
            h11.c(this.f33847e.getResources().getString(R.string.oplus_audio_record_ready));
        } else {
            h11.c(this.f33847e.getResources().getString(R.string.oplus_record));
        }
        if (i11 != null) {
            i11.setText(h11.n());
            if (!TextUtils.isEmpty(h11.k())) {
                i11.setContentDescription(h11.k());
            }
        }
    }

    public void T(boolean z10) {
        F(z10);
        p();
    }

    public void a() {
        this.f33849g.clear();
        G(false);
    }

    public void b(int i10, boolean z10) {
        e eVar = this.f33849g.get(i10);
        if (eVar != null) {
            InCallButtonItem i11 = i(i10, false);
            if (i11 != null) {
                i11.setEnabled(z10);
            }
            eVar.setEnabled(z10);
        }
    }

    public void c(boolean z10) {
        if (!OplusFeatureOption.OPLUS_VERSION_EXP && ((OplusCallList) CallList.getInstance()).oplusGetCallSize() > 1) {
            z10 = false;
        }
        b(10, z10);
        if (OplusPhoneUtils.isNeedHideVideoCallButton()) {
            if (!z10) {
                A(false);
            } else if (c.u() != null && !c.u().getIsVideoCall()) {
                A(true);
            }
        }
    }

    public final void d(boolean z10) {
        boolean z11;
        Call currentCall = this.f33848f.getCurrentCall();
        if (currentCall == null) {
            return;
        }
        if (l(currentCall) && (currentCall.can(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE) || currentCall.isEmergencyCall())) {
            z11 = true;
        } else {
            z11 = false;
        }
        b(12, z11);
    }

    public void e(boolean z10) {
        if (z10 && (!OplusPhoneUtils.isDeviceProvisioned(this.f33847e.getApplicationContext()) || !OplusPhoneUtils.isUserUnlocked(this.f33847e))) {
            z10 = false;
        }
        b(0, z10);
    }

    public final void f(int i10, boolean z10, boolean z11) {
        G(true);
        this.f33845c.h();
        int i11 = 0;
        for (int i12 = 0; i12 < b.f33851f; i12++) {
            if (k(this.f33849g.get(i12))) {
                t(z11, z10, i12);
                if (i11 < i10) {
                    this.f33844b.put(Integer.valueOf(i12), Integer.valueOf(i11));
                    this.f33845c.g(this.f33849g.get(i12));
                }
                i11++;
            }
        }
        this.f33845c.notifyDataSetChanged();
        Log.d("CallButtonController", "refreshButtonsState，firstRefreshRecyclerView");
    }

    public int g() {
        return 6;
    }

    public e h(int i10) {
        return this.f33849g.get(i10);
    }

    public InCallButtonItem i(int i10, boolean z10) {
        int intValue;
        if (!this.f33844b.containsKey(Integer.valueOf(i10)) || this.f33846d == null || (intValue = this.f33844b.get(Integer.valueOf(i10)).intValue()) < 0 || intValue >= this.f33846d.getChildCount()) {
            return null;
        }
        InCallButtonItem inCallButtonItem = (InCallButtonItem) this.f33846d.getChildAt(intValue);
        if (inCallButtonItem != null && i10 != inCallButtonItem.getId() && !z10) {
            return null;
        }
        return inCallButtonItem;
    }

    public final boolean j(Call call) {
        if (call == null) {
            return false;
        }
        int g10 = l.g(this.f33847e, call.getSubId());
        Log.i("CallButtonPresenter.is23GVoiceNetwork", "is23GVoiceNetwork  " + g10);
        switch (g10) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            case 13:
            default:
                return false;
        }
    }

    public final boolean k(e eVar) {
        if (eVar != null && eVar.isVisible()) {
            return true;
        }
        return false;
    }

    public final boolean l(Call call) {
        if (call == null) {
            return false;
        }
        boolean shouldShowRttUi = OplusPhoneUtils.shouldShowRttUi(this.f33847e);
        if (call.isConferenceCall() || ((OplusCall) call).isRttCall()) {
            return false;
        }
        if (shouldShowRttUi && Call.State.isActiveOrHold(call.getState()) && l.j(this.f33847e)) {
            return true;
        }
        if (shouldShowRttUi && call.isEmergencyCall() && j(call)) {
            return true;
        }
        if (!call.isEmergencyCall() || !Call.State.isActiveOrHold(call.getState()) || l.h(this.f33847e) || !R5.a.b() || !OplusPhoneUtils.isRttSettingOn(this.f33847e)) {
            return false;
        }
        return true;
    }

    public final e m(int i10) {
        e a10 = f.a(i10, this.f33847e);
        if (a10 != null) {
            a10.setVisible(true);
        }
        return a10;
    }

    public final void n(e eVar, int i10) {
        if (this.f33845c.i() != null) {
            Iterator<e> it = this.f33845c.i().iterator();
            while (it.hasNext()) {
                if (it.next().f() == eVar.f()) {
                    Log.d("CallButtonController", "list already has this button");
                    return;
                }
            }
            this.f33845c.i().add(eVar);
            this.f33845c.notifyItemInserted(i10);
        }
    }

    public void o(boolean z10) {
        CallButtonPresenter callButtonPresenter = this.f33848f;
        if (callButtonPresenter == null) {
            return;
        }
        callButtonPresenter.muteClicked(z10);
    }

    public void p() {
        boolean z10;
        RecyclerView recyclerView;
        int g10 = g();
        boolean z11 = false;
        if (c.u() != null && c.u().getIsVideoCall()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f33848f.getCurrentCall() != null && Call.State.isConnectingOrDialing(this.f33848f.getCurrentCall().getState())) {
            z11 = true;
        }
        if (this.f33843a && (recyclerView = this.f33846d) != null && recyclerView.getChildCount() != 0) {
            r(g10);
        } else {
            f(g10, z10, z11);
        }
    }

    public void q(Call call) {
        boolean z10 = false;
        if (R5.a.b() ? !(call == null || !call.can(4) || !BrandCenter.f19187a.a().i()) : !(call == null || !call.can(4))) {
            z10 = true;
        }
        H(z10);
        P(8, true);
        if (c.u() != null && c.u().getIsVideoCall()) {
            v(call);
        } else if (OplusPhoneUtils.isOplusVideoCallEnableAndImsRegistered(SubscriptionManager.getSlotIndex(CallList.getInstance().getActiveSubId()))) {
            Log.d("CallButtonController", "refreshCallButtonsVisibility, support video call");
            F(true);
            x(call);
        } else {
            Log.d("CallButtonController", "refreshCallButtonsVisibility, not support video call");
            F(true);
            J();
        }
        K();
        M();
        p();
    }

    public final void r(int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < b.f33851f; i12++) {
            e eVar = this.f33849g.get(i12);
            if (k(eVar)) {
                if (i11 < i10) {
                    Log.d("CallButtonController", "refreshByGetButton, buttonId = " + i12);
                    this.f33844b.put(Integer.valueOf(i12), Integer.valueOf(i11));
                    InCallButtonItem i13 = i(i12, true);
                    if (i13 != null) {
                        i13.a(eVar);
                    } else if (i11 >= this.f33846d.getChildCount()) {
                        n(eVar, i11);
                    }
                }
                i11++;
            } else {
                InCallButtonItem i14 = i(i12, false);
                if (i14 != null) {
                    i14.setVisibility(8);
                }
                this.f33844b.remove(Integer.valueOf(i12));
            }
        }
    }

    public void s(int i10, boolean z10) {
        e h10 = h(i10);
        if (h10 != null) {
            h10.a(z10);
        }
    }

    public final void t(boolean z10, boolean z11, int i10) {
        e eVar = this.f33849g.get(i10);
        if (z10) {
            if (i10 == 6 || i10 == 3 || i10 == 8) {
                D(eVar);
            }
            if (z11) {
                if (i10 == 5 || i10 == 11) {
                    D(eVar);
                    return;
                }
                return;
            }
            if (i10 == 10) {
                D(eVar);
            }
        }
    }

    public final void u(e eVar) {
        if (eVar != null) {
            eVar.setVisible(false);
        }
    }

    public final void v(Call call) {
        Log.d("CallButtonController", "refreshCallButtonsVisibility, video call");
        A(false);
        C(true);
        P(9, true);
        if (OplusPhoneUtils.isNeedHideRecord(this.f33847e)) {
            P(0, false);
            P(5, true);
            if (OplusPhoneUtils.isNeedShowVideoCallHold(this.f33847e, call)) {
                F(true);
                P(2, false);
                P(1, false);
                return;
            } else if (OplusPhoneUtils.isNeedShowTransferButton(this.f33847e)) {
                F(false);
                P(2, true);
                P(1, false);
                return;
            } else {
                F(false);
                P(2, false);
                P(1, true);
                return;
            }
        }
        P(0, true);
        if (OplusPhoneUtils.isNeedShowVideoCallHold(this.f33847e, call)) {
            F(true);
            P(5, false);
        } else {
            F(false);
            P(5, true);
        }
        P(2, false);
        P(1, false);
    }

    public final void w(e eVar, int i10) {
        if (eVar == null) {
            e m10 = m(i10);
            if (m10 == null) {
                return;
            }
            this.f33849g.put(i10, m10);
            return;
        }
        eVar.setVisible(true);
    }

    public final void x(Call call) {
        boolean z10 = true;
        if (OplusPhoneUtils.isNeedHideRecord(this.f33847e)) {
            if (OplusPhoneUtils.isNeedShowTransferButton(this.f33847e)) {
                P(2, true);
                P(1, false);
            } else {
                P(2, false);
                P(1, true);
            }
            P(0, false);
        } else {
            P(2, false);
            P(1, false);
            P(0, true);
        }
        A(true);
        if (call == null || !call.isActive() || call.isConferenceCall() || call.getSessionModificationState() == 1 || call.getIsRemotelyHeld()) {
            z10 = false;
        }
        c(z10);
        C(false);
        P(9, false);
        P(5, false);
    }

    public void y(boolean z10) {
        b(8, z10);
        b(7, z10);
        Log.d("CallButtonController", "setButtonsEnable " + z10);
        if (!z10) {
            b(6, false);
        }
        boolean z11 = true;
        if (z10) {
            b(1, !OplusPhoneUtils.isDeviceRestricted(this.f33847e));
        } else {
            b(1, false);
        }
        e(z10);
        b(2, z10);
        if (!OplusPhoneUtils.isDeviceProvisioned(this.f33847e.getApplicationContext())) {
            if (Log.sDebug) {
                Log.d("CallButtonController", "is in provisioned...");
            }
            b(1, false);
            b(3, false);
            b(6, false);
            b(7, false);
        }
        if (OplusPhoneUtils.isDeviceRestricted(this.f33847e) || !OplusPhoneUtils.isNotesInstalled(this.f33847e.getApplicationContext()) || OplusPhoneUtils.isBreathMode(this.f33847e)) {
            z11 = false;
        }
        b(13, z11);
        d(z10);
        if (!OplusPhoneUtils.isUserUnlocked(this.f33847e)) {
            b(6, false);
        }
    }

    public final void z(e eVar) {
        if (OplusPhoneUtils.changeToVowifiIcon(CallList.getInstance().getFirstCall(), CallList.getInstance().getActiveSubId())) {
            eVar.l(R.drawable.incall_btn_vowifi_change_to_video);
            eVar.m(R.drawable.incall_btn_vowifi_change_to_video_selected);
        } else {
            eVar.l(R.drawable.incall_btn_change_to_video);
            eVar.m(R.drawable.incall_btn_change_to_video_selected);
        }
    }
}
