package mirror.android.app;

import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefInt;
import com.oplus.utils.reflect.RefObject;
import java.util.Map;

/* loaded from: classes4.dex */
public class SystemServiceRegistry {

    /* loaded from: classes4.dex */
    public static class CachedServiceFetcher {

        /* loaded from: classes4.dex */
        public static class RefInfo {
            private static final String CLASS_NAME = "android.app.SystemServiceRegistry$CachedServiceFetcher";
            private static Class<?> TYPE = RefClass.load((Class<?>) RefInfo.class, CLASS_NAME);
            public static RefInt mCacheIndex;

            private RefInfo() {
            }
        }

        public static int getCacheIndex(Object obj) {
            return RefInfo.mCacheIndex.get(obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class RefInfo {
        public static RefObject<Map<String, ?>> SYSTEM_SERVICE_FETCHERS;
        private static Class<?> TYPE = RefClass.load((Class<?>) RefInfo.class, "android.app.SystemServiceRegistry");

        private RefInfo() {
        }
    }

    /* loaded from: classes4.dex */
    public static class StaticServiceFetcher {

        /* loaded from: classes4.dex */
        public static class RefInfo {
            private static final String CLASS_NAME = "android.app.SystemServiceRegistry$StaticServiceFetcher";
            private static Class<?> TYPE = RefClass.load((Class<?>) RefInfo.class, CLASS_NAME);
            public static RefObject mCachedInstance;

            private RefInfo() {
            }
        }

        public static void setCachedInstance(Object obj, Object obj2) {
            RefInfo.mCachedInstance.set(obj, obj2);
        }
    }

    private SystemServiceRegistry() {
    }

    public static Object getFetcher(String str) {
        return RefInfo.SYSTEM_SERVICE_FETCHERS.get(null).get(str);
    }
}
