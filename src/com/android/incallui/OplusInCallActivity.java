package com.android.incallui;

import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Insets;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telecom.DisconnectCause;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.android.incallui.InCallPresenter;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.usecase.VideoBackgroundUseCase;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;
import com.android.oplus.brand.BrandCenter;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import java.util.Map;
import y2.C1702a;

/* loaded from: classes.dex */
public class OplusInCallActivity extends InCallActivity {
    private static final String ACTION_STATE_CHANGED = "android.bluetooth.adapter.action.STATE_CHANGED";
    public static final int C12 = 201392708;
    private static final int DELAY_FOR_GO_TO_SLEEP = 100;
    private static final int DIALOG_RECORD_STORAGE_FULL = 1001;
    private static final int DIALOG_VIDEO_UPGRADE_REQUEST = 1000;
    private static final int KEYCODE_GESTURE_LEFT = 218;
    private static final int KEYCODE_GESTURE_RIGHT = 217;
    protected static final String LOG_TAG = "OplusInCallActivity";
    protected static final int OPLUS_DELAY_TO_GO_TO_SLEEP = 800;
    protected static final int OPLUS_DELAY_TO_INCALLSCREEN_STATE_CHANGE = 200;
    protected static final int OPLUS_DELAY_TO_TURN_ON_SPEAKER = 300;
    protected static final int OPLUS_MSG_DELAY_TO_GO_TO_SLEEP = 104;
    protected static final int OPLUS_MSG_DELAY_TO_TURN_ON_SPEAKER = 103;
    protected static final int OPLUS_MSG_INCALLSCREEN_STATE_CHANGE = 100;
    private static final String OPLUS_SMART_APPERCEIVE_GESTURE_ANSWER = "oplus_smart_apperceive_gesture_answer";
    public E2.d mCurvedDisplayView;
    private KeyguardManager mKeyguardManager;
    private int mRecordStorageFullResId;
    private UiModeManager mUiModeManager;
    protected boolean mFirstStartActivity = false;
    protected final BroadcastReceiver mOplusReceiver = new OplusInCallAppBroadcastReceiver();
    private boolean mIsOnSaveInstanceState = false;
    protected Handler mHandler = new Handler(Looper.myLooper()) { // from class: com.android.incallui.OplusInCallActivity.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 100) {
                if (i10 != 103) {
                    if (i10 != 104) {
                        Log.wtf(OplusInCallActivity.LOG_TAG, "mHandler: unexpected message: " + message);
                        return;
                    }
                    if (Log.sDebug) {
                        Log.d(OplusInCallActivity.LOG_TAG, "OPLUS_MSG_DELAY_TO_GO_TO_SLEEP");
                    }
                    OplusPhoneUtils.lockScreenIfNeeded(OplusInCallActivity.this.getApplicationContext());
                    return;
                }
                if (OplusInCallActivity.this.mInCallFragmentManager.c() != null) {
                    OplusInCallActivity.this.mInCallFragmentManager.c().getPresenter().toggleSpeakerphone();
                    return;
                }
                return;
            }
            OplusPhoneUtils.sendBroadcastInCallActivityState(OplusInCallActivity.this.getApplicationContext(), ((Boolean) message.obj).booleanValue());
            OplusInCallActivity oplusInCallActivity = OplusInCallActivity.this;
            if (!oplusInCallActivity.mIsForegroundActivity && oplusInCallActivity.mInCallFragmentManager.c() != null) {
                ((OplusInCallViewModel) new androidx.lifecycle.K(OplusInCallActivity.this).a(OplusInCallViewModel.class)).k().o(Boolean.FALSE);
            }
        }
    };

    /* loaded from: classes.dex */
    public class OplusInCallAppBroadcastReceiver extends BroadcastReceiver {
        public OplusInCallAppBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(OplusInCallActivity.LOG_TAG, "OplusInCallAppBroadcastReceiver action = " + action);
            if (action.equals("oplus_action_infrafed_pick_up")) {
                if (Log.sDebug) {
                    Log.d(OplusInCallActivity.LOG_TAG, "oplus_action_infrafed_pick_up");
                }
                OplusInCallActivity.this.answerCallByInfrared();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(Integer num) {
        updateRequestedOrientation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1() {
        this.mInCallFragmentManager.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPostResume$2() {
        this.mInCallFragmentManager.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStop$3() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "DELAY_FOR_GO_TO_SLEEP");
        }
        OplusPhoneUtils.lockScreenIfNeeded(getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSmsResponseList$4(Intent intent) {
        Log.d(LOG_TAG, "intent.getAction():" + intent.getAction() + "  getAnswerFragment():" + getAnswerFragment());
        if (getAnswerFragment() != null && intent.getAction() == "oplus.intent.action.SHOW_RESPONSE_SMS") {
            getAnswerFragment().onShowSmsListView();
        }
    }

    private void refreshBackground() {
        int i10;
        if (OplusPhoneUtils.getPhoneScreenLockState(this)) {
            i10 = 0;
        } else {
            i10 = R.anim.oplus_rounded_corners_anim_fade_in_fast;
        }
        overridePendingTransition(i10, R.anim.oplus_rounded_corners_anim_fade_out_fast);
    }

    private void showSmsResponseList(final Intent intent) {
        if (intent == null) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.android.incallui.O
            @Override // java.lang.Runnable
            public final void run() {
                OplusInCallActivity.this.lambda$showSmsResponseList$4(intent);
            }
        });
    }

    private void turnOnSpeakerByGesture() {
        int audioMode = AudioModeProvider.getInstance().getAudioMode();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "turnOnSpeakerByGesture() mode = " + audioMode);
        }
        if (this.mInCallFragmentManager.c() != null && audioMode == D2.a.f420a) {
            this.mHandler.removeMessages(103);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(103), 300L);
        }
    }

    private void updateRequestedOrientation() {
        Log.d(LOG_TAG, "updateRequestedOrientation: ");
        if (L1.c.f()) {
            setRequestedOrientation(5);
        } else {
            if (ResponsiveConfigRepository.f18540a.F1()) {
                if (!OplusFeatureOption.FEATURE_FOLD_REMAP_DISPLAY_DISABLED) {
                    setRequestedOrientation(2);
                    return;
                }
                return;
            }
            setRequestedOrientation(5);
        }
    }

    public void answerCallByInfrared() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "infrared switch = " + OplusFeatureOption.OPLUS_INFRARED_GESTURE_SUPPORT);
        }
        if (OplusFeatureOption.OPLUS_INFRARED_GESTURE_SUPPORT && InCallPresenter.getInstance().mInCallState == InCallPresenter.InCallState.INCOMING) {
            if (this.mInCallFragmentManager.i() != null) {
                this.mInCallFragmentManager.i().onAnswer(0, this, 0);
            }
            turnOnSpeakerByGesture();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        com.android.incallui.Log.d(com.android.incallui.OplusInCallActivity.LOG_TAG, " hasRingingCall = " + r1 + "gestureAnswerOn = " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
    
        if (r1 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        if (r3 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
    
        if (r7.mInCallFragmentManager.i() == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        r7.mInCallFragmentManager.i().onAnswer(0, r7, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        turnOnSpeakerByGesture();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        if (com.internal_dependency.SettingsUtils.INSTANCE.getSystemSettingsInt(getContentResolver(), com.android.incallui.OplusInCallActivity.OPLUS_SMART_APPERCEIVE_GESTURE_ANSWER, 0) == 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        if (com.android.incallui.Log.sDebug == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void answerGestureRingingCall() {
        /*
            r7 = this;
            java.lang.String r0 = "OplusInCallActivity"
            com.android.incallui.InCallPresenter r1 = com.android.incallui.InCallPresenter.getInstance()
            com.android.incallui.InCallPresenter$InCallState r1 = r1.mInCallState
            com.android.incallui.InCallPresenter$InCallState r2 = com.android.incallui.InCallPresenter.InCallState.INCOMING
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L10
            r1 = r3
            goto L11
        L10:
            r1 = r4
        L11:
            com.internal_dependency.SettingsUtils r2 = com.internal_dependency.SettingsUtils.INSTANCE     // Catch: java.lang.Exception -> L20
            android.content.ContentResolver r5 = r7.getContentResolver()     // Catch: java.lang.Exception -> L20
            java.lang.String r6 = "oplus_smart_apperceive_gesture_answer"
            int r2 = r2.getSystemSettingsInt(r5, r6, r4)     // Catch: java.lang.Exception -> L20
            if (r2 != r3) goto L29
            goto L2a
        L20:
            boolean r2 = com.android.incallui.Log.sDebug
            if (r2 == 0) goto L29
            java.lang.String r2 = "gestureAnswerOn is not found"
            com.android.incallui.Log.d(r0, r2)
        L29:
            r3 = r4
        L2a:
            boolean r2 = com.android.incallui.Log.sDebug
            if (r2 == 0) goto L4a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = " hasRingingCall = "
            r2.append(r5)
            r2.append(r1)
            java.lang.String r5 = "gestureAnswerOn = "
            r2.append(r5)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.android.incallui.Log.d(r0, r2)
        L4a:
            if (r1 == 0) goto L62
            if (r3 == 0) goto L62
            b2.a r0 = r7.mInCallFragmentManager
            com.android.incallui.OplusAnswerFragment r0 = r0.i()
            if (r0 == 0) goto L5f
            b2.a r0 = r7.mInCallFragmentManager
            com.android.incallui.OplusAnswerFragment r0 = r0.i()
            r0.onAnswer(r4, r7, r4)
        L5f:
            r7.turnOnSpeakerByGesture()
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.OplusInCallActivity.answerGestureRingingCall():void");
    }

    public void dismissVideoUpgradeRequestDialog() {
        try {
            if (OplusPhoneUtils.isUstOplusExport()) {
                BrandCenter.f19187a.a().d().D();
            } else {
                dismissDialog(1000);
            }
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // com.android.incallui.InCallActivity, android.app.Activity
    public void finish() {
        super.finish();
        boolean z10 = !CallList.getInstance().hasAnyLiveCall();
        if (z10 || CallList.getInstance().getIncomingCall() != null) {
            overridePendingTransition(R.anim.oplus_rounded_corners_anim_fade_in_fast_pause, R.anim.oplus_rounded_corners_anim_fade_out_fast_pause);
        }
        if (z10) {
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(104), 800L);
            dissmissPostCharDialog();
            if (i2.c.f(this)) {
                OplusPhoneUserActionStatistics.onCommon(this, OplusPhoneUserActionStatistics.TAG_AUTO_RECORD, OplusPhoneUserActionStatistics.EVENT_SHOW_RECORD_PROMPT, (Map) null);
                OplusPhoneUtils.startOplusInCallDialogActivity(this, 2);
            }
        }
        if (this.mInCallFragmentManager.l() != null) {
            this.mInCallFragmentManager.l().e1();
        }
    }

    @Override // com.android.incallui.InCallActivity
    public void internalResolveIntent(Intent intent) {
        V5.b foldScreenController;
        super.internalResolveIntent(intent);
        if (intent.hasExtra(InCallActivity.LAUNCH_FROM_NOTIFICATION_EXTRA) || intent.hasExtra(InCallActivity.NEW_OUTGOING_CALL)) {
            boolean a10 = D2.d.a(intent, InCallActivity.LAUNCH_FROM_NOTIFICATION_EXTRA, false);
            boolean a11 = D2.d.a(intent, InCallActivity.NEW_OUTGOING_CALL, false);
            Log.d(this, "- internalResolveIntent: LAUNCH_FROM_NOTIFICATION_EXTRA: " + a10 + ", isOutgoingCall: " + a11);
            if ((a10 || a11) && (foldScreenController = InCallPresenter.getInstance().getFoldScreenController()) != null) {
                foldScreenController.g();
            }
        }
    }

    @Override // com.android.incallui.InCallActivity
    public boolean isSecureMode() {
        try {
            return this.mKeyguardManager.isKeyguardSecure();
        } catch (Exception e10) {
            Log.d(LOG_TAG, "Exception: " + e10.toString());
            return false;
        }
    }

    @Override // com.android.incallui.InCallActivity
    public void maybeShowErrorDialogOnDisconnect(DisconnectCause disconnectCause, int i10) {
        Log.d(LOG_TAG, "maybeShowErrorDialogOnDisconnect disconnectCause = " + disconnectCause);
        if (disconnectCause == null) {
            return;
        }
        if (18 == disconnectCause.getCode()) {
            Log.d(LOG_TAG, "maybeShowErrorDialogOnDisconnect,OUT_OF_SERVICE not need show dialog");
        } else {
            super.maybeShowErrorDialogOnDisconnect(disconnectCause, i10);
        }
    }

    @Override // com.android.incallui.InCallActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (OplusPhoneUtils.isDeviceProvisioned(getApplicationContext()) && !OplusPhoneUtils.isDeviceLocked(getApplicationContext())) {
            if (this.mIsOnSaveInstanceState) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "mIsOnSaveInstanceState is true return!!!");
                    return;
                }
                return;
            }
            super.onBackPressed();
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "is in provisioned or isDeviceLocked ...");
        }
    }

    @Override // com.android.incallui.InCallActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onConfigurationChanged, newConfig = " + D2.g.o(configuration));
        }
        OplusPhoneUtils.setDefaultDisplayResources(getResources());
    }

    @Override // com.android.incallui.InCallActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ResponsiveConfigRepository.f18540a.h1().i(this, new androidx.lifecycle.w() { // from class: com.android.incallui.K
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                OplusInCallActivity.this.lambda$onCreate$0((Integer) obj);
            }
        });
        this.mInCallFragmentManager = new b2.j(this);
        OplusPhoneUtils.setDefaultDisplayResources(getResources());
        Intent intent = getIntent();
        super.onCreate(bundle);
        VideoBackgroundUseCase.f18569a.s((ViewGroup) findViewById(R.id.video_show_frame_layout));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("oplus_action_infrafed_pick_up");
        intentFilter.addAction(ACTION_STATE_CHANGED);
        registerReceiver(this.mOplusReceiver, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
        if (bundle == null) {
            Log.i(LOG_TAG, "onCreate(): this is our very first launch, checking intent...");
            internalResolveIntent(intent);
        }
        this.mKeyguardManager = (KeyguardManager) getSystemService("keyguard");
        this.mFirstStartActivity = true;
        this.mUiModeManager = (UiModeManager) getSystemService("uimode");
        View findViewById = findViewById(R.id.cl_root);
        if (findViewById != null) {
            findViewById.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.android.incallui.OplusInCallActivity.1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    WindowInsets rootWindowInsets;
                    boolean z10;
                    if (view != null && view.getRootWindowInsets() != null && (rootWindowInsets = view.getRootWindowInsets()) != null) {
                        Insets insetsIgnoringVisibility = rootWindowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
                        if (Log.sDebug) {
                            Log.d(OplusInCallActivity.LOG_TAG, "onApplyWindowInsets insetsIgnoringVisibility = " + insetsIgnoringVisibility);
                        }
                        if (insetsIgnoringVisibility.bottom != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        InCallPresenter.getInstance().notifyNavigationBarChange(z10);
                        ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
                        responsiveConfigRepository.r1().o(Integer.valueOf(insetsIgnoringVisibility.top));
                        responsiveConfigRepository.N0().o(Integer.valueOf(insetsIgnoringVisibility.bottom));
                    }
                    return windowInsets;
                }
            });
            com.android.incallui.mvvm.view.m.f(this, findViewById);
        }
        if (!InCallPresenter.getInstance().realInstance().shouldAddFragmentLazy()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "add fragment for incoming call");
            }
            if (InCallPresenter.getInstance().realInstance().getInCallFragmentPresenter() != null) {
                InCallPresenter.getInstance().realInstance().getInCallFragmentPresenter().a(this.mInCallFragmentManager);
            }
            this.mHandler.post(new Runnable() { // from class: com.android.incallui.L
                @Override // java.lang.Runnable
                public final void run() {
                    OplusInCallActivity.this.lambda$onCreate$1();
                }
            });
        }
        if (OplusPhoneUtils.isSupportWCG(this)) {
            Log.d(LOG_TAG, "WCG supported");
            getWindow().setColorMode(1);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
        if (i10 != 1000) {
            if (i10 == 1001) {
                cOUIAlertDialogBuilder.setTitle(this.mRecordStorageFullResId).setPositiveButton(R.string.oplus_clean, new DialogInterface.OnClickListener() { // from class: com.android.incallui.OplusInCallActivity.7
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        Intent intent = new Intent("oplus.intent.action.CLEAR_MAIN_ACTIVITY");
                        intent.setComponent(new ComponentName("com.oplus.phonemanager", "com.oplus.phonemanager.clear.ClearMainActivity"));
                        intent.putExtra("enter_from", BuildConfig.LIBRARY_PACKAGE_NAME);
                        intent.putExtra("DEEP_CLEAN", 2);
                        OplusPhoneUtils.startSafeActivity(OplusInCallActivity.this, intent);
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.incallui.OplusInCallActivity.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i11) {
                    }
                }).setCancelable(false);
            }
        } else {
            cOUIAlertDialogBuilder.setTitle(R.string.oplus_video_upgrade_request).setPositiveButton(R.string.oplus_video_upgrade_request_accept, new DialogInterface.OnClickListener() { // from class: com.android.incallui.OplusInCallActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i11) {
                    OplusPhoneUserActionStatistics.onCommon(OplusInCallActivity.this, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_ACCEPT_VIDEO_REQUEST_BY_LOCAL_WHEN_CALL, (Map) null);
                    Call videoUpgradeRequestCall = CallList.getInstance().getVideoUpgradeRequestCall();
                    if (videoUpgradeRequestCall != null) {
                        videoUpgradeRequestCall.setOplusClickToVoice(false);
                    } else {
                        Log.d(OplusInCallActivity.LOG_TAG, "the UpgradeRequestCall is null");
                    }
                    InCallPresenter.getInstance().acceptUpgradeRequest(OplusInCallActivity.this);
                }
            }).setNegativeButton(R.string.oplus_video_upgrade_request_reject, new DialogInterface.OnClickListener() { // from class: com.android.incallui.OplusInCallActivity.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i11) {
                    OplusPhoneUserActionStatistics.onCommon(OplusInCallActivity.this, OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_REJECT_VIDEO_REQUEST_BY_LOCAL_WHEN_CALL, (Map) null);
                    InCallPresenter.getInstance().declineUpgradeRequest(OplusInCallActivity.this);
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.incallui.OplusInCallActivity.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK && OplusFeatureOption.OPLUS_PHONE_VILTE_AUTO_TEST) {
                        C1702a.e().i();
                    }
                }
            }).setCancelable(false);
        }
        androidx.appcompat.app.b create = cOUIAlertDialogBuilder.create();
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        A2.d.e(attributes);
        window.setAttributes(attributes);
        return create;
    }

    @Override // com.android.incallui.InCallActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.mOplusReceiver);
        InCallPresenter.getInstance().setActivity(null);
        VideoBackgroundUseCase.f18569a.s(null);
        if (OplusPhoneUtils.isUstOplusExport()) {
            BrandCenter.f19187a.a().d().D();
        }
        this.mInCallFragmentManager.a();
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    @Override // com.android.incallui.InCallActivity, android.app.Activity, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyUp(int r6, android.view.KeyEvent r7) {
        /*
            r5 = this;
            boolean r0 = com.android.incallui.OplusFeatureOption.OPLUS_EYESIGHT_CAMERA_GESTURE_SUPPORT
            r1 = 1
            java.lang.String r2 = "OplusInCallActivity"
            if (r0 == 0) goto L29
            boolean r0 = com.android.incallui.Log.sDebug
            if (r0 == 0) goto L1f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "eyesight gesture onKeyUp: "
            r0.append(r3)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.android.incallui.Log.d(r2, r0)
        L1f:
            r0 = 218(0xda, float:3.05E-43)
            if (r6 == r0) goto L27
            r0 = 217(0xd9, float:3.04E-43)
            if (r6 != r0) goto L29
        L27:
            r0 = r1
            goto L2a
        L29:
            r0 = 0
        L2a:
            boolean r3 = com.android.incallui.Log.sDebug
            if (r3 == 0) goto L42
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = " keyTrigger = "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.android.incallui.Log.d(r2, r3)
        L42:
            if (r0 == 0) goto L48
            r5.answerGestureRingingCall()
            return r1
        L48:
            boolean r5 = super.onKeyUp(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.OplusInCallActivity.onKeyUp(int, android.view.KeyEvent):boolean");
    }

    @Override // com.android.incallui.InCallActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.android.incallui.InCallActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsForegroundActivity = false;
        if (this.mHandler != null && CallList.getInstance().hasAnyLiveCall() && OplusPhoneUtils.getPhoneScreenLockState(this)) {
            this.mHandler.removeMessages(100);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 100, Boolean.valueOf(this.mIsForegroundActivity)), 200L);
        }
        ((OplusInCallPresenter) InCallPresenter.getInstance()).updateNotificationWhenResumeAndPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onPostResume :first create activity =  " + this.mFirstStartActivity);
        }
        if (InCallPresenter.getInstance().realInstance().getInCallFragmentPresenter() != null) {
            InCallPresenter.getInstance().realInstance().getInCallFragmentPresenter().a(this.mInCallFragmentManager);
        }
        this.mHandler.post(new Runnable() { // from class: com.android.incallui.N
            @Override // java.lang.Runnable
            public final void run() {
                OplusInCallActivity.this.lambda$onPostResume$2();
            }
        });
        if (!this.mFirstStartActivity) {
            try {
                InCallPresenter.getInstance().realInstance().inCallActivityOnPostResume();
            } catch (Exception e10) {
                Log.e(LOG_TAG, "inCallActivityOnPostResume" + e10.getMessage());
            }
        }
        this.mFirstStartActivity = false;
        InCallPresenter.getInstance().realInstance().userActionStatisticsHomeKeyPressed();
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog) {
        if (i10 == 1001 && dialog != null) {
            try {
                dialog.setTitle(this.mRecordStorageFullResId);
            } catch (Resources.NotFoundException e10) {
                Log.d(LOG_TAG, "onPrepareDialog NotFoundException: " + e10.toString());
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Log.d(LOG_TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.android.incallui.InCallActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.mIsForegroundActivity) {
            refreshBackground();
        }
        this.mIsOnSaveInstanceState = false;
        this.mIsForegroundActivity = true;
        if (this.mShowDialpadRequested) {
            this.mInCallFragmentManager.displayDialpad(true);
        }
        this.mShowDialpadRequested = false;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(100);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 100, Boolean.valueOf(this.mIsForegroundActivity)), 200L);
        }
        ((OplusInCallPresenter) InCallPresenter.getInstance()).inCallActivityonResume();
        InCallUIAide.getInstance().checkFontChange();
        InCallPresenter.getInstance().realInstance().checkRttUi();
        showSmsResponseList(getIntent());
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Log.d(LOG_TAG, "onSaveInstanceState");
        this.mIsOnSaveInstanceState = true;
        ((OplusInCallPresenter) InCallPresenter.getInstance()).dismissPermissionDialog();
        super.onSaveInstanceState(bundle);
    }

    @Override // com.android.incallui.InCallActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        InCallPresenter.getInstance().setActivity(this);
        VideoBackgroundUseCase.f18569a.s((ViewGroup) findViewById(R.id.video_show_frame_layout));
    }

    @Override // com.android.incallui.InCallActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mHandler != null && CallList.getInstance().hasAnyLiveCall()) {
            this.mHandler.removeMessages(100);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 100, Boolean.valueOf(this.mIsForegroundActivity)), 200L);
        }
        if (!CallList.getInstance().hasAnyLiveCall()) {
            Handler handler = this.mHandler;
            if (handler != null && handler.hasMessages(104)) {
                this.mHandler.removeMessages(104);
            }
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.postDelayed(new Runnable() { // from class: com.android.incallui.M
                    @Override // java.lang.Runnable
                    public final void run() {
                        OplusInCallActivity.this.lambda$onStop$3();
                    }
                }, 100L);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            InCallPresenter.getInstance().realInstance().inCallActivityHasFocus();
            D2.g.n();
        } else {
            InCallPresenter.getInstance().realInstance().inCallActivityLoseFocus();
        }
        D2.g.h(LOG_TAG, "onWindowFocusChanged : " + z10);
    }

    @Override // com.android.incallui.InCallActivity
    public void relaunchedFromDialer(boolean z10) {
        this.mShowDialpadRequested = z10;
        if (z10) {
            Call activeOrBackgroundCall = CallList.getInstance().getActiveOrBackgroundCall();
            InCallPresenter.InCallState inCallState = InCallPresenter.getInstance().getInCallState();
            if (activeOrBackgroundCall != null && activeOrBackgroundCall.getState() == 8 && inCallState != InCallPresenter.InCallState.OUTGOING) {
                TelecomAdapter.getInstance().holdCall(activeOrBackgroundCall.getId());
            }
        }
    }

    public void showRecordStorageFullDialog(int i10) {
        if (i10 == -1) {
            return;
        }
        this.mRecordStorageFullResId = i10;
        showDialog(1001);
    }

    public void showVideoUpgradeRequestDialog() {
        OplusPhoneUtils.oplusPokeUserActivity(this);
        if (OplusPhoneUtils.isUstOplusExport()) {
            BrandCenter.f19187a.a().d().o(this);
        } else {
            showDialog(1000);
        }
        if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK && OplusFeatureOption.OPLUS_PHONE_VILTE_AUTO_TEST) {
            C1702a.e().g(this, InCallPresenter.getInstance());
        }
    }
}
