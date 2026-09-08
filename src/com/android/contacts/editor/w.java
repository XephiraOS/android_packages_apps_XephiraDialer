package com.android.contacts.editor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.android.contacts.model.AccountWithDataSet;
import n1.AbstractC1362a;

/* compiled from: ContactEditorUtils.java */
/* loaded from: classes.dex */
public class w {
    public static void a(Context context, AccountWithDataSet accountWithDataSet) {
        SharedPreferences.Editor putBoolean = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit().putBoolean("ContactEditorUtils_anything_saved", true);
        if (accountWithDataSet == null) {
            putBoolean.putString("ContactEditorUtils_known_accounts", "");
            putBoolean.putString("ContactEditorUtils_default_account", "");
        } else {
            putBoolean.putString("ContactEditorUtils_known_accounts", AccountWithDataSet.k(AbstractC1362a.h(context).g(true)));
            putBoolean.putString("ContactEditorUtils_default_account", accountWithDataSet.j());
        }
        putBoolean.apply();
    }
}
