package com.coui.appcompat.view;

import X8.e;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.S;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class COUIResponsiveGridMaskView extends View {
    private static final boolean DEBUG = true;
    private static final String TAG = "COUIResponsiveGridMaskView";
    private int mColumnCount;
    private final Paint mColumnPaint;
    private final Rect mColumnRect;
    private int[] mColumnWidth;
    private Context mContext;
    private int mGutter;
    private int mMargin;
    private final Paint mMarginPaint;
    private final Rect mMarginRect;
    private MarginType mMarginType;
    private ResponsiveUIModel mResponsiveUIModel;

    public COUIResponsiveGridMaskView(Context context) {
        super(context);
        this.mColumnCount = 0;
        this.mGutter = 0;
        this.mMargin = 0;
        this.mMarginType = MarginType.MARGIN_SMALL;
        this.mMarginRect = new Rect();
        this.mColumnRect = new Rect();
        this.mMarginPaint = new Paint();
        this.mColumnPaint = new Paint();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mResponsiveUIModel = new ResponsiveUIModel(context, 0, 0);
        requestLatestGridParams();
        this.mMarginPaint.setColor(COUIContextUtil.getColor(context, e.f4434K));
        this.mColumnPaint.setColor(COUIContextUtil.getColor(context, e.f4433J));
    }

    private void requestLatestGridParams() {
        this.mResponsiveUIModel.chooseMargin(this.mMarginType);
        this.mColumnCount = this.mResponsiveUIModel.columnCount();
        this.mColumnWidth = this.mResponsiveUIModel.columnWidth();
        this.mGutter = this.mResponsiveUIModel.gutter();
        this.mMargin = this.mResponsiveUIModel.margin();
        int i10 = 0;
        for (int i11 : this.mColumnWidth) {
            Log.d(TAG, "requestLatestGridParams: " + i11);
            i10 += i11;
        }
        Log.d(TAG, "requestLatestGridParams: \ngetMeasureWidth() = " + getMeasuredWidth() + "\nmMargin = " + this.mMargin + "\nmGutter = " + this.mGutter + "\nmColumnWidth = " + Arrays.toString(this.mColumnWidth) + "\nmColumnCount = " + this.mColumnCount + "\nsum(columnWidth) = " + i10 + "\ntotal = (mMargin * 2) + (mColumnWidth * mColumnCount) + (mGutter * (mColumnCount - 1)) = " + ((this.mMargin * 2) + i10 + (this.mGutter * (this.mColumnCount - 1))));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.mContext = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        int i11;
        super.onDraw(canvas);
        if (S.b(this)) {
            int measuredWidth = getMeasuredWidth();
            Log.d(TAG, "onDraw: total" + getMeasuredWidth());
            this.mMarginRect.set(measuredWidth, 0, measuredWidth - ((int) (((float) this.mMargin) + 0.0f)), getHeight());
            canvas.drawRect(this.mMarginRect, this.mMarginPaint);
            Log.d(TAG, "onDraw: right margin:0.0" + com.android.incallui.Log.TAG_DELIMETER + (this.mMargin + 0.0f));
            float f10 = ((float) this.mMargin) + 0.0f;
            for (int i12 = 0; i12 < this.mColumnCount; i12++) {
                this.mColumnRect.set(measuredWidth - ((int) f10), 0, measuredWidth - ((int) (this.mColumnWidth[i12] + f10)), getHeight());
                canvas.drawRect(this.mColumnRect, this.mColumnPaint);
                Log.d(TAG, "onDraw: column:" + f10 + com.android.incallui.Log.TAG_DELIMETER + (this.mColumnWidth[i12] + f10));
                if (i12 != this.mColumnCount - 1) {
                    Log.d(TAG, "onDraw: gap:" + (this.mColumnWidth[i12] + f10) + com.android.incallui.Log.TAG_DELIMETER + (this.mColumnWidth[i12] + f10 + this.mGutter));
                }
                int i13 = this.mColumnWidth[i12];
                if (i12 == this.mColumnCount - 1) {
                    i11 = 0;
                } else {
                    i11 = this.mGutter;
                }
                f10 += i13 + i11;
            }
            this.mMarginRect.set(measuredWidth - ((int) f10), 0, measuredWidth - ((int) (this.mMargin + f10)), getHeight());
            canvas.drawRect(this.mMarginRect, this.mMarginPaint);
            Log.d(TAG, "onDraw: left margin:" + f10 + com.android.incallui.Log.TAG_DELIMETER + (this.mMargin + f10));
            return;
        }
        Log.d(TAG, "onDraw: total width: " + getMeasuredWidth());
        this.mMarginRect.set(0, 0, (int) (((float) this.mMargin) + 0.0f), getHeight());
        canvas.drawRect(this.mMarginRect, this.mMarginPaint);
        Log.d(TAG, "onDraw: left margin: 0.0" + com.android.incallui.Log.TAG_DELIMETER + (this.mMargin + 0.0f) + " width: " + this.mMargin);
        float f11 = ((float) this.mMargin) + 0.0f;
        for (int i14 = 0; i14 < this.mColumnCount; i14++) {
            this.mColumnRect.set((int) f11, 0, (int) (this.mColumnWidth[i14] + f11), getHeight());
            canvas.drawRect(this.mColumnRect, this.mColumnPaint);
            Log.d(TAG, "onDraw: column " + i14 + " :" + f11 + com.android.incallui.Log.TAG_DELIMETER + (this.mColumnWidth[i14] + f11) + " width: " + this.mColumnWidth[i14]);
            if (i14 != this.mColumnCount - 1) {
                Log.d(TAG, "onDraw: gap " + i14 + " :" + (this.mColumnWidth[i14] + f11) + com.android.incallui.Log.TAG_DELIMETER + (this.mColumnWidth[i14] + f11 + this.mGutter) + " width: " + this.mGutter);
            }
            int i15 = this.mColumnWidth[i14];
            if (i14 == this.mColumnCount - 1) {
                i10 = 0;
            } else {
                i10 = this.mGutter;
            }
            f11 += i15 + i10;
        }
        this.mMarginRect.set((int) f11, 0, (int) (this.mMargin + f11), getHeight());
        canvas.drawRect(this.mMarginRect, this.mMarginPaint);
        Log.d(TAG, "onDraw: right margin:" + f11 + com.android.incallui.Log.TAG_DELIMETER + (this.mMargin + f11) + " width:" + this.mMargin);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.mResponsiveUIModel.rebuild(getMeasuredWidth(), getMeasuredHeight());
        requestLatestGridParams();
    }

    public void setMarginType(MarginType marginType) {
        this.mMarginType = marginType;
    }

    public COUIResponsiveGridMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mColumnCount = 0;
        this.mGutter = 0;
        this.mMargin = 0;
        this.mMarginType = MarginType.MARGIN_SMALL;
        this.mMarginRect = new Rect();
        this.mColumnRect = new Rect();
        this.mMarginPaint = new Paint();
        this.mColumnPaint = new Paint();
        init(context);
    }

    public COUIResponsiveGridMaskView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mColumnCount = 0;
        this.mGutter = 0;
        this.mMargin = 0;
        this.mMarginType = MarginType.MARGIN_SMALL;
        this.mMarginRect = new Rect();
        this.mColumnRect = new Rect();
        this.mMarginPaint = new Paint();
        this.mColumnPaint = new Paint();
        init(context);
    }

    public COUIResponsiveGridMaskView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mColumnCount = 0;
        this.mGutter = 0;
        this.mMargin = 0;
        this.mMarginType = MarginType.MARGIN_SMALL;
        this.mMarginRect = new Rect();
        this.mColumnRect = new Rect();
        this.mMarginPaint = new Paint();
        this.mColumnPaint = new Paint();
        init(context);
    }
}
