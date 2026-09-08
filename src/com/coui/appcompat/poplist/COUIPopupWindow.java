package com.coui.appcompat.poplist;

import X8.n;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.PopupWindow;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.poplist.WindowSpacingControlHelper;
import com.coui.appcompat.uiutil.ShadowUtils;
import e.C0961a;

/* loaded from: classes.dex */
public class COUIPopupWindow extends PopupWindow {
    private Context mContext;
    protected boolean mIsOutLineBackgroundInPopupWindow;
    private boolean mSetElevationInPopupwindow;
    protected WindowSpacingControlHelper mWindowSpacingControlHelper;

    public COUIPopupWindow(Context context) {
        this(context, null);
    }

    private void initPopupWindow(Context context) {
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{X8.c.f4365X});
        initPopupWindowBackground(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        setClippingEnabled(false);
        setElevation(0.0f);
        setExitTransition(null);
        setEnterTransition(null);
        setAnimationStyle(n.f5031c);
    }

    public void addSpacingControlUtil(Context context, int i10, WindowSpacingControlHelper.AnchorViewTypeEnum anchorViewTypeEnum) {
        if (context != null) {
            addSpacingControlUtil(context.getResources().getDimensionPixelSize(i10), anchorViewTypeEnum);
        }
    }

    public int getAnchorViewSpacing(WindowSpacingControlHelper.AnchorViewTypeEnum anchorViewTypeEnum) {
        if (this.mWindowSpacingControlHelper.isUtilMapInit()) {
            return this.mWindowSpacingControlHelper.getAnchorViewSpacing(anchorViewTypeEnum);
        }
        return 0;
    }

    public void initElevationInPopupwindow() {
        if (this.mSetElevationInPopupwindow && getContentView() != null) {
            setBackgroundDrawable(null);
            if (ShadowUtils.checkOPlusViewElevationSDK()) {
                ShadowUtils.setElevationToView(getContentView(), 3);
            } else {
                setElevation(this.mContext.getResources().getDimensionPixelSize(X8.f.f4523I5));
                getContentView().setOutlineSpotShadowColor(androidx.core.content.b.c(this.mContext, X8.e.f4458x));
            }
        }
    }

    public void initOutlineRoundRectBackground() {
        if (this.mIsOutLineBackgroundInPopupWindow && getContentView() != null) {
            getContentView().setOutlineProvider(new ViewOutlineProvider() { // from class: com.coui.appcompat.poplist.COUIPopupWindow.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), COUIContextUtil.getAttrDimens(COUIPopupWindow.this.getContentView().getContext(), X8.c.f4373c0));
                }
            });
            getContentView().setClipToOutline(true);
        }
    }

    public void initPopupWindowBackground(Context context, TypedArray typedArray) {
        typedArray.getDrawable(0);
        setBackgroundDrawable(context.getResources().getDrawable(X8.g.f4859l));
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View view) {
        super.setContentView(view);
        initOutlineRoundRectBackground();
        initElevationInPopupwindow();
    }

    public void setDismissTouchOutside(boolean z10) {
        if (z10) {
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
        } else {
            setFocusable(false);
            setOutsideTouchable(false);
        }
        update();
    }

    public void setElevationInPopupwindow(boolean z10) {
        this.mSetElevationInPopupwindow = z10;
    }

    public COUIPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30092J);
    }

    public void addSpacingControlUtil(int i10, WindowSpacingControlHelper.AnchorViewTypeEnum anchorViewTypeEnum) {
        this.mWindowSpacingControlHelper.addAnchorViewSpacingMap(i10, anchorViewTypeEnum);
    }

    public COUIPopupWindow(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public int getAnchorViewSpacing(View view, WindowSpacingControlHelper.AnchorViewTypeEnum anchorViewTypeEnum) {
        if (this.mWindowSpacingControlHelper.isUtilMapInit()) {
            return this.mWindowSpacingControlHelper.getAnchorViewSpacing(view, anchorViewTypeEnum);
        }
        return 0;
    }

    public COUIPopupWindow(View view, int i10, int i11) {
        this(view, i10, i11, false);
    }

    public COUIPopupWindow(View view, int i10, int i11, boolean z10) {
        super(view, i10, i11, z10);
        this.mSetElevationInPopupwindow = false;
        this.mIsOutLineBackgroundInPopupWindow = true;
        this.mWindowSpacingControlHelper = new WindowSpacingControlHelper();
        initPopupWindow(view.getContext());
    }

    public COUIPopupWindow(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mSetElevationInPopupwindow = false;
        this.mIsOutLineBackgroundInPopupWindow = true;
        this.mWindowSpacingControlHelper = new WindowSpacingControlHelper();
        initPopupWindow(context);
    }
}
