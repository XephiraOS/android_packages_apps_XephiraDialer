package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.internal.D;
import v9.q;

/* compiled from: Merge.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f34435a = D.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    public static final <T, R> a<R> a(a<? extends T> aVar, v9.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return c.j(aVar, new FlowKt__MergeKt$mapLatest$1(pVar, null));
    }

    public static final <T, R> a<R> b(a<? extends T> aVar, q<? super b<? super R>, ? super T, ? super kotlin.coroutines.c<? super m9.q>, ? extends Object> qVar) {
        return new ChannelFlowTransformLatest(qVar, aVar, null, 0, null, 28, null);
    }
}
