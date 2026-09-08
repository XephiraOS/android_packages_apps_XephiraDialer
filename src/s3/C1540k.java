package s3;

import android.text.TextUtils;
import java.util.Collection;

/* compiled from: Preconditions.java */
/* renamed from: s3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1540k {
    public static void a(boolean z10, String str) {
        if (z10) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T extends Collection<Y>, Y> T c(T t10) {
        if (!t10.isEmpty()) {
            return t10;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public static <T> T d(T t10) {
        return (T) e(t10, "Argument must not be null");
    }

    public static <T> T e(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }
}
