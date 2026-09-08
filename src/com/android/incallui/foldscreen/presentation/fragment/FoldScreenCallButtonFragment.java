package com.android.incallui.foldscreen.presentation.fragment;

import P1.e;
import R1.g;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.K;
import com.android.incallui.Log;
import com.android.incallui.foldscreen.presentation.controller.RespondViaSmsManager;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallButtonViewModel;
import g2.InterfaceC1034a;
import java.util.ArrayList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: FoldScreenCallButtonFragment.kt */
/* loaded from: classes.dex */
public final class FoldScreenCallButtonFragment extends Fragment implements InterfaceC1034a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f18431c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final m9.d f18432a;

    /* renamed from: b, reason: collision with root package name */
    public final b f18433b;

    /* compiled from: FoldScreenCallButtonFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: FoldScreenCallButtonFragment.kt */
    /* loaded from: classes.dex */
    public static final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Integer num;
            if (message != null) {
                num = Integer.valueOf(message.what);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 101) {
                FoldScreenCallButtonFragment.this.showSmsListView();
            }
        }
    }

    public FoldScreenCallButtonFragment() {
        m9.d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<FoldScreenCallButtonViewModel>() { // from class: com.android.incallui.foldscreen.presentation.fragment.FoldScreenCallButtonFragment$viewModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final FoldScreenCallButtonViewModel invoke() {
                return (FoldScreenCallButtonViewModel) new K(FoldScreenCallButtonFragment.this, new Z1.d(Y1.a.f5520a)).a(FoldScreenCallButtonViewModel.class);
            }
        });
        this.f18432a = b10;
        this.f18433b = new b(Looper.getMainLooper());
    }

    public static final void h1(g gVar, FoldScreenCallButtonFragment this$0, ViewStub viewStub, View view) {
        i.f(this$0, "this$0");
        ViewDataBinding g10 = gVar.f3282G.g();
        if (g10 != null) {
            g10.b1(this$0.getViewLifecycleOwner());
        }
    }

    public static final void i1(g gVar, FoldScreenCallButtonFragment this$0, ViewStub viewStub, View view) {
        i.f(this$0, "this$0");
        ViewDataBinding g10 = gVar.f3283H.g();
        if (g10 != null) {
            g10.b1(this$0.getViewLifecycleOwner());
        }
    }

    public static final void j1(g gVar, FoldScreenCallButtonFragment this$0, ViewStub viewStub, View view) {
        i.f(this$0, "this$0");
        ViewDataBinding g10 = gVar.f3284I.g();
        if (g10 != null) {
            g10.b1(this$0.getViewLifecycleOwner());
        }
    }

    public final FoldScreenCallButtonViewModel g1() {
        return (FoldScreenCallButtonViewModel) this.f18432a.getValue();
    }

    public final void k1() {
        if (!g1().y().isEmpty()) {
            if (this.f18433b.hasMessages(101)) {
                this.f18433b.removeMessages(101);
            }
            this.f18433b.sendEmptyMessage(101);
        }
    }

    @Override // g2.InterfaceC1034a
    public void onAnswer(int i10, Context context, int i11) {
        g1().D(i10, i11);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View inflate = inflater.inflate(e.f2870g, viewGroup, false);
        final g i12 = g.i1(inflate);
        i12.l1(g1());
        i12.k1(this);
        i12.b1(getViewLifecycleOwner());
        i12.f3282G.l(new ViewStub.OnInflateListener() { // from class: com.android.incallui.foldscreen.presentation.fragment.a
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                FoldScreenCallButtonFragment.h1(g.this, this, viewStub, view);
            }
        });
        i12.f3283H.l(new ViewStub.OnInflateListener() { // from class: com.android.incallui.foldscreen.presentation.fragment.b
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                FoldScreenCallButtonFragment.i1(g.this, this, viewStub, view);
            }
        });
        i12.f3284I.l(new ViewStub.OnInflateListener() { // from class: com.android.incallui.foldscreen.presentation.fragment.c
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                FoldScreenCallButtonFragment.j1(g.this, this, viewStub, view);
            }
        });
        return inflate;
    }

    @Override // g2.InterfaceC1034a
    public void onDecline(Context context) {
        g1().E();
    }

    @Override // g2.InterfaceC1034a
    public void onShowSmsListView() {
        k1();
    }

    public void onSilenceRinger() {
        g1().G();
    }

    public final void showSmsListDialog() {
        ArrayList<String> y10 = g1().y();
        if (y10.isEmpty()) {
            Log.d("INCALL_FoldScreenCallButtonFragment", "showSmsListDialog: mSmsRefuseList is null or isEmpty");
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Log.d("INCALL_FoldScreenCallButtonFragment", "showSmsListDialog: context is null");
        } else {
            RespondViaSmsManager.f18413a.u(activity, y10);
        }
    }

    public final void showSmsListView() {
        if (Log.sDebug) {
            Log.d("INCALL_FoldScreenCallButtonFragment", "showSmsListView mShow ");
        }
        if (i.b(g1().C().getValue(), Boolean.FALSE)) {
            return;
        }
        onSilenceRinger();
        showSmsListDialog();
    }

    @Override // g2.InterfaceC1034a
    public void onShowInterceptSelectionDialog() {
    }
}
