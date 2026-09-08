package kotlinx.coroutines;

import kotlin.Result;

/* compiled from: CompletionState.kt */
/* loaded from: classes4.dex */
public final class A {
    public static final <T> Object a(Object obj, kotlin.coroutines.c<? super T> cVar) {
        if (obj instanceof C1282x) {
            Result.a aVar = Result.f34166a;
            return Result.b(kotlin.b.a(((C1282x) obj).f34650a));
        }
        return Result.b(obj);
    }

    public static final <T> Object b(Object obj, InterfaceC1266m<?> interfaceC1266m) {
        Throwable d10 = Result.d(obj);
        if (d10 != null) {
            return new C1282x(d10, false, 2, null);
        }
        return obj;
    }

    public static final <T> Object c(Object obj, v9.l<? super Throwable, m9.q> lVar) {
        Throwable d10 = Result.d(obj);
        if (d10 == null) {
            if (lVar != null) {
                return new C1283y(obj, lVar);
            }
            return obj;
        }
        return new C1282x(d10, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, v9.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return c(obj, lVar);
    }
}
