package G;

import android.os.Handler;
import android.os.Looper;

/* compiled from: CalleeHandler.java */
/* loaded from: classes.dex */
public class b {
    public static Handler a() {
        if (Looper.myLooper() == null) {
            return new Handler(Looper.getMainLooper());
        }
        return new Handler();
    }
}
