package U7;

import kotlin.jvm.internal.i;

/* compiled from: StringExt.kt */
/* loaded from: classes3.dex */
public final class e {
    public static final boolean a(Character ch) {
        if (ch == null) {
            return false;
        }
        if (!new B9.c('a', 'z').g(ch.charValue()) && !new B9.c('A', 'Z').g(ch.charValue())) {
            return false;
        }
        return true;
    }

    public static final boolean b(CharSequence charSequence) {
        return i.b(charSequence, "#");
    }

    public static final boolean c(CharSequence charSequence) {
        return i.b(charSequence, "*");
    }
}
