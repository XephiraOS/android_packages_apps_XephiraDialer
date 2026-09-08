package N5;

import java.util.Base64;

/* compiled from: Base64Utils.java */
/* loaded from: classes3.dex */
public class a {
    public static byte[] a(String str) {
        return Base64.getDecoder().decode(str);
    }
}
