package com.coui.appcompat.stepper;

import X8.f;
import X8.h;
import X8.j;
import X8.n;
import X8.o;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.state.COUIMaskEffectDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;
import com.coui.appcompat.state.COUIStrokeDrawable;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes.dex */
public class COUIStepperView extends ConstraintLayout implements IStepper, Observer {
    private final String TAG;
    private Context mContext;
    private OnStepChangeListener mListener;
    private ImageView mMinusImage;
    private LongPressProxy mMinusLongPressProxy;
    private final Runnable mMinusRunnable;
    private ImageView mPlusImage;
    private LongPressProxy mPlusLongPressProxy;
    private final Runnable mPlusRunnable;
    private ObservableStep mStep;
    private int mStyle;
    private int mUnit;
    private TextView mValueText;

    public COUIStepperView(Context context) {
        this(context, null);
    }

    private void configEffectDrawableForButton() {
        configEffectDrawableForButton(this.mMinusImage, this.mMinusLongPressProxy);
        configEffectDrawableForButton(this.mPlusImage, this.mPlusLongPressProxy);
    }

    private int getNumForMaxWidth() {
        int i10 = 1;
        float f10 = 0.0f;
        for (int i11 = 0; i11 < 10; i11++) {
            float measureText = this.mValueText.getPaint().measureText(String.valueOf(i11));
            if (measureText > f10) {
                i10 = i11;
                f10 = measureText;
            }
        }
        return i10;
    }

    private void initAttr(TypedArray typedArray) {
        try {
            int resourceId = typedArray.getResourceId(o.f5339j5, 0);
            int resourceId2 = typedArray.getResourceId(o.f5331i5, 0);
            int resourceId3 = typedArray.getResourceId(o.f5323h5, 0);
            if (resourceId != 0) {
                this.mValueText.setTextAppearance(resourceId);
            }
            if (resourceId2 != 0) {
                this.mPlusImage.setImageDrawable(androidx.core.content.b.e(getContext(), resourceId2));
            }
            if (resourceId3 != 0) {
                this.mMinusImage.setImageDrawable(androidx.core.content.b.e(getContext(), resourceId3));
            }
            configEffectDrawableForButton();
        } catch (Resources.NotFoundException e10) {
            Log.e("COUIStepperView", e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$configEffectDrawableForButton$2(COUIStateEffectDrawable cOUIStateEffectDrawable, View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            cOUIStateEffectDrawable.setTouched(true);
        }
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
            cOUIStateEffectDrawable.setTouched(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE_SYNC, 0);
        plus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE_SYNC, 0);
        minus();
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public int getCurStep() {
        return this.mStep.getStep();
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public int getMaximum() {
        return this.mStep.getMaximum();
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public int getMinimum() {
        return this.mStep.getMinimum();
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public int getUnit() {
        return this.mUnit;
    }

    public void init(AttributeSet attributeSet, int i10) {
        int i11 = n.f5039k;
        this.mStyle = i11;
        LayoutInflater.from(getContext()).inflate(j.f4986q, this);
        this.mPlusImage = (ImageView) findViewById(h.f4908Y);
        this.mMinusImage = (ImageView) findViewById(h.f4906W);
        this.mValueText = (TextView) findViewById(h.f4900Q);
        this.mPlusLongPressProxy = new LongPressProxy(this.mPlusImage, this.mPlusRunnable);
        this.mMinusLongPressProxy = new LongPressProxy(this.mMinusImage, this.mMinusRunnable);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f5291d5, i10, i11);
        int i12 = obtainStyledAttributes.getInt(o.f5307f5, ObservableStep.MAX_VALUE);
        int i13 = obtainStyledAttributes.getInt(o.f5315g5, ObservableStep.MIN_VALUE);
        int i14 = obtainStyledAttributes.getInt(o.f5299e5, 0);
        this.mUnit = obtainStyledAttributes.getInt(o.f5347k5, 1);
        initAttr(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        ObservableStep observableStep = new ObservableStep();
        this.mStep = observableStep;
        observableStep.addObserver(this);
        setMaximum(i12);
        setMinimum(i13);
        setCurStep(i14);
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void minus() {
        ObservableStep observableStep = this.mStep;
        observableStep.setStep(observableStep.getStep() - getUnit());
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int numForMaxWidth = getNumForMaxWidth();
        String[] split = String.valueOf(getMaximum()).split("");
        StringBuilder sb = new StringBuilder();
        for (int i12 = 0; i12 < split.length; i12++) {
            sb.append(numForMaxWidth);
        }
        this.mValueText.setWidth(Math.round(this.mValueText.getPaint().measureText(sb.toString())));
        super.onMeasure(i10, i11);
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void plus() {
        ObservableStep observableStep = this.mStep;
        observableStep.setStep(observableStep.getStep() + getUnit());
    }

    public void refresh() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, o.f5291d5, 0, this.mStyle);
        if (obtainStyledAttributes != null) {
            initAttr(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }

    public void release() {
        this.mPlusLongPressProxy.release();
        this.mMinusLongPressProxy.release();
        this.mStep.deleteObservers();
        this.mListener = null;
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setCurStep(int i10) {
        this.mStep.setStep(i10);
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setMaximum(int i10) {
        this.mStep.setMaximum(i10);
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setMinimum(int i10) {
        this.mStep.setMinimum(i10);
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setOnStepChangeListener(OnStepChangeListener onStepChangeListener) {
        this.mListener = onStepChangeListener;
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setUnit(int i10) {
        this.mUnit = i10;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        boolean z10;
        int step = ((ObservableStep) observable).getStep();
        int intValue = ((Integer) obj).intValue();
        ImageView imageView = this.mPlusImage;
        boolean z11 = false;
        if (step < getMaximum() && isEnabled()) {
            z10 = true;
        } else {
            z10 = false;
        }
        imageView.setEnabled(z10);
        ImageView imageView2 = this.mMinusImage;
        if (step > getMinimum() && isEnabled()) {
            z11 = true;
        }
        imageView2.setEnabled(z11);
        this.mValueText.setText(String.valueOf(step));
        OnStepChangeListener onStepChangeListener = this.mListener;
        if (onStepChangeListener != null) {
            onStepChangeListener.onStepChanged(step, intValue);
        }
    }

    public COUIStepperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4397o0);
    }

    public COUIStepperView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.TAG = "COUIStepperView";
        this.mPlusRunnable = new Runnable() { // from class: com.coui.appcompat.stepper.b
            @Override // java.lang.Runnable
            public final void run() {
                COUIStepperView.this.lambda$new$0();
            }
        };
        this.mMinusRunnable = new Runnable() { // from class: com.coui.appcompat.stepper.c
            @Override // java.lang.Runnable
            public final void run() {
                COUIStepperView.this.lambda$new$1();
            }
        };
        this.mContext = context;
        init(attributeSet, i10);
    }

    private void configEffectDrawableForButton(ImageView imageView, LongPressProxy longPressProxy) {
        float dimension = getContext().getResources().getDimension(f.f4509G5);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        RectF rectF = new RectF(0.0f, 0.0f, dimension, dimension);
        shapeDrawable.getPaint().setColor(COUIContextUtil.getAttrColor(getContext(), X8.c.f4346E));
        int i10 = (int) dimension;
        shapeDrawable.setBounds(0, 0, i10, i10);
        COUIMaskEffectDrawable cOUIMaskEffectDrawable = new COUIMaskEffectDrawable(getContext(), 0);
        float f10 = dimension / 2.0f;
        cOUIMaskEffectDrawable.setMaskRect(rectF, f10, f10);
        COUIStrokeDrawable cOUIStrokeDrawable = new COUIStrokeDrawable(getContext());
        cOUIStrokeDrawable.setStrokeRect(rectF, f10, f10);
        final COUIStateEffectDrawable cOUIStateEffectDrawable = new COUIStateEffectDrawable(new Drawable[]{shapeDrawable, cOUIMaskEffectDrawable, cOUIStrokeDrawable});
        cOUIStateEffectDrawable.enableScaleEffect(imageView, 2);
        imageView.setBackground(cOUIStateEffectDrawable);
        longPressProxy.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.stepper.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$configEffectDrawableForButton$2;
                lambda$configEffectDrawableForButton$2 = COUIStepperView.lambda$configEffectDrawableForButton$2(COUIStateEffectDrawable.this, view, motionEvent);
                return lambda$configEffectDrawableForButton$2;
            }
        });
    }
}
