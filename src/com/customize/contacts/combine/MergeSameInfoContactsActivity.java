package com.customize.contacts.combine;

import U0.k;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.A;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.combine.MergeSameInfoContactsActivity;
import com.customize.contacts.combine.a;
import com.customize.contacts.pushnotification.model.PushNotificationScheduler;
import com.customize.contacts.pushnotification.model.h;
import com.customize.contacts.util.C0798i;
import com.customize.contacts.util.i0;
import com.customize.contacts.widget.MultiChoiceListView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes3.dex */
public class MergeSameInfoContactsActivity extends BasicActivity implements COUIStatusBarResponseUtil.StatusBarClickListener, AbsListView.OnScrollListener, a.c {

    /* renamed from: C, reason: collision with root package name */
    public Handler f20882C;

    /* renamed from: D, reason: collision with root package name */
    public Context f20883D;

    /* renamed from: E, reason: collision with root package name */
    public TextView f20884E;

    /* renamed from: F, reason: collision with root package name */
    public TextView f20885F;

    /* renamed from: I, reason: collision with root package name */
    public COUIStatusBarResponseUtil f20888I;

    /* renamed from: J, reason: collision with root package name */
    public ThreadPoolExecutor f20889J;

    /* renamed from: K, reason: collision with root package name */
    public FrameLayout f20890K;

    /* renamed from: L, reason: collision with root package name */
    public COUINavigationView f20891L;

    /* renamed from: x, reason: collision with root package name */
    public View f20896x;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20892o = false;

    /* renamed from: p, reason: collision with root package name */
    public androidx.appcompat.app.b f20893p = null;

    /* renamed from: q, reason: collision with root package name */
    public Thread f20894q = null;

    /* renamed from: r, reason: collision with root package name */
    public f f20895r = null;

    /* renamed from: y, reason: collision with root package name */
    public ListView f20897y = null;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList<G3.b> f20898z = new ArrayList<>();

    /* renamed from: A, reason: collision with root package name */
    public ArrayList<G3.b> f20880A = new ArrayList<>();

    /* renamed from: B, reason: collision with root package name */
    public com.customize.contacts.combine.a f20881B = null;

    /* renamed from: G, reason: collision with root package name */
    public int f20886G = 0;

    /* renamed from: H, reason: collision with root package name */
    public int f20887H = 0;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10;
            int i11 = message.what;
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 != 5) {
                            if (i11 != 6) {
                                if (i11 != 9) {
                                    super.handleMessage(message);
                                    return;
                                } else {
                                    if (!MergeSameInfoContactsActivity.this.isFinishing()) {
                                        MergeSameInfoContactsActivity.this.finish();
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (MergeSameInfoContactsActivity.this.isFinishing()) {
                                return;
                            }
                            MergeSameInfoContactsActivity.this.f20893p.dismiss();
                            MergeSameInfoContactsActivity mergeSameInfoContactsActivity = MergeSameInfoContactsActivity.this;
                            mergeSameInfoContactsActivity.Q1(mergeSameInfoContactsActivity.f20883D.getString(R.string.merge_error));
                            if (MergeSameInfoContactsActivity.this.f20887H == 0) {
                                MergeSameInfoContactsActivity.this.f20887H = 1;
                            }
                            if (1 == MergeSameInfoContactsActivity.this.f20887H) {
                                MergeSameInfoContactsActivity.this.V1(R.string.menu_done, R.drawable.pb_dr_menu_done, true, true);
                            }
                            MergeSameInfoContactsActivity.this.f20881B.notifyDataSetChanged();
                            return;
                        }
                        if (MergeSameInfoContactsActivity.this.isFinishing()) {
                            return;
                        }
                        MergeSameInfoContactsActivity mergeSameInfoContactsActivity2 = MergeSameInfoContactsActivity.this;
                        mergeSameInfoContactsActivity2.Q1(mergeSameInfoContactsActivity2.f20883D.getString(R.string.merge_canceled, String.valueOf(message.arg1)));
                        if (MergeSameInfoContactsActivity.this.f20887H == 0) {
                            MergeSameInfoContactsActivity.this.f20887H = 1;
                        }
                        if (1 == MergeSameInfoContactsActivity.this.f20887H) {
                            MergeSameInfoContactsActivity.this.V1(R.string.menu_done, R.drawable.pb_dr_menu_done, true, true);
                        }
                        MergeSameInfoContactsActivity.this.f20881B.notifyDataSetChanged();
                        return;
                    }
                    MergeSameInfoContactsActivity.this.f20893p.dismiss();
                    if (MergeSameInfoContactsActivity.this.f20887H == 0) {
                        MergeSameInfoContactsActivity.this.f20887H = 1;
                    }
                    HashMap hashMap = new HashMap();
                    if (1 == MergeSameInfoContactsActivity.this.f20887H) {
                        MergeSameInfoContactsActivity.this.V1(R.string.menu_merge, R.drawable.pb_dr_menu_merge, true, false);
                        hashMap.put("state", 0);
                    }
                    A.a(MergeSameInfoContactsActivity.this.getBaseContext(), 2000317, 200030162, hashMap, false);
                    MergeSameInfoContactsActivity.this.W1();
                    MergeSameInfoContactsActivity.this.f20881B.notifyDataSetChanged();
                    C0798i.b(MergeSameInfoContactsActivity.this.getApplicationContext());
                    return;
                }
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(MergeSameInfoContactsActivity.this.f20898z.size()));
            Context baseContext = MergeSameInfoContactsActivity.this.getBaseContext();
            if (2 == MergeSameInfoContactsActivity.this.f20887H) {
                i10 = 200030165;
            } else {
                i10 = 200030160;
            }
            A.a(baseContext, 2000317, i10, hashMap2, false);
            if (MergeSameInfoContactsActivity.this.f20898z.isEmpty()) {
                TextView textView = (TextView) MergeSameInfoContactsActivity.this.findViewById(R.id.empty_bottle);
                textView.setText(R.string.oplus_no_duplicate_contact);
                textView.setVisibility(0);
                ((ImageView) MergeSameInfoContactsActivity.this.findViewById(R.id.no_content)).setVisibility(0);
                View findViewById = MergeSameInfoContactsActivity.this.findViewById(R.id.loading);
                View findViewById2 = MergeSameInfoContactsActivity.this.findViewById(R.id.loading_view);
                findViewById.setVisibility(8);
                findViewById2.setVisibility(8);
                if (MergeSameInfoContactsActivity.this.f20897y != null && MergeSameInfoContactsActivity.this.f20897y.getVisibility() == 0) {
                    MergeSameInfoContactsActivity.this.f20897y.setVisibility(8);
                }
                MergeSameInfoContactsActivity.this.V1(R.string.menu_merge, R.drawable.pb_dr_menu_merge, false, false);
                return;
            }
            TextView textView2 = (TextView) MergeSameInfoContactsActivity.this.findViewById(R.id.empty_bottle);
            if (textView2.getVisibility() == 0) {
                textView2.setVisibility(8);
            }
            ImageView imageView = (ImageView) MergeSameInfoContactsActivity.this.findViewById(R.id.no_content);
            if (imageView.getVisibility() == 0) {
                imageView.setVisibility(8);
            }
            if (MergeSameInfoContactsActivity.this.f20897y != null && MergeSameInfoContactsActivity.this.f20897y.getVisibility() == 8) {
                MergeSameInfoContactsActivity.this.f20897y.setVisibility(0);
            }
            if (MergeSameInfoContactsActivity.this.f20887H == 0) {
                MergeSameInfoContactsActivity.this.V1(R.string.menu_merge, R.drawable.pb_dr_menu_merge, true, true);
            } else if (MergeSameInfoContactsActivity.this.f20891L != null && MergeSameInfoContactsActivity.this.f20891L.getVisibility() == 0) {
                MergeSameInfoContactsActivity.this.V1(R.string.menu_merge, R.drawable.pb_dr_menu_merge, true, false);
            }
            MergeSameInfoContactsActivity.this.W1();
            MergeSameInfoContactsActivity.this.L1();
            MergeSameInfoContactsActivity.this.M1();
            View findViewById3 = MergeSameInfoContactsActivity.this.findViewById(R.id.loading);
            View findViewById4 = MergeSameInfoContactsActivity.this.findViewById(R.id.loading_view);
            findViewById3.setVisibility(8);
            findViewById4.setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MergeSameInfoContactsActivity.this.onBackPressed();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Thread {
        public c(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread
        public void interrupt() {
            if (MergeSameInfoContactsActivity.this.f20895r != null) {
                MergeSameInfoContactsActivity.this.f20895r.f20904a = true;
            }
            super.interrupt();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BottomNavigationView.c {
        public d() {
        }

        @Override // com.google.android.material.navigation.NavigationBarView.c
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            if (menuItem != null && menuItem.getItemId() == R.id.delete) {
                if (MergeSameInfoContactsActivity.this.f20887H == 0) {
                    MergeSameInfoContactsActivity.this.R1();
                } else {
                    A.a(MergeSameInfoContactsActivity.this.getBaseContext(), 2000317, 200030163, null, false);
                    MergeSameInfoContactsActivity.this.finish();
                }
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MergeSameInfoContactsActivity.this.f20891L.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20904a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference<MergeSameInfoContactsActivity> f20905b;

        @Override // java.lang.Runnable
        public void run() {
            MergeSameInfoContactsActivity mergeSameInfoContactsActivity = this.f20905b.get();
            if (mergeSameInfoContactsActivity != null && !mergeSameInfoContactsActivity.isFinishing() && !mergeSameInfoContactsActivity.isDestroyed()) {
                long currentTimeMillis = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                hashMap.put("handle_dupli_done", 0);
                hashMap.put("handle_single_dupli_count", 0);
                hashMap.put("handle_dupli_namephone_count", 0);
                hashMap.put("handle_dupli_nameemail_count", 0);
                hashMap.put("handle_dupli_contacts_count", 0);
                try {
                    G3.c.f(mergeSameInfoContactsActivity).x(false);
                    G3.c.v(mergeSameInfoContactsActivity);
                    if (G3.c.f(mergeSameInfoContactsActivity).n() && mergeSameInfoContactsActivity.f20882C != null) {
                        mergeSameInfoContactsActivity.f20882C.sendEmptyMessage(9);
                        return;
                    }
                    if (this.f20904a) {
                        return;
                    }
                    if (G3.c.f(mergeSameInfoContactsActivity).n() && mergeSameInfoContactsActivity.f20882C != null) {
                        mergeSameInfoContactsActivity.f20882C.sendEmptyMessage(9);
                        return;
                    }
                    if (this.f20904a) {
                        return;
                    }
                    if (G3.c.f(mergeSameInfoContactsActivity).n() && mergeSameInfoContactsActivity.f20882C != null) {
                        mergeSameInfoContactsActivity.f20882C.sendEmptyMessage(9);
                        return;
                    }
                    if (this.f20904a) {
                        return;
                    }
                    if (G3.c.f(mergeSameInfoContactsActivity).n() && mergeSameInfoContactsActivity.f20882C != null) {
                        mergeSameInfoContactsActivity.f20882C.sendEmptyMessage(9);
                        return;
                    }
                    if (this.f20904a) {
                        return;
                    }
                    hashMap.put("handle_dupli_done", 1);
                    A.a(mergeSameInfoContactsActivity, 2000302, 200030250, hashMap, false);
                    if (2 == mergeSameInfoContactsActivity.f20887H) {
                        mergeSameInfoContactsActivity.f20898z = G3.c.f(mergeSameInfoContactsActivity).l(4L);
                    } else if (mergeSameInfoContactsActivity.f20887H == 0) {
                        mergeSameInfoContactsActivity.f20898z = G3.c.f(mergeSameInfoContactsActivity).l(3L);
                    }
                    if (G3.c.f(mergeSameInfoContactsActivity).n() && mergeSameInfoContactsActivity.f20882C != null) {
                        mergeSameInfoContactsActivity.f20882C.sendEmptyMessage(9);
                        return;
                    }
                    if (!this.f20904a) {
                        mergeSameInfoContactsActivity.f20886G = mergeSameInfoContactsActivity.f20898z.size();
                        H7.b.b("MergeContactsActivity", "query mode = " + mergeSameInfoContactsActivity.f20887H + ", mCount = " + mergeSameInfoContactsActivity.f20886G + ", time = " + (System.currentTimeMillis() - currentTimeMillis));
                        if (mergeSameInfoContactsActivity.f20882C != null) {
                            mergeSameInfoContactsActivity.f20882C.sendEmptyMessage(2);
                        }
                    }
                } finally {
                    hashMap.put("handle_dupli_done", 1);
                    A.a(mergeSameInfoContactsActivity, 2000302, 200030250, hashMap, false);
                }
            }
        }

        public f(MergeSameInfoContactsActivity mergeSameInfoContactsActivity) {
            this.f20904a = false;
            this.f20905b = new WeakReference<>(mergeSameInfoContactsActivity);
        }
    }

    private void J1() {
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        setSupportActionBar(cOUIToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.v(4, 4);
            supportActionBar.w(false);
        }
        cOUIToolbar.setNavigationOnClickListener(new b());
    }

    private void T1() {
        Thread thread = this.f20894q;
        if (thread != null) {
            thread.interrupt();
            this.f20894q = null;
            this.f20895r = null;
        }
        this.f20895r = new f();
        c cVar = new c(this.f20895r);
        this.f20894q = cVar;
        cVar.start();
    }

    private void U1() {
        int count = this.f20881B.getCount();
        int K12 = K1();
        boolean z10 = false;
        if (K12 < count) {
            this.f20892o = false;
        } else {
            this.f20892o = true;
        }
        if (H7.a.b()) {
            H7.b.b("MergeContactsActivity", "totalCount = " + count + " currentCount = " + K12);
            StringBuilder sb = new StringBuilder();
            sb.append("mIsMarkAll = ");
            sb.append(this.f20892o);
            H7.b.b("MergeContactsActivity", sb.toString());
        }
        if (K12 > 0) {
            z10 = true;
        }
        V1(R.string.menu_merge, R.drawable.pb_dr_menu_merge, z10, true);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    public final int K1() {
        int size = this.f20898z.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f20898z.get(i11).d()) {
                i10++;
            }
        }
        if (H7.a.b()) {
            H7.b.b("MergeContactsActivity", "checkCount = " + i10);
        }
        return i10;
    }

    public final void L1() {
        com.customize.contacts.combine.a aVar = new com.customize.contacts.combine.a(this, R.layout.merge_contacts_list_item, this.f20898z);
        this.f20881B = aVar;
        aVar.h(this);
        this.f20881B.i(this.f20887H);
        this.f20897y.setAdapter((ListAdapter) this.f20881B);
    }

    public final void M1() {
        this.f20897y.setOnScrollListener(this);
        if (2 != this.f20887H) {
            U1();
        }
    }

    public final /* synthetic */ void N1() {
        h d10;
        com.customize.contacts.pushnotification.model.c e10;
        String l10 = C7.e.l(getIntent(), "notification_string_id");
        if (!TextUtils.isEmpty(l10) && (d10 = h.d()) != null && (e10 = d10.e(l10)) != null && e10.n() == 1) {
            e10.p(System.currentTimeMillis() / 1000);
            PushNotificationScheduler.b.a(e10, e10.n(), 6);
            d10.f(e10);
        }
    }

    public final /* synthetic */ void O1() {
        G3.c f10 = G3.c.f(this.f20883D);
        f10.w(this.f20882C);
        this.f20880A = f10.p(this.f20898z, true);
    }

    public final void P1() {
        ListView listView = this.f20897y;
        if (listView != null) {
            listView.setVisibility(8);
        }
        View findViewById = findViewById(R.id.empty_bottle);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        ((ImageView) findViewById(R.id.no_content)).setVisibility(8);
        View findViewById2 = findViewById(R.id.loading);
        View findViewById3 = findViewById(R.id.loading_view);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(0);
        }
    }

    public final void Q1(String str) {
        com.oplus.foundation.util.ui.c.c(this, str);
    }

    public void R1() {
        int K12 = K1();
        HashMap hashMap = new HashMap();
        hashMap.put("selected_count", Integer.valueOf(K12));
        hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(this.f20898z.size()));
        A.a(getBaseContext(), 2000317, 200030161, hashMap, false);
        if (K12 < 1) {
            if (this.f20887H == 0) {
                this.f20887H = 2;
                View findViewById = findViewById(R.id.loading);
                View findViewById2 = findViewById(R.id.loading_view);
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                T1();
                return;
            }
            return;
        }
        if (this.f20893p == null) {
            this.f20893p = k.o(this, getString(R.string.merging));
        }
        androidx.appcompat.app.b bVar = this.f20893p;
        if (bVar != null) {
            bVar.show();
        }
        S1();
    }

    public final void S1() {
        this.f20889J.execute(new Runnable() { // from class: G3.e
            @Override // java.lang.Runnable
            public final void run() {
                MergeSameInfoContactsActivity.this.O1();
            }
        });
    }

    public final void V1(int i10, int i11, boolean z10, boolean z11) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (K1() > 0) {
                supportActionBar.A(String.format(getResources().getString(R.string.auto_merge_numbers), U7.a.b(K1())));
            } else {
                supportActionBar.z(R.string.merge_contacts);
            }
        }
        m1(this.f20890K, z11);
        f1(this, false, K0());
        k1(z11);
        if (z11) {
            MenuItem findItem = this.f20891L.getMenu().findItem(R.id.delete);
            findItem.setTitle(i10);
            findItem.setIcon(i11);
            findItem.setEnabled(z10);
            this.f20891L.getViewTreeObserver().addOnGlobalLayoutListener(new e());
        }
    }

    public final void W1() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        if (this.f20884E == null) {
            this.f20884E = (TextView) this.f20896x.findViewById(R.id.title);
            this.f20885F = (TextView) findViewById(R.id.count);
        }
        int i10 = this.f20887H;
        if (i10 == 0) {
            this.f20884E.setText(R.string.same_name_separator_tips);
            this.f20885F.setText(String.format(getResources().getString(R.string.oplus_groups), U7.a.b(this.f20898z.size())));
            supportActionBar.z(R.string.merge_contacts);
        } else if (1 == i10) {
            this.f20884E.setText(String.format(getResources().getString(R.string.auto_merge_complete_tips), U7.a.b(this.f20898z.size())));
            this.f20885F.setText("");
            supportActionBar.z(R.string.auto_merge_complete);
        } else if (2 == i10) {
            this.f20884E.setText(R.string.same_number_separator_tips);
            this.f20885F.setText(String.format(getResources().getString(R.string.oplus_groups), U7.a.b(this.f20886G)));
            if (this.f20898z.size() == this.f20886G) {
                supportActionBar.z(R.string.manual_merge);
            } else {
                supportActionBar.z(R.string.manual_merge_complete);
            }
        }
    }

    @Override // com.customize.contacts.combine.a.c
    public void a() {
        U1();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void f1(Activity activity, boolean z10, boolean z11) {
        g1(this.f20890K);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        H7.b.b("MergeContactsActivity", "onActivityResult resultCode = " + i11 + ", RESULT_OK = -1");
        super.onActivityResult(i10, i11, intent);
        if (-1 == i11) {
            try {
                int d10 = C7.e.d(intent, "chosen_contacts_position", -1);
                if (-1 != d10 && this.f20898z.size() > d10) {
                    this.f20886G--;
                    G3.b bVar = this.f20898z.get(d10);
                    String l10 = C7.e.l(intent, "checked_name");
                    ArrayList<String> k10 = C7.e.k(intent, "checked_numbers");
                    bVar.f1101k.clear();
                    bVar.f1093c = l10;
                    bVar.f1096f.clear();
                    bVar.f1096f = new ArrayList<>(k10);
                    k10.clear();
                    bVar.f1095e = "";
                    for (int i12 = 0; i12 < bVar.f1096f.size(); i12++) {
                        if (i12 > 0) {
                            bVar.f1095e += ", ";
                        }
                        bVar.f1095e += bVar.f1096f.get(i12);
                    }
                    W1();
                    this.f20881B.notifyDataSetChanged();
                }
            } catch (Exception e10) {
                H7.b.c("MergeContactsActivity", "" + e10);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        A.b(this, "merge_duplicate_contact_back");
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.merge_contacts_main);
        J1();
        this.f20883D = getApplicationContext();
        this.f20897y = (MultiChoiceListView) findViewById(R.id.merge_contacts_list);
        View inflate = LayoutInflater.from(this).inflate(R.layout.merge_header, (ViewGroup) null);
        this.f20896x = inflate;
        this.f20897y.addHeaderView(inflate);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.list_padding_top) + getResources().getDimensionPixelSize(R.dimen.divider_background_height);
        this.f20897y.setPadding(0, dimensionPixelSize, 0, 0);
        this.f20897y.smoothScrollByOffset(-dimensionPixelSize);
        this.f20897y.setNestedScrollingEnabled(true);
        v0(this.f20897y);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f20888I = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        this.f20889J = N7.a.a();
        this.f20882C = new a();
        try {
            this.f20887H = C7.e.d(getIntent(), "operation_mode", 0);
        } catch (Exception e10) {
            H7.b.c("MergeContactsActivity", "" + e10);
        }
        if (C7.e.c(getIntent(), "has_queried", false)) {
            this.f20898z.clear();
            this.f20898z.addAll(G3.c.f(this.f20883D).g());
            G3.c.f(this.f20883D).g().clear();
            this.f20886G = this.f20898z.size();
            if (!G3.c.f(this.f20883D).m()) {
                Handler handler = this.f20882C;
                if (handler != null) {
                    handler.sendEmptyMessage(2);
                }
            } else {
                finish();
            }
            this.f20889J.execute(new Runnable() { // from class: G3.d
                @Override // java.lang.Runnable
                public final void run() {
                    MergeSameInfoContactsActivity.this.N1();
                }
            });
        }
        T1();
        this.f20889J.execute(new Runnable() { // from class: G3.d
            @Override // java.lang.Runnable
            public final void run() {
                MergeSameInfoContactsActivity.this.N1();
            }
        });
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        G3.c.f(this).x(true);
        androidx.appcompat.app.b bVar = this.f20893p;
        if (bVar != null && bVar.isShowing()) {
            this.f20893p.dismiss();
        }
        com.customize.contacts.combine.a aVar = this.f20881B;
        if (aVar != null) {
            aVar.j();
        }
        G3.c.c();
        f fVar = this.f20895r;
        if (fVar != null) {
            fVar.f20904a = true;
        }
        Thread thread = this.f20894q;
        if (thread != null) {
            thread.interrupt();
            this.f20894q = null;
            this.f20895r = null;
        }
        ThreadPoolExecutor threadPoolExecutor = this.f20889J;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
            this.f20889J = null;
        }
        super.onDestroy();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        androidx.appcompat.app.b bVar = this.f20893p;
        if (bVar != null && bVar.isShowing()) {
            return;
        }
        setIntent(intent);
        J1();
        boolean z10 = false;
        try {
            this.f20887H = C7.e.d(getIntent(), "operation_mode", 0);
            z10 = C7.e.c(getIntent(), "has_queried", false);
        } catch (Exception e10) {
            H7.b.c("MergeContactsActivity", "" + e10);
        }
        P1();
        if (z10) {
            Thread thread = this.f20894q;
            if (thread != null) {
                thread.interrupt();
                this.f20894q = null;
                this.f20895r = null;
            }
            this.f20898z.clear();
            this.f20898z.addAll(G3.c.f(this.f20883D).g());
            G3.c.f(this.f20883D).g().clear();
            this.f20886G = this.f20898z.size();
            if (!G3.c.f(this.f20883D).m()) {
                Handler handler = this.f20882C;
                if (handler != null) {
                    handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            finish();
            return;
        }
        T1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        A.g(this);
        i0.b();
        com.customize.contacts.combine.a aVar = this.f20881B;
        if (aVar != null) {
            aVar.d();
        }
        this.f20888I.onPause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        A.h(this);
        com.customize.contacts.combine.a aVar = this.f20881B;
        if (aVar != null) {
            aVar.g();
        }
        this.f20888I.onResume();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        if (i10 == 2) {
            this.f20881B.f();
        } else {
            this.f20881B.g();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        i0.d(this, this.f20897y);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.customize.contacts.combine.a.c
    public void s(int i10) {
        MergeSameNumberActivity.F1(this.f20898z.get(i10));
        Intent intent = new Intent(this.f20883D, (Class<?>) MergeSameNumberActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("chosen_contacts_position", i10);
        Q7.b.b(this, intent, 0, 0);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void y0() {
        this.f20890K = (FrameLayout) findViewById(R.id.navigation_view_panel);
        COUINavigationView cOUINavigationView = (COUINavigationView) findViewById(R.id.navigation_view);
        this.f20891L = cOUINavigationView;
        cOUINavigationView.inflateMenu(R.menu.one_action);
        this.f20891L.getMenu().findItem(R.string.menu_merge);
        this.f20891L.setOnNavigationItemSelectedListener(new d());
        FrameLayout frameLayout = this.f20890K;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
    }
}
