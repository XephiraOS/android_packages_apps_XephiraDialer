package com.coui.appcompat.panel;

/* loaded from: classes.dex */
public interface COUIPanelPullUpListener {
    void onCancel();

    int onDragging(int i10, int i11);

    void onDraggingPanel();

    void onOffsetChanged(float f10);

    void onReleased(int i10);

    void onReleasedDrag();
}
