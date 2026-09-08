package com.customize.contacts.io;

import J3.e;
import O3.f;
import O3.g;
import O3.h;
import Z3.k;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.model.Account;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.progressbar.COUIHorizontalProgressBar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.SimContactsOrderHelper;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.C0797h;
import com.customize.contacts.util.C0810v;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.c0;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public class ContactsProcessActivity extends BasicActivity implements k, DialogInterface.OnClickListener {

    /* renamed from: A, reason: collision with root package name */
    public String f21447A;

    /* renamed from: E, reason: collision with root package name */
    public androidx.appcompat.app.b f21451E;

    /* renamed from: F, reason: collision with root package name */
    public COUIHorizontalProgressBar f21452F;

    /* renamed from: G, reason: collision with root package name */
    public androidx.appcompat.app.b f21453G;

    /* renamed from: H, reason: collision with root package name */
    public g f21454H;

    /* renamed from: p, reason: collision with root package name */
    public int f21465p;

    /* renamed from: y, reason: collision with root package name */
    public int f21469y;

    /* renamed from: o, reason: collision with root package name */
    public androidx.appcompat.app.b f21464o = null;

    /* renamed from: q, reason: collision with root package name */
    public int f21466q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f21467r = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f21468x = 0;

    /* renamed from: z, reason: collision with root package name */
    public int f21470z = 0;

    /* renamed from: B, reason: collision with root package name */
    public boolean f21448B = true;

    /* renamed from: C, reason: collision with root package name */
    public boolean f21449C = false;

    /* renamed from: D, reason: collision with root package name */
    public boolean f21450D = true;

    /* renamed from: I, reason: collision with root package name */
    public boolean f21455I = false;

    /* renamed from: J, reason: collision with root package name */
    public boolean f21456J = false;

    /* renamed from: K, reason: collision with root package name */
    public boolean f21457K = false;

    /* renamed from: L, reason: collision with root package name */
    public AsyncTask<Void, Void, Boolean> f21458L = null;

    /* renamed from: M, reason: collision with root package name */
    public AsyncTask<Void, Void, Boolean> f21459M = null;

    /* renamed from: N, reason: collision with root package name */
    public final CountDownLatch f21460N = new CountDownLatch(1);

    /* renamed from: O, reason: collision with root package name */
    public long f21461O = 0;

    /* renamed from: P, reason: collision with root package name */
    public c f21462P = new c(this);

    /* renamed from: Q, reason: collision with root package name */
    public boolean f21463Q = true;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ContactsProcessActivity.this.onCancel();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (ContactsProcessActivity.this.f21462P != null && ContactsProcessActivity.this.f21462P.f21473a && ContactsProcessActivity.this.f21462P.f21474b) {
                ContactsProcessActivity.this.W1();
            }
            if (ContactsProcessActivity.this.f21454H != null) {
                ContactsProcessActivity.this.f21454H.c();
            }
            ContactsProcessActivity.this.finish();
        }

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public boolean f21473a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f21474b = false;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<ContactsProcessActivity> f21475c;

        public c(ContactsProcessActivity contactsProcessActivity) {
            this.f21475c = new WeakReference<>(contactsProcessActivity);
        }

        public void a() {
            this.f21475c = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z10;
            if (this.f21474b) {
                if (this.f21473a) {
                    if (message.what != 4) {
                        return;
                    }
                } else {
                    int i10 = message.what;
                    if (i10 != 6 && i10 != 3 && i10 != 5 && i10 != 9) {
                        return;
                    }
                }
            }
            try {
                ContactsProcessActivity contactsProcessActivity = this.f21475c.get();
                if (contactsProcessActivity == null) {
                    return;
                }
                boolean z11 = true;
                switch (message.what) {
                    case 1:
                        if (contactsProcessActivity.f21469y != 6 && contactsProcessActivity.f21469y != 5) {
                            if (contactsProcessActivity.f21451E != null) {
                                if (H7.a.b()) {
                                    H7.b.e("ContactsProcessActivity", "mProgressDialog.show() ------------");
                                }
                                contactsProcessActivity.f21451E.show();
                                contactsProcessActivity.T1(contactsProcessActivity.f21451E);
                                if (contactsProcessActivity.f21452F != null) {
                                    contactsProcessActivity.f21452F.setMax(contactsProcessActivity.f21466q);
                                    contactsProcessActivity.Z1();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        contactsProcessActivity.f21453G = U0.k.o(contactsProcessActivity, contactsProcessActivity.f21447A);
                        return;
                    case 2:
                        if (contactsProcessActivity.f21451E != null) {
                            contactsProcessActivity.T1(contactsProcessActivity.f21451E);
                            if (H7.a.b()) {
                                H7.b.b("ContactsProcessActivity", "activity.mCurrent = " + contactsProcessActivity.f21467r);
                            }
                            if (contactsProcessActivity.f21452F != null) {
                                contactsProcessActivity.f21452F.setProgress(contactsProcessActivity.f21467r);
                            }
                            contactsProcessActivity.Z1();
                            return;
                        }
                        return;
                    case 3:
                        if (contactsProcessActivity.f21469y == 1 || contactsProcessActivity.f21469y == 5) {
                            B3.c.d().h();
                            break;
                        }
                        break;
                    case 4:
                        if (H7.a.b()) {
                            H7.b.b("ContactsProcessActivity", "handleMessage MESSAGE_THREAD_ERROR---activity.isFinishing() = " + contactsProcessActivity.isFinishing());
                        }
                        contactsProcessActivity.P1();
                        if (!contactsProcessActivity.isFinishing()) {
                            if (contactsProcessActivity.f21464o != null && contactsProcessActivity.f21464o.isShowing()) {
                                contactsProcessActivity.f21464o.dismiss();
                                contactsProcessActivity.f21464o = null;
                            }
                            contactsProcessActivity.f21463Q = false;
                            if (contactsProcessActivity.f21465p == 4) {
                                com.oplus.foundation.util.ui.c.c(contactsProcessActivity, contactsProcessActivity.getResources().getString(R.string.operation_canceled) + contactsProcessActivity.getResources().getString(R.string.oplus_comma) + contactsProcessActivity.getResources().getString(R.string.simcard_is_full));
                                if (!contactsProcessActivity.isFinishing()) {
                                    contactsProcessActivity.finish();
                                    return;
                                }
                                return;
                            }
                            if (contactsProcessActivity.f21465p == 8) {
                                contactsProcessActivity.f21468x = contactsProcessActivity.f21454H.i();
                                com.oplus.foundation.util.ui.c.c(contactsProcessActivity, contactsProcessActivity.N1(contactsProcessActivity.f21469y, contactsProcessActivity.f21468x, true));
                                if (!contactsProcessActivity.isFinishing()) {
                                    contactsProcessActivity.finish();
                                    return;
                                }
                                return;
                            }
                            if (contactsProcessActivity.f21465p == 7) {
                                com.oplus.foundation.util.ui.c.c(contactsProcessActivity, contactsProcessActivity.getResources().getString(R.string.error_delete_contacts));
                                if (contactsProcessActivity.f21462P != null && contactsProcessActivity.f21462P.f21473a && contactsProcessActivity.f21462P.f21474b) {
                                    contactsProcessActivity.W1();
                                }
                                if (!contactsProcessActivity.isFinishing()) {
                                    contactsProcessActivity.finish();
                                    return;
                                }
                                return;
                            }
                            if (H7.a.b()) {
                                H7.b.b("ContactsProcessActivity", "showDialog DIALOG_PROCESS_ERROR--------------");
                            }
                            contactsProcessActivity.showDialog(0);
                            return;
                        }
                        return;
                    case 5:
                    case 9:
                        break;
                    case 6:
                        contactsProcessActivity.P1();
                        contactsProcessActivity.W1();
                        if (!this.f21473a && !contactsProcessActivity.isFinishing()) {
                            contactsProcessActivity.finish();
                            return;
                        }
                        return;
                    case 7:
                    case 8:
                    default:
                        return;
                    case 10:
                        contactsProcessActivity.f21454H.f2698c = false;
                        C0797h.a(contactsProcessActivity, null, contactsProcessActivity.f21454H.f2697b);
                        if (!contactsProcessActivity.isFinishing() && !contactsProcessActivity.f21454H.f2698c) {
                            contactsProcessActivity.f21464o = U0.k.o(contactsProcessActivity, contactsProcessActivity.getString(R.string.oplus_msg_export_canceling));
                            return;
                        }
                        return;
                }
                contactsProcessActivity.P1();
                int i11 = message.what;
                if (((i11 != 3 && i11 != 9) || contactsProcessActivity.f21469y != 5) && !contactsProcessActivity.f21449C) {
                    int i12 = contactsProcessActivity.f21469y;
                    int i13 = contactsProcessActivity.f21468x;
                    if (message.what == 5) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    com.oplus.foundation.util.ui.c.c(contactsProcessActivity, contactsProcessActivity.N1(i12, i13, z10));
                }
                if (contactsProcessActivity.f21457K) {
                    contactsProcessActivity.W1();
                }
                int i14 = message.what;
                if (i14 == 5 || i14 == 9) {
                    z11 = false;
                }
                contactsProcessActivity.f21463Q = z11;
                if (!contactsProcessActivity.f21463Q && contactsProcessActivity.f21454H.f2699d) {
                    contactsProcessActivity.f21454H.f2699d = false;
                    if (contactsProcessActivity.f21464o != null && contactsProcessActivity.f21464o.isShowing()) {
                        contactsProcessActivity.f21464o.dismiss();
                        contactsProcessActivity.f21464o = null;
                    }
                    contactsProcessActivity.W1();
                    if (!contactsProcessActivity.isFinishing()) {
                        contactsProcessActivity.finish();
                    }
                }
            } catch (Exception e10) {
                H7.b.c("ContactsProcessActivity", "Exception e: " + e10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final int f21476a;

        /* renamed from: b, reason: collision with root package name */
        public final String f21477b;

        /* renamed from: c, reason: collision with root package name */
        public final WeakReference<Context> f21478c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f21479d;

        public d(Context context, int i10, String str, boolean z10) {
            this.f21478c = new WeakReference<>(context);
            this.f21476a = i10;
            this.f21477b = str;
            this.f21479d = z10;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            boolean z10;
            Cursor cursor = null;
            try {
                try {
                    if (this.f21478c.get() == null) {
                        return Boolean.FALSE;
                    }
                    Cursor c10 = W3.a.c(this.f21478c.get(), this.f21476a);
                    W3.a.d(this.f21478c.get(), this.f21476a);
                    if (b0.M(this.f21478c.get(), this.f21476a) == -1) {
                        H7.b.c("ContactsProcessActivity", "fail to get sim card storage.");
                        Boolean bool = Boolean.FALSE;
                        if (c10 != null) {
                            c10.close();
                        }
                        return bool;
                    }
                    if (c10 != null) {
                        H7.b.e("ContactsProcessActivity", "count = " + c10.getCount());
                    }
                    if (com.customize.contacts.simcontacts.b.j(this.f21477b) == this.f21476a && this.f21479d) {
                        SimContactsOrderHelper.c(c10);
                        if (this.f21478c.get() instanceof ContactsProcessActivity) {
                            ((ContactsProcessActivity) this.f21478c.get()).f21460N.countDown();
                        }
                    }
                    if (c10 != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z10);
                    if (c10 != null) {
                        c10.close();
                    }
                    return valueOf;
                } catch (Exception e10) {
                    H7.b.c("ContactsProcessActivity", "Exception occur when query sim card status " + e10);
                    Boolean bool2 = Boolean.FALSE;
                    if (0 != 0) {
                        cursor.close();
                    }
                    return bool2;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (this.f21478c.get() == null) {
                H7.b.b("ContactsProcessActivity", "when judge the sim status, the context is null, just return");
                return;
            }
            if (bool == null || !bool.booleanValue()) {
                com.oplus.foundation.util.ui.c.b(this.f21478c.get(), R.string.simcard_abnormal_please_check_and_try_again);
                if (this.f21478c.get() instanceof ContactsProcessActivity) {
                    ((ContactsProcessActivity) this.f21478c.get()).finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1() {
        androidx.appcompat.app.b bVar;
        androidx.appcompat.app.b bVar2;
        if (!isFinishing() && (bVar2 = this.f21451E) != null) {
            bVar2.dismiss();
            this.f21451E = null;
            c0.w(-1L);
        }
        if (!isFinishing() && (bVar = this.f21453G) != null) {
            bVar.dismiss();
            this.f21453G = null;
            c0.w(-1L);
        }
    }

    private Dialog S1() {
        int i10;
        switch (this.f21465p) {
            case 2:
                i10 = R.string.error_no_contacts;
                break;
            case 3:
                i10 = R.string.error_set_ringtone;
                break;
            case 4:
                i10 = R.string.simcard_fullfilled;
                break;
            case 5:
                i10 = R.string.error_db_delete;
                break;
            case 6:
                i10 = R.string.error_simcard_delete;
                break;
            case 7:
            default:
                i10 = R.string.operation_error;
                break;
            case 8:
                i10 = R.string.error_simcard_insert;
                break;
            case 9:
                i10 = R.string.error_copy_contacts;
                break;
            case 10:
                i10 = R.string.error_move_contacts;
                break;
            case 11:
                i10 = R.string.error_move_sim_to_phone;
                break;
            case 12:
                i10 = R.string.error_delete_group;
                break;
            case 13:
                i10 = R.string.error_set_starred;
                break;
            case 14:
                i10 = R.string.error_email_full;
                break;
        }
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
        cOUIAlertDialogBuilder.setTitle(R.string.operation_error).setIcon(android.R.drawable.ic_dialog_alert).setMessage(getString(i10)).setPositiveButton(android.R.string.ok, this).setOnCancelListener(new b());
        return cOUIAlertDialogBuilder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(androidx.appcompat.app.b bVar) {
        if (this.f21452F == null) {
            this.f21452F = (COUIHorizontalProgressBar) bVar.getWindow().findViewById(R.id.progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1() {
        int i10;
        if (this.f21448B) {
            try {
                androidx.appcompat.app.b bVar = this.f21451E;
                if (bVar != null && bVar.isShowing() && (i10 = this.f21467r) <= this.f21466q) {
                    this.f21451E.setTitle(getString(this.f21470z, Integer.valueOf(i10), Integer.valueOf(this.f21466q)));
                }
            } catch (Exception e10) {
                H7.b.c("ContactsProcessActivity", "updateProcessDialog Exception e: " + e10);
            }
        }
    }

    @Override // Z3.k
    public void I(int i10, Object obj, Object obj2) {
        c cVar = this.f21462P;
        if (cVar == null) {
            return;
        }
        if (i10 != 9) {
            switch (i10) {
                case 1:
                    this.f21461O = System.currentTimeMillis();
                    this.f21466q = this.f21454H.j();
                    this.f21462P.sendEmptyMessage(1);
                    return;
                case 2:
                    this.f21467r = this.f21454H.e();
                    this.f21462P.sendEmptyMessage(2);
                    return;
                case 3:
                    this.f21468x = this.f21454H.i();
                    X1(3);
                    if (this.f21456J) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(this.f21468x));
                        A.a(getBaseContext(), 2000315, 200030143, hashMap, false);
                        com.android.contacts.framework.api.infocollection.a.c();
                        return;
                    }
                    if (this.f21455I) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(this.f21468x));
                        A.a(getBaseContext(), 2000315, 200030148, hashMap2, false);
                        com.android.contacts.framework.api.infocollection.a.c();
                        return;
                    }
                    return;
                case 4:
                    cVar.f21473a = true;
                    this.f21465p = this.f21454H.f();
                    if (H7.a.b()) {
                        H7.b.b("ContactsProcessActivity", "THREAD_ERROR CODE : " + this.f21465p);
                    }
                    this.f21462P.sendEmptyMessage(4);
                    return;
                case 5:
                    this.f21468x = this.f21454H.i();
                    this.f21462P.sendEmptyMessage(5);
                    return;
                case 6:
                    X1(6);
                    this.f21462P.f21474b = true;
                    return;
                default:
                    return;
            }
        }
        this.f21468x = this.f21454H.i();
        this.f21462P.sendEmptyMessage(9);
    }

    public final String N1(int i10, int i11, boolean z10) {
        String string;
        int i12;
        int i13;
        if (z10) {
            string = getString(R.string.operation_canceled);
        } else {
            string = getString(R.string.operation_finished);
        }
        if (i10 != 1) {
            i12 = 0;
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 8) {
                        if (i10 == 9) {
                            i12 = R.string.already_removed_info;
                        }
                    } else {
                        i12 = R.string.already_fixed_number;
                    }
                } else {
                    i12 = R.string.aleady_moved;
                }
            } else {
                boolean z11 = this.f21455I;
                int i14 = R.string.aleady_exported_sim;
                if (z11) {
                    if (this.f21457K) {
                        i13 = R.string.aleady_imported;
                    } else {
                        i13 = R.string.aleady_exported_sim;
                    }
                    this.f21455I = false;
                    Q3.b.c();
                } else {
                    i13 = R.string.aleady_copied;
                }
                if (this.f21456J) {
                    if (!FeatureOption.k()) {
                        i14 = R.string.aleady_imported;
                    }
                    this.f21456J = false;
                    i12 = i14;
                } else {
                    i12 = i13;
                }
            }
        } else {
            i12 = R.string.aleady_deleted;
        }
        if (6 == i10) {
            return getString(R.string.set_ring_finished);
        }
        if (i12 == 0) {
            return string;
        }
        return string + getString(R.string.oplus_comma) + String.format(getString(i12), U7.a.b(i11));
    }

    public final void O1() {
        androidx.appcompat.app.b k10 = U0.k.k(this, this.f21447A, R1(), this.f21450D);
        this.f21451E = k10;
        if (!this.f21450D) {
            e.c(k10);
            e.b(this.f21451E);
            return;
        }
        int i10 = this.f21469y;
        if (i10 != 6 && i10 != 5 && k10 != null) {
            e.b(k10);
        }
    }

    public final void Q1(AsyncTask<Void, Void, Boolean> asyncTask) {
        if (asyncTask != null) {
            try {
                if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                    asyncTask.cancel(true);
                }
            } catch (Exception e10) {
                H7.b.c("ContactsProcessActivity", "exception when finishQuerySimStatusTask " + e10);
            }
        }
    }

    public final DialogInterface.OnClickListener R1() {
        int i10 = this.f21469y;
        if (i10 != 6 && i10 != 5 && i10 != 8 && i10 != 9) {
            return new a();
        }
        return null;
    }

    public final void U1(Account account, boolean z10) {
        if (account != null && TextUtils.equals("com.android.oplus.sim", account.f16942b)) {
            int j10 = com.customize.contacts.simcontacts.b.j(account.f16941a);
            if (j10 == 0) {
                if (this.f21458L == null) {
                    this.f21458L = new d(this, j10, account.f16941a, z10);
                }
                this.f21458L.execute(new Void[0]);
            } else {
                if (j10 == 1) {
                    if (this.f21459M == null) {
                        this.f21459M = new d(this, j10, account.f16941a, z10);
                    }
                    this.f21459M.execute(new Void[0]);
                    return;
                }
                H7.b.b("ContactsProcessActivity", "unknown slot id ,check if there is some error");
            }
        }
    }

    public final void V1(Intent intent) {
        int i10;
        String action = intent.getAction();
        if (H7.a.b()) {
            H7.b.b("ContactsProcessActivity", "Action : " + action);
        }
        U1((Account) intent.getParcelableExtra("SRC_ACCOUNT"), false);
        U1((Account) intent.getParcelableExtra("DEST_ACCOUNT"), true);
        this.f21457K = C7.e.c(intent, "imprort_sim_contacts", false);
        if ("com.oplus.contacts.proc.COPY_CONTACTS_BETWEEN_ACCOUNTS".equals(action)) {
            this.f21469y = 2;
            Account account = (Account) C7.e.j(intent, "SRC_ACCOUNT");
            Account account2 = (Account) C7.e.j(intent, "DEST_ACCOUNT");
            i10 = C7.e.d(intent, "tittle_id", -1);
            this.f21449C = C7.e.c(intent, "return_result", false);
            this.f21450D = C7.e.c(intent, "can_cancel", true);
            if (C7.e.c(intent, "DEST_SIM_ACCOUNT", false)) {
                this.f21470z = R.string.oplus_import_contacts_v2;
                this.f21456J = true;
            } else {
                this.f21470z = R.string.oplus_copying_contacts_v2;
            }
            if (account != null && (M3.c.t(account) || TextUtils.equals(account.f16942b, "com.android.oplus.sim"))) {
                if (this.f21457K) {
                    this.f21470z = R.string.oplus_import_contacts_v2;
                } else {
                    this.f21470z = R.string.oplus_export_contacts_v2;
                }
                this.f21455I = true;
            } else if (account2 != null && TextUtils.equals(account2.f16942b, "com.android.oplus.sim")) {
                this.f21470z = R.string.oplus_export_contacts_v2;
                this.f21456J = true;
            }
            if (account != null && TextUtils.equals(account.f16942b, "com.android.oplus.sim")) {
                this.f21454H = new O3.b(getApplication(), C0810v.c(), account2);
            } else if (account2 != null && TextUtils.equals(account2.f16942b, "com.android.oplus.sim")) {
                this.f21454H = new O3.b(getApplication(), C0810v.c(), account2);
            } else if (account != null && !this.f21455I) {
                this.f21454H = new O3.c(this, account, account2, C7.e.c(intent, "need_delete", false));
            } else {
                ArrayList<IdRecord> c10 = C0810v.c();
                if (this.f21455I) {
                    this.f21454H = new O3.b(getApplication(), c10, account, account2);
                } else {
                    this.f21454H = new O3.b(getApplication(), c10, account2);
                }
            }
        } else {
            if ("com.oplus.contacts.proc.DELETE_SELECTED_PHONE_SIM_CONTACTS".equals(action)) {
                this.f21469y = 1;
                this.f21470z = R.string.mark_more_delete_v2;
                this.f21454H = new f(this, C0810v.c());
            } else if ("com.oplus.contacts.proc.DELETE_SELECTED_SIM_CONTACTS".equals(action)) {
                this.f21469y = 1;
                this.f21470z = R.string.mark_more_delete_v2;
                this.f21454H = new f(this, new Account(C7.e.l(intent, OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI), "com.oplus.contacts.sim"), C0810v.c());
            } else if ("com.oplus.contacts.ui.DELELE_AND_REMOVE_GROUP".equals(action)) {
                this.f21469y = 5;
                this.f21470z = R.string.mark_more_delete;
                long[] e10 = C7.e.e(intent, "DELETE_AND_REMOVE_GROUP");
                if (e10 != null && e10.length > 0) {
                    this.f21454H = new O3.d(this, e10);
                } else {
                    finish();
                }
            } else if ("com.oplus.contacts.proc.SET_RINGTONE_TO_CONTACTS".equals(action)) {
                this.f21469y = 6;
                this.f21470z = R.string.oplus_group_add_member_message;
                String l10 = C7.e.l(intent, "CONTACTS_RINGTONE");
                if (TextUtils.isEmpty(l10)) {
                    finish();
                } else {
                    this.f21454H = new h(this, C7.e.i(intent, "NEW_RET_CONTACTS"), l10);
                }
            } else {
                finish();
            }
            i10 = -1;
        }
        if (i10 != -1) {
            this.f21447A = getString(i10);
            this.f21448B = false;
        } else {
            this.f21447A = getString(this.f21470z, Integer.valueOf(this.f21467r), Integer.valueOf(this.f21466q));
        }
    }

    public final void W1() {
        Intent intent = new Intent();
        intent.addFlags(!this.f21463Q ? 1 : 0);
        intent.putExtra("actual_count", this.f21468x);
        intent.putExtra(OplusAutoRedialNotificationUI.TOTAL_COUNT, this.f21466q);
        intent.putExtra("result_success", this.f21463Q);
        setResult(-1, intent);
    }

    public final void X1(int i10) {
        long currentTimeMillis = System.currentTimeMillis() - this.f21461O;
        if (currentTimeMillis < 1100) {
            this.f21462P.sendEmptyMessageDelayed(i10, 1100 - currentTimeMillis);
        } else {
            this.f21462P.sendEmptyMessage(i10);
        }
    }

    public final void Y1() {
        g gVar = this.f21454H;
        if (gVar != null) {
            gVar.o(this);
            this.f21454H.p(this.f21460N);
            this.f21454H.start();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        W1();
        super.finish();
        overridePendingTransition(R.anim.coui_center_dialog_enter, R.anim.coui_center_dialog_exit);
    }

    public void onCancel() {
        int i10;
        int i11;
        if (this.f21456J) {
            HashMap hashMap = new HashMap();
            int i12 = this.f21466q;
            if (i12 > 0) {
                i11 = (this.f21467r * 100) / i12;
            } else {
                i11 = 0;
            }
            hashMap.put("current_progress", Integer.valueOf(i11));
            A.a(getBaseContext(), 2000315, 200030142, hashMap, false);
        } else if (this.f21455I) {
            HashMap hashMap2 = new HashMap();
            int i13 = this.f21466q;
            if (i13 > 0) {
                i10 = (this.f21467r * 100) / i13;
            } else {
                i10 = 0;
            }
            hashMap2.put("current_progress", Integer.valueOf(i10));
            A.a(getBaseContext(), 2000315, 200030147, hashMap2, false);
        }
        g gVar = this.f21454H;
        if (gVar != null) {
            gVar.f2699d = true;
            this.f21462P.sendEmptyMessage(10);
            this.f21454H.c();
            this.f21463Q = false;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        if (i10 == -1) {
            c cVar = this.f21462P;
            if (cVar != null && cVar.f21473a && cVar.f21474b) {
                W1();
            }
            finish();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        V1(getIntent());
        O1();
        Y1();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        if (i10 != 0) {
            return super.onCreateDialog(i10);
        }
        return S1();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        P1();
        if (H7.a.b()) {
            H7.b.b("ContactsProcessActivity", "onDestroy() -------------------");
        }
        g gVar = this.f21454H;
        if (gVar != null) {
            gVar.c();
        }
        c cVar = this.f21462P;
        if (cVar != null) {
            cVar.a();
            this.f21462P = null;
        }
        Q1(this.f21458L);
        this.f21458L = null;
        Q1(this.f21459M);
        this.f21459M = null;
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i10, dialog, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        c cVar;
        super.onStop();
        if (!isFinishing() && (cVar = this.f21462P) != null && cVar.f21474b && cVar.f21473a) {
            finish();
        }
    }
}
