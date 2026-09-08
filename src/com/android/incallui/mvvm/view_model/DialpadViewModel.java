package com.android.incallui.mvvm.view_model;

import com.android.incallui.mvvm.base.BaseViewModel;
import com.android.incallui.mvvm.utils.h;
import kotlin.Pair;
import kotlin.jvm.internal.f;
import m9.g;

/* compiled from: DialpadViewModel.kt */
/* loaded from: classes.dex */
public final class DialpadViewModel extends BaseViewModel {

    /* renamed from: f, reason: collision with root package name */
    public static final a f18704f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final Pair<Character, String>[] f18705g = {g.a('1', ""), g.a('2', "ABC"), g.a('3', "DEF"), g.a('4', "GHI"), g.a('5', "JKL"), g.a('6', "MNO"), g.a('7', "PQRS"), g.a('8', "TUV"), g.a('9', "WXYZ"), g.a('*', ""), g.a('0', ""), g.a('#', "")};

    /* renamed from: d, reason: collision with root package name */
    public final h<String> f18706d = new h<>("", false, 2, null);

    /* renamed from: e, reason: collision with root package name */
    public final h<Boolean> f18707e = new h<>(Boolean.FALSE, false, 2, null);

    /* compiled from: DialpadViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final Pair<Character, String>[] a() {
            return DialpadViewModel.f18705g;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final h<String> i() {
        return this.f18706d;
    }

    public final h<Boolean> j() {
        return this.f18707e;
    }
}
