package N6;

import android.content.Context;
import com.color.inner.os.storage.StorageManagerWrapper;

/* compiled from: StorageManagerNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class b {
    public static Object a(Context context, String str) {
        return StorageManagerWrapper.getVolumeState(context, str);
    }
}
