package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.K;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import e4.g;
import e4.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: a, reason: collision with root package name */
    public final Chip f24181a;

    /* renamed from: b, reason: collision with root package name */
    public final TextInputLayout f24182b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f24183c;

    /* renamed from: d, reason: collision with root package name */
    public TextWatcher f24184d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f24185e;

    /* loaded from: classes3.dex */
    public class b extends TextWatcherAdapter {
        public b() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable)) {
                String c10 = ChipTextInputComboView.this.c(editable);
                Chip chip = ChipTextInputComboView.this.f24181a;
                if (TextUtils.isEmpty(c10)) {
                    c10 = ChipTextInputComboView.this.c("00");
                }
                chip.setText(c10);
                return;
            }
            ChipTextInputComboView.this.f24181a.setText(ChipTextInputComboView.this.c("00"));
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String c(CharSequence charSequence) {
        return TimeModel.b(getResources(), charSequence);
    }

    public final void d() {
        this.f24183c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f24181a.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        int i10;
        int i11;
        this.f24181a.setChecked(z10);
        EditText editText = this.f24183c;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 4;
        }
        editText.setVisibility(i10);
        Chip chip = this.f24181a;
        if (z10) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        chip.setVisibility(i11);
        if (isChecked()) {
            ViewUtils.requestFocusAndShowKeyboard(this.f24183c, false);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f24181a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        this.f24181a.setTag(i10, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f24181a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(i.f30936p, (ViewGroup) this, false);
        this.f24181a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(i.f30937q, (ViewGroup) this, false);
        this.f24182b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f24183c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f24184d = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f24185e = (TextView) findViewById(g.f30894p);
        editText.setId(K.i());
        K.w0(this.f24185e, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
