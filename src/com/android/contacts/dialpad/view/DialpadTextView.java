package com.android.contacts.dialpad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes.dex */
public class DialpadTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    public Rect f15000a;

    /* renamed from: b, reason: collision with root package name */
    public String f15001b;

    public DialpadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15000a = new Rect();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        String str = this.f15001b;
        Rect rect = this.f15000a;
        canvas.drawText(str, -rect.left, -rect.top, paint);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f15001b = getText().toString();
        TextPaint paint = getPaint();
        String str = this.f15001b;
        paint.getTextBounds(str, 0, str.length(), this.f15000a);
        setMeasuredDimension(View.resolveSize(this.f15000a.width(), i10), View.resolveSize(Math.max(this.f15000a.height(), getMinHeight()), i11));
    }
}
