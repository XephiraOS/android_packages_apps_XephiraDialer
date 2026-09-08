package com.oplus.blacklistapp.activities;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.j;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.couiswitch.COUISwitch;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationBarView;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.activities.PhoneNoInquireForCountryActivity;
import com.oplus.blacklistapp.callintercept.CallInterceptController;
import com.oplus.blacklistapp.n;
import com.oplus.blacklistapp.o;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.s;
import com.oplus.blacklistapp.t;
import com.oplus.blacklistapp.u;
import com.oplus.utils.B;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0861w;
import com.oplus.utils.C0863y;
import com.oplus.utils.InterfaceC0859u;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.T;
import com.oplus.utils.r;
import com.oplus.widget.EditModeHandler;
import com.oplus.widget.MultiChoiceListview;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import v6.C1632f;
import x6.C1681a;
import x6.C1682b;

/* loaded from: classes3.dex */
public class PhoneNoInquireForCountryActivity extends BaseNavigationActivity implements COUIListView.ScrollMultiChoiceListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, CallInterceptController.b, View.OnClickListener {

    /* renamed from: N, reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f26430N;

    /* renamed from: O, reason: collision with root package name */
    public static final ThreadPoolExecutor f26431O;

    /* renamed from: A, reason: collision with root package name */
    public AppBarLayout f26432A;

    /* renamed from: D, reason: collision with root package name */
    public COUIStatusBarResponseUtil f26435D;

    /* renamed from: E, reason: collision with root package name */
    public MenuItem f26436E;

    /* renamed from: F, reason: collision with root package name */
    public MenuItem f26437F;

    /* renamed from: G, reason: collision with root package name */
    public MenuItem f26438G;

    /* renamed from: I, reason: collision with root package name */
    public COUISwitch f26440I;

    /* renamed from: J, reason: collision with root package name */
    public COUICardListSelectedItemLayout f26441J;

    /* renamed from: K, reason: collision with root package name */
    public COUIAlertDialogBuilder f26442K;

    /* renamed from: q, reason: collision with root package name */
    public MultiChoiceListview f26449q;

    /* renamed from: r, reason: collision with root package name */
    public C1682b f26450r;

    /* renamed from: y, reason: collision with root package name */
    public COUIToolbar f26452y;

    /* renamed from: z, reason: collision with root package name */
    public EditModeHandler f26453z;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<C1681a.c> f26445m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    public View f26446n = null;

    /* renamed from: o, reason: collision with root package name */
    public boolean f26447o = false;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem f26448p = null;

    /* renamed from: x, reason: collision with root package name */
    public int f26451x = 0;

    /* renamed from: B, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, C1681a.c> f26433B = new ConcurrentHashMap<>();

    /* renamed from: C, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, C1681a.c> f26434C = new ConcurrentHashMap<>();

    /* renamed from: H, reason: collision with root package name */
    public final Handler f26439H = new Handler(Looper.getMainLooper());

    /* renamed from: L, reason: collision with root package name */
    public final Handler f26443L = new h();

    /* renamed from: M, reason: collision with root package name */
    public final InterfaceC0859u f26444M = new f();

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PhoneNoInquireForCountryActivity.this.f26432A.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = PhoneNoInquireForCountryActivity.this.f26432A.getMeasuredHeight() + PhoneNoInquireForCountryActivity.this.getResources().getDimensionPixelSize(n.f27290o);
            PhoneNoInquireForCountryActivity.this.f26449q.setPadding(0, measuredHeight, 0, PhoneNoInquireForCountryActivity.this.getResources().getDimensionPixelSize(n.f27278c));
            PhoneNoInquireForCountryActivity.this.f26449q.setClipToPadding(false);
            PhoneNoInquireForCountryActivity.this.f26449q.smoothScrollByOffset(-measuredHeight);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1681a.g(PhoneNoInquireForCountryActivity.this);
            C1681a.n(PhoneNoInquireForCountryActivity.this);
            PhoneNoInquireForCountryActivity.this.f26443L.sendEmptyMessage(0);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Toolbar.g {
        public d() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == p.f27330D) {
                if (!BlackListAppUtil.c().a()) {
                    PhoneNoInquireForCountryActivity.this.A1();
                    return true;
                }
                Log.i("PhoneNoInquireForCountryActivity", "Invalid click return --------------");
                return false;
            }
            if (itemId == p.f27400m) {
                PhoneNoInquireForCountryActivity.this.J1();
                return true;
            }
            if (itemId == p.f27380c) {
                PhoneNoInquireForCountryActivity.this.L1();
                return true;
            }
            if (itemId == p.f27327B0) {
                PhoneNoInquireForCountryActivity.this.f26453z.f();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhoneNoInquireForCountryActivity.this.finish();
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
                PhoneNoInquireForCountryActivity.this.finish();
            }
        }

        public f() {
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void a(boolean z10) {
            PhoneNoInquireForCountryActivity.this.f26452y.getMenu().clear();
            if (z10) {
                PhoneNoInquireForCountryActivity.this.f26452y.setNavigationIcon(X8.g.f4850c);
                PhoneNoInquireForCountryActivity.this.f26452y.setNavigationContentDescription(e.h.f30261a);
                PhoneNoInquireForCountryActivity.this.f26452y.setNavigationOnClickListener(new a());
                PhoneNoInquireForCountryActivity.this.f26452y.setIsTitleCenterStyle(false);
                PhoneNoInquireForCountryActivity.this.f26452y.inflateMenu(s.f27478g);
                PhoneNoInquireForCountryActivity phoneNoInquireForCountryActivity = PhoneNoInquireForCountryActivity.this;
                phoneNoInquireForCountryActivity.f26436E = phoneNoInquireForCountryActivity.f26452y.getMenu().findItem(p.f27330D);
                PhoneNoInquireForCountryActivity phoneNoInquireForCountryActivity2 = PhoneNoInquireForCountryActivity.this;
                phoneNoInquireForCountryActivity2.f26437F = phoneNoInquireForCountryActivity2.f26452y.getMenu().findItem(p.f27380c);
                e();
                return;
            }
            PhoneNoInquireForCountryActivity.this.getMenuInflater().inflate(s.f27475d, PhoneNoInquireForCountryActivity.this.f26452y.getMenu());
            PhoneNoInquireForCountryActivity.this.f26452y.setIsTitleCenterStyle(true);
            PhoneNoInquireForCountryActivity.this.f26452y.setNavigationIcon((Drawable) null);
            PhoneNoInquireForCountryActivity phoneNoInquireForCountryActivity3 = PhoneNoInquireForCountryActivity.this;
            phoneNoInquireForCountryActivity3.f26438G = phoneNoInquireForCountryActivity3.f26452y.getMenu().findItem(p.f27327B0);
            d();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void b() {
            a(false);
            if (PhoneNoInquireForCountryActivity.this.f26450r != null) {
                PhoneNoInquireForCountryActivity.this.f26450r.d(true);
                PhoneNoInquireForCountryActivity.this.f26450r.notifyDataSetChanged();
            }
            PhoneNoInquireForCountryActivity.this.f26453z.j(PhoneNoInquireForCountryActivity.this.f26434C);
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void c() {
            a(true);
            PhoneNoInquireForCountryActivity.this.f26436E.setVisible(true);
            PhoneNoInquireForCountryActivity.this.f26437F.setVisible(true);
            PhoneNoInquireForCountryActivity phoneNoInquireForCountryActivity = PhoneNoInquireForCountryActivity.this;
            phoneNoInquireForCountryActivity.f26447o = true;
            phoneNoInquireForCountryActivity.f26450r.d(false);
            PhoneNoInquireForCountryActivity.this.f26450r.notifyDataSetChanged();
            PhoneNoInquireForCountryActivity.this.f26433B.clear();
            PhoneNoInquireForCountryActivity.this.f26453z.n(PhoneNoInquireForCountryActivity.this.f26433B);
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void d() {
            if (PhoneNoInquireForCountryActivity.this.f26452y != null) {
                PhoneNoInquireForCountryActivity.this.f26452y.setTitle(PhoneNoInquireForCountryActivity.this.f26453z.b());
            }
            g();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void e() {
            if (PhoneNoInquireForCountryActivity.this.f26452y != null) {
                PhoneNoInquireForCountryActivity.this.f26452y.setTitle(u.f27667o1);
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void f(boolean z10) {
            if (PhoneNoInquireForCountryActivity.this.f26436E != null) {
                PhoneNoInquireForCountryActivity.this.f26436E.setVisible(z10);
            }
            if (PhoneNoInquireForCountryActivity.this.f26437F != null) {
                PhoneNoInquireForCountryActivity.this.f26437F.setVisible(z10);
            }
        }

        public void g() {
            int c10 = PhoneNoInquireForCountryActivity.this.f26453z.c();
            int count = PhoneNoInquireForCountryActivity.this.f26450r.getCount();
            if (PhoneNoInquireForCountryActivity.this.f26438G != null) {
                if (c10 < count) {
                    PhoneNoInquireForCountryActivity.this.f26438G.setTitle(u.f27562R2);
                } else {
                    PhoneNoInquireForCountryActivity.this.f26438G.setTitle(u.f27644j3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        public final int f26461a;

        public g(int i10) {
            this.f26461a = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -3) {
                new i().execute(new Void[0]);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PhoneNoInquireForCountryActivity.this.removeDialog(this.f26461a);
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<PhoneNoInquireForCountryActivity> f26463a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PhoneNoInquireForCountryActivity phoneNoInquireForCountryActivity = this.f26463a.get();
            C0846g.i("PhoneNoInquireForCountryActivity", "handleMessage");
            if (phoneNoInquireForCountryActivity == null) {
                return;
            }
            phoneNoInquireForCountryActivity.f26445m = new ArrayList<>(C1681a.f38002b);
            C0846g.i("PhoneNoInquireForCountryActivity", "activity.mDatas size is " + phoneNoInquireForCountryActivity.f26445m.size());
            phoneNoInquireForCountryActivity.f26450r.e(phoneNoInquireForCountryActivity.f26445m);
            phoneNoInquireForCountryActivity.f26450r.notifyDataSetChanged();
            phoneNoInquireForCountryActivity.D1(phoneNoInquireForCountryActivity.f26445m);
            boolean z10 = false;
            if (phoneNoInquireForCountryActivity.f26445m.size() <= 0) {
                phoneNoInquireForCountryActivity.f26449q.setVisibility(8);
                phoneNoInquireForCountryActivity.f26264j.setVisibility(0);
            } else {
                phoneNoInquireForCountryActivity.f26449q.setVisibility(0);
                phoneNoInquireForCountryActivity.f26264j.setVisibility(8);
            }
            InterfaceC0859u interfaceC0859u = phoneNoInquireForCountryActivity.f26444M;
            if (phoneNoInquireForCountryActivity.f26445m.size() > 0) {
                z10 = true;
            }
            interfaceC0859u.f(z10);
            StatisticsUtils.b(phoneNoInquireForCountryActivity, String.valueOf(phoneNoInquireForCountryActivity.f26445m.size()));
        }

        public h(PhoneNoInquireForCountryActivity phoneNoInquireForCountryActivity) {
            this.f26463a = new WeakReference<>(phoneNoInquireForCountryActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.b f26464a = null;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PhoneNoInquireForCountryActivity.this.M1();
            }
        }

        public i() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            C1681a.o(PhoneNoInquireForCountryActivity.this.f26433B, PhoneNoInquireForCountryActivity.this);
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r42) {
            androidx.appcompat.app.b bVar = this.f26464a;
            if (bVar != null && bVar.isShowing()) {
                this.f26464a.dismiss();
                this.f26464a = null;
            }
            if (PhoneNoInquireForCountryActivity.this.f26453z.d()) {
                PhoneNoInquireForCountryActivity.this.J1();
            }
            PhoneNoInquireForCountryActivity.this.f26439H.postDelayed(new a(), 350L);
            C0861w.g(PhoneNoInquireForCountryActivity.this.getApplicationContext()).l();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            PhoneNoInquireForCountryActivity phoneNoInquireForCountryActivity = PhoneNoInquireForCountryActivity.this;
            this.f26464a = r.b(phoneNoInquireForCountryActivity, phoneNoInquireForCountryActivity.getString(u.f27584X0));
        }
    }

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        f26430N = linkedBlockingQueue;
        f26431O = new ThreadPoolExecutor(1, 1, 180L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1() {
        boolean z10 = true;
        b1(true);
        K1(false);
        this.f26453z.a();
        R0(true, this.f26449q);
        MenuItem menuItem = this.f26448p;
        if (menuItem != null) {
            if (this.f26433B.size() <= 0) {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
        s0(n0());
    }

    private int B1() {
        return this.f26433B.size();
    }

    private Dialog C1(int i10) {
        int B12 = B1();
        if (this.f26450r.getCount() == 0) {
            return null;
        }
        String format = String.format(getResources().getQuantityString(t.f27487i, B12), Integer.valueOf(B12));
        g gVar = new g(i10);
        COUIAlertDialogBuilder neutralButton = new S8.b(this, X8.n.f5032d).setTitle((CharSequence) format).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) gVar).setNeutralButton(u.f27502C2, (DialogInterface.OnClickListener) gVar);
        this.f26442K = neutralButton;
        androidx.appcompat.app.b create = neutralButton.create();
        create.setOnDismissListener(gVar);
        return create;
    }

    private void F1() {
        this.f26452y.setOnMenuItemClickListener(new d());
        this.f26452y.setNavigationOnClickListener(new e());
        this.f26444M.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean H1(MenuItem menuItem) {
        showDialog(0);
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = this.f26442K;
        if (cOUIAlertDialogBuilder != null) {
            cOUIAlertDialogBuilder.updateViewAfterShown();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1() {
        if (!this.f26453z.d()) {
            return;
        }
        boolean z10 = false;
        b1(false);
        K1(true);
        this.f26453z.e();
        R0(false, this.f26449q);
        MenuItem menuItem = this.f26448p;
        if (menuItem != null) {
            if (this.f26433B.size() > 0) {
                z10 = true;
            }
            menuItem.setEnabled(z10);
        }
        s0(n0());
    }

    private void K1(boolean z10) {
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = this.f26441J;
        if (cOUICardListSelectedItemLayout != null) {
            cOUICardListSelectedItemLayout.setEnabled(z10);
        }
        COUISwitch cOUISwitch = this.f26440I;
        if (cOUISwitch != null) {
            cOUISwitch.setEnabled(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M1() {
        C0846g.i("PhoneNoInquireForCountryActivity", "handleMessage startQueryAsync");
        if (this.f26453z.d()) {
            return;
        }
        f26431O.execute(new c());
    }

    public final void D1(ArrayList<C1681a.c> arrayList) {
        this.f26434C.clear();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            this.f26434C.put(Integer.valueOf(i10), arrayList.get(i10));
        }
    }

    public final void E1(View view) {
        final SharedPreferences b10 = j.b(this);
        boolean C10 = C1632f.C(b10, "harass_intercept_attribution", 3, this.f26451x);
        C0846g.i("PhoneNoInquireForCountryActivity", this.f26451x + "-refresh-isHarassInterceptAttribution : " + C10);
        COUISwitch cOUISwitch = (COUISwitch) view.findViewById(p.f27416u);
        this.f26440I = cOUISwitch;
        cOUISwitch.setChecked(C10);
        this.f26450r.f(C10);
        this.f26440I.setTactileFeedbackEnabled(true);
        ((TextView) view.findViewById(p.f27351N0)).setText(u.f27667o1);
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view.findViewById(p.f27349M0);
        this.f26441J = cOUICardListSelectedItemLayout;
        cOUICardListSelectedItemLayout.setOnClickListener(new View.OnClickListener() { // from class: p6.A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PhoneNoInquireForCountryActivity.this.G1(b10, view2);
            }
        });
    }

    public final /* synthetic */ void G1(SharedPreferences sharedPreferences, View view) {
        boolean z10 = !this.f26440I.isChecked();
        com.oplus.blacklistapp.callintercept.settings.u.d(sharedPreferences, this.f26451x, "harass_intercept_attribution", z10, 3);
        this.f26440I.setChecked(z10);
        this.f26440I.setTactileFeedbackEnabled(true);
        this.f26450r.f(z10);
        this.f26450r.notifyDataSetChanged();
    }

    public final void L1() {
        Intent intent = new Intent(this, (Class<?>) PhoneNoInquireForCountrySelectActivity.class);
        intent.putExtra("slotId", this.f26451x);
        intent.putExtra("is_single_sim", C0863y.a(getIntent(), "is_single_sim", false));
        C0849j.A(this, intent);
        overridePendingTransition(com.oplus.blacklistapp.i.f27263e, com.oplus.blacklistapp.i.f27264f);
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity
    public void O0() {
        boolean z10;
        super.O0();
        this.f26263i.inflateMenu(s.f27474c);
        MenuItem findItem = this.f26263i.getMenu().findItem(p.f27422x);
        this.f26448p = findItem;
        if (findItem != null) {
            findItem.setTitle(u.f27502C2);
            MenuItem menuItem = this.f26448p;
            if (this.f26433B.size() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
        this.f26263i.setOnItemSelectedListener(new NavigationBarView.c() { // from class: p6.y
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean onNavigationItemSelected(MenuItem menuItem2) {
                boolean H12;
                H12 = PhoneNoInquireForCountryActivity.this.H1(menuItem2);
                return H12;
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        int i10;
        Intent intent = new Intent();
        C1682b c1682b = this.f26450r;
        if (c1682b != null) {
            i10 = c1682b.getCount();
        } else {
            i10 = 0;
        }
        intent.putExtra("area_count", i10);
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean n0() {
        EditModeHandler editModeHandler = this.f26453z;
        if (editModeHandler != null) {
            return editModeHandler.d();
        }
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f26453z.d()) {
            J1();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        L1();
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity, com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        setContentView(com.oplus.blacklistapp.r.f27440L);
        this.f26452y = (COUIToolbar) findViewById(p.f27363T0);
        F1();
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(p.f27376a);
        this.f26432A = appBarLayout;
        appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.f26449q = (MultiChoiceListview) findViewById(p.f27360S);
        View inflate = layoutInflater.inflate(com.oplus.blacklistapp.r.f27450e, (ViewGroup) null);
        this.f26446n = inflate;
        this.f26449q.addHeaderView(inflate);
        this.f26449q.setVerticalFadingEdgeEnabled(false);
        this.f26449q.setOnItemClickListener(this);
        this.f26449q.setOnItemLongClickListener(this);
        this.f26449q.setChoiceMode(2);
        this.f26449q.setScrollMultiChoiceListener(this);
        this.f26449q.setNestedScrollingEnabled(true);
        this.f26449q.setMultiChoiceListener(new MultiChoiceListview.a() { // from class: p6.z
            @Override // com.oplus.widget.MultiChoiceListview.a
            public final void a() {
                PhoneNoInquireForCountryActivity.I1();
            }
        });
        C1682b c1682b = new C1682b(this, false);
        this.f26450r = c1682b;
        this.f26449q.setAdapter((ListAdapter) c1682b);
        N0(o.f27316s, u.f27553P1, Integer.valueOf(u.f27557Q1), this);
        b bVar = new b();
        this.f26444M.e();
        if (this.f26453z == null) {
            this.f26453z = new EditModeHandler(this, this.f26450r, this.f26444M, bVar, EditModeHandler.Mode.INTERCEPT_BY_COUNTRY_MODE);
        }
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f26435D = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        Intent intent = getIntent();
        this.f26451x = C0863y.b(intent, "slotId", 0);
        boolean a10 = C0863y.a(intent, "is_single_sim", false);
        C1681a.r(this.f26451x);
        StatisticsUtils.c(this, "attribution_setting_entry", a10, this.f26451x);
        E1(this.f26446n);
        CallInterceptController.e().d(this);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        if (i10 == 0) {
            return C1(i10);
        }
        return null;
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        StatisticsUtils.e(this, "attribution_setting_back");
        CallInterceptController.e().m(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        EditModeHandler editModeHandler = this.f26453z;
        if (editModeHandler != null && editModeHandler.d()) {
            int headerViewsCount = i10 - this.f26449q.getHeaderViewsCount();
            C1682b c1682b = this.f26450r;
            boolean z10 = true;
            if (c1682b != null) {
                C1681a.c item = c1682b.getItem(headerViewsCount);
                if (item != null) {
                    item.f38015d = !item.f38015d;
                    C1681a.s(item);
                }
                if (this.f26433B.containsKey(Integer.valueOf(headerViewsCount))) {
                    this.f26433B.remove(Integer.valueOf(headerViewsCount));
                } else if (item != null) {
                    this.f26433B.put(Integer.valueOf(headerViewsCount), item);
                }
            }
            this.f26453z.n(this.f26433B);
            this.f26444M.d();
            C1682b c1682b2 = this.f26450r;
            if (c1682b2 != null) {
                c1682b2.g(this.f26433B);
                this.f26450r.notifyDataSetChanged();
            }
            MenuItem menuItem = this.f26448p;
            if (menuItem != null) {
                if (this.f26433B.size() <= 0) {
                    z10 = false;
                }
                menuItem.setEnabled(z10);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        EditModeHandler editModeHandler = this.f26453z;
        boolean z10 = false;
        if (editModeHandler != null && editModeHandler.d()) {
            return false;
        }
        int headerViewsCount = i10 - this.f26449q.getHeaderViewsCount();
        C1682b c1682b = this.f26450r;
        if (c1682b != null) {
            C1681a.c item = c1682b.getItem(headerViewsCount);
            if (item != null) {
                this.f26433B.put(Integer.valueOf(headerViewsCount), item);
            }
            this.f26450r.g(this.f26433B);
        }
        if (this.f26453z != null) {
            A1();
            this.f26453z.n(this.f26433B);
            this.f26444M.d();
        }
        C1682b c1682b2 = this.f26450r;
        if (c1682b2 != null) {
            c1682b2.notifyDataSetChanged();
        }
        MenuItem menuItem = this.f26448p;
        if (menuItem != null) {
            if (this.f26433B.size() > 0) {
                z10 = true;
            }
            menuItem.setEnabled(z10);
        }
        return true;
    }

    @Override // com.coui.appcompat.list.COUIListView.ScrollMultiChoiceListener
    public void onItemTouch(int i10, View view) {
        EditModeHandler editModeHandler;
        boolean z10;
        if (view != null && (editModeHandler = this.f26453z) != null && editModeHandler.d()) {
            int headerViewsCount = i10 - this.f26449q.getHeaderViewsCount();
            C1682b c1682b = this.f26450r;
            if (c1682b != null) {
                C1681a.c item = c1682b.getItem(headerViewsCount);
                if (this.f26433B.containsKey(Integer.valueOf(headerViewsCount))) {
                    this.f26433B.remove(Integer.valueOf(headerViewsCount));
                } else if (item != null) {
                    this.f26433B.put(Integer.valueOf(headerViewsCount), item);
                }
            }
            this.f26453z.n(this.f26433B);
            this.f26444M.d();
            C1682b c1682b2 = this.f26450r;
            if (c1682b2 != null) {
                c1682b2.g(this.f26433B);
                this.f26450r.notifyDataSetChanged();
            }
            MenuItem menuItem = this.f26448p;
            if (menuItem != null) {
                if (this.f26433B.size() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                menuItem.setEnabled(z10);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f26435D.onPause();
        T.c();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f26435D.onResume();
        this.f26447o = false;
        M1();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        T.e(this, this.f26449q);
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void u(int i10) {
        C0846g.i("PhoneNoInquireForCountryActivity", "handleHotPlugOut slot = " + i10);
        finish();
    }

    /* loaded from: classes3.dex */
    public class b implements B {
        public b() {
        }

        @Override // com.oplus.utils.B
        public void b() {
            MenuItem menuItem = PhoneNoInquireForCountryActivity.this.f26448p;
            if (menuItem != null) {
                menuItem.setEnabled(true);
            }
            PhoneNoInquireForCountryActivity.this.f26433B.clear();
            PhoneNoInquireForCountryActivity.this.f26433B.putAll(PhoneNoInquireForCountryActivity.this.f26434C);
            PhoneNoInquireForCountryActivity.this.f26450r.g(PhoneNoInquireForCountryActivity.this.f26433B);
            PhoneNoInquireForCountryActivity.this.f26450r.e(PhoneNoInquireForCountryActivity.this.f26445m);
        }

        @Override // com.oplus.utils.B
        public void c() {
            MenuItem menuItem = PhoneNoInquireForCountryActivity.this.f26448p;
            if (menuItem != null) {
                menuItem.setEnabled(false);
            }
            PhoneNoInquireForCountryActivity.this.f26433B.clear();
            PhoneNoInquireForCountryActivity.this.f26450r.g(PhoneNoInquireForCountryActivity.this.f26433B);
            PhoneNoInquireForCountryActivity.this.f26450r.e(PhoneNoInquireForCountryActivity.this.f26445m);
        }

        @Override // com.oplus.utils.B
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I1() {
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void P0(int i10) {
    }
}
