package mirror.android.app;

import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* loaded from: classes4.dex */
public class ActivityManager {
    public static RefObject IActivityManagerSingleton;

    static {
        RefClass.load((Class<?>) ActivityManager.class, "android.app.ActivityManager");
    }
}
