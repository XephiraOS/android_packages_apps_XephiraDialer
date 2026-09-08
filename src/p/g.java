package P;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: EmojiTextWatcher.java */
/* loaded from: classes.dex */
public final class g implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f2804a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2805b;

    /* renamed from: c, reason: collision with root package name */
    public e.f f2806c;

    /* renamed from: d, reason: collision with root package name */
    public int f2807d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f2808e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2809f = true;

    /* compiled from: EmojiTextWatcher.java */
    /* loaded from: classes.dex */
    public static class a extends e.f {

        /* renamed from: a, reason: collision with root package name */
        public final Reference<EditText> f2810a;

        public a(EditText editText) {
            this.f2810a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.e.f
        public void b() {
            super.b();
            g.c(this.f2810a.get(), 1);
        }
    }

    public g(EditText editText, boolean z10) {
        this.f2804a = editText;
        this.f2805b = z10;
    }

    public static void c(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.e.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final e.f a() {
        if (this.f2806c == null) {
            this.f2806c = new a(this.f2804a);
        }
        return this.f2806c;
    }

    public boolean b() {
        return this.f2809f;
    }

    public void d(boolean z10) {
        if (this.f2809f != z10) {
            if (this.f2806c != null) {
                androidx.emoji2.text.e.c().u(this.f2806c);
            }
            this.f2809f = z10;
            if (z10) {
                c(this.f2804a, androidx.emoji2.text.e.c().e());
            }
        }
    }

    public final boolean e() {
        if (this.f2809f && (this.f2805b || androidx.emoji2.text.e.i())) {
            return false;
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (!this.f2804a.isInEditMode() && !e() && i11 <= i12 && (charSequence instanceof Spannable)) {
            int e10 = androidx.emoji2.text.e.c().e();
            if (e10 != 0) {
                if (e10 != 1) {
                    if (e10 != 3) {
                        return;
                    }
                } else {
                    androidx.emoji2.text.e.c().s((Spannable) charSequence, i10, i10 + i12, this.f2807d, this.f2808e);
                    return;
                }
            }
            androidx.emoji2.text.e.c().t(a());
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
