package com.android.contacts.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.V0;

/* loaded from: classes.dex */
public class ProportionalLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public Direction f18245a;

    /* renamed from: b, reason: collision with root package name */
    public float f18246b;

    /* loaded from: classes.dex */
    public enum Direction {
        widthToHeight("widthToHeight"),
        heightToWidth("heightToWidth");

        public final String mXmlName;

        Direction(String str) {
            this.mXmlName = str;
        }

        public static Direction b(String str) {
            Direction direction = widthToHeight;
            if (direction.mXmlName.equals(str)) {
                return direction;
            }
            Direction direction2 = heightToWidth;
            if (direction2.mXmlName.equals(str)) {
                return direction2;
            }
            throw new IllegalStateException("direction must be either " + direction.mXmlName + " or " + direction2.mXmlName);
        }
    }

    public ProportionalLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V0.f13468l4);
        this.f18245a = Direction.b(obtainStyledAttributes.getString(0));
        this.f18246b = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
    }

    public Direction getDirection() {
        return this.f18245a;
    }

    public float getRatio() {
        return this.f18246b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (getChildCount() == 1) {
            getChildAt(0).layout(0, 0, i12 - i10, i13 - i11);
            return;
        }
        throw new IllegalStateException("ProportionalLayout requires exactly one child");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            measureChild(childAt, i10, i11);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (this.f18245a == Direction.heightToWidth) {
                measuredWidth = Math.round(measuredHeight * this.f18246b);
            } else {
                measuredHeight = Math.round(measuredWidth * this.f18246b);
            }
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            setMeasuredDimension(View.resolveSize(measuredWidth, i10), View.resolveSize(measuredHeight, i11));
            return;
        }
        throw new IllegalStateException("ProportionalLayout requires exactly one child");
    }

    public void setDirection(Direction direction) {
        this.f18245a = direction;
    }

    public void setRatio(float f10) {
        this.f18246b = f10;
    }
}
