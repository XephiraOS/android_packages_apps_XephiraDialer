package com.coui.appcompat.scanview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: COUIFullscreenScanView.kt */
/* loaded from: classes.dex */
public final class COUIFullscreenScanView extends ConstraintLayout {
    public static final Companion Companion = new Companion(null);
    private static final String EMPTY_STRING = "";
    private static final String TAG = "COUIFullscreenScanView";
    private final RotateLottieAnimationView albumIcon;
    private final View cancelIcon;
    private final TextView description;
    private final m9.d finderHolder$delegate;
    private final FinderView finderView;
    private final ConstraintLayout iconContainer;
    private boolean isAlbumVisible;
    private boolean isInitialized;
    private boolean isTorchVisible;
    private View.OnClickListener onClickAlbumListener;
    private OnTorchStateChangeListener onTorchStateChangeListener;
    private final FrameLayout previewHolder;
    private final ConstraintLayout rotateContentContainer;
    private final RotateIconHelper rotateIconHelper;
    private final m9.d scanViewRotateHelper$delegate;
    private boolean shouldShowFinderView;
    private boolean showTorchTip;
    private final TextView title;
    private final RotateLottieAnimationView torchIcon;
    private final TorchTipGroup torchTipGroup;

    /* compiled from: COUIFullscreenScanView.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIFullscreenScanView(Context context) {
        this(context, null, 0, 0, 14, null);
        i.f(context, "context");
    }

    private final int getDimenPx(View view, int i10) {
        return view.getContext().getResources().getDimensionPixelSize(i10);
    }

    private final FrameLayout getFinderHolder() {
        Object value = this.finderHolder$delegate.getValue();
        i.e(value, "<get-finderHolder>(...)");
        return (FrameLayout) value;
    }

    private final ScanViewRotateHelper getScanViewRotateHelper() {
        return (ScanViewRotateHelper) this.scanViewRotateHelper$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDark$lambda$8(COUIFullscreenScanView this$0) {
        i.f(this$0, "this$0");
        this$0.torchTipGroup.disappear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDark$lambda$9(COUIFullscreenScanView this$0) {
        i.f(this$0, "this$0");
        this$0.torchTipGroup.showBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLight$lambda$10(COUIFullscreenScanView this$0) {
        i.f(this$0, "this$0");
        this$0.torchTipGroup.disappear();
    }

    private final void updateContentAndVisibility(TextView textView, CharSequence charSequence) {
        updateContentAndVisibility(textView, charSequence, textView);
    }

    public final void adjustIconLayout$coui_support_component_release() {
        if (!this.isInitialized) {
            return;
        }
        ConstraintLayout constraintLayout = this.iconContainer;
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ScanViewRotateHelper scanViewRotateHelper = getScanViewRotateHelper();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = Integer.valueOf(((int) scanViewRotateHelper.getDirectionAwareWidth$coui_support_component_release(scanViewRotateHelper.getOrientation$coui_support_component_release())) - (getDimenPx(this, Z8.c.f5998S) * 2)).intValue();
            constraintLayout.setLayoutParams(layoutParams2);
            if (this.isAlbumVisible && this.isTorchVisible) {
                RotateLottieAnimationView rotateLottieAnimationView = this.albumIcon;
                ViewGroup.LayoutParams layoutParams3 = rotateLottieAnimationView.getLayoutParams();
                if (layoutParams3 != null) {
                    ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                    layoutParams4.endToEnd = -1;
                    rotateLottieAnimationView.setLayoutParams(layoutParams4);
                    RotateLottieAnimationView rotateLottieAnimationView2 = this.torchIcon;
                    ViewGroup.LayoutParams layoutParams5 = rotateLottieAnimationView2.getLayoutParams();
                    if (layoutParams5 != null) {
                        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                        layoutParams6.startToStart = -1;
                        rotateLottieAnimationView2.setLayoutParams(layoutParams6);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
            }
            if (this.isAlbumVisible ^ this.isTorchVisible) {
                RotateLottieAnimationView rotateLottieAnimationView3 = this.albumIcon;
                ViewGroup.LayoutParams layoutParams7 = rotateLottieAnimationView3.getLayoutParams();
                if (layoutParams7 != null) {
                    ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
                    layoutParams8.endToEnd = 0;
                    rotateLottieAnimationView3.setLayoutParams(layoutParams8);
                    RotateLottieAnimationView rotateLottieAnimationView4 = this.torchIcon;
                    ViewGroup.LayoutParams layoutParams9 = rotateLottieAnimationView4.getLayoutParams();
                    if (layoutParams9 != null) {
                        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) layoutParams9;
                        layoutParams10.startToStart = 0;
                        rotateLottieAnimationView4.setLayoutParams(layoutParams10);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final View.OnClickListener getOnClickAlbumListener() {
        return this.onClickAlbumListener;
    }

    public final OnTorchStateChangeListener getOnTorchStateChangeListener() {
        return this.onTorchStateChangeListener;
    }

    public final boolean getShouldShowFinderView() {
        return this.shouldShowFinderView;
    }

    public final boolean getShowTorchTip() {
        return this.showTorchTip;
    }

    public final TorchTipGroup getTorchTipGroup$coui_support_component_release() {
        return this.torchTipGroup;
    }

    public final boolean isAlbumVisible() {
        return this.isAlbumVisible;
    }

    public final boolean isTorchVisible() {
        return this.isTorchVisible;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getScanViewRotateHelper().registerListener$coui_support_component_release();
    }

    public final void onDark() {
        if (this.rotateIconHelper.isTorchOn()) {
            post(new Runnable() { // from class: com.coui.appcompat.scanview.a
                @Override // java.lang.Runnable
                public final void run() {
                    COUIFullscreenScanView.onDark$lambda$8(COUIFullscreenScanView.this);
                }
            });
        } else {
            post(new Runnable() { // from class: com.coui.appcompat.scanview.b
                @Override // java.lang.Runnable
                public final void run() {
                    COUIFullscreenScanView.onDark$lambda$9(COUIFullscreenScanView.this);
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getScanViewRotateHelper().unregisterListener$coui_support_component_release();
    }

    public final void onLight() {
        post(new Runnable() { // from class: com.coui.appcompat.scanview.c
            @Override // java.lang.Runnable
            public final void run() {
                COUIFullscreenScanView.onLight$lambda$10(COUIFullscreenScanView.this);
            }
        });
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 == 0) {
            getScanViewRotateHelper().registerListener$coui_support_component_release();
        } else {
            getScanViewRotateHelper().unregisterListener$coui_support_component_release();
        }
    }

    public final void setAlbumVisible(boolean z10) {
        int i10;
        this.isAlbumVisible = z10;
        RotateLottieAnimationView rotateLottieAnimationView = this.albumIcon;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        rotateLottieAnimationView.setVisibility(i10);
        adjustIconLayout$coui_support_component_release();
    }

    public final void setDescription(CharSequence content) {
        i.f(content, "content");
        this.description.setText(content);
        getScanViewRotateHelper().init();
    }

    public final void setFinderView(View finderView) {
        i.f(finderView, "finderView");
        getFinderHolder().removeAllViews();
        FrameLayout finderHolder = getFinderHolder();
        finderView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        finderHolder.addView(finderView);
    }

    public final void setOnClickAlbumListener(View.OnClickListener onClickListener) {
        this.onClickAlbumListener = onClickListener;
        if (onClickListener != null) {
            this.rotateIconHelper.bindAlbumIconTorchEvent(this.albumIcon, onClickListener);
        }
    }

    public final void setOnExitClickListener(View.OnClickListener onClickListener) {
        i.f(onClickListener, "onClickListener");
        this.cancelIcon.setOnClickListener(onClickListener);
    }

    public final void setOnTorchStateChangeListener(OnTorchStateChangeListener onTorchStateChangeListener) {
        this.onTorchStateChangeListener = onTorchStateChangeListener;
        if (onTorchStateChangeListener != null) {
            this.rotateIconHelper.bindTorchIconTouchEvent(this.torchIcon, onTorchStateChangeListener);
            this.rotateIconHelper.bindTorchTipTouchEvent(this.torchTipGroup, this.torchIcon, onTorchStateChangeListener);
        }
    }

    public final void setPreviewView(View previewView) {
        i.f(previewView, "previewView");
        this.previewHolder.removeAllViews();
        FrameLayout frameLayout = this.previewHolder;
        previewView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(previewView);
    }

    public final void setShouldShowFinderView(boolean z10) {
        this.shouldShowFinderView = z10;
        setShowFinderView(z10);
    }

    public final void setShowFinderView(boolean z10) {
        if (z10) {
            setFinderView(this.finderView);
        } else {
            getFinderHolder().removeAllViews();
        }
    }

    public final void setShowTorchTip(boolean z10) {
        this.showTorchTip = z10;
        this.torchTipGroup.setShowTorchTip(z10);
        if (!z10) {
            this.torchTipGroup.disappear();
        }
    }

    public final void setTitle(CharSequence content) {
        i.f(content, "content");
        this.title.setText(content);
    }

    public final void setTorchState(boolean z10) {
        float f10;
        this.rotateIconHelper.setTorchOn(z10);
        RotateLottieAnimationView rotateLottieAnimationView = this.torchIcon;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        rotateLottieAnimationView.setProgress(f10);
    }

    public final void setTorchTip(CharSequence content) {
        i.f(content, "content");
        this.torchTipGroup.setTorchTip(content);
        getScanViewRotateHelper().init();
    }

    public final void setTorchVisible(boolean z10) {
        int i10;
        this.isTorchVisible = z10;
        RotateLottieAnimationView rotateLottieAnimationView = this.torchIcon;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        rotateLottieAnimationView.setVisibility(i10);
        adjustIconLayout$coui_support_component_release();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIFullscreenScanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    private final void updateContentAndVisibility(TextView textView, CharSequence charSequence, View view) {
        if (charSequence != null && charSequence.length() != 0) {
            view.setVisibility(0);
            textView.setText(charSequence);
        } else {
            view.setVisibility(8);
        }
    }

    public final void setTitle(int i10) {
        this.title.setText(i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIFullscreenScanView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        i.f(context, "context");
    }

    public final void setDescription(int i10) {
        this.description.setText(i10);
        getScanViewRotateHelper().init();
    }

    public final void setTorchTip(int i10) {
        this.torchTipGroup.setTorchTip(i10);
        getScanViewRotateHelper().init();
    }

    public /* synthetic */ COUIFullscreenScanView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIFullscreenScanView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        m9.d b10;
        m9.d b11;
        int dimenPx;
        i.f(context, "context");
        this.isAlbumVisible = true;
        this.isTorchVisible = true;
        TorchTipGroup torchTipGroup = new TorchTipGroup(context);
        this.torchTipGroup = torchTipGroup;
        b10 = kotlin.a.b(new InterfaceC1637a<ScanViewRotateHelper>() { // from class: com.coui.appcompat.scanview.COUIFullscreenScanView$scanViewRotateHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final ScanViewRotateHelper invoke() {
                return new ScanViewRotateHelper(COUIFullscreenScanView.this);
            }
        });
        this.scanViewRotateHelper$delegate = b10;
        this.rotateIconHelper = new RotateIconHelper();
        View inflate = View.inflate(context, Z8.f.f6187w, null);
        inflate.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        i.d(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.rotateContentContainer = constraintLayout;
        View findViewById = constraintLayout.findViewById(Z8.e.f6072A);
        i.e(findViewById, "rotateContentContainer.f…omponent_scan_view_title)");
        TextView textView = (TextView) findViewById;
        this.title = textView;
        int i12 = Z8.e.f6149v;
        View findViewById2 = constraintLayout.findViewById(i12);
        i.e(findViewById2, "rotateContentContainer.f…nt_scan_view_description)");
        TextView textView2 = (TextView) findViewById2;
        this.description = textView2;
        int i13 = Z8.e.f6153x;
        View findViewById3 = constraintLayout.findViewById(i13);
        i.e(findViewById3, "rotateContentContainer.f…scan_view_icon_container)");
        this.iconContainer = (ConstraintLayout) findViewById3;
        View findViewById4 = constraintLayout.findViewById(Z8.e.f6147u);
        i.e(findViewById4, "rotateContentContainer.f…omponent_scan_view_album)");
        this.albumIcon = (RotateLottieAnimationView) findViewById4;
        View findViewById5 = constraintLayout.findViewById(Z8.e.f6074B);
        i.e(findViewById5, "rotateContentContainer\n …omponent_scan_view_torch)");
        this.torchIcon = (RotateLottieAnimationView) findViewById5;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(Z8.e.f6155y);
        frameLayout.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.previewHolder = frameLayout;
        View findViewById6 = constraintLayout.findViewById(Z8.e.f6145t);
        i.e(findViewById6, "rotateContentContainer.f…ui_component_scan_cancel)");
        this.cancelIcon = findViewById6;
        b11 = kotlin.a.b(new InterfaceC1637a<FrameLayout>() { // from class: com.coui.appcompat.scanview.COUIFullscreenScanView$finderHolder$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final FrameLayout invoke() {
                ConstraintLayout constraintLayout2;
                constraintLayout2 = COUIFullscreenScanView.this.rotateContentContainer;
                return (FrameLayout) constraintLayout2.findViewById(Z8.e.f6151w);
            }
        });
        this.finderHolder$delegate = b11;
        this.finderView = new FinderView(context);
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z8.i.f6205K, i10, i11);
        setAlbumVisible(obtainStyledAttributes.getBoolean(Z8.i.f6207M, true));
        setTorchVisible(obtainStyledAttributes.getBoolean(Z8.i.f6208N, true));
        setShouldShowFinderView(obtainStyledAttributes.getBoolean(Z8.i.f6209O, false));
        String string = obtainStyledAttributes.getString(Z8.i.f6211Q);
        CharSequence string2 = obtainStyledAttributes.getString(Z8.i.f6206L);
        String string3 = obtainStyledAttributes.getString(Z8.i.f6212R);
        if (string3 == null) {
            string3 = "";
        } else {
            i.e(string3, "getString(R.styleable.CO…torchTip) ?: EMPTY_STRING");
        }
        setShowTorchTip(obtainStyledAttributes.getBoolean(Z8.i.f6210P, false));
        torchTipGroup.setTorchTip(string3);
        textView.setText(string);
        updateContentAndVisibility(textView2, string2);
        obtainStyledAttributes.recycle();
        FrameLayout finderHolder = getFinderHolder();
        ViewGroup.LayoutParams layoutParams = finderHolder.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (textView2.getVisibility() == 0) {
                layoutParams2.bottomToTop = i12;
                dimenPx = getDimenPx(finderHolder, Z8.c.f5978A);
            } else {
                layoutParams2.bottomToTop = i13;
                dimenPx = getDimenPx(finderHolder, Z8.c.f5980B);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = dimenPx;
            finderHolder.setLayoutParams(layoutParams2);
            addView(frameLayout);
            torchTipGroup.attachToRoot(constraintLayout);
            addView(constraintLayout);
            this.isInitialized = true;
            getScanViewRotateHelper().init();
            getScanViewRotateHelper().setIconOrientationListenerState$coui_support_component_release();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }
}
