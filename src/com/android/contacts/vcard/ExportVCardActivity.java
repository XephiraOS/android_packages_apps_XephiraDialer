package com.android.contacts.vcard;

import Z3.g;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.android.contacts.activities.RequestPermissionsActivity;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.model.Account;
import com.android.contacts.vcard.VCardService;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.util.C;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ExportVCardActivity extends BasicActivity implements ServiceConnection, DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

    /* renamed from: A, reason: collision with root package name */
    public String f17639A;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<Account> f17642p;

    /* renamed from: q, reason: collision with root package name */
    public Account f17643q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f17644r;

    /* renamed from: y, reason: collision with root package name */
    public VCardService f17646y;

    /* renamed from: z, reason: collision with root package name */
    public String f17647z;

    /* renamed from: o, reason: collision with root package name */
    public final Messenger f17641o = new Messenger(new e());

    /* renamed from: x, reason: collision with root package name */
    public volatile boolean f17645x = true;

    /* renamed from: B, reason: collision with root package name */
    public K3.a f17640B = new a();

    /* loaded from: classes.dex */
    public class a extends K3.a {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                ExportVCardActivity.this.D1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ExportVCardActivity.this.finish();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-2 == i10) {
                ExportVCardActivity.this.finish();
                return;
            }
            ExportVCardActivity exportVCardActivity = ExportVCardActivity.this;
            if (i10 >= 0 && i10 < exportVCardActivity.f17642p.size()) {
                ExportVCardActivity exportVCardActivity2 = ExportVCardActivity.this;
                exportVCardActivity2.f17643q = (Account) exportVCardActivity2.f17642p.get(i10);
                if (M3.c.t(ExportVCardActivity.this.f17643q) && !b0.l0(exportVCardActivity)) {
                    ExportVCardActivity.this.showDialog(9);
                    return;
                }
                if (M3.c.i(exportVCardActivity, ExportVCardActivity.this.f17643q) == 0) {
                    com.oplus.foundation.util.ui.c.b(exportVCardActivity, R.string.no_contacts_warnning);
                } else {
                    f fVar = new f(Uri.parse("file://" + ExportVCardActivity.this.f17647z), null, ExportVCardActivity.this.f17643q);
                    ExportVCardActivity.this.f17646y.p(ExportVCardActivity.this.f17640B);
                    ExportVCardActivity.this.f17646y.j(fVar, new p(ExportVCardActivity.this));
                    H7.b.e("VCardExport", "Export start. acquireCpuWakeLock()");
                    Z3.c.a(exportVCardActivity);
                }
            }
            ExportVCardActivity.this.E1();
        }

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ExportVCardActivity.this.finish();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ExportVCardActivity.this.finish();
        }

        public c() {
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f17651a;

        public d(ExportVCardActivity exportVCardActivity, String str) {
            this(Uri.parse("file://" + str));
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                ExportVCardActivity.this.f17646y.j(new f(this.f17651a), new p(ExportVCardActivity.this));
            }
            ExportVCardActivity.this.E1();
        }

        public d(Uri uri) {
            this.f17651a = uri;
        }
    }

    /* loaded from: classes.dex */
    public class e extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (message.arg1 != 0) {
                    H7.b.e("VCardExport", "Message returned from vCard server contains error code.");
                    Object obj = message.obj;
                    if (obj != null) {
                        ExportVCardActivity.this.f17639A = (String) obj;
                    }
                    ExportVCardActivity.this.showDialog(message.arg1);
                    return;
                }
                if (message.what != 5) {
                    H7.b.i("VCardExport", "Unknown message type: " + message.what);
                    super.handleMessage(message);
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 == null) {
                    H7.b.i("VCardExport", "Message returned from vCard server doesn't contain valid path");
                    ExportVCardActivity exportVCardActivity = ExportVCardActivity.this;
                    exportVCardActivity.f17639A = exportVCardActivity.getString(R.string.fail_reason_unknown);
                    ExportVCardActivity.this.showDialog(R.id.dialog_fail_to_export_with_reason);
                    return;
                }
                ExportVCardActivity.this.f17647z = (String) obj2;
                if (!TextUtils.isEmpty(ExportVCardActivity.this.f17647z)) {
                    ExportVCardActivity.this.C1();
                    return;
                }
                H7.b.i("VCardExport", "Destination file name coming from vCard service is empty.");
                ExportVCardActivity exportVCardActivity2 = ExportVCardActivity.this;
                exportVCardActivity2.f17639A = exportVCardActivity2.getString(R.string.fail_reason_unknown);
                ExportVCardActivity.this.showDialog(R.id.dialog_fail_to_export_with_reason);
            } catch (Exception e10) {
                H7.b.c("VCardExport", "Exception e: " + e10);
            }
        }

        public e() {
        }
    }

    public Dialog A1(int i10, int i11) {
        c cVar = new c();
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
        cOUIAlertDialogBuilder.setTitle(i10).setMessage(i11).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) cVar).setOnCancelListener(cVar);
        return cOUIAlertDialogBuilder.show();
    }

    public final File B1() {
        String c10 = C.c(this);
        if (TextUtils.isEmpty(c10)) {
            return null;
        }
        return new File(c10);
    }

    public final void C1() {
        ArrayList<Account> e10 = M3.c.e(this);
        this.f17642p = e10;
        if (e10.size() > 1) {
            this.f17642p.add(M3.c.g(this));
        }
        H7.b.b("VCardExport", "showAccountsToExport()----------");
        showDialog(2);
    }

    public void D1() {
        H7.b.e("VCardExport", "Export finish. releaseCpuLock()");
        Z3.c.b();
        com.oplus.foundation.util.ui.c.c(this, getString(R.string.oplus_msg_export_place));
    }

    public final synchronized void E1() {
        try {
            if (this.f17644r) {
                unbindService(this);
                this.f17644r = false;
            }
            finish();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f17645x = false;
        E1();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        E1();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (RequestPermissionsActivity.p2(this)) {
            return;
        }
        File B12 = B1();
        if (B12 == null) {
            showDialog(R.id.dialog_sdcard_not_found);
            return;
        }
        if ((!B12.exists() || !B12.isDirectory() || !B12.canRead()) && !B12.mkdirs()) {
            showDialog(R.id.dialog_sdcard_not_found);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) VCardService.class);
        if (startService(intent) == null) {
            H7.b.c("VCardExport", "Failed to start vCard service");
            this.f17639A = getString(R.string.fail_reason_unknown);
            showDialog(R.id.dialog_fail_to_export_with_reason);
        } else if (!bindService(intent, this, 1)) {
            H7.b.c("VCardExport", "Failed to connect to vCard service.");
            this.f17639A = getString(R.string.fail_reason_unknown);
            showDialog(R.id.dialog_fail_to_export_with_reason);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        switch (i10) {
            case 2:
                return z1();
            case 9:
                return A1(R.string.oplus_title_export_phonebook, R.string.simcard_not_available);
            case R.id.dialog_export_confirmation /* 2131427894 */:
                COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
                cOUIAlertDialogBuilder.setTitle(R.string.confirm_export_title).setMessage((CharSequence) getString(R.string.confirm_export_message, this.f17647z)).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) new d(this, this.f17647z)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) this).setOnCancelListener(this);
                return cOUIAlertDialogBuilder.show();
            case R.id.dialog_fail_to_export_with_reason /* 2131427895 */:
                this.f17645x = false;
                COUIAlertDialogBuilder cOUIAlertDialogBuilder2 = new COUIAlertDialogBuilder(this);
                COUIAlertDialogBuilder title = cOUIAlertDialogBuilder2.setTitle(R.string.exporting_contact_failed_title);
                String str = this.f17639A;
                if (str == null) {
                    str = getString(R.string.fail_reason_unknown);
                }
                title.setMessage((CharSequence) getString(R.string.exporting_contact_failed_message, str)).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) this).setOnCancelListener(this);
                return cOUIAlertDialogBuilder2.show();
            case R.id.dialog_sdcard_not_found /* 2131427900 */:
                this.f17645x = false;
                COUIAlertDialogBuilder cOUIAlertDialogBuilder3 = new COUIAlertDialogBuilder(this);
                cOUIAlertDialogBuilder3.setTitle(R.string.no_sdcard_title).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(R.string.no_sdcard_message).setPositiveButton(android.R.string.ok, this);
                return cOUIAlertDialogBuilder3.show();
            case R.string.fail_reason_too_many_vcard /* 2132018319 */:
                this.f17645x = false;
                COUIAlertDialogBuilder cOUIAlertDialogBuilder4 = new COUIAlertDialogBuilder(this);
                cOUIAlertDialogBuilder4.setTitle(R.string.exporting_contact_failed_title).setMessage((CharSequence) getString(R.string.exporting_contact_failed_message, getString(R.string.fail_reason_too_many_vcard))).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) this);
                return cOUIAlertDialogBuilder4.show();
            default:
                return super.onCreateDialog(i10, bundle);
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog, Bundle bundle) {
        if (i10 == R.id.dialog_fail_to_export_with_reason) {
            ((androidx.appcompat.app.b) dialog).h(this.f17639A);
        } else if (i10 == R.id.dialog_export_confirmation) {
            ((androidx.appcompat.app.b) dialog).h(getString(R.string.confirm_export_message, this.f17647z));
        } else {
            super.onPrepareDialog(i10, dialog, bundle);
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f17644r = true;
        VCardService a10 = ((VCardService.b) iBinder).a();
        this.f17646y = a10;
        a10.n(this.f17641o);
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        this.f17646y = null;
        this.f17644r = false;
        if (this.f17645x) {
            H7.b.i("VCardExport", "Disconnected from service during the process ongoing.");
            this.f17639A = getString(R.string.fail_reason_unknown);
            showDialog(R.id.dialog_fail_to_export_with_reason);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!isFinishing()) {
            E1();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        this.f17645x = false;
        super.unbindService(serviceConnection);
    }

    public final Dialog z1() {
        ArrayList arrayList = new ArrayList();
        Z3.g.h(this, this.f17642p, arrayList);
        g.a aVar = new g.a(this, R.layout.item_textview_insert_resolver, arrayList);
        b bVar = new b();
        return new COUIAlertDialogBuilder(this).setAdapter((ListAdapter) aVar, (DialogInterface.OnClickListener) bVar).setTitle(R.string.oplus_title_export_phonebook).setOnCancelListener(bVar).show();
    }
}
