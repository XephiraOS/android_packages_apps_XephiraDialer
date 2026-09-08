package kotlinx.coroutines.internal;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes4.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final LockFreeLinkedListNode f34538a;

    public w(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f34538a = lockFreeLinkedListNode;
    }

    public String toString() {
        return "Removed[" + this.f34538a + ']';
    }
}
