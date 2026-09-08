package com.coui.appcompat.poplist;

import android.util.Log;
import android.view.View;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: WindowSpacingControlHelper.kt */
/* loaded from: classes.dex */
public final class WindowSpacingControlHelper {
    private final String TAG = "WindowSpacingControlHelper";
    private Map<AnchorViewTypeEnum, Integer> marginMap = new HashMap();
    public static final Companion Companion = new Companion(null);
    private static final int ORIENTATION_VERTICAL_TOP = 1;
    private static final int ORIENTATION_VERTICAL_BOTTOM = 2;

    /* compiled from: WindowSpacingControlHelper.kt */
    /* loaded from: classes.dex */
    public enum AnchorViewTypeEnum {
        NORMAL,
        TOOLBAR,
        NAVIGATION,
        START,
        END,
        TOP,
        BOTTOM
    }

    /* compiled from: WindowSpacingControlHelper.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final int getORIENTATION_VERTICAL_BOTTOM() {
            return WindowSpacingControlHelper.ORIENTATION_VERTICAL_BOTTOM;
        }

        public final int getORIENTATION_VERTICAL_TOP() {
            return WindowSpacingControlHelper.ORIENTATION_VERTICAL_TOP;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public static /* synthetic */ void getORIENTATION_VERTICAL_BOTTOM$annotations() {
        }

        public static /* synthetic */ void getORIENTATION_VERTICAL_TOP$annotations() {
        }
    }

    /* compiled from: WindowSpacingControlHelper.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnchorViewTypeEnum.values().length];
            try {
                iArr[AnchorViewTypeEnum.TOOLBAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnchorViewTypeEnum.NAVIGATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final boolean checkViewFromEnumType(View view, AnchorViewTypeEnum anchorViewTypeEnum) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[anchorViewTypeEnum.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return false;
            }
            return view instanceof BottomNavigationView;
        }
        return view instanceof COUIToolbar;
    }

    private final int getEnumViewSpacing(Integer num, View view, AnchorViewTypeEnum anchorViewTypeEnum) {
        Integer num2;
        View view2 = view;
        while (view2 != null) {
            if (checkViewFromEnumType(view2, anchorViewTypeEnum)) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                view2.getLocationInWindow(iArr2);
                if (num != null) {
                    num2 = Integer.valueOf(num.intValue() + getOrientationSpacing(view2, view, iArr2, iArr, anchorViewTypeEnum));
                } else {
                    num2 = null;
                }
                if (num2 == null) {
                    return 0;
                }
                return num2.intValue();
            }
            if (!(view2.getParent() instanceof View)) {
                Log.e(WindowSpacingControlHelper.class.getName(), "getToolbarViewSpacing  tempView " + view2.getClass().getName());
                if (num == null) {
                    return 0;
                }
                return num.intValue();
            }
            Object parent = view2.getParent();
            kotlin.jvm.internal.i.d(parent, "null cannot be cast to non-null type android.view.View");
            view2 = (View) parent;
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static final int getORIENTATION_VERTICAL_BOTTOM() {
        return Companion.getORIENTATION_VERTICAL_BOTTOM();
    }

    public static final int getORIENTATION_VERTICAL_TOP() {
        return Companion.getORIENTATION_VERTICAL_TOP();
    }

    private final int getOrientationSpacing(View view, View view2, int[] iArr, int[] iArr2, AnchorViewTypeEnum anchorViewTypeEnum) {
        int height;
        int height2;
        int orientationValue = getOrientationValue(anchorViewTypeEnum);
        if (orientationValue == ORIENTATION_VERTICAL_TOP) {
            height = iArr[1];
            height2 = iArr2[1];
        } else if (orientationValue == ORIENTATION_VERTICAL_BOTTOM) {
            height = iArr[1] + view.getHeight();
            height2 = iArr2[1] + view2.getHeight();
        } else {
            return 0;
        }
        return height - height2;
    }

    public final void addAnchorViewSpacingMap(int i10, AnchorViewTypeEnum enumType) {
        kotlin.jvm.internal.i.f(enumType, "enumType");
        Map<AnchorViewTypeEnum, Integer> map = this.marginMap;
        if (map != null) {
            map.put(enumType, Integer.valueOf(i10));
        }
    }

    public final boolean checkInMarginMap(AnchorViewTypeEnum enumType) {
        kotlin.jvm.internal.i.f(enumType, "enumType");
        if (this.marginMap.isEmpty()) {
            return false;
        }
        Iterator<AnchorViewTypeEnum> it = this.marginMap.keySet().iterator();
        while (it.hasNext()) {
            if (it.next() == enumType) {
                return true;
            }
        }
        return false;
    }

    public final View getAnchorViewParentView(View anchorView, AnchorViewTypeEnum viewTypeEnum) {
        kotlin.jvm.internal.i.f(anchorView, "anchorView");
        kotlin.jvm.internal.i.f(viewTypeEnum, "viewTypeEnum");
        while (!checkViewFromEnumType(anchorView, viewTypeEnum)) {
            if (!(anchorView.getParent() instanceof View)) {
                Log.e(WindowSpacingControlHelper.class.getName(), "getAnchorViewParentView  tempView " + anchorView.getClass().getName());
                return anchorView;
            }
            Object parent = anchorView.getParent();
            kotlin.jvm.internal.i.d(parent, "null cannot be cast to non-null type android.view.View");
            anchorView = (View) parent;
        }
        return anchorView;
    }

    public final int getAnchorViewSpacing(AnchorViewTypeEnum enumType) {
        Integer num;
        kotlin.jvm.internal.i.f(enumType, "enumType");
        if (this.marginMap.isEmpty() || this.marginMap.get(enumType) == null || (num = this.marginMap.get(enumType)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final AnchorViewTypeEnum getAnchorViewTypeEnum(View anchorView) {
        kotlin.jvm.internal.i.f(anchorView, "anchorView");
        while (!(anchorView instanceof COUIToolbar)) {
            if (anchorView instanceof BottomNavigationView) {
                return AnchorViewTypeEnum.NAVIGATION;
            }
            if (!(anchorView.getParent() instanceof View)) {
                Log.e(WindowSpacingControlHelper.class.getName(), "getAnchorViewTypeEnum  tempView " + anchorView.getClass().getName());
                return AnchorViewTypeEnum.NORMAL;
            }
            Object parent = anchorView.getParent();
            kotlin.jvm.internal.i.d(parent, "null cannot be cast to non-null type android.view.View");
            anchorView = (View) parent;
        }
        return AnchorViewTypeEnum.TOOLBAR;
    }

    public final Map<AnchorViewTypeEnum, Integer> getMarginMap() {
        return this.marginMap;
    }

    public final int getOrientationValue(AnchorViewTypeEnum enumType) {
        kotlin.jvm.internal.i.f(enumType, "enumType");
        int i10 = WhenMappings.$EnumSwitchMapping$0[enumType.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return ORIENTATION_VERTICAL_TOP;
            }
            return ORIENTATION_VERTICAL_TOP;
        }
        return ORIENTATION_VERTICAL_BOTTOM;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final boolean isUtilMapInit() {
        return !this.marginMap.isEmpty();
    }

    public final void setMarginMap(Map<AnchorViewTypeEnum, Integer> map) {
        kotlin.jvm.internal.i.f(map, "<set-?>");
        this.marginMap = map;
    }

    public final void setOriginCenterPoint(int[] anchorViewLocationInScreen, int[] resultOriginCenterPoint, View anchorView) {
        kotlin.jvm.internal.i.f(anchorViewLocationInScreen, "anchorViewLocationInScreen");
        kotlin.jvm.internal.i.f(resultOriginCenterPoint, "resultOriginCenterPoint");
        kotlin.jvm.internal.i.f(anchorView, "anchorView");
        if (anchorView.getWidth() <= 0 || anchorView.getHeight() <= 0) {
            Log.e(this.TAG, "setOriginCenterPoint anchorView.width <= 0 or anchorView.height <= 0");
            resultOriginCenterPoint[0] = (int) anchorView.getPivotX();
            resultOriginCenterPoint[1] = (int) anchorView.getPivotY();
        }
        float pivotX = anchorView.getPivotX() / anchorView.getWidth();
        float pivotY = anchorView.getPivotY() / anchorView.getHeight();
        float f10 = 2;
        float scaleX = anchorViewLocationInScreen[0] + ((anchorView.getScaleX() * anchorView.getWidth()) / f10);
        float scaleY = anchorViewLocationInScreen[1] + ((anchorView.getScaleY() * anchorView.getHeight()) / f10);
        float f11 = 1;
        resultOriginCenterPoint[0] = Math.round(scaleX + ((pivotX - 0.5f) * (anchorView.getScaleX() - f11) * anchorView.getWidth()));
        resultOriginCenterPoint[1] = Math.round(scaleY + ((pivotY - 0.5f) * (anchorView.getScaleY() - f11) * anchorView.getHeight()));
    }

    public final int getAnchorViewSpacing(View anchorView, AnchorViewTypeEnum enumType) {
        kotlin.jvm.internal.i.f(anchorView, "anchorView");
        kotlin.jvm.internal.i.f(enumType, "enumType");
        if (this.marginMap.isEmpty() || this.marginMap.get(enumType) == null) {
            return 0;
        }
        return getEnumViewSpacing(this.marginMap.get(enumType), anchorView, enumType);
    }
}
