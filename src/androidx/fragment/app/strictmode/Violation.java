package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.i;

/* compiled from: Violation.kt */
/* loaded from: classes.dex */
public abstract class Violation extends RuntimeException {
    private final Fragment fragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Violation(Fragment fragment, String str) {
        super(str);
        i.f(fragment, "fragment");
        this.fragment = fragment;
    }

    public final Fragment a() {
        return this.fragment;
    }
}
