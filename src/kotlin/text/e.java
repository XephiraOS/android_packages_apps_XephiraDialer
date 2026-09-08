package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import w9.InterfaceC1658a;

/* compiled from: Strings.kt */
/* loaded from: classes4.dex */
public final class e implements kotlin.sequences.e<B9.f> {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f34290a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34291b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34292c;

    /* renamed from: d, reason: collision with root package name */
    public final v9.p<CharSequence, Integer, Pair<Integer, Integer>> f34293d;

    /* compiled from: Strings.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<B9.f>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public int f34294a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f34295b;

        /* renamed from: c, reason: collision with root package name */
        public int f34296c;

        /* renamed from: d, reason: collision with root package name */
        public B9.f f34297d;

        /* renamed from: e, reason: collision with root package name */
        public int f34298e;

        public a() {
            int g10;
            g10 = B9.i.g(e.this.f34291b, 0, e.this.f34290a.length());
            this.f34295b = g10;
            this.f34296c = g10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f34299f.f34292c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f34296c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f34294a = r1
                r0 = 0
                r6.f34297d = r0
                goto L9e
            Lc:
                kotlin.text.e r0 = kotlin.text.e.this
                int r0 = kotlin.text.e.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f34298e
                int r0 = r0 + r3
                r6.f34298e = r0
                kotlin.text.e r4 = kotlin.text.e.this
                int r4 = kotlin.text.e.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f34296c
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                B9.f r0 = new B9.f
                int r1 = r6.f34295b
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = kotlin.text.f.D(r4)
                r0.<init>(r1, r4)
                r6.f34297d = r0
                r6.f34296c = r2
                goto L9c
            L47:
                kotlin.text.e r0 = kotlin.text.e.this
                v9.p r0 = kotlin.text.e.a(r0)
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r5 = r6.f34296c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                B9.f r0 = new B9.f
                int r1 = r6.f34295b
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = kotlin.text.f.D(r4)
                r0.<init>(r1, r4)
                r6.f34297d = r0
                r6.f34296c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f34295b
                B9.f r4 = B9.g.i(r4, r2)
                r6.f34297d = r4
                int r2 = r2 + r0
                r6.f34295b = r2
                if (r0 != 0) goto L99
                r1 = r3
            L99:
                int r2 = r2 + r1
                r6.f34296c = r2
            L9c:
                r6.f34294a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.e.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public B9.f next() {
            if (this.f34294a == -1) {
                a();
            }
            if (this.f34294a != 0) {
                B9.f fVar = this.f34297d;
                kotlin.jvm.internal.i.d(fVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f34297d = null;
                this.f34294a = -1;
                return fVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34294a == -1) {
                a();
            }
            if (this.f34294a == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence input, int i10, int i11, v9.p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.i.f(input, "input");
        kotlin.jvm.internal.i.f(getNextMatch, "getNextMatch");
        this.f34290a = input;
        this.f34291b = i10;
        this.f34292c = i11;
        this.f34293d = getNextMatch;
    }

    @Override // kotlin.sequences.e
    public Iterator<B9.f> iterator() {
        return new a();
    }
}
