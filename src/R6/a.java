package R6;

/* compiled from: OplusTypeCastingHelperNative.java */
/* loaded from: classes3.dex */
public class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(Class<T> cls, Object obj) {
        if (obj != 0 && cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
