package com.oplus.blacklistapp.activities;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.widget.Toolbar;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.blacklistapp.activities.PhoneNoInquireForCountrySelectActivity;
import com.oplus.blacklistapp.callintercept.CallInterceptController;
import com.oplus.blacklistapp.n;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.s;
import com.oplus.blacklistapp.u;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0863y;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.T;
import com.oplus.utils.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import x6.C1681a;
import x6.C1683c;

/* loaded from: classes3.dex */
public class PhoneNoInquireForCountrySelectActivity extends BaseActivity implements AdapterView.OnItemClickListener, CallInterceptController.b {

    /* renamed from: n, reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f26467n = new LinkedBlockingQueue<>();

    /* renamed from: o, reason: collision with root package name */
    public static ThreadPoolExecutor f26468o = new ThreadPoolExecutor(1, 1, 180, TimeUnit.SECONDS, f26467n);

    /* renamed from: g, reason: collision with root package name */
    public COUIListView f26471g;

    /* renamed from: h, reason: collision with root package name */
    public C1683c f26472h;

    /* renamed from: j, reason: collision with root package name */
    public COUIToolbar f26474j;

    /* renamed from: k, reason: collision with root package name */
    public AppBarLayout f26475k;

    /* renamed from: l, reason: collision with root package name */
    public COUIStatusBarResponseUtil f26476l;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<C1681a.c> f26469e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<C1681a.c> f26470f = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public int f26473i = 0;

    /* renamed from: m, reason: collision with root package name */
    public Handler f26477m = new d();

    /* loaded from: classes3.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            PhoneNoInquireForCountrySelectActivity.this.U0();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PhoneNoInquireForCountrySelectActivity.this.f26475k.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = PhoneNoInquireForCountrySelectActivity.this.f26475k.getMeasuredHeight() + PhoneNoInquireForCountrySelectActivity.this.getResources().getDimensionPixelSize(n.f27290o);
            PhoneNoInquireForCountrySelectActivity.this.f26471g.setPadding(0, measuredHeight, 0, 0);
            PhoneNoInquireForCountrySelectActivity.this.f26471g.setClipToPadding(false);
            PhoneNoInquireForCountrySelectActivity.this.f26471g.smoothScrollByOffset(-measuredHeight);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1681a.g(PhoneNoInquireForCountrySelectActivity.this);
            C1681a.n(PhoneNoInquireForCountrySelectActivity.this);
            PhoneNoInquireForCountrySelectActivity.this.f26477m.sendEmptyMessage(0);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<PhoneNoInquireForCountrySelectActivity> f26481a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PhoneNoInquireForCountrySelectActivity phoneNoInquireForCountrySelectActivity = this.f26481a.get();
            if (phoneNoInquireForCountrySelectActivity == null) {
                return;
            }
            phoneNoInquireForCountrySelectActivity.f26469e = new ArrayList<>(C1681a.f38003c);
            phoneNoInquireForCountrySelectActivity.f26470f = new ArrayList<>(C1681a.d.f38020e);
            phoneNoInquireForCountrySelectActivity.f26472h.c(phoneNoInquireForCountrySelectActivity.f26469e);
            phoneNoInquireForCountrySelectActivity.f26472h.a(phoneNoInquireForCountrySelectActivity.f26470f);
            phoneNoInquireForCountrySelectActivity.f26472h.notifyDataSetChanged();
        }

        public d(PhoneNoInquireForCountrySelectActivity phoneNoInquireForCountrySelectActivity) {
            this.f26481a = new WeakReference<>(phoneNoInquireForCountrySelectActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.b f26482a = null;

        public e() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            C1681a.f(PhoneNoInquireForCountrySelectActivity.this);
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            androidx.appcompat.app.b bVar = this.f26482a;
            if (bVar != null && bVar.isShowing()) {
                this.f26482a.dismiss();
                this.f26482a = null;
            }
            C1681a.e();
            C1681a.d();
            C1681a.c();
            PhoneNoInquireForCountrySelectActivity.this.finish();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            PhoneNoInquireForCountrySelectActivity phoneNoInquireForCountrySelectActivity = PhoneNoInquireForCountrySelectActivity.this;
            this.f26482a = r.b(phoneNoInquireForCountrySelectActivity, phoneNoInquireForCountrySelectActivity.getString(u.f27554P2));
        }
    }

    private void R0() {
        this.f26474j.inflateMenu(s.f27472a);
        this.f26474j.setOnMenuItemClickListener(new Toolbar.g() { // from class: p6.C
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean T02;
                T02 = PhoneNoInquireForCountrySelectActivity.this.T0(menuItem);
                return T02;
            }
        });
        this.f26474j.setIsTitleCenterStyle(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean T0(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == p.f27427z0) {
            new e().execute(new Void[0]);
            return true;
        }
        if (itemId == p.f27400m) {
            finish();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        String string;
        boolean z10;
        int k10 = C1681a.k(this.f26469e);
        if (k10 > 0) {
            string = String.format(getString(u.f27582W2), Integer.valueOf(k10));
        } else {
            string = getString(u.f27566S2);
        }
        this.f26474j.setTitle(string);
        MenuItem findItem = this.f26474j.getMenu().findItem(p.f27427z0);
        if (k10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        findItem.setEnabled(z10);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(H6.b.f1289c, H6.b.f1287a);
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean m0() {
        return false;
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.oplus.blacklistapp.r.f27442N);
        this.f26474j = (COUIToolbar) findViewById(p.f27363T0);
        R0();
        COUIListView cOUIListView = (COUIListView) findViewById(p.f27360S);
        this.f26471g = cOUIListView;
        cOUIListView.setDivider(null);
        this.f26471g.setVerticalFadingEdgeEnabled(false);
        this.f26471g.setOnItemClickListener(this);
        C1683c c1683c = new C1683c(this);
        this.f26472h = c1683c;
        c1683c.registerDataSetObserver(new a());
        this.f26471g.setAdapter((ListAdapter) this.f26472h);
        U0();
        C1681a.e();
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(p.f27376a);
        this.f26475k = appBarLayout;
        appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.f26471g.setNestedScrollingEnabled(true);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f26476l = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.f26473i = C0863y.b(intent, "slotId", 0);
        }
        C1681a.r(this.f26473i);
        StatisticsUtils.c(this, "attribution_add_entry", true, this.f26473i);
        CallInterceptController.e().d(this);
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C1681a.e();
        C1681a.d();
        C1681a.c();
        StatisticsUtils.e(this, "attribution_add_back");
        CallInterceptController.e().m(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        C1681a.c item = this.f26472h.getItem(i10);
        if (item != null) {
            if (item.f38012a.equals("OTHERS")) {
                item.f(!item.e());
                C1681a.p(item);
                if (!item.f38015d) {
                    C1681a.i();
                } else {
                    C1681a.q();
                }
            } else {
                item.f38015d = !item.f38015d;
                C1681a.s(item);
            }
        }
        this.f26472h.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f26476l.onPause();
        T.c();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f26476l.onResume();
        f26468o.execute(new c());
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        T.e(this, this.f26471g);
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void u(int i10) {
        C0846g.i("PhoneNoInquireForCountrySelectActivity", "handleHotPlugOut slot = " + i10);
        finish();
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void P0(int i10) {
    }
}
