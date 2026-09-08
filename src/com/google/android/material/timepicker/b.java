package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: MaxInputValidator.java */
/* loaded from: classes3.dex */
public class b implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public int f24246a;

    public b(int i10) {
        this.f24246a = i10;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i12, i13, charSequence.subSequence(i10, i11).toString());
            if (Integer.parseInt(sb.toString()) <= this.f24246a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
