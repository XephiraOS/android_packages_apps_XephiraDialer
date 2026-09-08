package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.AbstractC0447b;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final f f7564a;

    /* renamed from: b, reason: collision with root package name */
    public final g f7565b;

    /* renamed from: c, reason: collision with root package name */
    public final View f7566c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f7567d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f7568e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f7569f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f7570g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f7571h;

    /* renamed from: i, reason: collision with root package name */
    public final int f7572i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC0447b f7573j;

    /* renamed from: k, reason: collision with root package name */
    public final DataSetObserver f7574k;

    /* renamed from: l, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f7575l;

    /* renamed from: m, reason: collision with root package name */
    public ListPopupWindow f7576m;

    /* renamed from: n, reason: collision with root package name */
    public PopupWindow.OnDismissListener f7577n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7578o;

    /* renamed from: p, reason: collision with root package name */
    public int f7579p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7580q;

    /* renamed from: r, reason: collision with root package name */
    public int f7581r;

    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f7582a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            K v10 = K.v(context, attributeSet, f7582a);
            setBackgroundDrawable(v10.g(0));
            v10.y();
        }
    }

    /* loaded from: classes.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f7564a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f7564a.notifyDataSetInvalidated();
        }
    }

    /* loaded from: classes.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.b()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                AbstractC0447b abstractC0447b = ActivityChooserView.this.f7573j;
                if (abstractC0447b != null) {
                    abstractC0447b.subUiVisibilityChanged(true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends View.AccessibilityDelegate {
        public c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            J.d.O0(accessibilityNodeInfo).e0(true);
        }
    }

    /* loaded from: classes.dex */
    public class d extends x {
        public d(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.x
        public ShowableListMenu getPopup() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.x
        public boolean onForwardingStarted() {
            ActivityChooserView.this.c();
            return true;
        }

        @Override // androidx.appcompat.widget.x
        public boolean onForwardingStopped() {
            ActivityChooserView.this.a();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.e();
        }
    }

    /* loaded from: classes.dex */
    public class f extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public int f7588a = 4;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7589b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7590c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f7591d;

        public f() {
        }

        public int a() {
            throw null;
        }

        public C0429c b() {
            return null;
        }

        public ResolveInfo c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        public boolean e() {
            return this.f7589b;
        }

        public void f(C0429c c0429c) {
            ActivityChooserView.this.f7564a.b();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            throw null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f7589b) {
                throw null;
            }
            throw null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i10) {
            if (this.f7591d && i10 == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view == null || view.getId() != 1) {
                        View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(e.g.f30245f, viewGroup, false);
                        inflate.setId(1);
                        ((TextView) inflate.findViewById(e.f.f30210R)).setText(ActivityChooserView.this.getContext().getString(e.h.f30263c));
                        return inflate;
                    }
                    return view;
                }
                throw new IllegalArgumentException();
            }
            if (view == null || view.getId() != e.f.f30237x) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(e.g.f30245f, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(e.f.f30235v);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i10);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(e.f.f30210R)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f7589b && i10 == 0 && this.f7590c) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    /* loaded from: classes.dex */
    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public g() {
        }

        public final void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f7577n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f7570g) {
                if (view == activityChooserView.f7568e) {
                    activityChooserView.f7578o = false;
                    activityChooserView.d(activityChooserView.f7579p);
                    return;
                }
                throw new IllegalArgumentException();
            }
            activityChooserView.a();
            ActivityChooserView.this.f7564a.c();
            ActivityChooserView.this.f7564a.b();
            throw null;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            AbstractC0447b abstractC0447b = ActivityChooserView.this.f7573j;
            if (abstractC0447b != null) {
                abstractC0447b.subUiVisibilityChanged(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ActivityChooserView.this.d(Integer.MAX_VALUE);
                    return;
                }
                throw new IllegalArgumentException();
            }
            ActivityChooserView.this.a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.f7578o) {
                if (i10 <= 0) {
                    return;
                }
                activityChooserView.f7564a.b();
                throw null;
            }
            activityChooserView.f7564a.e();
            ActivityChooserView.this.f7564a.b();
            throw null;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f7570g) {
                if (activityChooserView.f7564a.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.f7578o = true;
                    activityChooserView2.d(activityChooserView2.f7579p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean a() {
        if (b()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f7575l);
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean b() {
        return getListPopupWindow().isShowing();
    }

    public boolean c() {
        if (b() || !this.f7580q) {
            return false;
        }
        this.f7578o = false;
        d(this.f7579p);
        return true;
    }

    public void d(int i10) {
        this.f7564a.b();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public void e() {
        if (this.f7564a.getCount() > 0) {
            this.f7568e.setEnabled(true);
        } else {
            this.f7568e.setEnabled(false);
        }
        int a10 = this.f7564a.a();
        int d10 = this.f7564a.d();
        if (a10 != 1 && (a10 <= 1 || d10 <= 0)) {
            this.f7570g.setVisibility(8);
        } else {
            this.f7570g.setVisibility(0);
            ResolveInfo c10 = this.f7564a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f7571h.setImageDrawable(c10.loadIcon(packageManager));
            if (this.f7581r != 0) {
                this.f7570g.setContentDescription(getContext().getString(this.f7581r, c10.loadLabel(packageManager)));
            }
        }
        if (this.f7570g.getVisibility() == 0) {
            this.f7566c.setBackgroundDrawable(this.f7567d);
        } else {
            this.f7566c.setBackgroundDrawable(null);
        }
    }

    public C0429c getDataModel() {
        this.f7564a.b();
        return null;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f7576m == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f7576m = listPopupWindow;
            listPopupWindow.k(this.f7564a);
            this.f7576m.y(this);
            this.f7576m.F(true);
            this.f7576m.H(this.f7565b);
            this.f7576m.G(this.f7565b);
        }
        return this.f7576m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7564a.b();
        this.f7580q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7564a.b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f7575l);
        }
        if (b()) {
            a();
        }
        this.f7580q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f7566c.layout(0, 0, i12 - i10, i13 - i11);
        if (!b()) {
            a();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        View view = this.f7566c;
        if (this.f7570g.getVisibility() != 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), 1073741824);
        }
        measureChild(view, i10, i11);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0429c c0429c) {
        this.f7564a.f(c0429c);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i10) {
        this.f7581r = i10;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i10) {
        this.f7569f.setContentDescription(getContext().getString(i10));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f7569f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i10) {
        this.f7579p = i10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f7577n = onDismissListener;
    }

    public void setProvider(AbstractC0447b abstractC0447b) {
        this.f7573j = abstractC0447b;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7574k = new a();
        this.f7575l = new b();
        this.f7579p = 4;
        int[] iArr = e.j.f30302E;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        androidx.core.view.K.h0(this, context, iArr, attributeSet, obtainStyledAttributes, i10, 0);
        this.f7579p = obtainStyledAttributes.getInt(e.j.f30312G, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(e.j.f30307F);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(e.g.f30244e, (ViewGroup) this, true);
        g gVar = new g();
        this.f7565b = gVar;
        View findViewById = findViewById(e.f.f30223j);
        this.f7566c = findViewById;
        this.f7567d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(e.f.f30231r);
        this.f7570g = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        int i11 = e.f.f30236w;
        this.f7571h = (ImageView) frameLayout.findViewById(i11);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(e.f.f30233t);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c());
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f7568e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i11);
        this.f7569f = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.f7564a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f7572i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.d.f30140d));
    }
}
