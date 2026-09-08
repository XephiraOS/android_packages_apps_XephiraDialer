package kotlinx.coroutines;

import kotlin.Result;
import kotlinx.coroutines.internal.C1258i;

/* compiled from: DebugStrings.kt */
/* loaded from: classes4.dex */
public final class G {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(kotlin.coroutines.c<?> cVar) {
        Object b10;
        if (cVar instanceof C1258i) {
            return cVar.toString();
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(cVar + '@' + b(cVar));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (Result.d(b10) != null) {
            b10 = cVar.getClass().getName() + '@' + b(cVar);
        }
        return (String) b10;
    }
}
