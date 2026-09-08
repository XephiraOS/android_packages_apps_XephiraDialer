package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ShowableListMenu;
import e.C0961a;

/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {

    /* renamed from: A, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f7728A;

    /* renamed from: B, reason: collision with root package name */
    public final i f7729B;

    /* renamed from: C, reason: collision with root package name */
    public final h f7730C;

    /* renamed from: D, reason: collision with root package name */
    public final g f7731D;

    /* renamed from: E, reason: collision with root package name */
    public final e f7732E;

    /* renamed from: F, reason: collision with root package name */
    public Runnable f7733F;

    /* renamed from: G, reason: collision with root package name */
    public final Handler f7734G;

    /* renamed from: H, reason: collision with root package name */
    public final Rect f7735H;

    /* renamed from: I, reason: collision with root package name */
    public Rect f7736I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f7737J;

    /* renamed from: K, reason: collision with root package name */
    public PopupWindow f7738K;

    /* renamed from: a, reason: collision with root package name */
    public Context f7739a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f7740b;

    /* renamed from: c, reason: collision with root package name */
    public v f7741c;

    /* renamed from: d, reason: collision with root package name */
    public int f7742d;

    /* renamed from: e, reason: collision with root package name */
    public int f7743e;

    /* renamed from: f, reason: collision with root package name */
    public int f7744f;

    /* renamed from: g, reason: collision with root package name */
    public int f7745g;

    /* renamed from: h, reason: collision with root package name */
    public int f7746h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7747i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7748j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7749k;

    /* renamed from: l, reason: collision with root package name */
    public int f7750l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7751m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7752n;

    /* renamed from: o, reason: collision with root package name */
    public int f7753o;

    /* renamed from: p, reason: collision with root package name */
    public View f7754p;

    /* renamed from: q, reason: collision with root package name */
    public int f7755q;

    /* renamed from: r, reason: collision with root package name */
    public DataSetObserver f7756r;

    /* renamed from: x, reason: collision with root package name */
    public View f7757x;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f7758y;

    /* renamed from: z, reason: collision with root package name */
    public AdapterView.OnItemClickListener f7759z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View o10 = ListPopupWindow.this.o();
            if (o10 != null && o10.getWindowToken() != null) {
                ListPopupWindow.this.show();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.m();
        }
    }

    /* loaded from: classes.dex */
    public class f extends DataSetObserver {
        public f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnTouchListener {
        public h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.f7738K) != null && popupWindow.isShowing() && x10 >= 0 && x10 < ListPopupWindow.this.f7738K.getWidth() && y10 >= 0 && y10 < ListPopupWindow.this.f7738K.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f7734G.postDelayed(listPopupWindow.f7729B, 250L);
                return false;
            }
            if (action == 1) {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.f7734G.removeCallbacks(listPopupWindow2.f7729B);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = ListPopupWindow.this.f7741c;
            if (vVar != null && vVar.isAttachedToWindow() && ListPopupWindow.this.f7741c.getCount() > ListPopupWindow.this.f7741c.getChildCount()) {
                int childCount = ListPopupWindow.this.f7741c.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.f7753o) {
                    listPopupWindow.f7738K.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, C0961a.f30089G);
    }

    public void A(int i10) {
        Drawable background = this.f7738K.getBackground();
        if (background != null) {
            background.getPadding(this.f7735H);
            Rect rect = this.f7735H;
            this.f7743e = rect.left + rect.right + i10;
            return;
        }
        N(i10);
    }

    public void B(int i10) {
        this.f7750l = i10;
    }

    public void C(Rect rect) {
        Rect rect2;
        if (rect != null) {
            rect2 = new Rect(rect);
        } else {
            rect2 = null;
        }
        this.f7736I = rect2;
    }

    public void D(int i10) {
        if (i10 < 0 && -2 != i10 && -1 != i10) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.f7742d = i10;
    }

    public void E(int i10) {
        this.f7738K.setInputMethodMode(i10);
    }

    public void F(boolean z10) {
        this.f7737J = z10;
        this.f7738K.setFocusable(z10);
    }

    public void G(PopupWindow.OnDismissListener onDismissListener) {
        this.f7738K.setOnDismissListener(onDismissListener);
    }

    public void H(AdapterView.OnItemClickListener onItemClickListener) {
        this.f7759z = onItemClickListener;
    }

    public void I(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f7728A = onItemSelectedListener;
    }

    public void J(boolean z10) {
        this.f7749k = true;
        this.f7748j = z10;
    }

    public final void K(boolean z10) {
        d.b(this.f7738K, z10);
    }

    public void L(int i10) {
        this.f7755q = i10;
    }

    public void M(int i10) {
        v vVar = this.f7741c;
        if (isShowing() && vVar != null) {
            vVar.setListSelectionHidden(false);
            vVar.setSelection(i10);
            if (vVar.getChoiceMode() != 0) {
                vVar.setItemChecked(i10, true);
            }
        }
    }

    public void N(int i10) {
        this.f7743e = i10;
    }

    public void a(Drawable drawable) {
        this.f7738K.setBackgroundDrawable(drawable);
    }

    public int b() {
        return this.f7744f;
    }

    public void c(int i10) {
        this.f7744f = i10;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.f7738K.dismiss();
        x();
        this.f7738K.setContentView(null);
        this.f7741c = null;
        this.f7734G.removeCallbacks(this.f7729B);
    }

    public Drawable e() {
        return this.f7738K.getBackground();
    }

    public void g(int i10) {
        this.f7745g = i10;
        this.f7747i = true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.f7741c;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.f7738K.isShowing();
    }

    public int j() {
        if (!this.f7747i) {
            return 0;
        }
        return this.f7745g;
    }

    public void k(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f7756r;
        if (dataSetObserver == null) {
            this.f7756r = new f();
        } else {
            ListAdapter listAdapter2 = this.f7740b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f7740b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f7756r);
        }
        v vVar = this.f7741c;
        if (vVar != null) {
            vVar.setAdapter(this.f7740b);
        }
    }

    public final int l() {
        int i10;
        int i11;
        int makeMeasureSpec;
        int i12;
        boolean z10 = true;
        if (this.f7741c == null) {
            Context context = this.f7739a;
            this.f7733F = new a();
            v n10 = n(context, !this.f7737J);
            this.f7741c = n10;
            Drawable drawable = this.f7758y;
            if (drawable != null) {
                n10.setSelector(drawable);
            }
            this.f7741c.setAdapter(this.f7740b);
            this.f7741c.setOnItemClickListener(this.f7759z);
            this.f7741c.setFocusable(true);
            this.f7741c.setFocusableInTouchMode(true);
            this.f7741c.setOnItemSelectedListener(new b());
            this.f7741c.setOnScrollListener(this.f7731D);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f7728A;
            if (onItemSelectedListener != null) {
                this.f7741c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f7741c;
            View view2 = this.f7754p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i13 = this.f7755q;
                if (i13 != 0) {
                    if (i13 != 1) {
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f7755q);
                    } else {
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                    }
                } else {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                }
                int i14 = this.f7743e;
                if (i14 >= 0) {
                    i12 = Integer.MIN_VALUE;
                } else {
                    i14 = 0;
                    i12 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i14, i12), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i10 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i10 = 0;
            }
            this.f7738K.setContentView(view);
        } else {
            View view3 = this.f7754p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i10 = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i10 = 0;
            }
        }
        Drawable background = this.f7738K.getBackground();
        if (background != null) {
            background.getPadding(this.f7735H);
            Rect rect = this.f7735H;
            int i15 = rect.top;
            i11 = rect.bottom + i15;
            if (!this.f7747i) {
                this.f7745g = -i15;
            }
        } else {
            this.f7735H.setEmpty();
            i11 = 0;
        }
        if (this.f7738K.getInputMethodMode() != 2) {
            z10 = false;
        }
        int p10 = p(o(), this.f7745g, z10);
        if (!this.f7751m && this.f7742d != -1) {
            int i16 = this.f7743e;
            if (i16 != -2) {
                if (i16 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                } else {
                    int i17 = this.f7739a.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.f7735H;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - (rect2.left + rect2.right), 1073741824);
                }
            } else {
                int i18 = this.f7739a.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.f7735H;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - (rect3.left + rect3.right), Integer.MIN_VALUE);
            }
            int d10 = this.f7741c.d(makeMeasureSpec, 0, -1, p10 - i10, -1);
            if (d10 > 0) {
                i10 += i11 + this.f7741c.getPaddingTop() + this.f7741c.getPaddingBottom();
            }
            return d10 + i10;
        }
        return p10 + i11;
    }

    public void m() {
        v vVar = this.f7741c;
        if (vVar != null) {
            vVar.setListSelectionHidden(true);
            vVar.requestLayout();
        }
    }

    public v n(Context context, boolean z10) {
        return new v(context, z10);
    }

    public View o() {
        return this.f7757x;
    }

    public final int p(View view, int i10, boolean z10) {
        return c.a(this.f7738K, view, i10, z10);
    }

    public Object q() {
        if (!isShowing()) {
            return null;
        }
        return this.f7741c.getSelectedItem();
    }

    public long r() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.f7741c.getSelectedItemId();
    }

    public int s() {
        if (!isShowing()) {
            return -1;
        }
        return this.f7741c.getSelectedItemPosition();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int i10;
        int i11;
        int i12;
        int i13;
        int l10 = l();
        boolean v10 = v();
        androidx.core.widget.j.b(this.f7738K, this.f7746h);
        boolean z10 = true;
        if (this.f7738K.isShowing()) {
            if (!o().isAttachedToWindow()) {
                return;
            }
            int i14 = this.f7743e;
            if (i14 == -1) {
                i14 = -1;
            } else if (i14 == -2) {
                i14 = o().getWidth();
            }
            int i15 = this.f7742d;
            if (i15 == -1) {
                if (!v10) {
                    l10 = -1;
                }
                if (v10) {
                    PopupWindow popupWindow = this.f7738K;
                    if (this.f7743e == -1) {
                        i13 = -1;
                    } else {
                        i13 = 0;
                    }
                    popupWindow.setWidth(i13);
                    this.f7738K.setHeight(0);
                } else {
                    PopupWindow popupWindow2 = this.f7738K;
                    if (this.f7743e == -1) {
                        i12 = -1;
                    } else {
                        i12 = 0;
                    }
                    popupWindow2.setWidth(i12);
                    this.f7738K.setHeight(-1);
                }
            } else if (i15 != -2) {
                l10 = i15;
            }
            PopupWindow popupWindow3 = this.f7738K;
            if (this.f7752n || this.f7751m) {
                z10 = false;
            }
            popupWindow3.setOutsideTouchable(z10);
            PopupWindow popupWindow4 = this.f7738K;
            View o10 = o();
            int i16 = this.f7744f;
            int i17 = this.f7745g;
            if (i14 < 0) {
                i10 = -1;
            } else {
                i10 = i14;
            }
            if (l10 < 0) {
                i11 = -1;
            } else {
                i11 = l10;
            }
            popupWindow4.update(o10, i16, i17, i10, i11);
            return;
        }
        int i18 = this.f7743e;
        if (i18 == -1) {
            i18 = -1;
        } else if (i18 == -2) {
            i18 = o().getWidth();
        }
        int i19 = this.f7742d;
        if (i19 == -1) {
            l10 = -1;
        } else if (i19 != -2) {
            l10 = i19;
        }
        this.f7738K.setWidth(i18);
        this.f7738K.setHeight(l10);
        K(true);
        PopupWindow popupWindow5 = this.f7738K;
        if (this.f7752n || this.f7751m) {
            z10 = false;
        }
        popupWindow5.setOutsideTouchable(z10);
        this.f7738K.setTouchInterceptor(this.f7730C);
        if (this.f7749k) {
            androidx.core.widget.j.a(this.f7738K, this.f7748j);
        }
        d.a(this.f7738K, this.f7736I);
        androidx.core.widget.j.c(this.f7738K, o(), this.f7744f, this.f7745g, this.f7750l);
        this.f7741c.setSelection(-1);
        if (!this.f7737J || this.f7741c.isInTouchMode()) {
            m();
        }
        if (!this.f7737J) {
            this.f7734G.post(this.f7732E);
        }
    }

    public View t() {
        if (!isShowing()) {
            return null;
        }
        return this.f7741c.getSelectedView();
    }

    public int u() {
        return this.f7743e;
    }

    public boolean v() {
        if (this.f7738K.getInputMethodMode() == 2) {
            return true;
        }
        return false;
    }

    public boolean w() {
        return this.f7737J;
    }

    public final void x() {
        View view = this.f7754p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f7754p);
            }
        }
    }

    public void y(View view) {
        this.f7757x = view;
    }

    public void z(int i10) {
        this.f7738K.setAnimationStyle(i10);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30089G);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f7742d = -2;
        this.f7743e = -2;
        this.f7746h = 1002;
        this.f7750l = 0;
        this.f7751m = false;
        this.f7752n = false;
        this.f7753o = Integer.MAX_VALUE;
        this.f7755q = 0;
        this.f7729B = new i();
        this.f7730C = new h();
        this.f7731D = new g();
        this.f7732E = new e();
        this.f7735H = new Rect();
        this.f7739a = context;
        this.f7734G = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f30522v1, i10, i11);
        this.f7744f = obtainStyledAttributes.getDimensionPixelOffset(e.j.f30527w1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(e.j.f30532x1, 0);
        this.f7745g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f7747i = true;
        }
        obtainStyledAttributes.recycle();
        C0438l c0438l = new C0438l(context, attributeSet, i10, i11);
        this.f7738K = c0438l;
        c0438l.setInputMethodMode(1);
    }

    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            v vVar;
            if (i10 != -1 && (vVar = ListPopupWindow.this.f7741c) != null) {
                vVar.setListSelectionHidden(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes.dex */
    public class g implements AbsListView.OnScrollListener {
        public g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 1 && !ListPopupWindow.this.v() && ListPopupWindow.this.f7738K.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f7734G.removeCallbacks(listPopupWindow.f7729B);
                ListPopupWindow.this.f7729B.run();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }
    }
}
