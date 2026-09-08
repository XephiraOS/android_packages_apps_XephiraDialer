package o9;

/* compiled from: Comparisons.kt */
/* renamed from: o9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1412b {
    public static <T extends Comparable<?>> int a(T t10, T t11) {
        if (t10 == t11) {
            return 0;
        }
        if (t10 == null) {
            return -1;
        }
        if (t11 == null) {
            return 1;
        }
        return t10.compareTo(t11);
    }
}
