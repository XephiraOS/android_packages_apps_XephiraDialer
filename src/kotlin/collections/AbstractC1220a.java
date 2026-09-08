package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import w9.InterfaceC1658a;

/* compiled from: AbstractIterator.kt */
/* renamed from: kotlin.collections.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1220a<T> implements Iterator<T>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public State f34186a = State.f34181b;

    /* renamed from: b, reason: collision with root package name */
    public T f34187b;

    /* compiled from: AbstractIterator.kt */
    /* renamed from: kotlin.collections.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class C0324a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34188a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.f34182c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.f34180a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f34188a = iArr;
        }
    }

    public abstract void a();

    public final void b() {
        this.f34186a = State.f34182c;
    }

    public final void c(T t10) {
        this.f34187b = t10;
        this.f34186a = State.f34180a;
    }

    public final boolean d() {
        this.f34186a = State.f34183d;
        a();
        if (this.f34186a == State.f34180a) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.f34186a;
        if (state != State.f34183d) {
            int i10 = C0324a.f34188a[state.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return true;
                }
                return d();
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.f34186a = State.f34181b;
            return this.f34187b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
