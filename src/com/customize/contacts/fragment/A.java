package com.customize.contacts.fragment;

import N3.d;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.customize.contacts.activities.MultiContactsSendSmsActivity;
import com.customize.contacts.util.C0814z;
import com.customize.contacts.util.HandlerC0795f;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.FeatureUtil;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import q7.C1493b;
import q7.InterfaceC1492a;

/* compiled from: GroupListFragment.java */
/* loaded from: classes3.dex */
public class A extends C0782g implements View.OnFocusChangeListener, View.OnTouchListener, d.b, d.c, w7.b {

    /* renamed from: g, reason: collision with root package name */
    public View f21109g;

    /* renamed from: h, reason: collision with root package name */
    public N3.d f21110h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f21111i;

    /* renamed from: j, reason: collision with root package name */
    public Context f21112j;

    /* renamed from: l, reason: collision with root package name */
    public Z3.i f21114l;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f21117o;

    /* renamed from: k, reason: collision with root package name */
    public a f21113k = null;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21115m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21116n = false;

    /* renamed from: p, reason: collision with root package name */
    public final InterfaceC1492a f21118p = new C1493b();

    /* compiled from: GroupListFragment.java */
    /* loaded from: classes3.dex */
    public static class a extends HandlerC0795f {

        /* renamed from: f, reason: collision with root package name */
        public final WeakReference<A> f21119f;

        public a(A a10) {
            super(a10.requireActivity().getContentResolver());
            this.f21119f = new WeakReference<>(a10);
        }

        @Override // com.customize.contacts.util.HandlerC0795f
        public void e(int i10, Object obj, Cursor cursor) {
            boolean z10;
            A a10 = this.f21119f.get();
            if (a10.f21110h != null) {
                if (cursor == null) {
                    a10.f21110h.k(null);
                    a10.f21110h.notifyDataSetChanged();
                    return;
                }
                if (a10.f21110h.n().size() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                a10.f21110h.k(cursor);
                a10.f21110h.w(cursor);
                if (!cursor.isClosed()) {
                    if (cursor.getCount() <= 0) {
                        a10.f21287d.setVisibility(8);
                        a10.f21111i.setVisibility(0);
                        a10.f21117o.setVisibility(0);
                    } else {
                        a10.f21287d.setVisibility(0);
                        a10.f21111i.setVisibility(8);
                        a10.f21117o.setVisibility(8);
                    }
                }
                if (z10 && a10.f21114l != null) {
                    a10.f21114l.a();
                }
            }
        }

        public void k(Uri uri, String[] strArr, String str, String[] strArr2) {
            super.i(42, null, uri, strArr, str, strArr2, null);
        }
    }

    private void m1() {
        this.f21111i = (TextView) this.f21109g.findViewById(R.id.empty_view);
        this.f21117o = (ImageView) this.f21109g.findViewById(R.id.no_content);
        this.f21113k = new a(this);
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) this.f21109g.findViewById(R.id.list);
        this.f21287d = headerFooterRecyclerView;
        if (headerFooterRecyclerView != null) {
            headerFooterRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f21287d.setDragSelectListener(this);
            this.f21287d.setAdapter(this.f21110h);
            this.f21287d.setNestedScrollingEnabled(true);
            this.f21287d.setTag(this.f21109g);
            boolean j10 = DisplayUtil.j(getActivity());
            if ((DisplayUtil.i(getActivity()) && !j10) || (!FeatureUtil.V() && DisplayUtil.n(getActivity()))) {
                this.f21287d.i(getResources().getDimensionPixelSize(R.dimen.DP_145), 0, 0, 0);
            } else if (FeatureUtil.V() && !j10) {
                this.f21287d.i(getResources().getDimensionPixelSize(R.dimen.DP_245), 0, 0, 0);
            } else {
                this.f21287d.i(getResources().getDimensionPixelSize(R.dimen.DP_60), 0, 0, 0);
            }
        }
        s1();
        this.f21110h.q(false);
        this.f21118p.T0(requireActivity(), this.f21287d, null);
    }

    private boolean n1(View view, int i10) {
        CheckBox checkBox;
        Cursor l10;
        if (this.f21110h == null || (checkBox = (CheckBox) view.findViewById(R.id.check_box)) == null || view.getAlpha() < 1.0f) {
            return false;
        }
        boolean z10 = !checkBox.isChecked();
        if (i10 < this.f21287d.getHeadersCount() || i10 - this.f21287d.getHeadersCount() < 0 || (l10 = this.f21110h.l()) == null || !l10.moveToPosition(i10)) {
            return false;
        }
        this.f21110h.v(l10.getLong(0), z10, l10.getLong(2));
        this.f21114l.a();
        return true;
    }

    private void s1() {
        this.f21110h.t();
    }

    @Override // w7.b
    public void K(int i10, int i11, List<? extends View> list) {
        for (View view : list) {
            Object tag = view.getTag(R.id.group_list_item_position);
            if (tag instanceof Integer) {
                Z0(view, ((Integer) tag).intValue());
            }
        }
    }

    @Override // w7.b
    public boolean Z0(View view, int i10) {
        return n1(view, i10);
    }

    public final long[] h1(HashSet<Long> hashSet) {
        long[] jArr = new long[hashSet.size()];
        Iterator<Long> it = hashSet.iterator();
        int i10 = -1;
        while (it.hasNext()) {
            i10++;
            jArr[i10] = it.next().longValue();
        }
        return jArr;
    }

    public N3.d i1() {
        return this.f21110h;
    }

    public int j1() {
        return this.f21110h.m();
    }

    public boolean k1() {
        if (this.f21110h.getItemCount() > 0) {
            return true;
        }
        return false;
    }

    public boolean l1() {
        if (this.f21110h.m() > 0) {
            return true;
        }
        return false;
    }

    public Intent o1(boolean z10) {
        Intent intent = new Intent();
        if (!k1() || !l1()) {
            return null;
        }
        long[] h12 = h1(this.f21110h.n());
        intent.setAction("com.oplus.contacts.ui.GET_GROUPS_CONTACTS_PHONES_FOR_SMS");
        intent.setComponent(new ComponentName(getContext(), (Class<?>) MultiContactsSendSmsActivity.class));
        intent.putExtra("GROUPS_IDS_ARRAY", h12);
        intent.putExtra("contain_email", this.f21115m);
        intent.putExtra("from_sms", z10);
        return intent;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f21112j = context;
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

    @Override // N3.d.c
    public void onContentChanged() {
        t1();
    }

    @Override // com.customize.contacts.fragment.C0782g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.customize.contacts.fragment.C0782g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f21109g;
        if (view != null) {
            return view;
        }
        this.f21109g = layoutInflater.inflate(R.layout.group_list_fragment, (ViewGroup) null);
        this.f21110h = new N3.d(this.f21112j, null, this, this);
        m1();
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f21109g;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Cursor l10 = this.f21110h.l();
        if (l10 != null && !l10.isClosed()) {
            l10.close();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f21118p.F();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f21112j = null;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (view == this.f21287d && z10) {
            SoftKeyboardUtil.a().b(this.f21287d);
        }
    }

    @Override // N3.d.b
    public void onItemClick(View view, int i10) {
        n1(view, i10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f21118p.p();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        t1();
        this.f21118p.H0();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.f21287d) {
            SoftKeyboardUtil.a().b(this.f21287d);
            return false;
        }
        return false;
    }

    public void p1(boolean z10) {
        this.f21115m = z10;
    }

    public void q1(boolean z10) {
        this.f21116n = z10;
    }

    public void r1(Z3.i iVar) {
        this.f21114l = iVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        HeaderFooterRecyclerView headerFooterRecyclerView;
        super.setUserVisibleHint(z10);
        H7.b.e("GroupListFragment", "isVisibleToUser = " + z10);
        if (z10) {
            this.f21118p.H0();
        } else {
            this.f21118p.p();
        }
        if (isAdded() && (headerFooterRecyclerView = this.f21287d) != null) {
            headerFooterRecyclerView.setDisallowReceiveTouchEvent(!z10);
        }
    }

    public void t1() {
        if (this.f21113k != null) {
            this.f21113k.k(C0814z.a(this.f21116n, this.f21115m), null, null, null);
        }
    }

    @Override // w7.b
    public void T() {
    }

    @Override // w7.b
    public void p0() {
    }
}
