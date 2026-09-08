package g3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation.java */
/* loaded from: classes.dex */
public class l implements X2.g<Drawable> {

    /* renamed from: b, reason: collision with root package name */
    public final X2.g<Bitmap> f31854b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f31855c;

    public l(X2.g<Bitmap> gVar, boolean z10) {
        this.f31854b = gVar;
        this.f31855c = z10;
    }

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        this.f31854b.a(messageDigest);
    }

    @Override // X2.g
    public Z2.j<Drawable> b(Context context, Z2.j<Drawable> jVar, int i10, int i11) {
        a3.d f10 = com.bumptech.glide.b.c(context).f();
        Drawable drawable = jVar.get();
        Z2.j<Bitmap> a10 = k.a(f10, drawable, i10, i11);
        if (a10 == null) {
            if (!this.f31855c) {
                return jVar;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        Z2.j<Bitmap> b10 = this.f31854b.b(context, a10, i10, i11);
        if (b10.equals(a10)) {
            b10.b();
            return jVar;
        }
        return d(context, b10);
    }

    public final Z2.j<Drawable> d(Context context, Z2.j<Bitmap> jVar) {
        return q.f(context.getResources(), jVar);
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return this.f31854b.equals(((l) obj).f31854b);
        }
        return false;
    }

    @Override // X2.b
    public int hashCode() {
        return this.f31854b.hashCode();
    }

    public X2.g<BitmapDrawable> c() {
        return this;
    }
}
