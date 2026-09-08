package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import e4.C0979e;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class MaterialCalendar<S> extends q<S> {

    /* renamed from: o, reason: collision with root package name */
    public static final Object f23117o = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: p, reason: collision with root package name */
    public static final Object f23118p = "NAVIGATION_PREV_TAG";

    /* renamed from: q, reason: collision with root package name */
    public static final Object f23119q = "NAVIGATION_NEXT_TAG";

    /* renamed from: r, reason: collision with root package name */
    public static final Object f23120r = "SELECTOR_TOGGLE_TAG";

    /* renamed from: b, reason: collision with root package name */
    public int f23121b;

    /* renamed from: c, reason: collision with root package name */
    public DateSelector<S> f23122c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarConstraints f23123d;

    /* renamed from: e, reason: collision with root package name */
    public DayViewDecorator f23124e;

    /* renamed from: f, reason: collision with root package name */
    public Month f23125f;

    /* renamed from: g, reason: collision with root package name */
    public CalendarSelector f23126g;

    /* renamed from: h, reason: collision with root package name */
    public com.google.android.material.datepicker.b f23127h;

    /* renamed from: i, reason: collision with root package name */
    public RecyclerView f23128i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f23129j;

    /* renamed from: k, reason: collision with root package name */
    public View f23130k;

    /* renamed from: l, reason: collision with root package name */
    public View f23131l;

    /* renamed from: m, reason: collision with root package name */
    public View f23132m;

    /* renamed from: n, reason: collision with root package name */
    public View f23133n;

    /* loaded from: classes3.dex */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f23137a;

        public a(o oVar) {
            this.f23137a = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findLastVisibleItemPosition = MaterialCalendar.this.t1().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.w1(this.f23137a.h(findLastVisibleItemPosition));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23139a;

        public b(int i10) {
            this.f23139a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.f23129j.smoothScrollToPosition(this.f23139a);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends C0446a {
        public c() {
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.j0(null);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23142a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, int i10, boolean z10, int i11) {
            super(context, i10, z10);
            this.f23142a = i11;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.y yVar, int[] iArr) {
            if (this.f23142a == 0) {
                iArr[0] = MaterialCalendar.this.f23129j.getWidth();
                iArr[1] = MaterialCalendar.this.f23129j.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.f23129j.getHeight();
                iArr[1] = MaterialCalendar.this.f23129j.getHeight();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements l {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.l
        public void a(long j10) {
            if (MaterialCalendar.this.f23123d.k().X(j10)) {
                MaterialCalendar.this.f23122c.m0(j10);
                Iterator<p<S>> it = MaterialCalendar.this.f23282a.iterator();
                while (it.hasNext()) {
                    it.next().b(MaterialCalendar.this.f23122c.g0());
                }
                MaterialCalendar.this.f23129j.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.f23128i != null) {
                    MaterialCalendar.this.f23128i.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends C0446a {
        public f() {
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.E0(false);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends RecyclerView.n {

        /* renamed from: a, reason: collision with root package name */
        public final Calendar f23146a = t.m();

        /* renamed from: b, reason: collision with root package name */
        public final Calendar f23147b = t.m();

        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
            int i10;
            int width;
            if ((recyclerView.getAdapter() instanceof u) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                u uVar = (u) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (I.d<Long, Long> dVar : MaterialCalendar.this.f23122c.o()) {
                    Long l10 = dVar.f1295a;
                    if (l10 != null && dVar.f1296b != null) {
                        this.f23146a.setTimeInMillis(l10.longValue());
                        this.f23147b.setTimeInMillis(dVar.f1296b.longValue());
                        int i11 = uVar.i(this.f23146a.get(1));
                        int i12 = uVar.i(this.f23147b.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(i11);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(i12);
                        int o10 = i11 / gridLayoutManager.o();
                        int o11 = i12 / gridLayoutManager.o();
                        for (int i13 = o10; i13 <= o11; i13++) {
                            View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.o() * i13);
                            if (findViewByPosition3 != null) {
                                int top = findViewByPosition3.getTop() + MaterialCalendar.this.f23127h.f23197d.c();
                                int bottom = findViewByPosition3.getBottom() - MaterialCalendar.this.f23127h.f23197d.b();
                                if (i13 == o10 && findViewByPosition != null) {
                                    i10 = findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2);
                                } else {
                                    i10 = 0;
                                }
                                if (i13 == o11 && findViewByPosition2 != null) {
                                    width = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                } else {
                                    width = recyclerView.getWidth();
                                }
                                canvas.drawRect(i10, top, width, bottom, MaterialCalendar.this.f23127h.f23201h);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends C0446a {
        public h() {
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            String string;
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (MaterialCalendar.this.f23133n.getVisibility() == 0) {
                string = MaterialCalendar.this.getString(e4.k.f30970W);
            } else {
                string = MaterialCalendar.this.getString(e4.k.f30968U);
            }
            dVar.s0(string);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends RecyclerView.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f23150a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialButton f23151b;

        public i(o oVar, MaterialButton materialButton) {
            this.f23150a = oVar;
            this.f23151b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            if (i10 == 0) {
                recyclerView.announceForAccessibility(this.f23151b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            int findLastVisibleItemPosition;
            if (i10 < 0) {
                findLastVisibleItemPosition = MaterialCalendar.this.t1().findFirstVisibleItemPosition();
            } else {
                findLastVisibleItemPosition = MaterialCalendar.this.t1().findLastVisibleItemPosition();
            }
            MaterialCalendar.this.f23125f = this.f23150a.h(findLastVisibleItemPosition);
            this.f23151b.setText(this.f23150a.i(findLastVisibleItemPosition));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.z1();
        }
    }

    /* loaded from: classes3.dex */
    public class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f23154a;

        public k(o oVar) {
            this.f23154a = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findFirstVisibleItemPosition = MaterialCalendar.this.t1().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < MaterialCalendar.this.f23129j.getAdapter().getItemCount()) {
                MaterialCalendar.this.w1(this.f23154a.h(findFirstVisibleItemPosition));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(long j10);
    }

    public static int r1(Context context) {
        return context.getResources().getDimensionPixelSize(C0979e.f30799n0);
    }

    public static int s1(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C0979e.f30815v0) + resources.getDimensionPixelOffset(C0979e.f30817w0) + resources.getDimensionPixelOffset(C0979e.f30813u0);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C0979e.f30803p0);
        int i10 = n.f23265g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(C0979e.f30799n0) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(C0979e.f30811t0)) + resources.getDimensionPixelOffset(C0979e.f30795l0);
    }

    public static <T> MaterialCalendar<T> u1(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.q());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    @Override // com.google.android.material.datepicker.q
    public boolean c1(p<S> pVar) {
        return super.c1(pVar);
    }

    public final void l1(View view, o oVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(e4.g.f30902t);
        materialButton.setTag(f23120r);
        K.j0(materialButton, new h());
        View findViewById = view.findViewById(e4.g.f30906v);
        this.f23130k = findViewById;
        findViewById.setTag(f23118p);
        View findViewById2 = view.findViewById(e4.g.f30904u);
        this.f23131l = findViewById2;
        findViewById2.setTag(f23119q);
        this.f23132m = view.findViewById(e4.g.f30841D);
        this.f23133n = view.findViewById(e4.g.f30910y);
        x1(CalendarSelector.DAY);
        materialButton.setText(this.f23125f.m());
        this.f23129j.addOnScrollListener(new i(oVar, materialButton));
        materialButton.setOnClickListener(new j());
        this.f23131l.setOnClickListener(new k(oVar));
        this.f23130k.setOnClickListener(new a(oVar));
    }

    public final RecyclerView.n m1() {
        return new g();
    }

    public CalendarConstraints n1() {
        return this.f23123d;
    }

    public com.google.android.material.datepicker.b o1() {
        return this.f23127h;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f23121b = bundle.getInt("THEME_RES_ID_KEY");
        this.f23122c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f23123d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f23124e = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f23125f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        int i11;
        com.google.android.material.datepicker.i iVar;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f23121b);
        this.f23127h = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month t10 = this.f23123d.t();
        if (com.google.android.material.datepicker.k.r1(contextThemeWrapper)) {
            i10 = e4.i.f30944x;
            i11 = 1;
        } else {
            i10 = e4.i.f30942v;
            i11 = 0;
        }
        View inflate = cloneInContext.inflate(i10, viewGroup, false);
        inflate.setMinimumHeight(s1(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(e4.g.f30911z);
        K.j0(gridView, new c());
        int n10 = this.f23123d.n();
        if (n10 > 0) {
            iVar = new com.google.android.material.datepicker.i(n10);
        } else {
            iVar = new com.google.android.material.datepicker.i();
        }
        gridView.setAdapter((ListAdapter) iVar);
        gridView.setNumColumns(t10.f23162d);
        gridView.setEnabled(false);
        this.f23129j = (RecyclerView) inflate.findViewById(e4.g.f30840C);
        this.f23129j.setLayoutManager(new d(getContext(), i11, false, i11));
        this.f23129j.setTag(f23117o);
        o oVar = new o(contextThemeWrapper, this.f23122c, this.f23123d, this.f23124e, new e());
        this.f23129j.setAdapter(oVar);
        int integer = contextThemeWrapper.getResources().getInteger(e4.h.f30914c);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(e4.g.f30841D);
        this.f23128i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f23128i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f23128i.setAdapter(new u(this));
            this.f23128i.addItemDecoration(m1());
        }
        if (inflate.findViewById(e4.g.f30902t) != null) {
            l1(inflate, oVar);
        }
        if (!com.google.android.material.datepicker.k.r1(contextThemeWrapper)) {
            new androidx.recyclerview.widget.t().attachToRecyclerView(this.f23129j);
        }
        this.f23129j.scrollToPosition(oVar.j(this.f23125f));
        y1();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f23121b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f23122c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f23123d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f23124e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f23125f);
    }

    public Month p1() {
        return this.f23125f;
    }

    public DateSelector<S> q1() {
        return this.f23122c;
    }

    public LinearLayoutManager t1() {
        return (LinearLayoutManager) this.f23129j.getLayoutManager();
    }

    public final void v1(int i10) {
        this.f23129j.post(new b(i10));
    }

    public void w1(Month month) {
        boolean z10;
        o oVar = (o) this.f23129j.getAdapter();
        int j10 = oVar.j(month);
        int j11 = j10 - oVar.j(this.f23125f);
        boolean z11 = false;
        if (Math.abs(j11) > 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (j11 > 0) {
            z11 = true;
        }
        this.f23125f = month;
        if (z10 && z11) {
            this.f23129j.scrollToPosition(j10 - 3);
            v1(j10);
        } else if (z10) {
            this.f23129j.scrollToPosition(j10 + 3);
            v1(j10);
        } else {
            v1(j10);
        }
    }

    public void x1(CalendarSelector calendarSelector) {
        this.f23126g = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f23128i.getLayoutManager().scrollToPosition(((u) this.f23128i.getAdapter()).i(this.f23125f.f23161c));
            this.f23132m.setVisibility(0);
            this.f23133n.setVisibility(8);
            this.f23130k.setVisibility(8);
            this.f23131l.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.f23132m.setVisibility(8);
            this.f23133n.setVisibility(0);
            this.f23130k.setVisibility(0);
            this.f23131l.setVisibility(0);
            w1(this.f23125f);
        }
    }

    public final void y1() {
        K.j0(this.f23129j, new f());
    }

    public void z1() {
        CalendarSelector calendarSelector = this.f23126g;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            x1(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            x1(calendarSelector2);
        }
    }
}
