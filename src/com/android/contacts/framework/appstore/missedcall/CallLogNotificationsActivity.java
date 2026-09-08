package com.android.contacts.framework.appstore.missedcall;

import C7.e;
import J0.c;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;

/* loaded from: classes.dex */
public class CallLogNotificationsActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (b.a(this, "android.permission.READ_CALL_LOG") != 0) {
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        if (!action.equals("com.android.server.telecom.ACTION_CALL_BACK_FROM_NOTIFICATION") && !action.equals("com.android.server.telecom.ACTION_SEND_SMS_FROM_NOTIFICATION")) {
            H7.b.b("CallLogNotificationsActivity.onCreate", "could not handle: " + intent);
        } else {
            new c(this).d(intent);
        }
        e.b(this);
    }
}
