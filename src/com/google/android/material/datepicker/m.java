package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* compiled from: MaterialTextInputPicker.java */
/* loaded from: classes3.dex */
public final class m<S> extends q<S> {

    /* renamed from: b, reason: collision with root package name */
    public int f23261b;

    /* renamed from: c, reason: collision with root package name */
    public DateSelector<S> f23262c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarConstraints f23263d;

    /* compiled from: MaterialTextInputPicker.java */
    /* loaded from: classes3.dex */
    public class a extends p<S> {
        public a() {
        }

        @Override // com.google.android.material.datepicker.p
        public void a() {
            Iterator<p<S>> it = m.this.f23282a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.p
        public void b(S s10) {
            Iterator<p<S>> it = m.this.f23282a.iterator();
            while (it.hasNext()) {
                it.next().b(s10);
            }
        }
    }

    public static <T> m<T> e1(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints) {
        m<T> mVar = new m<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        mVar.setArguments(bundle);
        return mVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f23261b = bundle.getInt("THEME_RES_ID_KEY");
        this.f23262c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f23263d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f23262c.L(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f23261b)), viewGroup, bundle, this.f23263d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f23261b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f23262c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f23263d);
    }
}
