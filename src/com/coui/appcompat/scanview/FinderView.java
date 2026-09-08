package com.coui.appcompat.scanview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import f.C0991a;
import kotlin.jvm.internal.i;

/* compiled from: FinderView.kt */
/* loaded from: classes.dex */
public final class FinderView extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_SCAN_TOP = -60;
    private static final int SPEED_DISTANCE = 10;
    private static final String TAG = "FinderView";
    private boolean canDraw;
    private boolean keepDrawing;
    private Drawable scanDrawable;
    private int scanLineHeight;
    private int scannerTop;

    /* compiled from: FinderView.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinderView(Context context) {
        super(context);
        i.f(context, "context");
        this.scannerTop = DEFAULT_SCAN_TOP;
        this.keepDrawing = true;
        setWillNotDraw(false);
        this.canDraw = false;
        this.scanLineHeight = getResources().getDimensionPixelSize(Z8.c.f5997R);
        this.scanDrawable = C0991a.b(context, Z8.d.f6058a);
    }

    public final void keepDrawing(boolean z10) {
        this.keepDrawing = z10;
        if (z10) {
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        if (!this.canDraw) {
            return;
        }
        int i10 = this.scannerTop + 10;
        this.scannerTop = i10;
        if (i10 > getMeasuredHeight() - this.scanLineHeight) {
            this.scannerTop = 0;
        }
        Drawable drawable = this.scanDrawable;
        if (drawable != null) {
            drawable.setBounds(0, this.scannerTop, getMeasuredWidth(), this.scannerTop + this.scanLineHeight);
        }
        Drawable drawable2 = this.scanDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (this.keepDrawing) {
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int i10) {
        boolean z10;
        i.f(changedView, "changedView");
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.canDraw = z10;
        super.onVisibilityChanged(changedView, i10);
    }

    public final void resetAllView() {
        this.keepDrawing = true;
        removeAllViews();
    }
}
