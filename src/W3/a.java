package W3;

import D7.c;
import H7.b;
import R0.d;
import android.content.ContentUris;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.customize.contacts.util.b0;

/* compiled from: SimQueryHandler.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f4188a = {BreenoCallContract.BaseColumns._ID, "name", "number", "emails", "additionalNumber"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f4189b = {"adn_max", "adn_used", "anr_max", "anr_used", "email_max", "email_used"};

    public static String[] a() {
        return f4188a;
    }

    public static Uri b(Context context, int i10) {
        Uri uri = d.b.f3245c;
        if (B3.a.T()) {
            return Uri.withAppendedPath(d.b.f3246d, String.valueOf(c.r(context, Integer.valueOf(i10))));
        }
        if (B3.a.R()) {
            return b0.I0(context, i10);
        }
        return uri;
    }

    public static Cursor c(Context context, int i10) {
        if (i10 < 0) {
            b.c("SimQueryHandler", "invalid slotId " + i10);
            return null;
        }
        Uri b10 = b(context, i10);
        if (b10 == null) {
            b.c("SimQueryHandler", "fail to get sim uri");
            return null;
        }
        return context.getContentResolver().query(b10, a(), null, null, null);
    }

    public static void d(Context context, int i10) {
        boolean z10;
        try {
            Cursor query = context.getContentResolver().query(ContentUris.withAppendedId(d.b.f3252j, c.r(context, Integer.valueOf(i10))), f4189b, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i11 = query.getInt(query.getColumnIndex("email_max"));
                        int i12 = query.getInt(query.getColumnIndex("anr_max"));
                        b.b("SimQueryHandler", "whetherSupportEmailAndAnr emailMax = " + i11 + ", anrMax = " + i12);
                        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                        StringBuilder sb = new StringBuilder();
                        sb.append("max_email");
                        sb.append(i10);
                        String sb2 = sb.toString();
                        boolean z11 = false;
                        if (i11 > 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        edit.putBoolean(sb2, z10);
                        String str = "max_anr" + i10;
                        if (i12 > 0) {
                            z11 = true;
                        }
                        edit.putBoolean(str, z11);
                        edit.commit();
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            b.c("SimQueryHandler", "fail to put adn capacity" + e10);
        }
    }
}
