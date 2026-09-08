package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.e;

/* compiled from: DefaultGlyphChecker.java */
/* loaded from: classes.dex */
public class d implements e.InterfaceC0121e {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f9749b = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f9750a;

    public d() {
        TextPaint textPaint = new TextPaint();
        this.f9750a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f9749b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.e.InterfaceC0121e
    public boolean a(CharSequence charSequence, int i10, int i11, int i12) {
        StringBuilder b10 = b();
        b10.setLength(0);
        while (i10 < i11) {
            b10.append(charSequence.charAt(i10));
            i10++;
        }
        return B.c.a(this.f9750a, b10.toString());
    }
}
