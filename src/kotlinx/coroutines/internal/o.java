package kotlinx.coroutines.internal;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f34525a = new C("CONDITION_FALSE");

    public static final Object a() {
        return f34525a;
    }

    public static final LockFreeLinkedListNode b(Object obj) {
        w wVar;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        if (obj instanceof w) {
            wVar = (w) obj;
        } else {
            wVar = null;
        }
        if (wVar == null || (lockFreeLinkedListNode = wVar.f34538a) == null) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            return (LockFreeLinkedListNode) obj;
        }
        return lockFreeLinkedListNode;
    }
}
