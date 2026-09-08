package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.textfield.TextInputLayout;
import e4.C0977c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import u4.C1606b;

/* loaded from: classes3.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f23182a;

    /* renamed from: b, reason: collision with root package name */
    public Long f23183b;

    /* renamed from: c, reason: collision with root package name */
    public SimpleDateFormat f23184c;

    /* loaded from: classes3.dex */
    public class a extends e {

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ p f23185i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f23186j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, p pVar, TextInputLayout textInputLayout2) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f23185i = pVar;
            this.f23186j = textInputLayout2;
        }

        @Override // com.google.android.material.datepicker.e
        public void f() {
            SingleDateSelector.this.f23182a = this.f23186j.getError();
            this.f23185i.a();
        }

        @Override // com.google.android.material.datepicker.e
        public void g(Long l10) {
            if (l10 == null) {
                SingleDateSelector.this.h();
            } else {
                SingleDateSelector.this.m0(l10.longValue());
            }
            SingleDateSelector.this.f23182a = null;
            this.f23185i.b(SingleDateSelector.this.g0());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Parcelable.Creator<SingleDateSelector> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f23183b = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector[] newArray(int i10) {
            return new SingleDateSelector[i10];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View L(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, p<Long> pVar) {
        String g10;
        boolean z10 = false;
        View inflate = layoutInflater.inflate(e4.i.f30917C, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(e4.g.f30847J);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormat = this.f23184c;
        if (simpleDateFormat != null) {
            z10 = true;
        }
        if (!z10) {
            simpleDateFormat = t.f();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        if (z10) {
            g10 = simpleDateFormat2.toPattern();
        } else {
            g10 = t.g(inflate.getResources(), simpleDateFormat2);
        }
        String str = g10;
        textInputLayout.setPlaceholderText(str);
        Long l10 = this.f23183b;
        if (l10 != null) {
            editText.setText(simpleDateFormat2.format(l10));
        }
        editText.addTextChangedListener(new a(str, simpleDateFormat2, textInputLayout, calendarConstraints, pVar, textInputLayout));
        DateSelector.I(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String T(Context context) {
        String m10;
        Resources resources = context.getResources();
        Long l10 = this.f23183b;
        if (l10 == null) {
            m10 = resources.getString(e4.k.f30997y);
        } else {
            m10 = h.m(l10.longValue());
        }
        return resources.getString(e4.k.f30996x, m10);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int V(Context context) {
        return C1606b.d(context, C0977c.f30640L, k.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean Z() {
        if (this.f23183b != null) {
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
        Long l10 = this.f23183b;
        if (l10 != null) {
            arrayList.add(l10);
        }
        return arrayList;
    }

    public final void h() {
        this.f23183b = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Long g0() {
        return this.f23183b;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String l(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f23183b;
        if (l10 == null) {
            return resources.getString(e4.k.f30948A);
        }
        return resources.getString(e4.k.f30998z, h.m(l10.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void m0(long j10) {
        this.f23183b = Long.valueOf(j10);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<I.d<Long, Long>> o() {
        return new ArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.f23183b);
    }
}
