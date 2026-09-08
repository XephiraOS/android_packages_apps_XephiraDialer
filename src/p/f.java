package P;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* compiled from: EmojiTextViewHelper.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final b f2799a;

    /* compiled from: EmojiTextViewHelper.java */
    /* loaded from: classes.dex */
    public static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f2800a;

        /* renamed from: b, reason: collision with root package name */
        public final d f2801b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2802c = true;

        public a(TextView textView) {
            this.f2800a = textView;
            this.f2801b = new d(textView);
        }

        @Override // P.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f2802c) {
                return h(inputFilterArr);
            }
            return f(inputFilterArr);
        }

        @Override // P.f.b
        public boolean b() {
            return this.f2802c;
        }

        @Override // P.f.b
        public void c(boolean z10) {
            if (z10) {
                l();
            }
        }

        @Override // P.f.b
        public void d(boolean z10) {
            this.f2802c = z10;
            l();
            k();
        }

        @Override // P.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.f2802c) {
                return m(transformationMethod);
            }
            return j(transformationMethod);
        }

        public final InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f2801b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f2801b;
            return inputFilterArr2;
        }

        public final SparseArray<InputFilter> g(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                InputFilter inputFilter = inputFilterArr[i10];
                if (inputFilter instanceof d) {
                    sparseArray.put(i10, inputFilter);
                }
            }
            return sparseArray;
        }

        public final InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> g10 = g(inputFilterArr);
            if (g10.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - g10.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (g10.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }

        public void i(boolean z10) {
            this.f2802c = z10;
        }

        public final TransformationMethod j(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof h) {
                return ((h) transformationMethod).a();
            }
            return transformationMethod;
        }

        public final void k() {
            this.f2800a.setFilters(a(this.f2800a.getFilters()));
        }

        public void l() {
            this.f2800a.setTransformationMethod(e(this.f2800a.getTransformationMethod()));
        }

        public final TransformationMethod m(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof h) {
                return transformationMethod;
            }
            if (transformationMethod instanceof PasswordTransformationMethod) {
                return transformationMethod;
            }
            return new h(transformationMethod);
        }
    }

    /* compiled from: EmojiTextViewHelper.java */
    /* loaded from: classes.dex */
    public static class b {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public void c(boolean z10) {
            throw null;
        }

        public void d(boolean z10) {
            throw null;
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            throw null;
        }
    }

    /* compiled from: EmojiTextViewHelper.java */
    /* loaded from: classes.dex */
    public static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final a f2803a;

        public c(TextView textView) {
            this.f2803a = new a(textView);
        }

        @Override // P.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            if (f()) {
                return inputFilterArr;
            }
            return this.f2803a.a(inputFilterArr);
        }

        @Override // P.f.b
        public boolean b() {
            return this.f2803a.b();
        }

        @Override // P.f.b
        public void c(boolean z10) {
            if (f()) {
                return;
            }
            this.f2803a.c(z10);
        }

        @Override // P.f.b
        public void d(boolean z10) {
            if (f()) {
                this.f2803a.i(z10);
            } else {
                this.f2803a.d(z10);
            }
        }

        @Override // P.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            if (f()) {
                return transformationMethod;
            }
            return this.f2803a.e(transformationMethod);
        }

        public final boolean f() {
            return !androidx.emoji2.text.e.i();
        }
    }

    public f(TextView textView, boolean z10) {
        I.h.f(textView, "textView cannot be null");
        if (!z10) {
            this.f2799a = new c(textView);
        } else {
            this.f2799a = new a(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f2799a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f2799a.b();
    }

    public void c(boolean z10) {
        this.f2799a.c(z10);
    }

    public void d(boolean z10) {
        this.f2799a.d(z10);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f2799a.e(transformationMethod);
    }
}
