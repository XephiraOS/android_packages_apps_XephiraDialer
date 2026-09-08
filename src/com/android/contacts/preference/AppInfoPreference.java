package com.android.contacts.preference;

import A.h;
import H7.b;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.l;
import com.android.contacts.V0;
import com.android.contacts.preference.AppInfoPreference;
import com.coui.appcompat.poplist.COUIPopupWindow;
import com.coui.appcompat.preference.COUIPreference;
import com.oplus.dialer.R;
import com.oplus.foundation.util.ui.c;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;

/* compiled from: AppInfoPreference.kt */
/* loaded from: classes.dex */
public final class AppInfoPreference extends COUIPreference {

    /* renamed from: h, reason: collision with root package name */
    public static final a f17050h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public ImageView f17051a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f17052b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f17053c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f17054d;

    /* renamed from: e, reason: collision with root package name */
    public String f17055e;

    /* renamed from: f, reason: collision with root package name */
    public String f17056f;

    /* renamed from: g, reason: collision with root package name */
    public Rect f17057g;

    /* compiled from: AppInfoPreference.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public AppInfoPreference(Context context) {
        this(context, null);
    }

    public static final void d(TextView this_apply, AppInfoPreference this$0, COUIPopupWindow popupWindow, View view) {
        CharSequence charSequence;
        i.f(this_apply, "$this_apply");
        i.f(this$0, "this$0");
        i.f(popupWindow, "$popupWindow");
        Object systemService = this_apply.getContext().getSystemService("clipboard");
        i.d(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        TextView textView = this$0.f17053c;
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, String.valueOf(charSequence)));
        c.d(this_apply.getContext(), R.string.toast_text_copied);
        popupWindow.dismiss();
    }

    public static final boolean e(AppInfoPreference this$0, TextView this_apply, COUIPopupWindow couiPopupWindow, View view) {
        i.f(this$0, "this$0");
        i.f(this_apply, "$this_apply");
        i.f(couiPopupWindow, "$couiPopupWindow");
        Rect rect = this$0.f17057g;
        int dimensionPixelOffset = (((rect.left + rect.right) + this_apply.getContext().getResources().getDimensionPixelOffset(R.dimen.copy_window_width)) - this_apply.getMeasuredWidth()) / 2;
        int measuredHeight = this_apply.getMeasuredHeight() + this_apply.getContext().getResources().getDimensionPixelOffset(R.dimen.copy_window_height) + this_apply.getContext().getResources().getDimensionPixelOffset(R.dimen.copy_window_margin_bottom) + this$0.f17057g.top;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            couiPopupWindow.showAsDropDown(this_apply, (-this_apply.getMeasuredWidth()) - dimensionPixelOffset, -measuredHeight);
        } else {
            couiPopupWindow.showAsDropDown(this_apply, -dimensionPixelOffset, -measuredHeight);
        }
        return true;
    }

    public final String c(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str == null) {
                return "";
            }
            return str;
        } catch (PackageManager.NameNotFoundException e10) {
            b.c("AppInfoPreference", "e : " + e10);
            return "";
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        ViewGroup viewGroup;
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        View e10 = holder.e(R.id.about_app_icon);
        i.d(e10, "null cannot be cast to non-null type android.widget.ImageView");
        this.f17051a = (ImageView) e10;
        View e11 = holder.e(R.id.about_app_name);
        i.d(e11, "null cannot be cast to non-null type android.widget.TextView");
        this.f17052b = (TextView) e11;
        View e12 = holder.e(R.id.about_app_version);
        i.d(e12, "null cannot be cast to non-null type android.widget.TextView");
        this.f17053c = (TextView) e12;
        ImageView imageView = this.f17051a;
        if (imageView != null) {
            ViewParent parent = imageView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.setOnClickListener(null);
                viewGroup.setBackground(null);
            }
            imageView.setImageDrawable(this.f17054d);
        }
        TextView textView = this.f17052b;
        if (textView != null) {
            textView.setText(this.f17055e);
        }
        final COUIPopupWindow cOUIPopupWindow = new COUIPopupWindow(getContext());
        Drawable f10 = h.f(getContext().getResources(), 2131232773, null);
        i.d(f10, "null cannot be cast to non-null type android.graphics.drawable.NinePatchDrawable");
        ((NinePatchDrawable) f10).getPadding(this.f17057g);
        cOUIPopupWindow.setBackgroundDrawable(h.f(getContext().getResources(), 2131232773, null));
        cOUIPopupWindow.setContentView(LayoutInflater.from(getContext()).inflate(R.layout.popup_window_layout, (ViewGroup) null));
        final TextView textView2 = (TextView) cOUIPopupWindow.getContentView().findViewById(R.id.popup_window_copy_body);
        if (textView2 != null) {
            i.e(textView2, "findViewById<TextView>(R…d.popup_window_copy_body)");
            textView2.setOnClickListener(new View.OnClickListener() { // from class: o1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppInfoPreference.d(textView2, this, cOUIPopupWindow, view);
                }
            });
        }
        cOUIPopupWindow.setDismissTouchOutside(true);
        m mVar = m.f34245a;
        String string = getContext().getString(R.string.version_information);
        i.e(string, "context.getString(R.string.version_information)");
        Context context = getContext();
        i.e(context, "context");
        String format = String.format(string, Arrays.copyOf(new Object[]{c(context)}, 1));
        i.e(format, "format(...)");
        this.f17056f = format;
        final TextView textView3 = this.f17053c;
        if (textView3 != null) {
            textView3.setText(format);
            textView3.setOnLongClickListener(new View.OnLongClickListener() { // from class: o1.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean e13;
                    e13 = AppInfoPreference.e(AppInfoPreference.this, textView3, cOUIPopupWindow, view);
                    return e13;
                }
            });
        }
    }

    public AppInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppInfoPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public AppInfoPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f17057g = new Rect();
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, V0.f13530v, 0, 0) : null;
        this.f17055e = obtainStyledAttributes != null ? obtainStyledAttributes.getString(1) : null;
        this.f17054d = obtainStyledAttributes != null ? obtainStyledAttributes.getDrawable(0) : null;
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
    }
}
