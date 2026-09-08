package com.android.incallui.oplus.forceenable;

import A2.d;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.b;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.oplus.forceenable.OplusForceEnableDialogActivity;
import com.android.incallui.oplus.widgets.COUIThemeActivity;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import n2.n;

/* compiled from: OplusForceEnableDialogActivity.kt */
/* loaded from: classes.dex */
public final class OplusForceEnableDialogActivity extends COUIThemeActivity implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: d, reason: collision with root package name */
    public static final a f18896d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public int f18897a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f18898b = new Handler();

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f18899c = new Runnable() { // from class: n2.a
        @Override // java.lang.Runnable
        public final void run() {
            OplusForceEnableDialogActivity.B0(OplusForceEnableDialogActivity.this);
        }
    };

    /* compiled from: OplusForceEnableDialogActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final void B0(OplusForceEnableDialogActivity this$0) {
        i.f(this$0, "this$0");
        Log.d("OplusForceEnableDialogActivity", "run to finish activity");
        if (!this$0.isFinishing()) {
            this$0.finish();
        }
    }

    public static final void D0(OplusForceEnableDialogActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        Intent intent = new Intent();
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", OplusPhoneUtils.OPLUS_BLACK_LIST_PACKAGE, null));
        OplusPhoneUtils.startSafeActivity(this$0, intent);
        this$0.b1();
    }

    public static final void H0(OplusForceEnableDialogActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.b1();
    }

    public static final void K0(OplusForceEnableDialogActivity this$0, DialogInterface dialogInterface) {
        i.f(this$0, "this$0");
        this$0.b1();
    }

    public static final boolean L0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Log.d("OplusForceEnableDialogActivity", "mInterceptDialog onKey = " + i10);
        if (i10 == 4) {
            return true;
        }
        return false;
    }

    public static final void M0(OplusForceEnableDialogActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.b1();
    }

    public static final void N0(OplusForceEnableDialogActivity this$0, DialogInterface dialogInterface) {
        i.f(this$0, "this$0");
        this$0.b1();
    }

    public static final boolean O0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Log.d("OplusForceEnableDialogActivity", "mInterceptDialog onKey = " + i10);
        if (i10 == 4) {
            return true;
        }
        return false;
    }

    public static final void Q0(OplusForceEnableDialogActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        Intent intent = new Intent();
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", OplusPhoneUtils.AUDIO_RECORD_APK_PACKAGE, null));
        OplusPhoneUtils.startSafeActivity(this$0, intent);
        this$0.b1();
    }

    public static final void R0(OplusForceEnableDialogActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.b1();
    }

    public static final void T0(OplusForceEnableDialogActivity this$0, DialogInterface dialogInterface) {
        i.f(this$0, "this$0");
        this$0.b1();
    }

    public static final boolean U0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Log.d("OplusForceEnableDialogActivity", "mInterceptDialog onKey = " + i10);
        if (i10 == 4) {
            return true;
        }
        return false;
    }

    public static final void Y0(OplusForceEnableDialogActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        Intent intent = new Intent();
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", OplusPhoneUtils.OPLUS_CALL_RECORDER_APK_PACKAGE, null));
        OplusPhoneUtils.startSafeActivity(this$0, intent);
        this$0.b1();
    }

    private final void y0() {
        Log.d("OplusForceEnableDialogActivity", "delayToFinishActivity");
        this.f18898b.postDelayed(this.f18899c, 300L);
    }

    public final void b1() {
        Log.d("OplusForceEnableDialogActivity", "oplusFinishActivity");
        z0(this.f18897a);
        this.f18898b.postDelayed(this.f18899c, 300L);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface arg0) {
        i.f(arg0, "arg0");
        Log.d("OplusForceEnableDialogActivity", "onCancel");
        y0();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int i10) {
        i.f(dialog, "dialog");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("dialog_id", -1);
        Log.d("OplusForceEnableDialogActivity", "onCreate dialogId" + intExtra);
        if (intExtra != -1) {
            showDialog(intExtra);
        }
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        CharSequence charSequence;
        b create;
        Log.d("OplusForceEnableDialogActivity", "onCreateDialog mCurrentDialogId" + this.f18897a + "id =" + i10);
        WindowManager.LayoutParams layoutParams = null;
        if (i10 != 3) {
            if (i10 != 4) {
                if (i10 != 5) {
                    create = null;
                } else {
                    CharSequence applicationLabel = getPackageManager().getApplicationLabel(n.a(this, OplusPhoneUtils.OPLUS_CALL_RECORDER_APK_PACKAGE));
                    create = new COUIAlertDialogBuilder(this).setCancelable(false).setTitle(getString(R.string.dialog_app_forbidden_title, applicationLabel)).setMessage(getString(R.string.dialog_app_forbidden_detail, applicationLabel, getString(R.string.inCallLabel))).setPositiveButton(getString(R.string.keyboard_position_disable_hint_setting), new DialogInterface.OnClickListener() { // from class: n2.c
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i11) {
                            OplusForceEnableDialogActivity.Y0(OplusForceEnableDialogActivity.this, dialogInterface, i11);
                        }
                    }).setNegativeButton(getString(android.R.string.cancel), new DialogInterface.OnClickListener() { // from class: n2.d
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i11) {
                            OplusForceEnableDialogActivity.H0(OplusForceEnableDialogActivity.this, dialogInterface, i11);
                        }
                    }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: n2.f
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            OplusForceEnableDialogActivity.K0(OplusForceEnableDialogActivity.this, dialogInterface);
                        }
                    }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: n2.g
                        @Override // android.content.DialogInterface.OnKeyListener
                        public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                            boolean L02;
                            L02 = OplusForceEnableDialogActivity.L0(dialogInterface, i11, keyEvent);
                            return L02;
                        }
                    }).create();
                }
            } else {
                CharSequence applicationLabel2 = getPackageManager().getApplicationLabel(n.a(this, OplusPhoneUtils.AUDIO_RECORD_APK_PACKAGE));
                create = new COUIAlertDialogBuilder(this).setCancelable(false).setTitle(getString(R.string.dialog_app_forbidden_title, applicationLabel2)).setMessage(getString(R.string.dialog_app_forbidden_detail, applicationLabel2, getString(R.string.inCallLabel))).setPositiveButton(getString(R.string.keyboard_position_disable_hint_setting), new DialogInterface.OnClickListener() { // from class: n2.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i11) {
                        OplusForceEnableDialogActivity.Q0(OplusForceEnableDialogActivity.this, dialogInterface, i11);
                    }
                }).setNegativeButton(getString(android.R.string.cancel), new DialogInterface.OnClickListener() { // from class: n2.l
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i11) {
                        OplusForceEnableDialogActivity.R0(OplusForceEnableDialogActivity.this, dialogInterface, i11);
                    }
                }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: n2.m
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        OplusForceEnableDialogActivity.T0(OplusForceEnableDialogActivity.this, dialogInterface);
                    }
                }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: n2.b
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                        boolean U02;
                        U02 = OplusForceEnableDialogActivity.U0(dialogInterface, i11, keyEvent);
                        return U02;
                    }
                }).create();
            }
        } else {
            ApplicationInfo a10 = n.a(this, OplusPhoneUtils.OPLUS_BLACK_LIST_PACKAGE);
            if (a10 != null) {
                charSequence = getPackageManager().getApplicationLabel(a10);
            } else {
                charSequence = null;
            }
            create = new COUIAlertDialogBuilder(this).setCancelable(false).setTitle(getString(R.string.dialog_app_forbidden_title, charSequence)).setMessage(getString(R.string.dialog_app_forbidden_detail, charSequence, getString(R.string.inCallLabel))).setPositiveButton(getString(R.string.keyboard_position_disable_hint_setting), new DialogInterface.OnClickListener() { // from class: n2.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    OplusForceEnableDialogActivity.D0(OplusForceEnableDialogActivity.this, dialogInterface, i11);
                }
            }).setNegativeButton(getString(android.R.string.cancel), new DialogInterface.OnClickListener() { // from class: n2.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    OplusForceEnableDialogActivity.M0(OplusForceEnableDialogActivity.this, dialogInterface, i11);
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: n2.i
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    OplusForceEnableDialogActivity.N0(OplusForceEnableDialogActivity.this, dialogInterface);
                }
            }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: n2.j
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                    boolean O02;
                    O02 = OplusForceEnableDialogActivity.O0(dialogInterface, i11, keyEvent);
                    return O02;
                }
            }).create();
        }
        if (create == null) {
            return null;
        }
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        }
        d.e(layoutParams);
        if (window != null) {
            window.setAttributes(layoutParams);
        }
        return create;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface arg0) {
        i.f(arg0, "arg0");
        Log.d("OplusForceEnableDialogActivity", "onDismiss");
        y0();
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog) {
        i.f(dialog, "dialog");
        super.onPrepareDialog(i10, dialog);
        Log.d("OplusForceEnableDialogActivity", "onPrepareDialog mCurrentDialogId" + this.f18897a + "id =" + i10);
        this.f18897a = i10;
    }

    public final void z0(int i10) {
        try {
            Log.d("OplusForceEnableDialogActivity", "dismissDialogSafely, id = " + i10);
            dismissDialog(i10);
        } catch (IllegalArgumentException unused) {
        }
    }
}
