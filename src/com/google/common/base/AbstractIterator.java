package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    public State f24282a = State.NOT_READY;

    /* renamed from: b, reason: collision with root package name */
    public T f24283b;

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
        public static final /* synthetic */ int[] f24289a;

        static {
            int[] iArr = new int[State.values().length];
            f24289a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24289a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f24282a = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f24282a = State.FAILED;
        this.f24283b = a();
        if (this.f24282a != State.DONE) {
            this.f24282a = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z10;
        if (this.f24282a != State.FAILED) {
            z10 = true;
        } else {
            z10 = false;
        }
        k.u(z10);
        int i10 = a.f24289a[this.f24282a.ordinal()];
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
            this.f24282a = State.NOT_READY;
            T t10 = (T) g.a(this.f24283b);
            this.f24283b = null;
            return t10;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
