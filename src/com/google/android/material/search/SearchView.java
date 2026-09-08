package com.google.android.material.search;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.core.view.z;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.C0979e;
import f.C0991a;
import g.C1027d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import l4.C1292a;
import o4.C1403a;
import s4.C1544c;
import s4.C1548g;
import s4.InterfaceC1543b;

/* loaded from: classes3.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.b, InterfaceC1543b {

    /* renamed from: I, reason: collision with root package name */
    public static final int f23566I = e4.l.f31039v;

    /* renamed from: A, reason: collision with root package name */
    public boolean f23567A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f23568B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f23569C;

    /* renamed from: D, reason: collision with root package name */
    public final int f23570D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f23571E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f23572F;

    /* renamed from: G, reason: collision with root package name */
    public TransitionState f23573G;

    /* renamed from: H, reason: collision with root package name */
    public Map<View, Integer> f23574H;

    /* renamed from: a, reason: collision with root package name */
    public final View f23575a;

    /* renamed from: b, reason: collision with root package name */
    public final ClippableRoundedCornerLayout f23576b;

    /* renamed from: c, reason: collision with root package name */
    public final View f23577c;

    /* renamed from: d, reason: collision with root package name */
    public final View f23578d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f23579e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f23580f;

    /* renamed from: g, reason: collision with root package name */
    public final MaterialToolbar f23581g;

    /* renamed from: h, reason: collision with root package name */
    public final Toolbar f23582h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f23583i;

    /* renamed from: j, reason: collision with root package name */
    public final EditText f23584j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageButton f23585k;

    /* renamed from: l, reason: collision with root package name */
    public final View f23586l;

    /* renamed from: m, reason: collision with root package name */
    public final TouchObserverFrameLayout f23587m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f23588n;

    /* renamed from: o, reason: collision with root package name */
    public final t f23589o;

    /* renamed from: p, reason: collision with root package name */
    public final C1544c f23590p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f23591q;

    /* renamed from: r, reason: collision with root package name */
    public final C1403a f23592r;

    /* renamed from: x, reason: collision with root package name */
    public final Set<b> f23593x;

    /* renamed from: y, reason: collision with root package name */
    public SearchBar f23594y;

    /* renamed from: z, reason: collision with root package name */
    public int f23595z;

    /* loaded from: classes3.dex */
    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            if (!searchView.t() && (view instanceof SearchBar)) {
                searchView.setupWithSearchBar((SearchBar) view);
                return false;
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f23596a;

        /* renamed from: b, reason: collision with root package name */
        public int f23597b;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f23596a);
            parcel.writeInt(this.f23597b);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f23596a = parcel.readString();
            this.f23597b = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes3.dex */
    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(SearchView searchView, TransitionState transitionState, TransitionState transitionState2);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30645Q);
    }

    public static /* synthetic */ boolean A(View view, MotionEvent motionEvent) {
        return true;
    }

    private Window getActivityWindow() {
        Activity activity = ContextUtils.getActivity(getContext());
        if (activity == null) {
            return null;
        }
        return activity.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f23594y;
        if (searchBar != null) {
            return searchBar.getCompatElevation();
        }
        return getResources().getDimension(C0979e.f30751O);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z10) {
        int i10;
        View view = this.f23578d;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    private void setUpBackgroundViewElevationOverlay(float f10) {
        C1403a c1403a = this.f23592r;
        if (c1403a != null && this.f23577c != null) {
            this.f23577c.setBackgroundColor(c1403a.c(this.f23570D, f10));
        }
    }

    private void setUpHeaderLayout(int i10) {
        if (i10 != -1) {
            k(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this.f23579e, false));
        }
    }

    private void setUpStatusBarSpacer(int i10) {
        if (this.f23578d.getLayoutParams().height != i10) {
            this.f23578d.getLayoutParams().height = i10;
            this.f23578d.requestLayout();
        }
    }

    public static /* synthetic */ X z(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, View view, X x10) {
        marginLayoutParams.leftMargin = i10 + x10.k();
        marginLayoutParams.rightMargin = i11 + x10.l();
        return x10;
    }

    public final /* synthetic */ X B(View view, X x10) {
        boolean z10;
        int m10 = x10.m();
        setUpStatusBarSpacer(m10);
        if (!this.f23572F) {
            if (m10 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            setStatusBarSpacerEnabledInternal(z10);
        }
        return x10;
    }

    public final /* synthetic */ X C(View view, X x10, ViewUtils.RelativePadding relativePadding) {
        int i10;
        int i11;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this.f23581g);
        if (isLayoutRtl) {
            i10 = relativePadding.end;
        } else {
            i10 = relativePadding.start;
        }
        if (isLayoutRtl) {
            i11 = relativePadding.start;
        } else {
            i11 = relativePadding.end;
        }
        this.f23581g.setPadding(i10 + x10.k(), relativePadding.top, i11 + x10.l(), relativePadding.bottom);
        return x10;
    }

    public final /* synthetic */ void D(View view) {
        R();
    }

    public void E() {
        this.f23584j.postDelayed(new Runnable() { // from class: com.google.android.material.search.d
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.this.v();
            }
        }, 100L);
    }

    public void F() {
        if (this.f23569C) {
            E();
        }
    }

    public final void G(TransitionState transitionState, boolean z10) {
        if (this.f23573G.equals(transitionState)) {
            return;
        }
        if (z10) {
            if (transitionState == TransitionState.SHOWN) {
                setModalForAccessibility(true);
            } else if (transitionState == TransitionState.HIDDEN) {
                setModalForAccessibility(false);
            }
        }
        TransitionState transitionState2 = this.f23573G;
        this.f23573G = transitionState;
        Iterator it = new LinkedHashSet(this.f23593x).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this, transitionState2, transitionState);
        }
        T(transitionState);
    }

    public final void H(boolean z10, boolean z11) {
        if (z11) {
            this.f23581g.setNavigationIcon((Drawable) null);
            return;
        }
        this.f23581g.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchView.this.w(view);
            }
        });
        if (z10) {
            C1027d c1027d = new C1027d(getContext());
            c1027d.c(C1292a.d(this, C0977c.f30689r));
            this.f23581g.setNavigationIcon(c1027d);
        }
    }

    public final void I() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    public final void J() {
        this.f23585k.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchView.this.x(view);
            }
        });
        this.f23584j.addTextChangedListener(new a());
    }

    public final void K() {
        this.f23587m.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.search.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean y10;
                y10 = SearchView.this.y(view, motionEvent);
                return y10;
            }
        });
    }

    public final void L() {
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f23586l.getLayoutParams();
        final int i10 = marginLayoutParams.leftMargin;
        final int i11 = marginLayoutParams.rightMargin;
        K.z0(this.f23586l, new z() { // from class: com.google.android.material.search.c
            @Override // androidx.core.view.z
            public final X onApplyWindowInsets(View view, X x10) {
                X z10;
                z10 = SearchView.z(marginLayoutParams, i10, i11, view, x10);
                return z10;
            }
        });
    }

    public final void M(int i10, String str, String str2) {
        if (i10 != -1) {
            androidx.core.widget.k.p(this.f23584j, i10);
        }
        this.f23584j.setText(str);
        this.f23584j.setHint(str2);
    }

    public final void N() {
        Q();
        L();
        P();
    }

    public final void O() {
        this.f23576b.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.search.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean A10;
                A10 = SearchView.A(view, motionEvent);
                return A10;
            }
        });
    }

    public final void P() {
        setUpStatusBarSpacer(getStatusBarHeight());
        K.z0(this.f23578d, new z() { // from class: com.google.android.material.search.f
            @Override // androidx.core.view.z
            public final X onApplyWindowInsets(View view, X x10) {
                X B10;
                B10 = SearchView.this.B(view, x10);
                return B10;
            }
        });
    }

    public final void Q() {
        ViewUtils.doOnApplyWindowInsets(this.f23581g, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.search.e
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public final X onApplyWindowInsets(View view, X x10, ViewUtils.RelativePadding relativePadding) {
                X C10;
                C10 = SearchView.this.C(view, x10, relativePadding);
                return C10;
            }
        });
    }

    public void R() {
        if (!this.f23573G.equals(TransitionState.SHOWN) && !this.f23573G.equals(TransitionState.SHOWING)) {
            this.f23589o.Z();
        }
    }

    public final void S(ViewGroup viewGroup, boolean z10) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != this) {
                if (childAt.findViewById(this.f23576b.getId()) != null) {
                    S((ViewGroup) childAt, z10);
                } else if (!z10) {
                    Map<View, Integer> map = this.f23574H;
                    if (map != null && map.containsKey(childAt)) {
                        K.t0(childAt, this.f23574H.get(childAt).intValue());
                    }
                } else {
                    this.f23574H.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    K.t0(childAt, 4);
                }
            }
        }
    }

    public final void T(TransitionState transitionState) {
        if (this.f23594y != null && this.f23591q) {
            if (transitionState.equals(TransitionState.SHOWN)) {
                this.f23590p.c();
            } else if (transitionState.equals(TransitionState.HIDDEN)) {
                this.f23590p.f();
            }
        }
    }

    public final void U() {
        MaterialToolbar materialToolbar = this.f23581g;
        if (materialToolbar == null || s(materialToolbar)) {
            return;
        }
        int defaultNavigationIconResource = getDefaultNavigationIconResource();
        if (this.f23594y == null) {
            this.f23581g.setNavigationIcon(defaultNavigationIconResource);
            return;
        }
        Drawable r10 = C.a.r(C0991a.b(getContext(), defaultNavigationIconResource).mutate());
        if (this.f23581g.getNavigationIconTint() != null) {
            C.a.n(r10, this.f23581g.getNavigationIconTint().intValue());
        }
        this.f23581g.setNavigationIcon(new FadeThroughDrawable(this.f23594y.getNavigationIcon(), r10));
        V();
    }

    public final void V() {
        int i10;
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this.f23581g);
        if (navigationIconButton == null) {
            return;
        }
        if (this.f23576b.getVisibility() == 0) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        Drawable q10 = C.a.q(navigationIconButton.getDrawable());
        if (q10 instanceof C1027d) {
            ((C1027d) q10).e(i10);
        }
        if (q10 instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) q10).setProgress(i10);
        }
    }

    public void W() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f23595z = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f23588n) {
            this.f23587m.addView(view, i10, layoutParams);
        } else {
            super.addView(view, i10, layoutParams);
        }
    }

    @Override // s4.InterfaceC1543b
    public void cancelBackProgress() {
        if (!q() && this.f23594y != null) {
            this.f23589o.o();
        }
    }

    public C1548g getBackHelper() {
        return this.f23589o.r();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    public TransitionState getCurrentTransitionState() {
        return this.f23573G;
    }

    public int getDefaultNavigationIconResource() {
        return e4.f.f30825b;
    }

    public EditText getEditText() {
        return this.f23584j;
    }

    public CharSequence getHint() {
        return this.f23584j.getHint();
    }

    public TextView getSearchPrefix() {
        return this.f23583i;
    }

    public CharSequence getSearchPrefixText() {
        return this.f23583i.getText();
    }

    public int getSoftInputMode() {
        return this.f23595z;
    }

    public Editable getText() {
        return this.f23584j.getText();
    }

    public Toolbar getToolbar() {
        return this.f23581g;
    }

    @Override // s4.InterfaceC1543b
    public void handleBackInvoked() {
        if (q()) {
            return;
        }
        androidx.activity.b S10 = this.f23589o.S();
        if (this.f23594y != null && S10 != null) {
            this.f23589o.p();
        } else {
            n();
        }
    }

    public void k(View view) {
        this.f23579e.addView(view);
        this.f23579e.setVisibility(0);
    }

    public void l() {
        this.f23584j.post(new Runnable() { // from class: com.google.android.material.search.l
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.this.u();
            }
        });
    }

    public void m() {
        this.f23584j.setText("");
    }

    public void n() {
        if (!this.f23573G.equals(TransitionState.HIDDEN) && !this.f23573G.equals(TransitionState.HIDING)) {
            this.f23589o.M();
        }
    }

    public boolean o() {
        if (this.f23595z == 48) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x4.j.e(this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        W();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean z10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.f23596a);
        if (savedState.f23597b == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        setVisible(z10);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        String charSequence;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        if (text == null) {
            charSequence = null;
        } else {
            charSequence = text.toString();
        }
        savedState.f23596a = charSequence;
        savedState.f23597b = this.f23576b.getVisibility();
        return savedState;
    }

    public boolean p() {
        return this.f23567A;
    }

    public final boolean q() {
        if (!this.f23573G.equals(TransitionState.HIDDEN) && !this.f23573G.equals(TransitionState.HIDING)) {
            return false;
        }
        return true;
    }

    public boolean r() {
        return this.f23568B;
    }

    public final boolean s(Toolbar toolbar) {
        return C.a.q(toolbar.getNavigationIcon()) instanceof C1027d;
    }

    public void setAnimatedNavigationIcon(boolean z10) {
        this.f23567A = z10;
    }

    public void setAutoShowKeyboard(boolean z10) {
        this.f23569C = z10;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        setUpBackgroundViewElevationOverlay(f10);
    }

    public void setHint(CharSequence charSequence) {
        this.f23584j.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z10) {
        this.f23568B = z10;
    }

    public void setModalForAccessibility(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z10) {
            this.f23574H = new HashMap(viewGroup.getChildCount());
        }
        S(viewGroup, z10);
        if (!z10) {
            this.f23574H = null;
        }
    }

    public void setOnMenuItemClickListener(Toolbar.g gVar) {
        this.f23581g.setOnMenuItemClickListener(gVar);
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        int i10;
        this.f23583i.setText(charSequence);
        TextView textView = this.f23583i;
        if (TextUtils.isEmpty(charSequence)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    public void setStatusBarSpacerEnabled(boolean z10) {
        this.f23572F = true;
        setStatusBarSpacerEnabledInternal(z10);
    }

    public void setText(CharSequence charSequence) {
        this.f23584j.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z10) {
        this.f23581g.setTouchscreenBlocksFocus(z10);
    }

    public void setTransitionState(TransitionState transitionState) {
        G(transitionState, true);
    }

    public void setUseWindowInsetsController(boolean z10) {
        this.f23571E = z10;
    }

    public void setVisible(boolean z10) {
        boolean z11;
        int i10;
        TransitionState transitionState;
        boolean z12 = true;
        if (this.f23576b.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f23576b;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        clippableRoundedCornerLayout.setVisibility(i10);
        V();
        if (z10) {
            transitionState = TransitionState.SHOWN;
        } else {
            transitionState = TransitionState.HIDDEN;
        }
        if (z11 == z10) {
            z12 = false;
        }
        G(transitionState, z12);
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f23594y = searchBar;
        this.f23589o.X(searchBar);
        if (searchBar != null) {
            searchBar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchView.this.D(view);
                }
            });
            try {
                searchBar.setHandwritingDelegatorCallback(new Runnable() { // from class: com.google.android.material.search.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchView.this.R();
                    }
                });
                this.f23584j.setIsHandwritingDelegate(true);
            } catch (LinkageError unused) {
            }
        }
        U();
        I();
        T(getCurrentTransitionState());
    }

    @Override // s4.InterfaceC1543b
    public void startBackProgress(androidx.activity.b bVar) {
        if (!q() && this.f23594y != null) {
            this.f23589o.a0(bVar);
        }
    }

    public boolean t() {
        if (this.f23594y != null) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void u() {
        this.f23584j.clearFocus();
        SearchBar searchBar = this.f23594y;
        if (searchBar != null) {
            searchBar.requestFocus();
        }
        ViewUtils.hideKeyboard(this.f23584j, this.f23571E);
    }

    @Override // s4.InterfaceC1543b
    public void updateBackProgress(androidx.activity.b bVar) {
        if (!q() && this.f23594y != null) {
            this.f23589o.f0(bVar);
        }
    }

    public final /* synthetic */ void v() {
        if (this.f23584j.requestFocus()) {
            this.f23584j.sendAccessibilityEvent(8);
        }
        ViewUtils.showKeyboard(this.f23584j, this.f23571E);
    }

    public final /* synthetic */ void w(View view) {
        n();
    }

    public final /* synthetic */ void x(View view) {
        m();
        F();
    }

    public final /* synthetic */ boolean y(View view, MotionEvent motionEvent) {
        if (o()) {
            l();
            return false;
        }
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SearchView(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setHint(int i10) {
        this.f23584j.setHint(i10);
    }

    public void setText(int i10) {
        this.f23584j.setText(i10);
    }

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            int i13;
            ImageButton imageButton = SearchView.this.f23585k;
            if (charSequence.length() > 0) {
                i13 = 0;
            } else {
                i13 = 8;
            }
            imageButton.setVisibility(i13);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
