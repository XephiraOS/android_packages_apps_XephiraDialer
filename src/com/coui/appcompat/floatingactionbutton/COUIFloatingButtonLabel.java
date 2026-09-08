package com.coui.appcompat.floatingactionbutton;

import X8.e;
import a9.c;
import a9.d;
import a9.f;
import a9.h;
import a9.m;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.coui.appcompat.animation.COUIAnimationListenerAdapter;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButtonItem;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.statelistutil.COUIStateListUtil;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.google.android.material.imageview.ShapeableImageView;
import x4.n;

/* loaded from: classes.dex */
public class COUIFloatingButtonLabel extends LinearLayout {
    private static final int DEFAULT_ELEVATION_FLOATING_BUTTON = 24;
    private static final float DEFAULT_PRESS_GUARANTEED_ANIMATION_VALUE = 0.98f;
    private static final String TAG = "COUIFloatingButtonLabel";
    private int mButtonSize;
    private ShapeableImageView mChildFloatingButton;
    private COUIFloatingButtonItem mFloatingButtonItem;
    private int mFloatingButtonPixel;
    private boolean mIsLabelEnabled;
    private boolean mIsNeedVibrate;
    private CardView mLabelBackground;
    private float mLabelCardViewElevation;
    private TextView mLabelTextView;
    private COUIFloatingButton.OnActionSelectedListener mOnActionSelectedListener;
    private ValueAnimator mPressAnimationRecorder;
    private float mPressValue;

    public COUIFloatingButtonLabel(Context context) {
        super(context);
        this.mIsNeedVibrate = true;
        this.mButtonSize = 0;
        init(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateNormal() {
        clearAnimation();
        cancelRecorder();
        ShapeableImageView shapeableImageView = this.mChildFloatingButton;
        shapeableImageView.startAnimation(COUIFABPressFeedbackUtil.generateResumeAnimation(shapeableImageView, this.mPressValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animatePress() {
        performHapticFeedback();
        clearAnimation();
        cancelRecorder();
        COUIFloatingButtonTouchAnimation generatePressAnimation = COUIFABPressFeedbackUtil.generatePressAnimation(this.mChildFloatingButton);
        ValueAnimator generatePressAnimationRecord = COUIFABPressFeedbackUtil.generatePressAnimationRecord();
        this.mPressAnimationRecorder = generatePressAnimationRecord;
        generatePressAnimationRecord.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButtonLabel.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIFloatingButtonLabel.this.mPressValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIFloatingButtonLabel.this.mPressValue >= COUIFloatingButtonLabel.DEFAULT_PRESS_GUARANTEED_ANIMATION_VALUE) {
                    COUIFloatingButtonLabel.this.mPressValue = COUIFloatingButtonLabel.DEFAULT_PRESS_GUARANTEED_ANIMATION_VALUE;
                }
            }
        });
        generatePressAnimation.setAnimationListener(new COUIAnimationListenerAdapter() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButtonLabel.7
            @Override // com.coui.appcompat.animation.COUIAnimationListenerAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                COUIFloatingButtonLabel.this.mPressAnimationRecorder.start();
            }
        });
        this.mChildFloatingButton.startAnimation(generatePressAnimation);
    }

    private void cancelRecorder() {
        ValueAnimator valueAnimator = this.mPressAnimationRecorder;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mPressAnimationRecorder.cancel();
        }
    }

    private void childFloatingButtonTouch() {
        this.mChildFloatingButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButtonLabel.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    COUIFloatingButtonLabel.this.animatePress();
                    return false;
                }
                if (action == 1 || action == 3) {
                    COUIFloatingButtonLabel.this.animateNormal();
                    return false;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnClickFloatingButton() {
        COUIFloatingButtonItem floatingButtonItem = getFloatingButtonItem();
        COUIFloatingButton.OnActionSelectedListener onActionSelectedListener = this.mOnActionSelectedListener;
        if (onActionSelectedListener != null && floatingButtonItem != null) {
            onActionSelectedListener.onActionSelected(floatingButtonItem);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        View inflate = View.inflate(context, h.f6663f, this);
        this.mChildFloatingButton = (ShapeableImageView) inflate.findViewById(f.f6637g);
        this.mLabelTextView = (TextView) inflate.findViewById(f.f6638h);
        this.mLabelBackground = (CardView) inflate.findViewById(f.f6639i);
        ShapeableImageView shapeableImageView = this.mChildFloatingButton;
        Resources resources = getResources();
        int i10 = X8.f.f4558N5;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i10);
        Resources resources2 = getResources();
        int i11 = c.f6483g;
        ShadowUtils.setElevationToView(shapeableImageView, 3, dimensionPixelOffset, resources2.getColor(i11));
        this.mChildFloatingButton.setOutlineProvider(new ViewOutlineProvider() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButtonLabel.3
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        });
        this.mChildFloatingButton.setShapeAppearanceModel(n.a().p(n.f37922m).m());
        ShadowUtils.setElevationToView(this.mLabelBackground, 3, getResources().getDimensionPixelOffset(i10), getResources().getColor(i11));
        this.mLabelBackground.setOutlineProvider(new ViewOutlineProvider() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButtonLabel.4
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), COUIContextUtil.getAttrDimens(COUIFloatingButtonLabel.this.getContext(), X8.c.f4387j0));
            }
        });
        setOrientation(0);
        setClipChildren(false);
        setClipToPadding(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6826a0, 0, 0);
        try {
            try {
                this.mIsNeedVibrate = obtainStyledAttributes.getBoolean(m.f6854g0, true);
                int resourceId = obtainStyledAttributes.getResourceId(m.f6858h0, Integer.MIN_VALUE);
                if (resourceId == Integer.MIN_VALUE) {
                    resourceId = obtainStyledAttributes.getResourceId(m.f6831b0, Integer.MIN_VALUE);
                }
                COUIFloatingButtonItem.Builder builder = new COUIFloatingButtonItem.Builder(getId(), resourceId);
                builder.setLabel(obtainStyledAttributes.getString(m.f6841d0));
                builder.setFabBackgroundColor(ColorStateList.valueOf(obtainStyledAttributes.getColor(m.f6836c0, COUIContextUtil.getAttrColor(getContext(), X8.c.f4347F, 0))));
                builder.setLabelColor(ColorStateList.valueOf(obtainStyledAttributes.getColor(m.f6850f0, Integer.MIN_VALUE)));
                builder.setLabelBackgroundColor(ColorStateList.valueOf(obtainStyledAttributes.getColor(m.f6846e0, Integer.MIN_VALUE)));
                setFloatingButtonItem(builder.create());
            } catch (Exception e10) {
                Log.e(TAG, "Failure setting FabWithLabelView icon" + e10.getMessage());
            }
            obtainStyledAttributes.recycle();
            setClipChildren(false);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void performHapticFeedback() {
        if (this.mIsNeedVibrate) {
            performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        }
    }

    private void setChildFloatingButtonSize() {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.f6590s);
        getContext().getResources().getDimensionPixelSize(d.f6592t);
        getContext().getResources().getDimensionPixelSize(d.f6596v);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mChildFloatingButton.getLayoutParams();
        if (getOrientation() == 0) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388613;
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize, -2);
            layoutParams3.gravity = 16;
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams = layoutParams3;
        }
        setLayoutParams(layoutParams);
        this.mChildFloatingButton.setLayoutParams(layoutParams2);
    }

    private void setFabBackgroundColor(ColorStateList colorStateList) {
        this.mChildFloatingButton.setBackgroundTintList(colorStateList);
    }

    private void setFabIcon(Drawable drawable) {
        this.mChildFloatingButton.setImageDrawable(drawable);
    }

    private void setLabel(CharSequence charSequence) {
        boolean z10 = false;
        if (!TextUtils.isEmpty(charSequence)) {
            this.mLabelTextView.setText(charSequence);
            if (getOrientation() == 0) {
                z10 = true;
            }
            setLabelEnabled(z10);
            return;
        }
        setLabelEnabled(false);
    }

    private void setLabelBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            this.mLabelBackground.setCardBackgroundColor(0);
            this.mLabelCardViewElevation = this.mLabelBackground.getElevation();
            this.mLabelBackground.setElevation(0.0f);
        } else {
            this.mLabelBackground.setCardBackgroundColor(colorStateList);
            float f10 = this.mLabelCardViewElevation;
            if (f10 != 0.0f) {
                this.mLabelBackground.setElevation(f10);
                this.mLabelCardViewElevation = 0.0f;
            }
        }
    }

    private void setLabelEnabled(boolean z10) {
        int i10;
        this.mIsLabelEnabled = z10;
        CardView cardView = this.mLabelBackground;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        cardView.setVisibility(i10);
    }

    private void setLabelTextColor(ColorStateList colorStateList) {
        this.mLabelTextView.setTextColor(colorStateList);
    }

    public ImageView getChildFloatingButton() {
        return this.mChildFloatingButton;
    }

    public PorterDuffColorFilter getDrawableFilter(int i10) {
        return new PorterDuffColorFilter(i10, PorterDuff.Mode.SRC_ATOP);
    }

    public COUIFloatingButtonItem getFloatingButtonItem() {
        COUIFloatingButtonItem cOUIFloatingButtonItem = this.mFloatingButtonItem;
        if (cOUIFloatingButtonItem != null) {
            return cOUIFloatingButtonItem;
        }
        throw new IllegalStateException("SpeedDialActionItem not set yet!");
    }

    public COUIFloatingButtonItem.Builder getFloatingButtonItemBuilder() {
        return new COUIFloatingButtonItem.Builder(getFloatingButtonItem());
    }

    public CardView getFloatingButtonLabelBackground() {
        return this.mLabelBackground;
    }

    public TextView getFloatingButtonLabelText() {
        return this.mLabelTextView;
    }

    public boolean isLabelEnabled() {
        return this.mIsLabelEnabled;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mButtonSize <= 0) {
            Context createConfigurationContext = getContext().createConfigurationContext(configuration);
            if (COUIResponsiveUtils.isSmallScreenDp(configuration.screenWidthDp)) {
                this.mFloatingButtonPixel = createConfigurationContext.getResources().getDimensionPixelOffset(d.f6602y);
            } else {
                this.mFloatingButtonPixel = createConfigurationContext.getResources().getDimensionPixelOffset(d.f6600x);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mChildFloatingButton.getLayoutParams();
            int i10 = this.mFloatingButtonPixel;
            layoutParams.width = i10;
            layoutParams.height = i10;
            this.mChildFloatingButton.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.mLabelTextView.setEnabled(z10);
        this.mChildFloatingButton.setEnabled(z10);
        this.mLabelBackground.setEnabled(z10);
    }

    public void setFloatingButtonItem(COUIFloatingButtonItem cOUIFloatingButtonItem) {
        this.mFloatingButtonItem = cOUIFloatingButtonItem;
        setId(cOUIFloatingButtonItem.getFloatingButtonItemLocation());
        setLabel(cOUIFloatingButtonItem.getLabel(getContext()));
        setFabIcon(cOUIFloatingButtonItem.getFabImageDrawable(getContext()));
        ColorStateList fabBackgroundColor = cOUIFloatingButtonItem.getFabBackgroundColor();
        int color = getContext().getResources().getColor(e.f4435a);
        int attrColor = COUIContextUtil.getAttrColor(getContext(), X8.c.f4347F, color);
        if (fabBackgroundColor == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            fabBackgroundColor = COUIStateListUtil.createColorStateList(attrColor, color);
        }
        setFabBackgroundColor(fabBackgroundColor);
        ColorStateList labelColor = cOUIFloatingButtonItem.getLabelColor();
        if (labelColor == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            labelColor = A.h.e(getResources(), c.f6484h, getContext().getTheme());
        }
        setLabelTextColor(labelColor);
        ColorStateList labelBackgroundColor = cOUIFloatingButtonItem.getLabelBackgroundColor();
        if (labelBackgroundColor == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            labelBackgroundColor = COUIStateListUtil.createColorStateList(attrColor, color);
        }
        setLabelBackgroundColor(labelBackgroundColor);
        if (cOUIFloatingButtonItem.isCOUIFloatingButtonExpandEnable()) {
            childFloatingButtonTouch();
        }
        getChildFloatingButton().setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButtonLabel.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                COUIFloatingButtonLabel.this.handleOnClickFloatingButton();
            }
        });
    }

    public void setMainButtonSize(int i10) {
        this.mButtonSize = i10;
        if (i10 > 0) {
            this.mFloatingButtonPixel = i10;
        } else {
            this.mFloatingButtonPixel = getResources().getDimensionPixelSize(d.f6604z);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mChildFloatingButton.getLayoutParams();
        int i11 = this.mFloatingButtonPixel;
        layoutParams.width = i11;
        layoutParams.height = i11;
        this.mChildFloatingButton.setLayoutParams(layoutParams);
    }

    public void setOnActionSelectedListener(COUIFloatingButton.OnActionSelectedListener onActionSelectedListener) {
        this.mOnActionSelectedListener = onActionSelectedListener;
        if (onActionSelectedListener != null) {
            getFloatingButtonLabelBackground().setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButtonLabel.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUIFloatingButtonItem floatingButtonItem = COUIFloatingButtonLabel.this.getFloatingButtonItem();
                    if (COUIFloatingButtonLabel.this.mOnActionSelectedListener != null && floatingButtonItem != null) {
                        COUIFloatingButtonLabel.this.mOnActionSelectedListener.onActionSelected(floatingButtonItem);
                    }
                }
            });
        } else {
            getChildFloatingButton().setOnClickListener(null);
            getFloatingButtonLabelBackground().setOnClickListener(null);
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        super.setOrientation(i10);
        setChildFloatingButtonSize();
        if (i10 == 1) {
            setLabelEnabled(false);
        } else {
            setLabel(this.mLabelTextView.getText().toString());
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        getChildFloatingButton().setVisibility(i10);
        if (isLabelEnabled()) {
            getFloatingButtonLabelBackground().setVisibility(i10);
        }
    }

    public COUIFloatingButtonLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsNeedVibrate = true;
        this.mButtonSize = 0;
        init(context, attributeSet);
    }

    public COUIFloatingButtonLabel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIsNeedVibrate = true;
        this.mButtonSize = 0;
        init(context, attributeSet);
    }
}
