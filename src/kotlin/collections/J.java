package kotlin.collections;

import java.util.Collections;
import java.util.Set;

/* compiled from: SetsJVM.kt */
/* loaded from: classes4.dex */
public class J {
    public static final <T> Set<T> a(T t10) {
        Set<T> singleton = Collections.singleton(t10);
        kotlin.jvm.internal.i.e(singleton, "singleton(...)");
        return singleton;
    }
}
