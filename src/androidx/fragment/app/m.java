package androidx.fragment.app;

import android.os.Bundle;

/* compiled from: Fragment.kt */
/* loaded from: classes.dex */
public final class m {
    public static final void a(Fragment fragment, String requestKey, Bundle result) {
        kotlin.jvm.internal.i.f(fragment, "<this>");
        kotlin.jvm.internal.i.f(requestKey, "requestKey");
        kotlin.jvm.internal.i.f(result, "result");
        fragment.getParentFragmentManager().A1(requestKey, result);
    }
}
