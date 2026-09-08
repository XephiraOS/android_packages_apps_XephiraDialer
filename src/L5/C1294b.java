package l5;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: ByteMatrix.java */
/* renamed from: l5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1294b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[][] f34690a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34691b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34692c;

    public C1294b(int i10, int i11) {
        this.f34690a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i11, i10);
        this.f34691b = i10;
        this.f34692c = i11;
    }

    public void a(byte b10) {
        for (byte[] bArr : this.f34690a) {
            Arrays.fill(bArr, b10);
        }
    }

    public byte b(int i10, int i11) {
        return this.f34690a[i11][i10];
    }

    public byte[][] c() {
        return this.f34690a;
    }

    public int d() {
        return this.f34692c;
    }

    public int e() {
        return this.f34691b;
    }

    public void f(int i10, int i11, int i12) {
        this.f34690a[i11][i10] = (byte) i12;
    }

    public void g(int i10, int i11, boolean z10) {
        this.f34690a[i11][i10] = z10 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f34691b * 2 * this.f34692c) + 2);
        for (int i10 = 0; i10 < this.f34692c; i10++) {
            byte[] bArr = this.f34690a[i10];
            for (int i11 = 0; i11 < this.f34691b; i11++) {
                byte b10 = bArr[i11];
                if (b10 != 0) {
                    if (b10 != 1) {
                        sb.append("  ");
                    } else {
                        sb.append(" 1");
                    }
                } else {
                    sb.append(" 0");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
