package com.coui.appcompat.preference;

import A.k;
import X8.c;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.PreferenceCategory;
import androidx.preference.s;
import b9.C0535e;
import b9.C0537g;
import b9.C0539i;
import b9.l;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.rippleutil.COUIRippleDrawableUtil;
import com.coui.appcompat.state.COUIMaskRippleDrawable;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;

/* loaded from: classes.dex */
public class COUIPreferenceCategory extends PreferenceCategory {
    public static final int MARGIN_TYPE_LARGE = 0;
    public static final int MARGIN_TYPE_SMALL = 1;
    public static final int MARGIN_TYPE_ZERO = 2;
    private static final String TAG = "COUIPreferenceCategory";
    private static final float TITLE_LARGE_TEXTSIZE = 16.0f;
    public static final int TITLE_MARGIN_START_TYPE_LARGE = 1;
    public static final int TITLE_MARGIN_START_TYPE_SMALL = 0;
    private static final float TITLE_MEDIUM_TEXTSIZE = 14.0f;
    private static final float TITLE_SMALL_TEXTSIZE = 12.0f;
    public static final int TITLE_TYPE_LARGE = 2;
    public static final int TITLE_TYPE_MEDIUM = 1;
    public static final int TITLE_TYPE_SMALL = 0;
    private Context mContext;
    private IGetWidgetLayoutListener mGetWidgetLayoutListener;
    private int mHorizontalMarginType;
    private int mIconInRight;
    private int mIconWithTitle;
    private View.OnClickListener mItemviewClickListener;
    private int mLayoutTitleMarginEndLarge;
    private int mLayoutTitleMarginStartLarge;
    private int mLayoutTitleMarginStartSmall;
    private ArrayMap<Integer, Integer> mMarginEndMap;
    private int mMarginTopType;
    private COUIMaskRippleDrawable mMaskRippleDrawable;
    private String mRightIconContentDescription;
    private String mTextInReddot;
    private String mTextInRight;
    private View.OnClickListener mTitleIconClickListener;
    private String mTitleIconContentDescription;
    private boolean mTitleOnly;
    private TextView mTitleTextView;
    private int mTitleType;
    private View mWidgetLayout;
    private View.OnClickListener mWidgetLayoutClickListener;
    private int mWidgetLayoutRes;

    /* loaded from: classes.dex */
    public interface IGetWidgetLayoutListener {
        void widgetInflated(View view);
    }

    public COUIPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHorizontalMarginType = 1;
        this.mTitleType = 0;
        this.mMarginTopType = 0;
        this.mTitleTextView = null;
        this.mTitleOnly = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12555F0, 0, 0);
        this.mTextInRight = obtainStyledAttributes.getString(l.f12569L0);
        this.mIconInRight = obtainStyledAttributes.getResourceId(l.f12558G0, 0);
        this.mIconWithTitle = obtainStyledAttributes.getResourceId(l.f12563I0, 0);
        this.mTextInReddot = obtainStyledAttributes.getString(l.f12567K0);
        this.mHorizontalMarginType = obtainStyledAttributes.getInteger(l.f12571M0, this.mHorizontalMarginType);
        this.mTitleType = obtainStyledAttributes.getInteger(l.f12573N0, this.mTitleType);
        this.mMarginTopType = obtainStyledAttributes.getInteger(l.f12575O0, this.mMarginTopType);
        this.mTitleIconContentDescription = obtainStyledAttributes.getString(l.f12565J0);
        this.mRightIconContentDescription = obtainStyledAttributes.getString(l.f12561H0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, s.f10676J, 0, 0);
        this.mWidgetLayoutRes = k.n(obtainStyledAttributes2, s.f10759t0, s.f10696T, 0);
        obtainStyledAttributes2.recycle();
        this.mLayoutTitleMarginStartLarge = context.getResources().getDimensionPixelSize(C0535e.f12436u0);
        this.mLayoutTitleMarginStartSmall = context.getResources().getDimensionPixelSize(C0535e.f12438v0);
        this.mLayoutTitleMarginEndLarge = context.getResources().getDimensionPixelSize(C0535e.f12432s0);
        ArrayMap<Integer, Integer> arrayMap = new ArrayMap<>();
        this.mMarginEndMap = arrayMap;
        arrayMap.put(Integer.valueOf(C0539i.f12504f), 0);
        this.mMarginEndMap.put(Integer.valueOf(C0539i.f12505g), 0);
        this.mMarginEndMap.put(Integer.valueOf(C0539i.f12506h), Integer.valueOf(context.getResources().getDimensionPixelSize(C0535e.f12433t)));
        this.mMarginEndMap.put(Integer.valueOf(C0539i.f12507i), Integer.valueOf(context.getResources().getDimensionPixelSize(C0535e.f12368A)));
        this.mMarginEndMap.put(Integer.valueOf(C0539i.f12508j), 0);
        ensureMaskRippleDrawable();
    }

    private void ensureMaskRippleDrawable() {
        if (this.mMaskRippleDrawable == null) {
            COUIMaskRippleDrawable cOUIMaskRippleDrawable = new COUIMaskRippleDrawable(getContext());
            this.mMaskRippleDrawable = cOUIMaskRippleDrawable;
            cOUIMaskRippleDrawable.setCircleRippleMask(getContext().getResources().getDimensionPixelSize(C0535e.f12375G));
        }
    }

    private void initEndRect(androidx.preference.l lVar) {
        TextView textView;
        TextView textView2;
        int i10;
        int i11;
        View e10 = lVar.e(R.id.widget_frame);
        if (this.mWidgetLayoutRes != 0) {
            if (!(e10 instanceof LinearLayout)) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) e10;
            if (linearLayout != null && linearLayout.getChildCount() > 0) {
                linearLayout.removeAllViews();
            }
            View inflate = LayoutInflater.from(this.mContext).inflate(this.mWidgetLayoutRes, (ViewGroup) linearLayout, false);
            this.mWidgetLayout = inflate;
            if (inflate == null) {
                Log.e(TAG, "inflate mWidgetLayoutRes failed");
                return;
            }
            this.mTitleOnly = false;
            if (inflate.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWidgetLayout.getLayoutParams();
                if (this.mHorizontalMarginType == 0) {
                    if (marginLayoutParams.getMarginEnd() != this.mMarginEndMap.get(Integer.valueOf(this.mWidgetLayoutRes)).intValue()) {
                        marginLayoutParams.setMarginEnd(this.mMarginEndMap.get(Integer.valueOf(this.mWidgetLayoutRes)).intValue());
                        this.mWidgetLayout.setLayoutParams(marginLayoutParams);
                    }
                } else if (marginLayoutParams.getMarginEnd() != this.mMarginEndMap.get(Integer.valueOf(this.mWidgetLayoutRes)).intValue() + this.mLayoutTitleMarginEndLarge) {
                    marginLayoutParams.setMarginEnd(this.mMarginEndMap.get(Integer.valueOf(this.mWidgetLayoutRes)).intValue() + this.mLayoutTitleMarginEndLarge);
                    this.mWidgetLayout.setLayoutParams(marginLayoutParams);
                }
            }
            if (this.mGetWidgetLayoutListener != null) {
                this.mWidgetLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.coui.appcompat.preference.COUIPreferenceCategory.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        COUIPreferenceCategory.this.mWidgetLayout.post(new Runnable() { // from class: com.coui.appcompat.preference.COUIPreferenceCategory.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                COUIPreferenceCategory.this.mGetWidgetLayoutListener.widgetInflated(COUIPreferenceCategory.this.mWidgetLayout);
                            }
                        });
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        view.removeOnAttachStateChangeListener(this);
                    }
                });
            }
            if (!(this.mWidgetLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mWidgetLayout.getLayoutParams();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(marginLayoutParams2.width, marginLayoutParams2.height);
            layoutParams.gravity = 16;
            layoutParams.setMarginStart(marginLayoutParams2.getMarginStart());
            layoutParams.topMargin = marginLayoutParams2.topMargin;
            layoutParams.setMarginEnd(marginLayoutParams2.getMarginEnd());
            layoutParams.bottomMargin = marginLayoutParams2.bottomMargin;
            linearLayout.addView(this.mWidgetLayout, layoutParams);
            linearLayout.setVisibility(0);
            if (this.mWidgetLayoutClickListener != null) {
                if (this.mWidgetLayoutRes == C0539i.f12506h) {
                    ensureMaskRippleDrawable();
                    linearLayout.getChildAt(0).setBackground(this.mMaskRippleDrawable);
                } else {
                    COUITextViewCompatUtil.setPressRippleDrawable(this.mWidgetLayout, false);
                }
                this.mWidgetLayout.setOnClickListener(this.mWidgetLayoutClickListener);
            } else {
                View.OnClickListener onClickListener = this.mItemviewClickListener;
                if (onClickListener != null) {
                    lVar.itemView.setOnClickListener(onClickListener);
                    COUIRippleDrawableUtil.setPressRippleDrawable(lVar.itemView, 0, false);
                }
            }
            int i12 = this.mWidgetLayoutRes;
            if (i12 == C0539i.f12508j) {
                textView2 = (TextView) linearLayout.findViewById(C0537g.f12463L);
                if (textView2 != null && !TextUtils.isEmpty(this.mTextInRight)) {
                    textView2.setText(this.mTextInRight);
                    textView2.setVisibility(0);
                }
                if (this.mWidgetLayoutClickListener != null && !rightTextfixSecondaryColor()) {
                    textView2.setTextColor(COUIContextUtil.getAttrColor(getContext(), c.f4348G, 0));
                } else {
                    textView2.setTextColor(COUIContextUtil.getAttrColor(getContext(), c.f4351J, 0));
                }
                ImageView imageView = (ImageView) linearLayout.findViewById(C0537g.f12494w);
                if (imageView != null && (i11 = this.mIconInRight) != 0) {
                    imageView.setImageResource(i11);
                    imageView.setVisibility(0);
                }
            } else if (i12 == C0539i.f12507i) {
                textView2 = (TextView) linearLayout.findViewById(C0537g.f12462K);
                if (textView2 != null && !TextUtils.isEmpty(this.mTextInRight)) {
                    textView2.setText(this.mTextInRight);
                    textView2.setVisibility(0);
                    COUITextViewCompatUtil.setPressRippleDrawable(textView2);
                }
            } else {
                if (i12 == C0539i.f12506h) {
                    ImageView imageView2 = (ImageView) linearLayout.findViewById(C0537g.f12458G);
                    if (imageView2 != null && (i10 = this.mIconInRight) != 0) {
                        imageView2.setImageResource(i10);
                        imageView2.setVisibility(0);
                        if (!TextUtils.isEmpty(this.mRightIconContentDescription)) {
                            imageView2.setContentDescription(this.mRightIconContentDescription);
                        }
                    }
                } else if (i12 == C0539i.f12505g) {
                    textView2 = (TextView) this.mWidgetLayout.findViewById(C0537g.f12464M);
                }
                textView2 = null;
            }
            if (textView2 != null) {
                if (this.mTitleType == 0) {
                    textView2.setTextSize(2, 12.0f);
                } else {
                    textView2.setTextSize(2, 14.0f);
                    linearLayout.getChildAt(0).setMinimumHeight(getContext().getResources().getDimensionPixelSize(C0535e.f12374F));
                }
            }
        } else if (e10 != null) {
            e10.setVisibility(8);
        }
        if (this.mTitleOnly && (textView = this.mTitleTextView) != null && (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.mTitleTextView.getLayoutParams();
            marginLayoutParams3.setMarginEnd(marginLayoutParams3.getMarginStart());
            this.mTitleTextView.setLayoutParams(marginLayoutParams3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initStartRect(androidx.preference.l r10) {
        /*
            Method dump skipped, instructions count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.preference.COUIPreferenceCategory.initStartRect(androidx.preference.l):void");
    }

    public void getWidgetLayout(IGetWidgetLayoutListener iGetWidgetLayoutListener) {
        View view = this.mWidgetLayout;
        if (view != null) {
            iGetWidgetLayoutListener.widgetInflated(view);
        } else {
            this.mGetWidgetLayoutListener = iGetWidgetLayoutListener;
        }
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.l lVar) {
        super.onBindViewHolder(lVar);
        initStartRect(lVar);
        initEndRect(lVar);
    }

    public boolean rightTextfixSecondaryColor() {
        return false;
    }

    public void setHorizontalMarginType(int i10) {
        if (this.mHorizontalMarginType != i10) {
            this.mHorizontalMarginType = i10;
            notifyChanged();
        }
    }

    public void setIconInRight(int i10) {
        if (this.mIconInRight != i10) {
            this.mIconInRight = i10;
            notifyChanged();
        }
    }

    public void setIconWithTitle(int i10) {
        this.mIconWithTitle = i10;
    }

    public void setItemViewLayoutClickListener(View.OnClickListener onClickListener) {
        this.mItemviewClickListener = onClickListener;
    }

    public void setMarginTopType(int i10) {
        if (this.mMarginTopType != i10) {
            this.mMarginTopType = i10;
            notifyChanged();
        }
    }

    public void setRightIconContentDescription(String str) {
        this.mRightIconContentDescription = str;
        notifyChanged();
    }

    public void setTextInReddot(String str) {
        this.mTextInReddot = str;
    }

    public void setTextInRight(String str) {
        if (!TextUtils.equals(str, this.mTextInRight)) {
            this.mTextInRight = str;
            notifyChanged();
        }
    }

    public void setTitleIconClickListener(View.OnClickListener onClickListener) {
        this.mTitleIconClickListener = onClickListener;
    }

    public void setTitleIconContentDescription(String str) {
        this.mTitleIconContentDescription = str;
        notifyChanged();
    }

    public void setTitleType(int i10) {
        if (this.mTitleType != i10) {
            this.mTitleType = i10;
            notifyChanged();
        }
    }

    public void setWidgetLayoutClickListener(View.OnClickListener onClickListener) {
        this.mWidgetLayoutClickListener = onClickListener;
    }

    public void setWidgetLayoutRes(int i10) {
        this.mWidgetLayoutRes = i10;
    }

    public View getWidgetLayout() {
        return this.mWidgetLayout;
    }
}
