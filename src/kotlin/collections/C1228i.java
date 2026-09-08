package kotlin.collections;

import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: _ArraysJvm.kt */
/* renamed from: kotlin.collections.i */
/* loaded from: classes4.dex */
public class C1228i extends C1227h {

    /* compiled from: _ArraysJvm.kt */
    /* renamed from: kotlin.collections.i$a */
    /* loaded from: classes4.dex */
    public static final class a extends AbstractC1221b<Integer> implements RandomAccess {

        /* renamed from: b */
        public final /* synthetic */ int[] f34203b;

        public a(int[] iArr) {
            this.f34203b = iArr;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.f34203b.length;
        }

        public boolean c(int i10) {
            boolean r10;
            r10 = C1229j.r(this.f34203b, i10);
            return r10;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Integer)) {
                return false;
            }
            return c(((Number) obj).intValue());
        }

        @Override // kotlin.collections.AbstractC1221b, java.util.List
        /* renamed from: e */
        public Integer get(int i10) {
            return Integer.valueOf(this.f34203b[i10]);
        }

        public int g(int i10) {
            return C1229j.C(this.f34203b, i10);
        }

        public int h(int i10) {
            return C1229j.G(this.f34203b, i10);
        }

        @Override // kotlin.collections.AbstractC1221b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return g(((Number) obj).intValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f34203b.length == 0) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.AbstractC1221b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return h(((Number) obj).intValue());
        }
    }

    public static List<Integer> e(int[] iArr) {
        kotlin.jvm.internal.i.f(iArr, "<this>");
        return new a(iArr);
    }

    public static <T> List<T> f(T[] tArr) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        List<T> a10 = C1230k.a(tArr);
        kotlin.jvm.internal.i.e(a10, "asList(...)");
        return a10;
    }

    public static byte[] g(byte[] bArr, byte[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.i.f(bArr, "<this>");
        kotlin.jvm.internal.i.f(destination, "destination");
        System.arraycopy(bArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static int[] h(int[] iArr, int[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.i.f(iArr, "<this>");
        kotlin.jvm.internal.i.f(destination, "destination");
        System.arraycopy(iArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static long[] i(long[] jArr, long[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.i.f(jArr, "<this>");
        kotlin.jvm.internal.i.f(destination, "destination");
        System.arraycopy(jArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static <T> T[] j(T[] tArr, T[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        kotlin.jvm.internal.i.f(destination, "destination");
        System.arraycopy(tArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static /* synthetic */ byte[] k(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        byte[] g10;
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        g10 = g(bArr, bArr2, i10, i11, i12);
        return g10;
    }

    public static /* synthetic */ int[] l(int[] iArr, int[] iArr2, int i10, int i11, int i12, int i13, Object obj) {
        int[] h10;
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length;
        }
        h10 = h(iArr, iArr2, i10, i11, i12);
        return h10;
    }

    public static /* synthetic */ Object[] m(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        Object[] j10;
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        j10 = j(objArr, objArr2, i10, i11, i12);
        return j10;
    }

    public static byte[] n(byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.i.f(bArr, "<this>");
        C1226g.c(i11, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kotlin.jvm.internal.i.e(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static <T> T[] o(T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        C1226g.c(i11, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
        kotlin.jvm.internal.i.e(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static final <T> void p(T[] tArr, T t10, int i10, int i11) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        Arrays.fill(tArr, i10, i11, t10);
    }
}
