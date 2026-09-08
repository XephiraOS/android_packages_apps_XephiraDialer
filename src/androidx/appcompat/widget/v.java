package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import e.C0961a;
import g.C1026c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: DropDownListView.java */
/* loaded from: classes.dex */
public class v extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f7923a;

    /* renamed from: b, reason: collision with root package name */
    public int f7924b;

    /* renamed from: c, reason: collision with root package name */
    public int f7925c;

    /* renamed from: d, reason: collision with root package name */
    public int f7926d;

    /* renamed from: e, reason: collision with root package name */
    public int f7927e;

    /* renamed from: f, reason: collision with root package name */
    public int f7928f;

    /* renamed from: g, reason: collision with root package name */
    public d f7929g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7930h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7931i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7932j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.core.view.Q f7933k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.core.widget.h f7934l;

    /* renamed from: m, reason: collision with root package name */
    public e f7935m;

    /* compiled from: DropDownListView.java */
    /* loaded from: classes.dex */
    public static class a {
        public static void a(View view, float f10, float f11) {
            view.drawableHotspotChanged(f10, f11);
        }
    }

    /* compiled from: DropDownListView.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static Method f7936a;

        /* renamed from: b, reason: collision with root package name */
        public static Method f7937b;

        /* renamed from: c, reason: collision with root package name */
        public static Method f7938c;

        /* renamed from: d, reason: collision with root package name */
        public static boolean f7939d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                f7936a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f7937b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f7938c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f7939d = true;
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }

        public static boolean a() {
            return f7939d;
        }

        public static void b(v vVar, int i10, View view) {
            try {
                f7936a.invoke(vVar, Integer.valueOf(i10), view, Boolean.FALSE, -1, -1);
                f7937b.invoke(vVar, Integer.valueOf(i10));
                f7938c.invoke(vVar, Integer.valueOf(i10));
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* compiled from: DropDownListView.java */
    /* loaded from: classes.dex */
    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z10) {
            absListView.setSelectedChildViewEnabled(z10);
        }
    }

    /* compiled from: DropDownListView.java */
    /* loaded from: classes.dex */
    public static class d extends C1026c {

        /* renamed from: b, reason: collision with root package name */
        public boolean f7940b;

        public d(Drawable drawable) {
            super(drawable);
            this.f7940b = true;
        }

        public void b(boolean z10) {
            this.f7940b = z10;
        }

        @Override // g.C1026c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f7940b) {
                super.draw(canvas);
            }
        }

        @Override // g.C1026c, android.graphics.drawable.Drawable
        public void setHotspot(float f10, float f11) {
            if (this.f7940b) {
                super.setHotspot(f10, f11);
            }
        }

        @Override // g.C1026c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f7940b) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        @Override // g.C1026c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f7940b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // g.C1026c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f7940b) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    /* compiled from: DropDownListView.java */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        public void a() {
            v vVar = v.this;
            vVar.f7935m = null;
            vVar.removeCallbacks(this);
        }

        public void b() {
            v.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = v.this;
            vVar.f7935m = null;
            vVar.drawableStateChanged();
        }
    }

    public v(Context context, boolean z10) {
        super(context, null, C0961a.f30085C);
        this.f7923a = new Rect();
        this.f7924b = 0;
        this.f7925c = 0;
        this.f7926d = 0;
        this.f7927e = 0;
        this.f7931i = z10;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean z10) {
        d dVar = this.f7929g;
        if (dVar != null) {
            dVar.b(z10);
        }
    }

    public final void a() {
        this.f7932j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f7928f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        androidx.core.view.Q q10 = this.f7933k;
        if (q10 != null) {
            q10.c();
            this.f7933k = null;
        }
    }

    public final void b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (!this.f7923a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f7923a);
            selector.draw(canvas);
        }
    }

    public int d(int i10, int i11, int i12, int i13, int i14) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i15 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i16 = 0;
        int i17 = 0;
        View view = null;
        for (int i18 = 0; i18 < count; i18++) {
            int itemViewType = adapter.getItemViewType(i18);
            if (itemViewType != i16) {
                view = null;
                i16 = itemViewType;
            }
            view = adapter.getView(i18, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i19 = layoutParams.height;
            if (i19 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i10, makeMeasureSpec);
            view.forceLayout();
            if (i18 > 0) {
                i15 += dividerHeight;
            }
            i15 += view.getMeasuredHeight();
            if (i15 >= i13) {
                if (i14 >= 0 && i18 > i14 && i17 > 0 && i15 != i13) {
                    return i17;
                }
                return i13;
            }
            if (i14 >= 0 && i18 >= i14) {
                i17 = i15;
            }
        }
        return i15;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f7935m != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r3 = r1
            r9 = r2
            goto L46
        L11:
            r9 = r2
            r3 = r9
            goto L46
        L14:
            r3 = r1
            goto L17
        L16:
            r3 = r2
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.h r9 = r7.f7934l
            if (r9 != 0) goto L5a
            androidx.core.widget.h r9 = new androidx.core.widget.h
            r9.<init>(r7)
            r7.f7934l = r9
        L5a:
            androidx.core.widget.h r9 = r7.f7934l
            r9.m(r1)
            androidx.core.widget.h r9 = r7.f7934l
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.h r7 = r7.f7934l
            if (r7 == 0) goto L6c
            r7.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.v.e(android.view.MotionEvent, int):boolean");
    }

    public final void f(int i10, View view) {
        Rect rect = this.f7923a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f7924b;
        rect.top -= this.f7925c;
        rect.right += this.f7926d;
        rect.bottom += this.f7927e;
        boolean j10 = j();
        if (view.isEnabled() != j10) {
            k(!j10);
            if (i10 != -1) {
                refreshDrawableState();
            }
        }
    }

    public final void g(int i10, View view) {
        boolean z10;
        Drawable selector = getSelector();
        boolean z11 = true;
        if (selector != null && i10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            selector.setVisible(false, false);
        }
        f(i10, view);
        if (z10) {
            Rect rect = this.f7923a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z11 = false;
            }
            selector.setVisible(z11, false);
            C.a.k(selector, exactCenterX, exactCenterY);
        }
    }

    public final void h(int i10, View view, float f10, float f11) {
        g(i10, view);
        Drawable selector = getSelector();
        if (selector != null && i10 != -1) {
            C.a.k(selector, f10, f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (!this.f7931i && !super.hasFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (!this.f7931i && !super.hasWindowFocus()) {
            return false;
        }
        return true;
    }

    public final void i(View view, int i10, float f10, float f11) {
        View childAt;
        this.f7932j = true;
        a.a(this, f10, f11);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i11 = this.f7928f;
        if (i11 != -1 && (childAt = getChildAt(i11 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f7928f = i10;
        a.a(view, f10 - view.getLeft(), f11 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i10, view, f10, f11);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (!this.f7931i && !super.isFocused()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if ((this.f7931i && this.f7930h) || super.isInTouchMode()) {
            return true;
        }
        return false;
    }

    public final boolean j() {
        return c.a(this);
    }

    public final void k(boolean z10) {
        c.b(this, z10);
    }

    public final boolean l() {
        return this.f7932j;
    }

    public final void m() {
        Drawable selector = getSelector();
        if (selector != null && l() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f7935m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f7935m == null) {
            e eVar = new e();
            this.f7935m = eVar;
            eVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (b.a()) {
                        b.b(this, pointToPosition, childAt);
                    } else {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    }
                }
                m();
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f7928f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        e eVar = this.f7935m;
        if (eVar != null) {
            eVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f7930h = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar;
        if (drawable != null) {
            dVar = new d(drawable);
        } else {
            dVar = null;
        }
        this.f7929g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f7924b = rect.left;
        this.f7925c = rect.top;
        this.f7926d = rect.right;
        this.f7927e = rect.bottom;
    }
}
