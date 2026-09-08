package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* compiled from: DateFormatTextWatcher.java */
/* loaded from: classes3.dex */
public abstract class e extends TextWatcherAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f23206a;

    /* renamed from: b, reason: collision with root package name */
    public final String f23207b;

    /* renamed from: c, reason: collision with root package name */
    public final DateFormat f23208c;

    /* renamed from: d, reason: collision with root package name */
    public final CalendarConstraints f23209d;

    /* renamed from: e, reason: collision with root package name */
    public final String f23210e;

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f23211f;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f23212g;

    /* renamed from: h, reason: collision with root package name */
    public int f23213h = 0;

    public e(final String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f23207b = str;
        this.f23208c = dateFormat;
        this.f23206a = textInputLayout;
        this.f23209d = calendarConstraints;
        this.f23210e = textInputLayout.getContext().getString(e4.k.f30957J);
        this.f23211f = new Runnable() { // from class: com.google.android.material.datepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.e(str);
            }
        };
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.f23207b.length() && editable.length() >= this.f23213h) {
            char charAt = this.f23207b.charAt(editable.length());
            if (!Character.isLetterOrDigit(charAt)) {
                editable.append(charAt);
            }
        }
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f23213h = charSequence.length();
    }

    public final Runnable c(final long j10) {
        return new Runnable() { // from class: com.google.android.material.datepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.d(j10);
            }
        };
    }

    public final /* synthetic */ void d(long j10) {
        this.f23206a.setError(String.format(this.f23210e, i(h.c(j10))));
        f();
    }

    public final /* synthetic */ void e(String str) {
        TextInputLayout textInputLayout = this.f23206a;
        DateFormat dateFormat = this.f23208c;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(e4.k.f30951D) + "\n" + String.format(context.getString(e4.k.f30953F), i(str)) + "\n" + String.format(context.getString(e4.k.f30952E), i(dateFormat.format(new Date(t.k().getTimeInMillis())))));
        f();
    }

    public abstract void f();

    public abstract void g(Long l10);

    public void h(View view, Runnable runnable) {
        view.post(runnable);
    }

    public final String i(String str) {
        return str.replace(' ', (char) 160);
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f23206a.removeCallbacks(this.f23211f);
        this.f23206a.removeCallbacks(this.f23212g);
        this.f23206a.setError(null);
        g(null);
        if (!TextUtils.isEmpty(charSequence) && charSequence.length() >= this.f23207b.length()) {
            try {
                Date parse = this.f23208c.parse(charSequence.toString());
                this.f23206a.setError(null);
                long time = parse.getTime();
                if (this.f23209d.k().X(time) && this.f23209d.w(time)) {
                    g(Long.valueOf(parse.getTime()));
                    return;
                }
                Runnable c10 = c(time);
                this.f23212g = c10;
                h(this.f23206a, c10);
            } catch (ParseException unused) {
                h(this.f23206a, this.f23211f);
            }
        }
    }
}
