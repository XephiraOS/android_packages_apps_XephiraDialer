package f4;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* compiled from: DrawableAlphaProperty.java */
/* renamed from: f4.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1005f extends Property<Drawable, Integer> {

    /* renamed from: b, reason: collision with root package name */
    public static final Property<Drawable, Integer> f31709b = new C1005f();

    /* renamed from: a, reason: collision with root package name */
    public final WeakHashMap<Drawable, Integer> f31710a;

    public C1005f() {
        super(Integer.class, "drawableAlphaCompat");
        this.f31710a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
