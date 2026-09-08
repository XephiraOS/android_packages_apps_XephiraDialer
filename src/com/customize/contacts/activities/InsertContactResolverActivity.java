package com.customize.contacts.activities;

import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.C0636a;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class InsertContactResolverActivity extends BasicActivity implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: o, reason: collision with root package name */
    public List<a> f20394o = null;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20395p = true;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Intent f20396a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f20397b = null;
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Throwable th) {
            H7.b.c("InsertContact", th.toString());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (H7.a.b()) {
            H7.b.b("InsertContact", "onActivityResult(), requestCode = " + i10);
        }
        super.onActivityResult(i10, i11, intent);
        if (i11 == 0) {
            finish();
            C0636a.b(this);
            return;
        }
        if (666 == i10 && intent != null) {
            Uri data = intent.getData();
            if (data == null) {
                finish();
                return;
            }
            String h10 = M3.c.h(this, ContentUris.parseId(data));
            if (H7.a.b()) {
                H7.b.b("InsertContact", "onActivityResult(), accountType = " + h10);
            }
            Intent intent2 = new Intent("android.intent.action.EDIT", data);
            intent2.putExtra("STORAGE_TYPE", h10);
            intent2.putExtras(getIntent().getExtras());
            R7.b.c(this, intent2);
        }
        finish();
        C0636a.b(this);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        finish();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        if (-2 == i10) {
            finish();
            return;
        }
        a aVar = this.f20394o.get(i10);
        String action = aVar.f20396a.getAction();
        if (H7.a.b()) {
            H7.b.b("InsertContact", "onClick(), action = " + action);
        }
        if ("android.intent.action.INSERT_OR_EDIT".equals(action)) {
            try {
                startActivityForResult(aVar.f20396a, 666);
                C0636a.a(this);
                return;
            } catch (Exception e10) {
                H7.b.c("InsertContact", "" + e10);
                return;
            }
        }
        R7.b.c(this, aVar.f20396a);
        C0636a.a(this);
        finish();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(0);
        List<a> q12 = q1();
        this.f20394o = q12;
        if (q12 == null) {
            if (H7.a.b()) {
                H7.b.b("InsertContact", "onCreate(), listItems is null ");
            }
            finish();
            return;
        }
        String action = getIntent().getAction();
        if (H7.a.b()) {
            H7.b.b("InsertContact", "onCreate(), action = " + action);
            H7.b.b("InsertContact", "lstItems.size() = " + q12.size());
        }
        if (!"oplus.intent.action.INSERT_OR_EDIT_IN_CALL".equals(action) && !r0.f.l(action)) {
            if (r0.f.j(action)) {
                if (q12.size() <= 1) {
                    R7.b.c(this, q12.get(0).f20396a);
                    finish();
                    return;
                } else {
                    R7.b.c(this, new Intent(com.customize.contacts.util.k0.f22137a, ContactsContract.Contacts.CONTENT_URI));
                    finish();
                    return;
                }
            }
            H7.b.i("InsertContact", "onCreate(), this shouldn't happen, action = " + action);
            return;
        }
        t1();
        this.f20395p = true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (H7.a.b()) {
            H7.b.b("InsertContact", "onDestroy()");
        }
        super.onDestroy();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (H7.a.b()) {
            H7.b.b("InsertContact", "onDismiss(), --------------------------");
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.android.contacts.framework.baseui.util.A.g(this);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.android.contacts.framework.baseui.util.A.h(this);
    }

    public final void p1(Intent intent) {
        intent.addFlags(50331648);
    }

    public List<a> q1() {
        Intent intent = getIntent();
        String action = intent.getAction();
        if (!"oplus.intent.action.INSERT_OR_EDIT_IN_CALL".equals(action) && !r0.f.l(action) && !r0.f.j(action)) {
            H7.b.i("InsertContact", "this shouldn't happen");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a aVar = new a();
        r1(aVar, intent);
        arrayList.add(aVar);
        if (!r0.f.j(action)) {
            a aVar2 = new a();
            s1(aVar2, intent);
            arrayList.add(aVar2);
        }
        return arrayList;
    }

    public final void r1(a aVar, Intent intent) {
        Intent intent2 = new Intent(intent);
        aVar.f20396a = intent2;
        intent2.setAction(com.customize.contacts.util.k0.f22137a);
        aVar.f20396a.setType("vnd.android.cursor.dir/raw_contact");
        if (this.f20395p) {
            p1(aVar.f20396a);
        }
        aVar.f20396a.setComponent(null);
        aVar.f20396a.setSelector(null);
        Intent intent3 = aVar.f20396a;
        intent3.setFlags(intent3.getFlags() & (-196));
        aVar.f20397b = getString(R.string.InserContacts);
    }

    public final void s1(a aVar, Intent intent) {
        Intent intent2 = new Intent(intent);
        aVar.f20396a = intent2;
        intent2.setAction("android.intent.action.INSERT_OR_EDIT");
        aVar.f20396a.setType("vnd.android.cursor.item/contact");
        aVar.f20396a.putExtras(getIntent().getExtras());
        aVar.f20396a.putExtra(R0.c.f3183a, true);
        aVar.f20396a.setComponent(null);
        aVar.f20396a.setSelector(null);
        Intent intent3 = aVar.f20396a;
        intent3.setFlags(intent3.getFlags() & (-196));
        aVar.f20397b = getString(R.string.add_to_saved_contacts);
    }

    public final void t1() {
        if (!isFinishing() && !isDestroyed()) {
            u1();
        }
    }

    public final void u1() {
        int size = this.f20394o.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = this.f20394o.get(i10).f20397b;
        }
        new U0.b(this, 2132083073).setItems((CharSequence[]) strArr, (DialogInterface.OnClickListener) this).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) this).setOnDismissListener(this).setOnCancelListener(this).show();
    }
}
