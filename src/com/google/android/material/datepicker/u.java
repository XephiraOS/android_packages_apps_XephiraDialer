package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: YearGridAdapter.java */
/* loaded from: classes3.dex */
public class u extends RecyclerView.Adapter<b> {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCalendar<?> f23288a;

    /* compiled from: YearGridAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23289a;

        public a(int i10) {
            this.f23289a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u.this.f23288a.w1(u.this.f23288a.n1().j(Month.d(this.f23289a, u.this.f23288a.p1().f23160b)));
            u.this.f23288a.x1(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    /* compiled from: YearGridAdapter.java */
    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f23291a;

        public b(TextView textView) {
            super(textView);
            this.f23291a = textView;
        }
    }

    public u(MaterialCalendar<?> materialCalendar) {
        this.f23288a = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f23288a.n1().v();
    }

    public final View.OnClickListener h(int i10) {
        return new a(i10);
    }

    public int i(int i10) {
        return i10 - this.f23288a.n1().t().f23161c;
    }

    public int j(int i10) {
        return this.f23288a.n1().t().f23161c + i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i10) {
        com.google.android.material.datepicker.a aVar;
        int j10 = j(i10);
        bVar.f23291a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(j10)));
        TextView textView = bVar.f23291a;
        textView.setContentDescription(h.k(textView.getContext(), j10));
        com.google.android.material.datepicker.b o12 = this.f23288a.o1();
        Calendar k10 = t.k();
        if (k10.get(1) == j10) {
            aVar = o12.f23199f;
        } else {
            aVar = o12.f23197d;
        }
        Iterator<Long> it = this.f23288a.q1().f0().iterator();
        while (it.hasNext()) {
            k10.setTimeInMillis(it.next().longValue());
            if (k10.get(1) == j10) {
                aVar = o12.f23198e;
            }
        }
        aVar.d(bVar.f23291a);
        bVar.f23291a.setOnClickListener(h(j10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e4.i.f30945y, viewGroup, false));
    }
}
