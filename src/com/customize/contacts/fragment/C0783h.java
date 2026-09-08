package com.customize.contacts.fragment;

import E3.u;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.w;
import com.coloros.contacts.common.ContactParcelable;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.HandlerC0795f;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.FeatureUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import q7.C1493b;
import q7.InterfaceC1492a;

/* compiled from: CallLogFragment.java */
/* renamed from: com.customize.contacts.fragment.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0783h extends C0782g implements u.e, u.d, w7.b {

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f21291r = {BreenoCallContract.BaseColumns._ID, "name", "number", "photo_id", "formatted_number", "simid", "duration", BreenoCallContract.BaseColumns.DATE, "ring_time", "lookup_uri", "countryiso"};

    /* renamed from: h, reason: collision with root package name */
    public Context f21293h;

    /* renamed from: i, reason: collision with root package name */
    public E3.u f21294i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f21295j;

    /* renamed from: k, reason: collision with root package name */
    public Z3.i f21296k;

    /* renamed from: l, reason: collision with root package name */
    public View f21297l;

    /* renamed from: m, reason: collision with root package name */
    public Cursor f21298m;

    /* renamed from: n, reason: collision with root package name */
    public b f21299n;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f21301p;

    /* renamed from: g, reason: collision with root package name */
    public final Uri f21292g = Uri.parse("content://call_log/" + com.android.contacts.compat.data.f.c("customize_calls"));

    /* renamed from: o, reason: collision with root package name */
    public HashSet<String> f21300o = null;

    /* renamed from: q, reason: collision with root package name */
    public final InterfaceC1492a f21302q = new C1493b();

    /* compiled from: CallLogFragment.java */
    /* renamed from: com.customize.contacts.fragment.h$a */
    /* loaded from: classes3.dex */
    public class a extends RecyclerView.s {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            boolean z10;
            E3.u uVar = C0783h.this.f21294i;
            if (i10 != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            uVar.r(z10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
        }
    }

    /* compiled from: CallLogFragment.java */
    /* renamed from: com.customize.contacts.fragment.h$b */
    /* loaded from: classes3.dex */
    public final class b extends HandlerC0795f {
        public b(Context context) {
            super(context.getContentResolver());
        }

        @Override // com.customize.contacts.util.HandlerC0795f
        public void e(int i10, Object obj, Cursor cursor) {
            if (i10 == 9797) {
                if (cursor != null && cursor.getCount() != 0) {
                    if (!cursor.isClosed()) {
                        if (H7.a.b()) {
                            H7.b.b("CallLogFragment", "count = " + cursor.getCount());
                        }
                        if (cursor.getCount() <= 0) {
                            C0783h.this.f21287d.setVisibility(8);
                            C0783h.this.f21295j.setVisibility(0);
                            C0783h.this.f21301p.setVisibility(0);
                        } else {
                            C0783h.this.f21287d.setVisibility(0);
                            C0783h.this.f21295j.setVisibility(8);
                            C0783h.this.f21301p.setVisibility(8);
                        }
                    }
                    C0783h.this.f21298m = cursor;
                    C0783h.this.r1();
                    C0783h.this.f21294i.l(cursor);
                    return;
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                if (C0783h.this.f21300o != null) {
                    C0783h.this.f21300o.clear();
                }
                C0783h.this.f21294i.l(null);
                C0783h.this.f21287d.setVisibility(8);
                C0783h.this.f21295j.setVisibility(0);
                C0783h.this.f21301p.setVisibility(0);
            }
        }
    }

    private void j1() {
        if (B3.a.u()) {
            E0.b.a();
        }
    }

    private void n1() {
        this.f21295j = (TextView) this.f21297l.findViewById(R.id.empty_view);
        this.f21301p = (ImageView) this.f21297l.findViewById(R.id.no_content);
        this.f21295j.setText(R.string.no_call_log);
        this.f21287d = (HeaderFooterRecyclerView) this.f21297l.findViewById(R.id.list);
        this.f21299n = new b(this.f21293h);
        this.f21294i.s();
        this.f21287d.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f21287d.setAdapter(this.f21294i);
        this.f21287d.setNestedScrollingEnabled(true);
        this.f21287d.setTag(this.f21297l);
        this.f21287d.setDragSelectListener(this);
        if (this.f21287d != null) {
            boolean j10 = DisplayUtil.j(getActivity());
            if ((DisplayUtil.i(getActivity()) && !j10) || (!FeatureUtil.V() && DisplayUtil.n(getActivity()))) {
                this.f21287d.i(getResources().getDimensionPixelSize(R.dimen.DP_145), 0, 0, 0);
            } else if (FeatureUtil.V() && !j10) {
                this.f21287d.i(getResources().getDimensionPixelSize(R.dimen.DP_245), 0, 0, 0);
            } else {
                this.f21287d.i(getResources().getDimensionPixelSize(R.dimen.DP_60), 0, 0, 0);
            }
        }
        this.f21302q.T0(requireActivity(), this.f21287d, null);
        this.f21287d.addOnScrollListener(new a());
    }

    @Override // w7.b
    public void K(int i10, int i11, List<? extends View> list) {
        for (View view : list) {
            Object tag = view.getTag(R.id.call_log_item_position);
            if (tag instanceof Integer) {
                Z0(view, ((Integer) tag).intValue());
            }
        }
    }

    @Override // w7.b
    public boolean Z0(View view, int i10) {
        return o1(view, i10);
    }

    public final ArrayList<ContactParcelable> k1() {
        HashSet<String> hashSet;
        ArrayList<ContactParcelable> arrayList = new ArrayList<>();
        Cursor cursor = this.f21298m;
        if (cursor != null && !cursor.isClosed() && (hashSet = this.f21300o) != null && !hashSet.isEmpty()) {
            this.f21298m.moveToPosition(-1);
            while (this.f21298m.moveToNext()) {
                String string = this.f21298m.getString(5);
                String string2 = this.f21298m.getString(2);
                if (this.f21300o.contains(string + "_" + string2)) {
                    ContactParcelable contactParcelable = new ContactParcelable();
                    contactParcelable.q(-1L);
                    String string3 = this.f21298m.getString(1);
                    if (this.f21298m.getString(9) == null) {
                        w.b d10 = com.android.contacts.framework.baseui.util.w.e().d(string2);
                        if (d10 != null) {
                            string3 = d10.a();
                        } else if (E0.b.y(string2)) {
                            string3 = E0.b.u(string2);
                        }
                    }
                    contactParcelable.t(string3);
                    contactParcelable.w(string2);
                    arrayList.add(contactParcelable);
                }
            }
        }
        return arrayList;
    }

    public int l1() {
        HashSet<String> hashSet = this.f21300o;
        if (hashSet == null) {
            return 0;
        }
        return hashSet.size();
    }

    public ArrayList<ContactParcelable> m1() {
        return k1();
    }

    public final boolean o1(View view, int i10) {
        if (this.f21294i == null) {
            return false;
        }
        int headersCount = i10 - this.f21287d.getHeadersCount();
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.check_box);
        if (checkBox == null) {
            return false;
        }
        boolean z10 = !checkBox.isChecked();
        checkBox.setChecked(z10);
        Cursor n10 = this.f21294i.n();
        if (n10 == null) {
            return false;
        }
        if (n10.moveToPosition(headersCount)) {
            String str = n10.getString(5) + "_" + n10.getString(2);
            if (z10) {
                this.f21300o.add(str);
            } else {
                this.f21300o.remove(str);
            }
        }
        com.android.contacts.util.C.b(view, z10);
        this.f21294i.w(this.f21300o);
        this.f21294i.notifyDataSetChanged();
        this.f21296k.a();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f21293h = context;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f21287d != null) {
            boolean j10 = DisplayUtil.j(getActivity());
            if ((DisplayUtil.i(getActivity()) && !j10) || (!FeatureUtil.V() && DisplayUtil.n(getActivity()))) {
                this.f21287d.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_145));
            } else if (FeatureUtil.V() && !j10) {
                this.f21287d.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_245));
            } else {
                this.f21287d.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_60));
            }
        }
    }

    @Override // E3.u.e
    public void onContentChanged() {
        E3.u uVar = this.f21294i;
        if (uVar != null) {
            uVar.o();
        }
        q1();
    }

    @Override // com.customize.contacts.fragment.C0782g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j1();
    }

    @Override // com.customize.contacts.fragment.C0782g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f21297l;
        if (view != null) {
            return view;
        }
        this.f21297l = layoutInflater.inflate(R.layout.call_log_fragment, (ViewGroup) null);
        this.f21294i = new E3.u(this.f21293h, null, this, this);
        n1();
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f21297l;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f21294i.u();
        Cursor cursor = this.f21298m;
        if (cursor != null) {
            cursor.close();
        }
        E0.b.D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f21302q.F();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f21293h = null;
    }

    @Override // E3.u.d
    public void onItemClick(View view, int i10) {
        o1(view, i10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f21294i.u();
        this.f21302q.p();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f21294i.o();
        q1();
        if (this.f21300o == null) {
            this.f21300o = new HashSet<>();
        }
        this.f21302q.H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    public void p1(Z3.i iVar) {
        this.f21296k = iVar;
    }

    public void q1() {
        if (this.f21299n != null) {
            String str = C0801l.m() + " AND " + C0801l.f();
            this.f21299n.c(9797);
            this.f21299n.i(9797, null, this.f21292g, f21291r, str, null, "MAX(date) DESC");
        }
    }

    public final void r1() {
        HashSet<String> hashSet = this.f21300o;
        if (hashSet == null) {
            this.f21300o = new HashSet<>();
            return;
        }
        if (hashSet.size() == 0) {
            return;
        }
        HashSet hashSet2 = new HashSet();
        this.f21298m.moveToPosition(-1);
        while (this.f21298m.moveToNext()) {
            String str = this.f21298m.getString(5) + "_" + this.f21298m.getString(2);
            if (this.f21300o.contains(str)) {
                hashSet2.add(str);
            }
        }
        this.f21300o.clear();
        this.f21300o.addAll(hashSet2);
        hashSet2.clear();
        this.f21294i.w(this.f21300o);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        HeaderFooterRecyclerView headerFooterRecyclerView;
        super.setUserVisibleHint(z10);
        H7.b.e("CallLogFragment", "isVisibleToUser = " + z10);
        if (z10) {
            this.f21302q.H0();
        } else {
            this.f21302q.p();
        }
        if (isAdded() && (headerFooterRecyclerView = this.f21287d) != null) {
            headerFooterRecyclerView.setDisallowReceiveTouchEvent(!z10);
        }
    }

    @Override // w7.b
    public void T() {
    }

    @Override // w7.b
    public void p0() {
    }
}
