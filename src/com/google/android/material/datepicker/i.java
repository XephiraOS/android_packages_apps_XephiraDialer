package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: DaysOfWeekAdapter.java */
/* loaded from: classes3.dex */
public class i extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    public static final int f23216d = 4;

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f23217a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23218b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23219c;

    public i() {
        Calendar m10 = t.m();
        this.f23217a = m10;
        this.f23218b = m10.getMaximum(7);
        this.f23219c = m10.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i10) {
        if (i10 >= this.f23218b) {
            return null;
        }
        return Integer.valueOf(b(i10));
    }

    public final int b(int i10) {
        int i11 = i10 + this.f23219c;
        int i12 = this.f23218b;
        if (i11 > i12) {
            return i11 - i12;
        }
        return i11;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23218b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e4.i.f30941u, viewGroup, false);
        }
        this.f23217a.set(7, b(i10));
        textView.setText(this.f23217a.getDisplayName(7, f23216d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(e4.k.f30949B), this.f23217a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public i(int i10) {
        Calendar m10 = t.m();
        this.f23217a = m10;
        this.f23218b = m10.getMaximum(7);
        this.f23219c = i10;
    }
}
