package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;

/* compiled from: BundleCompat.java */
@Deprecated
/* loaded from: classes.dex */
public final class e {
    @Deprecated
    public static IBinder a(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    @Deprecated
    public static void b(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
