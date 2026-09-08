package i3;

import Z2.g;
import Z2.j;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import s3.C1540k;

/* compiled from: DrawableResource.java */
/* renamed from: i3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1094c<T extends Drawable> implements j<T>, g {

    /* renamed from: a, reason: collision with root package name */
    public final T f32155a;

    public AbstractC1094c(T t10) {
        this.f32155a = (T) C1540k.d(t10);
    }

    @Override // Z2.g
    public void a() {
        T t10 = this.f32155a;
        if (t10 instanceof BitmapDrawable) {
            ((BitmapDrawable) t10).getBitmap().prepareToDraw();
        } else if (t10 instanceof k3.c) {
            ((k3.c) t10).e().prepareToDraw();
        }
    }

    @Override // Z2.j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f32155a.getConstantState();
        if (constantState == null) {
            return this.f32155a;
        }
        return (T) constantState.newDrawable();
    }
}
