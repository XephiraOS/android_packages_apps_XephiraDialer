package com.google.common.base;

import java.util.Iterator;

/* compiled from: Splitter.java */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final CharMatcher f24321a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f24322b;

    /* renamed from: c, reason: collision with root package name */
    public final d f24323c;

    /* renamed from: d, reason: collision with root package name */
    public final int f24324d;

    /* compiled from: Splitter.java */
    /* loaded from: classes3.dex */
    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharMatcher f24325a;

        /* compiled from: Splitter.java */
        /* renamed from: com.google.common.base.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0219a extends c {
            public C0219a(l lVar, CharSequence charSequence) {
                super(lVar, charSequence);
            }

            @Override // com.google.common.base.l.c
            public int e(int i10) {
                return i10 + 1;
            }

            @Override // com.google.common.base.l.c
            public int f(int i10) {
                return a.this.f24325a.b(this.f24329c, i10);
            }
        }

        public a(CharMatcher charMatcher) {
            this.f24325a = charMatcher;
        }

        @Override // com.google.common.base.l.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(l lVar, CharSequence charSequence) {
            return new C0219a(lVar, charSequence);
        }
    }

    /* compiled from: Splitter.java */
    /* loaded from: classes3.dex */
    public class b implements Iterable<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f24327a;

        public b(CharSequence charSequence) {
            this.f24327a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return l.this.h(this.f24327a);
        }

        public String toString() {
            e g10 = e.g(", ");
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            StringBuilder b10 = g10.b(sb, this);
            b10.append(']');
            return b10.toString();
        }
    }

    /* compiled from: Splitter.java */
    /* loaded from: classes3.dex */
    public static abstract class c extends AbstractIterator<String> {

        /* renamed from: c, reason: collision with root package name */
        public final CharSequence f24329c;

        /* renamed from: d, reason: collision with root package name */
        public final CharMatcher f24330d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f24331e;

        /* renamed from: f, reason: collision with root package name */
        public int f24332f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f24333g;

        public c(l lVar, CharSequence charSequence) {
            this.f24330d = lVar.f24321a;
            this.f24331e = lVar.f24322b;
            this.f24333g = lVar.f24324d;
            this.f24329c = charSequence;
        }

        @Override // com.google.common.base.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int f10;
            int i10 = this.f24332f;
            while (true) {
                int i11 = this.f24332f;
                if (i11 != -1) {
                    f10 = f(i11);
                    if (f10 == -1) {
                        f10 = this.f24329c.length();
                        this.f24332f = -1;
                    } else {
                        this.f24332f = e(f10);
                    }
                    int i12 = this.f24332f;
                    if (i12 == i10) {
                        int i13 = i12 + 1;
                        this.f24332f = i13;
                        if (i13 > this.f24329c.length()) {
                            this.f24332f = -1;
                        }
                    } else {
                        while (i10 < f10 && this.f24330d.d(this.f24329c.charAt(i10))) {
                            i10++;
                        }
                        while (f10 > i10 && this.f24330d.d(this.f24329c.charAt(f10 - 1))) {
                            f10--;
                        }
                        if (!this.f24331e || i10 != f10) {
                            break;
                        }
                        i10 = this.f24332f;
                    }
                } else {
                    return b();
                }
            }
            int i14 = this.f24333g;
            if (i14 == 1) {
                f10 = this.f24329c.length();
                this.f24332f = -1;
                while (f10 > i10 && this.f24330d.d(this.f24329c.charAt(f10 - 1))) {
                    f10--;
                }
            } else {
                this.f24333g = i14 - 1;
            }
            return this.f24329c.subSequence(i10, f10).toString();
        }

        public abstract int e(int i10);

        public abstract int f(int i10);
    }

    /* compiled from: Splitter.java */
    /* loaded from: classes3.dex */
    public interface d {
        Iterator<String> a(l lVar, CharSequence charSequence);
    }

    public l(d dVar) {
        this(dVar, false, CharMatcher.e(), Integer.MAX_VALUE);
    }

    public static l e(char c10) {
        return f(CharMatcher.c(c10));
    }

    public static l f(CharMatcher charMatcher) {
        k.o(charMatcher);
        return new l(new a(charMatcher));
    }

    public Iterable<String> g(CharSequence charSequence) {
        k.o(charSequence);
        return new b(charSequence);
    }

    public final Iterator<String> h(CharSequence charSequence) {
        return this.f24323c.a(this, charSequence);
    }

    public l i() {
        return j(CharMatcher.g());
    }

    public l j(CharMatcher charMatcher) {
        k.o(charMatcher);
        return new l(this.f24323c, this.f24322b, charMatcher, this.f24324d);
    }

    public l(d dVar, boolean z10, CharMatcher charMatcher, int i10) {
        this.f24323c = dVar;
        this.f24322b = z10;
        this.f24321a = charMatcher;
        this.f24324d = i10;
    }
}
