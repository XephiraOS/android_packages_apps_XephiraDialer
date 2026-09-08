package kotlin.text;

import java.util.NoSuchElementException;

/* compiled from: _Strings.kt */
/* loaded from: classes4.dex */
public class p extends o {
    public static final String k0(String str, int i10) {
        int e10;
        kotlin.jvm.internal.i.f(str, "<this>");
        if (i10 >= 0) {
            e10 = B9.i.e(i10, str.length());
            String substring = str.substring(e10);
            kotlin.jvm.internal.i.e(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char l0(CharSequence charSequence) {
        int D10;
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            D10 = StringsKt__StringsKt.D(charSequence);
            return charSequence.charAt(D10);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }
}
