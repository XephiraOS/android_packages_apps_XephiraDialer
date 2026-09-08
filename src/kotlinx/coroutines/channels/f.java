package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.internal.z;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public final class f<E> extends z<f<E>> {

    /* renamed from: e, reason: collision with root package name */
    public final BufferedChannel<E> f34413e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceArray f34414f;

    public f(long j10, f<E> fVar, BufferedChannel<E> bufferedChannel, int i10) {
        super(j10, fVar, i10);
        this.f34413e = bufferedChannel;
        this.f34414f = new AtomicReferenceArray(BufferedChannelKt.f34386b * 2);
    }

    public final void A(int i10, Object obj) {
        this.f34414f.set((i10 * 2) + 1, obj);
    }

    public final void B(int i10, E e10) {
        z(i10, e10);
    }

    @Override // kotlinx.coroutines.internal.z
    public int n() {
        return BufferedChannelKt.f34386b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0063, code lost:
    
        s(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0066, code lost:
    
        if (r0 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0068, code lost:
    
        r3 = u().f34378b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006e, code lost:
    
        if (r3 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0070, code lost:
    
        kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r3, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(int r4, java.lang.Throwable r5, kotlin.coroutines.CoroutineContext r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f34386b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.v(r4)
        Le:
            java.lang.Object r1 = r3.w(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.Q0
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.p
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            kotlinx.coroutines.internal.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            if (r1 == r2) goto L63
            kotlinx.coroutines.internal.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
            if (r1 != r2) goto L28
            goto L63
        L28:
            kotlinx.coroutines.internal.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r1 == r2) goto Le
            kotlinx.coroutines.internal.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            kotlinx.coroutines.internal.C r3 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r1 == r3) goto L62
            kotlinx.coroutines.internal.C r3 = kotlinx.coroutines.channels.BufferedChannelKt.f34388d
            if (r1 != r3) goto L40
            goto L62
        L40:
            kotlinx.coroutines.internal.C r3 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            if (r1 != r3) goto L47
            return
        L47:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "unexpected state: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L62:
            return
        L63:
            r3.s(r4)
            if (r0 == 0) goto L73
            kotlinx.coroutines.channels.BufferedChannel r3 = r3.u()
            v9.l<E, m9.q> r3 = r3.f34378b
            if (r3 == 0) goto L73
            kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r3, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            kotlinx.coroutines.internal.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            goto L7f
        L7b:
            kotlinx.coroutines.internal.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
        L7f:
            boolean r1 = r3.r(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.s(r4)
            r1 = r0 ^ 1
            r3.x(r4, r1)
            if (r0 == 0) goto L9a
            kotlinx.coroutines.channels.BufferedChannel r3 = r3.u()
            v9.l<E, m9.q> r3 = r3.f34378b
            if (r3 == 0) goto L9a
            kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r3, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.f.o(int, java.lang.Throwable, kotlin.coroutines.CoroutineContext):void");
    }

    public final boolean r(int i10, Object obj, Object obj2) {
        return this.f34414f.compareAndSet((i10 * 2) + 1, obj, obj2);
    }

    public final void s(int i10) {
        z(i10, null);
    }

    public final Object t(int i10, Object obj) {
        return this.f34414f.getAndSet((i10 * 2) + 1, obj);
    }

    public final BufferedChannel<E> u() {
        BufferedChannel<E> bufferedChannel = this.f34413e;
        kotlin.jvm.internal.i.c(bufferedChannel);
        return bufferedChannel;
    }

    public final E v(int i10) {
        return (E) this.f34414f.get(i10 * 2);
    }

    public final Object w(int i10) {
        return this.f34414f.get((i10 * 2) + 1);
    }

    public final void x(int i10, boolean z10) {
        if (z10) {
            u().z0((this.f34541c * BufferedChannelKt.f34386b) + i10);
        }
        p();
    }

    public final E y(int i10) {
        E v10 = v(i10);
        s(i10);
        return v10;
    }

    public final void z(int i10, Object obj) {
        this.f34414f.lazySet(i10 * 2, obj);
    }
}
