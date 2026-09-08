package P;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: EmojiInputFilter.java */
/* loaded from: classes.dex */
public final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2793a;

    /* renamed from: b, reason: collision with root package name */
    public e.f f2794b;

    /* compiled from: EmojiInputFilter.java */
    /* loaded from: classes.dex */
    public static class a extends e.f {

        /* renamed from: a, reason: collision with root package name */
        public final Reference<TextView> f2795a;

        /* renamed from: b, reason: collision with root package name */
        public final Reference<d> f2796b;

        public a(TextView textView, d dVar) {
            this.f2795a = new WeakReference(textView);
            this.f2796b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.e.f
        public void b() {
            CharSequence text;
            CharSequence p10;
            super.b();
            TextView textView = this.f2795a.get();
            if (!c(textView, this.f2796b.get()) || !textView.isAttachedToWindow() || text == (p10 = androidx.emoji2.text.e.c().p((text = textView.getText())))) {
                return;
            }
            int selectionStart = Selection.getSelectionStart(p10);
            int selectionEnd = Selection.getSelectionEnd(p10);
            textView.setText(p10);
            if (p10 instanceof Spannable) {
                d.b((Spannable) p10, selectionStart, selectionEnd);
            }
        }

        public final boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(TextView textView) {
        this.f2793a = textView;
    }

    public static void b(Spannable spannable, int i10, int i11) {
        if (i10 >= 0 && i11 >= 0) {
            Selection.setSelection(spannable, i10, i11);
        } else if (i10 >= 0) {
            Selection.setSelection(spannable, i10);
        } else if (i11 >= 0) {
            Selection.setSelection(spannable, i11);
        }
    }

    public final e.f a() {
        if (this.f2794b == null) {
            this.f2794b = new a(this.f2793a, this);
        }
        return this.f2794b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        if (this.f2793a.isInEditMode()) {
            return charSequence;
        }
        int e10 = androidx.emoji2.text.e.c().e();
        if (e10 != 0) {
            if (e10 != 1) {
                if (e10 != 3) {
                    return charSequence;
                }
            } else {
                if ((i13 != 0 || i12 != 0 || spanned.length() != 0 || charSequence != this.f2793a.getText()) && charSequence != null) {
                    if (i10 != 0 || i11 != charSequence.length()) {
                        charSequence = charSequence.subSequence(i10, i11);
                    }
                    return androidx.emoji2.text.e.c().q(charSequence, 0, charSequence.length());
                }
                return charSequence;
            }
        }
        androidx.emoji2.text.e.c().t(a());
        return charSequence;
    }
}
