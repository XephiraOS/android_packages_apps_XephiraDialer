package com.coui.appcompat.searchview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.google.android.material.internal.TextWatcherAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIHintAnimationLayout extends FrameLayout {
    private static final int DURATION_TIME = 600;
    private static final int INTERVAL_TIME = 3000;
    private static final int IN_DELAY_TIME = 150;
    private static final String TAG = "COUIHintAnimationLayout";
    boolean mAnimationIsWorking;
    private AnimatorSet mAnimatorSetIn;
    private AnimatorSet mAnimatorSetOut;
    private COUIHintAnimationChangeListener mCOUIHintAnimationChangeListener;
    private Runnable mChangeHintRunnable;
    private int mCouiSearchBarAnimationTranslateExtra;
    private int mCurrentHintIndex;
    private TextView mCurrentHintTextView;
    private int mCurrentPlayTime;
    private ObjectAnimator mFadeIn;
    private ObjectAnimator mFadeOut;
    private List<String> mHintStrings;
    private TextView mHintTextViewFirst;
    private TextView mHintTextViewThen;
    private ObjectAnimator mMoveIn;
    private ObjectAnimator mMoveOut;
    boolean mNeedRePlay;
    private boolean mNeedStopAnimation;
    private int mRepeatCount;
    private EditText mSearchEditText;
    private String mTempQueryHint;
    private static final TimeInterpolator TRANSLATEINTERPOLATOR = K.a.a(0.3f, 0.0f, 0.2f, 1.0f);
    private static final COUIEaseInterpolator EASEINTERPOLATOR = new COUIEaseInterpolator();

    /* loaded from: classes.dex */
    public interface COUIHintAnimationChangeListener {
        void hintAnimationChange(int i10, String str, TextView textView);
    }

    public COUIHintAnimationLayout(Context context) {
        this(context, null);
    }

    private boolean animationIsRunning() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2 = this.mAnimatorSetIn;
        if ((animatorSet2 != null && animatorSet2.isRunning()) || ((animatorSet = this.mAnimatorSetOut) != null && animatorSet.isRunning())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyHintChangeAnimation(String str) {
        if (this.mCurrentHintTextView == null) {
            return;
        }
        int i10 = this.mCurrentPlayTime + 1;
        this.mCurrentPlayTime = i10;
        int i11 = this.mRepeatCount;
        if (i11 != -1 && i10 > i11) {
            pauseHintsAnimation();
            return;
        }
        this.mTempQueryHint = str;
        int measuredHeight = ((getMeasuredHeight() - this.mCurrentHintTextView.getLineHeight()) / 2) + this.mCouiSearchBarAnimationTranslateExtra;
        if (this.mAnimatorSetOut != null && this.mAnimatorSetIn != null) {
            this.mMoveOut.setTarget(this.mCurrentHintTextView);
            this.mFadeOut.setTarget(this.mCurrentHintTextView);
            this.mMoveIn.setTarget(getNextHintTextView());
            this.mFadeIn.setTarget(getNextHintTextView());
        } else {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mCurrentHintTextView, "translationY", 0.0f, -measuredHeight);
            this.mMoveOut = ofFloat;
            TimeInterpolator timeInterpolator = TRANSLATEINTERPOLATOR;
            ofFloat.setInterpolator(timeInterpolator);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mCurrentHintTextView, "alpha", 1.0f, 0.0f);
            this.mFadeOut = ofFloat2;
            COUIEaseInterpolator cOUIEaseInterpolator = EASEINTERPOLATOR;
            ofFloat2.setInterpolator(cOUIEaseInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimatorSetOut = animatorSet;
            animatorSet.playTogether(this.mMoveOut, this.mFadeOut);
            this.mAnimatorSetOut.setDuration(600L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(getNextHintTextView(), "translationY", measuredHeight, 0.0f);
            this.mMoveIn = ofFloat3;
            ofFloat3.setInterpolator(timeInterpolator);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(getNextHintTextView(), "alpha", 0.0f, 1.0f);
            this.mFadeIn = ofFloat4;
            ofFloat4.setInterpolator(cOUIEaseInterpolator);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mAnimatorSetIn = animatorSet2;
            animatorSet2.playTogether(this.mMoveIn, this.mFadeIn);
            this.mAnimatorSetIn.setDuration(600L);
            this.mAnimatorSetIn.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUIHintAnimationLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    COUIHintAnimationLayout cOUIHintAnimationLayout = COUIHintAnimationLayout.this;
                    cOUIHintAnimationLayout.mCurrentHintTextView = cOUIHintAnimationLayout.getNextHintTextView();
                    if (COUIHintAnimationLayout.this.mNeedStopAnimation) {
                        COUIHintAnimationLayout.this.pauseHintsAnimation();
                        COUIHintAnimationLayout.this.mNeedStopAnimation = false;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    COUIHintAnimationLayout.this.getNextHintTextView().setText(COUIHintAnimationLayout.this.mTempQueryHint);
                    COUIHintAnimationLayout.this.getNextHintTextView().setVisibility(0);
                }
            });
        }
        postDelayed(new Runnable() { // from class: com.coui.appcompat.searchview.COUIHintAnimationLayout.4
            @Override // java.lang.Runnable
            public void run() {
                COUIHintAnimationLayout.this.mAnimatorSetIn.start();
            }
        }, 150L);
        this.mAnimatorSetOut.start();
        COUIHintAnimationChangeListener cOUIHintAnimationChangeListener = this.mCOUIHintAnimationChangeListener;
        if (cOUIHintAnimationChangeListener != null) {
            cOUIHintAnimationChangeListener.hintAnimationChange(this.mCurrentHintIndex, str, this.mCurrentHintTextView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnimation() {
        AnimatorSet animatorSet = this.mAnimatorSetIn;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mAnimatorSetIn.cancel();
        }
        AnimatorSet animatorSet2 = this.mAnimatorSetOut;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.mAnimatorSetOut.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TextView getNextHintTextView() {
        TextView textView = this.mCurrentHintTextView;
        TextView textView2 = this.mHintTextViewFirst;
        if (textView == textView2) {
            return this.mHintTextViewThen;
        }
        return textView2;
    }

    private void initHintAnimationTextView() {
        if (this.mHintTextViewFirst == null && this.mHintTextViewThen == null) {
            Context context = getContext();
            int i10 = X8.n.f5050v;
            this.mHintTextViewFirst = new TextView(new ContextThemeWrapper(context, i10), null);
            this.mHintTextViewThen = new TextView(new ContextThemeWrapper(getContext(), i10), null);
            this.mHintTextViewFirst.setImportantForAccessibility(2);
            this.mHintTextViewThen.setImportantForAccessibility(2);
            TextView textView = this.mHintTextViewFirst;
            int i11 = X8.n.f5052x;
            textView.setTextAppearance(i11);
            this.mHintTextViewThen.setTextAppearance(i11);
            TextView textView2 = this.mHintTextViewFirst;
            Context context2 = getContext();
            int i12 = X8.c.f4418z;
            textView2.setTextColor(COUIContextUtil.getAttrColor(context2, i12));
            this.mHintTextViewThen.setTextColor(COUIContextUtil.getAttrColor(getContext(), i12));
            this.mHintTextViewFirst.setId(X8.h.f4958y);
            this.mHintTextViewThen.setId(X8.h.f4960z);
            addView(this.mHintTextViewFirst);
            addView(this.mHintTextViewThen);
        }
    }

    private void initTextHintAnimation() {
        if (this.mChangeHintRunnable == null) {
            this.mHintStrings = new ArrayList();
            this.mChangeHintRunnable = new Runnable() { // from class: com.coui.appcompat.searchview.COUIHintAnimationLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    if (COUIHintAnimationLayout.this.mHintStrings.isEmpty()) {
                        return;
                    }
                    COUIHintAnimationLayout cOUIHintAnimationLayout = COUIHintAnimationLayout.this;
                    cOUIHintAnimationLayout.mCurrentHintIndex = (cOUIHintAnimationLayout.mCurrentHintIndex + 1) % COUIHintAnimationLayout.this.mHintStrings.size();
                    COUIHintAnimationLayout cOUIHintAnimationLayout2 = COUIHintAnimationLayout.this;
                    if (cOUIHintAnimationLayout2.mAnimationIsWorking) {
                        cOUIHintAnimationLayout2.applyHintChangeAnimation((String) cOUIHintAnimationLayout2.mHintStrings.get(COUIHintAnimationLayout.this.mCurrentHintIndex));
                    }
                    COUIHintAnimationLayout.this.postDelayed(this, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
                }
            };
            this.mSearchEditText.addTextChangedListener(new TextWatcherAdapter() { // from class: com.coui.appcompat.searchview.COUIHintAnimationLayout.2
                @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (!TextUtils.isEmpty(COUIHintAnimationLayout.this.mSearchEditText.getText().toString())) {
                        COUIHintAnimationLayout cOUIHintAnimationLayout = COUIHintAnimationLayout.this;
                        cOUIHintAnimationLayout.removeCallbacks(cOUIHintAnimationLayout.mChangeHintRunnable);
                        COUIHintAnimationLayout.this.mHintTextViewFirst.setVisibility(8);
                        COUIHintAnimationLayout.this.mHintTextViewThen.setVisibility(8);
                        COUIHintAnimationLayout.this.cancelAnimation();
                        COUIHintAnimationLayout.this.mAnimationIsWorking = false;
                        return;
                    }
                    if (!TextUtils.isEmpty(COUIHintAnimationLayout.this.mTempQueryHint)) {
                        COUIHintAnimationLayout.this.mCurrentHintTextView.setText(COUIHintAnimationLayout.this.mTempQueryHint);
                        COUIHintAnimationLayout.this.mCurrentHintTextView.setVisibility(0);
                        COUIHintAnimationLayout.this.getNextHintTextView().setVisibility(8);
                    }
                }
            });
        }
    }

    private void resetHintTextView() {
        this.mHintTextViewFirst.setTranslationY(0.0f);
        this.mHintTextViewFirst.setAlpha(1.0f);
        this.mHintTextViewThen.setTranslationY(0.0f);
        this.mHintTextViewThen.setAlpha(1.0f);
    }

    public TextView getCurrentHintTextView() {
        return this.mCurrentHintTextView;
    }

    public List<String> getHintStrings() {
        return this.mHintStrings;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        resumeHintsAnimation();
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        pauseHintsAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 == 0) {
            if (this.mNeedRePlay) {
                resumeHintsAnimation();
                this.mNeedRePlay = false;
                return;
            }
            return;
        }
        if (this.mAnimationIsWorking) {
            pauseHintsAnimation();
            this.mNeedRePlay = true;
        }
    }

    public void pauseHintsAnimation() {
        List<String> list;
        removeCallbacks(this.mChangeHintRunnable);
        if (this.mAnimationIsWorking && (list = this.mHintStrings) != null && list.size() != 0) {
            if (animationIsRunning()) {
                this.mNeedStopAnimation = true;
                return;
            }
            resetHintTextView();
            this.mAnimationIsWorking = false;
            if (!TextUtils.isEmpty(this.mTempQueryHint)) {
                this.mCurrentHintTextView.setText(this.mTempQueryHint);
                this.mCurrentHintTextView.setVisibility(0);
                getNextHintTextView().setVisibility(8);
                return;
            } else {
                this.mHintTextViewFirst.setVisibility(8);
                this.mHintTextViewThen.setVisibility(8);
                return;
            }
        }
        Log.e(TAG, "pauseHintsAnimation return");
    }

    public void resumeHintsAnimation() {
        setHintsAnimation(this.mHintStrings);
    }

    public void setCOUIHintAnimationChangeListener(COUIHintAnimationChangeListener cOUIHintAnimationChangeListener) {
        this.mCOUIHintAnimationChangeListener = cOUIHintAnimationChangeListener;
    }

    public void setHintsAnimation(List<String> list) {
        if (list != null && list.size() != 0) {
            if (this.mSearchEditText == null) {
                if (getChildAt(0) instanceof EditText) {
                    this.mSearchEditText = (EditText) getChildAt(0);
                } else {
                    Log.e(TAG, "Before calling this method, you must ensure that there is an edittext object in the container:1, you can call setSearchEditText or add an edittext yourself, refer to COUISearchBar2, you can put an edittext object in xml ( Refer to coui_search_view_animated_support_layout)to use the related functions of this animation container");
                    return;
                }
            }
            if (TextUtils.isEmpty(this.mSearchEditText.getText().toString())) {
                initHintAnimationTextView();
                initTextHintAnimation();
                if (!this.mHintStrings.equals(list)) {
                    this.mHintStrings.clear();
                    this.mHintStrings.addAll(list);
                }
                if (this.mCurrentHintTextView == null) {
                    this.mCurrentHintTextView = this.mHintTextViewFirst;
                }
                if (TextUtils.isEmpty(this.mTempQueryHint)) {
                    this.mTempQueryHint = this.mHintStrings.get(this.mCurrentHintIndex);
                }
                this.mCurrentHintTextView.setText(this.mTempQueryHint);
                this.mCurrentHintTextView.setVisibility(0);
                removeCallbacks(this.mChangeHintRunnable);
                this.mSearchEditText.setHint("");
                postDelayed(this.mChangeHintRunnable, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
                this.mAnimationIsWorking = true;
                return;
            }
            Log.e(TAG, "Setting hints animation content is invalid when the searchEdittext has a value");
        }
    }

    public void setRepeatCount(int i10) {
        if (i10 <= 0) {
            Log.e(TAG, "RepeatCount must be greater than zero");
        } else {
            this.mRepeatCount = i10;
        }
    }

    public void setSearchEditText(EditText editText) {
        this.mSearchEditText = editText;
        if (getChildCount() == 0) {
            addView(this.mSearchEditText, new FrameLayout.LayoutParams(-1, -1));
        } else {
            Log.e(TAG, "setSearchEditText() can only be executed once");
        }
    }

    public COUIHintAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentHintIndex = 0;
        this.mAnimationIsWorking = false;
        this.mNeedRePlay = false;
        this.mNeedStopAnimation = false;
        this.mRepeatCount = -1;
        this.mCurrentPlayTime = 0;
        this.mCouiSearchBarAnimationTranslateExtra = context.getResources().getDimensionPixelSize(X8.f.f4826x3);
    }
}
