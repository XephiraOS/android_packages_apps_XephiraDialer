package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.E;
import kotlinx.coroutines.F;
import kotlinx.coroutines.G;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.n;
import m9.q;
import v9.p;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public abstract class ChannelFlow<T> implements g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f34440a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34441b;

    /* renamed from: c, reason: collision with root package name */
    public final BufferOverflow f34442c;

    public ChannelFlow(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        this.f34440a = coroutineContext;
        this.f34441b = i10;
        this.f34442c = bufferOverflow;
    }

    public static /* synthetic */ <T> Object d(ChannelFlow<T> channelFlow, kotlinx.coroutines.flow.b<? super T> bVar, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object e10 = F.e(new ChannelFlow$collect$2(bVar, channelFlow, null), cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (e10 == c10) {
            return e10;
        }
        return q.f35511a;
    }

    @Override // kotlinx.coroutines.flow.internal.g
    public kotlinx.coroutines.flow.a<T> a(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        CoroutineContext r10 = coroutineContext.r(this.f34440a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i11 = this.f34441b;
            if (i11 != -3) {
                if (i10 != -3) {
                    if (i11 != -2) {
                        if (i10 != -2) {
                            i10 += i11;
                            if (i10 < 0) {
                                i10 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i10 = i11;
            }
            bufferOverflow = this.f34442c;
        }
        if (kotlin.jvm.internal.i.b(r10, this.f34440a) && i10 == this.f34441b && bufferOverflow == this.f34442c) {
            return this;
        }
        return f(r10, i10, bufferOverflow);
    }

    public String b() {
        return null;
    }

    @Override // kotlinx.coroutines.flow.a
    public Object collect(kotlinx.coroutines.flow.b<? super T> bVar, kotlin.coroutines.c<? super q> cVar) {
        return d(this, bVar, cVar);
    }

    public abstract Object e(kotlinx.coroutines.channels.l<? super T> lVar, kotlin.coroutines.c<? super q> cVar);

    public abstract ChannelFlow<T> f(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow);

    public final p<kotlinx.coroutines.channels.l<? super T>, kotlin.coroutines.c<? super q>, Object> g() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int h() {
        int i10 = this.f34441b;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    public n<T> i(E e10) {
        return kotlinx.coroutines.channels.j.b(e10, this.f34440a, h(), this.f34442c, CoroutineStart.ATOMIC, null, g(), 16, null);
    }

    public String toString() {
        String D10;
        ArrayList arrayList = new ArrayList(4);
        String b10 = b();
        if (b10 != null) {
            arrayList.add(b10);
        }
        if (this.f34440a != EmptyCoroutineContext.f34213a) {
            arrayList.add("context=" + this.f34440a);
        }
        if (this.f34441b != -3) {
            arrayList.add("capacity=" + this.f34441b);
        }
        if (this.f34442c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f34442c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(G.a(this));
        sb.append('[');
        D10 = CollectionsKt___CollectionsKt.D(arrayList, ", ", null, null, 0, null, null, 62, null);
        sb.append(D10);
        sb.append(']');
        return sb.toString();
    }
}
