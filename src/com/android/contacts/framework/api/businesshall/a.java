package com.android.contacts.framework.api.businesshall;

import I.d;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;
import v9.l;

/* compiled from: BusinessHallCompat.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15566a = new a();

    public static final void a(InterfaceC1637a<Boolean> isFeatureSupport) {
        i.f(isFeatureSupport, "isFeatureSupport");
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            a10.c(isFeatureSupport);
        }
    }

    public static final List<d<String, List<String>>> b() {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            return a10.a();
        }
        return null;
    }

    public static final Class<? extends Fragment> c() {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            return a10.k();
        }
        return null;
    }

    public static final int d() {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            return a10.f();
        }
        return 0;
    }

    public static final ArrayList<d<String, Boolean>> e() {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            return a10.i();
        }
        return null;
    }

    public static final LiveData<Boolean> f() {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            return a10.g();
        }
        return null;
    }

    public static final boolean g(String inputString) {
        i.f(inputString, "inputString");
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            return a10.h(inputString);
        }
        return false;
    }

    public static final LiveData<Boolean> h() {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            return a10.j();
        }
        return null;
    }

    public static final boolean i() {
        if (IBusinessHall.f15562a.a() != null && CommonFeatureOption.j()) {
            return true;
        }
        return false;
    }

    public static final void j(Resources.Theme theme, int i10, boolean z10) {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            a10.l(theme, i10, z10);
        }
    }

    public static final boolean k(Context context) {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null && context != null) {
            a10.e(context);
            return true;
        }
        return false;
    }

    public static final boolean l(String str) {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            return a10.n(str);
        }
        return false;
    }

    public static final void m(l<? super View, Boolean> lVar) {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            a10.b(lVar);
        }
    }

    public static final void n(Context context) {
        i.f(context, "context");
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            a10.m(context);
        }
    }

    public static final void o(boolean z10) {
        IBusinessHall a10 = IBusinessHall.f15562a.a();
        if (a10 != null) {
            a10.d(z10);
        }
    }
}
