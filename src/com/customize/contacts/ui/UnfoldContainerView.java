package com.customize.contacts.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.contacts.ContactsApplication;
import com.android.contacts.util.m;
import com.oplus.dialer.R;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: UnfoldContainerView.kt */
/* loaded from: classes3.dex */
public final class UnfoldContainerView extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    public static final a f21848j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public View f21849a;

    /* renamed from: b, reason: collision with root package name */
    public View f21850b;

    /* renamed from: c, reason: collision with root package name */
    public View f21851c;

    /* renamed from: d, reason: collision with root package name */
    public View f21852d;

    /* renamed from: e, reason: collision with root package name */
    public int f21853e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21854f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21855g;

    /* renamed from: h, reason: collision with root package name */
    public b f21856h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21857i;

    /* compiled from: UnfoldContainerView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final int a(int i10, int i11, int i12) {
            if (i10 < 0) {
                return 0;
            }
            int i13 = (int) (i10 * 0.4f);
            if (i13 <= i11) {
                if (i13 < i12) {
                    return i12;
                }
                return i13;
            }
            return i11;
        }

        public final int b(int i10, Context context) {
            i.f(context, "context");
            return a(i10, context.getResources().getDimensionPixelSize(R.dimen.DP_360), context.getResources().getDimensionPixelSize(R.dimen.DP_300));
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: UnfoldContainerView.kt */
    /* loaded from: classes3.dex */
    public interface b {
        boolean o();
    }

    /* compiled from: UnfoldContainerView.kt */
    /* loaded from: classes3.dex */
    public interface c {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnfoldContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f21853e = 3;
        b();
    }

    public static final int a(int i10, Context context) {
        return f21848j.b(i10, context);
    }

    public final void b() {
        b bVar;
        Object context = getContext();
        if (context instanceof b) {
            bVar = (b) context;
        } else {
            bVar = null;
        }
        this.f21856h = bVar;
    }

    public final boolean c() {
        return this.f21857i;
    }

    public final void d(boolean z10) {
        View view = null;
        if (z10) {
            View view2 = this.f21852d;
            if (view2 == null) {
                i.q("divider");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this.f21852d;
        if (view3 == null) {
            i.q("divider");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    public final boolean getUseFold() {
        return this.f21855g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f21856h;
        if (bVar != null) {
            d(bVar.o());
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        b bVar = this.f21856h;
        if (bVar != null) {
            d(bVar.o());
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (!this.f21854f) {
            this.f21854f = true;
            View childAt = getChildAt(0);
            i.e(childAt, "getChildAt(0)");
            this.f21849a = childAt;
            View childAt2 = getChildAt(1);
            i.e(childAt2, "getChildAt(1)");
            this.f21850b = childAt2;
            View view = null;
            if (childAt2 == null) {
                i.q("endView");
                childAt2 = null;
            }
            if (childAt2.getId() == R.id.left_right_content) {
                this.f21853e++;
                View view2 = this.f21850b;
                if (view2 == null) {
                    i.q("endView");
                    view2 = null;
                }
                this.f21851c = view2;
                View childAt3 = getChildAt(2);
                i.e(childAt3, "getChildAt(2)");
                this.f21850b = childAt3;
            }
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.contacts_tab_main_status_bar_divider, (ViewGroup) this, false);
            i.e(inflate, "from(context).inflate(R.…bar_divider, this, false)");
            this.f21852d = inflate;
            b bVar = this.f21856h;
            if (bVar != null) {
                d(bVar.o());
            }
            View view3 = this.f21852d;
            if (view3 == null) {
                i.q("divider");
                view3 = null;
            }
            addView(view3);
            View view4 = this.f21849a;
            if (view4 == null) {
                i.q("startView");
                view4 = null;
            }
            ViewGroup.LayoutParams layoutParams = view4.getLayoutParams();
            i.d(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            View view5 = this.f21850b;
            if (view5 == null) {
                i.q("endView");
            } else {
                view = view5;
            }
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            i.d(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            layoutParams2.topMargin = 0;
            ((FrameLayout.LayoutParams) layoutParams3).topMargin = 0;
            View view6 = this.f21851c;
            if (view6 != null) {
                ViewGroup.LayoutParams layoutParams4 = view6.getLayoutParams();
                i.d(layoutParams4, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                ((FrameLayout.LayoutParams) layoutParams4).topMargin = 0;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Object b10;
        String b11;
        try {
            Result.a aVar = Result.f34166a;
            super.onLayout(z10, i10, i11, i12, i13);
            if (getChildCount() == this.f21853e) {
                View view = this.f21850b;
                View view2 = null;
                if (view == null) {
                    i.q("endView");
                    view = null;
                }
                if (view.getVisibility() != 8) {
                    View view3 = this.f21849a;
                    if (view3 == null) {
                        i.q("startView");
                        view3 = null;
                    }
                    int width = view3.getWidth();
                    b bVar = this.f21856h;
                    if (bVar != null && bVar.o()) {
                        View view4 = this.f21852d;
                        if (view4 == null) {
                            i.q("divider");
                            view4 = null;
                        }
                        int width2 = view4.getWidth();
                        if (ContactsApplication.f13094j) {
                            View view5 = this.f21852d;
                            if (view5 == null) {
                                i.q("divider");
                                view5 = null;
                            }
                            View view6 = this.f21852d;
                            if (view6 == null) {
                                i.q("divider");
                                view6 = null;
                            }
                            int left = view6.getLeft() - width;
                            View view7 = this.f21852d;
                            if (view7 == null) {
                                i.q("divider");
                                view7 = null;
                            }
                            int top = view7.getTop();
                            View view8 = this.f21852d;
                            if (view8 == null) {
                                i.q("divider");
                                view8 = null;
                            }
                            int right = view8.getRight() - width;
                            View view9 = this.f21852d;
                            if (view9 == null) {
                                i.q("divider");
                                view9 = null;
                            }
                            view5.layout(left, top, right, view9.getBottom());
                            View view10 = this.f21851c;
                            if (view10 != null) {
                                view10.layout((view10.getLeft() - width) - width2, view10.getTop(), (view10.getRight() - width) - width2, view10.getBottom());
                            }
                            View view11 = this.f21850b;
                            if (view11 == null) {
                                i.q("endView");
                                view11 = null;
                            }
                            View view12 = this.f21850b;
                            if (view12 == null) {
                                i.q("endView");
                                view12 = null;
                            }
                            int left2 = (view12.getLeft() - width) - width2;
                            View view13 = this.f21850b;
                            if (view13 == null) {
                                i.q("endView");
                                view13 = null;
                            }
                            int top2 = view13.getTop();
                            View view14 = this.f21850b;
                            if (view14 == null) {
                                i.q("endView");
                                view14 = null;
                            }
                            int right2 = (view14.getRight() - width) - width2;
                            View view15 = this.f21850b;
                            if (view15 == null) {
                                i.q("endView");
                            } else {
                                view2 = view15;
                            }
                            view11.layout(left2, top2, right2, view2.getBottom());
                        } else {
                            View view16 = this.f21852d;
                            if (view16 == null) {
                                i.q("divider");
                                view16 = null;
                            }
                            View view17 = this.f21852d;
                            if (view17 == null) {
                                i.q("divider");
                                view17 = null;
                            }
                            int left3 = view17.getLeft() + width;
                            View view18 = this.f21852d;
                            if (view18 == null) {
                                i.q("divider");
                                view18 = null;
                            }
                            int top3 = view18.getTop();
                            View view19 = this.f21852d;
                            if (view19 == null) {
                                i.q("divider");
                                view19 = null;
                            }
                            int right3 = view19.getRight() + width;
                            View view20 = this.f21852d;
                            if (view20 == null) {
                                i.q("divider");
                                view20 = null;
                            }
                            view16.layout(left3, top3, right3, view20.getBottom());
                            View view21 = this.f21851c;
                            if (view21 != null) {
                                view21.layout(view21.getLeft() + width + width2, view21.getTop(), view21.getRight() + width + width2, view21.getBottom());
                            }
                            View view22 = this.f21850b;
                            if (view22 == null) {
                                i.q("endView");
                                view22 = null;
                            }
                            View view23 = this.f21850b;
                            if (view23 == null) {
                                i.q("endView");
                                view23 = null;
                            }
                            int left4 = view23.getLeft() + width + width2;
                            View view24 = this.f21850b;
                            if (view24 == null) {
                                i.q("endView");
                                view24 = null;
                            }
                            int top4 = view24.getTop();
                            View view25 = this.f21850b;
                            if (view25 == null) {
                                i.q("endView");
                                view25 = null;
                            }
                            int right4 = view25.getRight() + width + width2;
                            View view26 = this.f21850b;
                            if (view26 == null) {
                                i.q("endView");
                            } else {
                                view2 = view26;
                            }
                            view22.layout(left4, top4, right4, view2.getBottom());
                        }
                    } else if (!this.f21855g) {
                        if (ContactsApplication.f13094j) {
                            View view27 = this.f21851c;
                            if (view27 != null) {
                                view27.layout(view27.getLeft() - width, view27.getTop(), view27.getRight() - width, view27.getBottom());
                            }
                            View view28 = this.f21850b;
                            if (view28 == null) {
                                i.q("endView");
                                view28 = null;
                            }
                            View view29 = this.f21850b;
                            if (view29 == null) {
                                i.q("endView");
                                view29 = null;
                            }
                            int left5 = view29.getLeft() - width;
                            View view30 = this.f21850b;
                            if (view30 == null) {
                                i.q("endView");
                                view30 = null;
                            }
                            int top5 = view30.getTop();
                            View view31 = this.f21850b;
                            if (view31 == null) {
                                i.q("endView");
                                view31 = null;
                            }
                            int right5 = view31.getRight() - width;
                            View view32 = this.f21850b;
                            if (view32 == null) {
                                i.q("endView");
                            } else {
                                view2 = view32;
                            }
                            view28.layout(left5, top5, right5, view2.getBottom());
                        } else {
                            View view33 = this.f21851c;
                            if (view33 != null) {
                                view33.layout(view33.getLeft() + width, view33.getTop(), view33.getRight() + width, view33.getBottom());
                            }
                            View view34 = this.f21850b;
                            if (view34 == null) {
                                i.q("endView");
                                view34 = null;
                            }
                            View view35 = this.f21850b;
                            if (view35 == null) {
                                i.q("endView");
                                view35 = null;
                            }
                            int left6 = view35.getLeft() + width;
                            View view36 = this.f21850b;
                            if (view36 == null) {
                                i.q("endView");
                                view36 = null;
                            }
                            int top6 = view36.getTop();
                            View view37 = this.f21850b;
                            if (view37 == null) {
                                i.q("endView");
                                view37 = null;
                            }
                            int right6 = view37.getRight() + width;
                            View view38 = this.f21850b;
                            if (view38 == null) {
                                i.q("endView");
                            } else {
                                view2 = view38;
                            }
                            view34.layout(left6, top6, right6, view2.getBottom());
                        }
                    }
                }
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            this.f21857i = true;
            H7.b.c("UnfoldContainerView", "onLayout e: " + d10);
            m.a aVar3 = m.f17578b;
            Context context = getContext();
            b11 = m9.b.b(d10);
            aVar3.a(context, "UnfoldContainerView onLayout:" + b11);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int b10;
        super.onMeasure(i10, i11);
        int measuredWidth = (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        b bVar = this.f21856h;
        if (bVar != null && bVar.o() && childCount == this.f21853e) {
            View view = this.f21849a;
            View view2 = null;
            if (view == null) {
                i.q("startView");
                view = null;
            }
            if (view.getVisibility() != 8) {
                View view3 = this.f21850b;
                if (view3 == null) {
                    i.q("endView");
                    view3 = null;
                }
                if (view3.getVisibility() != 8) {
                    View view4 = this.f21852d;
                    if (view4 == null) {
                        i.q("divider");
                        view4 = null;
                    }
                    int measuredWidth2 = view4.getMeasuredWidth();
                    View view5 = this.f21849a;
                    if (view5 == null) {
                        i.q("startView");
                        view5 = null;
                    }
                    ViewGroup.LayoutParams layoutParams = view5.getLayoutParams();
                    i.d(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    View view6 = this.f21850b;
                    if (view6 == null) {
                        i.q("endView");
                        view6 = null;
                    }
                    ViewGroup.LayoutParams layoutParams3 = view6.getLayoutParams();
                    i.d(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                    a aVar = f21848j;
                    b10 = B9.i.b(0, (measuredWidth - layoutParams2.leftMargin) - layoutParams2.rightMargin);
                    Context context = getContext();
                    i.e(context, "context");
                    int b11 = aVar.b(b10, context);
                    int i12 = (((measuredWidth - b11) - layoutParams4.leftMargin) - layoutParams4.rightMargin) - measuredWidth2;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(b11, 1073741824);
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((measuredHeight - layoutParams2.topMargin) - layoutParams2.bottomMargin, 1073741824);
                    View view7 = this.f21849a;
                    if (view7 == null) {
                        i.q("startView");
                        view7 = null;
                    }
                    view7.measure(makeMeasureSpec, makeMeasureSpec2);
                    int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                    int makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec((measuredHeight - layoutParams4.topMargin) - layoutParams4.bottomMargin, 1073741824);
                    View view8 = this.f21850b;
                    if (view8 == null) {
                        i.q("endView");
                    } else {
                        view2 = view8;
                    }
                    view2.measure(makeMeasureSpec3, makeMeasureSpec4);
                    View view9 = this.f21851c;
                    if (view9 != null) {
                        view9.measure(makeMeasureSpec3, makeMeasureSpec4);
                    }
                }
            }
        }
    }

    public final void setErrorState(boolean z10) {
        this.f21857i = z10;
    }

    public final void setOnIsShowUnfoldScreenListener(b listener) {
        i.f(listener, "listener");
        if (this.f21856h == null) {
            this.f21856h = listener;
        }
    }

    public final void setOnVisibilityListener(c listener) {
        i.f(listener, "listener");
    }

    public final void setUseFold(boolean z10) {
        this.f21855g = z10;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }
}
