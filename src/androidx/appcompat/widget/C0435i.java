package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatEmojiTextHelper.java */
/* renamed from: androidx.appcompat.widget.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0435i {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f7867a;

    /* renamed from: b, reason: collision with root package name */
    public final P.f f7868b;

    public C0435i(TextView textView) {
        this.f7867a = textView;
        this.f7868b = new P.f(textView, false);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f7868b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f7868b.b();
    }

    public void c(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f7867a.getContext().obtainStyledAttributes(attributeSet, e.j.f30456i0, i10, 0);
        try {
            int i11 = e.j.f30526w0;
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(i11)) {
                z10 = obtainStyledAttributes.getBoolean(i11, true);
            }
            obtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(boolean z10) {
        this.f7868b.c(z10);
    }

    public void e(boolean z10) {
        this.f7868b.d(z10);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f7868b.e(transformationMethod);
    }
}
