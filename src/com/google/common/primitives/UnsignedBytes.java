package com.google.common.primitives;

import com.heytap.accessory.constant.FastPairConstants;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public final class UnsignedBytes {

    /* loaded from: classes3.dex */
    public static class LexicographicalComparatorHolder {

        /* renamed from: a, reason: collision with root package name */
        public static final String f24607a = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";

        /* renamed from: b, reason: collision with root package name */
        public static final Comparator<byte[]> f24608b = a();

        /* loaded from: classes3.dex */
        public enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            @Override // java.util.Comparator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                for (int i10 = 0; i10 < min; i10++) {
                    int a10 = UnsignedBytes.a(bArr[i10], bArr2[i10]);
                    if (a10 != 0) {
                        return a10;
                    }
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        /* loaded from: classes3.dex */
        public enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;


            /* renamed from: b, reason: collision with root package name */
            public static final boolean f24612b = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);

            /* renamed from: c, reason: collision with root package name */
            public static final Unsafe f24613c;

            /* renamed from: d, reason: collision with root package name */
            public static final int f24614d;

            /* loaded from: classes3.dex */
            public class a implements PrivilegedExceptionAction<Unsafe> {
                @Override // java.security.PrivilegedExceptionAction
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unsafe run() {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            }

            static {
                Unsafe c10 = c();
                f24613c = c10;
                int arrayBaseOffset = c10.arrayBaseOffset(byte[].class);
                f24614d = arrayBaseOffset;
                if ("64".equals(System.getProperty("sun.arch.data.model")) && arrayBaseOffset % 8 == 0 && c10.arrayIndexScale(byte[].class) == 1) {
                } else {
                    throw new Error();
                }
            }

            public static Unsafe c() {
                try {
                    try {
                        return Unsafe.getUnsafe();
                    } catch (PrivilegedActionException e10) {
                        throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                    }
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new a());
                }
            }

            @Override // java.util.Comparator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                int i10 = min & (-8);
                int i11 = 0;
                while (i11 < i10) {
                    Unsafe unsafe = f24613c;
                    int i12 = f24614d;
                    long j10 = i11;
                    long j11 = unsafe.getLong(bArr, i12 + j10);
                    long j12 = unsafe.getLong(bArr2, i12 + j10);
                    if (j11 != j12) {
                        if (f24612b) {
                            return e.a(j11, j12);
                        }
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j11 ^ j12) & (-8);
                        return ((int) ((j11 >>> numberOfTrailingZeros) & 255)) - ((int) (255 & (j12 >>> numberOfTrailingZeros)));
                    }
                    i11 += 8;
                }
                while (i11 < min) {
                    int a10 = UnsignedBytes.a(bArr[i11], bArr2[i11]);
                    if (a10 != 0) {
                        return a10;
                    }
                    i11++;
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        public static Comparator<byte[]> a() {
            try {
                Object[] enumConstants = Class.forName(f24607a).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }
    }

    public static int a(byte b10, byte b11) {
        return b(b10) - b(b11);
    }

    public static int b(byte b10) {
        return b10 & FastPairConstants.GO_INTENT_NOT_SET;
    }

    public static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }
}
