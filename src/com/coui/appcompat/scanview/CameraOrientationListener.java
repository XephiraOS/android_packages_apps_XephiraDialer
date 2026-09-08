package com.coui.appcompat.scanview;

import android.content.Context;
import android.view.OrientationEventListener;
import kotlin.jvm.internal.i;

/* compiled from: CameraOrientationListener.kt */
/* loaded from: classes.dex */
public abstract class CameraOrientationListener extends OrientationEventListener {
    public static final int ANGLE_0 = 0;
    public static final int ANGLE_180 = 180;
    public static final int ANGLE_270 = 270;
    public static final int ANGLE_30 = 30;
    public static final int ANGLE_360 = 360;
    public static final int ANGLE_45 = 45;
    public static final int ANGLE_60 = 60;
    public static final int ANGLE_90 = 90;
    public static final int ANGLE_OFFSET = 5;
    public static final Companion Companion = new Companion(null);
    private int lastOrientation;

    /* compiled from: CameraOrientationListener.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraOrientationListener(Context context) {
        super(context);
        i.f(context, "context");
        this.lastOrientation = -1;
    }

    private final int roundOrientation(int i10, int i11) {
        int e10;
        if (i11 != -1) {
            int abs = Math.abs(i10 - i11);
            e10 = B9.i.e(abs, 360 - abs);
            if (e10 < 65) {
                return i11;
            }
        }
        return (((i10 + 30) / 90) * 90) % 360;
    }

    public abstract void onDirectionChanged(int i10);

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i10) {
        int roundOrientation;
        if (i10 != -1 && this.lastOrientation != (roundOrientation = roundOrientation(i10, this.lastOrientation))) {
            this.lastOrientation = roundOrientation;
            onDirectionChanged(roundOrientation);
        }
    }
}
