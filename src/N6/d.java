package N6;

import android.os.storage.StorageVolume;
import com.color.inner.os.storage.StorageVolumeWrapper;

/* compiled from: StorageVolumeNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class d {
    public static Object a(StorageVolume storageVolume) {
        return StorageVolumeWrapper.getPath(storageVolume);
    }
}
