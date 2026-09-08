package com.google.gson.internal;

import F4.o;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* compiled from: Streams.java */
/* loaded from: classes3.dex */
public final class j {
    public static com.google.gson.j a(K4.a aVar) {
        boolean z10;
        try {
            try {
                aVar.f0();
                z10 = false;
                try {
                    return o.f945V.b(aVar);
                } catch (EOFException e10) {
                    e = e10;
                    if (z10) {
                        return com.google.gson.k.f24815a;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (EOFException e11) {
                e = e11;
                z10 = true;
            }
        } catch (MalformedJsonException e12) {
            throw new JsonSyntaxException(e12);
        } catch (IOException e13) {
            throw new JsonIOException(e13);
        } catch (NumberFormatException e14) {
            throw new JsonSyntaxException(e14);
        }
    }

    public static void b(com.google.gson.j jVar, K4.b bVar) {
        o.f945V.d(bVar, jVar);
    }

    public static Writer c(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new b(appendable);
    }

    /* compiled from: Streams.java */
    /* loaded from: classes3.dex */
    public static final class b extends Writer {

        /* renamed from: a, reason: collision with root package name */
        public final Appendable f24805a;

        /* renamed from: b, reason: collision with root package name */
        public final a f24806b = new a();

        /* compiled from: Streams.java */
        /* loaded from: classes3.dex */
        public static class a implements CharSequence {

            /* renamed from: a, reason: collision with root package name */
            public char[] f24807a;

            /* renamed from: b, reason: collision with root package name */
            public String f24808b;

            public a() {
            }

            public void a(char[] cArr) {
                this.f24807a = cArr;
                this.f24808b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f24807a[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f24807a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f24807a, i10, i11 - i10);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f24808b == null) {
                    this.f24808b = new String(this.f24807a);
                }
                return this.f24808b;
            }
        }

        public b(Appendable appendable) {
            this.f24805a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            this.f24806b.a(cArr);
            this.f24805a.append(this.f24806b, i10, i11 + i10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) {
            this.f24805a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i10) {
            this.f24805a.append((char) i10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i10, int i11) {
            this.f24805a.append(charSequence, i10, i11);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i10, int i11) {
            Objects.requireNonNull(str);
            this.f24805a.append(str, i10, i11 + i10);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
