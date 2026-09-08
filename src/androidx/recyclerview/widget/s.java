package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f11200a;

    /* renamed from: b, reason: collision with root package name */
    public int f11201b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f11202c;

    /* compiled from: OrientationHelper.java */
    /* loaded from: classes.dex */
    public class a extends s {
        public a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.s
        public int d(View view) {
            return this.f11200a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.s
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f11200a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.s
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f11200a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.s
        public int g(View view) {
            return this.f11200a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.s
        public int h() {
            return this.f11200a.getWidth();
        }

        @Override // androidx.recyclerview.widget.s
        public int i() {
            return this.f11200a.getWidth() - this.f11200a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.s
        public int j() {
            return this.f11200a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.s
        public int l() {
            return this.f11200a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.s
        public int m() {
            return this.f11200a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.s
        public int n() {
            return this.f11200a.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.s
        public int o() {
            return (this.f11200a.getWidth() - this.f11200a.getPaddingLeft()) - this.f11200a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.s
        public int q(View view) {
            this.f11200a.getTransformedBoundingBox(view, true, this.f11202c);
            return this.f11202c.right;
        }

        @Override // androidx.recyclerview.widget.s
        public int r(View view) {
            this.f11200a.getTransformedBoundingBox(view, true, this.f11202c);
            return this.f11202c.left;
        }

        @Override // androidx.recyclerview.widget.s
        public void s(int i10) {
            this.f11200a.offsetChildrenHorizontal(i10);
        }
    }

    /* compiled from: OrientationHelper.java */
    /* loaded from: classes.dex */
    public class b extends s {
        public b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.s
        public int d(View view) {
            return this.f11200a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.s
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f11200a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.s
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f11200a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.s
        public int g(View view) {
            return this.f11200a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.s
        public int h() {
            return this.f11200a.getHeight();
        }

        @Override // androidx.recyclerview.widget.s
        public int i() {
            return this.f11200a.getHeight() - this.f11200a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.s
        public int j() {
            return this.f11200a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.s
        public int l() {
            return this.f11200a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.s
        public int m() {
            return this.f11200a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.s
        public int n() {
            return this.f11200a.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.s
        public int o() {
            return (this.f11200a.getHeight() - this.f11200a.getPaddingTop()) - this.f11200a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.s
        public int q(View view) {
            this.f11200a.getTransformedBoundingBox(view, true, this.f11202c);
            return this.f11202c.bottom;
        }

        @Override // androidx.recyclerview.widget.s
        public int r(View view) {
            this.f11200a.getTransformedBoundingBox(view, true, this.f11202c);
            return this.f11202c.top;
        }

        @Override // androidx.recyclerview.widget.s
        public void s(int i10) {
            this.f11200a.offsetChildrenVertical(i10);
        }
    }

    public /* synthetic */ s(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static s a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static s b(RecyclerView.o oVar, int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                return c(oVar);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return a(oVar);
    }

    public static s c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public RecyclerView.o k() {
        return this.f11200a;
    }

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public int p() {
        if (Integer.MIN_VALUE == this.f11201b) {
            return 0;
        }
        return o() - this.f11201b;
    }

    public abstract int q(View view);

    public abstract int r(View view);

    public abstract void s(int i10);

    public void t() {
        this.f11201b = o();
    }

    public s(RecyclerView.o oVar) {
        this.f11201b = Integer.MIN_VALUE;
        this.f11202c = new Rect();
        this.f11200a = oVar;
    }
}
