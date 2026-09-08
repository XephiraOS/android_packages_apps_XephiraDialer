package androidx.window.embedding;

import android.app.Activity;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: EmbeddingAdapter.kt */
/* loaded from: classes.dex */
final class EmbeddingAdapter$translateActivityPredicates$1 extends Lambda implements l<Activity, Boolean> {
    final /* synthetic */ Set<ActivityFilter> $activityFilters;

    @Override // v9.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Activity activity) {
        i.f(activity, "activity");
        Set<ActivityFilter> set = this.$activityFilters;
        boolean z10 = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((ActivityFilter) it.next()).a(activity)) {
                    z10 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z10);
    }
}
