package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.i;
import kotlin.sequences.e;
import w9.InterfaceC1658a;

/* compiled from: ReadWrite.kt */
/* loaded from: classes4.dex */
public final class b implements e<String> {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedReader f34226a;

    /* compiled from: ReadWrite.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<String>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public String f34227a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f34228b;

        public a() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (hasNext()) {
                String str = this.f34227a;
                this.f34227a = null;
                i.c(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34227a == null && !this.f34228b) {
                String readLine = b.this.f34226a.readLine();
                this.f34227a = readLine;
                if (readLine == null) {
                    this.f34228b = true;
                }
            }
            if (this.f34227a != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(BufferedReader reader) {
        i.f(reader, "reader");
        this.f34226a = reader;
    }

    @Override // kotlin.sequences.e
    public Iterator<String> iterator() {
        return new a();
    }
}
