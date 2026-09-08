package com.google.common.base;

/* loaded from: classes3.dex */
public abstract class CharMatcher {

    /* loaded from: classes3.dex */
    public static final class Whitespace extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final int f24290b = Integer.numberOfLeadingZeros(31);

        /* renamed from: c, reason: collision with root package name */
        public static final Whitespace f24291c = new Whitespace();

        public Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c10) {
            if ("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c10) >>> f24290b) == c10) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class a extends CharMatcher {
    }

    /* loaded from: classes3.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        public final char f24292a;

        public b(char c10) {
            this.f24292a = c10;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c10) {
            if (c10 == this.f24292a) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.f(this.f24292a) + "')";
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c extends a {

        /* renamed from: a, reason: collision with root package name */
        public final String f24293a;

        public c(String str) {
            this.f24293a = (String) k.o(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.f24293a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final d f24294b = new d();

        public d() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public int b(CharSequence charSequence, int i10) {
            k.r(i10, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c10) {
            return false;
        }
    }

    public static CharMatcher c(char c10) {
        return new b(c10);
    }

    public static CharMatcher e() {
        return d.f24294b;
    }

    public static String f(char c10) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            cArr[5 - i10] = "0123456789ABCDEF".charAt(c10 & 15);
            c10 = (char) (c10 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static CharMatcher g() {
        return Whitespace.f24291c;
    }

    public int b(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        k.r(i10, length);
        while (i10 < length) {
            if (d(charSequence.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public abstract boolean d(char c10);

    public String toString() {
        return super.toString();
    }
}
