package E7;

import android.content.Intent;
import android.net.Uri;
import java.io.File;

/* compiled from: Intents.java */
/* loaded from: classes3.dex */
public class a {
    public static Intent a(String str) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(new File(str)));
        return intent;
    }
}
