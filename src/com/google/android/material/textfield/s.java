package com.google.android.material.textfield;

import J.c;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* compiled from: EndIconDelegate.java */
/* loaded from: classes3.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f24128a;

    /* renamed from: b, reason: collision with root package name */
    public final r f24129b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f24130c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f24131d;

    public s(r rVar) {
        this.f24128a = rVar.f24100a;
        this.f24129b = rVar;
        this.f24130c = rVar.getContext();
        this.f24131d = rVar.r();
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public c.a h() {
        return null;
    }

    public boolean i(int i10) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public final void r() {
        this.f24129b.L(false);
    }

    public boolean t() {
        return false;
    }

    public void s() {
    }

    public void u() {
    }

    public void a(Editable editable) {
    }

    public void n(EditText editText) {
    }

    public void q(boolean z10) {
    }

    public void o(View view, J.d dVar) {
    }

    public void p(View view, AccessibilityEvent accessibilityEvent) {
    }

    public void b(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
