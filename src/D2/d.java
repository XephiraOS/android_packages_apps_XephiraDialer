package D2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/* compiled from: OplusIntentUtils.java */
/* loaded from: classes.dex */
public final class d {
    public static boolean a(Intent intent, String str, boolean z10) {
        if (intent == null) {
            return z10;
        }
        try {
            return intent.getBooleanExtra(str, z10);
        } catch (Exception e10) {
            Log.d("OplusIntentUtils", e10.getMessage());
            return z10;
        }
    }

    public static Bundle b(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getExtras();
        } catch (Exception e10) {
            Log.d("OplusIntentUtils", e10.toString());
            return null;
        }
    }

    public static int c(Intent intent, String str, int i10) {
        if (intent == null) {
            return i10;
        }
        try {
            return intent.getIntExtra(str, i10);
        } catch (Exception e10) {
            Log.d("OplusIntentUtils", e10.toString());
            return i10;
        }
    }
}
