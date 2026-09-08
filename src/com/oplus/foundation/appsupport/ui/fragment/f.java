package com.oplus.foundation.appsupport.ui.fragment;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.coui.appcompat.toolbar.COUIToolbar;
import kotlin.jvm.internal.i;
import s7.C1557b;
import s7.InterfaceC1556a;

/* compiled from: LazyInflateToolbarPopMenuFragment.kt */
/* loaded from: classes3.dex */
public abstract class f<BD extends ViewDataBinding> extends BaseUIFragment<BD> implements InterfaceC1556a {

    /* renamed from: i, reason: collision with root package name */
    public s7.c f28206i;

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment
    public boolean A1(MenuItem item) {
        View view;
        i.f(item, "item");
        FragmentActivity activity = getActivity();
        if (activity == null || !activity.isFinishing()) {
            FragmentActivity activity2 = getActivity();
            if ((activity2 != null && activity2.isDestroyed()) || !isAdded()) {
                return false;
            }
            if (O1(item)) {
                s7.c cVar = this.f28206i;
                if (cVar != null && cVar.isShowing()) {
                    s7.c cVar2 = this.f28206i;
                    if (cVar2 != null) {
                        cVar2.dismiss();
                    }
                } else {
                    Context requireContext = requireContext();
                    i.e(requireContext, "requireContext()");
                    s7.c cVar3 = new s7.c(requireContext);
                    this.f28206i = cVar3;
                    cVar3.d(U());
                    cVar3.setDismissTouchOutside(true);
                    cVar3.c(this);
                    COUIToolbar toolbar = getToolbar();
                    if (toolbar != null) {
                        view = toolbar.findViewById(item.getItemId());
                    } else {
                        view = null;
                    }
                    cVar3.show(view);
                    P1();
                }
                return true;
            }
            return super.A1(item);
        }
        return false;
    }

    @Override // s7.c.a
    public final void N0(C1557b popMenuItem) {
        i.f(popMenuItem, "popMenuItem");
        s7.c cVar = this.f28206i;
        if (cVar != null) {
            cVar.dismiss();
        }
        z(popMenuItem);
    }

    public boolean O1(MenuItem menuItem) {
        return InterfaceC1556a.C0358a.a(this, menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        s7.c cVar;
        s7.c cVar2;
        super.onResume();
        if (!s1() && (cVar = this.f28206i) != null && cVar.isShowing() && (cVar2 = this.f28206i) != null) {
            cVar2.dismiss();
        }
    }

    public void P1() {
    }
}
