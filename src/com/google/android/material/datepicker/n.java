package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MonthAdapter.java */
/* loaded from: classes3.dex */
public class n extends BaseAdapter {

    /* renamed from: g, reason: collision with root package name */
    public static final int f23265g = t.m().getMaximum(4);

    /* renamed from: h, reason: collision with root package name */
    public static final int f23266h = (t.m().getMaximum(5) + t.m().getMaximum(7)) - 1;

    /* renamed from: a, reason: collision with root package name */
    public final Month f23267a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f23268b;

    /* renamed from: c, reason: collision with root package name */
    public Collection<Long> f23269c;

    /* renamed from: d, reason: collision with root package name */
    public b f23270d;

    /* renamed from: e, reason: collision with root package name */
    public final CalendarConstraints f23271e;

    /* renamed from: f, reason: collision with root package name */
    public final DayViewDecorator f23272f;

    public n(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f23267a = month;
        this.f23268b = dateSelector;
        this.f23271e = calendarConstraints;
        this.f23272f = dayViewDecorator;
        this.f23269c = dateSelector.f0();
    }

    public int a(int i10) {
        return b() + (i10 - 1);
    }

    public int b() {
        return this.f23267a.i(this.f23271e.n());
    }

    public final String c(Context context, long j10) {
        return h.e(context, j10, l(j10), k(j10), g(j10));
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i10) {
        if (i10 >= b() && i10 <= m()) {
            return Long.valueOf(this.f23267a.j(n(i10)));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.f(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = e4.i.f30940t
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L54
            com.google.android.material.datepicker.Month r8 = r5.f23267a
            int r2 = r8.f23163e
            if (r7 < r2) goto L2d
            goto L54
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L5d
        L54:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L5d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L64
            return r0
        L64:
            long r1 = r6.longValue()
            r5.o(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.n.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public final void f(Context context) {
        if (this.f23270d == null) {
            this.f23270d = new b(context);
        }
    }

    public boolean g(long j10) {
        Iterator<I.d<Long, Long>> it = this.f23268b.o().iterator();
        while (it.hasNext()) {
            Long l10 = it.next().f1296b;
            if (l10 != null && l10.longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f23266h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10 / this.f23267a.f23162d;
    }

    public boolean h(int i10) {
        if (i10 % this.f23267a.f23162d == 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public boolean i(int i10) {
        if ((i10 + 1) % this.f23267a.f23162d == 0) {
            return true;
        }
        return false;
    }

    public final boolean j(long j10) {
        Iterator<Long> it = this.f23268b.f0().iterator();
        while (it.hasNext()) {
            if (t.a(j10) == t.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean k(long j10) {
        Iterator<I.d<Long, Long>> it = this.f23268b.o().iterator();
        while (it.hasNext()) {
            Long l10 = it.next().f1295a;
            if (l10 != null && l10.longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    public final boolean l(long j10) {
        if (t.k().getTimeInMillis() == j10) {
            return true;
        }
        return false;
    }

    public int m() {
        return (b() + this.f23267a.f23163e) - 1;
    }

    public int n(int i10) {
        return (i10 - b()) + 1;
    }

    public final void o(TextView textView, long j10, int i10) {
        boolean z10;
        a aVar;
        a aVar2;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String c10 = c(context, j10);
        textView.setContentDescription(c10);
        boolean X10 = this.f23271e.k().X(j10);
        if (X10) {
            textView.setEnabled(true);
            boolean j11 = j(j10);
            textView.setSelected(j11);
            if (j11) {
                aVar2 = this.f23270d.f23195b;
            } else if (l(j10)) {
                aVar2 = this.f23270d.f23196c;
            } else {
                aVar2 = this.f23270d.f23194a;
            }
            aVar = aVar2;
            z10 = j11;
        } else {
            textView.setEnabled(false);
            z10 = false;
            aVar = this.f23270d.f23200g;
        }
        DayViewDecorator dayViewDecorator = this.f23272f;
        if (dayViewDecorator != null && i10 != -1) {
            Month month = this.f23267a;
            int i11 = month.f23161c;
            int i12 = month.f23160b;
            ColorStateList b10 = dayViewDecorator.b(context, i11, i12, i10, X10, z10);
            boolean z11 = z10;
            aVar.e(textView, b10, this.f23272f.k(context, i11, i12, i10, X10, z11));
            Drawable f10 = this.f23272f.f(context, i11, i12, i10, X10, z11);
            Drawable i13 = this.f23272f.i(context, i11, i12, i10, X10, z11);
            Drawable h10 = this.f23272f.h(context, i11, i12, i10, X10, z11);
            boolean z12 = z10;
            textView.setCompoundDrawables(f10, i13, h10, this.f23272f.d(context, i11, i12, i10, X10, z12));
            textView.setContentDescription(this.f23272f.j(context, i11, i12, i10, X10, z12, c10));
            return;
        }
        aVar.d(textView);
    }

    public final void p(MaterialCalendarGridView materialCalendarGridView, long j10) {
        if (Month.f(j10).equals(this.f23267a)) {
            int k10 = this.f23267a.k(j10);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(k10) - materialCalendarGridView.getFirstVisiblePosition()), j10, k10);
        }
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f23269c.iterator();
        while (it.hasNext()) {
            p(materialCalendarGridView, it.next().longValue());
        }
        DateSelector<?> dateSelector = this.f23268b;
        if (dateSelector != null) {
            Iterator<Long> it2 = dateSelector.f0().iterator();
            while (it2.hasNext()) {
                p(materialCalendarGridView, it2.next().longValue());
            }
            this.f23269c = this.f23268b.f0();
        }
    }

    public boolean r(int i10) {
        if (i10 >= b() && i10 <= m()) {
            return true;
        }
        return false;
    }
}
