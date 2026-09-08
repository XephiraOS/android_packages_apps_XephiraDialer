package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* compiled from: UnprecomputeTextOnModificationSpannable.java */
/* loaded from: classes.dex */
public class q implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9840a = false;

    /* renamed from: b, reason: collision with root package name */
    public Spannable f9841b;

    /* compiled from: UnprecomputeTextOnModificationSpannable.java */
    /* loaded from: classes.dex */
    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    /* compiled from: UnprecomputeTextOnModificationSpannable.java */
    /* loaded from: classes.dex */
    public static class b {
        public boolean a(CharSequence charSequence) {
            throw null;
        }
    }

    /* compiled from: UnprecomputeTextOnModificationSpannable.java */
    /* loaded from: classes.dex */
    public static class c extends b {
        @Override // androidx.emoji2.text.q.b
        public boolean a(CharSequence charSequence) {
            if (!(charSequence instanceof PrecomputedText) && !(charSequence instanceof H.b)) {
                return false;
            }
            return true;
        }
    }

    public q(Spannable spannable) {
        this.f9841b = spannable;
    }

    public static b c() {
        return new c();
    }

    public final void a() {
        Spannable spannable = this.f9841b;
        if (!this.f9840a && c().a(spannable)) {
            this.f9841b = new SpannableString(spannable);
        }
        this.f9840a = true;
    }

    public Spannable b() {
        return this.f9841b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f9841b.charAt(i10);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f9841b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f9841b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f9841b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f9841b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f9841b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f9841b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f9841b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f9841b.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f9841b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f9841b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f9841b.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f9841b.toString();
    }

    public q(CharSequence charSequence) {
        this.f9841b = new SpannableString(charSequence);
    }
}
