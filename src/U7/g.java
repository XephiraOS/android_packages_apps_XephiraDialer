package U7;

import android.net.Uri;

/* compiled from: UriUtils.java */
/* loaded from: classes3.dex */
public class g {
    public static boolean a(Uri uri, Uri uri2) {
        if (uri == null && uri2 == null) {
            return true;
        }
        if (uri != null && uri2 != null) {
            return uri.equals(uri2);
        }
        return false;
    }

    public static Uri b(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    public static String c(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }
}
