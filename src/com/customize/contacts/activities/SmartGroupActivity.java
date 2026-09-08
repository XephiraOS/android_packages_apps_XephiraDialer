package com.customize.contacts.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.K;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.ContactsApplication;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.group.c;
import com.android.contacts.group.viewmodel.SmartGroupViewModel;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.SmartGroupActivity;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import o1.C1393c;
import v9.InterfaceC1637a;

/* compiled from: SmartGroupActivity.kt */
/* loaded from: classes3.dex */
public final class SmartGroupActivity extends BasicActivity implements COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: D, reason: collision with root package name */
    public static final a f20668D = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public int f20669A = 1;

    /* renamed from: B, reason: collision with root package name */
    public final m9.d f20670B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f20671C;

    /* renamed from: o, reason: collision with root package name */
    public HeaderFooterRecyclerView f20672o;

    /* renamed from: p, reason: collision with root package name */
    public SmartGroupViewModel f20673p;

    /* renamed from: q, reason: collision with root package name */
    public View f20674q;

    /* renamed from: r, reason: collision with root package name */
    public View f20675r;

    /* renamed from: x, reason: collision with root package name */
    public TextView f20676x;

    /* renamed from: y, reason: collision with root package name */
    public ImageView f20677y;

    /* renamed from: z, reason: collision with root package name */
    public b f20678z;

    /* compiled from: SmartGroupActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SmartGroupActivity.kt */
    /* loaded from: classes3.dex */
    public final class b extends RecyclerView.Adapter<c.C0169c> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f20679a;

        /* renamed from: b, reason: collision with root package name */
        public List<c> f20680b;

        /* renamed from: c, reason: collision with root package name */
        public final LayoutInflater f20681c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SmartGroupActivity f20682d;

        public b(SmartGroupActivity smartGroupActivity, Context context, List<c> list) {
            kotlin.jvm.internal.i.f(context, "context");
            this.f20682d = smartGroupActivity;
            this.f20679a = context;
            this.f20680b = list;
            LayoutInflater from = LayoutInflater.from(context);
            kotlin.jvm.internal.i.e(from, "from(context)");
            this.f20681c = from;
        }

        public static final void i(SmartGroupActivity this$0, View view, View view2) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            kotlin.jvm.internal.i.f(view, "$view");
            this$0.clickItem(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<c> list = this.f20680b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public final void h(final View view) {
            kotlin.jvm.internal.i.f(view, "view");
            final SmartGroupActivity smartGroupActivity = this.f20682d;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.activities.w0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SmartGroupActivity.b.i(SmartGroupActivity.this, view, view2);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c.C0169c holder, int i10) {
            c cVar;
            kotlin.jvm.internal.i.f(holder, "holder");
            H7.b.b("SmartGroupActivity", "onBindViewHolder position=" + i10);
            List<c> list = this.f20680b;
            String str = null;
            if (list != null) {
                cVar = list.get(i10);
            } else {
                cVar = null;
            }
            if (cVar != null) {
                holder.s(cVar.a());
            }
            TextView o10 = holder.o();
            if (cVar != null) {
                str = cVar.b();
            }
            o10.setText(str);
            holder.k().setBackgroundResource(R.drawable.coui_preference_bg_selector);
            if (cVar != null) {
                if (cVar.c() < 0) {
                    holder.m().setVisibility(8);
                } else {
                    holder.m().setText(this.f20679a.getResources().getQuantityString(R.plurals.group_member_count_tips, cVar.c(), Integer.valueOf(cVar.c())));
                }
            }
            if (i10 == getItemCount() - 1) {
                View i11 = holder.i();
                if (i11 != null) {
                    i11.setVisibility(8);
                    return;
                }
                return;
            }
            View i12 = holder.i();
            if (i12 != null) {
                i12.setVisibility(0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public c.C0169c onCreateViewHolder(ViewGroup parent, int i10) {
            kotlin.jvm.internal.i.f(parent, "parent");
            H7.b.b("SmartGroupActivity", "onCreateViewHolder");
            View convertView = this.f20681c.inflate(R.layout.smart_group_browse_list_item, parent, false);
            kotlin.jvm.internal.i.e(convertView, "convertView");
            h(convertView);
            c.C0169c c0169c = new c.C0169c(convertView);
            convertView.setTag(c0169c);
            return c0169c;
        }

        public final void l(List<c> list) {
            kotlin.jvm.internal.i.f(list, "list");
            this.f20680b = list;
            notifyDataSetChanged();
        }
    }

    /* compiled from: SmartGroupActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f20683a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20684b;

        /* renamed from: c, reason: collision with root package name */
        public final String f20685c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20686d;

        /* renamed from: e, reason: collision with root package name */
        public String f20687e;

        /* renamed from: f, reason: collision with root package name */
        public int f20688f;

        /* renamed from: g, reason: collision with root package name */
        public String f20689g;

        /* renamed from: h, reason: collision with root package name */
        public int f20690h;

        public c(String location, int i10, String str, int i11) {
            kotlin.jvm.internal.i.f(location, "location");
            this.f20683a = location;
            this.f20684b = i10;
            this.f20685c = str;
            this.f20686d = i11;
            this.f20687e = location;
            this.f20688f = i10;
            this.f20689g = str;
            this.f20690h = i11;
            if (1 == i11 && location.length() == 0) {
                this.f20689g = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
                String string = ContactsApplication.h().getString(R.string.oplus_smart_group_no_company_title);
                kotlin.jvm.internal.i.e(string, "getApplication().getStri…t_group_no_company_title)");
                this.f20687e = string;
            }
        }

        public final String a() {
            return this.f20689g;
        }

        public final String b() {
            return this.f20687e;
        }

        public final int c() {
            return this.f20688f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (kotlin.jvm.internal.i.b(this.f20683a, cVar.f20683a) && this.f20684b == cVar.f20684b && kotlin.jvm.internal.i.b(this.f20685c, cVar.f20685c) && this.f20686d == cVar.f20686d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.f20683a.hashCode() * 31) + Integer.hashCode(this.f20684b)) * 31;
            String str = this.f20685c;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return ((hashCode2 + hashCode) * 31) + Integer.hashCode(this.f20686d);
        }

        public String toString() {
            return "SmartGroupItem(location=" + this.f20683a + ", count=" + this.f20684b + ", id=" + this.f20685c + ", mode=" + this.f20686d + ")";
        }
    }

    /* compiled from: SmartGroupActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d implements androidx.lifecycle.w, kotlin.jvm.internal.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v9.l f20691a;

        public d(v9.l function) {
            kotlin.jvm.internal.i.f(function, "function");
            this.f20691a = function;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof androidx.lifecycle.w) || !(obj instanceof kotlin.jvm.internal.g)) {
                return false;
            }
            return kotlin.jvm.internal.i.b(getFunctionDelegate(), ((kotlin.jvm.internal.g) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.g
        public final m9.c<?> getFunctionDelegate() {
            return this.f20691a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20691a.invoke(obj);
        }
    }

    public SmartGroupActivity() {
        m9.d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<COUIStatusBarResponseUtil>() { // from class: com.customize.contacts.activities.SmartGroupActivity$barResponseUtil$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final COUIStatusBarResponseUtil invoke() {
                return new COUIStatusBarResponseUtil(SmartGroupActivity.this);
            }
        });
        this.f20670B = b10;
    }

    private final void t1() {
        View view = this.f20674q;
        View view2 = null;
        if (view == null) {
            kotlin.jvm.internal.i.q("loadingView");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.f20675r;
        if (view3 == null) {
            kotlin.jvm.internal.i.q("colorLoadingView");
        } else {
            view2 = view3;
        }
        view2.setVisibility(8);
    }

    private final void x1() {
        View view = this.f20674q;
        View view2 = null;
        if (view == null) {
            kotlin.jvm.internal.i.q("loadingView");
            view = null;
        }
        view.setVisibility(0);
        View view3 = this.f20675r;
        if (view3 == null) {
            kotlin.jvm.internal.i.q("colorLoadingView");
        } else {
            view2 = view3;
        }
        view2.setVisibility(0);
    }

    public final void clickItem(View view) {
        Object obj;
        String n10;
        Uri build;
        String str;
        String[] b10;
        String str2;
        Uri uri;
        String[] b11;
        Intent intent = new Intent(this, (Class<?>) ViewGroupActivity.class);
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type com.android.contacts.group.GroupBrowseListAdapter.GroupListItemViewCache");
        c.C0169c c0169c = (c.C0169c) obj;
        intent.putExtra("group_mode", this.f20669A);
        intent.putExtra("group_name", c0169c.n());
        Bundle bundle = new Bundle();
        C1393c c1393c = new C1393c(getApplicationContext());
        boolean z10 = false;
        String str3 = "";
        if (2 == this.f20669A) {
            if (com.android.contacts.group.l.g()) {
                Pair<Uri, String> f10 = com.android.contacts.group.l.f16689a.f(c0169c.n());
                build = f10.c();
                str = f10.d();
                if (c1393c.g() == 2) {
                    z10 = true;
                }
                if (z10) {
                    b11 = R0.b.c();
                } else {
                    b11 = R0.b.b();
                }
                bundle.putStringArray("PROJECTION", b11);
            } else {
                String h10 = c0169c.h();
                if (h10 != null && h10.length() != 0) {
                    str3 = c0169c.h();
                }
                if (str3 != null && str3.length() != 0) {
                    uri = R0.d.f3227n.buildUpon().appendQueryParameter("areano", str3).appendQueryParameter("cityname", c0169c.n()).build();
                } else {
                    uri = R0.d.f3227n;
                }
                build = uri;
                str = str3;
            }
            bundle.putString("SELECTION", str);
        } else {
            if (c0169c.n().length() == 0) {
                n10 = "";
            } else {
                n10 = c0169c.n();
            }
            if (TextUtils.equals(c0169c.h(), OplusPhoneUtils.DeviceState.UNLOCK_DEVICE)) {
                Uri build2 = R0.d.f3225l.buildUpon().query(n10).appendQueryParameter("no_company_group", "true").build();
                intent.putExtra("group_mode", 3);
                build = build2;
                str = n10;
            } else {
                if (c0169c.n().length() != 0) {
                    str3 = c0169c.n();
                }
                build = R0.d.f3225l.buildUpon().query(str3).build();
                str = str3;
            }
            if (c1393c.g() == 2) {
                z10 = true;
            }
            if (z10) {
                b10 = R0.b.c();
            } else {
                b10 = R0.b.b();
            }
            bundle.putStringArray("PROJECTION", b10);
        }
        bundle.putParcelable("URI", build);
        if (c1393c.h() == 1) {
            str2 = "sort_key";
        } else {
            str2 = "sort_key_alt";
        }
        bundle.putString("ORDER", str2);
        intent.putExtras(bundle);
        intent.putExtra("SELECTION_FOR_VIEW_GROUP", str);
        R7.b.f(this, intent, 0, null, 6, null);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.smart_group_list_view);
        setSupportActionBar((COUIToolbar) findViewById(R.id.toolbar));
        this.f20671C = true;
        r1();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.v(4, 4);
            supportActionBar.t(true);
            if (this.f20669A == 2) {
                supportActionBar.z(R.string.oplus_smart_group_location_title);
            } else {
                supportActionBar.z(R.string.oplus_smart_group_company_title);
            }
        }
        v1();
        androidx.lifecycle.M viewModelStore = getViewModelStore();
        kotlin.jvm.internal.i.e(viewModelStore, "viewModelStore");
        SmartGroupViewModel smartGroupViewModel = (SmartGroupViewModel) new androidx.lifecycle.K(viewModelStore, new K.c(), null, 4, null).a(SmartGroupViewModel.class);
        this.f20673p = smartGroupViewModel;
        if (smartGroupViewModel == null) {
            kotlin.jvm.internal.i.q("smartGroupViewModel");
            smartGroupViewModel = null;
        }
        smartGroupViewModel.h().i(this, new d(new v9.l<List<? extends c>, m9.q>() { // from class: com.customize.contacts.activities.SmartGroupActivity$onCreate$2
            {
                super(1);
            }

            public final void b(List<SmartGroupActivity.c> groupListItems) {
                SmartGroupActivity smartGroupActivity = SmartGroupActivity.this;
                kotlin.jvm.internal.i.e(groupListItems, "groupListItems");
                smartGroupActivity.q1(groupListItems);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(List<? extends SmartGroupActivity.c> list) {
                b(list);
                return m9.q.f35511a;
            }
        }));
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.i.f(item, "item");
        if (item.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.customize.contacts.util.i0.b();
        u1().onPause();
        super.onPause();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        u1().onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        SmartGroupViewModel smartGroupViewModel = this.f20673p;
        if (smartGroupViewModel == null) {
            kotlin.jvm.internal.i.q("smartGroupViewModel");
            smartGroupViewModel = null;
        }
        smartGroupViewModel.i(this.f20669A);
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f20672o;
        if (headerFooterRecyclerView == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        }
        headerFooterRecyclerView.scrollToPosition(0);
    }

    public final void q1(List<c> list) {
        int i10;
        int size = list.size();
        t1();
        if (size == 0) {
            w1();
        } else {
            s1();
        }
        if (this.f20671C) {
            HashMap hashMap = new HashMap();
            hashMap.put(BreenoCallContract.SummaryColumns.COUNT, String.valueOf(size));
            if (2 == this.f20669A) {
                i10 = 200030232;
            } else {
                i10 = 200030229;
            }
            com.android.contacts.framework.baseui.util.A.a(this, 2000308, i10, hashMap, false);
        }
        this.f20671C = false;
        b bVar = this.f20678z;
        if (bVar == null) {
            kotlin.jvm.internal.i.q("smartGroupAdapter");
            bVar = null;
        }
        bVar.l(list);
    }

    public final void r1() {
        long f10 = C7.e.f(getIntent(), "GroupMode", -1L);
        if (FeatureOption.i()) {
            if (f10 == -1) {
                this.f20669A = 1;
                return;
            } else {
                if (f10 == -2) {
                    this.f20669A = 2;
                    return;
                }
                return;
            }
        }
        if (f10 == -1) {
            this.f20669A = 1;
        }
    }

    public final void s1() {
        TextView textView = this.f20676x;
        HeaderFooterRecyclerView headerFooterRecyclerView = null;
        if (textView == null) {
            kotlin.jvm.internal.i.q("emptyView");
            textView = null;
        }
        textView.setVisibility(8);
        ImageView imageView = this.f20677y;
        if (imageView == null) {
            kotlin.jvm.internal.i.q("noContentView");
            imageView = null;
        }
        imageView.setVisibility(8);
        HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f20672o;
        if (headerFooterRecyclerView2 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
        } else {
            headerFooterRecyclerView = headerFooterRecyclerView2;
        }
        headerFooterRecyclerView.setVisibility(0);
    }

    public final COUIStatusBarResponseUtil u1() {
        return (COUIStatusBarResponseUtil) this.f20670B.getValue();
    }

    public final void v1() {
        View findViewById = findViewById(R.id.list);
        kotlin.jvm.internal.i.d(findViewById, "null cannot be cast to non-null type com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView");
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) findViewById;
        this.f20672o = headerFooterRecyclerView;
        TextView textView = null;
        if (headerFooterRecyclerView == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        }
        HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f20672o;
        if (headerFooterRecyclerView2 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView2 = null;
        }
        com.android.contacts.util.C.c(this, headerFooterRecyclerView, headerFooterRecyclerView2.getPaddingBottom());
        u1().setStatusBarClickListener(this);
        this.f20678z = new b(this, this, null);
        HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f20672o;
        if (headerFooterRecyclerView3 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView3 = null;
        }
        headerFooterRecyclerView3.setLayoutManager(new LinearLayoutManager(headerFooterRecyclerView3.getContext()));
        b bVar = this.f20678z;
        if (bVar == null) {
            kotlin.jvm.internal.i.q("smartGroupAdapter");
            bVar = null;
        }
        if (!(bVar instanceof RecyclerView.Adapter)) {
            bVar = null;
        }
        headerFooterRecyclerView3.setAdapter(bVar);
        headerFooterRecyclerView3.setNestedScrollingEnabled(true);
        View findViewById2 = findViewById(R.id.loading);
        kotlin.jvm.internal.i.c(findViewById2);
        this.f20674q = findViewById2;
        View findViewById3 = findViewById(R.id.loading_view);
        kotlin.jvm.internal.i.c(findViewById3);
        this.f20675r = findViewById3;
        View findViewById4 = findViewById(R.id.empty_view);
        kotlin.jvm.internal.i.d(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById4;
        this.f20676x = textView2;
        if (textView2 == null) {
            kotlin.jvm.internal.i.q("emptyView");
        } else {
            textView = textView2;
        }
        textView.setText(R.string.noGroups);
        View findViewById5 = findViewById(R.id.no_content);
        kotlin.jvm.internal.i.d(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.f20677y = (ImageView) findViewById5;
        x1();
    }

    public final void w1() {
        TextView textView = this.f20676x;
        HeaderFooterRecyclerView headerFooterRecyclerView = null;
        if (textView == null) {
            kotlin.jvm.internal.i.q("emptyView");
            textView = null;
        }
        textView.setVisibility(0);
        ImageView imageView = this.f20677y;
        if (imageView == null) {
            kotlin.jvm.internal.i.q("noContentView");
            imageView = null;
        }
        imageView.setVisibility(0);
        HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f20672o;
        if (headerFooterRecyclerView2 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
        } else {
            headerFooterRecyclerView = headerFooterRecyclerView2;
        }
        headerFooterRecyclerView.setVisibility(8);
    }
}
