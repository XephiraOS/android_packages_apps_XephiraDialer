package com.android.incallui.mvvm.view;

import O1.AbstractC0401g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.K;
import androidx.lifecycle.w;
import b2.InterfaceC0519a;
import com.android.incallui.Log;
import com.android.incallui.OplusCallButtonFragment;
import com.android.incallui.OplusInCallActivity;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.mvvm.command_model.ActionButtonCommandModel;
import com.android.incallui.mvvm.command_model.CommandModelPipeLineKt;
import com.android.incallui.mvvm.command_model.GlobalCommandModel;
import com.android.incallui.mvvm.usecase.FragmentStateUseCase;
import com.android.incallui.mvvm.utils.A;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.y;
import com.android.incallui.mvvm.view_model.ActionButtonViewModel;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;
import com.android.incallui.mvvm.widget.SuitableSizeEditText;
import com.android.incallui.oplus.callbutton.callbuttonview.FunctionButtonLayout;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.PopupListItem;
import e2.C0966a;
import java.util.ArrayList;
import java.util.List;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: OplusActionButtonFragment.kt */
/* loaded from: classes.dex */
public final class OplusActionButtonFragment extends Fragment implements View.OnClickListener {

    /* renamed from: m, reason: collision with root package name */
    public static final a f18612m = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final m9.d f18613a;

    /* renamed from: b, reason: collision with root package name */
    public final m9.d f18614b;

    /* renamed from: c, reason: collision with root package name */
    public final m9.d f18615c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18616d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f18617e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f18618f;

    /* renamed from: g, reason: collision with root package name */
    public FunctionButtonLayout f18619g;

    /* renamed from: h, reason: collision with root package name */
    public AbstractC0401g f18620h;

    /* renamed from: i, reason: collision with root package name */
    public final List<PopupListItem> f18621i;

    /* renamed from: j, reason: collision with root package name */
    public COUIPopupListWindow f18622j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.appcompat.app.b f18623k;

    /* renamed from: l, reason: collision with root package name */
    public final m9.d f18624l;

    /* compiled from: OplusActionButtonFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: OplusActionButtonFragment.kt */
    /* loaded from: classes.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SuitableSizeEditText f18626b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f18627c;

        public b(SuitableSizeEditText suitableSizeEditText, View view) {
            this.f18626b = suitableSizeEditText;
            this.f18627c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            OplusCallButtonFragment oplusCallButtonFragment;
            View view = this.f18627c;
            if (view != null) {
                view.setVisibility(8);
            }
            Log.d("OplusActionButtonMOFragment", "startHideDialpadAnimation onAnimationEnd");
            OplusActionButtonFragment.this.f18617e = false;
            InterfaceC0519a a10 = A.a();
            if (a10 != null) {
                oplusCallButtonFragment = a10.c();
            } else {
                oplusCallButtonFragment = null;
            }
            if (oplusCallButtonFragment != null) {
                oplusCallButtonFragment.mCallButtonAnimFlag = 0;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view;
            Log.d("OplusActionButtonMOFragment", "startHideDialpadAnimation onAnimationStart");
            OplusActionButtonFragment.this.f18617e = true;
            SuitableSizeEditText suitableSizeEditText = this.f18626b;
            if (suitableSizeEditText != null) {
                suitableSizeEditText.setVisibility(8);
            }
            InterfaceC0519a a10 = A.a();
            if (a10 != null) {
                a10.k(false);
            }
            InterfaceC0519a a11 = A.a();
            OplusCallButtonFragment oplusCallButtonFragment = null;
            if (a11 != null) {
                view = a11.j(3);
            } else {
                view = null;
            }
            if (view != null) {
                view.setAlpha(1.0f);
            }
            InterfaceC0519a a12 = A.a();
            if (a12 != null) {
                oplusCallButtonFragment = a12.c();
            }
            if (oplusCallButtonFragment != null) {
                oplusCallButtonFragment.mCallButtonAnimFlag = 1;
            }
        }
    }

    /* compiled from: OplusActionButtonFragment.kt */
    /* loaded from: classes.dex */
    public static final class c extends com.android.incallui.anim.d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f18629b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SuitableSizeEditText f18630c;

        /* compiled from: OplusActionButtonFragment.kt */
        /* loaded from: classes.dex */
        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OplusActionButtonFragment f18631a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SuitableSizeEditText f18632b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f18633c;

            public a(OplusActionButtonFragment oplusActionButtonFragment, SuitableSizeEditText suitableSizeEditText, View view) {
                this.f18631a = oplusActionButtonFragment;
                this.f18632b = suitableSizeEditText;
                this.f18633c = view;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Log.d("OplusActionButtonMOFragment", "show dialpad animator onAnimationEnd");
                this.f18631a.f18616d = false;
                SuitableSizeEditText suitableSizeEditText = this.f18632b;
                if (suitableSizeEditText != null) {
                    suitableSizeEditText.setVisibility(0);
                }
                SuitableSizeEditText suitableSizeEditText2 = this.f18632b;
                if (suitableSizeEditText2 != null) {
                    suitableSizeEditText2.setAlpha(1.0f);
                }
                InterfaceC0519a a10 = A.a();
                if (a10 != null) {
                    a10.k(true);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View view = this.f18633c;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view, SuitableSizeEditText suitableSizeEditText) {
            super("dialpadShow", null);
            this.f18629b = view;
            this.f18630c = suitableSizeEditText;
        }

        @Override // com.android.incallui.anim.d, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            com.android.incallui.anim.b.c().b(this.f18629b, true, OplusActionButtonFragment.this.f18617e, new a(OplusActionButtonFragment.this, this.f18630c, this.f18629b));
        }

        @Override // com.android.incallui.anim.d, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            Log.d("OplusActionButtonMOFragment", "show dialpad animator onAnimationStart");
            OplusActionButtonFragment.this.f18616d = true;
            InterfaceC0519a a10 = A.a();
            if (a10 != null) {
                a10.displayDialpad(true);
            }
            InterfaceC0519a a11 = A.a();
            if (a11 != null) {
                a11.k(false);
            }
        }
    }

    public OplusActionButtonFragment() {
        m9.d b10;
        m9.d b11;
        m9.d b12;
        m9.d b13;
        b10 = kotlin.a.b(new InterfaceC1637a<ActionButtonViewModel>() { // from class: com.android.incallui.mvvm.view.OplusActionButtonFragment$mViewModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ActionButtonViewModel invoke() {
                return (ActionButtonViewModel) new K(OplusActionButtonFragment.this).a(ActionButtonViewModel.class);
            }
        });
        this.f18613a = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<OplusInCallViewModel>() { // from class: com.android.incallui.mvvm.view.OplusActionButtonFragment$mInCallViewModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final OplusInCallViewModel invoke() {
                FragmentActivity requireActivity = OplusActionButtonFragment.this.requireActivity();
                kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
                return (OplusInCallViewModel) new K(requireActivity).a(OplusInCallViewModel.class);
            }
        });
        this.f18614b = b11;
        b12 = kotlin.a.b(new InterfaceC1637a<ActionButtonCommandModel>() { // from class: com.android.incallui.mvvm.view.OplusActionButtonFragment$mActionButtonCommandModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ActionButtonCommandModel invoke() {
                ActionButtonViewModel C12;
                OplusInCallViewModel B12;
                C12 = OplusActionButtonFragment.this.C1();
                B12 = OplusActionButtonFragment.this.B1();
                return new ActionButtonCommandModel(C12, B12);
            }
        });
        this.f18615c = b12;
        this.f18618f = isDialpadVisible();
        this.f18621i = new ArrayList();
        b13 = kotlin.a.b(new InterfaceC1637a<c2.c<C0966a>>() { // from class: com.android.incallui.mvvm.view.OplusActionButtonFragment$mAudioModeAdapter$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c2.c<C0966a> invoke() {
                ActionButtonViewModel C12;
                FragmentActivity requireActivity = OplusActionButtonFragment.this.requireActivity();
                kotlin.jvm.internal.i.d(requireActivity, "null cannot be cast to non-null type com.android.incallui.OplusInCallActivity");
                C12 = OplusActionButtonFragment.this.C1();
                return new c2.c<>((OplusInCallActivity) requireActivity, C12.k().getValue());
            }
        });
        this.f18624l = b13;
    }

    public static final void H1(OplusActionButtonFragment this$0, COUIPopupListWindow this_apply, AdapterView adapterView, View view, int i10, long j10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(this_apply, "$this_apply");
        CommandModelPipeLineKt.d(this$0.z1().d(), Integer.valueOf(i10), null, 2, null);
        this_apply.dismiss();
    }

    public static final void I1(OplusActionButtonFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        CommandModelPipeLineKt.c(this$0.z1().a(), null, 1, null);
    }

    public static final void J1(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void K1(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void L1(COUIPopupListWindow this_apply, View anchor) {
        kotlin.jvm.internal.i.f(this_apply, "$this_apply");
        kotlin.jvm.internal.i.f(anchor, "$anchor");
        this_apply.show(anchor, true);
    }

    public static final void N1(DialogInterface dialogInterface, int i10) {
        OplusPhoneUtils.putUserSwitchRoute(128);
        TelecomAdapter.getInstance().setAudioRoute(128);
    }

    public static final void P1(OplusActionButtonFragment this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.B1().t().o(Boolean.FALSE);
    }

    public static final void U1(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void V1(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void W1(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initView(View view) {
        if (view != null) {
            View findViewById = view.findViewById(R.id.audio_button);
            kotlin.jvm.internal.i.e(findViewById, "view.findViewById(R.id.audio_button)");
            FunctionButtonLayout functionButtonLayout = (FunctionButtonLayout) findViewById;
            functionButtonLayout.setOnClickListener(this);
            functionButtonLayout.a((ImageView) view.findViewById(R.id.audio_bg_circle), (ImageView) view.findViewById(R.id.audio_image), (ImageView) view.findViewById(R.id.audio_selected_image));
            View findViewById2 = view.findViewById(R.id.dialpad_button);
            kotlin.jvm.internal.i.e(findViewById2, "view.findViewById(R.id.dialpad_button)");
            FunctionButtonLayout functionButtonLayout2 = (FunctionButtonLayout) findViewById2;
            this.f18619g = functionButtonLayout2;
            FunctionButtonLayout functionButtonLayout3 = null;
            if (functionButtonLayout2 == null) {
                kotlin.jvm.internal.i.q("mDialpadButton");
                functionButtonLayout2 = null;
            }
            functionButtonLayout2.setOnClickListener(this);
            FunctionButtonLayout functionButtonLayout4 = this.f18619g;
            if (functionButtonLayout4 == null) {
                kotlin.jvm.internal.i.q("mDialpadButton");
                functionButtonLayout4 = null;
            }
            functionButtonLayout4.setContentDescription(getString(R.string.oplus_show_dialpad_text));
            FunctionButtonLayout functionButtonLayout5 = this.f18619g;
            if (functionButtonLayout5 == null) {
                kotlin.jvm.internal.i.q("mDialpadButton");
            } else {
                functionButtonLayout3 = functionButtonLayout5;
            }
            functionButtonLayout3.a((ImageView) view.findViewById(R.id.dialpad_bg_circle), (ImageView) view.findViewById(R.id.dialpad_image), (ImageView) view.findViewById(R.id.dialpad_selected_image));
            ((ImageView) view.findViewById(R.id.end_button)).setContentDescription(getString(R.string.notification_action_end_call));
        }
    }

    private final boolean isDialpadVisible() {
        InterfaceC0519a a10 = A.a();
        if (a10 == null || !a10.isDialpadVisible()) {
            return false;
        }
        return true;
    }

    public final c2.c<C0966a> A1() {
        return (c2.c) this.f18624l.getValue();
    }

    public final OplusInCallViewModel B1() {
        return (OplusInCallViewModel) this.f18614b.getValue();
    }

    public final ActionButtonViewModel C1() {
        return (ActionButtonViewModel) this.f18613a.getValue();
    }

    public final void D1() {
        COUIPopupListWindow cOUIPopupListWindow;
        COUIPopupListWindow cOUIPopupListWindow2 = this.f18622j;
        if (cOUIPopupListWindow2 != null && cOUIPopupListWindow2.isShowing() && (cOUIPopupListWindow = this.f18622j) != null) {
            cOUIPopupListWindow.dismiss();
        }
    }

    public final void E1() {
        androidx.appcompat.app.b bVar = this.f18623k;
        if (bVar != null && bVar.isShowing()) {
            androidx.appcompat.app.b bVar2 = this.f18623k;
            if (bVar2 != null) {
                bVar2.dismiss();
            }
            this.f18623k = null;
        }
    }

    public final void F1() {
        this.f18621i.clear();
        List<PopupListItem> list = this.f18621i;
        for (C0966a c0966a : C1().k().getValue()) {
            PopupListItem.Builder builder = new PopupListItem.Builder();
            PopupListItem.Builder reset = builder.reset();
            String f10 = c0966a.f();
            if (f10 == null) {
                f10 = getString(c0966a.g());
                kotlin.jvm.internal.i.e(f10, "getString(audioModeInfo.nameStringResId)");
            }
            reset.setTitle(f10).setIconId(c0966a.e()).setIsChecked(c0966a.c()).setIsEnable(c0966a.d());
            if (c0966a.c()) {
                builder.setStateIconId(R.drawable.coui_menu_ic_checkbox);
            }
            PopupListItem build = builder.build();
            kotlin.jvm.internal.i.e(build, "builder.build()");
            list.add(build);
        }
    }

    public final void G1(final View view) {
        F1();
        COUIPopupListWindow cOUIPopupListWindow = this.f18622j;
        if (cOUIPopupListWindow == null || !cOUIPopupListWindow.isShowing()) {
            final COUIPopupListWindow cOUIPopupListWindow2 = this.f18622j;
            if (cOUIPopupListWindow2 == null) {
                cOUIPopupListWindow2 = new COUIPopupListWindow(getContext());
                cOUIPopupListWindow2.setDismissTouchOutside(true);
                cOUIPopupListWindow2.setDismissWhenWindowSizeChange(false);
                cOUIPopupListWindow2.setItemList(this.f18621i);
                cOUIPopupListWindow2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.android.incallui.mvvm.view.h
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                        OplusActionButtonFragment.H1(OplusActionButtonFragment.this, cOUIPopupListWindow2, adapterView, view2, i10, j10);
                    }
                });
                cOUIPopupListWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.android.incallui.mvvm.view.i
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        OplusActionButtonFragment.I1(OplusActionButtonFragment.this);
                    }
                });
                y<Integer> l10 = C1().l();
                InterfaceC0492o viewLifecycleOwner = getViewLifecycleOwner();
                final v9.l<Integer, q> lVar = new v9.l<Integer, q>() { // from class: com.android.incallui.mvvm.view.OplusActionButtonFragment$showAudioSelectWindow$1$3
                    {
                        super(1);
                    }

                    public final void b(Integer num) {
                        COUIPopupListWindow cOUIPopupListWindow3;
                        cOUIPopupListWindow3 = OplusActionButtonFragment.this.f18622j;
                        if (cOUIPopupListWindow3 != null) {
                            cOUIPopupListWindow3.dismiss();
                        }
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ q invoke(Integer num) {
                        b(num);
                        return q.f35511a;
                    }
                };
                l10.i(viewLifecycleOwner, new w() { // from class: com.android.incallui.mvvm.view.j
                    @Override // androidx.lifecycle.w
                    public final void onChanged(Object obj) {
                        OplusActionButtonFragment.J1(v9.l.this, obj);
                    }
                });
                y<List<C0966a>> k10 = C1().k();
                InterfaceC0492o viewLifecycleOwner2 = getViewLifecycleOwner();
                final v9.l<List<C0966a>, q> lVar2 = new v9.l<List<C0966a>, q>() { // from class: com.android.incallui.mvvm.view.OplusActionButtonFragment$showAudioSelectWindow$1$4
                    {
                        super(1);
                    }

                    public final void b(List<C0966a> list) {
                        c2.c A12;
                        A12 = OplusActionButtonFragment.this.A1();
                        A12.notifyDataSetChanged();
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ q invoke(List<C0966a> list) {
                        b(list);
                        return q.f35511a;
                    }
                };
                k10.i(viewLifecycleOwner2, new w() { // from class: com.android.incallui.mvvm.view.k
                    @Override // androidx.lifecycle.w
                    public final void onChanged(Object obj) {
                        OplusActionButtonFragment.K1(v9.l.this, obj);
                    }
                });
            }
            view.post(new Runnable() { // from class: com.android.incallui.mvvm.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    OplusActionButtonFragment.L1(COUIPopupListWindow.this, view);
                }
            });
            this.f18622j = cOUIPopupListWindow2;
        }
    }

    public final void M1() {
        androidx.appcompat.app.b bVar = this.f18623k;
        if (bVar != null && bVar.isShowing()) {
            return;
        }
        androidx.appcompat.app.b bVar2 = this.f18623k;
        if (bVar2 == null) {
            Context context = getContext();
            if (context != null) {
                bVar2 = new COUIAlertDialogBuilder(context).setMessage(R.string.change_audio_mode_pc_when_recording).setTitle(R.string.start_record_when_audio_mode_pc_dialog_title).setPositiveButton(R.string.change_pc_when_recording_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.android.incallui.mvvm.view.e
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        OplusActionButtonFragment.N1(dialogInterface, i10);
                    }
                }).setNegativeButton(R.string.start_record_when_audio_mode_pc_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.android.incallui.mvvm.view.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        OplusActionButtonFragment.O1(dialogInterface, i10);
                    }
                }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.incallui.mvvm.view.g
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        OplusActionButtonFragment.P1(OplusActionButtonFragment.this, dialogInterface);
                    }
                }).create();
            } else {
                bVar2 = null;
            }
        }
        this.f18623k = bVar2;
        if (bVar2 != null) {
            bVar2.show();
        }
    }

    public final void Q1() {
        View view;
        Log.d("OplusActionButtonMOFragment", "startHideDialpadAnimation");
        InterfaceC0519a a10 = A.a();
        SuitableSizeEditText suitableSizeEditText = null;
        if (a10 != null) {
            view = a10.j(5);
        } else {
            view = null;
        }
        if (view != null) {
            suitableSizeEditText = (SuitableSizeEditText) view.findViewById(R.id.et_dtmf_dialer_field);
        }
        com.android.incallui.anim.b.c().b(view, false, this.f18617e, new b(suitableSizeEditText, view));
    }

    public final void R1() {
        View view;
        OplusCallButtonFragment c10;
        Log.d("OplusActionButtonMOFragment", "startShowDialpadAnimation");
        InterfaceC0519a a10 = A.a();
        SuitableSizeEditText suitableSizeEditText = null;
        if (a10 != null) {
            view = a10.j(5);
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(0);
        }
        if (view != null) {
            suitableSizeEditText = (SuitableSizeEditText) view.findViewById(R.id.et_dtmf_dialer_field);
        }
        if (suitableSizeEditText != null) {
            suitableSizeEditText.setVisibility(8);
        }
        com.android.incallui.anim.b.c().l(view, new c(view, suitableSizeEditText), ObjectAnimator.ofFloat(view, "alpha", 1.0f));
        InterfaceC0519a a11 = A.a();
        if (a11 != null && (c10 = a11.c()) != null) {
            c10.maybeSetCallsButtonMask();
        }
    }

    public final void S1(View view) {
        OplusCallButtonFragment c10;
        OplusCallButtonFragment c11;
        OplusDialpadFragment l10;
        GlobalCommandModel.f18535a.a();
        view.setSelected(!view.isSelected());
        if (view.isSelected()) {
            view.setContentDescription(getString(R.string.oplus_hide_dialpad_text));
        } else {
            view.setContentDescription(getString(R.string.oplus_show_dialpad_text));
        }
        FragmentStateUseCase.f18563a.e(256);
        this.f18618f = !this.f18618f;
        Log.d("OplusActionButtonMOFragment", "toggleDialpad, mIsDialpadVisible = " + this.f18618f);
        if (!this.f18618f) {
            InterfaceC0519a a10 = A.a();
            if (a10 != null && (l10 = a10.l()) != null) {
                l10.e1();
            }
            Q1();
            InterfaceC0519a a11 = A.a();
            if (a11 != null && (c11 = a11.c()) != null) {
                c11.startShowRecyclerButtonAnimation();
                return;
            }
            return;
        }
        R1();
        InterfaceC0519a a12 = A.a();
        if (a12 != null && (c10 = a12.c()) != null) {
            c10.startHideRecyclerButtonAnimation();
        }
    }

    public final void T1() {
        com.android.incallui.mvvm.utils.h<Boolean> k10 = B1().k();
        InterfaceC0492o viewLifecycleOwner = getViewLifecycleOwner();
        final v9.l<Boolean, q> lVar = new v9.l<Boolean, q>() { // from class: com.android.incallui.mvvm.view.OplusActionButtonFragment$watchValueChange$1
            {
                super(1);
            }

            public final void b(Boolean it) {
                COUIPopupListWindow cOUIPopupListWindow;
                Boolean bool;
                AbstractC0401g abstractC0401g;
                StringBuilder sb = new StringBuilder();
                sb.append("should/hide dialog : ");
                cOUIPopupListWindow = OplusActionButtonFragment.this.f18622j;
                AbstractC0401g abstractC0401g2 = null;
                if (cOUIPopupListWindow != null) {
                    bool = Boolean.valueOf(cOUIPopupListWindow.isShowing());
                } else {
                    bool = null;
                }
                sb.append(bool);
                sb.append(" >>> ");
                sb.append(it);
                Log.d("OplusActionButtonMOFragment", sb.toString());
                kotlin.jvm.internal.i.e(it, "it");
                boolean booleanValue = it.booleanValue();
                OplusActionButtonFragment oplusActionButtonFragment = OplusActionButtonFragment.this;
                if (booleanValue) {
                    abstractC0401g = oplusActionButtonFragment.f18620h;
                    if (abstractC0401g == null) {
                        kotlin.jvm.internal.i.q("binding");
                    } else {
                        abstractC0401g2 = abstractC0401g;
                    }
                    FunctionButtonLayout functionButtonLayout = abstractC0401g2.f2555H;
                    kotlin.jvm.internal.i.e(functionButtonLayout, "binding.audioButton");
                    oplusActionButtonFragment.G1(functionButtonLayout);
                }
                OplusActionButtonFragment oplusActionButtonFragment2 = OplusActionButtonFragment.this;
                if (!booleanValue) {
                    oplusActionButtonFragment2.D1();
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                b(bool);
                return q.f35511a;
            }
        };
        k10.i(viewLifecycleOwner, new w() { // from class: com.android.incallui.mvvm.view.a
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                OplusActionButtonFragment.U1(v9.l.this, obj);
            }
        });
        com.android.incallui.mvvm.utils.h<Boolean> t10 = B1().t();
        InterfaceC0492o viewLifecycleOwner2 = getViewLifecycleOwner();
        final v9.l<Boolean, q> lVar2 = new v9.l<Boolean, q>() { // from class: com.android.incallui.mvvm.view.OplusActionButtonFragment$watchValueChange$2
            {
                super(1);
            }

            public final void b(Boolean it) {
                COUIPopupListWindow cOUIPopupListWindow;
                Boolean bool;
                StringBuilder sb = new StringBuilder();
                sb.append("should/hide pc record dialog : ");
                cOUIPopupListWindow = OplusActionButtonFragment.this.f18622j;
                if (cOUIPopupListWindow != null) {
                    bool = Boolean.valueOf(cOUIPopupListWindow.isShowing());
                } else {
                    bool = null;
                }
                sb.append(bool);
                sb.append(" >>> ");
                sb.append(it);
                Log.d("OplusActionButtonMOFragment", sb.toString());
                kotlin.jvm.internal.i.e(it, "it");
                boolean booleanValue = it.booleanValue();
                OplusActionButtonFragment oplusActionButtonFragment = OplusActionButtonFragment.this;
                if (booleanValue) {
                    oplusActionButtonFragment.M1();
                }
                OplusActionButtonFragment oplusActionButtonFragment2 = OplusActionButtonFragment.this;
                if (!booleanValue) {
                    oplusActionButtonFragment2.E1();
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                b(bool);
                return q.f35511a;
            }
        };
        t10.i(viewLifecycleOwner2, new w() { // from class: com.android.incallui.mvvm.view.c
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                OplusActionButtonFragment.V1(v9.l.this, obj);
            }
        });
        y<Boolean> c10 = FragmentStateUseCase.f18563a.c();
        InterfaceC0492o viewLifecycleOwner3 = getViewLifecycleOwner();
        final v9.l<Boolean, q> lVar3 = new v9.l<Boolean, q>() { // from class: com.android.incallui.mvvm.view.OplusActionButtonFragment$watchValueChange$3
            {
                super(1);
            }

            public final void b(Boolean it) {
                kotlin.jvm.internal.i.e(it, "it");
                boolean booleanValue = it.booleanValue();
                OplusActionButtonFragment oplusActionButtonFragment = OplusActionButtonFragment.this;
                if (!booleanValue) {
                    oplusActionButtonFragment.D1();
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                b(bool);
                return q.f35511a;
            }
        };
        c10.i(viewLifecycleOwner3, new w() { // from class: com.android.incallui.mvvm.view.d
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                OplusActionButtonFragment.W1(v9.l.this, obj);
            }
        });
        y<Boolean> m10 = B1().m();
        InterfaceC0492o viewLifecycleOwner4 = getViewLifecycleOwner();
        kotlin.jvm.internal.i.e(viewLifecycleOwner4, "viewLifecycleOwner");
        IgnoreEqualsLiveDataKt.q(m10, viewLifecycleOwner4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer num;
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        int i10 = R.id.dialpad_button;
        if (num != null && num.intValue() == i10) {
            S1(view);
        } else {
            Log.d("OplusActionButtonMOFragment", "wrong view");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_action_button, viewGroup, false);
        AbstractC0401g i12 = AbstractC0401g.i1(inflate);
        i12.n1(C1());
        i12.m1(B1());
        i12.k1(z1());
        i12.l1(GlobalCommandModel.f18535a);
        i12.b1(getViewLifecycleOwner());
        kotlin.jvm.internal.i.e(i12, "bind(it).apply {\n       …leOwner\n                }");
        this.f18620h = i12;
        initView(inflate);
        T1();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f18618f = isDialpadVisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        D1();
    }

    public final ActionButtonCommandModel z1() {
        return (ActionButtonCommandModel) this.f18615c.getValue();
    }

    public static final void O1(DialogInterface dialogInterface, int i10) {
    }
}
