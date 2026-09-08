package com.customize.contacts.combine;

import U0.k;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.android.contacts.ContactsApplication;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.util.C;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.util.C0798i;
import com.customize.contacts.util.i0;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MergeSameNumberActivity extends BasicActivity implements COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: C, reason: collision with root package name */
    public static G3.b f20906C;

    /* renamed from: A, reason: collision with root package name */
    public COUIStatusBarResponseUtil f20907A;

    /* renamed from: r, reason: collision with root package name */
    public Handler f20912r;

    /* renamed from: x, reason: collision with root package name */
    public View[] f20913x;

    /* renamed from: z, reason: collision with root package name */
    public f f20915z;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList<e> f20909o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList<e> f20910p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    public int f20911q = 0;

    /* renamed from: y, reason: collision with root package name */
    public androidx.appcompat.app.b f20914y = null;

    /* renamed from: B, reason: collision with root package name */
    public ListView f20908B = null;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MergeSameNumberActivity.this.B1();
            C0798i.b(MergeSameNumberActivity.this.getApplicationContext());
            MergeSameNumberActivity.this.setResult(-1, (Intent) message.obj);
            MergeSameNumberActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            int headerViewsCount = MergeSameNumberActivity.this.f20908B.getHeaderViewsCount();
            if (i10 != 0 && headerViewsCount - 1 != i10) {
                if (i10 < MergeSameNumberActivity.this.f20908B.getHeaderViewsCount()) {
                    int i11 = i10 - 1;
                    if (MergeSameNumberActivity.this.f20911q != i11) {
                        MergeSameNumberActivity.this.f20911q = i11;
                        for (int i12 = 0; i12 < headerViewsCount - 2 && i12 < MergeSameNumberActivity.this.f20913x.length; i12++) {
                            if (i12 == i11) {
                                ((RadioButton) MergeSameNumberActivity.this.f20913x[i12].findViewById(R.id.radio)).setChecked(true);
                                ((e) MergeSameNumberActivity.this.f20909o.get(i12)).f20921b = true;
                            } else {
                                ((RadioButton) MergeSameNumberActivity.this.f20913x[i12].findViewById(R.id.radio)).setChecked(false);
                                ((e) MergeSameNumberActivity.this.f20909o.get(i12)).f20921b = false;
                            }
                        }
                        return;
                    }
                    return;
                }
                int i13 = i10 - headerViewsCount;
                boolean z10 = ((e) MergeSameNumberActivity.this.f20910p.get(i13)).f20921b;
                ((e) MergeSameNumberActivity.this.f20910p.get(i13)).f20921b = !z10;
                C.b(view, !z10);
                MergeSameNumberActivity.this.f20915z.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            G3.c f10 = G3.c.f(MergeSameNumberActivity.this);
            if (MergeSameNumberActivity.this.f20911q < MergeSameNumberActivity.this.f20909o.size()) {
                str = ((e) MergeSameNumberActivity.this.f20909o.get(MergeSameNumberActivity.this.f20911q)).f20920a;
            } else {
                str = "";
            }
            ArrayList<String> C12 = MergeSameNumberActivity.this.C1();
            Intent intent = new Intent();
            Message message = new Message();
            HashMap hashMap = new HashMap();
            hashMap.put("view_position", Integer.valueOf(MergeSameNumberActivity.this.f20911q));
            hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(MergeSameNumberActivity.this.f20910p.size()));
            hashMap.put("selected_count", Integer.valueOf(C12.size()));
            A.a(MergeSameNumberActivity.this.getBaseContext(), 2000317, 200030168, hashMap, false);
            try {
                if (f10.r(MergeSameNumberActivity.f20906C, str, C12, "numberMerge")) {
                    intent.putExtra("chosen_contacts_position", C7.e.d(MergeSameNumberActivity.this.getIntent(), "chosen_contacts_position", -1));
                    intent.putExtra("checked_name", str);
                    intent.putExtra("checked_numbers", C12);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                message.obj = intent;
                MergeSameNumberActivity.this.f20912r.sendMessage(message);
                throw th;
            }
            message.obj = intent;
            MergeSameNumberActivity.this.f20912r.sendMessage(message);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BottomNavigationView.c {
        public d() {
        }

        @Override // com.google.android.material.navigation.NavigationBarView.c
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            if (menuItem != null && menuItem.getItemId() == R.id.delete) {
                MergeSameNumberActivity.this.G1();
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f20920a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f20921b;

        public e(String str, boolean z10) {
            this.f20920a = str;
            this.f20921b = z10;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends ArrayAdapter {
        public f(Context context, int i10) {
            super(context, i10);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return MergeSameNumberActivity.this.f20910p.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Object getItem(int i10) {
            return MergeSameNumberActivity.this.f20910p.get(i10);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.single_row_list_item, viewGroup, false);
            }
            view.findViewById(R.id.radio).setVisibility(8);
            ((TextView) view.findViewById(R.id.text)).setText(((e) MergeSameNumberActivity.this.f20910p.get(i10)).f20920a);
            ((CheckBox) view.findViewById(R.id.check)).setChecked(((e) MergeSameNumberActivity.this.f20910p.get(i10)).f20921b);
            int positionInGroup = COUICardListHelper.getPositionInGroup(getCount(), i10);
            if (positionInGroup != 1 && positionInGroup != 2) {
                view.findViewById(R.id.bottom_divider).setVisibility(8);
            } else {
                view.findViewById(R.id.bottom_divider).setVisibility(0);
            }
            COUICardListHelper.setItemCardBackground(view, positionInGroup);
            C.b(view, ((e) MergeSameNumberActivity.this.f20910p.get(i10)).f20921b);
            return view;
        }
    }

    private void A1() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.v(4, 4);
            supportActionBar.w(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1() {
        androidx.appcompat.app.b bVar = this.f20914y;
        if (bVar != null && bVar.isShowing()) {
            this.f20914y.dismiss();
        }
        this.f20914y = null;
    }

    public static void F1(G3.b bVar) {
        f20906C = bVar;
    }

    private void H1() {
        Thread thread = new Thread(new c());
        thread.setDaemon(true);
        thread.start();
    }

    public final ArrayList<String> C1() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < this.f20910p.size(); i10++) {
            if (this.f20910p.get(i10).f20921b) {
                arrayList.add(this.f20910p.get(i10).f20920a);
            }
        }
        return arrayList;
    }

    public final void D1() {
        E1();
        if (this.f20908B == null) {
            ListView listView = (ListView) findViewById(R.id.list);
            this.f20908B = listView;
            f fVar = new f(this, R.layout.single_row_list_item);
            this.f20915z = fVar;
            listView.setAdapter((ListAdapter) fVar);
        }
        LayoutInflater from = LayoutInflater.from(this);
        if (this.f20909o.size() > 0) {
            View inflate = from.inflate(R.layout.merge_title, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.title)).setText(R.string.checked_name);
            inflate.setEnabled(false);
            inflate.setFocusable(false);
            inflate.setBackground(null);
            this.f20908B.addHeaderView(inflate);
            int size = this.f20909o.size();
            this.f20913x = new View[size];
            for (int i10 = 0; i10 < size; i10++) {
                View inflate2 = from.inflate(R.layout.single_row_list_item, (ViewGroup) null);
                TextView textView = (TextView) inflate2.findViewById(R.id.text);
                if (i10 == size - 1) {
                    inflate2.findViewById(R.id.bottom_divider).setVisibility(8);
                } else {
                    inflate2.findViewById(R.id.bottom_divider).setVisibility(0);
                }
                if (ContactsApplication.f13094j) {
                    textView.setGravity(5);
                } else {
                    textView.setGravity(3);
                }
                textView.setText(this.f20909o.get(i10).f20920a);
                RadioButton radioButton = (RadioButton) inflate2.findViewById(R.id.radio);
                radioButton.setVisibility(0);
                radioButton.setChecked(this.f20909o.get(i10).f20921b);
                inflate2.findViewById(R.id.check).setVisibility(8);
                COUICardListHelper.setItemCardBackground(inflate2, COUICardListHelper.getPositionInGroup(this.f20909o.size(), i10));
                this.f20908B.addHeaderView(inflate2);
                this.f20913x[i10] = inflate2;
            }
        }
        View inflate3 = from.inflate(R.layout.merge_title, (ViewGroup) null);
        ((TextView) inflate3.findViewById(R.id.title)).setText(R.string.checked_numbers);
        inflate3.setEnabled(false);
        inflate3.setFocusable(false);
        inflate3.setBackground(null);
        this.f20908B.addHeaderView(inflate3);
        this.f20908B.setOnItemClickListener(new b());
    }

    public final void E1() {
        this.f20909o.clear();
        this.f20910p.clear();
        this.f20909o.add(new e(f20906C.f1093c, true));
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.add(f20906C.f1093c);
        Iterator<String> it = f20906C.f1096f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!hashSet2.contains(next)) {
                this.f20910p.add(new e(next, true));
                hashSet2.add(next);
            }
        }
        Iterator<G3.a> it2 = f20906C.f1101k.iterator();
        while (it2.hasNext()) {
            G3.a next2 = it2.next();
            if (!hashSet.contains(next2.f1093c)) {
                this.f20909o.add(new e(next2.f1093c, false));
                hashSet.add(next2.f1093c);
            }
            Iterator<String> it3 = next2.f1096f.iterator();
            while (it3.hasNext()) {
                String next3 = it3.next();
                if (!hashSet2.contains(next3)) {
                    this.f20910p.add(new e(next3, true));
                    hashSet2.add(next3);
                }
            }
        }
        hashSet.clear();
        hashSet2.clear();
        HashMap hashMap = new HashMap();
        hashMap.put("name_count", Integer.valueOf(this.f20909o.size()));
        hashMap.put("number_count", Integer.valueOf(this.f20910p.size()));
        A.a(getBaseContext(), 2000317, 200030167, hashMap, false);
    }

    public void G1() {
        this.f20914y = k.o(this, getString(R.string.merging));
        H1();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean o1() {
        return false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (f20906C == null) {
            finish();
            return;
        }
        setContentView(R.layout.merge_contacts_number);
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        D1();
        setSupportActionBar(cOUIToolbar);
        A1();
        this.f20912r = new a();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.list_padding_top) + getResources().getDimensionPixelSize(R.dimen.divider_background_height);
        this.f20908B.setPadding(0, dimensionPixelSize, 0, o0());
        this.f20908B.smoothScrollByOffset(-dimensionPixelSize);
        this.f20908B.setNestedScrollingEnabled(true);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f20907A = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        f20906C = null;
        B1();
        super.onDestroy();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (f20906C == null) {
            finish();
        } else {
            D1();
        }
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
        i0.b();
        this.f20907A.onPause();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f20907A.onResume();
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        i0.d(this, this.f20908B);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void y0() {
        COUINavigationView cOUINavigationView = (COUINavigationView) findViewById(R.id.navigation_view);
        cOUINavigationView.inflateMenu(R.menu.one_action);
        MenuItem findItem = cOUINavigationView.getMenu().findItem(R.id.delete);
        findItem.setTitle(R.string.merge);
        findItem.setIcon(R.drawable.pb_dr_menu_merge);
        cOUINavigationView.setOnNavigationItemSelectedListener(new d());
    }
}
