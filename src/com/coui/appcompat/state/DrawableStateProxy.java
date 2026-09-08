package com.coui.appcompat.state;

/* loaded from: classes.dex */
public interface DrawableStateProxy {
    public static final int STATE_ENABLED = 16842910;
    public static final int STATE_ENABLED_FLAG = 32;
    public static final int STATE_FOCUSED = 16842908;
    public static final int STATE_FOCUSED_FLAG = 2;
    public static final int STATE_HOVERED = 16843623;
    public static final int STATE_HOVERED_FLAG = 4;
    public static final int STATE_PRESSED = 16842919;
    public static final int STATE_PRESSED_FLAG = 16;
    public static final int STATE_SELECTED = 16842913;
    public static final int STATE_SELECTED_FLAG = 8;
    public static final int STATE_TOUCH_ENTERED = 1;
    public static final int STATE_TOUCH_ENTERED_FLAG = 1;
    public static final int TOUCH_TYPE_PRESSED = 0;
    public static final int TOUCH_TYPE_SELECTED = 1;

    int getTouchType();

    boolean isDrawableEnabled();

    boolean isEnabled();

    boolean isFocused();

    boolean isHovered();

    boolean isNativeStateEnabled(int i10);

    boolean isPressed();

    boolean isSelected();

    boolean isStateLocked(int i10);

    boolean isTouchEntered();

    void onViewStateChanged(int i10);

    void setDrawableEnabled(boolean z10);

    void setFocusEntered();

    void setFocusExited();

    void setHoverEntered();

    void setHoverExited();

    void setNativeStateEnabled(int i10, boolean z10);

    void setSelectedEntered();

    void setSelectedExited();

    void setStateLocked(int i10, boolean z10, boolean z11, boolean z12);

    void setTouchEntered();

    void setTouchExited();

    void setTouchSelectEntered();

    void setTouchSelectExited();
}
