package k3;

import W2.a;
import android.graphics.Bitmap;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public final class b implements a.InterfaceC0079a {

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f34098a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.b f34099b;

    public b(a3.d dVar, a3.b bVar) {
        this.f34098a = dVar;
        this.f34099b = bVar;
    }

    @Override // W2.a.InterfaceC0079a
    public Bitmap a(int i10, int i11, Bitmap.Config config) {
        return this.f34098a.e(i10, i11, config);
    }

    @Override // W2.a.InterfaceC0079a
    public int[] b(int i10) {
        a3.b bVar = this.f34099b;
        if (bVar == null) {
            return new int[i10];
        }
        return (int[]) bVar.e(i10, int[].class);
    }

    @Override // W2.a.InterfaceC0079a
    public void c(Bitmap bitmap) {
        this.f34098a.c(bitmap);
    }

    @Override // W2.a.InterfaceC0079a
    public void d(byte[] bArr) {
        a3.b bVar = this.f34099b;
        if (bVar == null) {
            return;
        }
        bVar.d(bArr);
    }

    @Override // W2.a.InterfaceC0079a
    public byte[] e(int i10) {
        a3.b bVar = this.f34099b;
        if (bVar == null) {
            return new byte[i10];
        }
        return (byte[]) bVar.e(i10, byte[].class);
    }

    @Override // W2.a.InterfaceC0079a
    public void f(int[] iArr) {
        a3.b bVar = this.f34099b;
        if (bVar == null) {
            return;
        }
        bVar.d(iArr);
    }
}
