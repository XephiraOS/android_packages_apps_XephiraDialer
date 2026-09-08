package L;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.databinding.h;

/* compiled from: TextViewBindingAdapter.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: TextViewBindingAdapter.java */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0038c f1702a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f1703b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f1704c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f1705d;

        public a(InterfaceC0038c interfaceC0038c, d dVar, h hVar, b bVar) {
            this.f1704c = hVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            b bVar = this.f1705d;
            if (bVar != null) {
                bVar.afterTextChanged(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            InterfaceC0038c interfaceC0038c = this.f1702a;
            if (interfaceC0038c != null) {
                interfaceC0038c.beforeTextChanged(charSequence, i10, i11, i12);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            d dVar = this.f1703b;
            if (dVar != null) {
                dVar.onTextChanged(charSequence, i10, i11, i12);
            }
            h hVar = this.f1704c;
            if (hVar != null) {
                hVar.onChange();
            }
        }
    }

    /* compiled from: TextViewBindingAdapter.java */
    /* loaded from: classes.dex */
    public interface b {
        void afterTextChanged(Editable editable);
    }

    /* compiled from: TextViewBindingAdapter.java */
    /* renamed from: L.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0038c {
        void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12);
    }

    /* compiled from: TextViewBindingAdapter.java */
    /* loaded from: classes.dex */
    public interface d {
        void onTextChanged(CharSequence charSequence, int i10, int i11, int i12);
    }

    public static String a(TextView textView) {
        return textView.getText().toString();
    }

    public static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        boolean z10;
        boolean z11;
        if (charSequence == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (charSequence2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 != z11) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return true;
            }
        }
        return false;
    }

    public static void c(TextView textView, Drawable drawable) {
        d(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(drawable, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    public static void d(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    public static void e(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence != text) {
            if (charSequence != null || text.length() != 0) {
                if (charSequence instanceof Spanned) {
                    if (charSequence.equals(text)) {
                        return;
                    }
                } else if (!b(charSequence, text)) {
                    return;
                }
                textView.setText(charSequence);
            }
        }
    }

    public static void f(TextView textView, InterfaceC0038c interfaceC0038c, d dVar, b bVar, h hVar) {
        a aVar;
        if (interfaceC0038c == null && bVar == null && dVar == null && hVar == null) {
            aVar = null;
        } else {
            aVar = new a(interfaceC0038c, dVar, hVar, bVar);
        }
        TextWatcher textWatcher = (TextWatcher) L.b.b(textView, aVar, N.a.f1835a);
        if (textWatcher != null) {
            textView.removeTextChangedListener(textWatcher);
        }
        if (aVar != null) {
            textView.addTextChangedListener(aVar);
        }
    }
}
