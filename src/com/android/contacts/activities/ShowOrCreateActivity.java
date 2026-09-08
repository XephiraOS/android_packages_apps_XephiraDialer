package com.android.contacts.activities;

import C7.e;
import R0.c;
import R0.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.android.contacts.ContactsActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.util.r;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.activities.ContactsTabActivity;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public final class ShowOrCreateActivity extends ContactsActivity implements r.a {

    /* renamed from: q, reason: collision with root package name */
    public r f13663q;

    /* renamed from: r, reason: collision with root package name */
    public Bundle f13664r;

    /* renamed from: x, reason: collision with root package name */
    public String f13665x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13666y;

    /* renamed from: z, reason: collision with root package name */
    public static final String[] f13662z = {BreenoCallContract.BaseColumns._ID, "lookup"};

    /* renamed from: A, reason: collision with root package name */
    public static final String[] f13661A = {"contact_id", "lookup"};

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.b(ShowOrCreateActivity.this);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public Activity f13668a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f13669b;

        public b(Activity activity, Intent intent) {
            this.f13668a = activity;
            this.f13669b = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Intent intent = this.f13669b;
            if (intent != null) {
                R7.b.c(this.f13668a, intent);
            }
            e.b(this.f13668a);
        }
    }

    @Override // com.android.contacts.util.r.a
    public void j(int i10, Object obj, Cursor cursor) {
        String str;
        long j10;
        if (cursor == null) {
            e.b(this);
            return;
        }
        try {
            int count = cursor.getCount();
            if (count == 1 && cursor.moveToFirst()) {
                j10 = cursor.getLong(0);
                str = cursor.getString(1);
            } else {
                str = null;
                j10 = -1;
            }
            if (count == 1 && j10 != -1) {
                R7.b.c(this, new Intent("android.intent.action.VIEW", ContactsContract.Contacts.getLookupUri(j10, str)));
                e.b(this);
                return;
            }
            if (count > 1) {
                Intent intent = new Intent("android.intent.action.SEARCH");
                intent.setComponent(new ComponentName(this, (Class<?>) ContactsTabActivity.class));
                intent.putExtras(this.f13664r);
                R7.b.c(this, intent);
                e.b(this);
                return;
            }
            if (this.f13666y) {
                Intent intent2 = new Intent("android.intent.action.INSERT", ContactsContract.RawContacts.CONTENT_URI);
                intent2.putExtras(this.f13664r);
                intent2.setType("vnd.android.cursor.dir/raw_contact");
                R7.b.c(this, intent2);
                e.b(this);
                return;
            }
            showDialog(1);
        } finally {
            cursor.close();
        }
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        if (RequestPermissionsActivity.p2(this)) {
            return;
        }
        r rVar = this.f13663q;
        if (rVar == null) {
            this.f13663q = new r(this, this);
        } else {
            rVar.c(42);
        }
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null) {
            str = data.getScheme();
            str2 = data.getSchemeSpecificPart();
        } else {
            str = null;
            str2 = null;
        }
        this.f13664r = new Bundle();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.f13664r.putAll(extras);
        }
        try {
            this.f13665x = e.l(intent, "com.android.contacts.action.CREATE_DESCRIPTION");
        } catch (Exception e10) {
            H7.b.c("ShowOrCreateActivity", "" + e10);
        }
        if (this.f13665x == null) {
            this.f13665x = str2;
        }
        this.f13666y = e.c(intent, "com.android.contacts.action.FORCE_CREATE", false);
        if ("mailto".equals(str)) {
            this.f13664r.putString("email", str2);
            this.f13664r.putString("query", str2);
            this.f13663q.i(42, null, Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI, Uri.encode(str2)), f13661A, null, null, null);
            return;
        }
        if ("tel".equals(str)) {
            this.f13664r.putString("phone", str2);
            this.f13664r.putString("query", str2);
            this.f13663q.i(42, null, d.c(str2), f13662z, null, null, null);
            return;
        }
        H7.b.i("ShowOrCreateActivity", "Invalid intent:" + getIntent());
        e.b(this);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        if (i10 != 1) {
            return super.onCreateDialog(i10);
        }
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.putExtras(this.f13664r);
        intent.setType("vnd.android.cursor.item/raw_contact");
        intent.putExtra(c.f3183a, true);
        return new COUIAlertDialogBuilder(this).setTitle(R.string.add_contact_dlg_title).setMessage((CharSequence) getResources().getString(R.string.add_contact_dlg_message_fmt, this.f13665x)).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) new b(this, intent)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) new b(this, null)).setOnCancelListener(new a()).show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        r rVar = this.f13663q;
        if (rVar != null) {
            rVar.c(42);
        }
    }
}
