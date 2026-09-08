package a1;

import com.android.contacts.framework.bttransmission.pbapclient.ClientControler;
import com.heytap.accessory.bean.BtDirectAdvertiseSetting;
import d1.C0947b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ClientSession.java */
/* renamed from: a1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0414e extends j {

    /* renamed from: k, reason: collision with root package name */
    public static final boolean f6293k = C0947b.f29928a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6295c;

    /* renamed from: g, reason: collision with root package name */
    public final InputStream f6299g;

    /* renamed from: h, reason: collision with root package name */
    public final OutputStream f6300h;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f6296d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f6297e = 256;

    /* renamed from: i, reason: collision with root package name */
    public long f6301i = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6294b = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6298f = false;

    /* renamed from: j, reason: collision with root package name */
    public C0416g f6302j = new C0416g();

    public C0414e(k kVar) {
        this.f6299g = kVar.a();
        this.f6300h = kVar.b();
    }

    public C0415f c(C0415f c0415f) {
        byte[] bArr;
        int i10;
        e();
        if (!this.f6295c) {
            h();
            if (c0415f != null) {
                byte[] bArr2 = c0415f.f6326w;
                if (bArr2 != null) {
                    byte[] bArr3 = new byte[16];
                    this.f6345a = bArr3;
                    System.arraycopy(bArr2, 0, bArr3, 0, 16);
                }
                bArr = C0416g.e(c0415f, false);
                i10 = bArr.length + 4;
            } else {
                bArr = null;
                i10 = 4;
            }
            byte[] bArr4 = new byte[i10];
            bArr4[0] = BtDirectAdvertiseSetting.FLAG_DEVICE_BATTERY;
            bArr4[1] = 0;
            int i11 = this.f6297e;
            bArr4[2] = (byte) (i11 >> 8);
            bArr4[3] = (byte) (i11 & 255);
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr4, 4, bArr.length);
            }
            if (i10 + 3 <= this.f6297e) {
                C0415f c0415f2 = new C0415f();
                g(128, bArr4, c0415f2, null, false, false);
                if (c0415f2.f6303A == 160) {
                    byte[] bArr5 = c0415f2.f6329z;
                    if (bArr5 != null) {
                        System.arraycopy(bArr5, 0, this.f6296d, 0, 4);
                    }
                    this.f6295c = true;
                    if (((Byte) c0415f2.a(151)) == C0416g.f6336k) {
                        this.f6302j.m(true);
                        if (f6293k) {
                            H7.b.h("Obex ClientSession", "SRM status: Enabled by Server response");
                        }
                    } else {
                        this.f6302j.m(false);
                        if (f6293k) {
                            H7.b.h("Obex ClientSession", "SRM status: Disabled by Server response");
                        }
                    }
                }
                i();
                return c0415f2;
            }
            throw new IOException("Packet size exceeds max packet size");
        }
        throw new IOException("Already connected to server");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a1.C0415f d(a1.C0415f r10) {
        /*
            r9 = this;
            boolean r0 = r9.f6295c
            if (r0 == 0) goto L68
            r9.h()
            r9.e()
            r0 = 4
            r1 = 0
            if (r10 == 0) goto L3b
            byte[] r2 = r10.f6326w
            if (r2 == 0) goto L1b
            r3 = 16
            byte[] r4 = new byte[r3]
            r9.f6345a = r4
            java.lang.System.arraycopy(r2, r1, r4, r1, r3)
        L1b:
            byte[] r2 = r9.f6296d
            if (r2 == 0) goto L26
            byte[] r3 = new byte[r0]
            r10.f6329z = r3
            java.lang.System.arraycopy(r2, r1, r3, r1, r0)
        L26:
            byte[] r10 = a1.C0416g.e(r10, r1)
            int r0 = r10.length
            int r0 = r0 + 3
            int r2 = r9.f6297e
            if (r0 > r2) goto L33
        L31:
            r4 = r10
            goto L4e
        L33:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Packet size exceeds max packet size"
            r9.<init>(r10)
            throw r9
        L3b:
            byte[] r10 = r9.f6296d
            if (r10 == 0) goto L4c
            r2 = 5
            byte[] r2 = new byte[r2]
            r3 = -53
            r2[r1] = r3
            r3 = 1
            java.lang.System.arraycopy(r10, r1, r2, r3, r0)
            r4 = r2
            goto L4e
        L4c:
            r10 = 0
            goto L31
        L4e:
            a1.f r10 = new a1.f
            r10.<init>()
            r7 = 0
            r8 = 0
            r3 = 129(0x81, float:1.81E-43)
            r6 = 0
            r2 = r9
            r5 = r10
            r2.g(r3, r4, r5, r6, r7, r8)
            monitor-enter(r9)
            r9.f6295c = r1     // Catch: java.lang.Throwable -> L65
            r9.i()     // Catch: java.lang.Throwable -> L65
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L65
            return r10
        L65:
            r10 = move-exception
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L65
            throw r10
        L68:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Not connected to the server"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.C0414e.d(a1.f):a1.f");
    }

    public synchronized void e() {
        if (!this.f6294b) {
            throw new IOException("Connection closed");
        }
    }

    public l f(C0415f c0415f) {
        if (this.f6295c) {
            System.out.println("client session get");
            h();
            e();
            if (c0415f == null) {
                c0415f = new C0415f();
            } else {
                byte[] bArr = c0415f.f6326w;
                if (bArr != null) {
                    byte[] bArr2 = new byte[16];
                    this.f6345a = bArr2;
                    System.arraycopy(bArr, 0, bArr2, 0, 16);
                }
            }
            byte[] bArr3 = this.f6296d;
            if (bArr3 != null) {
                byte[] bArr4 = new byte[4];
                c0415f.f6329z = bArr4;
                System.arraycopy(bArr3, 0, bArr4, 0, 4);
            }
            return new C0413d(this.f6297e, this, c0415f, true);
        }
        throw new IOException("Not connected to the server");
    }

    public boolean g(int i10, byte[] bArr, C0415f c0415f, m mVar, boolean z10, boolean z11) {
        byte[] bArr2;
        boolean z12 = f6293k;
        if (z12) {
            H7.b.h("Obex ClientSession", "sendRequest ignore: " + z10 + ", SRMP WAIT: " + this.f6302j.h() + " supressSend : " + z11);
        }
        if (bArr != null && bArr.length + 3 > this.f6297e) {
            throw new IOException("header too large ");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write((byte) i10);
        if (z12) {
            H7.b.h("Obex ClientSession", "sendRequest opCode = " + i10);
        }
        if (bArr == null) {
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(3);
        } else {
            byteArrayOutputStream.write((byte) ((bArr.length + 3) >> 8));
            byteArrayOutputStream.write((byte) (bArr.length + 3));
            byteArrayOutputStream.write(bArr);
            if (z12) {
                H7.b.h("Obex ClientSession", "sendRequest head.length = " + bArr.length);
            }
        }
        if (!z11) {
            this.f6300h.write(byteArrayOutputStream.toByteArray());
            this.f6300h.flush();
        }
        if (!z10 || this.f6302j.h()) {
            c0415f.f6303A = this.f6299g.read();
            if (z12) {
                H7.b.h("Obex ClientSession", "sendRequest responseCode " + c0415f.f6303A);
            }
            if (c0415f.f6303A == 204) {
                ClientControler.f16169o = true;
                i();
            }
            int read = (this.f6299g.read() << 8) | this.f6299g.read();
            if (z12) {
                H7.b.h("Obex ClientSession", "sendRequest response length " + read);
            }
            if (read <= this.f6297e) {
                if (read > 3) {
                    if (i10 == 128) {
                        this.f6299g.read();
                        this.f6299g.read();
                        int read2 = (this.f6299g.read() << 8) + this.f6299g.read();
                        this.f6297e = read2;
                        if (read2 > 64512) {
                            this.f6297e = 64512;
                        }
                        if (read <= 7) {
                            return true;
                        }
                        int i11 = read - 7;
                        bArr2 = new byte[i11];
                        int read3 = this.f6299g.read(bArr2);
                        while (read3 != i11) {
                            read3 += this.f6299g.read(bArr2, read3, i11 - read3);
                        }
                    } else {
                        int i12 = read - 3;
                        bArr2 = new byte[i12];
                        int read4 = this.f6299g.read(bArr2);
                        while (read4 != i12) {
                            read4 += this.f6299g.read(bArr2, read4, i12 - read4);
                        }
                    }
                    byte[] n10 = C0416g.n(c0415f, bArr2);
                    if (mVar != null && n10 != null) {
                        mVar.c(n10, 1);
                        this.f6301i += n10.length - 1;
                        if (n10[0] == 73 && c0415f.a(195) == null) {
                            c0415f.c(195, Long.valueOf(this.f6301i));
                            if (f6293k) {
                                H7.b.h("Obex ClientSession", " header.mLength : " + c0415f.a(195));
                            }
                            this.f6301i = 0L;
                        }
                    }
                    byte[] bArr3 = c0415f.f6329z;
                    if (bArr3 != null) {
                        byte[] bArr4 = new byte[4];
                        this.f6296d = bArr4;
                        System.arraycopy(bArr3, 0, bArr4, 0, 4);
                    }
                    byte[] bArr5 = c0415f.f6328y;
                    if (bArr5 != null && !b(bArr5)) {
                        i();
                        throw new IOException("Authentication Failed");
                    }
                    if (c0415f.f6303A == 193 && c0415f.f6327x != null && a(c0415f)) {
                        byteArrayOutputStream.write(78);
                        byteArrayOutputStream.write((byte) ((c0415f.f6328y.length + 3) >> 8));
                        byteArrayOutputStream.write((byte) (c0415f.f6328y.length + 3));
                        byteArrayOutputStream.write(c0415f.f6328y);
                        c0415f.f6327x = null;
                        c0415f.f6328y = null;
                        int size = byteArrayOutputStream.size() - 3;
                        byte[] bArr6 = new byte[size];
                        System.arraycopy(byteArrayOutputStream.toByteArray(), 3, bArr6, 0, size);
                        return g(i10, bArr6, c0415f, mVar, false, false);
                    }
                }
            } else {
                throw new IOException("Packet received exceeds packet size limit");
            }
        }
        return true;
    }

    public final synchronized void h() {
        if (!this.f6298f) {
            this.f6298f = true;
        } else {
            throw new IOException("OBEX request is already being performed");
        }
    }

    public synchronized void i() {
        this.f6298f = false;
    }
}
