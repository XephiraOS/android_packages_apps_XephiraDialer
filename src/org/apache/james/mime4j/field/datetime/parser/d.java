package org.apache.james.mime4j.field.datetime.parser;

import java.io.IOException;
import java.io.Reader;

/* compiled from: SimpleCharStream.java */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f35837a;

    /* renamed from: b, reason: collision with root package name */
    public int f35838b;

    /* renamed from: c, reason: collision with root package name */
    public int f35839c;

    /* renamed from: d, reason: collision with root package name */
    public int f35840d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f35841e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f35842f;

    /* renamed from: g, reason: collision with root package name */
    public int f35843g;

    /* renamed from: h, reason: collision with root package name */
    public int f35844h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f35845i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f35846j;

    /* renamed from: k, reason: collision with root package name */
    public Reader f35847k;

    /* renamed from: l, reason: collision with root package name */
    public char[] f35848l;

    /* renamed from: m, reason: collision with root package name */
    public int f35849m;

    /* renamed from: n, reason: collision with root package name */
    public int f35850n;

    /* renamed from: o, reason: collision with root package name */
    public int f35851o;

    public d(Reader reader, int i10, int i11, int i12) {
        this.f35840d = -1;
        this.f35845i = false;
        this.f35846j = false;
        this.f35849m = 0;
        this.f35850n = 0;
        this.f35851o = 8;
        this.f35847k = reader;
        this.f35844h = i10;
        this.f35843g = i11 - 1;
        this.f35837a = i12;
        this.f35838b = i12;
        this.f35848l = new char[i12];
        this.f35841e = new int[i12];
        this.f35842f = new int[i12];
    }

    public char a() {
        this.f35839c = -1;
        char l10 = l();
        this.f35839c = this.f35840d;
        return l10;
    }

    public void b(boolean z10) {
        int i10 = this.f35837a;
        char[] cArr = new char[i10 + 2048];
        int[] iArr = new int[i10 + 2048];
        int[] iArr2 = new int[i10 + 2048];
        try {
            if (z10) {
                char[] cArr2 = this.f35848l;
                int i11 = this.f35839c;
                System.arraycopy(cArr2, i11, cArr, 0, i10 - i11);
                System.arraycopy(this.f35848l, 0, cArr, this.f35837a - this.f35839c, this.f35840d);
                this.f35848l = cArr;
                int[] iArr3 = this.f35841e;
                int i12 = this.f35839c;
                System.arraycopy(iArr3, i12, iArr, 0, this.f35837a - i12);
                System.arraycopy(this.f35841e, 0, iArr, this.f35837a - this.f35839c, this.f35840d);
                this.f35841e = iArr;
                int[] iArr4 = this.f35842f;
                int i13 = this.f35839c;
                System.arraycopy(iArr4, i13, iArr2, 0, this.f35837a - i13);
                System.arraycopy(this.f35842f, 0, iArr2, this.f35837a - this.f35839c, this.f35840d);
                this.f35842f = iArr2;
                int i14 = this.f35840d + (this.f35837a - this.f35839c);
                this.f35840d = i14;
                this.f35849m = i14;
            } else {
                char[] cArr3 = this.f35848l;
                int i15 = this.f35839c;
                System.arraycopy(cArr3, i15, cArr, 0, i10 - i15);
                this.f35848l = cArr;
                int[] iArr5 = this.f35841e;
                int i16 = this.f35839c;
                System.arraycopy(iArr5, i16, iArr, 0, this.f35837a - i16);
                this.f35841e = iArr;
                int[] iArr6 = this.f35842f;
                int i17 = this.f35839c;
                System.arraycopy(iArr6, i17, iArr2, 0, this.f35837a - i17);
                this.f35842f = iArr2;
                int i18 = this.f35840d - this.f35839c;
                this.f35840d = i18;
                this.f35849m = i18;
            }
            int i19 = this.f35837a + 2048;
            this.f35837a = i19;
            this.f35838b = i19;
            this.f35839c = 0;
        } catch (Throwable th) {
            throw new Error(th.getMessage());
        }
    }

    public void c() {
        int i10 = this.f35849m;
        int i11 = this.f35838b;
        if (i10 == i11) {
            int i12 = this.f35837a;
            if (i11 == i12) {
                int i13 = this.f35839c;
                if (i13 > 2048) {
                    this.f35849m = 0;
                    this.f35840d = 0;
                    this.f35838b = i13;
                } else if (i13 < 0) {
                    this.f35849m = 0;
                    this.f35840d = 0;
                } else {
                    b(false);
                }
            } else {
                int i14 = this.f35839c;
                if (i11 > i14) {
                    this.f35838b = i12;
                } else if (i14 - i11 < 2048) {
                    b(true);
                } else {
                    this.f35838b = i14;
                }
            }
        }
        try {
            Reader reader = this.f35847k;
            char[] cArr = this.f35848l;
            int i15 = this.f35849m;
            int read = reader.read(cArr, i15, this.f35838b - i15);
            if (read != -1) {
                this.f35849m += read;
            } else {
                this.f35847k.close();
                throw new IOException();
            }
        } catch (IOException e10) {
            this.f35840d--;
            g(0);
            if (this.f35839c == -1) {
                this.f35839c = this.f35840d;
            }
            throw e10;
        }
    }

    public String d() {
        int i10 = this.f35840d;
        int i11 = this.f35839c;
        if (i10 >= i11) {
            return new String(this.f35848l, i11, (i10 - i11) + 1);
        }
        StringBuilder sb = new StringBuilder();
        char[] cArr = this.f35848l;
        int i12 = this.f35839c;
        sb.append(new String(cArr, i12, this.f35837a - i12));
        sb.append(new String(this.f35848l, 0, this.f35840d + 1));
        return sb.toString();
    }

    public char[] e(int i10) {
        char[] cArr = new char[i10];
        int i11 = this.f35840d;
        if (i11 + 1 >= i10) {
            System.arraycopy(this.f35848l, (i11 - i10) + 1, cArr, 0, i10);
        } else {
            System.arraycopy(this.f35848l, this.f35837a - ((i10 - i11) - 1), cArr, 0, (i10 - i11) - 1);
            System.arraycopy(this.f35848l, 0, cArr, (i10 - r6) - 1, this.f35840d + 1);
        }
        return cArr;
    }

    public void f(char c10) {
        this.f35843g++;
        if (this.f35846j) {
            this.f35846j = false;
            int i10 = this.f35844h;
            this.f35843g = 1;
            this.f35844h = i10 + 1;
        } else if (this.f35845i) {
            this.f35845i = false;
            if (c10 == '\n') {
                this.f35846j = true;
            } else {
                int i11 = this.f35844h;
                this.f35843g = 1;
                this.f35844h = i11 + 1;
            }
        }
        if (c10 != '\t') {
            if (c10 != '\n') {
                if (c10 == '\r') {
                    this.f35845i = true;
                }
            } else {
                this.f35846j = true;
            }
        } else {
            int i12 = this.f35843g - 1;
            this.f35843g = i12;
            int i13 = this.f35851o;
            this.f35843g = i12 + (i13 - (i12 % i13));
        }
        int[] iArr = this.f35841e;
        int i14 = this.f35840d;
        iArr[i14] = this.f35844h;
        this.f35842f[i14] = this.f35843g;
    }

    public void g(int i10) {
        this.f35850n += i10;
        int i11 = this.f35840d - i10;
        this.f35840d = i11;
        if (i11 < 0) {
            this.f35840d = i11 + this.f35837a;
        }
    }

    public int h() {
        return this.f35842f[this.f35839c];
    }

    public int i() {
        return this.f35841e[this.f35839c];
    }

    public int j() {
        return this.f35842f[this.f35840d];
    }

    public int k() {
        return this.f35841e[this.f35840d];
    }

    public char l() {
        int i10 = this.f35850n;
        if (i10 > 0) {
            this.f35850n = i10 - 1;
            int i11 = this.f35840d + 1;
            this.f35840d = i11;
            if (i11 == this.f35837a) {
                this.f35840d = 0;
            }
            return this.f35848l[this.f35840d];
        }
        int i12 = this.f35840d + 1;
        this.f35840d = i12;
        if (i12 >= this.f35849m) {
            c();
        }
        char c10 = this.f35848l[this.f35840d];
        f(c10);
        return c10;
    }

    public d(Reader reader, int i10, int i11) {
        this(reader, i10, i11, 4096);
    }
}
