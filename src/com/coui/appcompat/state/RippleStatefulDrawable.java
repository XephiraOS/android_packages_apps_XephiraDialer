package com.coui.appcompat.state;

import android.content.res.ColorStateList;
import android.graphics.drawable.RippleDrawable;

/* loaded from: classes.dex */
public abstract class RippleStatefulDrawable extends RippleDrawable implements DrawableStateProxy, IStateEffect {
    protected final DrawableStateManager mDrawableStateManager;

    public RippleStatefulDrawable(String str) {
        super(ColorStateList.valueOf(0), null, null);
        this.mDrawableStateManager = new DrawableStateManager(str, this);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final int getTouchType() {
        return this.mDrawableStateManager.getTouchType();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isDrawableEnabled() {
        return this.mDrawableStateManager.isDrawableEnabled();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final boolean isEnabled() {
        return this.mDrawableStateManager.isEnabled();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final boolean isFocused() {
        return this.mDrawableStateManager.isFocused();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final boolean isHovered() {
        return this.mDrawableStateManager.isHovered();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isNativeStateEnabled(int i10) {
        return this.mDrawableStateManager.isNativeStateEnabled(i10);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final boolean isPressed() {
        return this.mDrawableStateManager.isPressed();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final boolean isSelected() {
        return this.mDrawableStateManager.isSelected();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isStateLocked(int i10) {
        return this.mDrawableStateManager.isStateLocked(i10);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.mDrawableStateManager.isStateful();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final boolean isTouchEntered() {
        return this.mDrawableStateManager.isTouchEntered();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setDrawableEnabled(boolean z10) {
        this.mDrawableStateManager.setDrawableEnabled(z10);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setFocusEntered() {
        this.mDrawableStateManager.setFocusEntered();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setFocusExited() {
        this.mDrawableStateManager.setFocusExited();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setHoverEntered() {
        this.mDrawableStateManager.setHoverEntered();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setHoverExited() {
        this.mDrawableStateManager.setHoverExited();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setNativeStateEnabled(int i10, boolean z10) {
        this.mDrawableStateManager.setNativeStateEnabled(i10, z10);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setSelectedEntered() {
        this.mDrawableStateManager.setSelectedEntered();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setSelectedExited() {
        this.mDrawableStateManager.setSelectedExited();
    }

    public void setStateLocked(int i10, boolean z10, boolean z11, boolean z12) {
        this.mDrawableStateManager.setStateLocked(i10, z10, z11, z12);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setTouchEntered() {
        this.mDrawableStateManager.setTouchEntered();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setTouchExited() {
        this.mDrawableStateManager.setTouchExited();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setTouchSelectEntered() {
        this.mDrawableStateManager.setTouchSelectEntered();
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public final void setTouchSelectExited() {
        this.mDrawableStateManager.setTouchSelectExited();
    }
}
