package com.google.common.io;

import com.google.common.base.k;
import com.heytap.accessory.constant.FastPairConstants;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: BaseEncoding.java */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f24584a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* renamed from: b, reason: collision with root package name */
    public static final a f24585b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* renamed from: c, reason: collision with root package name */
    public static final a f24586c = new d("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* renamed from: d, reason: collision with root package name */
    public static final a f24587d = new d("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* renamed from: e, reason: collision with root package name */
    public static final a f24588e = new b("base16()", "0123456789ABCDEF");

    /* compiled from: BaseEncoding.java */
    /* renamed from: com.google.common.io.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0222a {

        /* renamed from: a, reason: collision with root package name */
        public final String f24589a;

        /* renamed from: b, reason: collision with root package name */
        public final char[] f24590b;

        /* renamed from: c, reason: collision with root package name */
        public final int f24591c;

        /* renamed from: d, reason: collision with root package name */
        public final int f24592d;

        /* renamed from: e, reason: collision with root package name */
        public final int f24593e;

        /* renamed from: f, reason: collision with root package name */
        public final int f24594f;

        /* renamed from: g, reason: collision with root package name */
        public final byte[] f24595g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean[] f24596h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f24597i;

        public C0222a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        public static byte[] b(char[] cArr) {
            boolean z10;
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i10 = 0; i10 < cArr.length; i10++) {
                char c10 = cArr[i10];
                boolean z11 = true;
                if (c10 < 128) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                k.f(z10, "Non-ASCII character: %s", c10);
                if (bArr[c10] != -1) {
                    z11 = false;
                }
                k.f(z11, "Duplicate character: %s", c10);
                bArr[c10] = (byte) i10;
            }
            return bArr;
        }

        public char c(int i10) {
            return this.f24590b[i10];
        }

        public boolean d(char c10) {
            byte[] bArr = this.f24595g;
            if (c10 < bArr.length && bArr[c10] != -1) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0222a)) {
                return false;
            }
            C0222a c0222a = (C0222a) obj;
            if (this.f24597i != c0222a.f24597i || !Arrays.equals(this.f24590b, c0222a.f24590b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10;
            int hashCode = Arrays.hashCode(this.f24590b);
            if (this.f24597i) {
                i10 = 1231;
            } else {
                i10 = 1237;
            }
            return hashCode + i10;
        }

        public String toString() {
            return this.f24589a;
        }

        public C0222a(String str, char[] cArr, byte[] bArr, boolean z10) {
            this.f24589a = (String) k.o(str);
            this.f24590b = (char[]) k.o(cArr);
            try {
                int c10 = com.google.common.math.a.c(cArr.length, RoundingMode.UNNECESSARY);
                this.f24592d = c10;
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(c10);
                int i10 = 1 << (3 - numberOfTrailingZeros);
                this.f24593e = i10;
                this.f24594f = c10 >> numberOfTrailingZeros;
                this.f24591c = cArr.length - 1;
                this.f24595g = bArr;
                boolean[] zArr = new boolean[i10];
                for (int i11 = 0; i11 < this.f24594f; i11++) {
                    zArr[com.google.common.math.a.a(i11 * 8, this.f24592d, RoundingMode.CEILING)] = true;
                }
                this.f24596h = zArr;
                this.f24597i = z10;
            } catch (ArithmeticException e10) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e10);
            }
        }
    }

    /* compiled from: BaseEncoding.java */
    /* loaded from: classes3.dex */
    public static final class b extends d {

        /* renamed from: h, reason: collision with root package name */
        public final char[] f24598h;

        public b(String str, String str2) {
            this(new C0222a(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.a.d, com.google.common.io.a
        public void d(Appendable appendable, byte[] bArr, int i10, int i11) {
            k.o(appendable);
            k.t(i10, i10 + i11, bArr.length);
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = bArr[i10 + i12] & FastPairConstants.GO_INTENT_NOT_SET;
                appendable.append(this.f24598h[i13]);
                appendable.append(this.f24598h[i13 | 256]);
            }
        }

        @Override // com.google.common.io.a.d
        public a h(C0222a c0222a, Character ch) {
            return new b(c0222a);
        }

        public b(C0222a c0222a) {
            super(c0222a, null);
            this.f24598h = new char[512];
            k.d(c0222a.f24590b.length == 16);
            for (int i10 = 0; i10 < 256; i10++) {
                this.f24598h[i10] = c0222a.c(i10 >>> 4);
                this.f24598h[i10 | 256] = c0222a.c(i10 & 15);
            }
        }
    }

    /* compiled from: BaseEncoding.java */
    /* loaded from: classes3.dex */
    public static final class c extends d {
        public c(String str, String str2, Character ch) {
            this(new C0222a(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.a.d, com.google.common.io.a
        public void d(Appendable appendable, byte[] bArr, int i10, int i11) {
            k.o(appendable);
            int i12 = i10 + i11;
            k.t(i10, i12, bArr.length);
            while (i11 >= 3) {
                int i13 = i10 + 2;
                int i14 = ((bArr[i10 + 1] & FastPairConstants.GO_INTENT_NOT_SET) << 8) | ((bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET) << 16);
                i10 += 3;
                int i15 = i14 | (bArr[i13] & FastPairConstants.GO_INTENT_NOT_SET);
                appendable.append(this.f24599f.c(i15 >>> 18));
                appendable.append(this.f24599f.c((i15 >>> 12) & 63));
                appendable.append(this.f24599f.c((i15 >>> 6) & 63));
                appendable.append(this.f24599f.c(i15 & 63));
                i11 -= 3;
            }
            if (i10 < i12) {
                g(appendable, bArr, i10, i12 - i10);
            }
        }

        @Override // com.google.common.io.a.d
        public a h(C0222a c0222a, Character ch) {
            return new c(c0222a, ch);
        }

        public c(C0222a c0222a, Character ch) {
            super(c0222a, ch);
            k.d(c0222a.f24590b.length == 64);
        }
    }

    /* compiled from: BaseEncoding.java */
    /* loaded from: classes3.dex */
    public static class d extends a {

        /* renamed from: f, reason: collision with root package name */
        public final C0222a f24599f;

        /* renamed from: g, reason: collision with root package name */
        public final Character f24600g;

        public d(String str, String str2, Character ch) {
            this(new C0222a(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.a
        public void d(Appendable appendable, byte[] bArr, int i10, int i11) {
            k.o(appendable);
            k.t(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (i12 < i11) {
                g(appendable, bArr, i10 + i12, Math.min(this.f24599f.f24594f, i11 - i12));
                i12 += this.f24599f.f24594f;
            }
        }

        @Override // com.google.common.io.a
        public int e(int i10) {
            C0222a c0222a = this.f24599f;
            return c0222a.f24593e * com.google.common.math.a.a(i10, c0222a.f24594f, RoundingMode.CEILING);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!this.f24599f.equals(dVar.f24599f) || !Objects.equals(this.f24600g, dVar.f24600g)) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.io.a
        public a f() {
            if (this.f24600g != null) {
                return h(this.f24599f, null);
            }
            return this;
        }

        public void g(Appendable appendable, byte[] bArr, int i10, int i11) {
            boolean z10;
            k.o(appendable);
            k.t(i10, i10 + i11, bArr.length);
            int i12 = 0;
            if (i11 <= this.f24599f.f24594f) {
                z10 = true;
            } else {
                z10 = false;
            }
            k.d(z10);
            long j10 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                j10 = (j10 | (bArr[i10 + i13] & FastPairConstants.GO_INTENT_NOT_SET)) << 8;
            }
            int i14 = ((i11 + 1) * 8) - this.f24599f.f24592d;
            while (i12 < i11 * 8) {
                C0222a c0222a = this.f24599f;
                appendable.append(c0222a.c(((int) (j10 >>> (i14 - i12))) & c0222a.f24591c));
                i12 += this.f24599f.f24592d;
            }
            if (this.f24600g != null) {
                while (i12 < this.f24599f.f24594f * 8) {
                    appendable.append(this.f24600g.charValue());
                    i12 += this.f24599f.f24592d;
                }
            }
        }

        public a h(C0222a c0222a, Character ch) {
            return new d(c0222a, ch);
        }

        public int hashCode() {
            return Objects.hashCode(this.f24600g) ^ this.f24599f.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f24599f);
            if (8 % this.f24599f.f24592d != 0) {
                if (this.f24600g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f24600g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        public d(C0222a c0222a, Character ch) {
            this.f24599f = (C0222a) k.o(c0222a);
            k.k(ch == null || !c0222a.d(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f24600g = ch;
        }
    }

    public static a a() {
        return f24584a;
    }

    public String b(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    public final String c(byte[] bArr, int i10, int i11) {
        k.t(i10, i10 + i11, bArr.length);
        StringBuilder sb = new StringBuilder(e(i11));
        try {
            d(sb, bArr, i10, i11);
            return sb.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public abstract void d(Appendable appendable, byte[] bArr, int i10, int i11);

    public abstract int e(int i10);

    public abstract a f();
}
