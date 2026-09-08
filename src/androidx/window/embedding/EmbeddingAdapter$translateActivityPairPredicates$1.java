package androidx.window.embedding;

import android.app.Activity;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import v9.p;

/* compiled from: EmbeddingAdapter.kt */
/* loaded from: classes.dex */
final class EmbeddingAdapter$translateActivityPairPredicates$1 extends Lambda implements p<Activity, Activity, Boolean> {
    final /* synthetic */ Set<SplitPairFilter> $splitPairFilters;

    @Override // v9.p
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Activity first, Activity second) {
        i.f(first, "first");
        i.f(second, "second");
        Set<SplitPairFilter> set = this.$splitPairFilters;
        boolean z10 = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((SplitPairFilter) it.next()).b(first, second)) {
                    z10 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z10);
    }
}
