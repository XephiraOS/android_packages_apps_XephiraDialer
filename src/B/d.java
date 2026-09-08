package B;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: PathParser.java */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: PathParser.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f212a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f213b;
    }

    public static void a(ArrayList<b> arrayList, char c10, float[] fArr) {
        arrayList.add(new b(c10, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if (bVarArr[i10].f214a != bVarArr2[i10].f214a || bVarArr[i10].f215b.length != bVarArr2[i10].f215b.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] c(float[] fArr, int i10, int i11) {
        if (i10 <= i11) {
            int length = fArr.length;
            if (i10 >= 0 && i10 <= length) {
                int i12 = i11 - i10;
                int min = Math.min(i12, length - i10);
                float[] fArr2 = new float[i12];
                System.arraycopy(fArr, i10, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static b[] d(String str) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 1;
        while (i11 < str.length()) {
            int i12 = i(str, i11);
            String trim = str.substring(i10, i12).trim();
            if (!trim.isEmpty()) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i10 = i12;
            i11 = i12 + 1;
        }
        if (i11 - i10 == 1 && i10 < str.length()) {
            a(arrayList, str.charAt(i10), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[0]);
    }

    public static Path e(String str) {
        Path path = new Path();
        try {
            b.h(d(str), path);
            return path;
        } catch (RuntimeException e10) {
            throw new RuntimeException("Error in parsing " + str, e10);
        }
    }

    public static b[] f(b[] bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            bVarArr2[i10] = new b(bVarArr[i10]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x001e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[LOOP:0: B:2:0x0007->B:14:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.String r8, int r9, B.d.a r10) {
        /*
            r0 = 0
            r10.f213b = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L36
        L27:
            r10.f213b = r7
        L29:
            r2 = r0
            r4 = r7
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.f213b = r7
            goto L29
        L33:
            r2 = r0
            goto L36
        L35:
            r2 = r7
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.f212a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B.d.g(java.lang.String, int, B.d$a):void");
    }

    public static float[] h(String str) {
        if (str.charAt(0) != 'z' && str.charAt(0) != 'Z') {
            try {
                float[] fArr = new float[str.length()];
                a aVar = new a();
                int length = str.length();
                int i10 = 1;
                int i11 = 0;
                while (i10 < length) {
                    g(str, i10, aVar);
                    int i12 = aVar.f212a;
                    if (i10 < i12) {
                        fArr[i11] = Float.parseFloat(str.substring(i10, i12));
                        i11++;
                    }
                    if (aVar.f213b) {
                        i10 = i12;
                    } else {
                        i10 = i12 + 1;
                    }
                }
                return c(fArr, 0, i11);
            } catch (NumberFormatException e10) {
                throw new RuntimeException("error in parsing \"" + str + "\"", e10);
            }
        }
        return new float[0];
    }

    public static int i(String str, int i10) {
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i10;
            }
            i10++;
        }
        return i10;
    }

    public static void j(b[] bVarArr, Path path) {
        float[] fArr = new float[6];
        char c10 = 'm';
        for (b bVar : bVarArr) {
            b.e(path, fArr, c10, bVar.f214a, bVar.f215b);
            c10 = bVar.f214a;
        }
    }

    public static void k(b[] bVarArr, b[] bVarArr2) {
        for (int i10 = 0; i10 < bVarArr2.length; i10++) {
            bVarArr[i10].f214a = bVarArr2[i10].f214a;
            for (int i11 = 0; i11 < bVarArr2[i10].f215b.length; i11++) {
                bVarArr[i10].f215b[i11] = bVarArr2[i10].f215b[i11];
            }
        }
    }

    /* compiled from: PathParser.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public char f214a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f215b;

        public b(char c10, float[] fArr) {
            this.f214a = c10;
            this.f215b = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void e(Path path, float[] fArr, char c10, char c11, float[] fArr2) {
            int i10;
            int i11;
            int i12;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            char c12 = c11;
            boolean z14 = false;
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr[2];
            float f21 = fArr[3];
            float f22 = fArr[4];
            float f23 = fArr[5];
            switch (c12) {
                case 'A':
                case 'a':
                    i10 = 7;
                    i11 = i10;
                    break;
                case 'C':
                case 'c':
                    i10 = 6;
                    i11 = i10;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i11 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i11 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i11 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f22, f23);
                    f18 = f22;
                    f20 = f18;
                    f19 = f23;
                    f21 = f19;
                    i11 = 2;
                    break;
            }
            float f24 = f18;
            float f25 = f19;
            float f26 = f22;
            float f27 = f23;
            int i13 = 0;
            char c13 = c10;
            while (i13 < fArr2.length) {
                if (c12 != 'A') {
                    if (c12 != 'C') {
                        if (c12 != 'H') {
                            if (c12 != 'Q') {
                                if (c12 != 'V') {
                                    if (c12 != 'a') {
                                        if (c12 != 'c') {
                                            if (c12 != 'h') {
                                                if (c12 != 'q') {
                                                    if (c12 != 'v') {
                                                        if (c12 != 'L') {
                                                            if (c12 != 'M') {
                                                                if (c12 != 'S') {
                                                                    if (c12 != 'T') {
                                                                        if (c12 != 'l') {
                                                                            if (c12 != 'm') {
                                                                                if (c12 != 's') {
                                                                                    if (c12 == 't') {
                                                                                        if (c13 != 'q' && c13 != 't' && c13 != 'Q' && c13 != 'T') {
                                                                                            f17 = 0.0f;
                                                                                            f16 = 0.0f;
                                                                                        } else {
                                                                                            f16 = f24 - f20;
                                                                                            f17 = f25 - f21;
                                                                                        }
                                                                                        int i14 = i13 + 1;
                                                                                        path.rQuadTo(f16, f17, fArr2[i13], fArr2[i14]);
                                                                                        float f28 = f16 + f24;
                                                                                        float f29 = f17 + f25;
                                                                                        f24 += fArr2[i13];
                                                                                        f25 += fArr2[i14];
                                                                                        f21 = f29;
                                                                                        f20 = f28;
                                                                                    }
                                                                                } else {
                                                                                    if (c13 != 'c' && c13 != 's' && c13 != 'C' && c13 != 'S') {
                                                                                        f15 = 0.0f;
                                                                                        f14 = 0.0f;
                                                                                    } else {
                                                                                        float f30 = f24 - f20;
                                                                                        f14 = f25 - f21;
                                                                                        f15 = f30;
                                                                                    }
                                                                                    int i15 = i13 + 1;
                                                                                    int i16 = i13 + 2;
                                                                                    int i17 = i13 + 3;
                                                                                    path.rCubicTo(f15, f14, fArr2[i13], fArr2[i15], fArr2[i16], fArr2[i17]);
                                                                                    f10 = fArr2[i13] + f24;
                                                                                    f11 = fArr2[i15] + f25;
                                                                                    f24 += fArr2[i16];
                                                                                    f12 = fArr2[i17];
                                                                                }
                                                                            } else {
                                                                                float f31 = fArr2[i13];
                                                                                f24 += f31;
                                                                                float f32 = fArr2[i13 + 1];
                                                                                f25 += f32;
                                                                                if (i13 > 0) {
                                                                                    path.rLineTo(f31, f32);
                                                                                } else {
                                                                                    path.rMoveTo(f31, f32);
                                                                                    i12 = i13;
                                                                                    f27 = f25;
                                                                                    f26 = f24;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            int i18 = i13 + 1;
                                                                            path.rLineTo(fArr2[i13], fArr2[i18]);
                                                                            f24 += fArr2[i13];
                                                                            f13 = fArr2[i18];
                                                                        }
                                                                    } else {
                                                                        if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                                                            f24 = (f24 * 2.0f) - f20;
                                                                            f25 = (f25 * 2.0f) - f21;
                                                                        }
                                                                        int i19 = i13 + 1;
                                                                        path.quadTo(f24, f25, fArr2[i13], fArr2[i19]);
                                                                        i12 = i13;
                                                                        f21 = f25;
                                                                        f20 = f24;
                                                                        f24 = fArr2[i13];
                                                                        f25 = fArr2[i19];
                                                                    }
                                                                } else {
                                                                    if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                                                        f24 = (f24 * 2.0f) - f20;
                                                                        f25 = (f25 * 2.0f) - f21;
                                                                    }
                                                                    float f33 = f25;
                                                                    float f34 = f24;
                                                                    int i20 = i13 + 1;
                                                                    int i21 = i13 + 2;
                                                                    int i22 = i13 + 3;
                                                                    path.cubicTo(f34, f33, fArr2[i13], fArr2[i20], fArr2[i21], fArr2[i22]);
                                                                    f10 = fArr2[i13];
                                                                    f11 = fArr2[i20];
                                                                    f24 = fArr2[i21];
                                                                    f25 = fArr2[i22];
                                                                    f20 = f10;
                                                                    f21 = f11;
                                                                }
                                                            } else {
                                                                f24 = fArr2[i13];
                                                                f25 = fArr2[i13 + 1];
                                                                if (i13 > 0) {
                                                                    path.lineTo(f24, f25);
                                                                } else {
                                                                    path.moveTo(f24, f25);
                                                                    i12 = i13;
                                                                    f27 = f25;
                                                                    f26 = f24;
                                                                }
                                                            }
                                                        } else {
                                                            int i23 = i13 + 1;
                                                            path.lineTo(fArr2[i13], fArr2[i23]);
                                                            f24 = fArr2[i13];
                                                            f25 = fArr2[i23];
                                                        }
                                                    } else {
                                                        path.rLineTo(0.0f, fArr2[i13]);
                                                        f13 = fArr2[i13];
                                                    }
                                                    f25 += f13;
                                                } else {
                                                    int i24 = i13 + 1;
                                                    int i25 = i13 + 2;
                                                    int i26 = i13 + 3;
                                                    path.rQuadTo(fArr2[i13], fArr2[i24], fArr2[i25], fArr2[i26]);
                                                    f10 = fArr2[i13] + f24;
                                                    f11 = fArr2[i24] + f25;
                                                    f24 += fArr2[i25];
                                                    f12 = fArr2[i26];
                                                }
                                            } else {
                                                path.rLineTo(fArr2[i13], 0.0f);
                                                f24 += fArr2[i13];
                                            }
                                            i12 = i13;
                                        } else {
                                            int i27 = i13 + 2;
                                            int i28 = i13 + 3;
                                            int i29 = i13 + 4;
                                            int i30 = i13 + 5;
                                            path.rCubicTo(fArr2[i13], fArr2[i13 + 1], fArr2[i27], fArr2[i28], fArr2[i29], fArr2[i30]);
                                            f10 = fArr2[i27] + f24;
                                            f11 = fArr2[i28] + f25;
                                            f24 += fArr2[i29];
                                            f12 = fArr2[i30];
                                        }
                                        f25 += f12;
                                        f20 = f10;
                                        f21 = f11;
                                        i12 = i13;
                                    } else {
                                        int i31 = i13 + 5;
                                        float f35 = fArr2[i31] + f24;
                                        int i32 = i13 + 6;
                                        float f36 = fArr2[i32] + f25;
                                        float f37 = fArr2[i13];
                                        float f38 = fArr2[i13 + 1];
                                        float f39 = fArr2[i13 + 2];
                                        if (fArr2[i13 + 3] != 0.0f) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                        if (fArr2[i13 + 4] != 0.0f) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        i12 = i13;
                                        g(path, f24, f25, f35, f36, f37, f38, f39, z12, z13);
                                        f24 += fArr2[i31];
                                        f25 += fArr2[i32];
                                    }
                                } else {
                                    i12 = i13;
                                    path.lineTo(f24, fArr2[i12]);
                                    f25 = fArr2[i12];
                                }
                            } else {
                                i12 = i13;
                                int i33 = i12 + 1;
                                int i34 = i12 + 2;
                                int i35 = i12 + 3;
                                path.quadTo(fArr2[i12], fArr2[i33], fArr2[i34], fArr2[i35]);
                                float f40 = fArr2[i12];
                                float f41 = fArr2[i33];
                                f24 = fArr2[i34];
                                f25 = fArr2[i35];
                                f20 = f40;
                                f21 = f41;
                            }
                        } else {
                            i12 = i13;
                            path.lineTo(fArr2[i12], f25);
                            f24 = fArr2[i12];
                        }
                    } else {
                        i12 = i13;
                        int i36 = i12 + 2;
                        int i37 = i12 + 3;
                        int i38 = i12 + 4;
                        int i39 = i12 + 5;
                        path.cubicTo(fArr2[i12], fArr2[i12 + 1], fArr2[i36], fArr2[i37], fArr2[i38], fArr2[i39]);
                        f24 = fArr2[i38];
                        float f42 = fArr2[i39];
                        float f43 = fArr2[i36];
                        float f44 = fArr2[i37];
                        f25 = f42;
                        f21 = f44;
                        f20 = f43;
                    }
                    i13 = i12 + i11;
                    c13 = c11;
                    c12 = c13;
                    z14 = false;
                } else {
                    i12 = i13;
                    float f45 = f25;
                    float f46 = f24;
                    int i40 = i12 + 5;
                    float f47 = fArr2[i40];
                    int i41 = i12 + 6;
                    float f48 = fArr2[i41];
                    float f49 = fArr2[i12];
                    float f50 = fArr2[i12 + 1];
                    float f51 = fArr2[i12 + 2];
                    if (fArr2[i12 + 3] != 0.0f) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (fArr2[i12 + 4] != 0.0f) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    g(path, f46, f45, f47, f48, f49, f50, f51, z10, z11);
                    f24 = fArr2[i40];
                    f25 = fArr2[i41];
                }
                f21 = f25;
                f20 = f24;
                i13 = i12 + i11;
                c13 = c11;
                c12 = c13;
                z14 = false;
            }
            fArr[z14 ? 1 : 0] = f24;
            fArr[1] = f25;
            fArr[2] = f20;
            fArr[3] = f21;
            fArr[4] = f26;
            fArr[5] = f27;
        }

        public static void f(Path path, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
            double d19 = d12;
            int ceil = (int) Math.ceil(Math.abs((d18 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d16);
            double sin = Math.sin(d16);
            double cos2 = Math.cos(d17);
            double sin2 = Math.sin(d17);
            double d20 = -d19;
            double d21 = d20 * cos;
            double d22 = d13 * sin;
            double d23 = (d21 * sin2) - (d22 * cos2);
            double d24 = d20 * sin;
            double d25 = d13 * cos;
            double d26 = (sin2 * d24) + (cos2 * d25);
            double d27 = d18 / ceil;
            double d28 = d26;
            double d29 = d23;
            int i10 = 0;
            double d30 = d14;
            double d31 = d15;
            double d32 = d17;
            while (i10 < ceil) {
                double d33 = d32 + d27;
                double sin3 = Math.sin(d33);
                double cos3 = Math.cos(d33);
                double d34 = (d10 + ((d19 * cos) * cos3)) - (d22 * sin3);
                double d35 = d11 + (d19 * sin * cos3) + (d25 * sin3);
                double d36 = (d21 * sin3) - (d22 * cos3);
                double d37 = (sin3 * d24) + (cos3 * d25);
                double d38 = d33 - d32;
                double tan = Math.tan(d38 / 2.0d);
                double sin4 = (Math.sin(d38) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d39 = d30 + (d29 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d39, (float) (d31 + (d28 * sin4)), (float) (d34 - (sin4 * d36)), (float) (d35 - (sin4 * d37)), (float) d34, (float) d35);
                i10++;
                d27 = d27;
                sin = sin;
                d30 = d34;
                d24 = d24;
                cos = cos;
                d32 = d33;
                d28 = d37;
                d29 = d36;
                ceil = ceil;
                d31 = d35;
                d19 = d12;
            }
        }

        public static void g(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean z10, boolean z11) {
            double d10;
            double d11;
            boolean z12;
            double radians = Math.toRadians(f16);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d12 = f10;
            double d13 = d12 * cos;
            double d14 = f11;
            double d15 = f14;
            double d16 = (d13 + (d14 * sin)) / d15;
            double d17 = ((-f10) * sin) + (d14 * cos);
            double d18 = f15;
            double d19 = d17 / d18;
            double d20 = f13;
            double d21 = ((f12 * cos) + (d20 * sin)) / d15;
            double d22 = (((-f12) * sin) + (d20 * cos)) / d18;
            double d23 = d16 - d21;
            double d24 = d19 - d22;
            double d25 = (d16 + d21) / 2.0d;
            double d26 = (d19 + d22) / 2.0d;
            double d27 = (d23 * d23) + (d24 * d24);
            if (d27 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d28 = (1.0d / d27) - 0.25d;
            if (d28 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d27);
                float sqrt = (float) (Math.sqrt(d27) / 1.99999d);
                g(path, f10, f11, f12, f13, f14 * sqrt, f15 * sqrt, f16, z10, z11);
                return;
            }
            double sqrt2 = Math.sqrt(d28);
            double d29 = d23 * sqrt2;
            double d30 = sqrt2 * d24;
            if (z10 == z11) {
                d10 = d25 - d30;
                d11 = d26 + d29;
            } else {
                d10 = d25 + d30;
                d11 = d26 - d29;
            }
            double atan2 = Math.atan2(d19 - d11, d16 - d10);
            double atan22 = Math.atan2(d22 - d11, d21 - d10) - atan2;
            if (atan22 >= 0.0d) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z11 != z12) {
                if (atan22 > 0.0d) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d31 = d10 * d15;
            double d32 = d11 * d18;
            f(path, (d31 * cos) - (d32 * sin), (d31 * sin) + (d32 * cos), d15, d18, d12, d14, radians, atan2, atan22);
        }

        @Deprecated
        public static void h(b[] bVarArr, Path path) {
            d.j(bVarArr, path);
        }

        public b(b bVar) {
            this.f214a = bVar.f214a;
            float[] fArr = bVar.f215b;
            this.f215b = d.c(fArr, 0, fArr.length);
        }
    }
}
