package com.oplus.ocs.icdf.grpcchannel.inner;

import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import io.grpc.Status;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, Status> f28612a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f28613b = 0;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private int f28614a;

        public a(int i10) {
            this.f28614a = i10;
        }

        public int a() {
            return this.f28614a;
        }

        public int a(int i10) {
            int i11 = this.f28614a + i10;
            this.f28614a = i11;
            return i11;
        }
    }

    static {
        a(Status.f32368e);
        a(Status.f32369f);
        a(Status.f32370g);
        a(Status.f32371h);
        a(Status.f32372i);
        a(Status.f32373j);
        a(Status.f32374k);
        a(Status.f32375l);
        a(Status.f32377n);
        a(Status.f32378o);
        a(Status.f32379p);
        a(Status.f32380q);
        a(Status.f32381r);
        a(Status.f32382s);
        a(Status.f32383t);
        a(Status.f32384u);
        a(Status.f32376m);
    }

    private static void a(Status status) {
        f28612a.put(Integer.valueOf(status.m().c()), status);
    }

    public static byte b(Status status) {
        if (status != null) {
            return (byte) status.m().c();
        }
        return (byte) -1;
    }

    public static byte[] c(byte[] bArr, a aVar) {
        if (aVar.a() + 4 > bArr.length) {
            ICDFLog.e("ICDF.GlobalUtil", "byteArr_netToLocal, invalid length " + bArr.length);
            return null;
        }
        int i10 = (bArr[aVar.a() + 3] & 255) + ((bArr[aVar.a() + 2] & 255) << 8) + ((bArr[aVar.a() + 1] & 255) << 16) + ((bArr[aVar.a()] & 255) << 24);
        if (i10 < 0) {
            ICDFLog.e("ICDF.GlobalUtil", "byteArr_netToLocal, length " + i10 + " < 0");
            return null;
        }
        int a10 = aVar.a() + 4;
        if (aVar.a(i10 + 4) > bArr.length) {
            return null;
        }
        return Arrays.copyOfRange(bArr, a10, aVar.a());
    }

    public static int d(byte[] bArr, a aVar) {
        if (bArr == null) {
            ICDFLog.e("ICDF.GlobalUtil", "int_netToLocal, invalid netBytes");
            return -1;
        }
        if (bArr.length - aVar.a() < 4) {
            ICDFLog.e("ICDF.GlobalUtil", "int_netToLocal, invalid length " + bArr.length);
            return -1;
        }
        int i10 = ((bArr[aVar.a()] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((bArr[aVar.a() + 1] & FastPairConstants.GO_INTENT_NOT_SET) << 16) + ((bArr[aVar.a() + 2] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[aVar.a() + 3] & FastPairConstants.GO_INTENT_NOT_SET);
        aVar.a(4);
        return i10;
    }

    public static short e(byte[] bArr, a aVar) {
        if (bArr.length - aVar.a() < 2) {
            ICDFLog.e("ICDF.GlobalUtil", "int_netToLocal, invalid length " + bArr.length);
            return (short) -1;
        }
        short s10 = (short) (((short) ((bArr[aVar.a()] & FastPairConstants.GO_INTENT_NOT_SET) << 8)) + (bArr[aVar.a() + 1] & FastPairConstants.GO_INTENT_NOT_SET));
        aVar.a(2);
        return s10;
    }

    public static byte[] a(int i10, byte b10, byte[] bArr, boolean z10) {
        int i11 = z10 ? 4 : 0;
        int length = (bArr == null ? 0 : bArr.length) + 11 + i11;
        byte[] bArr2 = new byte[length];
        int i12 = (length - 8) - i11;
        bArr2[i11] = 73;
        bArr2[i11 + 1] = 67;
        bArr2[i11 + 2] = 68;
        bArr2[i11 + 3] = 70;
        bArr2[i11 + 4] = (byte) ((i12 >> 24) & 255);
        bArr2[i11 + 5] = (byte) ((i12 >> 16) & 255);
        bArr2[i11 + 6] = (byte) ((i12 >> 8) & 255);
        bArr2[i11 + 7] = (byte) (i12 & 255);
        bArr2[i11 + 8] = (byte) (i10 >> 8);
        bArr2[i11 + 9] = (byte) i10;
        bArr2[i11 + 10] = b10;
        if (bArr != null && bArr.length > 0) {
            System.arraycopy(bArr, 0, bArr2, i11 + 11, bArr.length);
        }
        return bArr2;
    }

    public static InputStream b(byte[] bArr, a aVar) {
        int a10 = aVar.a();
        if (a10 + 4 > bArr.length) {
            ICDFLog.e("ICDF.GlobalUtil", "netToInputStream, pos " + a10 + " > netBytes.length " + bArr.length);
            return null;
        }
        int i10 = (bArr[aVar.a() + 3] & 255) + ((bArr[aVar.a() + 2] & 255) << 8) + ((bArr[aVar.a() + 1] & 255) << 16) + ((bArr[aVar.a()] & 255) << 24);
        if (i10 < 0) {
            ICDFLog.e("ICDF.GlobalUtil", "netToInputStream, length " + i10 + " < 0");
            return null;
        }
        int a11 = aVar.a() + 4;
        int a12 = aVar.a(i10 + 4);
        if (a12 > bArr.length) {
            ICDFLog.e("ICDF.GlobalUtil", "netToInputStream, pos " + a12 + " > netBytes.length " + bArr.length);
            return null;
        }
        return new ByteArrayInputStream(bArr, a11, i10);
    }

    public static Status a(byte b10) {
        Status status = (Status) ((HashMap) f28612a).get(Integer.valueOf(b10));
        com.google.common.base.k.v(status != null, "client cancel : writeNetData fault!");
        return status;
    }

    public static byte[] a(int i10) {
        return new byte[]{(byte) (i10 >> 24), (byte) (i10 >> 16), (byte) (i10 >> 8), (byte) i10};
    }

    public static byte[] a(short s10) {
        return new byte[]{(byte) (s10 >> 8), (byte) s10};
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr == null ? -1 : bArr.length;
        byte[] bArr2 = new byte[length + 4];
        bArr2[0] = (byte) (length >> 24);
        bArr2[1] = (byte) (length >> 16);
        bArr2[2] = (byte) (length >> 8);
        bArr2[3] = (byte) length;
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        }
        return bArr2;
    }

    public static byte[][] a(byte[] bArr, a aVar) {
        if (aVar.a() + 4 > bArr.length) {
            ICDFLog.e("ICDF.GlobalUtil", "byteArr2D_netToLocal, invalid length " + bArr.length);
            return null;
        }
        int i10 = (bArr[aVar.a() + 3] & 255) + ((bArr[aVar.a() + 2] & 255) << 8) + ((bArr[aVar.a() + 1] & 255) << 16) + ((bArr[aVar.a()] & 255) << 24);
        if (i10 < 0) {
            return null;
        }
        byte[][] bArr2 = new byte[i10];
        aVar.a(4);
        for (int i11 = 0; i11 < i10; i11++) {
            bArr2[i11] = c(bArr, aVar);
        }
        return bArr2;
    }

    public static byte[] a(byte[][] bArr) {
        int i10;
        int i11 = 4;
        if (bArr != null) {
            i10 = 0;
            for (byte[] bArr2 : bArr) {
                i10 += bArr2.length + 4;
            }
        } else {
            i10 = 0;
        }
        byte[] bArr3 = new byte[i10 + 4];
        int length = bArr == null ? -1 : bArr.length;
        bArr3[0] = (byte) (length >> 24);
        bArr3[1] = (byte) (length >> 16);
        bArr3[2] = (byte) (length >> 8);
        bArr3[3] = (byte) length;
        if (bArr != null) {
            for (byte[] bArr4 : bArr) {
                byte[] a10 = a(bArr4);
                System.arraycopy(a10, 0, bArr3, i11, a10.length);
                i11 += a10.length;
            }
        }
        return bArr3;
    }
}
