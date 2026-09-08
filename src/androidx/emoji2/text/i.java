package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* compiled from: EmojiSpan.java */
/* loaded from: classes.dex */
public abstract class i extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    public final o f9805b;

    /* renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f9804a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    public short f9806c = -1;

    /* renamed from: d, reason: collision with root package name */
    public short f9807d = -1;

    /* renamed from: e, reason: collision with root package name */
    public float f9808e = 1.0f;

    public i(o oVar) {
        I.h.f(oVar, "rasterizer cannot be null");
        this.f9805b = oVar;
    }

    public final o a() {
        return this.f9805b;
    }

    public final int b() {
        return this.f9806c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f9804a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f9804a;
        this.f9808e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f9805b.e();
        this.f9807d = (short) (this.f9805b.e() * this.f9808e);
        short i12 = (short) (this.f9805b.i() * this.f9808e);
        this.f9806c = i12;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f9804a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i12;
    }
}
