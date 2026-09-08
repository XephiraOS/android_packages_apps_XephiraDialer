package androidx.emoji2.text;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* compiled from: EmojiExclusions.java */
/* loaded from: classes.dex */
public class g {

    /* compiled from: EmojiExclusions.java */
    /* loaded from: classes.dex */
    public static class a {
        public static Set<int[]> a() {
            return b.a();
        }
    }

    /* compiled from: EmojiExclusions.java */
    /* loaded from: classes.dex */
    public static class b {
        public static Set<int[]> a() {
            try {
                Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
                if (invoke == null) {
                    return Collections.emptySet();
                }
                Set<int[]> set = (Set) invoke;
                Iterator<int[]> it = set.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof int[])) {
                        return Collections.emptySet();
                    }
                }
                return set;
            } catch (Throwable unused) {
                return Collections.emptySet();
            }
        }
    }

    public static Set<int[]> a() {
        return a.a();
    }
}
