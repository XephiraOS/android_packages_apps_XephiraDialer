package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* compiled from: TypefaceEmojiSpan.java */
/* loaded from: classes.dex */
public final class p extends i {

    /* renamed from: g, reason: collision with root package name */
    public static Paint f9838g;

    /* renamed from: f, reason: collision with root package name */
    public TextPaint f9839f;

    public p(o oVar) {
        super(oVar);
    }

    public static Paint e() {
        if (f9838g == null) {
            TextPaint textPaint = new TextPaint();
            f9838g = textPaint;
            textPaint.setColor(e.c().d());
            f9838g.setStyle(Paint.Style.FILL);
        }
        return f9838g;
    }

    public final TextPaint c(CharSequence charSequence, int i10, int i11, Paint paint) {
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i10, i11, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint = this.f9839f;
                    if (textPaint == null) {
                        textPaint = new TextPaint();
                        this.f9839f = textPaint;
                    }
                    textPaint.set(paint);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        characterStyle.updateDrawState(textPaint);
                    }
                    return textPaint;
                }
            }
            if (!(paint instanceof TextPaint)) {
                return null;
            }
            return (TextPaint) paint;
        }
        if (!(paint instanceof TextPaint)) {
            return null;
        }
        return (TextPaint) paint;
    }

    public void d(Canvas canvas, TextPaint textPaint, float f10, float f11, float f12, float f13) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f10, f12, f11, f13, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        Paint paint2 = paint;
        TextPaint c10 = c(charSequence, i10, i11, paint2);
        if (c10 != null && c10.bgColor != 0) {
            d(canvas, c10, f10, f10 + b(), i12, i14);
        }
        if (e.c().j()) {
            canvas.drawRect(f10, i12, f10 + b(), i14, e());
        }
        o a10 = a();
        float f11 = i13;
        if (c10 != null) {
            paint2 = c10;
        }
        a10.a(canvas, f10, f11, paint2);
    }
}
