package com.customize.contacts.util;

import android.content.Context;
import com.oplus.dialer.R;

/* compiled from: ResourcesGetter.java */
/* loaded from: classes3.dex */
public class X {
    public static int a(int i10, int i11) {
        if (i10 == i11 && i10 > 1) {
            return R.string.delete_all;
        }
        return R.string.delete_button;
    }

    public static String b(Context context, int i10, int i11) {
        String string;
        try {
            if (i10 == i11) {
                string = context.getString(R.string.dialog_title_delete_all_contacts);
            } else if (i10 > 1) {
                int parseInt = Integer.parseInt(U7.a.b(i10));
                string = String.format(context.getResources().getQuantityString(R.plurals.dialog_title_delete_n_contacts, parseInt), Integer.valueOf(parseInt));
            } else {
                string = context.getString(R.string.dialog_title_delete_contact);
            }
            return string;
        } catch (Exception e10) {
            H7.b.c("ContactsUtils", "getDeleteContactTitle error " + e10);
            return "";
        }
    }

    public static String c(Context context, int i10, int i11) {
        String string;
        try {
            if (i10 == i11) {
                string = context.getString(R.string.dialog_title_delete_all_groups);
            } else if (i10 > 1) {
                int parseInt = Integer.parseInt(U7.a.b(i10));
                string = String.format(context.getResources().getQuantityString(R.plurals.dialog_title_delete_n_groups, parseInt), Integer.valueOf(parseInt));
            } else {
                string = context.getString(R.string.dialog_title_delete_group);
            }
            return string;
        } catch (Exception e10) {
            H7.b.c("ContactsUtils", "getDeleteVipGroupMessage error " + e10);
            return "";
        }
    }
}
