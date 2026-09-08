package P;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* compiled from: EmojiEditTextHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f2783a;

    /* renamed from: b, reason: collision with root package name */
    public int f2784b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f2785c = 0;

    /* compiled from: EmojiEditTextHelper.java */
    /* renamed from: P.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0053a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final EditText f2786a;

        /* renamed from: b, reason: collision with root package name */
        public final g f2787b;

        public C0053a(EditText editText, boolean z10) {
            this.f2786a = editText;
            g gVar = new g(editText, z10);
            this.f2787b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(P.b.getInstance());
        }

        @Override // P.a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new e(keyListener);
        }

        @Override // P.a.b
        public boolean b() {
            return this.f2787b.b();
        }

        @Override // P.a.b
        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            if (inputConnection instanceof c) {
                return inputConnection;
            }
            return new c(this.f2786a, inputConnection, editorInfo);
        }

        @Override // P.a.b
        public void d(boolean z10) {
            this.f2787b.d(z10);
        }
    }

    /* compiled from: EmojiEditTextHelper.java */
    /* loaded from: classes.dex */
    public static class b {
        public KeyListener a(KeyListener keyListener) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            throw null;
        }

        public void d(boolean z10) {
            throw null;
        }
    }

    public a(EditText editText, boolean z10) {
        I.h.f(editText, "editText cannot be null");
        this.f2783a = new C0053a(editText, z10);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f2783a.a(keyListener);
    }

    public boolean b() {
        return this.f2783a.b();
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f2783a.c(inputConnection, editorInfo);
    }

    public void d(boolean z10) {
        this.f2783a.d(z10);
    }
}
