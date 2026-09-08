package com.android.contacts.dialpad.view;

import U7.f;
import android.R;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Rect;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.SuggestionSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.coui.appcompat.edittext.COUIEditText;
import com.customize.contacts.util.C0803n;
import com.customize.contacts.util.SoftKeyboardUtil;

/* loaded from: classes.dex */
public class DialEditText extends COUIEditText {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f14966a;

    /* renamed from: b, reason: collision with root package name */
    public TextWatcher f14967b;

    public DialEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14967b = null;
        setInputType(getInputType() | 524288);
        setForceDarkAllowed(false);
    }

    public CharSequence a(int i10, int i11) {
        return f.g(b(this.f14966a.subSequence(i10, i11)).toString());
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        if (textWatcher instanceof PhoneNumberFormattingTextWatcher) {
            if (H7.a.b()) {
                H7.b.b("DialEditText", "addTextChangedListener watcher is PhoneNumberWatcher : " + this.f14967b);
            }
            TextWatcher textWatcher2 = this.f14967b;
            if (textWatcher2 != null) {
                super.removeTextChangedListener(textWatcher2);
            }
            this.f14967b = textWatcher;
        } else if (H7.a.b()) {
            H7.b.b("DialEditText", "addTextChangedListener watcher is TextWatcher");
        }
        super.addTextChangedListener(textWatcher);
    }

    public CharSequence b(CharSequence charSequence) {
        Spannable spannableString;
        if (charSequence instanceof Spanned) {
            if (charSequence instanceof Spannable) {
                spannableString = (Spannable) charSequence;
            } else {
                spannableString = new SpannableString(charSequence);
                charSequence = spannableString;
            }
            for (SuggestionSpan suggestionSpan : (SuggestionSpan[]) spannableString.getSpans(0, charSequence.length(), SuggestionSpan.class)) {
                spannableString.removeSpan(suggestionSpan);
            }
        }
        return charSequence;
    }

    @Override // com.coui.appcompat.edittext.COUIEditText, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        SoftKeyboardUtil.a().b(this);
        setShowSoftInputOnFocus(false);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i10) {
        int length = getText().length();
        this.f14966a = getText();
        int i11 = 0;
        if (isFocused()) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            int max = Math.max(0, Math.min(selectionStart, selectionEnd));
            length = Math.max(0, Math.max(selectionStart, selectionEnd));
            i11 = max;
        }
        CharSequence a10 = a(i11, length);
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i10);
        switch (i10) {
            case R.id.cut:
            case R.id.copy:
                C0803n.d(getContext(), ClipData.newPlainText(null, a10));
            default:
                return onTextContextMenuItem;
        }
    }

    @Override // com.coui.appcompat.edittext.COUIEditText, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        try {
            z10 = super.onTouchEvent(motionEvent);
        } catch (Exception e10) {
            H7.b.c("DialEditText", "DialEditText onTouchEvent error." + e10);
            z10 = true;
        }
        if (H7.a.b()) {
            H7.b.b("DialEditText", "onTouchEvent MotionEvent: " + motionEvent + " super ret = " + z10);
        }
        SoftKeyboardUtil.a().b(this);
        setShowSoftInputOnFocus(false);
        return z10;
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher textWatcher) {
        if (H7.a.b()) {
            H7.b.b("DialEditText", "removeTextChangedListener watcher : " + textWatcher);
        }
        super.removeTextChangedListener(textWatcher);
        if (textWatcher instanceof PhoneNumberFormattingTextWatcher) {
            this.f14967b = null;
        }
    }
}
