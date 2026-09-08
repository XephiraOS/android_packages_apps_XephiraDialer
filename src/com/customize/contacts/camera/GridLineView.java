package com.customize.contacts.camera;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.android.contacts.V0;
import com.oplus.dialer.R;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: GridLineView.kt */
/* loaded from: classes3.dex */
public final class GridLineView extends View {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20858c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Paint f20859a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20860b;

    /* compiled from: GridLineView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth();
        float f10 = width / 3.0f;
        float height = getHeight();
        float f11 = height / 3.0f;
        canvas.drawLine(0.0f, f11, width, f11, this.f20859a);
        canvas.drawLine(f10, 0.0f, f10, height, this.f20859a);
        float f12 = 2;
        float f13 = f11 * f12;
        canvas.drawLine(0.0f, f13, width, f13, this.f20859a);
        float f14 = f10 * f12;
        canvas.drawLine(f14, 0.0f, f14, height, this.f20859a);
    }

    public /* synthetic */ GridLineView(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLineView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V0.f13335R2);
        i.e(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.GridLineView)");
        float dimension = obtainStyledAttributes.getDimension(1, 0.0f);
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        this.f20860b = getResources().getDimensionPixelSize(R.dimen.camera_control_height);
        Paint paint = new Paint();
        this.f20859a = paint;
        paint.setColor(color);
        paint.setStrokeWidth(dimension);
        paint.setStyle(Paint.Style.FILL);
    }
}
