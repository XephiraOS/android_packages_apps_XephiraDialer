package com.customize.contacts.activities;

import android.os.Bundle;
import android.view.MotionEvent;
import com.android.contacts.activities.RequestPermissionsActivity;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class ContactsImportExportActivity extends BasicActivity {
    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.android.contacts.framework.baseui.util.A.b(this, "import_export_contact_back");
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RequestPermissionsActivity.p2(this);
        setContentView(R.layout.contacts_import_export_activity);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (iArr.length != 1 || iArr[0] != 0) {
            finish();
        }
    }
}
