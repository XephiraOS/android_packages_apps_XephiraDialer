package com.coui.appcompat.statement;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.textutil.COUIChangeTextUtil;

/* loaded from: classes.dex */
public class COUIFullPageStatement extends LinearLayout {
    private static final int CONFIRM_BUTTON_MAX_LINES = 2;
    private static final int MEDIUM_LARGE_SCREEN_SW_THRESHOLD = 480;
    private boolean isInSmallLand;
    private TextView mAppStatement;
    private COUIButton mBottomButtonLand;
    private COUIButton mBottomButtonNormal;
    private LinearLayout mButtonLayoutLand;
    private LinearLayout mButtonLayoutNormal;
    private Context mContext;
    private LinearLayoutCompat mCustomView;
    private COUIButton mExitButtonLand;
    private TextView mExitTextView;
    private LayoutInflater mLayoutInflater;
    private int mLayoutResourceId;
    private OnButtonClickListener mOnButtonClickListener;
    private ScrollView mScrollButton;
    private COUIMaxHeightScrollView mScrollText;
    private int mStyle;
    private TextView mTitle;
    private COUIMaxHeightScrollView mTitleScrollView;

    /* loaded from: classes.dex */
    public interface OnButtonClickListener {
        void onBottomButtonClick();

        void onExitButtonClick();
    }

    public COUIFullPageStatement(Context context) {
        this(context, (AttributeSet) null);
    }

    private void disableTitleScrollBeforeMaxHeight() {
        if (this.mTitleScrollView == null) {
            return;
        }
        post(new Runnable() { // from class: com.coui.appcompat.statement.COUIFullPageStatement.5
            @Override // java.lang.Runnable
            public void run() {
                if (COUIFullPageStatement.this.mTitleScrollView.getHeight() < COUIFullPageStatement.this.mTitleScrollView.getMaxHeight()) {
                    COUIFullPageStatement.this.mTitleScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.statement.COUIFullPageStatement.5.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                }
            }
        });
    }

    private void initView() {
        boolean z10;
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.mLayoutInflater = layoutInflater;
        View inflate = layoutInflater.inflate(this.mLayoutResourceId, this);
        this.mAppStatement = (TextView) inflate.findViewById(X8.h.f4891I0);
        this.mScrollText = (COUIMaxHeightScrollView) inflate.findViewById(X8.h.f4939o0);
        if (isSmallScreen(this.mContext.getResources().getConfiguration()) && !isPortrait(this.mContext.getResources().getConfiguration())) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.isInSmallLand = z10;
        this.mExitTextView = (TextView) inflate.findViewById(X8.h.f4889H0);
        this.mBottomButtonNormal = (COUIButton) inflate.findViewById(X8.h.f4924h);
        if (isNotTinyStyle()) {
            this.mExitButtonLand = (COUIButton) inflate.findViewById(X8.h.f4928j);
            this.mBottomButtonLand = (COUIButton) inflate.findViewById(X8.h.f4926i);
            this.mButtonLayoutLand = (LinearLayout) inflate.findViewById(X8.h.f4936n);
            this.mButtonLayoutNormal = (LinearLayout) inflate.findViewById(X8.h.f4938o);
            this.mBottomButtonLand.setSingleLine(false);
            this.mBottomButtonLand.setMaxLines(2);
            this.mBottomButtonLand.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.statement.COUIFullPageStatement.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (COUIFullPageStatement.this.mOnButtonClickListener != null) {
                        COUIFullPageStatement.this.mOnButtonClickListener.onBottomButtonClick();
                    }
                }
            });
            this.mExitButtonLand.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.statement.COUIFullPageStatement.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (COUIFullPageStatement.this.mOnButtonClickListener != null) {
                        COUIFullPageStatement.this.mOnButtonClickListener.onExitButtonClick();
                    }
                }
            });
        }
        this.mTitle = (TextView) inflate.findViewById(X8.h.f4893J0);
        this.mTitleScrollView = (COUIMaxHeightScrollView) inflate.findViewById(X8.h.f4883E0);
        this.mScrollButton = (ScrollView) inflate.findViewById(X8.h.f4937n0);
        this.mCustomView = (LinearLayoutCompat) inflate.findViewById(X8.h.f4895L);
        refreshParams();
        disableTitleScrollBeforeMaxHeight();
        COUIChangeTextUtil.adaptFontSize(this.mAppStatement, 2);
        this.mBottomButtonNormal.setSingleLine(false);
        this.mBottomButtonNormal.setMaxLines(2);
        this.mBottomButtonNormal.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.statement.COUIFullPageStatement.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIFullPageStatement.this.mOnButtonClickListener != null) {
                    COUIFullPageStatement.this.mOnButtonClickListener.onBottomButtonClick();
                }
            }
        });
        this.mExitTextView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.statement.COUIFullPageStatement.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIFullPageStatement.this.mOnButtonClickListener != null) {
                    COUIFullPageStatement.this.mOnButtonClickListener.onExitButtonClick();
                }
            }
        });
        COUIChangeTextUtil.adaptFontSize(this.mExitTextView, 4);
    }

    private boolean isNotTinyStyle() {
        if (this.mLayoutResourceId == X8.j.f4973d) {
            return true;
        }
        return false;
    }

    private boolean isPortrait(Configuration configuration) {
        if (configuration.orientation == 1) {
            return true;
        }
        return false;
    }

    private boolean isSmallScreen(Configuration configuration) {
        if (configuration.smallestScreenWidthDp < 480) {
            return true;
        }
        return false;
    }

    public TextView getAppStatement() {
        return this.mAppStatement;
    }

    public COUIButton getConfirmButton() {
        if (this.isInSmallLand && isNotTinyStyle()) {
            return this.mBottomButtonLand;
        }
        return this.mBottomButtonNormal;
    }

    public TextView getExitButton() {
        if (this.isInSmallLand && isNotTinyStyle()) {
            return this.mExitButtonLand;
        }
        return this.mExitTextView;
    }

    public COUIMaxHeightScrollView getScrollTextView() {
        return this.mScrollText;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        boolean z10;
        super.onConfigurationChanged(configuration);
        if (this.mLayoutResourceId == X8.j.f4974e) {
            return;
        }
        if (isSmallScreen(configuration) && !isPortrait(configuration)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.mBottomButtonNormal.getLayoutParams().width = getContext().createConfigurationContext(configuration).getResources().getDimensionPixelOffset(X8.f.f4824x1);
        }
        if (this.isInSmallLand != z10) {
            this.isInSmallLand = z10;
            refreshParams();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.mLayoutResourceId == X8.j.f4974e) {
            ViewParent parent = this.mScrollButton.getParent();
            if (parent instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) parent;
                int bottom = ((linearLayout.getBottom() - linearLayout.getTop()) - this.mScrollButton.getTop()) - this.mScrollButton.getMeasuredHeight();
                ScrollView scrollView = this.mScrollButton;
                scrollView.layout(scrollView.getLeft(), this.mScrollButton.getTop() + bottom, this.mScrollButton.getRight(), this.mScrollButton.getBottom() + bottom);
            }
        }
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, X8.o.f5399r1, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, X8.o.f5399r1, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mExitTextView.setTextColor(typedArray.getColor(X8.o.f5431v1, 0));
            this.mAppStatement.setTextColor(typedArray.getColor(X8.o.f5439w1, 0));
            typedArray.recycle();
        }
    }

    public void refreshParams() {
        if (isNotTinyStyle()) {
            if (this.isInSmallLand) {
                this.mButtonLayoutNormal.setVisibility(8);
                this.mButtonLayoutLand.setVisibility(0);
            } else {
                this.mButtonLayoutNormal.setVisibility(0);
                this.mButtonLayoutLand.setVisibility(8);
            }
        }
    }

    public void setAppStatement(CharSequence charSequence) {
        this.mAppStatement.setText(charSequence);
    }

    public void setAppStatementTextColor(int i10) {
        this.mAppStatement.setTextColor(i10);
    }

    public void setButtonDisableColor(int i10) {
        this.mBottomButtonNormal.setDisabledColor(i10);
        if (isNotTinyStyle()) {
            this.mBottomButtonLand.setDisabledColor(i10);
        }
    }

    public void setButtonDrawableColor(int i10) {
        this.mBottomButtonNormal.setDrawableColor(i10);
        if (isNotTinyStyle()) {
            this.mBottomButtonLand.setDrawableColor(i10);
        }
    }

    public void setButtonListener(OnButtonClickListener onButtonClickListener) {
        this.mOnButtonClickListener = onButtonClickListener;
    }

    public void setButtonText(CharSequence charSequence) {
        this.mBottomButtonNormal.setText(charSequence);
        if (isNotTinyStyle()) {
            this.mBottomButtonLand.setText(charSequence);
        }
    }

    public void setCustomView(View view) {
        LinearLayoutCompat linearLayoutCompat = this.mCustomView;
        if (linearLayoutCompat != null) {
            if (view == null) {
                linearLayoutCompat.removeAllViews();
                this.mCustomView.setVisibility(8);
            } else {
                linearLayoutCompat.setVisibility(0);
                this.mCustomView.removeAllViews();
                this.mCustomView.addView(view);
            }
        }
    }

    public void setExitButtonText(CharSequence charSequence) {
        if (isNotTinyStyle()) {
            this.mExitButtonLand.setText(charSequence);
        }
        this.mExitTextView.setText(charSequence);
    }

    public void setExitTextColor(int i10) {
        this.mExitTextView.setTextColor(i10);
    }

    public void setStatementMaxHeight(int i10) {
        this.mScrollText.setMaxHeight(i10);
    }

    public void setTitleText(CharSequence charSequence) {
        this.mTitle.setText(charSequence);
    }

    public COUIFullPageStatement(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4356O);
    }

    public COUIFullPageStatement(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, X8.n.f5046r);
    }

    public COUIFullPageStatement(Context context, int i10) {
        this(context, null, 0, i10);
    }

    public COUIFullPageStatement(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mContext = context;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, X8.o.f5399r1, i10, i11);
        String string = obtainStyledAttributes.getString(X8.o.f5455y1);
        String string2 = obtainStyledAttributes.getString(X8.o.f5423u1);
        String string3 = obtainStyledAttributes.getString(X8.o.f5447x1);
        this.mLayoutResourceId = obtainStyledAttributes.getResourceId(X8.o.f5407s1, X8.j.f4973d);
        initView();
        this.mAppStatement.setText(obtainStyledAttributes.getString(X8.o.f5415t1));
        int color = obtainStyledAttributes.getColor(X8.o.f5431v1, 0);
        if (color != 0) {
            this.mExitTextView.setTextColor(color);
        }
        this.mAppStatement.setTextColor(obtainStyledAttributes.getColor(X8.o.f5439w1, 0));
        if (string2 != null) {
            this.mBottomButtonNormal.setText(string2);
            if (isNotTinyStyle()) {
                this.mBottomButtonLand.setText(string2);
            }
        }
        if (string != null) {
            if (isNotTinyStyle()) {
                this.mExitButtonLand.setText(string);
            }
            this.mExitTextView.setText(string);
        }
        if (string3 != null) {
            this.mTitle.setText(string3);
        }
        obtainStyledAttributes.recycle();
    }
}
