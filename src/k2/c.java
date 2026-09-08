package k2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusAnimationUtils;
import com.android.incallui.OplusCall;
import com.android.incallui.OplusCallButtonFragment;
import com.android.incallui.OplusCallButtonPresenter;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.QtiCallUtils;
import com.android.incallui.R;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.oplus.callbutton.callbuttonview.InCallButtonItem;
import com.android.oplus.brand.BrandCenter;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import j2.C1159a;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import k2.c;

/* compiled from: BaseCallButton.java */
/* loaded from: classes.dex */
public abstract class c implements k2.e {

    /* renamed from: m, reason: collision with root package name */
    public static final Handler f34072m = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public final int f34073a;

    /* renamed from: b, reason: collision with root package name */
    public String f34074b;

    /* renamed from: c, reason: collision with root package name */
    public int f34075c;

    /* renamed from: d, reason: collision with root package name */
    public String f34076d;

    /* renamed from: e, reason: collision with root package name */
    public final C8.b<Boolean> f34077e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f34078f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f34079g;

    /* renamed from: h, reason: collision with root package name */
    public Context f34080h;

    /* renamed from: i, reason: collision with root package name */
    public int f34081i;

    /* renamed from: j, reason: collision with root package name */
    public float f34082j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f34083k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f34084l;

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class a extends c {
        public a(Context context) {
            super(context, context.getResources().getString(R.string.oplus_addcall), 6, R.drawable.incall_btn_add_call, R.drawable.incall_btn_add_call_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            InCallPresenter.InCallState inCallState = InCallPresenter.getInstance().getInCallState();
            HashMap hashMap = new HashMap();
            hashMap.put("CLICK_ADD_CALL_BUTTON", String.valueOf(inCallState));
            OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_DIAL_AND_SCREEN, OplusPhoneUserActionStatistics.CLICK_ADD_CALL_BUTTON, hashMap);
            c.u().getPresenter().addCallClicked();
            OplusAnimationUtils.playActivityAnimationUpDownEnter(c.u().getActivity());
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class b extends c {
        public b(Context context) {
            super(context, context.getResources().getString(R.string.card_title_video_call), 10, R.drawable.incall_btn_change_to_video, R.drawable.incall_btn_change_to_video_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_CLICK_CHANGE_TO_VIDEO_WHEN_CALL, (Map) null);
            if (OplusPhoneUtils.isUstOplusExport()) {
                QtiCallUtils.displayModifyCallOptions(CallList.getInstance().getFirstCall(), context);
                return true;
            }
            c.u().getPresenter().changeToVideoClicked();
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* renamed from: k2.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0321c extends c {
        public C0321c(Context context) {
            super(context, context.getResources().getString(R.string.notification_action_answer_voice), 11, R.drawable.incall_btn_change_to_voice, R.drawable.incall_btn_change_to_voice_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_CLICK_CHANGE_TO_AUDIO_WHEN_CALL, (Map) null);
            c.u().getPresenter().changeToVideoClicked();
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class d extends c {
        public d(Context context) {
            super(context, context.getResources().getString(R.string.camera_off_description), 5, R.drawable.incall_btn_close_camera, R.drawable.incall_btn_close_camera_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            c.u().getPresenter().pauseVideoClicked(!isSelected());
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class e extends c {
        public e(Context context) {
            super(context, context.getResources().getString(R.string.oplus_contacts), 1, R.drawable.incall_btn_contacts, R.drawable.incall_btn_contacts_selected);
        }

        public static void z(Context context) {
            try {
                Intent intent = new Intent(OplusPhoneUtils.CONTACTS_ACTION);
                intent.setType("vnd.android.cursor.dir/contact");
                intent.addFlags(67108864);
                intent.putExtra(OplusCallButtonFragment.START_FROM_INCALLUI_BUTTON, true);
                context.startActivity(intent);
            } catch (Exception e10) {
                if (Log.sDebug) {
                    Log.d("BaseCallButton", "go to contacts has exception!");
                }
                Log.d("BaseCallButton", "Exception: " + e10.toString());
            }
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            InCallPresenter.InCallState inCallState = InCallPresenter.getInstance().getInCallState();
            HashMap hashMap = new HashMap();
            hashMap.put("CLICK_DIALER_BUTTON", String.valueOf(inCallState));
            OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_DIAL_AND_SCREEN, OplusPhoneUserActionStatistics.CLICK_DIALER_BUTTON, hashMap);
            z(context);
            OplusAnimationUtils.playActivityAnimationUpDownEnter(c.u().getActivity());
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class f extends c {
        public f(Context context) {
            super(context, context.getResources().getString(R.string.oplus_hold), 3, R.drawable.incall_btn_hold_call, R.drawable.incall_btn_hold_call_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            if (c.u().getPresenter().holdClicked(!isSelected())) {
                x(!isSelected());
            }
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class g extends c {
        public g(Context context) {
            super(context, context.getResources().getString(R.string.oplus_merge), 7, R.drawable.incall_btn_merge_call, R.drawable.incall_btn_merge_call_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            if (!isVisible()) {
                Log.d("BaseCallButton", "mMergeButton click return for it is not visible now!");
                return false;
            }
            Log.d("BaseCallButton", "MergeButton click!!!");
            c.u().getPresenter().mergeClicked();
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class h extends c {
        public h(Context context) {
            super(context, context.getResources().getString(R.string.oplus_mute), 8, R.drawable.incall_btn_mute_call, R.drawable.incall_btn_mute_call_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (Log.sDebug) {
                Log.d("BaseCallButton", "MuteButton click!!!");
            }
            if (!super.i(context)) {
                return false;
            }
            HashMap hashMap = new HashMap();
            c.u().onMuteClicked(!isSelected());
            hashMap.put("CLICK_MUTE_BUTTON", String.valueOf(isSelected()));
            hashMap.put("VIDEO_CALL", String.valueOf(c.u().getIsVideoCall()));
            OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_DIAL_AND_SCREEN, OplusPhoneUserActionStatistics.CLICK_MUTE_BUTTON, hashMap);
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class i extends c {
        public i(Context context) {
            super(context, context.getResources().getString(R.string.oplus_notes), 13, R.drawable.incall_btn_notes, R.drawable.incall_btn_notes_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (Log.sDebug) {
                Log.d("BaseCallButton", "NotesButton click!!!");
            }
            if (!super.i(context)) {
                return false;
            }
            InCallPresenter.InCallState inCallState = InCallPresenter.getInstance().getInCallState();
            HashMap hashMap = new HashMap();
            hashMap.put("CLICK_NOTES_BUTTON", String.valueOf(inCallState));
            OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_DIAL_AND_SCREEN, OplusPhoneUserActionStatistics.CLICK_NOTES_BUTTON, hashMap);
            z();
            return true;
        }

        public final void z() {
            if (!isEnabled()) {
                if (!OplusPhoneUtils.isDeviceRestricted(this.f34080h)) {
                    Toast.makeText(this.f34080h, R.string.oplus_toast_notes_disabled_tips, 0).show();
                    return;
                } else {
                    Log.i("BaseCallButton", "onNotesClick, notes disabled, do nothing.");
                    return;
                }
            }
            OplusCall oplusCall = (OplusCall) CallList.getInstance().getFirstCall();
            if (oplusCall == null) {
                Log.i("BaseCallButton", "currentCall is null, return");
                return;
            }
            if (OplusPhoneUtils.isScreenLocked(this.f34080h)) {
                OplusPhoneUtils.dismissKeyguard();
            }
            Context context = this.f34080h;
            OplusPhoneUtils.startSafeActivity(context, D2.c.d(context, oplusCall, true));
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class k extends c {
        public k(Context context) {
            super(context, BrandCenter.f19187a.a().e(context), 12, R.drawable.incall_btn_rtt, R.drawable.incall_btn_rtt_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            ((OplusCallButtonPresenter) c.u().getPresenter()).changeToRttClicked();
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class l extends c {
        public l(Context context) {
            super(context, context.getResources().getString(R.string.onscreenSwapCallsText), 4, R.drawable.incall_btn_swap_call, R.drawable.incall_btn_swap_call_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            c.u().getPresenter().swapClicked();
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class m extends c {

        /* renamed from: n, reason: collision with root package name */
        public boolean f34087n;

        /* renamed from: o, reason: collision with root package name */
        public Runnable f34088o;

        public m(Context context) {
            super(context, context.getResources().getString(R.string.oplus_switch_camera), 9, R.drawable.incall_btn_switch_camera, R.drawable.incall_btn_switch_camera_selected);
            this.f34087n = true;
            this.f34088o = new Runnable() { // from class: k2.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.m.this.A();
                }
            };
        }

        public final /* synthetic */ void A() {
            this.f34087n = true;
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            if (!this.f34087n) {
                Log.d("BaseCallButton", "switch camera not done");
                return true;
            }
            this.f34087n = false;
            c.f34072m.postDelayed(this.f34088o, 700L);
            OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_SWITCH_CAMERE_WHEN_CALL, (Map) null);
            if (InCallPresenter.getInstance().getInCallCameraManager() != null) {
                c.u().getPresenter().switchCameraClicked(!r5.isUsingFrontFacingCamera());
            }
            return true;
        }
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class n extends c {
        public n(Context context) {
            super(context, context.getResources().getString(R.string.oplus_ect), 2, R.drawable.incall_btn_transfer_call, R.drawable.incall_btn_transfer_call_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            if (!super.i(context)) {
                return false;
            }
            c.u().getPresenter().explicitCallTransfer();
            return true;
        }
    }

    public c(Context context, String str, int i10, int i11, int i12) {
        C8.b<Boolean> bVar = new C8.b<>(Boolean.FALSE, 10000L, f34072m);
        this.f34077e = bVar;
        this.f34074b = str;
        this.f34073a = i10;
        this.f34075c = i11;
        this.f34080h = context;
        this.f34081i = i12;
        bVar.addObserver(new Observer() { // from class: k2.a
            @Override // java.util.Observer
            public final void update(Observable observable, Object obj) {
                c.this.v(observable, obj);
            }
        });
    }

    public static OplusCallButtonFragment u() {
        OplusInCallPresenter realInstance;
        InCallPresenter inCallPresenter = InCallPresenter.getInstance();
        if (inCallPresenter != null && (realInstance = inCallPresenter.realInstance()) != null && realInstance.getActivity() != null) {
            return realInstance.getActivity().getCallButtonFragment();
        }
        return null;
    }

    public static void y(c cVar, final boolean z10) {
        C1159a buttonController;
        OplusCallButtonFragment u10 = u();
        if (u10 == null || (buttonController = u10.getButtonController()) == null) {
            return;
        }
        int i10 = 0;
        final InCallButtonItem i11 = buttonController.i(cVar.f(), false);
        if (i11 == null) {
            return;
        }
        if (!z10) {
            i10 = 50;
        }
        f34072m.postDelayed(new Runnable() { // from class: k2.b
            @Override // java.lang.Runnable
            public final void run() {
                InCallButtonItem.this.setSelected(z10);
            }
        }, i10);
    }

    @Override // k2.e
    public void a(boolean z10) {
        this.f34077e.e(Boolean.valueOf(z10));
    }

    @Override // k2.e
    public int b() {
        return this.f34075c;
    }

    @Override // k2.e
    public void c(String str) {
        this.f34074b = str;
    }

    @Override // k2.e
    public boolean d() {
        return this.f34084l;
    }

    @Override // k2.e
    public void e(boolean z10) {
        this.f34084l = z10;
    }

    @Override // k2.e
    public int f() {
        return this.f34073a;
    }

    @Override // k2.e
    public float g() {
        return this.f34082j;
    }

    @Override // k2.e
    public void h(float f10) {
        this.f34082j = f10;
    }

    @Override // k2.e
    public boolean i(Context context) {
        if (u() == null) {
            return false;
        }
        if (InCallPresenter.getInstance() != null && InCallPresenter.getInstance().getVideoCallPresenter() != null) {
            if (u().getIsVideoCall() || InCallPresenter.getInstance().getVideoCallPresenter().isIsRingToneMode()) {
                InCallPresenter.getInstance().getVideoCallPresenter().doAutoToggleFullScreen();
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // k2.e
    public boolean isEnabled() {
        return this.f34078f;
    }

    @Override // k2.e
    public boolean isSelected() {
        return this.f34077e.b().booleanValue();
    }

    @Override // k2.e
    public boolean isVisible() {
        return this.f34079g;
    }

    @Override // k2.e
    public void j(String str) {
        this.f34076d = str;
    }

    @Override // k2.e
    public String k() {
        return this.f34076d;
    }

    @Override // k2.e
    public void l(int i10) {
        this.f34075c = i10;
    }

    @Override // k2.e
    public void m(int i10) {
        this.f34081i = i10;
    }

    @Override // k2.e
    public String n() {
        return this.f34074b;
    }

    @Override // k2.e
    public void o(boolean z10) {
        this.f34083k = z10;
    }

    @Override // k2.e
    public boolean p() {
        return this.f34083k;
    }

    @Override // k2.e
    public int q() {
        return this.f34081i;
    }

    @Override // k2.e
    public void setEnabled(boolean z10) {
        this.f34078f = z10;
    }

    @Override // k2.e
    public void setVisible(boolean z10) {
        this.f34079g = z10;
    }

    public final /* synthetic */ void v(Observable observable, Object obj) {
        y(this, ((Boolean) obj).booleanValue());
    }

    public void x(boolean z10) {
        this.f34077e.d(Boolean.valueOf(z10));
    }

    /* compiled from: BaseCallButton.java */
    /* loaded from: classes.dex */
    public static class j extends c {

        /* compiled from: BaseCallButton.java */
        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                OplusPhoneUtils.putUserSwitchRoute(5);
                TelecomAdapter.getInstance().setAudioRoute(5);
                if (Q5.a.a() != null && Q5.a.a().b()) {
                    j.this.x(!r0.isSelected());
                }
            }
        }

        public j(Context context) {
            super(context, context.getResources().getString(R.string.oplus_record), 0, R.drawable.incall_btn_record_call, R.drawable.incall_btn_record_call_selected);
        }

        @Override // k2.c, k2.e
        public boolean i(Context context) {
            Log.d("BaseCallButton", "onRecordClick");
            if (!super.i(context)) {
                return false;
            }
            if (OplusFeatureOption.VERSION_STORE && n2.n.b(context, OplusPhoneUtils.OPLUS_CALL_RECORDER_APK_PACKAGE)) {
                n2.n.d(context, 5);
                return false;
            }
            if (OplusPhoneUtils.shouldShowPcRecordDialog(AudioModeProvider.getInstance().getAudioMode())) {
                new COUIAlertDialogBuilder(context).setMessage(R.string.start_record_when_audio_mode_pc_dialog_message).setTitle(R.string.start_record_when_audio_mode_pc_dialog_title).setPositiveButton(R.string.start_record_when_audio_mode_pc_dialog_ok, (DialogInterface.OnClickListener) new b()).setNegativeButton(R.string.start_record_when_audio_mode_pc_dialog_cancel, (DialogInterface.OnClickListener) new a()).create().show();
                return true;
            }
            if (Q5.a.a() != null && Q5.a.a().b()) {
                x(!isSelected());
            }
            return true;
        }

        /* compiled from: BaseCallButton.java */
        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
            }
        }
    }
}
