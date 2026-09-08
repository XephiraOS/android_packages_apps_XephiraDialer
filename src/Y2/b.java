package Y2;

import android.net.Uri;

/* compiled from: MediaStoreUtil.java */
/* loaded from: classes.dex */
public final class b {
    public static boolean a(Uri uri) {
        if (c(uri) && uri.getPathSegments().contains("picker")) {
            return true;
        }
        return false;
    }

    public static boolean b(Uri uri) {
        if (c(uri) && !f(uri)) {
            return true;
        }
        return false;
    }

    public static boolean c(Uri uri) {
        if (uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public static boolean d(Uri uri) {
        if (c(uri) && f(uri)) {
            return true;
        }
        return false;
    }

    public static boolean e(int i10, int i11) {
        if (i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && i10 <= 512 && i11 <= 384) {
            return true;
        }
        return false;
    }

    public static boolean f(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
