package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import b9.C0535e;
import b9.C0537g;
import b9.l;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUICustomListSelectedLinearLayout extends COUICardListSelectedItemLayout {
    private boolean mIconMarginDependOnImageView;
    private boolean mWithDividerItem;

    public COUICustomListSelectedLinearLayout(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12545C);
        this.mWithDividerItem = obtainStyledAttributes.getBoolean(l.f12548D, false);
        obtainStyledAttributes.recycle();
    }

    private boolean operateMultilineIconPosition() {
        AppCompatImageView appCompatImageView;
        boolean z10;
        int i10;
        int i11;
        int i12;
        int px2dip;
        View findViewById = findViewById(C0537g.f12496y);
        int i13 = 0;
        if (findViewById == null || findViewById.getVisibility() != 0 || (appCompatImageView = (AppCompatImageView) findViewById(R.id.icon)) == null) {
            return false;
        }
        if (findViewById(C0537g.f12455D) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        TextView textView = (TextView) findViewById(R.id.title);
        TextView textView2 = (TextView) findViewById(R.id.summary);
        if (textView != null && textView.getVisibility() == 0) {
            i10 = textView.getLineCount();
        } else {
            i10 = 0;
        }
        if (textView2 != null && textView2.getVisibility() == 0) {
            i11 = textView2.getLineCount();
        } else {
            i11 = 0;
        }
        TextView textView3 = (TextView) findViewById(C0537g.f12474c);
        if (!z10 && textView3 != null && textView3.getVisibility() == 0) {
            i12 = textView3.getLineCount();
        } else {
            i12 = 0;
        }
        if (this.mIconMarginDependOnImageView) {
            px2dip = UIUtil.px2dip(getContext(), appCompatImageView.getMeasuredHeight());
        } else {
            Context context = getContext();
            if (appCompatImageView.getDrawable() != null) {
                i13 = appCompatImageView.getDrawable().getIntrinsicHeight();
            }
            px2dip = UIUtil.px2dip(context, i13);
        }
        int i14 = i10 + i11 + i12;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (i14 > 2) {
            layoutParams.gravity = 48;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C0535e.f12371C);
            if (px2dip != 24) {
                if (px2dip != 32) {
                    if (px2dip != 36) {
                        if (px2dip == 50) {
                            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C0535e.f12425p);
                        }
                    } else {
                        dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C0535e.f12421n);
                    }
                } else {
                    dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C0535e.f12417l);
                }
            } else {
                dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C0535e.f12413j);
            }
            if (layoutParams.topMargin != dimensionPixelSize) {
                layoutParams.topMargin = dimensionPixelSize;
            }
        } else {
            layoutParams.gravity = 16;
            int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C0535e.f12371C);
            if (px2dip != 24) {
                if (px2dip != 32) {
                    if (px2dip != 36) {
                        if (px2dip == 50) {
                            dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C0535e.f12427q);
                        }
                    } else if (i14 <= 1) {
                        dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C0535e.f12423o);
                    } else {
                        dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C0535e.f12421n);
                    }
                } else if (i14 <= 1) {
                    dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C0535e.f12419m);
                } else {
                    dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C0535e.f12417l);
                }
            } else if (i14 <= 1) {
                dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C0535e.f12415k);
            } else {
                dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C0535e.f12413j);
            }
            if (layoutParams.topMargin != dimensionPixelSize2 || layoutParams.bottomMargin != dimensionPixelSize2) {
                layoutParams.topMargin = dimensionPixelSize2;
                layoutParams.bottomMargin = dimensionPixelSize2;
            }
        }
        findViewById.setLayoutParams(layoutParams);
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (operateMultilineIconPosition()) {
            super.onMeasure(i10, i11);
        }
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mWithDividerItem) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIconMarginDependOnImageView(boolean z10) {
        this.mIconMarginDependOnImageView = z10;
    }

    public COUICustomListSelectedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWithDividerItem = false;
        init(context, attributeSet);
    }
}
