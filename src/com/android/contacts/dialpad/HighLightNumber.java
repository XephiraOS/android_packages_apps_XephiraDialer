package com.android.contacts.dialpad;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.contacts.framework.baseui.util.r;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public class HighLightNumber extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14872a;

    /* renamed from: b, reason: collision with root package name */
    public TextPaint f14873b;

    /* renamed from: c, reason: collision with root package name */
    public TextPaint f14874c;

    /* renamed from: d, reason: collision with root package name */
    public int f14875d;

    /* renamed from: e, reason: collision with root package name */
    public String f14876e;

    /* renamed from: f, reason: collision with root package name */
    public String f14877f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14878g;

    /* renamed from: h, reason: collision with root package name */
    public Context f14879h;

    /* renamed from: i, reason: collision with root package name */
    public int f14880i;

    /* renamed from: j, reason: collision with root package name */
    public int f14881j;

    /* renamed from: k, reason: collision with root package name */
    public int f14882k;

    /* renamed from: l, reason: collision with root package name */
    public int f14883l;

    public HighLightNumber(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14872a = false;
        this.f14878g = false;
        this.f14881j = -1;
        this.f14882k = -1;
        this.f14873b = new TextPaint(1);
        this.f14873b.setColor(context.getColor(R.color.coui_preference_secondary_text_color));
        this.f14873b.density = getResources().getDisplayMetrics().density;
        this.f14873b.setTextSize(getTextSize());
        this.f14874c = new TextPaint(1);
        int a10 = r.a(context);
        this.f14875d = a10;
        this.f14874c.setColor(a10);
        this.f14874c.density = getResources().getDisplayMetrics().density;
        this.f14874c.setTextSize(getTextSize());
        this.f14883l = (int) c();
        this.f14879h = context;
    }

    public void a(String str) {
        this.f14881j = -1;
        this.f14882k = -1;
        int indexOf = this.f14876e.indexOf(str);
        if (indexOf < 0) {
            str = PhoneNumberUtils.e(str);
            indexOf = this.f14876e.indexOf(str);
        }
        if (indexOf >= 0) {
            this.f14881j = indexOf;
            this.f14882k = str.length();
        }
    }

    public final float b(String str) {
        if (str != null && !str.equals("")) {
            return this.f14873b.measureText(str);
        }
        return 0.0f;
    }

    public final float c() {
        return this.f14873b.measureText("...");
    }

    public void d(String str, String str2, int i10) {
        this.f14876e = str;
        this.f14877f = str2;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.f14876e) && i10 == 3) {
            a(str2);
            e();
            f(str);
            return;
        }
        this.f14881j = -1;
        this.f14882k = -1;
        if (!TextUtils.isEmpty(str2) && str2.length() >= 0 && !TextUtils.isEmpty(this.f14876e)) {
            a(str2);
            e();
        }
        f(str);
    }

    public final void e() {
        String str;
        if (!FeatureOption.i() && !TextUtils.isEmpty(this.f14877f) && this.f14881j >= 0 && this.f14882k >= 0) {
            String str2 = this.f14876e;
            this.f14880i = str2.length();
            int i10 = this.f14881j;
            String str3 = null;
            if (i10 > 0) {
                str = str2.substring(0, i10);
            } else {
                str = null;
            }
            int i11 = this.f14881j;
            String substring = str2.substring(i11, this.f14882k + i11);
            int i12 = this.f14881j;
            int i13 = this.f14882k;
            if (i12 + i13 < this.f14880i) {
                str3 = str2.substring(i12 + i13);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int a10 = r.a(this.f14879h);
            if (str != null) {
                try {
                    spannableStringBuilder.append((CharSequence) str);
                } catch (Exception e10) {
                    H7.b.c("HighLightNumber", "setHighLightInfoToNumberTextView  error!");
                    H7.b.c("HighLightNumber", "Exception e: " + e10);
                    return;
                }
            }
            spannableStringBuilder.append((CharSequence) substring);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(a10);
            int i14 = this.f14881j;
            spannableStringBuilder.setSpan(foregroundColorSpan, i14, substring.length() + i14, 33);
            if (str3 != null) {
                spannableStringBuilder.append((CharSequence) str3);
            }
            setText(spannableStringBuilder);
        }
    }

    public final void f(String str) {
        if (!TextUtils.isEmpty(str) && this.f14881j >= 0 && this.f14882k >= 0) {
            try {
                this.f14878g = true;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.f14875d);
                int i10 = this.f14881j;
                spannableStringBuilder.setSpan(foregroundColorSpan, i10, this.f14882k + i10, 33);
                setText(spannableStringBuilder);
                return;
            } catch (Exception e10) {
                this.f14878g = false;
                setText(str);
                H7.b.c("HighLightNumber", "highLight number error " + e10);
                return;
            }
        }
        setText(str);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int height;
        int lineDescent;
        String str;
        if (this.f14878g) {
            super.onDraw(canvas);
            return;
        }
        if (this.f14872a) {
            super.onDraw(canvas);
            return;
        }
        Layout layout = getLayout();
        if (!TextUtils.isEmpty(this.f14877f) && this.f14881j >= 0 && layout != null) {
            if ((getGravity() & 112) == 48) {
                height = layout.getLineTop(1);
                lineDescent = layout.getLineDescent(0);
            } else {
                height = (getHeight() + layout.getLineTop(1)) / 2;
                lineDescent = layout.getLineDescent(0);
            }
            int i10 = height - lineDescent;
            String str2 = this.f14876e;
            this.f14880i = str2.length();
            int i11 = this.f14881j;
            String str3 = null;
            if (i11 > 0) {
                str = str2.substring(0, i11);
            } else {
                str = null;
            }
            int i12 = this.f14881j;
            String substring = str2.substring(i12, this.f14882k + i12);
            int i13 = this.f14881j;
            int i14 = this.f14882k;
            if (i13 + i14 < this.f14880i) {
                str3 = str2.substring(i13 + i14);
            }
            if (b(str2) <= getWidth()) {
                if (str != null) {
                    canvas.drawText(str, getPaddingLeft(), i10, this.f14873b);
                }
                float f10 = i10;
                canvas.drawText(substring, getPaddingLeft() + b(str), f10, this.f14874c);
                if (str3 != null) {
                    canvas.drawText(str3, getPaddingLeft() + b(str) + b(substring), f10, this.f14873b);
                    return;
                }
                return;
            }
            String str4 = "";
            if (str == null) {
                str = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            int b10 = (int) b(str);
            int b11 = (int) b(substring);
            if (b10 <= getWidth() - this.f14883l) {
                float f11 = i10;
                canvas.drawText(str, getPaddingLeft(), f11, this.f14873b);
                int width = getWidth() - b10;
                int i15 = this.f14883l;
                if (b11 <= width - i15) {
                    canvas.drawText(substring, getPaddingLeft() + b(str), f11, this.f14874c);
                    int i16 = (width - b11) - this.f14883l;
                    int i17 = 1;
                    while (true) {
                        if (i17 > str3.length()) {
                            break;
                        }
                        str4 = str3.substring(0, i17);
                        if (((int) b(str4)) <= i16) {
                            i17++;
                        } else {
                            str4 = str3.substring(0, i17 - 1);
                            break;
                        }
                    }
                    canvas.drawText(str4 + "...", getPaddingLeft() + b(str) + b(substring), f11, this.f14873b);
                    return;
                }
                int i18 = width - i15;
                int i19 = 1;
                while (true) {
                    if (i19 > substring.length()) {
                        break;
                    }
                    str4 = substring.substring(0, i19);
                    if (((int) b(str4)) <= i18) {
                        i19++;
                    } else {
                        str4 = substring.substring(0, i19 - 1);
                        break;
                    }
                }
                canvas.drawText(str4 + "...", getPaddingLeft() + b(str), f11, this.f14874c);
                return;
            }
            int width2 = getWidth() - this.f14883l;
            int i20 = 1;
            while (true) {
                if (i20 > str.length()) {
                    break;
                }
                str4 = str.substring(0, i20);
                if (((int) b(str4)) <= width2) {
                    i20++;
                } else {
                    str4 = str.substring(0, i20 - 1);
                    break;
                }
            }
            canvas.drawText(str4 + "...", getPaddingLeft(), i10, this.f14873b);
            return;
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
    }

    public void setHightTextColor(int i10) {
        this.f14875d = i10;
        this.f14874c.setColor(i10);
    }

    public void setNormalMode(boolean z10) {
        this.f14878g = z10;
    }

    public void setTextPaintColor(int i10) {
        this.f14873b.setColor(i10);
    }
}
