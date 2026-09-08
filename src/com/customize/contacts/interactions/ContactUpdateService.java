package com.customize.contacts.interactions;

import C7.e;
import android.app.IntentService;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;

/* loaded from: classes3.dex */
public class ContactUpdateService extends IntentService {
    public ContactUpdateService() {
        super(ContactUpdateService.class.getSimpleName());
        setIntentRedelivery(true);
    }

    public static Intent a(Context context, long j10) {
        Intent intent = new Intent(context, (Class<?>) ContactUpdateService.class);
        intent.putExtra("phone_number_data_id", j10);
        return intent;
    }

    public static void b(Context context, long j10) {
        if (j10 > 0) {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("is_super_primary", (Integer) 1);
            contentValues.put("is_primary", (Integer) 1);
            context.getContentResolver().update(ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, j10), contentValues, null, null);
        }
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        b(this, e.f(intent, "phone_number_data_id", -1L));
    }
}
