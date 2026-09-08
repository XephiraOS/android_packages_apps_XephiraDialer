package com.android.contacts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import com.oplus.dialer.R;

/* compiled from: ContactStatusUtil.java */
/* renamed from: com.android.contacts.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0656n {
    public static Drawable a(Context context, int i10) {
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5) {
            return null;
        }
        return context.getDrawable(ContactsContract.StatusUpdates.getPresenceIconResourceId(i10));
    }

    public static String b(Context context, int i10) {
        Resources resources = context.getResources();
        if (i10 != 2 && i10 != 3) {
            if (i10 != 4) {
                if (i10 != 5) {
                    return null;
                }
                return resources.getString(R.string.status_available);
            }
            return resources.getString(R.string.status_busy);
        }
        return resources.getString(R.string.status_away);
    }
}
