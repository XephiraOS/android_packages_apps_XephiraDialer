package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import m9.q;
import p9.C1472f;
import w9.InterfaceC1658a;

/* compiled from: SequenceBuilder.kt */
/* loaded from: classes4.dex */
public final class f<T> extends g<T> implements Iterator<T>, kotlin.coroutines.c<q>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public int f34272a;

    /* renamed from: b, reason: collision with root package name */
    public T f34273b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator<? extends T> f34274c;

    /* renamed from: d, reason: collision with root package name */
    public kotlin.coroutines.c<? super q> f34275d;

    @Override // kotlin.sequences.g
    public Object a(T t10, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object c11;
        Object c12;
        this.f34273b = t10;
        this.f34272a = 3;
        this.f34275d = cVar;
        c10 = kotlin.coroutines.intrinsics.b.c();
        c11 = kotlin.coroutines.intrinsics.b.c();
        if (c10 == c11) {
            C1472f.c(cVar);
        }
        c12 = kotlin.coroutines.intrinsics.b.c();
        if (c10 == c12) {
            return c10;
        }
        return q.f35511a;
    }

    public final Throwable c() {
        int i10 = this.f34272a;
        if (i10 != 4) {
            if (i10 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f34272a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    public final T d() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void e(kotlin.coroutines.c<? super q> cVar) {
        this.f34275d = cVar;
    }

    @Override // kotlin.coroutines.c
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f34213a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i10 = this.f34272a;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw c();
                }
                Iterator<? extends T> it = this.f34274c;
                kotlin.jvm.internal.i.c(it);
                if (it.hasNext()) {
                    this.f34272a = 2;
                    return true;
                }
                this.f34274c = null;
            }
            this.f34272a = 5;
            kotlin.coroutines.c<? super q> cVar = this.f34275d;
            kotlin.jvm.internal.i.c(cVar);
            this.f34275d = null;
            Result.a aVar = Result.f34166a;
            cVar.resumeWith(Result.b(q.f35511a));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i10 = this.f34272a;
        if (i10 != 0 && i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    this.f34272a = 0;
                    T t10 = this.f34273b;
                    this.f34273b = null;
                    return t10;
                }
                throw c();
            }
            this.f34272a = 1;
            Iterator<? extends T> it = this.f34274c;
            kotlin.jvm.internal.i.c(it);
            return it.next();
        }
        return d();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        kotlin.b.b(obj);
        this.f34272a = 4;
    }
}
