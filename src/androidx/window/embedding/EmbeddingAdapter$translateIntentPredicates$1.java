package androidx.window.embedding;

import android.content.Intent;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: EmbeddingAdapter.kt */
/* loaded from: classes.dex */
final class EmbeddingAdapter$translateIntentPredicates$1 extends Lambda implements l<Intent, Boolean> {
    final /* synthetic */ Set<ActivityFilter> $activityFilters;

    @Override // v9.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Intent intent) {
        i.f(intent, "intent");
        Set<ActivityFilter> set = this.$activityFilters;
        boolean z10 = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((ActivityFilter) it.next()).b(intent)) {
                    z10 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z10);
    }
}
