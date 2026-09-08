package kotlin.coroutines;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.i;
import m9.q;
import v9.p;

/* compiled from: Continuation.kt */
/* loaded from: classes4.dex */
public final class e {
    public static final <R, T> void a(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> completion) {
        c a10;
        c b10;
        i.f(pVar, "<this>");
        i.f(completion, "completion");
        a10 = IntrinsicsKt__IntrinsicsJvmKt.a(pVar, r10, completion);
        b10 = IntrinsicsKt__IntrinsicsJvmKt.b(a10);
        Result.a aVar = Result.f34166a;
        b10.resumeWith(Result.b(q.f35511a));
    }
}
