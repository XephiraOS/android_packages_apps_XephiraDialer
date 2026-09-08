package h3;

import Z2.j;
import s3.C1540k;

/* compiled from: BytesResource.java */
/* renamed from: h3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1078b implements j<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f32054a;

    public C1078b(byte[] bArr) {
        this.f32054a = (byte[]) C1540k.d(bArr);
    }

    @Override // Z2.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f32054a;
    }

    @Override // Z2.j
    public int c() {
        return this.f32054a.length;
    }

    @Override // Z2.j
    public Class<byte[]> d() {
        return byte[].class;
    }

    @Override // Z2.j
    public void b() {
    }
}
