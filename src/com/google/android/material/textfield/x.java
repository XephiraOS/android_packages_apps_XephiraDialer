package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* compiled from: PasswordToggleEndIconDelegate.java */
/* loaded from: classes3.dex */
public class x extends s {

    /* renamed from: e, reason: collision with root package name */
    public int f24167e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f24168f;

    /* renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f24169g;

    public x(r rVar, int i10) {
        super(rVar);
        this.f24167e = e4.f.f30824a;
        this.f24169g = new View.OnClickListener() { // from class: com.google.android.material.textfield.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.this.y(view);
            }
        };
        if (i10 != 0) {
            this.f24167e = i10;
        }
    }

    public static boolean x(EditText editText) {
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText = this.f24168f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (w()) {
            this.f24168f.setTransformationMethod(null);
        } else {
            this.f24168f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            this.f24168f.setSelection(selectionEnd);
        }
        r();
    }

    @Override // com.google.android.material.textfield.s
    public void b(CharSequence charSequence, int i10, int i11, int i12) {
        r();
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return e4.k.f30971X;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return this.f24167e;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f24169g;
    }

    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return !w();
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f24168f = editText;
        r();
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        if (x(this.f24168f)) {
            this.f24168f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f24168f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final boolean w() {
        EditText editText = this.f24168f;
        if (editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return true;
        }
        return false;
    }
}
