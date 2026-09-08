package com.customize.contacts.activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.android.contacts.list.AccountFilterActivity;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.model.Account;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0797h;
import com.customize.contacts.util.C0810v;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes3.dex */
public class MultiContactPickActivity extends CommonTopTitlebarActivity implements Z3.i, View.OnTouchListener {
    public static final int TOAST_HINT_TYPE_ADD_MORE_THAN_2000 = 1;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList<IdRecord> f20469b0;

    /* renamed from: c0, reason: collision with root package name */
    public ArrayList<IdRecord> f20470c0;

    /* renamed from: i0, reason: collision with root package name */
    public androidx.appcompat.app.b f20476i0;

    /* renamed from: k0, reason: collision with root package name */
    public j f20478k0;

    /* renamed from: l0, reason: collision with root package name */
    public ThreadPoolExecutor f20479l0;
    public int mToastHintType;

    /* renamed from: o0, reason: collision with root package name */
    public FrameLayout f20482o0;

    /* renamed from: p0, reason: collision with root package name */
    public COUINavigationView f20483p0;

    /* renamed from: T, reason: collision with root package name */
    public com.customize.contacts.fragment.D f20461T = null;

    /* renamed from: U, reason: collision with root package name */
    public int f20462U = -1;

    /* renamed from: V, reason: collision with root package name */
    public Account f20463V = null;

    /* renamed from: W, reason: collision with root package name */
    public String f20464W = null;

    /* renamed from: X, reason: collision with root package name */
    public boolean f20465X = false;

    /* renamed from: Y, reason: collision with root package name */
    public Intent f20466Y = null;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f20467Z = false;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f20468a0 = false;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f20471d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    public int f20472e0 = 0;

    /* renamed from: f0, reason: collision with root package name */
    public Object f20473f0 = new Object();

    /* renamed from: g0, reason: collision with root package name */
    public boolean f20474g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f20475h0 = false;

    /* renamed from: j0, reason: collision with root package name */
    public ArrayList<Account> f20477j0 = null;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f20480m0 = true;

    /* renamed from: n0, reason: collision with root package name */
    public AsyncTask<Void, Void, Boolean> f20481n0 = null;

    /* renamed from: q0, reason: collision with root package name */
    public BroadcastReceiver f20484q0 = new e();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MultiContactPickActivity.this.F2();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Toolbar.g {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (R.id.select_all == itemId) {
                MultiContactPickActivity.this.d2();
                return true;
            }
            if (R.id.cancel == itemId) {
                MultiContactPickActivity.this.F2();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MultiContactPickActivity.this.f20572y.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = MultiContactPickActivity.this.f20572y.getMeasuredHeight();
            MultiContactPickActivity multiContactPickActivity = MultiContactPickActivity.this;
            if (multiContactPickActivity.f20568p == null) {
                multiContactPickActivity.f20568p = multiContactPickActivity.f20461T.n1();
            }
            MultiContactPickActivity multiContactPickActivity2 = MultiContactPickActivity.this;
            if (multiContactPickActivity2.f20568p != null) {
                int dimensionPixelSize = measuredHeight - multiContactPickActivity2.getResources().getDimensionPixelSize(R.dimen.divider_background_height);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MultiContactPickActivity.this.f20568p.getLayoutParams();
                layoutParams.topMargin = dimensionPixelSize;
                layoutParams.addRule(10);
                MultiContactPickActivity.this.f20568p.setLayoutParams(layoutParams);
                measuredHeight = dimensionPixelSize + MultiContactPickActivity.this.f20568p.getMeasuredHeight() + MultiContactPickActivity.this.getResources().getDimensionPixelSize(R.dimen.list_padding_top);
            }
            MultiContactPickActivity multiContactPickActivity3 = MultiContactPickActivity.this;
            if (multiContactPickActivity3.f20569q == null) {
                multiContactPickActivity3.f20569q = new View(MultiContactPickActivity.this);
                MultiContactPickActivity.this.f20569q.setVisibility(4);
                MultiContactPickActivity.this.f20461T.u1().addHeaderView(MultiContactPickActivity.this.f20569q);
                MultiContactPickActivity.this.f20461T.u1().setPadding(0, MultiContactPickActivity.this.f20461T.u1().getPaddingTop(), 0, MultiContactPickActivity.this.f20461T.s1());
                MultiContactPickActivity.this.f20461T.i2(measuredHeight);
                MultiContactPickActivity.this.f20569q.setLayoutParams(new AbsListView.LayoutParams(-1, measuredHeight));
            }
            MultiContactPickActivity.this.f20461T.u1().setNestedScrollingEnabled(true);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiContactPickActivity multiContactPickActivity = MultiContactPickActivity.this;
            multiContactPickActivity.z2(multiContactPickActivity.getContentResolver());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (H7.a.b()) {
                H7.b.b("MultiContactPickActivity", "onReceive action : " + action);
            }
            if (!TextUtils.equals("com.oplus.contacts.action_SIM_ABSENT", action)) {
                return;
            }
            MultiContactPickActivity multiContactPickActivity = MultiContactPickActivity.this;
            int i10 = multiContactPickActivity.f20462U;
            if (7 == i10 || 8 == i10) {
                multiContactPickActivity.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                MultiContactPickActivity multiContactPickActivity = MultiContactPickActivity.this;
                multiContactPickActivity.S2(multiContactPickActivity.f20461T.V2());
            }
            MultiContactPickActivity.this.removeDialog(1);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements BottomNavigationView.c {
        public g() {
        }

        @Override // com.google.android.material.navigation.NavigationBarView.c
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            if (menuItem != null && menuItem.getItemId() == R.id.delete) {
                MultiContactPickActivity.this.f20461T.r2();
                MultiContactPickActivity.this.returnSelectContacts();
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class h extends AsyncTask<Void, Void, Void> {
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            MultiContactPickActivity multiContactPickActivity = MultiContactPickActivity.this;
            multiContactPickActivity.z2(multiContactPickActivity.getContentResolver());
            return null;
        }

        public void b() {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }

        public h() {
        }
    }

    /* loaded from: classes3.dex */
    public class i implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MultiContactPickActivity.this.removeDialog(6);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                com.android.contacts.framework.baseui.util.A.a(MultiContactPickActivity.this.getBaseContext(), 2000315, 200030141, null, false);
                if (B3.a.i()) {
                    Account account = (Account) C7.e.j(MultiContactPickActivity.this.f20466Y, "account");
                    MultiContactPickActivity multiContactPickActivity = MultiContactPickActivity.this;
                    multiContactPickActivity.C2(multiContactPickActivity.f20461T.V2(), account.f16941a);
                } else {
                    MultiContactPickActivity multiContactPickActivity2 = MultiContactPickActivity.this;
                    multiContactPickActivity2.B2(multiContactPickActivity2.f20461T.V2());
                }
            } else {
                com.android.contacts.framework.baseui.util.A.a(MultiContactPickActivity.this.getBaseContext(), 2000315, 200030140, null, false);
            }
            MultiContactPickActivity.this.removeDialog(6);
        }

        public i() {
        }
    }

    /* loaded from: classes3.dex */
    public class j implements V3.a {
        @Override // V3.a
        public void a() {
            MultiContactPickActivity.this.w2();
        }

        @Override // V3.a
        public void b() {
            View view = MultiContactPickActivity.this.f20570r;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // V3.a
        public void c(boolean z10) {
            Object[] objArr;
            boolean z11;
            MultiContactPickActivity multiContactPickActivity = MultiContactPickActivity.this;
            boolean z12 = false;
            int i10 = 0;
            z12 = false;
            if (multiContactPickActivity.f20568p != null && !multiContactPickActivity.U1()) {
                COUISearchBar cOUISearchBar = MultiContactPickActivity.this.f20568p;
                if (!z10) {
                    i10 = 8;
                }
                cOUISearchBar.setVisibility(i10);
                return;
            }
            COUISearchBar cOUISearchBar2 = MultiContactPickActivity.this.f20568p;
            if (cOUISearchBar2 != null && cOUISearchBar2.getSearchEditText() != null && !MultiContactPickActivity.this.f20568p.getSearchEditText().getText().toString().isEmpty()) {
                objArr = true;
            } else {
                objArr = false;
            }
            if (MultiContactPickActivity.this.U1()) {
                MultiContactPickActivity multiContactPickActivity2 = MultiContactPickActivity.this;
                FrameLayout frameLayout = multiContactPickActivity2.f20482o0;
                if (objArr != false && z10) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                multiContactPickActivity2.m1(frameLayout, z11);
            } else {
                MultiContactPickActivity multiContactPickActivity3 = MultiContactPickActivity.this;
                multiContactPickActivity3.m1(multiContactPickActivity3.f20482o0, z10);
            }
            com.customize.contacts.fragment.D d10 = MultiContactPickActivity.this.f20461T;
            if (d10 != null) {
                if (objArr != false && z10) {
                    z12 = true;
                }
                d10.h2(z12);
            }
        }

        @Override // V3.a
        public void d() {
            View view = MultiContactPickActivity.this.f20570r;
            if (view != null) {
                view.setVisibility(0);
            }
        }

        @Override // V3.a
        public void e() {
            MultiContactPickActivity.this.x2();
        }

        public j() {
        }
    }

    /* loaded from: classes3.dex */
    public class k implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MultiContactPickActivity.this.removeDialog(8);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                Account account = (Account) C7.e.j(MultiContactPickActivity.this.f20466Y, "SRC_ACCOUNT");
                Account account2 = (Account) C7.e.j(MultiContactPickActivity.this.f20466Y, "DEST_ACCOUNT");
                MultiContactPickActivity multiContactPickActivity = MultiContactPickActivity.this;
                multiContactPickActivity.H2(multiContactPickActivity.f20461T.V2(), account, account2);
            }
            MultiContactPickActivity.this.removeDialog(8);
        }

        public k() {
        }
    }

    /* loaded from: classes3.dex */
    public static class l extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<MultiContactPickActivity> f20496a;

        public l(MultiContactPickActivity multiContactPickActivity) {
            this.f20496a = new WeakReference<>(multiContactPickActivity);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            MultiContactPickActivity multiContactPickActivity = this.f20496a.get();
            if (multiContactPickActivity != null) {
                try {
                    multiContactPickActivity.f20461T.X2();
                    multiContactPickActivity.f20474g0 = true;
                    synchronized (multiContactPickActivity.f20473f0) {
                        multiContactPickActivity.f20473f0.notifyAll();
                    }
                    return null;
                } catch (Throwable th) {
                    multiContactPickActivity.f20474g0 = true;
                    synchronized (multiContactPickActivity.f20473f0) {
                        multiContactPickActivity.f20473f0.notifyAll();
                        throw th;
                    }
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            MultiContactPickActivity multiContactPickActivity = this.f20496a.get();
            if (multiContactPickActivity != null) {
                if (multiContactPickActivity.f20476i0 != null && multiContactPickActivity.f20476i0.isShowing()) {
                    multiContactPickActivity.f20476i0.dismiss();
                    multiContactPickActivity.f20476i0 = null;
                }
                multiContactPickActivity.G2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends AsyncTask<Integer, Integer, List<ContactListFilter>> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<IdRecord> f20497a;

        /* renamed from: b, reason: collision with root package name */
        public final Account f20498b;

        /* loaded from: classes3.dex */
        public class a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f20500a;

            public a(List list) {
                this.f20500a = list;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                m mVar = m.this;
                MultiContactPickActivity.this.N2(mVar.f20497a, m.this.f20498b, new Account(((ContactListFilter) this.f20500a.get(i10)).f16740d, ((ContactListFilter) this.f20500a.get(i10)).f16739c));
            }
        }

        public m(ArrayList<IdRecord> arrayList, Account account) {
            this.f20497a = arrayList;
            this.f20498b = account;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<ContactListFilter> doInBackground(Integer... numArr) {
            ArrayList arrayList = new ArrayList();
            List<ContactListFilter> C12 = AccountFilterActivity.C1(MultiContactPickActivity.this, ContactListFilter.h(-2), true);
            if (H7.a.b()) {
                H7.b.b("MultiContactPickActivity", "QueryAvailableAccountAsyncTask, size = " + C12.size());
            }
            for (int size = C12.size() - 1; size > 0; size--) {
                if (H7.a.b()) {
                    H7.b.b("MultiContactPickActivity", "the type is " + C12.get(size).f16738b);
                }
                if (C12.get(size).f16738b != -3 && (C12.get(size).f16738b != 0 || !TextUtils.equals(C12.get(size).f16739c, "com.android.oplus.sim"))) {
                    arrayList.add(C12.get(size));
                }
            }
            return arrayList;
        }

        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<ContactListFilter> list) {
            if (!MultiContactPickActivity.this.isDestroyed() && !MultiContactPickActivity.this.isFinishing()) {
                if (list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (ContactListFilter contactListFilter : list) {
                        if (TextUtils.equals(contactListFilter.f16739c, R0.a.f3166b)) {
                            arrayList.add(MultiContactPickActivity.this.getString(R.string.contact_editor_account_storage_phone));
                        } else {
                            String str = contactListFilter.f16739c;
                            if (str != null && !str.equals("com.android.oplus.sim")) {
                                arrayList.add(contactListFilter.f16740d);
                            }
                        }
                    }
                    new U0.b(MultiContactPickActivity.this, 2132083073).setMessage(R.string.import_from_sim).setItems((CharSequence[]) arrayList.toArray(new String[0]), (DialogInterface.OnClickListener) new a(list)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                    return;
                }
                H7.b.i("MultiContactPickActivity", "no available account!");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class n extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final int f20502a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<Context> f20503b;

        public n(Context context, int i10) {
            this.f20503b = new WeakReference<>(context);
            this.f20502a = i10;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            boolean z10;
            Cursor cursor = null;
            try {
                try {
                    if (this.f20503b.get() == null) {
                        return Boolean.FALSE;
                    }
                    Cursor c10 = W3.a.c(this.f20503b.get(), this.f20502a);
                    W3.a.d(this.f20503b.get(), this.f20502a);
                    if (com.customize.contacts.util.b0.M(this.f20503b.get(), this.f20502a) == -1) {
                        H7.b.c("MultiContactPickActivity", "fail to get sim card storage.");
                        Boolean bool = Boolean.FALSE;
                        if (c10 != null) {
                            c10.close();
                        }
                        return bool;
                    }
                    if (c10 != null) {
                        H7.b.e("MultiContactPickActivity", "count = " + c10.getCount());
                    }
                    if (c10 != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z10);
                    if (c10 != null) {
                        c10.close();
                    }
                    return valueOf;
                } catch (Exception e10) {
                    H7.b.c("MultiContactPickActivity", "Exception occur when query sim card status " + e10);
                    Boolean bool2 = Boolean.FALSE;
                    if (0 != 0) {
                        cursor.close();
                    }
                    return bool2;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (this.f20503b.get() == null) {
                H7.b.b("MultiContactPickActivity", "when judge the sim status, the context is null, just return");
                return;
            }
            if (bool == null || !bool.booleanValue()) {
                com.oplus.foundation.util.ui.c.b(this.f20503b.get(), R.string.simcard_abnormal_please_check_and_try_again);
                if (this.f20503b.get() instanceof MultiContactPickActivity) {
                    ((MultiContactPickActivity) this.f20503b.get()).finish();
                }
            }
        }
    }

    private void D2() {
        if (this.f20568p == null) {
            this.f20568p = this.f20461T.n1();
        }
        x1();
        B1();
        z1();
        O2();
    }

    private void O2() {
        com.customize.contacts.fragment.D d10;
        if (this.f20570r == null && (d10 = this.f20461T) != null) {
            View x12 = d10.x1();
            this.f20570r = x12;
            x12.setOnTouchListener(this);
        }
    }

    private void Y2(boolean z10) {
        MenuItem findItem = this.f20483p0.getMenu().findItem(R.id.delete);
        int i10 = this.f20462U;
        if (i10 == 6) {
            findItem.setTitle(R.string.oplus_import_contacts_to_sim);
            findItem.setIcon(R.drawable.pb_dr_menu_import);
        } else if (i10 == 7) {
            findItem.setTitle(R.string.oplus_import_contacts_to_sim);
            findItem.setIcon(R.drawable.pb_dr_menu_import);
        } else if (i10 == 8) {
            findItem.setTitle(R.string.oplus_export_from_sim);
            findItem.setIcon(R.drawable.pb_dr_menu_export);
        } else if (i10 == 1) {
            findItem.setIcon(R.drawable.pb_dr_menu_add_group_member);
            findItem.setTitle(R.string.add_to_group);
        } else {
            findItem.setIcon(R.drawable.pb_dr_bottom_menu_add);
            findItem.setTitle(R.string.confirm_description);
        }
        findItem.setEnabled(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w2() {
        D2();
        K1();
        m1(this.f20482o0, true);
        this.f20461T.h2(true);
        this.f20461T.s2(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2() {
        D2();
        E1();
        m1(this.f20482o0, false);
        this.f20461T.h2(false);
        this.f20461T.s2(false);
    }

    public void A2() {
        Fragment m02 = getSupportFragmentManager().m0("multiContactPick");
        if (m02 instanceof com.customize.contacts.fragment.D) {
            this.f20461T = (com.customize.contacts.fragment.D) m02;
        } else {
            this.f20461T = new com.customize.contacts.fragment.D();
        }
        this.f20461T.f3(this.f20482o0);
        this.f20461T.g3(this.f20469b0);
        this.f20461T.c3(this.f20470c0);
        if (this.f20465X) {
            this.f20461T.H2(true);
        }
        if (this.f20478k0 == null) {
            this.f20478k0 = new j();
        }
        int i10 = this.f20462U;
        if (i10 != 1) {
            if (i10 != 6) {
                if (i10 == 7 || i10 == 8) {
                    Account account = (Account) C7.e.j(this.f20466Y, "SRC_ACCOUNT");
                    this.f20461T.b3(account);
                    this.f20461T.d3(account);
                }
            } else {
                this.f20461T.e3(true);
            }
        } else {
            this.f20461T.b3(this.f20463V);
            this.f20461T.h3(this.f20477j0);
            this.f20461T.I2(true);
            this.f20461T.H2(true);
        }
        this.f20461T.M2(this.f20478k0);
        this.f20461T.Q2(this);
        this.f20461T.g2(false);
        getSupportFragmentManager().p().t(R.id.list_container, this.f20461T, "multiContactPick").j();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void B0() {
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        this.f20571x = cOUIToolbar;
        cOUIToolbar.setNavigationOnClickListener(new a());
        this.f20571x.setOnMenuItemClickListener(new b());
        this.f20571x.setNavigationIcon(R.drawable.coui_back_arrow);
        this.f20571x.setNavigationContentDescription(R.string.abc_action_bar_up_description);
        this.f20571x.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.activities.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiContactPickActivity.this.P2(view);
            }
        });
        this.f20571x.inflateMenu(R.menu.cancel_select_menu);
    }

    public void B2(ArrayList<IdRecord> arrayList) {
        C2(arrayList, ((TelephonyManager) getSystemService("phone")).getSubscriberId());
    }

    public void C2(ArrayList<IdRecord> arrayList, String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.foundation.util.ui.c.d(this, R.string.simcard_abnormal_please_check_and_try_again);
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            Intent intent = new Intent("com.oplus.contacts.proc.COPY_CONTACTS_BETWEEN_ACCOUNTS");
            intent.setPackage(getPackageName());
            C0810v.g(arrayList);
            intent.putExtra("DEST_ACCOUNT", new Account(str, "com.oplus.contacts.sim"));
            intent.putExtra("DEST_SIM_ACCOUNT", true);
            intent.putExtra("title", C7.e.l(this.f20466Y, "title"));
            R7.b.c(this, intent);
            finish();
            return;
        }
        com.oplus.foundation.util.ui.c.d(this, R.string.no_select_contacts);
    }

    public final void E2() {
        boolean z10;
        setContentView(R.layout.customize_contact_picker);
        this.f20572y = (AppBarLayout) findViewById(R.id.appbar);
        T2();
        ArrayList<IdRecord> arrayList = this.f20469b0;
        if (arrayList != null && (arrayList == null || arrayList.size() > 0)) {
            z10 = true;
        } else {
            z10 = false;
        }
        Y2(z10);
        A2();
        this.f20572y.getViewTreeObserver().addOnGlobalLayoutListener(new c());
    }

    public final void F2() {
        if (1 == this.f20462U && this.f20467Z) {
            this.f20468a0 = true;
            this.f20461T.r2();
            G2();
        }
        finish();
    }

    public final void G2() {
        this.f20475h0 = false;
        ArrayList<IdRecord> V22 = this.f20461T.V2();
        if (this.f20467Z && this.f20468a0) {
            V22 = new ArrayList<>();
        }
        int i10 = this.f20462U;
        if (i10 != 0) {
            if (i10 != 1 && i10 != 2 && i10 != 5) {
                if (i10 != 6) {
                    if (i10 != 7) {
                        if (i10 == 8) {
                            showDialog(8);
                            return;
                        }
                        return;
                    }
                    U2(V22, (Account) C7.e.j(this.f20466Y, "SRC_ACCOUNT"));
                    return;
                }
                showDialog(6);
                return;
            }
            if (1 == this.f20472e0) {
                showDialog(1);
                return;
            } else {
                S2(V22);
                return;
            }
        }
        R2(V22);
    }

    public final void H2(ArrayList<IdRecord> arrayList, Account account, Account account2) {
        Object valueOf;
        if (H7.a.b()) {
            StringBuilder sb = new StringBuilder();
            sb.append("exportContactsToSim: srcAccount = ");
            sb.append(account);
            sb.append(", destAccount = ");
            sb.append(account2);
            sb.append(", array size = ");
            if (arrayList == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(arrayList.size());
            }
            sb.append(valueOf);
            H7.b.b("MultiContactPickActivity", sb.toString());
        }
        Intent intent = new Intent("com.oplus.contacts.proc.COPY_CONTACTS_BETWEEN_ACCOUNTS");
        intent.setPackage(C7.e.g());
        C0810v.g(arrayList);
        intent.putExtra("SRC_ACCOUNT", account);
        intent.putExtra("DEST_ACCOUNT", account2);
        R7.b.c(this, intent);
        finish();
    }

    public int I2() {
        return this.f20461T.S2();
    }

    public int J2() {
        return this.f20461T.T2();
    }

    public final Dialog K2() {
        boolean Q02;
        i iVar = new i();
        Account account = (Account) C7.e.j(this.f20466Y, "account");
        if (account != null) {
            if (FeatureOption.i()) {
                Q02 = com.customize.contacts.util.b0.P0(this, account.f16941a);
            } else {
                Q02 = com.customize.contacts.util.b0.Q0(this, account.f16941a);
            }
            if (Q02) {
                return new COUIAlertDialogBuilder(this).setTitle(R.string.from_phone_to_sim).setMessage(R.string.data_usimdiscard_warning_copy).setPositiveButton(R.string.notify_import, (DialogInterface.OnClickListener) iVar).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) iVar).setOnCancelListener(iVar).show();
            }
        }
        return new COUIAlertDialogBuilder(this).setTitle(R.string.from_phone_to_sim).setMessage(R.string.data_discard_warning_copy).setPositiveButton(R.string.notify_import, (DialogInterface.OnClickListener) iVar).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) iVar).setOnCancelListener(iVar).show();
    }

    public final Dialog L2() {
        boolean Q02;
        k kVar = new k();
        Account account = (Account) C7.e.j(this.f20466Y, "DEST_ACCOUNT");
        if (account != null) {
            String d10 = com.customize.contacts.simcontacts.b.d(this, account.f16941a);
            if (FeatureOption.i()) {
                Q02 = com.customize.contacts.util.b0.P0(this, d10);
            } else {
                Q02 = com.customize.contacts.util.b0.Q0(this, d10);
            }
            if (Q02) {
                return new COUIAlertDialogBuilder(this).setTitle(R.string.export_to_sim_confirm).setMessage(R.string.data_usimdiscard_warning_copy).setPositiveButton(R.string.notify_export, (DialogInterface.OnClickListener) kVar).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) kVar).setOnCancelListener(kVar).show();
            }
        }
        return new COUIAlertDialogBuilder(this).setTitle(R.string.export_to_sim_confirm).setMessage(R.string.data_discard_warning_copy).setPositiveButton(R.string.notify_export, (DialogInterface.OnClickListener) kVar).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) kVar).setOnCancelListener(kVar).show();
    }

    public final Dialog M2() {
        f fVar = new f();
        return new COUIAlertDialogBuilder(this).setTitle(R.string.oplus_smart_company_add_title).setMessage((CharSequence) getString(R.string.oplus_smart_company_add_tips, this.f20464W)).setPositiveButton(R.string.confirm_description, (DialogInterface.OnClickListener) fVar).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) fVar).show();
    }

    public final void N2(ArrayList<IdRecord> arrayList, Account account, Account account2) {
        Object valueOf;
        if (H7.a.b()) {
            StringBuilder sb = new StringBuilder();
            sb.append("importContactsFromSim: srcAccount = ");
            sb.append(account);
            sb.append(", destAccount = ");
            sb.append(account2);
            sb.append(", array size = ");
            if (arrayList == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(arrayList.size());
            }
            sb.append(valueOf);
            H7.b.b("MultiContactPickActivity", sb.toString());
        }
        Intent intent = new Intent("com.oplus.contacts.proc.COPY_CONTACTS_BETWEEN_ACCOUNTS");
        intent.setPackage(C7.e.g());
        C0810v.g(arrayList);
        intent.putExtra("SRC_ACCOUNT", account);
        intent.putExtra("DEST_ACCOUNT", account2);
        intent.putExtra("imprort_sim_contacts", true);
        R7.b.c(this, intent);
        finish();
    }

    public final /* synthetic */ void P2(View view) {
        F2();
    }

    public final void Q2() {
        try {
            X.a b10 = X.a.b(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.contacts.action_SIM_ABSENT");
            b10.c(this.f20484q0, intentFilter);
        } catch (Exception e10) {
            H7.b.b("MultiContactPickActivity", "register local broadcast error" + e10);
        }
    }

    public void R2(ArrayList<IdRecord> arrayList) {
        Intent intent = new Intent("com.oplus.contacts.proc.ADD_CONTACTS_TO_STARRED");
        intent.putParcelableArrayListExtra("OLD_STARRED_CONTACTS", this.f20469b0);
        intent.putParcelableArrayListExtra("NEW_RET_CONTACTS", arrayList);
        intent.setPackage(C7.e.g());
        R7.b.c(this, intent);
        finish();
    }

    public void S2(ArrayList<IdRecord> arrayList) {
        new h().b();
        Intent intent = new Intent();
        if (this.f20471d0) {
            long[] jArr = new long[arrayList.size()];
            for (int i10 = 0; i10 != arrayList.size(); i10++) {
                jArr[i10] = arrayList.get(i10).b();
            }
            intent.putExtra("NEW_RET_CONTACTS", jArr);
        } else {
            intent.putParcelableArrayListExtra("NEW_RET_CONTACTS", arrayList);
        }
        setResult(-1, intent);
        finish();
    }

    public void T2() {
        COUIToolbar cOUIToolbar = this.f20571x;
        if (cOUIToolbar != null) {
            if (this.f20462U == 6) {
                cOUIToolbar.setSubtitle(getString(R.string.import_contacts_to_sim_tips_tablet));
            }
            this.f20571x.setTitle(R.string.contactPickerActivityTitle);
        }
    }

    public void U2(ArrayList<IdRecord> arrayList, Account account) {
        if (arrayList != null && arrayList.size() != 0) {
            new m(arrayList, account).execute(0);
        } else {
            com.oplus.foundation.util.ui.c.d(this, R.string.no_select_contacts);
        }
    }

    public final void V2() {
        if (this.f20484q0 == null) {
            return;
        }
        try {
            X.a.b(this).e(this.f20484q0);
        } catch (Exception e10) {
            H7.b.b("MultiContactPickActivity", "unregister local receiver error" + e10);
        }
    }

    public void W2() {
        boolean z10;
        boolean z11 = false;
        this.f20571x.getMenu().findItem(R.id.cancel).setVisible(false);
        int I22 = I2();
        int J22 = J2();
        if (H7.a.b()) {
            H7.b.b("MultiContactPickActivity", "markCount = " + I22 + ", totalCount() = " + J22);
        }
        if (I22 == J22 && J22 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f20190R = z10;
        MenuItem findItem = this.f20571x.getMenu().findItem(R.id.select_all);
        if (J22 != 0) {
            z11 = true;
        }
        findItem.setEnabled(z11);
    }

    public void X2() {
        boolean z10;
        if (this.f20461T.U2() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Y2(z10);
    }

    @Override // Z3.i
    public void a() {
        g2();
        X2();
        h2();
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public int a2() {
        return this.f20461T.U2();
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public int b2() {
        return this.f20461T.W2();
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public void d2() {
        super.d2();
        this.f20461T.r2();
        if (6 == this.f20462U) {
            HashMap hashMap = new HashMap();
            hashMap.put("selecte_all", Boolean.valueOf(this.f20190R));
            com.android.contacts.framework.baseui.util.A.a(getBaseContext(), 2000315, 200030139, hashMap, false);
        }
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public void e2(boolean z10) {
        this.f20461T.a3(z10);
        g2();
        X2();
    }

    @Override // Z3.i
    public void k() {
        if (!this.f20480m0) {
            return;
        }
        W2();
        g2();
        h2();
        X2();
        this.f20461T.Z2();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void n1() {
        h2();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean o1() {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 999) {
            boolean a10 = C0792c.a(this, i10, i11, intent);
            this.f20480m0 = a10;
            if (a10) {
                E2();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (U1()) {
            COUISearchBar cOUISearchBar = this.f20568p;
            if (cOUISearchBar != null) {
                cOUISearchBar.changeStateWithAnimation(0);
                return;
            }
            return;
        }
        F2();
        super.onBackPressed();
    }

    @Override // com.customize.contacts.activities.SearchAnimatorsActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f20466Y = getIntent();
        super.onCreate(bundle);
        this.f20479l0 = N7.a.a();
        this.f20480m0 = com.android.contacts.util.w.w(this);
        Intent intent = this.f20466Y;
        if (intent != null && !y2(intent.getAction())) {
            setResult(0);
            finish();
            return;
        }
        Account account = (Account) C7.e.j(this.f20466Y, "SRC_ACCOUNT");
        if (account != null && "com.android.oplus.sim".equals(account.f16942b)) {
            n nVar = new n(this, com.customize.contacts.simcontacts.b.j(account.f16941a));
            this.f20481n0 = nVar;
            nVar.execute(new Void[0]);
        }
        Intent intent2 = this.f20466Y;
        if (intent2 != null) {
            this.f20467Z = C7.e.c(intent2, "new_group", false);
        }
        if (bundle != null) {
            this.f20469b0 = bundle.getParcelableArrayList("initSelectedContacts");
            this.f20470c0 = bundle.getParcelableArrayList("initExceptContacts");
        }
        if (this.f20480m0) {
            E2();
        }
        Q2();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        if (6 == i10) {
            return K2();
        }
        if (8 == i10) {
            return L2();
        }
        if (1 == i10) {
            return M2();
        }
        return super.onCreateDialog(i10);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        V2();
        AsyncTask<Void, Void, Boolean> asyncTask = this.f20481n0;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                try {
                    this.f20481n0.cancel(true);
                } catch (Exception e10) {
                    H7.b.c("MultiContactPickActivity", "exception when cancel query sim status task " + e10);
                }
            }
            this.f20481n0 = null;
        }
        ThreadPoolExecutor threadPoolExecutor = this.f20479l0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            this.f20479l0 = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        boolean f10 = C0792c.f(this, i10, strArr, iArr);
        this.f20480m0 = f10;
        if (f10) {
            E2();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        com.customize.contacts.fragment.D d10 = this.f20461T;
        if (d10 != null) {
            bundle.putParcelableArrayList("initSelectedContacts", d10.V2());
        }
        bundle.putParcelableArrayList("initExceptContacts", this.f20470c0);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!V1() && motionEvent.getAction() == 0) {
            this.f20568p.changeStateWithAnimation(0);
        }
        return true;
    }

    public void returnSelectContacts() {
        if (this.f20461T.P2() > 2000) {
            this.mToastHintType = 1;
            com.oplus.foundation.util.ui.c.d(this, R.string.limit_reached_number_of_contacts);
            return;
        }
        if (this.f20461T.Y2()) {
            if (!this.f20475h0) {
                this.f20475h0 = true;
                this.f20474g0 = false;
                C0797h.a(this, new l(this), this.f20473f0);
                if (!this.f20474g0) {
                    this.f20476i0 = U0.k.o(this, getResources().getString(R.string.in_processing));
                    return;
                }
                return;
            }
            return;
        }
        G2();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void y0() {
        this.f20482o0 = (FrameLayout) findViewById(R.id.navigation_view_panel);
        COUINavigationView cOUINavigationView = (COUINavigationView) findViewById(R.id.navigation_view);
        this.f20483p0 = cOUINavigationView;
        cOUINavigationView.inflateMenu(R.menu.one_action);
        this.f20483p0.setOnNavigationItemSelectedListener(new g());
    }

    public boolean y2(String str) {
        Account account;
        if ("com.oplus.contacts.ui.SELECT_CONTACTS_ADD_TO_STARRED".equals(str)) {
            this.f20462U = 0;
            this.f20469b0 = C7.e.i(getIntent(), "NEW_RET_CONTACTS");
        } else if ("com.oplus.contacts.ui.SELECT_CONTACTS_ADD_TO_GROUP".equals(str)) {
            this.f20462U = 1;
            this.f20479l0.execute(new d());
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                account = null;
            } else {
                account = (Account) extras.getParcelable("android.provider.extra.ACCOUNT");
            }
            this.f20463V = account;
            if (extras != null) {
                this.f20477j0 = extras.getParcelableArrayList("writable_account");
            }
            ArrayList<IdRecord> i10 = C7.e.i(getIntent(), "NEW_RET_CONTACTS");
            this.f20470c0 = i10;
            if (i10 == null) {
                this.f20470c0 = C0810v.e(C0810v.f22183b);
            }
            this.f20464W = C7.e.l(getIntent(), "group_name");
            if (extras != null) {
                this.f20472e0 = extras.getInt("group_mode", 0);
            }
        } else if ("com.oplus.contacts.ui.SELECT_CONTACTS_ADD_TO_SPECIAL".equals(str)) {
            this.f20462U = 2;
            this.f20469b0 = C7.e.i(getIntent(), "NEW_RET_CONTACTS");
            this.f20465X = C7.e.c(getIntent(), "forRingtone", false);
        } else if ("com.oplus.contacts.ui.SELECT_CONTACTS_COPY_TO_SIM".equals(str)) {
            this.f20462U = 6;
        } else if (r0.f.n(str)) {
            this.f20462U = 5;
            this.f20471d0 = C7.e.c(getIntent(), "fromMms", false);
        } else if ("com.oplus.contacts.ui.SELECT_CONTACTS_IMPORT_FROM_SIM".equals(str)) {
            this.f20462U = 7;
        } else {
            if (!"com.oplus.contacts.ui.SELECT_CONTACTS_EXPORT_TO_SIM".equals(str)) {
                return false;
            }
            this.f20462U = 8;
        }
        return true;
    }

    public final void z2(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("clear", Boolean.TRUE);
        G7.c.d(contentResolver, R0.d.a(ContactsContract.Contacts.CONTENT_URI), contentValues);
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public void Y1() {
    }
}
