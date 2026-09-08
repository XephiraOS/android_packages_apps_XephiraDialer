package com.coui.appcompat.tips.def;

import a9.d;
import a9.f;
import a9.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import androidx.core.view.K;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.coui.appcompat.tips.COUIMarqueeTextView;

/* loaded from: classes3.dex */
public class COUIDefaultTopTipsView extends ConstraintLayout implements IDefaultTopTips {
    public static final int ACTION_ID = 3;
    public static final int CLOSE_ID = 4;
    public static final int ICON_ID = 0;
    public static final int IGNORE_ID = 2;
    public static final int IMAGE_BTN_TYPE = 1;
    private static final int TEXT_BTN_ACTION_WRAP = 1;
    private static final int TEXT_BTN_BOTH_WRAP = 3;
    private static final int TEXT_BTN_DIVIDED = 0;
    private static final int TEXT_BTN_IGNORE_WRAP = 2;
    public static final int TEXT_BTN_TYPE = 0;
    public static final int TITLE_ID = 1;
    private final b end;
    private TextView mAction;
    private ImageView mClose;
    private View.OnClickListener mCloseBtnClickListener;
    private int mContentLines;
    private TextView mIgnore;
    private ImageView mImage;
    private boolean mIsChangeText;
    private View.OnClickListener mNegativeClickListener;
    private OnLinesChangedListener mOnLinesChangedListener;
    private View.OnClickListener mPositiveClickListener;
    private int mTextBtnRuleFlag;
    private COUIMarqueeTextView mTitle;
    private int mType;

    public COUIDefaultTopTipsView(Context context) {
        this(context, null);
    }

    private void changeBtnTypeImpl() {
        int i10;
        this.end.i(this);
        b bVar = this.end;
        int i11 = f.f6625O;
        int i12 = f.f6635e;
        bVar.k(i11, 7, i12, 6);
        this.end.D(i11, 7, getContext().getResources().getDimensionPixelSize(d.f6532S0));
        int i13 = 4;
        this.end.k(i11, 4, 0, 4);
        b bVar2 = this.end;
        int i14 = f.f6611A;
        bVar2.k(i14, 3, i11, 3);
        this.end.D(i14, 3, 0);
        b bVar3 = this.end;
        int i15 = f.f6631a;
        bVar3.k(i15, 3, i11, 3);
        this.end.D(i15, 3, 0);
        this.end.F(i12, 0);
        this.end.F(i14, 4);
        this.end.F(i15, 4);
        b bVar4 = this.end;
        if (TextUtils.isEmpty(this.mIgnore.getText())) {
            i10 = 8;
        } else {
            i10 = 4;
        }
        bVar4.F(i14, i10);
        b bVar5 = this.end;
        if (TextUtils.isEmpty(this.mAction.getText())) {
            i13 = 8;
        }
        bVar5.F(i15, i13);
        this.end.d(this);
    }

    private void changeTextTypeImpl() {
        int i10;
        this.end.i(this);
        int i11 = 0;
        if (isNeedMultiText()) {
            b bVar = this.end;
            int i12 = f.f6625O;
            bVar.k(i12, 7, 0, 7);
            if (TextUtils.isEmpty(this.mAction.getText()) && TextUtils.isEmpty(this.mIgnore.getText())) {
                this.end.k(i12, 4, 0, 4);
            } else {
                this.end.k(i12, 4, -1, 4);
            }
            this.end.D(i12, 7, getContext().getResources().getDimensionPixelSize(d.f6540W0));
            b bVar2 = this.end;
            int i13 = f.f6611A;
            bVar2.k(i13, 3, i12, 4);
            this.end.k(i13, 4, 0, 4);
            b bVar3 = this.end;
            Resources resources = getContext().getResources();
            int i14 = d.f6534T0;
            bVar3.D(i13, 3, resources.getDimensionPixelSize(i14));
            b bVar4 = this.end;
            Resources resources2 = getContext().getResources();
            int i15 = d.f6536U0;
            bVar4.D(i13, 4, resources2.getDimensionPixelSize(i15));
            b bVar5 = this.end;
            int i16 = f.f6631a;
            bVar5.k(i16, 3, i12, 4);
            this.end.k(i16, 4, 0, 4);
            this.end.D(i16, 3, getContext().getResources().getDimensionPixelSize(i14));
            this.end.D(i16, 4, getContext().getResources().getDimensionPixelSize(i15));
            b bVar6 = this.end;
            int i17 = f.f6612B;
            bVar6.k(i17, 4, -1, 4);
            this.end.k(i17, 3, 0, 3);
            this.end.D(i17, 3, getContext().getResources().getDimensionPixelSize(d.f6538V0));
        } else {
            b bVar7 = this.end;
            int i18 = f.f6625O;
            int i19 = f.f6611A;
            bVar7.k(i18, 7, i19, 6);
            this.end.k(i18, 4, 0, 4);
            this.end.D(i18, 7, getContext().getResources().getDimensionPixelSize(d.f6532S0));
            this.end.k(i19, 3, i18, 3);
            this.end.k(i19, 4, i18, 4);
            this.end.D(i19, 3, 0);
            this.end.D(i19, 4, 0);
            b bVar8 = this.end;
            int i20 = f.f6631a;
            bVar8.k(i20, 3, i18, 3);
            this.end.k(i20, 4, i18, 4);
            this.end.D(i20, 3, 0);
            this.end.D(i20, 4, 0);
            b bVar9 = this.end;
            int i21 = f.f6612B;
            bVar9.k(i21, 3, i18, 3);
            this.end.k(i21, 4, i18, 4);
            this.end.D(i21, 3, 0);
        }
        if (this.mOnLinesChangedListener != null && this.mContentLines != this.mTitle.getLineCount()) {
            int lineCount = this.mTitle.getLineCount();
            this.mContentLines = lineCount;
            this.mOnLinesChangedListener.onLinesChanged(lineCount);
        }
        this.end.F(f.f6635e, 4);
        b bVar10 = this.end;
        int i22 = f.f6611A;
        if (TextUtils.isEmpty(this.mIgnore.getText())) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        bVar10.F(i22, i10);
        b bVar11 = this.end;
        int i23 = f.f6631a;
        if (TextUtils.isEmpty(this.mAction.getText())) {
            i11 = 8;
        }
        bVar11.F(i23, i11);
        this.end.d(this);
    }

    private boolean isNeedMultiText() {
        TextView textView;
        boolean z10;
        int right;
        int left;
        if (this.mTitle.getLineCount() > 1) {
            return true;
        }
        if (this.mTitle.getMaxLines() == 1) {
            return false;
        }
        float measureText = this.mTitle.getPaint().measureText(this.mTitle.getText().toString());
        if (TextUtils.isEmpty(this.mIgnore.getText())) {
            textView = this.mAction;
        } else {
            textView = this.mIgnore;
        }
        if (TextUtils.isEmpty(this.mAction.getText()) && TextUtils.isEmpty(this.mIgnore.getText())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (K.v(this) == 1) {
            int min = (int) Math.min(measureText + this.mTitle.getRight(), this.mTitle.getLeft());
            if (z10) {
                left = textView.getRight();
            } else {
                left = getLeft();
            }
            if (left + getContext().getResources().getDimensionPixelSize(d.f6530R0) >= min) {
                return true;
            }
            return false;
        }
        int max = (int) Math.max(measureText + this.mTitle.getLeft(), this.mTitle.getRight());
        if (z10) {
            right = textView.getLeft();
        } else {
            right = getRight();
        }
        if (max + getContext().getResources().getDimensionPixelSize(d.f6530R0) >= right) {
            return true;
        }
        return false;
    }

    private void remeasureTextBtnWidth(TextView textView, int i10) {
        textView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), 0, -2), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(textView.getMeasuredHeight(), Integer.MIN_VALUE), 0, -2));
    }

    private void setBtnColorImpl(int i10, int i11) {
        if (i10 != 2) {
            if (i10 == 3) {
                this.mAction.setTextColor(i11);
                return;
            }
            throw new IllegalArgumentException("setBtnColorImpl parameter 'which' is wrong");
        }
        this.mIgnore.setTextColor(i11);
    }

    private void setBtnDrawableImpl(int i10, Drawable drawable) {
        if (i10 == 4) {
            this.mClose.setImageDrawable(drawable);
            changeType(1);
            return;
        }
        throw new IllegalArgumentException("setBtnDrawableImpl parameter 'which' is wrong");
    }

    private void setBtnTextImpl(int i10, CharSequence charSequence) {
        if (i10 != 2) {
            if (i10 == 3) {
                this.mAction.setText(charSequence);
                changeType(0);
                return;
            }
            throw new IllegalArgumentException("setBtnTextImpl parameter 'which' is wrong");
        }
        this.mIgnore.setText(charSequence);
        changeType(0);
    }

    public final void changeType(int i10) {
        if (i10 == 0) {
            changeTextTypeImpl();
        } else {
            changeBtnTypeImpl();
        }
        this.mType = i10;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(h.f6662e, this);
        this.mImage = (ImageView) findViewById(f.f6612B);
        this.mTitle = (COUIMarqueeTextView) findViewById(f.f6625O);
        TextView textView = (TextView) findViewById(f.f6611A);
        this.mIgnore = textView;
        COUITextViewCompatUtil.setPressRippleDrawable(textView);
        this.mIgnore.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.tips.def.COUIDefaultTopTipsView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIDefaultTopTipsView.this.mNegativeClickListener != null) {
                    COUIDefaultTopTipsView.this.mNegativeClickListener.onClick(view);
                }
            }
        });
        TextView textView2 = (TextView) findViewById(f.f6631a);
        this.mAction = textView2;
        COUITextViewCompatUtil.setPressRippleDrawable(textView2);
        this.mAction.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.tips.def.COUIDefaultTopTipsView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIDefaultTopTipsView.this.mPositiveClickListener != null) {
                    COUIDefaultTopTipsView.this.mPositiveClickListener.onClick(view);
                }
            }
        });
        ImageView imageView = (ImageView) findViewById(f.f6635e);
        this.mClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.tips.def.COUIDefaultTopTipsView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIDefaultTopTipsView.this.mCloseBtnClickListener != null) {
                    COUIDefaultTopTipsView.this.mCloseBtnClickListener.onClick(view);
                }
            }
        });
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (K.v(this) == 1) {
            TextView textView = this.mAction;
            textView.layout(textView.getLeft(), this.mAction.getTop(), this.mAction.getLeft() + this.mAction.getMeasuredWidth(), this.mAction.getBottom());
            this.mIgnore.layout(this.mAction.getRight(), this.mIgnore.getTop(), this.mAction.getRight() + this.mIgnore.getMeasuredWidth(), this.mIgnore.getBottom());
        } else {
            TextView textView2 = this.mAction;
            textView2.layout(textView2.getRight() - this.mAction.getMeasuredWidth(), this.mAction.getTop(), this.mAction.getRight(), this.mAction.getBottom());
            this.mIgnore.layout(this.mAction.getLeft() - this.mIgnore.getMeasuredWidth(), this.mIgnore.getTop(), this.mAction.getLeft(), this.mIgnore.getBottom());
        }
        if (this.mType == 0 && this.mIsChangeText) {
            this.mIsChangeText = false;
            changeTextTypeImpl();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth() - ((((ConstraintLayout.LayoutParams) this.mTitle.getLayoutParams()).getMarginStart() + this.mImage.getMeasuredWidth()) + ((ConstraintLayout.LayoutParams) this.mImage.getLayoutParams()).getMarginStart());
        int i12 = measuredWidth >> 1;
        if (this.mAction.getMeasuredWidth() <= i12) {
            this.mTextBtnRuleFlag++;
        }
        if (this.mIgnore.getMeasuredWidth() <= i12) {
            this.mTextBtnRuleFlag += 2;
        }
        int i13 = this.mTextBtnRuleFlag;
        if (i13 != 0) {
            if (i13 != 1) {
                if (i13 == 2) {
                    remeasureTextBtnWidth(this.mAction, measuredWidth - this.mIgnore.getMeasuredWidth());
                }
            } else {
                remeasureTextBtnWidth(this.mIgnore, measuredWidth - this.mAction.getMeasuredWidth());
            }
        } else {
            remeasureTextBtnWidth(this.mAction, i12);
            remeasureTextBtnWidth(this.mIgnore, i12);
        }
        this.mTextBtnRuleFlag = 0;
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setCloseBtnListener(View.OnClickListener onClickListener) {
        this.mCloseBtnClickListener = onClickListener;
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setCloseDrawable(Drawable drawable) {
        setBtnDrawableImpl(4, drawable);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setNegativeButton(CharSequence charSequence) {
        setBtnTextImpl(2, charSequence);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setNegativeButtonColor(int i10) {
        setBtnColorImpl(2, i10);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setNegativeButtonListener(View.OnClickListener onClickListener) {
        this.mNegativeClickListener = onClickListener;
    }

    public void setOnLinesChangedListener(OnLinesChangedListener onLinesChangedListener) {
        this.mOnLinesChangedListener = onLinesChangedListener;
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setPositiveButton(CharSequence charSequence) {
        setBtnTextImpl(3, charSequence);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setPositiveButtonColor(int i10) {
        setBtnColorImpl(3, i10);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setPositiveButtonListener(View.OnClickListener onClickListener) {
        this.mPositiveClickListener = onClickListener;
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setStartIcon(Drawable drawable) {
        this.mImage.setImageDrawable(drawable);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setTipsText(CharSequence charSequence) {
        this.mIsChangeText = true;
        this.mTitle.setText(charSequence);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setTipsTextColor(int i10) {
        this.mTitle.setTextColor(i10);
    }

    public void startRoll() {
        this.mTitle.continueRoll();
    }

    public void stopRoll() {
        this.mTitle.stopRoll();
        this.mTitle.setMarqueeEnable(false);
    }

    public COUIDefaultTopTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIDefaultTopTipsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mType = 0;
        this.mIsChangeText = true;
        this.end = new b();
        this.mContentLines = -1;
        this.mTextBtnRuleFlag = 0;
        init();
    }
}
