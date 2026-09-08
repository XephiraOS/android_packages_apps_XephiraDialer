package com.customize.contacts.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import c.C0543d;
import com.android.contacts.ViewOnClickListenerC0694u0;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.calllog.k;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.android.contacts.dialpad.view.DialpadBottomView;
import com.android.contacts.dialpad.view.DialpadView;
import com.android.contacts.framework.baseui.viewmodel.TabActivityViewModel;
import com.android.contacts.framework.baseui.widget.MainPercentWidthLayout;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.manager.ContactUnfoldFragmentManager;
import com.customize.contacts.startupspeed.StartupSpeedHelper;
import com.customize.contacts.ui.UnfoldContainerView;
import com.customize.contacts.widget.ScrollRelativeLayout;
import com.oplus.contacts.list.viewmodel.FoldableContactsMainListViewModel;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.lifecycle.FlowExtKt;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.FeatureUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import v9.InterfaceC1637a;

/* compiled from: DialtactsUnfoldFragment.kt */
/* loaded from: classes3.dex */
public final class DialtactsUnfoldFragment extends ViewOnClickListenerC0694u0 {

    /* renamed from: w2, reason: collision with root package name */
    public static final a f21199w2 = new a(null);

    /* renamed from: f2, reason: collision with root package name */
    public FrameLayout f21200f2;

    /* renamed from: g2, reason: collision with root package name */
    public Animation f21201g2;

    /* renamed from: h2, reason: collision with root package name */
    public CallDetailActivityFragment f21202h2;

    /* renamed from: i2, reason: collision with root package name */
    public boolean f21203i2;

    /* renamed from: j2, reason: collision with root package name */
    public boolean f21204j2;

    /* renamed from: k2, reason: collision with root package name */
    public boolean f21205k2;

    /* renamed from: l2, reason: collision with root package name */
    public boolean f21206l2;

    /* renamed from: o2, reason: collision with root package name */
    public UnfoldContainerView f21209o2;

    /* renamed from: v2, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f21216v2;

    /* renamed from: m2, reason: collision with root package name */
    public int f21207m2 = -1;

    /* renamed from: n2, reason: collision with root package name */
    public final m9.d f21208n2 = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(TabActivityViewModel.class), new InterfaceC1637a<M>() { // from class: com.customize.contacts.fragment.DialtactsUnfoldFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v9.InterfaceC1637a
        public final M invoke() {
            M viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            kotlin.jvm.internal.i.e(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new InterfaceC1637a<K.b>() { // from class: com.customize.contacts.fragment.DialtactsUnfoldFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v9.InterfaceC1637a
        public final K.b invoke() {
            K.b defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.i.e(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: p2, reason: collision with root package name */
    public final m9.d f21210p2 = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(FoldableContactsMainListViewModel.class), new InterfaceC1637a<M>() { // from class: com.customize.contacts.fragment.DialtactsUnfoldFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v9.InterfaceC1637a
        public final M invoke() {
            M viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            kotlin.jvm.internal.i.e(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new InterfaceC1637a<K.b>() { // from class: com.customize.contacts.fragment.DialtactsUnfoldFragment$special$$inlined$activityViewModels$default$4
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v9.InterfaceC1637a
        public final K.b invoke() {
            K.b defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.i.e(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: q2, reason: collision with root package name */
    public final ReentrantLock f21211q2 = new ReentrantLock();

    /* renamed from: r2, reason: collision with root package name */
    public ArrayList<View> f21212r2 = new ArrayList<>(12);

    /* renamed from: s2, reason: collision with root package name */
    public final androidx.fragment.app.v f21213s2 = new androidx.fragment.app.v() { // from class: com.customize.contacts.fragment.v
        @Override // androidx.fragment.app.v
        public final void a(FragmentManager fragmentManager, Fragment fragment) {
            DialtactsUnfoldFragment.J8(DialtactsUnfoldFragment.this, fragmentManager, fragment);
        }
    };

    /* renamed from: t2, reason: collision with root package name */
    public boolean f21214t2 = true;

    /* renamed from: u2, reason: collision with root package name */
    public final b f21215u2 = new b();

    /* compiled from: DialtactsUnfoldFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: DialtactsUnfoldFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements k.o {
        public b() {
        }

        @Override // com.android.contacts.calllog.k.o
        public boolean a(com.android.contacts.calllog.G intentProvider) {
            Intent intent;
            kotlin.jvm.internal.i.f(intentProvider, "intentProvider");
            if (DialtactsUnfoldFragment.this.f17460t1 && !DialtactsUnfoldFragment.this.e5()) {
                DialtactsUnfoldFragment dialtactsUnfoldFragment = DialtactsUnfoldFragment.this;
                if (dialtactsUnfoldFragment.f17464v1 && dialtactsUnfoldFragment.f21202h2 != null) {
                    DialtactsUnfoldFragment dialtactsUnfoldFragment2 = DialtactsUnfoldFragment.this;
                    Intent b10 = intentProvider.b(dialtactsUnfoldFragment2.getActivity());
                    CallDetailActivityFragment callDetailActivityFragment = DialtactsUnfoldFragment.this.f21202h2;
                    if (callDetailActivityFragment != null) {
                        intent = callDetailActivityFragment.t1();
                    } else {
                        intent = null;
                    }
                    if (dialtactsUnfoldFragment2.X8(b10, intent)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: DialtactsUnfoldFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f21218a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DialtactsUnfoldFragment f21219b;

        public c(View view, DialtactsUnfoldFragment dialtactsUnfoldFragment) {
            this.f21218a = view;
            this.f21219b = dialtactsUnfoldFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f21218a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.f21218a.getBottom() > this.f21219b.f17356I.getTop()) {
                ViewGroup.LayoutParams layoutParams = this.f21218a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.f21219b.T8();
                    this.f21218a.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public DialtactsUnfoldFragment() {
        androidx.activity.result.b<Intent> registerForActivityResult = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.customize.contacts.fragment.w
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                DialtactsUnfoldFragment.g9(DialtactsUnfoldFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult, "registerForActivityResul…leftFocused = false\n    }");
        this.f21216v2 = registerForActivityResult;
    }

    public static final void J8(DialtactsUnfoldFragment this$0, FragmentManager fragmentManager, Fragment fragment) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(fragmentManager, "<anonymous parameter 0>");
        kotlin.jvm.internal.i.f(fragment, "fragment");
        if (kotlin.jvm.internal.i.b(fragment.getTag(), "unfold_dial_contact")) {
            this$0.f21202h2 = (CallDetailActivityFragment) fragment;
        }
    }

    public static final boolean M8(View view, MotionEvent motionEvent) {
        return true;
    }

    private final boolean V8() {
        if (this.f21203i2 || e5() || U0.n.j() || Z3.j.f() || this.f21204j2 || this.f21205k2 || this.f21206l2) {
            return true;
        }
        ContactsTabActivity f42 = f4();
        if (f42 != null && f42.F2()) {
            return true;
        }
        return false;
    }

    private final void Y8() {
        FlowExtKt.b(S8().m(), this, null, new v9.l<Integer, m9.q>() { // from class: com.customize.contacts.fragment.DialtactsUnfoldFragment$observerContactsProviderStatus$1
            {
                super(1);
            }

            public final void b(int i10) {
                boolean z10;
                SharedPreferences sharedPreferences;
                z10 = DialtactsUnfoldFragment.this.f21214t2;
                boolean z11 = false;
                if (z10) {
                    H7.b.e("DialtactsUnfoldFragment", "isProviderStatusFirstObserve");
                    DialtactsUnfoldFragment.this.f21214t2 = false;
                    return;
                }
                if (i10 == 0) {
                    z11 = true;
                }
                H7.b.e("DialtactsUnfoldFragment", "observerContactsProviderStatus isNormal: " + z11);
                sharedPreferences = DialtactsUnfoldFragment.this.f17414b1;
                R7.d.j(sharedPreferences, "contacts_provider_status", i10);
                DialtactsUnfoldFragment.this.s8(z11);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Integer num) {
                b(num.intValue());
                return m9.q.f35511a;
            }
        }, 2, null);
    }

    public static final void Z8(DialtactsUnfoldFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.i8();
    }

    public static final void a9(DialtactsUnfoldFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.i8();
    }

    private final void c9(Intent intent) {
        FragmentManager supportFragmentManager;
        boolean z10;
        View view;
        ContactsTabActivity f42;
        COUIFloatingButton cOUIFloatingButton;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            this.f17464v1 = true;
            Fragment m02 = supportFragmentManager.m0("unfold_dial_contact");
            if (m02 == null || !(m02 instanceof CallDetailActivityFragment) || !X8(intent, ((CallDetailActivityFragment) m02).t1()) || !this.f17460t1) {
                CallDetailActivityFragment callDetailActivityFragment = new CallDetailActivityFragment();
                ContactsTabActivity f43 = f4();
                if (f43 != null) {
                    z10 = f43.G2();
                } else {
                    z10 = false;
                }
                callDetailActivityFragment.X1(z10, true);
                callDetailActivityFragment.V1(intent);
                this.f21202h2 = callDetailActivityFragment;
                androidx.fragment.app.B p10 = supportFragmentManager.p();
                kotlin.jvm.internal.i.e(p10, "it.beginTransaction()");
                if (!this.f17460t1) {
                    Fragment m03 = supportFragmentManager.m0("unfold_dial_contact");
                    if (m03 != null && (view = m03.getView()) != null) {
                        view.setVisibility(8);
                    }
                    callDetailActivityFragment.W1();
                } else {
                    View view2 = this.f17474z0;
                    if (view2 != null) {
                        view2.setVisibility(4);
                    }
                    p10.u(R.anim.unfold_fragment_alpha_in, R.anim.unfold_fragment_alpha_out);
                }
                p10.t(R.id.dial_container_content, callDetailActivityFragment, "unfold_dial_contact");
                p10.i();
            }
            if (this.f17460t1 && ((cOUIFloatingButton = this.f17450p1) == null || cOUIFloatingButton.getVisibility() != 0)) {
                i9();
                Z3.f.t(this.f17450p1.getMainFloatingButton());
                COUIFloatingButton cOUIFloatingButton2 = this.f17450p1;
                if (cOUIFloatingButton2 != null) {
                    cOUIFloatingButton2.animationFloatingButtonEnlarge();
                }
            }
            com.android.contacts.calllog.k c42 = c4();
            if (c42 != null) {
                c42.notifyDataSetChanged();
            }
            this.f21203i2 = false;
            this.f21206l2 = false;
            j9();
            if (!OsUtils.f28280f && (f42 = f4()) != null) {
                f42.s3();
            }
            ContactsTabActivity f44 = f4();
            if (f44 != null) {
                f44.r3();
            }
        }
    }

    public static final void g9(DialtactsUnfoldFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f21203i2 = false;
    }

    private final TabActivityViewModel n1() {
        return (TabActivityViewModel) this.f21208n2.getValue();
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void A4(boolean z10) {
        super.A4(z10);
        i9();
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void B3() {
        this.f21206l2 = true;
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public View G4(LayoutInflater inflater, ViewGroup viewGroup) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        return inflater.inflate(R.layout.dialtacts_main_list_content_unfold, viewGroup, false);
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void G7(Intent intent) {
        kotlin.jvm.internal.i.f(intent, "intent");
        if (CommonFeatureOption.o(getContext())) {
            c9(intent);
        } else {
            super.G7(intent);
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void H4() {
        boolean z10;
        super.H4();
        MainPercentWidthLayout mainPercentWidthLayout = this.f17468x0;
        if (mainPercentWidthLayout != null) {
            if (FeatureUtil.V() && !this.f17460t1) {
                z10 = true;
            } else {
                z10 = false;
            }
            mainPercentWidthLayout.setPercentIndentEnabled(z10);
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void J3() {
        super.J3();
        if (this.f17460t1) {
            d9(true);
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void J4(boolean z10) {
        super.J4(z10);
        c4().M1(this.f21215u2);
    }

    public final boolean K8(View itemView) {
        boolean z10;
        kotlin.jvm.internal.i.f(itemView, "itemView");
        this.f21211q2.lock();
        try {
            ArrayList<View> arrayList = this.f21212r2;
            if (arrayList != null) {
                z10 = arrayList.add(itemView);
            } else {
                z10 = false;
            }
            return z10;
        } finally {
            this.f21211q2.unlock();
        }
    }

    public final void L8() {
        ViewParent viewParent;
        int i10;
        View view = this.f17474z0;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            if (e5() && this.f17460t1) {
                if (com.android.contacts.framework.baseui.util.o.e(getContext())) {
                    float c10 = com.android.contacts.framework.baseui.util.o.c();
                    if (c10 == 8.0f) {
                        i10 = R.color.pb_color_moderate_dial_pad_fragment_masking;
                    } else if (c10 == 20.0f) {
                        i10 = R.color.pb_color_soft_dial_pad_fragment_masking;
                    } else {
                        i10 = R.color.pb_color_enhance_dial_pad_fragment_masking;
                    }
                } else {
                    i10 = R.color.pb_color_day_dial_pad_fragment_masking;
                }
                ViewGroup viewGroup = (ViewGroup) viewParent;
                View findViewById = viewGroup.findViewById(R.id.dial_pad_fragment_masking);
                if (findViewById == null) {
                    findViewById = new View(getContext());
                    findViewById.setId(R.id.dial_pad_fragment_masking);
                    findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.customize.contacts.fragment.r
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view2, MotionEvent motionEvent) {
                            boolean M82;
                            M82 = DialtactsUnfoldFragment.M8(view2, motionEvent);
                            return M82;
                        }
                    });
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.fragment.s
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            DialtactsUnfoldFragment.N8(view2);
                        }
                    });
                    viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, -1));
                }
                findViewById.setBackgroundResource(i10);
                viewGroup.setImportantForAccessibility(4);
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup) viewParent;
            View findViewById2 = viewGroup2.findViewById(R.id.dial_pad_fragment_masking);
            if (findViewById2 != null) {
                viewGroup2.removeView(findViewById2);
            }
            viewGroup2.setImportantForAccessibility(0);
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void N6() {
        Object b10;
        if (this.f17460t1) {
            return;
        }
        int p42 = p4();
        if (!d5()) {
            try {
                Result.a aVar = Result.f34166a;
                this.f17416c0.scrollBy(0, 0 - (p42 - getResources().getDimensionPixelSize(R.dimen.DP_14)));
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("DialtactsUnfoldFragment", "resetCallLogListPaddingTop scrollListBy: " + d10);
            }
        }
    }

    public final void O8() {
        if (e5()) {
            u1();
        }
    }

    public final void P8() {
        d9(true);
    }

    public final void Q8() {
        if (!this.f17460t1) {
            this.f21203i2 = true;
            j9();
            this.f21203i2 = false;
        }
        T3();
    }

    public final List<View> R8() {
        this.f21211q2.lock();
        try {
            ArrayList<View> arrayList = this.f21212r2;
            this.f21212r2 = null;
            return arrayList;
        } finally {
            this.f21211q2.unlock();
        }
    }

    public final FoldableContactsMainListViewModel S8() {
        return (FoldableContactsMainListViewModel) this.f21210p2.getValue();
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void T4() {
        if (this.f17460t1) {
            R4();
        }
        super.T4();
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void T7() {
        int dimensionPixelOffset;
        if (this.f17460t1) {
            dimensionPixelOffset = getResources().getDimensionPixelSize(R.dimen.DP_14);
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.add_contact_margin_top);
            if (o5()) {
                dimensionPixelOffset -= this.f17469x1;
            }
        }
        View view = this.f17465w0;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            kotlin.jvm.internal.i.d(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = dimensionPixelOffset;
            view.setLayoutParams(layoutParams2);
        }
    }

    public final int T8() {
        return this.f21207m2;
    }

    public final void U8(COUIFloatingButton cOUIFloatingButton) {
        cOUIFloatingButton.setScaleX(0.0f);
        cOUIFloatingButton.setScaleY(0.0f);
        cOUIFloatingButton.setVisibility(8);
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void V3(String str) {
        if (this.f17460t1) {
            e9();
        }
        super.V3(str);
    }

    public final boolean W8(Intent intent, Intent intent2) {
        Uri data = intent2.getData();
        Uri data2 = intent.getData();
        if (data == null && data2 == null) {
            return true;
        }
        if (data != null && data2 != null && kotlin.jvm.internal.i.b(data, data2)) {
            return true;
        }
        return false;
    }

    public final boolean X8(Intent intent, Intent intent2) {
        if (intent == null || intent2 == null) {
            return false;
        }
        boolean W82 = W8(intent, intent2);
        boolean equals = TextUtils.equals(C7.e.l(intent, "number"), C7.e.l(intent2, "number"));
        boolean equals2 = TextUtils.equals(C7.e.l(intent, BreenoCallContract.BaseColumns.NORMALIZED_NUMBER), C7.e.l(intent2, BreenoCallContract.BaseColumns.NORMALIZED_NUMBER));
        boolean equals3 = TextUtils.equals(C7.e.l(intent, "countryiso"), C7.e.l(intent2, "countryiso"));
        if (!W82 || !equals || !equals2 || !equals3) {
            return false;
        }
        return true;
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void Y6() {
        this.f17459t0.setVisibility(0);
        this.f17438l1.setVisibility(0);
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public boolean a5() {
        if (S8().m().getValue().intValue() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        super.afterTextChanged(editable);
        u8();
        W7(false);
        U7();
    }

    public final void b9() {
        this.f21205k2 = true;
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public boolean c6() {
        Fragment fragment;
        FragmentManager supportFragmentManager;
        FrameLayout frameLayout;
        if (!this.f17460t1 && e5()) {
            u1();
            return true;
        }
        if (!this.f17460t1 && (frameLayout = this.f21200f2) != null && frameLayout.getVisibility() == 8) {
            return super.c6();
        }
        if (this.f17464v1) {
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                fragment = supportFragmentManager.m0("unfold_dial_contact");
            } else {
                fragment = null;
            }
            if (fragment != null && (fragment instanceof CallDetailActivityFragment) && ((CallDetailActivityFragment) fragment).N3()) {
                return true;
            }
        }
        if (this.f17464v1) {
            d9(true);
            FrameLayout frameLayout2 = this.f21200f2;
            if (frameLayout2 != null && frameLayout2.getVisibility() == 0) {
                return true;
            }
        }
        return super.c6();
    }

    public final void d9(boolean z10) {
        FragmentManager supportFragmentManager;
        boolean z11;
        boolean z12;
        View view = this.f17474z0;
        if (view != null) {
            view.setVisibility(0);
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            if (H7.a.b()) {
                H7.b.b("DialtactsUnfoldFragment", "showDefault mShowChildUi = " + this.f17460t1);
            }
            Fragment m02 = supportFragmentManager.m0("unfold_dial_contact");
            if (m02 != null) {
                androidx.fragment.app.B p10 = supportFragmentManager.p();
                kotlin.jvm.internal.i.e(p10, "it.beginTransaction()");
                z11 = true;
                if (z10) {
                    if (this.f17460t1) {
                        p10.u(0, R.anim.unfold_fragment_alpha_out);
                        Animation animation = this.f21201g2;
                        if (animation == null) {
                            animation = AnimationUtils.loadAnimation(getContext(), R.anim.unfold_fragment_alpha_in);
                        }
                        if (animation != null) {
                            this.f21201g2 = animation;
                            View view2 = this.f17474z0;
                            if (view2 != null) {
                                view2.setAnimation(animation);
                            }
                            animation.start();
                        }
                    } else {
                        p10.u(0, R.anim.coui_close_slide_exit);
                        z12 = true;
                        p10.r(m02);
                        p10.j();
                    }
                }
                z12 = false;
                p10.r(m02);
                p10.j();
            } else {
                z11 = false;
                z12 = false;
            }
            this.f21202h2 = null;
            this.f17464v1 = false;
            if (z11) {
                com.android.contacts.calllog.k c42 = c4();
                if (c42 != null) {
                    c42.notifyDataSetChanged();
                }
                i9();
                FragmentActivity activity2 = getActivity();
                if (activity2 instanceof ContactsTabActivity) {
                    if (!OsUtils.f28280f) {
                        ((ContactsTabActivity) activity2).s3();
                    }
                    ContactsTabActivity contactsTabActivity = (ContactsTabActivity) activity2;
                    contactsTabActivity.r3();
                    if (z12 && z10) {
                        contactsTabActivity.g2();
                    }
                }
            }
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public I.d<DialpadView, Integer> e4() {
        return StartupSpeedHelper.f21823p.c(getContext());
    }

    public final void e9() {
        if (this.f17460t1 && this.f17464v1) {
            d9(true);
            i9();
        } else {
            s7(true);
        }
    }

    public final void f9(COUIFloatingButton cOUIFloatingButton) {
        cOUIFloatingButton.setScaleX(1.0f);
        cOUIFloatingButton.setScaleY(1.0f);
        cOUIFloatingButton.setVisibility(0);
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void g1() {
        super.g1();
        FragmentActivity activity = getActivity();
        if (activity instanceof ContactsTabActivity) {
            ((ContactsTabActivity) activity).i3();
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public boolean g5() {
        boolean z10;
        FrameLayout frameLayout;
        if (this.f17464v1 && (frameLayout = this.f21200f2) != null && frameLayout.getVisibility() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (H7.a.b()) {
            H7.b.b("DialtactsUnfoldFragment", "isFoldShowRight = " + z10);
        }
        return z10;
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void g6(Intent intent) {
        super.g6(intent);
        if (this.f17464v1) {
            d9(false);
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, com.customize.contacts.fragment.MainFragment
    public void h1() {
        super.h1();
        com.android.contacts.calllog.k c42 = c4();
        if (c42 != null) {
            c42.notifyDataSetChanged();
        }
        L8();
        n1().n(2);
    }

    public final void h9(boolean z10) {
        int dimensionPixelSize;
        if (z10) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.unfold_dialpad_padding);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fold_dialpad_padding);
        }
        DialpadBottomView dialpadBottomView = this.f17367L1;
        if (dialpadBottomView != null) {
            ViewGroup.LayoutParams layoutParams = dialpadBottomView.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(dimensionPixelSize);
                layoutParams2.setMarginEnd(dimensionPixelSize);
                dialpadBottomView.setLayoutParams(layoutParams);
            }
        }
    }

    public final void i9() {
        COUIFloatingButton cOUIFloatingButton = this.f17450p1;
        if (cOUIFloatingButton != null) {
            FragmentActivity activity = getActivity();
            if ((activity instanceof ContactsTabActivity) && ((ContactsTabActivity) activity).E2()) {
                if (e5()) {
                    U8(cOUIFloatingButton);
                    return;
                }
                if (this.f17460t1) {
                    if (this.f17464v1) {
                        f9(cOUIFloatingButton);
                        return;
                    } else {
                        U8(cOUIFloatingButton);
                        return;
                    }
                }
                if (G()) {
                    U8(cOUIFloatingButton);
                } else {
                    f9(cOUIFloatingButton);
                }
            }
        }
    }

    public final void j9() {
        if (!this.f17460t1) {
            if (V8()) {
                FrameLayout frameLayout = this.f21200f2;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
            } else {
                FrameLayout frameLayout2 = this.f21200f2;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(0);
                }
            }
        } else {
            FrameLayout frameLayout3 = this.f21200f2;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(0);
            }
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof ContactsTabActivity) {
            ((ContactsTabActivity) activity).r3();
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void k8(boolean z10) {
        super.k8(z10);
        if (((this.f17460t1 && this.f17464v1) || o5()) && !e5() && this.f17450p1 != null) {
            i9();
            if (z10) {
                Z3.f.t(this.f17450p1.getMainFloatingButton());
            }
            this.f17450p1.animationFloatingButtonEnlarge();
        }
    }

    public final void k9() {
        View view = this.f17474z0;
        if (view != null) {
            if (this.f17460t1) {
                View mPasteDigitContainer = this.f17438l1;
                if (mPasteDigitContainer != null) {
                    kotlin.jvm.internal.i.e(mPasteDigitContainer, "mPasteDigitContainer");
                    if (this.f21207m2 == -1) {
                        this.f21207m2 = com.android.contacts.framework.baseui.util.B.a(getContext());
                    }
                    ViewGroup.LayoutParams layoutParams = mPasteDigitContainer.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = getResources().getDimensionPixelSize(R.dimen.DP_24) + this.f21207m2;
                        mPasteDigitContainer.setLayoutParams(layoutParams);
                    }
                    mPasteDigitContainer.getViewTreeObserver().addOnGlobalLayoutListener(new c(mPasteDigitContainer, this));
                }
                ScrollRelativeLayout mDialpadContainer = this.f17356I;
                if (mDialpadContainer != null) {
                    kotlin.jvm.internal.i.e(mDialpadContainer, "mDialpadContainer");
                    mDialpadContainer.setTranslationY(0.0f);
                    mDialpadContainer.setBackground(null);
                    mDialpadContainer.setCanScroll(false);
                }
                ImageButton imageButton = this.f17380Q;
                if (imageButton != null) {
                    imageButton.setVisibility(8);
                }
                if (this.f17464v1) {
                    view.setVisibility(4);
                } else {
                    view.setVisibility(0);
                }
                this.f17457s0.setDialpadPadding(getResources().getDimensionPixelSize(R.dimen.unfold_dialpad_padding));
                h9(true);
                return;
            }
            view.setVisibility(0);
            ScrollRelativeLayout scrollRelativeLayout = this.f17356I;
            if (scrollRelativeLayout != null) {
                scrollRelativeLayout.setBackgroundResource(2131232320);
            }
            ScrollRelativeLayout scrollRelativeLayout2 = this.f17356I;
            if (scrollRelativeLayout2 != null) {
                scrollRelativeLayout2.setCanScroll(true);
            }
            a8();
            this.f17457s0.setDialpadPadding(getResources().getDimensionPixelSize(R.dimen.fold_dialpad_padding));
            h9(false);
        }
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public Integer l1() {
        return Integer.valueOf(R.id.dialer_more_menu);
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void n7() {
        k9();
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != -1) {
            if (i10 == 1) {
                this.f21203i2 = false;
                return;
            }
            return;
        }
        this.f21203i2 = false;
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration arg0) {
        Object b10;
        boolean z10;
        int i10;
        View view;
        kotlin.jvm.internal.i.f(arg0, "arg0");
        boolean z11 = this.f17460t1;
        super.onConfigurationChanged(arg0);
        u8();
        boolean z12 = false;
        W7(false);
        N6();
        if (z11 == this.f17460t1) {
            View view2 = getView();
            if (view2 != null) {
                view2.post(new Runnable() { // from class: com.customize.contacts.fragment.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        DialtactsUnfoldFragment.a9(DialtactsUnfoldFragment.this);
                    }
                });
            }
            k9();
            return;
        }
        k9();
        if (!this.f17460t1) {
            T4();
            FragmentActivity activity = getActivity();
            if ((activity instanceof ContactsTabActivity) && ((ContactsTabActivity) activity).E2() && (view = this.f17458s1) != null) {
                view.setAlpha(0.0f);
            }
            ImageButton imageButton = this.f17377P;
            if (imageButton != null) {
                imageButton.setEnabled(!d5());
            }
            LinearLayout linearLayout = this.f17459t0;
            if (linearLayout != null) {
                if (d5()) {
                    i10 = 8;
                } else {
                    i10 = 0;
                }
                linearLayout.setVisibility(i10);
            }
            if (e5()) {
                A4(true);
                F4();
                U0.n.h();
            } else {
                V7();
                r7();
            }
        } else {
            s7(true);
            View view3 = this.f17458s1;
            if (view3 != null) {
                view3.setAlpha(1.0f);
            }
            V7();
            T4();
            if (!d5()) {
                try {
                    Result.a aVar = Result.f34166a;
                    this.f17416c0.scrollBy(0, (((getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.toolbar_title_init_height)) + getResources().getDimensionPixelSize(R.dimen.toolbar_title_init_margin_bottom)) - getResources().getDimensionPixelSize(R.dimen.divider_height)) - getResources().getDimensionPixelSize(R.dimen.DP_14));
                    b10 = Result.b(m9.q.f35511a);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b10 = Result.b(kotlin.b.a(th));
                }
                Throwable d10 = Result.d(b10);
                if (d10 != null) {
                    H7.b.c("DialtactsUnfoldFragment", "onConfigurationChanged scrollListBy: " + d10);
                }
            }
            com.android.contacts.calllog.k kVar = this.f17446o0;
            if (kVar != null) {
                kVar.D();
            }
        }
        F3();
        if (!this.f17464v1) {
            d9(false);
        }
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
        if (headerFooterRecyclerView != null) {
            if (FeatureUtil.V() && !this.f17460t1) {
                z10 = true;
            } else {
                z10 = false;
            }
            headerFooterRecyclerView.setPercentIndentEnabled(z10);
        }
        MainPercentWidthLayout mainPercentWidthLayout = this.f17468x0;
        if (mainPercentWidthLayout != null) {
            if (FeatureUtil.V() && !this.f17460t1) {
                z12 = true;
            }
            mainPercentWidthLayout.setPercentIndentEnabled(z12);
        }
        j9();
        L8();
        View view4 = getView();
        if (view4 != null) {
            view4.post(new Runnable() { // from class: com.customize.contacts.fragment.u
                @Override // java.lang.Runnable
                public final void run() {
                    DialtactsUnfoldFragment.Z8(DialtactsUnfoldFragment.this);
                }
            });
        }
        q8();
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        FragmentManager supportFragmentManager;
        super.onCreate(bundle);
        ContactUnfoldFragmentManager.f21504e.k(this);
        if (bundle != null) {
            this.f17464v1 = bundle.getBoolean("is_dial_contact_show");
            this.f21203i2 = bundle.getBoolean("dial_left_focused");
            this.f21204j2 = bundle.getBoolean("dial_left_focused_before");
            this.f21205k2 = bundle.getBoolean("dial_left_start_other_task");
            this.f21206l2 = bundle.getBoolean("dial_left_start_call");
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.k(this.f21213s2);
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, androidx.fragment.app.Fragment
    public void onDestroy() {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.o1(this.f21213s2);
        }
        super.onDestroy();
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f21206l2 = false;
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("is_dial_contact_show", this.f17464v1);
        outState.putBoolean("dial_left_focused", this.f21203i2);
        outState.putBoolean("dial_left_focused_before", V8());
        outState.putBoolean("dial_left_start_other_task", this.f21205k2);
        outState.putBoolean("dial_left_start_call", this.f21206l2);
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f21205k2 = false;
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, com.customize.contacts.fragment.MainFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        boolean z10;
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f21200f2 = (FrameLayout) this.f17421e1.findViewById(R.id.dial_container_content);
        this.f21209o2 = (UnfoldContainerView) this.f17421e1.findViewById(R.id.dial_fragment_layout);
        if (!this.f17464v1) {
            d9(false);
        }
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f17416c0;
        if (headerFooterRecyclerView != null) {
            if (FeatureUtil.V() && !this.f17460t1) {
                z10 = true;
            } else {
                z10 = false;
            }
            headerFooterRecyclerView.setPercentIndentEnabled(z10);
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof ContactsTabActivity) {
            ((ContactsTabActivity) activity).v3();
        }
        if (this.f21204j2) {
            j9();
            this.f21204j2 = false;
        } else {
            j9();
        }
        if (this.f17460t1) {
            k9();
        }
        L8();
        T7();
        U7();
        u8();
        W7(false);
        N6();
        Y8();
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public boolean r5() {
        UnfoldContainerView unfoldContainerView = this.f21209o2;
        if (unfoldContainerView != null) {
            return unfoldContainerView.c();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(Intent intent) {
        kotlin.jvm.internal.i.f(intent, "intent");
        this.f21216v2.a(intent);
        this.f21203i2 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int i10) {
        kotlin.jvm.internal.i.f(intent, "intent");
        super.startActivityForResult(intent, i10);
        if (1 == i10 || -1 == i10) {
            this.f21203i2 = true;
        }
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0, com.customize.contacts.fragment.MainFragment
    public void u1() {
        super.u1();
        com.android.contacts.calllog.k c42 = c4();
        if (c42 != null) {
            c42.notifyDataSetChanged();
        }
        L8();
        n1().n(0);
    }

    @Override // com.android.contacts.ViewOnClickListenerC0694u0
    public void w6() {
        i9();
        super.w6();
    }

    public static final void N8(View view) {
    }
}
