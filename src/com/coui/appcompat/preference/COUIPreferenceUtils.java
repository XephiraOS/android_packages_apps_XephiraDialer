package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.l;
import b9.C0535e;
import b9.C0537g;
import com.coui.appcompat.imageview.COUIRoundImageView;

/* loaded from: classes.dex */
public class COUIPreferenceUtils {
    static final int DEFALUT_RADIUS = 14;
    static final int DELAY_TIME = 70;
    public static final int ICON_SIZE_DP_LARGE = 50;
    public static final int ICON_SIZE_DP_MEDIUM = 32;
    public static final int ICON_SIZE_DP_MEDIUM_LARGE = 36;
    public static final int ICON_SIZE_DP_SMALL = 24;

    public static void bindAssignmentView(l lVar, CharSequence charSequence, int i10) {
        TextView textView = (TextView) lVar.e(C0537g.f12474c);
        if (textView != null) {
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                if (i10 != 0) {
                    textView.setTextColor(i10);
                    return;
                }
                return;
            }
            textView.setVisibility(8);
        }
    }

    public static void bindView(l lVar, Drawable drawable, CharSequence charSequence, CharSequence charSequence2) {
        bindView(lVar, drawable, charSequence, charSequence2, 0);
    }

    public static void setIconStyle(l lVar, Context context, int i10, boolean z10, int i11, boolean z11) {
        View e10 = lVar.e(R.id.icon);
        if (e10 != null && (e10 instanceof COUIRoundImageView)) {
            if (z11) {
                COUIRoundImageView cOUIRoundImageView = (COUIRoundImageView) e10;
                cOUIRoundImageView.setHasBorder(z10);
                cOUIRoundImageView.setBorderRectRadius(0);
                cOUIRoundImageView.setType(i11);
                return;
            }
            COUIRoundImageView cOUIRoundImageView2 = (COUIRoundImageView) e10;
            Drawable drawable = cOUIRoundImageView2.getDrawable();
            if (drawable != null && i10 == 14) {
                i10 = drawable.getIntrinsicHeight() / 6;
                Resources resources = context.getResources();
                int i12 = C0535e.f12373E;
                if (i10 < resources.getDimensionPixelOffset(i12)) {
                    i10 = context.getResources().getDimensionPixelOffset(i12);
                } else {
                    Resources resources2 = context.getResources();
                    int i13 = C0535e.f12372D;
                    if (i10 > resources2.getDimensionPixelOffset(i13)) {
                        i10 = context.getResources().getDimensionPixelOffset(i13);
                    }
                }
            }
            cOUIRoundImageView2.setHasBorder(z10);
            cOUIRoundImageView2.setBorderRectRadius(i10);
            cOUIRoundImageView2.setType(i11);
        }
    }

    public static void setSummaryView(Context context, l lVar) {
        final TextView textView = (TextView) lVar.e(R.id.summary);
        if (textView != null) {
            textView.setHighlightColor(context.getResources().getColor(R.color.transparent));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUIPreferenceUtils.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z10;
                    int actionMasked = motionEvent.getActionMasked();
                    int selectionStart = textView.getSelectionStart();
                    int selectionEnd = textView.getSelectionEnd();
                    int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    if (selectionStart != selectionEnd && offsetForPosition > selectionStart && offsetForPosition < selectionEnd) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (actionMasked != 0) {
                        if (actionMasked == 1 || actionMasked == 3) {
                            textView.setPressed(false);
                            textView.postInvalidateDelayed(70L);
                        }
                    } else {
                        if (z10) {
                            return false;
                        }
                        textView.setPressed(true);
                        textView.invalidate();
                    }
                    return false;
                }
            });
        }
    }

    public static void setSummaryViewColor(l lVar, ColorStateList colorStateList) {
        TextView textView = (TextView) lVar.e(R.id.summary);
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static void setTitleViewColor(Context context, l lVar, ColorStateList colorStateList) {
        View e10 = lVar.e(R.id.title);
        if (e10 != null && colorStateList != null) {
            ((TextView) e10).setTextColor(colorStateList);
        }
    }

    public static void bindView(l lVar, Drawable drawable, CharSequence charSequence, CharSequence charSequence2, int i10) {
        ImageView imageView = (ImageView) lVar.e(C0537g.f12487p);
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View e10 = lVar.e(R.id.icon);
        View e11 = lVar.e(C0537g.f12496y);
        if (e11 != null) {
            if (e10 != null) {
                e11.setVisibility(e10.getVisibility());
            } else {
                e11.setVisibility(8);
            }
        }
        TextView textView = (TextView) lVar.e(C0537g.f12488q);
        if (textView != null) {
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        bindAssignmentView(lVar, charSequence2, i10);
    }
}
