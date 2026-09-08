package com.oplus.ocs.icdf.grpcchannel.inner;

import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;

/* loaded from: classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f28732a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f28733b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f28734c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f28735d = 0;

    private byte[] b(byte[] bArr) {
        if (bArr.length <= 8) {
            ICDFLog.e("ICDF.PacketAssemble", "invalid msg length: " + bArr.length);
            return null;
        }
        int i10 = ((bArr[0] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((bArr[1] & FastPairConstants.GO_INTENT_NOT_SET) << 16) + ((bArr[2] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[3] & FastPairConstants.GO_INTENT_NOT_SET);
        if (1229145158 != i10) {
            ICDFLog.e("ICDF.PacketAssemble", "invalid msg header flag: " + i10);
            return null;
        }
        int i11 = ((bArr[4] & 255) << 24) + ((bArr[5] & 255) << 16) + ((bArr[6] & 255) << 8) + (bArr[7] & 255);
        if (i11 > 0 && i11 <= 4194336) {
            int i12 = i11 + 8;
            int i13 = i12 / 64888;
            if (i12 % 64888 != 0) {
                i13++;
            }
            if (i13 > 1) {
                this.f28734c = i12;
                this.f28733b = i13 - 1;
                this.f28735d = bArr.length;
                byte[] bArr2 = new byte[i12];
                this.f28732a = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                return null;
            }
            return bArr;
        }
        ICDFLog.e("ICDF.PacketAssemble", "invalid msg body length: " + i11);
        return null;
    }

    public byte[] a(byte[] bArr) {
        int i10;
        int i11 = this.f28733b;
        if (i11 == 0) {
            return b(bArr);
        }
        if (bArr.length > 8 && 1229145158 == (i10 = ((bArr[0] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((bArr[1] & FastPairConstants.GO_INTENT_NOT_SET) << 16) + ((bArr[2] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[3] & FastPairConstants.GO_INTENT_NOT_SET))) {
            ICDFLog.e("ICDF.PacketAssemble", "invalid msg header flag: " + i10);
            a();
            return b(bArr);
        }
        if (1 < i11 && bArr.length != 64888) {
            ICDFLog.e("ICDF.PacketAssemble", "invalid middle message fragment length " + bArr.length + ", drop cached message");
            a();
            return null;
        }
        if (1 == i11 && bArr.length != this.f28734c - this.f28735d) {
            ICDFLog.i("ICDF.PacketAssemble", "mMsgTotalLen " + this.f28734c + ", mMsgRecvLen " + this.f28735d + ", recvBlockLen " + bArr.length);
            StringBuilder sb = new StringBuilder();
            sb.append("invalid tail message fragment length ");
            sb.append(bArr.length);
            sb.append(", drop cached message");
            ICDFLog.e("ICDF.PacketAssemble", sb.toString());
            a();
            return null;
        }
        System.arraycopy(bArr, 0, this.f28732a, this.f28735d, bArr.length);
        int i12 = this.f28733b - 1;
        this.f28733b = i12;
        this.f28735d += bArr.length;
        if (i12 != 0) {
            return null;
        }
        byte[] bArr2 = this.f28732a;
        a();
        return bArr2;
    }

    private void a() {
        this.f28732a = null;
        this.f28733b = 0;
        this.f28734c = 0;
        this.f28735d = 0;
    }
}
