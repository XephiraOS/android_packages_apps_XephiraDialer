package com.oplus.blacklistapp.activities;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.coui.appcompat.checkbox.COUICheckBox;
import com.coui.appcompat.rotateview.COUIRotateView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.blacklistapp.activities.PhoneNoInquireSelectActivity;
import com.oplus.blacklistapp.callintercept.CallInterceptController;
import com.oplus.blacklistapp.n;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.blacklistapp.s;
import com.oplus.blacklistapp.u;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0863y;
import com.oplus.utils.N;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.T;
import com.oplus.utils.Z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class PhoneNoInquireSelectActivity extends BaseActivity implements ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener, CallInterceptController.b {

    /* renamed from: p, reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f26484p;

    /* renamed from: q, reason: collision with root package name */
    public static final ThreadPoolExecutor f26485q;

    /* renamed from: g, reason: collision with root package name */
    public ExpandableListView f26488g;

    /* renamed from: h, reason: collision with root package name */
    public d f26489h;

    /* renamed from: i, reason: collision with root package name */
    public int f26490i;

    /* renamed from: l, reason: collision with root package name */
    public COUIToolbar f26493l;

    /* renamed from: m, reason: collision with root package name */
    public AppBarLayout f26494m;

    /* renamed from: n, reason: collision with root package name */
    public COUIStatusBarResponseUtil f26495n;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<N.b> f26486e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<N.b> f26487f = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public long f26491j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f26492k = 0;

    /* renamed from: o, reason: collision with root package name */
    public final Handler f26496o = new e();

    /* loaded from: classes3.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            PhoneNoInquireSelectActivity.this.b1();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PhoneNoInquireSelectActivity.this.f26494m.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = PhoneNoInquireSelectActivity.this.f26494m.getMeasuredHeight() + PhoneNoInquireSelectActivity.this.getResources().getDimensionPixelSize(n.f27290o);
            PhoneNoInquireSelectActivity.this.f26488g.setPadding(0, measuredHeight, 0, PhoneNoInquireSelectActivity.this.f26488g.getPaddingBottom());
            PhoneNoInquireSelectActivity.this.f26488g.setClipToPadding(false);
            PhoneNoInquireSelectActivity.this.f26488g.smoothScrollByOffset(-measuredHeight);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            N.d(PhoneNoInquireSelectActivity.this);
            N.i(PhoneNoInquireSelectActivity.this);
            PhoneNoInquireSelectActivity.this.f26496o.sendEmptyMessage(0);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BaseExpandableListAdapter {

        /* renamed from: a, reason: collision with root package name */
        public Context f26500a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f26501b;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ N.b f26503a;

            public a(N.b bVar) {
                this.f26503a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f26503a.h();
                PhoneNoInquireSelectActivity.this.f26489h.notifyDataSetChanged();
            }
        }

        public d(Context context) {
            this.f26500a = context;
            this.f26501b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i10, int i11) {
            if (i10 > 0) {
                i10--;
            }
            return PhoneNoInquireSelectActivity.this.f26486e.get(i10).f29069d.get(i11);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i10, int i11) {
            return i11;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int i10, int i11, boolean z10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f26501b.inflate(r.f27462q, (ViewGroup) null);
            }
            CheckBox checkBox = (CheckBox) view.findViewById(p.f27402n);
            TextView textView = (TextView) view.findViewById(p.f27382d);
            N.a aVar = (N.a) getChild(i10, i11);
            textView.setText(aVar.f29072b);
            checkBox.setChecked(aVar.f29073c);
            Z.a(view, aVar.f29073c);
            checkBox.setVisibility(0);
            view.setTag(aVar);
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int i10) {
            int i11;
            if (i10 <= 0 || i10 - 1 >= PhoneNoInquireSelectActivity.this.f26486e.size()) {
                return 0;
            }
            return PhoneNoInquireSelectActivity.this.f26486e.get(i11).f29069d.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int i10) {
            if (i10 == 0) {
                return PhoneNoInquireSelectActivity.this.f26487f.get(r1.size() - 1);
            }
            if (i10 < PhoneNoInquireSelectActivity.this.f26486e.size() + 1) {
                return PhoneNoInquireSelectActivity.this.f26486e.get(i10 - 1);
            }
            PhoneNoInquireSelectActivity phoneNoInquireSelectActivity = PhoneNoInquireSelectActivity.this;
            return phoneNoInquireSelectActivity.f26487f.get(i10 - (phoneNoInquireSelectActivity.f26486e.size() + 1));
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return PhoneNoInquireSelectActivity.this.f26486e.size() + PhoneNoInquireSelectActivity.this.f26487f.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public int getGroupType(int i10) {
            return 0;
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public int getGroupTypeCount() {
            return 1;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i10, boolean z10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f26501b.inflate(r.f27464s, (ViewGroup) null);
            }
            COUIRotateView cOUIRotateView = (COUIRotateView) view.findViewById(p.f27328C);
            COUICheckBox cOUICheckBox = (COUICheckBox) view.findViewById(p.f27402n);
            TextView textView = (TextView) view.findViewById(p.f27415t0);
            TextView textView2 = (TextView) view.findViewById(p.f27426z);
            TextView textView3 = (TextView) view.findViewById(p.f27407p0);
            N.b bVar = (N.b) getGroup(i10);
            if (i10 == 0) {
                textView.setPadding(0, 0, 0, 0);
                textView3.setVisibility(0);
            } else {
                textView.setPadding(0, 4, 0, 0);
                textView3.setVisibility(8);
            }
            if (bVar.f29071a == 0) {
                cOUIRotateView.setVisibility(0);
            } else {
                cOUIRotateView.setVisibility(8);
            }
            cOUIRotateView.setExpanded(z10);
            view.setTag(bVar);
            textView.setText(bVar.f29072b);
            String f10 = bVar.f();
            boolean z11 = true;
            if (f10.length() > 0 && bVar.c() > 1) {
                f10 = f10 + String.format(PhoneNoInquireSelectActivity.this.getString(u.f27700v), Integer.valueOf(bVar.c()));
            }
            if (TextUtils.isEmpty(f10)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(f10);
                textView2.setVisibility(0);
            }
            int g10 = N.g(this, i10, bVar);
            cOUICheckBox.setState(g10);
            if (g10 == 0) {
                z11 = false;
            }
            Z.a(view, z11);
            cOUICheckBox.setVisibility(0);
            cOUICheckBox.setOnClickListener(new a(bVar));
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i10, int i11) {
            return true;
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
        public void onGroupCollapsed(int i10) {
            PhoneNoInquireSelectActivity.this.f26490i = i10;
            PhoneNoInquireSelectActivity.this.f26491j = SystemClock.elapsedRealtime();
            super.onGroupCollapsed(i10);
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
        public void onGroupExpanded(int i10) {
            PhoneNoInquireSelectActivity.this.f26490i = i10;
            PhoneNoInquireSelectActivity.this.f26491j = SystemClock.elapsedRealtime();
            super.onGroupExpanded(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<PhoneNoInquireSelectActivity> f26505a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PhoneNoInquireSelectActivity phoneNoInquireSelectActivity = this.f26505a.get();
            if (phoneNoInquireSelectActivity == null) {
                return;
            }
            phoneNoInquireSelectActivity.f26486e = new ArrayList<>(N.f29063g);
            phoneNoInquireSelectActivity.f26487f = new ArrayList<>(N.d.f29075b);
            phoneNoInquireSelectActivity.f26489h.notifyDataSetChanged();
        }

        public e(PhoneNoInquireSelectActivity phoneNoInquireSelectActivity) {
            this.f26505a = new WeakReference<>(phoneNoInquireSelectActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class f extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.b f26506a = null;

        public f() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            N.c(PhoneNoInquireSelectActivity.this);
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            androidx.appcompat.app.b bVar = this.f26506a;
            if (bVar != null && bVar.isShowing()) {
                this.f26506a.dismiss();
                this.f26506a = null;
            }
            N.b();
            PhoneNoInquireSelectActivity.this.finish();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            PhoneNoInquireSelectActivity phoneNoInquireSelectActivity = PhoneNoInquireSelectActivity.this;
            this.f26506a = com.oplus.utils.r.b(phoneNoInquireSelectActivity, phoneNoInquireSelectActivity.getString(u.f27554P2));
        }
    }

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        f26484p = linkedBlockingQueue;
        f26485q = new ThreadPoolExecutor(1, 1, 180L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void U0() {
        this.f26493l.setIsTitleCenterStyle(true);
        this.f26493l.inflateMenu(s.f27472a);
        this.f26493l.setOnMenuItemClickListener(new Toolbar.g() { // from class: p6.E
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean Y02;
                Y02 = PhoneNoInquireSelectActivity.this.Y0(menuItem);
                return Y02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Y0(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == p.f27427z0) {
            new f().execute(new Void[0]);
            return true;
        }
        if (itemId == p.f27400m) {
            finish();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        String string;
        boolean z10;
        int f10 = N.f(this.f26486e) + N.f(this.f26487f);
        if (f10 > 0) {
            string = String.format(getString(u.f27578V2), Integer.valueOf(f10));
        } else {
            string = getString(u.f27566S2);
        }
        this.f26493l.setTitle(string);
        MenuItem findItem = this.f26493l.getMenu().findItem(p.f27427z0);
        if (f10 > 0) {
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

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i10, int i11, long j10) {
        N.a aVar = (N.a) view.getTag();
        aVar.f29073c = !aVar.f29073c;
        N.m(aVar);
        this.f26489h.notifyDataSetChanged();
        return true;
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.f27460o);
        this.f26493l = (COUIToolbar) findViewById(p.f27363T0);
        U0();
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);
        this.f26488g = expandableListView;
        expandableListView.setDivider(null);
        this.f26488g.setVerticalFadingEdgeEnabled(false);
        this.f26488g.setOnGroupClickListener(this);
        this.f26488g.setOnChildClickListener(this);
        this.f26488g.setGroupIndicator(null);
        this.f26488g.setNestedScrollingEnabled(true);
        this.f26488g.setVisibility(0);
        d dVar = new d(this);
        this.f26489h = dVar;
        dVar.registerDataSetObserver(new a());
        this.f26488g.setAdapter(this.f26489h);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(p.f27376a);
        this.f26494m = appBarLayout;
        appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        b1();
        N.b();
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f26495n = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.f26492k = C0863y.b(intent, "slotId", 0);
        }
        N.l(this.f26492k);
        StatisticsUtils.c(this, "attribution_add_entry", C0863y.a(getIntent(), "is_single_sim", false), this.f26492k);
        CallInterceptController.e().d(this);
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        N.b();
        StatisticsUtils.e(this, "attribution_add_back");
        CallInterceptController.e().m(this);
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i10, long j10) {
        N.b bVar = (N.b) this.f26489h.getGroup(i10);
        if (bVar.f29071a != 0) {
            bVar.f29073c = !bVar.f29073c;
            N.m(bVar);
            this.f26489h.notifyDataSetChanged();
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f26495n.onPause();
        T.c();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f26495n.onResume();
        f26485q.execute(new c());
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        T.e(this, this.f26488g);
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void u(int i10) {
        C0846g.i("PhoneNoInquireSelectActivity", "handleHotPlugOut slot = " + i10);
        finish();
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void P0(int i10) {
    }
}
