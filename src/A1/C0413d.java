package a1;

import com.android.contacts.framework.bttransmission.pbapclient.ClientControler;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import d1.C0947b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.opencv.imgproc.Imgproc;

/* compiled from: ClientOperation.java */
/* renamed from: a1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0413d implements l, InterfaceC0411b {

    /* renamed from: p, reason: collision with root package name */
    public static final boolean f6277p = C0947b.f29928a;

    /* renamed from: a, reason: collision with root package name */
    public C0414e f6278a;

    /* renamed from: f, reason: collision with root package name */
    public String f6283f;

    /* renamed from: g, reason: collision with root package name */
    public int f6284g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6286i;

    /* renamed from: o, reason: collision with root package name */
    public C0416g f6292o;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6289l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6290m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6291n = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6279b = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6285h = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6281d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6282e = false;

    /* renamed from: c, reason: collision with root package name */
    public m f6280c = null;

    /* renamed from: k, reason: collision with root package name */
    public C0415f f6288k = new C0415f();

    /* renamed from: j, reason: collision with root package name */
    public C0415f f6287j = new C0415f();

    public C0413d(int i10, C0414e c0414e, C0415f c0415f, boolean z10) {
        this.f6278a = c0414e;
        this.f6284g = i10;
        this.f6286i = z10;
        this.f6292o = c0414e.f6302j;
        int[] b10 = c0415f.b();
        if (b10 != null) {
            for (int i11 = 0; i11 < b10.length; i11++) {
                if (f6277p) {
                    H7.b.h("Obex ClientOperation", "SetHeader " + b10[i11]);
                }
                C0415f c0415f2 = this.f6287j;
                int i12 = b10[i11];
                c0415f2.c(i12, c0415f.a(i12));
            }
        }
        byte[] bArr = c0415f.f6327x;
        if (bArr != null) {
            C0415f c0415f3 = this.f6287j;
            byte[] bArr2 = new byte[bArr.length];
            c0415f3.f6327x = bArr2;
            byte[] bArr3 = c0415f.f6327x;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        }
        byte[] bArr4 = c0415f.f6328y;
        if (bArr4 != null) {
            C0415f c0415f4 = this.f6287j;
            byte[] bArr5 = new byte[bArr4.length];
            c0415f4.f6328y = bArr5;
            byte[] bArr6 = c0415f.f6328y;
            System.arraycopy(bArr6, 0, bArr5, 0, bArr6.length);
        }
        if (c0415f.f6329z != null) {
            byte[] bArr7 = new byte[4];
            this.f6287j.f6329z = bArr7;
            System.arraycopy(c0415f.f6329z, 0, bArr7, 0, 4);
        }
    }

    @Override // a1.InterfaceC0411b
    public void a(boolean z10) {
        if (!this.f6286i) {
            if (!z10 && !this.f6285h) {
                C0415f c0415f = this.f6288k;
                if (c0415f.f6303A == -1) {
                    c0415f.f6303A = 144;
                }
                while (this.f6288k.f6303A == 144 && h(2)) {
                }
                if (f6277p) {
                    H7.b.h("Obex ClientOperation", "streamClosed: Client SRM Disabled");
                }
                this.f6292o.j();
                this.f6290m = false;
                while (this.f6288k.f6303A == 144) {
                    h(130);
                }
                this.f6285h = true;
                return;
            }
            if (z10 && this.f6285h) {
                this.f6285h = true;
                return;
            }
            return;
        }
        if (z10 && !this.f6285h) {
            C0415f c0415f2 = this.f6288k;
            if (c0415f2.f6303A == -1) {
                c0415f2.f6303A = 144;
            }
            if (f6277p) {
                H7.b.h("Obex ClientOperation", "(inStream) && (!mOperationDone) StreamClosed");
            }
            while (this.f6288k.f6303A == 144) {
                if (f6277p) {
                    H7.b.h("Obex ClientOperation", "StreamClosed sendRequest(0x83)");
                }
                if (!h(Imgproc.COLOR_RGB2YUV_YV12)) {
                    break;
                }
            }
            if (f6277p) {
                H7.b.h("Obex ClientOperation", "streamClosed: Client SRM Disabled");
            }
            this.f6292o.j();
            this.f6291n = false;
            while (this.f6288k.f6303A == 144) {
                if (f6277p) {
                    H7.b.h("Obex ClientOperation", "StreamClosed  mParent.sendRequest(0x83)");
                }
                this.f6278a.g(Imgproc.COLOR_RGB2YUV_YV12, null, this.f6288k, this.f6280c, false, false);
            }
            this.f6285h = true;
            return;
        }
        if (!z10 && !this.f6285h) {
            if (this.f6280c == null) {
                this.f6280c = new m(this);
            }
            this.f6288k.f6303A = 144;
            while (this.f6288k.f6303A == 144 && h(3)) {
            }
            h(Imgproc.COLOR_RGB2YUV_YV12);
            if (this.f6288k.f6303A != 144) {
                this.f6285h = true;
            }
        }
    }

    @Override // a1.InterfaceC0411b
    public void b() {
        this.f6278a.e();
        if (this.f6283f == null) {
            if (this.f6279b) {
                return;
            } else {
                throw new IOException("Operation has already ended");
            }
        }
        throw new IOException(this.f6283f);
    }

    @Override // a1.InterfaceC0411b
    public synchronized boolean c(boolean z10, boolean z11) {
        if (ClientControler.y().I()) {
            ClientControler.y().q();
            H7.b.b("Obex ClientOperation", "continueOperation");
            return false;
        }
        boolean z12 = f6277p;
        if (z12) {
            H7.b.h("Obex ClientOperation", "continueOperation mSingleResponseActiveClient " + this.f6290m);
        }
        if (this.f6286i) {
            if (z11 && !this.f6285h) {
                if (z12) {
                    H7.b.h("Obex ClientOperation", "continueOperation inStream&&!mOperationDone mReplyHeader.responseCode = " + this.f6288k.f6303A);
                }
                Byte b10 = (Byte) this.f6288k.a(151);
                if (b10 == C0416g.f6336k || b10 == C0416g.f6335j) {
                    this.f6292o.m(true);
                    if (z12) {
                        H7.b.h("Obex ClientOperation", "Remote SRM status: Enabled by Server response");
                    }
                }
                if (this.f6292o.i()) {
                    if (z12) {
                        H7.b.h("Obex ClientOperation", "continueOperation: Remote SRM Enabled");
                    }
                    this.f6291n = this.f6292o.g();
                }
                this.f6278a.g(Imgproc.COLOR_RGB2YUV_YV12, null, this.f6288k, this.f6280c, false, this.f6291n);
                if (this.f6288k.f6303A != 144) {
                    this.f6285h = true;
                }
                return true;
            }
            if (!z11 && !this.f6285h) {
                if (z12) {
                    H7.b.h("Obex ClientOperation", "continueOperation (!inStream) && (!mOperationDone) ");
                }
                if (this.f6280c == null) {
                    this.f6280c = new m(this);
                }
                h(3);
                return true;
            }
            if (this.f6285h) {
                if (z12) {
                    H7.b.h("Obex ClientOperation", "continueOperation mOperationDone ");
                }
                return false;
            }
        } else {
            if (!z11 && !this.f6285h) {
                C0415f c0415f = this.f6288k;
                if (c0415f.f6303A == -1) {
                    c0415f.f6303A = 144;
                }
                h(2);
                if (z12) {
                    H7.b.h("Obex ClientOperation", "continueOperation: Client setting SRM, sendEmpty clause");
                }
                Byte b11 = (Byte) this.f6288k.a(151);
                if (b11 == C0416g.f6336k || b11 == C0416g.f6335j) {
                    this.f6292o.m(true);
                    if (z12) {
                        H7.b.h("Obex ClientOperation", "Remote SRM status: Enabled by Server response");
                    }
                }
                if (this.f6292o.i()) {
                    if (z12) {
                        H7.b.h("Obex ClientOperation", "continueOperation: Remote SRM Enabled");
                    }
                    this.f6290m = this.f6292o.g();
                }
                if (z12) {
                    H7.b.h("Obex ClientOperation", "continueOperation: Client SRM status: " + this.f6290m);
                }
                if (this.f6290m) {
                    if (z12) {
                        H7.b.h("Obex ClientOperation", "continueOperation: Client SRM enabled");
                    }
                    Byte b12 = (Byte) this.f6288k.a(VibrateUtils.TYPE_STEPABLE_REGULATE);
                    if (z12) {
                        H7.b.h("Obex ClientOperation", "SRMP header (CONTINUE): " + b12);
                    }
                    if (b12 == C0416g.f6337l) {
                        if (z12) {
                            H7.b.h("Obex ClientOperation", "continueOperation: Client SRMP WAIT requested by Server");
                        }
                        this.f6292o.l(true);
                        this.f6290m = false;
                    } else {
                        if (z12) {
                            H7.b.h("Obex ClientOperation", "continueOperation: Client SRMP NONE");
                        }
                        this.f6292o.l(false);
                    }
                    this.f6288k.c(VibrateUtils.TYPE_STEPABLE_REGULATE, C0416g.f6338m);
                } else if (z12) {
                    H7.b.h("Obex ClientOperation", "continueOperation: Client SRM disabled");
                }
                return true;
            }
            if (z11 && !this.f6285h) {
                return false;
            }
            if (this.f6285h) {
                return false;
            }
        }
        return false;
    }

    public synchronized void d() {
        try {
            b();
            boolean z10 = this.f6285h;
            if (z10 && this.f6288k.f6303A != 144) {
                throw new IOException("Operation has already ended");
            }
            this.f6283f = "Operation aborted";
            if (!z10) {
                C0415f c0415f = this.f6288k;
                if (c0415f.f6303A == 144) {
                    this.f6285h = true;
                    this.f6278a.g(255, null, c0415f, null, false, false);
                    if (this.f6288k.f6303A == 160) {
                        this.f6283f = null;
                    } else {
                        throw new IOException("Invalid response code from server");
                    }
                }
            }
            e();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void e() {
        this.f6279b = false;
        this.f6281d = false;
        this.f6282e = false;
        this.f6278a.i();
    }

    public C0415f f() {
        b();
        return this.f6288k;
    }

    public InputStream g() {
        b();
        if (!this.f6281d) {
            if (this.f6286i) {
                j();
            } else if (this.f6280c == null) {
                System.out.println("new PrivateInputStream");
                this.f6280c = new m(this);
            }
            this.f6281d = true;
            return this.f6280c;
        }
        throw new IOException("no more input streams available");
    }

    public final boolean h(int i10) {
        boolean z10 = f6277p;
        if (z10) {
            H7.b.h("Obex ClientOperation", "sendRequest mSingleResponseActiveClient " + this.f6290m);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] e10 = C0416g.e(this.f6287j, true);
        if (e10.length + 3 > this.f6284g) {
            int i11 = 0;
            do {
                int i12 = i11;
                if (i11 == e10.length) {
                    break;
                }
                i11 = C0416g.f(e10, i12, this.f6284g - 3);
                if (i11 == -1) {
                    this.f6285h = true;
                    d();
                    this.f6283f = "Header larger then can be sent in a packet";
                    this.f6279b = false;
                    m mVar = this.f6280c;
                    if (mVar != null) {
                        mVar.close();
                    }
                    throw new IOException("OBEX Packet exceeds max packet size");
                }
                int i13 = i11 - i12;
                byte[] bArr = new byte[i13];
                System.arraycopy(e10, i12, bArr, 0, i13);
                if (!this.f6278a.g(i10, bArr, this.f6288k, this.f6280c, this.f6290m, this.f6291n)) {
                    return false;
                }
            } while (this.f6288k.f6303A == 144);
            return false;
        }
        byteArrayOutputStream.write(e10);
        if (this.f6282e && !this.f6289l) {
            if ((i10 & 128) == 0) {
                byteArrayOutputStream.write(72);
            } else {
                byteArrayOutputStream.write(73);
                this.f6289l = true;
            }
            byteArrayOutputStream.write((byte) 0);
            byteArrayOutputStream.write((byte) 3);
        }
        if (z10) {
            H7.b.h("Obex ClientOperation", "sendRequest with out.size " + byteArrayOutputStream.size() + "mSingleResponseActiveClient " + this.f6290m);
        }
        if (byteArrayOutputStream.size() == 0) {
            this.f6278a.g(i10, null, this.f6288k, this.f6280c, this.f6290m, this.f6291n);
            return false;
        }
        if (byteArrayOutputStream.size() > 0) {
            this.f6278a.g(i10, byteArrayOutputStream.toByteArray(), this.f6288k, this.f6280c, this.f6290m, this.f6291n);
        }
        return false;
    }

    public final synchronized void i() {
        try {
            if (f6277p) {
                H7.b.h("Obex ClientOperation", "startProcessing mSingleResponseActiveClient " + this.f6290m);
            }
            if (this.f6280c == null) {
                this.f6280c = new m(this);
            }
            if (this.f6286i) {
                if (!this.f6285h) {
                    this.f6288k.f6303A = 144;
                    while (this.f6288k.f6303A == 144) {
                        boolean z10 = f6277p;
                        if (z10) {
                            H7.b.h("Obex ClientOperation", "startProcessing SendRequest(0x03)");
                        }
                        boolean h10 = h(3);
                        if (z10) {
                            H7.b.h("Obex ClientOperation", "more " + h10);
                        }
                        if (!h10) {
                            break;
                        }
                    }
                    if (this.f6288k.f6303A == 144) {
                        if (f6277p) {
                            H7.b.h("Obex ClientOperation", "startProcessing mParent.sendRequest(0x83)");
                        }
                        this.f6278a.g(Imgproc.COLOR_RGB2YUV_YV12, null, this.f6288k, this.f6280c, false, false);
                    }
                    if (this.f6288k.f6303A != 144) {
                        this.f6285h = true;
                    }
                }
            } else {
                if (!this.f6285h) {
                    this.f6288k.f6303A = 144;
                    while (this.f6288k.f6303A == 144 && h(2)) {
                    }
                }
                C0415f c0415f = this.f6288k;
                if (c0415f.f6303A == 144) {
                    this.f6278a.g(130, null, c0415f, this.f6280c, false, false);
                }
                if (this.f6288k.f6303A != 144) {
                    this.f6285h = true;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void j() {
        b();
        if (this.f6280c == null) {
            i();
        }
    }
}
