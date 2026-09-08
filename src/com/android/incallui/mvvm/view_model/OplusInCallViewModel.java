package com.android.incallui.mvvm.view_model;

import android.R;
import androidx.lifecycle.J;
import com.android.incallui.Log;
import com.android.incallui.mvvm.base.BaseViewModel;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.SingleNonNullLiveEvent;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import kotlin.Pair;
import kotlin.coroutines.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.InterfaceC1265l0;
import v9.l;

/* compiled from: OplusInCallViewModel.kt */
/* loaded from: classes.dex */
public final class OplusInCallViewModel extends BaseViewModel {

    /* renamed from: o, reason: collision with root package name */
    public static final a f18708o = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final h<Integer> f18709d = new h<>(Integer.valueOf(g().getColor(R.color.transparent)), false, 2, null);

    /* renamed from: e, reason: collision with root package name */
    public final h<Boolean> f18710e;

    /* renamed from: f, reason: collision with root package name */
    public final h<Boolean> f18711f;

    /* renamed from: g, reason: collision with root package name */
    public final h<Integer> f18712g;

    /* renamed from: h, reason: collision with root package name */
    public final h<Boolean> f18713h;

    /* renamed from: i, reason: collision with root package name */
    public final y<Integer> f18714i;

    /* renamed from: j, reason: collision with root package name */
    public final h<Boolean> f18715j;

    /* renamed from: k, reason: collision with root package name */
    public final h<Boolean> f18716k;

    /* renamed from: l, reason: collision with root package name */
    public final SingleNonNullLiveEvent<Boolean> f18717l;

    /* renamed from: m, reason: collision with root package name */
    public InterfaceC1265l0 f18718m;

    /* renamed from: n, reason: collision with root package name */
    public final y<Boolean> f18719n;

    /* compiled from: OplusInCallViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public OplusInCallViewModel() {
        Boolean bool = Boolean.FALSE;
        this.f18710e = new h<>(bool, false, 2, null);
        this.f18711f = new h<>(bool, false, 2, null);
        this.f18712g = new h<>(Integer.valueOf(com.android.incallui.R.drawable.incall_btn_reject), false, 2, null);
        this.f18713h = new h<>(bool, false, 2, null);
        this.f18714i = IgnoreEqualsLiveDataKt.D(ResponsiveConfigRepository.f18540a.c0(), false, new l<Pair<? extends Integer, ? extends Integer>, Integer>() { // from class: com.android.incallui.mvvm.view_model.OplusInCallViewModel$mCallMaxContentWidth$1
            {
                super(1);
            }

            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(Pair<Integer, Integer> it) {
                i.f(it, "it");
                Integer valueOf = Integer.valueOf(OplusInCallViewModel.this.g().getResources().getDimensionPixelSize(com.android.incallui.R.dimen.fragment_call_button_max_width));
                Log.d("OplusInCallViewModel", "mCallMaxContentWidth change to: " + valueOf.intValue());
                return valueOf;
            }
        }, 1, null);
        this.f18715j = new h<>(bool, false, 2, null);
        this.f18716k = new h<>(bool, false, 2, null);
        SingleNonNullLiveEvent<Boolean> singleNonNullLiveEvent = new SingleNonNullLiveEvent<>(bool, false, 2, null);
        this.f18717l = singleNonNullLiveEvent;
        this.f18719n = IgnoreEqualsLiveDataKt.C(singleNonNullLiveEvent, false, new l<Boolean, Boolean>() { // from class: com.android.incallui.mvvm.view_model.OplusInCallViewModel$mAutoControlAudioDialog$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                InterfaceC1265l0 d10;
                OplusInCallViewModel oplusInCallViewModel = OplusInCallViewModel.this;
                if (z10) {
                    InterfaceC1265l0 n10 = oplusInCallViewModel.n();
                    if (n10 != null) {
                        InterfaceC1265l0.a.a(n10, null, 1, null);
                    }
                    d10 = C1248i.d(J.a(oplusInCallViewModel), null, null, new OplusInCallViewModel$mAutoControlAudioDialog$1$1$1(oplusInCallViewModel, null), 3, null);
                    oplusInCallViewModel.v(d10);
                }
                return Boolean.valueOf(z10);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool2) {
                return b(bool2.booleanValue());
            }
        }, 1, null);
    }

    public static /* synthetic */ Object j(OplusInCallViewModel oplusInCallViewModel, long j10, long j11, c cVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 500;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            j11 = 5000;
        }
        return oplusInCallViewModel.i(j12, j11, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(long r7, long r9, kotlin.coroutines.c<? super m9.q> r11) {
        /*
            r6 = this;
            boolean r0 = r11 instanceof com.android.incallui.mvvm.view_model.OplusInCallViewModel$autoShowAudioModeDialog$1
            if (r0 == 0) goto L13
            r0 = r11
            com.android.incallui.mvvm.view_model.OplusInCallViewModel$autoShowAudioModeDialog$1 r0 = (com.android.incallui.mvvm.view_model.OplusInCallViewModel$autoShowAudioModeDialog$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.android.incallui.mvvm.view_model.OplusInCallViewModel$autoShowAudioModeDialog$1 r0 = new com.android.incallui.mvvm.view_model.OplusInCallViewModel$autoShowAudioModeDialog$1
            r0.<init>(r6, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
            int r2 = r0.label
            r3 = 2
            java.lang.String r4 = "OplusInCallViewModel"
            r5 = 1
            if (r2 == 0) goto L44
            if (r2 == r5) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$0
            com.android.incallui.mvvm.view_model.OplusInCallViewModel r6 = (com.android.incallui.mvvm.view_model.OplusInCallViewModel) r6
            kotlin.b.b(r11)
            goto L9e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            long r9 = r0.J$0
            java.lang.Object r6 = r0.L$0
            com.android.incallui.mvvm.view_model.OplusInCallViewModel r6 = (com.android.incallui.mvvm.view_model.OplusInCallViewModel) r6
            kotlin.b.b(r11)
            goto L68
        L44:
            kotlin.b.b(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "delay autoShowAudioModeDialog: "
            r11.append(r2)
            r11.append(r7)
            java.lang.String r11 = r11.toString()
            com.android.incallui.Log.d(r4, r11)
            r0.L$0 = r6
            r0.J$0 = r9
            r0.label = r5
            java.lang.Object r7 = kotlinx.coroutines.M.a(r7, r0)
            if (r7 != r1) goto L68
            return r1
        L68:
            com.android.incallui.mvvm.repository.dynamic.a r7 = com.android.incallui.mvvm.repository.dynamic.a.f18559a
            boolean r8 = r7.c0()
            if (r8 != 0) goto L76
            boolean r7 = r7.o()
            if (r7 == 0) goto Lad
        L76:
            com.android.incallui.mvvm.utils.h<java.lang.Boolean> r7 = r6.f18715j
            java.lang.Boolean r8 = p9.C1467a.a(r5)
            r7.o(r8)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "autoShowAudioModeDialog duration: "
            r7.append(r8)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            com.android.incallui.Log.d(r4, r7)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.M.a(r9, r0)
            if (r7 != r1) goto L9e
            return r1
        L9e:
            com.android.incallui.mvvm.utils.h<java.lang.Boolean> r6 = r6.f18715j
            r7 = 0
            java.lang.Boolean r7 = p9.C1467a.a(r7)
            r6.o(r7)
            java.lang.String r6 = "dismiss autoShowAudioModeDialog"
            com.android.incallui.Log.d(r4, r6)
        Lad:
            m9.q r6 = m9.q.f35511a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.mvvm.view_model.OplusInCallViewModel.i(long, long, kotlin.coroutines.c):java.lang.Object");
    }

    public final h<Boolean> k() {
        return this.f18715j;
    }

    public final SingleNonNullLiveEvent<Boolean> l() {
        return this.f18717l;
    }

    public final y<Boolean> m() {
        return this.f18719n;
    }

    public final InterfaceC1265l0 n() {
        return this.f18718m;
    }

    public final h<Integer> o() {
        return this.f18709d;
    }

    public final y<Integer> p() {
        return this.f18714i;
    }

    public final h<Boolean> q() {
        return this.f18710e;
    }

    public final h<Boolean> r() {
        return this.f18713h;
    }

    public final h<Integer> s() {
        return this.f18712g;
    }

    public final h<Boolean> t() {
        return this.f18716k;
    }

    public final h<Boolean> u() {
        return this.f18711f;
    }

    public final void v(InterfaceC1265l0 interfaceC1265l0) {
        this.f18718m = interfaceC1265l0;
    }
}
