package com.coui.appcompat.toolbar;

import X8.f;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.state.COUIMaskRippleDrawable;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class COUIActionMenuItemView extends ActionMenuItemView {
    private static final String TAG = "COUIActionMenuItemView";
    private int mIconMenuMinWidth;
    private boolean mIsText;
    private int mMarginEnd;
    private COUIMaskRippleDrawable mMaskRippleDrawable;
    private int mPaddingHorizontal;
    private int mPaddingVertical;
    private int mTextMenuItemMaxWidth;
    private int mTextPaddingHorizontal;
    private int mTextPaddingVertical;

    public COUIActionMenuItemView(Context context) {
        this(context, null);
    }

    private void configMenuIconBackground() {
        COUIMaskRippleDrawable cOUIMaskRippleDrawable = new COUIMaskRippleDrawable(getContext());
        this.mMaskRippleDrawable = cOUIMaskRippleDrawable;
        cOUIMaskRippleDrawable.setCircleRippleMask(COUIMaskRippleDrawable.getMaskRippleRadiusByType(getContext(), 0));
        setBackground(this.mMaskRippleDrawable);
        COUIDarkModeUtil.setForceDarkAllow(this, false);
    }

    private void setReflectField(Class cls, Object obj, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception e10) {
            Log.e(TAG, "setReflectField error: " + e10.getMessage());
        }
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView, androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i10) {
        boolean z10;
        int i11;
        super.initialize(menuItemImpl, i10);
        if (menuItemImpl.getIcon() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mIsText = z10;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.mIsText) {
            COUITextViewCompatUtil.setPressRippleDrawable(this);
            setMaxWidth(this.mTextMenuItemMaxWidth);
        } else {
            setReflectField(ActionMenuItemView.class, this, "mMinWidth", Integer.valueOf(this.mIconMenuMinWidth));
            configMenuIconBackground();
            int i12 = this.mPaddingHorizontal;
            int i13 = this.mPaddingVertical;
            setPadding(i12, i13, i12, i13);
        }
        boolean z11 = this.mIsText;
        if (z11) {
            i11 = -2;
        } else {
            i11 = -1;
        }
        layoutParams.height = i11;
        if (!z11 && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(this.mMarginEnd);
        }
        setLayoutParams(layoutParams);
    }

    public boolean isTextMenuItem() {
        return this.mIsText;
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView, android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MenuItemImpl itemData = getItemData();
        if (itemData != null && itemData.getIcon() != null) {
            this.mMarginEnd = getContext().createConfigurationContext(configuration).getResources().getDimensionPixelSize(f.f4731l);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(this.mMarginEnd);
            }
        }
    }

    public void refresh() {
        COUIMaskRippleDrawable cOUIMaskRippleDrawable = this.mMaskRippleDrawable;
        if (cOUIMaskRippleDrawable != null) {
            cOUIMaskRippleDrawable.refresh(getContext());
        }
    }

    public void setItemWithGap(boolean z10) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!this.mIsText && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (z10) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(this.mMarginEnd);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(0);
            }
        }
        setLayoutParams(layoutParams);
    }

    public COUIActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPaddingHorizontal = context.getResources().getDimensionPixelSize(f.f4721j5);
        this.mPaddingVertical = context.getResources().getDimensionPixelSize(f.f4729k5);
        this.mTextPaddingHorizontal = context.getResources().getDimensionPixelSize(f.f4807u5);
        this.mTextPaddingVertical = context.getResources().getDimensionPixelSize(f.f4814v5);
        this.mMarginEnd = context.getResources().getDimensionPixelSize(f.f4731l);
        this.mIconMenuMinWidth = context.getResources().getDimensionPixelSize(f.f4723k);
        this.mTextMenuItemMaxWidth = context.getResources().getDimensionPixelSize(f.f4715j);
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
    }
}
