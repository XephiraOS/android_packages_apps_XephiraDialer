package N6;

import android.content.Context;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.inner.os.storage.StorageEventListenerWrapper;
import com.oplus.utils.reflect.MethodName;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;
import java.util.HashMap;
import java.util.List;

/* compiled from: StorageManagerNative.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<Object, StorageEventListenerWrapper> f2374a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<Object, Object> f2375b = new HashMap<>();

    /* compiled from: StorageManagerNative.java */
    /* renamed from: N6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0049a {

        @MethodName(name = "getVolumeList", params = {int.class, int.class})
        private static RefMethod<StorageVolume[]> getVolumeList;
        private static RefMethod<String[]> getVolumePaths;
        private static RefMethod<String> getVolumeState;
        private static RefMethod<List<Object>> getVolumes;
        private static RefMethod<Boolean> isFileEncryptedNativeOnly;

        static {
            RefClass.load((Class<?>) C0049a.class, (Class<?>) StorageManager.class);
        }
    }

    public static StorageVolume[] a(int i10, int i11) {
        if (S6.c.f()) {
            return (StorageVolume[]) C0049a.getVolumeList.call(null, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new UnSupportedApiVersionException("not supported before M");
    }

    public static String b(Context context, String str) {
        if (S6.c.m()) {
            return (String) C0049a.getVolumeState.call((StorageManager) context.getSystemService("storage"), str);
        }
        if (S6.c.l()) {
            return (String) c(context, str);
        }
        if (S6.c.i()) {
            return ((StorageManager) context.getSystemService("storage")).getVolumeState(str);
        }
        throw new UnSupportedApiVersionException("not supported before O");
    }

    public static Object c(Context context, String str) {
        return b.a(context, str);
    }
}
