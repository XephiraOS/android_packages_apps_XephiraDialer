package com.oplus.blacklistapp.activities;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import com.oplus.blacklistapp.activities.BaseActivity;
import com.oplus.blacklistapp.framework.baseui.BasicActivity;
import com.oplus.blacklistapp.u;
import n6.C1372a;
import n6.C1373b;

/* loaded from: classes3.dex */
public abstract class BaseActivity extends BasicActivity implements COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: d, reason: collision with root package name */
    public Dialog f26258d;

    public static /* synthetic */ void B0(Activity activity, DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        activity.finish();
    }

    public static /* synthetic */ void z0(C1372a c1372a, Activity activity, DialogInterface dialogInterface, int i10) {
        c1372a.c(activity);
        dialogInterface.dismiss();
    }

    public final void D0(final Activity activity) {
        COUIAlertDialogBuilder cOUIAlertDialogBuilder;
        final C1372a b10 = C1372a.b();
        if (b10.d(activity) == 1) {
            if (this.f26258d == null) {
                String string = activity.getString(C1373b.f35626a);
                cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(activity);
                cOUIAlertDialogBuilder.setCancelable(false);
                cOUIAlertDialogBuilder.setTitle((CharSequence) activity.getString(u.f27576V0, string));
                cOUIAlertDialogBuilder.setMessage((CharSequence) activity.getString(u.f27568T0, string));
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: p6.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        BaseActivity.z0(C1372a.this, activity, dialogInterface, i10);
                    }
                };
                DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: p6.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        BaseActivity.B0(activity, dialogInterface, i10);
                    }
                };
                cOUIAlertDialogBuilder.setPositiveButton((CharSequence) activity.getString(u.f27594Z2), onClickListener);
                cOUIAlertDialogBuilder.setNegativeButton((CharSequence) activity.getString(R.string.cancel), onClickListener2);
                this.f26258d = cOUIAlertDialogBuilder.create();
            } else {
                cOUIAlertDialogBuilder = null;
            }
            this.f26258d.show();
            if (cOUIAlertDialogBuilder != null) {
                cOUIAlertDialogBuilder.updateViewAfterShown();
            }
        }
    }

    public final void H0() {
        if (ResponsiveUIConfig.getDefault(this).getUiStatus().getValue() == UIConfig.Status.UNFOLD) {
            setRequestedOrientation(2);
        } else {
            setRequestedOrientation(5);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        ResponsiveUIConfig.getDefault(this).onActivityConfigChanged(configuration);
        super.onConfigurationChanged(configuration);
        H0();
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Dialog dialog = this.f26258d;
        if (dialog != null) {
            dialog.dismiss();
            this.f26258d = null;
        }
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        D0(this);
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
    }
}
