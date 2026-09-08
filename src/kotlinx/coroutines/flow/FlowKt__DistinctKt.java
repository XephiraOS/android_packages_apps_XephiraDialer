package kotlinx.coroutines.flow;

/* compiled from: Distinct.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__DistinctKt {

    /* renamed from: a, reason: collision with root package name */
    public static final v9.l<Object, Object> f34431a = new v9.l<Object, Object>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
        @Override // v9.l
        public final Object invoke(Object obj) {
            return obj;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final v9.p<Object, Object, Boolean> f34432b = new v9.p<Object, Object, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
        @Override // v9.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(kotlin.jvm.internal.i.b(obj, obj2));
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> a<T> a(a<? extends T> aVar) {
        if (!(aVar instanceof m)) {
            return b(aVar, f34431a, f34432b);
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> a<T> b(a<? extends T> aVar, v9.l<? super T, ? extends Object> lVar, v9.p<Object, Object, Boolean> pVar) {
        if (aVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) aVar;
            if (distinctFlowImpl.f34426b == lVar && distinctFlowImpl.f34427c == pVar) {
                return aVar;
            }
        }
        return new DistinctFlowImpl(aVar, lVar, pVar);
    }
}
