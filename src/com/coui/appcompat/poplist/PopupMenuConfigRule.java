package com.coui.appcompat.poplist;

import android.graphics.Rect;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public interface PopupMenuConfigRule extends PopupMenuRule {
    public static final int BARRIER_FROM_BOTTOM = 3;
    public static final int BARRIER_FROM_LEFT = 0;
    public static final int BARRIER_FROM_RIGHT = 2;
    public static final int BARRIER_FROM_TOP = 1;
    public static final int BARRIER_GONE = -1;
    public static final int BARRIER_WINDOW = 4;
    public static final int TYPE_ANCHOR = 1;
    public static final int TYPE_BARRIER = 2;
    public static final int TYPE_SUBMENU_ANCHOR = 3;
    public static final int TYPE_WINDOW = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BarrierDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PopupMenuConfigType {
    }

    int getBarrierDirection();

    Rect getDisplayFrame();

    Rect getOutsets();

    boolean getPopupMenuRuleEnabled();

    int getType();

    void setPopupMenuRuleEnabled(boolean z10);
}
