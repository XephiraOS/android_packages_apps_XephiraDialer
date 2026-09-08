package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.PropertyReference0Impl;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes4.dex */
public class LockFreeLinkedListNode {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34490a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34491b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34492c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes4.dex */
    public static abstract class a extends AbstractC1251b<LockFreeLinkedListNode> {

        /* renamed from: b, reason: collision with root package name */
        public final LockFreeLinkedListNode f34493b;

        /* renamed from: c, reason: collision with root package name */
        public LockFreeLinkedListNode f34494c;

        public a(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f34493b = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.AbstractC1251b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z10;
            LockFreeLinkedListNode lockFreeLinkedListNode2;
            if (obj == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                lockFreeLinkedListNode2 = this.f34493b;
            } else {
                lockFreeLinkedListNode2 = this.f34494c;
            }
            if (lockFreeLinkedListNode2 != null && LockFreeLinkedListNode.f34490a.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z10) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.f34493b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f34494c;
                kotlin.jvm.internal.i.c(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.l(lockFreeLinkedListNode4);
            }
        }
    }

    public final boolean i(LockFreeLinkedListNode lockFreeLinkedListNode) {
        f34491b.lazySet(lockFreeLinkedListNode, this);
        f34490a.lazySet(lockFreeLinkedListNode, this);
        while (m() == this) {
            if (f34490a.compareAndSet(this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.l(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        if (r4.compareAndSet(r3, r2, ((kotlinx.coroutines.internal.w) r5).f34538a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode j(kotlinx.coroutines.internal.v r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f34491b
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f34490a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L20
            if (r0 != r2) goto L16
            return r2
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f34491b
            boolean r0 = r1.compareAndSet(r8, r0, r2)
            if (r0 != 0) goto L1f
            goto L0
        L1f:
            return r2
        L20:
            boolean r6 = r8.p()
            if (r6 == 0) goto L27
            return r1
        L27:
            if (r5 != r9) goto L2a
            return r2
        L2a:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.v
            if (r6 == 0) goto L34
            kotlinx.coroutines.internal.v r5 = (kotlinx.coroutines.internal.v) r5
            r5.a(r2)
            goto L0
        L34:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.w
            if (r6 == 0) goto L50
            if (r3 == 0) goto L47
            kotlinx.coroutines.internal.w r5 = (kotlinx.coroutines.internal.w) r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = r5.f34538a
            boolean r2 = r4.compareAndSet(r3, r2, r5)
            if (r2 != 0) goto L45
            goto L0
        L45:
            r2 = r3
            goto La
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f34491b
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto Lb
        L50:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.i.d(r5, r3)
            r3 = r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.j(kotlinx.coroutines.internal.v):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final LockFreeLinkedListNode k(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.p()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) f34491b.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }

    public final void l(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34491b;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (m() != lockFreeLinkedListNode) {
                return;
            }
        } while (!f34491b.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (p()) {
            lockFreeLinkedListNode.j(null);
        }
    }

    public final Object m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34490a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof v)) {
                return obj;
            }
            ((v) obj).a(this);
        }
    }

    public final LockFreeLinkedListNode n() {
        return o.b(m());
    }

    public final LockFreeLinkedListNode o() {
        LockFreeLinkedListNode j10 = j(null);
        if (j10 == null) {
            return k((LockFreeLinkedListNode) f34491b.get(this));
        }
        return j10;
    }

    public boolean p() {
        return m() instanceof w;
    }

    public boolean q() {
        if (r() == null) {
            return true;
        }
        return false;
    }

    public final LockFreeLinkedListNode r() {
        Object m10;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            m10 = m();
            if (m10 instanceof w) {
                return ((w) m10).f34538a;
            }
            if (m10 == this) {
                return (LockFreeLinkedListNode) m10;
            }
            kotlin.jvm.internal.i.d(m10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) m10;
        } while (!f34490a.compareAndSet(this, m10, lockFreeLinkedListNode.s()));
        lockFreeLinkedListNode.j(null);
        return null;
    }

    public final w s() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34492c;
        w wVar = (w) atomicReferenceFieldUpdater.get(this);
        if (wVar == null) {
            w wVar2 = new w(this);
            atomicReferenceFieldUpdater.lazySet(this, wVar2);
            return wVar2;
        }
        return wVar;
    }

    public final int t(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, a aVar) {
        f34491b.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34490a;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        aVar.f34494c = lockFreeLinkedListNode2;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedListNode2, aVar)) {
            return 0;
        }
        if (aVar.a(this) == null) {
            return 1;
        }
        return 2;
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, C9.h
            public Object get() {
                return kotlinx.coroutines.G.a(this.receiver);
            }
        } + '@' + kotlinx.coroutines.G.b(this);
    }
}
