package com.android.contacts.framework.bttransmission.obex;

import H7.b;
import a1.C0410a;
import a1.C0412c;
import a1.C0413d;
import a1.C0414e;
import a1.C0415f;
import a1.h;
import a1.k;
import android.bluetooth.BluetoothSocket;
import com.heytap.accessory.bean.BtDirectAdvertiseSetting;
import d1.C0946a;
import d1.C0947b;
import java.io.IOException;

/* loaded from: classes.dex */
public class ObexOperationImpl implements h {

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f16158g = {121, 97, 53, -16, -16, -59, 17, -40, 9, 102, 8, 0, BtDirectAdvertiseSetting.FLAG_DEVICE_STATE, 12, -102, 102};

    /* renamed from: c, reason: collision with root package name */
    public C0413d f16161c;

    /* renamed from: a, reason: collision with root package name */
    public C0414e f16159a = null;

    /* renamed from: b, reason: collision with root package name */
    public k f16160b = null;

    /* renamed from: d, reason: collision with root package name */
    public SocketState f16162d = null;

    /* renamed from: e, reason: collision with root package name */
    public C0947b f16163e = new C0947b();

    /* renamed from: f, reason: collision with root package name */
    public int f16164f = -1;

    /* loaded from: classes.dex */
    public enum SocketState {
        INIT,
        CONNECTED,
        CLOSED
    }

    @Override // a1.h
    public int a() {
        SocketState socketState = SocketState.INIT;
        try {
            C0415f c0415f = new C0415f();
            c0415f.c(70, f16158g);
            this.f16159a.c(c0415f);
            this.f16162d = SocketState.CONNECTED;
            return -1000;
        } catch (IOException e10) {
            C0947b.a(e10.getMessage(), 3);
            return -1;
        } catch (Exception e11) {
            C0947b.a(e11.getMessage(), 3);
            return -1;
        }
    }

    @Override // a1.h
    public int b(Object obj) {
        if (!(obj instanceof BluetoothSocket)) {
            return -1;
        }
        try {
            this.f16160b = new C0412c((BluetoothSocket) obj);
            this.f16159a = new C0414e(this.f16160b);
            this.f16162d = SocketState.INIT;
            return 0;
        } catch (IOException e10) {
            b.c("ObexOperationImpl", "Exception e: " + e10);
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0160, code lost:
    
        if (r3 > 16) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0162, code lost:
    
        if (r3 <= 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0164, code lost:
    
        com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().P(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x016e, code lost:
    
        if (com.android.contacts.framework.bttransmission.pbapclient.ClientControler.f16169o == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01ca, code lost:
    
        if (com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().u() > 0) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01cc, code lost:
    
        com.android.contacts.framework.bttransmission.pbapclient.ClientControler.f16169o = true;
        r14.f16159a.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01d3, code lost:
    
        r2.close();
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01e1, code lost:
    
        if (com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().I() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01e7, code lost:
    
        if (r0.length() <= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01e9, code lost:
    
        d1.C0947b.a(com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().v().getAddress(), 1);
        d1.C0946a.i(com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().v().getAddress(), r0.toString());
        com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().P(r14.f16164f);
        com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().N(1002);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x021c, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x021d, code lost:
    
        d1.C0947b.a(r14.getMessage(), 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0225, code lost:
    
        r2.close();
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0233, code lost:
    
        if (com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().I() != false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0239, code lost:
    
        if (r0.length() <= 0) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x023b, code lost:
    
        d1.C0947b.a(com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().v().getAddress(), 1);
        d1.C0946a.i(com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().v().getAddress(), r0.toString());
        com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().P(r14.f16164f);
        com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().N(1002);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
    
        return -1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
    
        return -1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0270, code lost:
    
        return -1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x026e, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0273, code lost:
    
        d1.C0947b.a(r14.getMessage(), 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x027a, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0170, code lost:
    
        r2.close();
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x017e, code lost:
    
        if (com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().I() != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0184, code lost:
    
        if (r0.length() <= 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0186, code lost:
    
        d1.C0947b.a(com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().v().getAddress(), 1);
        d1.C0946a.i(com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().v().getAddress(), r0.toString());
        com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().P(r14.f16164f);
        com.android.contacts.framework.bttransmission.pbapclient.ClientControler.y().N(1002);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b9, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ba, code lost:
    
        d1.C0947b.a(r14.getMessage(), 3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v10, types: [int] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // a1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int c() {
        /*
            Method dump skipped, instructions count: 843
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.bttransmission.obex.ObexOperationImpl.c():int");
    }

    @Override // a1.h
    public int d() {
        if (this.f16162d != SocketState.CONNECTED) {
            C0947b.a("wrong obex connect state", 3);
            return -4;
        }
        try {
            C0415f d10 = this.f16159a.d(new C0415f());
            this.f16162d = SocketState.CLOSED;
            if (d10 != null && d10.f6303A == 160) {
                return -1000;
            }
            C0947b.a("wrong obex disconnect state :" + d10.f6303A, 3);
            return -4;
        } catch (IOException e10) {
            C0947b.a(e10.getMessage(), 3);
            return -4;
        }
    }

    @Override // a1.h
    public int e() {
        b.e("ObexOperationImpl", "mObexSocketState is " + this.f16162d);
        if (this.f16162d != SocketState.CONNECTED) {
            b.b("ObexOperationImpl", "wrong obex");
            return -3;
        }
        try {
            this.f16161c.d();
            return -1000;
        } catch (Exception e10) {
            b.b("ObexOperationImpl", e10.getMessage());
            return -3;
        }
    }

    @Override // a1.h
    public int f() {
        C0415f c0415f = new C0415f();
        c0415f.c(66, "x-bt/phonebook");
        c0415f.c(1, "telecom/pb.vcf");
        C0410a c0410a = new C0410a();
        c0410a.a((byte) 4, (byte) 2, new byte[]{0, 0});
        byte[] bArr = new byte[8];
        for (int i10 = 0; i10 < 8; i10++) {
            bArr[i10] = -1;
        }
        c0410a.a((byte) 6, (byte) 8, bArr);
        c0415f.c(76, c0410a.b());
        try {
            try {
                C0413d c0413d = (C0413d) this.f16159a.f(c0415f);
                this.f16161c = c0413d;
                c0413d.g();
                C0947b.a("getPhoneBookSize return", 1);
                byte[] bArr2 = (byte[]) this.f16161c.f().a(76);
                C0947b.a("resultByte size:" + bArr2.length, 1);
                this.f16164f = (bArr2[2] << 8) + C0946a.c(bArr2[3]);
                C0947b.a("phoneBookSize is:" + this.f16164f, 1);
                int i11 = this.f16164f - 1;
                try {
                    this.f16161c.e();
                } catch (IOException e10) {
                    C0947b.a("phoneBookSize is:" + e10.getMessage(), 3);
                }
                return i11;
            } catch (IOException e11) {
                b.c("ObexOperationImpl", "Exception e: " + e11);
                try {
                    this.f16161c.e();
                    return -6;
                } catch (IOException e12) {
                    C0947b.a("phoneBookSize is:" + e12.getMessage(), 3);
                    return -6;
                }
            }
        } catch (Throwable th) {
            try {
                this.f16161c.e();
            } catch (IOException e13) {
                C0947b.a("phoneBookSize is:" + e13.getMessage(), 3);
            }
            throw th;
        }
    }
}
