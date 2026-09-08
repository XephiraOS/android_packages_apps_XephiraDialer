package com.customize.contacts.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.contacts.V0;
import com.oplus.dialer.R;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TelescopicTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    public TextPaint f22445a;

    /* renamed from: b, reason: collision with root package name */
    public Context f22446b;

    /* renamed from: c, reason: collision with root package name */
    public DynamicLayout f22447c;

    /* renamed from: d, reason: collision with root package name */
    public int f22448d;

    /* renamed from: e, reason: collision with root package name */
    public int f22449e;

    /* renamed from: f, reason: collision with root package name */
    public int f22450f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f22451g;

    /* renamed from: h, reason: collision with root package name */
    public int f22452h;

    /* renamed from: i, reason: collision with root package name */
    public int f22453i;

    /* renamed from: j, reason: collision with root package name */
    public String f22454j;

    /* renamed from: k, reason: collision with root package name */
    public String f22455k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f22456l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f22457m;

    /* loaded from: classes3.dex */
    public class a extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f22458a;

        public a(CharSequence charSequence) {
            this.f22458a = charSequence;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            TelescopicTextView.this.f22457m = !r2.f22457m;
            TelescopicTextView.this.setContent(this.f22458a.toString());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(TelescopicTextView.this.f22452h);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f22460a;

        public b(CharSequence charSequence) {
            this.f22460a = charSequence;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            TelescopicTextView.this.f22457m = !r2.f22457m;
            TelescopicTextView.this.setContent(this.f22460a.toString());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(TelescopicTextView.this.f22453i);
            textPaint.setUnderlineText(false);
        }
    }

    public TelescopicTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final SpannableStringBuilder e(CharSequence charSequence, SpannableStringBuilder spannableStringBuilder) {
        int i10 = this.f22448d - 1;
        int lineStart = this.f22447c.getLineStart(i10);
        int lineEnd = this.f22447c.getLineEnd(i10);
        float lineWidth = this.f22447c.getLineWidth(i10);
        String format = String.format(Locale.getDefault(), "...  %s", this.f22454j);
        String charSequence2 = charSequence.subSequence(0, g(format, lineStart, lineWidth, this.f22445a.measureText(format), lineEnd - lineStart, 0.0f)).toString();
        if (charSequence2.endsWith("\n")) {
            charSequence2 = charSequence2.substring(0, charSequence2.length() - 1);
        }
        spannableStringBuilder.append((CharSequence) charSequence2);
        spannableStringBuilder.append((CharSequence) format);
        spannableStringBuilder.setSpan(new a(charSequence), spannableStringBuilder.length() - this.f22454j.length(), spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder f(CharSequence charSequence, SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.append((CharSequence) String.format(Locale.getDefault(), "  %s", this.f22455k));
        spannableStringBuilder.setSpan(new b(charSequence), spannableStringBuilder.length() - this.f22455k.length(), spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public final int g(String str, int i10, float f10, float f11, int i11, float f12) {
        int h10 = h(f10, f11, f12, i11);
        if (h10 <= str.length()) {
            return i11 + i10;
        }
        int i12 = h10 + i10;
        if (this.f22445a.measureText(this.f22451g.subSequence(i10, i12).toString()) <= f10 - f11) {
            return i12;
        }
        return g(str, i10, f10, f11, i11, f12 + this.f22445a.measureText(this.f22446b.getResources().getString(R.string.space)));
    }

    public final int h(float f10, float f11, float f12, int i10) {
        if (f10 != 0.0f) {
            return (int) (((f10 - (f11 + f12)) * i10) / f10);
        }
        return 0;
    }

    public final void i(Context context, AttributeSet attributeSet, int i10) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V0.f13373X4, i10, 0);
            this.f22448d = obtainStyledAttributes.getInt(2, 2);
            this.f22454j = context.getString(R.string.contact_editor_name_expand);
            this.f22455k = context.getString(R.string.contact_editor_name_close);
            this.f22452h = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.coui_color_label_primary));
            this.f22453i = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.coui_color_label_primary));
            obtainStyledAttributes.recycle();
        }
        this.f22446b = context;
        TextPaint paint = getPaint();
        this.f22445a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void j(int i10) {
        this.f22449e = i10;
    }

    public void setContent(String str) {
        boolean z10;
        if (str == null) {
            return;
        }
        this.f22451g = str;
        DynamicLayout dynamicLayout = new DynamicLayout(str, this.f22445a, this.f22449e, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        this.f22447c = dynamicLayout;
        int lineCount = dynamicLayout.getLineCount();
        this.f22450f = lineCount;
        if (lineCount > this.f22448d) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f22456l = z10;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f22456l) {
            if (this.f22457m) {
                spannableStringBuilder = e(str, spannableStringBuilder);
            } else {
                spannableStringBuilder = f(str, spannableStringBuilder);
            }
        } else {
            spannableStringBuilder.append((CharSequence) str);
        }
        setText(spannableStringBuilder);
    }

    public TelescopicTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22457m = true;
        i(context, attributeSet, i10);
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
