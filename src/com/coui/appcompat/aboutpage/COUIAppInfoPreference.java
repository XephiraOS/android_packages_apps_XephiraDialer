package com.coui.appcompat.aboutpage;

import A.h;
import X8.g;
import Z8.c;
import Z8.e;
import Z8.f;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.preference.l;
import androidx.preference.m;
import com.coui.appcompat.aboutpage.COUIAppInfoPreference;
import com.coui.appcompat.poplist.COUIPopupWindow;
import com.coui.appcompat.preference.COUIPreference;
import java.util.Locale;
import kotlin.jvm.internal.i;

/* compiled from: COUIAppInfoPreference.kt */
/* loaded from: classes.dex */
public final class COUIAppInfoPreference extends COUIPreference {
    private Drawable appIcon;
    private String appName;
    private String appVersion;
    private String copyFinishText;
    private String copyText;
    private COUIPopupWindow popupWindow;
    private Toast toast;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIAppInfoPreference(Context context) {
        this(context, null);
        i.f(context, "context");
    }

    private final void initPopupWindow(Rect rect) {
        final COUIPopupWindow cOUIPopupWindow = new COUIPopupWindow(getContext());
        cOUIPopupWindow.setContentView(LayoutInflater.from(getContext()).inflate(f.f6181q, (ViewGroup) null, false));
        Drawable f10 = h.f(getContext().getResources(), g.f4868u, null);
        if (f10 != null) {
            f10.getPadding(rect);
            cOUIPopupWindow.setBackgroundDrawable(f10);
        }
        final TextView textView = (TextView) cOUIPopupWindow.getContentView().findViewById(e.f6120g0);
        textView.setText(this.copyText);
        textView.setOnClickListener(new View.OnClickListener() { // from class: v3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIAppInfoPreference.initPopupWindow$lambda$11$lambda$10$lambda$9(textView, this, cOUIPopupWindow, view);
            }
        });
        cOUIPopupWindow.setDismissTouchOutside(true);
        this.popupWindow = cOUIPopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPopupWindow$lambda$11$lambda$10$lambda$9(TextView textView, COUIAppInfoPreference this$0, COUIPopupWindow this_apply$1, View view) {
        i.f(this$0, "this$0");
        i.f(this_apply$1, "$this_apply$1");
        Object systemService = textView.getContext().getSystemService("clipboard");
        i.d(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, this$0.appVersion));
        Toast toast = this$0.toast;
        if (toast != null) {
            toast.cancel();
        }
        String str = this$0.copyFinishText;
        if (str != null) {
            Toast makeText = Toast.makeText(textView.getContext().getApplicationContext(), str, 0);
            makeText.show();
            this$0.toast = makeText;
        }
        this_apply$1.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$5$lambda$4(COUIAppInfoPreference this$0, Rect drawableRect, TextView this_apply, View view) {
        i.f(this$0, "this$0");
        i.f(drawableRect, "$drawableRect");
        i.f(this_apply, "$this_apply");
        if (this$0.copyText == null) {
            return true;
        }
        if (this$0.popupWindow == null) {
            this$0.initPopupWindow(drawableRect);
        }
        this$0.showPopupWindow(drawableRect, this_apply);
        return true;
    }

    private final void showPopupWindow(Rect rect, View view) {
        TextView textView;
        Integer num;
        float f10;
        int i10;
        int i11;
        TextPaint paint;
        View contentView;
        COUIPopupWindow cOUIPopupWindow = this.popupWindow;
        Integer num2 = null;
        if (cOUIPopupWindow != null && (contentView = cOUIPopupWindow.getContentView()) != null) {
            textView = (TextView) contentView.findViewById(e.f6120g0);
        } else {
            textView = null;
        }
        if (textView != null) {
            num = Integer.valueOf(textView.getPaddingStart());
        } else {
            num = null;
        }
        if (textView != null) {
            num2 = Integer.valueOf(textView.getPaddingEnd());
        }
        if (textView != null && (paint = textView.getPaint()) != null) {
            f10 = paint.measureText(this.copyText);
        } else {
            f10 = 0.0f;
        }
        int i12 = rect.left + rect.right;
        int i13 = 0;
        if (num != null) {
            i10 = num.intValue();
        } else {
            i10 = 0;
        }
        int i14 = i12 + i10;
        if (num2 != null) {
            i13 = num2.intValue();
        }
        int measuredWidth = (((i14 + i13) + ((int) f10)) - view.getMeasuredWidth()) / 2;
        int measuredHeight = view.getMeasuredHeight() + getContext().getResources().getDimensionPixelOffset(c.f6050w) + getContext().getResources().getDimensionPixelOffset(c.f6052x) + rect.top;
        Locale locale = Locale.getDefault();
        i.e(locale, "getDefault()");
        if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
            i11 = (-view.getMeasuredWidth()) - measuredWidth;
        } else {
            i11 = -measuredWidth;
        }
        COUIPopupWindow cOUIPopupWindow2 = this.popupWindow;
        if (cOUIPopupWindow2 != null) {
            cOUIPopupWindow2.showAsDropDown(view, i11, -measuredHeight);
        }
    }

    public final Drawable getAppIcon() {
        return this.appIcon;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCopyFinishText() {
        return this.copyFinishText;
    }

    public final String getCopyText() {
        return this.copyText;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        ImageView imageView = (ImageView) holder.e(e.f6107a);
        if (imageView != null) {
            ViewParent parent = imageView.getParent();
            if (parent != null) {
                i.e(parent, "parent");
                imageView.setOnClickListener(null);
                imageView.setBackground(null);
            }
            imageView.setImageDrawable(this.appIcon);
            imageView.setContentDescription(this.appName);
        }
        TextView textView = (TextView) holder.e(e.f6109b);
        if (textView != null) {
            textView.setText(this.appName);
        }
        final TextView textView2 = (TextView) holder.e(e.f6111c);
        if (textView2 != null) {
            textView2.setText(this.appVersion);
            final Rect rect = new Rect();
            textView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: v3.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean onBindViewHolder$lambda$5$lambda$4;
                    onBindViewHolder$lambda$5$lambda$4 = COUIAppInfoPreference.onBindViewHolder$lambda$5$lambda$4(COUIAppInfoPreference.this, rect, textView2, view);
                    return onBindViewHolder$lambda$5$lambda$4;
                }
            });
        }
    }

    public final void setAppIcon(Drawable drawable) {
        this.appIcon = drawable;
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setAppVersion(String str) {
        this.appVersion = str;
    }

    public final void setCopyFinishText(String str) {
        this.copyFinishText = str;
    }

    public final void setCopyText(String str) {
        this.copyText = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIAppInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f10636h);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIAppInfoPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        i.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIAppInfoPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
        setLayoutResource(f.f6182r);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z8.i.f6221a, 0, 0);
        this.appName = obtainStyledAttributes.getString(Z8.i.f6225c);
        this.appIcon = obtainStyledAttributes.getDrawable(Z8.i.f6223b);
        this.appVersion = obtainStyledAttributes.getString(Z8.i.f6227d);
        this.copyText = obtainStyledAttributes.getString(Z8.i.f6229f);
        this.copyFinishText = obtainStyledAttributes.getString(Z8.i.f6228e);
        obtainStyledAttributes.recycle();
    }
}
