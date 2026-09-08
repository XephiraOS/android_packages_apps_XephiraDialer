package k7;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.oplus.utils.C0864z;
import g7.C1050a;

/* compiled from: ProviderUtils.java */
/* renamed from: k7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1217b {
    public static Bundle a(Context context, String str) {
        Bundle c10 = c(context, Uri.parse("content://com.oplus.appplatform.dispatcher/find_transfer/" + str));
        if (c10 == null) {
            return b(context, str);
        }
        return c10;
    }

    public static Bundle b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("com.oplus.epona.Dispatcher.TRANSFER_KEY", str);
        try {
            return context.getContentResolver().call("com.oplus.appplatform.dispatcher", "com.oplus.epona.Dispatcher.FIND_TRANSFER", (String) null, bundle);
        } catch (Exception unused) {
            C0864z.d("Epona->ProviderUtils", "failed to call provider: com.oplus.appplatform.dispatcher", new Object[0]);
            return null;
        }
    }

    public static Bundle c(Context context, Uri uri) {
        try {
            Cursor query = context.getContentResolver().query(uri, null, null, null);
            try {
                if (query == null) {
                    C0864z.d("Epona->ProviderUtils", "Get cursor null.", new Object[0]);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                Bundle c10 = C1050a.c(query);
                query.close();
                return c10;
            } finally {
            }
        } catch (Exception e10) {
            C0864z.d("Epona->ProviderUtils", "Get cursor Exception : " + e10, new Object[0]);
            e10.printStackTrace();
            return null;
        }
    }
}
