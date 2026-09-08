package H;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class b implements Spannable {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1186c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Spannable f1187a;

    /* renamed from: b, reason: collision with root package name */
    public final PrecomputedText f1188b;

    /* compiled from: PrecomputedTextCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextPaint f1189a;

        /* renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f1190b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1191c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1192d;

        /* renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f1193e;

        public a(PrecomputedText.Params params) {
            this.f1189a = params.getTextPaint();
            this.f1190b = params.getTextDirection();
            this.f1191c = params.getBreakStrategy();
            this.f1192d = params.getHyphenationFrequency();
            this.f1193e = params;
        }

        public boolean a(a aVar) {
            if (this.f1191c != aVar.b() || this.f1192d != aVar.c() || this.f1189a.getTextSize() != aVar.e().getTextSize() || this.f1189a.getTextScaleX() != aVar.e().getTextScaleX() || this.f1189a.getTextSkewX() != aVar.e().getTextSkewX() || this.f1189a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f1189a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.f1189a.getFlags() != aVar.e().getFlags() || !this.f1189a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return false;
            }
            if (this.f1189a.getTypeface() == null) {
                if (aVar.e().getTypeface() != null) {
                    return false;
                }
                return true;
            }
            if (!this.f1189a.getTypeface().equals(aVar.e().getTypeface())) {
                return false;
            }
            return true;
        }

        public int b() {
            return this.f1191c;
        }

        public int c() {
            return this.f1192d;
        }

        public TextDirectionHeuristic d() {
            return this.f1190b;
        }

        public TextPaint e() {
            return this.f1189a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar) && this.f1190b == aVar.d()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return I.c.b(Float.valueOf(this.f1189a.getTextSize()), Float.valueOf(this.f1189a.getTextScaleX()), Float.valueOf(this.f1189a.getTextSkewX()), Float.valueOf(this.f1189a.getLetterSpacing()), Integer.valueOf(this.f1189a.getFlags()), this.f1189a.getTextLocales(), this.f1189a.getTypeface(), Boolean.valueOf(this.f1189a.isElegantTextHeight()), this.f1190b, Integer.valueOf(this.f1191c), Integer.valueOf(this.f1192d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1189a.getTextSize());
            sb.append(", textScaleX=" + this.f1189a.getTextScaleX());
            sb.append(", textSkewX=" + this.f1189a.getTextSkewX());
            sb.append(", letterSpacing=" + this.f1189a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f1189a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f1189a.getTextLocales());
            sb.append(", typeface=" + this.f1189a.getTypeface());
            sb.append(", variationSettings=" + this.f1189a.getFontVariationSettings());
            sb.append(", textDir=" + this.f1190b);
            sb.append(", breakStrategy=" + this.f1191c);
            sb.append(", hyphenationFrequency=" + this.f1192d);
            sb.append("}");
            return sb.toString();
        }
    }

    public PrecomputedText a() {
        Spannable spannable = this.f1187a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f1187a.charAt(i10);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f1187a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f1187a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f1187a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f1188b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1187a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f1187a.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f1188b.removeSpan(obj);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f1188b.setSpan(obj, i10, i11, i12);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f1187a.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f1187a.toString();
    }
}
