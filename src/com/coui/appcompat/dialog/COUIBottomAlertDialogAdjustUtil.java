package com.coui.appcompat.dialog;

import X8.e;
import X8.f;
import X8.g;
import X8.h;
import X8.n;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.core.view.K;
import com.coui.appcompat.dialog.COUIBottomAlertDialogAdjustUtil;
import com.coui.appcompat.dialog.widget.COUIAlertDialogMaxLinearLayout;
import com.coui.appcompat.uiutil.FollowHandManager;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUIBottomAlertDialogAdjustUtil {

    /* loaded from: classes.dex */
    public interface OnFirstLayoutListener {
        void onFirstLayout();
    }

    public static void adjustToFree(Window window, View view) {
        adjustToFree(window, view, null);
    }

    private static int dpToPx(Context context, float f10) {
        return Math.round(TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics()));
    }

    private static int getDimensionPixel(Window window, int i10, int i11) {
        Resources resources = window.getDecorView().getResources();
        if (resources != null && i10 != 0) {
            return resources.getDimensionPixelOffset(i10);
        }
        return i11;
    }

    private static Drawable getDrawable(Window window, int i10) {
        Context context = window.getDecorView().getContext();
        if (context != null && i10 != 0) {
            return context.getDrawable(i10);
        }
        return null;
    }

    public static Rect getLocationRectInScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        return new Rect(i10, iArr[1], view.getMeasuredWidth() + i10, iArr[1] + view.getMeasuredHeight());
    }

    private static int lerp(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i10, i12));
    }

    private static void offsetWindowTo(Window window, int i10, int i11) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = i10;
        attributes.y = i11;
        window.setAttributes(attributes);
    }

    private static void setFirstLayoutListener(final Window window, final OnFirstLayoutListener onFirstLayoutListener) {
        if (onFirstLayoutListener == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coui.appcompat.dialog.COUIBottomAlertDialogAdjustUtil.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                window.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                onFirstLayoutListener.onFirstLayout();
            }
        });
    }

    private static void setWindowWidth(Window window, int i10) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i10;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateParentPanel(Window window, boolean z10) {
        View findViewById = window.findViewById(h.f4907X);
        if (findViewById instanceof COUIAlertDialogMaxLinearLayout) {
            if (z10) {
                int dimensionPixel = getDimensionPixel(window, f.f4544L5, 0);
                LinearLayout linearLayout = new LinearLayout(window.getContext());
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(UIUtil.dip2px(window.getContext(), window.getContext().getResources().getConfiguration().screenWidthDp), FollowHandManager.getDecorViewRectInWindow().height()));
                if (FollowHandManager.ifWidthDpIsFullScreen(window.getContext()) && FollowHandManager.getWindowLocationOnScreen()[0] > 0) {
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    layoutParams.copyFrom(window.getAttributes());
                    layoutParams.gravity = 8388659;
                    layoutParams.x = FollowHandManager.getWindowLocationOnScreen()[0];
                    layoutParams.y = FollowHandManager.getWindowLocationOnScreen()[1];
                    window.setAttributes(layoutParams);
                }
                UIUtil.safeForceHasOverlappingRendering(linearLayout, false);
                linearLayout.setClipToOutline(false);
                linearLayout.setClipChildren(false);
                findViewById.setClipToOutline(false);
                ((COUIAlertDialogMaxLinearLayout) findViewById).setClipChildren(false);
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                viewGroup.removeView(findViewById);
                viewGroup.addView(linearLayout);
                linearLayout.addView(findViewById);
                ShadowUtils.setElevationToView(findViewById, 3, dimensionPixel, androidx.core.content.b.c(window.getContext(), e.f4447m));
            } else {
                ((COUIAlertDialogMaxLinearLayout) findViewById).setMaxWidth(getDimensionPixel(window, f.f4757o1, 0));
            }
            findViewById.setBackground(getDrawable(window, g.f4848a));
            findViewById.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateWindowLocation(Window window, View view, Point point, Point point2) {
        Point calculatePosition;
        if (view == null && point != null) {
            offsetWindowTo(window, point.x, point.y);
            return;
        }
        int dimensionPixel = getDimensionPixel(window, f.f4475C, 0);
        View findViewById = window.findViewById(h.f4907X);
        if (point == null) {
            calculatePosition = FollowHandManager.calculatePosition(view.getContext(), findViewById.getMeasuredWidth(), findViewById.getMeasuredHeight() + dimensionPixel, false);
            if (calculatePosition.y < FollowHandManager.getClickPositionYInWindow()) {
                calculatePosition.y += dpToPx(view.getContext(), 8.0f);
            }
        } else {
            calculatePosition = FollowHandManager.calculatePosition(view.getContext(), findViewById.getMeasuredWidth(), findViewById.getMeasuredHeight() + dimensionPixel, false);
        }
        int i10 = calculatePosition.y - FollowHandManager.getDecorViewRectInWindow().top;
        calculatePosition.y = i10;
        if (point2 != null) {
            calculatePosition.x += point2.x;
            calculatePosition.y = i10 + point2.y;
        }
        if (findViewById instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.topMargin = calculatePosition.y + dimensionPixel;
            Rect rect = new Rect();
            if (FollowHandManager.getWindowLocationOnScreen()[0] == 0) {
                view.getWindowVisibleDisplayFrame(rect);
            }
            if (K.v(view) == 1) {
                layoutParams.setMarginStart(((FollowHandManager.getDecorViewRectInWindow().width() - calculatePosition.x) - findViewById.getMeasuredWidth()) + rect.left);
            } else {
                layoutParams.setMarginStart(calculatePosition.x - rect.left);
            }
            findViewById.setLayoutParams(layoutParams);
        }
    }

    public static void adjustToFree(Window window, View view, Point point) {
        adjustToFree(window, view, point, null);
    }

    public static void adjustToFree(final Window window, final View view, final Point point, final Point point2) {
        setWindowWidth(window, -2);
        window.clearFlags(2);
        window.setGravity(51);
        window.setWindowAnimations(n.f5031c);
        setFirstLayoutListener(window, new OnFirstLayoutListener() { // from class: com.coui.appcompat.dialog.COUIBottomAlertDialogAdjustUtil.1

            /* renamed from: com.coui.appcompat.dialog.COUIBottomAlertDialogAdjustUtil$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            public class ViewOnLayoutChangeListenerC01971 implements View.OnLayoutChangeListener {
                final /* synthetic */ View val$parentPanel;

                public ViewOnLayoutChangeListenerC01971(View view) {
                    this.val$parentPanel = view;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    COUIBottomAlertDialogAdjustUtil.updateWindowLocation(window, view, point, point2);
                    this.val$parentPanel.removeOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.coui.appcompat.dialog.b
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view2, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25) {
                            COUIBottomAlertDialogAdjustUtil.AnonymousClass1.ViewOnLayoutChangeListenerC01971.this.onLayoutChange(view2, i18, i19, i20, i21, i22, i23, i24, i25);
                        }
                    });
                    window.getDecorView().setVisibility(0);
                }
            }

            @Override // com.coui.appcompat.dialog.COUIBottomAlertDialogAdjustUtil.OnFirstLayoutListener
            public void onFirstLayout() {
                View findViewById = window.findViewById(h.f4907X);
                if (findViewById == null) {
                    return;
                }
                Point point3 = point;
                if (point3 == null) {
                    FollowHandManager.init(view);
                } else {
                    FollowHandManager.init(view, point3.x, point3.y);
                }
                COUIBottomAlertDialogAdjustUtil.updateParentPanel(window, true);
                findViewById.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC01971(findViewById));
            }
        });
    }
}
