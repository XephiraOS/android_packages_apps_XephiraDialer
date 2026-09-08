package l3;

import Z2.j;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import g3.q;
import s3.C1540k;

/* compiled from: BitmapDrawableTranscoder.java */
/* renamed from: l3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1291b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f34679a;

    public C1291b(Resources resources) {
        this.f34679a = (Resources) C1540k.d(resources);
    }

    @Override // l3.e
    public j<BitmapDrawable> a(j<Bitmap> jVar, X2.d dVar) {
        return q.f(this.f34679a, jVar);
    }
}
