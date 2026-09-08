package E7;

import android.content.Intent;
import android.net.Uri;

/* compiled from: StructuredPostalUtils.java */
/* loaded from: classes3.dex */
public class c {
    public static Uri a(String str) {
        return Uri.parse("geo:0,0?q=" + Uri.encode(str));
    }

    public static Intent b(String str) {
        return new Intent("android.intent.action.VIEW", a(str));
    }
}
