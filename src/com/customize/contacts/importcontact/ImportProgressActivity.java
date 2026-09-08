package com.customize.contacts.importcontact;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.A;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.progressbar.COUIHorizontalProgressBar;
import com.customize.contacts.importcontact.ImportContactsService;
import com.customize.contacts.util.C;
import com.customize.contacts.util.C0798i;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ImportProgressActivity extends BasicActivity implements ServiceConnection, DialogInterface.OnShowListener, DialogInterface.OnDismissListener {

    /* renamed from: B, reason: collision with root package name */
    public ImportContactsService f21386B;

    /* renamed from: E, reason: collision with root package name */
    public boolean f21389E;

    /* renamed from: r, reason: collision with root package name */
    public androidx.appcompat.app.b f21397r;

    /* renamed from: x, reason: collision with root package name */
    public androidx.appcompat.app.b f21398x;

    /* renamed from: y, reason: collision with root package name */
    public COUIHorizontalProgressBar f21399y;

    /* renamed from: z, reason: collision with root package name */
    public i f21400z;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21394o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f21395p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21396q = false;

    /* renamed from: A, reason: collision with root package name */
    public boolean f21385A = false;

    /* renamed from: C, reason: collision with root package name */
    public int f21387C = 0;

    /* renamed from: D, reason: collision with root package name */
    public int f21388D = 0;

    /* renamed from: F, reason: collision with root package name */
    public String f21390F = null;

    /* renamed from: G, reason: collision with root package name */
    public ProgressDialog f21391G = null;

    /* renamed from: H, reason: collision with root package name */
    public final BroadcastReceiver f21392H = new c();

    /* renamed from: I, reason: collision with root package name */
    public j f21393I = new d();

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ImportProgressActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends j {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (4 == message.what) {
                removeMessages(2);
                ImportProgressActivity.this.G1();
                ImportProgressActivity.this.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public boolean f21403a = false;

        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.MEDIA_PRE_SHARED")) {
                if (!this.f21403a && ImportProgressActivity.this.f21386B != null) {
                    this.f21403a = true;
                    ImportProgressActivity.this.f21386B.d();
                    ImportProgressActivity.this.finish();
                    return;
                }
                return;
            }
            if (intent.getAction().equals("android.intent.action.MEDIA_EJECT") && ImportProgressActivity.this.f21390F != null && C.a(ImportProgressActivity.this.getApplicationContext()) != null && !ImportProgressActivity.this.f21390F.contains(C.a(ImportProgressActivity.this.getApplicationContext()).getAbsolutePath())) {
                ImportProgressActivity.this.f21394o = true;
                ImportProgressActivity.this.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends j {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HashMap hashMap = new HashMap();
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                if (i10 != 5) {
                                    if (i10 != 9) {
                                        if (i10 == 10) {
                                            if (ImportProgressActivity.this.f21386B != null) {
                                                ImportProgressActivity.this.f21386B.d();
                                            }
                                            ImportProgressActivity.this.M1();
                                            ImportProgressActivity.this.finish();
                                            return;
                                        }
                                        return;
                                    }
                                    Z3.c.b();
                                    if (!ImportProgressActivity.this.f21394o) {
                                        ImportProgressActivity.this.H1();
                                        if (!ImportProgressActivity.this.f21395p) {
                                            ImportProgressActivity importProgressActivity = ImportProgressActivity.this;
                                            importProgressActivity.f21398x = U0.k.o(importProgressActivity, importProgressActivity.getString(R.string.oplus_msg_import_canceling));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ImportProgressActivity.this.f21388D = message.arg1;
                                if (!ImportProgressActivity.this.f21394o && !ImportProgressActivity.this.f21395p && ImportProgressActivity.this.f21399y != null) {
                                    ImportProgressActivity.this.f21399y.setMax(message.arg1);
                                    ImportProgressActivity.this.f21399y.setProgress(0);
                                    ImportProgressActivity.this.T1();
                                    return;
                                }
                                return;
                            }
                            Z3.c.b();
                            removeMessages(2);
                            ImportProgressActivity.this.G1();
                            if (H7.a.b()) {
                                H7.b.b("ImportProgress", "MESSAGE_THREAD_CANCELED");
                            }
                            ImportProgressActivity.this.M1();
                            ImportProgressActivity.this.finish();
                            return;
                        }
                        Z3.c.b();
                        removeMessages(4);
                        removeMessages(2);
                        if (ImportProgressActivity.this.f21397r != null) {
                            ImportProgressActivity.this.f21397r.dismiss();
                        }
                        if (!ImportProgressActivity.this.f21394o) {
                            ImportProgressActivity.this.O1(message.arg1, message.arg2);
                            return;
                        } else {
                            ImportProgressActivity.this.M1();
                            ImportProgressActivity.this.finish();
                            return;
                        }
                    }
                    H7.b.b("ImportProgress", "MESSAGE_THREAD_FINISH --------");
                    Z3.c.b();
                    removeMessages(4);
                    if (ImportProgressActivity.this.f21397r != null) {
                        ImportProgressActivity.this.f21397r.dismiss();
                    }
                    hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(message.arg1));
                    A.a(ImportProgressActivity.this.getBaseContext(), 2000314, 200030113, hashMap, false);
                    ImportProgressActivity.this.setResult(-1, null);
                    ImportProgressActivity.this.M1();
                    C0798i.c(ImportProgressActivity.this.getApplicationContext());
                    ImportProgressActivity.this.finish();
                    return;
                }
                if (ImportProgressActivity.this.f21399y != null) {
                    ImportProgressActivity.this.f21399y.setProgress(message.arg1);
                    ImportProgressActivity.this.f21387C = message.arg1;
                    ImportProgressActivity.this.T1();
                    return;
                }
                return;
            }
            if (!ImportProgressActivity.this.f21394o && !ImportProgressActivity.this.f21395p) {
                ImportProgressActivity.this.N1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        public final String f21406a;

        public e(String str) {
            this.f21406a = str;
        }

        public final void a() {
            com.oplus.foundation.util.ui.c.c(ImportProgressActivity.this, this.f21406a);
            ImportProgressActivity.this.setResult(-1, null);
            ImportProgressActivity.this.finish();
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            a();
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ImportProgressActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            int i11;
            int i12;
            HashMap hashMap = new HashMap();
            if (ImportProgressActivity.this.f21399y != null) {
                i11 = ImportProgressActivity.this.f21399y.getProgress();
            } else {
                i11 = 0;
            }
            if (ImportProgressActivity.this.f21388D > 0) {
                i12 = (i11 * 100) / ImportProgressActivity.this.f21388D;
            } else {
                i12 = 0;
            }
            hashMap.put("current_progress", Integer.valueOf(i12));
            A.a(ImportProgressActivity.this.getBaseContext(), 2000314, 200030111, hashMap, false);
            if (H7.a.b()) {
                H7.b.b("ImportProgress", "onCancel(), mImportService = " + ImportProgressActivity.this.f21386B);
            }
            if (ImportProgressActivity.this.f21386B != null) {
                ImportProgressActivity.this.f21386B.d();
            }
            ImportProgressActivity.this.f21394o = true;
            ImportProgressActivity.this.finish();
        }

        public f() {
        }
    }

    private void F1() {
        this.f21385A = true;
        if (H7.a.b()) {
            H7.b.b("ImportProgress", "bind service");
        }
        Intent intent = new Intent(this, (Class<?>) ImportContactsService.class);
        intent.putExtras(getIntent());
        startService(intent);
        bindService(intent, this, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1() {
        androidx.appcompat.app.b bVar = this.f21397r;
        if (bVar != null && bVar.isShowing()) {
            this.f21397r.dismiss();
        }
        this.f21397r = null;
    }

    private void J1(androidx.appcompat.app.b bVar) {
        if (this.f21399y == null) {
            this.f21399y = (COUIHorizontalProgressBar) bVar.getWindow().findViewById(R.id.progress);
        }
    }

    private void K1() {
        if (H7.a.b()) {
            H7.b.b("ImportProgress", "registerUsbReceiver");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_PRE_SHARED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        this.f21396q = true;
        registerReceiver(this.f21392H, intentFilter, R0.b.f3175i, null, 2);
    }

    private void Q1() {
        if (H7.a.b()) {
            H7.b.b("ImportProgress", "unBindService");
        }
        if (this.f21385A) {
            unbindService(this);
            if (this.f21391G == null) {
                ProgressDialog progressDialog = new ProgressDialog(this);
                this.f21391G = progressDialog;
                progressDialog.setProgressStyle(0);
                this.f21391G.setCancelable(false);
                this.f21391G.setOnCancelListener(new a());
            }
            if (!this.f21391G.isShowing()) {
                this.f21391G.show();
            }
        }
        this.f21385A = false;
    }

    private void R1() {
        if (this.f21392H != null && this.f21396q) {
            if (H7.a.b()) {
                H7.b.b("ImportProgress", "unRegisterUsbReceiver");
            }
            unregisterReceiver(this.f21392H);
            this.f21396q = false;
        }
    }

    private synchronized void S1() {
        if (this.f21389E) {
            Q1();
            this.f21389E = false;
        }
    }

    public final void G1() {
        androidx.appcompat.app.b bVar = this.f21398x;
        if (bVar != null && bVar.isShowing()) {
            this.f21398x.dismiss();
        }
        this.f21398x = null;
    }

    public final Dialog I1(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.operation_error);
        }
        e eVar = new e(str2);
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
        cOUIAlertDialogBuilder.setTitle(R.string.oplus_title_import_phonebook).setIcon(android.R.drawable.ic_dialog_alert).setMessage(str).setPositiveButton(android.R.string.ok, eVar).setOnCancelListener(eVar);
        return cOUIAlertDialogBuilder.show();
    }

    public final void L1(n nVar) {
        N1();
        int b10 = nVar.b();
        int a10 = nVar.a();
        if (H7.a.b()) {
            H7.b.b("ImportProgress", "resumeImportStatus(), viewer.getCurrent() = " + b10 + ", viewer.getContactCount() = " + a10 + ", viewer.getCurrent() = " + b10);
        }
        if (a10 > 0) {
            this.f21388D = a10;
            this.f21387C = b10;
            COUIHorizontalProgressBar cOUIHorizontalProgressBar = this.f21399y;
            if (cOUIHorizontalProgressBar != null) {
                cOUIHorizontalProgressBar.setMax(a10);
                this.f21399y.setProgress(b10);
            }
        }
    }

    public void M1() {
        X.a.b(getApplicationContext()).d(new Intent("com.oplus.contacts.display_settings_changed"));
    }

    public final void N1() {
        try {
            ProgressDialog progressDialog = this.f21391G;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f21391G.dismiss();
            }
        } catch (Exception e10) {
            H7.b.c("ImportProgress", "Exception e: " + e10);
        }
        try {
            P1();
            J1(this.f21397r);
        } catch (Exception unused) {
        }
    }

    public final void O1(int i10, int i11) {
        String a10 = this.f21400z.a(i10);
        String c10 = this.f21400z.c(i10, i11);
        if (H7.a.b()) {
            H7.b.b("ImportProgress", "showErrorDialog(), errorInfo = " + a10);
        }
        Bundle bundle = new Bundle(2);
        bundle.putString("key_error_info", a10);
        bundle.putString("key_error_toast", c10);
        showDialog(3, bundle);
    }

    public final void P1() {
        androidx.appcompat.app.b bVar = this.f21397r;
        if (bVar != null && bVar.isShowing()) {
            return;
        }
        androidx.appcompat.app.b j10 = U0.k.j(this, getString(R.string.oplus_import_contacts_v2, Integer.valueOf(this.f21387C), Integer.valueOf(this.f21388D)), new f());
        this.f21397r = j10;
        if (j10 != null) {
            j10.setOnShowListener(this);
            J3.e.b(this.f21397r);
            J3.e.c(this.f21397r);
            this.f21397r.show();
        }
    }

    public final void T1() {
        int i10;
        try {
            androidx.appcompat.app.b bVar = this.f21397r;
            if (bVar != null && bVar.isShowing() && (i10 = this.f21387C) <= this.f21388D) {
                this.f21397r.setTitle(getString(R.string.oplus_import_contacts_v2, Integer.valueOf(i10), Integer.valueOf(this.f21388D)));
            }
        } catch (Exception e10) {
            H7.b.c("ImportProgress", "updateProcessDialog Exception e: " + e10);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Z3.c.b();
        super.finish();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21400z = new i(this);
        ArrayList<String> k10 = C7.e.k(getIntent(), "FILE_NAME");
        if (k10 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(k10.size()));
            A.a(getBaseContext(), 2000314, 200030110, hashMap, false);
        }
        if (k10 != null && k10.size() >= 1) {
            this.f21390F = k10.get(0);
        }
        F1();
        this.f21394o = false;
        this.f21395p = false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        String string;
        if (H7.a.b()) {
            H7.b.b("ImportProgress", "onCreateDialog(), extras = " + bundle + ", id = " + i10);
        }
        if (3 == i10) {
            String str = "";
            if (bundle == null) {
                string = "";
            } else {
                string = bundle.getString("key_error_info");
            }
            if (bundle != null) {
                str = bundle.getString("key_error_toast");
            }
            return I1(string, str);
        }
        return super.onCreateDialog(i10, bundle);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        R1();
        Q1();
        H1();
        G1();
        if (H7.a.b()) {
            H7.b.b("ImportProgress", "onDestroy-----------------");
        }
        this.f21395p = true;
        try {
            ProgressDialog progressDialog = this.f21391G;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f21391G.dismiss();
            }
        } catch (Exception e10) {
            H7.b.c("ImportProgress", "Exception e: " + e10);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i10, dialog, bundle);
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f21389E = true;
            ImportContactsService.d dVar = (ImportContactsService.d) iBinder;
            ImportContactsService e10 = dVar.e();
            this.f21386B = e10;
            e10.f21360a = this.f21390F;
            int c10 = dVar.c();
            if (H7.a.b()) {
                H7.b.b("ImportProgress", "onServiceConnected(), importState = " + c10);
            }
            if (666 != c10) {
                if (777 == c10) {
                    this.f21386B.j(new b());
                    if (!this.f21395p) {
                        this.f21398x = U0.k.o(this, getString(R.string.oplus_msg_import_canceling));
                    }
                    return;
                } else {
                    if (888 != c10) {
                        S1();
                    } else {
                        K1();
                        L1(dVar);
                        this.f21386B.j(this.f21393I);
                    }
                    return;
                }
            }
            K1();
            this.f21386B.j(this.f21393I);
            this.f21386B.h();
            S1();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        this.f21389E = false;
        this.f21386B.j(this.f21393I);
        this.f21386B = null;
        finish();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        if (!isFinishing()) {
            Z3.c.a(this);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
    }
}
