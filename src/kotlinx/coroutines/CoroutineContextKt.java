package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC1469c;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes4.dex */
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z10) {
        boolean c10 = c(coroutineContext);
        boolean c11 = c(coroutineContext2);
        if (!c10 && !c11) {
            return coroutineContext.r(coroutineContext2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f34213a;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.y(emptyCoroutineContext, new v9.p<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // v9.p
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.a aVar) {
                B b10;
                if (!(aVar instanceof B)) {
                    return coroutineContext4.r(aVar);
                }
                CoroutineContext.a a10 = ref$ObjectRef.element.a(aVar.getKey());
                if (a10 == null) {
                    if (z10) {
                        b10 = ((B) aVar).S();
                    } else {
                        b10 = (B) aVar;
                    }
                    return coroutineContext4.r(b10);
                }
                Ref$ObjectRef<CoroutineContext> ref$ObjectRef2 = ref$ObjectRef;
                ref$ObjectRef2.element = ref$ObjectRef2.element.L(aVar.getKey());
                return coroutineContext4.r(((B) aVar).o(a10));
            }
        });
        if (c11) {
            ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).y(emptyCoroutineContext, new v9.p<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // v9.p
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.a aVar) {
                    if (aVar instanceof B) {
                        return coroutineContext4.r(((B) aVar).S());
                    }
                    return coroutineContext4.r(aVar);
                }
            });
        }
        return coroutineContext3.r((CoroutineContext) ref$ObjectRef.element);
    }

    public static final String b(CoroutineContext coroutineContext) {
        return null;
    }

    public static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.y(Boolean.FALSE, new v9.p<Boolean, CoroutineContext.a, Boolean>() { // from class: kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1
            public final Boolean b(boolean z10, CoroutineContext.a aVar) {
                boolean z11;
                if (!z10 && !(aVar instanceof B)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, CoroutineContext.a aVar) {
                return b(bool.booleanValue(), aVar);
            }
        })).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        if (!c(coroutineContext2)) {
            return coroutineContext.r(coroutineContext2);
        }
        return a(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext e(E e10, CoroutineContext coroutineContext) {
        CoroutineContext a10 = a(e10.s(), coroutineContext, true);
        if (a10 != S.a() && a10.a(kotlin.coroutines.d.f34217t) == null) {
            return a10.r(S.a());
        }
        return a10;
    }

    public static final O0<?> f(InterfaceC1469c interfaceC1469c) {
        while (!(interfaceC1469c instanceof N) && (interfaceC1469c = interfaceC1469c.getCallerFrame()) != null) {
            if (interfaceC1469c instanceof O0) {
                return (O0) interfaceC1469c;
            }
        }
        return null;
    }

    public static final O0<?> g(kotlin.coroutines.c<?> cVar, CoroutineContext coroutineContext, Object obj) {
        if (!(cVar instanceof InterfaceC1469c) || coroutineContext.a(P0.f34332a) == null) {
            return null;
        }
        O0<?> f10 = f((InterfaceC1469c) cVar);
        if (f10 != null) {
            f10.O0(coroutineContext, obj);
        }
        return f10;
    }
}
