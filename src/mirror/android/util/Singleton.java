package mirror.android.util;

import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* loaded from: classes4.dex */
public class Singleton {
    public static RefObject mInstance;

    static {
        RefClass.load((Class<?>) Singleton.class, "android.util.Singleton");
    }
}
