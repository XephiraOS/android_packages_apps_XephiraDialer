package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.K;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: FastScroller.java */
/* loaded from: classes.dex */
public class k extends RecyclerView.n implements RecyclerView.r {

    /* renamed from: D, reason: collision with root package name */
    public static final int[] f11138D = {16842919};

    /* renamed from: E, reason: collision with root package name */
    public static final int[] f11139E = new int[0];

    /* renamed from: A, reason: collision with root package name */
    public int f11140A;

    /* renamed from: B, reason: collision with root package name */
    public final Runnable f11141B;

    /* renamed from: C, reason: collision with root package name */
    public final RecyclerView.s f11142C;

    /* renamed from: a, reason: collision with root package name */
    public final int f11143a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11144b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f11145c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f11146d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11147e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11148f;

    /* renamed from: g, reason: collision with root package name */
    public final StateListDrawable f11149g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f11150h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11151i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11152j;

    /* renamed from: k, reason: collision with root package name */
    public int f11153k;

    /* renamed from: l, reason: collision with root package name */
    public int f11154l;

    /* renamed from: m, reason: collision with root package name */
    public float f11155m;

    /* renamed from: n, reason: collision with root package name */
    public int f11156n;

    /* renamed from: o, reason: collision with root package name */
    public int f11157o;

    /* renamed from: p, reason: collision with root package name */
    public float f11158p;

    /* renamed from: s, reason: collision with root package name */
    public RecyclerView f11161s;

    /* renamed from: z, reason: collision with root package name */
    public final ValueAnimator f11168z;

    /* renamed from: q, reason: collision with root package name */
    public int f11159q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f11160r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f11162t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11163u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f11164v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f11165w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f11166x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    public final int[] f11167y = new int[2];

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.k(500);
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.s {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            k.this.v(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11171a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f11171a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f11171a) {
                this.f11171a = false;
                return;
            }
            if (((Float) k.this.f11168z.getAnimatedValue()).floatValue() == 0.0f) {
                k kVar = k.this;
                kVar.f11140A = 0;
                kVar.s(0);
            } else {
                k kVar2 = k.this;
                kVar2.f11140A = 2;
                kVar2.p();
            }
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            k.this.f11145c.setAlpha(floatValue);
            k.this.f11146d.setAlpha(floatValue);
            k.this.p();
        }
    }

    public k(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f11168z = ofFloat;
        this.f11140A = 0;
        this.f11141B = new a();
        this.f11142C = new b();
        this.f11145c = stateListDrawable;
        this.f11146d = drawable;
        this.f11149g = stateListDrawable2;
        this.f11150h = drawable2;
        this.f11147e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f11148f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f11151i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f11152j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f11143a = i11;
        this.f11144b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        d(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f11164v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean o10 = o(motionEvent.getX(), motionEvent.getY());
            boolean n10 = n(motionEvent.getX(), motionEvent.getY());
            if (o10 || n10) {
                if (n10) {
                    this.f11165w = 1;
                    this.f11158p = (int) motionEvent.getX();
                } else if (o10) {
                    this.f11165w = 2;
                    this.f11155m = (int) motionEvent.getY();
                }
                s(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f11164v == 2) {
            this.f11155m = 0.0f;
            this.f11158p = 0.0f;
            s(1);
            this.f11165w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f11164v == 2) {
            u();
            if (this.f11165w == 1) {
                l(motionEvent.getX());
            }
            if (this.f11165w == 2) {
                w(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f11164v;
        if (i10 == 1) {
            boolean o10 = o(motionEvent.getX(), motionEvent.getY());
            boolean n10 = n(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!o10 && !n10) {
                return false;
            }
            if (n10) {
                this.f11165w = 1;
                this.f11158p = (int) motionEvent.getX();
            } else if (o10) {
                this.f11165w = 2;
                this.f11155m = (int) motionEvent.getY();
            }
            s(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    public void d(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f11161s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.f11161s = recyclerView;
        if (recyclerView != null) {
            t();
        }
    }

    public final void e() {
        this.f11161s.removeCallbacks(this.f11141B);
    }

    public final void f() {
        this.f11161s.removeItemDecoration(this);
        this.f11161s.removeOnItemTouchListener(this);
        this.f11161s.removeOnScrollListener(this.f11142C);
        e();
    }

    public final void g(Canvas canvas) {
        int i10 = this.f11160r;
        int i11 = this.f11151i;
        int i12 = this.f11157o;
        int i13 = this.f11156n;
        this.f11149g.setBounds(0, 0, i13, i11);
        this.f11150h.setBounds(0, 0, this.f11159q, this.f11152j);
        canvas.translate(0.0f, i10 - i11);
        this.f11150h.draw(canvas);
        canvas.translate(i12 - (i13 / 2), 0.0f);
        this.f11149g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void h(Canvas canvas) {
        int i10 = this.f11159q;
        int i11 = this.f11147e;
        int i12 = i10 - i11;
        int i13 = this.f11154l;
        int i14 = this.f11153k;
        int i15 = i13 - (i14 / 2);
        this.f11145c.setBounds(0, 0, i11, i14);
        this.f11146d.setBounds(0, 0, this.f11148f, this.f11160r);
        if (m()) {
            this.f11146d.draw(canvas);
            canvas.translate(this.f11147e, i15);
            canvas.scale(-1.0f, 1.0f);
            this.f11145c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate(-this.f11147e, -i15);
            return;
        }
        canvas.translate(i12, 0.0f);
        this.f11146d.draw(canvas);
        canvas.translate(0.0f, i15);
        this.f11145c.draw(canvas);
        canvas.translate(-i12, -i15);
    }

    public final int[] i() {
        int[] iArr = this.f11167y;
        int i10 = this.f11144b;
        iArr[0] = i10;
        iArr[1] = this.f11159q - i10;
        return iArr;
    }

    public final int[] j() {
        int[] iArr = this.f11166x;
        int i10 = this.f11144b;
        iArr[0] = i10;
        iArr[1] = this.f11160r - i10;
        return iArr;
    }

    public void k(int i10) {
        int i11 = this.f11140A;
        if (i11 != 1) {
            if (i11 != 2) {
                return;
            }
        } else {
            this.f11168z.cancel();
        }
        this.f11140A = 3;
        ValueAnimator valueAnimator = this.f11168z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f11168z.setDuration(i10);
        this.f11168z.start();
    }

    public final void l(float f10) {
        int[] i10 = i();
        float max = Math.max(i10[0], Math.min(i10[1], f10));
        if (Math.abs(this.f11157o - max) < 2.0f) {
            return;
        }
        int r10 = r(this.f11158p, max, i10, this.f11161s.computeHorizontalScrollRange(), this.f11161s.computeHorizontalScrollOffset(), this.f11159q);
        if (r10 != 0) {
            this.f11161s.scrollBy(r10, 0);
        }
        this.f11158p = max;
    }

    public final boolean m() {
        if (K.v(this.f11161s) == 1) {
            return true;
        }
        return false;
    }

    public boolean n(float f10, float f11) {
        if (f11 >= this.f11160r - this.f11151i) {
            int i10 = this.f11157o;
            int i11 = this.f11156n;
            if (f10 >= i10 - (i11 / 2) && f10 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean o(float f10, float f11) {
        if (!m() ? f10 >= this.f11159q - this.f11147e : f10 <= this.f11147e) {
            int i10 = this.f11154l;
            int i11 = this.f11153k;
            if (f11 >= i10 - (i11 / 2) && f11 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        if (this.f11159q == this.f11161s.getWidth() && this.f11160r == this.f11161s.getHeight()) {
            if (this.f11140A != 0) {
                if (this.f11162t) {
                    h(canvas);
                }
                if (this.f11163u) {
                    g(canvas);
                    return;
                }
                return;
            }
            return;
        }
        this.f11159q = this.f11161s.getWidth();
        this.f11160r = this.f11161s.getHeight();
        s(0);
    }

    public void p() {
        this.f11161s.invalidate();
    }

    public final void q(int i10) {
        e();
        this.f11161s.postDelayed(this.f11141B, i10);
    }

    public final int r(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / i13) * i14);
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    public void s(int i10) {
        if (i10 == 2 && this.f11164v != 2) {
            this.f11145c.setState(f11138D);
            e();
        }
        if (i10 == 0) {
            p();
        } else {
            u();
        }
        if (this.f11164v == 2 && i10 != 2) {
            this.f11145c.setState(f11139E);
            q(1200);
        } else if (i10 == 1) {
            q(1500);
        }
        this.f11164v = i10;
    }

    public final void t() {
        this.f11161s.addItemDecoration(this);
        this.f11161s.addOnItemTouchListener(this);
        this.f11161s.addOnScrollListener(this.f11142C);
    }

    public void u() {
        int i10 = this.f11140A;
        if (i10 != 0) {
            if (i10 == 3) {
                this.f11168z.cancel();
            } else {
                return;
            }
        }
        this.f11140A = 1;
        ValueAnimator valueAnimator = this.f11168z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f11168z.setDuration(500L);
        this.f11168z.setStartDelay(0L);
        this.f11168z.start();
    }

    public void v(int i10, int i11) {
        boolean z10;
        boolean z11;
        int computeVerticalScrollRange = this.f11161s.computeVerticalScrollRange();
        int i12 = this.f11160r;
        if (computeVerticalScrollRange - i12 > 0 && i12 >= this.f11143a) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f11162t = z10;
        int computeHorizontalScrollRange = this.f11161s.computeHorizontalScrollRange();
        int i13 = this.f11159q;
        if (computeHorizontalScrollRange - i13 > 0 && i13 >= this.f11143a) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f11163u = z11;
        boolean z12 = this.f11162t;
        if (!z12 && !z11) {
            if (this.f11164v != 0) {
                s(0);
                return;
            }
            return;
        }
        if (z12) {
            float f10 = i12;
            this.f11154l = (int) ((f10 * (i11 + (f10 / 2.0f))) / computeVerticalScrollRange);
            this.f11153k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
        }
        if (this.f11163u) {
            float f11 = i13;
            this.f11157o = (int) ((f11 * (i10 + (f11 / 2.0f))) / computeHorizontalScrollRange);
            this.f11156n = Math.min(i13, (i13 * i13) / computeHorizontalScrollRange);
        }
        int i14 = this.f11164v;
        if (i14 == 0 || i14 == 1) {
            s(1);
        }
    }

    public final void w(float f10) {
        int[] j10 = j();
        float max = Math.max(j10[0], Math.min(j10[1], f10));
        if (Math.abs(this.f11154l - max) < 2.0f) {
            return;
        }
        int r10 = r(this.f11155m, max, j10, this.f11161s.computeVerticalScrollRange(), this.f11161s.computeVerticalScrollOffset(), this.f11160r);
        if (r10 != 0) {
            this.f11161s.scrollBy(0, r10);
        }
        this.f11155m = max;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void c(boolean z10) {
    }
}
