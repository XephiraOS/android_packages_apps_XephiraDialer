package kotlinx.coroutines.internal;

import a.C0405a;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes4.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f34478a = new C0405a().a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f34479b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f34480c;

    static {
        Object b10;
        Object b11;
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (Result.d(b10) != null) {
            b10 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f34479b = (String) b10;
        try {
            b11 = Result.b(B.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar3 = Result.f34166a;
            b11 = Result.b(kotlin.b.a(th2));
        }
        if (Result.d(b11) != null) {
            b11 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f34480c = (String) b11;
    }

    public static final <E extends Throwable> E a(E e10) {
        return e10;
    }
}
