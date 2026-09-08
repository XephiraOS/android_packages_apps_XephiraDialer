package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class H {

    /* renamed from: a, reason: collision with root package name */
    public static final I f11627a = new M();

    /* renamed from: b, reason: collision with root package name */
    public static final Property<View, Float> f11628b = new a(Float.class, "translationAlpha");

    /* renamed from: c, reason: collision with root package name */
    public static final Property<View, Rect> f11629c = new b(Rect.class, "clipBounds");

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    public class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(H.b(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            H.f(view, f10.floatValue());
        }
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    public class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    public static void a(View view) {
        f11627a.a(view);
    }

    public static float b(View view) {
        return f11627a.b(view);
    }

    public static void c(View view) {
        f11627a.c(view);
    }

    public static void d(View view, Matrix matrix) {
        f11627a.d(view, matrix);
    }

    public static void e(View view, int i10, int i11, int i12, int i13) {
        f11627a.e(view, i10, i11, i12, i13);
    }

    public static void f(View view, float f10) {
        f11627a.f(view, f10);
    }

    public static void g(View view, int i10) {
        f11627a.g(view, i10);
    }

    public static void h(View view, Matrix matrix) {
        f11627a.h(view, matrix);
    }

    public static void i(View view, Matrix matrix) {
        f11627a.i(view, matrix);
    }
}
