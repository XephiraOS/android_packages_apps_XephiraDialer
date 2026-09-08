package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import m9.q;
import v9.p;

/* compiled from: SequenceBuilder.kt */
/* loaded from: classes4.dex */
public class i {
    public static <T> Iterator<T> a(p<? super g<? super T>, ? super kotlin.coroutines.c<? super q>, ? extends Object> block) {
        kotlin.coroutines.c<? super q> a10;
        kotlin.jvm.internal.i.f(block, "block");
        f fVar = new f();
        a10 = IntrinsicsKt__IntrinsicsJvmKt.a(block, fVar, fVar);
        fVar.e(a10);
        return fVar;
    }
}
