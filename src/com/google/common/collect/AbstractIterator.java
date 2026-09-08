package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class AbstractIterator<T> extends C<T> {

    /* renamed from: a, reason: collision with root package name */
    public State f24343a = State.NOT_READY;

    /* renamed from: b, reason: collision with root package name */
    public T f24344b;

    /* loaded from: classes3.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24350a;

        static {
            int[] iArr = new int[State.values().length];
            f24350a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24350a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f24343a = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f24343a = State.FAILED;
        this.f24344b = a();
        if (this.f24343a != State.DONE) {
            this.f24343a = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z10;
        if (this.f24343a != State.FAILED) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.u(z10);
        int i10 = a.f24350a[this.f24343a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            return true;
        }
        return c();
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f24343a = State.NOT_READY;
            T t10 = (T) s.a(this.f24344b);
            this.f24344b = null;
            return t10;
        }
        throw new NoSuchElementException();
    }
}
