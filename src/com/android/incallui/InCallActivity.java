package com.android.incallui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telecom.DisconnectCause;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import b2.InterfaceC0519a;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.oplus.widgets.COUIThemeActivity;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;

/* loaded from: classes.dex */
public class InCallActivity extends COUIThemeActivity {
    public static final String LAUNCH_FROM_NOTIFICATION_EXTRA = "InCallActivity.launch_from_notification";
    public static final String LAUNCH_ON_DEFAULT_DISPLAY_EXTRA = "PendingIntent.launch_on_default_display";
    public static final String LOCK_SCREEN_STATE = "InCallActivity.lock_screen_state";
    public static final String NEW_OUTGOING_CALL = "InCallActivity.new_outgoing_call";
    public static final String SHOW_DIALPAD_EXTRA = "InCallActivity.show_dialpad";
    private final String DISCONNECT_REASON_OUT_OF_SERVICE = "OUT_OF_SERVICE";
    protected androidx.appcompat.app.b mDialog;
    public InterfaceC0519a mInCallFragmentManager;
    private InCallOrientationEventListener mInCallOrientationEventListener;
    protected boolean mIsForegroundActivity;
    private androidx.appcompat.app.b mModifyCallPromptDialog;
    private PostCharDialogFragment mPostCharDialogFragment;
    protected boolean mShowDialpadRequested;

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(OplusPhoneUtils.setDefaultFontScaleAndDisplay(context));
    }

    public void createContentView() {
        if (OplusTelephonyCapabilities.isOplusEnabled()) {
            InCallUIAide.getInstance().clearFontChangeListener();
            setContentView(R.layout.oplus_incall_screen);
        } else {
            setContentView(R.layout.incall_screen);
        }
    }

    public void dismissKeyguard(boolean z10) {
        Log.d(this, "dismissKeyguard dismiss = " + z10);
        if (z10) {
            getWindow().addFlags(4194304);
        } else {
            getWindow().clearFlags(4194304);
        }
    }

    public void dismissPendingDialogs() {
        androidx.appcompat.app.b bVar = this.mDialog;
        if (bVar != null) {
            bVar.dismiss();
            this.mDialog = null;
        }
        this.mInCallFragmentManager.e(4);
        androidx.appcompat.app.b bVar2 = this.mModifyCallPromptDialog;
        if (bVar2 != null) {
            bVar2.dismiss();
            this.mModifyCallPromptDialog = null;
        }
    }

    public void dissmissPostCharDialog() {
        if (Log.sOplusDebug) {
            Log.d(this, "dissmissPostCharDialog... ");
        }
        PostCharDialogFragment postCharDialogFragment = this.mPostCharDialogFragment;
        if (postCharDialogFragment != null && postCharDialogFragment.isAdded()) {
            try {
                this.mPostCharDialogFragment.dismiss();
            } catch (Exception e10) {
                Log.e(this, e10.getMessage());
            }
        }
        this.mPostCharDialogFragment = null;
    }

    public void enableInCallOrientationEventListener(boolean z10) {
        if (z10) {
            this.mInCallOrientationEventListener.enable(z10);
        } else {
            this.mInCallOrientationEventListener.disable();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append("finish().  Dialog showing: ");
        if (this.mDialog != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        Log.i(this, sb.toString());
        OplusAnswerFragment i10 = this.mInCallFragmentManager.i();
        if (!hasPendingErrorDialog()) {
            if (i10 == null || !i10.hasPendingDialogs()) {
                try {
                    if (this.mInCallFragmentManager.c() != null) {
                        this.mInCallFragmentManager.c().setBottomButtonsEnable(false);
                    }
                    if (CallList.getInstance().hasAnyLiveCall()) {
                        Log.i(this, "finish().  moveTaskToBack");
                        moveTaskToBack(true);
                    } else {
                        Log.i(this, "finish().  real finish");
                        super.finish();
                    }
                } catch (NullPointerException e10) {
                    Log.e(this, e10.getMessage());
                } catch (Exception e11) {
                    Log.e(this, e11.getMessage());
                }
            }
        }
    }

    public OplusAnswerFragment getAnswerFragment() {
        return this.mInCallFragmentManager.i();
    }

    public OplusCallButtonFragment getCallButtonFragment() {
        return this.mInCallFragmentManager.c();
    }

    public OplusCallCardFragment getCallCardFragment() {
        return this.mInCallFragmentManager.h();
    }

    public InterfaceC0519a getInCallFragmentManager() {
        return this.mInCallFragmentManager;
    }

    public boolean handleDialerKeyDown(int i10, KeyEvent keyEvent) {
        Log.v(this, "handleDialerKeyDown: keyCode " + i10 + ", event " + keyEvent + "...");
        if (this.mInCallFragmentManager.m(5)) {
            return this.mInCallFragmentManager.l().j1(keyEvent);
        }
        return false;
    }

    public boolean hasPendingErrorDialog() {
        if (this.mDialog != null) {
            return true;
        }
        return false;
    }

    public void internalResolveIntent(Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("android.intent.action.MAIN") && intent.hasExtra(SHOW_DIALPAD_EXTRA)) {
            boolean booleanExtra = intent.getBooleanExtra(SHOW_DIALPAD_EXTRA, false);
            Log.d(this, "- internalResolveIntent: SHOW_DIALPAD_EXTRA: " + booleanExtra);
            relaunchedFromDialer(booleanExtra);
        }
    }

    public boolean isForegroundActivity() {
        if (Log.sDebug) {
            Log.d(this, "mIsForegroundActivity " + this.mIsForegroundActivity);
        }
        return this.mIsForegroundActivity;
    }

    public boolean isSecureMode() {
        return false;
    }

    public void maybeShowErrorDialogOnDisconnect(DisconnectCause disconnectCause, int i10) {
        Log.d(this, "maybeShowErrorDialogOnDisconnect disconnectCause = " + disconnectCause);
        if (!isFinishing() && !TextUtils.isEmpty(disconnectCause.getDescription())) {
            if (disconnectCause.getCode() == 1 || disconnectCause.getCode() == 8) {
                if (OplusFeatureOption.FEATURE_CLEAR_CODE_CLARO.a(i10).booleanValue()) {
                    Log.d(this, "claro clear code feature!");
                    toast(disconnectCause.getDescription().toString());
                } else {
                    showErrorDialog(disconnectCause.getDescription());
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Log.d(this, "onBackPressed()...");
        if (this.mInCallFragmentManager.m(6)) {
            this.mInCallFragmentManager.displayManageConferencePanel(false);
        } else if (CallList.getInstance().getIncomingCall() != null) {
            Log.d(this, "Consume Back press for an incoming call");
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (InCallPresenter.getInstance().getProximitySensor() != null) {
            InCallPresenter.getInstance().getProximitySensor().onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i10;
        Log.d(this, "onCreate()...  this = " + this);
        super.onCreate(bundle);
        ResponsiveConfigRepository.f18540a.h1().i(this, new androidx.lifecycle.w<Integer>() { // from class: com.android.incallui.InCallActivity.1
            @Override // androidx.lifecycle.w
            public void onChanged(Integer num) {
                Log.d(this, "getMScreenStatus onChanged: " + num);
                if (num.intValue() == 1) {
                    InCallActivity.this.getWindow().addFlags(OplusPhoneCapabilities.CAPABILITY_INVITE_PARTICIPANTS);
                } else {
                    InCallActivity.this.getWindow().clearFlags(OplusPhoneCapabilities.CAPABILITY_INVITE_PARTICIPANTS);
                }
            }
        });
        int i11 = 2654976;
        if (OplusPhoneUtils.shouldAddScreenOnFlag()) {
            i10 = 2654976;
        } else {
            i10 = 557824;
        }
        if (OplusFeatureOption.VERSION_STORE) {
            setTurnScreenOn(true);
        } else {
            i11 = i10;
        }
        getWindow().addFlags(i11);
        this.mInCallOrientationEventListener = new InCallOrientationEventListener(this);
        requestWindowFeature(1);
        createContentView();
        D2.j.a(getWindow());
        Log.d(this, "onCreate(): exit");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Log.d(this, "onDestroy()...  this = " + this);
        super.onDestroy();
        enableInCallOrientationEventListener(false);
    }

    public void onDialogDismissed() {
        this.mDialog = null;
        InCallPresenter.getInstance().onDismissDialog();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        Log.i(this, "onKeyDown: keyCode = " + i10);
        if (i10 != 5) {
            if (i10 == 27) {
                return true;
            }
            if (i10 != 76) {
                if (i10 == 91) {
                    TelecomAdapter.getInstance().mute(!AudioModeProvider.getInstance().getMute());
                    return true;
                }
            } else if (Log.sVerbose) {
                Log.v(this, "----------- InCallActivity View dump --------------");
                return true;
            }
            Log.d(this, "onKeyDown: repeatCount = " + keyEvent.getRepeatCount());
            if (keyEvent.getRepeatCount() == 0 && handleDialerKeyDown(i10, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i10, keyEvent);
        }
        if (!InCallPresenter.getInstance().handleCallKey()) {
            Log.w(this, "InCallActivity should always handle KEYCODE_CALL in onKeyDown");
        }
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        Log.i(this, "onKeyUp: keyCode = " + i10);
        if ((this.mInCallFragmentManager.m(5) && this.mInCallFragmentManager.l().k1(keyEvent)) || i10 == 5) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(this, "onNewIntent: intent = " + intent);
        setIntent(intent);
        internalResolveIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Log.d(this, "onPause()...");
        super.onPause();
        this.mIsForegroundActivity = false;
        if (this.mInCallFragmentManager.l() != null) {
            this.mInCallFragmentManager.l().k1(null);
        }
        InCallPresenter.getInstance().onUiShowing(false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Log.i(this, "onResume()...");
        super.onResume();
        InCallPresenter.getInstance().onUiShowing(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Log.d(this, "onStart()...");
        super.onStart();
        InCallPresenter.getInstance().onActivityStarted();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Log.d(this, "onStop()...");
        super.onStop();
        InCallPresenter.getInstance().onActivityStopped();
    }

    public void relaunchedFromDialer(boolean z10) {
        Call activeOrBackgroundCall;
        this.mShowDialpadRequested = z10;
        if (z10 && (activeOrBackgroundCall = CallList.getInstance().getActiveOrBackgroundCall()) != null && activeOrBackgroundCall.getState() == 8) {
            TelecomAdapter.getInstance().holdCall(activeOrBackgroundCall.getId());
        }
    }

    public void showErrorDialog(CharSequence charSequence) {
        Log.d(this, "Show Dialog: " + ((Object) charSequence));
        String string = getResources().getString(R.string.incall_error_out_of_service);
        String string2 = getResources().getString(R.string.incall_error_call_failed);
        if (!string.equals(charSequence.toString()) && !string2.equals(charSequence.toString())) {
            dismissPendingDialogs();
            androidx.appcompat.app.b create = new COUIAlertDialogBuilder(this).setTitle(charSequence).setPositiveButton(R.string.oplus_know_ok, new DialogInterface.OnClickListener() { // from class: com.android.incallui.InCallActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    InCallActivity.this.onDialogDismissed();
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.android.incallui.InCallActivity.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    InCallActivity.this.onDialogDismissed();
                }
            }).create();
            this.mDialog = create;
            create.setCanceledOnTouchOutside(false);
            this.mDialog.getWindow().addFlags(2);
            this.mDialog.show();
            TextView textView = (TextView) this.mDialog.getWindow().findViewById(R.id.alertTitle);
            if (textView != null) {
                textView.setSingleLine(false);
                return;
            }
            return;
        }
        Log.d(this, "outOfService display in telephony  remove here!");
    }

    public void showPostCharWaitDialog(String str, String str2) {
        PostCharDialogFragment postCharDialogFragment = new PostCharDialogFragment(str, str2);
        this.mPostCharDialogFragment = postCharDialogFragment;
        try {
            postCharDialogFragment.show(getFragmentManager(), "postCharWait");
        } catch (IllegalStateException e10) {
            Log.e(this, e10.getMessage());
        }
    }

    public void toast(String str) {
        Toast.makeText(this, str, 0).show();
    }
}
