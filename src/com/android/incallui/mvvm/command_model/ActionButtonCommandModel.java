package com.android.incallui.mvvm.command_model;

import b2.InterfaceC0519a;
import com.android.incallui.Log;
import com.android.incallui.OplusCallButtonFragment;
import com.android.incallui.mvvm.repository.dynamic.a;
import com.android.incallui.mvvm.utils.A;
import com.android.incallui.mvvm.view_model.ActionButtonViewModel;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;
import com.android.incallui.oplus.widgets.OplusIncallUIImageView;
import d2.C0948a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.InterfaceC1265l0;
import m9.q;
import v9.InterfaceC1637a;
import v9.l;

/* compiled from: ActionButtonCommandModel.kt */
/* loaded from: classes.dex */
public final class ActionButtonCommandModel extends C0948a<ActionButtonViewModel> {

    /* renamed from: f, reason: collision with root package name */
    public static final a f18526f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1637a<q> f18527b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC1637a<q> f18528c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1637a<q> f18529d;

    /* renamed from: e, reason: collision with root package name */
    public final l<Integer, q> f18530e;

    /* compiled from: ActionButtonCommandModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionButtonCommandModel(final ActionButtonViewModel mViewModel, final OplusInCallViewModel mInCallViewModel) {
        super(mViewModel);
        i.f(mViewModel, "mViewModel");
        i.f(mInCallViewModel, "mInCallViewModel");
        this.f18527b = new InterfaceC1637a<q>() { // from class: com.android.incallui.mvvm.command_model.ActionButtonCommandModel$performAudioButtonClick$1
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public /* bridge */ /* synthetic */ q invoke() {
                invoke2();
                return q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Log.d("ActionButtonCommandModel", "performAudioButtonClick");
                a aVar = a.f18559a;
                if (!aVar.c0() && !aVar.o() && !aVar.G1()) {
                    if (!aVar.o1() && !aVar.r1()) {
                        if (aVar.E1()) {
                            GlobalCommandModel.f18535a.b().invoke(5);
                        }
                    } else {
                        GlobalCommandModel.f18535a.b().invoke(8);
                    }
                } else {
                    OplusInCallViewModel.this.k().o(Boolean.TRUE);
                }
                InterfaceC1265l0 n10 = OplusInCallViewModel.this.n();
                if (n10 != null) {
                    InterfaceC1265l0.a.a(n10, null, 1, null);
                }
                GlobalCommandModel.f18535a.a();
            }
        };
        this.f18528c = new InterfaceC1637a<q>() { // from class: com.android.incallui.mvvm.command_model.ActionButtonCommandModel$handUpCall$1
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public /* bridge */ /* synthetic */ q invoke() {
                invoke2();
                return q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                OplusCallButtonFragment c10;
                OplusIncallUIImageView oplusIncallUIImageView;
                Log.d("ActionButtonCommandModel", "handUpCall");
                InterfaceC1265l0 n10 = OplusInCallViewModel.this.n();
                if (n10 != null) {
                    InterfaceC1265l0.a.a(n10, null, 1, null);
                }
                InterfaceC0519a a10 = A.a();
                if (a10 == null || (c10 = a10.c()) == null || (oplusIncallUIImageView = c10.mEndCallButton) == null) {
                    return;
                }
                oplusIncallUIImageView.performClick();
            }
        };
        this.f18529d = new InterfaceC1637a<q>() { // from class: com.android.incallui.mvvm.command_model.ActionButtonCommandModel$cancelAutoShowJobAndResetDialogVisible$1
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public /* bridge */ /* synthetic */ q invoke() {
                invoke2();
                return q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Log.d("ActionButtonCommandModel", "cancelAutoShowJobAndResetDialogVisible");
                InterfaceC1265l0 n10 = OplusInCallViewModel.this.n();
                if (n10 != null) {
                    InterfaceC1265l0.a.a(n10, null, 1, null);
                }
                OplusInCallViewModel.this.k().o(Boolean.FALSE);
            }
        };
        this.f18530e = new l<Integer, q>() { // from class: com.android.incallui.mvvm.command_model.ActionButtonCommandModel$refreshAudioModeAndChange$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
            
                if (kotlin.jvm.internal.i.b(r2, r5) != false) goto L55;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x00d9, code lost:
            
                if (r1 != 128) goto L55;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void b(int r8) {
                /*
                    Method dump skipped, instructions count: 263
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.mvvm.command_model.ActionButtonCommandModel$refreshAudioModeAndChange$1.b(int):void");
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num.intValue());
                return q.f35511a;
            }
        };
    }

    public final InterfaceC1637a<q> a() {
        return this.f18529d;
    }

    public final InterfaceC1637a<q> b() {
        return this.f18528c;
    }

    public final InterfaceC1637a<q> c() {
        return this.f18527b;
    }

    public final l<Integer, q> d() {
        return this.f18530e;
    }
}
