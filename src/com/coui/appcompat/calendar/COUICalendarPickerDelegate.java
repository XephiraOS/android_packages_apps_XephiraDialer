package com.coui.appcompat.calendar;

import X8.c;
import a9.d;
import a9.f;
import a9.h;
import a9.m;
import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.media.AudioAttributes;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.PathInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.calendar.COUICalendarDayPickerView;
import com.coui.appcompat.calendar.COUICalendarPicker;
import com.coui.appcompat.calendar.COUICalendarYearView;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.rotateview.COUIRotateView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUICalendarPickerDelegate extends COUICalendarPicker.AbstractDatePickerDelegate {
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_YEAR = 1900;
    private static final long DURATION_OF_DISMISS_ANIMATOR = 150;
    private static final long DURATION_OF_SHOW_ANIMATOR = 280;
    private static final int PICKER_FADE_IN_DELAY = 120;
    private static final int USE_LOCALE = 0;
    private static final int VIEW_MONTH_DAY = 0;
    private static final int VIEW_YEAR = 1;
    private ViewAnimator mAnimator;
    private ViewGroup mContainer;
    private int mCurrentView;
    private COUICalendarDayPickerView mDayPickerView;
    private ValueAnimator mDisMissAnimator;
    private COUIRotateView mExpandButton;
    private int mFirstDayOfWeek;
    private final SimpleDateFormat mFormatter;
    private LinearLayout mHeaderMonthLayout;
    private TextView mHeaderMonthView;
    private final Calendar mMaxDate;
    private final Calendar mMinDate;
    private ImageButton mNextButton;
    private final COUICalendarDayPickerView.OnDaySelectedListener mOnDaySelectedListener;
    private final View.OnClickListener mOnHeaderClickListener;
    private final COUICalendarYearView.OnYearSelectedListener mOnYearSelectedListener;
    private ImageButton mPrevButton;
    private ValueAnimator mShowAnimator;
    private final Calendar mTempDate;
    private COUICalendarYearView mYearPickerView;
    private static final int[] ATTRS_TEXT_COLOR = {R.attr.textColor};
    private static final PathInterpolator SHOW_ANIMATOR_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final PathInterpolator DISMISS_ANIMATOR_INTERPOLATOR = new COUIEaseInterpolator();
    private static final AudioAttributes VIBRATION_ATTRIBUTES = new AudioAttributes.Builder().setContentType(4).setUsage(13).build();

    public COUICalendarPickerDelegate(COUICalendarPicker cOUICalendarPicker, Context context, AttributeSet attributeSet, int i10, int i11) {
        super(cOUICalendarPicker, context);
        this.mCurrentView = 0;
        this.mFirstDayOfWeek = 0;
        COUICalendarDayPickerView.OnDaySelectedListener onDaySelectedListener = new COUICalendarDayPickerView.OnDaySelectedListener() { // from class: com.coui.appcompat.calendar.COUICalendarPickerDelegate.5
            @Override // com.coui.appcompat.calendar.COUICalendarDayPickerView.OnDaySelectedListener
            public void onDaySelected(COUICalendarDayPickerView cOUICalendarDayPickerView, Calendar calendar) {
                COUICalendarPickerDelegate.this.mCurrentDate.setTimeInMillis(calendar.getTimeInMillis());
                COUICalendarPickerDelegate.this.onDateChanged(true, true);
            }
        };
        this.mOnDaySelectedListener = onDaySelectedListener;
        COUICalendarYearView.OnYearSelectedListener onYearSelectedListener = new COUICalendarYearView.OnYearSelectedListener() { // from class: com.coui.appcompat.calendar.COUICalendarPickerDelegate.6
            @Override // com.coui.appcompat.calendar.COUICalendarYearView.OnYearSelectedListener
            public void onYearChanged(COUICalendarYearView cOUICalendarYearView, int i12, int i13, int i14) {
                COUICalendarPickerDelegate.this.mCurrentDate.set(1, i12);
                COUICalendarPickerDelegate.this.mCurrentDate.set(2, i13);
                COUICalendarPickerDelegate.this.mCurrentDate.set(5, i14);
                COUICalendarPickerDelegate cOUICalendarPickerDelegate = COUICalendarPickerDelegate.this;
                COUICalendarPicker.OnDateChangedListener onDateChangedListener = cOUICalendarPickerDelegate.mOnDateChangedListener;
                if (onDateChangedListener != null) {
                    onDateChangedListener.onDateChanged(cOUICalendarPickerDelegate.mDelegator, i12, i13, i14);
                }
                COUICalendarPickerDelegate cOUICalendarPickerDelegate2 = COUICalendarPickerDelegate.this;
                COUICalendarPicker.OnDateChangedListener onDateChangedListener2 = cOUICalendarPickerDelegate2.mAutoFillChangeListener;
                if (onDateChangedListener2 != null) {
                    onDateChangedListener2.onDateChanged(cOUICalendarPickerDelegate2.mDelegator, i12, i13, i14);
                }
                COUICalendarPickerDelegate.this.mHeaderMonthView.setText(COUICalendarPickerDelegate.this.mFormatter.format(COUICalendarPickerDelegate.this.mCurrentDate.getTime()));
            }
        };
        this.mOnYearSelectedListener = onYearSelectedListener;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.coui.appcompat.calendar.COUICalendarPickerDelegate.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUICalendarPickerDelegate.this.mCurrentView == 0) {
                    COUICalendarPickerDelegate.this.setCurrentView(1, false);
                } else if (COUICalendarPickerDelegate.this.mCurrentView == 1) {
                    COUICalendarPickerDelegate.this.setCurrentView(0, false);
                } else {
                    COUICalendarPickerDelegate.this.setCurrentView(1, false);
                }
            }
        };
        this.mOnHeaderClickListener = onClickListener;
        Locale locale = this.mCurrentLocale;
        this.mCurrentDate = Calendar.getInstance(locale);
        this.mTempDate = Calendar.getInstance(locale);
        Calendar calendar = Calendar.getInstance(locale);
        this.mMinDate = calendar;
        Calendar calendar2 = Calendar.getInstance(locale);
        this.mMaxDate = calendar2;
        calendar.set(1900, 0, 1);
        calendar2.set(2100, 11, 31);
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, m.f6825a, i10, i11);
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(h.f6659b, (ViewGroup) this.mDelegator, false);
        this.mContainer = viewGroup;
        viewGroup.setSaveFromParentEnabled(false);
        this.mDelegator.addView(this.mContainer);
        ViewGroup viewGroup2 = (ViewGroup) this.mContainer.findViewById(f.f6648r);
        this.mExpandButton = (COUIRotateView) viewGroup2.findViewById(f.f6655y);
        this.mPrevButton = (ImageButton) viewGroup2.findViewById(f.f6621K);
        this.mNextButton = (ImageButton) viewGroup2.findViewById(f.f6619I);
        this.mHeaderMonthView = (TextView) viewGroup2.findViewById(f.f6649s);
        this.mHeaderMonthView.setTextSize(0, (int) COUIChangeTextUtil.getG3FontSize(context.getResources().getDimensionPixelSize(d.f6576l), context.getResources().getConfiguration().fontScale));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat.getBestDateTimePattern(context.getResources().getConfiguration().locale, "MMMMy"), context.getResources().getConfiguration().locale);
        this.mFormatter = simpleDateFormat;
        this.mHeaderMonthView.setText(simpleDateFormat.format(this.mCurrentDate.getTime()));
        LinearLayout linearLayout = (LinearLayout) viewGroup2.findViewById(f.f6650t);
        this.mHeaderMonthLayout = linearLayout;
        linearLayout.setOnClickListener(onClickListener);
        this.mExpandButton.setOnClickListener(onClickListener);
        int resourceId = obtainStyledAttributes.getResourceId(m.f6835c, 0);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = this.mContext.obtainStyledAttributes(null, ATTRS_TEXT_COLOR, 0, resourceId);
            obtainStyledAttributes2.getColorStateList(0);
            obtainStyledAttributes2.recycle();
        }
        obtainStyledAttributes.recycle();
        ViewAnimator viewAnimator = (ViewAnimator) this.mContainer.findViewById(f.f6633c);
        this.mAnimator = viewAnimator;
        COUICalendarDayPickerView cOUICalendarDayPickerView = (COUICalendarDayPickerView) viewAnimator.findViewById(f.f6647q);
        this.mDayPickerView = cOUICalendarDayPickerView;
        cOUICalendarDayPickerView.setFirstDayOfWeek(this.mFirstDayOfWeek);
        this.mDayPickerView.setMinDate(calendar.getTimeInMillis());
        this.mDayPickerView.setMaxDate(calendar2.getTimeInMillis());
        this.mDayPickerView.setDate(this.mCurrentDate.getTimeInMillis());
        this.mDayPickerView.setOnDaySelectedListener(onDaySelectedListener);
        this.mDayPickerView.setMonthView(this.mHeaderMonthView);
        this.mDayPickerView.setPrevButton(this.mPrevButton);
        this.mDayPickerView.setNextButton(this.mNextButton);
        COUICalendarYearView cOUICalendarYearView = (COUICalendarYearView) this.mAnimator.findViewById(f.f6651u);
        this.mYearPickerView = cOUICalendarYearView;
        cOUICalendarYearView.setRange(calendar, calendar2);
        this.mYearPickerView.setDate(this.mCurrentDate);
        this.mYearPickerView.setOnYearSelectedListener(onYearSelectedListener);
        configAnimator();
        onLocaleChanged(this.mCurrentLocale);
    }

    private void configAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mShowAnimator = valueAnimator;
        valueAnimator.setFloatValues(0.0f, 1.0f);
        this.mShowAnimator.setDuration(DURATION_OF_SHOW_ANIMATOR);
        this.mShowAnimator.setInterpolator(SHOW_ANIMATOR_INTERPOLATOR);
        this.mShowAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.calendar.COUICalendarPickerDelegate.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                int i10;
                ImageButton imageButton = COUICalendarPickerDelegate.this.mPrevButton;
                int i11 = 8;
                if (COUICalendarPickerDelegate.this.mDayPickerView.hasPre()) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                imageButton.setVisibility(i10);
                ImageButton imageButton2 = COUICalendarPickerDelegate.this.mNextButton;
                if (COUICalendarPickerDelegate.this.mDayPickerView.hasNext()) {
                    i11 = 0;
                }
                imageButton2.setVisibility(i11);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mShowAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.calendar.COUICalendarPickerDelegate.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float animatedFraction = valueAnimator2.getAnimatedFraction();
                COUICalendarPickerDelegate.this.mPrevButton.setAlpha(animatedFraction);
                COUICalendarPickerDelegate.this.mNextButton.setAlpha(animatedFraction);
            }
        });
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.mDisMissAnimator = valueAnimator2;
        valueAnimator2.setFloatValues(0.0f, 1.0f);
        this.mDisMissAnimator.setDuration(150L);
        this.mDisMissAnimator.setInterpolator(DISMISS_ANIMATOR_INTERPOLATOR);
        this.mDisMissAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.calendar.COUICalendarPickerDelegate.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUICalendarPickerDelegate.this.mPrevButton.setVisibility(8);
                COUICalendarPickerDelegate.this.mNextButton.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.mDisMissAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.calendar.COUICalendarPickerDelegate.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                float animatedFraction = 1.0f - valueAnimator3.getAnimatedFraction();
                COUICalendarPickerDelegate.this.mPrevButton.setAlpha(animatedFraction);
                COUICalendarPickerDelegate.this.mNextButton.setAlpha(animatedFraction);
            }
        });
    }

    public static int getDaysInMonth(int i10, int i11) {
        switch (i10) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                if (i11 % 4 == 0) {
                    return 29;
                }
                return 28;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid Month");
        }
    }

    private int multiplyAlphaComponent(int i10, float f10) {
        return (16777215 & i10) | (((int) ((((i10 >> 24) & 255) * f10) + 0.5f)) << 24);
    }

    private void onCurrentDateChanged(boolean z10) {
        if (z10) {
            this.mAnimator.announceForAccessibility(getFormattedCurrentDate());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDateChanged(boolean z10, boolean z11) {
        int i10 = this.mCurrentDate.get(1);
        if (z11 && (this.mOnDateChangedListener != null || this.mAutoFillChangeListener != null)) {
            int i11 = this.mCurrentDate.get(2);
            int i12 = this.mCurrentDate.get(5);
            COUICalendarPicker.OnDateChangedListener onDateChangedListener = this.mOnDateChangedListener;
            if (onDateChangedListener != null) {
                onDateChangedListener.onDateChanged(this.mDelegator, i10, i11, i12);
            }
            COUICalendarPicker.OnDateChangedListener onDateChangedListener2 = this.mAutoFillChangeListener;
            if (onDateChangedListener2 != null) {
                onDateChangedListener2.onDateChanged(this.mDelegator, i10, i11, i12);
            }
        }
        this.mDayPickerView.setDate(this.mCurrentDate.getTimeInMillis(), this.mIsCurrentItemAnimate);
        this.mYearPickerView.setDate(this.mCurrentDate);
        onCurrentDateChanged(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentView(int i10, boolean z10) {
        this.mHeaderMonthView.setText(this.mFormatter.format(this.mCurrentDate.getTime()));
        if (i10 != 0) {
            if (i10 == 1) {
                this.mYearPickerView.setDate(this.mCurrentDate);
                this.mYearPickerView.post(new Runnable() { // from class: com.coui.appcompat.calendar.COUICalendarPickerDelegate.8
                    @Override // java.lang.Runnable
                    public void run() {
                        COUICalendarPickerDelegate.this.mYearPickerView.requestFocus();
                        COUICalendarPickerDelegate.this.mYearPickerView.clearFocus();
                    }
                });
                if (this.mCurrentView != i10) {
                    this.mHeaderMonthView.setTextColor(COUIContextUtil.getAttrColor(this.mContext, c.f4347F));
                    if (z10) {
                        this.mAnimator.setDisplayedChild(1);
                        this.mPrevButton.setVisibility(8);
                        this.mNextButton.setVisibility(8);
                        this.mExpandButton.setExpanded(true);
                    } else {
                        this.mAnimator.postDelayed(new Runnable() { // from class: com.coui.appcompat.calendar.COUICalendarPickerDelegate.9
                            @Override // java.lang.Runnable
                            public void run() {
                                COUICalendarPickerDelegate.this.mAnimator.setDisplayedChild(1);
                            }
                        }, 120L);
                        this.mShowAnimator.cancel();
                        this.mDisMissAnimator.start();
                        this.mExpandButton.startExpandAnimation();
                    }
                    this.mCurrentView = i10;
                    return;
                }
                return;
            }
            return;
        }
        onDateChanged(true, true);
        this.mDayPickerView.setDate(this.mCurrentDate.getTimeInMillis());
        if (this.mCurrentView != i10) {
            this.mHeaderMonthView.setTextColor(COUIContextUtil.getAttrColor(this.mContext, c.f4348G));
            this.mAnimator.setDisplayedChild(0);
            this.mExpandButton.startCollapseAnimation();
            this.mCurrentView = i10;
            this.mDisMissAnimator.cancel();
            this.mShowAnimator.setCurrentFraction(this.mPrevButton.getAlpha());
            this.mShowAnimator.start();
        }
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public CharSequence getAccessibilityClassName() {
        return COUICalendarPicker.class.getName();
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.AbstractDatePickerDelegate, com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public /* bridge */ /* synthetic */ long getDate() {
        return super.getDate();
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public int getDayOfMonth() {
        return this.mCurrentDate.get(5);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public int getFirstDayOfWeek() {
        int i10 = this.mFirstDayOfWeek;
        if (i10 != 0) {
            return i10;
        }
        return this.mCurrentDate.getFirstDayOfWeek();
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public Calendar getMaxDate() {
        return this.mMaxDate;
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public Calendar getMinDate() {
        return this.mMinDate;
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public int getMonth() {
        return this.mCurrentDate.get(2);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public int getYear() {
        return this.mCurrentDate.get(1);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public void init(int i10, int i11, int i12, COUICalendarPicker.OnDateChangedListener onDateChangedListener) {
        this.mCurrentDate.set(1, i10);
        this.mCurrentDate.set(2, i11);
        this.mCurrentDate.set(5, i12);
        this.mHeaderMonthView.setText(this.mFormatter.format(this.mCurrentDate.getTime()));
        onDateChanged(false, false);
        this.mOnDateChangedListener = onDateChangedListener;
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public boolean isEnabled() {
        return this.mContainer.isEnabled();
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public boolean isYearPickerIsShow() {
        if (this.mCurrentView == 1) {
            return true;
        }
        return false;
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public void onConfigurationChanged(Configuration configuration) {
        setCurrentLocale(configuration.locale);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.AbstractDatePickerDelegate
    public void onLocaleChanged(Locale locale) {
        onCurrentDateChanged(false);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.AbstractDatePickerDelegate, com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public /* bridge */ /* synthetic */ void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof COUICalendarPicker.AbstractDatePickerDelegate.SavedState) {
            COUICalendarPicker.AbstractDatePickerDelegate.SavedState savedState = (COUICalendarPicker.AbstractDatePickerDelegate.SavedState) parcelable;
            this.mCurrentDate.set(savedState.getSelectedYear(), savedState.getSelectedMonth(), savedState.getSelectedDay());
            this.mMinDate.setTimeInMillis(savedState.getMinDate());
            this.mMaxDate.setTimeInMillis(savedState.getMaxDate());
            onCurrentDateChanged(false);
            int currentView = savedState.getCurrentView();
            setCurrentView(currentView, true);
            int listPosition = savedState.getListPosition();
            if (listPosition != Integer.MIN_VALUE && currentView == 0) {
                this.mDayPickerView.setPosition(listPosition);
                this.mHeaderMonthView.setText(this.mFormatter.format(Long.valueOf(savedState.getCurrentTimeMillis())));
            }
        }
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public Parcelable onSaveInstanceState(Parcelable parcelable) {
        int i10;
        int i11 = this.mCurrentDate.get(1);
        int i12 = this.mCurrentDate.get(2);
        int i13 = this.mCurrentDate.get(5);
        if (this.mCurrentView == 0) {
            i10 = this.mDayPickerView.getMostVisiblePosition();
        } else {
            i10 = Integer.MIN_VALUE;
        }
        return new COUICalendarPicker.AbstractDatePickerDelegate.SavedState(parcelable, i11, i12, i13, this.mMinDate.getTimeInMillis(), this.mMaxDate.getTimeInMillis(), this.mCurrentView, i10, Integer.MIN_VALUE, this.mDayPickerView.getCurrentTimeMillis());
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.AbstractDatePickerDelegate, com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public /* bridge */ /* synthetic */ void setAutoFillChangeListener(COUICalendarPicker.OnDateChangedListener onDateChangedListener) {
        super.setAutoFillChangeListener(onDateChangedListener);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.AbstractDatePickerDelegate, com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public /* bridge */ /* synthetic */ void setCurrentItemAnimate(boolean z10) {
        super.setCurrentItemAnimate(z10);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public void setCurrentYear() {
        this.mYearPickerView.setCurrentYear();
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public void setEnabled(boolean z10) {
        this.mContainer.setEnabled(z10);
        this.mDayPickerView.setEnabled(z10);
        this.mYearPickerView.setEnabled(z10);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public void setFirstDayOfWeek(int i10) {
        this.mFirstDayOfWeek = i10;
        this.mDayPickerView.setFirstDayOfWeek(i10);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public void setMaxDate(long j10) {
        this.mTempDate.setTimeInMillis(j10);
        if (this.mTempDate.get(1) == this.mMaxDate.get(1) && this.mTempDate.get(6) == this.mMaxDate.get(6)) {
            return;
        }
        if (this.mCurrentDate.after(this.mTempDate)) {
            this.mCurrentDate.setTimeInMillis(j10);
            onDateChanged(false, true);
        }
        this.mMaxDate.setTimeInMillis(j10);
        this.mDayPickerView.setMaxDate(j10);
        this.mYearPickerView.setRange(this.mMinDate, this.mMaxDate);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public void setMinDate(long j10) {
        this.mTempDate.setTimeInMillis(j10);
        if (this.mTempDate.get(1) == this.mMinDate.get(1) && this.mTempDate.get(6) == this.mMinDate.get(6)) {
            return;
        }
        if (this.mCurrentDate.before(this.mTempDate)) {
            this.mCurrentDate.setTimeInMillis(j10);
            onDateChanged(false, true);
        }
        this.mMinDate.setTimeInMillis(j10);
        this.mDayPickerView.setMinDate(j10);
        this.mYearPickerView.setRange(this.mMinDate, this.mMaxDate);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.AbstractDatePickerDelegate, com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public /* bridge */ /* synthetic */ void setOnDateChangedListener(COUICalendarPicker.OnDateChangedListener onDateChangedListener) {
        super.setOnDateChangedListener(onDateChangedListener);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.AbstractDatePickerDelegate, com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public /* bridge */ /* synthetic */ void setValidationCallback(COUICalendarPicker.ValidationCallback validationCallback) {
        super.setValidationCallback(validationCallback);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.AbstractDatePickerDelegate, com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public /* bridge */ /* synthetic */ void updateDate(long j10) {
        super.updateDate(j10);
    }

    @Override // com.coui.appcompat.calendar.COUICalendarPicker.COUIDatePickerDelegate
    public void updateDate(int i10, int i11, int i12) {
        this.mCurrentDate.set(1, i10);
        this.mCurrentDate.set(2, i11);
        this.mCurrentDate.set(5, i12);
        this.mHeaderMonthView.setText(this.mFormatter.format(this.mCurrentDate.getTime()));
        this.mDayPickerView.setClick(true);
        onDateChanged(false, true);
    }
}
