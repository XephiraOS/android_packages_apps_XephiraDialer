package W2;

import android.util.Log;
import com.heytap.accessory.constant.FastPairConstants;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f4164b;

    /* renamed from: c, reason: collision with root package name */
    public c f4165c;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f4163a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    public int f4166d = 0;

    public void a() {
        this.f4164b = null;
        this.f4165c = null;
    }

    public final boolean b() {
        if (this.f4165c.f4151b != 0) {
            return true;
        }
        return false;
    }

    public c c() {
        if (this.f4164b != null) {
            if (b()) {
                return this.f4165c;
            }
            k();
            if (!b()) {
                h();
                c cVar = this.f4165c;
                if (cVar.f4152c < 0) {
                    cVar.f4151b = 1;
                }
            }
            return this.f4165c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public final int d() {
        try {
            return this.f4164b.get() & FastPairConstants.GO_INTENT_NOT_SET;
        } catch (Exception unused) {
            this.f4165c.f4151b = 1;
            return 0;
        }
    }

    public final void e() {
        boolean z10;
        this.f4165c.f4153d.f4139a = n();
        this.f4165c.f4153d.f4140b = n();
        this.f4165c.f4153d.f4141c = n();
        this.f4165c.f4153d.f4142d = n();
        int d10 = d();
        boolean z11 = false;
        if ((d10 & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int pow = (int) Math.pow(2.0d, (d10 & 7) + 1);
        b bVar = this.f4165c.f4153d;
        if ((d10 & 64) != 0) {
            z11 = true;
        }
        bVar.f4143e = z11;
        if (z10) {
            bVar.f4149k = g(pow);
        } else {
            bVar.f4149k = null;
        }
        this.f4165c.f4153d.f4148j = this.f4164b.position();
        r();
        if (b()) {
            return;
        }
        c cVar = this.f4165c;
        cVar.f4152c++;
        cVar.f4154e.add(cVar.f4153d);
    }

    public final void f() {
        int d10 = d();
        this.f4166d = d10;
        if (d10 > 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                try {
                    i11 = this.f4166d;
                    if (i10 < i11) {
                        i11 -= i10;
                        this.f4164b.get(this.f4163a, i10, i11);
                        i10 += i11;
                    } else {
                        return;
                    }
                } catch (Exception e10) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i10 + " count: " + i11 + " blockSize: " + this.f4166d, e10);
                    }
                    this.f4165c.f4151b = 1;
                    return;
                }
            }
        }
    }

    public final int[] g(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f4164b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = bArr[i12] & FastPairConstants.GO_INTENT_NOT_SET;
                int i14 = i12 + 2;
                int i15 = bArr[i12 + 1] & FastPairConstants.GO_INTENT_NOT_SET;
                i12 += 3;
                int i16 = i11 + 1;
                iArr[i11] = (i15 << 8) | (i13 << 16) | (-16777216) | (bArr[i14] & FastPairConstants.GO_INTENT_NOT_SET);
                i11 = i16;
            }
        } catch (BufferUnderflowException e10) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e10);
            }
            this.f4165c.f4151b = 1;
        }
        return iArr;
    }

    public final void h() {
        i(Integer.MAX_VALUE);
    }

    public final void i(int i10) {
        boolean z10 = false;
        while (!z10 && !b() && this.f4165c.f4152c <= i10) {
            int d10 = d();
            if (d10 != 33) {
                if (d10 != 44) {
                    if (d10 != 59) {
                        this.f4165c.f4151b = 1;
                    } else {
                        z10 = true;
                    }
                } else {
                    c cVar = this.f4165c;
                    if (cVar.f4153d == null) {
                        cVar.f4153d = new b();
                    }
                    e();
                }
            } else {
                int d11 = d();
                if (d11 != 1) {
                    if (d11 != 249) {
                        if (d11 != 254) {
                            if (d11 != 255) {
                                q();
                            } else {
                                f();
                                StringBuilder sb = new StringBuilder();
                                for (int i11 = 0; i11 < 11; i11++) {
                                    sb.append((char) this.f4163a[i11]);
                                }
                                if (sb.toString().equals("NETSCAPE2.0")) {
                                    m();
                                } else {
                                    q();
                                }
                            }
                        } else {
                            q();
                        }
                    } else {
                        this.f4165c.f4153d = new b();
                        j();
                    }
                } else {
                    q();
                }
            }
        }
    }

    public final void j() {
        d();
        int d10 = d();
        b bVar = this.f4165c.f4153d;
        int i10 = (d10 & 28) >> 2;
        bVar.f4145g = i10;
        boolean z10 = true;
        if (i10 == 0) {
            bVar.f4145g = 1;
        }
        if ((d10 & 1) == 0) {
            z10 = false;
        }
        bVar.f4144f = z10;
        int n10 = n();
        if (n10 < 2) {
            n10 = 10;
        }
        b bVar2 = this.f4165c.f4153d;
        bVar2.f4147i = n10 * 10;
        bVar2.f4146h = d();
        d();
    }

    public final void k() {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f4165c.f4151b = 1;
            return;
        }
        l();
        if (this.f4165c.f4157h && !b()) {
            c cVar = this.f4165c;
            cVar.f4150a = g(cVar.f4158i);
            c cVar2 = this.f4165c;
            cVar2.f4161l = cVar2.f4150a[cVar2.f4159j];
        }
    }

    public final void l() {
        boolean z10;
        this.f4165c.f4155f = n();
        this.f4165c.f4156g = n();
        int d10 = d();
        c cVar = this.f4165c;
        if ((d10 & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.f4157h = z10;
        cVar.f4158i = (int) Math.pow(2.0d, (d10 & 7) + 1);
        this.f4165c.f4159j = d();
        this.f4165c.f4160k = d();
    }

    public final void m() {
        do {
            f();
            byte[] bArr = this.f4163a;
            if (bArr[0] == 1) {
                this.f4165c.f4162m = ((bArr[2] & FastPairConstants.GO_INTENT_NOT_SET) << 8) | (bArr[1] & FastPairConstants.GO_INTENT_NOT_SET);
            }
            if (this.f4166d <= 0) {
                return;
            }
        } while (!b());
    }

    public final int n() {
        return this.f4164b.getShort();
    }

    public final void o() {
        this.f4164b = null;
        Arrays.fill(this.f4163a, (byte) 0);
        this.f4165c = new c();
        this.f4166d = 0;
    }

    public d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f4164b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f4164b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void q() {
        int d10;
        do {
            d10 = d();
            this.f4164b.position(Math.min(this.f4164b.position() + d10, this.f4164b.limit()));
        } while (d10 > 0);
    }

    public final void r() {
        d();
        q();
    }
}
