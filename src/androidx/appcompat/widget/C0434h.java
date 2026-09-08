package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* compiled from: AppCompatEmojiEditTextHelper.java */
/* renamed from: androidx.appcompat.widget.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0434h {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f7865a;

    /* renamed from: b, reason: collision with root package name */
    public final P.a f7866b;

    public C0434h(EditText editText) {
        this.f7865a = editText;
        this.f7866b = new P.a(editText, false);
    }

    public KeyListener a(KeyListener keyListener) {
        if (b(keyListener)) {
            return this.f7866b.a(keyListener);
        }
        return keyListener;
    }

    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public boolean c() {
        return this.f7866b.b();
    }

    public void d(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f7865a.getContext().obtainStyledAttributes(attributeSet, e.j.f30456i0, i10, 0);
        try {
            int i11 = e.j.f30526w0;
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(i11)) {
                z10 = obtainStyledAttributes.getBoolean(i11, true);
            }
            obtainStyledAttributes.recycle();
            f(z10);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public InputConnection e(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f7866b.c(inputConnection, editorInfo);
    }

    public void f(boolean z10) {
        this.f7866b.d(z10);
    }
}
