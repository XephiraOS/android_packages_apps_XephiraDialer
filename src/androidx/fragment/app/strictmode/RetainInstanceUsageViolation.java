package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.i;

/* compiled from: RetainInstanceUsageViolation.kt */
/* loaded from: classes.dex */
public abstract class RetainInstanceUsageViolation extends Violation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetainInstanceUsageViolation(Fragment fragment, String str) {
        super(fragment, str);
        i.f(fragment, "fragment");
    }
}
