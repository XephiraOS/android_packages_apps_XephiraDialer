package T9;

/* compiled from: LangUtils.java */
/* loaded from: classes4.dex */
public final class e {
    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static int b(int i10, int i11) {
        return (i10 * 37) + i11;
    }

    public static int c(int i10, Object obj) {
        int i11;
        if (obj != null) {
            i11 = obj.hashCode();
        } else {
            i11 = 0;
        }
        return b(i10, i11);
    }
}
