package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.i;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import androidx.core.view.V;
import androidx.core.view.X;
import androidx.core.view.z;
import com.android.incallui.OplusPhoneUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.g;
import e4.l;
import l4.C1292a;
import s4.C1544c;

/* compiled from: BottomSheetDialog.java */
/* loaded from: classes3.dex */
public class a extends i {
    private C1544c backOrchestrator;
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.g bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private f edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    /* compiled from: BottomSheetDialog.java */
    /* renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0208a implements z {
        public C0208a() {
        }

        @Override // androidx.core.view.z
        public X onApplyWindowInsets(View view, X x10) {
            if (a.this.edgeToEdgeCallback != null) {
                a.this.behavior.removeBottomSheetCallback(a.this.edgeToEdgeCallback);
            }
            if (x10 != null) {
                a aVar = a.this;
                aVar.edgeToEdgeCallback = new f(aVar.bottomSheet, x10, null);
                a.this.edgeToEdgeCallback.b(a.this.getWindow());
                a.this.behavior.addBottomSheetCallback(a.this.edgeToEdgeCallback);
            }
            return x10;
        }
    }

    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.cancelable && aVar.isShowing() && a.this.shouldWindowCloseOnTouchOutside()) {
                a.this.cancel();
            }
        }
    }

    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes3.dex */
    public class c extends C0446a {
        public c() {
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (a.this.cancelable) {
                dVar.a(OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS);
                dVar.m0(true);
            } else {
                dVar.m0(false);
            }
        }

        @Override // androidx.core.view.C0446a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 == 1048576) {
                a aVar = a.this;
                if (aVar.cancelable) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i10, bundle);
        }
    }

    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes3.dex */
    public static class f extends BottomSheetBehavior.g {

        /* renamed from: a, reason: collision with root package name */
        public final Boolean f22841a;

        /* renamed from: b, reason: collision with root package name */
        public final X f22842b;

        /* renamed from: c, reason: collision with root package name */
        public Window f22843c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f22844d;

        public /* synthetic */ f(View view, X x10, C0208a c0208a) {
            this(view, x10);
        }

        public final void a(View view) {
            boolean booleanValue;
            if (view.getTop() < this.f22842b.m()) {
                Window window = this.f22843c;
                if (window != null) {
                    Boolean bool = this.f22841a;
                    if (bool == null) {
                        booleanValue = this.f22844d;
                    } else {
                        booleanValue = bool.booleanValue();
                    }
                    EdgeToEdgeUtils.setLightStatusBar(window, booleanValue);
                }
                view.setPadding(view.getPaddingLeft(), this.f22842b.m() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.f22843c;
                if (window2 != null) {
                    EdgeToEdgeUtils.setLightStatusBar(window2, this.f22844d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public void b(Window window) {
            if (this.f22843c == window) {
                return;
            }
            this.f22843c = window;
            if (window != null) {
                this.f22844d = V.a(window, window.getDecorView()).b();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onLayout(View view) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onSlide(View view, float f10) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onStateChanged(View view, int i10) {
            a(view);
        }

        public f(View view, X x10) {
            ColorStateList o10;
            this.f22842b = x10;
            x4.i materialShapeDrawable = BottomSheetBehavior.from(view).getMaterialShapeDrawable();
            if (materialShapeDrawable != null) {
                o10 = materialShapeDrawable.getFillColor();
            } else {
                o10 = K.o(view);
            }
            if (o10 != null) {
                this.f22841a = Boolean.valueOf(C1292a.h(o10.getDefaultColor()));
                return;
            }
            Integer backgroundColor = ViewUtils.getBackgroundColor(view);
            if (backgroundColor != null) {
                this.f22841a = Boolean.valueOf(C1292a.h(backgroundColor.intValue()));
            } else {
                this.f22841a = null;
            }
        }
    }

    public a(Context context) {
        this(context, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{C0977c.f30626B}).getBoolean(0, false);
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), e4.i.f30922b, null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(g.f30872e);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(g.f30874f);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            from.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
            this.backOrchestrator = new C1544c(this.behavior, this.bottomSheet);
        }
        return this.container;
    }

    private static int getThemeResId(Context context, int i10) {
        if (i10 == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(C0977c.f30665f, typedValue, true)) {
                return typedValue.resourceId;
            }
            return l.f31024g;
        }
        return i10;
    }

    @Deprecated
    public static void setLightStatusBar(View view, boolean z10) {
        int i10;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z10) {
            i10 = systemUiVisibility | 8192;
        } else {
            i10 = systemUiVisibility & (-8193);
        }
        view.setSystemUiVisibility(i10);
    }

    private void updateListeningForBackCallbacks() {
        C1544c c1544c = this.backOrchestrator;
        if (c1544c == null) {
            return;
        }
        if (this.cancelable) {
            c1544c.c();
        } else {
            c1544c.f();
        }
    }

    private View wrapInBottomSheet(int i10, View view, ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(g.f30872e);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, (ViewGroup) coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            K.z0(this.bottomSheet, new C0208a());
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(g.f30903t0).setOnClickListener(new b());
        K.j0(this.bottomSheet, new c());
        this.bottomSheet.setOnTouchListener(new d());
        return this.container;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        if (this.dismissWithAnimation && behavior.getState() != 5) {
            behavior.setState(5);
        } else {
            super.cancel();
        }
    }

    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        boolean z10;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            if (this.edgeToEdgeEnabled && Color.alpha(window.getNavigationBarColor()) < 255) {
                z10 = true;
            } else {
                z10 = false;
            }
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            V.b(window, !z10);
            f fVar = this.edgeToEdgeCallback;
            if (fVar != null) {
                fVar.b(window);
            }
        }
        updateListeningForBackCallbacks();
    }

    @Override // androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        f fVar = this.edgeToEdgeCallback;
        if (fVar != null) {
            fVar.b(null);
        }
        C1544c c1544c = this.backOrchestrator;
        if (c1544c != null) {
            c1544c.f();
        }
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5) {
            this.behavior.setState(4);
        }
    }

    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.cancelable != z10) {
            this.cancelable = z10;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z10);
            }
            if (getWindow() != null) {
                updateListeningForBackCallbacks();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z10;
        this.canceledOnTouchOutsideSet = true;
    }

    @Override // androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void setContentView(int i10) {
        super.setContentView(wrapInBottomSheet(i10, null, null));
    }

    public void setDismissWithAnimation(boolean z10) {
        this.dismissWithAnimation = z10;
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    @Override // androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    @Override // androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public a(Context context, int i10) {
        super(context, getThemeResId(context, i10));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new e();
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{C0977c.f30626B}).getBoolean(0, false);
    }

    public a(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new e();
        supportRequestWindowFeature(1);
        this.cancelable = z10;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{C0977c.f30626B}).getBoolean(0, false);
    }

    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes3.dex */
    public class e extends BottomSheetBehavior.g {
        public e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onStateChanged(View view, int i10) {
            if (i10 == 5) {
                a.this.cancel();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onSlide(View view, float f10) {
        }
    }
}
