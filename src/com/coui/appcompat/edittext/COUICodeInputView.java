package com.coui.appcompat.edittext;

import X8.c;
import X8.e;
import X8.f;
import X8.h;
import X8.j;
import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.roundRect.COUIShapePath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class COUICodeInputView extends RelativeLayout {
    private final int CELL_COUNT;
    private final int DEFAULT_SCREEN_WIDTH_DP;
    private List<CodeItemView> codeViews;
    private List<String> codes;
    private int mCellCount;
    private int mCellHeight;
    private int mCellMarginHorizontal;
    private int mCellWidth;
    private LinearLayout mCodeViewsContainer;
    private int mCodeViewsContainerMarginHorizontal;
    private EditText mEditText;
    private boolean mIsEnableSecurity;
    private int mMaxCellMarginHorizontal;
    private int mMinCellMarginHorizontal;
    private UpdateItemWidthRunnable mUpdateItemWidthRunnable;
    private OnInputListener onInputListener;

    /* loaded from: classes.dex */
    public static class CodeItemView extends View {
        private COUICodeInputHelper codeInputHelper;
        private int mCircleColor;
        private Paint mCirclePaint;
        private int mCircleRadius;
        private boolean mIsEnableSecurity;
        private boolean mIsSelected;
        private String mNumber;
        private TextPaint mNumberTextPaint;
        private Paint mPaint;
        private Path mPath;
        private int mRadius;
        private Paint mStrokePaint;
        private int mTextSize;
        private int strokeWidth;

        public CodeItemView(Context context) {
            super(context);
            this.mTextSize = getResources().getDimensionPixelSize(f.f4685f1);
            this.mRadius = COUIContextUtil.getAttrDimens(getContext(), c.f4379f0);
            this.strokeWidth = getResources().getDimensionPixelSize(f.f4677e1);
            this.mCircleRadius = getResources().getDimensionPixelSize(f.f4669d1);
            this.mCircleColor = COUIContextUtil.getColor(getContext(), e.f4440f);
            this.mNumberTextPaint = new TextPaint();
            this.mPaint = new Paint();
            this.mStrokePaint = new Paint();
            this.mCirclePaint = new Paint();
            this.mPath = new Path();
            this.mNumber = "";
            this.mNumberTextPaint.setTextSize(this.mTextSize);
            this.mNumberTextPaint.setAntiAlias(true);
            this.mNumberTextPaint.setColor(COUIContextUtil.getAttrColor(getContext(), c.f4348G));
            this.mPaint.setColor(COUIContextUtil.getAttrColor(getContext(), c.f4386j));
            this.mStrokePaint.setColor(COUIContextUtil.getAttrColor(getContext(), c.f4347F));
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
            this.mStrokePaint.setStrokeWidth(this.strokeWidth);
            this.mCirclePaint.setColor(this.mCircleColor);
            this.mCirclePaint.setAntiAlias(true);
            this.codeInputHelper = new COUICodeInputHelper(this);
        }

        private float getDrawTextStartX(int i10, String str) {
            return (i10 / 2) - (this.mNumberTextPaint.measureText(str) / 2.0f);
        }

        private float getDrawTextStartY(int i10) {
            Paint.FontMetricsInt fontMetricsInt = this.mNumberTextPaint.getFontMetricsInt();
            return (i10 / 2) - ((fontMetricsInt.descent + fontMetricsInt.ascent) / 2);
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            float drawTextStartX;
            float drawTextStartY;
            int width = getWidth();
            int height = getHeight();
            Path roundRectPath = COUIShapePath.getRoundRectPath(this.mPath, new RectF(0.0f, 0.0f, width, height), this.mRadius);
            this.mPath = roundRectPath;
            canvas.drawPath(roundRectPath, this.mPaint);
            if (this.mIsSelected || this.codeInputHelper.isInboxAnimatorRuning()) {
                float f10 = this.strokeWidth >> 1;
                RectF rectF = new RectF(f10, f10, width - r2, height - r2);
                this.mStrokePaint.setAlpha((int) (this.codeInputHelper.getCurrentInboxAlpha() * 255.0f));
                Path roundRectPath2 = COUIShapePath.getRoundRectPath(this.mPath, rectF, this.mRadius);
                this.mPath = roundRectPath2;
                canvas.drawPath(roundRectPath2, this.mStrokePaint);
            }
            if (!TextUtils.isEmpty(this.mNumber) || this.codeInputHelper.isNumberAnimatorRuning()) {
                if (this.mIsEnableSecurity) {
                    canvas.drawCircle(width / 2, height / 2, this.mCircleRadius, this.mCirclePaint);
                    return;
                }
                if (this.codeInputHelper.isNumberAnimatorRuning()) {
                    float currentNumberAlpha = this.codeInputHelper.getCurrentNumberAlpha();
                    String str = this.mNumber;
                    this.mNumberTextPaint.setAlpha((int) (currentNumberAlpha * 255.0f));
                    if (this.codeInputHelper.isCurrentNumberAppear()) {
                        drawTextStartX = getDrawTextStartX(width, str);
                        drawTextStartY = getDrawTextStartY(height);
                        float currentNumberScale = this.codeInputHelper.getCurrentNumberScale();
                        canvas.scale(currentNumberScale, currentNumberScale, drawTextStartX, drawTextStartY);
                    } else {
                        str = this.codeInputHelper.getAnimatorNumber();
                        drawTextStartX = getDrawTextStartX(width, str);
                        drawTextStartY = getDrawTextStartY(height);
                    }
                    canvas.drawText(str, drawTextStartX, drawTextStartY, this.mNumberTextPaint);
                    return;
                }
                float drawTextStartX2 = getDrawTextStartX(width, this.mNumber);
                float drawTextStartY2 = getDrawTextStartY(height);
                this.mNumberTextPaint.setAlpha(255);
                canvas.drawText(this.mNumber, drawTextStartX2, drawTextStartY2, this.mNumberTextPaint);
            }
        }

        public void setEnableSecurity(boolean z10) {
            this.mIsEnableSecurity = z10;
        }

        public void setIsSelected(boolean z10) {
            if (z10 != this.mIsSelected) {
                this.codeInputHelper.startInboxAnimator(z10);
            }
            this.mIsSelected = z10;
        }

        public void setNumber(String str) {
            if (!this.mIsEnableSecurity) {
                if (!TextUtils.isEmpty(this.mNumber) && TextUtils.isEmpty(str)) {
                    this.codeInputHelper.startNumberAnimator(false, this.mNumber);
                } else if (TextUtils.isEmpty(this.mNumber) && !TextUtils.isEmpty(str)) {
                    this.codeInputHelper.startNumberAnimator(true, str);
                }
            }
            this.mNumber = str;
        }
    }

    /* loaded from: classes.dex */
    public interface OnInputListener {
        void onInput();

        void onSuccess(String str);
    }

    /* loaded from: classes.dex */
    public static class UpdateItemWidthRunnable implements Runnable {
        private View codeViewsContainer;

        private UpdateItemWidthRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.codeViewsContainer;
            if (view != null) {
                view.requestLayout();
                this.codeViewsContainer = null;
            }
        }

        public void setCodeViewsContainer(View view) {
            this.codeViewsContainer = view;
        }
    }

    public COUICodeInputView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBack() {
        if (this.onInputListener == null) {
            return;
        }
        if (this.codes.size() == this.mCellCount) {
            this.onInputListener.onSuccess(getPhoneCode());
        } else {
            this.onInputListener.onInput();
        }
    }

    private int getCellMarginHorizontal(int i10, int i11) {
        int min = Math.min(Math.max(Math.round(((i10 - (i11 * this.codeViews.size())) - (this.mCodeViewsContainerMarginHorizontal * 2)) / ((this.codeViews.size() * 2) - 2)), this.mMinCellMarginHorizontal), this.mMaxCellMarginHorizontal);
        this.mCellMarginHorizontal = min;
        return min;
    }

    private void initResource() {
        this.mCellWidth = getResources().getDimensionPixelSize(f.f4693g1);
        this.mCellMarginHorizontal = getResources().getDimensionPixelSize(f.f4645a1);
        this.mCellHeight = getResources().getDimensionPixelSize(f.f4637Z0);
        this.mMaxCellMarginHorizontal = getResources().getDimensionPixelSize(f.f4653b1);
        this.mMinCellMarginHorizontal = getResources().getDimensionPixelSize(f.f4661c1);
        this.mCodeViewsContainerMarginHorizontal = getResources().getDimensionPixelSize(f.f4701h1);
    }

    private void initView(View view) {
        this.mCodeViewsContainer = (LinearLayout) view.findViewById(h.f4946s);
        for (int i10 = 0; i10 < this.mCellCount; i10++) {
            CodeItemView codeItemView = new CodeItemView(getContext());
            codeItemView.setEnableSecurity(this.mIsEnableSecurity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mCellWidth, -1);
            layoutParams.setMarginStart(this.mCellMarginHorizontal);
            layoutParams.setMarginEnd(this.mCellMarginHorizontal);
            this.mCodeViewsContainer.addView(codeItemView, layoutParams);
            this.codeViews.add(codeItemView);
        }
        this.codeViews.get(0).setIsSelected(true);
        EditText editText = (EditText) view.findViewById(h.f4944r);
        this.mEditText = editText;
        editText.requestFocus();
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.coui.appcompat.edittext.COUICodeInputView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    COUICodeInputView.this.mEditText.setText("");
                    if (COUICodeInputView.this.codes.size() < COUICodeInputView.this.mCellCount) {
                        String trim = editable.toString().trim();
                        if (trim.length() > 1) {
                            if (trim.length() > COUICodeInputView.this.mCellCount) {
                                trim = trim.substring(0, COUICodeInputView.this.mCellCount);
                            }
                            List asList = Arrays.asList(trim.split(""));
                            COUICodeInputView.this.codes = new ArrayList(asList);
                        } else {
                            COUICodeInputView.this.codes.add(trim);
                        }
                    }
                    COUICodeInputView.this.updateViewsByCodesChange();
                    COUICodeInputView.this.callBack();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.mEditText.setOnKeyListener(new View.OnKeyListener() { // from class: com.coui.appcompat.edittext.COUICodeInputView.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view2, int i11, KeyEvent keyEvent) {
                COUICodeInputView cOUICodeInputView = COUICodeInputView.this;
                if (cOUICodeInputView.isNotEmpty(cOUICodeInputView.codes) && i11 == 67 && keyEvent.getAction() == 0 && COUICodeInputView.this.codes.size() > 0) {
                    COUICodeInputView.this.codes.remove(COUICodeInputView.this.codes.size() - 1);
                    COUICodeInputView.this.updateViewsByCodesChange();
                    COUICodeInputView.this.callBack();
                    return true;
                }
                return false;
            }
        });
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.coui.appcompat.edittext.COUICodeInputView.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z10) {
                CodeItemView codeItemView2 = (CodeItemView) COUICodeInputView.this.codeViews.get(Math.min(COUICodeInputView.this.codes.size(), COUICodeInputView.this.mCellCount - 1));
                codeItemView2.setIsSelected(z10);
                codeItemView2.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNotEmpty(List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    private void setCodeItemWidth(int i10) {
        double min = Math.min(getResources().getConfiguration().screenWidthDp, 360.0d) / 360.0d;
        int i11 = (int) (this.mCellWidth * min);
        int i12 = (int) (this.mCellHeight * min);
        this.mCellMarginHorizontal = getCellMarginHorizontal(i10, i11);
        for (int i13 = 0; i13 < this.mCodeViewsContainer.getChildCount(); i13++) {
            View childAt = this.mCodeViewsContainer.getChildAt(i13);
            if (childAt != null && (childAt instanceof CodeItemView)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.width = i11;
                layoutParams.height = i12;
                if (i13 == 0) {
                    layoutParams.setMarginStart(0);
                } else {
                    layoutParams.setMarginStart(this.mCellMarginHorizontal);
                }
                if (i13 == this.mCellCount - 1) {
                    layoutParams.setMarginEnd(0);
                } else {
                    layoutParams.setMarginEnd(this.mCellMarginHorizontal);
                }
                childAt.setLayoutParams(layoutParams);
            }
        }
        this.mUpdateItemWidthRunnable.setCodeViewsContainer(this.mCodeViewsContainer);
        post(this.mUpdateItemWidthRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewsByCodesChange() {
        String str;
        int size = this.codes.size();
        for (int i10 = 0; i10 < this.mCellCount; i10++) {
            if (size > i10) {
                str = this.codes.get(i10);
            } else {
                str = "";
            }
            CodeItemView codeItemView = this.codeViews.get(i10);
            codeItemView.setNumber(str);
            int i11 = this.mCellCount;
            boolean z10 = true;
            if (size == i11 && i10 == i11 - 1) {
                codeItemView.setIsSelected(true);
            } else {
                if (size != i10) {
                    z10 = false;
                }
                codeItemView.setIsSelected(z10);
            }
            codeItemView.invalidate();
        }
    }

    public void clearAll() {
        this.mEditText.setText("");
        this.codes.clear();
        updateViewsByCodesChange();
    }

    public String getPhoneCode() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.codes.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UpdateItemWidthRunnable updateItemWidthRunnable = this.mUpdateItemWidthRunnable;
        if (updateItemWidthRunnable != null) {
            removeCallbacks(updateItemWidthRunnable);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            setCodeItemWidth(i10);
        }
    }

    public void setOnInputListener(OnInputListener onInputListener) {
        this.onInputListener = onInputListener;
    }

    public COUICodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUICodeInputView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.CELL_COUNT = 6;
        this.DEFAULT_SCREEN_WIDTH_DP = 360;
        this.mIsEnableSecurity = false;
        this.codes = new ArrayList();
        this.codeViews = new ArrayList();
        this.mUpdateItemWidthRunnable = new UpdateItemWidthRunnable();
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5382p0, i10, 0);
        this.mCellCount = obtainStyledAttributes.getInteger(o.f5390q0, 6);
        this.mIsEnableSecurity = obtainStyledAttributes.getBoolean(o.f5398r0, false);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(j.f4978i, this);
        initResource();
        initView(inflate);
    }
}
