package com.android.incallui.foldscreen.presentation.viewmodel;

import A2.c;
import H1.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.clean.domain.interactor.UseCase0;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import d.InterfaceC0944a;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import kotlin.Pair;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import v9.l;
import v9.q;

/* compiled from: FoldScreenCallCardViewModel.kt */
/* loaded from: classes.dex */
public final class FoldScreenCallCardViewModel extends FoldScreenBaseViewModel implements c.b {

    /* renamed from: K, reason: collision with root package name */
    public static final a f18489K = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public int f18490A;

    /* renamed from: B, reason: collision with root package name */
    public int f18491B;

    /* renamed from: C, reason: collision with root package name */
    public final boolean f18492C;

    /* renamed from: D, reason: collision with root package name */
    public final h<String> f18493D;

    /* renamed from: E, reason: collision with root package name */
    public final h<Drawable> f18494E;

    /* renamed from: F, reason: collision with root package name */
    public final y<Boolean> f18495F;

    /* renamed from: G, reason: collision with root package name */
    public final PropertyChangeListener f18496G;

    /* renamed from: H, reason: collision with root package name */
    public final PropertyChangeListener f18497H;

    /* renamed from: I, reason: collision with root package name */
    public final PropertyChangeListener f18498I;

    /* renamed from: J, reason: collision with root package name */
    public final PropertyChangeListener f18499J;

    /* renamed from: i, reason: collision with root package name */
    public final UseCase0<g<H1.a>> f18500i;

    /* renamed from: j, reason: collision with root package name */
    public final UseCase0<g<H1.b>> f18501j;

    /* renamed from: k, reason: collision with root package name */
    public final UseCase0<g<H1.a>> f18502k;

    /* renamed from: l, reason: collision with root package name */
    public final UseCase0<g<H1.b>> f18503l;

    /* renamed from: m, reason: collision with root package name */
    public final h<Long> f18504m;

    /* renamed from: n, reason: collision with root package name */
    public final h<Boolean> f18505n;

    /* renamed from: o, reason: collision with root package name */
    public final h<String> f18506o;

    /* renamed from: p, reason: collision with root package name */
    public final h<H1.b> f18507p;

    /* renamed from: q, reason: collision with root package name */
    public final h<String> f18508q;

    /* renamed from: r, reason: collision with root package name */
    public final h<String> f18509r;

    /* renamed from: x, reason: collision with root package name */
    public final y<Pair<String, String>> f18510x;

    /* renamed from: y, reason: collision with root package name */
    public final h<Drawable> f18511y;

    /* renamed from: z, reason: collision with root package name */
    public final h<Drawable> f18512z;

    /* compiled from: FoldScreenCallCardViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @InterfaceC0944a
    public FoldScreenCallCardViewModel(Y1.a useCaseProvider) {
        super(useCaseProvider);
        i.f(useCaseProvider, "useCaseProvider");
        UseCase0<g<H1.a>> d10 = useCaseProvider.b().d();
        this.f18500i = d10;
        UseCase0<g<H1.b>> d11 = useCaseProvider.c().d();
        this.f18501j = d11;
        UseCase0<g<H1.a>> e10 = useCaseProvider.b().e();
        this.f18502k = e10;
        UseCase0<g<H1.b>> e11 = useCaseProvider.c().e();
        this.f18503l = e11;
        h<Long> hVar = new h<>(0L, true);
        this.f18504m = hVar;
        Boolean bool = Boolean.FALSE;
        h<Boolean> hVar2 = new h<>(bool, true);
        this.f18505n = hVar2;
        h<String> hVar3 = new h<>(true);
        this.f18506o = hVar3;
        this.f18507p = new h<>(true);
        this.f18508q = new h<>(true);
        this.f18509r = new h<>(true);
        this.f18510x = IgnoreEqualsLiveDataKt.G(IgnoreEqualsLiveDataKt.s(m9.g.a(hVar2, hVar), hVar3), false, new q<Boolean, Long, String, Pair<? extends String, ? extends String>>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallCardViewModel$primaryCallState$1
            {
                super(3);
            }

            public final Pair<String, String> b(boolean z10, long j10, String str) {
                String str2;
                String str3;
                if (z10) {
                    str2 = D2.b.a(FoldScreenCallCardViewModel.this.g(), j10 / 1000);
                    i.e(str2, "formatElapsedTime(defaul…onstants.SECONDS_DIVISOR)");
                    str3 = OplusPhoneUtils.formatDuration(j10);
                    i.e(str3, "formatDuration(callDuration)");
                } else {
                    if (str == null) {
                        str = "";
                    }
                    str2 = str;
                    str3 = str2;
                }
                return m9.g.a(str2, str3);
            }

            @Override // v9.q
            public /* bridge */ /* synthetic */ Pair<? extends String, ? extends String> d(Boolean bool2, Long l10, String str) {
                return b(bool2.booleanValue(), l10.longValue(), str);
            }
        }, 1, null);
        this.f18511y = new h<>(null, true);
        this.f18512z = new h<>(null, true);
        this.f18490A = 4;
        this.f18491B = 4;
        this.f18492C = OplusFeatureOption.FEATURE_SOFTWARE_SUPPORT_SECONDARY_MINI_APP;
        h<String> hVar4 = new h<>(true);
        this.f18493D = hVar4;
        this.f18494E = new h<>(null, true);
        this.f18495F = IgnoreEqualsLiveDataKt.t(hVar4, bool, true, new l<String, Boolean>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallCardViewModel$secondaryInfoVisibility$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(String str) {
                boolean z10;
                if (str != null && str.length() != 0) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                return Boolean.valueOf(true ^ z10);
            }
        });
        PropertyChangeListener propertyChangeListener = new PropertyChangeListener() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.a
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                FoldScreenCallCardViewModel.D(FoldScreenCallCardViewModel.this, propertyChangeEvent);
            }
        };
        this.f18496G = propertyChangeListener;
        PropertyChangeListener propertyChangeListener2 = new PropertyChangeListener() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.b
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                FoldScreenCallCardViewModel.E(FoldScreenCallCardViewModel.this, propertyChangeEvent);
            }
        };
        this.f18497H = propertyChangeListener2;
        PropertyChangeListener propertyChangeListener3 = new PropertyChangeListener() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.c
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                FoldScreenCallCardViewModel.F(FoldScreenCallCardViewModel.this, propertyChangeEvent);
            }
        };
        this.f18498I = propertyChangeListener3;
        PropertyChangeListener propertyChangeListener4 = new PropertyChangeListener() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.d
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                FoldScreenCallCardViewModel.G(FoldScreenCallCardViewModel.this, propertyChangeEvent);
            }
        };
        this.f18499J = propertyChangeListener4;
        Log.d("FoldScreenCallCardViewModel", "init");
        g<H1.a> b10 = d10.b();
        I(this, b10.b(), null, 2, null);
        b10.a(propertyChangeListener);
        g<H1.b> b11 = d11.b();
        J(b11.b());
        b11.a(propertyChangeListener2);
        Pair a10 = m9.g.a(e10.b(), e11.b());
        K((H1.a) ((g) a10.c()).b(), (H1.b) ((g) a10.d()).b());
        ((g) a10.c()).a(propertyChangeListener3);
        ((g) a10.d()).a(propertyChangeListener4);
        A2.c.d().b(this);
    }

    public static final void D(FoldScreenCallCardViewModel this$0, PropertyChangeEvent propertyChangeEvent) {
        H1.a aVar;
        i.f(this$0, "this$0");
        Object newValue = propertyChangeEvent.getNewValue();
        if (newValue instanceof H1.a) {
            aVar = (H1.a) newValue;
        } else {
            aVar = null;
        }
        I(this$0, aVar, null, 2, null);
    }

    public static final void E(FoldScreenCallCardViewModel this$0, PropertyChangeEvent propertyChangeEvent) {
        H1.b bVar;
        i.f(this$0, "this$0");
        Object newValue = propertyChangeEvent.getNewValue();
        if (newValue instanceof H1.b) {
            bVar = (H1.b) newValue;
        } else {
            bVar = null;
        }
        this$0.J(bVar);
    }

    public static final void F(FoldScreenCallCardViewModel this$0, PropertyChangeEvent propertyChangeEvent) {
        H1.a aVar;
        i.f(this$0, "this$0");
        Object newValue = propertyChangeEvent.getNewValue();
        if (newValue instanceof H1.a) {
            aVar = (H1.a) newValue;
        } else {
            aVar = null;
        }
        this$0.K(aVar, this$0.f18503l.b().b());
    }

    public static final void G(FoldScreenCallCardViewModel this$0, PropertyChangeEvent propertyChangeEvent) {
        H1.b bVar;
        i.f(this$0, "this$0");
        H1.a b10 = this$0.f18502k.b().b();
        Object newValue = propertyChangeEvent.getNewValue();
        if (newValue instanceof H1.b) {
            bVar = (H1.b) newValue;
        } else {
            bVar = null;
        }
        this$0.K(b10, bVar);
    }

    public static /* synthetic */ void I(FoldScreenCallCardViewModel foldScreenCallCardViewModel, H1.a aVar, H1.b bVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bVar = foldScreenCallCardViewModel.f18501j.b().b();
        }
        foldScreenCallCardViewModel.H(aVar, bVar);
    }

    public final h<Drawable> A() {
        return this.f18494E;
    }

    public final y<Boolean> B() {
        return this.f18495F;
    }

    public final boolean C() {
        return this.f18492C;
    }

    public final void H(H1.a aVar, H1.b bVar) {
        String str;
        Log.d("FoldScreenCallCardViewModel", "updatePrimaryCallInfo: callInfo=" + aVar);
        if (aVar == null) {
            return;
        }
        String d10 = aVar.d();
        if (bVar != null) {
            str = bVar.f();
        } else {
            str = null;
        }
        if (!i.b(d10, str)) {
            Log.d("FoldScreenCallCardViewModel", "updatePrimaryCallInfo: callId different return");
            return;
        }
        int b10 = Z1.c.b(aVar, bVar);
        this.f18490A = b10;
        this.f18508q.o(s(aVar, b10));
        this.f18509r.o(u(aVar, this.f18490A, bVar));
        this.f18511y.o(Z1.c.c(OplusInCallApp.getDefaultDisplayUiContext(), aVar.h(), aVar.j(), this.f18490A));
    }

    public final void J(H1.b bVar) {
        boolean z10;
        String str;
        Log.d("FoldScreenCallCardViewModel", "updatePrimaryCallState: callState=" + bVar);
        if (this.f18490A == 5) {
            this.f18509r.o(u(this.f18500i.b().b(), this.f18490A, bVar));
        }
        h<Boolean> hVar = this.f18505n;
        if (bVar != null) {
            z10 = bVar.l();
        } else {
            z10 = false;
        }
        hVar.o(Boolean.valueOf(z10));
        h<String> hVar2 = this.f18506o;
        if (bVar == null || (str = bVar.e()) == null) {
            str = "";
        }
        hVar2.o(str);
        this.f18512z.o(Z1.c.a(bVar));
        this.f18507p.o(bVar);
    }

    public final void K(H1.a aVar, H1.b bVar) {
        int i10;
        Log.d("FoldScreenCallCardViewModel", "updateSecondaryCallInfoState: callInfo=" + aVar + " callState=" + bVar);
        if (aVar == null) {
            this.f18493D.o(null);
            this.f18494E.o(null);
            return;
        }
        this.f18491B = Z1.c.b(aVar, bVar);
        this.f18493D.o(z(aVar, bVar));
        H1.a b10 = this.f18500i.b().b();
        if (b10 != null) {
            i10 = b10.h();
        } else {
            i10 = -1;
        }
        if (i10 == aVar.h()) {
            this.f18494E.o(null);
        } else {
            this.f18494E.o(Z1.c.c(OplusInCallApp.getDefaultDisplayUiContext(), aVar.h(), aVar.j(), this.f18491B));
        }
    }

    @Override // androidx.lifecycle.I
    public void e() {
        super.e();
        this.f18500i.b().c(this.f18496G);
        this.f18501j.b().c(this.f18497H);
        this.f18502k.b().c(this.f18498I);
        this.f18503l.b().c(this.f18499J);
        A2.c.d().f(this);
    }

    public final h<Drawable> q() {
        return this.f18512z;
    }

    public final h<String> r() {
        return this.f18508q;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String s(H1.a aVar, int i10) {
        String b10;
        Pair<String, String> b11;
        String str = null;
        if (aVar == null) {
            return null;
        }
        Context g10 = g();
        switch (i10) {
            case 0:
                H1.c a10 = aVar.a();
                if (a10 != null) {
                    b10 = a10.b();
                    break;
                }
                b10 = null;
                break;
            case 1:
                H1.f f10 = aVar.f();
                if (f10 != null) {
                    b10 = f10.c();
                    break;
                }
                b10 = null;
                break;
            case 2:
                H1.f f11 = aVar.f();
                if (f11 != null && (b11 = f11.b()) != null) {
                    b10 = b11.c();
                    break;
                }
                b10 = null;
                break;
            case 3:
                H1.f f12 = aVar.f();
                if (f12 != null) {
                    b10 = f12.a();
                    break;
                }
                b10 = null;
                break;
            case 4:
                String b12 = aVar.b();
                if (b12 != null && b12.length() != 0) {
                    b10 = aVar.b();
                    break;
                } else {
                    H1.c a11 = aVar.a();
                    if (a11 != null) {
                        b10 = a11.b();
                        break;
                    }
                    b10 = null;
                    break;
                }
                break;
            case 5:
                if (aVar.i()) {
                    b10 = g10.getString(R.string.oplus_cdma_multi_call);
                    break;
                } else {
                    b10 = g10.getString(R.string.card_title_conf_call);
                    break;
                }
            case 6:
                b10 = g10.getString(R.string.oplus_emergency_call_dialog_number_for_display);
                break;
            case 7:
            default:
                b10 = null;
                break;
            case 8:
                b10 = aVar.e();
                break;
        }
        if (b10 == null || b10.length() == 0) {
            if (D2.b.q(aVar.g())) {
                str = g10.getString(R.string.oplus_co_service_center);
            } else {
                String b13 = aVar.b();
                if (b13 != null && b13.length() != 0) {
                    str = aVar.b();
                } else {
                    H1.c a12 = aVar.a();
                    if (a12 != null) {
                        str = a12.b();
                    }
                }
            }
            b10 = str;
        }
        Log.d("FoldScreenCallCardViewModel", "getPrimaryCallInfoLineOne: callInfoType=" + S1.b.f3376a.a(i10));
        return b10;
    }

    public final h<String> t() {
        return this.f18509r;
    }

    public final String u(H1.a aVar, int i10, H1.b bVar) {
        String string;
        String str = null;
        if (aVar == null) {
            return null;
        }
        Context g10 = g();
        if (i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                if (i10 != 5) {
                    if (i10 != 6) {
                        if (i10 != 8) {
                            str = aVar.e();
                        }
                    } else {
                        str = aVar.j() ? g10.getString(R.string.oplus_emergency_number) : aVar.e();
                    }
                } else if (!aVar.i() && bVar != null && bVar.b()) {
                    str = g10.getResources().getQuantityString(R.plurals.incall_conference_participant, bVar.c(), Integer.valueOf(bVar.c()));
                }
            }
            str = aVar.b();
        } else {
            if (aVar.j()) {
                string = g10.getString(R.string.oplus_emergency_number);
            } else {
                string = g10.getString(R.string.oplus_yellow_page_number);
            }
            str = aVar.b() + ' ' + string;
        }
        if ((str == null || str.length() == 0) && i10 == 0) {
            str = aVar.b();
        }
        Log.d("FoldScreenCallCardViewModel", "getPrimaryCallInfoLineTwo: callInfoType=" + S1.b.f3376a.a(i10));
        return str;
    }

    @Override // A2.c.b
    public void updateCallTime() {
        h<Long> hVar = this.f18504m;
        H1.b b10 = this.f18501j.b().b();
        long j10 = 0;
        if (b10 != null) {
            long d10 = b10.d();
            if (d10 != 0) {
                j10 = System.currentTimeMillis() - d10;
            }
        }
        hVar.o(Long.valueOf(j10));
    }

    public final h<Drawable> v() {
        return this.f18511y;
    }

    public final y<Pair<String, String>> w() {
        return this.f18510x;
    }

    public final h<H1.b> x() {
        return this.f18507p;
    }

    public final h<String> y() {
        return this.f18493D;
    }

    public final String z(H1.a aVar, H1.b bVar) {
        if (aVar == null || bVar == null) {
            return null;
        }
        String s10 = s(aVar, this.f18491B);
        String e10 = bVar.e();
        if (s10 == null || s10.length() == 0) {
            return null;
        }
        if (e10 != null && e10.length() != 0) {
            return s10 + " | " + e10;
        }
        return s10;
    }
}
