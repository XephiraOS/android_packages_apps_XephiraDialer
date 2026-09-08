package com.coui.appcompat.scanview;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.w;
import com.coui.appcompat.grid.COUIPercentUtils;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.orientationutil.COUIOrientationUtil;
import com.coui.appcompat.scanview.TorchTipGroup;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.i;
import m9.q;
import v9.InterfaceC1637a;
import v9.l;

/* compiled from: ScanViewRotateHelper.kt */
/* loaded from: classes.dex */
public final class ScanViewRotateHelper implements w<UIConfig> {
    public static final Companion Companion = new Companion(null);
    private static final int FINDER_VIEW_GRID_COUNT_LARGE = 8;
    private static final int FINDER_VIEW_GRID_COUNT_MEDIUM = 6;
    private static final int FINDER_VIEW_GRID_COUNT_SMALL = 5;
    public static final int PERCENT_UTILS_FLAG_WITHOUT_PADDING = 0;
    public static final int SCREEN_TYPE_WIDTH_THRESH_MEDIUM = 840;
    public static final int SCREEN_TYPE_WIDTH_THRESH_SMALL = 600;
    private static final String TAG = "ScanViewRotateHelper";
    private static final int TORCH_TIP_GRID_COUNT_MEDIUM = 6;
    private static final int TORCH_TIP_GRID_COUNT_SMALL = 5;
    public static final int TOTAL_GRID_COUNT_SCREEN_TYPE_LARGE = 12;
    public static final int TOTAL_GRID_COUNT_SCREEN_TYPE_MEDIUM = 8;
    public static final int TOTAL_GRID_COUNT_SCREEN_TYPE_SMALL = 4;
    private static final int TWO_ICON_GRID_COUNT_LARGE = 8;
    private static final int TWO_ICON_GRID_COUNT_MEDIUM = 6;
    private static final int TWO_ICON_GRID_COUNT_SMALL = 5;
    private final m9.d albumIcon$delegate;
    private final Context context;
    private final m9.d description$delegate;
    private final m9.d finderHolder$delegate;
    private UIConfig.WindowType lastScreenType;
    private int orientation;
    private final m9.d orientationListener$delegate;
    private final ResponsiveUIConfig responsiveUIConfig;
    private final COUIFullscreenScanView root;
    private final m9.d rotateContentContainer$delegate;
    private final m9.d torchIcon$delegate;
    private final TorchTipGroup torchTipGroup;
    private final int torchTipMargin;

    /* compiled from: ScanViewRotateHelper.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public ScanViewRotateHelper(COUIFullscreenScanView root) {
        m9.d b10;
        m9.d b11;
        m9.d b12;
        m9.d b13;
        m9.d b14;
        m9.d b15;
        i.f(root, "root");
        this.root = root;
        b10 = kotlin.a.b(new InterfaceC1637a<RotateLottieAnimationView>() { // from class: com.coui.appcompat.scanview.ScanViewRotateHelper$albumIcon$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final RotateLottieAnimationView invoke() {
                COUIFullscreenScanView cOUIFullscreenScanView;
                cOUIFullscreenScanView = ScanViewRotateHelper.this.root;
                return (RotateLottieAnimationView) cOUIFullscreenScanView.findViewById(Z8.e.f6147u);
            }
        });
        this.albumIcon$delegate = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<RotateLottieAnimationView>() { // from class: com.coui.appcompat.scanview.ScanViewRotateHelper$torchIcon$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final RotateLottieAnimationView invoke() {
                COUIFullscreenScanView cOUIFullscreenScanView;
                cOUIFullscreenScanView = ScanViewRotateHelper.this.root;
                return (RotateLottieAnimationView) cOUIFullscreenScanView.findViewById(Z8.e.f6074B);
            }
        });
        this.torchIcon$delegate = b11;
        b12 = kotlin.a.b(new InterfaceC1637a<TextView>() { // from class: com.coui.appcompat.scanview.ScanViewRotateHelper$description$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final TextView invoke() {
                COUIFullscreenScanView cOUIFullscreenScanView;
                cOUIFullscreenScanView = ScanViewRotateHelper.this.root;
                return (TextView) cOUIFullscreenScanView.findViewById(Z8.e.f6149v);
            }
        });
        this.description$delegate = b12;
        b13 = kotlin.a.b(new InterfaceC1637a<FrameLayout>() { // from class: com.coui.appcompat.scanview.ScanViewRotateHelper$finderHolder$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final FrameLayout invoke() {
                COUIFullscreenScanView cOUIFullscreenScanView;
                cOUIFullscreenScanView = ScanViewRotateHelper.this.root;
                return (FrameLayout) cOUIFullscreenScanView.findViewById(Z8.e.f6151w);
            }
        });
        this.finderHolder$delegate = b13;
        b14 = kotlin.a.b(new InterfaceC1637a<ConstraintLayout>() { // from class: com.coui.appcompat.scanview.ScanViewRotateHelper$rotateContentContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final ConstraintLayout invoke() {
                COUIFullscreenScanView cOUIFullscreenScanView;
                cOUIFullscreenScanView = ScanViewRotateHelper.this.root;
                return (ConstraintLayout) cOUIFullscreenScanView.findViewById(Z8.e.f6157z);
            }
        });
        this.rotateContentContainer$delegate = b14;
        ResponsiveUIConfig responsiveUIConfig = ResponsiveUIConfig.getDefault(root.getContext());
        this.responsiveUIConfig = responsiveUIConfig;
        this.torchTipGroup = root.getTorchTipGroup$coui_support_component_release();
        Context context = root.getContext();
        this.context = context;
        i.e(context, "context");
        this.torchTipMargin = getDimenPx(context, Z8.c.f5999T);
        b15 = kotlin.a.b(new InterfaceC1637a<WeakReference<CameraOrientationListener>>() { // from class: com.coui.appcompat.scanview.ScanViewRotateHelper$orientationListener$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public final WeakReference<CameraOrientationListener> invoke() {
                Context context2;
                context2 = ScanViewRotateHelper.this.context;
                return new WeakReference<>(new CameraOrientationListener(context2.getApplicationContext()) { // from class: com.coui.appcompat.scanview.ScanViewRotateHelper$orientationListener$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(applicationContext);
                        i.e(applicationContext, "applicationContext");
                    }

                    @Override // com.coui.appcompat.scanview.CameraOrientationListener
                    public void onDirectionChanged(int i10) {
                        if (ScanViewRotateHelper.this.getOrientation$coui_support_component_release() == i10) {
                            return;
                        }
                        COUILog.d("ScanViewRotateHelper", "[onDirectionChanged] newOrientation=" + i10 + " oldOrientation=" + ScanViewRotateHelper.this.getOrientation$coui_support_component_release() + " width=" + ScanViewRotateHelper.this.getDirectionAwareWidthDp$coui_support_component_release(i10));
                        ScanViewRotateHelper.updateRotateContainerOrientation$default(ScanViewRotateHelper.this, i10, false, 2, null);
                        ScanViewRotateHelper.this.setOrientation$coui_support_component_release(i10);
                    }
                });
            }
        });
        this.orientationListener$delegate = b15;
        UIConfig.WindowType screenType = responsiveUIConfig.getScreenType();
        i.e(screenType, "responsiveUIConfig.screenType");
        this.lastScreenType = screenType;
    }

    private final RotateLottieAnimationView getAlbumIcon() {
        return (RotateLottieAnimationView) this.albumIcon$delegate.getValue();
    }

    private final TextView getDescription() {
        return (TextView) this.description$delegate.getValue();
    }

    private final int getDimenPx(Context context, int i10) {
        return context.getResources().getDimensionPixelSize(i10);
    }

    private final Size getDisplaySizeDp() {
        int b10;
        int b11;
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        float f10 = COUIOrientationUtil.getScreenSize(this.context).x;
        float f11 = displayMetrics.density;
        b10 = x9.c.b(f10 / f11);
        b11 = x9.c.b(r2.y / f11);
        return new Size(b10, b11);
    }

    private final FrameLayout getFinderHolder() {
        return (FrameLayout) this.finderHolder$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getFinderViewGridNumber(int i10) {
        if (i10 < 600) {
            return 5;
        }
        if (i10 < 840) {
            return 6;
        }
        return 8;
    }

    private final Size getMeasuredWidthWithMaxWidth(View view, int i10) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new Size(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private final WeakReference<CameraOrientationListener> getOrientationListener() {
        return (WeakReference) this.orientationListener$delegate.getValue();
    }

    private final ConstraintLayout getRotateContentContainer() {
        return (ConstraintLayout) this.rotateContentContainer$delegate.getValue();
    }

    private final RotateLottieAnimationView getTorchIcon() {
        return (RotateLottieAnimationView) this.torchIcon$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTorchTipGridNumber(int i10) {
        if (i10 >= 600) {
            return 6;
        }
        return 5;
    }

    private final int getTotalGridCountByWidth(int i10) {
        if (i10 < 600) {
            return 4;
        }
        if (i10 < 840) {
            return 8;
        }
        return 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rotateContainer(ViewGroup viewGroup, int i10) {
        if (TorchTipGroup.Companion.isPortrait(i10)) {
            viewGroup.setRotation(-i10);
            viewGroup.setTranslationX(0.0f);
            viewGroup.setTranslationY(0.0f);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
                viewGroup.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        viewGroup.setRotation(-i10);
        viewGroup.setTranslationX((this.root.getWidth() - this.root.getHeight()) / 2);
        viewGroup.setTranslationY((this.root.getHeight() - this.root.getWidth()) / 2);
        ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
        if (layoutParams3 != null) {
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            ((ViewGroup.MarginLayoutParams) layoutParams4).height = this.root.getWidth();
            ((ViewGroup.MarginLayoutParams) layoutParams4).width = this.root.getHeight();
            viewGroup.setLayoutParams(layoutParams4);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final void updateDescriptionLp() {
        int i10;
        int widthByGridCount$coui_support_component_release = getWidthByGridCount$coui_support_component_release(this.orientation, new ScanViewRotateHelper$updateDescriptionLp$descriptionMaxWidth$1(this));
        TextView description = getDescription();
        i.e(description, "description");
        Size measuredWidthWithMaxWidth = getMeasuredWidthWithMaxWidth(description, widthByGridCount$coui_support_component_release);
        TextView description2 = getDescription();
        i.e(description2, "description");
        ViewGroup.LayoutParams layoutParams = description2.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (isSmall$coui_support_component_release()) {
                i10 = getDimenPx(this.root, Z8.c.f5998S);
            } else {
                i10 = 0;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = measuredWidthWithMaxWidth.getWidth() - (i10 * 2);
            description2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final void updateFinderViewLp() {
        int widthByGridCount$coui_support_component_release = getWidthByGridCount$coui_support_component_release(this.orientation, new ScanViewRotateHelper$updateFinderViewLp$finderHolderWidth$1(this));
        FrameLayout finderHolder = getFinderHolder();
        i.e(finderHolder, "finderHolder");
        ViewGroup.LayoutParams layoutParams = finderHolder.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = widthByGridCount$coui_support_component_release;
            finderHolder.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final void updateRotateContainerOrientation(final int i10, boolean z10) {
        final ConstraintLayout rotateContentContainer = getRotateContentContainer();
        if (isSmall$coui_support_component_release()) {
            if (((int) rotateContentContainer.getRotation()) != 0) {
                i.e(rotateContentContainer, "this");
                rotateContainer(rotateContentContainer, 0);
                return;
            }
            return;
        }
        if (z10) {
            TorchTipGroup.Companion companion = TorchTipGroup.Companion;
            i.e(rotateContentContainer, "this");
            companion.disappear(rotateContentContainer, new InterfaceC1637a<q>() { // from class: com.coui.appcompat.scanview.ScanViewRotateHelper$updateRotateContainerOrientation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // v9.InterfaceC1637a
                public /* bridge */ /* synthetic */ q invoke() {
                    invoke2();
                    return q.f35511a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ScanViewRotateHelper scanViewRotateHelper = ScanViewRotateHelper.this;
                    ConstraintLayout constraintLayout = rotateContentContainer;
                    i.e(constraintLayout, "this");
                    scanViewRotateHelper.rotateContainer(constraintLayout, i10);
                    ScanViewRotateHelper.this.init();
                    TorchTipGroup.Companion companion2 = TorchTipGroup.Companion;
                    ConstraintLayout constraintLayout2 = rotateContentContainer;
                    i.e(constraintLayout2, "this");
                    TorchTipGroup.Companion.show$default(companion2, constraintLayout2, null, 2, null);
                }
            });
        } else {
            i.e(rotateContentContainer, "this");
            rotateContainer(rotateContentContainer, i10);
        }
    }

    public static /* synthetic */ void updateRotateContainerOrientation$default(ScanViewRotateHelper scanViewRotateHelper, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        scanViewRotateHelper.updateRotateContainerOrientation(i10, z10);
    }

    private final void updateTorchTipGroupLp() {
        int i10 = this.orientation;
        TorchTipGroup torchTipGroup = this.torchTipGroup;
        Size measuredWidthWithMaxWidth = getMeasuredWidthWithMaxWidth(torchTipGroup.getBottomTorchTip(), getWidthByGridCount$coui_support_component_release(i10, new ScanViewRotateHelper$updateTorchTipGroupLp$1$torchTipMaxWidth$1(this)));
        LinearLayout bottomTorchTip = torchTipGroup.getBottomTorchTip();
        ViewGroup.LayoutParams layoutParams = bottomTorchTip.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = measuredWidthWithMaxWidth.getWidth();
            layoutParams2.bottomToTop = Z8.e.f6149v;
            layoutParams2.startToStart = 0;
            layoutParams2.endToEnd = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = this.torchTipMargin;
            bottomTorchTip.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final float getDirectionAwareWidth$coui_support_component_release(int i10) {
        int i11;
        Point screenSize = COUIOrientationUtil.getScreenSize(this.context);
        if (isSmall$coui_support_component_release()) {
            return screenSize.x;
        }
        if (TorchTipGroup.Companion.isPortrait(i10)) {
            i11 = screenSize.x;
        } else {
            i11 = screenSize.y;
        }
        return i11;
    }

    public final int getDirectionAwareWidthByGridCount$coui_support_component_release(int i10, int i11) {
        int b10;
        b10 = x9.c.b(COUIPercentUtils.calculateWidth(getDirectionAwareWidth$coui_support_component_release(i11), i10, getTotalGridCountByWidth(getDirectionAwareWidthDp$coui_support_component_release(i11)), 0, this.context));
        return b10;
    }

    public final int getDirectionAwareWidthDp$coui_support_component_release(int i10) {
        Size displaySizeDp = getDisplaySizeDp();
        if (isSmall$coui_support_component_release()) {
            return displaySizeDp.getWidth();
        }
        if (TorchTipGroup.Companion.isPortrait(i10)) {
            return displaySizeDp.getWidth();
        }
        return displaySizeDp.getHeight();
    }

    public final int getOrientation$coui_support_component_release() {
        return this.orientation;
    }

    public final int getTwoIconGridNumber$coui_support_component_release(int i10) {
        if (i10 < 600) {
            return 5;
        }
        if (i10 < 840) {
            return 6;
        }
        return 8;
    }

    public final int getWidthByGridCount$coui_support_component_release(int i10, l<? super Integer, Integer> getGridCount) {
        i.f(getGridCount, "getGridCount");
        return getDirectionAwareWidthByGridCount$coui_support_component_release(getGridCount.invoke(Integer.valueOf(getDirectionAwareWidthDp$coui_support_component_release(i10))).intValue(), i10);
    }

    public final void init() {
        updateTorchTipGroupLp();
        updateDescriptionLp();
        updateFinderViewLp();
        this.root.adjustIconLayout$coui_support_component_release();
    }

    public final boolean isSmall$coui_support_component_release() {
        if (this.responsiveUIConfig.getScreenType() == UIConfig.WindowType.SMALL) {
            return true;
        }
        return false;
    }

    public final void registerListener$coui_support_component_release() {
        this.responsiveUIConfig.getUiConfig().j(this);
        CameraOrientationListener cameraOrientationListener = getOrientationListener().get();
        if (cameraOrientationListener != null) {
            cameraOrientationListener.enable();
        }
    }

    public final void setIconOrientationListenerState$coui_support_component_release() {
        if (isSmall$coui_support_component_release()) {
            getTorchIcon().enableOrientationListener();
            getAlbumIcon().enableOrientationListener();
            getTorchIcon().setOrientation(this.orientation);
            getAlbumIcon().setOrientation(this.orientation);
            return;
        }
        getTorchIcon().disableOrientationListener();
        getTorchIcon().resetOrientation();
        getAlbumIcon().disableOrientationListener();
        getAlbumIcon().resetOrientation();
    }

    public final void setOrientation$coui_support_component_release(int i10) {
        this.orientation = i10;
    }

    public final void unregisterListener$coui_support_component_release() {
        this.responsiveUIConfig.getUiConfig().n(this);
        CameraOrientationListener cameraOrientationListener = getOrientationListener().get();
        if (cameraOrientationListener != null) {
            cameraOrientationListener.disable();
        }
    }

    private final int getDimenPx(View view, int i10) {
        return view.getContext().getResources().getDimensionPixelSize(i10);
    }

    @Override // androidx.lifecycle.w
    public void onChanged(UIConfig uIConfig) {
        COUILog.d(TAG, "[onChanged] lastScreenType=" + this.lastScreenType + " currentScreenType=" + this.responsiveUIConfig.getScreenType());
        if (this.lastScreenType == this.responsiveUIConfig.getScreenType()) {
            return;
        }
        UIConfig.WindowType screenType = this.responsiveUIConfig.getScreenType();
        i.e(screenType, "responsiveUIConfig.screenType");
        this.lastScreenType = screenType;
        setIconOrientationListenerState$coui_support_component_release();
        updateRotateContainerOrientation(this.orientation, false);
        init();
    }
}
