package com.android.contacts.detail;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.text.TextUtils;
import com.android.contacts.ContactLoader;
import com.oplus.dialer.R;
import java.util.Iterator;
import o1.C1393c;

/* compiled from: ContactDetailDisplayUtils.java */
/* loaded from: classes.dex */
public class F {
    public static String a(Context context, ContactLoader.Result result) {
        if (result.b0()) {
            String y10 = result.y();
            String A10 = result.A();
            if (TextUtils.isEmpty(y10)) {
                y10 = A10;
            }
            return context.getString(R.string.contact_directory_description, y10);
        }
        return null;
    }

    public static String b(Context context, ContactLoader.Result result) {
        boolean z10;
        String trim;
        String trim2;
        if (result == null) {
            return "";
        }
        if (result.C() == 30) {
            z10 = true;
        } else {
            z10 = false;
        }
        Iterator<Entity> it = result.D().iterator();
        while (it.hasNext()) {
            Iterator<Entity.NamedContentValues> it2 = it.next().getSubValues().iterator();
            while (it2.hasNext()) {
                ContentValues contentValues = it2.next().values;
                if ("vnd.android.cursor.item/organization".equals(contentValues.getAsString("mimetype"))) {
                    String asString = contentValues.getAsString("data1");
                    String asString2 = contentValues.getAsString("data4");
                    if (asString == null) {
                        trim = null;
                    } else {
                        trim = asString.trim();
                    }
                    if (asString2 == null) {
                        trim2 = null;
                    } else {
                        trim2 = asString2.trim();
                    }
                    if (TextUtils.isEmpty(trim)) {
                        if (z10) {
                            trim2 = null;
                        }
                    } else if (TextUtils.isEmpty(trim2)) {
                        if (z10) {
                            trim = null;
                        }
                        trim2 = trim;
                    } else if (!z10) {
                        trim2 = context.getString(R.string.organization_company_and_title, trim2, trim);
                    }
                    if (!TextUtils.isEmpty(trim2)) {
                        return trim2;
                    }
                }
            }
        }
        return null;
    }

    public static String c(Context context, ContactLoader.Result result) {
        return String.valueOf(ContentUris.parseId(result.L()));
    }

    public static CharSequence d(Context context, ContactLoader.Result result) {
        if (result == null) {
            return "";
        }
        String B10 = result.B();
        String q10 = result.q();
        C1393c c1393c = new C1393c(context);
        if (!TextUtils.isEmpty(B10) && !TextUtils.isEmpty(q10)) {
            if (c1393c.g() != 1) {
                return q10;
            }
            return B10;
        }
        return context.getResources().getString(R.string.missing_name);
    }

    public static CharSequence e(Context context, ContactLoader.Result result) {
        String B10 = result.B();
        String q10 = result.q();
        C1393c c1393c = new C1393c(context);
        if (!TextUtils.isEmpty(B10) && !TextUtils.isEmpty(q10)) {
            if (c1393c.g() != 1) {
                return q10;
            }
            return B10;
        }
        return "";
    }

    public static String f(Context context, ContactLoader.Result result) {
        String Q10 = result.Q();
        if (!TextUtils.isEmpty(Q10)) {
            return Q10;
        }
        return null;
    }

    public static String g(Context context, ContactLoader.Result result) {
        if (result == null) {
            return "";
        }
        f(context, result);
        if (result.C() == 37) {
            return null;
        }
        return result.Q();
    }
}
