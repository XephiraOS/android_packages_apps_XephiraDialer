package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.K;
import java.util.Arrays;

/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: x, reason: collision with root package name */
    public static final Interpolator f9583x = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f9584a;

    /* renamed from: b, reason: collision with root package name */
    public int f9585b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f9587d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f9588e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f9589f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f9590g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f9591h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f9592i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f9593j;

    /* renamed from: k, reason: collision with root package name */
    public int f9594k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f9595l;

    /* renamed from: m, reason: collision with root package name */
    public float f9596m;

    /* renamed from: n, reason: collision with root package name */
    public float f9597n;

    /* renamed from: o, reason: collision with root package name */
    public int f9598o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9599p;

    /* renamed from: q, reason: collision with root package name */
    public int f9600q;

    /* renamed from: r, reason: collision with root package name */
    public OverScroller f9601r;

    /* renamed from: s, reason: collision with root package name */
    public final AbstractC0115c f9602s;

    /* renamed from: t, reason: collision with root package name */
    public View f9603t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9604u;

    /* renamed from: v, reason: collision with root package name */
    public final ViewGroup f9605v;

    /* renamed from: c, reason: collision with root package name */
    public int f9586c = -1;

    /* renamed from: w, reason: collision with root package name */
    public final Runnable f9606w = new b();

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.L(0);
        }
    }

    public c(Context context, ViewGroup viewGroup, AbstractC0115c abstractC0115c) {
        if (viewGroup != null) {
            if (abstractC0115c != null) {
                this.f9605v = viewGroup;
                this.f9602s = abstractC0115c;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.f9599p = i10;
                this.f9598o = i10;
                this.f9585b = viewConfiguration.getScaledTouchSlop();
                this.f9596m = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f9597n = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f9601r = new OverScroller(context, f9583x);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public static c o(ViewGroup viewGroup, float f10, AbstractC0115c abstractC0115c) {
        c p10 = p(viewGroup, abstractC0115c);
        p10.f9585b = (int) (p10.f9585b * (1.0f / f10));
        return p10;
    }

    public static c p(ViewGroup viewGroup, AbstractC0115c abstractC0115c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0115c);
    }

    public int A() {
        return this.f9585b;
    }

    public int B() {
        return this.f9584a;
    }

    public boolean C(int i10, int i11) {
        return F(this.f9603t, i10, i11);
    }

    public boolean D(int i10) {
        if ((this.f9594k & (1 << i10)) != 0) {
            return true;
        }
        return false;
    }

    public final boolean E(int i10) {
        if (!D(i10)) {
            Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return true;
    }

    public boolean F(View view, int i10, int i11) {
        if (view == null || i10 < view.getLeft() || i10 >= view.getRight() || i11 < view.getTop() || i11 >= view.getBottom()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
    
        if (r9.f9586c == (-1)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
    
        H();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.c.G(android.view.MotionEvent):void");
    }

    public final void H() {
        this.f9595l.computeCurrentVelocity(1000, this.f9596m);
        q(h(this.f9595l.getXVelocity(this.f9586c), this.f9597n, this.f9596m), h(this.f9595l.getYVelocity(this.f9586c), this.f9597n, this.f9596m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.customview.widget.c$c] */
    public final void I(float f10, float f11, int i10) {
        boolean d10 = d(f10, f11, i10, 1);
        boolean z10 = d10;
        if (d(f11, f10, i10, 4)) {
            z10 = (d10 ? 1 : 0) | 4;
        }
        boolean z11 = z10;
        if (d(f10, f11, i10, 2)) {
            z11 = (z10 ? 1 : 0) | 2;
        }
        ?? r02 = z11;
        if (d(f11, f10, i10, 8)) {
            r02 = (z11 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f9592i;
            iArr[i10] = iArr[i10] | r02;
            this.f9602s.onEdgeDragStarted(r02, i10);
        }
    }

    public final void J(float f10, float f11, int i10) {
        t(i10);
        float[] fArr = this.f9587d;
        this.f9589f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f9588e;
        this.f9590g[i10] = f11;
        fArr2[i10] = f11;
        this.f9591h[i10] = z((int) f10, (int) f11);
        this.f9594k |= 1 << i10;
    }

    public final void K(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (E(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f9589f[pointerId] = x10;
                this.f9590g[pointerId] = y10;
            }
        }
    }

    public void L(int i10) {
        this.f9605v.removeCallbacks(this.f9606w);
        if (this.f9584a != i10) {
            this.f9584a = i10;
            this.f9602s.onViewDragStateChanged(i10);
            if (this.f9584a == 0) {
                this.f9603t = null;
            }
        }
    }

    public void M(int i10) {
        this.f9598o = i10;
    }

    public void N(int i10) {
        this.f9600q = i10;
    }

    public void O(float f10) {
        this.f9597n = f10;
    }

    public boolean P(int i10, int i11) {
        if (this.f9604u) {
            return v(i10, i11, (int) this.f9595l.getXVelocity(this.f9586c), (int) this.f9595l.getYVelocity(this.f9586c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean Q(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.c.Q(android.view.MotionEvent):boolean");
    }

    public boolean R(View view, int i10, int i11) {
        this.f9603t = view;
        this.f9586c = -1;
        boolean v10 = v(i10, i11, 0, 0);
        if (!v10 && this.f9584a == 0 && this.f9603t != null) {
            this.f9603t = null;
        }
        return v10;
    }

    public boolean S(View view, int i10) {
        if (view == this.f9603t && this.f9586c == i10) {
            return true;
        }
        if (view != null && this.f9602s.tryCaptureView(view, i10)) {
            this.f9586c = i10;
            c(view, i10);
            return true;
        }
        return false;
    }

    public void a() {
        b();
        if (this.f9584a == 2) {
            int currX = this.f9601r.getCurrX();
            int currY = this.f9601r.getCurrY();
            this.f9601r.abortAnimation();
            int currX2 = this.f9601r.getCurrX();
            int currY2 = this.f9601r.getCurrY();
            this.f9602s.onViewPositionChanged(this.f9603t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        L(0);
    }

    public void b() {
        this.f9586c = -1;
        j();
        VelocityTracker velocityTracker = this.f9595l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f9595l = null;
        }
    }

    public void c(View view, int i10) {
        if (view.getParent() == this.f9605v) {
            this.f9603t = view;
            this.f9586c = i10;
            this.f9602s.onViewCaptured(view, i10);
            L(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f9605v + ")");
    }

    public final boolean d(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f9591h[i10] & i11) != i11 || (this.f9600q & i11) == 0 || (this.f9593j[i10] & i11) == i11 || (this.f9592i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f9585b;
        if (abs <= i12 && abs2 <= i12) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f9602s.onEdgeLock(i11)) {
            int[] iArr = this.f9593j;
            iArr[i10] = iArr[i10] | i11;
            return false;
        }
        if ((this.f9592i[i10] & i11) != 0 || abs <= this.f9585b) {
            return false;
        }
        return true;
    }

    public boolean e(int i10) {
        int length = this.f9587d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (f(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i10, int i11) {
        boolean z10;
        boolean z11;
        if (!D(i11)) {
            return false;
        }
        if ((i10 & 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((i10 & 2) == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        float f10 = this.f9589f[i11] - this.f9587d[i11];
        float f11 = this.f9590g[i11] - this.f9588e[i11];
        if (z10 && z11) {
            float f12 = (f10 * f10) + (f11 * f11);
            int i12 = this.f9585b;
            if (f12 <= i12 * i12) {
                return false;
            }
            return true;
        }
        if (z10) {
            if (Math.abs(f10) <= this.f9585b) {
                return false;
            }
            return true;
        }
        if (!z11 || Math.abs(f11) <= this.f9585b) {
            return false;
        }
        return true;
    }

    public final boolean g(View view, float f10, float f11) {
        boolean z10;
        boolean z11;
        if (view == null) {
            return false;
        }
        if (this.f9602s.getViewHorizontalDragRange(view) > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f9602s.getViewVerticalDragRange(view) > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && z11) {
            float f12 = (f10 * f10) + (f11 * f11);
            int i10 = this.f9585b;
            if (f12 <= i10 * i10) {
                return false;
            }
            return true;
        }
        if (z10) {
            if (Math.abs(f10) <= this.f9585b) {
                return false;
            }
            return true;
        }
        if (!z11 || Math.abs(f11) <= this.f9585b) {
            return false;
        }
        return true;
    }

    public final float h(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return 0.0f;
        }
        if (abs > f12) {
            if (f10 <= 0.0f) {
                return -f12;
            }
            return f12;
        }
        return f10;
    }

    public final int i(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        if (abs > i12) {
            if (i10 <= 0) {
                return -i12;
            }
            return i12;
        }
        return i10;
    }

    public final void j() {
        float[] fArr = this.f9587d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f9588e, 0.0f);
        Arrays.fill(this.f9589f, 0.0f);
        Arrays.fill(this.f9590g, 0.0f);
        Arrays.fill(this.f9591h, 0);
        Arrays.fill(this.f9592i, 0);
        Arrays.fill(this.f9593j, 0);
        this.f9594k = 0;
    }

    public final void k(int i10) {
        if (this.f9587d != null && D(i10)) {
            this.f9587d[i10] = 0.0f;
            this.f9588e[i10] = 0.0f;
            this.f9589f[i10] = 0.0f;
            this.f9590g[i10] = 0.0f;
            this.f9591h[i10] = 0;
            this.f9592i[i10] = 0;
            this.f9593j[i10] = 0;
            this.f9594k = (~(1 << i10)) & this.f9594k;
        }
    }

    public final int l(int i10, int i11, int i12) {
        int abs;
        if (i10 == 0) {
            return 0;
        }
        int width = this.f9605v.getWidth();
        float f10 = width / 2;
        float r10 = f10 + (r(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int abs2 = Math.abs(i11);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(r10 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    public final int m(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int i14 = i(i12, (int) this.f9597n, (int) this.f9596m);
        int i15 = i(i13, (int) this.f9597n, (int) this.f9596m);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(i14);
        int abs4 = Math.abs(i15);
        int i16 = abs3 + abs4;
        int i17 = abs + abs2;
        if (i14 != 0) {
            f10 = abs3;
            f11 = i16;
        } else {
            f10 = abs;
            f11 = i17;
        }
        float f14 = f10 / f11;
        if (i15 != 0) {
            f12 = abs4;
            f13 = i16;
        } else {
            f12 = abs2;
            f13 = i17;
        }
        return (int) ((l(i10, i14, this.f9602s.getViewHorizontalDragRange(view)) * f14) + (l(i11, i15, this.f9602s.getViewVerticalDragRange(view)) * (f12 / f13)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r0 == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean n(boolean r12) {
        /*
            r11 = this;
            int r0 = r11.f9584a
            r1 = 0
            r2 = 2
            if (r0 != r2) goto L6a
            android.widget.OverScroller r0 = r11.f9601r
            boolean r0 = r0.computeScrollOffset()
            android.widget.OverScroller r3 = r11.f9601r
            int r3 = r3.getCurrX()
            android.widget.OverScroller r4 = r11.f9601r
            int r10 = r4.getCurrY()
            android.view.View r4 = r11.f9603t
            int r4 = r4.getLeft()
            int r8 = r3 - r4
            android.view.View r4 = r11.f9603t
            int r4 = r4.getTop()
            int r9 = r10 - r4
            if (r8 == 0) goto L2f
            android.view.View r4 = r11.f9603t
            androidx.core.view.K.T(r4, r8)
        L2f:
            if (r9 == 0) goto L36
            android.view.View r4 = r11.f9603t
            androidx.core.view.K.U(r4, r9)
        L36:
            if (r8 != 0) goto L3a
            if (r9 == 0) goto L43
        L3a:
            androidx.customview.widget.c$c r4 = r11.f9602s
            android.view.View r5 = r11.f9603t
            r6 = r3
            r7 = r10
            r4.onViewPositionChanged(r5, r6, r7, r8, r9)
        L43:
            if (r0 == 0) goto L5b
            android.widget.OverScroller r4 = r11.f9601r
            int r4 = r4.getFinalX()
            if (r3 != r4) goto L5b
            android.widget.OverScroller r3 = r11.f9601r
            int r3 = r3.getFinalY()
            if (r10 != r3) goto L5b
            android.widget.OverScroller r0 = r11.f9601r
            r0.abortAnimation()
            goto L5d
        L5b:
            if (r0 != 0) goto L6a
        L5d:
            if (r12 == 0) goto L67
            android.view.ViewGroup r12 = r11.f9605v
            java.lang.Runnable r0 = r11.f9606w
            r12.post(r0)
            goto L6a
        L67:
            r11.L(r1)
        L6a:
            int r11 = r11.f9584a
            if (r11 != r2) goto L6f
            r1 = 1
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.c.n(boolean):boolean");
    }

    public final void q(float f10, float f11) {
        this.f9604u = true;
        this.f9602s.onViewReleased(this.f9603t, f10, f11);
        this.f9604u = false;
        if (this.f9584a == 1) {
            L(0);
        }
    }

    public final float r(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public final void s(int i10, int i11, int i12, int i13) {
        int left = this.f9603t.getLeft();
        int top = this.f9603t.getTop();
        if (i12 != 0) {
            i10 = this.f9602s.clampViewPositionHorizontal(this.f9603t, i10, i12);
            K.T(this.f9603t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f9602s.clampViewPositionVertical(this.f9603t, i11, i13);
            K.U(this.f9603t, i11 - top);
        }
        int i15 = i11;
        if (i12 != 0 || i13 != 0) {
            this.f9602s.onViewPositionChanged(this.f9603t, i14, i15, i14 - left, i15 - top);
        }
    }

    public final void t(int i10) {
        float[] fArr = this.f9587d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f9588e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f9589f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f9590g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f9591h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f9592i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f9593j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f9587d = fArr2;
            this.f9588e = fArr3;
            this.f9589f = fArr4;
            this.f9590g = fArr5;
            this.f9591h = iArr;
            this.f9592i = iArr2;
            this.f9593j = iArr3;
        }
    }

    public View u(int i10, int i11) {
        for (int childCount = this.f9605v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f9605v.getChildAt(this.f9602s.getOrderedChildIndex(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean v(int i10, int i11, int i12, int i13) {
        int left = this.f9603t.getLeft();
        int top = this.f9603t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f9601r.abortAnimation();
            L(0);
            return false;
        }
        this.f9601r.startScroll(left, top, i14, i15, m(this.f9603t, i14, i15, i12, i13));
        L(2);
        return true;
    }

    public View w() {
        return this.f9603t;
    }

    public int x() {
        return this.f9599p;
    }

    public int y() {
        return this.f9598o;
    }

    public final int z(int i10, int i11) {
        int i12;
        if (i10 < this.f9605v.getLeft() + this.f9598o) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        if (i11 < this.f9605v.getTop() + this.f9598o) {
            i12 |= 4;
        }
        if (i10 > this.f9605v.getRight() - this.f9598o) {
            i12 |= 2;
        }
        if (i11 > this.f9605v.getBottom() - this.f9598o) {
            return i12 | 8;
        }
        return i12;
    }

    /* compiled from: ViewDragHelper.java */
    /* renamed from: androidx.customview.widget.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0115c {
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i10, int i11) {
            return 0;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public boolean onEdgeLock(int i10) {
            return false;
        }

        public abstract boolean tryCaptureView(View view, int i10);

        public int getOrderedChildIndex(int i10) {
            return i10;
        }

        public void onViewDragStateChanged(int i10) {
        }

        public void onEdgeDragStarted(int i10, int i11) {
        }

        public void onEdgeTouched(int i10, int i11) {
        }

        public void onViewCaptured(View view, int i10) {
        }

        public void onViewReleased(View view, float f10, float f11) {
        }

        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
        }
    }
}
