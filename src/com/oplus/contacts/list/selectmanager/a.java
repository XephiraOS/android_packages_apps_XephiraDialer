package com.oplus.contacts.list.selectmanager;

import C9.j;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.ContactsApplication;
import com.coui.appcompat.animation.COUIAnimationListenerAdapter;
import com.oplus.dialer.R;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import x7.e;
import y9.c;

/* compiled from: EditModeController.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ j<Object>[] f28034e = {k.d(new MutablePropertyReference1Impl(a.class, "navItemHeight", "getNavItemHeight()I", 0))};

    /* renamed from: a, reason: collision with root package name */
    public final Context f28035a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f28036b;

    /* renamed from: c, reason: collision with root package name */
    public final e f28037c;

    /* renamed from: d, reason: collision with root package name */
    public final c f28038d;

    /* compiled from: EditModeController.kt */
    /* renamed from: com.oplus.contacts.list.selectmanager.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0259a extends COUIAnimationListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f28039a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f28040b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f28041c;

        public C0259a(CheckBox checkBox, boolean z10, a aVar) {
            this.f28039a = checkBox;
            this.f28040b = z10;
            this.f28041c = aVar;
        }

        @Override // com.coui.appcompat.animation.COUIAnimationListenerAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            RecyclerView.Adapter adapter;
            if (!this.f28040b) {
                this.f28039a.setChecked(false);
                this.f28039a.setVisibility(8);
            }
            e eVar = this.f28041c.f28037c;
            if (eVar != null && (adapter = this.f28041c.d().getAdapter()) != null) {
                adapter.notifyItemRangeChanged(0, eVar.getItemCount(), "selection_change");
            }
        }

        @Override // com.coui.appcompat.animation.COUIAnimationListenerAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f28039a.setVisibility(0);
        }
    }

    public a(Context context, RecyclerView recyclerView, e eVar) {
        i.f(context, "context");
        i.f(recyclerView, "recyclerView");
        this.f28035a = context;
        this.f28036b = recyclerView;
        this.f28037c = eVar;
        this.f28038d = y9.a.f38157a.a();
        f(context.getResources().getDimensionPixelOffset(R.dimen.coui_tool_navigation_item_height));
    }

    public final void b() {
        e eVar = this.f28037c;
        if (eVar != null && eVar.getItemCount() > 0) {
            h(true);
        }
    }

    public final void c() {
        e eVar = this.f28037c;
        if (eVar != null && eVar.getItemCount() > 0) {
            h(false);
        }
    }

    public final RecyclerView d() {
        return this.f28036b;
    }

    public final void e() {
        f(this.f28035a.getResources().getDimensionPixelOffset(R.dimen.coui_tool_navigation_item_height));
    }

    public final void f(int i10) {
        this.f28038d.b(this, f28034e[0], Integer.valueOf(i10));
    }

    public final void g(CheckBox checkBox, boolean z10) {
        int i10;
        if (z10) {
            if (ContactsApplication.f13094j) {
                i10 = R.anim.multiselect_left_enter;
            } else {
                i10 = R.anim.multiselect_right_enter;
            }
        } else if (ContactsApplication.f13094j) {
            i10 = R.anim.multiselect_left_exit;
        } else {
            i10 = R.anim.multiselect_right_exit;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(checkBox.getContext(), i10);
        loadAnimation.setAnimationListener(new C0259a(checkBox, z10, this));
        checkBox.startAnimation(loadAnimation);
    }

    public final void h(boolean z10) {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        CheckBox b10;
        e eVar = this.f28037c;
        if (eVar != null) {
            RecyclerView.o layoutManager = this.f28036b.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
                return;
            }
            while (true) {
                RecyclerView.B findViewHolderForLayoutPosition = this.f28036b.findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
                if (findViewHolderForLayoutPosition != null && (b10 = eVar.b(findViewHolderForLayoutPosition)) != null) {
                    g(b10, z10);
                }
                if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                    findFirstVisibleItemPosition++;
                } else {
                    return;
                }
            }
        }
    }
}
