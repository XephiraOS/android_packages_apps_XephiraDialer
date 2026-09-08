package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.textfield.TextInputLayout;
import e4.C0977c;
import e4.C0979e;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import u4.C1606b;

/* loaded from: classes3.dex */
public class RangeDateSelector implements DateSelector<I.d<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f23166a;

    /* renamed from: b, reason: collision with root package name */
    public String f23167b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23168c = " ";

    /* renamed from: d, reason: collision with root package name */
    public Long f23169d = null;

    /* renamed from: e, reason: collision with root package name */
    public Long f23170e = null;

    /* renamed from: f, reason: collision with root package name */
    public Long f23171f = null;

    /* renamed from: g, reason: collision with root package name */
    public Long f23172g = null;

    /* renamed from: h, reason: collision with root package name */
    public SimpleDateFormat f23173h;

    /* loaded from: classes3.dex */
    public class a extends e {

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f23174i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f23175j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ p f23176k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, p pVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f23174i = textInputLayout2;
            this.f23175j = textInputLayout3;
            this.f23176k = pVar;
        }

        @Override // com.google.android.material.datepicker.e
        public void f() {
            RangeDateSelector.this.f23171f = null;
            RangeDateSelector.this.q(this.f23174i, this.f23175j, this.f23176k);
        }

        @Override // com.google.android.material.datepicker.e
        public void g(Long l10) {
            RangeDateSelector.this.f23171f = l10;
            RangeDateSelector.this.q(this.f23174i, this.f23175j, this.f23176k);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends e {

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f23178i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f23179j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ p f23180k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, p pVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f23178i = textInputLayout2;
            this.f23179j = textInputLayout3;
            this.f23180k = pVar;
        }

        @Override // com.google.android.material.datepicker.e
        public void f() {
            RangeDateSelector.this.f23172g = null;
            RangeDateSelector.this.q(this.f23178i, this.f23179j, this.f23180k);
        }

        @Override // com.google.android.material.datepicker.e
        public void g(Long l10) {
            RangeDateSelector.this.f23172g = l10;
            RangeDateSelector.this.q(this.f23178i, this.f23179j, this.f23180k);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f23169d = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f23170e = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i10) {
            return new RangeDateSelector[i10];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View L(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, p<I.d<Long, Long>> pVar) {
        String g10;
        boolean z10 = false;
        View inflate = layoutInflater.inflate(e4.i.f30918D, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(e4.g.f30849L);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(e4.g.f30848K);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f23167b = inflate.getResources().getString(e4.k.f30954G);
        SimpleDateFormat simpleDateFormat = this.f23173h;
        if (simpleDateFormat != null) {
            z10 = true;
        }
        if (!z10) {
            simpleDateFormat = t.f();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        Long l10 = this.f23169d;
        if (l10 != null) {
            editText.setText(simpleDateFormat2.format(l10));
            this.f23171f = this.f23169d;
        }
        Long l11 = this.f23170e;
        if (l11 != null) {
            editText2.setText(simpleDateFormat2.format(l11));
            this.f23172g = this.f23170e;
        }
        if (z10) {
            g10 = simpleDateFormat2.toPattern();
        } else {
            g10 = t.g(inflate.getResources(), simpleDateFormat2);
        }
        String str = g10;
        textInputLayout.setPlaceholderText(str);
        textInputLayout2.setPlaceholderText(str);
        editText.addTextChangedListener(new a(str, simpleDateFormat2, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, pVar));
        editText2.addTextChangedListener(new b(str, simpleDateFormat2, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, pVar));
        DateSelector.I(editText, editText2);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String T(Context context) {
        String str;
        String str2;
        Resources resources = context.getResources();
        I.d<String, String> a10 = h.a(this.f23169d, this.f23170e);
        String str3 = a10.f1295a;
        if (str3 == null) {
            str = resources.getString(e4.k.f30997y);
        } else {
            str = str3;
        }
        String str4 = a10.f1296b;
        if (str4 == null) {
            str2 = resources.getString(e4.k.f30997y);
        } else {
            str2 = str4;
        }
        return resources.getString(e4.k.f30995w, str, str2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int V(Context context) {
        int i10;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(C0979e.f30807r0)) {
            i10 = C0977c.f30640L;
        } else {
            i10 = C0977c.f30638J;
        }
        return C1606b.d(context, i10, k.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean Z() {
        Long l10 = this.f23169d;
        if (l10 != null && this.f23170e != null && m(l10.longValue(), this.f23170e.longValue())) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> f0() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f23169d;
        if (l10 != null) {
            arrayList.add(l10);
        }
        Long l11 = this.f23170e;
        if (l11 != null) {
            arrayList.add(l11);
        }
        return arrayList;
    }

    public final void j(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f23167b.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError(null);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public I.d<Long, Long> g0() {
        return new I.d<>(this.f23169d, this.f23170e);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String l(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f23169d;
        if (l10 == null && this.f23170e == null) {
            return resources.getString(e4.k.f30961N);
        }
        Long l11 = this.f23170e;
        if (l11 == null) {
            return resources.getString(e4.k.f30959L, h.c(l10.longValue()));
        }
        if (l10 == null) {
            return resources.getString(e4.k.f30958K, h.c(l11.longValue()));
        }
        I.d<String, String> a10 = h.a(l10, l11);
        return resources.getString(e4.k.f30960M, a10.f1295a, a10.f1296b);
    }

    public final boolean m(long j10, long j11) {
        if (j10 <= j11) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void m0(long j10) {
        Long l10 = this.f23169d;
        if (l10 == null) {
            this.f23169d = Long.valueOf(j10);
        } else if (this.f23170e == null && m(l10.longValue(), j10)) {
            this.f23170e = Long.valueOf(j10);
        } else {
            this.f23170e = null;
            this.f23169d = Long.valueOf(j10);
        }
    }

    public final void n(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f23167b);
        textInputLayout2.setError(" ");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<I.d<Long, Long>> o() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new I.d(this.f23169d, this.f23170e));
        return arrayList;
    }

    public final void p(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.f23166a = textInputLayout.getError();
        } else if (!TextUtils.isEmpty(textInputLayout2.getError())) {
            this.f23166a = textInputLayout2.getError();
        } else {
            this.f23166a = null;
        }
    }

    public final void q(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, p<I.d<Long, Long>> pVar) {
        Long l10 = this.f23171f;
        if (l10 != null && this.f23172g != null) {
            if (m(l10.longValue(), this.f23172g.longValue())) {
                this.f23169d = this.f23171f;
                this.f23170e = this.f23172g;
                pVar.b(g0());
            } else {
                n(textInputLayout, textInputLayout2);
                pVar.a();
            }
        } else {
            j(textInputLayout, textInputLayout2);
            pVar.a();
        }
        p(textInputLayout, textInputLayout2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.f23169d);
        parcel.writeValue(this.f23170e);
    }
}
