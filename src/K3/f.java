package k3;

import android.content.Context;
import android.graphics.Bitmap;
import g3.C1043e;
import java.security.MessageDigest;
import s3.C1540k;

/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class f implements X2.g<c> {

    /* renamed from: b, reason: collision with root package name */
    public final X2.g<Bitmap> f34112b;

    public f(X2.g<Bitmap> gVar) {
        this.f34112b = (X2.g) C1540k.d(gVar);
    }

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        this.f34112b.a(messageDigest);
    }

    @Override // X2.g
    public Z2.j<c> b(Context context, Z2.j<c> jVar, int i10, int i11) {
        c cVar = jVar.get();
        Z2.j<Bitmap> c1043e = new C1043e(cVar.e(), com.bumptech.glide.b.c(context).f());
        Z2.j<Bitmap> b10 = this.f34112b.b(context, c1043e, i10, i11);
        if (!c1043e.equals(b10)) {
            c1043e.b();
        }
        cVar.m(this.f34112b, b10.get());
        return jVar;
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f34112b.equals(((f) obj).f34112b);
        }
        return false;
    }

    @Override // X2.b
    public int hashCode() {
        return this.f34112b.hashCode();
    }
}
