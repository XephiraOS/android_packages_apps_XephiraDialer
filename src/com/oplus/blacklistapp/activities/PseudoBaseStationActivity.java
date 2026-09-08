package com.oplus.blacklistapp.activities;

import android.R;
import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.appcompat.widget.Toolbar;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationBarView;
import com.oplus.blacklist.database.a;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.activities.PseudoBaseStationActivity;
import com.oplus.blacklistapp.n;
import com.oplus.blacklistapp.o;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.blacklistapp.s;
import com.oplus.blacklistapp.u;
import com.oplus.utils.B;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0861w;
import com.oplus.utils.InterfaceC0851l;
import com.oplus.utils.InterfaceC0859u;
import com.oplus.utils.L;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.T;
import com.oplus.utils.Z;
import com.oplus.widget.EditModeHandler;
import com.oplus.widget.MultiChoiceListview;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.concurrent.ConcurrentHashMap;
import l8.C1297a;

/* loaded from: classes3.dex */
public class PseudoBaseStationActivity extends BaseNavigationActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, COUIListView.ScrollMultiChoiceListener {

    /* renamed from: A, reason: collision with root package name */
    public EditModeHandler f26508A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem f26509B;

    /* renamed from: C, reason: collision with root package name */
    public int f26510C;

    /* renamed from: D, reason: collision with root package name */
    public int f26511D;

    /* renamed from: E, reason: collision with root package name */
    public AppBarLayout f26512E;

    /* renamed from: H, reason: collision with root package name */
    public COUIStatusBarResponseUtil f26515H;

    /* renamed from: I, reason: collision with root package name */
    public MenuItem f26516I;

    /* renamed from: J, reason: collision with root package name */
    public MenuItem f26517J;

    /* renamed from: n, reason: collision with root package name */
    public C1297a f26521n;

    /* renamed from: o, reason: collision with root package name */
    public MultiChoiceListview f26522o;

    /* renamed from: p, reason: collision with root package name */
    public g f26523p;

    /* renamed from: x, reason: collision with root package name */
    public View f26526x;

    /* renamed from: y, reason: collision with root package name */
    public int f26527y;

    /* renamed from: z, reason: collision with root package name */
    public COUIToolbar f26528z;

    /* renamed from: m, reason: collision with root package name */
    public final Object f26520m = new Object();

    /* renamed from: q, reason: collision with root package name */
    public View f26524q = null;

    /* renamed from: r, reason: collision with root package name */
    public h f26525r = null;

    /* renamed from: F, reason: collision with root package name */
    public final ConcurrentHashMap<Long, String> f26513F = new ConcurrentHashMap<>();

    /* renamed from: G, reason: collision with root package name */
    public final ConcurrentHashMap<Long, String> f26514G = new ConcurrentHashMap<>();

    /* renamed from: K, reason: collision with root package name */
    public final InterfaceC0851l f26518K = new InterfaceC0851l() { // from class: p6.G
        @Override // com.oplus.utils.InterfaceC0851l
        public final void onCancel() {
            PseudoBaseStationActivity.this.M1();
        }
    };

    /* renamed from: L, reason: collision with root package name */
    public final InterfaceC0859u f26519L = new f();

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PseudoBaseStationActivity.this.f26512E.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = PseudoBaseStationActivity.this.f26512E.getMeasuredHeight();
            PseudoBaseStationActivity.this.f26522o.setPadding(0, measuredHeight, 0, PseudoBaseStationActivity.this.getResources().getDimensionPixelSize(n.f27278c));
            PseudoBaseStationActivity.this.f26522o.setClipToPadding(false);
            PseudoBaseStationActivity.this.f26522o.smoothScrollByOffset(-measuredHeight);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends DataSetObserver {
        public c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            try {
                synchronized (PseudoBaseStationActivity.this.f26520m) {
                    PseudoBaseStationActivity.this.V1();
                }
            } catch (Exception e10) {
                Log.e("PseudoBaseStation", "Exception e" + e10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f26532a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f26533b;

        public d(FrameLayout.LayoutParams layoutParams, ViewGroup viewGroup) {
            this.f26532a = layoutParams;
            this.f26533b = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (PseudoBaseStationActivity.this.f26526x != null) {
                return;
            }
            PseudoBaseStationActivity.this.f26528z.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            PseudoBaseStationActivity pseudoBaseStationActivity = PseudoBaseStationActivity.this;
            pseudoBaseStationActivity.f26510C = pseudoBaseStationActivity.f26528z.getMeasuredHeight();
            if (C0846g.c()) {
                Log.d("PseudoBaseStation", "onGlobalLayout mToolBarHeight = " + PseudoBaseStationActivity.this.f26510C + " ,mFakeStationCount = " + PseudoBaseStationActivity.this.f26511D);
            }
            if (PseudoBaseStationActivity.this.f26511D == 0) {
                this.f26532a.topMargin = PseudoBaseStationActivity.this.f26510C;
                PseudoBaseStationActivity pseudoBaseStationActivity2 = PseudoBaseStationActivity.this;
                pseudoBaseStationActivity2.f26526x = pseudoBaseStationActivity2.getLayoutInflater().inflate(r.f27465t, (ViewGroup) null);
                this.f26533b.addView(PseudoBaseStationActivity.this.f26526x, 1, this.f26532a);
                PseudoBaseStationActivity.this.S1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PseudoBaseStationActivity.this.f26526x.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            PseudoBaseStationActivity pseudoBaseStationActivity = PseudoBaseStationActivity.this;
            pseudoBaseStationActivity.Q0(pseudoBaseStationActivity.f26526x.getMeasuredHeight());
        }
    }

    /* loaded from: classes3.dex */
    public class f implements InterfaceC0859u {

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PseudoBaseStationActivity.this.finish();
            }
        }

        public f() {
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void a(boolean z10) {
            PseudoBaseStationActivity.this.f26528z.getMenu().clear();
            if (z10) {
                PseudoBaseStationActivity.this.f26528z.setNavigationIcon(X8.g.f4850c);
                PseudoBaseStationActivity.this.f26528z.setNavigationContentDescription(e.h.f30261a);
                PseudoBaseStationActivity.this.f26528z.setNavigationOnClickListener(new a());
                PseudoBaseStationActivity.this.f26528z.setIsTitleCenterStyle(false);
                PseudoBaseStationActivity.this.f26528z.inflateMenu(s.f27478g);
                PseudoBaseStationActivity pseudoBaseStationActivity = PseudoBaseStationActivity.this;
                pseudoBaseStationActivity.f26516I = pseudoBaseStationActivity.f26528z.getMenu().findItem(p.f27330D);
                PseudoBaseStationActivity.this.f26528z.getMenu().findItem(p.f27380c).setVisible(false);
                e();
                return;
            }
            PseudoBaseStationActivity.this.getMenuInflater().inflate(s.f27475d, PseudoBaseStationActivity.this.f26528z.getMenu());
            PseudoBaseStationActivity.this.f26528z.setIsTitleCenterStyle(true);
            PseudoBaseStationActivity.this.f26528z.setNavigationIcon((Drawable) null);
            PseudoBaseStationActivity pseudoBaseStationActivity2 = PseudoBaseStationActivity.this;
            pseudoBaseStationActivity2.f26517J = pseudoBaseStationActivity2.f26528z.getMenu().findItem(p.f27327B0);
            d();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void b() {
            a(false);
            PseudoBaseStationActivity.this.f26521n.h(true);
            PseudoBaseStationActivity.this.f26521n.notifyDataSetChanged();
            if (PseudoBaseStationActivity.this.f26509B != null) {
                PseudoBaseStationActivity.this.f26509B.setEnabled(false);
            }
            PseudoBaseStationActivity.this.f26508A.o(PseudoBaseStationActivity.this.f26513F);
            PseudoBaseStationActivity.this.f26508A.k(PseudoBaseStationActivity.this.f26514G);
            d();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void c() {
            a(true);
            PseudoBaseStationActivity.this.f26516I.setVisible(true);
            PseudoBaseStationActivity.this.f26521n.h(false);
            PseudoBaseStationActivity.this.f26521n.notifyDataSetChanged();
            PseudoBaseStationActivity.this.T1();
            PseudoBaseStationActivity.this.f26513F.clear();
            PseudoBaseStationActivity.this.f26508A.o(PseudoBaseStationActivity.this.f26513F);
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void d() {
            if (PseudoBaseStationActivity.this.f26528z != null) {
                PseudoBaseStationActivity.this.f26528z.setTitle(PseudoBaseStationActivity.this.f26508A.b());
            }
            g();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void e() {
            if (PseudoBaseStationActivity.this.f26528z != null) {
                PseudoBaseStationActivity.this.f26528z.setTitle(u.f27708w2);
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void f(boolean z10) {
            PseudoBaseStationActivity.this.f26516I.setVisible(z10);
        }

        public void g() {
            int c10 = PseudoBaseStationActivity.this.f26508A.c();
            int count = PseudoBaseStationActivity.this.f26521n.getCount();
            if (PseudoBaseStationActivity.this.f26517J != null) {
                if (c10 < count) {
                    PseudoBaseStationActivity.this.f26517J.setTitle(u.f27562R2);
                } else {
                    PseudoBaseStationActivity.this.f26517J.setTitle(u.f27644j3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends AsyncQueryHandler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<PseudoBaseStationActivity> f26538a;

        public g(PseudoBaseStationActivity pseudoBaseStationActivity) {
            super(pseudoBaseStationActivity.getContentResolver());
            this.f26538a = new WeakReference<>(pseudoBaseStationActivity);
        }

        @Override // android.content.AsyncQueryHandler
        public void onDeleteComplete(int i10, Object obj, int i11) {
            PseudoBaseStationActivity pseudoBaseStationActivity = this.f26538a.get();
            if (pseudoBaseStationActivity != null) {
                pseudoBaseStationActivity.Q1();
                pseudoBaseStationActivity.T1();
            }
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i10, Object obj, Cursor cursor) {
            PseudoBaseStationActivity pseudoBaseStationActivity = this.f26538a.get();
            if (pseudoBaseStationActivity == null) {
                return;
            }
            try {
                boolean z10 = false;
                pseudoBaseStationActivity.f26521n.j(false);
                pseudoBaseStationActivity.H1(cursor);
                pseudoBaseStationActivity.f26521n.changeCursor(cursor);
                pseudoBaseStationActivity.f26521n.notifyDataSetChanged();
                pseudoBaseStationActivity.Q1();
                if (cursor != null && !cursor.isClosed()) {
                    int count = cursor.getCount();
                    if (count <= 0) {
                        pseudoBaseStationActivity.f26522o.setVisibility(8);
                        pseudoBaseStationActivity.f26264j.setVisibility(0);
                    } else {
                        pseudoBaseStationActivity.f26522o.setVisibility(0);
                        pseudoBaseStationActivity.f26264j.setVisibility(8);
                    }
                    InterfaceC0859u interfaceC0859u = pseudoBaseStationActivity.f26519L;
                    if (count > 0) {
                        z10 = true;
                    }
                    interfaceC0859u.f(z10);
                }
            } catch (Exception e10) {
                Log.e("PseudoBaseStation", "e = " + e10);
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        @Override // android.content.AsyncQueryHandler
        public void onUpdateComplete(int i10, Object obj, int i11) {
            super.onUpdateComplete(i10, obj, i11);
        }
    }

    /* loaded from: classes3.dex */
    public class h extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.b f26539a;

        /* renamed from: b, reason: collision with root package name */
        public int f26540b;

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            StringBuilder sb = new StringBuilder();
            for (Long l10 : PseudoBaseStationActivity.this.f26513F.keySet()) {
                l10.longValue();
                String str = (String) PseudoBaseStationActivity.this.f26513F.get(l10);
                sb.append(",'");
                sb.append(str);
                sb.append("'");
                int i10 = this.f26540b + 1;
                this.f26540b = i10;
                if (i10 >= 200 || i10 >= PseudoBaseStationActivity.this.f26513F.size()) {
                    this.f26540b = 0;
                    try {
                        if (C0846g.c()) {
                            Log.d("PseudoBaseStation", "delete selection =" + C0846g.g(sb.toString()));
                        }
                        if (sb.length() > 0) {
                            String substring = sb.substring(1);
                            PseudoBaseStationActivity.this.getContentResolver().delete(a.e.f26238a, "station_name IN (" + substring + ")", null);
                            sb.setLength(0);
                        }
                    } catch (Exception e10) {
                        Log.e("PseudoBaseStation", "delete base station failed" + e10);
                    }
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r42) {
            try {
                this.f26539a.dismiss();
                this.f26539a = null;
            } catch (Exception e10) {
                Log.e("PseudoBaseStation", "e = " + e10);
            }
            PseudoBaseStationActivity.this.f26525r = null;
            PseudoBaseStationActivity.this.P1();
            C0861w.g(PseudoBaseStationActivity.this.getApplicationContext()).l();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            PseudoBaseStationActivity pseudoBaseStationActivity = PseudoBaseStationActivity.this;
            this.f26539a = com.oplus.utils.r.b(pseudoBaseStationActivity, pseudoBaseStationActivity.getString(u.f27584X0));
        }

        public h() {
            this.f26540b = 0;
        }
    }

    private void G1() {
        boolean z10 = true;
        b1(true);
        this.f26508A.a();
        R0(true, this.f26522o);
        MenuItem menuItem = this.f26509B;
        if (menuItem != null) {
            if (this.f26513F.size() <= 0) {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
        s0(n0());
    }

    private void I1() {
        this.f26528z.setOnMenuItemClickListener(new Toolbar.g() { // from class: p6.H
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean K12;
                K12 = PseudoBaseStationActivity.this.K1(menuItem);
                return K12;
            }
        });
        this.f26528z.setNavigationOnClickListener(new View.OnClickListener() { // from class: p6.I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PseudoBaseStationActivity.this.L1(view);
            }
        });
        this.f26519L.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean K1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == p.f27330D) {
            if (BlackListAppUtil.c().a()) {
                Log.i("PseudoBaseStation", "Invalid click return --------------");
                return false;
            }
            G1();
            return true;
        }
        if (itemId == p.f27400m) {
            P1();
            return true;
        }
        if (itemId == p.f27327B0) {
            this.f26508A.f();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1() {
        if (!this.f26508A.d()) {
            return;
        }
        boolean z10 = false;
        b1(false);
        this.f26508A.e();
        R0(false, this.f26522o);
        MenuItem menuItem = this.f26509B;
        if (menuItem != null) {
            if (this.f26513F.size() > 0) {
                z10 = true;
            }
            menuItem.setEnabled(z10);
        }
        s0(n0());
    }

    public final void H1(Cursor cursor) {
        try {
            try {
                this.f26514G.clear();
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    this.f26514G.put(Long.valueOf(cursor.getLong(0)), cursor.getString(2));
                }
            } catch (Exception e10) {
                Log.e("PseudoBaseStation", "e = " + e10);
            }
        } finally {
            cursor.moveToPosition(-1);
        }
    }

    public final /* synthetic */ boolean J1(MenuItem menuItem) {
        if (this.f26525r == null) {
            h hVar = new h();
            this.f26525r = hVar;
            hVar.execute(new Void[0]);
        }
        return false;
    }

    public final /* synthetic */ void N1(String[] strArr) {
        requestPermissions(strArr, 1);
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity
    public void O0() {
        boolean z10;
        super.O0();
        this.f26263i.inflateMenu(s.f27474c);
        MenuItem findItem = this.f26263i.getMenu().findItem(p.f27422x);
        this.f26509B = findItem;
        if (findItem != null) {
            findItem.setTitle(u.f27508E0);
            MenuItem menuItem = this.f26509B;
            if (this.f26513F.size() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
        this.f26263i.setOnItemSelectedListener(new NavigationBarView.c() { // from class: p6.K
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean onNavigationItemSelected(MenuItem menuItem2) {
                boolean J12;
                J12 = PseudoBaseStationActivity.this.J1(menuItem2);
                return J12;
            }
        });
    }

    public final void O1() {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("is_read", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
        this.f26523p.startUpdate(52, null, a.e.f26238a, contentValues, "is_read != 0", null);
    }

    public final void Q1() {
        if (this.f26521n.getCount() == 0 && this.f26521n.f()) {
            P1();
        }
    }

    public final void R1() {
        final String[] f10 = L.f(this);
        if (f10 != null) {
            AppBarLayout appBarLayout = this.f26512E;
            if (appBarLayout != null) {
                appBarLayout.postDelayed(new Runnable() { // from class: p6.J
                    @Override // java.lang.Runnable
                    public final void run() {
                        PseudoBaseStationActivity.this.N1(f10);
                    }
                }, 500L);
            }
        } else {
            androidx.appcompat.app.b bVar = L.f29055a;
            if (bVar != null && bVar.isShowing()) {
                L.f29055a.dismiss();
                L.f29055a = null;
            }
        }
        if (f10 == null) {
            M1();
        }
    }

    public final void S1() {
        View view = this.f26526x;
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            if (C0846g.c()) {
                Log.i("PseudoBaseStation", "resetEmptyTopMargin height=" + measuredHeight);
            }
            if (measuredHeight > 0) {
                Q0(measuredHeight);
            } else {
                this.f26526x.getViewTreeObserver().addOnGlobalLayoutListener(new e());
            }
        }
    }

    public void T1() {
        this.f26521n.j(false);
        this.f26523p.cancelOperation(51);
        this.f26523p.startQuery(51, null, com.oplus.blacklist.database.a.f26234c, null, null, null, "date DESC");
    }

    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public final void M1() {
        T1();
        C0861w.g(getApplicationContext()).k();
    }

    public final void V1() {
        View view;
        C1297a c1297a = this.f26521n;
        if (c1297a == null) {
            return;
        }
        this.f26511D = c1297a.getCount();
        if (C0846g.c()) {
            Log.d("PseudoBaseStation", "updateHeaderView count = " + this.f26511D + " ,mPreCount = " + this.f26527y);
        }
        if (this.f26511D > 0) {
            if (this.f26522o.getHeaderViewsCount() == 0 && this.f26526x != null) {
                ((ViewGroup) this.f26512E.getParent()).removeViewInLayout(this.f26526x);
                this.f26526x = null;
            }
            if (this.f26526x == null) {
                View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(r.f27465t, (ViewGroup) null);
                this.f26526x = inflate;
                this.f26522o.addHeaderView(inflate, null, false);
            }
            if (this.f26524q == null) {
                View inflate2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(r.f27467v, (ViewGroup) null);
                this.f26524q = inflate2;
                this.f26522o.addHeaderView(inflate2, null, false);
            }
        } else {
            View view2 = this.f26524q;
            if (view2 != null) {
                this.f26522o.removeHeaderView(view2);
                this.f26524q = null;
            }
            if (this.f26522o.getHeaderViewsCount() > 0 && (view = this.f26526x) != null) {
                this.f26522o.removeHeaderView(view);
                this.f26526x = null;
            }
            if (this.f26512E.getParent() != null && this.f26526x == null) {
                ViewGroup viewGroup = (ViewGroup) this.f26512E.getParent();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 48;
                int i10 = this.f26510C;
                if (i10 == 0) {
                    this.f26528z.getViewTreeObserver().addOnGlobalLayoutListener(new d(layoutParams, viewGroup));
                } else {
                    layoutParams.topMargin = i10;
                    View inflate3 = getLayoutInflater().inflate(r.f27465t, (ViewGroup) null);
                    this.f26526x = inflate3;
                    viewGroup.addView(inflate3, 1, layoutParams);
                    S1();
                }
            }
        }
        this.f26527y = this.f26511D;
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean m0() {
        return false;
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean n0() {
        EditModeHandler editModeHandler = this.f26508A;
        if (editModeHandler != null) {
            return editModeHandler.d();
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 10 && !isFinishing()) {
            String[] f10 = L.f(this);
            if (f10 != null && f10.length > 0) {
                for (String str : f10) {
                    if (checkSelfPermission(str) != 0) {
                        if (f10.length == 1 && L.k(f10, "android.permission.READ_MEDIA_AUDIO")) {
                            Log.i("PseudoBaseStation", "no need to request because requestLocationPermission() do it");
                            return;
                        } else {
                            requestPermissions(f10, 1);
                            return;
                        }
                    }
                }
                L.q(this, f10, this.f26518K);
                return;
            }
            M1();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f26508A.d()) {
            P1();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity, com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.f27431C);
        this.f26528z = (COUIToolbar) findViewById(p.f27363T0);
        I1();
        MultiChoiceListview multiChoiceListview = (MultiChoiceListview) findViewById(R.id.list);
        this.f26522o = multiChoiceListview;
        multiChoiceListview.setChoiceMode(2);
        this.f26522o.setDivider(null);
        this.f26522o.setVerticalFadingEdgeEnabled(false);
        this.f26522o.setOnItemClickListener(this);
        this.f26522o.setOnItemLongClickListener(this);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(r.f27465t, (ViewGroup) null);
        this.f26526x = inflate;
        this.f26522o.addHeaderView(inflate, null, false);
        C1297a c1297a = new C1297a(this);
        this.f26521n = c1297a;
        this.f26522o.setAdapter((ListAdapter) c1297a);
        a aVar = new a();
        if (this.f26508A == null) {
            this.f26508A = new EditModeHandler(this, this.f26521n, this.f26519L, aVar, EditModeHandler.Mode.FAKE_STATION_MODE);
        }
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(p.f27376a);
        this.f26512E = appBarLayout;
        appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.f26522o.setNestedScrollingEnabled(true);
        this.f26522o.setScrollMultiChoiceListener(this);
        this.f26521n.registerDataSetObserver(new c());
        N0(o.f27320w, u.f27581W1, null, null);
        this.f26523p = new g(this);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f26515H = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Cursor cursor;
        super.onDestroy();
        L.i();
        C1297a c1297a = this.f26521n;
        if (c1297a != null && (cursor = c1297a.getCursor()) != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        CheckBox checkBox;
        if (!this.f26508A.d() || (checkBox = (CheckBox) view.findViewById(p.f27370X)) == null) {
            return;
        }
        boolean z10 = true;
        boolean z11 = !checkBox.isChecked();
        checkBox.setChecked(z11);
        Z.a(view, z11);
        int headerViewsCount = i10 - this.f26522o.getHeaderViewsCount();
        Cursor cursor = this.f26521n.getCursor();
        cursor.moveToPosition(headerViewsCount);
        long j11 = cursor.getLong(0);
        String string = cursor.getString(2);
        if (this.f26513F.containsKey(Long.valueOf(j11))) {
            this.f26513F.remove(Long.valueOf(j11));
        } else {
            this.f26513F.put(Long.valueOf(j11), string);
        }
        this.f26508A.o(this.f26513F);
        this.f26519L.d();
        this.f26521n.k(this.f26513F);
        MenuItem menuItem = this.f26509B;
        if (menuItem != null) {
            if (this.f26513F.size() <= 0) {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        if (this.f26508A.d()) {
            return false;
        }
        int headerViewsCount = i10 - this.f26522o.getHeaderViewsCount();
        Cursor cursor = this.f26521n.getCursor();
        cursor.moveToPosition(headerViewsCount);
        long j11 = cursor.getLong(0);
        this.f26513F.put(Long.valueOf(j11), cursor.getString(2));
        this.f26521n.k(this.f26513F);
        G1();
        return true;
    }

    @Override // com.coui.appcompat.list.COUIListView.ScrollMultiChoiceListener
    public void onItemTouch(int i10, View view) {
        EditModeHandler editModeHandler;
        CheckBox checkBox;
        if (view == null || (editModeHandler = this.f26508A) == null || !editModeHandler.d() || (checkBox = (CheckBox) view.findViewById(p.f27370X)) == null) {
            return;
        }
        boolean z10 = true;
        boolean z11 = !checkBox.isChecked();
        checkBox.setChecked(z11);
        Z.a(view, z11);
        int headerViewsCount = i10 - this.f26522o.getHeaderViewsCount();
        Cursor cursor = this.f26521n.getCursor();
        cursor.moveToPosition(headerViewsCount);
        long j10 = cursor.getLong(0);
        String string = cursor.getString(2);
        if (this.f26513F.containsKey(Long.valueOf(j10))) {
            this.f26513F.remove(Long.valueOf(j10));
        } else {
            this.f26513F.put(Long.valueOf(j10), string);
        }
        this.f26508A.o(this.f26513F);
        this.f26519L.d();
        MenuItem menuItem = this.f26509B;
        if (menuItem != null) {
            if (this.f26513F.size() <= 0) {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        O1();
        this.f26515H.onPause();
        T.c();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean z10;
        int i10;
        super.onPrepareOptionsMenu(menu);
        C1297a c1297a = this.f26521n;
        if (c1297a != null && c1297a.getCount() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        MenuItem findItem = menu.findItem(p.f27330D);
        if (findItem != null) {
            findItem.setEnabled(z10);
            if (z10) {
                i10 = u.f27558Q2;
            } else {
                i10 = u.f27601b0;
            }
            findItem.setTitle(i10);
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        String[] f10 = L.f(this);
        if (!L.j(iArr)) {
            if (f10 != null && f10.length > 0) {
                L.q(this, f10, this.f26518K);
                return;
            }
            return;
        }
        if (f10 == null || f10.length < 1) {
            M1();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C0846g.i("PseudoBaseStation", "--onResume--");
        this.f26515H.onResume();
        C1297a c1297a = this.f26521n;
        if (c1297a != null) {
            c1297a.g();
            this.f26521n.i(DateFormat.getDateInstance(3));
            this.f26521n.l(android.text.format.DateFormat.getTimeFormat(this));
        }
        StatisticsUtils.a(this, 2010801, 201080010, null, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        androidx.appcompat.app.b bVar = L.f29055a;
        if (bVar == null || !bVar.isShowing()) {
            R1();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        T.e(this, this.f26522o);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* loaded from: classes3.dex */
    public class a implements B {
        public a() {
        }

        @Override // com.oplus.utils.B
        public void b() {
            PseudoBaseStationActivity.this.f26513F.clear();
            PseudoBaseStationActivity.this.f26513F.putAll(PseudoBaseStationActivity.this.f26514G);
            PseudoBaseStationActivity.this.f26521n.k(PseudoBaseStationActivity.this.f26513F);
            if (PseudoBaseStationActivity.this.f26509B != null) {
                PseudoBaseStationActivity.this.f26509B.setEnabled(true);
            }
        }

        @Override // com.oplus.utils.B
        public void c() {
            PseudoBaseStationActivity.this.f26513F.clear();
            PseudoBaseStationActivity.this.f26521n.k(PseudoBaseStationActivity.this.f26513F);
            if (PseudoBaseStationActivity.this.f26509B != null) {
                PseudoBaseStationActivity.this.f26509B.setEnabled(false);
            }
        }

        @Override // com.oplus.utils.B
        public void a() {
        }
    }
}
