package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: ObjectAnimatorUtils.java */
/* renamed from: androidx.transition.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0509l {

    /* compiled from: ObjectAnimatorUtils.java */
    /* renamed from: androidx.transition.l$a */
    /* loaded from: classes.dex */
    public static class a {
        public static <T, V> ObjectAnimator a(T t10, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t10, property, (TypeConverter) null, path);
        }
    }

    public static <T> ObjectAnimator a(T t10, Property<T, PointF> property, Path path) {
        return a.a(t10, property, path);
    }
}
