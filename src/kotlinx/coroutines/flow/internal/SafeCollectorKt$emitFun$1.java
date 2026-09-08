package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.FunctionReferenceImpl;
import v9.q;

/* compiled from: SafeCollector.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements q<kotlinx.coroutines.flow.b<? super Object>, Object, kotlin.coroutines.c<? super m9.q>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final SafeCollectorKt$emitFun$1 f34451a = new SafeCollectorKt$emitFun$1();

    public SafeCollectorKt$emitFun$1() {
        super(3, kotlinx.coroutines.flow.b.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // v9.q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object d(kotlinx.coroutines.flow.b<Object> bVar, Object obj, kotlin.coroutines.c<? super m9.q> cVar) {
        return bVar.emit(obj, cVar);
    }
}
