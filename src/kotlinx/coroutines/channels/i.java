package kotlinx.coroutines.channels;

import kotlinx.coroutines.Q0;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import m9.q;

/* compiled from: ConflatedBufferedChannel.kt */
/* loaded from: classes4.dex */
public class i<E> extends BufferedChannel<E> {

    /* renamed from: m, reason: collision with root package name */
    public final int f34415m;

    /* renamed from: n, reason: collision with root package name */
    public final BufferOverflow f34416n;

    public i(int i10, BufferOverflow bufferOverflow, v9.l<? super E, q> lVar) {
        super(i10, lVar);
        this.f34415m = i10;
        this.f34416n = bufferOverflow;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            if (i10 >= 1) {
                return;
            }
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i10 + " was specified").toString());
        }
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + kotlin.jvm.internal.k.b(BufferedChannel.class).c() + " instead").toString());
    }

    public static /* synthetic */ <E> Object A0(i<E> iVar, E e10, kotlin.coroutines.c<? super q> cVar) {
        UndeliveredElementException d10;
        Object D02 = iVar.D0(e10, true);
        if (D02 instanceof e.a) {
            e.e(D02);
            v9.l<E, q> lVar = iVar.f34378b;
            if (lVar != null && (d10 = OnUndeliveredElementKt.d(lVar, e10, null, 2, null)) != null) {
                m9.b.a(d10, iVar.I());
                throw d10;
            }
            throw iVar.I();
        }
        return q.f35511a;
    }

    public final Object B0(E e10, boolean z10) {
        v9.l<E, q> lVar;
        UndeliveredElementException d10;
        Object j10 = super.j(e10);
        if (!e.h(j10) && !e.g(j10)) {
            if (z10 && (lVar = this.f34378b) != null && (d10 = OnUndeliveredElementKt.d(lVar, e10, null, 2, null)) != null) {
                throw d10;
            }
            return e.f34409b.c(q.f35511a);
        }
        return j10;
    }

    public final Object C0(E e10) {
        f fVar;
        Q0 q02;
        Object obj = BufferedChannelKt.f34388d;
        f fVar2 = (f) BufferedChannel.f34372h.get(this);
        while (true) {
            long andIncrement = BufferedChannel.f34368d.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean T10 = T(andIncrement);
            int i10 = BufferedChannelKt.f34386b;
            long j11 = j10 / i10;
            int i11 = (int) (j10 % i10);
            if (fVar2.f34541c != j11) {
                f D10 = D(j11, fVar2);
                if (D10 == null) {
                    if (T10) {
                        return e.f34409b.a(I());
                    }
                } else {
                    fVar = D10;
                }
            } else {
                fVar = fVar2;
            }
            int v02 = v0(fVar, i11, e10, j10, obj, T10);
            if (v02 != 0) {
                if (v02 != 1) {
                    if (v02 != 2) {
                        if (v02 != 3) {
                            if (v02 != 4) {
                                if (v02 == 5) {
                                    fVar.b();
                                }
                                fVar2 = fVar;
                            } else {
                                if (j10 < H()) {
                                    fVar.b();
                                }
                                return e.f34409b.a(I());
                            }
                        } else {
                            throw new IllegalStateException("unexpected".toString());
                        }
                    } else {
                        if (T10) {
                            fVar.p();
                            return e.f34409b.a(I());
                        }
                        if (obj instanceof Q0) {
                            q02 = (Q0) obj;
                        } else {
                            q02 = null;
                        }
                        if (q02 != null) {
                            h0(q02, fVar, i11);
                        }
                        z((fVar.f34541c * i10) + i11);
                        return e.f34409b.c(q.f35511a);
                    }
                } else {
                    return e.f34409b.c(q.f35511a);
                }
            } else {
                fVar.b();
                return e.f34409b.c(q.f35511a);
            }
        }
    }

    public final Object D0(E e10, boolean z10) {
        if (this.f34416n == BufferOverflow.DROP_LATEST) {
            return B0(e10, z10);
        }
        return C0(e10);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean U() {
        if (this.f34416n == BufferOverflow.DROP_OLDEST) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.o
    public Object j(E e10) {
        return D0(e10, false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.o
    public Object k(E e10, kotlin.coroutines.c<? super q> cVar) {
        return A0(this, e10, cVar);
    }
}
