package com.android.contacts;

import F0.c;
import Z3.f;
import a4.C0421a;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.CallLog;
import android.provider.Settings;
import android.telecom.PhoneAccountHandle;
import android.telephony.PhoneNumberUtils;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.ViewOnClickListenerC0694u0;
import com.android.contacts.calllog.CallLogItemCacheManager;
import com.android.contacts.calllog.k;
import com.android.contacts.calllog.r;
import com.android.contacts.dialpad.SimInfoManager;
import com.android.contacts.dialpad.g;
import com.android.contacts.dialpad.view.DialEditText;
import com.android.contacts.dialpad.view.DialerHeaderViewManager;
import com.android.contacts.dialpad.view.DialpadBottomView;
import com.android.contacts.dialpad.view.DialpadImageButton;
import com.android.contacts.dialpad.view.DialpadView;
import com.android.contacts.framework.baseui.behavior.BaseTitleBehavior;
import com.android.contacts.framework.baseui.behavior.PrimaryTitleBehavior;
import com.android.contacts.framework.baseui.calllog.CallRecordingsCache;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.baseui.util.C0638c;
import com.android.contacts.framework.baseui.util.LocationUtils;
import com.android.contacts.framework.baseui.widget.AppBarLayoutView;
import com.android.contacts.framework.baseui.widget.EmptyViewGroup;
import com.android.contacts.framework.baseui.widget.FloatingTabView;
import com.android.contacts.framework.baseui.widget.MainPercentWidthLayout;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.TelecomAdapter;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.fragment.MainFragment;
import com.customize.contacts.manager.B;
import com.customize.contacts.startupspeed.CallLogPreload;
import com.customize.contacts.startupspeed.StartupSpeedHelper;
import com.customize.contacts.util.AnimationAnimationListenerC0813y;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0794e;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.C0802m;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.HandlerC0795f;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.viewmodel.DialPadFragmentViewModel;
import com.customize.contacts.widget.ScrollRelativeLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.AppMetaFeatures;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import h1.C1073b;
import h1.C1074c;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m1.C1322s;
import o0.C1390c;
import q7.C1493b;
import r0.C1498a;
import r0.C1501d;
import w0.C1643c;

/* compiled from: DialtactsFragment.java */
/* renamed from: com.android.contacts.u0 */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0694u0 extends MainFragment implements View.OnClickListener, View.OnLongClickListener, COUIStatusBarResponseUtil.StatusBarClickListener, TextWatcher, BaseTitleBehavior.b, r.b, k.j, DialpadImageButton.b, B.b, DialpadView.a, w7.b, A0.a {

    /* renamed from: c2 */
    public static final String f17329c2 = C0421a.f6395a;

    /* renamed from: d2 */
    public static boolean f17330d2 = false;

    /* renamed from: e2 */
    public static final Pattern f17331e2 = Pattern.compile("[0-9*#+()\\s\\-]{7,}");

    /* renamed from: A */
    public com.customize.contacts.manager.B f17332A;

    /* renamed from: A0 */
    public ImageView f17333A0;

    /* renamed from: B0 */
    public ImageView f17336B0;

    /* renamed from: C0 */
    public TextView f17339C0;

    /* renamed from: C1 */
    public w f17340C1;

    /* renamed from: D0 */
    public TextView f17342D0;

    /* renamed from: D1 */
    public x f17343D1;

    /* renamed from: E */
    public A f17344E;

    /* renamed from: E0 */
    public TextView f17345E0;

    /* renamed from: E1 */
    public x f17346E1;

    /* renamed from: F0 */
    public View f17348F0;

    /* renamed from: G */
    public E f17350G;

    /* renamed from: G0 */
    public FloatingTabView f17351G0;

    /* renamed from: G1 */
    public Boolean f17352G1;

    /* renamed from: H */
    public Z3.f f17353H;

    /* renamed from: H0 */
    public TextView f17354H0;

    /* renamed from: H1 */
    public boolean f17355H1;

    /* renamed from: I */
    public ScrollRelativeLayout f17356I;

    /* renamed from: J */
    public String f17359J;

    /* renamed from: L0 */
    public com.android.contacts.dialpad.g f17366L0;

    /* renamed from: L1 */
    public DialpadBottomView f17367L1;

    /* renamed from: O1 */
    public A0.b f17376O1;

    /* renamed from: P */
    public ImageButton f17377P;

    /* renamed from: P0 */
    public String f17378P0;

    /* renamed from: P1 */
    public LinearLayoutManager f17379P1;

    /* renamed from: Q */
    public ImageButton f17380Q;

    /* renamed from: T */
    public Resources f17389T;

    /* renamed from: W */
    public E3.c f17398W;

    /* renamed from: X0 */
    public ClipboardManager f17402X0;

    /* renamed from: Y0 */
    public LinearLayout f17405Y0;

    /* renamed from: Z0 */
    public String f17408Z0;

    /* renamed from: a0 */
    public E3.q f17410a0;

    /* renamed from: a1 */
    public long f17411a1;

    /* renamed from: b0 */
    public E3.o f17413b0;

    /* renamed from: b1 */
    public SharedPreferences f17414b1;

    /* renamed from: c0 */
    public HeaderFooterRecyclerView f17416c0;

    /* renamed from: d0 */
    public DialerHeaderViewManager f17418d0;

    /* renamed from: f1 */
    public ThreadPoolExecutor f17423f1;

    /* renamed from: g1 */
    public com.android.contacts.dialpad.c f17425g1;

    /* renamed from: h1 */
    public com.android.contacts.dialpad.j f17427h1;

    /* renamed from: i1 */
    public Z3.a f17429i1;

    /* renamed from: j1 */
    public MenuItem f17432j1;

    /* renamed from: k */
    public DialEditText f17433k;

    /* renamed from: k1 */
    public MenuItem f17435k1;

    /* renamed from: l1 */
    public View f17438l1;

    /* renamed from: m1 */
    public HandlerThread f17441m1;

    /* renamed from: n0 */
    public com.android.contacts.calllog.r f17443n0;

    /* renamed from: n1 */
    public s f17444n1;

    /* renamed from: o0 */
    public com.android.contacts.calllog.k f17446o0;

    /* renamed from: o1 */
    public String f17447o1;

    /* renamed from: p1 */
    public COUIFloatingButton f17450p1;

    /* renamed from: q0 */
    public int f17452q0;

    /* renamed from: q1 */
    public Drawable f17453q1;

    /* renamed from: r0 */
    public TextView f17455r0;

    /* renamed from: r1 */
    public String f17456r1;

    /* renamed from: s0 */
    public DialpadView f17457s0;

    /* renamed from: s1 */
    public View f17458s1;

    /* renamed from: t0 */
    public LinearLayout f17459t0;

    /* renamed from: u1 */
    public EmptyViewGroup f17462u1;

    /* renamed from: v0 */
    public View f17463v0;

    /* renamed from: w0 */
    public View f17465w0;

    /* renamed from: x0 */
    public MainPercentWidthLayout f17468x0;

    /* renamed from: x1 */
    public int f17469x1;

    /* renamed from: y0 */
    public View f17471y0;

    /* renamed from: j */
    public final c1 f17430j = new c1();

    /* renamed from: l */
    public final C1493b f17436l = new C1493b();

    /* renamed from: m */
    public final Handler f17439m = new u(this);

    /* renamed from: n */
    public boolean f17442n = false;

    /* renamed from: o */
    public boolean f17445o = false;

    /* renamed from: p */
    public boolean f17448p = false;

    /* renamed from: q */
    public boolean f17451q = true;

    /* renamed from: r */
    public boolean f17454r = true;

    /* renamed from: x */
    public boolean f17467x = false;

    /* renamed from: y */
    public int f17470y = -1;

    /* renamed from: z */
    public final SimInfoManager f17473z = new SimInfoManager();

    /* renamed from: B */
    public BroadcastReceiver f17335B = null;

    /* renamed from: C */
    public BroadcastReceiver f17338C = null;

    /* renamed from: D */
    public BroadcastReceiver f17341D = null;

    /* renamed from: F */
    public B f17347F = null;

    /* renamed from: K */
    public int f17362K = -1;

    /* renamed from: L */
    public boolean f17365L = false;

    /* renamed from: M */
    public boolean f17368M = false;

    /* renamed from: N */
    public boolean f17371N = false;

    /* renamed from: O */
    public int f17374O = -1;

    /* renamed from: R */
    public boolean f17383R = true;

    /* renamed from: S */
    public t f17386S = null;

    /* renamed from: U */
    public boolean f17392U = true;

    /* renamed from: V */
    public boolean f17395V = false;

    /* renamed from: X */
    public int f17401X = -1;

    /* renamed from: Y */
    public int f17404Y = -1;

    /* renamed from: Z */
    public final Object f17407Z = new Object();

    /* renamed from: e0 */
    public boolean f17420e0 = false;

    /* renamed from: f0 */
    public Animator f17422f0 = null;

    /* renamed from: g0 */
    public boolean f17424g0 = false;

    /* renamed from: h0 */
    public boolean f17426h0 = false;

    /* renamed from: i0 */
    public ViewTreeObserver.OnGlobalLayoutListener f17428i0 = null;

    /* renamed from: j0 */
    public boolean f17431j0 = false;

    /* renamed from: k0 */
    public boolean f17434k0 = false;

    /* renamed from: l0 */
    public y f17437l0 = null;

    /* renamed from: m0 */
    public y f17440m0 = null;

    /* renamed from: p0 */
    public boolean f17449p0 = false;

    /* renamed from: u0 */
    public View f17461u0 = null;

    /* renamed from: z0 */
    public View f17474z0 = null;

    /* renamed from: I0 */
    public int f17357I0 = -1;

    /* renamed from: J0 */
    public boolean f17360J0 = false;

    /* renamed from: K0 */
    public String f17363K0 = null;

    /* renamed from: M0 */
    public boolean f17369M0 = false;

    /* renamed from: N0 */
    public boolean f17372N0 = false;

    /* renamed from: O0 */
    public boolean f17375O0 = false;

    /* renamed from: Q0 */
    public boolean f17381Q0 = false;

    /* renamed from: R0 */
    public boolean f17384R0 = false;

    /* renamed from: S0 */
    public boolean f17387S0 = false;

    /* renamed from: T0 */
    public boolean f17390T0 = false;

    /* renamed from: U0 */
    public boolean f17393U0 = false;

    /* renamed from: V0 */
    public volatile int f17396V0 = 0;

    /* renamed from: W0 */
    public int f17399W0 = 0;

    /* renamed from: c1 */
    public String f17417c1 = "";

    /* renamed from: d1 */
    public Intent f17419d1 = null;

    /* renamed from: e1 */
    public View f17421e1 = null;

    /* renamed from: t1 */
    public boolean f17460t1 = true;

    /* renamed from: v1 */
    public boolean f17464v1 = false;

    /* renamed from: w1 */
    public int f17466w1 = -1;

    /* renamed from: y1 */
    public boolean f17472y1 = false;

    /* renamed from: z1 */
    public boolean f17475z1 = false;

    /* renamed from: A1 */
    public boolean f17334A1 = true;

    /* renamed from: B1 */
    public boolean f17337B1 = true;

    /* renamed from: F1 */
    public boolean f17349F1 = false;

    /* renamed from: I1 */
    public boolean f17358I1 = false;

    /* renamed from: J1 */
    public boolean f17361J1 = false;

    /* renamed from: K1 */
    public boolean f17364K1 = false;

    /* renamed from: M1 */
    public DialPadFragmentViewModel f17370M1 = null;

    /* renamed from: N1 */
    public AnimationAnimationListenerC0813y f17373N1 = null;

    /* renamed from: Q1 */
    public int f17382Q1 = 0;

    /* renamed from: R1 */
    public final Object f17385R1 = new Object();

    /* renamed from: S1 */
    public boolean f17388S1 = false;

    /* renamed from: T1 */
    public boolean f17391T1 = false;

    /* renamed from: U1 */
    public final C1322s.a f17394U1 = new C1322s.a() { // from class: com.android.contacts.h0
        @Override // m1.C1322s.a
        public final void a(Throwable th, int i10) {
            ViewOnClickListenerC0694u0.this.E5(th, i10);
        }
    };

    /* renamed from: V1 */
    public final androidx.lifecycle.w<Boolean> f17397V1 = new androidx.lifecycle.w() { // from class: com.android.contacts.k0
        @Override // androidx.lifecycle.w
        public final void onChanged(Object obj) {
            ViewOnClickListenerC0694u0.this.F5((Boolean) obj);
        }
    };

    /* renamed from: W1 */
    public final androidx.lifecycle.w<Boolean> f17400W1 = new androidx.lifecycle.w() { // from class: com.android.contacts.l0
        @Override // androidx.lifecycle.w
        public final void onChanged(Object obj) {
            ViewOnClickListenerC0694u0.this.G5((Boolean) obj);
        }
    };

    /* renamed from: X1 */
    public final Runnable f17403X1 = new n();

    /* renamed from: Y1 */
    public final ContentObserver f17406Y1 = new C0695a(new Handler());

    /* renamed from: Z1 */
    public final Z3.h f17409Z1 = new C0698d();

    /* renamed from: a2 */
    public final ContentObserver f17412a2 = new C0699e(null);

    /* renamed from: b2 */
    public final androidx.lifecycle.w<Integer> f17415b2 = new androidx.lifecycle.w() { // from class: com.android.contacts.m0
        @Override // androidx.lifecycle.w
        public final void onChanged(Object obj) {
            ViewOnClickListenerC0694u0.this.H5((Integer) obj);
        }
    };

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$A */
    /* loaded from: classes.dex */
    public class A extends BroadcastReceiver {
        public /* synthetic */ A(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, E0 e02) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ViewOnClickListenerC0694u0.log("onReceive action: " + intent.getAction());
            if (ViewOnClickListenerC0694u0.this.f17446o0 != null) {
                com.android.contacts.framework.baseui.util.w.e().b();
                ViewOnClickListenerC0694u0.this.f17446o0.S1(com.android.contacts.framework.baseui.util.w.e());
            }
        }

        public A() {
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$B */
    /* loaded from: classes.dex */
    public class B extends BroadcastReceiver {
        public /* synthetic */ B(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, F0 f02) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ViewOnClickListenerC0694u0.log("onReceive action: " + intent.getAction());
            ViewOnClickListenerC0694u0.this.I3();
        }

        public B() {
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$C */
    /* loaded from: classes.dex */
    public static class C extends com.android.contacts.util.D<Void, Void, String, ViewOnClickListenerC0694u0> {

        /* renamed from: b */
        public final String f17478b;

        public /* synthetic */ C(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, String str, G0 g02) {
            this(viewOnClickListenerC0694u0, str);
        }

        @Override // com.android.contacts.util.D
        /* renamed from: d */
        public String a(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, Void... voidArr) {
            if (viewOnClickListenerC0694u0 != null && viewOnClickListenerC0694u0.isAdded()) {
                String a10 = C7.c.b(viewOnClickListenerC0694u0.d4()).a();
                ViewOnClickListenerC0694u0.log("updateCityAddress number = " + H7.a.d(this.f17478b) + " ,countryIso = " + a10);
                return LocationUtils.j(viewOnClickListenerC0694u0.requireContext(), this.f17478b, a10, 0, false);
            }
            return null;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e */
        public void b(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, String str) {
            if (viewOnClickListenerC0694u0 != null && viewOnClickListenerC0694u0.isAdded()) {
                ViewOnClickListenerC0694u0.log("updateCityAddress home = " + str);
                if (viewOnClickListenerC0694u0.f17455r0 == null) {
                    H7.b.e("DialtactsFragment", "fragment.mLocation is null");
                } else if (!TextUtils.isEmpty(str)) {
                    viewOnClickListenerC0694u0.f17455r0.setText(str);
                    viewOnClickListenerC0694u0.f17455r0.setVisibility(0);
                } else {
                    viewOnClickListenerC0694u0.f17455r0.setVisibility(4);
                }
            }
        }

        public C(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, String str) {
            super(viewOnClickListenerC0694u0);
            this.f17478b = str;
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$D */
    /* loaded from: classes.dex */
    public class D extends BroadcastReceiver {
        public /* synthetic */ D(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, H0 h02) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            FragmentActivity activity;
            FragmentActivity activity2;
            if (intent == null) {
                return;
            }
            if (!"com.oplus.contacts.display_settings_changed".equals(intent.getAction()) && !"com.oplus.contacts.force_refresh_calllog".equals(intent.getAction()) && !"contacts.intent.action.SIM_STATE_CHANGED_LOCAL".equals(intent.getAction())) {
                if ("com.oplus.contacts.DETAIL_UPDATE_DONE".equals(intent.getAction())) {
                    boolean c10 = C7.e.c(intent, "from_calllog", false);
                    if (c10 && C7.e.c(intent, "notInsertVipToBlackList", false) && (activity2 = ViewOnClickListenerC0694u0.this.getActivity()) != null) {
                        com.oplus.foundation.util.ui.c.d(activity2, R.string.oplus_not_add_to_backlist_in_vip);
                    }
                    if (!c10 || ViewOnClickListenerC0694u0.this.d5()) {
                        ViewOnClickListenerC0694u0.this.F7();
                        return;
                    } else {
                        ViewOnClickListenerC0694u0.this.I7(ViewOnClickListenerC0694u0.this.l4());
                        return;
                    }
                }
                if ("com.oplus.contacts.HANDLE_VIP_FINISHED".equals(intent.getAction())) {
                    if (ViewOnClickListenerC0694u0.this.f17446o0 != null) {
                        ArrayList<String> k10 = C7.e.k(intent, "number_list_key");
                        if (!C0811w.g(k10)) {
                            ViewOnClickListenerC0694u0.this.f17446o0.L0(k10);
                        }
                        ViewOnClickListenerC0694u0.this.G3();
                    }
                    if (C7.e.c(intent, "vip_remove_blacklist_tips", false) && (activity = ViewOnClickListenerC0694u0.this.getActivity()) != null) {
                        com.oplus.foundation.util.ui.c.d(activity, R.string.removed_from_the_blacklist);
                        return;
                    }
                    return;
                }
                if ("oplus.intent.action.calllog.clear_catch".equals(intent.getAction()) && ViewOnClickListenerC0694u0.this.f17446o0 != null) {
                    ArrayList<String> k11 = C7.e.k(intent, "number_list_key");
                    if (!C0811w.g(k11)) {
                        ViewOnClickListenerC0694u0.this.f17446o0.L0(k11);
                        return;
                    }
                    return;
                }
                return;
            }
            com.android.contacts.calllog.k kVar = ViewOnClickListenerC0694u0.this.f17446o0;
            if (kVar != null) {
                kVar.T1(false);
                if (C7.e.c(intent, "need_refresh_data", false)) {
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessage(599);
                } else if (C7.e.c(intent, "need_delay_update_call_log", true)) {
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(555, 1000L);
                } else {
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessage(555);
                }
                if (!ViewOnClickListenerC0694u0.this.d5()) {
                    ViewOnClickListenerC0694u0.this.I7(ViewOnClickListenerC0694u0.this.l4());
                }
            }
        }

        public D() {
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$E */
    /* loaded from: classes.dex */
    public class E extends BroadcastReceiver {
        public /* synthetic */ E(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, J0 j02) {
            this();
        }

        public final /* synthetic */ void b() {
            ViewOnClickListenerC0694u0.this.t4();
            ViewOnClickListenerC0694u0.this.p7(true);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ViewOnClickListenerC0694u0.log("VolteCheckReceiver onReceive action: " + intent.getAction());
            if (ViewOnClickListenerC0694u0.this.isAdded()) {
                ViewOnClickListenerC0694u0.this.f17473z.i(ViewOnClickListenerC0694u0.this.getActivity(), null, new Runnable() { // from class: com.android.contacts.I0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC0694u0.E.this.b();
                    }
                });
            }
        }

        public E() {
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$a */
    /* loaded from: classes.dex */
    public class C0695a extends ContentObserver {
        public C0695a(Handler handler) {
            super(handler);
        }

        public final /* synthetic */ void b() {
            ViewOnClickListenerC0694u0.this.t4();
            ViewOnClickListenerC0694u0.this.p7(true);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            FragmentActivity activity = ViewOnClickListenerC0694u0.this.getActivity();
            H7.b.e("DialtactsFragment", "mVoLTEContentObserver--------");
            if (activity != null && ViewOnClickListenerC0694u0.this.isAdded() && com.customize.contacts.util.b0.f0(activity)) {
                ViewOnClickListenerC0694u0.this.f17473z.i(ViewOnClickListenerC0694u0.this.getActivity(), null, new Runnable() { // from class: com.android.contacts.t0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC0694u0.C0695a.this.b();
                    }
                });
            }
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$b */
    /* loaded from: classes.dex */
    public class AsyncTaskC0696b extends AsyncTask<Integer, Void, String> {

        /* renamed from: a */
        public final /* synthetic */ String f17482a;

        public AsyncTaskC0696b(String str) {
            this.f17482a = str;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            if (B3.a.u()) {
                E0.b.F(new c.a().h(this.f17482a).c(2).e(0L).j(0).i(Long.valueOf(System.currentTimeMillis())).k(-1).f(Boolean.TRUE).b(Boolean.valueOf(C0801l.o(2))).a());
                return null;
            }
            return null;
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$e */
    /* loaded from: classes.dex */
    public class C0699e extends ContentObserver {
        public C0699e(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = ViewOnClickListenerC0694u0.this;
            viewOnClickListenerC0694u0.f17352G1 = Boolean.valueOf(DisplayUtil.m(viewOnClickListenerC0694u0.getContext()));
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$f */
    /* loaded from: classes.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        public final /* synthetic */ int f17487a;

        public f(int i10) {
            this.f17487a = i10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewOnClickListenerC0694u0.this.f17356I.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "updateDialpadContainerView getTranslationY = " + ViewOnClickListenerC0694u0.this.f17356I.getTranslationY() + ";mDialpadIsShow = " + ViewOnClickListenerC0694u0.this.f17383R + ";mDialpad height = " + this.f17487a);
            }
            if (!ViewOnClickListenerC0694u0.this.f17383R) {
                float translationY = ViewOnClickListenerC0694u0.this.f17356I.getTranslationY();
                int i10 = this.f17487a;
                if (translationY != i10) {
                    ViewOnClickListenerC0694u0.this.f17356I.setTranslationY(i10);
                }
            }
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$g */
    /* loaded from: classes.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        public final /* synthetic */ View f17489a;

        public g(View view) {
            this.f17489a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f17489a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f17489a.setVisibility(0);
            ViewOnClickListenerC0694u0.this.f17428i0 = null;
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$h */
    /* loaded from: classes.dex */
    public class h implements FloatingTabView.c {

        /* renamed from: a */
        public final Runnable f17491a = new Runnable() { // from class: com.android.contacts.v0
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.h.this.e();
            }
        };

        /* renamed from: b */
        public final Runnable f17492b = new Runnable() { // from class: com.android.contacts.w0
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.h.this.f();
            }
        };

        public h() {
        }

        @Override // com.android.contacts.framework.baseui.widget.FloatingTabView.c
        public boolean a(int i10, boolean z10) {
            boolean z11;
            int i11 = 0;
            if (i10 == R.id.tab_missed_call) {
                z11 = true;
            } else {
                z11 = false;
            }
            H7.b.e("DialtactsFragment", "onTabSelected, filterMissed = " + z11);
            ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = ViewOnClickListenerC0694u0.this;
            if (viewOnClickListenerC0694u0.f17416c0 != null && viewOnClickListenerC0694u0.f17446o0 != null && viewOnClickListenerC0694u0.f17379P1 != null) {
                ViewOnClickListenerC0694u0 viewOnClickListenerC0694u02 = ViewOnClickListenerC0694u0.this;
                if (viewOnClickListenerC0694u02.f21252f != null && viewOnClickListenerC0694u02.f17351G0 != null) {
                    if (ViewOnClickListenerC0694u0.this.f17416c0.isComputingLayout() && ViewOnClickListenerC0694u0.this.r5()) {
                        H7.b.i("DialtactsFragment", "recyclerview is computing layout");
                        ViewOnClickListenerC0694u0.this.requireActivity().recreate();
                        return false;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ViewOnClickListenerC0694u0.this.f17416c0.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                    ViewOnClickListenerC0694u0.this.f17446o0.G(z11);
                    androidx.recyclerview.widget.j.b(ViewOnClickListenerC0694u0.this.f17446o0.r()).c(ViewOnClickListenerC0694u0.this.f17446o0);
                    int headersCount = ViewOnClickListenerC0694u0.this.f17416c0.getHeadersCount();
                    int dimensionPixelSize = ViewOnClickListenerC0694u0.this.getResources().getDimensionPixelSize(R.dimen.toolbar_title_init_height);
                    if (z11) {
                        LinearLayoutManager linearLayoutManager = ViewOnClickListenerC0694u0.this.f17379P1;
                        ViewOnClickListenerC0694u0 viewOnClickListenerC0694u03 = ViewOnClickListenerC0694u0.this;
                        int n10 = ViewOnClickListenerC0694u0.this.f17446o0.n(w7.e.b(linearLayoutManager, viewOnClickListenerC0694u03.f21249c, viewOnClickListenerC0694u03.q4(), ViewOnClickListenerC0694u0.this.getResources().getDimensionPixelSize(R.dimen.unfold_divider_width) * 2) - headersCount) + headersCount;
                        if (ViewOnClickListenerC0694u0.this.f21252f.S() && n10 == headersCount) {
                            n10 = 0;
                        }
                        LinearLayoutManager linearLayoutManager2 = ViewOnClickListenerC0694u0.this.f17379P1;
                        if (!ViewOnClickListenerC0694u0.this.f21252f.S()) {
                            i11 = -dimensionPixelSize;
                        }
                        linearLayoutManager2.scrollToPositionWithOffset(n10, i11);
                    } else {
                        if (ViewOnClickListenerC0694u0.this.f21252f.S()) {
                            headersCount = 0;
                        }
                        LinearLayoutManager linearLayoutManager3 = ViewOnClickListenerC0694u0.this.f17379P1;
                        if (!ViewOnClickListenerC0694u0.this.f21252f.S()) {
                            i11 = -dimensionPixelSize;
                        }
                        linearLayoutManager3.scrollToPositionWithOffset(headersCount, i11);
                    }
                    if (z11 && ViewOnClickListenerC0694u0.this.f17446o0.getItemCount() == 0) {
                        ViewOnClickListenerC0694u0.this.f17351G0.removeCallbacks(this.f17491a);
                        ViewOnClickListenerC0694u0.this.f17351G0.post(this.f17491a);
                    } else {
                        ViewOnClickListenerC0694u0.this.f17351G0.removeCallbacks(this.f17492b);
                        ViewOnClickListenerC0694u0.this.f17351G0.post(this.f17492b);
                    }
                    ViewOnClickListenerC0694u0.this.X7();
                    ViewOnClickListenerC0694u0.this.q8();
                    com.customize.contacts.util.h0.g(z11);
                    return true;
                }
            }
            H7.b.c("DialtactsFragment", "recyclerview invalid state");
            return false;
        }

        @Override // com.android.contacts.framework.baseui.widget.FloatingTabView.c
        public void b() {
            H7.b.e("DialtactsFragment", "onClickSelectedTabAgain");
        }

        public final /* synthetic */ void e() {
            BaseTitleBehavior baseTitleBehavior = ViewOnClickListenerC0694u0.this.f21252f;
            if (baseTitleBehavior != null) {
                baseTitleBehavior.T();
            }
        }

        public final /* synthetic */ void f() {
            BaseTitleBehavior baseTitleBehavior = ViewOnClickListenerC0694u0.this.f21252f;
            if (baseTitleBehavior != null) {
                baseTitleBehavior.l0();
            }
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$i */
    /* loaded from: classes.dex */
    public class i implements DialerHeaderViewManager.b {
        public i() {
        }

        @Override // com.android.contacts.dialpad.view.DialerHeaderViewManager.b
        public void a() {
            ViewOnClickListenerC0694u0.this.f17431j0 = false;
            ViewOnClickListenerC0694u0.this.J6();
            ViewOnClickListenerC0694u0.this.f17421e1.post(new Runnable() { // from class: com.android.contacts.q0
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC0694u0.i.this.f();
                }
            });
            ViewOnClickListenerC0694u0.this.q8();
            ViewOnClickListenerC0694u0.this.X7();
        }

        @Override // com.android.contacts.dialpad.view.DialerHeaderViewManager.b
        public void b(boolean z10) {
            ViewOnClickListenerC0694u0.this.f17431j0 = z10;
            ViewOnClickListenerC0694u0.this.X7();
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "mDeletedEmptyByExternalKeyboard = " + ViewOnClickListenerC0694u0.this.f17434k0);
            }
            if (CommonFeatureOption.m() && ViewOnClickListenerC0694u0.this.f17431j0 && ViewOnClickListenerC0694u0.this.f17434k0) {
                ViewOnClickListenerC0694u0.this.f17434k0 = false;
                ViewOnClickListenerC0694u0.this.f17421e1.post(new Runnable() { // from class: com.android.contacts.r0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC0694u0.i.this.g();
                    }
                });
            }
            ViewOnClickListenerC0694u0.this.f17421e1.post(new Runnable() { // from class: com.android.contacts.s0
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC0694u0.i.this.h();
                }
            });
            ViewOnClickListenerC0694u0.this.q8();
        }

        public final /* synthetic */ void f() {
            ViewOnClickListenerC0694u0.this.i8();
        }

        public final /* synthetic */ void g() {
            ViewOnClickListenerC0694u0.this.J6();
        }

        public final /* synthetic */ void h() {
            ViewOnClickListenerC0694u0.this.i8();
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$j */
    /* loaded from: classes.dex */
    public class j implements ViewTreeObserver.OnGlobalLayoutListener {
        public j() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ViewOnClickListenerC0694u0.this.f21251e.getWidth() == 0) {
                H7.b.i("DialtactsFragment", "mAppBarLayout getWidth is 0");
                return;
            }
            ViewOnClickListenerC0694u0.this.f21251e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = ViewOnClickListenerC0694u0.this;
            BaseTitleBehavior baseTitleBehavior = viewOnClickListenerC0694u0.f21252f;
            if (baseTitleBehavior != null) {
                baseTitleBehavior.O(viewOnClickListenerC0694u0.f21251e, viewOnClickListenerC0694u0.f17416c0);
                ViewOnClickListenerC0694u0.this.f21252f.k0();
                ViewOnClickListenerC0694u0.this.f21252f.f();
            }
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$k */
    /* loaded from: classes.dex */
    public class k implements ViewTreeObserver.OnGlobalLayoutListener {
        public k() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewOnClickListenerC0694u0.this.f17421e1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (ViewOnClickListenerC0694u0.this.c5()) {
                ViewOnClickListenerC0694u0.this.f7();
                ViewOnClickListenerC0694u0.this.f17369M0 = false;
                if (ViewOnClickListenerC0694u0.this.f17387S0) {
                    ViewOnClickListenerC0694u0.this.f17387S0 = false;
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageAtTime(222, 1000L);
                }
            }
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$l */
    /* loaded from: classes.dex */
    public class l implements f.e {
        public l() {
        }

        @Override // Z3.f.e
        public void onAnimationEnd(Animator animator) {
            H7.b.b("DialtactsFragment", "hide dialpad onAnimationEnd");
            ViewOnClickListenerC0694u0.this.E4();
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$m */
    /* loaded from: classes.dex */
    public class m extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ Cursor f17498a;

        /* renamed from: b */
        public final /* synthetic */ com.android.contacts.framework.baseui.calllog.b f17499b;

        /* renamed from: c */
        public final /* synthetic */ ContactsTabActivity f17500c;

        public m(Cursor cursor, com.android.contacts.framework.baseui.calllog.b bVar, ContactsTabActivity contactsTabActivity) {
            this.f17498a = cursor;
            this.f17499b = bVar;
            this.f17500c = contactsTabActivity;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.android.contacts.calllog.k kVar = ViewOnClickListenerC0694u0.this.f17446o0;
            if (kVar != null) {
                kVar.B1(false);
                if (this.f17498a == ViewOnClickListenerC0694u0.this.f17446o0.q() && this.f17499b != null) {
                    ViewOnClickListenerC0694u0.this.f17446o0.J();
                }
            }
            if (!ViewOnClickListenerC0694u0.this.f17426h0) {
                ViewOnClickListenerC0694u0.this.f17426h0 = true;
                this.f17500c.T2();
            }
            ViewOnClickListenerC0694u0.this.F7();
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$n */
    /* loaded from: classes.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int selectionStart = ViewOnClickListenerC0694u0.this.f17433k.getSelectionStart();
            String l42 = ViewOnClickListenerC0694u0.this.l4();
            char[] charArray = l42.toCharArray();
            int length = l42.length();
            ViewOnClickListenerC0694u0.log("index = " + selectionStart + "length = " + length);
            if (selectionStart >= length) {
                ViewOnClickListenerC0694u0.this.W6("");
                ViewOnClickListenerC0694u0.this.V6(false);
            } else {
                ViewOnClickListenerC0694u0.this.f17433k.setText(charArray, selectionStart, length - selectionStart);
                ViewOnClickListenerC0694u0.this.f17433k.setSelection(0);
            }
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$p */
    /* loaded from: classes.dex */
    public class p extends LinearLayoutManager {
        public p(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
        public boolean canScrollVertically() {
            com.android.contacts.calllog.k kVar;
            ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = ViewOnClickListenerC0694u0.this;
            if (!viewOnClickListenerC0694u0.f17460t1 && (kVar = viewOnClickListenerC0694u0.f17446o0) != null && kVar.getItemCount() <= 0 && ViewOnClickListenerC0694u0.this.d5() && !ViewOnClickListenerC0694u0.this.o5()) {
                return false;
            }
            return super.canScrollVertically();
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
        public void onLayoutCompleted(RecyclerView.y yVar) {
            View view;
            super.onLayoutCompleted(yVar);
            ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = ViewOnClickListenerC0694u0.this;
            if (viewOnClickListenerC0694u0.f17416c0 != null && viewOnClickListenerC0694u0.f17446o0 != null && (view = viewOnClickListenerC0694u0.f21249c) != null && view.getHeight() != 0) {
                int size = ViewOnClickListenerC0694u0.this.f17446o0.o().size();
                int size2 = ViewOnClickListenerC0694u0.this.f17446o0.v().size();
                int dimensionPixelSize = ViewOnClickListenerC0694u0.this.getResources().getDimensionPixelSize(R.dimen.dialtact_recycler_view_padding_bottom);
                ViewOnClickListenerC0694u0 viewOnClickListenerC0694u02 = ViewOnClickListenerC0694u0.this;
                int a10 = w7.e.a(viewOnClickListenerC0694u02.f17416c0, dimensionPixelSize, size, viewOnClickListenerC0694u02.f21249c.getHeight());
                if (a10 <= 0) {
                    ViewOnClickListenerC0694u0 viewOnClickListenerC0694u03 = ViewOnClickListenerC0694u0.this;
                    a10 = w7.e.a(viewOnClickListenerC0694u03.f17416c0, dimensionPixelSize, size2, viewOnClickListenerC0694u03.f21249c.getHeight());
                }
                if (a10 > 0 && a10 <= ViewOnClickListenerC0694u0.this.f21249c.getHeight()) {
                    dimensionPixelSize += a10;
                }
                if (dimensionPixelSize != ViewOnClickListenerC0694u0.this.f17416c0.getPaddingBottom()) {
                    H7.b.e("DialtactsFragment", "adjust recyclerview padding bottom");
                    HeaderFooterRecyclerView headerFooterRecyclerView = ViewOnClickListenerC0694u0.this.f17416c0;
                    headerFooterRecyclerView.setPaddingRelative(headerFooterRecyclerView.getPaddingStart(), ViewOnClickListenerC0694u0.this.f17416c0.getPaddingTop(), ViewOnClickListenerC0694u0.this.f17416c0.getPaddingEnd(), dimensionPixelSize);
                }
            }
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$q */
    /* loaded from: classes.dex */
    public class q implements ViewTreeObserver.OnGlobalLayoutListener {
        public q() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewOnClickListenerC0694u0.this.f17471y0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ViewOnClickListenerC0694u0.this.i8();
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$r */
    /* loaded from: classes.dex */
    public class r extends BroadcastReceiver {
        public /* synthetic */ r(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, C0709x0 c0709x0) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && r0.f.c(intent.getAction())) {
                H7.b.e("DialtactsFragment", "Received broadcast from phone,clear digits:: mStartCall: " + ViewOnClickListenerC0694u0.this.f17384R0);
                if (!ViewOnClickListenerC0694u0.this.d5() && ViewOnClickListenerC0694u0.this.f17384R0) {
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(59, 200L);
                    ViewOnClickListenerC0694u0.this.f17384R0 = false;
                }
            }
        }

        public r() {
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$s */
    /* loaded from: classes.dex */
    public static class s extends Handler {

        /* renamed from: a */
        public final WeakReference<ViewOnClickListenerC0694u0> f17507a;

        public s(Looper looper, ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0) {
            super(looper);
            this.f17507a = new WeakReference<>(viewOnClickListenerC0694u0);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = this.f17507a.get();
            if (viewOnClickListenerC0694u0 == null) {
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                viewOnClickListenerC0694u0.C6(1);
                viewOnClickListenerC0694u0.C6(5);
                viewOnClickListenerC0694u0.C6(3);
                viewOnClickListenerC0694u0.C6(6);
                viewOnClickListenerC0694u0.C6(2);
                viewOnClickListenerC0694u0.C6(4);
                return;
            }
            if (i10 == 1) {
                viewOnClickListenerC0694u0.B6();
            } else if (i10 == 3) {
                viewOnClickListenerC0694u0.f17427h1 = new com.android.contacts.dialpad.j(viewOnClickListenerC0694u0.getActivity());
            }
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$t */
    /* loaded from: classes.dex */
    public interface t {
        void a(boolean z10, boolean z11);
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$u */
    /* loaded from: classes.dex */
    public static class u extends Handler {

        /* renamed from: a */
        public final WeakReference<ViewOnClickListenerC0694u0> f17508a;

        public u(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0) {
            this.f17508a = new WeakReference<>(viewOnClickListenerC0694u0);
        }

        public static /* synthetic */ void c(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0) {
            viewOnClickListenerC0694u0.t4();
            viewOnClickListenerC0694u0.p7(true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            final ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = this.f17508a.get();
            if (viewOnClickListenerC0694u0 == null || viewOnClickListenerC0694u0.getActivity() == null) {
                return;
            }
            int i10 = message.what;
            if (i10 != 59) {
                if (i10 == 222) {
                    viewOnClickListenerC0694u0.J6();
                    return;
                }
                if (i10 != 555) {
                    if (i10 != 599) {
                        if (i10 != 799) {
                            if (i10 != 888) {
                                if (i10 != 999) {
                                    switch (i10) {
                                        case 81:
                                            viewOnClickListenerC0694u0.H6();
                                            return;
                                        case 82:
                                            viewOnClickListenerC0694u0.E7(false);
                                            return;
                                        case 83:
                                            viewOnClickListenerC0694u0.E7(true);
                                            return;
                                        case 84:
                                            viewOnClickListenerC0694u0.D3();
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                final Context d42 = viewOnClickListenerC0694u0.d4();
                                if (d42 != null) {
                                    viewOnClickListenerC0694u0.f17423f1.execute(new Runnable() { // from class: com.android.contacts.z0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            C0801l.d(d42);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            ContactsTabActivity f42 = viewOnClickListenerC0694u0.f4();
                            if (f42 != null) {
                                f42.g3(true);
                                return;
                            }
                            return;
                        }
                        if (viewOnClickListenerC0694u0.isAdded()) {
                            View view = viewOnClickListenerC0694u0.f17465w0;
                            if (view != null && view.getVisibility() == 0) {
                                viewOnClickListenerC0694u0.P6(true, true);
                            }
                            viewOnClickListenerC0694u0.f17473z.i(viewOnClickListenerC0694u0.getActivity(), null, new Runnable() { // from class: com.android.contacts.y0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ViewOnClickListenerC0694u0.u.c(ViewOnClickListenerC0694u0.this);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (viewOnClickListenerC0694u0.isAdded()) {
                        viewOnClickListenerC0694u0.F7();
                        return;
                    }
                    return;
                }
                com.android.contacts.calllog.k kVar = viewOnClickListenerC0694u0.f17446o0;
                if (kVar != null) {
                    kVar.f1();
                    viewOnClickListenerC0694u0.G3();
                    return;
                }
                return;
            }
            viewOnClickListenerC0694u0.J3();
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$v */
    /* loaded from: classes.dex */
    public static class v extends DialerKeyListener {

        /* renamed from: a */
        public final char[] f17509a;

        public /* synthetic */ v(A0 a02) {
            this();
        }

        @Override // android.text.method.DialerKeyListener, android.text.method.NumberKeyListener
        public char[] getAcceptedChars() {
            return this.f17509a;
        }

        public v() {
            this.f17509a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '#', '*', '+', '-', '(', ')', ',', '/', '.', ' ', ';'};
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$w */
    /* loaded from: classes.dex */
    public class w extends BroadcastReceiver {
        public /* synthetic */ w(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, B0 b02) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && TextUtils.equals(intent.getAction(), "com.android.contacts.ust.action.SHOW_SIM_CONTACT_NUMBER")) {
                ViewOnClickListenerC0694u0.this.W6(C7.e.l(intent, "number"));
            }
        }

        public w() {
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$x */
    /* loaded from: classes.dex */
    public class x extends PhoneStateListener {

        /* renamed from: a */
        public int f17511a;

        public x(int i10) {
            this.f17511a = i10;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i10, String str) {
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "mPhoneStateListener.onCallStateChanged slotId:" + this.f17511a);
            }
            ViewOnClickListenerC0694u0.this.w4(i10, str);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "mPhoneStateListener.onServiceStateChanged slotId:" + this.f17511a);
            }
            ViewOnClickListenerC0694u0.this.f17439m.removeMessages(799);
            ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(799, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$y */
    /* loaded from: classes.dex */
    public static class y extends HandlerC0795f {

        /* renamed from: f */
        public final WeakReference<ViewOnClickListenerC0694u0> f17513f;

        public y(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0) {
            super(viewOnClickListenerC0694u0.g4());
            this.f17513f = new WeakReference<>(viewOnClickListenerC0694u0);
        }

        @Override // com.customize.contacts.util.HandlerC0795f
        public void e(int i10, Object obj, Cursor cursor) {
            String b42;
            String a42;
            ViewOnClickListenerC0694u0.log("onQueryComplete token = " + i10);
            ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = this.f17513f.get();
            if (viewOnClickListenerC0694u0 == null) {
                return;
            }
            if (i10 == 0) {
                if (viewOnClickListenerC0694u0.getActivity() != null && !viewOnClickListenerC0694u0.getActivity().isFinishing()) {
                    synchronized (viewOnClickListenerC0694u0) {
                        try {
                            if (viewOnClickListenerC0694u0.f17446o0 == null) {
                                viewOnClickListenerC0694u0.I4();
                            }
                            String l42 = viewOnClickListenerC0694u0.l4();
                            b42 = viewOnClickListenerC0694u0.b4(l42);
                            a42 = viewOnClickListenerC0694u0.a4(l42);
                        } catch (Throwable th) {
                            H7.b.c("DialtactsFragment", "onQueryComplete e = " + th);
                            com.oplus.foundation.util.io.e.a(cursor);
                        } finally {
                        }
                        if (TextUtils.isEmpty(a42)) {
                            HeaderFooterRecyclerView headerFooterRecyclerView = viewOnClickListenerC0694u0.f17416c0;
                            if (headerFooterRecyclerView != null) {
                                headerFooterRecyclerView.setVisibility(0);
                            }
                            com.oplus.foundation.util.io.e.a(cursor);
                            return;
                        }
                        viewOnClickListenerC0694u0.f17446o0.P1(true);
                        if (cursor != null) {
                            if (!cursor.isClosed() && cursor.getCount() > 0 && !TextUtils.isEmpty(a42)) {
                                viewOnClickListenerC0694u0.f17452q0 = cursor.getCount();
                                ViewOnClickListenerC0694u0.log("mPeopleCount=" + viewOnClickListenerC0694u0.f17452q0);
                                if (viewOnClickListenerC0694u0.f17455r0 != null) {
                                    viewOnClickListenerC0694u0.f17455r0.setVisibility(4);
                                }
                                viewOnClickListenerC0694u0.P6(false, false);
                                viewOnClickListenerC0694u0.f17446o0.I0(cursor);
                                viewOnClickListenerC0694u0.X7();
                                viewOnClickListenerC0694u0.C4();
                                return;
                            }
                        }
                        viewOnClickListenerC0694u0.f17452q0 = 0;
                        if (!TextUtils.isEmpty(b42)) {
                            viewOnClickListenerC0694u0.P6(true, false);
                            View view = viewOnClickListenerC0694u0.f17465w0;
                            if (view != null) {
                                view.setVisibility(0);
                            }
                            if (b42.length() >= 2 && b42.length() <= 20) {
                                viewOnClickListenerC0694u0.Z3(b42);
                            }
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            viewOnClickListenerC0694u0.f17446o0.I0(cursor);
                        } else {
                            viewOnClickListenerC0694u0.f17446o0.I0(null);
                        }
                        viewOnClickListenerC0694u0.X7();
                        viewOnClickListenerC0694u0.C4();
                        return;
                    }
                }
                com.oplus.foundation.util.io.e.a(cursor);
                return;
            }
            if (i10 == 3) {
                if (cursor != null) {
                    try {
                        if (!cursor.isClosed()) {
                            try {
                                if (cursor.moveToFirst()) {
                                    String string = cursor.getString(0);
                                    if (!TextUtils.isEmpty(string) && viewOnClickListenerC0694u0.f17383R) {
                                        if (C0637b.h()) {
                                            viewOnClickListenerC0694u0.f17378P0 = string;
                                            string = C0637b.d(string);
                                            viewOnClickListenerC0694u0.f17375O0 = true;
                                        }
                                        DialEditText dialEditText = viewOnClickListenerC0694u0.f17433k;
                                        if (dialEditText != null) {
                                            Editable text = dialEditText.getText();
                                            if (text != null) {
                                                text.replace(0, text.length(), string);
                                            }
                                            viewOnClickListenerC0694u0.f17433k.setSelection(viewOnClickListenerC0694u0.j4());
                                            viewOnClickListenerC0694u0.V6(false);
                                        }
                                    }
                                }
                            } catch (Exception e10) {
                                H7.b.c("DialtactsFragment", "onQueryComplete QUERY_LAST_CALL_NUMBER_TOKEN" + e10);
                            }
                            com.oplus.foundation.util.io.e.a(cursor);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        com.oplus.foundation.util.io.e.a(cursor);
                        throw th2;
                    }
                }
                return;
            }
            com.oplus.foundation.util.io.e.a(cursor);
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$z */
    /* loaded from: classes.dex */
    public class z extends BroadcastReceiver {
        public /* synthetic */ z(ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0, D0 d02) {
            this();
        }

        public final /* synthetic */ void b() {
            ViewOnClickListenerC0694u0.this.t4();
            ViewOnClickListenerC0694u0.this.p7(true);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            View view;
            String action = intent.getAction();
            ViewOnClickListenerC0694u0.log("onReceive:: action = " + action);
            boolean z10 = false;
            if ("android.intent.action.SIM_STATE_CHANGED".equals(action)) {
                String l10 = C7.e.l(intent, "reason");
                String l11 = C7.e.l(intent, "ss");
                ViewOnClickListenerC0694u0.log("sim state has changed state = " + l10 + ", mIsFirstSimStateChangeBroadcast = " + ViewOnClickListenerC0694u0.this.f17454r + ", keyState = " + l11);
                if (ViewOnClickListenerC0694u0.this.f17454r) {
                    ViewOnClickListenerC0694u0.this.f17454r = false;
                    return;
                }
                if (!"PLUGIN".equals(l10) && !"PLUGOUT".equals(l10) && !"ABSENT".equals(l11) && !"READY".equals(l11)) {
                    ViewOnClickListenerC0694u0.this.f17439m.removeMessages(82);
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(82, 1000L);
                    return;
                } else {
                    ViewOnClickListenerC0694u0.this.f17439m.removeMessages(83);
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(83, 1000L);
                    ViewOnClickListenerC0694u0.this.f17395V = true;
                    return;
                }
            }
            if ("android.intent.action.SIM_SETTING_INFO_CHANGED".equals(action)) {
                ViewOnClickListenerC0694u0.log("SIM_SETTINGS_INFO_CHANGED");
                ViewOnClickListenerC0694u0.this.f17473z.i(ViewOnClickListenerC0694u0.this.getActivity(), null, new Runnable() { // from class: com.android.contacts.C0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC0694u0.z.this.b();
                    }
                });
                return;
            }
            if (C1498a.f36264w.equals(action)) {
                String l12 = C7.e.l(intent, "simstate");
                ViewOnClickListenerC0694u0.log("sim state has changed state = " + l12);
                if ("PLUGIN".equals(l12) || "PLUGOUT".equals(l12)) {
                    ViewOnClickListenerC0694u0.this.f17395V = true;
                    ViewOnClickListenerC0694u0.this.f17439m.removeMessages(83);
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(83, 1000L);
                    return;
                }
                return;
            }
            if ("org.codeaurora.intent.action.ACTION_DDS_SWITCH_DONE".equals(action)) {
                ViewOnClickListenerC0694u0.this.f17439m.removeMessages(83);
                ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(83, COUIScrollBar.SCROLLER_FADE_TIMEOUT);
                return;
            }
            if ("android.intent.action.ACTION_SUBINFO_CONTENT_CHANGE".equals(action)) {
                String l13 = C7.e.l(intent, "PRIVISION");
                ViewOnClickListenerC0694u0.log("ACTION_SUBINFO_CONTENT_CHANGE mIsPluginOrOut = " + ViewOnClickListenerC0694u0.this.f17395V + ", extra = " + l13);
                if (ViewOnClickListenerC0694u0.this.f17395V || "PRIVISION".equals(l13)) {
                    ViewOnClickListenerC0694u0.this.f17395V = false;
                    ViewOnClickListenerC0694u0.this.f17439m.removeMessages(83);
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(83, 1000L);
                    return;
                } else {
                    if (B3.a.R()) {
                        String l14 = C7.e.l(intent, "columnName");
                        int d10 = C7.e.d(intent, "intContent", 0);
                        if ("sub_state".equals(l14) && d10 == 0) {
                            z10 = true;
                        }
                        if (("sub_state".equals(l14) && d10 == 1) || z10) {
                            ViewOnClickListenerC0694u0.this.f17439m.removeMessages(83);
                            ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(83, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if ("android.telephony.action.CARRIER_CONFIG_CHANGED".equals(action)) {
                if (ViewOnClickListenerC0694u0.this.isAdded() && (view = ViewOnClickListenerC0694u0.this.f17465w0) != null && view.getVisibility() == 0) {
                    ViewOnClickListenerC0694u0.this.P6(true, true);
                    return;
                }
                return;
            }
            if (TextUtils.equals(C1498a.f36265x, action)) {
                String l15 = C7.e.l(intent, "simstate");
                ViewOnClickListenerC0694u0.log("sim state has changed state = " + l15);
                if ("PLUGIN".equals(l15) || "PLUGOUT".equals(l15)) {
                    ViewOnClickListenerC0694u0.this.f17395V = true;
                    ViewOnClickListenerC0694u0.this.f17439m.removeMessages(83);
                    ViewOnClickListenerC0694u0.this.f17439m.sendEmptyMessageDelayed(83, 1000L);
                }
            }
        }

        public z() {
        }
    }

    public static /* synthetic */ boolean B5(View view, MotionEvent motionEvent) {
        log("dialBtnPanel::onTouch");
        return true;
    }

    public static /* synthetic */ boolean C5(View view, MotionEvent motionEvent) {
        H7.b.b("DialtactsFragment", "mDialpadNum::onTouch");
        return true;
    }

    public void F7() {
        com.android.contacts.calllog.r rVar = this.f17443n0;
        if (rVar != null) {
            rVar.r();
        }
    }

    public void I3() {
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null && dialEditText.getText() != null) {
            this.f17433k.getText().clear();
        }
    }

    public void J6() {
        if (!this.f17460t1) {
            BaseTitleBehavior baseTitleBehavior = this.f21252f;
            if (baseTitleBehavior != null) {
                baseTitleBehavior.T();
                return;
            }
            return;
        }
        View view = this.f17421e1;
        if (view != null) {
            view.post(new Runnable() { // from class: com.android.contacts.L
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC0694u0.this.R5();
                }
            });
        }
    }

    private void L7() {
        this.f17425g1.q();
    }

    public static DialpadView N4(Context context, DialpadView dialpadView, int i10, com.customize.contacts.startupspeed.a aVar) {
        if (context == null) {
            return null;
        }
        if (dialpadView == null) {
            if (i10 == 1) {
                dialpadView = new DialpadView(context, DialpadView.DialpadMode.STROKE_MODE);
            } else if (i10 == 0) {
                dialpadView = new DialpadView(context, DialpadView.DialpadMode.PINYIN_MODE);
            } else if (i10 == 4) {
                dialpadView = new DialpadView(context, DialpadView.DialpadMode.TAVEN_MODE_EXP);
            } else if (i10 == 5) {
                dialpadView = new DialpadView(context, DialpadView.DialpadMode.VIETNAMESE_MODE_EXP);
            } else if (i10 == 7) {
                dialpadView = new DialpadView(context, DialpadView.DialpadMode.RUSSIAN_MODE_EXP);
            } else if (i10 == 8) {
                dialpadView = new DialpadView(context, DialpadView.DialpadMode.TAIWAN_MODE_EXP);
            } else if (i10 == 9) {
                dialpadView = new DialpadView(context, DialpadView.DialpadMode.UKRAINIAN_MODE_EXP);
            } else {
                dialpadView = new DialpadView(context, DialpadView.DialpadMode.INDONESIAN_MODE_EXP);
            }
            if (aVar != null && aVar.a()) {
                return dialpadView;
            }
        }
        dialpadView.d(aVar);
        return dialpadView;
    }

    private void N7() {
        this.f17425g1.t(this.f17427h1);
    }

    public static boolean W4(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = "";
        }
        if (!"android.intent.action.DIAL".equals(str) && !"android.intent.action.VIEW".equals(str) && !r0.f.d(str)) {
            return false;
        }
        return C7.e.c(intent, TelecomAdapter.ADD_CALL_MODE_KEY, false);
    }

    private void Z6(Intent intent) {
        this.f17419d1 = intent;
    }

    private void b7(boolean z10) {
        BaseTitleBehavior baseTitleBehavior = this.f21252f;
        if (baseTitleBehavior != null) {
            baseTitleBehavior.b0(z10);
        }
    }

    public boolean c5() {
        ContactsTabActivity f42 = f4();
        if (f42 != null && f42.E2()) {
            return true;
        }
        return false;
    }

    private boolean e6(View view) {
        E3.c cVar;
        CheckBox checkBox;
        if (view == null || (cVar = this.f17398W) == null || !cVar.A() || (checkBox = (CheckBox) view.findViewById(R.id.check_box)) == null) {
            return false;
        }
        checkBox.setChecked(!checkBox.isChecked());
        this.f17446o0.h2(((com.android.contacts.calllog.o) view.getTag(R.id.call_log_view_key)).f14008a, true, false);
        return true;
    }

    public ContentResolver g4() {
        if (getActivity() != null) {
            return getActivity().getContentResolver();
        }
        return null;
    }

    private int h4() {
        A0.b bVar = this.f17376O1;
        if (bVar != null) {
            return bVar.c();
        }
        return -1;
    }

    public void k7() {
        int i10;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            i10 = R.string.odialer_app_name;
        } else {
            i10 = R.string.call_title;
        }
        TextView textView = this.f21250d;
        if (textView != null) {
            textView.setText(i10);
        }
        TextView textView2 = this.f17354H0;
        if (textView2 != null) {
            textView2.setText(i10);
        }
    }

    private void l7(boolean z10) {
        ContactsTabActivity f42 = f4();
        if (f42 != null) {
            f42.g3(z10);
        }
    }

    public static void log(String str) {
        H7.b.b("DialtactsFragment", str);
    }

    public boolean n4() {
        return this.f17390T0;
    }

    public View q4() {
        ContactsTabActivity f42 = f4();
        if (f42 != null) {
            return f42.q2();
        }
        return null;
    }

    private void s6(int i10) {
        this.f17425g1.m(i10, this.f17427h1);
    }

    public void t4() {
        this.f17473z.a();
        com.customize.contacts.util.b0.P(this.f17414b1);
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.j2(this.f17473z.b(), com.customize.contacts.util.b0.O());
        }
        if (com.customize.contacts.util.b0.O() != 0 && this.f17473z.c() != com.customize.contacts.util.b0.O() && this.f17446o0 != null) {
            F7();
        }
        this.f17439m.post(new M(this));
    }

    private boolean y4(int i10) {
        com.android.contacts.dialpad.g gVar = this.f17366L0;
        if (gVar != null) {
            return gVar.m(i10, l4());
        }
        return false;
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior.b
    public void A(ViewGroup viewGroup, int i10) {
        ScrollRelativeLayout scrollRelativeLayout = this.f17356I;
        if (scrollRelativeLayout != null && scrollRelativeLayout.b()) {
            return;
        }
        View view = this.f17465w0;
        if (view != null && view.getVisibility() == 0) {
            return;
        }
        a7(i10);
        if (i10 != 0) {
            D4();
            if (!this.f17460t1 && this.f17383R) {
                d7(true);
                s7(false);
                d7(false);
            }
        }
        if (i10 != 1 && i10 != 2) {
            E3.q qVar = this.f17410a0;
            if (qVar != null) {
                qVar.v();
            }
            E3.o oVar = this.f17413b0;
            if (oVar != null) {
                oVar.j();
            }
            com.android.contacts.calllog.k kVar = this.f17446o0;
            if (kVar != null) {
                kVar.N1(false);
                return;
            }
            return;
        }
        if (d5()) {
            E3.q qVar2 = this.f17410a0;
            if (qVar2 != null) {
                qVar2.s();
            }
            E3.o oVar2 = this.f17413b0;
            if (oVar2 != null) {
                oVar2.g();
            }
        }
        com.android.contacts.calllog.k kVar2 = this.f17446o0;
        if (kVar2 != null) {
            kVar2.N1(true);
        }
    }

    public void A4(boolean z10) {
        H7.b.b("DialtactsFragment", "hideDialPadAnimation");
        if (this.f17353H.n()) {
            Log.i("DialtactsFragment", "HideDialPad animation is running");
            return;
        }
        if (this.f17460t1) {
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "hideDialPadAnimation but mIsShowUnfoldScreen");
            }
        } else {
            if (f4() == null) {
                return;
            }
            this.f17353H.g(new l());
            O4();
            if (this.f17450p1 != null) {
                boolean c52 = c5();
                if (c52) {
                    j8();
                }
                this.f17353H.l(this.f17356I, this.f17458s1, this.f17450p1, z10, c52);
                h8(false, true);
            }
        }
    }

    public final /* synthetic */ void A5(final ContactsTabActivity contactsTabActivity) {
        final CharSequence charSequence;
        final CharSequence charSequence2;
        final boolean d10 = com.android.contacts.framework.baseui.util.l.d(contactsTabActivity, "com.ted.number");
        String str = C1501d.f36275d;
        final boolean d11 = com.android.contacts.framework.baseui.util.l.d(contactsTabActivity, str);
        if (!d10) {
            charSequence = "";
        } else {
            charSequence = com.android.contacts.framework.baseui.util.l.b(contactsTabActivity, "com.ted.number");
        }
        if (!d11) {
            charSequence2 = "";
        } else {
            charSequence2 = com.android.contacts.framework.baseui.util.l.b(contactsTabActivity, str);
        }
        this.f17439m.post(new Runnable() { // from class: com.android.contacts.f0
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.z5(d10, contactsTabActivity, charSequence, d11, charSequence2);
            }
        });
    }

    public final void A6() {
        this.f17444n1.removeCallbacksAndMessages(null);
        this.f17444n1.sendEmptyMessageDelayed(0, 1000L);
        this.f17444n1.sendEmptyMessageDelayed(1, 1000L);
        this.f17444n1.sendEmptyMessage(3);
    }

    public final void A7() {
        String str;
        if (!TextUtils.isEmpty(this.f17408Z0)) {
            str = PhoneNumberUtils.formatNumber(this.f17408Z0, C1074c.b(d4()));
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            W6(this.f17408Z0);
        } else {
            W6(str);
        }
        V6(false);
    }

    public final void B4() {
        if (this.f17383R) {
            A4(true);
        }
    }

    public final void B6() {
        try {
            requireActivity().getContentResolver().registerContentObserver(Settings.Global.getUriFor(R0.b.f3169c), false, this.f17406Y1);
            DisplayUtil.u(getContext(), this.f17412a2);
        } catch (Exception e10) {
            H7.b.c("DialtactsFragment", "" + e10);
        }
    }

    public final void B7() {
        if (!isAdded()) {
            return;
        }
        new COUIAlertDialogBuilder(requireActivity()).setTitle(R.string.sim_card_unavailable_voilcemail).setPositiveButton(R.string.oplus_know, (DialogInterface.OnClickListener) null).show();
    }

    public final void C3() {
        String v42 = v4(this.f17357I0);
        log("callVoicemail--number=" + H7.a.d(v42));
        if (TextUtils.isEmpty(v42)) {
            D7(this.f17357I0);
        } else if (B3.a.R()) {
            log("Mtk place call voice number :  ,mVoiceMailSlotId = " + this.f17357I0);
            Intent intent = new Intent(f17329c2, Uri.fromParts("tel", v42, null));
            t6(intent, this.f17357I0);
            intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            R7.b.d(getActivity(), intent, R.string.activity_not_found);
        } else {
            R7.b.d(getActivity(), b6(), R.string.activity_not_found);
        }
        I3();
    }

    public final void C4() {
        DialerHeaderViewManager dialerHeaderViewManager = this.f17418d0;
        if (dialerHeaderViewManager != null) {
            dialerHeaderViewManager.J();
        }
    }

    public final void C6(int i10) {
        BroadcastReceiver broadcastReceiver;
        IntentFilter intentFilter;
        switch (i10) {
            case 1:
                if (this.f17335B == null) {
                    this.f17335B = new z();
                }
                broadcastReceiver = this.f17335B;
                intentFilter = new IntentFilter();
                C0811w.j(getActivity(), broadcastReceiver, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
                intentFilter.addAction("android.intent.action.SIM_SETTING_INFO_CHANGED");
                intentFilter.addAction(C1498a.f36264w);
                intentFilter.addAction("android.intent.action.ACTION_SUBINFO_CONTENT_CHANGE");
                intentFilter.addAction("org.codeaurora.intent.action.ACTION_DDS_SWITCH_DONE");
                intentFilter.addAction("android.telephony.action.CARRIER_CONFIG_CHANGED");
                intentFilter.addAction(C1498a.f36265x);
                break;
            case 2:
                if (this.f17338C == null) {
                    this.f17338C = new D();
                }
                BroadcastReceiver broadcastReceiver2 = this.f17338C;
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("com.oplus.contacts.display_settings_changed");
                intentFilter2.addAction("com.oplus.contacts.DETAIL_UPDATE_DONE");
                intentFilter2.addAction("com.oplus.contacts.HANDLE_VIP_FINISHED");
                intentFilter2.addAction("oplus.intent.action.calllog.clear_catch");
                intentFilter2.addAction("com.oplus.contacts.force_refresh_calllog");
                intentFilter2.addAction("contacts.intent.action.SIM_STATE_CHANGED_LOCAL");
                try {
                    X.a.b(requireActivity()).c(broadcastReceiver2, intentFilter2);
                    return;
                } catch (Exception e10) {
                    H7.b.c("DialtactsFragment", "Exception: " + e10);
                    return;
                }
            case 3:
                if (this.f17341D == null) {
                    this.f17341D = new r();
                }
                broadcastReceiver = this.f17341D;
                intentFilter = new IntentFilter();
                r0.f.a(intentFilter);
                break;
            case 4:
                if (this.f17350G == null) {
                    this.f17350G = new E();
                }
                broadcastReceiver = this.f17350G;
                intentFilter = new IntentFilter();
                intentFilter.addAction(C1498a.f36266y);
                break;
            case 5:
                if (this.f17344E == null) {
                    this.f17344E = new A();
                }
                broadcastReceiver = this.f17344E;
                intentFilter = new IntentFilter("android.intent.action.SPECIALNUM_UPDATE_COMPLETE");
                break;
            case 6:
                if (this.f17347F == null) {
                    this.f17347F = new B();
                }
                broadcastReceiver = this.f17347F;
                intentFilter = new IntentFilter(com.customize.contacts.util.k0.f22140d);
                intentFilter.setPriority(10);
                break;
            default:
                return;
        }
        try {
            E6(broadcastReceiver, intentFilter);
        } catch (Exception e11) {
            H7.b.c("DialtactsFragment", "Exception: " + e11);
        }
    }

    public final void C7() {
        int c10 = this.f17473z.c();
        if (c10 < 2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        final List<SubscriptionInfo> e10 = this.f17473z.e();
        if (e10 == null) {
            return;
        }
        if (e10.size() == c10) {
            for (int i10 = 0; i10 < c10; i10++) {
                arrayList.add(String.format(getResources().getString(R.string.oplus_use_sim_x_to_call), e10.get(i10).getDisplayName().toString()));
            }
        }
        new U0.b(requireActivity(), 2132083073).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.android.contacts.J
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                ViewOnClickListenerC0694u0.this.W5(e10, dialogInterface, i11);
            }
        }).show();
    }

    @Override // A0.a
    public void D0(View view) {
        onClick(view);
    }

    public void D3() {
        if (getActivity() == null) {
            return;
        }
        N7.a.b().execute(new Runnable() { // from class: com.android.contacts.d0
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.v5();
            }
        });
    }

    public final void D4() {
        if (m5()) {
            this.f17405Y0.setVisibility(8);
            this.f17438l1.setVisibility(8);
            u8();
            J6();
            if (this.f17460t1) {
                i8();
            } else {
                t8(true);
            }
            View view = this.f21249c;
            if (view != null) {
                view.setVisibility(0);
            }
            M6();
            T6(false);
        }
    }

    public final /* synthetic */ boolean D5(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            } else {
                if (!d5()) {
                    V6(true);
                    if (this.f17433k.getSelectionStart() == this.f17433k.getSelectionEnd() && !this.f17383R && !e5()) {
                        s7(true);
                    }
                }
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
        view.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    public void D6(Context context) {
        try {
            if (B3.a.i()) {
                D7.c.l(context, this.f17343D1, 33, 0);
                D7.c.l(context, this.f17346E1, 33, 1);
            } else {
                ((TelephonyManager) context.getSystemService("phone")).listen(this.f17343D1, 33);
            }
        } catch (Throwable th) {
            H7.b.c("DialtactsFragment", "registerListener error" + th);
        }
    }

    public final void D7(final int i10) {
        if (!isAdded()) {
            return;
        }
        new COUIAlertDialogBuilder(requireActivity()).setTitle(R.string.no_voice_mail_tips).setPositiveButton(R.string.oplus_button_set, new DialogInterface.OnClickListener() { // from class: com.android.contacts.W
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                ViewOnClickListenerC0694u0.this.X5(i10, dialogInterface, i11);
            }
        }).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    public final void E3(int i10) {
        DialpadView dialpadView;
        if (getActivity() != null && (dialpadView = this.f17457s0) != null) {
            if (i10 == 1) {
                dialpadView.a(DialpadView.DialpadMode.STROKE_MODE);
            } else if (i10 == 0) {
                dialpadView.a(DialpadView.DialpadMode.PINYIN_MODE);
            } else if (i10 == 4) {
                dialpadView.a(DialpadView.DialpadMode.TAVEN_MODE_EXP);
            } else if (i10 == 5) {
                dialpadView.a(DialpadView.DialpadMode.VIETNAMESE_MODE_EXP);
            } else if (i10 == 7) {
                dialpadView.a(DialpadView.DialpadMode.RUSSIAN_MODE_EXP);
            } else if (i10 == 8) {
                dialpadView.a(DialpadView.DialpadMode.TAIWAN_MODE_EXP);
            } else if (i10 == 9) {
                dialpadView.a(DialpadView.DialpadMode.UKRAINIAN_MODE_EXP);
            } else {
                dialpadView.a(DialpadView.DialpadMode.INDONESIAN_MODE_EXP);
            }
            if (!d5() && !this.f17383R) {
                s7(true);
            }
        }
    }

    public final void E4() {
        if (m5()) {
            Z3.f.m(this.f17405Y0, new Runnable() { // from class: com.android.contacts.H
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC0694u0.this.D4();
                }
            });
        }
    }

    public final /* synthetic */ void E5(Throwable th, int i10) {
        if (ThreadUtilsKt.b()) {
            synchronized (this.f17385R1) {
                try {
                    if (i10 >= 30) {
                        H7.b.c("DialtactsFragment", "CursorExceptionListener: count: " + i10 + ";stack = " + Log.getStackTraceString(th));
                        if (!f17330d2) {
                            f17330d2 = true;
                            com.android.contacts.util.m.a(getContext(), "DialCursorException: throwable: \n " + Log.getStackTraceString(th));
                        }
                        return;
                    }
                    int i11 = this.f17382Q1;
                    if (i10 >= i11) {
                        this.f17382Q1 = i11 + 1;
                        h();
                    } else {
                        H7.b.c("DialtactsFragment", "CursorExceptionListener: count: " + i10 + ";mCursorErrorCount = " + this.f17382Q1);
                    }
                    return;
                } finally {
                }
            }
        }
        H7.b.c("DialtactsFragment", "CursorExceptionListener: count: " + i10 + ";stack = " + Log.getStackTraceString(th));
    }

    public final void E6(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(broadcastReceiver, intentFilter, R0.b.f3175i, null, 2);
        }
    }

    public final void E7(final boolean z10) {
        if (getActivity() != null && B3.a.i()) {
            this.f17473z.i(getActivity(), null, new Runnable() { // from class: com.android.contacts.c0
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC0694u0.this.Z5(z10);
                }
            });
        }
    }

    public void F3() {
        try {
            if (this.f17333A0 == null) {
                return;
            }
            if (this.f17370M1.g() == 1) {
                this.f17333A0.setImageResource(R.drawable.pb_ic_search_tips_strokes);
                this.f17339C0.setVisibility(8);
                this.f17342D0.setVisibility(8);
                this.f17336B0.setVisibility(8);
                this.f17333A0.setVisibility(0);
            } else {
                String a10 = com.customize.contacts.util.K.a();
                if (!a10.startsWith("zh-Hans") && !a10.equalsIgnoreCase("zh-CN")) {
                    this.f17342D0.setText(R.string.intelligent_dial_tips);
                    this.f17339C0.setText(P0.a(requireContext()));
                    this.f17339C0.setVisibility(0);
                    this.f17342D0.setVisibility(0);
                    this.f17336B0.setVisibility(0);
                    this.f17333A0.setVisibility(8);
                }
                this.f17333A0.setImageResource(R.drawable.pb_ic_search_tips_cn);
                this.f17339C0.setVisibility(8);
                this.f17342D0.setVisibility(8);
                this.f17336B0.setVisibility(8);
                this.f17333A0.setVisibility(0);
            }
        } catch (Exception e10) {
            H7.b.c("DialtactsFragment", "changeTheDialpadTips: " + e10);
        }
    }

    public void F4() {
        e8(false);
    }

    public final /* synthetic */ void F5(Boolean bool) {
        H7.b.e("DialtactsFragment", "OnChange: online: " + bool);
        this.f17439m.post(new M(this));
    }

    public final void F6() {
        E0.b.D();
        E0.b.f();
    }

    @Override // com.android.contacts.dialpad.view.DialpadView.a
    public boolean G() {
        return this.f17383R;
    }

    public final void G3() {
        if (f4() != null && this.f17416c0 != null && this.f17446o0 != null) {
            if (B3.a.b0()) {
                this.f17446o0.D();
            } else if (this.f17416c0.getAlpha() == 1.0f) {
                this.f17446o0.D();
            }
        }
    }

    public View G4(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.key_dialer_layout, viewGroup, false);
    }

    public final /* synthetic */ void G5(Boolean bool) {
        boolean p10 = CallRecordingsCache.f15754a.p();
        H7.b.e("DialtactsFragment", "Call recordings loaded: " + bool + ", hasChanged: " + p10);
        if (p10) {
            this.f17439m.post(new RunnableC0661p0(this));
        }
    }

    public void G6(Context context) {
        try {
            if (B3.a.i()) {
                x xVar = this.f17343D1;
                if (xVar != null) {
                    D7.c.l(context, xVar, 0, 0);
                }
                x xVar2 = this.f17346E1;
                if (xVar2 != null) {
                    D7.c.l(context, xVar2, 0, 1);
                    return;
                }
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            x xVar3 = this.f17343D1;
            if (xVar3 != null) {
                telephonyManager.listen(xVar3, 0);
            }
        } catch (Throwable th) {
            H7.b.c("DialtactsFragment", "removeAllListener error" + th);
        }
    }

    public void G7(Intent intent) {
        R7.b.d(getContext(), intent, R.string.activity_not_found);
    }

    public final void H3() {
        this.f17423f1.execute(new Runnable() { // from class: com.android.contacts.X
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.w5();
            }
        });
        if (!this.f17445o) {
            this.f17370M1.j(getContext());
        }
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.D1(this.f17370M1.g());
            Boolean D10 = StartupSpeedHelper.D();
            if (D10 == null) {
                boolean z10 = false;
                if (G0.c.d(getContext(), 0, "not_requery_ted_mark_info", 0) == 1) {
                    z10 = true;
                }
                D10 = Boolean.valueOf(z10);
            }
            this.f17446o0.K1(D10.booleanValue());
        }
    }

    public void H4() {
        ViewStub viewStub = (ViewStub) X3(R.id.add_contact_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.f17465w0 = X3(R.id.add_contact_content);
        this.f17468x0 = (MainPercentWidthLayout) X3(R.id.percent_layout);
        View X32 = X3(R.id.video_call);
        this.f17463v0 = X32;
        X32.setOnClickListener(this);
        X3(R.id.add_new_contact).setOnClickListener(this);
        X3(R.id.add_old_contact).setOnClickListener(this);
        T7();
    }

    public final /* synthetic */ void H5(Integer num) {
        E3(num.intValue());
        F3();
        y6();
    }

    public final void H6() {
        m4().setType(null);
    }

    public void H7(String str) {
        S7.b.b(this, O3(str), 666, 0);
    }

    public void I4() {
        J4(false);
    }

    public final /* synthetic */ void I5(com.android.contacts.calllog.G g10, Context context, boolean z10, com.android.contacts.calllog.o oVar, int i10, int i11) {
        Intent b10 = g10.b(context);
        if (b10 != null) {
            if (z10) {
                m6(b10, oVar, i10, i11);
                return;
            } else {
                n6(b10, i10);
                return;
            }
        }
        H7.b.i("DialtactsFragment", "onItemClick: no intent!");
    }

    public final void I6(String str) {
        if (!this.f17375O0) {
            return;
        }
        if (TextUtils.isEmpty(this.f17378P0) || TextUtils.isEmpty(str) || this.f17378P0.length() != str.length()) {
            this.f17375O0 = false;
            this.f17378P0 = null;
        }
    }

    public final void I7(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = a4(str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] a10 = com.android.contacts.dialpad.a.a();
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "startQueryContacts: length = " + a10.length);
        }
        Uri b10 = com.android.contacts.dialpad.d.b(this.f17370M1.g(), str);
        boolean c10 = com.android.contacts.dialpad.d.c(this.f17370M1.g());
        if (this.f17440m0 == null) {
            this.f17440m0 = new y(this);
        }
        this.f17440m0.h(true);
        this.f17440m0.g(c10);
        this.f17440m0.c(0);
        this.f17440m0.i(0, null, b10, a10, null, null, null);
    }

    public void J3() {
        I3();
        if (!this.f17383R) {
            r7();
        }
    }

    public void J4(boolean z10) {
        DateFormat timeFormat;
        log("initCallLogAdapter ");
        com.android.contacts.calllog.k kVar = new com.android.contacts.calllog.k(getActivity(), this, new com.android.contacts.calllog.A(getActivity(), null), this.f17473z.b(), com.customize.contacts.util.b0.O(), this.f17353H);
        this.f17446o0 = kVar;
        kVar.G(z10);
        this.f17410a0 = new E3.q(getActivity(), "");
        this.f17413b0 = new E3.o(requireActivity());
        this.f17446o0.O1(this.f17410a0);
        this.f17446o0.I1(this.f17413b0);
        this.f17446o0.D1(this.f17370M1.g());
        if (StartupSpeedHelper.y() != null && StartupSpeedHelper.y().equals(getResources().getConfiguration().locale)) {
            timeFormat = StartupSpeedHelper.u();
        } else {
            timeFormat = android.text.format.DateFormat.getTimeFormat(getActivity());
        }
        this.f17446o0.U1(timeFormat);
        this.f17446o0.E1(F7.b.e(getActivity()));
    }

    public final /* synthetic */ void J5() {
        try {
            Cursor query = d4().getContentResolver().query(R0.d.f3220g, null, "1<>1", null, null);
            try {
                if (H7.a.b()) {
                    H7.b.b("DialtactsFragment", "Start blacklist app process.");
                }
                if (query != null) {
                    query.close();
                }
            } finally {
            }
        } catch (Exception e10) {
            H7.b.c("DialtactsFragment", "Exception e: " + e10);
        }
    }

    public void J7() {
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.T1(false);
            this.f17446o0.f2(true);
        }
    }

    @Override // w7.b
    public void K(int i10, int i11, List<? extends View> list) {
        Iterator<? extends View> it = list.iterator();
        while (it.hasNext()) {
            e6(it.next());
        }
    }

    public void K3() {
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null) {
            dialEditText.clearFocus();
        }
    }

    public final void K4() {
        CallLogPreload h22;
        if (B3.a.b0()) {
            V4();
            return;
        }
        if (this.f17420e0) {
            this.f17420e0 = false;
            HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
            if (headerFooterRecyclerView != null) {
                headerFooterRecyclerView.setAlpha(0.0f);
            }
        } else {
            F7();
        }
        ContactsTabActivity f42 = f4();
        if (f42 != null && (h22 = f42.h2()) != null) {
            h22.e(this);
        }
    }

    public final /* synthetic */ void K5() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            G6(activity);
        }
    }

    public final void K6() {
        if (this.f17431j0 && this.f17396V0 <= 0 && d5()) {
            J6();
        }
    }

    public void K7() {
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
        if (headerFooterRecyclerView != null) {
            headerFooterRecyclerView.onWindowFocusChanged(false);
        }
    }

    @Override // com.android.contacts.calllog.r.b
    public void L(Cursor cursor) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            com.oplus.foundation.util.io.e.a(cursor);
        }
    }

    public final void L3() {
        if (!i5()) {
            Q4();
        }
        LinearLayout linearLayout = this.f17405Y0;
        if (linearLayout != null) {
            Z3.f.m(linearLayout, new Runnable() { // from class: com.android.contacts.F
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC0694u0.this.A7();
                }
            });
        } else {
            A7();
        }
        M6();
    }

    public final void L4() {
        if (this.f17416c0 != null || getActivity() == null) {
            return;
        }
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) X3(R.id.list);
        this.f17416c0 = headerFooterRecyclerView;
        if (headerFooterRecyclerView == null) {
            return;
        }
        this.f21252f.c0(this);
        this.f17436l.T0(requireActivity(), this.f17416c0, null);
        this.f17416c0.setNestedScrollingEnabled(true);
        this.f17416c0.setItemAnimator(null);
        this.f17416c0.setTag(this.f17421e1);
        this.f17416c0.setFadingEdgeLength(0);
        this.f17416c0.setScrollBarStyle(33554432);
        this.f17416c0.setDragSelectListener(this);
        p pVar = new p(getContext());
        this.f17379P1 = pVar;
        this.f17416c0.setLayoutManager(pVar);
        this.f17416c0.setAdapter(this.f17446o0);
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.H(this.f17416c0);
        }
    }

    public final /* synthetic */ void L5(String str) {
        this.f17418d0.v0(getContext(), str);
    }

    public final void L6() {
        if (this.f17433k == null) {
            return;
        }
        String l42 = l4();
        if (!TextUtils.isEmpty(l42)) {
            log("onResume mEditBeforeDial=" + this.f17369M0 + ", text = " + H7.a.d(l42) + ", mDialpadIsShow = " + this.f17383R);
            if (this.f17369M0) {
                this.f17433k.setSelection(l42.length());
                V6(true);
                this.f17433k.requestFocus();
                t8(false);
                if (!this.f17383R && !o5()) {
                    r7();
                }
            }
        }
    }

    public final void M3(Intent intent) {
        if (!W4(intent)) {
            log("configureScreenFromIntent digitsFilled: " + W3(intent));
        }
    }

    public final void M4() {
        if (this.f17457s0 == null) {
            this.f17370M1.j(getActivity());
            this.f17457s0 = N4(getContext(), null, this.f17370M1.g(), null);
        }
        ScrollRelativeLayout scrollRelativeLayout = (ScrollRelativeLayout) X3(R.id.dialpad_container);
        this.f17356I = scrollRelativeLayout;
        scrollRelativeLayout.setListener(new o());
        f8();
        this.f17367L1 = (DialpadBottomView) X3(R.id.dialpad_bottom_sub_container);
        ((LinearLayout) X3(R.id.dial_btn_panel)).setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.T
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean B52;
                B52 = ViewOnClickListenerC0694u0.B5(view, motionEvent);
                return B52;
            }
        });
        A0.b bVar = new A0.b(this, this.f17367L1, this.f17467x);
        this.f17376O1 = bVar;
        bVar.e(this);
        LinearLayout linearLayout = (LinearLayout) X3(R.id.dialpad_upper);
        ImageButton imageButton = (ImageButton) X3(R.id.dial_del);
        this.f17377P = imageButton;
        imageButton.setEnabled(false);
        this.f17377P.setOnClickListener(this);
        this.f17377P.setOnLongClickListener(this);
        ImageButton imageButton2 = (ImageButton) this.f17367L1.findViewById(R.id.dial_hide);
        this.f17380Q = imageButton2;
        imageButton2.setOnClickListener(this);
        linearLayout.addView(this.f17457s0);
        this.f17457s0.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.U
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean C52;
                C52 = ViewOnClickListenerC0694u0.C5(view, motionEvent);
                return C52;
            }
        });
        this.f17457s0.setListener(this);
        this.f17457s0.f(this, this, this);
        log("changeTheDialpad : mDialpadIsShow = " + this.f17383R);
        com.customize.contacts.manager.B b10 = this.f17332A;
        if (b10 != null) {
            b10.m(this);
        }
        o7();
        y6();
    }

    public final /* synthetic */ void M5() {
        final String a10 = P7.d.a(d4());
        this.f17439m.post(new Runnable() { // from class: com.android.contacts.O
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.L5(a10);
            }
        });
    }

    public final void M6() {
        SharedPreferences sharedPreferences = this.f17414b1;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_timestamp", this.f17411a1).apply();
        }
    }

    public void M7() {
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.T1(true);
            this.f17446o0.g2();
        }
    }

    public final void N3() {
        this.f17366L0.p();
        this.f17366L0.o(new C0697c());
    }

    public final /* synthetic */ void N5() {
        com.android.contacts.calllog.I U02;
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null && (U02 = kVar.U0()) != null) {
            U02.l(getContext());
        }
    }

    public void N6() {
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "scrollCallLogListToPosition");
        }
    }

    public Intent O3(String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra("phone", str);
        intent.putExtra(R0.c.f3183a, true);
        intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        if (C0637b.h()) {
            intent.putExtra("edit_page_start_source", 2);
        }
        return intent;
    }

    public final void O4() {
        ContactsTabActivity f42;
        if (this.f17450p1 == null && (f42 = f4()) != null) {
            this.f17450p1 = f42.j2();
            this.f17453q1 = f42.getDrawable(R.drawable.pb_ic_floating_dial_show);
            this.f17456r1 = f42.getString(R.string.show_dialpad_description);
        }
    }

    public final /* synthetic */ void O5() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            D6(activity);
        }
    }

    public void O6(Z3.a aVar) {
        this.f17429i1 = aVar;
    }

    public final void O7() {
        com.android.contacts.dialpad.c cVar = this.f17425g1;
        if (cVar != null) {
            cVar.s();
        }
    }

    public void P3(int i10) {
        this.f17396V0 -= i10;
    }

    public final void P4() {
        int i10;
        FloatingTabView floatingTabView = (FloatingTabView) this.f17421e1.findViewById(R.id.floating_tabview);
        this.f17351G0 = floatingTabView;
        if (floatingTabView != null) {
            int e10 = R7.d.e(this.f17414b1, "cache_key_call_log_count", 0);
            FloatingTabView floatingTabView2 = this.f17351G0;
            if (e10 > 0) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            floatingTabView2.setVisibility(i10);
            String string = getString(R.string.all_call_v2);
            int i11 = R.id.tab_all_call;
            FloatingTabView.e eVar = new FloatingTabView.e(R.id.tab_all_call, string);
            FloatingTabView.e eVar2 = new FloatingTabView.e(R.id.tab_missed_call, getString(R.string.missed_call_v2));
            this.f17351G0.setTabTouchAnimator(false);
            this.f17351G0.setTabData(com.google.common.collect.n.i(eVar, eVar2));
            this.f17351G0.setOnTabSelectedListener(new h());
            com.android.contacts.calllog.k kVar = this.f17446o0;
            if (kVar != null) {
                FloatingTabView floatingTabView3 = this.f17351G0;
                if (kVar.A()) {
                    i11 = R.id.tab_missed_call;
                }
                floatingTabView3.t(i11, false);
                return;
            }
            this.f17351G0.t(R.id.tab_all_call, false);
        }
    }

    public final /* synthetic */ void P5() {
        View view;
        if (!this.f17460t1 && (view = this.f17438l1) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != this.f21251e.getMeasuredHeight()) {
                if (H7.a.b()) {
                    H7.b.b("DialtactsFragment", "AppBar MeasureListener PasteDigitTopMargin = " + marginLayoutParams.topMargin + ";appBarHeight = " + this.f21251e.getMeasuredHeight());
                }
                marginLayoutParams.topMargin = this.f21251e.getMeasuredHeight();
                this.f17438l1.setLayoutParams(marginLayoutParams);
            }
            i8();
        }
    }

    public final void P6(boolean z10, boolean z11) {
        int i10;
        View view;
        if (!isAdded()) {
            return;
        }
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        if (!z11 && (view = this.f17465w0) != null && view.getVisibility() == i10) {
            log("--setAddContactsLayoutVisible return--");
            return;
        }
        View view2 = this.f17465w0;
        if (view2 != null) {
            view2.setVisibility(i10);
        } else if (z10) {
            H4();
        }
        if (z10) {
            if (PrimaryUserUtils.a() && !VirtualSupportUtils.m()) {
                final Context applicationContext = requireContext().getApplicationContext();
                final ArrayList arrayList = new ArrayList(this.f17473z.d());
                N7.a.b().execute(new Runnable() { // from class: com.android.contacts.Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC0694u0.this.T5(applicationContext, arrayList);
                    }
                });
                return;
            }
            this.f17463v0.setVisibility(8);
        }
    }

    public final void P7() {
        try {
            requireActivity().getContentResolver().unregisterContentObserver(this.f17406Y1);
        } catch (Exception e10) {
            H7.b.c("DialtactsFragment", "unregisterDialpadContentObserver" + e10);
        }
        try {
            DisplayUtil.w(getContext(), this.f17412a2);
        } catch (Exception e11) {
            H7.b.c("DialtactsFragment", "unregisterParallelWindowModeObserver" + e11);
        }
    }

    public void Q3() {
        ContactsTabActivity f42 = f4();
        if (f42 != null && !f42.isFinishing() && f42.E2()) {
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "delayCancelMissCall() CANCEL_MISSED_CALL_NOTIFICATION");
            }
            this.f17439m.removeMessages(84);
            this.f17439m.sendEmptyMessageDelayed(84, COUIScrollBar.SCROLLER_FADE_TIMEOUT);
        }
    }

    public void Q4() {
        ViewStub viewStub = (ViewStub) this.f17438l1.findViewById(R.id.digits_container_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.f17459t0 = (LinearLayout) this.f17438l1.findViewById(R.id.digits_container);
        this.f17461u0 = this.f17438l1.findViewById(R.id.bottom_divider_line);
        DialEditText dialEditText = (DialEditText) this.f17438l1.findViewById(R.id.normal_input);
        this.f17433k = dialEditText;
        dialEditText.setShowSoftInputOnFocus(false);
        TextView textView = (TextView) this.f17438l1.findViewById(R.id.new_contact_location);
        this.f17455r0 = textView;
        com.oplus.foundation.util.ui.d.d(textView, 2);
        this.f17433k.setKeyListener(new v());
        this.f17433k.addTextChangedListener(this);
        this.f17433k.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.G
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D52;
                D52 = ViewOnClickListenerC0694u0.this.D5(view, motionEvent);
                return D52;
            }
        });
        C1074c.d(getActivity(), this.f17433k);
        LinearLayout linearLayout = this.f17459t0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        m8();
    }

    public final /* synthetic */ void Q5() {
        com.android.contacts.calllog.k kVar;
        if (isAdded() && (kVar = this.f17446o0) != null) {
            kVar.f1();
            this.f17446o0.D();
        }
    }

    public final void Q6() {
        if (this.f17461u0 != null && !A7.a.a()) {
            this.f17461u0.setAlpha(0.0f);
        }
    }

    public final void Q7(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null && getActivity() != null) {
            try {
                getActivity().unregisterReceiver(broadcastReceiver);
            } catch (Exception e10) {
                H7.b.c("DialtactsFragment", "IllegalArgumentException: " + e10);
            }
        }
    }

    public final void R3(View view) {
        if (!i5()) {
            Q4();
        }
        if (view != null) {
            view.setSoundEffectsEnabled(true);
        }
        s5(67);
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null) {
            dialEditText.requestFocus();
            if (j4() == 0) {
                V6(false);
            } else if (this.f17433k.getSelectionStart() == this.f17433k.getSelectionEnd() && this.f17433k.getSelectionStart() != l4().length()) {
                V6(true);
            }
        }
    }

    public void R4() {
        ViewStub viewStub;
        if (this.f17462u1 == null && (viewStub = (ViewStub) X3(R.id.no_content_stub)) != null) {
            viewStub.inflate();
            EmptyViewGroup emptyViewGroup = (EmptyViewGroup) X3(R.id.no_content_layout);
            this.f17462u1 = emptyViewGroup;
            if (emptyViewGroup != null) {
                this.f17345E0 = (TextView) emptyViewGroup.findViewById(R.id.empty_view);
            }
        }
    }

    public final /* synthetic */ void R5() {
        BaseTitleBehavior baseTitleBehavior = this.f21252f;
        if (baseTitleBehavior != null) {
            baseTitleBehavior.T();
        }
    }

    public final void R6() {
        boolean z10;
        if (this.f17380Q != null) {
            A0.b bVar = this.f17376O1;
            boolean z11 = true;
            int i10 = 0;
            if (bVar != null && !bVar.d()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!this.f17460t1 && !z10) {
                z11 = false;
            }
            ImageButton imageButton = this.f17380Q;
            if (z11) {
                i10 = 8;
            }
            imageButton.setVisibility(i10);
            H7.b.e("DialtactsFragment", "setBottomShowBtnState: alwaysHide: " + z11 + ", " + this.f17460t1 + ", " + z10);
        }
    }

    public final void R7(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                X.a.b(requireActivity()).e(broadcastReceiver);
            } catch (IllegalArgumentException e10) {
                H7.b.c("DialtactsFragment", "IllegalArgumentException: " + e10);
            }
        }
    }

    public boolean S3() {
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null && kVar.f13908I) {
            return true;
        }
        return false;
    }

    public final void S4() {
        if (!this.f17383R) {
            return;
        }
        W6("");
        LinearLayout linearLayout = this.f17459t0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ViewStub viewStub = (ViewStub) this.f17438l1.findViewById(R.id.paste_container_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        LinearLayout linearLayout2 = (LinearLayout) this.f17438l1.findViewById(R.id.paste_container);
        this.f17405Y0 = linearLayout2;
        linearLayout2.setVisibility(0);
        this.f17438l1.setVisibility(0);
        u8();
        if (!this.f17460t1) {
            t8(false);
            View view = this.f21249c;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        LinearLayout linearLayout3 = (LinearLayout) this.f17438l1.findViewById(R.id.paste_number_container);
        COUIEditText cOUIEditText = (COUIEditText) this.f17438l1.findViewById(R.id.paste_input);
        ImageView imageView = (ImageView) this.f17438l1.findViewById(R.id.paste_del);
        float f10 = this.f17389T.getDisplayMetrics().density;
        if (!TextUtils.isEmpty(this.f17408Z0)) {
            if (this.f17408Z0.length() > 12 && this.f17408Z0.length() <= 17) {
                cOUIEditText.setTextSize(1, (int) ((this.f17389T.getDimensionPixelSize(R.dimen.DP_22) / f10) + 0.5f));
            } else if (this.f17408Z0.length() > 17) {
                cOUIEditText.setTextSize(1, (int) ((this.f17389T.getDimensionPixelSize(R.dimen.DP_20) / f10) + 0.5f));
            } else {
                cOUIEditText.setTextSize(1, (int) ((this.f17389T.getDimensionPixelSize(R.dimen.DP_25) / f10) + 0.5f));
            }
            cOUIEditText.setText(this.f17408Z0);
        }
        linearLayout3.setOnClickListener(this);
        cOUIEditText.setOnClickListener(this);
        imageView.setOnClickListener(this);
        T6(true);
        com.android.contacts.framework.baseui.util.A.a(d4(), 2000304, 200030214, null, false);
    }

    public final /* synthetic */ void S5(boolean z10) {
        int i10;
        View view = this.f17463v0;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    public void S6(boolean z10) {
        this.f17388S1 = z10;
    }

    public final void S7() {
        com.android.contacts.dialpad.j jVar = this.f17427h1;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // w7.b
    public void T() {
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "onItemDragScrollEnd ---------");
        }
        a7(0);
    }

    public void T3() {
        final ContactsTabActivity f42 = f4();
        if (f42 != null && f42.E2() && a6()) {
            N7.a.b().execute(new Runnable() { // from class: com.android.contacts.Z
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC0694u0.this.A5(f42);
                }
            });
        }
    }

    public void T4() {
        ViewStub viewStub = (ViewStub) X3(R.id.query_contacts_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.f17471y0 = X3(R.id.query_contacts_tip);
        this.f17342D0 = (TextView) X3(R.id.query_contacts_title);
        this.f17339C0 = (TextView) X3(R.id.query_contacts_text);
        this.f17333A0 = (ImageView) X3(R.id.query_contacts_background_cn);
        this.f17336B0 = (ImageView) X3(R.id.query_contacts_background_other);
        this.f17471y0.getViewTreeObserver().addOnGlobalLayoutListener(new q());
    }

    public final /* synthetic */ void T5(Context context, ArrayList arrayList) {
        final boolean z10;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            z10 = com.android.contacts.framework.api.appstore.simcard.a.f(context);
        } else if (com.customize.contacts.util.b0.z0(context, arrayList) && com.customize.contacts.util.b0.i0(context) && !this.f17467x) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f17439m.post(new Runnable() { // from class: com.android.contacts.e0
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.S5(z10);
            }
        });
    }

    public final void T6(boolean z10) {
        ImageButton imageButton = this.f17377P;
        if (imageButton != null) {
            imageButton.setAllowClickWhenDisabled(z10);
        }
    }

    public final void U3() {
        boolean z10 = this.f17475z1;
        if (z10 || this.f17472y1) {
            if (z10) {
                E0.b.b();
                this.f17475z1 = false;
            }
            if (this.f17472y1) {
                E3.q qVar = this.f17410a0;
                if (qVar != null) {
                    qVar.o();
                }
                this.f17472y1 = false;
            }
            G3();
        }
    }

    public final void U4() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.contacts.ust.action.SHOW_SIM_CONTACT_NUMBER");
        this.f17340C1 = new w();
        X.a.b(d4()).c(this.f17340C1, intentFilter);
    }

    public final /* synthetic */ void U5(boolean z10, boolean z11) {
        log("receive mDialpadIsShow onVisibilityChanged, newValue = " + z11);
        if (z11) {
            this.f17386S = null;
            z7();
        }
    }

    public final void U6(boolean z10) {
        boolean z11 = this.f17383R;
        h8(z10, true);
        t tVar = this.f17386S;
        if (tVar != null && z11 != z10) {
            tVar.a(z11, z10);
        }
    }

    public void U7() {
        boolean z10;
        BaseTitleBehavior baseTitleBehavior = this.f21252f;
        if (baseTitleBehavior instanceof PrimaryTitleBehavior) {
            if (baseTitleBehavior.Q() && o5()) {
                z10 = true;
            } else {
                z10 = false;
            }
            ((PrimaryTitleBehavior) this.f21252f).s0(z10);
        }
    }

    public void V3(String str) {
        if (!i5()) {
            Q4();
        }
        W6(str);
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null) {
            dialEditText.requestFocus();
            V6(true);
            this.f17433k.setSelection(j4());
        }
    }

    public final void V4() {
        Cursor G10 = StartupSpeedHelper.G();
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "cursor = " + G10);
        }
        if (G10 == null) {
            CallLogItemCacheManager.f13737c.a().h(requireContext(), true, new CallLogItemCacheManager.a() { // from class: com.android.contacts.S
                @Override // com.android.contacts.calllog.CallLogItemCacheManager.a
                public final void a(MatrixCursor matrixCursor) {
                    ViewOnClickListenerC0694u0.this.Z7(matrixCursor);
                }
            });
        } else {
            Z7(G10);
        }
    }

    public final /* synthetic */ void V5(DialogInterface dialogInterface, int i10) {
        C0792c.r(getActivity());
    }

    public final void V6(boolean z10) {
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null) {
            dialEditText.setCursorVisible(z10);
        }
    }

    public void V7() {
        ContactsTabActivity f42 = f4();
        if (f42 != null && f42.E2()) {
            O4();
            j8();
            if (this.f17450p1 != null) {
                if ((this.f17383R && !this.f17460t1) || ((this.f17460t1 && !this.f17464v1) || e5())) {
                    this.f17450p1.setScaleX(0.0f);
                    this.f17450p1.setScaleY(0.0f);
                    this.f17450p1.setVisibility(8);
                    return;
                } else {
                    this.f17450p1.setScaleX(1.0f);
                    this.f17450p1.setScaleY(1.0f);
                    this.f17450p1.setVisibility(0);
                    return;
                }
            }
            return;
        }
        log("updateBottomViewState:mDialpadIsShow = " + this.f17383R);
    }

    public final boolean W3(Intent intent) {
        Uri data;
        if (intent == null) {
            return false;
        }
        log("fillDigitsIfNecessary->isCallLogIntent = " + Z4(m4()));
        String action = intent.getAction();
        if (("android.intent.action.DIAL".equals(action) || "android.intent.action.VIEW".equals(action) || r0.f.d(action)) && (data = intent.getData()) != null) {
            if ("tel".equals(data.getScheme())) {
                String schemeSpecificPart = data.getSchemeSpecificPart();
                this.f17369M0 = true;
                X6(schemeSpecificPart);
                return true;
            }
            String type = intent.getType();
            if ("vnd.android.cursor.item/person".equals(type) || "vnd.android.cursor.item/phone".equals(type)) {
                try {
                    Cursor query = requireActivity().getContentResolver().query(intent.getData(), new String[]{"number", "number_key"}, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                this.f17369M0 = true;
                                X6(query.getString(0));
                                query.close();
                                return true;
                            }
                        } finally {
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e10) {
                    H7.b.c("DialtactsFragment", "" + e10);
                }
            }
        }
        return false;
    }

    public final /* synthetic */ void W5(List list, DialogInterface dialogInterface, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = 0;
        } else if (1 == i10) {
            i11 = 1;
        } else {
            i11 = 2;
        }
        if (i11 >= list.size()) {
            this.f17357I0 = -1;
        } else {
            this.f17357I0 = ((SubscriptionInfo) list.get(i11)).getSimSlotIndex();
        }
        log("onClick mVoiceMailSlotId=" + this.f17357I0 + " ,mSim1IsUnavailable = " + this.f17473z.f() + " ,mSim2IsUnavailable = " + this.f17473z.g());
        int i12 = this.f17357I0;
        if (i12 != -1 && ((i12 != 0 || !this.f17473z.f()) && (this.f17357I0 != 1 || !this.f17473z.g()))) {
            C3();
        } else {
            B7();
            I3();
        }
    }

    public final void W6(String str) {
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null) {
            dialEditText.setText(str);
        }
    }

    public void W7(boolean z10) {
        int p42;
        if (this.f17416c0 != null) {
            if (this.f17460t1) {
                BaseTitleBehavior baseTitleBehavior = this.f21252f;
                if (baseTitleBehavior != null && baseTitleBehavior.Q()) {
                    p42 = getResources().getDimensionPixelSize(R.dimen.DP_24);
                } else {
                    p42 = p4();
                }
            } else {
                p42 = p4();
            }
            if (p42 != this.f17416c0.getPaddingTop()) {
                if (z10) {
                    H7.b.e("DialtactsFragment", "newIntent updateCallLogRecyclerViewPaddingTop paddingTop: " + p42);
                }
                HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
                headerFooterRecyclerView.setPadding(0, p42, 0, headerFooterRecyclerView.getPaddingBottom());
            }
        }
    }

    public View X3(int i10) {
        View view;
        View view2 = this.f17421e1;
        if (view2 != null) {
            view = view2.findViewById(i10);
        } else {
            view = null;
        }
        if (view == null && getActivity() != null) {
            return getActivity().findViewById(i10);
        }
        return view;
    }

    public final boolean X4() {
        ContactsTabActivity f42 = f4();
        if (f42 == null || !CommonFeatureOption.m() || f42.isInMultiWindowMode() || this.f17460t1 || getResources().getConfiguration().orientation != 1) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void X5(int i10, DialogInterface dialogInterface, int i11) {
        if (M7.c.a(getActivity())) {
            m7();
        } else {
            C0792c.j(getActivity(), i10);
        }
    }

    public final void X6(String str) {
        Editable editable;
        String extractNetworkPortion = PhoneNumberUtils.extractNetworkPortion(str);
        if (!TextUtils.isEmpty(extractNetworkPortion)) {
            String extractPostDialPortion = PhoneNumberUtils.extractPostDialPortion(str);
            if (!TextUtils.isEmpty(extractPostDialPortion)) {
                extractNetworkPortion = extractNetworkPortion.concat(extractPostDialPortion);
            }
            if (!i5()) {
                Q4();
            }
            I7(extractNetworkPortion);
            if (C0637b.h()) {
                this.f17378P0 = extractNetworkPortion;
                extractNetworkPortion = C0637b.d(extractNetworkPortion);
                this.f17375O0 = true;
            }
            DialEditText dialEditText = this.f17433k;
            if (dialEditText != null) {
                editable = dialEditText.getText();
            } else {
                editable = null;
            }
            if (editable == null) {
                return;
            }
            editable.replace(0, editable.length(), extractNetworkPortion);
            this.f17433k.setSelection(editable.length());
            V6(true);
            this.f17433k.requestFocus();
        }
    }

    public final void X7() {
        if (this.f17416c0 == null) {
            return;
        }
        if (d5()) {
            if (this.f17418d0 != null && this.f17431j0) {
                this.f17416c0.setVisibility(0);
                return;
            } else if (this.f17446o0 != null && this.f17396V0 > 0) {
                this.f17416c0.setVisibility(0);
                return;
            } else {
                this.f17416c0.setVisibility(8);
                return;
            }
        }
        if (this.f17452q0 > 0) {
            this.f17416c0.setVisibility(0);
        } else {
            this.f17416c0.setVisibility(8);
        }
    }

    public final void Y3(Intent intent) {
        if ("android.intent.action.CALL_BUTTON".equals(intent.getAction())) {
            intent.setDataAndType(CallLog.Calls.CONTENT_URI, "vnd.android.cursor.dir/calls");
            intent.putExtra("call_key", true);
            Z6(intent);
        }
    }

    public boolean Y4() {
        return Z4(m4());
    }

    public final /* synthetic */ void Y5() {
        this.f17446o0.U0().l(getContext());
    }

    public final void Y7(String str) {
        new C(str).execute(new Void[0]);
    }

    @Override // w7.b
    public boolean Z0(View view, int i10) {
        return e6(view);
    }

    public final void Z3(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(" ")) {
            str = U7.f.f(str);
        }
        if (!TextUtils.isEmpty(str) && str.length() <= 20) {
            if (str.length() >= 5) {
                int i10 = 0;
                while (true) {
                    if (i10 >= C1073b.c().length) {
                        break;
                    }
                    if (str.startsWith(C1073b.c()[i10])) {
                        str = str.substring(C1073b.c()[i10].length());
                        break;
                    }
                    i10++;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.charAt(0) == '0') {
                if (str.length() == 3 && (str.charAt(1) == '2' || str.charAt(1) == '1')) {
                    Y7(str);
                } else if (str.length() >= 4 && !str.startsWith("00")) {
                    Y7(str);
                } else if (str.length() >= 5 && str.startsWith("008")) {
                    Y7(str);
                } else if (str.length() >= 3 && str.startsWith("00")) {
                    Y7(str);
                }
                if (str.length() < 4) {
                    if (str.length() != 3 || (str.charAt(1) != '1' && str.charAt(1) != '2')) {
                        this.f17455r0.setVisibility(4);
                        return;
                    }
                    return;
                }
                return;
            }
            if (str.charAt(0) == '1') {
                if (str.length() >= 7) {
                    Y7(str);
                }
                if (str.length() < 7) {
                    this.f17455r0.setVisibility(4);
                    return;
                }
                return;
            }
            if (str.startsWith("+")) {
                if (str.length() >= 3) {
                    Y7(str);
                }
                if (str.length() < 3) {
                    this.f17455r0.setVisibility(4);
                    return;
                }
                return;
            }
            if (this.f17455r0.getVisibility() != 8) {
                this.f17455r0.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView = this.f17455r0;
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    public final boolean Z4(Intent intent) {
        if (intent != null && "android.intent.action.VIEW".equals(intent.getAction()) && "vnd.android.cursor.dir/calls".equals(intent.getType())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void Z5(boolean z10) {
        t4();
        View view = this.f17465w0;
        if (view != null && view.getVisibility() == 0) {
            P6(true, true);
        }
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.f1();
            this.f17446o0.j2(this.f17473z.b(), com.customize.contacts.util.b0.O());
            if (this.f17446o0.U0() != null) {
                this.f17423f1.execute(new Runnable() { // from class: com.android.contacts.j0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC0694u0.this.Y5();
                    }
                });
            }
            if (z10) {
                this.f17446o0.U1(android.text.format.DateFormat.getTimeFormat(getActivity()));
                this.f17446o0.E1(F7.b.e(getActivity()));
                F7();
            } else {
                G3();
            }
        }
        if (e5()) {
            log("In action mode ,not refresh menu view");
        } else {
            p7(true);
        }
    }

    public final void Z7(Cursor cursor) {
        if (cursor != null) {
            int count = cursor.getCount();
            if (count > 0) {
                H7.b.e("DialtactsFragment", "updateContent success count = " + count);
                d6(cursor, null, false);
            } else {
                H7.b.e("DialtactsFragment", "updateContent fail");
                com.oplus.foundation.util.io.e.a(cursor);
            }
        }
        F7();
    }

    public final String a4(String str) {
        if (!TextUtils.isEmpty(str)) {
            return com.android.contacts.framework.phonenumber.PhoneNumberUtils.e(b4(str));
        }
        return "";
    }

    public boolean a5() {
        return false;
    }

    public boolean a6() {
        return true;
    }

    public final void a7(int i10) {
        boolean z10 = true;
        if (i10 != 1 && i10 != 2) {
            z10 = false;
        }
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.G1(z10);
        }
    }

    public void a8() {
        boolean e10 = com.android.contacts.framework.api.satellite.a.e();
        if (this.f17376O1 != null) {
            this.f17374O = com.customize.contacts.util.b0.j();
            H7.b.e("DialtactsFragment", "updateDialBottom: satellite mode: " + e10 + ", sim count: " + this.f17374O);
            this.f17376O1.f(e10, this.f17374O, this.f17362K, this.f17365L, this.f17368M, this.f17371N);
        }
        R6();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i10;
        boolean z10;
        float f10;
        TextView textView;
        log("afterTextChanged::input:" + H7.a.d(editable.toString()));
        ContactsTabActivity f42 = f4();
        if (f42 == null) {
            return;
        }
        f42.g3(false);
        String str = this.f17417c1;
        this.f17439m.removeMessages(888);
        this.f17439m.sendEmptyMessageDelayed(888, 500L);
        String b10 = C1073b.b(l4());
        I6(b10);
        if (!TextUtils.isEmpty(b10)) {
            i10 = b10.length();
            if ((!this.f17369M0 && o0.f.f(f42, b10, l4())) || o0.f.e(f42, b10)) {
                I3();
                i10 = 0;
                b10 = "";
            }
        } else {
            i10 = 0;
        }
        if (!TextUtils.isEmpty(b10) && !this.f17369M0 && !b10.equals(this.f17417c1)) {
            I7(b10);
        }
        this.f17417c1 = b10;
        if (b10.contains("\n")) {
            W6(b10.replaceAll("\\n", ""));
        }
        if (b10.contains("\r")) {
            W6(b10.replaceAll("\\r", ""));
        }
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            F7();
            LinearLayout linearLayout = this.f17459t0;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                this.f17438l1.setVisibility(8);
                View view = this.f21249c;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
            ImageButton imageButton = this.f17377P;
            if (imageButton != null) {
                imageButton.setPressed(false);
                this.f17377P.setEnabled(false);
            }
            V6(false);
            I3();
            P6(false, false);
            TextView textView2 = this.f17455r0;
            if (textView2 != null) {
                textView2.setVisibility(4);
            }
            if (this.f17418d0 != null) {
                N7.a.b().execute(new Runnable() { // from class: com.android.contacts.I
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC0694u0.this.u5();
                    }
                });
            }
            this.f17452q0 = 0;
        } else {
            if (-1 == this.f17401X) {
                float f11 = this.f17389T.getDisplayMetrics().density;
                this.f17401X = (int) ((this.f17389T.getDimensionPixelSize(R.dimen.DP_30) / f11) + 0.5f);
                this.f17404Y = (int) ((this.f17389T.getDimensionPixelSize(R.dimen.DP_28) / f11) + 0.5f);
            }
            b10 = l4();
            int length = U7.f.d(b10).length();
            int i11 = this.f17401X;
            int i12 = this.f17404Y;
            float f12 = (i11 - i12) / 5.0f;
            if (length <= 12) {
                f10 = i11;
            } else if (length <= 17) {
                f10 = i11 - ((length - 12) * f12);
            } else {
                f10 = i12;
            }
            int i13 = (int) ((f10 * this.f17389T.getDisplayMetrics().density) + 0.5f);
            DialEditText dialEditText = this.f17433k;
            if (dialEditText != null) {
                dialEditText.setTextSize(0, i13);
            }
            LinearLayout linearLayout2 = this.f17405Y0;
            if (linearLayout2 != null) {
                Z3.f.m(linearLayout2, null);
            }
            if (this.f17459t0 != null) {
                Y6();
                View view2 = this.f21249c;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            ImageButton imageButton2 = this.f17377P;
            if (imageButton2 != null) {
                imageButton2.setEnabled(true);
            }
            DialEditText dialEditText2 = this.f17433k;
            if (dialEditText2 != null) {
                dialEditText2.setVisibility(0);
            }
            i8();
            C4();
        }
        X7();
        q8();
        if (i10 > 20 && (textView = this.f17455r0) != null) {
            textView.setVisibility(4);
        }
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "afterTextChanged: isLengthZero: " + z10 + ", mDefaultSlotId: " + this.f17362K);
        }
        b7(!z10);
        if (!TextUtils.equals(str, b10) || z10) {
            J6();
        }
        t8(z10);
        Q6();
        A0.b bVar = this.f17376O1;
        if (bVar != null) {
            bVar.a(l4());
        }
        R6();
    }

    @Override // com.android.contacts.calllog.k.j
    public int b1() {
        return this.f17370M1.g();
    }

    public final String b4(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll("[ \\-().]", "");
    }

    public final boolean b5(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = "";
        }
        if ("android.intent.action.DIAL".equals(str) || "com.android.phone.action.TOUCH_DIALER".equals(str) || r0.f.d(str)) {
            return true;
        }
        if (!"android.intent.action.VIEW".equals(str)) {
            return false;
        }
        Uri data = intent.getData();
        if (data != null && "tel".equals(data.getScheme())) {
            return true;
        }
        return false;
    }

    public final Intent b6() {
        int i10;
        Intent intent = new Intent(C0421a.f6395a, Uri.fromParts("voicemail", "", null));
        if (B3.a.i() && (i10 = this.f17357I0) != -1) {
            t6(intent, i10);
        }
        return intent;
    }

    public final void b8(String str) {
        DialEditText dialEditText = this.f17433k;
        if (dialEditText == null) {
            return;
        }
        int selectionStart = dialEditText.getSelectionStart();
        int selectionEnd = this.f17433k.getSelectionEnd();
        int min = Math.min(selectionStart, selectionEnd);
        int max = Math.max(selectionStart, selectionEnd);
        Editable text = this.f17433k.getText();
        if (text == null) {
            return;
        }
        if (min != -1) {
            if (min <= text.length() && max <= text.length()) {
                if (min == max) {
                    text.replace(min, min, str);
                    return;
                }
                text.replace(min, max, str);
                int i10 = min + 1;
                if (i10 <= this.f17433k.length()) {
                    this.f17433k.setSelection(i10);
                    return;
                }
                return;
            }
            return;
        }
        int length = this.f17433k.length();
        text.replace(length, length, str);
    }

    public com.android.contacts.calllog.k c4() {
        return this.f17446o0;
    }

    public boolean c6() {
        if (e5()) {
            u1();
            return true;
        }
        H7.b.e("DialtactsFragment", "onBackPressed:mDialpadIsShow: " + this.f17383R);
        if (this.f17433k != null) {
            H7.b.b("DialtactsFragment", "mDigits.length: " + l4().length());
        }
        if (j4() != 0 && !this.f17383R && !this.f17460t1) {
            s7(true);
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        if (C0792c.d(activity)) {
            boolean e10 = C0792c.e(activity, false);
            this.f17442n = true;
            return e10;
        }
        I3();
        activity.finish();
        return false;
    }

    public final void c7() {
        this.f17437l0.i(3, null, CallLog.Calls.CONTENT_URI, new String[]{"number", "simid"}, C0801l.f(), null, "date DESC LIMIT 1");
        if (!i5()) {
            Q4();
        }
    }

    public final void c8(int i10) {
        DialpadBottomView dialpadBottomView = this.f17367L1;
        if (dialpadBottomView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dialpadBottomView.getLayoutParams();
            layoutParams.height = i10;
            this.f17367L1.setLayoutParams(layoutParams);
        }
        A0.b bVar = this.f17376O1;
        if (bVar != null) {
            bVar.g(getResources(), i10);
        }
    }

    @Override // com.android.contacts.calllog.r.b
    public void d(Cursor cursor) {
        d6(cursor, null, true);
    }

    public Context d4() {
        return requireActivity().getApplicationContext();
    }

    public boolean d5() {
        DialEditText dialEditText = this.f17433k;
        if (dialEditText == null || dialEditText.length() == 0) {
            return true;
        }
        return false;
    }

    public void d6(Cursor cursor, com.android.contacts.framework.baseui.calllog.b bVar, boolean z10) {
        DialerHeaderViewManager dialerHeaderViewManager;
        E3.c cVar;
        H7.b.e("DialtactsFragment", "onCallsFetched");
        ContactsTabActivity f42 = f4();
        if (z10 && f42 != null) {
            f42.Z2();
        }
        if (f42 != null && !f42.isFinishing() && this.f17416c0 != null) {
            if (this.f17446o0 == null) {
                I4();
            }
            boolean z11 = false;
            this.f17396V0 = 0;
            this.f17424g0 = true;
            if (cursor != null && !cursor.isClosed()) {
                if (B3.a.b0() && z10 && !this.f17391T1) {
                    CallLogItemCacheManager.f13737c.a().e();
                }
                this.f17396V0 = cursor.getCount();
                C1322s c1322s = new C1322s(cursor, this.f17382Q1);
                c1322s.c(this.f17394U1);
                cursor = c1322s;
            }
            if (cursor != null && this.f17396V0 > 0) {
                if (this.f17460t1 && this.f17471y0 == null) {
                    T4();
                    F3();
                }
                log("onCallsFetched->cursor.getCount() = " + this.f17396V0);
                if (this.f17449p0) {
                    log("onCallsFetched-> mScrollToTop = true");
                    G3();
                    this.f17449p0 = false;
                }
                this.f17390T0 = true;
                if (e5() && (cVar = this.f17398W) != null) {
                    cVar.J(cursor);
                }
            } else {
                this.f17390T0 = false;
                if (this.f17471y0 == null) {
                    T4();
                    F3();
                }
                if (e5()) {
                    u1();
                }
                J6();
                H7.b.e("DialtactsFragment", "onCallsFetched no call log");
            }
            if (this.f17446o0 != null && d5()) {
                this.f17446o0.P1(false);
                if (cursor == null || !cursor.isClosed()) {
                    this.f17446o0.j(cursor, bVar);
                }
                if (!this.f17446o0.s().p()) {
                    this.f17399W0 = this.f17446o0.v().size();
                }
            } else {
                com.oplus.foundation.util.io.e.a(cursor);
            }
            if (this.f17396V0 > 6000) {
                this.f17439m.removeMessages(999);
                this.f17439m.sendEmptyMessageDelayed(999, 500L);
            }
            o7();
            this.f17409Z1.f(n4());
            if (d5() && (dialerHeaderViewManager = this.f17418d0) != null && z10) {
                dialerHeaderViewManager.u0();
            } else {
                z11 = true;
            }
            X7();
            q8();
            if (z11) {
                i8();
            }
            if (B3.a.b0()) {
                if (f42.E2()) {
                    f42.T2();
                    return;
                }
                return;
            }
            o8(cursor, bVar);
            return;
        }
        H7.b.e("DialtactsFragment", "[onCallsFetched]ContactsTabActivity is null or is finishing");
        com.oplus.foundation.util.io.e.a(cursor);
    }

    public void d7(boolean z10) {
        this.f17349F1 = z10;
    }

    public final void d8(int i10, int i11) {
        ScrollRelativeLayout scrollRelativeLayout = this.f17356I;
        if (scrollRelativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) scrollRelativeLayout.getLayoutParams();
            if (layoutParams.height != i10 || this.f17356I.getPaddingBottom() != i11) {
                layoutParams.height = i10;
                this.f17356I.setLayoutParams(layoutParams);
                this.f17356I.setPadding(0, 0, 0, i11);
                this.f17356I.getViewTreeObserver().addOnGlobalLayoutListener(new f(i10));
            }
        }
    }

    public I.d<DialpadView, Integer> e4() {
        return null;
    }

    public boolean e5() {
        E3.c cVar = this.f17398W;
        if (cVar != null && cVar.A()) {
            return true;
        }
        return false;
    }

    public final void e7(boolean z10) {
        int i10;
        View q42 = q4();
        if (q42 != null) {
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "setNavigationMainViewVisible show=" + z10 + ",animate=" + this.f17349F1 + ",visible=" + q42.getVisibility());
            }
            AnimationAnimationListenerC0813y animationAnimationListenerC0813y = this.f17373N1;
            if (animationAnimationListenerC0813y != null) {
                if (z10) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                animationAnimationListenerC0813y.q(i10);
                this.f17373N1.c();
            }
            if (z10) {
                if (this.f17349F1) {
                    this.f17373N1 = AnimationAnimationListenerC0813y.s(q42);
                    return;
                } else {
                    q42.setVisibility(0);
                    return;
                }
            }
            if (this.f17349F1) {
                this.f17373N1 = AnimationAnimationListenerC0813y.h(q42);
            } else {
                q42.setVisibility(8);
            }
        }
    }

    public final void e8(boolean z10) {
        int i10;
        if (this.f17450p1 != null && c5()) {
            COUIFloatingButton cOUIFloatingButton = this.f17450p1;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            cOUIFloatingButton.setVisibility(i10);
            if (z10) {
                this.f17450p1.setAlpha(1.0f);
                this.f17450p1.setScaleX(1.0f);
                this.f17450p1.setScaleY(1.0f);
            }
        }
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void f1() {
        this.f17409Z1.a(true);
    }

    public ContactsTabActivity f4() {
        FragmentActivity activity = getActivity();
        if (activity instanceof ContactsTabActivity) {
            return (ContactsTabActivity) activity;
        }
        return null;
    }

    public final boolean f5() {
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar == null || !kVar.A() || !this.f17446o0.v().isEmpty()) {
            return false;
        }
        return true;
    }

    public void f6(int i10, KeyEvent keyEvent) {
        if (e5() || g5() || !this.f17383R) {
            return;
        }
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "onKeyDown: keyCode: " + i10);
        }
        if (i10 != 66) {
            if (i10 != 67) {
                if (i10 != 70) {
                    if (i10 != 74) {
                        if (i10 != 81) {
                            switch (i10) {
                                case 7:
                                    if (keyEvent.isShiftPressed()) {
                                        s5(163);
                                        return;
                                    } else {
                                        s5(7);
                                        return;
                                    }
                                case 8:
                                    s5(8);
                                    return;
                                case 9:
                                    s5(9);
                                    return;
                                case 10:
                                    if (keyEvent.isShiftPressed()) {
                                        s5(18);
                                        return;
                                    } else {
                                        s5(10);
                                        return;
                                    }
                                case 11:
                                    s5(11);
                                    return;
                                case 12:
                                    s5(12);
                                    return;
                                case 13:
                                    s5(13);
                                    return;
                                case 14:
                                    s5(14);
                                    return;
                                case 15:
                                    if (keyEvent.isShiftPressed()) {
                                        s5(17);
                                        return;
                                    } else {
                                        s5(15);
                                        return;
                                    }
                                case 16:
                                    if (keyEvent.isShiftPressed()) {
                                        s5(162);
                                        return;
                                    } else {
                                        s5(16);
                                        return;
                                    }
                                case 17:
                                    s5(17);
                                    return;
                                case 18:
                                    s5(18);
                                    return;
                                default:
                                    switch (i10) {
                                        case 32:
                                        case 33:
                                        case 34:
                                            s5(10);
                                            return;
                                        default:
                                            switch (i10) {
                                                case 48:
                                                case 49:
                                                case 50:
                                                    s5(15);
                                                    return;
                                                case 51:
                                                case 52:
                                                case 53:
                                                case 54:
                                                    s5(16);
                                                    return;
                                                case 55:
                                                    if (j4() != 0) {
                                                        b8(",");
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    return;
                                            }
                                    }
                            }
                        }
                        s5(81);
                        return;
                    }
                    if (j4() != 0) {
                        b8(Constants.DataMigration.SPLIT_TAG);
                        return;
                    }
                    return;
                }
                if (keyEvent.isShiftPressed()) {
                    s5(81);
                    return;
                }
                return;
            }
            R3(null);
            return;
        }
        r6();
    }

    public final void f7() {
        log("setPasteLayoutVisible, mIsEditBeforeDial = " + this.f17369M0 + ", mDialpadIsShow = " + this.f17383R + ", mOuterContinueDial = " + this.f17372N0);
        if (!this.f17369M0 && !this.f17372N0) {
            z7();
            if (!this.f17383R) {
                this.f17386S = new t() { // from class: com.android.contacts.E
                    @Override // com.android.contacts.ViewOnClickListenerC0694u0.t
                    public final void a(boolean z10, boolean z11) {
                        ViewOnClickListenerC0694u0.this.U5(z10, z11);
                    }
                };
            }
        }
    }

    public final void f8() {
        int i10;
        if (this.f17356I != null) {
            if (!o5()) {
                i10 = getResources().getDimensionPixelSize(R.dimen.dialpad_margin_bottom);
            } else {
                i10 = -1;
            }
            ViewGroup.LayoutParams layoutParams = this.f17356I.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams.bottomMargin != i10) {
                    marginLayoutParams.bottomMargin = i10;
                    this.f17356I.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    @Override // com.android.contacts.dialpad.view.DialpadImageButton.b
    public void g0(View view, boolean z10) {
        int i10;
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
                Log.i("DialtactsFragment", "The tone is unknown");
            } else {
                s6(i10);
            }
        }
    }

    public boolean g5() {
        return false;
    }

    public void g6(Intent intent) {
        H7.b.e("DialtactsFragment", "onNewIntent() newIntent::");
        Z6(intent);
        Y3(intent);
        M3(intent);
        this.f17449p0 = true;
        if (e5()) {
            this.f17398W.H(false);
            u1();
        }
        this.f17355H1 = false;
        if (c5() && !h5(intent) && (b5(intent) || Z4(intent) || k5(intent))) {
            w7();
        }
        J6();
        W7(true);
    }

    public final void g7() {
        if (this.f17460t1) {
            this.f17387S0 = true;
            this.f17439m.sendEmptyMessageDelayed(222, 1000L);
        }
    }

    public final void g8(int i10, boolean z10, boolean z11) {
        DialpadView dialpadView = this.f17457s0;
        if (dialpadView != null) {
            dialpadView.setDialpadButtonHeight(i10);
            this.f17457s0.g(z10, z11);
        }
    }

    @Override // com.android.contacts.calllog.k.j
    public void h() {
        if (getActivity() != null && d5()) {
            if (this.f17443n0 == null) {
                this.f17443n0 = new com.android.contacts.calllog.r(g4(), this);
            }
            F7();
        }
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void h1() {
        E3.c cVar = this.f17398W;
        if (cVar != null && cVar.A()) {
            u1();
            return;
        }
        if (this.f17398W == null) {
            E3.c cVar2 = new E3.c(this, this.f17446o0, this.f17409Z1);
            this.f17398W = cVar2;
            this.f17446o0.A1(cVar2);
        }
        if (d5()) {
            log("enterActionMode()");
            E3.c cVar3 = this.f17398W;
            if (cVar3 != null && !cVar3.A()) {
                com.android.contacts.calllog.k kVar = this.f17446o0;
                if (kVar != null) {
                    kVar.Q1(true);
                    this.f17446o0.R1(true);
                }
                this.f17398W.H(true);
                this.f17398W.t();
                if (this.f17383R) {
                    s7(false);
                }
                F4();
                if (this.f17416c0 != null) {
                    boolean j10 = DisplayUtil.j(getActivity());
                    if (this.f17361J1 && !j10) {
                        this.f17416c0.i(requireContext().getResources().getDimensionPixelSize(R.dimen.DP_145), 0, 0, 0);
                    } else {
                        this.f17416c0.i(requireContext().getResources().getDimensionPixelSize(R.dimen.DP_60), 0, 0, 0);
                    }
                }
                this.f17398W.I();
                DialerHeaderViewManager dialerHeaderViewManager = this.f17418d0;
                if (dialerHeaderViewManager != null) {
                    dialerHeaderViewManager.F0(false);
                }
            }
        }
        com.android.contacts.framework.baseui.util.A.a(getActivity(), 2000303, 200030022, null, false);
    }

    public final boolean h5(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("from_scene", false);
        H7.b.e("DialtactsFragment", "isFromScene : " + booleanExtra);
        return booleanExtra;
    }

    public void h6(boolean z10) {
        if (z10) {
            View view = this.f17438l1;
            if (view == null || view.getVisibility() == 8) {
                f7();
            }
        }
    }

    public final void h7(int i10) {
        this.f17470y = i10;
    }

    public final void h8(boolean z10, boolean z11) {
        if (this.f17383R != z10) {
            this.f17383R = z10;
            if (z11) {
                x6();
            }
        }
    }

    @Override // com.android.contacts.calllog.k.j
    public void i() {
        log("refreshSearchContacts");
        if (i5() && !d5() && !this.f17369M0) {
            I7(l4());
        }
    }

    public final int i4() {
        View F10;
        DialerHeaderViewManager dialerHeaderViewManager = this.f17418d0;
        if (dialerHeaderViewManager != null && (F10 = dialerHeaderViewManager.F()) != null && F10.getVisibility() == 0) {
            int measuredHeight = F10.getMeasuredHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.DP_120);
            if (measuredHeight <= dimensionPixelSize) {
                return dimensionPixelSize;
            }
            return measuredHeight;
        }
        return 0;
    }

    public boolean i5() {
        if (this.f17433k != null) {
            return true;
        }
        return false;
    }

    public void i6(boolean z10) {
        if (z10) {
            SoftKeyboardUtil.a().b(this.f17433k);
        }
    }

    public final void i7() {
        G0.c.o(d4(), 0, "oplus_start_bind_incall_service", 1, 1);
        H7.b.e("DialtactsFragment", "has written oplus_start_bind_incall_service ,value 1");
    }

    public void i8() {
        boolean z10;
        boolean z11;
        View view;
        boolean z12;
        int height;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (!isAdded()) {
            return;
        }
        View view2 = this.f17471y0;
        if (view2 == null) {
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "updateDialpadTipsVisible queryContactsView = " + view2 + ";mAdapter = " + this.f17446o0);
                return;
            }
            return;
        }
        if (d5() && ((view = this.f17438l1) == null || view.getVisibility() == 8)) {
            z11 = true;
            if (this.f17396V0 > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            int height2 = view2.getHeight();
            if (height2 <= 0) {
                return;
            }
            int e10 = DisplayUtil.e(getContext(), false);
            int height3 = this.f17356I.getHeight();
            int i15 = ((ViewGroup.MarginLayoutParams) this.f17356I.getLayoutParams()).bottomMargin;
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "updateDialpadTipsVisible screenHeight = " + e10 + ";dialpadContainerHeight = " + height3 + ";queryContactsViewHeight = " + height2 + ";dialpadContainerBottomMargin = " + i15);
            }
            if (this.f17460t1) {
                i13 = com.android.contacts.framework.baseui.util.B.a(getContext());
                if (H7.a.b()) {
                    H7.b.b("DialtactsFragment", "updateDialpadTipsVisible statusBarHeight = " + i13);
                }
                i12 = 0;
                i11 = 0;
                i10 = 0;
            } else {
                int i42 = i4();
                if (q4() == null) {
                    height = 0;
                } else {
                    height = q4().getHeight();
                }
                int measuredHeight = this.f21251e.getMeasuredHeight();
                if (H7.a.b()) {
                    H7.b.b("DialtactsFragment", "updateDialpadTipsVisible hasCalllog = " + z12 + ";appBarHeight = " + measuredHeight + ";dialerHeaderTipsViewHeight = " + i42);
                }
                i10 = measuredHeight;
                i11 = height;
                i12 = i42;
                i13 = 0;
            }
            if (!this.f17460t1 ? !(z12 || ((this.f17431j0 && o5()) || (((e10 - i10) - i11) - i12) - getResources().getDimensionPixelSize(R.dimen.DP_74) <= height2)) : ((e10 - i13) - height3) - i15 > height2) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "needShow = " + z10);
            }
            if (z10) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (this.f17460t1) {
                        i14 = (((((e10 - i13) - height3) - i15) - height2) / 2) + i13;
                    } else {
                        int i16 = (((((e10 - i10) - height3) - i12) - i15) - height2) / 2;
                        if (i16 < 0) {
                            i14 = i12 + i10;
                        } else {
                            i14 = i16 + i10 + i12;
                        }
                    }
                    if (marginLayoutParams.topMargin != i14) {
                        marginLayoutParams.topMargin = i14;
                        view2.setLayoutParams(marginLayoutParams);
                    }
                }
            }
            z11 = false;
        } else {
            z10 = false;
            z11 = false;
        }
        if (z10) {
            if (view2.getVisibility() != 0) {
                if (z11) {
                    this.f17428i0 = new g(view2);
                    view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f17428i0);
                    return;
                } else {
                    view2.setVisibility(0);
                    return;
                }
            }
            return;
        }
        if (view2.getVisibility() != 4) {
            view2.setVisibility(4);
        }
        if (this.f17428i0 != null) {
            view2.getViewTreeObserver().removeOnGlobalLayoutListener(this.f17428i0);
            view2.setVisibility(4);
        }
    }

    public final int j4() {
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null && dialEditText.getText() != null) {
            return this.f17433k.getText().length();
        }
        return 0;
    }

    public boolean j5() {
        Animator animator = this.f17422f0;
        if (animator == null) {
            return false;
        }
        boolean isStarted = animator.isStarted();
        log("isListViewAnimating = " + isStarted);
        return isStarted;
    }

    public final boolean j6() {
        HashMap hashMap = new HashMap();
        hashMap.put("dialpad_input_count", Integer.valueOf(k4()));
        com.android.contacts.framework.baseui.util.A.a(getActivity(), 2000304, 200030028, hashMap, false);
        com.customize.contacts.util.d0.p().z(67, null, null);
        if (d5()) {
            return false;
        }
        this.f17439m.post(this.f17403X1);
        return true;
    }

    public final void j7() {
        if (!isAdded()) {
            return;
        }
        G0.c.o(d4(), 0, "oplus_start_bind_incall_service", 0, 1);
        H7.b.b("DialtactsFragment", "has written oplus_start_bind_incall_service ,value 0");
    }

    public final void j8() {
        COUIFloatingButton cOUIFloatingButton = this.f17450p1;
        if (cOUIFloatingButton != null) {
            cOUIFloatingButton.setMainFabDrawable(this.f17453q1);
            this.f17450p1.getMainFloatingButton().setContentDescription(this.f17456r1);
        }
    }

    public int k4() {
        return l4().replaceAll(" ", "").replaceAll("-", "").length();
    }

    public final boolean k5(Intent intent) {
        if (intent != null && "android.intent.action.MAIN".equals(intent.getAction())) {
            return true;
        }
        return false;
    }

    public final boolean k6() {
        if (getActivity() != null && C0802m.b(getActivity())) {
            return true;
        }
        return false;
    }

    public void k8(boolean z10) {
        if (!c5()) {
            H7.b.b("DialtactsFragment", "current\u3000tab is not dialtact\u3000");
            return;
        }
        O4();
        j8();
        COUIFloatingButton cOUIFloatingButton = this.f17450p1;
        if (cOUIFloatingButton != null && this.f17383R) {
            cOUIFloatingButton.setVisibility(8);
        }
    }

    public String l4() {
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null && dialEditText.getText() != null) {
            return this.f17433k.getText().toString();
        }
        return "";
    }

    public final boolean l5() {
        if (this.f17352G1 == null) {
            this.f17352G1 = Boolean.valueOf(DisplayUtil.m(requireContext()));
        }
        return this.f17352G1.booleanValue();
    }

    public void l6(int i10) {
        String r42 = r4();
        Intent intent = new Intent(f17329c2, Uri.fromParts("tel", r42, null));
        if (!this.f17360J0) {
            N7();
        }
        if (C7.a.a()) {
            H7.b.e("DialtactsFragment", "placeCall filter Click!");
            return;
        }
        H7.b.e("DialtactsFragment", "placeCall : slotId = " + i10);
        t6(intent, i10);
        intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        Intent m42 = m4();
        if (m42 != null) {
            String action = m42.getAction();
            Uri data = m42.getData();
            if ("android.intent.action.DIAL".equals(action) || "android.intent.action.VIEW".equals(action) || (r0.f.d(action) && data != null)) {
                m42.setData(null);
                Z6(m42);
            }
        }
        this.f17381Q0 = true;
        this.f17384R0 = true;
        this.f17360J0 = false;
        H7.b.e("DialtactsFragment", "placeCall here----------");
        intent.putExtra("dialer_from", "dialpad");
        C0802m.a(getActivity(), intent);
        g7();
        u6(r42);
    }

    public final void l8() {
        boolean z10 = false;
        if (e5()) {
            x7(false);
        } else {
            if (!d5()) {
                x7(false);
                return;
            }
            if (this.f17396V0 > 0) {
                z10 = true;
            }
            x7(z10);
        }
    }

    public Intent m4() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getIntent();
        }
        Intent intent = this.f17419d1;
        if (intent != null) {
            return intent;
        }
        Intent intent2 = new Intent();
        intent2.setFlags(335544320);
        intent2.putExtra("show_dialpad", true);
        return intent2;
    }

    public final boolean m5() {
        LinearLayout linearLayout = this.f17405Y0;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void m6(Intent intent, com.android.contacts.calllog.o oVar, int i10, int i11) {
        String l10 = C7.e.l(intent, "number");
        String l11 = C7.e.l(intent, R0.c.f3186d);
        if (!TextUtils.isEmpty(l10) && !l10.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS) && !l10.equals("-2") && !l10.equals("-3")) {
            if (B3.a.f0() && com.android.contacts.calllog.I.i(l10)) {
                H7.b.e("DialtactsFragment", "It is impossible to place a call to the special number: " + H7.a.d(l10));
                return;
            }
            if (l11 != null) {
                C0794e.b(getActivity(), intent, l10);
            }
            H7.b.e("DialtactsFragment", "CallLog list item click , place call number:" + H7.a.d(l10));
            try {
                intent.putExtra("dialer_from", "calllog");
                C0802m.a(getActivity(), intent);
                B3();
                u6(l10);
                C0710y.b(getActivity(), intent, i11, l10, l11);
                C0710y.c(getActivity(), (com.android.contacts.calllog.G) oVar.f14009b.getTag(), i10);
                return;
            } catch (Exception e10) {
                H7.b.c("DialtactsFragment", "Exception: " + e10);
                return;
            }
        }
        H7.b.e("DialtactsFragment", "It is impossible to place a call to the given number: " + H7.a.d(l10));
    }

    public final void m7() {
        if (!isAdded()) {
            return;
        }
        new COUIAlertDialogBuilder(requireActivity()).setTitle(R.string.oplus_airplane_mode_voicemail_message).setPositiveButton(R.string.non_phone_close, new DialogInterface.OnClickListener() { // from class: com.android.contacts.a0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ViewOnClickListenerC0694u0.this.V5(dialogInterface, i10);
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    public final void m8() {
        if (this.f21252f != null && !A7.a.a()) {
            if (this.f17460t1) {
                this.f21252f.a0(null);
            } else {
                this.f21252f.a0(this.f17461u0);
            }
        }
    }

    public final boolean n5() {
        boolean z10;
        ContactsTabActivity f42 = f4();
        if (f42 == null) {
            return false;
        }
        if (f42.t2() > 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (o5()) {
            if ((f42.E2() && this.f17383R) || !z10 || e5()) {
                return false;
            }
            return true;
        }
        return z10;
    }

    public final void n6(Intent intent, int i10) {
        int h42;
        String l10 = C7.e.l(intent, "number");
        String str = R0.c.f3186d;
        String l11 = C7.e.l(intent, str);
        String l12 = C7.e.l(intent, "countryiso");
        String l13 = C7.e.l(intent, str);
        H7.b.e("DialtactsFragment", "onItemClick place call number:" + H7.a.d(l10) + " ,countryIso = " + l12);
        if (TextUtils.isEmpty(l10)) {
            return;
        }
        boolean i11 = com.customize.contacts.util.b0.i(d4());
        Intent intent2 = new Intent(f17329c2, Uri.fromParts("tel", l10, null));
        intent2.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        if (i11 && this.f17473z.c() > 1) {
            h42 = C0801l.g(d4(), l10);
            if (h42 == -1) {
                h42 = h4();
            }
            log("slotId = " + h42);
        } else {
            h42 = h4();
        }
        t6(intent2, h42);
        if (l11 != null && PrimaryUserUtils.a()) {
            intent2.putExtra(str, l11);
        }
        if (l13 != null) {
            C0794e.b(getActivity(), intent2, l10);
        }
        intent2.putExtra("countryiso", l12);
        try {
            intent2.putExtra("dialer_from", "search");
            C0802m.a(getActivity(), intent2);
            g7();
            B3();
            C0710y.d(getActivity(), intent, i10, k4(), l11);
        } catch (Exception e10) {
            H7.b.c("DialtactsFragment", "Exception: " + e10);
        }
        this.f17384R0 = true;
    }

    public void n7() {
        ScrollRelativeLayout scrollRelativeLayout = this.f17356I;
        if (scrollRelativeLayout != null) {
            scrollRelativeLayout.setVisibility(0);
        }
    }

    public void n8() {
        this.f17434k0 = d5();
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "updateKeyboardDigitsStatus mDeletedEmptyByExternalKeyboard = " + this.f17434k0);
        }
        if (this.f17434k0 && CommonFeatureOption.m() && this.f17431j0) {
            this.f17421e1.post(new Runnable() { // from class: com.android.contacts.D
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC0694u0.this.J6();
                }
            });
        }
    }

    public final int o4() {
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            return kVar.getItemCount();
        }
        return 0;
    }

    public boolean o5() {
        boolean z10;
        ContactsTabActivity f42 = f4();
        if (f42 == null) {
            return false;
        }
        if (!this.f17460t1 && getResources().getConfiguration().orientation == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!f42.isInMultiWindowMode()) {
            return false;
        }
        if (FeatureUtil.N() && l5() && !z10) {
            return false;
        }
        if (CommonFeatureOption.m() && !z10) {
            return false;
        }
        return true;
    }

    public final void o6(int i10) {
        l6(i10);
        C0710y.a(getActivity(), k4());
    }

    public void o7() {
        p7(false);
    }

    public final void o8(Cursor cursor, com.android.contacts.framework.baseui.calllog.b bVar) {
        ContactsTabActivity f42 = f4();
        if (f42 != null) {
            com.android.contacts.calllog.k kVar = this.f17446o0;
            if (kVar != null && kVar.getItemCount() != 0) {
                HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
                if (headerFooterRecyclerView != null && headerFooterRecyclerView.getAlpha() == 0.0f && this.f17422f0 == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f17416c0, "alpha", 0.0f, 1.0f);
                    this.f17422f0 = ofFloat;
                    ofFloat.setDuration(250L);
                    this.f17422f0.addListener(new m(cursor, bVar, f42));
                    this.f17422f0.start();
                    this.f17446o0.B1(true);
                    return;
                }
                if (!this.f17426h0) {
                    Animator animator = this.f17422f0;
                    if (animator == null || !animator.isStarted()) {
                        this.f17426h0 = true;
                        f42.T2();
                        return;
                    }
                    return;
                }
                return;
            }
            HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f17416c0;
            if (headerFooterRecyclerView2 != null && headerFooterRecyclerView2.getAlpha() == 0.0f) {
                this.f17416c0.setAlpha(1.0f);
                F7();
            }
            if (!this.f17426h0) {
                this.f17426h0 = true;
                f42.T2();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ContactsTabActivity f42 = f4();
        if (f42 == null) {
            return;
        }
        this.f17458s1 = f42.p2();
        if (AppMetaFeatures.b()) {
            CallRecordingsCache.f15754a.r(f42);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        int i12;
        String str;
        H7.b.e("DialtactsFragment", "onActivityResult: requestCode: " + i10 + ", resultCode: " + i11);
        boolean z10 = true;
        if (i10 != -1 && i10 != 1) {
            if (i10 == 2 && (i12 = this.f17470y) >= 2 && i12 <= 9) {
                if (-1 == i11 && intent != null && getActivity() != null) {
                    Uri data = intent.getData();
                    if (data == null) {
                        str = "";
                    } else {
                        str = data.getLastPathSegment();
                    }
                    if (this.f17366L0 == null) {
                        this.f17366L0 = new com.android.contacts.dialpad.g(getActivity());
                    }
                    this.f17366L0.t(this.f17470y, this.f17366L0.l(str, "", ""));
                    this.f17470y = -1;
                    return;
                }
                this.f17470y = -1;
                return;
            }
            return;
        }
        E3.c cVar = this.f17398W;
        if (cVar != null) {
            if (i11 == -1) {
                int o42 = o4();
                if (i10 != -1) {
                    z10 = false;
                }
                cVar.r(o42, z10);
            } else {
                cVar.I();
            }
        }
        S6(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.customize.contacts.util.d0.p().v()) {
            return;
        }
        int id = view.getId();
        switch (id) {
            case R.id.add_new_contact /* 2131427440 */:
                if (!i5()) {
                    Q4();
                }
                String l42 = l4();
                if (!TextUtils.isEmpty(l42)) {
                    C0792c.g(getActivity(), l42, null, null, null);
                }
                C0636a.a(getActivity());
                return;
            case R.id.add_old_contact /* 2131427443 */:
                if (!i5()) {
                    Q4();
                }
                String l43 = l4();
                if (!TextUtils.isEmpty(l43)) {
                    H7(l43);
                    return;
                }
                return;
            case R.id.dial_del /* 2131427875 */:
                if (m5()) {
                    D4();
                } else {
                    R3(view);
                }
                N7();
                return;
            case R.id.dial_hide /* 2131427880 */:
                if (!i5()) {
                    Q4();
                }
                d7(true);
                s7(false);
                d7(false);
                com.customize.contacts.util.d0.p().z(119, null, null);
                return;
            case R.id.eight /* 2131427973 */:
                s5(15);
                return;
            case R.id.five /* 2131428045 */:
                s5(12);
                return;
            case R.id.four /* 2131428089 */:
                s5(11);
                return;
            case R.id.nine /* 2131428504 */:
                s5(16);
                return;
            case R.id.one /* 2131428557 */:
                s5(8);
                return;
            case R.id.paste_del /* 2131428650 */:
                t8(true);
                if (!i5()) {
                    Q4();
                }
                E4();
                com.android.contacts.framework.baseui.util.A.a(d4(), 2000304, 200030216, null, false);
                return;
            case R.id.paste_input /* 2131428651 */:
            case R.id.paste_number_container /* 2131428652 */:
                L3();
                com.android.contacts.framework.baseui.util.A.a(d4(), 2000304, 200030215, null, false);
                return;
            case R.id.pound /* 2131428723 */:
                s5(18);
                return;
            case R.id.seven /* 2131428942 */:
                s5(14);
                return;
            case R.id.sim1_dial_btn /* 2131428961 */:
            case R.id.single_sim1_dial_btn /* 2131428983 */:
                if (H7.a.b()) {
                    H7.b.b("DialtactsFragment", "onClick: viewId: " + requireContext().getResources().getResourceEntryName(id));
                }
                if (com.customize.contacts.util.d0.p().z(5, this, view)) {
                    return;
                }
                p6(0);
                return;
            case R.id.sim2_dial_btn /* 2131428965 */:
            case R.id.single_sim2_dial_btn /* 2131428984 */:
                if (H7.a.b()) {
                    H7.b.b("DialtactsFragment", "onClick: viewId: " + requireContext().getResources().getResourceEntryName(id));
                }
                if (com.customize.contacts.util.d0.p().z(5, this, view)) {
                    return;
                }
                p6(1);
                return;
            case R.id.sim_dial_btn /* 2131428971 */:
            case R.id.sim_dial_btn_satellite /* 2131428972 */:
            case R.id.single_sim_view /* 2131428990 */:
            case R.id.single_sim_view_satellite /* 2131428991 */:
                if (H7.a.b()) {
                    H7.b.b("DialtactsFragment", "onClick: viewId: " + requireContext().getResources().getResourceEntryName(id));
                }
                if (com.customize.contacts.util.d0.p().z(5, this, view)) {
                    return;
                }
                r6();
                return;
            case R.id.six /* 2131428992 */:
                s5(13);
                return;
            case R.id.star /* 2131429050 */:
                s5(17);
                return;
            case R.id.three /* 2131429203 */:
                s5(10);
                return;
            case R.id.two /* 2131429281 */:
                s5(9);
                return;
            case R.id.ust_video_view /* 2131429336 */:
            case R.id.video_call /* 2131429348 */:
                if (H7.a.b()) {
                    H7.b.b("DialtactsFragment", "onClick: video_call or ust_video_view");
                }
                if (!i5()) {
                    Q4();
                }
                Intent intent = new Intent(f17329c2, Uri.fromParts("tel", l4(), null));
                intent.putExtra("android.telecom.extra.START_CALL_WITH_VIDEO_STATE", 3);
                intent.putExtra("dialer_from", "calllog_video_call");
                C0802m.a(getActivity(), intent);
                g7();
                this.f17384R0 = true;
                com.android.contacts.framework.baseui.util.A.a(getActivity(), 2000319, 200030176, com.customize.contacts.util.h0.b0(getActivity()), false);
                return;
            case R.id.zero /* 2131429413 */:
                s5(7);
                return;
            default:
                H7.b.c("DialtactsFragment", "Unexpected onTouch(ACTION_DOWN) event from: " + view);
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f17460t1 = DisplayUtil.o(requireActivity(), configuration);
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "onConfigurationChanged mShowChildUi = " + this.f17460t1);
        }
        super.onConfigurationChanged(configuration);
        com.android.contacts.dialpad.g gVar = this.f17366L0;
        if (gVar != null) {
            gVar.n();
        }
        x6();
        T7();
        U7();
        y6();
        D4();
        m8();
        if (this.f17460t1) {
            Q6();
        }
        log("dial onConfigurationChanged");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z10;
        super.onCreate(bundle);
        DialPadFragmentViewModel dialPadFragmentViewModel = (DialPadFragmentViewModel) new androidx.lifecycle.K(this).a(DialPadFragmentViewModel.class);
        this.f17370M1 = dialPadFragmentViewModel;
        dialPadFragmentViewModel.h(this, this.f17415b2);
        if (bundle != null && bundle.containsKey("key_number")) {
            this.f17447o1 = bundle.getString("key_number");
            C1390c.h(bundle.getString("key_pre_secret_code_input"));
        }
        if (bundle != null) {
            this.f17470y = bundle.getInt("pressed_key_number", -1);
            this.f17355H1 = bundle.getBoolean("dialpad_state");
            z10 = bundle.getBoolean("filter_missed_state");
        } else {
            z10 = false;
        }
        this.f17414b1 = PreferenceManager.getDefaultSharedPreferences(d4());
        this.f17473z.i(getActivity(), null, new M(this));
        com.customize.contacts.util.b0.P(this.f17414b1);
        this.f17353H = new Z3.f(getActivity());
        J4(z10);
        Q3();
        if (bundle != null) {
            super.onSaveInstanceState(bundle);
        }
        this.f17445o = true;
        this.f17389T = getResources();
        if (C1643c.w()) {
            this.f17467x = true;
        }
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "mSupportUstVideoView: " + this.f17467x);
        }
        this.f17332A = new com.customize.contacts.manager.B(requireActivity().getApplicationContext());
        this.f17425g1 = new com.android.contacts.dialpad.c(getActivity());
        this.f17423f1 = N7.a.a();
        HandlerThread handlerThread = new HandlerThread("dialpad_register_thread");
        this.f17441m1 = handlerThread;
        handlerThread.start();
        this.f17444n1 = new s(this.f17441m1.getLooper(), this);
        A6();
        this.f17437l0 = new y(this);
        this.f17440m0 = new y(this);
        this.f17443n0 = new com.android.contacts.calllog.r(g4(), this);
        if (C1643c.w()) {
            U4();
        }
        this.f17343D1 = new x(0);
        if (B3.a.i()) {
            this.f17346E1 = new x(1);
        }
        if (FeatureOption.i() && com.android.contacts.framework.api.satellite.a.b()) {
            com.android.contacts.framework.api.satellite.a.f15607a.c().i(this, this.f17397V1);
        }
        if (AppMetaFeatures.b()) {
            CallRecordingsCache.f15754a.o().i(this, this.f17400W1);
        }
        this.f17448p = E0.a.h();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f17421e1;
        if (view != null) {
            return view;
        }
        I.d<DialpadView, Integer> e42 = e4();
        if (e42 != null) {
            this.f17457s0 = e42.f1295a;
            this.f17370M1.i(e42.f1296b.intValue());
        }
        View G42 = G4(layoutInflater, viewGroup);
        this.f17421e1 = G42;
        this.f17474z0 = G42.findViewById(R.id.dial_content);
        this.f21251e = (AppBarLayout) this.f17421e1.findViewById(R.id.appbar);
        this.f21250d = (TextView) this.f17421e1.findViewById(R.id.toolbar_title);
        this.f17354H0 = (TextView) this.f17421e1.findViewById(R.id.dummy_toolbar_title);
        this.f21249c = this.f17421e1.findViewById(R.id.content);
        this.f17438l1 = this.f17421e1.findViewById(R.id.paste_and_digit_container);
        this.f21248b = (COUIToolbar) this.f17421e1.findViewById(R.id.toolbar);
        this.f17348F0 = this.f17421e1.findViewById(R.id.toolbar_parent);
        this.f17460t1 = DisplayUtil.n(requireActivity());
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "onCreateView mShowChildUi = " + this.f17460t1);
        }
        k7();
        View b10 = com.android.contacts.framework.baseui.util.B.b(getContext(), false);
        this.f21251e.addView(b10, 0, b10.getLayoutParams());
        CoordinatorLayout.e eVar = (CoordinatorLayout.e) this.f21251e.getLayoutParams();
        this.f21253g = eVar;
        this.f21252f = (PrimaryTitleBehavior) eVar.f();
        o1();
        this.f17421e1.findViewById(R.id.top).setPadding(0, com.android.contacts.framework.baseui.util.B.a(getContext()), 0, 0);
        M4();
        V7();
        if (!TextUtils.isEmpty(this.f17447o1) && !this.f17460t1) {
            X6(this.f17447o1);
            this.f17447o1 = null;
        }
        M3(m4());
        DialerHeaderViewManager dialerHeaderViewManager = new DialerHeaderViewManager(getActivity(), this.f17356I, new Runnable() { // from class: com.android.contacts.n0
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.v6();
            }
        });
        this.f17418d0 = dialerHeaderViewManager;
        dialerHeaderViewManager.i0(new i());
        this.f17418d0.M();
        View F10 = this.f17418d0.F();
        if (F10 != null) {
            F10.setVisibility(8);
        }
        L4();
        K4();
        P4();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.call_log_list_header_layout, (ViewGroup) null);
        linearLayout.addView(F10);
        linearLayout.setId(R.id.call_log_header_view);
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
        if (headerFooterRecyclerView != null) {
            headerFooterRecyclerView.x(linearLayout);
        }
        W7(false);
        this.f21251e.getViewTreeObserver().addOnGlobalLayoutListener(new j());
        return this.f17421e1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        H7.b.e("DialtactsFragment", "onDestroy");
        this.f17430j.e();
        if (this.f17448p) {
            E0.a.i();
        }
        this.f17425g1.o(true);
        this.f17439m.removeCallbacksAndMessages(null);
        F6();
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.g2();
            this.f17446o0.I0(null);
            this.f17446o0.t1();
        }
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
        if (headerFooterRecyclerView != null) {
            headerFooterRecyclerView.setFocusable(false);
        }
        com.customize.contacts.manager.B b10 = this.f17332A;
        if (b10 != null) {
            b10.n();
        }
        Q7(this.f17335B);
        Q7(this.f17341D);
        Q7(this.f17344E);
        Q7(this.f17347F);
        R7(this.f17338C);
        P7();
        Q7(this.f17350G);
        S7();
        O7();
        if (C1643c.w()) {
            X.a.b(d4()).e(this.f17340C1);
        }
        this.f17441m1.quit();
        this.f17444n1.removeCallbacksAndMessages(null);
        this.f17446o0 = null;
        this.f17429i1 = null;
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null) {
            dialEditText.removeTextChangedListener(this);
        }
        U0.n.f();
        ThreadPoolExecutor threadPoolExecutor = this.f17423f1;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            this.f17423f1 = null;
        }
        if (C1643c.w()) {
            C1643c.b();
        }
        super.onDestroy();
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isChangingConfigurations()) {
            Q0.c("");
        }
        if (FeatureOption.i() && com.android.contacts.framework.api.satellite.a.b()) {
            com.android.contacts.framework.api.satellite.a.f15607a.c().n(this.f17397V1);
        }
        H7.b.e("DialtactsFragment", "onDestroy end");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f17436l.F();
    }

    @Override // com.android.contacts.calllog.k.j
    public void onItemClick(View view, final int i10, final int i11) {
        final com.android.contacts.calllog.o oVar;
        Object tag = view.getTag(R.id.call_log_view_key);
        com.android.contacts.calllog.G g10 = null;
        if (tag instanceof com.android.contacts.calllog.o) {
            oVar = (com.android.contacts.calllog.o) tag;
        } else {
            oVar = null;
        }
        if (oVar != null && oVar.f14008a != null) {
            boolean e52 = e5();
            H7.b.e("DialtactsFragment", "onItemClick: isEditMode: " + e52);
            if (e52) {
                com.android.contacts.calllog.k kVar = this.f17446o0;
                if (kVar != null) {
                    kVar.h2(oVar.f14008a, true, true);
                    return;
                }
                return;
            }
            if (C7.a.a()) {
                H7.b.i("DialtactsFragment", "onItemClick: Ignore too fast click!");
                return;
            }
            Object tag2 = oVar.f14008a.getTag();
            if (tag2 instanceof com.android.contacts.calllog.G) {
                g10 = (com.android.contacts.calllog.G) tag2;
            }
            final com.android.contacts.calllog.G g11 = g10;
            if (g11 == null) {
                H7.b.i("DialtactsFragment", "onItemClick: no intentProvider!");
                return;
            }
            final Context context = getContext();
            final boolean d52 = d5();
            N7.a.b().execute(new Runnable() { // from class: com.android.contacts.b0
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC0694u0.this.I5(g11, context, d52, oVar, i10, i11);
                }
            });
            return;
        }
        H7.b.i("DialtactsFragment", "onItemClick: views or primary action view is null!");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processFallThroughCases(RegionMaker.java:841)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:800)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processFallThroughCases(RegionMaker.java:841)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:800)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0038. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x003b. Please report as an issue. */
    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(android.view.View r7) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.ViewOnClickListenerC0694u0.onLongClick(android.view.View):boolean");
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z10) {
        super.onMultiWindowModeChanged(z10);
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "onMultiWindowModeChanged isInMultiWindowMode=" + z10);
        }
        if (o5()) {
            B4();
        }
        if (!z10) {
            K6();
        }
        if (OsUtils.f28279e) {
            u8();
            W7(false);
            N6();
            T7();
            U7();
            y6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        DialEditText dialEditText;
        H7.b.e("DialtactsFragment", "onPause");
        super.onPause();
        if (getActivity() != null) {
            com.android.contacts.framework.baseui.util.A.g(getActivity());
        }
        this.f17423f1.execute(new Runnable() { // from class: com.android.contacts.z
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.K5();
            }
        });
        L7();
        this.f17369M0 = false;
        this.f17372N0 = false;
        if ("vnd.android.cursor.dir/calls".equals(m4().getType())) {
            m4().setType(null);
        }
        if (this.f17381Q0) {
            if (!d5() && (dialEditText = this.f17433k) != null && (dialEditText.length() < 3 || (this.f17433k.length() >= 3 && l4().endsWith("#")))) {
                this.f17439m.sendEmptyMessageDelayed(59, 500L);
            }
            this.f17381Q0 = false;
        }
        this.f17417c1 = "";
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f17391T1 = false;
        com.android.contacts.framework.baseui.util.A.h(getActivity());
        boolean c52 = c5();
        com.customize.contacts.util.d0.p().B();
        H7.b.b("DialtactsFragment", "onResume() isDiallerTab = " + c52);
        if (c52) {
            com.android.contacts.calllog.k kVar = this.f17446o0;
            if (kVar != null && !kVar.h1() && this.f17418d0 != null) {
                N7.a.b().execute(new Runnable() { // from class: com.android.contacts.A
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC0694u0.this.M5();
                    }
                });
            }
            this.f17439m.sendEmptyMessageDelayed(81, COUIScrollBar.SCROLLER_FADE_TIMEOUT);
            if (!this.f17445o) {
                Q3();
            }
            this.f17393U0 = true;
        }
        com.android.contacts.calllog.k kVar2 = this.f17446o0;
        if (kVar2 != null) {
            kVar2.f2(true);
        }
        com.android.contacts.calllog.k kVar3 = this.f17446o0;
        if (kVar3 != null && kVar3.U0() != null) {
            this.f17446o0.f1();
            if (!this.f17445o) {
                this.f17423f1.execute(new Runnable() { // from class: com.android.contacts.B
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC0694u0.this.N5();
                    }
                });
            }
        }
        H3();
        this.f17423f1.execute(new Runnable() { // from class: com.android.contacts.C
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.O5();
            }
        });
        L6();
        if (i5() && !d5() && !this.f17369M0) {
            I7(l4());
        }
        View view = this.f17465w0;
        if (view != null && view.getVisibility() == 0) {
            P6(true, true);
        }
        C0638c.f15889a.e();
        View view2 = this.f17421e1;
        if (view2 != null) {
            view2.getViewTreeObserver().addOnGlobalLayoutListener(new k());
        }
        this.f17445o = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null && dialEditText.getText() != null) {
            bundle.putString("key_number", l4());
            bundle.putString("key_pre_secret_code_input", C1390c.c());
        }
        bundle.putInt("pressed_key_number", this.f17470y);
        bundle.putBoolean("dialpad_state", this.f17383R);
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            bundle.putBoolean("filter_missed_state", kVar.A());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        H7.b.e("DialtactsFragment", "onStart, the mIsFirst is " + this.f17445o);
        super.onStart();
        this.f17425g1.j();
        if (this.f17445o && c5()) {
            w7();
        }
        if (!this.f17392U) {
            z6();
            if (!this.f17388S1) {
                F7();
            }
        } else {
            HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
            if (headerFooterRecyclerView != null && headerFooterRecyclerView.getAlpha() == 0.0f) {
                F7();
            }
        }
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.T1(false);
            this.f17446o0.J1(true);
        }
        this.f17392U = false;
        E3.q qVar = this.f17410a0;
        if (qVar != null) {
            qVar.v();
        }
        E3.o oVar = this.f17413b0;
        if (oVar != null) {
            oVar.j();
        }
        this.f17423f1.execute(new Runnable() { // from class: com.android.contacts.o0
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.i7();
            }
        });
        T3();
        U3();
        if (this.f17442n) {
            this.f17449p0 = true;
            this.f17442n = false;
        }
        this.f17384R0 = false;
        if (Q0.b()) {
            String f10 = Q0.f();
            if (!this.f17369M0 && !TextUtils.equals(f10, l4())) {
                this.f17372N0 = true;
                V3(f10);
            }
            Boolean a10 = Q0.a();
            if (a10 != null) {
                H7.b.e("DialtactsFragment", "sceneDialpadShow: " + a10);
                t7(a10.booleanValue(), false);
                Q0.e(null);
            }
        }
        com.android.contacts.framework.api.breenocall.a.g(new RunnableC0661p0(this));
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        this.f17436l.onStatusBarClicked();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        H7.b.e("DialtactsFragment", "onStop");
        this.f17391T1 = true;
        if (B3.a.b0()) {
            CallLogItemCacheManager.f13737c.a().f(requireContext());
        }
        E3.q qVar = this.f17410a0;
        if (qVar != null) {
            qVar.y();
        }
        E3.o oVar = this.f17413b0;
        if (oVar != null) {
            oVar.l();
            this.f17413b0.c();
        }
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.T1(true);
            this.f17446o0.g2();
        }
        this.f17423f1.execute(new Runnable() { // from class: com.android.contacts.N
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.j7();
            }
        });
        this.f17425g1.o(false);
        if (this.f17384R0) {
            J3();
            this.f17384R0 = false;
        }
        if (this.f17442n) {
            J3();
        }
        Z3.j.d();
        D4();
        Q0.c(l4());
        R7.d.j(this.f17414b1, "cache_key_call_log_count", this.f17396V0);
        super.onStop();
        H7.b.e("DialtactsFragment", "onStop end");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        String charSequence2 = charSequence.toString();
        if (charSequence2.equals(this.f17359J)) {
            return;
        }
        this.f17359J = charSequence2;
    }

    @Override // com.customize.contacts.fragment.MainFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f17460t1) {
            i8();
        }
        ((AppBarLayoutView) this.f21251e).setMeasureListener(new AppBarLayoutView.b() { // from class: com.android.contacts.K
            @Override // com.android.contacts.framework.baseui.widget.AppBarLayoutView.b
            public final void a() {
                ViewOnClickListenerC0694u0.this.P5();
            }
        });
    }

    @Override // w7.b
    public void p0() {
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "onItemDragScrollStart ---------");
        }
        a7(1);
    }

    public int p4() {
        MenuItem menuItem;
        if (-1 == this.f17466w1) {
            Resources resources = getResources();
            this.f17469x1 = resources.getDimensionPixelSize(R.dimen.large_toolbar_height);
            this.f17466w1 = resources.getDimensionPixelSize(R.dimen.toolbar_title_init_height) - resources.getDimensionPixelSize(R.dimen.unfold_divider_width);
        }
        if (o5() && (menuItem = this.f17432j1) != null && !menuItem.isVisible()) {
            return this.f17466w1;
        }
        return this.f17469x1 + this.f17466w1;
    }

    public boolean p5() {
        ContactsTabActivity f42 = f4();
        if (f42 == null || !f42.isInMultiWindowMode() || !this.f17460t1 || DisplayUtil.e(f42, false) > getResources().getDimensionPixelSize(R.dimen.DP_480)) {
            return false;
        }
        return true;
    }

    public final void p6(int i10) {
        String r42 = r4();
        if (!TextUtils.isEmpty(r42) && TextUtils.isGraphic(r42)) {
            o6(i10);
        } else {
            c7();
        }
    }

    public final void p7(boolean z10) {
        int j10 = com.customize.contacts.util.b0.j();
        FragmentActivity activity = getActivity();
        com.customize.contacts.manager.B b10 = this.f17332A;
        if (b10 != null && activity != null) {
            b10.o(activity, true, j10, this.f17473z.d(), z10);
        }
    }

    public void p8(boolean z10) {
        ContactsTabActivity f42 = f4();
        if (f42 != null) {
            f42.t3(z10);
        }
    }

    public boolean q5() {
        DialPadFragmentViewModel dialPadFragmentViewModel = this.f17370M1;
        boolean z10 = false;
        if (dialPadFragmentViewModel == null) {
            return false;
        }
        if (dialPadFragmentViewModel.g() == 1) {
            z10 = true;
        }
        if (H7.a.b()) {
            H7.b.e("DialtactsFragment", "isStrokes = " + z10);
        }
        return z10;
    }

    public final void q6() {
        if (this.f17374O > 1) {
            l6(h4());
        } else {
            l6(-1);
        }
        C0710y.a(getActivity(), k4());
    }

    public final void q7(boolean z10) {
        boolean z11;
        View view;
        H7.b.b("DialtactsFragment", "showDialPadAnimation");
        if (this.f17353H.n()) {
            Log.i("DialtactsFragment", "ShowDialPad animation is running");
            return;
        }
        if (f4() == null) {
            return;
        }
        if (this.f17460t1) {
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", "showDialPadAnimation but mIsShowUnfoldScreen");
            }
            z11 = true;
        } else {
            z11 = z10;
        }
        O4();
        if (this.f17450p1 != null) {
            boolean c52 = c5();
            if (c52) {
                j8();
            }
            if (this.f17460t1) {
                this.f17353H.u(this.f17356I, null, this.f17450p1, z11, c52);
                if (c52 && (view = this.f17458s1) != null) {
                    view.setAlpha(1.0f);
                }
            } else {
                this.f17353H.u(this.f17356I, this.f17458s1, this.f17450p1, z11, c52);
            }
            U6(true);
        }
    }

    public void q8() {
        l8();
        boolean z10 = false;
        if (!this.f17460t1 && !f5()) {
            y7(false);
            return;
        }
        if (d5()) {
            if (this.f17396V0 <= 0 && !this.f17460t1) {
                y7(false);
                return;
            }
            if (!this.f17446o0.A() ? this.f17396V0 <= 0 : this.f17399W0 <= 0) {
                z10 = true;
            }
            y7(z10);
            return;
        }
        y7(false);
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public boolean r1() {
        ContactsTabActivity f42 = f4();
        if (f42 != null) {
            f42.e3(0);
            if (n4() && j4() == 0 && !f5()) {
                return true;
            }
        }
        return false;
    }

    public final String r4() {
        if (this.f17375O0) {
            String str = this.f17378P0;
            this.f17375O0 = false;
            return str;
        }
        if (this.f17360J0) {
            return this.f17363K0;
        }
        if (m5()) {
            return this.f17408Z0;
        }
        return l4();
    }

    public boolean r5() {
        return false;
    }

    public final void r6() {
        String r42 = r4();
        if (!TextUtils.isEmpty(r42) && TextUtils.isGraphic(r42)) {
            q6();
        } else {
            c7();
        }
    }

    public void r7() {
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "showDialpad--");
        }
        synchronized (this.f17407Z) {
            try {
                if (!this.f17383R) {
                    if (!d5()) {
                        this.f17438l1.setVisibility(0);
                        this.f17459t0.setVisibility(0);
                        this.f21249c.setVisibility(8);
                    }
                    q7(true);
                    E3.c cVar = this.f17398W;
                    if (cVar == null || !cVar.A()) {
                        o7();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r8() {
        EmptyViewGroup emptyViewGroup = this.f17462u1;
        if (emptyViewGroup != null && emptyViewGroup.getVisibility() == 0) {
            Resources resources = this.f17462u1.getContext().getResources();
            if (this.f17460t1) {
                this.f17462u1.j(resources.getDimensionPixelSize(R.dimen.contact_bottom_tab_unfold_height));
                this.f17462u1.k(resources.getDimensionPixelSize(R.dimen.DP_129));
                this.f17462u1.m(false);
                this.f17462u1.l(false);
                return;
            }
            this.f17462u1.k(i4());
            this.f17462u1.j(0);
            this.f17462u1.m(true);
            this.f17462u1.l(true);
        }
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void s1() {
        this.f17398W.E();
    }

    public RecyclerView s4() {
        return this.f17416c0;
    }

    public final void s5(int i10) {
        log("keyPressed::keyCode:" + i10);
        if (com.customize.contacts.util.d0.p().v()) {
            return;
        }
        if (!i5()) {
            Q4();
        }
        if (this.f17433k == null) {
            return;
        }
        com.customize.contacts.util.d0.p().z(i10, null, null);
        KeyEvent keyEvent = new KeyEvent(0, i10);
        if (i10 == 67) {
            this.f17433k.onKeyDown(i10, keyEvent);
            return;
        }
        this.f17433k.onKeyDown(i10, keyEvent);
        int length = this.f17433k.length();
        if (length == this.f17433k.getSelectionStart() && length == this.f17433k.getSelectionEnd()) {
            V6(false);
        }
    }

    public void s7(boolean z10) {
        t7(z10, true);
    }

    public void s8(boolean z10) {
        boolean z11;
        if (this.f17435k1 != null) {
            boolean a52 = a5();
            boolean d52 = d5();
            boolean m52 = m5();
            if (z10 && a52 && d52 && !m52) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f17435k1.setVisible(z11);
            if (H7.a.b()) {
                H7.b.b("DialtactsFragment", String.format("updateSearchMenuVisible: ret = %s, isContactsProviderStatusNormal = %s, isDigitsEmpty = %s, isPasteLayoutVisible= %s", Boolean.valueOf(z11), Boolean.valueOf(a52), Boolean.valueOf(d52), Boolean.valueOf(m52)));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        HeaderFooterRecyclerView headerFooterRecyclerView;
        super.setUserVisibleHint(z10);
        if (isAdded() && (headerFooterRecyclerView = this.f17416c0) != null) {
            headerFooterRecyclerView.setDisallowReceiveTouchEvent(!z10);
        }
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void t1() {
        this.f17423f1.execute(new Runnable() { // from class: com.android.contacts.Y
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.J5();
            }
        });
    }

    public final /* synthetic */ void t5(String str) {
        this.f17418d0.v0(getContext(), str);
    }

    public final void t6(Intent intent, int i10) {
        if (OsUtils.f28275a.j()) {
            PhoneAccountHandle s10 = com.customize.contacts.util.b0.s(getContext(), i10);
            if (s10 != null) {
                intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", s10);
                return;
            }
            return;
        }
        intent.putExtra(OplusPhoneUtils.SUBSCRIPTION_KEY, i10);
    }

    public final void t7(boolean z10, boolean z11) {
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "showDialpad show " + z10 + ", mDialpadIsShow = " + this.f17383R);
        }
        if (this.f17383R == z10) {
            log("current state is the same as needed show " + z10);
        }
        if (z10) {
            q7(!z11);
            return;
        }
        DialEditText dialEditText = this.f17433k;
        if (dialEditText != null && dialEditText.getSelectionEnd() != this.f17433k.getSelectionStart()) {
            this.f17433k.clearFocus();
        }
        A4(!z11);
    }

    public final void t8(boolean z10) {
        MenuItem menuItem = this.f17432j1;
        if (menuItem != null) {
            menuItem.setVisible(z10);
        }
        s8(z10);
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void u1() {
        if (!e5()) {
            return;
        }
        E3.c cVar = this.f17398W;
        if (cVar != null) {
            cVar.F();
            HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
            if (headerFooterRecyclerView != null) {
                headerFooterRecyclerView.k();
            }
        }
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.y1();
        }
        DialerHeaderViewManager dialerHeaderViewManager = this.f17418d0;
        if (dialerHeaderViewManager != null) {
            dialerHeaderViewManager.F0(true);
        }
        if (o5()) {
            x6();
        }
    }

    public final String u4() {
        try {
            if (this.f17402X0 == null) {
                this.f17402X0 = (ClipboardManager) d4().getSystemService("clipboard");
            }
            ClipData primaryClip = this.f17402X0.getPrimaryClip();
            if (primaryClip != null) {
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                if (itemAt != null && itemAt.getText() != null) {
                    Matcher matcher = f17331e2.matcher(itemAt.getText().toString().replaceAll("\u200b", ""));
                    if (matcher.find()) {
                        String group = matcher.group();
                        if (H7.a.b()) {
                            H7.b.b("DialtactsFragment", "content = " + H7.a.d(group));
                        }
                        if (group != null) {
                            H7.b.e("DialtactsFragment", "length = " + group.length());
                        }
                        long timestamp = primaryClip.getDescription().getTimestamp();
                        long j10 = this.f17414b1.getLong("last_timestamp", -1L);
                        if (timestamp <= j10) {
                            if (H7.a.b()) {
                                H7.b.b("DialtactsFragment", "timestamp = " + timestamp + ", lastTimestamp = " + j10);
                            }
                            return null;
                        }
                        if (TextUtils.isEmpty(group)) {
                            return null;
                        }
                        String replace = group.replace(" ", "");
                        if (replace.length() > 6 && replace.length() < 18) {
                            String formatNumber = PhoneNumberUtils.formatNumber(group, C1074c.b(d4()));
                            if (!TextUtils.isEmpty(formatNumber)) {
                                if (formatNumber.length() <= 6) {
                                    return null;
                                }
                                group = formatNumber;
                            }
                            this.f17411a1 = timestamp;
                            return group;
                        }
                    }
                    return null;
                }
                H7.b.e("DialtactsFragment", "content =========== null");
                return null;
            }
        } catch (Exception e10) {
            H7.b.e("DialtactsFragment", "e = " + e10);
        }
        return null;
    }

    public final /* synthetic */ void u5() {
        final String a10 = P7.d.a(d4());
        this.f17439m.post(new Runnable() { // from class: com.android.contacts.P
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.t5(a10);
            }
        });
    }

    public final void u6(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new AsyncTaskC0696b(str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 0);
    }

    public void u7() {
        e8(true);
    }

    public void u8() {
        boolean z10;
        if (this.f17348F0 != null) {
            BaseTitleBehavior baseTitleBehavior = this.f21252f;
            boolean z11 = true;
            if (baseTitleBehavior != null && baseTitleBehavior.Q()) {
                z10 = true;
            } else {
                z10 = false;
            }
            View view = this.f17438l1;
            if (view == null || view.getVisibility() != 0) {
                z11 = false;
            }
            if (o5() && (z10 || z11)) {
                this.f17348F0.setVisibility(8);
                return;
            }
            if (!this.f17460t1) {
                this.f17348F0.setVisibility(0);
            } else if (z10) {
                this.f17348F0.setVisibility(8);
            } else {
                this.f17348F0.setVisibility(0);
            }
        }
    }

    public final String v4(int i10) {
        String voiceMailNumber;
        log("[getVoiceMailNumber] slotId = " + i10);
        try {
            if (B3.a.i()) {
                voiceMailNumber = D7.c.e(Integer.valueOf(i10));
            } else {
                voiceMailNumber = ((TelephonyManager) requireActivity().getSystemService(TelephonyManager.class)).getVoiceMailNumber();
            }
            return voiceMailNumber;
        } catch (Throwable th) {
            H7.b.c("DialtactsFragment", "getVoiceMailNumber, the e is " + th);
            return null;
        }
    }

    public final /* synthetic */ void v5() {
        KeyguardManager keyguardManager;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        int state = activity.getDisplay().getState();
        H7.b.e("DialtactsFragment", "cancelMissCall displayState : " + state);
        if (state != 1 && (keyguardManager = (KeyguardManager) activity.getSystemService("keyguard")) != null && !keyguardManager.isKeyguardLocked()) {
            com.android.contacts.business.calllog.a.a(activity);
        }
    }

    public final void v6() {
        this.f17439m.post(new Runnable() { // from class: com.android.contacts.V
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC0694u0.this.Q5();
            }
        });
    }

    public final void v7() {
        if (!isAdded()) {
            return;
        }
        new COUIAlertDialogBuilder(requireActivity()).setTitle(R.string.dialog_callFailed_simError).setPositiveButton(R.string.oplus_know, (DialogInterface.OnClickListener) null).show();
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void w1(boolean z10) {
        super.w1(z10);
        l8();
    }

    public final void w4(int i10, String str) {
        log("handleCallStateChanged: " + i10 + ", '" + H7.a.d(str) + "'");
        if (getActivity() != null && this.f17393U0) {
            if (i10 == 0) {
                if (!this.f17451q) {
                    Q3();
                }
                this.f17451q = true;
            } else if (i10 == 1) {
                this.f17451q = false;
            } else if (i10 == 2) {
                this.f17451q = false;
            }
            if ((i10 == 0 || i10 == 2) && this.f17381Q0) {
                this.f17381Q0 = false;
            }
        }
    }

    public final /* synthetic */ void w5() {
        this.f17425g1.i();
        com.android.contacts.dialpad.j jVar = this.f17427h1;
        if (jVar != null) {
            jVar.a(getActivity());
        }
    }

    public void w6() {
        r7();
    }

    public final void w7() {
        if (Z4(m4())) {
            if ((!this.f17369M0 && !k6()) || (o5() && !this.f17355H1)) {
                log("isCallLogIntent, hide dialpad");
                B4();
            }
            if (this.f17433k != null && !d5() && !this.f17369M0) {
                log("isCallLogIntent clear digits");
                I3();
                return;
            }
            return;
        }
        if (o5() && !this.f17355H1) {
            B4();
        } else if (!e5()) {
            r7();
        }
    }

    public void x4() {
        E3.c cVar = this.f17398W;
        if (cVar != null) {
            cVar.z();
        }
    }

    public final /* synthetic */ void x5(DialogInterface dialogInterface, int i10) {
        if (i10 == -1) {
            this.f17475z1 = true;
        }
    }

    public void x6() {
        boolean n52 = n5();
        e7(n52);
        E3.c cVar = this.f17398W;
        if (cVar != null && cVar.A()) {
            l7(false);
        } else {
            l7(n52);
        }
        f8();
    }

    public final void x7(boolean z10) {
        int i10;
        Log.i("DialtactsFragment", "showFloatingTabView : " + z10);
        FloatingTabView floatingTabView = this.f17351G0;
        if (floatingTabView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            floatingTabView.setVisibility(i10);
        }
    }

    @Override // com.customize.contacts.manager.B.b
    public void y0(int i10, boolean z10, boolean z11, boolean z12, int i11) {
        this.f17374O = i10;
        this.f17365L = z10;
        this.f17368M = z11;
        this.f17371N = z12;
        if (i10 == 2) {
            this.f17362K = i11;
        } else {
            this.f17362K = -1;
        }
        if (H7.a.b()) {
            H7.b.b("DialtactsFragment", "updateWifiCallingStatus: availableSimCount: " + i10 + ", isSim1WifiCalling: " + z10 + ", isSim2WifiCalling: " + z11 + ", isSupportVideoCall: " + z12 + ", defaultSlotId: " + i11 + ", mDefaultSlotId: " + this.f17362K);
        }
        a8();
    }

    public final /* synthetic */ void y5(DialogInterface dialogInterface, int i10) {
        if (i10 == -1) {
            this.f17472y1 = true;
        }
    }

    public void y6() {
        ScrollRelativeLayout scrollRelativeLayout;
        int dimensionPixelSize;
        int i10;
        boolean z10;
        int i11;
        this.f17361J1 = false;
        if (o5()) {
            ContactsTabActivity f42 = f4();
            if (f42 != null) {
                int e10 = DisplayUtil.e(f42, false);
                if (e10 <= getResources().getDimensionPixelSize(R.dimen.DP_240)) {
                    i11 = getResources().getDimensionPixelSize(R.dimen.dialpad_container_smallest_height);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dialpad_button_smallest_height);
                    c8(getResources().getDimensionPixelSize(R.dimen.DP_48));
                    i10 = dimensionPixelSize2;
                    z10 = true;
                } else {
                    if (e10 <= getResources().getDimensionPixelSize(R.dimen.DP_360)) {
                        dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dialpad_container_small_height);
                        i10 = getResources().getDimensionPixelSize(R.dimen.dialpad_button_small_height);
                        c8(getResources().getDimensionPixelSize(R.dimen.DP_48));
                    } else {
                        dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dialpad_container_medium_height);
                        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.dialpad_button_medium_height);
                        c8(getResources().getDimensionPixelSize(R.dimen.DP_56));
                        i10 = dimensionPixelSize3;
                    }
                    int i12 = dimensionPixelSize;
                    z10 = false;
                    i11 = i12;
                }
                d8(i11, getResources().getDimensionPixelSize(R.dimen.DP_8));
                g8(i10, true, z10);
                if (!this.f17383R) {
                    float f10 = i11;
                    if (this.f17356I.getTranslationY() < f10) {
                        this.f17356I.setTranslationY(f10);
                    }
                }
                this.f17358I1 = true;
            }
        } else if (p5()) {
            if (DisplayUtil.e(f4(), false) <= getResources().getDimensionPixelSize(R.dimen.DP_420)) {
                d8(getResources().getDimensionPixelSize(R.dimen.dialpad_container_small_height), getResources().getDimensionPixelSize(R.dimen.DP_8));
                g8(getResources().getDimensionPixelSize(R.dimen.dialpad_button_small_height), true, false);
            } else {
                d8(getResources().getDimensionPixelSize(R.dimen.dialpad_container_medium_height), getResources().getDimensionPixelSize(R.dimen.DP_8));
                g8(getResources().getDimensionPixelSize(R.dimen.dialpad_button_medium_height), true, false);
            }
            this.f17364K1 = true;
        } else if (X4()) {
            d8(getResources().getDimensionPixelSize(R.dimen.dialpad_container_biggest_height), getResources().getDimensionPixelSize(R.dimen.DP_20));
            g8(getResources().getDimensionPixelSize(R.dimen.dialpad_button_biggest_height), false, false);
            this.f17457s0.setDialpadPaddingTop(getResources().getDimensionPixelSize(R.dimen.dialpad_buttons_biggest_paddingTop));
            c8(getResources().getDimensionPixelSize(R.dimen.dialpad_button_biggest_height));
            this.f17364K1 = true;
            this.f17361J1 = true;
        } else {
            if (!this.f17358I1 && !this.f17364K1) {
                return;
            }
            d8(getResources().getDimensionPixelSize(R.dimen.new_dialpad_container_empty_height), getResources().getDimensionPixelSize(R.dimen.DP_20));
            if (this.f17358I1 && !this.f17383R && (scrollRelativeLayout = this.f17356I) != null) {
                scrollRelativeLayout.setTranslationY(getResources().getDimensionPixelSize(R.dimen.new_dialpad_container_empty_height));
            }
            g8(getResources().getDimensionPixelSize(R.dimen.dialpad_button_height), false, false);
            this.f17457s0.setDialpadPaddingTop(getResources().getDimensionPixelSize(R.dimen.dialpad_buttons_paddingTop));
            c8(getResources().getDimensionPixelSize(R.dimen.DP_56));
            this.f17358I1 = false;
            this.f17364K1 = false;
        }
        if (this.f17416c0 != null && e5()) {
            boolean j10 = DisplayUtil.j(getActivity());
            if (this.f17361J1 && !j10) {
                this.f17416c0.setDragRegionWidth(requireContext().getResources().getDimensionPixelSize(R.dimen.DP_145));
            } else {
                this.f17416c0.setDragRegionWidth(requireContext().getResources().getDimensionPixelSize(R.dimen.DP_60));
            }
        }
    }

    public final void y7(boolean z10) {
        int i10;
        if (z10) {
            R4();
            EmptyViewGroup emptyViewGroup = this.f17462u1;
            if (emptyViewGroup != null) {
                emptyViewGroup.setVisibility(0);
                TextView textView = this.f17345E0;
                if (textView != null) {
                    com.android.contacts.calllog.k kVar = this.f17446o0;
                    if (kVar != null && kVar.A() && this.f17396V0 > 0) {
                        i10 = R.string.no_missed_call;
                    } else {
                        i10 = R.string.no_call_log;
                    }
                    textView.setText(i10);
                }
                r8();
                return;
            }
            return;
        }
        EmptyViewGroup emptyViewGroup2 = this.f17462u1;
        if (emptyViewGroup2 != null) {
            emptyViewGroup2.setVisibility(8);
        }
    }

    public final void z4() {
        this.f17357I0 = -1;
        if (B3.a.i()) {
            int c10 = this.f17473z.c();
            if (c10 == 1) {
                if (!this.f17473z.f()) {
                    this.f17357I0 = 0;
                } else if (!this.f17473z.g()) {
                    this.f17357I0 = 1;
                }
                if (this.f17357I0 == -1) {
                    B7();
                    I3();
                    return;
                }
            } else if (c10 > 1) {
                C7();
                return;
            } else if (c10 == 0) {
                B7();
                I3();
                return;
            }
            if (this.f17357I0 == -1) {
                return;
            }
        }
        String v42 = v4(this.f17357I0);
        log("callVoicemailGemini--number=" + H7.a.d(v42));
        if (TextUtils.isEmpty(v42)) {
            D7(this.f17357I0);
        } else {
            R7.b.d(getActivity(), b6(), R.string.activity_not_found);
        }
        I3();
    }

    public final /* synthetic */ void z5(boolean z10, ContactsTabActivity contactsTabActivity, CharSequence charSequence, boolean z11, CharSequence charSequence2) {
        if (z10 && this.f17337B1) {
            com.android.contacts.framework.baseui.util.l.g(contactsTabActivity, "com.ted.number", charSequence, new DialogInterface.OnClickListener() { // from class: com.android.contacts.g0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    ViewOnClickListenerC0694u0.this.x5(dialogInterface, i10);
                }
            }, 1);
            this.f17337B1 = false;
        }
        if (z11 && this.f17334A1) {
            com.android.contacts.framework.baseui.util.l.g(contactsTabActivity, C1501d.f36275d, charSequence2, new DialogInterface.OnClickListener() { // from class: com.android.contacts.i0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    ViewOnClickListenerC0694u0.this.y5(dialogInterface, i10);
                }
            }, 1);
            this.f17334A1 = false;
        }
    }

    public final void z6() {
        com.android.contacts.calllog.k kVar = this.f17446o0;
        if (kVar != null) {
            kVar.U1(android.text.format.DateFormat.getTimeFormat(getActivity()));
            this.f17446o0.E1(F7.b.e(getActivity()));
        }
    }

    public final void z7() {
        String u42 = u4();
        this.f17408Z0 = u42;
        if (!TextUtils.isEmpty(u42)) {
            S4();
            i8();
        } else {
            D4();
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$c */
    /* loaded from: classes.dex */
    public class C0697c implements g.b {
        public C0697c() {
        }

        @Override // com.android.contacts.dialpad.g.b
        public void b(String str) {
            int i10;
            ViewOnClickListenerC0694u0.this.f17360J0 = true;
            ViewOnClickListenerC0694u0.this.f17363K0 = str;
            com.android.contacts.framework.baseui.util.A.a(ViewOnClickListenerC0694u0.this.getContext(), 2000305, 200030501, com.customize.contacts.util.h0.b0(ViewOnClickListenerC0694u0.this.getActivity()), false);
            if (ViewOnClickListenerC0694u0.this.f17473z.c() < 2) {
                ViewOnClickListenerC0694u0.this.l6(-1);
            } else {
                if (!com.customize.contacts.util.b0.B0(ViewOnClickListenerC0694u0.this.getContext())) {
                    i10 = com.customize.contacts.util.b0.k(ViewOnClickListenerC0694u0.this.getContext());
                } else {
                    i10 = -1;
                }
                if (i10 != -1) {
                    ViewOnClickListenerC0694u0.this.l6(i10);
                } else {
                    ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = ViewOnClickListenerC0694u0.this;
                    viewOnClickListenerC0694u0.W6(viewOnClickListenerC0694u0.f17363K0);
                }
            }
            ViewOnClickListenerC0694u0.this.f17360J0 = false;
        }

        @Override // com.android.contacts.dialpad.g.b
        public void c(int i10) {
            ViewOnClickListenerC0694u0.this.h7(i10);
            ViewOnClickListenerC0694u0.this.f17366L0.q(2);
        }

        @Override // com.android.contacts.dialpad.g.b
        public void a(int i10) {
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$d */
    /* loaded from: classes.dex */
    public class C0698d implements Z3.h {
        public C0698d() {
        }

        @Override // Z3.h
        public void a(boolean z10) {
            COUIToolbar cOUIToolbar = ViewOnClickListenerC0694u0.this.f21248b;
            if (cOUIToolbar != null) {
                cOUIToolbar.getMenu().clear();
                boolean z11 = true;
                if (z10) {
                    ViewOnClickListenerC0694u0.this.f21248b.inflateMenu(R.menu.dialer_menu);
                    ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = ViewOnClickListenerC0694u0.this;
                    viewOnClickListenerC0694u0.f17432j1 = viewOnClickListenerC0694u0.f21248b.getMenu().findItem(R.id.dialer_more_menu);
                    ViewOnClickListenerC0694u0 viewOnClickListenerC0694u02 = ViewOnClickListenerC0694u0.this;
                    viewOnClickListenerC0694u02.f17435k1 = viewOnClickListenerC0694u02.f21248b.getMenu().findItem(R.id.search_menu);
                    int e10 = R7.d.e(ViewOnClickListenerC0694u0.this.f17414b1, "contacts_provider_status", -1);
                    if (H7.a.b()) {
                        H7.b.e("DialtactsFragment", "contactsProviderStatus :" + e10);
                    }
                    ViewOnClickListenerC0694u0 viewOnClickListenerC0694u03 = ViewOnClickListenerC0694u0.this;
                    viewOnClickListenerC0694u03.f17435k1.setContentDescription(viewOnClickListenerC0694u03.getString(R.string.menu_search));
                    MenuItem menuItem = ViewOnClickListenerC0694u0.this.f17435k1;
                    if (e10 != 0) {
                        z11 = false;
                    }
                    menuItem.setVisible(z11);
                    e();
                    f(ViewOnClickListenerC0694u0.this.n4());
                    ViewOnClickListenerC0694u0.this.w1(false);
                    ViewOnClickListenerC0694u0.this.f21248b.setIsTitleCenterStyle(false);
                    return;
                }
                ViewOnClickListenerC0694u0.this.f21248b.inflateMenu(R.menu.cancel_select_menu);
                ViewOnClickListenerC0694u0.this.f21248b.setNavigationIcon((Drawable) null);
                ViewOnClickListenerC0694u0.this.f21248b.setIsTitleCenterStyle(true);
                ViewOnClickListenerC0694u0.this.w1(true);
            }
        }

        @Override // Z3.h
        public void b() {
            H7.b.b("DialtactsFragment", "DialtactsFragment enterEditMode");
            a(false);
            ViewOnClickListenerC0694u0.this.k8(true);
            if (ViewOnClickListenerC0694u0.this.f17429i1 != null) {
                ViewOnClickListenerC0694u0.this.f17429i1.b(ViewOnClickListenerC0694u0.this.requireView().findViewById(R.id.coordinator));
            }
            d();
        }

        @Override // Z3.h
        public void c() {
            H7.b.b("DialtactsFragment", "DialtactsFragment quitEditMode");
            a(true);
            ViewOnClickListenerC0694u0.this.k8(true);
            if (ViewOnClickListenerC0694u0.this.f17429i1 != null) {
                ViewOnClickListenerC0694u0.this.f17429i1.a(ViewOnClickListenerC0694u0.this.requireView().findViewById(R.id.coordinator));
            }
            com.android.contacts.calllog.k kVar = ViewOnClickListenerC0694u0.this.f17446o0;
            if (kVar != null) {
                kVar.R1(true);
            }
        }

        @Override // Z3.h
        public void d() {
            ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = ViewOnClickListenerC0694u0.this;
            TextView textView = viewOnClickListenerC0694u0.f21250d;
            if (textView != null) {
                textView.setText(viewOnClickListenerC0694u0.f17398W.v());
            }
            ViewOnClickListenerC0694u0 viewOnClickListenerC0694u02 = ViewOnClickListenerC0694u0.this;
            COUIToolbar cOUIToolbar = viewOnClickListenerC0694u02.f21248b;
            if (cOUIToolbar != null) {
                cOUIToolbar.setTitle(viewOnClickListenerC0694u02.f17398W.v());
            }
            g();
        }

        @Override // Z3.h
        public void e() {
            ViewOnClickListenerC0694u0.this.k7();
        }

        @Override // Z3.h
        public void g() {
            if (ViewOnClickListenerC0694u0.this.f17398W.B()) {
                ViewOnClickListenerC0694u0.this.f21248b.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectcancel);
            } else {
                ViewOnClickListenerC0694u0.this.f21248b.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectall);
            }
        }

        @Override // Z3.h
        public void f(boolean z10) {
        }
    }

    /* compiled from: DialtactsFragment.java */
    /* renamed from: com.android.contacts.u0$o */
    /* loaded from: classes.dex */
    public class o implements ScrollRelativeLayout.a {
        public o() {
        }

        @Override // com.customize.contacts.widget.ScrollRelativeLayout.a
        public void a() {
            ViewOnClickListenerC0694u0.this.d7(true);
            ViewOnClickListenerC0694u0.this.A4(false);
            ViewOnClickListenerC0694u0.this.d7(false);
        }

        @Override // com.customize.contacts.widget.ScrollRelativeLayout.a
        public boolean b() {
            if (ViewOnClickListenerC0694u0.this.f17353H != null && ViewOnClickListenerC0694u0.this.f17353H.n()) {
                return true;
            }
            return false;
        }

        @Override // com.customize.contacts.widget.ScrollRelativeLayout.a
        public int getHeight() {
            int i10;
            ScrollRelativeLayout scrollRelativeLayout = ViewOnClickListenerC0694u0.this.f17356I;
            if (scrollRelativeLayout != null) {
                i10 = scrollRelativeLayout.getHeight();
            } else {
                i10 = 0;
            }
            if (i10 == 0) {
                ViewOnClickListenerC0694u0.log("getHeight == 0");
                i10 = ViewOnClickListenerC0694u0.this.f17389T.getDimensionPixelSize(R.dimen.new_dialpad_container_empty_height);
            }
            DialEditText dialEditText = ViewOnClickListenerC0694u0.this.f17433k;
            if (dialEditText == null || TextUtils.isEmpty(dialEditText.getText())) {
                return i10 - ViewOnClickListenerC0694u0.this.getResources().getDimensionPixelSize(R.dimen.dialpad_digits_height);
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

    public void B3() {
    }

    public void T7() {
    }

    public void Y6() {
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior.b
    public void K0(ViewGroup viewGroup, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
