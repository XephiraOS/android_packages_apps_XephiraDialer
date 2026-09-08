package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: WindowInsetsAnimationCompat.java */
/* loaded from: classes.dex */
public final class W {

    /* renamed from: a, reason: collision with root package name */
    public d f9460a;

    /* compiled from: WindowInsetsAnimationCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final B.b f9461a;

        /* renamed from: b, reason: collision with root package name */
        public final B.b f9462b;

        public a(WindowInsetsAnimation.Bounds bounds) {
            this.f9461a = c.f(bounds);
            this.f9462b = c.e(bounds);
        }

        public static a d(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public B.b a() {
            return this.f9461a;
        }

        public B.b b() {
            return this.f9462b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return c.d(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f9461a + " upper=" + this.f9462b + "}";
        }
    }

    /* compiled from: WindowInsetsAnimationCompat.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f9468a;

        /* renamed from: b, reason: collision with root package name */
        public final Interpolator f9469b;

        /* renamed from: c, reason: collision with root package name */
        public final long f9470c;

        public d(int i10, Interpolator interpolator, long j10) {
            this.f9468a = i10;
            this.f9469b = interpolator;
            this.f9470c = j10;
        }

        public float a() {
            throw null;
        }

        public int b() {
            throw null;
        }

        public void c(float f10) {
            throw null;
        }
    }

    public W(int i10, Interpolator interpolator, long j10) {
        this.f9460a = new c(i10, interpolator, j10);
    }

    public static void c(View view, b bVar) {
        c.g(view, bVar);
    }

    public static W e(WindowInsetsAnimation windowInsetsAnimation) {
        return new W(windowInsetsAnimation);
    }

    public float a() {
        return this.f9460a.a();
    }

    public int b() {
        return this.f9460a.b();
    }

    public void d(float f10) {
        this.f9460a.c(f10);
    }

    /* compiled from: WindowInsetsAnimationCompat.java */
    /* loaded from: classes.dex */
    public static class c extends d {

        /* renamed from: d, reason: collision with root package name */
        public final WindowInsetsAnimation f9463d;

        /* compiled from: WindowInsetsAnimationCompat.java */
        /* loaded from: classes.dex */
        public static class a extends WindowInsetsAnimation.Callback {

            /* renamed from: a, reason: collision with root package name */
            public final b f9464a;

            /* renamed from: b, reason: collision with root package name */
            public List<W> f9465b;

            /* renamed from: c, reason: collision with root package name */
            public ArrayList<W> f9466c;

            /* renamed from: d, reason: collision with root package name */
            public final HashMap<WindowInsetsAnimation, W> f9467d;

            public a(b bVar) {
                super(bVar.getDispatchMode());
                this.f9467d = new HashMap<>();
                this.f9464a = bVar;
            }

            public final W a(WindowInsetsAnimation windowInsetsAnimation) {
                W w10 = this.f9467d.get(windowInsetsAnimation);
                if (w10 == null) {
                    W e10 = W.e(windowInsetsAnimation);
                    this.f9467d.put(windowInsetsAnimation, e10);
                    return e10;
                }
                return w10;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f9464a.onEnd(a(windowInsetsAnimation));
                this.f9467d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f9464a.onPrepare(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<W> arrayList = this.f9466c;
                if (arrayList == null) {
                    ArrayList<W> arrayList2 = new ArrayList<>(list.size());
                    this.f9466c = arrayList2;
                    this.f9465b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    W a10 = a(windowInsetsAnimation);
                    a10.d(windowInsetsAnimation.getFraction());
                    this.f9466c.add(a10);
                }
                return this.f9464a.onProgress(X.x(windowInsets), this.f9465b).w();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f9464a.onStart(a(windowInsetsAnimation), a.d(bounds)).c();
            }
        }

        public c(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f9463d = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds d(a aVar) {
            return new WindowInsetsAnimation.Bounds(aVar.a().d(), aVar.b().d());
        }

        public static B.b e(WindowInsetsAnimation.Bounds bounds) {
            return B.b.c(bounds.getUpperBound());
        }

        public static B.b f(WindowInsetsAnimation.Bounds bounds) {
            return B.b.c(bounds.getLowerBound());
        }

        public static void g(View view, b bVar) {
            a aVar;
            if (bVar != null) {
                aVar = new a(bVar);
            } else {
                aVar = null;
            }
            view.setWindowInsetsAnimationCallback(aVar);
        }

        @Override // androidx.core.view.W.d
        public float a() {
            return this.f9463d.getInterpolatedFraction();
        }

        @Override // androidx.core.view.W.d
        public int b() {
            return this.f9463d.getTypeMask();
        }

        @Override // androidx.core.view.W.d
        public void c(float f10) {
            this.f9463d.setFraction(f10);
        }

        public c(int i10, Interpolator interpolator, long j10) {
            this(new WindowInsetsAnimation(i10, interpolator, j10));
        }
    }

    public W(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        this.f9460a = new c(windowInsetsAnimation);
    }

    /* compiled from: WindowInsetsAnimationCompat.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        public b(int i10) {
            this.mDispatchMode = i10;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public abstract X onProgress(X x10, List<W> list);

        public void onEnd(W w10) {
        }

        public void onPrepare(W w10) {
        }

        public a onStart(W w10, a aVar) {
            return aVar;
        }
    }
}
