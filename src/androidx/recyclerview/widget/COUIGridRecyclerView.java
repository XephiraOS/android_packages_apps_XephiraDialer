package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.grid.COUIPercentWidthRecyclerView;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import java.util.Arrays;

/* loaded from: classes.dex */
public class COUIGridRecyclerView extends COUIPercentWidthRecyclerView {

    /* renamed from: a, reason: collision with root package name */
    public float f10808a;

    /* renamed from: b, reason: collision with root package name */
    public float f10809b;

    /* renamed from: c, reason: collision with root package name */
    public float f10810c;

    /* renamed from: d, reason: collision with root package name */
    public float f10811d;

    /* renamed from: e, reason: collision with root package name */
    public float f10812e;

    /* renamed from: f, reason: collision with root package name */
    public float f10813f;

    /* renamed from: g, reason: collision with root package name */
    public float f10814g;

    /* renamed from: h, reason: collision with root package name */
    public int f10815h;

    /* renamed from: i, reason: collision with root package name */
    public int f10816i;

    /* renamed from: j, reason: collision with root package name */
    public int f10817j;

    /* renamed from: k, reason: collision with root package name */
    public int f10818k;

    /* renamed from: l, reason: collision with root package name */
    public int f10819l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10820m;

    /* loaded from: classes.dex */
    public class COUIGridLayoutManager extends GridLayoutManager {
        public COUIGridLayoutManager(Context context) {
            super(context, 1);
        }

        public final void A() {
            COUIGridRecyclerView.this.f10815h = Math.max(1, (int) ((C() + COUIGridRecyclerView.this.f10808a) / (COUIGridRecyclerView.this.f10808a + COUIGridRecyclerView.this.f10811d)));
            COUIGridRecyclerView.this.f10814g = (C() - (COUIGridRecyclerView.this.f10808a * (COUIGridRecyclerView.this.f10815h - 1))) / COUIGridRecyclerView.this.f10815h;
            COUIGridRecyclerView.this.f10813f = y();
        }

        public final void B() {
            COUIGridRecyclerView.this.f10815h = Math.max(1, (int) ((C() + COUIGridRecyclerView.this.f10809b) / (COUIGridRecyclerView.this.f10809b + COUIGridRecyclerView.this.f10814g)));
            COUIGridRecyclerView.this.f10808a = (C() - (COUIGridRecyclerView.this.f10814g * COUIGridRecyclerView.this.f10815h)) / (COUIGridRecyclerView.this.f10815h - 1);
        }

        public final int C() {
            return (getWidth() - getPaddingStart()) - getPaddingEnd();
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager
        public View findReferenceChild(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10, boolean z11) {
            return super.findReferenceChild(uVar, yVar, z10, z11);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager
        public void layoutChunk(RecyclerView.u uVar, RecyclerView.y yVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
            boolean z10;
            int f10;
            int i10;
            int i11;
            int i12;
            boolean z11;
            int i13;
            int i14;
            View d10;
            int paddingStart = getPaddingStart() + COUIGridRecyclerView.this.f10819l;
            View[] viewArr = this.f10832d;
            if (viewArr == null || viewArr.length != COUIGridRecyclerView.this.f10815h) {
                this.f10832d = new View[COUIGridRecyclerView.this.f10815h];
            }
            int i15 = 0;
            int i16 = 0;
            while (i16 < COUIGridRecyclerView.this.f10815h && cVar.c(yVar) && (d10 = cVar.d(uVar)) != null) {
                this.f10832d[i16] = d10;
                i16++;
            }
            if (i16 == 0) {
                bVar.f10849b = true;
                return;
            }
            if (cVar.f10856e == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            float f11 = 0.0f;
            int i17 = 0;
            int i18 = 0;
            float f12 = 0.0f;
            while (i17 < COUIGridRecyclerView.this.f10815h) {
                View view = this.f10832d[i17];
                if (view != null) {
                    if (cVar.f10863l == null) {
                        if (z10) {
                            addView(view);
                        } else {
                            addView(view, i15);
                        }
                    } else if (z10) {
                        addDisappearingView(view);
                    } else {
                        addDisappearingView(view, i15);
                    }
                    calculateItemDecorationsForChild(view, this.f10836h);
                    GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                    Rect rect = layoutParams.f10877b;
                    int i19 = rect.top + rect.bottom;
                    if (COUIGridRecyclerView.this.f10820m) {
                        i13 = i15;
                    } else {
                        i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    }
                    int i20 = i19 + i13;
                    int i21 = rect.left + rect.right;
                    if (COUIGridRecyclerView.this.f10820m) {
                        i14 = i15;
                    } else {
                        i14 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                    int i22 = i21 + i14;
                    if (COUIGridRecyclerView.this.f10813f == f11) {
                        COUIGridRecyclerView.this.f10813f = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    }
                    float round = Math.round(f12 + COUIGridRecyclerView.this.f10814g);
                    float f13 = COUIGridRecyclerView.this.f10814g - round;
                    z11 = z10;
                    int childMeasureSpec = RecyclerView.o.getChildMeasureSpec((int) (round + rect.left + rect.right), this.mOrientationHelper.m(), i22, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    view.measure(childMeasureSpec, RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.o(), getHeightMode(), i20, (int) COUIGridRecyclerView.this.f10813f, true));
                    int e10 = this.mOrientationHelper.e(view);
                    Log.d("COUIGridRecyclerView", "childWidthSpec = " + View.MeasureSpec.getSize(childMeasureSpec) + " horizontalInsets = " + i22 + " lp.leftMargin = " + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + "  lp.rightMargin = " + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + " decorInsets = " + rect.left + com.android.incallui.Log.TAG_DELIMETER + rect.right + " mCurrentPosition = " + cVar.f10855d + " x = " + paddingStart);
                    if (e10 > i18) {
                        i18 = e10;
                    }
                    f12 = f13;
                } else {
                    z11 = z10;
                }
                i17++;
                z10 = z11;
                i15 = 0;
                f11 = 0.0f;
            }
            bVar.f10848a = i18;
            int i23 = paddingStart;
            float f14 = 0.0f;
            float f15 = 0.0f;
            for (int i24 = 0; i24 < COUIGridRecyclerView.this.f10815h; i24++) {
                View view2 = this.f10832d[i24];
                if (view2 != null) {
                    GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) view2.getLayoutParams();
                    if (isLayoutRTL()) {
                        int width = getWidth() - i23;
                        f10 = width;
                        i10 = width - this.mOrientationHelper.f(view2);
                    } else {
                        f10 = this.mOrientationHelper.f(view2) + i23;
                        i10 = i23;
                    }
                    if (cVar.f10857f == -1) {
                        int i25 = cVar.f10853b;
                        i12 = i25;
                        i11 = i25 - bVar.f10848a;
                    } else {
                        int i26 = cVar.f10853b;
                        i11 = i26;
                        i12 = bVar.f10848a + i26;
                    }
                    layoutDecoratedWithMargins(view2, i10, i11, f10, i12);
                    int round2 = Math.round(f14 + COUIGridRecyclerView.this.f10814g);
                    float f16 = COUIGridRecyclerView.this.f10814g - round2;
                    int round3 = Math.round(f15 + COUIGridRecyclerView.this.f10808a);
                    float f17 = COUIGridRecyclerView.this.f10808a - round3;
                    i23 = i23 + round3 + round2;
                    if (layoutParams2.c() || layoutParams2.b()) {
                        bVar.f10850c = true;
                    }
                    bVar.f10851d |= view2.hasFocusable();
                    f14 = f16;
                    f15 = f17;
                }
            }
            Arrays.fill(this.f10832d, (Object) null);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
        public void onLayoutChildren(RecyclerView.u uVar, RecyclerView.y yVar) {
            int i10 = COUIGridRecyclerView.this.f10818k;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        B();
                    }
                } else {
                    A();
                }
            } else {
                z();
            }
            if (COUIGridRecyclerView.this.f10815h > 0 && this.f10830b != COUIGridRecyclerView.this.f10815h) {
                v(COUIGridRecyclerView.this.f10815h);
            }
            super.onLayoutChildren(uVar, yVar);
        }

        public final float y() {
            if (COUIGridRecyclerView.this.f10813f != 0.0f) {
                return COUIGridRecyclerView.this.f10813f;
            }
            if (COUIGridRecyclerView.this.f10812e == 0.0f) {
                return 0.0f;
            }
            return (COUIGridRecyclerView.this.f10812e / COUIGridRecyclerView.this.f10811d) * COUIGridRecyclerView.this.f10814g;
        }

        public final void z() {
            MarginType marginType;
            if (COUIGridRecyclerView.this.f10817j == 1) {
                marginType = MarginType.MARGIN_SMALL;
            } else {
                marginType = MarginType.MARGIN_LARGE;
            }
            ResponsiveUIModel chooseMargin = new ResponsiveUIModel(COUIGridRecyclerView.this.getContext(), COUIGridRecyclerView.this.getMeasuredWidth(), 0).chooseMargin(marginType);
            chooseMargin.chooseMargin(marginType);
            COUIGridRecyclerView.this.f10814g = chooseMargin.width(0, r0.f10816i - 1);
            COUIGridRecyclerView.this.f10808a = chooseMargin.gutter();
            COUIGridRecyclerView.this.f10819l = chooseMargin.margin();
            COUIGridRecyclerView.this.f10815h = chooseMargin.columnCount() / COUIGridRecyclerView.this.f10816i;
            Log.d("COUIGridRecyclerView", "mChildWidth = " + COUIGridRecyclerView.this.f10814g + " mHorizontalGap = " + COUIGridRecyclerView.this.f10808a + " mColumn = " + COUIGridRecyclerView.this.f10815h + " mGridPadding = " + COUIGridRecyclerView.this.f10819l + " getWidthWithoutPadding() = " + C());
        }
    }

    /* loaded from: classes.dex */
    public class a extends RecyclerView.n {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
            super.getItemOffsets(rect, view, recyclerView, yVar);
            if (recyclerView.getChildAdapterPosition(view) % COUIGridRecyclerView.this.f10815h != COUIGridRecyclerView.this.f10815h - 1) {
                float childAdapterPosition = (recyclerView.getChildAdapterPosition(view) % COUIGridRecyclerView.this.f10815h) + 1.0f;
                int round = Math.round(Math.round(COUIGridRecyclerView.this.f10808a + ((COUIGridRecyclerView.this.f10808a * childAdapterPosition) - Math.round(COUIGridRecyclerView.this.f10808a * childAdapterPosition))));
                if (COUIGridRecyclerView.this.w()) {
                    rect.left = round;
                } else {
                    rect.right = round;
                }
                Log.d("COUIGridRecyclerView", "   mHorizontalGap = " + COUIGridRecyclerView.this.f10808a + " horizontalGap = " + round + " getChildAdapterPosition = " + recyclerView.getChildAdapterPosition(view) + " outRect = " + rect);
            }
            if (recyclerView.getChildAdapterPosition(view) < COUIGridRecyclerView.this.f10815h * (((int) Math.ceil(recyclerView.mAdapter.getItemCount() / COUIGridRecyclerView.this.f10815h)) - 1)) {
                rect.bottom = (int) COUIGridRecyclerView.this.f10810c;
            }
        }
    }

    public COUIGridRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10820m = true;
        u(attributeSet, 0);
        v();
    }

    @Override // com.coui.appcompat.grid.COUIPercentWidthRecyclerView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        invalidateItemDecorations();
    }

    public void setChildGridNumber(int i10) {
        this.f10816i = i10;
        requestLayout();
    }

    public void setChildHeight(float f10) {
        this.f10813f = f10;
        requestLayout();
    }

    public void setChildMinHeight(float f10) {
        this.f10812e = f10;
        requestLayout();
    }

    public void setChildMinWidth(float f10) {
        this.f10811d = f10;
        requestLayout();
    }

    public void setChildWidth(float f10) {
        this.f10814g = f10;
        requestLayout();
    }

    public void setGridMarginType(int i10) {
        this.f10817j = i10;
        requestLayout();
    }

    public void setHorizontalGap(float f10) {
        this.f10808a = f10;
        requestLayout();
    }

    public void setIsIgnoreChildMargin(boolean z10) {
        this.f10820m = z10;
    }

    public void setMinHorizontalGap(float f10) {
        this.f10809b = f10;
        requestLayout();
    }

    public void setType(int i10) {
        this.f10818k = i10;
        requestLayout();
    }

    public void setVerticalGap(float f10) {
        this.f10810c = f10;
        requestLayout();
    }

    public final void u(AttributeSet attributeSet, int i10) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, X8.o.f5137K1, i10, 0);
            this.f10808a = obtainStyledAttributes.getDimension(X8.o.f5185Q1, 0.0f);
            this.f10809b = obtainStyledAttributes.getDimension(X8.o.f5209T1, 0.0f);
            this.f10810c = obtainStyledAttributes.getDimension(X8.o.f5193R1, 0.0f);
            this.f10811d = obtainStyledAttributes.getDimension(X8.o.f5169O1, 0.0f);
            this.f10812e = obtainStyledAttributes.getDimension(X8.o.f5161N1, 0.0f);
            this.f10813f = obtainStyledAttributes.getDimension(X8.o.f5153M1, 0.0f);
            this.f10814g = obtainStyledAttributes.getDimension(X8.o.f5177P1, 0.0f);
            this.f10816i = obtainStyledAttributes.getInteger(X8.o.f5145L1, 0);
            this.f10817j = obtainStyledAttributes.getInteger(X8.o.f5201S1, 1);
            this.f10818k = obtainStyledAttributes.getInteger(X8.o.f5217U1, -1);
            obtainStyledAttributes.recycle();
        }
    }

    public final void v() {
        setLayoutManager(new COUIGridLayoutManager(getContext()));
        addItemDecoration(new a());
        setPercentIndentEnabled(false);
    }

    public final boolean w() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
