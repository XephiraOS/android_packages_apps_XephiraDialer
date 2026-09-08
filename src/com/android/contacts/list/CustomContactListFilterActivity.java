package com.android.contacts.list;

import U0.k;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.EntityIterator;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.app.a;
import androidx.recyclerview.widget.COUILinearLayoutManager;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.android.contacts.ContactsActivity;
import com.android.contacts.list.CustomContactListFilterActivity;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.C;
import com.android.contacts.util.D;
import com.android.contacts.util.EmptyService;
import com.android.contacts.util.p;
import com.coui.appcompat.expandable.COUIExpandableRecyclerView;
import com.coui.appcompat.rotateview.COUIRotateView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.b0;
import com.google.common.collect.n;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n1.AbstractC1362a;
import q7.C1493b;
import q7.InterfaceC1492a;

/* loaded from: classes.dex */
public class CustomContactListFilterActivity extends ContactsActivity implements COUIExpandableRecyclerView.OnChildClickListener, COUIExpandableRecyclerView.OnGroupClickListener, a.InterfaceC0129a<AccountSet> {

    /* renamed from: q, reason: collision with root package name */
    public com.android.contacts.list.b f16851q;

    /* renamed from: r, reason: collision with root package name */
    public final InterfaceC1492a f16852r = new C1493b();

    /* loaded from: classes.dex */
    public static class AccountSet extends ArrayList<a> {
        public ArrayList<ContentProviderOperation> a() {
            ArrayList<ContentProviderOperation> f10 = n.f();
            Iterator<a> it = iterator();
            while (it.hasNext()) {
                it.next().c(f10);
            }
            return f10;
        }
    }

    /* loaded from: classes.dex */
    public static class GroupDelta extends EntityDelta.ValuesDelta {

        /* renamed from: i, reason: collision with root package name */
        public boolean f16854i;

        /* renamed from: h, reason: collision with root package name */
        public boolean f16853h = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f16855j = false;

        public static GroupDelta w0(ContentValues contentValues) {
            GroupDelta groupDelta = new GroupDelta();
            groupDelta.f16992a = null;
            groupDelta.f16993b = contentValues;
            return groupDelta;
        }

        public static GroupDelta x0(ContentValues contentValues) {
            GroupDelta groupDelta = new GroupDelta();
            groupDelta.f16992a = contentValues;
            groupDelta.f16993b = new ContentValues();
            return groupDelta;
        }

        public static GroupDelta y0(ContentResolver contentResolver, String str, String str2, String str3, boolean z10) {
            String str4;
            ContentValues contentValues;
            int i10;
            Uri.Builder buildUpon = ContactsContract.Settings.CONTENT_URI.buildUpon();
            if (str == null && str2 == null) {
                str4 = "account_name IS NULL AND account_type IS NULL";
            } else {
                buildUpon.appendQueryParameter("account_name", str).appendQueryParameter("account_type", str2);
                str4 = null;
            }
            String str5 = str4;
            if (str3 != null) {
                buildUpon.appendQueryParameter("data_set", str3);
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("account_name", str);
            contentValues2.put("account_type", str2);
            contentValues2.put("data_set", str3);
            try {
                Uri build = buildUpon.build();
                contentValues = contentValues2;
                try {
                    Cursor query = contentResolver.query(build, new String[]{"should_sync", "ungrouped_visible"}, str5, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                if (TextUtils.equals(R0.a.f3166b, str2)) {
                                    i10 = 1;
                                } else {
                                    i10 = query.getInt(0);
                                }
                                contentValues.put("should_sync", Integer.valueOf(i10));
                                contentValues.put("ungrouped_visible", Integer.valueOf(query.getInt(1)));
                                GroupDelta F02 = x0(contentValues).F0(z10);
                                query.close();
                                return F02;
                            }
                        } finally {
                        }
                    }
                    contentValues.put("should_sync", (Integer) 1);
                    contentValues.put("ungrouped_visible", (Integer) 0);
                    GroupDelta F03 = w0(contentValues).F0(z10);
                    if (query != null) {
                        query.close();
                    }
                    return F03;
                } catch (Exception e10) {
                    e = e10;
                    H7.b.c("CustomFilterActivity", "" + e);
                    contentValues.put("should_sync", (Integer) 1);
                    contentValues.put("ungrouped_visible", (Integer) 0);
                    return w0(contentValues).F0(z10);
                }
            } catch (Exception e11) {
                e = e11;
                contentValues = contentValues2;
            }
        }

        public boolean A0() {
            return this.f16855j;
        }

        public boolean B0() {
            if (w("should_sync", 1).intValue() != 0) {
                return true;
            }
            return false;
        }

        public CharSequence C0(Context context) {
            if (this.f16853h) {
                String a10 = p.a(context, z0());
                if (a10 != null) {
                    return a10;
                }
                if (this.f16854i) {
                    return context.getText(R.string.display_ungrouped);
                }
                return context.getText(R.string.display_all_contacts);
            }
            Integer v10 = v("title_res");
            if (v10 != null) {
                return context.getPackageManager().getText(z("res_package"), v10.intValue(), null);
            }
            return z("title");
        }

        public void D0(boolean z10) {
            String str;
            if (this.f16853h) {
                str = "ungrouped_visible";
            } else {
                str = "group_visible";
            }
            b0(str, z10 ? 1 : 0);
        }

        public void E0(boolean z10) {
            this.f16855j = z10;
        }

        public GroupDelta F0(boolean z10) {
            this.f16853h = true;
            this.f16854i = z10;
            return this;
        }

        @Override // com.android.contacts.model.EntityDelta.ValuesDelta
        public boolean h() {
            if (this.f16992a != null) {
                return true;
            }
            return false;
        }

        public ContentProviderOperation v0() {
            StringBuilder sb;
            String[] strArr = null;
            if (K()) {
                if (this.f16853h) {
                    this.f16993b.remove(this.f16994c);
                    return ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Settings.CONTENT_URI)).withValues(this.f16993b).build();
                }
                H7.b.c("CustomFilterActivity", "Unexpected diff");
                return null;
            }
            if (!Q()) {
                return null;
            }
            if (this.f16853h) {
                String z10 = z("account_name");
                String z11 = z("account_type");
                String z12 = z("data_set");
                if (z10 == null && z11 == null) {
                    sb = new StringBuilder("account_name IS NULL AND account_type IS NULL");
                } else {
                    StringBuilder sb2 = new StringBuilder("account_name=? AND account_type=?");
                    if (z12 == null) {
                        sb2.append(" AND data_set IS NULL");
                        String[] strArr2 = {z10, z11};
                        sb = sb2;
                        strArr = strArr2;
                    } else {
                        sb2.append(" AND data_set=?");
                        String[] strArr3 = {z10, z11, z12};
                        sb = sb2;
                        strArr = strArr3;
                    }
                }
                return ContentProviderOperation.newUpdate(ContactsContract.Settings.CONTENT_URI).withSelection(sb.toString(), strArr).withValues(this.f16993b).build();
            }
            return ContentProviderOperation.newUpdate(CustomContactListFilterActivity.r1()).withSelection("_id=" + E(), null).withValues(this.f16993b).build();
        }

        public final String z0() {
            ContentValues contentValues = this.f16992a;
            if (contentValues == null) {
                contentValues = this.f16993b;
            }
            return contentValues.getAsString("account_type");
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f16856a;

        /* renamed from: b, reason: collision with root package name */
        public final String f16857b;

        /* renamed from: c, reason: collision with root package name */
        public final String f16858c;

        /* renamed from: d, reason: collision with root package name */
        public GroupDelta f16859d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<GroupDelta> f16860e = n.f();

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<GroupDelta> f16861f = n.f();

        public a(String str, String str2, String str3) {
            this.f16856a = str;
            this.f16857b = str2;
            this.f16858c = str3;
        }

        public final void b(GroupDelta groupDelta) {
            if (groupDelta.B0()) {
                this.f16860e.add(groupDelta);
            } else {
                this.f16861f.add(groupDelta);
            }
        }

        public void c(ArrayList<ContentProviderOperation> arrayList) {
            Iterator<GroupDelta> it = this.f16860e.iterator();
            while (it.hasNext()) {
                ContentProviderOperation v02 = it.next().v0();
                if (v02 != null) {
                    arrayList.add(v02);
                }
            }
            Iterator<GroupDelta> it2 = this.f16861f.iterator();
            while (it2.hasNext()) {
                ContentProviderOperation v03 = it2.next().v0();
                if (v03 != null) {
                    arrayList.add(v03);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends W.a<AccountSet> {

        /* renamed from: p, reason: collision with root package name */
        public AccountSet f16862p;

        public b(Context context) {
            super(context);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void L(List<a> list) {
            int i10;
            boolean z10;
            int i11;
            if (!FeatureOption.k()) {
                return;
            }
            if (B3.a.i()) {
                boolean m02 = b0.m0(i(), 0);
                z10 = b0.m0(i(), 1);
                i11 = m02;
            } else {
                if (!b0.m0(i(), 0) && !b0.m0(i(), 1)) {
                    i10 = 0;
                } else {
                    i10 = 1;
                }
                z10 = false;
                i11 = i10;
            }
            if (i11 != 0 && z10) {
                list.add(new a(com.customize.contacts.simcontacts.b.g(0), "com.android.oplus.sim", null));
                list.add(new a(com.customize.contacts.simcontacts.b.g(1), "com.android.oplus.sim", null));
            } else if (i11 != 0 || z10) {
                list.add(new a(com.customize.contacts.simcontacts.b.g(i11 ^ 1), "com.android.oplus.sim", null));
            }
        }

        @Override // W.c
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public void f(AccountSet accountSet) {
            if (l()) {
                return;
            }
            this.f16862p = accountSet;
            if (m()) {
                super.f(accountSet);
            }
        }

        @Override // W.a
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public AccountSet I() {
            String str;
            boolean z10;
            boolean z11;
            Context i10 = i();
            AbstractC1362a h10 = AbstractC1362a.h(i10);
            ContentResolver contentResolver = i10.getContentResolver();
            ArrayList f10 = n.f();
            AccountSet accountSet = new AccountSet();
            for (AccountWithDataSet accountWithDataSet : h10.g(false)) {
                if (!h10.e(accountWithDataSet).o() || accountWithDataSet.i(i10)) {
                    f10.add(new a(accountWithDataSet.f16941a, accountWithDataSet.f16942b, accountWithDataSet.f16970c));
                }
            }
            L(f10);
            Iterator it = f10.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                Uri.Builder buildUpon = ContactsContract.Groups.CONTENT_URI.buildUpon();
                String str2 = aVar.f16856a;
                if (str2 != null && aVar.f16857b != null) {
                    buildUpon.appendQueryParameter("account_name", str2).appendQueryParameter("account_type", aVar.f16857b);
                    String str3 = aVar.f16858c;
                    if (str3 != null) {
                        buildUpon.appendQueryParameter("data_set", str3).build();
                    }
                }
                if (!B3.a.q(i10)) {
                    str = "deleted = 0";
                } else {
                    str = "deleted = 0 AND title!='Business Card in ColorOS'";
                }
                EntityIterator entityIterator = null;
                try {
                    try {
                        Cursor query = contentResolver.query(buildUpon.build(), null, str, null, null);
                        if (query != null) {
                            boolean z12 = true;
                            if (!TextUtils.equals(aVar.f16857b, "com.android.oplus.sim")) {
                                entityIterator = ContactsContract.Groups.newEntityIterator(query);
                                z10 = false;
                                while (entityIterator.hasNext()) {
                                    GroupDelta x02 = GroupDelta.x0(((Entity) entityIterator.next()).getEntityValues());
                                    aVar.b(x02);
                                    if (x02.w("group_visible", 0).intValue() != 0) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    x02.E0(z11);
                                    z10 = true;
                                }
                            } else {
                                z10 = false;
                            }
                            GroupDelta y02 = GroupDelta.y0(contentResolver, aVar.f16856a, aVar.f16857b, aVar.f16858c, z10);
                            aVar.f16859d = y02;
                            aVar.b(y02);
                            if (aVar.f16859d.w("ungrouped_visible", 0).intValue() == 0) {
                                z12 = false;
                            }
                            aVar.f16859d.E0(z12);
                        }
                    } catch (Exception e10) {
                        H7.b.c("CustomFilterActivity", "" + e10);
                        if (0 == 0) {
                        }
                    }
                    if (entityIterator == null) {
                        accountSet.add(aVar);
                    }
                    entityIterator.close();
                    accountSet.add(aVar);
                } catch (Throwable th) {
                    if (0 != 0) {
                        entityIterator.close();
                    }
                    throw th;
                }
            }
            return accountSet;
        }

        @Override // W.c
        public void r() {
            super.r();
            t();
            this.f16862p = null;
        }

        @Override // W.c
        public void s() {
            AccountSet accountSet = this.f16862p;
            if (accountSet != null) {
                f(accountSet);
            }
            if (A() || this.f16862p == null) {
                h();
            }
        }

        @Override // W.c
        public void t() {
            b();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends D<ArrayList<ContentProviderOperation>, Void, Void, Activity> {

        /* renamed from: b, reason: collision with root package name */
        public androidx.appcompat.app.b f16863b;

        public c(Activity activity) {
            super(activity);
        }

        @Override // com.android.contacts.util.D
        @SafeVarargs
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Void a(Activity activity, ArrayList<ContentProviderOperation>... arrayListArr) {
            try {
                activity.getContentResolver().applyBatch("com.android.contacts", arrayListArr[0]);
                return null;
            } catch (OperationApplicationException | RemoteException e10) {
                H7.b.c("CustomFilterActivity", "Problem saving display groups" + e10);
                return null;
            } catch (Exception e11) {
                H7.b.c("CustomFilterActivity", "Problem saving display settings" + e11);
                return null;
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(Activity activity, Void r32) {
            try {
                this.f16863b.dismiss();
            } catch (Exception e10) {
                H7.b.c("CustomFilterActivity", "Error dismissing progress dialog" + e10);
            }
            activity.stopService(new Intent(activity, (Class<?>) EmptyService.class));
            activity.finish();
        }

        @Override // com.android.contacts.util.D
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(Activity activity) {
            if (this.f16863b == null) {
                this.f16863b = k.o(activity, activity.getString(R.string.savingDisplayGroups));
            }
            androidx.appcompat.app.b bVar = this.f16863b;
            if (bVar != null) {
                J3.e.b(bVar);
            }
            activity.startService(new Intent(activity, (Class<?>) EmptyService.class));
        }
    }

    public static /* bridge */ /* synthetic */ Uri r1() {
        return s1();
    }

    public static Uri s1() {
        return ContactsContract.Groups.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
    }

    private void t1() {
        com.android.contacts.list.b bVar = this.f16851q;
        if (bVar != null && bVar.b() != null) {
            setResult(-1);
            ArrayList<ContentProviderOperation> a10 = this.f16851q.b().a();
            if (a10.isEmpty()) {
                finish();
                return;
            } else {
                new c(this).execute(a10);
                return;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(View view) {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean v1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.save) {
            t1();
            return true;
        }
        return true;
    }

    @Override // androidx.loader.app.a.InterfaceC0129a
    public void Q(W.c<AccountSet> cVar) {
        this.f16851q.e(null);
        this.f16851q.notifyDataSetChanged();
    }

    @Override // androidx.loader.app.a.InterfaceC0129a
    public W.c<AccountSet> Z(int i10, Bundle bundle) {
        return new b(this);
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerView.OnChildClickListener
    public boolean onChildClick(COUIRecyclerView cOUIRecyclerView, View view, int i10, int i11, long j10) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.check_box);
        GroupDelta groupDelta = (GroupDelta) this.f16851q.getChild(i10, i11);
        if (groupDelta != null) {
            checkBox.toggle();
            groupDelta.D0(checkBox.isChecked());
            groupDelta.E0(checkBox.isChecked());
            this.f16851q.notifyDataSetChanged();
            return true;
        }
        H7.b.c("CustomFilterActivity", "child == null");
        return true;
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.contact_list_filter_custom);
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        cOUIToolbar.setIsTitleCenterStyle(false);
        cOUIToolbar.setTitle(R.string.list_filter_custom);
        cOUIToolbar.setNavigationIcon(R.drawable.coui_back_arrow);
        cOUIToolbar.setNavigationContentDescription(R.string.abc_action_bar_up_description);
        cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: m1.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomContactListFilterActivity.this.u1(view);
            }
        });
        cOUIToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: m1.r
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean v12;
                v12 = CustomContactListFilterActivity.this.v1(menuItem);
                return v12;
            }
        });
        cOUIToolbar.inflateMenu(R.menu.cancel_save_menu);
        cOUIToolbar.getMenu().findItem(R.id.cancel).setVisible(false);
        COUIExpandableRecyclerView cOUIExpandableRecyclerView = (COUIExpandableRecyclerView) findViewById(R.id.account_recycler_view);
        cOUIExpandableRecyclerView.setLayoutManager(new COUILinearLayoutManager(this));
        cOUIExpandableRecyclerView.setOnChildClickListener(this);
        cOUIExpandableRecyclerView.setOnGroupClickListener(this);
        com.android.contacts.list.b bVar = new com.android.contacts.list.b(this, null);
        this.f16851q = bVar;
        cOUIExpandableRecyclerView.setAdapter(bVar);
        C.c(this, cOUIExpandableRecyclerView, getResources().getDimensionPixelSize(R.dimen.DP_30));
        cOUIExpandableRecyclerView.setClipToPadding(false);
        cOUIExpandableRecyclerView.setNestedScrollingEnabled(true);
        this.f16852r.T0(this, cOUIExpandableRecyclerView, null);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f16852r.F();
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerView.OnGroupClickListener
    public boolean onGroupClick(COUIExpandableRecyclerView cOUIExpandableRecyclerView, View view, int i10, long j10) {
        COUIRotateView cOUIRotateView = (COUIRotateView) view.findViewById(R.id.rotate_view);
        if (cOUIRotateView != null) {
            cOUIRotateView.setExpanded(!cOUIRotateView.isExpanded());
            return false;
        }
        return false;
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f16852r.H0();
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f16852r.H0();
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        getSupportLoaderManager().e(1, null, this);
        super.onStart();
    }

    @Override // androidx.loader.app.a.InterfaceC0129a
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public void S0(W.c<AccountSet> cVar, AccountSet accountSet) {
        this.f16851q.e(accountSet);
        this.f16851q.notifyDataSetChanged();
    }
}
