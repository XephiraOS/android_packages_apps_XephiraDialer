package com.android.contacts.vcard;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.vcard.VCardService;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public class CancelActivity extends BasicActivity implements ServiceConnection {

    /* renamed from: p, reason: collision with root package name */
    public int f17634p;

    /* renamed from: r, reason: collision with root package name */
    public int f17636r;

    /* renamed from: o, reason: collision with root package name */
    public final a f17633o = new a();

    /* renamed from: q, reason: collision with root package name */
    public String f17635q = "";

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            CancelActivity.this.finish();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            CancelActivity.this.finish();
        }

        public a() {
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            CancelActivity.this.bindService(new Intent(CancelActivity.this, (Class<?>) VCardService.class), CancelActivity.this, 1);
        }

        public b() {
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Uri data = getIntent().getData();
        if (data != null) {
            this.f17634p = Integer.parseInt(data.getQueryParameter("job_id"));
            this.f17635q = data.getQueryParameter("display_name");
            this.f17636r = Integer.parseInt(data.getQueryParameter(OplusAutoRedialNotificationUI.TYPE));
        }
        showDialog(R.id.dialog_cancel_confirmation);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        String string;
        String string2;
        switch (i10) {
            case R.id.dialog_cancel_confirmation /* 2131427888 */:
                if (this.f17636r == 1) {
                    string = getString(R.string.cancel_import_confirmation_title);
                    string2 = getString(R.string.cancel_import_confirmation_message, this.f17635q);
                } else {
                    string = getString(R.string.cancel_export_confirmation_title);
                    string2 = getString(R.string.cancel_export_confirmation_message, this.f17635q);
                }
                COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
                cOUIAlertDialogBuilder.setTitle((CharSequence) string).setMessage((CharSequence) string2).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) new b()).setOnCancelListener(this.f17633o).setNegativeButton(android.R.string.cancel, this.f17633o);
                return cOUIAlertDialogBuilder.show();
            case R.id.dialog_cancel_failed /* 2131427889 */:
                COUIAlertDialogBuilder cOUIAlertDialogBuilder2 = new COUIAlertDialogBuilder(this);
                cOUIAlertDialogBuilder2.setTitle(R.string.cancel_vcard_import_or_export_failed).setMessage((CharSequence) getString(R.string.fail_reason_unknown)).setOnCancelListener(this.f17633o).setPositiveButton(android.R.string.ok, this.f17633o);
                return cOUIAlertDialogBuilder2.show();
            default:
                H7.b.i("VCardCancel", "Unknown dialog id: " + i10);
                return super.onCreateDialog(i10, bundle);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            ((VCardService.b) iBinder).a().i(new c(this.f17634p, this.f17635q), null);
            unbindService(this);
            finish();
        } catch (Throwable th) {
            unbindService(this);
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
