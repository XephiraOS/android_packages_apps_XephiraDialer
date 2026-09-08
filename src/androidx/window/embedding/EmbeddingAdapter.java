package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import androidx.window.core.PredicateAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.p;
import kotlin.jvm.internal.i;

/* compiled from: EmbeddingAdapter.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class EmbeddingAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final PredicateAdapter f11940a;

    public EmbeddingAdapter(PredicateAdapter predicateAdapter) {
        i.f(predicateAdapter, "predicateAdapter");
        this.f11940a = predicateAdapter;
    }

    public final SplitInfo a(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        boolean z10;
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        i.e(primaryActivityStack, "splitInfo.primaryActivityStack");
        boolean z11 = false;
        try {
            z10 = primaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused) {
            z10 = false;
        }
        List activities = primaryActivityStack.getActivities();
        i.e(activities, "primaryActivityStack.activities");
        ActivityStack activityStack = new ActivityStack(activities, z10);
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        i.e(secondaryActivityStack, "splitInfo.secondaryActivityStack");
        try {
            z11 = secondaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused2) {
        }
        List activities2 = secondaryActivityStack.getActivities();
        i.e(activities2, "secondaryActivityStack.activities");
        return new SplitInfo(activityStack, new ActivityStack(activities2, z11), splitInfo.getSplitRatio());
    }

    public final List<SplitInfo> b(List<? extends androidx.window.extensions.embedding.SplitInfo> splitInfoList) {
        int p10;
        i.f(splitInfoList, "splitInfoList");
        List<? extends androidx.window.extensions.embedding.SplitInfo> list = splitInfoList;
        p10 = p.p(list, 10);
        ArrayList arrayList = new ArrayList(p10);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((androidx.window.extensions.embedding.SplitInfo) it.next()));
        }
        return arrayList;
    }
}
