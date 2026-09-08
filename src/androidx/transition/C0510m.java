package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PropertyValuesHolderUtils.java */
/* renamed from: androidx.transition.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0510m {

    /* compiled from: PropertyValuesHolderUtils.java */
    /* renamed from: androidx.transition.m$a */
    /* loaded from: classes.dex */
    public static class a {
        public static <V> PropertyValuesHolder a(Property<?, V> property, Path path) {
            return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
        }
    }

    public static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        return a.a(property, path);
    }
}
