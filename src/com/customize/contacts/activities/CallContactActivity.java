package com.customize.contacts.activities;

import W.c;
import a4.C0421a;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.android.contacts.activities.RequestPermissionsActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.model.b;
import com.android.incallui.OplusPhoneCapabilities;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.interactions.ContactUpdateService;
import com.oplus.dialer.R;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CallContactActivity extends BasicActivity implements c.InterfaceC0078c<Cursor>, DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

    /* renamed from: y, reason: collision with root package name */
    public static final String[] f20176y = {BreenoCallContract.BaseColumns._ID, "data1", "is_primary", "is_super_primary", "account_type", "data2", "data3", "mimetype", "contact_id", "data6"};

    /* renamed from: o, reason: collision with root package name */
    public Uri f20177o;

    /* renamed from: q, reason: collision with root package name */
    public W.b f20179q;

    /* renamed from: x, reason: collision with root package name */
    public androidx.appcompat.app.b f20181x;

    /* renamed from: p, reason: collision with root package name */
    public long f20178p = -1;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList<a> f20180r = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f20182a;

        /* renamed from: b, reason: collision with root package name */
        public String f20183b;

        /* renamed from: c, reason: collision with root package name */
        public String f20184c;

        /* renamed from: d, reason: collision with root package name */
        public long f20185d;

        /* renamed from: e, reason: collision with root package name */
        public String f20186e;

        /* renamed from: f, reason: collision with root package name */
        public String f20187f;

        /* renamed from: g, reason: collision with root package name */
        public String f20188g;

        public String toString() {
            if (C0637b.h()) {
                return C0637b.d(this.f20183b);
            }
            return this.f20183b;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends ArrayAdapter<a> {
        public b(Context context, List<a> list) {
            super(context, R.layout.phone_disambig_item, android.R.id.text2, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i10, view, viewGroup);
            a aVar = (a) getItem(i10);
            ((TextView) view2.findViewById(android.R.id.text1)).setText(CallContactActivity.q1(getContext(), (int) aVar.f20185d, aVar.f20186e));
            return view2;
        }
    }

    public static CharSequence q1(Context context, int i10, CharSequence charSequence) {
        if (i10 != 0 && i10 != 19) {
            return context.getResources().getText(new b.p().e(Integer.valueOf(i10)));
        }
        if (charSequence == null) {
            return "";
        }
        return context.getString(R.string.call_custom, charSequence);
    }

    private void u1() {
        W.b bVar = new W.b(this, ContactsContract.Data.CONTENT_URI, f20176y, "(mimetype='vnd.android.cursor.item/phone_v2') AND contact_id=?", new String[]{String.valueOf(this.f20178p)}, null);
        this.f20179q = bVar;
        bVar.u(0, this);
        this.f20179q.y();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean k0() {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        androidx.appcompat.app.b bVar = (androidx.appcompat.app.b) dialogInterface;
        if (this.f20180r.size() > i10 && i10 >= 0) {
            a aVar = this.f20180r.get(i10);
            if (((CheckBox) bVar.findViewById(R.id.setPrimary)).isChecked()) {
                startService(ContactUpdateService.a(this, aVar.f20182a));
            }
            s1(aVar.f20183b, aVar.f20188g);
        }
        dialogInterface.dismiss();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (RequestPermissionsActivity.p2(this)) {
            return;
        }
        Uri data = getIntent().getData();
        this.f20177o = data;
        this.f20178p = ContentUris.parseId(data);
        W.b bVar = this.f20179q;
        if (bVar != null) {
            bVar.w();
        }
        u1();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        androidx.appcompat.app.b bVar = this.f20181x;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        finish();
        overridePendingTransition(R.anim.coui_center_dialog_enter, R.anim.coui_center_dialog_exit);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        this.f20177o = (Uri) bundle.getParcelable("uri_key");
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("uri_key", this.f20177o);
    }

    @Override // W.c.InterfaceC0078c
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public void t(W.c<Cursor> cVar, Cursor cursor) {
        if (cursor == null) {
            H7.b.e("CallContactActivity", "null cursor finish activity");
            finish();
            return;
        }
        if (H7.a.b()) {
            H7.b.b("CallContactActivity", "onLoadComplete cursor.getCount = " + cursor.getCount());
        }
        try {
            if (cursor.moveToFirst()) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow(BreenoCallContract.BaseColumns._ID);
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("contact_id");
                int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("is_primary");
                int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("is_super_primary");
                int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("data1");
                int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("account_type");
                int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("data2");
                int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("data3");
                int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow("mimetype");
                int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow("data6");
                String str = null;
                String str2 = null;
                while (true) {
                    if (this.f20178p == -1) {
                        this.f20178p = cursor.getLong(columnIndexOrThrow2);
                    }
                    if (cursor.getInt(columnIndexOrThrow3) != 0 && cursor.getInt(columnIndexOrThrow4) != 0) {
                        str = cursor.getString(columnIndexOrThrow5);
                        str2 = cursor.getString(columnIndexOrThrow10);
                        if (!TextUtils.isEmpty(str)) {
                            break;
                        }
                    }
                    a aVar = new a();
                    int i10 = columnIndexOrThrow2;
                    int i11 = columnIndexOrThrow3;
                    aVar.f20182a = cursor.getLong(columnIndexOrThrow);
                    aVar.f20183b = cursor.getString(columnIndexOrThrow5);
                    aVar.f20184c = cursor.getString(columnIndexOrThrow6);
                    aVar.f20185d = cursor.getInt(columnIndexOrThrow7);
                    aVar.f20186e = cursor.getString(columnIndexOrThrow8);
                    aVar.f20187f = cursor.getString(columnIndexOrThrow9);
                    aVar.f20188g = cursor.getString(columnIndexOrThrow10);
                    this.f20180r.add(aVar);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    columnIndexOrThrow2 = i10;
                    columnIndexOrThrow3 = i11;
                }
                if (!TextUtils.isEmpty(str)) {
                    s1(str, str2);
                    finish();
                    com.oplus.foundation.util.io.e.a(cursor);
                    return;
                } else {
                    if (this.f20180r.size() == 1) {
                        a aVar2 = this.f20180r.get(0);
                        s1(aVar2.f20183b, aVar2.f20188g);
                        finish();
                        com.oplus.foundation.util.io.e.a(cursor);
                        return;
                    }
                    if (!isFinishing() && !isDestroyed()) {
                        t1();
                    }
                    com.oplus.foundation.util.io.e.a(cursor);
                    return;
                }
            }
            H7.b.e("CallContactActivity", "cursor moveToFirst failed, finish activity");
            finish();
            com.oplus.foundation.util.io.e.a(cursor);
        } catch (Throwable th) {
            com.oplus.foundation.util.io.e.a(cursor);
            throw th;
        }
    }

    public final void s1(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            H7.b.b("CallContactActivity", "performAction primaryPhone is null; return");
            return;
        }
        Uri withAppendedId = ContentUris.withAppendedId(R0.d.c(str), this.f20178p);
        Intent intent = new Intent(C0421a.f6395a, Uri.fromParts("tel", str, null));
        intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.putExtra("countryiso", str2);
        if (withAppendedId != null && PrimaryUserUtils.a()) {
            intent.putExtra(R0.c.f3186d, withAppendedId.toString());
        }
        R7.b.c(this, intent);
    }

    public final void t1() {
        if (H7.a.b()) {
            H7.b.b("CallContactActivity", "---getNumberListDialog---");
        }
        b bVar = new b(this, this.f20180r);
        View inflate = getLayoutInflater().inflate(R.layout.set_primary_checkbox, (ViewGroup) null);
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this, 2132083075);
        cOUIAlertDialogBuilder.setTitle(R.string.oplus_select_phones);
        cOUIAlertDialogBuilder.setAdapter((ListAdapter) bVar, (DialogInterface.OnClickListener) this);
        cOUIAlertDialogBuilder.setOnDismissListener(this);
        cOUIAlertDialogBuilder.setView(inflate);
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        this.f20181x = show;
        show.setCanceledOnTouchOutside(true);
    }
}
