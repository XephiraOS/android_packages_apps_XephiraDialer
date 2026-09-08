package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.K;
import androidx.core.view.X;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FragmentContainerView.kt */
/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final List<View> f9959a;

    /* renamed from: b, reason: collision with root package name */
    public final List<View> f9960b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f9961c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9962d;

    /* compiled from: FragmentContainerView.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f9963a = new a();

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View v10, WindowInsets insets) {
            kotlin.jvm.internal.i.f(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            kotlin.jvm.internal.i.f(v10, "v");
            kotlin.jvm.internal.i.f(insets, "insets");
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v10, insets);
            kotlin.jvm.internal.i.e(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public final void a(View view) {
        if (this.f9960b.contains(view)) {
            this.f9959a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i10, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.i.f(child, "child");
        if (FragmentManager.G0(child) != null) {
            super.addView(child, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        X V10;
        kotlin.jvm.internal.i.f(insets, "insets");
        X x10 = X.x(insets);
        kotlin.jvm.internal.i.e(x10, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f9961c;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f9963a;
            kotlin.jvm.internal.i.c(onApplyWindowInsetsListener);
            V10 = X.x(aVar.a(onApplyWindowInsetsListener, this, insets));
        } else {
            V10 = K.V(this, x10);
        }
        kotlin.jvm.internal.i.e(V10, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!V10.q()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                K.f(getChildAt(i10), V10);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.i.f(canvas, "canvas");
        if (this.f9962d) {
            Iterator<T> it = this.f9959a.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long j10) {
        kotlin.jvm.internal.i.f(canvas, "canvas");
        kotlin.jvm.internal.i.f(child, "child");
        if (this.f9962d && (!this.f9959a.isEmpty()) && this.f9959a.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, j10);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        kotlin.jvm.internal.i.f(view, "view");
        this.f9960b.remove(view);
        if (this.f9959a.remove(view)) {
            this.f9962d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.o0(this).l0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.i.f(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View view = getChildAt(childCount);
                kotlin.jvm.internal.i.e(view, "view");
                a(view);
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        kotlin.jvm.internal.i.f(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        View view = getChildAt(i10);
        kotlin.jvm.internal.i.e(view, "view");
        a(view);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        kotlin.jvm.internal.i.f(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View view = getChildAt(i13);
            kotlin.jvm.internal.i.e(view, "view");
            a(view);
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View view = getChildAt(i13);
            kotlin.jvm.internal.i.e(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i10, i11);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f9962d = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f9961c = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        kotlin.jvm.internal.i.f(view, "view");
        if (view.getParent() == this) {
            this.f9960b.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context) {
        super(context);
        kotlin.jvm.internal.i.f(context, "context");
        this.f9959a = new ArrayList();
        this.f9960b = new ArrayList();
        this.f9962d = true;
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.f fVar) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        String str;
        kotlin.jvm.internal.i.f(context, "context");
        this.f9959a = new ArrayList();
        this.f9960b = new ArrayList();
        this.f9962d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] FragmentContainerView = R.c.f3162e;
            kotlin.jvm.internal.i.e(FragmentContainerView, "FragmentContainerView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentContainerView, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R.c.f3163f);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attrs, FragmentManager fm) {
        super(context, attrs);
        String str;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(attrs, "attrs");
        kotlin.jvm.internal.i.f(fm, "fm");
        this.f9959a = new ArrayList();
        this.f9960b = new ArrayList();
        this.f9962d = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = R.c.f3162e;
        kotlin.jvm.internal.i.e(FragmentContainerView, "FragmentContainerView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.c.f3163f) : classAttribute;
        String string = obtainStyledAttributes.getString(R.c.f3164g);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment l02 = fm.l0(id);
        if (classAttribute != null && l02 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a10 = fm.x0().a(context.getClassLoader(), classAttribute);
            kotlin.jvm.internal.i.e(a10, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            a10.onInflate(context, attrs, (Bundle) null);
            fm.p().x(true).d(this, a10, string).l();
        }
        fm.e1(this);
    }
}
