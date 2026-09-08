package com.coui.appcompat.panel;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import c9.C0577i;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.grid.COUIPercentWidthFrameLayout;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.roundcorner.RoundCornerUtil;

/* loaded from: classes.dex */
public class COUIPanelPercentFrameLayout extends COUIPercentWidthFrameLayout {
    public static final float MEDIUM_AND_LARGE_SCREEN = 2.0f;
    public static final float SMALL_SCREEN = 1.0f;
    private static final String TAG = "COUIPanelPercentFrameLayout";
    private static final int UNSET_WIDTH = -1;
    private Bitmap mBitmap;
    private final Paint mClipPaint;
    private boolean mHasAnchor;
    private boolean mIsHandlePanel;
    private boolean mIsSupportSmoothRoundCorner;
    private int mMaxHeight;
    private int mMaxHeightOfAttr;
    private int mMaxWidth;
    private final Rect mMeasureRect;
    private final Path mPath;
    private int mPreferWidth;
    private float mRadius;
    private float mRatio;
    private final RectF mRectF;
    private float mWeight;

    public COUIPanelPercentFrameLayout(Context context) {
        this(context, null);
    }

    private Bitmap createClipSmoothRoundBitmap() {
        if (this.mRectF.width() > 0.0f && this.mRectF.height() > 0.0f) {
            Bitmap createBitmap = Bitmap.createBitmap((int) this.mRectF.width(), (int) this.mRectF.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint(1);
            paint.setColor(-1);
            canvas.drawPath(this.mPath, paint);
            return createBitmap;
        }
        COUILog.i(TAG, "createClipSmoothRoundBitmap return for width and height must be > 0");
        return null;
    }

    private void enforceChangeScreenWidth() {
        if (this.mPreferWidth == -1) {
            return;
        }
        try {
            Resources resources = getContext().getResources();
            Configuration configuration = resources.getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = this.mPreferWidth;
            if (i10 == i11) {
                return;
            }
            configuration.screenWidthDp = i11;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "enforceChangeScreenWidth : PreferWidth:" + this.mPreferWidth);
        } catch (Exception unused) {
            Log.d(TAG, "enforceChangeScreenWidth : failed to updateConfiguration");
        }
    }

    private void initAttr(AttributeSet attributeSet) {
        float f10;
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0577i.f12946m);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(C0577i.f12947n, 0);
            obtainStyledAttributes.recycle();
        }
        this.mMaxHeightOfAttr = this.mMaxHeight;
        if (COUIPanelMultiWindowUtils.isSmallScreen(getContext(), null)) {
            f10 = 1.0f;
        } else {
            f10 = 2.0f;
        }
        this.mRatio = f10;
        boolean isPathSupportSingleCorner = RoundCornerUtil.isPathSupportSingleCorner();
        this.mIsSupportSmoothRoundCorner = isPathSupportSingleCorner;
        if (isPathSupportSingleCorner) {
            this.mRadius = COUIContextUtil.getAttrDimens(getContext(), X8.c.f4369a0);
            this.mWeight = COUIContextUtil.getAttrFloat(getContext(), X8.c.f4371b0);
        } else {
            this.mRadius = COUIContextUtil.getAttrDimens(getContext(), X8.c.f4367Z);
            this.mWeight = 0.0f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        if (r2 == 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updatePath() {
        /*
            r11 = this;
            android.graphics.Path r0 = r11.mPath
            r0.reset()
            boolean r0 = r11.mIsHandlePanel
            if (r0 == 0) goto L18
            android.content.Context r0 = r11.getContext()
            android.content.res.Resources r0 = r0.getResources()
            int r1 = c9.C0572d.f12879b
            int r0 = r0.getDimensionPixelOffset(r1)
            goto L59
        L18:
            android.content.Context r0 = r11.getContext()
            android.content.res.Resources r0 = r0.getResources()
            int r1 = c9.C0572d.f12878a
            int r0 = r0.getDimensionPixelOffset(r1)
            android.content.Context r1 = r11.getContext()
            android.app.Activity r1 = com.coui.appcompat.uiutil.UIUtil.contextToActivity(r1)
            if (r1 == 0) goto L59
            int r2 = r1.getRequestedOrientation()
            r3 = 1
            if (r2 != r3) goto L56
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 48
            r3 = 32
            if (r1 != r3) goto L56
            android.content.Context r0 = r11.getContext()
            android.content.res.Resources r0 = r0.getResources()
            int r1 = c9.C0572d.f12879b
            int r0 = r0.getDimensionPixelOffset(r1)
            goto L59
        L56:
            if (r2 != 0) goto L59
            goto L5b
        L59:
            if (r0 != 0) goto L67
        L5b:
            android.graphics.Path r0 = r11.mPath
            android.graphics.RectF r1 = r11.mRectF
            float r2 = r11.mRadius
            float r11 = r11.mWeight
            com.coui.appcompat.roundRect.COUIShapePath.getSmoothRoundRectPath(r0, r1, r2, r11)
            goto L76
        L67:
            android.graphics.Path r3 = r11.mPath
            android.graphics.RectF r4 = r11.mRectF
            float r5 = r11.mRadius
            float r6 = r11.mWeight
            r9 = 0
            r10 = 0
            r7 = 1
            r8 = 1
            com.coui.appcompat.roundRect.COUIShapePath.getSmoothRoundRectPath(r3, r4, r5, r6, r7, r8, r9, r10)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.panel.COUIPanelPercentFrameLayout.updatePath():void");
    }

    public void delPreferWidth() {
        this.mPreferWidth = -1;
        Log.d(TAG, "delPreferWidth");
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int saveLayer = canvas.saveLayer(null, null);
        super.draw(canvas);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mClipPaint);
        } else {
            canvas.clipPath(this.mPath);
        }
        canvas.restoreToCount(saveLayer);
    }

    public int getGridNumber() {
        return this.mGridNumber;
    }

    public boolean getHasAnchor() {
        return this.mHasAnchor;
    }

    public int getPaddingSize() {
        return this.mPaddingSize;
    }

    public int getPaddingType() {
        return this.mPaddingType;
    }

    public float getRatio() {
        if (this.mIsHandlePanel) {
            return 1.0f;
        }
        return this.mRatio;
    }

    public boolean isIsHandlePanel() {
        return this.mIsHandlePanel;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        float f10;
        super.onAttachedToWindow();
        if (COUIPanelMultiWindowUtils.isSmallScreen(getContext(), null)) {
            f10 = 1.0f;
        } else {
            f10 = 2.0f;
        }
        this.mRatio = f10;
    }

    @Override // com.coui.appcompat.grid.COUIPercentWidthFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        getWindowVisibleDisplayFrame(this.mMeasureRect);
        int height = this.mMeasureRect.height();
        int i12 = this.mMaxHeight;
        if (height > i12 && i12 > 0 && i12 < View.MeasureSpec.getSize(i11)) {
            i11 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, View.MeasureSpec.getMode(i11));
        }
        boolean isSmallScreen = COUIResponsiveUtils.isSmallScreen(getContext(), this.mMeasureRect.width());
        if ((COUIPanelMultiWindowUtils.isSmallScreen(getContext(), null) || View.MeasureSpec.getSize(i10) >= this.mMeasureRect.width()) && !isSmallScreen && this.mMaxWidth == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        setPercentIndentEnabled(z10);
        int i13 = this.mMaxWidth;
        if (i13 != 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(i13, View.MeasureSpec.getMode(i10));
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        enforceChangeScreenWidth();
        this.mRectF.set(0.0f, 0.0f, i10, i11);
        updatePath();
        if (this.mBitmap == null || i10 != i12 || i11 != i13) {
            this.mBitmap = createClipSmoothRoundBitmap();
        }
    }

    public void restoreDefaultMaxSize() {
        if (this.mMaxWidth == 0) {
            return;
        }
        this.mMaxWidth = 0;
        this.mMaxHeight = this.mMaxHeightOfAttr;
        requestLayout();
    }

    public void setHasAnchor(boolean z10) {
        this.mHasAnchor = z10;
    }

    public void setIsHandlePanel(boolean z10) {
        this.mIsHandlePanel = z10;
    }

    public void setMaxSize(int i10, int i11) {
        if (i11 == this.mMaxHeight && i10 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i10;
        this.mMaxHeight = i11;
        requestLayout();
    }

    public void setPreferWidth(int i10) {
        this.mPreferWidth = i10;
        Log.d(TAG, "setPreferWidth =：" + this.mPreferWidth);
    }

    public void updateLayoutWhileConfigChange(Configuration configuration) {
        float f10;
        if (COUIPanelMultiWindowUtils.isSmallScreen(getContext(), configuration)) {
            f10 = 1.0f;
        } else {
            f10 = 2.0f;
        }
        this.mRatio = f10;
    }

    public COUIPanelPercentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIPanelPercentFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPath = new Path();
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.mClipPaint = paint;
        this.mRatio = 1.0f;
        this.mHasAnchor = false;
        this.mPreferWidth = -1;
        this.mIsSupportSmoothRoundCorner = false;
        this.mBitmap = null;
        initAttr(attributeSet);
        this.mMeasureRect = new Rect();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
}
