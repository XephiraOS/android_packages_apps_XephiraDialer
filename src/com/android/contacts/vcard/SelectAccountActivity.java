package com.android.contacts.vcard;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.android.contacts.ContactsActivity;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.C0701b;
import com.oplus.dialer.R;
import java.util.List;
import n1.AbstractC1362a;

/* loaded from: classes.dex */
public class SelectAccountActivity extends ContactsActivity {

    /* renamed from: q, reason: collision with root package name */
    public C0701b.c f17698q;

    /* loaded from: classes.dex */
    public class a extends C0701b.c {
        public a(Context context, List list, int i10) {
            super(context, list, i10);
        }

        @Override // com.android.contacts.util.C0701b.c, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            AccountWithDataSet accountWithDataSet = this.f17563a.get(i10);
            Intent intent = new Intent();
            intent.putExtra("account_name", accountWithDataSet.f16941a);
            intent.putExtra("account_type", accountWithDataSet.f16942b);
            intent.putExtra("data_set", accountWithDataSet.f16970c);
            SelectAccountActivity.this.setResult(-1, intent);
            SelectAccountActivity.this.finish();
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            SelectAccountActivity.this.finish();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            SelectAccountActivity.this.finish();
        }

        public b() {
        }
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        List<AccountWithDataSet> g10 = AbstractC1362a.h(this).g(true);
        if (g10.size() == 0) {
            H7.b.i("SelectAccountActivity", "Account does not exist");
            finish();
            return;
        }
        if (g10.size() == 1) {
            AccountWithDataSet accountWithDataSet = g10.get(0);
            Intent intent = new Intent();
            intent.putExtra("account_name", accountWithDataSet.f16941a);
            intent.putExtra("account_type", accountWithDataSet.f16942b);
            intent.putExtra("data_set", accountWithDataSet.f16970c);
            setResult(-1, intent);
            finish();
            return;
        }
        this.f17698q = new a(this, g10, R.string.import_from_sdcard);
        showDialog(R.string.import_from_sdcard);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        if (i10 != R.string.import_from_sdcard) {
            return super.onCreateDialog(i10, bundle);
        }
        C0701b.c cVar = this.f17698q;
        if (cVar != null) {
            return C0701b.e(this, i10, cVar, new b());
        }
        throw new NullPointerException("mAccountSelectionListener must not be null.");
    }
}
