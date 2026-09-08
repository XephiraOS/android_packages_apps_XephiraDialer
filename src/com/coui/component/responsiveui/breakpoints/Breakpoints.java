package com.coui.component.responsiveui.breakpoints;

import com.coui.appcompat.statement.COUIIndividualStatementDialog;
import com.coui.component.responsiveui.unit.Dp;

/* compiled from: Breakpoints.kt */
/* loaded from: classes3.dex */
public final class Breakpoints {
    public static final Breakpoints INSTANCE = new Breakpoints();
    public static final Dp BP_MEDIUM_WINDOW_BASE_WIDTH = new Dp(600);
    public static final Dp BP_EXPANDED_WINDOW_BASE_WIDTH = new Dp(840);
    public static final Dp BP_MEDIUM_WINDOW_BASE_HEIGHT = new Dp(COUIIndividualStatementDialog.MEDIUM_LARGE_SCREEN_SW_THRESHOLD);
    public static final Dp BP_EXPANDED_WINDOW_BASE_HEIGHT = new Dp(900);

    public String toString() {
        return "BreakPoints Base-Width (" + BP_MEDIUM_WINDOW_BASE_WIDTH + ", " + BP_EXPANDED_WINDOW_BASE_WIDTH + "), Base-Height (" + BP_MEDIUM_WINDOW_BASE_HEIGHT + ", " + BP_EXPANDED_WINDOW_BASE_HEIGHT + ')';
    }
}
