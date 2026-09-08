package com.customize.contacts.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.C0637b;
import com.coloros.contacts.common.ContactParcelable;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.util.C0808t;
import com.customize.contacts.util.ContactsPhonesUtils$PhoneItem;
import com.google.android.material.navigation.NavigationBarView;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MultiPhonesSelectActivity extends BasicActivity implements COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: B, reason: collision with root package name */
    public static final ArrayList<C0808t> f20525B = new ArrayList<>();

    /* renamed from: A, reason: collision with root package name */
    public COUIStatusBarResponseUtil f20526A;

    /* renamed from: o, reason: collision with root package name */
    public int f20527o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<ContactsPhonesUtils$PhoneItem> f20528p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    public c f20529q;

    /* renamed from: r, reason: collision with root package name */
    public COUIListView f20530r;

    /* renamed from: x, reason: collision with root package name */
    public COUIToolbar f20531x;

    /* renamed from: y, reason: collision with root package name */
    public COUINavigationView f20532y;

    /* renamed from: z, reason: collision with root package name */
    public int f20533z;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            int i11;
            boolean z10 = ((ContactsPhonesUtils$PhoneItem) MultiPhonesSelectActivity.this.f20528p.get(i10)).f21875h;
            int i12 = MultiPhonesSelectActivity.this.f20527o;
            ((ContactsPhonesUtils$PhoneItem) MultiPhonesSelectActivity.this.f20528p.get(i10)).b(!z10);
            MultiPhonesSelectActivity multiPhonesSelectActivity = MultiPhonesSelectActivity.this;
            if (z10) {
                i11 = multiPhonesSelectActivity.f20527o - 1;
            } else {
                i11 = multiPhonesSelectActivity.f20527o + 1;
            }
            multiPhonesSelectActivity.f20527o = i11;
            multiPhonesSelectActivity.f20527o = i11;
            MultiPhonesSelectActivity.this.F1();
            if (MultiPhonesSelectActivity.this.f20528p.size() == MultiPhonesSelectActivity.this.f20527o || MultiPhonesSelectActivity.this.f20528p.size() == i12) {
                MultiPhonesSelectActivity.this.D1();
            }
            MultiPhonesSelectActivity.this.f20529q.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MultiPhonesSelectActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ArrayAdapter<ContactsPhonesUtils$PhoneItem> {

        /* renamed from: a, reason: collision with root package name */
        public LayoutInflater f20536a;

        public c(Context context, int i10) {
            super(context, i10);
            this.f20536a = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactsPhonesUtils$PhoneItem getItem(int i10) {
            return (ContactsPhonesUtils$PhoneItem) MultiPhonesSelectActivity.this.f20528p.get(i10);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return MultiPhonesSelectActivity.this.f20528p.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f20536a.inflate(R.layout.double_rows, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.number);
            String str = ((ContactsPhonesUtils$PhoneItem) MultiPhonesSelectActivity.this.f20528p.get(i10)).f21872e;
            if (C0637b.h()) {
                str = C0637b.d(str);
            }
            textView.setText(str);
            TextView textView2 = (TextView) view.findViewById(R.id.name);
            View findViewById = view.findViewById(R.id.bottom_divider);
            if (i10 != 0 && ((ContactsPhonesUtils$PhoneItem) MultiPhonesSelectActivity.this.f20528p.get(i10)).f21868a == ((ContactsPhonesUtils$PhoneItem) MultiPhonesSelectActivity.this.f20528p.get(i10 - 1)).f21868a) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                String str2 = ((ContactsPhonesUtils$PhoneItem) MultiPhonesSelectActivity.this.f20528p.get(i10)).f21870c;
                if (C0637b.h()) {
                    str2 = C0637b.c(str2);
                }
                textView2.setText(str2);
            }
            if (i10 == getCount() - 1) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            ((CheckBox) view.findViewById(R.id.checkbox)).setChecked(((ContactsPhonesUtils$PhoneItem) MultiPhonesSelectActivity.this.f20528p.get(i10)).f21875h);
            return view;
        }
    }

    private void B1(ArrayList<ContactParcelable> arrayList) {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("SELECTED_CONTACTS", arrayList);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        if (this.f20531x != null) {
            if (this.f20528p.size() == this.f20527o) {
                this.f20531x.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectcancel);
            } else {
                this.f20531x.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectall);
            }
        }
    }

    private void E1(boolean z10) {
        this.f20532y.getMenu().findItem(R.id.delete).setEnabled(z10);
    }

    public void A1() {
        boolean z10;
        if (this.f20528p.size() != this.f20527o) {
            z10 = true;
        } else {
            z10 = false;
        }
        C1(z10);
        D1();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void B0() {
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        this.f20531x = cOUIToolbar;
        cOUIToolbar.setNavigationOnClickListener(new b());
        this.f20531x.setOnMenuItemClickListener(new Toolbar.g() { // from class: com.customize.contacts.activities.j0
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z12;
                z12 = MultiPhonesSelectActivity.this.z1(menuItem);
                return z12;
            }
        });
        this.f20531x.setNavigationIcon((Drawable) null);
        this.f20531x.setIsTitleCenterStyle(true);
        this.f20531x.inflateMenu(R.menu.cancel_select_menu);
    }

    public final void C1(boolean z10) {
        int size = this.f20528p.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f20528p.get(i10).b(z10);
        }
        if (z10) {
            this.f20527o = size;
        } else {
            this.f20527o = 0;
        }
        F1();
        this.f20529q.notifyDataSetChanged();
    }

    public final void F1() {
        if (this.f20531x != null) {
            if (H7.a.b()) {
                H7.b.b("MultiPhonesSelectActivity", "updateTitle mSelectedCount:" + this.f20527o);
            }
            if (this.f20533z == 3) {
                if (this.f20527o > 0) {
                    this.f20531x.setTitle(String.format(getString(R.string.select_items), Integer.valueOf(this.f20527o)));
                    return;
                } else {
                    this.f20531x.setTitle(R.string.oplus_select_email);
                    return;
                }
            }
            if (this.f20527o > 0) {
                this.f20531x.setTitle(String.format(getString(R.string.select_items), Integer.valueOf(U7.a.b(this.f20527o))));
            } else {
                this.f20531x.setTitle(R.string.oplus_select_phones);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.zoom_fade_enter, R.anim.coui_push_down_exit_activitydialog);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean o1() {
        return false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ArrayList<C0808t> arrayList = f20525B;
        if (arrayList.size() == 0 && bundle == null) {
            arrayList.clear();
            finish();
            return;
        }
        this.f20527o = arrayList.size();
        for (int i10 = 0; i10 < this.f20527o; i10++) {
            this.f20528p.addAll(f20525B.get(i10).f22181c);
        }
        f20525B.clear();
        if (bundle != null) {
            this.f20528p = bundle.getParcelableArrayList("PhoneItem");
            this.f20527o = bundle.getInt("SelectedCount", this.f20527o);
        }
        ArrayList<ContactsPhonesUtils$PhoneItem> arrayList2 = this.f20528p;
        if (arrayList2 != null && arrayList2.size() != 0) {
            setContentView(R.layout.multi_phones_select_activity);
            this.f20530r = (COUIListView) findViewById(R.id.list);
            c cVar = new c(this, R.layout.double_rows);
            this.f20529q = cVar;
            this.f20530r.setAdapter((ListAdapter) cVar);
            this.f20530r.setOnItemClickListener(new a());
            this.f20533z = C7.e.d(getIntent(), "mode", 0);
            F1();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.divider_background_height);
            this.f20530r.setPadding(0, dimensionPixelSize, 0, o0());
            this.f20530r.smoothScrollByOffset(-dimensionPixelSize);
            this.f20530r.setClipToPadding(false);
            this.f20530r.setNestedScrollingEnabled(true);
            this.f20530r.setDivider(null);
            E1(true);
            COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
            this.f20526A = cOUIStatusBarResponseUtil;
            cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
            return;
        }
        finish();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ArrayList<C0808t> arrayList = f20525B;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.customize.contacts.util.i0.b();
        this.f20526A.onPause();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f20526A.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelableArrayList("PhoneItem", this.f20528p);
        bundle.putInt("SelectedCount", this.f20527o);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        com.customize.contacts.util.i0.d(this, this.f20530r);
    }

    public final ArrayList<ContactParcelable> x1() {
        ArrayList<ContactParcelable> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < this.f20528p.size(); i10++) {
            ContactsPhonesUtils$PhoneItem contactsPhonesUtils$PhoneItem = this.f20528p.get(i10);
            if (contactsPhonesUtils$PhoneItem.f21875h) {
                ContactParcelable contactParcelable = new ContactParcelable();
                contactParcelable.w(contactsPhonesUtils$PhoneItem.f21872e);
                contactParcelable.t(contactsPhonesUtils$PhoneItem.f21870c);
                contactParcelable.q(contactsPhonesUtils$PhoneItem.f21868a);
                arrayList.add(contactParcelable);
            }
        }
        return arrayList;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void y0() {
        COUINavigationView cOUINavigationView = (COUINavigationView) findViewById(R.id.navigation_view);
        this.f20532y = cOUINavigationView;
        cOUINavigationView.inflateMenu(R.menu.one_action);
        MenuItem findItem = this.f20532y.getMenu().findItem(R.id.delete);
        findItem.setTitle(R.string.confirm_description);
        findItem.setIcon(R.drawable.pb_dr_bottom_menu_add);
        this.f20532y.setOnItemSelectedListener(new NavigationBarView.c() { // from class: com.customize.contacts.activities.k0
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean y12;
                y12 = MultiPhonesSelectActivity.this.y1(menuItem);
                return y12;
            }
        });
    }

    public final /* synthetic */ boolean y1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.delete) {
            B1(x1());
            finish();
            return true;
        }
        return true;
    }

    public final /* synthetic */ boolean z1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (R.id.select_all == itemId) {
            A1();
            return true;
        }
        if (R.id.cancel == itemId) {
            finish();
            return true;
        }
        return true;
    }
}
