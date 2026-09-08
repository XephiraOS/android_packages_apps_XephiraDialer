package N6;

import android.os.storage.StorageVolume;
import android.util.Log;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.inner.os.storage.StorageVolumeWrapper;

/* compiled from: StorageVolumeNative.java */
/* loaded from: classes3.dex */
public class c {
    public static String a(StorageVolume storageVolume) {
        if (S6.c.n()) {
            try {
                return storageVolume.getPath();
            } catch (NoSuchMethodError e10) {
                Log.e("StorageVolumeNative", e10.toString());
                throw new UnSupportedApiVersionException("no permission to access the blocked method", e10);
            }
        }
        if (S6.c.j()) {
            return StorageVolumeWrapper.getPath(storageVolume);
        }
        if (S6.c.l()) {
            return (String) b(storageVolume);
        }
        if (S6.c.f()) {
            return storageVolume.getPath();
        }
        throw new UnSupportedApiVersionException();
    }

    public static Object b(StorageVolume storageVolume) {
        return d.a(storageVolume);
    }
}
