package com.android.contacts.socialwidget;

import H7.b;
import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.oplus.foundation.util.display.DisplayUtil;
import p1.C1429a;

/* loaded from: classes.dex */
public class SocialWidgetConfigureActivity extends Activity {
    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i11 == -1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                b.c("SocialWidgetActivity", "Intent extras are null");
                return;
            }
            int i12 = extras.getInt("appWidgetId", 0);
            C1429a.c().f(this, i12, intent.getData());
            SocialWidgetProvider.c(this, AppWidgetManager.getInstance(this), i12, true);
            Intent intent2 = new Intent();
            intent2.putExtra("appWidgetId", i12);
            setResult(-1, intent2);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DisplayUtil.v(this);
        setResult(0);
        Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        intent.setFlags(603979776);
        Q7.b.b(this, intent, 0, 0);
    }
}
