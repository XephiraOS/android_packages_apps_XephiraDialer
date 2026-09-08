package kotlin.text;

/* compiled from: CharJVM.kt */
/* loaded from: classes4.dex */
public class b {
    public static int a(int i10) {
        if (new B9.f(2, 36).i(i10)) {
            return i10;
        }
        throw new IllegalArgumentException("radix " + i10 + " was not in valid range " + new B9.f(2, 36));
    }

    public static final int b(char c10, int i10) {
        return Character.digit((int) c10, i10);
    }

    public static final boolean c(char c10) {
        if (!Character.isWhitespace(c10) && !Character.isSpaceChar(c10)) {
            return false;
        }
        return true;
    }
}
