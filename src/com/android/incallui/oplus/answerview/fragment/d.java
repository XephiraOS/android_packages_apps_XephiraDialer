package com.android.incallui.oplus.answerview.fragment;

import androidx.fragment.app.B;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.oplus.brand.BrandCenter;

/* compiled from: AnswerMethodFactory.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f18742a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static Class<? extends AnswerMethod> f18743b = FlingUpAnswerMethod.class;

    public final AnswerMethod a(Class<? extends AnswerMethod> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e10) {
            Log.w("AnswerMethodFactory", "newInstanceFragmentById failed:" + e10.getMessage());
            return null;
        } catch (InstantiationException e11) {
            Log.w("AnswerMethodFactory", "newInstanceFragmentById failed:" + e11.getMessage());
            return null;
        }
    }

    public final Class<? extends AnswerMethod> b() {
        if (d()) {
            return StaticAnswerMethod.class;
        }
        if (c()) {
            return RideModeAnswerMethod.class;
        }
        return FlingUpAnswerMethod.class;
    }

    public final boolean c() {
        return OplusPhoneUtils.isRideMode();
    }

    public final boolean d() {
        return G2.a.a(OplusInCallApp.getAppContext());
    }

    public final void e(FragmentManager fragmentManager) {
        Fragment m02;
        if (fragmentManager != null && (m02 = fragmentManager.m0(f18743b.getName())) != null) {
            fragmentManager.p().r(m02).j();
        }
    }

    public final void f(FragmentManager fragmentManager) {
        if (fragmentManager != null) {
            B p10 = fragmentManager.p();
            Class<? extends AnswerMethod> c10 = BrandCenter.f19187a.a().c();
            if (c10 == null) {
                c10 = f18742a.b();
            }
            Fragment m02 = fragmentManager.m0(c10.getName());
            if (m02 == null) {
                m02 = f18742a.a(c10);
            }
            if (m02 != null) {
                if (m02.isAdded()) {
                    p10.y(m02);
                } else {
                    p10.t(R.id.answer_method_container, m02, c10.getName());
                }
            }
            f18743b = c10;
            p10.j();
        }
    }
}
