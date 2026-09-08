package com.android.incallui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.internal_dependency.SettingsUtils;
import com.oapm.perftest.PerfTest;
import java.util.Map;

/* loaded from: classes.dex */
public class OplusNumberMarkView extends RelativeLayout implements View.OnClickListener {
    private static final int INCOMING_CALL_TYPE = 11;
    private static final String IS_FIRST_IN_DATA = "is_first_in_data";
    private static final String LOG_TAG = "OplusNumberMarkView";
    private static final String NEED_SHOW_CHECKBOX = "needShowCheckbox";
    private static final String SUSPICIOUS_NUMBER_CONFIRMED_SWITCH = "suspicious_number_confirmed_switch";
    private static final int VIEW_DISMISS = 2;
    private static final int VIEW_SHOW = 1;
    private Button mAddToBlacklistButton;
    private boolean mClickButtonListener;
    private Context mContext;
    private boolean mIsVisible;
    private int mLastY;
    private AnimationListener mListener;
    private Button mMarkButton;
    private CheckBox mNumberMarkCheckBox;
    private LinearLayout mNumberMarkNeverShowLine;
    private RelativeLayout mRelativeLayout;
    private Button mSaveNumberButton;
    private final androidx.lifecycle.w<Integer> mStatusObserver;
    private int mUpY;
    private View mWindowView;

    /* loaded from: classes.dex */
    public interface AnimationListener {
        void onExitAnimationEnd(boolean z10);
    }

    public OplusNumberMarkView(Context context, AnimationListener animationListener) {
        super(context);
        this.mClickButtonListener = false;
        this.mIsVisible = false;
        this.mStatusObserver = new androidx.lifecycle.w<Integer>() { // from class: com.android.incallui.OplusNumberMarkView.1
            @Override // androidx.lifecycle.w
            public void onChanged(Integer num) {
                Log.d(OplusNumberMarkView.LOG_TAG, "onChanged...status = " + num);
                if (ResponsiveConfigRepository.f18540a.E1()) {
                    return;
                }
                OplusNumberMarkView.this.setNumberMarkViewVis(false);
            }
        };
        this.mContext = context;
        this.mListener = animationListener;
        initView();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if ((keyEvent.getKeyCode() == 4 || keyEvent.getKeyCode() == 176) && keyEvent.getAction() == 1) {
            setNumberMarkViewVis(false);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void initView() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "initView...");
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.oplus_number_mark_view, (ViewGroup) null);
        this.mWindowView = inflate;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.oplus_number_mark_layout);
        this.mRelativeLayout = relativeLayout;
        Drawable background = relativeLayout.getBackground();
        if (background != null) {
            background.setFilterBitmap(true);
        }
        Button button = (Button) this.mWindowView.findViewById(R.id.saveNumberButton);
        this.mSaveNumberButton = button;
        button.setOnClickListener(this);
        OplusPhoneUtils.setFontSize(this.mContext, this.mSaveNumberButton, 3);
        Button button2 = (Button) this.mWindowView.findViewById(R.id.addToBlacklistButton);
        this.mAddToBlacklistButton = button2;
        button2.setOnClickListener(this);
        OplusPhoneUtils.setFontSize(this.mContext, this.mAddToBlacklistButton, 3);
        Button button3 = (Button) this.mWindowView.findViewById(R.id.markButton);
        this.mMarkButton = button3;
        button3.setOnClickListener(this);
        OplusPhoneUtils.setFontSize(this.mContext, this.mMarkButton, 3);
        OplusPhoneUtils.setFontSize(this.mContext, (TextView) this.mWindowView.findViewById(R.id.oplusNumberMarkTips), 3);
        OplusPhoneUtils.setFontSize(this.mContext, (TextView) this.mWindowView.findViewById(R.id.oplusNumberMarkNeverShow), 3);
        CheckBox checkBox = (CheckBox) this.mWindowView.findViewById(R.id.oplusNeverShowCheckbox);
        this.mNumberMarkCheckBox = checkBox;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.android.incallui.OplusNumberMarkView.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                SettingsUtils.INSTANCE.putSystemSettingsInt(OplusNumberMarkView.this.mContext.getContentResolver(), OplusNumberMarkView.SUSPICIOUS_NUMBER_CONFIRMED_SWITCH, !z10 ? 1 : 0);
            }
        });
        this.mNumberMarkNeverShowLine = (LinearLayout) this.mWindowView.findViewById(R.id.oplus_number_mark_never_show_line);
        if (this.mContext.getSharedPreferences(IS_FIRST_IN_DATA, 0).getBoolean(NEED_SHOW_CHECKBOX, false)) {
            this.mNumberMarkNeverShowLine.setVisibility(0);
        }
        this.mRelativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.incallui.OplusNumberMarkView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int rawY = (int) motionEvent.getRawY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    OplusNumberMarkView.this.mLastY = rawY;
                    OplusNumberMarkView.this.mUpY = rawY;
                } else if (action != 1) {
                    if (action == 2 && rawY - OplusNumberMarkView.this.mUpY > 0) {
                        OplusNumberMarkView oplusNumberMarkView = OplusNumberMarkView.this;
                        oplusNumberMarkView.layout(oplusNumberMarkView.getLeft(), (OplusNumberMarkView.this.getTop() + rawY) - OplusNumberMarkView.this.mLastY, OplusNumberMarkView.this.getRight(), (OplusNumberMarkView.this.getBottom() + rawY) - OplusNumberMarkView.this.mLastY);
                        OplusNumberMarkView.this.mLastY = rawY;
                    }
                } else {
                    int i10 = rawY - OplusNumberMarkView.this.mUpY;
                    if (OplusNumberMarkView.this.mContext.getResources().getDimensionPixelSize(R.dimen.oplus_number_mark_slide_dismiss_down) < i10) {
                        OplusNumberMarkView.this.setNumberMarkViewVis(false);
                    } else if (i10 > 0) {
                        OplusNumberMarkView oplusNumberMarkView2 = OplusNumberMarkView.this;
                        oplusNumberMarkView2.layout(oplusNumberMarkView2.getLeft(), OplusNumberMarkView.this.getTop() - i10, OplusNumberMarkView.this.getRight(), OplusNumberMarkView.this.getBottom() - i10);
                    }
                }
                return true;
            }
        });
        OplusPhoneUtils.setIsHangUpConfernceCall(false);
        addView(this.mWindowView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ResponsiveConfigRepository.f18540a.h1().j(this.mStatusObserver);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onClick id " + id + ", phone number = " + D2.g.l(OplusPhoneUtils.getMarkNumber()));
        }
        setNumberMarkViewVis(false);
        this.mClickButtonListener = true;
        OplusNumberMarkUtils oplusNumberMarkUtils = new OplusNumberMarkUtils(this.mContext);
        if (id == R.id.saveNumberButton) {
            oplusNumberMarkUtils.showAddToContactDialog(OplusPhoneUtils.getMarkNumber());
            return;
        }
        if (id == R.id.addToBlacklistButton) {
            oplusNumberMarkUtils.showBlacklistDialog(OplusPhoneUtils.getMarkNumber());
            return;
        }
        if (id == R.id.markButton) {
            if (OplusPhoneUtils.isScreenLocked(this.mContext)) {
                OplusPhoneUtils.dismissKeyguard();
            }
            oplusNumberMarkUtils.startMarkNumber(OplusPhoneUtils.getMarkNumber(), 11);
            OplusPhoneUserActionStatistics.onCommon(getContext(), OplusPhoneUserActionStatistics.TAG_NUMBER_RECOGNITION, OplusPhoneUserActionStatistics.NUMBER_MARK_FRAGMENT_MARK, (Map) null);
            return;
        }
        if (Log.sDebug) {
            Log.e(LOG_TAG, "onClick: unexpected");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PerfTest.leakWatch(this);
        ResponsiveConfigRepository.f18540a.h1().n(this.mStatusObserver);
    }

    public void setNumberMarkViewVis(boolean z10) {
        if (this.mIsVisible == z10) {
            return;
        }
        this.mIsVisible = z10;
        if (z10) {
            this.mWindowView.setVisibility(0);
            this.mWindowView.measure(-1, -2);
            this.mRelativeLayout.startAnimation(com.android.incallui.anim.b.c().f(1));
        } else {
            Animation f10 = com.android.incallui.anim.b.c().f(2);
            f10.setAnimationListener(new Animation.AnimationListener() { // from class: com.android.incallui.OplusNumberMarkView.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (OplusNumberMarkView.this.mListener != null) {
                        OplusNumberMarkView.this.mListener.onExitAnimationEnd(OplusNumberMarkView.this.mClickButtonListener);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.mRelativeLayout.startAnimation(f10);
        }
    }
}
