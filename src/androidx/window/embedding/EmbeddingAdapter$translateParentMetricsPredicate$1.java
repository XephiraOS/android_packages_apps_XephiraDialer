package androidx.window.embedding;

import android.view.WindowMetrics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: EmbeddingAdapter.kt */
/* loaded from: classes.dex */
final class EmbeddingAdapter$translateParentMetricsPredicate$1 extends Lambda implements l<WindowMetrics, Boolean> {
    final /* synthetic */ SplitRule $splitRule;

    @Override // v9.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(WindowMetrics windowMetrics) {
        i.f(windowMetrics, "windowMetrics");
        return Boolean.valueOf(this.$splitRule.a(windowMetrics));
    }
}
