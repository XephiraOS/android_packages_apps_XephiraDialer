package com.coui.appcompat.dialog.widget;

import X8.c;
import X8.f;
import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.roundcorner.RoundCornerUtil;
import com.oplus.graphics.OplusOutline;

/* loaded from: classes.dex */
public class COUIAlertDialogClipCornerLinearLayout extends LinearLayoutCompat {
    private static final String TAG = "COUIAlertDialogClipCorner";
    private boolean mBlurBackgroundWindow;
    private boolean mIsSupportRoundCornerWhenBlur;
    private boolean mIsSupportSmoothRoundCorner;
    private int mRadius;

    public COUIAlertDialogClipCornerLinearLayout(Context context) {
        super(context);
        this.mBlurBackgroundWindow = false;
        this.mIsSupportRoundCornerWhenBlur = false;
        this.mIsSupportSmoothRoundCorner = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRadius > 0) {
            setClipToOutline(true);
            setOutlineProvider(new ViewOutlineProvider() { // from class: com.coui.appcompat.dialog.widget.COUIAlertDialogClipCornerLinearLayout.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    boolean z10;
                    if (COUIAlertDialogClipCornerLinearLayout.this.mBlurBackgroundWindow && !COUIAlertDialogClipCornerLinearLayout.this.mIsSupportRoundCornerWhenBlur) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (COUIAlertDialogClipCornerLinearLayout.this.mIsSupportSmoothRoundCorner && !z10) {
                        new OplusOutline(outline).setSmoothRoundRect(0, 0, COUIAlertDialogClipCornerLinearLayout.this.getMeasuredWidth(), COUIAlertDialogClipCornerLinearLayout.this.getMeasuredHeight(), COUIAlertDialogClipCornerLinearLayout.this.mRadius, COUIContextUtil.getFloat(COUIAlertDialogClipCornerLinearLayout.this.getContext(), f.f4759o3));
                    } else {
                        outline.setRoundRect(0, 0, COUIAlertDialogClipCornerLinearLayout.this.getMeasuredWidth(), COUIAlertDialogClipCornerLinearLayout.this.getMeasuredHeight(), COUIAlertDialogClipCornerLinearLayout.this.mRadius);
                    }
                    COUILog.i(COUIAlertDialogClipCornerLinearLayout.TAG, "getOutline: notUseRoundCornerWhenBlur" + z10 + " mBlurBackgroundWindow=" + COUIAlertDialogClipCornerLinearLayout.this.mBlurBackgroundWindow + " mIsSupportRoundCornerWhenBlur=" + COUIAlertDialogClipCornerLinearLayout.this.mIsSupportRoundCornerWhenBlur + " mIsSupportSmoothRoundCorner=" + COUIAlertDialogClipCornerLinearLayout.this.mIsSupportSmoothRoundCorner + " mRadius=" + COUIAlertDialogClipCornerLinearLayout.this.mRadius);
                }
            });
        }
    }

    public void setBlurBackgroundWindow(boolean z10) {
        this.mBlurBackgroundWindow = z10;
    }

    public void setIsSupportRoundCornerWhenBlur(boolean z10) {
        this.mIsSupportRoundCornerWhenBlur = z10;
    }

    public COUIAlertDialogClipCornerLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBlurBackgroundWindow = false;
        this.mIsSupportRoundCornerWhenBlur = false;
        this.mIsSupportSmoothRoundCorner = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5365n);
        boolean isVersionSupport = RoundCornerUtil.isVersionSupport();
        this.mIsSupportSmoothRoundCorner = isVersionSupport;
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(o.f5373o, COUIContextUtil.getAttrDimens(getContext(), isVersionSupport ? c.f4383h0 : c.f4381g0));
        obtainStyledAttributes.recycle();
    }

    public COUIAlertDialogClipCornerLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mBlurBackgroundWindow = false;
        this.mIsSupportRoundCornerWhenBlur = false;
        this.mIsSupportSmoothRoundCorner = false;
    }
}
