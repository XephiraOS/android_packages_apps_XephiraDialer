package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SpannableBuilder.java */
/* loaded from: classes.dex */
public final class n extends SpannableStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f9830a;

    /* renamed from: b, reason: collision with root package name */
    public final List<a> f9831b;

    /* compiled from: SpannableBuilder.java */
    /* loaded from: classes.dex */
    public static class a implements TextWatcher, SpanWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final Object f9832a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f9833b = new AtomicInteger(0);

        public a(Object obj) {
            this.f9832a = obj;
        }

        public final void a() {
            this.f9833b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f9832a).afterTextChanged(editable);
        }

        public final boolean b(Object obj) {
            return obj instanceof i;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ((TextWatcher) this.f9832a).beforeTextChanged(charSequence, i10, i11, i12);
        }

        public final void c() {
            this.f9833b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i10, int i11) {
            if (this.f9833b.get() > 0 && b(obj)) {
                return;
            }
            ((SpanWatcher) this.f9832a).onSpanAdded(spannable, obj, i10, i11);
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i10, int i11, int i12, int i13) {
            if (this.f9833b.get() > 0 && b(obj)) {
                return;
            }
            ((SpanWatcher) this.f9832a).onSpanChanged(spannable, obj, i10, i11, i12, i13);
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i10, int i11) {
            if (this.f9833b.get() > 0 && b(obj)) {
                return;
            }
            ((SpanWatcher) this.f9832a).onSpanRemoved(spannable, obj, i10, i11);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ((TextWatcher) this.f9832a).onTextChanged(charSequence, i10, i11, i12);
        }
    }

    public n(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        this.f9831b = new ArrayList();
        I.h.f(cls, "watcherClass cannot be null");
        this.f9830a = cls;
    }

    public static n c(Class<?> cls, CharSequence charSequence) {
        return new n(cls, charSequence);
    }

    public void a() {
        b();
    }

    public final void b() {
        for (int i10 = 0; i10 < this.f9831b.size(); i10++) {
            this.f9831b.get(i10).a();
        }
    }

    public void d() {
        i();
        e();
    }

    public final void e() {
        for (int i10 = 0; i10 < this.f9831b.size(); i10++) {
            this.f9831b.get(i10).onTextChanged(this, 0, length(), length());
        }
    }

    public final a f(Object obj) {
        for (int i10 = 0; i10 < this.f9831b.size(); i10++) {
            a aVar = this.f9831b.get(i10);
            if (aVar.f9832a == obj) {
                return aVar;
            }
        }
        return null;
    }

    public final boolean g(Class<?> cls) {
        if (this.f9830a == cls) {
            return true;
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        a f10;
        if (h(obj) && (f10 = f(obj)) != null) {
            obj = f10;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        a f10;
        if (h(obj) && (f10 = f(obj)) != null) {
            obj = f10;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        a f10;
        if (h(obj) && (f10 = f(obj)) != null) {
            obj = f10;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        if (g(cls)) {
            a[] aVarArr = (a[]) super.getSpans(i10, i11, a.class);
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, aVarArr.length));
            for (int i12 = 0; i12 < aVarArr.length; i12++) {
                tArr[i12] = aVarArr[i12].f9832a;
            }
            return tArr;
        }
        return (T[]) super.getSpans(i10, i11, cls);
    }

    public final boolean h(Object obj) {
        if (obj != null && g(obj.getClass())) {
            return true;
        }
        return false;
    }

    public final void i() {
        for (int i10 = 0; i10 < this.f9831b.size(); i10++) {
            this.f9831b.get(i10).c();
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        a aVar;
        if (h(obj)) {
            aVar = f(obj);
            if (aVar != null) {
                obj = aVar;
            }
        } else {
            aVar = null;
        }
        super.removeSpan(obj);
        if (aVar != null) {
            this.f9831b.remove(aVar);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f9831b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i10, i11, i12);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return new n(this.f9830a, this, i10, i11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i10, int i11) {
        super.delete(i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i10, CharSequence charSequence) {
        super.insert(i10, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence) {
        b();
        super.replace(i10, i11, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i10, CharSequence charSequence, int i11, int i12) {
        super.insert(i10, charSequence, i11, i12);
        return this;
    }

    public n(Class<?> cls, CharSequence charSequence, int i10, int i11) {
        super(charSequence, i10, i11);
        this.f9831b = new ArrayList();
        I.h.f(cls, "watcherClass cannot be null");
        this.f9830a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence, int i12, int i13) {
        b();
        super.replace(i10, i11, charSequence, i12, i13);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c10) {
        super.append(c10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i10, int i11) {
        super.append(charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i10) {
        super.append(charSequence, obj, i10);
        return this;
    }
}
