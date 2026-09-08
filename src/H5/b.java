package H5;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: ProviderUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static Bundle a(Context context, String str) {
        Bundle c10 = c(context, Uri.parse("content://com.heytap.appplatform.dispatcher/find_transfer/" + str));
        if (c10 == null) {
            return b(context, str);
        }
        return c10;
    }

    public static Bundle b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("com.heytap.epona.Dispatcher.TRANSFER_KEY", str);
        return context.getContentResolver().call("com.heytap.appplatform.dispatcher", "com.heytap.epona.Dispatcher.FIND_TRANSFER", (String) null, bundle);
    }

    public static Bundle c(Context context, Uri uri) {
        try {
            Cursor query = context.getContentResolver().query(uri, null, null, null);
            try {
                if (query == null) {
                    a.c("ProviderUtils", "Get cursor null.", new Object[0]);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                Bundle c10 = D5.a.c(query);
                query.close();
                return c10;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Exception e10) {
            a.c("ProviderUtils", "Get cursor Exception : " + e10, new Object[0]);
            e10.printStackTrace();
            return null;
        }
    }
}
