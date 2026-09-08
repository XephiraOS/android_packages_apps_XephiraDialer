package com.android.contacts.activities;

import U0.n;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.C0490m;
import com.android.contacts.ContactsActivity;
import com.android.contacts.DynamicShortcuts;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountWithDataSet;
import com.android.incallui.OplusNumberMarkUtils;
import com.customize.contacts.util.C0798i;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import m1.AbstractC1316l;
import n1.AbstractC1362a;

/* loaded from: classes.dex */
public class ContactEditorActivity extends ContactsActivity {

    /* renamed from: D, reason: collision with root package name */
    public float f13604D;

    /* renamed from: q, reason: collision with root package name */
    public View f13610q;

    /* renamed from: r, reason: collision with root package name */
    public ContactEditorFragment f13611r;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13612x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13613y;

    /* renamed from: z, reason: collision with root package name */
    public long f13614z = -1;

    /* renamed from: A, reason: collision with root package name */
    public boolean f13601A = false;

    /* renamed from: B, reason: collision with root package name */
    public int f13602B = -1;

    /* renamed from: C, reason: collision with root package name */
    public boolean f13603C = false;

    /* renamed from: E, reason: collision with root package name */
    public Intent f13605E = null;

    /* renamed from: F, reason: collision with root package name */
    public final f f13606F = new f(this);

    /* renamed from: G, reason: collision with root package name */
    public final ContactEditorFragment.u f13607G = new a();

    /* renamed from: H, reason: collision with root package name */
    public Handler f13608H = new e(this);

    /* renamed from: I, reason: collision with root package name */
    public final BroadcastReceiver f13609I = new b();

    /* loaded from: classes.dex */
    public class a implements ContactEditorFragment.u {
        public a() {
        }

        @Override // com.android.contacts.editor.ContactEditorFragment.u
        public void a() {
            ContactEditorActivity.this.finish();
        }

        @Override // com.android.contacts.editor.ContactEditorFragment.u
        public void b(Uri uri) {
            if (uri != null) {
                ContactEditorActivity.this.f13614z = ContentUris.parseId(uri);
            }
            if (uri == null) {
                ContactEditorActivity.this.setResult(0);
            } else {
                Intent intent = new Intent(ContactEditorActivity.this.getApplicationContext(), (Class<?>) CallDetailActivity.class);
                intent.setData(uri);
                ContactEditorActivity.this.setResult(-1, intent);
            }
            ContactEditorActivity.this.finish();
        }

        @Override // com.android.contacts.editor.ContactEditorFragment.u
        public void c() {
            ContactEditorActivity.this.finish();
        }

        @Override // com.android.contacts.editor.ContactEditorFragment.u
        public void d() {
            ContactEditorActivity.this.finish();
        }

        @Override // com.android.contacts.editor.ContactEditorFragment.u
        public void e(AccountWithDataSet accountWithDataSet, Bundle bundle) {
            String str;
            String str2;
            String str3 = null;
            if (accountWithDataSet != null) {
                str = accountWithDataSet.f16942b;
            } else {
                str = null;
            }
            if (accountWithDataSet != null) {
                str2 = accountWithDataSet.f16941a;
            } else {
                str2 = null;
            }
            if (accountWithDataSet != null) {
                str3 = accountWithDataSet.f16970c;
            }
            AccountType c10 = AbstractC1362a.h(ContactEditorActivity.this).c(str, str3);
            Intent intent = new Intent();
            intent.setClassName(c10.f16946c, c10.d());
            intent.setAction("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.item/contact");
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("account_name", str2);
            intent.putExtra("account_type", str);
            intent.putExtra("data_set", str3);
            intent.setFlags(41943040);
            R7.b.c(ContactEditorActivity.this, intent);
            ContactEditorActivity.this.finish();
        }

        @Override // com.android.contacts.editor.ContactEditorFragment.u
        public void f() {
            ContactEditorActivity.this.G1();
        }

        @Override // com.android.contacts.editor.ContactEditorFragment.u
        public void g(Intent intent) {
            if (ContactEditorActivity.this.f13611r.b3()) {
                ContactEditorActivity.this.f13611r.s4(false);
                ContactEditorActivity.this.f13605E = intent;
                return;
            }
            if (intent != null && C7.e.c(intent, "uriIsInvalidated", false)) {
                ContactEditorActivity.this.setResult(-1, intent);
                ContactEditorActivity.this.finish();
            } else if (intent != null) {
                ContactEditorActivity.this.D1(intent);
            } else if (ContactEditorActivity.this.f13605E == null) {
                ContactEditorActivity.this.D1(null);
            } else {
                ContactEditorActivity contactEditorActivity = ContactEditorActivity.this;
                contactEditorActivity.D1(contactEditorActivity.f13605E);
            }
        }

        @Override // com.android.contacts.editor.ContactEditorFragment.u
        public void h(AccountWithDataSet accountWithDataSet, Uri uri, Bundle bundle, boolean z10) {
            AccountType c10 = AbstractC1362a.h(ContactEditorActivity.this).c(accountWithDataSet.f16942b, accountWithDataSet.f16970c);
            Intent intent = new Intent();
            intent.setClassName(c10.f16946c, c10.g());
            intent.setAction("android.intent.action.EDIT");
            intent.setData(uri);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (z10) {
                intent.setFlags(41943040);
                R7.b.c(ContactEditorActivity.this, intent);
                ContactEditorActivity.this.finish();
                return;
            }
            R7.b.c(ContactEditorActivity.this, intent);
        }

        @Override // com.android.contacts.editor.ContactEditorFragment.u
        public void onCancel() {
            ContactEditorActivity.this.f13611r.Y3(0, "cancel");
        }
    }

    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (H7.a.b()) {
                H7.b.b("ContactEditorActivity", "onReceivet action : " + action + ", mSlotId : " + ContactEditorActivity.this.f13602B);
            }
            if (TextUtils.equals("local.intent.action.SUBINFO_STATE_CHANGE", action) && TextUtils.equals("PLUGOUT", C7.e.l(intent, "simstate")) && TextUtils.equals(String.valueOf(ContactEditorActivity.this.f13602B), C7.e.l(intent, "slotid"))) {
                ContactEditorActivity.this.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -3) {
                h0.O(ContactEditorActivity.this.getBaseContext(), "yes");
                if (ContactEditorActivity.this.f13611r != null) {
                    ContactEditorActivity.this.f13611r.P2();
                }
                ContactEditorActivity contactEditorActivity = ContactEditorActivity.this;
                contactEditorActivity.A1(contactEditorActivity.f13614z);
                return;
            }
            if (i10 == -2) {
                h0.O(ContactEditorActivity.this.getBaseContext(), "no");
            }
        }

        public c() {
        }
    }

    /* loaded from: classes.dex */
    public class d extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public long f13618a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f13619b;

        public d(long j10) {
            boolean z10;
            this.f13618a = j10;
            ContactListFilter e10 = AbstractC1316l.f(ContactEditorActivity.this).e();
            if (e10.f16738b == 0 && ContactEditorActivity.this.f13611r != null && ContactEditorActivity.this.f13611r.Z2() != null && ContactEditorActivity.this.f13611r.Z2().l(e10.f16740d)) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f13619b = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00da  */
        /* JADX WARN: Type inference failed for: r9v26 */
        /* JADX WARN: Type inference failed for: r9v27 */
        /* JADX WARN: Type inference failed for: r9v41, types: [boolean] */
        /* JADX WARN: Type inference failed for: r9v42 */
        /* JADX WARN: Type inference failed for: r9v43 */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.Void... r9) {
            /*
                r8 = this;
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                android.content.Intent r9 = r9.getIntent()
                java.lang.String r0 = "sim_contacts_info"
                android.os.Parcelable r9 = C7.e.j(r9, r0)
                r1 = 0
                if (r9 == 0) goto L3f
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                android.content.Intent r9 = r9.getIntent()
                android.os.Parcelable r9 = C7.e.j(r9, r0)
                com.android.contacts.framework.baseui.sim.SimContactInfo r9 = (com.android.contacts.framework.baseui.sim.SimContactInfo) r9
                com.android.contacts.activities.ContactEditorActivity r0 = com.android.contacts.activities.ContactEditorActivity.this
                android.content.Context r0 = r0.getBaseContext()
                java.lang.String r2 = r9.f15826f
                int r0 = com.customize.contacts.util.b0.K(r0, r2)
                com.android.contacts.activities.ContactEditorActivity r2 = com.android.contacts.activities.ContactEditorActivity.this
                android.content.Context r2 = r2.getBaseContext()
                android.net.Uri r0 = com.customize.contacts.util.b0.I0(r2, r0)
                com.android.contacts.activities.ContactEditorActivity r2 = com.android.contacts.activities.ContactEditorActivity.this
                android.content.ContentResolver r3 = r2.getContentResolver()
                long r4 = r9.f15821a
                boolean r9 = com.customize.contacts.util.b0.g(r2, r3, r4, r0)
                goto Le7
            L3f:
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                com.android.contacts.editor.ContactEditorFragment r9 = com.android.contacts.activities.ContactEditorActivity.s1(r9)
                r0 = 0
                if (r9 == 0) goto L6f
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                com.android.contacts.editor.ContactEditorFragment r9 = com.android.contacts.activities.ContactEditorActivity.s1(r9)
                boolean r9 = r9.s3()
                if (r9 == 0) goto L6f
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                android.content.ContentResolver r9 = r9.getContentResolver()
                android.net.Uri r2 = android.provider.ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI
                int r9 = G7.c.c(r9, r2, r1, r1)
                if (r9 <= 0) goto L63
                r0 = 1
            L63:
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                com.customize.contacts.util.W.h(r9)
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                com.customize.contacts.util.W.e(r9)
            L6d:
                r9 = r0
                goto Ld8
            L6f:
                long r2 = r8.f13618a
                r4 = 0
                int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r9 <= 0) goto L6d
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                com.android.contacts.editor.ContactEditorFragment r9 = com.android.contacts.activities.ContactEditorActivity.s1(r9)
                if (r9 == 0) goto Lcc
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                com.android.contacts.editor.ContactEditorFragment r9 = com.android.contacts.activities.ContactEditorActivity.s1(r9)
                com.android.contacts.ContactLoader$Result r9 = r9.Z2()
                if (r9 == 0) goto Lcc
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                com.android.contacts.editor.ContactEditorFragment r9 = com.android.contacts.activities.ContactEditorActivity.s1(r9)
                com.android.contacts.ContactLoader$Result r9 = r9.Z2()
                java.lang.String r9 = r9.p()
                java.lang.String r0 = "com.android.oplus.sim"
                boolean r9 = android.text.TextUtils.equals(r0, r9)
                if (r9 == 0) goto Lcc
                boolean r9 = com.customize.contacts.FeatureOption.k()
                if (r9 == 0) goto Lcc
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                com.android.contacts.editor.ContactEditorFragment r9 = com.android.contacts.activities.ContactEditorActivity.s1(r9)
                com.android.contacts.ContactLoader$Result r9 = r9.Z2()
                int r4 = r9.V()
                com.android.contacts.activities.ContactEditorActivity r2 = com.android.contacts.activities.ContactEditorActivity.this
                com.android.contacts.editor.ContactEditorFragment r9 = com.android.contacts.activities.ContactEditorActivity.s1(r2)
                com.android.contacts.ContactLoader$Result r9 = r9.Z2()
                java.lang.String r3 = r9.o()
                long r5 = r8.f13618a
                java.lang.String r7 = "editor"
                boolean r9 = com.customize.contacts.simcontacts.b.b(r2, r3, r4, r5, r7)
                goto Ld8
            Lcc:
                com.android.contacts.activities.ContactEditorActivity r9 = com.android.contacts.activities.ContactEditorActivity.this
                long r2 = r8.f13618a
                boolean r0 = r8.f13619b
                java.lang.String r4 = "editor"
                boolean r9 = com.customize.contacts.util.c0.d(r9, r2, r0, r4)
            Ld8:
                if (r9 == 0) goto Le7
                com.android.contacts.activities.ContactEditorActivity r0 = com.android.contacts.activities.ContactEditorActivity.this
                com.android.contacts.editor.ContactEditorFragment r2 = com.android.contacts.activities.ContactEditorActivity.s1(r0)
                android.net.Uri r2 = r2.d3()
                com.customize.contacts.util.C0811w.n(r0, r2)
            Le7:
                android.os.Message r0 = new android.os.Message
                r0.<init>()
                r0.what = r9
                com.android.contacts.activities.ContactEditorActivity r8 = com.android.contacts.activities.ContactEditorActivity.this
                android.os.Handler r8 = r8.f13608H
                r8.sendMessage(r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.activities.ContactEditorActivity.d.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        public void b() {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            B3.c.d().h();
        }
    }

    /* loaded from: classes.dex */
    public static class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ContactEditorActivity> f13621a;

        public e(ContactEditorActivity contactEditorActivity) {
            this.f13621a = new WeakReference<>(contactEditorActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ContactEditorActivity contactEditorActivity = this.f13621a.get();
            if (contactEditorActivity == null) {
                return;
            }
            if (message.what == 1) {
                contactEditorActivity.setResult(20);
                C0798i.b(contactEditorActivity.getApplicationContext());
                contactEditorActivity.finish();
                return;
            }
            com.oplus.foundation.util.ui.c.c(contactEditorActivity, contactEditorActivity.getString(R.string.oplus_delete_contacts_failed));
        }
    }

    /* loaded from: classes.dex */
    public static class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ContactEditorActivity> f13622a;

        public f(ContactEditorActivity contactEditorActivity) {
            this.f13622a = new WeakReference<>(contactEditorActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ContactEditorActivity contactEditorActivity = this.f13622a.get();
            if (contactEditorActivity != null && message.what == 1 && contactEditorActivity.getCurrentFocus() != null) {
                SoftKeyboardUtil.a().f(contactEditorActivity.getCurrentFocus());
            }
        }
    }

    public static /* synthetic */ void B1(View view) {
        if (view.getVisibility() == 4 || view.getAlpha() == 0.0f) {
            H7.b.i("ContactEditorActivity", "enter edit, but view can't show");
            view.setVisibility(0);
            view.setAlpha(1.0f);
        }
    }

    public final void A1(long j10) {
        new d(j10).b();
    }

    public final /* synthetic */ void C1() {
        String Y22 = this.f13611r.Y2();
        com.android.contacts.framework.api.cloudsync.a.e();
        if (H7.a.b()) {
            H7.b.b("ContactEditorActivity", "isCloudSyncOpen = false ,accountType = " + Y22);
        }
        if (!"com.oplus.contacts.sim".equals(Y22) && !"com.android.oplus.sim".equals(Y22)) {
            if (!TextUtils.equals(R0.a.f3166b, Y22)) {
                F1();
                return;
            } else {
                E1();
                return;
            }
        }
        E1();
    }

    public final void D1(Intent intent) {
        try {
            int i10 = -1;
            if (this.f13612x) {
                if (intent == null) {
                    i10 = 0;
                }
                setResult(i10, intent);
            } else if (intent != null) {
                if (this.f13613y) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                R7.b.c(this, intent);
            }
        } catch (Exception e10) {
            H7.b.c("ContactEditorActivity", "Exception e: " + e10);
        }
        finish();
    }

    public final void E1() {
        int i10;
        U0.b bVar = new U0.b(this, 2132083073);
        if (this.f13611r.s3()) {
            i10 = R.string.delete_my_business_card_info_v2;
        } else {
            i10 = R.string.dialog_title_delete_contact;
        }
        bVar.setTitle(i10).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) new c()).setNeutralButton(R.string.delete_button, (DialogInterface.OnClickListener) new c()).show();
    }

    public final void F1() {
        int i10;
        U0.b bVar = new U0.b(this, 2132083073);
        if (!this.f13611r.s3()) {
            bVar.setMessage(R.string.delete_contact_contain_cloud);
        }
        if (this.f13611r.s3()) {
            i10 = R.string.delete_my_business_card_info_v2;
        } else {
            i10 = R.string.dialog_title_delete_contact;
        }
        bVar.setTitle(i10).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) new c()).setNeutralButton(R.string.delete_button, (DialogInterface.OnClickListener) new c()).show();
    }

    public final void G1() {
        com.android.contacts.framework.api.cloudsync.a.a("ContactEditorActivity showDeleteDialog", C0490m.a(getLifecycle()), new Runnable() { // from class: p0.b
            @Override // java.lang.Runnable
            public final void run() {
                ContactEditorActivity.this.C1();
            }
        });
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean T0() {
        return false;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        C0636a.b(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        ContactEditorFragment contactEditorFragment = this.f13611r;
        if (contactEditorFragment != null) {
            contactEditorFragment.onActivityResult(i10, i11, intent);
        }
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri data;
        long j10;
        String l10;
        super.onCreate(bundle);
        RequestPermissionsActivity.p2(this);
        Intent intent = getIntent();
        if ("android.provider.action.SET_DEFAULT_ACCOUNT".equals(intent.getAction())) {
            intent.setAction("android.intent.action.INSERT");
            setIntent(intent);
        }
        String action = intent.getAction();
        if (!"android.intent.action.EDIT".equals(action) && !"com.oplus.contacts.EDIT_CONTACTS".equals(action)) {
            data = null;
        } else {
            data = getIntent().getData();
        }
        if (H7.a.b()) {
            H7.b.b("ContactEditorActivity", "onCreate......uri = " + data);
        }
        intent.setComponent(new ComponentName(this, (Class<?>) ContactEditorActivity.class));
        try {
            this.f13612x = C7.e.c(intent, "finishActivityOnSaveCompleted", false);
            this.f13613y = C7.e.c(intent, "destroy_previous_activity", false);
        } catch (Exception e10) {
            H7.b.c("ContactEditorActivity", "" + e10);
        }
        if ("joinCompleted".equals(action)) {
            finish();
            return;
        }
        if ("saveCompleted".equals(action)) {
            finish();
            return;
        }
        setContentView(R.layout.contact_editor_activity);
        this.f13610q = findViewById(R.id.contact_editor_layout);
        ContactEditorFragment contactEditorFragment = (ContactEditorFragment) getSupportFragmentManager().l0(R.id.contact_editor_fragment);
        this.f13611r = contactEditorFragment;
        if (contactEditorFragment != null && bundle != null) {
            this.f13604D = bundle.getFloat("mCurrentSlide");
        }
        if (data != null) {
            try {
                j10 = ContentUris.parseId(data);
            } catch (Exception e11) {
                H7.b.b("ContactEditorActivity", "the last segment may not be number" + e11);
                if (!data.toString().contains("profile")) {
                    finish();
                    return;
                }
                j10 = 0;
            }
            H7.b.e("ContactEditorActivity", "contactId = " + j10);
            this.f13614z = j10;
        }
        ContactEditorFragment contactEditorFragment2 = this.f13611r;
        if (contactEditorFragment2 != null) {
            contactEditorFragment2.t4(this.f13607G);
            this.f13611r.S3(action, data, getIntent().getExtras());
        }
        if ("android.intent.action.INSERT".equals(action)) {
            DynamicShortcuts.r(this, "shortcut-add-contact");
        }
        if (C7.e.j(getIntent(), "sim_contacts_info") != null || !TextUtils.isEmpty(C7.e.l(getIntent(), OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI))) {
            SimContactInfo simContactInfo = (SimContactInfo) C7.e.j(getIntent(), "sim_contacts_info");
            if (simContactInfo != null) {
                l10 = simContactInfo.d();
            } else {
                l10 = C7.e.l(getIntent(), OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI);
            }
            this.f13602B = b0.K(this, l10);
            if (H7.a.b()) {
                H7.b.b("ContactEditorActivity", "regist local broadcast mSlotId : " + this.f13602B);
            }
            if (-1 != this.f13602B) {
                try {
                    X.a b10 = X.a.b(this);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("local.intent.action.SUBINFO_STATE_CHANGE");
                    b10.c(this.f13609I, intentFilter);
                } catch (Exception e12) {
                    H7.b.b("ContactEditorActivity", "regist local broadcast error" + e12);
                }
            }
        }
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (H7.a.b()) {
            H7.b.b("ContactEditorActivity", "onDestroy......");
        }
        if (-1 != this.f13602B) {
            try {
                X.a.b(this).e(this.f13609I);
            } catch (Exception e10) {
                H7.b.b("ContactEditorActivity", "unregister local receiver error" + e10);
            }
        }
        n.h();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            ContactEditorFragment contactEditorFragment = this.f13611r;
            if (contactEditorFragment != null) {
                contactEditorFragment.R2();
            }
            if (this.f13601A) {
                return super.onKeyDown(i10, keyEvent);
            }
            ContactEditorFragment contactEditorFragment2 = this.f13611r;
            if (contactEditorFragment2 != null && contactEditorFragment2.Y3(0, "navigation")) {
                return true;
            }
            return super.onKeyDown(i10, keyEvent);
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Uri d32;
        super.onNewIntent(intent);
        if (this.f13611r == null) {
            return;
        }
        if ("android.provider.action.SET_DEFAULT_ACCOUNT".equals(intent.getAction())) {
            intent.setAction("android.intent.action.INSERT");
        }
        setIntent(intent);
        String action = intent.getAction();
        H7.b.e("ContactEditorActivity", "onNewIntent action : " + action + " ,uri : " + intent.getData());
        if (!"android.intent.action.EDIT".equals(action) && !"com.oplus.contacts.EDIT_CONTACTS".equals(action)) {
            if ("saveCompleted".equals(action)) {
                this.f13611r.T3();
                try {
                    ContactEditorFragment contactEditorFragment = this.f13611r;
                    int d10 = C7.e.d(intent, "saveMode", 0);
                    boolean c10 = C7.e.c(intent, "saveSucceeded", false);
                    if (intent.getData() != null) {
                        d32 = intent.getData();
                    } else {
                        d32 = this.f13611r.d3();
                    }
                    contactEditorFragment.W3(true, d10, c10, d32, intent);
                    return;
                } catch (Exception e10) {
                    H7.b.c("ContactEditorActivity", "" + e10);
                    return;
                }
            }
            if ("joinCompleted".equals(action)) {
                this.f13611r.U3(intent.getData());
                return;
            }
            return;
        }
        this.f13611r.p4(intent.getExtras());
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        this.f13603C = true;
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (H7.a.b()) {
            H7.b.b("ContactEditorActivity", "onResume......");
        }
        ContactEditorFragment contactEditorFragment = this.f13611r;
        if (contactEditorFragment == null) {
            return;
        }
        contactEditorFragment.r4(false);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f13611r != null) {
            bundle.putFloat("mCurrentSlide", this.f13604D);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (this.f13603C && z10 && getCurrentFocus() != null) {
            if (getCurrentFocus().getId() != R.id.date_view) {
                this.f13606F.removeMessages(1);
                this.f13606F.sendEmptyMessageDelayed(1, 200L);
            }
        } else if (!z10) {
            this.f13606F.removeMessages(1);
        }
        if (z10) {
            this.f13611r.x4(true);
            final View view = (View) this.f13610q.getParent();
            if (view.getVisibility() == 4 || view.getAlpha() == 0.0f) {
                view.postDelayed(new Runnable() { // from class: p0.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactEditorActivity.B1(view);
                    }
                }, 800L);
            }
        }
        this.f13603C = false;
    }
}
