package com.android.oplus.brand;

import android.content.Context;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.oplus.answerview.fragment.AnswerMethod;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: BrandCenter.kt */
/* loaded from: classes.dex */
public final class BrandCenter {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19187a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final d<BrandCenter> f19188b;

    /* compiled from: BrandCenter.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final BrandCenter a() {
            return (BrandCenter) BrandCenter.f19188b.getValue();
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        d<BrandCenter> a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<BrandCenter>() { // from class: com.android.oplus.brand.BrandCenter$Companion$sInstance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final BrandCenter invoke() {
                return new BrandCenter(null);
            }
        });
        f19188b = a10;
    }

    public BrandCenter() {
    }

    public final void b(InCallPresenter.InCallState state) {
        i.f(state, "state");
        T5.a d10 = d();
        if (d10 != null) {
            d10.i(state);
        }
    }

    public final Class<? extends AnswerMethod> c() {
        T5.a d10;
        Log.d("BrandCenter", "getBrandAnswerMethod ");
        if (!OplusFeatureOption.OPLUS_VERSION_EXP || (d10 = d()) == null) {
            return null;
        }
        Class n10 = d10.n();
        if (!(n10 instanceof Class)) {
            return null;
        }
        return n10;
    }

    public final T5.a d() {
        return R5.a.a();
    }

    public final String e(Context context) {
        Log.d("BrandCenter", "getBrandRttStringMethod ");
        T5.a d10 = d();
        if (d10 != null) {
            return d10.y(context);
        }
        return null;
    }

    public final boolean f(Context context) {
        T5.a d10 = d();
        if (d10 != null) {
            return d10.B(context);
        }
        return false;
    }

    public final boolean g(boolean z10) {
        T5.a d10 = d();
        if (d10 != null) {
            return d10.p(z10);
        }
        return z10;
    }

    public final boolean h() {
        T5.a a10 = R5.a.a();
        if (a10 != null) {
            return a10.t();
        }
        return false;
    }

    public final boolean i() {
        T5.a d10 = d();
        if (d10 != null) {
            return d10.F();
        }
        return true;
    }

    public final void j(Context context) {
        if (context == null) {
            return;
        }
        Log.d("BrandCenter", "getBrandRttFragmentMethod");
        T5.a d10 = d();
        if (d10 != null && d10.d()) {
            d10.j(context);
        }
    }

    public /* synthetic */ BrandCenter(f fVar) {
        this();
    }
}
