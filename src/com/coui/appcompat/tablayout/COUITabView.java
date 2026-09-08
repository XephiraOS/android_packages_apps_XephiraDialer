package com.coui.appcompat.tablayout;

import A.h;
import Y8.g;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.P;
import androidx.core.view.K;
import androidx.core.widget.k;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.reddot.COUIHintRedDot;
import com.coui.appcompat.reddot.COUIHintRedDotMemento;
import com.coui.appcompat.state.COUIMaskEffectDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;
import com.coui.appcompat.textutil.COUIChangeTextUtil;

/* loaded from: classes3.dex */
public class COUITabView extends LinearLayout {
    private COUITabLayout mCOUITabLayout;
    private ImageView mCustomIconView;
    private TextView mCustomTextView;
    protected View mCustomView;
    private int mDefaultMaxLines;
    private COUIHintRedDot mHintRedDot;
    private ImageView mIconView;
    private COUIMaskEffectDrawable mMaskEffectDrawable;
    private boolean mSelectedByClick;
    private COUIStateEffectDrawable mStateEffectBackground;
    private COUITab mTab;
    private final RectF mTabRect;
    private TextView mTextFrame;

    public COUITabView(Context context, COUITabLayout cOUITabLayout) {
        super(context);
        this.mTabRect = new RectF();
        this.mDefaultMaxLines = 1;
        this.mCOUITabLayout = cOUITabLayout;
        if (cOUITabLayout.mTabBackgroundResId != 0) {
            K.n0(this, h.f(context.getResources(), this.mCOUITabLayout.mTabBackgroundResId, getContext().getTheme()));
        }
        K.A0(this, this.mCOUITabLayout.getTabPaddingStart(), this.mCOUITabLayout.getTabPaddingTop(), this.mCOUITabLayout.getTabPaddingEnd(), this.mCOUITabLayout.getTabPaddingBottom());
        setGravity(17);
        setOrientation(0);
        setClickable(true);
        configStateEffectBackground();
    }

    private float approximateLineWidth(Layout layout, int i10, float f10) {
        return layout.getLineWidth(i10) * (f10 / layout.getPaint().getTextSize());
    }

    private void configStateEffectBackground() {
        Drawable background;
        setDefaultFocusHighlightEnabled(false);
        COUIMaskEffectDrawable cOUIMaskEffectDrawable = new COUIMaskEffectDrawable(getContext(), 1);
        this.mMaskEffectDrawable = cOUIMaskEffectDrawable;
        cOUIMaskEffectDrawable.setMaskRect(this.mTabRect, dpToPx(8), dpToPx(8));
        this.mMaskEffectDrawable.enableSelectedState(false);
        this.mMaskEffectDrawable.setMinProgressForTouchEnterAnimation(0.0f);
        if (getBackground() == null) {
            background = new ColorDrawable(0);
        } else {
            background = getBackground();
        }
        COUIStateEffectDrawable cOUIStateEffectDrawable = new COUIStateEffectDrawable(new Drawable[]{background, this.mMaskEffectDrawable});
        this.mStateEffectBackground = cOUIStateEffectDrawable;
        super.setBackground(cOUIStateEffectDrawable);
        COUIDarkModeUtil.setForceDarkAllow(this, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTextAndIcon$0() {
        COUITabLayout cOUITabLayout = this.mCOUITabLayout;
        cOUITabLayout.mTabAlreadyMeasure = false;
        cOUITabLayout.mTabStrip.requestLayout();
    }

    private void updateTextAndIcon(TextView textView, ImageView imageView) {
        Drawable drawable;
        CharSequence charSequence;
        CharSequence charSequence2;
        COUITab cOUITab = this.mTab;
        CharSequence charSequence3 = null;
        if (cOUITab != null) {
            drawable = cOUITab.getIcon();
        } else {
            drawable = null;
        }
        COUITab cOUITab2 = this.mTab;
        if (cOUITab2 != null) {
            charSequence = cOUITab2.getText();
        } else {
            charSequence = null;
        }
        COUITab cOUITab3 = this.mTab;
        if (cOUITab3 != null) {
            charSequence2 = cOUITab3.getContentDescription();
        } else {
            charSequence2 = null;
        }
        int i10 = 0;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
            imageView.setContentDescription(charSequence2);
        }
        boolean z10 = !TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (z10) {
                CharSequence text = textView.getText();
                textView.setText(charSequence);
                textView.setVisibility(0);
                COUITabLayout cOUITabLayout = this.mCOUITabLayout;
                if (cOUITabLayout.mTabAlreadyMeasure) {
                    COUISlidingTabStrip cOUISlidingTabStrip = cOUITabLayout.mTabStrip;
                    if (cOUISlidingTabStrip != null) {
                        cOUITabLayout.mTabAlreadyMeasure = false;
                        cOUISlidingTabStrip.requestLayout();
                    }
                } else if (!charSequence.equals(text)) {
                    this.mCOUITabLayout.mTabStrip.post(new Runnable() { // from class: com.coui.appcompat.tablayout.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            COUITabView.this.lambda$updateTextAndIcon$0();
                        }
                    });
                }
                textView.setMaxLines(this.mDefaultMaxLines);
                setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView.setText((CharSequence) null);
            }
            textView.setContentDescription(charSequence2);
        }
        if (imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            if (z10 && imageView.getVisibility() == 0) {
                i10 = dpToPx(8);
            }
            if (i10 != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = i10;
                imageView.requestLayout();
            }
        }
        if (!z10) {
            charSequence3 = charSequence2;
        }
        P.a(this, charSequence3);
    }

    public int dpToPx(int i10) {
        return Math.round(getResources().getDisplayMetrics().density * i10);
    }

    public COUIHintRedDot getHintRedDot() {
        return this.mHintRedDot;
    }

    public boolean getSelectedByClick() {
        return this.mSelectedByClick;
    }

    public COUITab getTab() {
        return this.mTab;
    }

    public TextView getTextView() {
        return this.mTextFrame;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ActionBar.b.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ActionBar.b.class.getName());
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mTabRect.set(0.0f, 0.0f, i10, i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                COUITabLayout cOUITabLayout = this.mCOUITabLayout;
                if (cOUITabLayout.mEnableVibrator) {
                    COUITab cOUITab = cOUITabLayout.mSelectedTab;
                    if (cOUITab != null && cOUITab.mView != this) {
                        performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
                    }
                    this.mStateEffectBackground.setTouched(true);
                }
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.mStateEffectBackground.setTouched(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean performClick = super.performClick();
        if (this.mTab != null) {
            if (!performClick) {
                playSoundEffect(0);
            }
            this.mCOUITabLayout.mNeedAdjust = false;
            this.mSelectedByClick = true;
            this.mTab.select();
            this.mSelectedByClick = false;
            return true;
        }
        return performClick;
    }

    public void refresh() {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            cOUIStateEffectDrawable.refresh(getContext());
        }
    }

    public void reset() {
        setTab(null);
        setSelected(false);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            if (drawable == null) {
                cOUIStateEffectDrawable.setViewBackground(new ColorDrawable(0));
                return;
            } else {
                cOUIStateEffectDrawable.setViewBackground(drawable);
                return;
            }
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        TextView textView = this.mTextFrame;
        if (textView != null) {
            textView.setEnabled(z10);
        }
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            imageView.setEnabled(z10);
        }
        View view = this.mCustomView;
        if (view != null) {
            view.setEnabled(z10);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        boolean z11;
        TextView textView;
        if (isSelected() != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        super.setSelected(z10);
        if (z11 && (textView = this.mTextFrame) != null) {
            if (z10) {
                textView.setTypeface(this.mCOUITabLayout.mSelectedTypeface);
            } else {
                textView.setTypeface(this.mCOUITabLayout.mNormalTypeface);
            }
        }
        TextView textView2 = this.mTextFrame;
        if (textView2 != null) {
            COUIDarkModeUtil.setForceDarkAllow(textView2, !z10);
        }
        TextView textView3 = this.mTextFrame;
        if (textView3 != null) {
            textView3.setSelected(z10);
        }
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            imageView.setSelected(z10);
        }
        View view = this.mCustomView;
        if (view != null) {
            view.setSelected(z10);
        }
    }

    public void setTab(COUITab cOUITab) {
        if (cOUITab != this.mTab) {
            this.mTab = cOUITab;
            update();
        }
    }

    public final void update() {
        View view;
        boolean z10;
        COUITab cOUITab = this.mTab;
        COUIHintRedDotMemento cOUIHintRedDotMemento = null;
        if (cOUITab != null) {
            view = cOUITab.getCustomView();
        } else {
            view = null;
        }
        boolean z11 = false;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view, 0, new ViewGroup.LayoutParams(-2, -2));
            }
            this.mCustomView = view;
            TextView textView = this.mTextFrame;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.mIconView.setImageDrawable(null);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.text1);
            this.mCustomTextView = textView2;
            if (textView2 != null) {
                this.mDefaultMaxLines = k.d(textView2);
            }
            this.mCustomIconView = (ImageView) view.findViewById(R.id.icon);
        } else {
            View view2 = this.mCustomView;
            if (view2 != null) {
                removeView(view2);
                this.mCustomView = null;
            }
            this.mCustomTextView = null;
            this.mCustomIconView = null;
        }
        if (this.mCustomView == null) {
            if (this.mIconView == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(g.f5686e, (ViewGroup) this, false);
                addView(imageView2, 0);
                this.mIconView = imageView2;
            }
            if (this.mTextFrame == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(g.f5687f, (ViewGroup) this, false);
                this.mTextFrame = textView3;
                addView(textView3);
                TextView textView4 = this.mTextFrame;
                COUITabLayout cOUITabLayout = this.mCOUITabLayout;
                K.A0(textView4, cOUITabLayout.mTabPaddingStart, cOUITabLayout.mTabPaddingTop, cOUITabLayout.mTabPaddingEnd, cOUITabLayout.mTabPaddingBottom);
                this.mDefaultMaxLines = k.d(this.mTextFrame);
                TextView textView5 = this.mTextFrame;
                if (cOUITab != null && cOUITab.isSelected()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                COUIChangeTextUtil.adaptBoldAndMediumFont(textView5, z10);
            }
            COUIHintRedDot cOUIHintRedDot = this.mHintRedDot;
            if (cOUIHintRedDot != null) {
                cOUIHintRedDotMemento = cOUIHintRedDot.saveMemento();
                removeView(this.mHintRedDot);
            }
            this.mHintRedDot = new COUIHintRedDot(getContext());
            this.mHintRedDot.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            addView(this.mHintRedDot);
            if (cOUIHintRedDotMemento != null) {
                cOUIHintRedDotMemento.applyTo(this.mHintRedDot);
            }
            this.mTextFrame.setTextSize(0, this.mCOUITabLayout.getTabTextSize());
            if (cOUITab != null && cOUITab.isSelected()) {
                this.mTextFrame.setTypeface(this.mCOUITabLayout.mSelectedTypeface);
            } else {
                this.mTextFrame.setTypeface(this.mCOUITabLayout.mNormalTypeface);
            }
            this.mTextFrame.setIncludeFontPadding(false);
            ColorStateList colorStateList = this.mCOUITabLayout.mTabTextColors;
            if (colorStateList != null) {
                this.mTextFrame.setTextColor(colorStateList);
            }
            updateTextAndIcon(this.mTextFrame, this.mIconView);
        } else {
            if (this.mTextFrame == null) {
                this.mTextFrame = (TextView) LayoutInflater.from(getContext()).inflate(g.f5687f, (ViewGroup) this, false);
            }
            TextView textView6 = this.mCustomTextView;
            if (textView6 != null || this.mCustomIconView != null) {
                updateTextAndIcon(textView6, this.mCustomIconView);
            }
        }
        if (cOUITab != null && cOUITab.isSelected()) {
            z11 = true;
        }
        setSelected(z11);
    }
}
