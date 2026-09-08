package com.android.contacts.framework.baseui.viewmodel;

import androidx.lifecycle.I;
import androidx.lifecycle.J;
import androidx.lifecycle.v;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;

/* compiled from: TabActivityViewModel.kt */
/* loaded from: classes.dex */
public final class TabActivityViewModel extends I {

    /* renamed from: i, reason: collision with root package name */
    public static final a f15985i = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final v<TabFragment> f15986d = new v<>();

    /* renamed from: e, reason: collision with root package name */
    public final v<Boolean> f15987e = new v<>();

    /* renamed from: f, reason: collision with root package name */
    public final v<Integer> f15988f = new v<>(0);

    /* renamed from: g, reason: collision with root package name */
    public final v<Integer> f15989g = new v<>(0);

    /* renamed from: h, reason: collision with root package name */
    public final v<Boolean> f15990h = new v<>(Boolean.FALSE);

    /* compiled from: TabActivityViewModel.kt */
    /* loaded from: classes.dex */
    public enum TabFragment {
        Dialer("phone"),
        Contact("contact"),
        VoiceMail("voice_mail"),
        BusinessHall("service_hall");

        private final String tag;

        TabFragment(String str) {
            this.tag = str;
        }

        public final String b() {
            return this.tag;
        }
    }

    /* compiled from: TabActivityViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final v<Boolean> g() {
        return this.f15987e;
    }

    public final v<Integer> h() {
        return this.f15988f;
    }

    public final v<Integer> i() {
        return this.f15989g;
    }

    public final v<TabFragment> j() {
        return this.f15986d;
    }

    public final boolean k() {
        Integer value = this.f15988f.getValue();
        if (value != null && value.intValue() == 2) {
            return true;
        }
        return false;
    }

    public final v<Boolean> l() {
        return this.f15990h;
    }

    public final void m() {
        C1248i.d(J.a(this), S.b(), null, new TabActivityViewModel$refreshToolbarRedDot$1(this, null), 2, null);
    }

    public final void n(int i10) {
        this.f15988f.m(Integer.valueOf(i10));
    }
}
