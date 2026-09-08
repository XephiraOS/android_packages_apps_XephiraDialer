package com.android.contacts.scenecard;

import a4.C0421a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import com.android.contacts.Q0;
import com.android.contacts.dialpad.g;
import com.android.contacts.dialpad.view.DialpadImageButton;
import com.android.contacts.dialpad.view.DialpadView;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.customize.contacts.util.C0802m;
import com.customize.contacts.util.SettingUtils;
import com.customize.contacts.util.b0;
import com.customize.contacts.viewmodel.DialPadFragmentViewModel;
import com.customize.contacts.widget.FeedbackLinearLayout;
import com.customize.contacts.widget.ScrollRelativeLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.lifecycle.FlowExtKt;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.util.Iterator;
import kotlin.Pair;
import kotlinx.coroutines.C1248i;

/* compiled from: SceneDialPadViewController.kt */
/* loaded from: classes.dex */
public final class SceneDialPadViewController implements InterfaceC0480c {

    /* renamed from: F, reason: collision with root package name */
    public static final a f17148F = new a(null);

    /* renamed from: G, reason: collision with root package name */
    public static final int[] f17149G = {-1, -1, -1, -1, -1, -1, -1, -1, -1, R.drawable.scene_dial_key_star, -1, R.drawable.scene_dial_key_pound};

    /* renamed from: H, reason: collision with root package name */
    public static final int[] f17150H = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: I, reason: collision with root package name */
    public static final int[] f17151I = {R.drawable.scene_ic_dial_key_heng, R.drawable.scene_ic_dial_key_shu, R.drawable.scene_ic_dial_key_pie, R.drawable.scene_ic_dial_key_na, R.drawable.scene_ic_dial_key_henggou, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: A, reason: collision with root package name */
    public final View.OnClickListener f17152A;

    /* renamed from: B, reason: collision with root package name */
    public final View.OnLongClickListener f17153B;

    /* renamed from: C, reason: collision with root package name */
    public final View.OnTouchListener f17154C;

    /* renamed from: D, reason: collision with root package name */
    public final View.OnClickListener f17155D;

    /* renamed from: E, reason: collision with root package name */
    public final f f17156E;

    /* renamed from: a, reason: collision with root package name */
    public final Context f17157a;

    /* renamed from: b, reason: collision with root package name */
    public final SceneSimCardStateManager f17158b;

    /* renamed from: c, reason: collision with root package name */
    public final kotlinx.coroutines.E f17159c;

    /* renamed from: d, reason: collision with root package name */
    public final SceneDialTextEditor f17160d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f17161e;

    /* renamed from: f, reason: collision with root package name */
    public final kotlinx.coroutines.flow.i<Integer> f17162f;

    /* renamed from: g, reason: collision with root package name */
    public final kotlinx.coroutines.flow.m<Integer> f17163g;

    /* renamed from: h, reason: collision with root package name */
    public x0.v f17164h;

    /* renamed from: i, reason: collision with root package name */
    public int f17165i;

    /* renamed from: j, reason: collision with root package name */
    public Z3.f f17166j;

    /* renamed from: k, reason: collision with root package name */
    public COUIFloatingButton f17167k;

    /* renamed from: l, reason: collision with root package name */
    public com.android.contacts.dialpad.c f17168l;

    /* renamed from: m, reason: collision with root package name */
    public com.android.contacts.dialpad.j f17169m;

    /* renamed from: n, reason: collision with root package name */
    public com.android.contacts.dialpad.g f17170n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f17171o;

    /* renamed from: p, reason: collision with root package name */
    public androidx.databinding.o f17172p;

    /* renamed from: q, reason: collision with root package name */
    public androidx.databinding.o f17173q;

    /* renamed from: r, reason: collision with root package name */
    public Bundle f17174r;

    /* renamed from: x, reason: collision with root package name */
    public int f17175x;

    /* renamed from: y, reason: collision with root package name */
    public b f17176y;

    /* renamed from: z, reason: collision with root package name */
    public final DialpadImageButton.b f17177z;

    /* compiled from: SceneDialPadViewController.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public SceneDialPadViewController(Context context, SceneSimCardStateManager simCardStateManager, kotlinx.coroutines.E coroutineScope) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(simCardStateManager, "simCardStateManager");
        kotlin.jvm.internal.i.f(coroutineScope, "coroutineScope");
        this.f17157a = context;
        this.f17158b = simCardStateManager;
        this.f17159c = coroutineScope;
        SceneDialTextEditor sceneDialTextEditor = new SceneDialTextEditor(context, coroutineScope);
        this.f17160d = sceneDialTextEditor;
        this.f17165i = -1;
        this.f17175x = -1;
        this.f17176y = new b();
        this.f17177z = new DialpadImageButton.b() { // from class: com.android.contacts.scenecard.g
            @Override // com.android.contacts.dialpad.view.DialpadImageButton.b
            public final void g0(View view, boolean z10) {
                SceneDialPadViewController.q(SceneDialPadViewController.this, view, z10);
            }
        };
        this.f17152A = new View.OnClickListener() { // from class: com.android.contacts.scenecard.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SceneDialPadViewController.p(SceneDialPadViewController.this, view);
            }
        };
        this.f17153B = new View.OnLongClickListener() { // from class: com.android.contacts.scenecard.i
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean s10;
                s10 = SceneDialPadViewController.s(SceneDialPadViewController.this, view);
                return s10;
            }
        };
        this.f17154C = new View.OnTouchListener() { // from class: com.android.contacts.scenecard.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean r10;
                r10 = SceneDialPadViewController.r(SceneDialPadViewController.this, view, motionEvent);
                return r10;
            }
        };
        this.f17155D = new View.OnClickListener() { // from class: com.android.contacts.scenecard.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SceneDialPadViewController.h0(SceneDialPadViewController.this, view);
            }
        };
        this.f17156E = new f();
        H7.b.e("SceneDialPadViewController", "init");
        kotlinx.coroutines.flow.i<Integer> a10 = kotlinx.coroutines.flow.n.a(Integer.valueOf(DialPadFragmentViewModel.f22207e.a(context)));
        this.f17162f = a10;
        this.f17163g = a10;
        this.f17166j = new Z3.f(context, R.dimen.scene_dialpad_height);
        sceneDialTextEditor.E(this);
    }

    public static /* synthetic */ void E(SceneDialPadViewController sceneDialPadViewController, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        sceneDialPadViewController.D(z10);
    }

    public static final void I(SceneDialPadViewController this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.G();
        this$0.F();
        d0(this$0, false, 1, null);
    }

    public static final void L(SceneDialPadViewController this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f17160d.m();
        this$0.D(false);
    }

    public static /* synthetic */ void O(SceneDialPadViewController sceneDialPadViewController, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = -1;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        sceneDialPadViewController.N(str, i10, z10);
    }

    public static /* synthetic */ void Q(SceneDialPadViewController sceneDialPadViewController, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = -1;
        }
        sceneDialPadViewController.P(str, i10);
    }

    public static /* synthetic */ void U(SceneDialPadViewController sceneDialPadViewController, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        sceneDialPadViewController.T(z10);
    }

    public static /* synthetic */ void d0(SceneDialPadViewController sceneDialPadViewController, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        sceneDialPadViewController.c0(z10);
    }

    public static final void g0(x0.H switchSimLayoutBinding, ValueAnimator animation) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        kotlin.jvm.internal.i.f(switchSimLayoutBinding, "$switchSimLayoutBinding");
        kotlin.jvm.internal.i.f(animation, "animation");
        ViewGroup.LayoutParams layoutParams = switchSimLayoutBinding.f37678K.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            Object animatedValue = animation.getAnimatedValue();
            kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            marginLayoutParams.setMarginStart(((Integer) animatedValue).intValue());
            switchSimLayoutBinding.f37678K.setLayoutParams(marginLayoutParams);
        }
    }

    public static final void h0(SceneDialPadViewController this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.f17164h != null) {
            switch (view.getId()) {
                case R.id.sim1_dial_btn /* 2131428961 */:
                    this$0.P(this$0.f17160d.u(), 0);
                    return;
                case R.id.sim2_dial_btn /* 2131428965 */:
                    this$0.P(this$0.f17160d.u(), 1);
                    return;
                case R.id.single_sim_dial_btn /* 2131428987 */:
                    Q(this$0, this$0.f17160d.u(), 0, 2, null);
                    return;
                case R.id.switch_button_parent /* 2131429114 */:
                    if (this$0.f17165i == 0) {
                        k0(this$0, 1, false, 2, null);
                        return;
                    } else {
                        k0(this$0, 0, false, 2, null);
                        return;
                    }
                case R.id.switch_sim_dial_parent /* 2131429116 */:
                    this$0.P(this$0.f17160d.u(), this$0.f17165i);
                    return;
                default:
                    H7.b.i("SceneDialPadViewController", "simDialButtonClickListener unknown view id");
                    return;
            }
        }
    }

    public static /* synthetic */ void k0(SceneDialPadViewController sceneDialPadViewController, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        sceneDialPadViewController.j0(i10, z10);
    }

    public static final void p(SceneDialPadViewController this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        switch (view.getId()) {
            case R.id.eight /* 2131427973 */:
                this$0.f17160d.A(15);
                return;
            case R.id.five /* 2131428045 */:
                this$0.f17160d.A(12);
                return;
            case R.id.four /* 2131428089 */:
                this$0.f17160d.A(11);
                return;
            case R.id.nine /* 2131428504 */:
                this$0.f17160d.A(16);
                return;
            case R.id.one /* 2131428557 */:
                this$0.f17160d.A(8);
                return;
            case R.id.pound /* 2131428723 */:
                this$0.f17160d.A(18);
                return;
            case R.id.seven /* 2131428942 */:
                this$0.f17160d.A(14);
                return;
            case R.id.six /* 2131428992 */:
                this$0.f17160d.A(13);
                return;
            case R.id.star /* 2131429050 */:
                this$0.f17160d.A(17);
                return;
            case R.id.three /* 2131429203 */:
                this$0.f17160d.A(10);
                return;
            case R.id.two /* 2131429281 */:
                this$0.f17160d.A(9);
                return;
            case R.id.zero /* 2131429413 */:
                this$0.f17160d.A(7);
                return;
            default:
                return;
        }
    }

    public static final void q(SceneDialPadViewController this$0, View view, boolean z10) {
        int i10;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (z10) {
            switch (view.getId()) {
                case R.id.eight /* 2131427973 */:
                    i10 = 8;
                    break;
                case R.id.five /* 2131428045 */:
                    i10 = 5;
                    break;
                case R.id.four /* 2131428089 */:
                    i10 = 4;
                    break;
                case R.id.nine /* 2131428504 */:
                    i10 = 9;
                    break;
                case R.id.one /* 2131428557 */:
                    i10 = 1;
                    break;
                case R.id.pound /* 2131428723 */:
                    i10 = 11;
                    break;
                case R.id.seven /* 2131428942 */:
                    i10 = 7;
                    break;
                case R.id.six /* 2131428992 */:
                    i10 = 6;
                    break;
                case R.id.star /* 2131429050 */:
                    i10 = 10;
                    break;
                case R.id.three /* 2131429203 */:
                    i10 = 3;
                    break;
                case R.id.two /* 2131429281 */:
                    i10 = 2;
                    break;
                case R.id.zero /* 2131429413 */:
                    i10 = 0;
                    break;
                default:
                    i10 = -1;
                    break;
            }
            if (i10 == -1) {
                H7.b.i("SceneDialPadViewController", "The tone is unknown");
            } else {
                this$0.R(i10);
            }
        }
    }

    public static final boolean r(SceneDialPadViewController this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (motionEvent.getActionMasked() == 1) {
            int i10 = this$0.f17175x;
            if (2 <= i10 && i10 < 10) {
                this$0.f17152A.onClick(view);
            }
            this$0.f17175x = -1;
            return false;
        }
        return false;
    }

    public static final boolean s(SceneDialPadViewController this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        switch (view.getId()) {
            case R.id.eight /* 2131427973 */:
                return this$0.C(8);
            case R.id.five /* 2131428045 */:
                return this$0.C(5);
            case R.id.four /* 2131428089 */:
                return this$0.C(4);
            case R.id.nine /* 2131428504 */:
                return this$0.C(9);
            case R.id.pound /* 2131428723 */:
                return this$0.f17160d.l(Constants.DataMigration.SPLIT_TAG);
            case R.id.seven /* 2131428942 */:
                return this$0.C(7);
            case R.id.six /* 2131428992 */:
                return this$0.C(6);
            case R.id.star /* 2131429050 */:
                return this$0.f17160d.l(",");
            case R.id.three /* 2131429203 */:
                return this$0.C(3);
            case R.id.two /* 2131429281 */:
                return this$0.C(2);
            case R.id.zero /* 2131429413 */:
                this$0.f17160d.A(81);
                this$0.i0();
                return true;
            default:
                return false;
        }
    }

    public final x0.F A(x0.v vVar) {
        if (!vVar.f37795L.j()) {
            H7.b.e("SceneDialPadViewController", "getSingleSimLayoutViewBinding");
            ViewStub i10 = vVar.f37795L.i();
            if (i10 != null) {
                i10.inflate();
            }
            ViewDataBinding g10 = vVar.f37795L.g();
            kotlin.jvm.internal.i.d(g10, "null cannot be cast to non-null type com.android.contacts.databinding.SceneSingleSimLayoutBinding");
            x0.F f10 = (x0.F) g10;
            f10.f37670H.setDrawableColor(this.f17157a.getColor(R.color.scene_color_dialpad_call_button_bg));
            f10.f37670H.setOnClickListener(this.f17155D);
            f10.f37670H.setContentDescription(this.f17157a.getString(R.string.call));
            return f10;
        }
        ViewDataBinding g11 = vVar.f37795L.g();
        kotlin.jvm.internal.i.d(g11, "null cannot be cast to non-null type com.android.contacts.databinding.SceneSingleSimLayoutBinding");
        return (x0.F) g11;
    }

    public final x0.H B(x0.v vVar) {
        if (!vVar.f37796M.j()) {
            ViewStub i10 = vVar.f37796M.i();
            if (i10 != null) {
                i10.inflate();
            }
            ViewDataBinding g10 = vVar.f37796M.g();
            kotlin.jvm.internal.i.d(g10, "null cannot be cast to non-null type com.android.contacts.databinding.SceneSwitchSimLayoutBinding");
            x0.H h10 = (x0.H) g10;
            h10.f37677J.setOnClickListener(this.f17155D);
            h10.f37678K.setOnClickListener(this.f17155D);
            h10.f37678K.setDrawableColor(this.f17157a.getColor(R.color.scene_color_dialpad_call_button_bg));
            return h10;
        }
        ViewDataBinding g11 = vVar.f37796M.g();
        kotlin.jvm.internal.i.d(g11, "null cannot be cast to non-null type com.android.contacts.databinding.SceneSwitchSimLayoutBinding");
        return (x0.H) g11;
    }

    public final boolean C(int i10) {
        com.android.contacts.dialpad.g gVar = this.f17170n;
        if (gVar != null) {
            return gVar.m(i10, this.f17160d.u());
        }
        return false;
    }

    public final void D(boolean z10) {
        ScrollRelativeLayout scrollRelativeLayout;
        H7.b.e("SceneDialPadViewController", "hideDialPad");
        Z3.f fVar = this.f17166j;
        if (fVar != null && fVar.n()) {
            H7.b.i("SceneDialPadViewController", "isDialPadAnimationRunning");
            return;
        }
        if (this.f17161e) {
            x0.v vVar = this.f17164h;
            if (vVar != null) {
                scrollRelativeLayout = vVar.f37791H;
            } else {
                scrollRelativeLayout = null;
            }
            ScrollRelativeLayout scrollRelativeLayout2 = scrollRelativeLayout;
            COUIFloatingButton cOUIFloatingButton = this.f17167k;
            if (scrollRelativeLayout2 != null && cOUIFloatingButton != null) {
                Z3.f fVar2 = this.f17166j;
                if (fVar2 != null) {
                    fVar2.l(scrollRelativeLayout2, null, cOUIFloatingButton, !z10, true);
                }
                this.f17161e = false;
                return;
            }
            return;
        }
        H7.b.e("SceneDialPadViewController", "DialPadHidden");
    }

    public final void F() {
        androidx.databinding.o oVar = this.f17173q;
        if (oVar != null) {
            this.f17160d.x(oVar);
        }
    }

    public final void G() {
        ViewDataBinding viewDataBinding;
        ViewStub i10;
        androidx.databinding.o oVar = this.f17172p;
        if (oVar != null && !oVar.j()) {
            H7.b.e("SceneDialPadViewController", "initDialPadContainer");
            androidx.databinding.o oVar2 = this.f17172p;
            if (oVar2 != null && (i10 = oVar2.i()) != null) {
                i10.inflate();
            }
            androidx.databinding.o oVar3 = this.f17172p;
            if (oVar3 != null) {
                viewDataBinding = oVar3.g();
            } else {
                viewDataBinding = null;
            }
            kotlin.jvm.internal.i.d(viewDataBinding, "null cannot be cast to non-null type com.android.contacts.databinding.SceneDialpadBinding");
            x0.v vVar = (x0.v) viewDataBinding;
            this.f17164h = vVar;
            int a10 = DialPadFragmentViewModel.f22207e.a(this.f17157a);
            int t10 = t(a10);
            int dimensionPixelSize = this.f17157a.getResources().getDimensionPixelSize(R.dimen.scene_dialpad_buttons_paddingTop);
            int dimensionPixelSize2 = this.f17157a.getResources().getDimensionPixelSize(R.dimen.scene_dialpad_button_horizontal_padding);
            C1248i.d(this.f17159c, null, null, new SceneDialPadViewController$initDialPadContainer$1(this, a10, null), 3, null);
            DialpadView dialpadView = vVar.f37790G;
            dialpadView.setIsScene(true);
            dialpadView.setDialpadButtonHeight(t10);
            dialpadView.setDialpadPaddingTop(dimensionPixelSize);
            dialpadView.setDialpadPadding(dimensionPixelSize2);
            dialpadView.setButtonDrawableIds(f17149G);
            dialpadView.setButtonLetterIconDrawableIds(f17150H);
            dialpadView.setButtonStrokeLetterIconDrawableIds(f17151I);
            dialpadView.setDialPadLetterColor(R.color.scene_color_dialpad_letter);
            dialpadView.setNumberTextColor(R.color.scene_color_primary_neutral);
            dialpadView.setSilkType(a10);
            vVar.f37790G.c();
            vVar.f37790G.f(this.f17177z, this.f17153B, this.f17152A);
            vVar.f37790G.setTouchListener(this.f17154C);
            vVar.f37791H.setListener(this.f17176y);
            X x10 = X.f17252a;
            FrameLayout frameLayout = vVar.f37794K;
            kotlin.jvm.internal.i.e(frameLayout, "binding.simLayoutParent");
            x10.a(frameLayout);
            V(this.f17158b.h().getValue());
            this.f17168l = new com.android.contacts.dialpad.c(this.f17157a);
            this.f17169m = new com.android.contacts.dialpad.j(this.f17157a);
            com.android.contacts.dialpad.c cVar = this.f17168l;
            if (cVar != null) {
                cVar.j();
            }
            T(false);
            if (SettingUtils.l() && PrimaryUserUtils.a()) {
                com.android.contacts.dialpad.g gVar = new com.android.contacts.dialpad.g(this.f17157a, false);
                gVar.p();
                gVar.o(this.f17156E);
                this.f17170n = gVar;
            }
        }
    }

    public final void H(Context context, COUIFloatingButton floatingButton, androidx.databinding.o dialPadStubProxy, androidx.databinding.o dialEditTextContainerStubProxy) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(floatingButton, "floatingButton");
        kotlin.jvm.internal.i.f(dialPadStubProxy, "dialPadStubProxy");
        kotlin.jvm.internal.i.f(dialEditTextContainerStubProxy, "dialEditTextContainerStubProxy");
        H7.b.e("SceneDialPadViewController", "initView");
        this.f17167k = floatingButton;
        this.f17172p = dialPadStubProxy;
        this.f17173q = dialEditTextContainerStubProxy;
        floatingButton.getMainFloatingButton().setContentDescription(context.getResources().getString(R.string.show_dialpad_description));
        floatingButton.getMainFloatingButton().setBackgroundColor(context.getColor(R.color.scene_color_dialpad_call_button_bg));
        floatingButton.getMainFloatingButton().setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.scenecard.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SceneDialPadViewController.I(SceneDialPadViewController.this, view);
            }
        });
    }

    public final boolean J() {
        return this.f17161e;
    }

    public final void K(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        H7.b.e("SceneDialPadViewController", "onSaveInstanceState");
        int i10 = this.f17165i;
        if (i10 != -1) {
            outState.putInt("selected_slot_id", i10);
        }
    }

    public final void M(Bundle savedInstanceState) {
        kotlin.jvm.internal.i.f(savedInstanceState, "savedInstanceState");
        H7.b.e("SceneDialPadViewController", "onViewStateRestored");
        this.f17174r = savedInstanceState;
    }

    public final void N(String str, int i10, boolean z10) {
        H7.b.e("SceneDialPadViewController", "slotId : " + i10 + ", number = " + H7.a.d(str));
        if (z10) {
            l0();
        }
        if (C7.a.a()) {
            H7.b.e("SceneDialPadViewController", "placeCall filter Click!");
            return;
        }
        Intent intent = new Intent(C0421a.f6395a, Uri.fromParts("tel", str, null));
        if (OsUtils.f28275a.j()) {
            PhoneAccountHandle s10 = b0.s(this.f17157a, i10);
            if (s10 != null) {
                intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", s10);
            }
        } else {
            intent.putExtra(OplusPhoneUtils.SUBSCRIPTION_KEY, i10);
        }
        intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        H7.b.e("SceneDialPadViewController", "ready to placeCall");
        this.f17171o = true;
        C0802m.a(this.f17157a, intent);
        S(str);
    }

    public final void P(String str, int i10) {
        if (!TextUtils.isEmpty(str) && TextUtils.isGraphic(str)) {
            O(this, str, i10, false, 4, null);
        } else {
            Y();
            R(26);
        }
    }

    public final void R(int i10) {
        com.android.contacts.dialpad.c cVar = this.f17168l;
        if (cVar != null) {
            cVar.m(i10, this.f17169m);
        }
    }

    public final void S(String str) {
        boolean q10;
        q10 = kotlin.text.n.q(str);
        if (!q10) {
            C1248i.d(this.f17159c, kotlinx.coroutines.S.b(), null, new SceneDialPadViewController$preQueryNumberInfo$1(str, null), 2, null);
        }
    }

    public final void T(boolean z10) {
        x0.v vVar;
        DialpadView dialpadView;
        if (z10 && (vVar = this.f17164h) != null && (dialpadView = vVar.f37790G) != null) {
            DialPadFragmentViewModel.a aVar = DialPadFragmentViewModel.f22207e;
            Context context = dialpadView.getContext();
            kotlin.jvm.internal.i.e(context, "context");
            int a10 = aVar.a(context);
            if (a10 != this.f17162f.getValue().intValue()) {
                C1248i.d(this.f17159c, null, null, new SceneDialPadViewController$refreshDialSwitchState$1$1(this, a10, null), 3, null);
                dialpadView.setDialpadButtonHeight(t(a10));
                dialpadView.a(DialpadView.b(a10));
            }
        }
        com.android.contacts.dialpad.c cVar = this.f17168l;
        if (cVar != null) {
            cVar.i();
        }
        com.android.contacts.dialpad.j jVar = this.f17169m;
        if (jVar != null) {
            jVar.a(this.f17157a);
        }
    }

    public final void V(Y y10) {
        H7.b.e("SceneDialPadViewController", "refreshSimDialButton " + y10);
        if (y10.c() < 2) {
            Z(y10.g());
            return;
        }
        int d10 = y10.d();
        if (d10 != -1) {
            this.f17165i = d10;
            b0(y10);
        } else {
            this.f17165i = -1;
            X(y10);
        }
    }

    public final void W() {
        Bundle bundle = this.f17174r;
        if (bundle != null) {
            int i10 = bundle.getInt("selected_slot_id", -1);
            H7.b.e("SceneDialPadViewController", "restoreViewStateIfNeed: slotId = " + i10);
            if (i10 != -1 && this.f17158b.j()) {
                k0(this, i10, false, 2, null);
                m0();
            }
            this.f17174r = null;
        }
        if (this.f17160d.z()) {
            D(false);
        } else {
            F();
            c0(false);
        }
    }

    public final void X(Y y10) {
        x0.v vVar = this.f17164h;
        if (vVar != null) {
            H7.b.e("SceneDialPadViewController", "setDualSimViewVisible");
            x0.x w10 = w(vVar);
            View K02 = w10.K0();
            kotlin.jvm.internal.i.e(K02, "dualSimLayoutBinding.root");
            K02.setVisibility(0);
            w10.f37802I.setContentDescription(this.f17157a.getString(R.string.oplus_use_sim_x_to_call, y10.f()));
            w10.f37805L.setContentDescription(this.f17157a.getString(R.string.oplus_use_sim_x_to_call, y10.i()));
            w10.f37803J.setText(y10.f());
            w10.f37806M.setText(y10.i());
            if (y10.g()) {
                w10.f37801H.setImageResource(R.drawable.scene_ic_dial_wifi_call_sim1);
            } else {
                w10.f37801H.setImageResource(R.drawable.scene_ic_dial_call_sim1);
            }
            if (y10.j()) {
                w10.f37804K.setImageResource(R.drawable.scene_ic_dial_wifi_call_sim2);
            } else {
                w10.f37804K.setImageResource(R.drawable.scene_ic_dial_call_sim2);
            }
            View root = vVar.f37795L.h();
            if (root != null) {
                kotlin.jvm.internal.i.e(root, "root");
                root.setVisibility(8);
            }
            View root2 = vVar.f37796M.h();
            if (root2 != null) {
                kotlin.jvm.internal.i.e(root2, "root");
                root2.setVisibility(8);
            }
        }
    }

    public final void Y() {
        C1248i.d(this.f17159c, kotlinx.coroutines.S.b(), null, new SceneDialPadViewController$setLastCallNumberToDialEditText$1(this, null), 2, null);
    }

    public final void Z(boolean z10) {
        x0.v vVar = this.f17164h;
        if (vVar != null) {
            H7.b.e("SceneDialPadViewController", "setSingleSimViewVisible");
            x0.F A10 = A(vVar);
            View K02 = A10.K0();
            kotlin.jvm.internal.i.e(K02, "singleSimViewBinding.root");
            K02.setVisibility(0);
            View root = vVar.f37793J.h();
            if (root != null) {
                kotlin.jvm.internal.i.e(root, "root");
                root.setVisibility(8);
            }
            View root2 = vVar.f37796M.h();
            if (root2 != null) {
                kotlin.jvm.internal.i.e(root2, "root");
                root2.setVisibility(8);
            }
            if (z10) {
                A10.f37669G.setImageResource(R.drawable.scene_ic_call_wifi);
            } else {
                A10.f37669G.setImageResource(R.drawable.scene_ic_dial_call);
            }
        }
    }

    public final void a0(boolean z10) {
        this.f17171o = z10;
    }

    public final void b0(Y y10) {
        x0.v vVar = this.f17164h;
        if (vVar != null) {
            H7.b.e("SceneDialPadViewController", "setSwitchSimViewVisible");
            View K02 = B(vVar).K0();
            kotlin.jvm.internal.i.e(K02, "switchSimLayoutBinding.root");
            K02.setVisibility(0);
            j0(y10.d(), false);
            m0();
            View root = vVar.f37793J.h();
            if (root != null) {
                kotlin.jvm.internal.i.e(root, "root");
                root.setVisibility(8);
            }
            View root2 = vVar.f37795L.h();
            if (root2 != null) {
                kotlin.jvm.internal.i.e(root2, "root");
                root2.setVisibility(8);
            }
        }
    }

    public final void c0(boolean z10) {
        ScrollRelativeLayout scrollRelativeLayout;
        H7.b.e("SceneDialPadViewController", "showDialPad");
        Z3.f fVar = this.f17166j;
        if (fVar != null && fVar.n()) {
            H7.b.i("SceneDialPadViewController", "isDialPadAnimationRunning");
            return;
        }
        if (this.f17161e) {
            H7.b.e("SceneDialPadViewController", "isDialPadShowed");
            return;
        }
        G();
        x0.v vVar = this.f17164h;
        if (vVar != null) {
            scrollRelativeLayout = vVar.f37791H;
        } else {
            scrollRelativeLayout = null;
        }
        ScrollRelativeLayout scrollRelativeLayout2 = scrollRelativeLayout;
        COUIFloatingButton cOUIFloatingButton = this.f17167k;
        if (scrollRelativeLayout2 != null && cOUIFloatingButton != null) {
            Z3.f fVar2 = this.f17166j;
            if (fVar2 != null) {
                fVar2.u(scrollRelativeLayout2, null, cOUIFloatingButton, !z10, true);
            }
            this.f17161e = true;
        }
    }

    public final void e0() {
        int i10;
        H7.b.e("SceneDialPadViewController", "showFloatingButtonIfNeed " + this.f17161e);
        COUIFloatingButton cOUIFloatingButton = this.f17167k;
        if (cOUIFloatingButton != null) {
            if (!this.f17161e) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            cOUIFloatingButton.setVisibility(i10);
        }
    }

    public final void f0(boolean z10, final x0.H h10) {
        boolean z11;
        ValueAnimator ofInt;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        FeedbackLinearLayout feedbackLinearLayout = h10.f37677J;
        kotlin.jvm.internal.i.e(feedbackLinearLayout, "switchSimLayoutBinding.switchButtonParent");
        if (feedbackLinearLayout.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 == z10) {
            H7.b.e("SceneDialPadViewController", "showSwitchButtonWithAnimator : already " + z10);
            return;
        }
        if (z10) {
            ofInt = ValueAnimator.ofInt(0, this.f17157a.getResources().getDimensionPixelSize(R.dimen.DP_44));
        } else {
            ofInt = ValueAnimator.ofInt(this.f17157a.getResources().getDimensionPixelSize(R.dimen.DP_44), 0);
        }
        ofInt.setInterpolator(new COUIMoveEaseInterpolator());
        ofInt.setDuration(250L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.contacts.scenecard.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SceneDialPadViewController.g0(x0.H.this, valueAnimator);
            }
        });
        if (z10) {
            ofFloat = ObjectAnimator.ofFloat(h10.f37677J, "scaleX", 0.8f, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(h10.f37677J, "scaleX", 1.0f, 0.8f);
        }
        if (z10) {
            ofFloat2 = ObjectAnimator.ofFloat(h10.f37677J, "scaleY", 0.8f, 1.0f);
        } else {
            ofFloat2 = ObjectAnimator.ofFloat(h10.f37677J, "scaleY", 1.0f, 0.8f);
        }
        if (z10) {
            ofFloat3 = ObjectAnimator.ofFloat(h10.f37677J, "alpha", 0.0f, 1.0f);
        } else {
            ofFloat3 = ObjectAnimator.ofFloat(h10.f37677J, "alpha", 1.0f, 0.0f);
        }
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(200L);
        ofFloat3.setDuration(200L);
        ofFloat3.setStartDelay(50L);
        ofFloat.setStartDelay(50L);
        ofFloat2.setStartDelay(50L);
        ofFloat.setInterpolator(new COUIMoveEaseInterpolator());
        ofFloat2.setInterpolator(new COUIMoveEaseInterpolator());
        ofFloat3.setInterpolator(new COUIMoveEaseInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new e(h10));
        animatorSet.addListener(new c(h10, z10));
        animatorSet.addListener(new d(h10, z10));
        animatorSet.playTogether(ofInt, ofFloat, ofFloat2, ofFloat3);
        animatorSet.start();
    }

    public final void i0() {
        com.android.contacts.dialpad.c cVar = this.f17168l;
        if (cVar != null) {
            cVar.q();
        }
    }

    public final void j0(int i10, boolean z10) {
        H7.b.e("SceneDialPadViewController", "switchSimLayout " + i10);
        x0.v vVar = this.f17164h;
        if (vVar != null) {
            x0.H B10 = B(vVar);
            Y value = this.f17158b.h().getValue();
            if (i10 == 0) {
                if (value.g()) {
                    B10.f37675H.setImageResource(R.drawable.scene_ic_dial_wifi_call_sim1);
                } else {
                    B10.f37675H.setImageResource(R.drawable.scene_ic_dial_call_sim1);
                }
                B10.f37678K.setContentDescription(this.f17157a.getString(R.string.oplus_use_sim_x_to_call, value.f()));
                B10.f37677J.setContentDescription(this.f17157a.getString(R.string.oplus_use_sim_x_to_call, value.i()));
                B10.f37676I.setText(value.f());
            } else {
                if (value.j()) {
                    B10.f37675H.setImageResource(R.drawable.scene_ic_dial_wifi_call_sim2);
                } else {
                    B10.f37675H.setImageResource(R.drawable.scene_ic_dial_call_sim2);
                }
                B10.f37676I.setText(value.i());
                B10.f37678K.setContentDescription(this.f17157a.getString(R.string.oplus_use_sim_x_to_call, value.i()));
                B10.f37677J.setContentDescription(this.f17157a.getString(R.string.oplus_use_sim_x_to_call, value.f()));
            }
            if (B10.f37674G.getDisplayedChild() != i10) {
                B10.f37674G.setDisplayedChild(i10);
            }
            if (!z10) {
                ImageSwitcher imageSwitcher = B10.f37674G;
                kotlin.jvm.internal.i.e(imageSwitcher, "switchSimLayoutBinding.buttonSwitch");
                Iterator<View> it = androidx.core.view.N.b(imageSwitcher).iterator();
                while (it.hasNext()) {
                    it.next().clearAnimation();
                }
            }
            this.f17165i = i10;
        }
    }

    public final void l0() {
        com.android.contacts.dialpad.c cVar = this.f17168l;
        if (cVar != null) {
            cVar.t(this.f17169m);
        }
    }

    public final void m0() {
        Pair a10;
        int i10;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        x0.v vVar = this.f17164h;
        if (vVar != null) {
            x0.H B10 = B(vVar);
            if (this.f17160d.z()) {
                a10 = m9.g.a(Boolean.FALSE, Integer.valueOf(R.dimen.DP_0));
            } else {
                a10 = m9.g.a(Boolean.TRUE, Integer.valueOf(R.dimen.DP_44));
            }
            FeedbackLinearLayout feedbackLinearLayout = B10.f37677J;
            kotlin.jvm.internal.i.e(feedbackLinearLayout, "switchSimLayoutBinding.switchButtonParent");
            if (((Boolean) a10.c()).booleanValue()) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            feedbackLinearLayout.setVisibility(i10);
            ViewGroup.LayoutParams layoutParams = B10.f37678K.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginStart(this.f17157a.getResources().getDimensionPixelSize(((Number) a10.d()).intValue()));
                B10.f37678K.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onCreate(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onCreate(owner);
        H7.b.e("SceneDialPadViewController", "onCreate");
        Q0.d(true);
        kotlinx.coroutines.flow.m<Y> h10 = this.f17158b.h();
        Lifecycle.State state = Lifecycle.State.CREATED;
        FlowExtKt.a(h10, owner, state, new v9.l<Y, m9.q>() { // from class: com.android.contacts.scenecard.SceneDialPadViewController$onCreate$1
            {
                super(1);
            }

            public final void b(Y it) {
                kotlin.jvm.internal.i.f(it, "it");
                H7.b.e("SceneDialPadViewController", "simCardStatesStateFlow " + it);
                SceneDialPadViewController.this.V(it);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Y y10) {
                b(y10);
                return m9.q.f35511a;
            }
        });
        FlowExtKt.a(this.f17160d.w(), owner, state, new v9.l<String, m9.q>() { // from class: com.android.contacts.scenecard.SceneDialPadViewController$onCreate$2
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(String str) {
                invoke2(str);
                return m9.q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                x0.H B10;
                if (str != null) {
                    Q0.c(SceneDialPadViewController.this.v().u());
                    x0.v vVar = SceneDialPadViewController.this.f17164h;
                    if (vVar != null) {
                        SceneDialPadViewController sceneDialPadViewController = SceneDialPadViewController.this;
                        if (sceneDialPadViewController.z().j()) {
                            int d10 = sceneDialPadViewController.z().h().getValue().d();
                            B10 = sceneDialPadViewController.B(vVar);
                            if (!sceneDialPadViewController.v().z()) {
                                sceneDialPadViewController.f0(true, B10);
                            } else {
                                SceneDialPadViewController.k0(sceneDialPadViewController, d10, false, 2, null);
                                sceneDialPadViewController.f0(false, B10);
                            }
                        }
                    }
                }
            }
        });
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onDestroy(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onDestroy(owner);
        H7.b.e("SceneDialPadViewController", "onDestroy");
        com.android.contacts.dialpad.c cVar = this.f17168l;
        if (cVar != null) {
            cVar.o(true);
        }
        com.android.contacts.dialpad.c cVar2 = this.f17168l;
        if (cVar2 != null) {
            cVar2.s();
        }
        com.android.contacts.dialpad.j jVar = this.f17169m;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onPause(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onPause(owner);
        H7.b.e("SceneDialPadViewController", "onPause");
        i0();
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onResume(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onResume(owner);
        H7.b.e("SceneDialPadViewController", "onResume");
        U(this, false, 1, null);
        W();
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onStart(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onStart(owner);
        H7.b.e("SceneDialPadViewController", "onStart");
        com.android.contacts.dialpad.c cVar = this.f17168l;
        if (cVar != null) {
            cVar.j();
        }
        String f10 = Q0.f();
        if (f10 != null && !kotlin.jvm.internal.i.b(this.f17160d.u(), f10)) {
            F();
            this.f17160d.C(f10);
            c0(false);
        } else {
            Q0.c(f10);
            e0();
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onStop(InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        super.onStop(owner);
        H7.b.e("SceneDialPadViewController", "onStop, startingPlaceCall: " + this.f17171o);
        com.android.contacts.dialpad.c cVar = this.f17168l;
        if (cVar != null) {
            cVar.o(false);
        }
        if (this.f17171o) {
            ThreadUtilsKt.a().postDelayed(new Runnable() { // from class: com.android.contacts.scenecard.l
                @Override // java.lang.Runnable
                public final void run() {
                    SceneDialPadViewController.L(SceneDialPadViewController.this);
                }
            }, 500L);
            Q0.c(null);
            this.f17171o = false;
        }
    }

    public final int t(int i10) {
        if (i10 != 4 && i10 != 7 && i10 != 8 && i10 != 9) {
            return this.f17157a.getResources().getDimensionPixelSize(R.dimen.scene_dialpad_button_height);
        }
        return this.f17157a.getResources().getDimensionPixelSize(R.dimen.scene_dialpad_button_silk_height);
    }

    public final Context u() {
        return this.f17157a;
    }

    public final SceneDialTextEditor v() {
        return this.f17160d;
    }

    public final x0.x w(x0.v vVar) {
        if (!vVar.f37793J.j()) {
            ViewStub i10 = vVar.f37793J.i();
            if (i10 != null) {
                i10.inflate();
            }
            ViewDataBinding g10 = vVar.f37793J.g();
            kotlin.jvm.internal.i.d(g10, "null cannot be cast to non-null type com.android.contacts.databinding.SceneDualSimLayoutBinding");
            x0.x xVar = (x0.x) g10;
            xVar.f37802I.setOnClickListener(this.f17155D);
            xVar.f37805L.setOnClickListener(this.f17155D);
            xVar.f37802I.setDrawableColor(this.f17157a.getColor(R.color.scene_color_dialpad_call_button_bg));
            xVar.f37805L.setDrawableColor(this.f17157a.getColor(R.color.scene_color_dialpad_call_button_bg));
            return xVar;
        }
        ViewDataBinding g11 = vVar.f37793J.g();
        kotlin.jvm.internal.i.d(g11, "null cannot be cast to non-null type com.android.contacts.databinding.SceneDualSimLayoutBinding");
        return (x0.x) g11;
    }

    public final int x() {
        return this.f17165i;
    }

    public final kotlinx.coroutines.flow.m<Integer> y() {
        return this.f17163g;
    }

    public final SceneSimCardStateManager z() {
        return this.f17158b;
    }

    /* compiled from: SceneDialPadViewController.kt */
    /* loaded from: classes.dex */
    public static final class b implements ScrollRelativeLayout.a {
        public b() {
        }

        @Override // com.customize.contacts.widget.ScrollRelativeLayout.a
        public void a() {
            SceneDialPadViewController.E(SceneDialPadViewController.this, false, 1, null);
        }

        @Override // com.customize.contacts.widget.ScrollRelativeLayout.a
        public boolean b() {
            Z3.f fVar = SceneDialPadViewController.this.f17166j;
            if (fVar == null || !fVar.n()) {
                return false;
            }
            return true;
        }

        @Override // com.customize.contacts.widget.ScrollRelativeLayout.a
        public int getHeight() {
            int i10;
            ScrollRelativeLayout scrollRelativeLayout;
            x0.v vVar = SceneDialPadViewController.this.f17164h;
            if (vVar != null && (scrollRelativeLayout = vVar.f37791H) != null) {
                i10 = scrollRelativeLayout.getHeight();
            } else {
                i10 = 0;
            }
            if (i10 == 0) {
                return SceneDialPadViewController.this.u().getResources().getDimensionPixelSize(R.dimen.scene_dialpad_height);
            }
            return i10;
        }

        @Override // com.customize.contacts.widget.ScrollRelativeLayout.a
        public void c() {
        }

        @Override // com.customize.contacts.widget.ScrollRelativeLayout.a
        public void d() {
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0.H f17179a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f17180b;

        public c(x0.H h10, boolean z10) {
            this.f17179a = h10;
            this.f17180b = z10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            int i10;
            FeedbackLinearLayout feedbackLinearLayout = this.f17179a.f37677J;
            kotlin.jvm.internal.i.e(feedbackLinearLayout, "switchSimLayoutBinding.switchButtonParent");
            if (this.f17180b) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            feedbackLinearLayout.setVisibility(i10);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0.H f17181a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f17182b;

        public d(x0.H h10, boolean z10) {
            this.f17181a = h10;
            this.f17182b = z10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i10;
            FeedbackLinearLayout feedbackLinearLayout = this.f17181a.f37677J;
            kotlin.jvm.internal.i.e(feedbackLinearLayout, "switchSimLayoutBinding.switchButtonParent");
            if (this.f17182b) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            feedbackLinearLayout.setVisibility(i10);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0.H f17183a;

        public e(x0.H h10) {
            this.f17183a = h10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FeedbackLinearLayout feedbackLinearLayout = this.f17183a.f37677J;
            kotlin.jvm.internal.i.e(feedbackLinearLayout, "switchSimLayoutBinding.switchButtonParent");
            feedbackLinearLayout.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: SceneDialPadViewController.kt */
    /* loaded from: classes.dex */
    public static final class f implements g.b {
        public f() {
        }

        @Override // com.android.contacts.dialpad.g.b
        public void a(int i10) {
            H7.b.e("SceneDialPadViewController", "onShowSetSpeedDial : " + i10);
            SceneDialPadViewController.this.f17175x = i10;
        }

        @Override // com.android.contacts.dialpad.g.b
        public void b(String str) {
            H7.b.e("SceneDialPadViewController", "speedDialManagerListener onPlaceCall");
            if (str != null && str.length() != 0) {
                SceneDialPadViewController.this.l0();
                if (SceneDialPadViewController.this.z().i() < 2) {
                    SceneDialPadViewController.O(SceneDialPadViewController.this, str, 0, false, 6, null);
                    return;
                } else if (SceneDialPadViewController.this.x() != -1) {
                    SceneDialPadViewController sceneDialPadViewController = SceneDialPadViewController.this;
                    SceneDialPadViewController.O(sceneDialPadViewController, str, sceneDialPadViewController.x(), false, 4, null);
                    return;
                } else {
                    SceneDialPadViewController.this.v().C(str);
                    return;
                }
            }
            H7.b.i("SceneDialPadViewController", "speedDialManagerListener onPlaceCall, number empty");
        }

        @Override // com.android.contacts.dialpad.g.b
        public void c(int i10) {
        }
    }
}
