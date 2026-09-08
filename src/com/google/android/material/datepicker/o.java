package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.K;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;

/* compiled from: MonthsPagerAdapter.java */
/* loaded from: classes3.dex */
public class o extends RecyclerView.Adapter<b> {

    /* renamed from: a, reason: collision with root package name */
    public final CalendarConstraints f23273a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f23274b;

    /* renamed from: c, reason: collision with root package name */
    public final DayViewDecorator f23275c;

    /* renamed from: d, reason: collision with root package name */
    public final MaterialCalendar.l f23276d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23277e;

    /* compiled from: MonthsPagerAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarGridView f23278a;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.f23278a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (this.f23278a.getAdapter().r(i10)) {
                o.this.f23276d.a(this.f23278a.getAdapter().getItem(i10).longValue());
            }
        }
    }

    /* compiled from: MonthsPagerAdapter.java */
    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f23280a;

        /* renamed from: b, reason: collision with root package name */
        public final MaterialCalendarGridView f23281b;

        public b(LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(e4.g.f30908w);
            this.f23280a = textView;
            K.k0(textView, true);
            this.f23281b = (MaterialCalendarGridView) linearLayout.findViewById(e4.g.f30900s);
            if (!z10) {
                textView.setVisibility(8);
            }
        }
    }

    public o(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.l lVar) {
        int i10;
        Month t10 = calendarConstraints.t();
        Month m10 = calendarConstraints.m();
        Month q10 = calendarConstraints.q();
        if (t10.compareTo(q10) <= 0) {
            if (q10.compareTo(m10) <= 0) {
                int r12 = n.f23265g * MaterialCalendar.r1(context);
                if (k.r1(context)) {
                    i10 = MaterialCalendar.r1(context);
                } else {
                    i10 = 0;
                }
                this.f23277e = r12 + i10;
                this.f23273a = calendarConstraints;
                this.f23274b = dateSelector;
                this.f23275c = dayViewDecorator;
                this.f23276d = lVar;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f23273a.p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return this.f23273a.t().p(i10).n();
    }

    public Month h(int i10) {
        return this.f23273a.t().p(i10);
    }

    public CharSequence i(int i10) {
        return h(i10).m();
    }

    public int j(Month month) {
        return this.f23273a.t().q(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i10) {
        Month p10 = this.f23273a.t().p(i10);
        bVar.f23280a.setText(p10.m());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f23281b.findViewById(e4.g.f30900s);
        if (materialCalendarGridView.getAdapter() != null && p10.equals(materialCalendarGridView.getAdapter().f23267a)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        } else {
            n nVar = new n(p10, this.f23274b, this.f23273a, this.f23275c);
            materialCalendarGridView.setNumColumns(p10.f23162d);
            materialCalendarGridView.setAdapter((ListAdapter) nVar);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e4.i.f30943w, viewGroup, false);
        if (k.r1(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f23277e));
            return new b(linearLayout, true);
        }
        return new b(linearLayout, false);
    }
}
