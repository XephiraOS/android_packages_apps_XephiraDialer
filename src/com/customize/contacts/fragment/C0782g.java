package com.customize.contacts.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.coui.appcompat.tablayout.COUITabLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;

/* compiled from: BaseFragment.java */
/* renamed from: com.customize.contacts.fragment.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0782g extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public AppBarLayout f21284a;

    /* renamed from: b, reason: collision with root package name */
    public COUIToolbar f21285b;

    /* renamed from: c, reason: collision with root package name */
    public COUITabLayout f21286c;

    /* renamed from: d, reason: collision with root package name */
    public HeaderFooterRecyclerView f21287d;

    /* renamed from: e, reason: collision with root package name */
    public int f21288e;

    /* renamed from: f, reason: collision with root package name */
    public int f21289f;

    /* compiled from: BaseFragment.java */
    /* renamed from: com.customize.contacts.fragment.g$a */
    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i10;
            C0782g.this.f21284a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int a10 = com.android.contacts.framework.baseui.util.B.a(C0782g.this.getContext());
            COUIToolbar cOUIToolbar = C0782g.this.f21285b;
            int i11 = 0;
            if (cOUIToolbar != null) {
                i10 = cOUIToolbar.getHeight();
            } else {
                i10 = 0;
            }
            int i12 = a10 + i10;
            COUITabLayout cOUITabLayout = C0782g.this.f21286c;
            if (cOUITabLayout != null) {
                i11 = cOUITabLayout.getHeight();
            }
            int i13 = i12 + i11;
            HeaderFooterRecyclerView headerFooterRecyclerView = C0782g.this.f21287d;
            if (headerFooterRecyclerView != null) {
                headerFooterRecyclerView.setPaddingRelative(headerFooterRecyclerView.getPaddingStart(), i13, C0782g.this.f21287d.getPaddingEnd(), C0782g.this.f21287d.getPaddingBottom());
            }
        }
    }

    public void c1(boolean z10) {
        int i10;
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f21287d;
        if (headerFooterRecyclerView != null) {
            int paddingTop = headerFooterRecyclerView.getPaddingTop();
            if (z10) {
                i10 = this.f21288e;
            } else {
                i10 = this.f21289f;
            }
            headerFooterRecyclerView.setPaddingRelative(0, paddingTop, 0, i10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f21289f = getResources().getDimensionPixelOffset(R.dimen.DP_30);
        this.f21288e = getResources().getDimensionPixelOffset(R.dimen.DP_100);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f21285b = (COUIToolbar) activity.findViewById(R.id.toolbar);
            this.f21284a = (AppBarLayout) activity.findViewById(R.id.appbar);
            this.f21286c = (COUITabLayout) activity.findViewById(R.id.color_tab_layout);
            AppBarLayout appBarLayout = this.f21284a;
            if (appBarLayout != null) {
                appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a());
            }
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
