package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.internal.y;
import v9.p;

/* compiled from: SafeCollector.common.kt */
/* loaded from: classes4.dex */
public final class SafeCollector_commonKt {
    public static final void a(final SafeCollector<?> safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.y(0, new p<Integer, CoroutineContext.a, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final Integer b(int i10, CoroutineContext.a aVar) {
                int i11;
                CoroutineContext.b<?> key = aVar.getKey();
                CoroutineContext.a a10 = safeCollector.collectContext.a(key);
                if (key != InterfaceC1265l0.f34546v) {
                    if (aVar != a10) {
                        i11 = Integer.MIN_VALUE;
                    } else {
                        i11 = i10 + 1;
                    }
                    return Integer.valueOf(i11);
                }
                InterfaceC1265l0 interfaceC1265l0 = (InterfaceC1265l0) a10;
                kotlin.jvm.internal.i.d(aVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                InterfaceC1265l0 b10 = SafeCollector_commonKt.b((InterfaceC1265l0) aVar, interfaceC1265l0);
                if (b10 == interfaceC1265l0) {
                    if (interfaceC1265l0 != null) {
                        i10++;
                    }
                    return Integer.valueOf(i10);
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b10 + ", expected child of " + interfaceC1265l0 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.a aVar) {
                return b(num.intValue(), aVar);
            }
        })).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final InterfaceC1265l0 b(InterfaceC1265l0 interfaceC1265l0, InterfaceC1265l0 interfaceC1265l02) {
        while (interfaceC1265l0 != null) {
            if (interfaceC1265l0 == interfaceC1265l02) {
                return interfaceC1265l0;
            }
            if (!(interfaceC1265l0 instanceof y)) {
                return interfaceC1265l0;
            }
            interfaceC1265l0 = interfaceC1265l0.getParent();
        }
        return null;
    }
}
