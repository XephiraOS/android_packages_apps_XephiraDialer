package androidx.profileinstaller;

import Z.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: ProfileTranscoder.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f10792a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f10793b = {112, 114, 109, 0};

    public static void A(InputStream inputStream) {
        Z.c.h(inputStream);
        int j10 = Z.c.j(inputStream);
        if (j10 == 6 || j10 == 7) {
            return;
        }
        while (j10 > 0) {
            Z.c.j(inputStream);
            for (int j11 = Z.c.j(inputStream); j11 > 0; j11--) {
                Z.c.h(inputStream);
            }
            j10--;
        }
    }

    public static boolean B(OutputStream outputStream, byte[] bArr, Z.b[] bVarArr) {
        if (Arrays.equals(bArr, j.f5766a)) {
            N(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, j.f5767b)) {
            M(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, j.f5769d)) {
            K(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, j.f5768c)) {
            L(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, j.f5770e)) {
            J(outputStream, bVarArr);
            return true;
        }
        return false;
    }

    public static void C(OutputStream outputStream, Z.b bVar) {
        int[] iArr = bVar.f5756h;
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            Z.c.p(outputStream, i12 - i11);
            i10++;
            i11 = i12;
        }
    }

    public static f D(Z.b[] bVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Z.c.p(byteArrayOutputStream, bVarArr.length);
            int i10 = 2;
            for (Z.b bVar : bVarArr) {
                Z.c.q(byteArrayOutputStream, bVar.f5751c);
                Z.c.q(byteArrayOutputStream, bVar.f5752d);
                Z.c.q(byteArrayOutputStream, bVar.f5755g);
                String j10 = j(bVar.f5749a, bVar.f5750b, j.f5766a);
                int k10 = Z.c.k(j10);
                Z.c.p(byteArrayOutputStream, k10);
                i10 = i10 + 14 + k10;
                Z.c.n(byteArrayOutputStream, j10);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                f fVar = new f(FileSectionType.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return fVar;
            }
            throw Z.c.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void E(OutputStream outputStream, byte[] bArr) {
        outputStream.write(f10792a);
        outputStream.write(bArr);
    }

    public static void F(OutputStream outputStream, Z.b bVar) {
        I(outputStream, bVar);
        C(outputStream, bVar);
        H(outputStream, bVar);
    }

    public static void G(OutputStream outputStream, Z.b bVar, String str) {
        Z.c.p(outputStream, Z.c.k(str));
        Z.c.p(outputStream, bVar.f5753e);
        Z.c.q(outputStream, bVar.f5754f);
        Z.c.q(outputStream, bVar.f5751c);
        Z.c.q(outputStream, bVar.f5755g);
        Z.c.n(outputStream, str);
    }

    public static void H(OutputStream outputStream, Z.b bVar) {
        byte[] bArr = new byte[k(bVar.f5755g)];
        for (Map.Entry<Integer, Integer> entry : bVar.f5757i.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            if ((intValue2 & 2) != 0) {
                z(bArr, 2, intValue, bVar);
            }
            if ((intValue2 & 4) != 0) {
                z(bArr, 4, intValue, bVar);
            }
        }
        outputStream.write(bArr);
    }

    public static void I(OutputStream outputStream, Z.b bVar) {
        int i10 = 0;
        for (Map.Entry<Integer, Integer> entry : bVar.f5757i.entrySet()) {
            int intValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                Z.c.p(outputStream, intValue - i10);
                Z.c.p(outputStream, 0);
                i10 = intValue;
            }
        }
    }

    public static void J(OutputStream outputStream, Z.b[] bVarArr) {
        Z.c.p(outputStream, bVarArr.length);
        for (Z.b bVar : bVarArr) {
            String j10 = j(bVar.f5749a, bVar.f5750b, j.f5770e);
            Z.c.p(outputStream, Z.c.k(j10));
            Z.c.p(outputStream, bVar.f5757i.size());
            Z.c.p(outputStream, bVar.f5756h.length);
            Z.c.q(outputStream, bVar.f5751c);
            Z.c.n(outputStream, j10);
            Iterator<Integer> it = bVar.f5757i.keySet().iterator();
            while (it.hasNext()) {
                Z.c.p(outputStream, it.next().intValue());
            }
            for (int i10 : bVar.f5756h) {
                Z.c.p(outputStream, i10);
            }
        }
    }

    public static void K(OutputStream outputStream, Z.b[] bVarArr) {
        Z.c.r(outputStream, bVarArr.length);
        for (Z.b bVar : bVarArr) {
            int size = bVar.f5757i.size() * 4;
            String j10 = j(bVar.f5749a, bVar.f5750b, j.f5769d);
            Z.c.p(outputStream, Z.c.k(j10));
            Z.c.p(outputStream, bVar.f5756h.length);
            Z.c.q(outputStream, size);
            Z.c.q(outputStream, bVar.f5751c);
            Z.c.n(outputStream, j10);
            Iterator<Integer> it = bVar.f5757i.keySet().iterator();
            while (it.hasNext()) {
                Z.c.p(outputStream, it.next().intValue());
                Z.c.p(outputStream, 0);
            }
            for (int i10 : bVar.f5756h) {
                Z.c.p(outputStream, i10);
            }
        }
    }

    public static void L(OutputStream outputStream, Z.b[] bVarArr) {
        byte[] b10 = b(bVarArr, j.f5768c);
        Z.c.r(outputStream, bVarArr.length);
        Z.c.m(outputStream, b10);
    }

    public static void M(OutputStream outputStream, Z.b[] bVarArr) {
        byte[] b10 = b(bVarArr, j.f5767b);
        Z.c.r(outputStream, bVarArr.length);
        Z.c.m(outputStream, b10);
    }

    public static void N(OutputStream outputStream, Z.b[] bVarArr) {
        O(outputStream, bVarArr);
    }

    public static void O(OutputStream outputStream, Z.b[] bVarArr) {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(bVarArr));
        arrayList.add(c(bVarArr));
        arrayList.add(d(bVarArr));
        long length2 = j.f5766a.length + f10792a.length + 4 + (arrayList.size() * 16);
        Z.c.q(outputStream, arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            f fVar = (f) arrayList.get(i10);
            Z.c.q(outputStream, fVar.f10804a.b());
            Z.c.q(outputStream, length2);
            if (fVar.f10807d) {
                byte[] bArr = fVar.f10806c;
                long length3 = bArr.length;
                byte[] b10 = Z.c.b(bArr);
                arrayList2.add(b10);
                Z.c.q(outputStream, b10.length);
                Z.c.q(outputStream, length3);
                length = b10.length;
            } else {
                arrayList2.add(fVar.f10806c);
                Z.c.q(outputStream, fVar.f10806c.length);
                Z.c.q(outputStream, 0L);
                length = fVar.f10806c.length;
            }
            length2 += length;
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            outputStream.write((byte[]) arrayList2.get(i11));
        }
    }

    public static int a(Z.b bVar) {
        Iterator<Map.Entry<Integer, Integer>> it = bVar.f5757i.entrySet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 |= it.next().getValue().intValue();
        }
        return i10;
    }

    public static byte[] b(Z.b[] bVarArr, byte[] bArr) {
        int i10 = 0;
        int i11 = 0;
        for (Z.b bVar : bVarArr) {
            i11 += Z.c.k(j(bVar.f5749a, bVar.f5750b, bArr)) + 16 + (bVar.f5753e * 2) + bVar.f5754f + k(bVar.f5755g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i11);
        if (Arrays.equals(bArr, j.f5768c)) {
            int length = bVarArr.length;
            while (i10 < length) {
                Z.b bVar2 = bVarArr[i10];
                G(byteArrayOutputStream, bVar2, j(bVar2.f5749a, bVar2.f5750b, bArr));
                F(byteArrayOutputStream, bVar2);
                i10++;
            }
        } else {
            for (Z.b bVar3 : bVarArr) {
                G(byteArrayOutputStream, bVar3, j(bVar3.f5749a, bVar3.f5750b, bArr));
            }
            int length2 = bVarArr.length;
            while (i10 < length2) {
                F(byteArrayOutputStream, bVarArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == i11) {
            return byteArrayOutputStream.toByteArray();
        }
        throw Z.c.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i11);
    }

    public static f c(Z.b[] bVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            try {
                Z.b bVar = bVarArr[i11];
                Z.c.p(byteArrayOutputStream, i11);
                Z.c.p(byteArrayOutputStream, bVar.f5753e);
                i10 = i10 + 4 + (bVar.f5753e * 2);
                C(byteArrayOutputStream, bVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            f fVar = new f(FileSectionType.CLASSES, i10, byteArray, true);
            byteArrayOutputStream.close();
            return fVar;
        }
        throw Z.c.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static f d(Z.b[] bVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            try {
                Z.b bVar = bVarArr[i11];
                int a10 = a(bVar);
                byte[] e10 = e(bVar);
                byte[] f10 = f(bVar);
                Z.c.p(byteArrayOutputStream, i11);
                int length = e10.length + 2 + f10.length;
                Z.c.q(byteArrayOutputStream, length);
                Z.c.p(byteArrayOutputStream, a10);
                byteArrayOutputStream.write(e10);
                byteArrayOutputStream.write(f10);
                i10 = i10 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            f fVar = new f(FileSectionType.METHODS, i10, byteArray, true);
            byteArrayOutputStream.close();
            return fVar;
        }
        throw Z.c.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(Z.b bVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, bVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] f(Z.b bVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, bVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String g(String str, String str2) {
        if ("!".equals(str2)) {
            return str.replace(":", "!");
        }
        if (":".equals(str2)) {
            return str.replace("!", ":");
        }
        return str;
    }

    public static String h(String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        if (indexOf > 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    public static Z.b i(Z.b[] bVarArr, String str) {
        if (bVarArr.length <= 0) {
            return null;
        }
        String h10 = h(str);
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if (bVarArr[i10].f5750b.equals(h10)) {
                return bVarArr[i10];
            }
        }
        return null;
    }

    public static String j(String str, String str2, byte[] bArr) {
        String a10 = j.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a10);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (!str2.contains("!") && !str2.contains(":")) {
            if (str2.endsWith(".apk")) {
                return str2;
            }
            return str + j.a(bArr) + str2;
        }
        return g(str2, a10);
    }

    public static int k(int i10) {
        return y(i10 * 2) / 8;
    }

    public static int l(int i10, int i11, int i12) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 4) {
                    return i11 + i12;
                }
                throw Z.c.c("Unexpected flag: " + i10);
            }
            return i11;
        }
        throw Z.c.c("HOT methods are not stored in the bitmap");
    }

    public static int[] m(InputStream inputStream, int i10) {
        int[] iArr = new int[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += Z.c.h(inputStream);
            iArr[i12] = i11;
        }
        return iArr;
    }

    public static int n(BitSet bitSet, int i10, int i11) {
        int i12 = 2;
        if (!bitSet.get(l(2, i10, i11))) {
            i12 = 0;
        }
        if (bitSet.get(l(4, i10, i11))) {
            return i12 | 4;
        }
        return i12;
    }

    public static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, Z.c.d(inputStream, bArr.length))) {
            return Z.c.d(inputStream, j.f5767b.length);
        }
        throw Z.c.c("Invalid magic");
    }

    public static void p(InputStream inputStream, Z.b bVar) {
        int available = inputStream.available() - bVar.f5754f;
        int i10 = 0;
        while (inputStream.available() > available) {
            i10 += Z.c.h(inputStream);
            bVar.f5757i.put(Integer.valueOf(i10), 1);
            for (int h10 = Z.c.h(inputStream); h10 > 0; h10--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw Z.c.c("Read too much data during profile line parse");
        }
    }

    public static Z.b[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, Z.b[] bVarArr) {
        if (Arrays.equals(bArr, j.f5771f)) {
            if (!Arrays.equals(j.f5766a, bArr2)) {
                return r(inputStream, bArr, bVarArr);
            }
            throw Z.c.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (Arrays.equals(bArr, j.f5772g)) {
            return t(inputStream, bArr2, bVarArr);
        }
        throw Z.c.c("Unsupported meta version");
    }

    public static Z.b[] r(InputStream inputStream, byte[] bArr, Z.b[] bVarArr) {
        if (Arrays.equals(bArr, j.f5771f)) {
            int j10 = Z.c.j(inputStream);
            byte[] e10 = Z.c.e(inputStream, (int) Z.c.i(inputStream), (int) Z.c.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e10);
                try {
                    Z.b[] s10 = s(byteArrayInputStream, j10, bVarArr);
                    byteArrayInputStream.close();
                    return s10;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw Z.c.c("Content found after the end of file");
        }
        throw Z.c.c("Unsupported meta version");
    }

    public static Z.b[] s(InputStream inputStream, int i10, Z.b[] bVarArr) {
        if (inputStream.available() == 0) {
            return new Z.b[0];
        }
        if (i10 == bVarArr.length) {
            String[] strArr = new String[i10];
            int[] iArr = new int[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                int h10 = Z.c.h(inputStream);
                iArr[i11] = Z.c.h(inputStream);
                strArr[i11] = Z.c.f(inputStream, h10);
            }
            for (int i12 = 0; i12 < i10; i12++) {
                Z.b bVar = bVarArr[i12];
                if (bVar.f5750b.equals(strArr[i12])) {
                    int i13 = iArr[i12];
                    bVar.f5753e = i13;
                    bVar.f5756h = m(inputStream, i13);
                } else {
                    throw Z.c.c("Order of dexfiles in metadata did not match baseline");
                }
            }
            return bVarArr;
        }
        throw Z.c.c("Mismatched number of dex files found in metadata");
    }

    public static Z.b[] t(InputStream inputStream, byte[] bArr, Z.b[] bVarArr) {
        int h10 = Z.c.h(inputStream);
        byte[] e10 = Z.c.e(inputStream, (int) Z.c.i(inputStream), (int) Z.c.i(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e10);
            try {
                Z.b[] u10 = u(byteArrayInputStream, bArr, h10, bVarArr);
                byteArrayInputStream.close();
                return u10;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        throw Z.c.c("Content found after the end of file");
    }

    public static Z.b[] u(InputStream inputStream, byte[] bArr, int i10, Z.b[] bVarArr) {
        if (inputStream.available() == 0) {
            return new Z.b[0];
        }
        if (i10 == bVarArr.length) {
            for (int i11 = 0; i11 < i10; i11++) {
                Z.c.h(inputStream);
                String f10 = Z.c.f(inputStream, Z.c.h(inputStream));
                long i12 = Z.c.i(inputStream);
                int h10 = Z.c.h(inputStream);
                Z.b i13 = i(bVarArr, f10);
                if (i13 != null) {
                    i13.f5752d = i12;
                    int[] m10 = m(inputStream, h10);
                    if (Arrays.equals(bArr, j.f5770e)) {
                        i13.f5753e = h10;
                        i13.f5756h = m10;
                    }
                } else {
                    throw Z.c.c("Missing profile key: " + f10);
                }
            }
            return bVarArr;
        }
        throw Z.c.c("Mismatched number of dex files found in metadata");
    }

    public static void v(InputStream inputStream, Z.b bVar) {
        BitSet valueOf = BitSet.valueOf(Z.c.d(inputStream, Z.c.a(bVar.f5755g * 2)));
        int i10 = 0;
        while (true) {
            int i11 = bVar.f5755g;
            if (i10 < i11) {
                int n10 = n(valueOf, i10, i11);
                if (n10 != 0) {
                    Integer num = bVar.f5757i.get(Integer.valueOf(i10));
                    if (num == null) {
                        num = 0;
                    }
                    bVar.f5757i.put(Integer.valueOf(i10), Integer.valueOf(n10 | num.intValue()));
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public static Z.b[] w(InputStream inputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, j.f5767b)) {
            int j10 = Z.c.j(inputStream);
            byte[] e10 = Z.c.e(inputStream, (int) Z.c.i(inputStream), (int) Z.c.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e10);
                try {
                    Z.b[] x10 = x(byteArrayInputStream, str, j10);
                    byteArrayInputStream.close();
                    return x10;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw Z.c.c("Content found after the end of file");
        }
        throw Z.c.c("Unsupported version");
    }

    public static Z.b[] x(InputStream inputStream, String str, int i10) {
        if (inputStream.available() == 0) {
            return new Z.b[0];
        }
        Z.b[] bVarArr = new Z.b[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int h10 = Z.c.h(inputStream);
            int h11 = Z.c.h(inputStream);
            bVarArr[i11] = new Z.b(str, Z.c.f(inputStream, h10), Z.c.i(inputStream), 0L, h11, (int) Z.c.i(inputStream), (int) Z.c.i(inputStream), new int[h11], new TreeMap());
        }
        for (int i12 = 0; i12 < i10; i12++) {
            Z.b bVar = bVarArr[i12];
            p(inputStream, bVar);
            bVar.f5756h = m(inputStream, bVar.f5753e);
            v(inputStream, bVar);
        }
        return bVarArr;
    }

    public static int y(int i10) {
        return (i10 + 7) & (-8);
    }

    public static void z(byte[] bArr, int i10, int i11, Z.b bVar) {
        int l10 = l(i10, i11, bVar.f5755g);
        int i12 = l10 / 8;
        bArr[i12] = (byte) ((1 << (l10 % 8)) | bArr[i12]);
    }
}
