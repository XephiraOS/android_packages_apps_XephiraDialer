package com.ted.number.ui;

import C7.e;
import G0.c;
import P7.d;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.util.C0811w;
import com.oplus.dialer.R;

/* loaded from: classes4.dex */
public class TedUpdateSettingActivity extends TedBaseActivity {

    /* renamed from: p, reason: collision with root package name */
    public boolean f29790p;

    /* renamed from: q, reason: collision with root package name */
    public androidx.appcompat.app.b f29791q;

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            com.android.contacts.framework.api.appstore.appinfo.a.m(TedUpdateSettingActivity.this);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // com.ted.number.ui.TedBaseActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ted_update_setting_activity);
        if (e.c(getIntent(), "isFromNotificationClick", false)) {
            c.n(this, 1, "click_notification_enter_ted_update_activity", 1);
        }
        v1(this);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        p1(this, this.f29791q);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.f29790p) {
            this.f29790p = true;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public final void v1(Context context) {
        String a10 = d.a(context);
        if (context.getPackageName().equals(a10)) {
            return;
        }
        String b10 = C0811w.b(getApplicationContext(), a10);
        androidx.appcompat.app.b create = new COUIAlertDialogBuilder(this).create();
        this.f29791q = create;
        create.setTitle(context.getString(R.string.oplus_change_default_dialer_dialog_title));
        this.f29791q.h(context.getString(R.string.oplus_change_to_default_dialer_tips, b10));
        this.f29791q.d(-2, context.getString(R.string.cancel), new a());
        this.f29791q.d(-1, context.getString(R.string.oplus_use_default_dialer), new b());
        u1(this, this.f29791q);
    }

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
        }
    }
}
