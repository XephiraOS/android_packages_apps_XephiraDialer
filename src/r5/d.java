package r5;

/* compiled from: ClassUtils.java */
/* loaded from: classes3.dex */
public class d {
    public static boolean a(Class cls, Class cls2) {
        Class superclass;
        if (cls2 == null || cls == null || (superclass = cls2.getSuperclass()) == null) {
            return false;
        }
        if (superclass.equals(cls)) {
            return true;
        }
        return a(cls, superclass);
    }
}
