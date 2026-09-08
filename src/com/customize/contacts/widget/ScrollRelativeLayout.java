package com.customize.contacts.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class ScrollRelativeLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public Scroller f22405a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f22406b;

    /* renamed from: c, reason: collision with root package name */
    public VelocityTracker f22407c;

    /* renamed from: d, reason: collision with root package name */
    public a f22408d;

    /* renamed from: e, reason: collision with root package name */
    public int f22409e;

    /* renamed from: f, reason: collision with root package name */
    public int f22410f;

    /* renamed from: g, reason: collision with root package name */
    public float f22411g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22412h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f22413i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f22414j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22415k;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        boolean b();

        void c();

        void d();

        int getHeight();
    }

    public ScrollRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final float a(float f10) {
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        return f10;
    }

    public boolean b() {
        return this.f22412h;
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f22407c;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f22407c.recycle();
            this.f22407c = null;
            this.f22409e = 0;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f22405a.computeScrollOffset()) {
            int currY = this.f22405a.getCurrY();
            if (this.f22405a.getFinalY() == currY) {
                if (H7.a.b()) {
                    H7.b.b("ScrollLayout", "computeScroll set mNeedReset false");
                }
                this.f22406b = false;
            }
            setTranslationY(a(currY));
            invalidate();
            return;
        }
        if (this.f22406b) {
            this.f22406b = false;
            setTranslationY(this.f22405a.getFinalY());
        }
    }

    public final void d(float f10) {
        int height;
        if (f10 <= this.f22411g || !this.f22413i) {
            double translationY = getTranslationY();
            a aVar = this.f22408d;
            if (aVar == null) {
                height = getHeight();
            } else {
                height = aVar.getHeight();
            }
            if (translationY <= height * 0.45d) {
                return;
            }
        }
        a aVar2 = this.f22408d;
        if (aVar2 != null) {
            aVar2.d();
            this.f22408d.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f22415k) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            View findViewById = findViewById(R.id.one);
            View findViewById2 = findViewById(R.id.pound);
            if (findViewById != null && findViewById2 != null) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                findViewById.getGlobalVisibleRect(rect);
                findViewById2.getGlobalVisibleRect(rect2);
                float f10 = rect.left;
                float f11 = rect2.right;
                float f12 = rect.top;
                float f13 = rect2.bottom;
                if ((x10 < f10 || x10 > f11) && y10 > f12 && y10 < f13) {
                    H7.b.e("ScrollLayout", "dial dispatchHoverEvent return true;");
                    return true;
                }
            }
            View findViewById3 = findViewById(R.id.dialpad_bottom_sub_container);
            if (findViewById3 != null) {
                Rect rect3 = new Rect();
                findViewById3.getGlobalVisibleRect(rect3);
                float f14 = rect3.left;
                float f15 = rect3.right;
                float f16 = rect3.top;
                float f17 = rect3.bottom;
                if ((x10 < f14 || x10 > f15) && y10 > f16 && y10 < f17) {
                    H7.b.e("ScrollLayout", "bottom dispatchHoverEvent return true;");
                    return true;
                }
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0016, code lost:
    
        if (r0 != 6) goto L37;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            boolean r0 = r3.f22415k
            if (r0 == 0) goto L6e
            int r0 = r4.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            if (r0 == 0) goto L43
            if (r0 == r1) goto L3b
            r2 = 2
            if (r0 == r2) goto L19
            r2 = 5
            if (r0 == r2) goto L43
            r4 = 6
            if (r0 == r4) goto L3b
            goto L6b
        L19:
            boolean r0 = r3.f22414j
            if (r0 != 0) goto L6b
            float r4 = r4.getY()
            int r0 = r3.f22409e
            float r0 = (float) r0
            float r4 = r4 - r0
            int r0 = r3.f22410f
            float r0 = (float) r0
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 <= 0) goto L6b
            android.widget.Scroller r4 = r3.f22405a
            boolean r4 = r4.isFinished()
            if (r4 == 0) goto L6b
            int r4 = r3.f22409e
            if (r4 == 0) goto L6b
            r3.f22412h = r1
            goto L6b
        L3b:
            boolean r4 = r3.f22412h
            if (r4 != 0) goto L6b
            r3.c()
            goto L6b
        L43:
            android.view.VelocityTracker r0 = r3.f22407c
            if (r0 != 0) goto L4e
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r3.f22407c = r0
            goto L51
        L4e:
            r0.clear()
        L51:
            android.view.VelocityTracker r0 = r3.f22407c
            r0.addMovement(r4)
            float r4 = r4.getY()
            int r4 = (int) r4
            r3.f22409e = r4
            com.customize.contacts.widget.ScrollRelativeLayout$a r4 = r3.f22408d
            if (r4 == 0) goto L68
            boolean r4 = r4.b()
            if (r4 == 0) goto L68
            goto L69
        L68:
            r1 = 0
        L69:
            r3.f22414j = r1
        L6b:
            boolean r3 = r3.f22412h
            return r3
        L6e:
            boolean r3 = super.onInterceptTouchEvent(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.widget.ScrollRelativeLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        if (isMotionEventSplittingEnabled() == false) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.f22415k
            r1 = 1
            if (r0 == 0) goto Lac
            boolean r0 = H7.a.b()
            java.lang.String r2 = "ScrollLayout"
            if (r0 == 0) goto L25
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "onTouchEvent event "
            r0.append(r3)
            int r3 = r7.getAction()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            H7.b.b(r2, r0)
        L25:
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 0
            if (r0 == r1) goto L84
            r4 = 2
            r5 = 0
            if (r0 == r4) goto L4f
            r4 = 3
            if (r0 == r4) goto L41
            r2 = 6
            if (r0 == r2) goto L3a
            goto Lac
        L3a:
            boolean r0 = r6.isMotionEventSplittingEnabled()
            if (r0 != 0) goto L84
            goto Lac
        L41:
            java.lang.String r7 = "ACTION_CANCEL"
            H7.b.b(r2, r7)
            r6.setTranslationY(r5)
            r6.f22412h = r3
            r6.c()
            goto Lac
        L4f:
            android.view.VelocityTracker r0 = r6.f22407c
            if (r0 != 0) goto L59
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.f22407c = r0
        L59:
            com.customize.contacts.widget.ScrollRelativeLayout$a r0 = r6.f22408d
            if (r0 == 0) goto L60
            r0.c()
        L60:
            android.view.VelocityTracker r0 = r6.f22407c
            r0.addMovement(r7)
            float r0 = r7.getY()
            int r2 = r6.f22409e
            float r2 = (float) r2
            float r0 = r0 - r2
            float r2 = r6.getTranslationY()
            float r2 = r2 + r0
            r6.a(r2)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L7a
            r3 = r1
        L7a:
            r6.f22413i = r3
            float r7 = r7.getY()
            int r7 = (int) r7
            r6.f22409e = r7
            goto Lac
        L84:
            android.view.VelocityTracker r0 = r6.f22407c
            if (r0 != 0) goto L8e
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.f22407c = r0
        L8e:
            android.view.VelocityTracker r0 = r6.f22407c
            r0.addMovement(r7)
            android.view.VelocityTracker r7 = r6.f22407c
            r0 = 1000(0x3e8, float:1.401E-42)
            r7.computeCurrentVelocity(r0)
            android.view.VelocityTracker r7 = r6.f22407c
            float r7 = r7.getYVelocity()
            float r7 = java.lang.Math.abs(r7)
            r6.d(r7)
            r6.f22412h = r3
            r6.c()
        Lac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.widget.ScrollRelativeLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCanScroll(boolean z10) {
        this.f22415k = z10;
    }

    public void setListener(a aVar) {
        this.f22408d = aVar;
    }

    public ScrollRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22406b = false;
        this.f22409e = 0;
        this.f22415k = true;
        setMotionEventSplittingEnabled(false);
        this.f22410f = (getResources().getDimensionPixelSize(R.dimen.dialpad_button_height) * 2) / 3;
        this.f22411g = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity() / 2.0f;
        this.f22405a = new Scroller(getContext(), new DecelerateInterpolator());
        this.f22406b = false;
    }
}
