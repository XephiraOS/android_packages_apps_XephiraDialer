package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.H0;

/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
public final class ThreadContextKt {

    /* renamed from: a, reason: collision with root package name */
    public static final C f34495a = new C("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    public static final v9.p<Object, CoroutineContext.a, Object> f34496b = new v9.p<Object, CoroutineContext.a, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // v9.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, CoroutineContext.a aVar) {
            Integer num;
            int i10;
            if (aVar instanceof H0) {
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                } else {
                    num = null;
                }
                if (num != null) {
                    i10 = num.intValue();
                } else {
                    i10 = 1;
                }
                if (i10 != 0) {
                    return Integer.valueOf(i10 + 1);
                }
                return aVar;
            }
            return obj;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final v9.p<H0<?>, CoroutineContext.a, H0<?>> f34497c = new v9.p<H0<?>, CoroutineContext.a, H0<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // v9.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final H0<?> invoke(H0<?> h02, CoroutineContext.a aVar) {
            if (h02 != null) {
                return h02;
            }
            if (aVar instanceof H0) {
                return (H0) aVar;
            }
            return null;
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public static final v9.p<J, CoroutineContext.a, J> f34498d = new v9.p<J, CoroutineContext.a, J>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // v9.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final J invoke(J j10, CoroutineContext.a aVar) {
            if (aVar instanceof H0) {
                H0<?> h02 = (H0) aVar;
                j10.a(h02, h02.a0(j10.f34486a));
            }
            return j10;
        }
    };

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f34495a) {
            return;
        }
        if (obj instanceof J) {
            ((J) obj).b(coroutineContext);
            return;
        }
        Object y10 = coroutineContext.y(null, f34497c);
        kotlin.jvm.internal.i.d(y10, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((H0) y10).U(coroutineContext, obj);
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object y10 = coroutineContext.y(0, f34496b);
        kotlin.jvm.internal.i.c(y10);
        return y10;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f34495a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.y(new J(coroutineContext, ((Number) obj).intValue()), f34498d);
        }
        kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((H0) obj).a0(coroutineContext);
    }
}
