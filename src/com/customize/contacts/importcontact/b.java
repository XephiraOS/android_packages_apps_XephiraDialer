package com.customize.contacts.importcontact;

import android.content.Context;
import com.android.contacts.model.Account;

/* compiled from: ContactFileParserFactory.java */
/* loaded from: classes3.dex */
public class b {
    public static c a(Context context, String str, Account account, int i10) {
        if (1 == i10) {
            return new q(context, str, account);
        }
        if (i10 == 0) {
            return new e(context, str, account);
        }
        return null;
    }

    public static c b(Context context, String str, Account account, int i10, boolean z10) {
        if (1 == i10) {
            return new q(context, str, account, z10);
        }
        return null;
    }
}
