package com.coui.appcompat.roundRect;

import android.graphics.Path;
import android.graphics.RectF;
import com.oplus.graphics.OplusPath;

/* loaded from: classes.dex */
public class COUIShapePath {
    public static Path getRoundRectPath(Path path, RectF rectF, float f10, boolean z10, boolean z11, boolean z12, boolean z13) {
        float f11;
        float f12;
        float f13 = f10 < 0.0f ? 0.0f : f10;
        path.reset();
        float f14 = rectF.left;
        float f15 = rectF.right;
        float f16 = rectF.bottom;
        float f17 = rectF.top;
        float f18 = f15 - f14;
        float f19 = f16 - f17;
        float f20 = f18 / 2.0f;
        float f21 = f19 / 2.0f;
        float min = ((double) (f13 / Math.min(f20, f21))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f13 / Math.min(f20, f21)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float min2 = f13 / Math.min(f20, f21) > 0.6f ? 1.0f + (Math.min(1.0f, ((f13 / Math.min(f20, f21)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        path.moveTo(f14 + f20, f17);
        if (!z11) {
            path.lineTo(f14 + f18, f17);
            f11 = f20;
        } else {
            float f22 = f13 / 100.0f;
            float f23 = f22 * 128.19f * min;
            path.lineTo(Math.max(f20, f18 - f23) + f14, f17);
            float f24 = f14 + f18;
            float f25 = f22 * 83.62f * min2;
            float f26 = f22 * 67.45f;
            float f27 = f22 * 4.64f;
            float f28 = f22 * 51.16f;
            float f29 = f22 * 13.36f;
            f11 = f20;
            path.cubicTo(f24 - f25, f17, f24 - f26, f17 + f27, f24 - f28, f17 + f29);
            float f30 = f22 * 34.86f;
            float f31 = f22 * 22.07f;
            path.cubicTo(f24 - f30, f17 + f31, f24 - f31, f17 + f30, f24 - f29, f17 + f28);
            path.cubicTo(f24 - f27, f17 + f26, f24, f17 + f25, f24, f17 + Math.min(f21, f23));
        }
        if (!z13) {
            path.lineTo(f18 + f14, f17 + f19);
            f12 = f11;
        } else {
            float f32 = f14 + f18;
            float f33 = f13 / 100.0f;
            float f34 = f33 * 128.19f * min;
            path.lineTo(f32, Math.max(f21, f19 - f34) + f17);
            float f35 = f17 + f19;
            float f36 = f33 * 83.62f * min2;
            float f37 = f33 * 4.64f;
            float f38 = f33 * 67.45f;
            float f39 = f33 * 13.36f;
            float f40 = f33 * 51.16f;
            path.cubicTo(f32, f35 - f36, f32 - f37, f35 - f38, f32 - f39, f35 - f40);
            float f41 = f33 * 22.07f;
            float f42 = f33 * 34.86f;
            path.cubicTo(f32 - f41, f35 - f42, f32 - f42, f35 - f41, f32 - f40, f35 - f39);
            float f43 = f32 - f36;
            f12 = f11;
            path.cubicTo(f32 - f38, f35 - f37, f43, f35, f14 + Math.max(f12, f18 - f34), f35);
        }
        if (!z12) {
            path.lineTo(f14, f19 + f17);
        } else {
            float f44 = f13 / 100.0f;
            float f45 = f44 * 128.19f * min;
            float f46 = f17 + f19;
            path.lineTo(Math.min(f12, f45) + f14, f46);
            float f47 = f44 * 83.62f * min2;
            float f48 = f44 * 67.45f;
            float f49 = f44 * 4.64f;
            float f50 = f44 * 51.16f;
            float f51 = f44 * 13.36f;
            path.cubicTo(f14 + f47, f46, f14 + f48, f46 - f49, f14 + f50, f46 - f51);
            float f52 = f44 * 34.86f;
            float f53 = f44 * 22.07f;
            path.cubicTo(f14 + f52, f46 - f53, f14 + f53, f46 - f52, f14 + f51, f46 - f50);
            path.cubicTo(f14 + f49, f46 - f48, f14, f46 - f47, f14, f17 + Math.max(f21, f19 - f45));
        }
        if (!z10) {
            path.lineTo(f14, f17);
        } else {
            float f54 = f13 / 100.0f;
            float f55 = 128.19f * f54 * min;
            path.lineTo(f14, Math.min(f21, f55) + f17);
            float f56 = 83.62f * f54 * min2;
            float f57 = 4.64f * f54;
            float f58 = 67.45f * f54;
            float f59 = 13.36f * f54;
            float f60 = 51.16f * f54;
            path.cubicTo(f14, f17 + f56, f14 + f57, f17 + f58, f14 + f59, f17 + f60);
            float f61 = 22.07f * f54;
            float f62 = f54 * 34.86f;
            path.cubicTo(f14 + f61, f17 + f62, f14 + f62, f17 + f61, f14 + f60, f17 + f59);
            path.cubicTo(f14 + f58, f17 + f57, f14 + f56, f17, f14 + Math.min(f12, f55), f17);
        }
        path.close();
        return path;
    }

    public static Path getSmoothRoundRectPath(Path path, RectF rectF, float f10, float f11, boolean z10, boolean z11, boolean z12, boolean z13) {
        if (path != null && rectF != null) {
            float[] fArr = new float[8];
            path.reset();
            float f12 = z10 ? f10 : 0.0f;
            float f13 = z11 ? f10 : 0.0f;
            float f14 = z12 ? f10 : 0.0f;
            if (!z13) {
                f10 = 0.0f;
            }
            fArr[1] = f12;
            fArr[0] = f12;
            fArr[3] = f13;
            fArr[2] = f13;
            fArr[5] = f14;
            fArr[4] = f14;
            fArr[7] = f10;
            fArr[6] = f10;
            if (isWeightValid(f11)) {
                new OplusPath(path).addSmoothRoundRect(rectF, fArr, Path.Direction.CW, f11);
            } else {
                path.addRoundRect(rectF, fArr, Path.Direction.CW);
            }
        }
        return path;
    }

    private static boolean isWeightValid(float f10) {
        if (f10 != 0.0f) {
            return true;
        }
        return false;
    }

    public static Path getSmoothRoundRectPath(Path path, RectF rectF, float f10, float f11) {
        return getSmoothRoundRectPath(path, rectF, f10, f11, true, true, true, true);
    }

    public static Path getRoundRectPath(Path path, RectF rectF, float f10, float f11) {
        float f12 = f10 < 0.0f ? 0.0f : f10;
        float f13 = f11 < 0.0f ? 0.0f : f11;
        path.reset();
        float f14 = rectF.left;
        float f15 = rectF.right;
        float f16 = rectF.bottom;
        float f17 = rectF.top;
        float f18 = f15 - f14;
        float f19 = f16 - f17;
        float f20 = f18 / 2.0f;
        float f21 = f19 / 2.0f;
        float min = f12 / Math.min(f20, f21);
        float min2 = ((double) min) > 0.5d ? 1.0f - (Math.min(1.0f, (min - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float min3 = f13 / Math.min(f20, f21);
        float min4 = ((double) min3) > 0.5d ? 1.0f - (Math.min(1.0f, (min3 - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float min5 = min > 0.6f ? (Math.min(1.0f, (min - 0.6f) / 0.3f) * 0.042454004f) + 1.0f : 1.0f;
        float min6 = min3 > 0.6f ? 1.0f + (Math.min(1.0f, (min3 - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        path.moveTo(f14 + f20, f17);
        float f22 = f12 / 100.0f;
        float f23 = f22 * 128.19f * min2;
        path.lineTo(Math.max(f20, f18 - f23) + f14, f17);
        float f24 = f14 + f18;
        float f25 = f22 * 83.62f * min5;
        float f26 = f22 * 67.45f;
        float f27 = f22 * 4.64f;
        float f28 = f17 + f27;
        float f29 = f22 * 51.16f;
        float f30 = f22 * 13.36f;
        float f31 = f17 + f30;
        path.cubicTo(f24 - f25, f17, f24 - f26, f28, f24 - f29, f31);
        float f32 = f22 * 34.86f;
        float f33 = f22 * 22.07f;
        float f34 = f17 + f33;
        float f35 = f17 + f32;
        float f36 = f17 + f29;
        path.cubicTo(f24 - f32, f34, f24 - f33, f35, f24 - f30, f36);
        float f37 = f17 + f26;
        float f38 = f17 + f25;
        path.cubicTo(f24 - f27, f37, f24, f38, f24, f17 + Math.min(f21, f23));
        float f39 = f13 / 100.0f;
        float f40 = min4 * 128.19f * f39;
        float f41 = f19 - f40;
        path.lineTo(f24, Math.max(f21, f41) + f17);
        float f42 = f19 + f17;
        float f43 = 83.62f * f39 * min6;
        float f44 = f42 - f43;
        float f45 = 4.64f * f39;
        float f46 = 67.45f * f39;
        float f47 = f42 - f46;
        float f48 = 13.36f * f39;
        float f49 = 51.16f * f39;
        float f50 = f42 - f49;
        path.cubicTo(f24, f44, f24 - f45, f47, f24 - f48, f50);
        float f51 = 22.07f * f39;
        float f52 = f39 * 34.86f;
        float f53 = f42 - f52;
        float f54 = f42 - f51;
        float f55 = f42 - f48;
        path.cubicTo(f24 - f51, f53, f24 - f52, f54, f24 - f49, f55);
        float f56 = f42 - f45;
        path.cubicTo(f24 - f46, f56, f24 - f43, f42, f14 + Math.max(f20, f18 - f40), f42);
        path.lineTo(f14 + Math.min(f20, f40), f42);
        path.cubicTo(f14 + f43, f42, f14 + f46, f56, f14 + f49, f55);
        path.cubicTo(f14 + f52, f54, f14 + f51, f53, f14 + f48, f50);
        path.cubicTo(f14 + f45, f47, f14, f44, f14, f17 + Math.max(f21, f41));
        path.lineTo(f14, Math.min(f21, f23) + f17);
        path.cubicTo(f14, f38, f14 + f27, f37, f14 + f30, f36);
        path.cubicTo(f14 + f33, f35, f14 + f32, f34, f14 + f29, f31);
        path.cubicTo(f14 + f26, f28, f14 + f25, f17, f14 + Math.min(f20, f23), f17);
        path.close();
        return path;
    }

    public static Path getRoundRectPath(Path path, RectF rectF, float f10) {
        return getRoundRectPath(path, rectF, f10, true, true, true, true);
    }
}
