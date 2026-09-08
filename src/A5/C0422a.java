package a5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

/* compiled from: CodaBarReader.java */
/* renamed from: a5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0422a extends k {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f6396d = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f6397e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: f, reason: collision with root package name */
    public static final char[] f6398f = {'A', 'B', 'C', 'D'};

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f6399a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    public int[] f6400b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    public int f6401c = 0;

    public static boolean g(char[] cArr, char c10) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c11 == c10) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // a5.k
    public P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        int i11;
        Arrays.fill(this.f6400b, 0);
        j(aVar);
        int i12 = i();
        this.f6399a.setLength(0);
        int i13 = i12;
        while (true) {
            int k10 = k(i13);
            if (k10 != -1) {
                this.f6399a.append((char) k10);
                i11 = i13 + 8;
                if ((this.f6399a.length() <= 1 || !g(f6398f, f6396d[k10])) && i11 < this.f6401c) {
                    i13 = i11;
                }
            } else {
                throw NotFoundException.a();
            }
        }
        int i14 = i13 + 7;
        int i15 = this.f6400b[i14];
        int i16 = 0;
        for (int i17 = -8; i17 < -1; i17++) {
            i16 += this.f6400b[i11 + i17];
        }
        if (i11 < this.f6401c && i15 < i16 / 2) {
            throw NotFoundException.a();
        }
        l(i12);
        for (int i18 = 0; i18 < this.f6399a.length(); i18++) {
            StringBuilder sb = this.f6399a;
            sb.setCharAt(i18, f6396d[sb.charAt(i18)]);
        }
        char charAt = this.f6399a.charAt(0);
        char[] cArr = f6398f;
        if (g(cArr, charAt)) {
            StringBuilder sb2 = this.f6399a;
            if (g(cArr, sb2.charAt(sb2.length() - 1))) {
                if (this.f6399a.length() > 3) {
                    if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                        StringBuilder sb3 = this.f6399a;
                        sb3.deleteCharAt(sb3.length() - 1);
                        this.f6399a.deleteCharAt(0);
                    }
                    int i19 = 0;
                    for (int i20 = 0; i20 < i12; i20++) {
                        i19 += this.f6400b[i20];
                    }
                    float f10 = i19;
                    while (i12 < i14) {
                        i19 += this.f6400b[i12];
                        i12++;
                    }
                    float f11 = i10;
                    return new P4.f(this.f6399a.toString(), null, new P4.g[]{new P4.g(f10, f11), new P4.g(i19, f11)}, BarcodeFormat.CODABAR);
                }
                throw NotFoundException.a();
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    public final void h(int i10) {
        int[] iArr = this.f6400b;
        int i11 = this.f6401c;
        iArr[i11] = i10;
        int i12 = i11 + 1;
        this.f6401c = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[i12 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.f6400b = iArr2;
        }
    }

    public final int i() {
        for (int i10 = 1; i10 < this.f6401c; i10 += 2) {
            int k10 = k(i10);
            if (k10 != -1 && g(f6398f, f6396d[k10])) {
                int i11 = 0;
                for (int i12 = i10; i12 < i10 + 7; i12++) {
                    i11 += this.f6400b[i12];
                }
                if (i10 == 1 || this.f6400b[i10 - 1] >= i11 / 2) {
                    return i10;
                }
            }
        }
        throw NotFoundException.a();
    }

    public final void j(S4.a aVar) {
        int i10 = 0;
        this.f6401c = 0;
        int j10 = aVar.j(0);
        int k10 = aVar.k();
        if (j10 < k10) {
            boolean z10 = true;
            while (j10 < k10) {
                if (aVar.g(j10) != z10) {
                    i10++;
                } else {
                    h(i10);
                    z10 = !z10;
                    i10 = 1;
                }
                j10++;
            }
            h(i10);
            return;
        }
        throw NotFoundException.a();
    }

    public final int k(int i10) {
        int i11;
        int i12 = i10 + 7;
        if (i12 >= this.f6401c) {
            return -1;
        }
        int[] iArr = this.f6400b;
        int i13 = Integer.MAX_VALUE;
        int i14 = 0;
        int i15 = Integer.MAX_VALUE;
        int i16 = 0;
        for (int i17 = i10; i17 < i12; i17 += 2) {
            int i18 = iArr[i17];
            if (i18 < i15) {
                i15 = i18;
            }
            if (i18 > i16) {
                i16 = i18;
            }
        }
        int i19 = (i15 + i16) / 2;
        int i20 = 0;
        for (int i21 = i10 + 1; i21 < i12; i21 += 2) {
            int i22 = iArr[i21];
            if (i22 < i13) {
                i13 = i22;
            }
            if (i22 > i20) {
                i20 = i22;
            }
        }
        int i23 = (i13 + i20) / 2;
        int i24 = 128;
        int i25 = 0;
        for (int i26 = 0; i26 < 7; i26++) {
            if ((i26 & 1) == 0) {
                i11 = i19;
            } else {
                i11 = i23;
            }
            i24 >>= 1;
            if (iArr[i10 + i26] > i11) {
                i25 |= i24;
            }
        }
        while (true) {
            int[] iArr2 = f6397e;
            if (i14 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i14] == i25) {
                return i14;
            }
            i14++;
        }
    }

    public final void l(int i10) {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.f6399a.length() - 1;
        int i11 = i10;
        int i12 = 0;
        while (true) {
            int i13 = f6397e[this.f6399a.charAt(i12)];
            for (int i14 = 6; i14 >= 0; i14--) {
                int i15 = (i14 & 1) + ((i13 & 1) << 1);
                iArr[i15] = iArr[i15] + this.f6400b[i11 + i14];
                iArr2[i15] = iArr2[i15] + 1;
                i13 >>= 1;
            }
            if (i12 >= length) {
                break;
            }
            i11 += 8;
            i12++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i16 = 0; i16 < 2; i16++) {
            fArr2[i16] = 0.0f;
            int i17 = i16 + 2;
            int i18 = iArr[i17];
            int i19 = iArr2[i17];
            float f10 = ((iArr[i16] / iArr2[i16]) + (i18 / i19)) / 2.0f;
            fArr2[i17] = f10;
            fArr[i16] = f10;
            fArr[i17] = ((i18 * 2.0f) + 1.5f) / i19;
        }
        int i20 = i10;
        int i21 = 0;
        loop3: while (true) {
            int i22 = f6397e[this.f6399a.charAt(i21)];
            for (int i23 = 6; i23 >= 0; i23--) {
                int i24 = (i23 & 1) + ((i22 & 1) << 1);
                float f11 = this.f6400b[i20 + i23];
                if (f11 < fArr2[i24] || f11 > fArr[i24]) {
                    break loop3;
                }
                i22 >>= 1;
            }
            if (i21 < length) {
                i20 += 8;
                i21++;
            } else {
                return;
            }
        }
        throw NotFoundException.a();
    }
}
