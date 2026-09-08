package O;

import java.nio.ByteBuffer;

/* compiled from: Table.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f2426a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f2427b;

    /* renamed from: c, reason: collision with root package name */
    public int f2428c;

    /* renamed from: d, reason: collision with root package name */
    public int f2429d;

    /* renamed from: e, reason: collision with root package name */
    public d f2430e = d.a();

    public int a(int i10) {
        return i10 + this.f2427b.getInt(i10);
    }

    public int b(int i10) {
        if (i10 < this.f2429d) {
            return this.f2427b.getShort(this.f2428c + i10);
        }
        return 0;
    }

    public void c(int i10, ByteBuffer byteBuffer) {
        this.f2427b = byteBuffer;
        if (byteBuffer != null) {
            this.f2426a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f2428c = i11;
            this.f2429d = this.f2427b.getShort(i11);
            return;
        }
        this.f2426a = 0;
        this.f2428c = 0;
        this.f2429d = 0;
    }

    public int d(int i10) {
        int i11 = i10 + this.f2426a;
        return i11 + this.f2427b.getInt(i11) + 4;
    }

    public int e(int i10) {
        int i11 = i10 + this.f2426a;
        return this.f2427b.getInt(i11 + this.f2427b.getInt(i11));
    }
}
