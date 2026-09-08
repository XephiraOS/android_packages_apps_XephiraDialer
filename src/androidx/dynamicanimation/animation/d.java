package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* compiled from: FloatPropertyCompat.java */
/* loaded from: classes.dex */
public abstract class d<T> {
    final String mPropertyName;

    /* compiled from: FloatPropertyCompat.java */
    /* loaded from: classes.dex */
    public static class a extends d<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatProperty f9726a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, FloatProperty floatProperty) {
            super(str);
            this.f9726a = floatProperty;
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(T t10) {
            return ((Float) this.f9726a.get(t10)).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(T t10, float f10) {
            this.f9726a.setValue(t10, f10);
        }
    }

    public d(String str) {
        this.mPropertyName = str;
    }

    public static <T> d<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new a(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(T t10);

    public abstract void setValue(T t10, float f10);
}
