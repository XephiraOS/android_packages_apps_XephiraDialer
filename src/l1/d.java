package L1;

import android.hardware.display.DisplayManager;
import android.view.Display;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.internal_dependency.AddOnSdkDepends;
import kotlin.jvm.internal.i;

/* compiled from: ScreenStatusUtils.kt */
/* loaded from: classes.dex */
public final class d {
    public static final /* synthetic */ Display a(DisplayManager displayManager) {
        return d(displayManager);
    }

    public static final /* synthetic */ Display b(DisplayManager displayManager) {
        return e(displayManager);
    }

    public static final /* synthetic */ boolean c(Display display) {
        return f(display);
    }

    public static final Display d(DisplayManager displayManager) {
        return displayManager.getDisplay(0);
    }

    public static final Display e(DisplayManager displayManager) {
        String str;
        boolean z10 = OplusFeatureOption.OPLUS_CTA_SUPPORT;
        if (OplusFeatureOption.VERSION_STORE) {
            AddOnSdkDepends.Companion companion = AddOnSdkDepends.Companion;
            OplusFeatureOption.FEATURE_FOLD = companion.getSInstance().hasFeature("oplus.hardware.type.fold");
            OplusFeatureOption.FEATURE_FOLD_REMAP_DISPLAY_DISABLED = companion.getSInstance().hasFeature("oplus.software.fold_remap_display_disabled");
        }
        if (!OplusFeatureOption.FEATURE_FOLD) {
            Log.d("FoldScreenStatusUtils", "getDragonflyDisplay: not support fold");
            return null;
        }
        if (!OplusFeatureOption.FEATURE_FOLD_REMAP_DISPLAY_DISABLED) {
            Log.d("FoldScreenStatusUtils", "getDragonflyDisplay: not Dragonfly fold display");
            return null;
        }
        Display d10 = d(displayManager);
        int i10 = 0;
        if (OplusFeatureOption.VERSION_STORE) {
            Display[] displays = displayManager.getDisplays("android.hardware.display.category.BUILTIN");
            i.e(displays, "getDisplays(DISPLAY_CATEGORY_BUILTIN)");
            for (Display display : displays) {
                if (display.getDisplayId() != 0) {
                    return display;
                }
            }
            Display[] displays2 = displayManager.getDisplays("android.hardware.display.category.ALL_INCLUDING_DISABLED");
            i.e(displays2, "getDisplays(DisplayManag…Y_ALL_INCLUDING_DISABLED)");
            int length = displays2.length;
            while (i10 < length) {
                Display display2 = displays2[i10];
                if (display2.getDisplayId() == 1) {
                    return display2;
                }
                i10++;
            }
            Display display3 = displayManager.getDisplay(1);
            if (display3 != null) {
                return display3;
            }
        } else {
            Display[] displays3 = displayManager.getDisplays("android.hardware.display.category.ALL_INCLUDING_DISABLED");
            i.e(displays3, "getDisplays(DisplayManag…Y_ALL_INCLUDING_DISABLED)");
            int length2 = displays3.length;
            while (i10 < length2) {
                Display display4 = displays3[i10];
                if (display4.getDisplayId() != 0) {
                    String name = display4.getName();
                    if (d10 != null) {
                        str = d10.getName();
                    } else {
                        str = null;
                    }
                    if (name.equals(str)) {
                        return display4;
                    }
                }
                i10++;
            }
        }
        Log.d("FoldScreenStatusUtils", "getDragonflyDisplay: no matching display");
        return null;
    }

    public static final boolean f(Display display) {
        if (display != null && display.getState() != 1) {
            return true;
        }
        return false;
    }
}
