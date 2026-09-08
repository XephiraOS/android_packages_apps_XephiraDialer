package androidx.dynamicanimation.animation;

import A2.z;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.K;
import androidx.dynamicanimation.animation.a;
import androidx.dynamicanimation.animation.c;
import java.util.ArrayList;

/* compiled from: DynamicAnimation.java */
/* loaded from: classes.dex */
public abstract class c<T extends c<T>> implements a.b {

    /* renamed from: m, reason: collision with root package name */
    public static final s f9696m = new g("translationX");

    /* renamed from: n, reason: collision with root package name */
    public static final s f9697n = new h("translationY");

    /* renamed from: o, reason: collision with root package name */
    public static final s f9698o = new i("translationZ");

    /* renamed from: p, reason: collision with root package name */
    public static final s f9699p = new j("scaleX");

    /* renamed from: q, reason: collision with root package name */
    public static final s f9700q = new k("scaleY");

    /* renamed from: r, reason: collision with root package name */
    public static final s f9701r = new l("rotation");

    /* renamed from: s, reason: collision with root package name */
    public static final s f9702s = new m("rotationX");

    /* renamed from: t, reason: collision with root package name */
    public static final s f9703t = new n("rotationY");

    /* renamed from: u, reason: collision with root package name */
    public static final s f9704u = new o("x");

    /* renamed from: v, reason: collision with root package name */
    public static final s f9705v = new a("y");

    /* renamed from: w, reason: collision with root package name */
    public static final s f9706w = new b(z.f196a);

    /* renamed from: x, reason: collision with root package name */
    public static final s f9707x = new C0118c("alpha");

    /* renamed from: y, reason: collision with root package name */
    public static final s f9708y = new d("scrollX");

    /* renamed from: z, reason: collision with root package name */
    public static final s f9709z = new e("scrollY");

    /* renamed from: a, reason: collision with root package name */
    public float f9710a;

    /* renamed from: b, reason: collision with root package name */
    public float f9711b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9712c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9713d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.d f9714e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9715f;

    /* renamed from: g, reason: collision with root package name */
    public float f9716g;

    /* renamed from: h, reason: collision with root package name */
    public float f9717h;

    /* renamed from: i, reason: collision with root package name */
    public long f9718i;

    /* renamed from: j, reason: collision with root package name */
    public float f9719j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList<q> f9720k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<r> f9721l;

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class a extends s {
        public a(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setY(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class b extends s {
        public b(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return K.I(view);
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            K.H0(view, f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* renamed from: androidx.dynamicanimation.animation.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0118c extends s {
        public C0118c(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class d extends s {
        public d(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class e extends s {
        public e(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public class f extends androidx.dynamicanimation.animation.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.dynamicanimation.animation.e f9722a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, androidx.dynamicanimation.animation.e eVar) {
            super(str);
            this.f9722a = eVar;
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(Object obj) {
            return this.f9722a.a();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(Object obj, float f10) {
            this.f9722a.b(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class g extends s {
        public g(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class h extends s {
        public h(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class i extends s {
        public i(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return K.F(view);
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            K.F0(view, f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class j extends s {
        public j(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class k extends s {
        public k(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class l extends s {
        public l(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setRotation(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class m extends s {
        public m(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class n extends s {
        public n(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class o extends s {
        public o(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setX(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static class p {

        /* renamed from: a, reason: collision with root package name */
        public float f9724a;

        /* renamed from: b, reason: collision with root package name */
        public float f9725b;
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public interface q {
        void onAnimationEnd(c cVar, boolean z10, float f10, float f11);
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public interface r {
        void onAnimationUpdate(c cVar, float f10, float f11);
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static abstract class s extends androidx.dynamicanimation.animation.d<View> {
        public /* synthetic */ s(String str, g gVar) {
            this(str);
        }

        public s(String str) {
            super(str);
        }
    }

    public c(androidx.dynamicanimation.animation.e eVar) {
        this.f9710a = 0.0f;
        this.f9711b = Float.MAX_VALUE;
        this.f9712c = false;
        this.f9715f = false;
        this.f9716g = Float.MAX_VALUE;
        this.f9717h = -Float.MAX_VALUE;
        this.f9718i = 0L;
        this.f9720k = new ArrayList<>();
        this.f9721l = new ArrayList<>();
        this.f9713d = null;
        this.f9714e = new f("FloatValueHolder", eVar);
        this.f9719j = 1.0f;
    }

    public static <T> void h(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public T a(q qVar) {
        if (!this.f9720k.contains(qVar)) {
            this.f9720k.add(qVar);
        }
        return this;
    }

    public T b(r rVar) {
        if (!g()) {
            if (!this.f9721l.contains(rVar)) {
                this.f9721l.add(rVar);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void c() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.f9715f) {
                d(true);
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    public final void d(boolean z10) {
        this.f9715f = false;
        androidx.dynamicanimation.animation.a.d().g(this);
        this.f9718i = 0L;
        this.f9712c = false;
        for (int i10 = 0; i10 < this.f9720k.size(); i10++) {
            if (this.f9720k.get(i10) != null) {
                this.f9720k.get(i10).onAnimationEnd(this, z10, this.f9711b, this.f9710a);
            }
        }
        h(this.f9720k);
    }

    @Override // androidx.dynamicanimation.animation.a.b
    public boolean doAnimationFrame(long j10) {
        long j11 = this.f9718i;
        if (j11 == 0) {
            this.f9718i = j10;
            l(this.f9711b);
            return false;
        }
        this.f9718i = j10;
        boolean r10 = r(j10 - j11);
        float min = Math.min(this.f9711b, this.f9716g);
        this.f9711b = min;
        float max = Math.max(min, this.f9717h);
        this.f9711b = max;
        l(max);
        if (r10) {
            d(false);
        }
        return r10;
    }

    public final float e() {
        return this.f9714e.getValue(this.f9713d);
    }

    public float f() {
        return this.f9719j * 0.75f;
    }

    public boolean g() {
        return this.f9715f;
    }

    public T i(float f10) {
        this.f9716g = f10;
        return this;
    }

    public T j(float f10) {
        this.f9717h = f10;
        return this;
    }

    public T k(float f10) {
        if (f10 > 0.0f) {
            this.f9719j = f10;
            o(f10 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public void l(float f10) {
        this.f9714e.setValue(this.f9713d, f10);
        for (int i10 = 0; i10 < this.f9721l.size(); i10++) {
            if (this.f9721l.get(i10) != null) {
                this.f9721l.get(i10).onAnimationUpdate(this, this.f9711b, this.f9710a);
            }
        }
        h(this.f9721l);
    }

    public T m(float f10) {
        this.f9711b = f10;
        this.f9712c = true;
        return this;
    }

    public T n(float f10) {
        this.f9710a = f10;
        return this;
    }

    public abstract void o(float f10);

    public void p() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.f9715f) {
                q();
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public final void q() {
        if (!this.f9715f) {
            this.f9715f = true;
            if (!this.f9712c) {
                this.f9711b = e();
            }
            float f10 = this.f9711b;
            if (f10 <= this.f9716g && f10 >= this.f9717h) {
                androidx.dynamicanimation.animation.a.d().a(this, 0L);
                return;
            }
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
    }

    public abstract boolean r(long j10);

    public <K> c(K k10, androidx.dynamicanimation.animation.d<K> dVar) {
        this.f9710a = 0.0f;
        this.f9711b = Float.MAX_VALUE;
        this.f9712c = false;
        this.f9715f = false;
        this.f9716g = Float.MAX_VALUE;
        this.f9717h = -Float.MAX_VALUE;
        this.f9718i = 0L;
        this.f9720k = new ArrayList<>();
        this.f9721l = new ArrayList<>();
        this.f9713d = k10;
        this.f9714e = dVar;
        if (dVar != f9701r && dVar != f9702s && dVar != f9703t) {
            if (dVar == f9707x) {
                this.f9719j = 0.00390625f;
                return;
            } else if (dVar != f9699p && dVar != f9700q) {
                this.f9719j = 1.0f;
                return;
            } else {
                this.f9719j = 0.00390625f;
                return;
            }
        }
        this.f9719j = 0.1f;
    }
}
