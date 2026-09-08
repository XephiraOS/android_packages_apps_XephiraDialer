package com.coui.appcompat.uiutil;

import X8.f;
import X8.i;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.version.COUIVersionUtil;
import com.oplus.view.OplusView;

/* loaded from: classes3.dex */
public class ShadowUtils {
    public static final int SDK_SUB_VERSION = 2;
    public static final int SDK_VERSION = 34;
    public static final int SHADOW_LV1 = 0;
    public static final int SHADOW_LV2 = 1;
    public static final int SHADOW_LV3 = 2;
    public static final int SHADOW_LV4 = 3;
    public static final int SHADOW_LV5 = 4;
    private static final String TAG = "ShadowUtils";

    public static boolean checkOPlusViewElevationSDK() {
        return COUIVersionUtil.checkOPlusViewSubSDK(34, 2);
    }

    public static void clearShadow(View view) {
        if (checkOPlusViewElevationSDK()) {
            setElevationToViewFromOPlusView(view, 0, 0, 0, 0, 0, -1);
        } else {
            setElevationToViewFromLower(view, 0, 0, 0);
        }
    }

    public static void setElevationToView(View view, int i10) {
        setElevationToView(view, i10, 0, 0, 0);
    }

    public static void setElevationToViewFromLower(View view, int i10, int i11, int i12) {
        if (view == null) {
            return;
        }
        view.setOutlineSpotShadowColor(i11);
        view.setElevation(i10);
    }

    public static void setElevationToViewFromOPlusView(View view, int i10, int i11, int i12, int i13, int i14, int i15) {
        if (view != null && checkOPlusViewElevationSDK()) {
            view.setOutlineAmbientShadowColor(i11);
            view.setOutlineSpotShadowColor(i11);
            view.setElevation(i10);
            try {
                new OplusView(view).setOverrideLightSourceGeometry(-1.0f, i12, i13, i14, i15);
            } catch (Exception e10) {
                COUILog.d(TAG, "setOverrideLightSourceGeometry error:" + e10.getMessage());
            }
        }
    }

    public static void setElevationToView(View view, int i10, int i11, int i12) {
        setElevationToView(view, i10, i11, view.getResources().getDimensionPixelOffset(f.f4530J5), i12);
    }

    public static void setElevationToView(View view, int i10, int i11, int i12, int i13) {
        if (view == null) {
            COUILog.e(TAG, "setElevationToView view is null");
            return;
        }
        if (checkOPlusViewElevationSDK()) {
            Resources resources = view.getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(f.f4776q4);
            if (i10 == 0) {
                setElevationToViewFromOPlusView(view, dimensionPixelSize, Color.argb(resources.getInteger(i.f4963b), 0, 0, 0), resources.getDimensionPixelSize(f.f4834y4), resources.getDimensionPixelSize(f.f4487D4), resources.getDimensionPixelSize(f.f4799t4), resources.getDimensionPixelSize(f.f4736l4));
                return;
            }
            if (i10 == 1) {
                setElevationToViewFromOPlusView(view, dimensionPixelSize, Color.argb(resources.getInteger(i.f4964c), 0, 0, 0), resources.getDimensionPixelSize(f.f4841z4), resources.getDimensionPixelSize(f.f4494E4), resources.getDimensionPixelSize(f.f4806u4), resources.getDimensionPixelSize(f.f4744m4));
                return;
            }
            if (i10 == 2) {
                setElevationToViewFromOPlusView(view, dimensionPixelSize, Color.argb(resources.getInteger(i.f4965d), 0, 0, 0), resources.getDimensionPixelSize(f.f4466A4), resources.getDimensionPixelSize(f.f4501F4), resources.getDimensionPixelSize(f.f4813v4), resources.getDimensionPixelSize(f.f4752n4));
                return;
            } else if (i10 == 3) {
                setElevationToViewFromOPlusView(view, resources.getDimensionPixelSize(f.f4792s4), Color.argb(resources.getInteger(i.f4966e), 0, 0, 0), resources.getDimensionPixelSize(f.f4473B4), resources.getDimensionPixelSize(f.f4508G4), resources.getDimensionPixelSize(f.f4820w4), resources.getDimensionPixelSize(f.f4760o4));
                return;
            } else {
                if (i10 == 4) {
                    setElevationToViewFromOPlusView(view, resources.getDimensionPixelSize(f.f4784r4), Color.argb(resources.getInteger(i.f4967f), 0, 0, 0), resources.getDimensionPixelSize(f.f4480C4), resources.getDimensionPixelSize(f.f4515H4), resources.getDimensionPixelSize(f.f4827x4), resources.getDimensionPixelSize(f.f4768p4));
                    return;
                }
                return;
            }
        }
        setElevationToViewFromLower(view, i11, i13, i12);
    }
}
