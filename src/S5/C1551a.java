package s5;

import com.heytap.accessory.utils.buffer.BufferException;
import java.util.Arrays;
import r5.j;

/* compiled from: Buffer.java */
/* renamed from: s5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1551a {

    /* renamed from: b, reason: collision with root package name */
    public byte[] f36811b;

    /* renamed from: c, reason: collision with root package name */
    public int f36812c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f36810a = false;

    /* renamed from: e, reason: collision with root package name */
    public int f36814e = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f36813d = 0;

    public C1551a(byte[] bArr, int i10) {
        this.f36811b = bArr;
        this.f36812c = i10;
    }

    public synchronized void a(byte[] bArr, int i10, int i11) {
        if (!this.f36810a) {
            int i12 = this.f36813d + this.f36814e;
            if (i12 + i11 <= this.f36812c) {
                j.a(bArr, i10, this.f36811b, i12, i11);
                this.f36814e += i11;
            } else {
                throw new BufferException(-2, "Cannot extract from byte[]. Buffer length exceeded! [buff offset=" + this.f36813d + "; payload len=" + this.f36814e + "; length to write = " + i11 + "; buff len = " + this.f36812c + "]");
            }
        } else {
            throw new IllegalStateException("Failed to extract from a recycled buffer!");
        }
    }

    public synchronized byte[] b() {
        if (!this.f36810a) {
        } else {
            throw new IllegalStateException("Cannot refer to a recycled buffer!");
        }
        return this.f36811b;
    }

    public synchronized int c() {
        if (!this.f36810a) {
        } else {
            throw new IllegalStateException("Cannot refer to a recycled buffer!");
        }
        return this.f36813d;
    }

    public synchronized int d() {
        if (!this.f36810a) {
        } else {
            throw new IllegalStateException("Cannot refer to a recycled buffer!");
        }
        return this.f36814e;
    }

    public synchronized boolean e() {
        if (this.f36810a) {
            return false;
        }
        boolean f10 = b.f(this.f36811b);
        this.f36810a = f10;
        return f10;
    }

    public synchronized void f(int i10) {
        if (!this.f36810a) {
            this.f36813d = i10;
        } else {
            throw new IllegalStateException("Cannot refer to a recycled buffer!");
        }
    }

    public String toString() {
        return "Buffer{data=" + Arrays.toString(this.f36811b) + ", length=" + this.f36812c + ", offset=" + this.f36813d + ", payloadLength=" + this.f36814e + ", isRecycled=" + this.f36810a + '}';
    }
}
