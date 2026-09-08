package com.android.contacts;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.android.contacts.ContactSaveService;
import com.android.contacts.activities.TransactionSafeActivity;

/* loaded from: classes.dex */
public abstract class ContactsActivity extends TransactionSafeActivity implements ContactSaveService.b {

    /* renamed from: p, reason: collision with root package name */
    public ContentResolver f13091p;

    @Override // com.android.contacts.ContactSaveService.b
    public void C(Intent intent) {
        onNewIntent(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        if (this.f13091p == null) {
            ContactsApplication.i();
            if (this.f13091p == null) {
                this.f13091p = super.getContentResolver();
            }
        }
        return this.f13091p;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i10) {
        ContactsApplication.i();
        return super.getSharedPreferences(str, i10);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if (systemService != null) {
            return systemService;
        }
        return getApplicationContext().getSystemService(str);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ContactSaveService.A(this);
        super.onCreate(bundle);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ContactSaveService.H(this);
        super.onDestroy();
    }
}
