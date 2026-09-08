package com.coui.appcompat.roundRect;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class COUIRoundRectUtil {
    private Path mPath;

    /* loaded from: classes.dex */
    public static final class SInstanceHolder {
        static final COUIRoundRectUtil sInstance = new COUIRoundRectUtil();

        private SInstanceHolder() {
        }
    }

    public static COUIRoundRectUtil getInstance() {
        return SInstanceHolder.sInstance;
    }

    public Path getPath(Rect rect, float f10) {
        return getPath(new RectF(rect), f10);
    }

    private COUIRoundRectUtil() {
        this.mPath = new Path();
    }

    public Path getPath(RectF rectF, float f10) {
        return COUIShapePath.getRoundRectPath(this.mPath, rectF, f10);
    }

    public Path getPath(float f10, float f11, float f12, float f13, float f14) {
        return getPath(new RectF(f10, f11, f12, f13), f14);
    }

    public Path getPath(float f10, float f11, float f12, float f13, float f14, boolean z10, boolean z11, boolean z12, boolean z13) {
        return COUIShapePath.getRoundRectPath(this.mPath, new RectF(f10, f11, f12, f13), f14, z10, z11, z12, z13);
    }
}
