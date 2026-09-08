package s3;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.heytap.accessory.constant.FastPairConstants;
import d3.m;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import o3.AbstractC1397a;

/* compiled from: Util.java */
/* renamed from: s3.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1541l {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f36775a = "0123456789abcdef".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f36776b = new char[64];

    /* renamed from: c, reason: collision with root package name */
    public static volatile Handler f36777c;

    /* compiled from: Util.java */
    /* renamed from: s3.l$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36778a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f36778a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36778a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36778a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36778a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36778a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (r()) {
        } else {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(AbstractC1397a<?> abstractC1397a, AbstractC1397a<?> abstractC1397a2) {
        if (abstractC1397a == null) {
            if (abstractC1397a2 == null) {
                return true;
            }
            return false;
        }
        return abstractC1397a.C(abstractC1397a2);
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        if (obj instanceof m) {
            return ((m) obj).a(obj2);
        }
        return obj.equals(obj2);
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static String e(byte[] bArr, char[] cArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = b10 & FastPairConstants.GO_INTENT_NOT_SET;
            int i12 = i10 * 2;
            char[] cArr2 = f36775a;
            cArr[i12] = cArr2[i11 >>> 4];
            cArr[i12 + 1] = cArr2[b10 & FastPairConstants.GO_INTENT_MAX];
        }
        return new String(cArr);
    }

    public static <T> Queue<T> f(int i10) {
        return new ArrayDeque(i10);
    }

    public static int g(int i10, int i11, Bitmap.Config config) {
        return i10 * i11 * i(config);
    }

    public static int h(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int i(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i10 = a.f36778a[config.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2 || i10 == 3) {
            return 2;
        }
        if (i10 != 4) {
            return 4;
        }
        return 8;
    }

    public static <T> List<T> j(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t10 : collection) {
            if (t10 != null) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static Handler k() {
        if (f36777c == null) {
            synchronized (C1541l.class) {
                try {
                    if (f36777c == null) {
                        f36777c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f36777c;
    }

    public static int l(float f10) {
        return m(f10, 17);
    }

    public static int m(float f10, int i10) {
        return n(Float.floatToIntBits(f10), i10);
    }

    public static int n(int i10, int i11) {
        return (i11 * 31) + i10;
    }

    public static int o(Object obj, int i10) {
        int hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return n(hashCode, i10);
    }

    public static int p(boolean z10, int i10) {
        return n(z10 ? 1 : 0, i10);
    }

    public static boolean q() {
        return !r();
    }

    public static boolean r() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static boolean s(int i10) {
        if (i10 <= 0 && i10 != Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public static boolean t(int i10, int i11) {
        if (s(i10) && s(i11)) {
            return true;
        }
        return false;
    }

    public static void u(Runnable runnable) {
        k().post(runnable);
    }

    public static void v(Runnable runnable) {
        k().removeCallbacks(runnable);
    }

    public static String w(byte[] bArr) {
        String e10;
        char[] cArr = f36776b;
        synchronized (cArr) {
            e10 = e(bArr, cArr);
        }
        return e10;
    }
}
