package com.customize.contacts.util;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import java.util.regex.Pattern;

/* compiled from: EmailFormattingTextWatcher.java */
/* loaded from: classes3.dex */
public class B implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public int f21859a = 0;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f21860b = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public boolean f21861c = false;

    public static boolean a(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '\"' || Pattern.matches("[_0-9a-zA-Z-!#\\$%&'\\*\\+/=\\?\\^`\\{\\}\\|~\\.@\\[\\]]", String.valueOf(charAt))) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.TextWatcher
    public synchronized void afterTextChanged(Editable editable) {
        try {
            if (this.f21861c) {
                return;
            }
            this.f21860b.setLength(0);
            int length = editable.length();
            boolean z10 = false;
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = editable.charAt(i11);
                if (charAt == '\"') {
                    z10 = !z10;
                    this.f21860b.append(charAt);
                } else if (z10) {
                    this.f21860b.append(charAt);
                } else if (Pattern.matches("[_0-9a-zA-Z-!#\\$%&'\\*\\+/=\\?\\^`\\{\\}\\|~\\.@\\[\\]]", String.valueOf(charAt))) {
                    this.f21860b.append(charAt);
                } else {
                    int i12 = this.f21859a;
                    if (i11 <= i12 + i10) {
                        this.f21859a = i12 - 1;
                        i10++;
                    }
                }
            }
            if (this.f21859a < 0) {
                this.f21859a = 0;
            }
            if (this.f21859a > this.f21860b.length()) {
                this.f21859a = this.f21860b.length();
            }
            this.f21861c = true;
            if (!this.f21860b.toString().equals(editable.toString())) {
                editable.replace(0, editable.length(), this.f21860b.toString(), 0, this.f21860b.length());
            }
            if (this.f21860b.toString().equals(editable.toString())) {
                Selection.setSelection(editable, this.f21859a);
            }
            this.f21861c = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (this.f21861c) {
            return;
        }
        this.f21859a = i10 + i12;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
