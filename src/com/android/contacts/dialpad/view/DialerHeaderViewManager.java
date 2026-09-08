package com.android.contacts.dialpad.view;

import U0.n;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ComponentActivity;
import androidx.lifecycle.p;
import androidx.lifecycle.w;
import androidx.preference.j;
import com.android.contacts.framework.baseui.util.AiCallTranslateStateController;
import com.android.contacts.framework.baseui.util.NoNetworkCommUiStateUtil;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.contacts.framework.baseui.util.r;
import com.android.incallui.OplusAutoRedial;
import com.coui.appcompat.snackbar.COUISnackBar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.h0;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m9.q;
import v9.InterfaceC1637a;
import v9.l;

/* compiled from: DialerHeaderViewManager.kt */
/* loaded from: classes.dex */
public final class DialerHeaderViewManager {

    /* renamed from: m, reason: collision with root package name */
    public static final a f14968m = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ComponentActivity f14969a;

    /* renamed from: b, reason: collision with root package name */
    public final View f14970b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f14971c;

    /* renamed from: e, reason: collision with root package name */
    public TextView f14973e;

    /* renamed from: f, reason: collision with root package name */
    public View f14974f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f14975g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f14976h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f14977i;

    /* renamed from: j, reason: collision with root package name */
    public int f14978j;

    /* renamed from: k, reason: collision with root package name */
    public b f14979k;

    /* renamed from: d, reason: collision with root package name */
    public String f14972d = "com.coloros.phonemanager";

    /* renamed from: l, reason: collision with root package name */
    public final String[] f14980l = {"need_show_vocal_highlight_tips", "need_show_call_summary_tips", "need_show_call_Privacy_tips", "need_show_breeno_call_tips"};

    /* compiled from: DialerHeaderViewManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: DialerHeaderViewManager.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(boolean z10);
    }

    /* compiled from: DialerHeaderViewManager.kt */
    /* loaded from: classes.dex */
    public static final class c implements w, g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f14981a;

        public c(l function) {
            i.f(function, "function");
            this.f14981a = function;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof w) || !(obj instanceof g)) {
                return false;
            }
            return i.b(getFunctionDelegate(), ((g) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.g
        public final m9.c<?> getFunctionDelegate() {
            return this.f14981a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object obj) {
            this.f14981a.invoke(obj);
        }
    }

    public DialerHeaderViewManager(ComponentActivity componentActivity, View view, Runnable runnable) {
        this.f14969a = componentActivity;
        this.f14970b = view;
        this.f14971c = runnable;
    }

    public static final void N(final DialerHeaderViewManager this$0, View view) {
        i.f(this$0, "this$0");
        int i10 = this$0.f14978j;
        if (i10 != 1) {
            switch (i10) {
                case 6:
                    Intent intent = new Intent("wireless.settings.VCOMM_SHARE_SETTINGS");
                    intent.setPackage("com.oplus.wirelesssettings");
                    R7.b.f(this$0.f14969a, intent, R.string.activity_not_found, null, 4, null);
                    return;
                case 7:
                    this$0.d0();
                    Intent intent2 = new Intent("oplus.intent.action.voice_nc_page_detail");
                    if (!TextUtils.isEmpty(this$0.f14972d)) {
                        intent2.setPackage(this$0.f14972d);
                    }
                    R7.b.f(this$0.f14969a, intent2, R.string.activity_not_found, null, 4, null);
                    this$0.K(false);
                    return;
                case 8:
                    h0.e(this$0.f14969a, 200031404, "go");
                    this$0.o0();
                    return;
                case 9:
                    this$0.Z();
                    R7.b.f(this$0.f14969a, com.android.contacts.framework.api.breenocall.a.f(), R.string.activity_not_found, null, 4, null);
                    h0.e(this$0.f14969a, 200031405, "go");
                    this$0.K(false);
                    return;
                case 10:
                    Intent intent3 = new Intent("action.oplus.accessibilityassistant.call.settings");
                    intent3.setPackage("com.coloros.accessibilityassistant");
                    R7.b.f(this$0.f14969a, intent3, R.string.activity_not_found, null, 4, null);
                    h0.e(this$0.f14969a, 200031406, "go");
                    this$0.b0();
                    this$0.K(false);
                    return;
                case 11:
                    R7.b.f(this$0.f14969a, new Intent("oplus.intent.action.SATELLITE_CALL_SETTINGS"), 0, null, 6, null);
                    h0.f(this$0.f14969a, 200031407, "go", L7.a.c());
                    return;
                case 12:
                    NoNetworkCommUiStateUtil noNetworkCommUiStateUtil = NoNetworkCommUiStateUtil.f15861a;
                    noNetworkCommUiStateUtil.q(this$0.f14969a, true);
                    noNetworkCommUiStateUtil.p(this$0.f14969a);
                    this$0.K(false);
                    h0.Q(this$0.f14969a, "no_network", "setting");
                    return;
                case 13:
                    NoNetworkCommUiStateUtil noNetworkCommUiStateUtil2 = NoNetworkCommUiStateUtil.f15861a;
                    noNetworkCommUiStateUtil2.q(this$0.f14969a, false);
                    noNetworkCommUiStateUtil2.p(this$0.f14969a);
                    this$0.K(false);
                    h0.Q(this$0.f14969a, "network", "setting");
                    return;
                case 14:
                    Intent intent4 = new Intent();
                    intent4.setComponent(new ComponentName("com.newcall", "com.newcall.setting.SettingsActivity"));
                    R7.b.f(this$0.f14969a, intent4, R.string.activity_not_found, null, 4, null);
                    this$0.c0();
                    this$0.K(false);
                    h0.h(1);
                    return;
                case 15:
                    this$0.Y(this$0.f14969a);
                    if (FeatureOption.i() && StatementUtils.t(this$0.f14969a)) {
                        n.b(StatementUtils.f15877a.w(this$0.f14969a, new InterfaceC1637a<q>() { // from class: com.android.contacts.dialpad.view.DialerHeaderViewManager$initDialerHeaderView$2$numberRecognitionDialog$1
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
                                Runnable runnable;
                                runnable = DialerHeaderViewManager.this.f14971c;
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        }));
                    } else {
                        NumberIdentifyUtils.n(this$0.f14969a, 1, null, null, true, 12, null);
                        Runnable runnable = this$0.f14971c;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    this$0.K(false);
                    h0.i(true);
                    return;
                case 16:
                    this$0.a0();
                    Intent intent5 = new Intent("oplus.intent.action.phone.PRIVACY_CALL_PAGE");
                    intent5.setPackage("com.android.phone");
                    R7.b.f(this$0.f14969a, intent5, R.string.activity_not_found, null, 4, null);
                    this$0.K(false);
                    return;
                case 17:
                    this$0.f0();
                    Intent intent6 = new Intent("oplus.intent.action.ai_call_assistant_settings");
                    intent6.setPackage("com.oplus.aicall");
                    this$0.C(intent6, false, this$0.f14969a);
                    R7.b.f(this$0.f14969a, intent6, R.string.activity_not_found, null, 4, null);
                    this$0.K(false);
                    h0.b(this$0.f14969a, 200031413, "go");
                    return;
                case 18:
                    this$0.g0();
                    Intent intent7 = new Intent("oplus.intent.action.ai_call_translate_settings");
                    intent7.setPackage("com.oplus.aicall");
                    this$0.C(intent7, true, this$0.f14969a);
                    R7.b.f(this$0.f14969a, intent7, R.string.activity_not_found, null, 4, null);
                    this$0.K(false);
                    h0.b(this$0.f14969a, 200031416, "go");
                    return;
                default:
                    return;
            }
        }
        h0.e(this$0.f14969a, 200031402, "setting");
        com.android.contacts.framework.api.appstore.appinfo.a.m(this$0.f14969a);
        this$0.K(false);
    }

    public static final void O(DialerHeaderViewManager this$0, View view) {
        String str;
        i.f(this$0, "this$0");
        switch (this$0.f14978j) {
            case 4:
                this$0.L(false);
                return;
            case 5:
            default:
                return;
            case 6:
                this$0.B("ignore_times");
                this$0.K(false);
                return;
            case 7:
                this$0.d0();
                this$0.K(false);
                return;
            case 8:
                this$0.e0();
                this$0.j0();
                h0.e(this$0.f14969a, 200031404, "ignore");
                this$0.K(false);
                return;
            case 9:
                this$0.Z();
                this$0.K(false);
                h0.e(this$0.f14969a, 200031405, "ignore");
                return;
            case 10:
                this$0.b0();
                this$0.K(false);
                h0.e(this$0.f14969a, 200031406, "ignore");
                return;
            case 11:
                boolean c10 = L7.a.c();
                if (c10) {
                    this$0.B("satellite_call_ignored_count_super_power");
                } else {
                    this$0.B("satellite_call_ignored_count_normal");
                }
                if (c10) {
                    str = "satellite_call_ignored_timestamp_super_power";
                } else {
                    str = "satellite_call_ignored_timestamp_normal";
                }
                this$0.h0(str);
                this$0.K(false);
                this$0.l0();
                h0.f(this$0.f14969a, 200031407, "ignore", c10);
                return;
            case 12:
                NoNetworkCommUiStateUtil.f15861a.q(this$0.f14969a, true);
                this$0.K(false);
                h0.Q(this$0.f14969a, "no_network", "ignore");
                return;
            case 13:
                NoNetworkCommUiStateUtil.f15861a.q(this$0.f14969a, false);
                this$0.K(false);
                h0.Q(this$0.f14969a, "network", "ignore");
                return;
            case 14:
                this$0.c0();
                this$0.K(false);
                h0.h(0);
                return;
            case 15:
                this$0.Y(this$0.f14969a);
                this$0.K(false);
                h0.i(false);
                return;
            case 16:
                this$0.a0();
                this$0.K(false);
                return;
            case 17:
                this$0.f0();
                this$0.K(false);
                h0.b(this$0.f14969a, 200031413, "ignore");
                return;
            case 18:
                this$0.g0();
                this$0.K(false);
                h0.c(this$0.f14969a, 200031416, "ignore");
                return;
        }
    }

    public static final void k0(DialerHeaderViewManager this$0, View view) {
        i.f(this$0, "this$0");
        this$0.o0();
    }

    public static final void m0(DialerHeaderViewManager this$0, View view) {
        i.f(this$0, "this$0");
        R7.b.f(this$0.f14969a, new Intent("oplus.intent.action.SATELLITE_CALL_SETTINGS"), 0, null, 6, null);
    }

    public final Object A0(final Context context, kotlin.coroutines.c<? super Boolean> cVar) {
        return z0(13, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTipsUnderNet$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(NoNetworkCommUiStateUtil.f15861a.n(context));
            }
        }, cVar);
    }

    public final void B(String str) {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            SharedPreferences b10 = j.b(componentActivity);
            b10.edit().putInt(str, b10.getInt(str, 0) + 1).apply();
        }
    }

    public final Object B0(final Context context, kotlin.coroutines.c<? super Boolean> cVar) {
        return z0(12, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTipsUnderNoNet$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
            
                if (r5 != false) goto L6;
             */
            @Override // v9.InterfaceC1637a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke() {
                /*
                    r5 = this;
                    com.android.contacts.framework.baseui.util.NoNetworkCommUiStateUtil r0 = com.android.contacts.framework.baseui.util.NoNetworkCommUiStateUtil.f15861a
                    android.content.Context r1 = r1
                    com.android.contacts.dialpad.view.DialerHeaderViewManager r2 = r2
                    r3 = 0
                    boolean r2 = com.android.contacts.dialpad.view.DialerHeaderViewManager.h(r2, r1, r3)
                    r4 = 1
                    if (r2 != 0) goto L18
                    com.android.contacts.dialpad.view.DialerHeaderViewManager r2 = r2
                    android.content.Context r5 = r1
                    boolean r5 = com.android.contacts.dialpad.view.DialerHeaderViewManager.h(r2, r5, r4)
                    if (r5 == 0) goto L19
                L18:
                    r3 = r4
                L19:
                    boolean r5 = r0.o(r1, r3)
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTipsUnderNoNet$2.invoke():java.lang.Boolean");
            }
        }, cVar);
    }

    public final void C(Intent intent, boolean z10, Context context) {
        boolean z11 = true;
        if (z10) {
            if (intent != null) {
                intent.putExtra("key_ai_call_translate", true);
                intent.putExtra("key_ai_call_breeno", false);
                intent.putExtra("key_ai_call_summary_support", false);
                intent.putExtra("key_ai_call_summary_offline", false);
                H7.b.b("DialerHeaderViewManager", "translate Intent data only translate true");
                return;
            }
            return;
        }
        if (context != null) {
            boolean l10 = FeatureOption.l();
            boolean m10 = FeatureOption.m();
            boolean e10 = com.android.contacts.framework.api.breenocall.a.e(true);
            if (!e10 || !com.android.contacts.framework.api.breenocall.a.c(context)) {
                z11 = false;
            }
            H7.b.b("DialerHeaderViewManager", "isSupportAICallTranslate: " + l10 + " isSupportBreenoCall: " + m10 + " isSupportCallSummary: " + e10 + " isCallSummaryOpen: " + z11 + " ");
            if (intent != null) {
                intent.putExtra("key_ai_call_translate", l10);
                intent.putExtra("key_ai_call_breeno", m10);
                intent.putExtra("key_ai_call_summary_support", e10);
                intent.putExtra("key_ai_call_summary_offline", z11);
            }
        }
    }

    public final boolean C0(Context context) {
        if (V()) {
            String countryIso = C7.c.b(context).e();
            if (H7.a.b()) {
                H7.b.b("DialerHeaderViewManager", "countryIso = " + countryIso);
            }
            SharedPreferences b10 = j.b(context);
            int i10 = b10.getInt("need_show_overseas_travel_tips", 0);
            int i11 = b10.getInt("ignore_count", 0);
            if (!TextUtils.isEmpty(countryIso) && !i.b(countryIso, "CN")) {
                if (i11 < 2 && i10 == 0) {
                    this.f14978j = 8;
                    ImageView imageView = this.f14977i;
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.pb_ic_emergency_number_tips);
                    }
                    ImageView imageView2 = this.f14977i;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    TextView textView = this.f14973e;
                    if (textView != null) {
                        textView.setText(context.getResources().getString(R.string.to_call));
                    }
                    TextView textView2 = this.f14973e;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    TextView textView3 = this.f14976h;
                    if (textView3 != null) {
                        textView3.setText(context.getResources().getString(R.string.ignore));
                    }
                    TextView textView4 = this.f14976h;
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                    }
                    TextView textView5 = this.f14975g;
                    if (textView5 != null) {
                        i.e(countryIso, "countryIso");
                        textView5.setText(H(countryIso));
                    }
                    n0();
                    return true;
                }
            } else {
                if (i10 == 1) {
                    b10.edit().putInt("need_show_overseas_travel_tips", 0).apply();
                }
                if (this.f14978j == 8) {
                    J();
                }
            }
        }
        return false;
    }

    public final long D(String str) {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity == null) {
            return 0L;
        }
        return j.b(componentActivity).getLong(str, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D0(android.content.Context r7, kotlin.coroutines.c<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowSatelliteCallTips$1
            if (r0 == 0) goto L13
            r0 = r8
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowSatelliteCallTips$1 r0 = (com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowSatelliteCallTips$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowSatelliteCallTips$1 r0 = new com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowSatelliteCallTips$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r6 = (kotlin.jvm.internal.Ref$BooleanRef) r6
            java.lang.Object r7 = r0.L$1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Object r0 = r0.L$0
            com.android.contacts.dialpad.view.DialerHeaderViewManager r0 = (com.android.contacts.dialpad.view.DialerHeaderViewManager) r0
            kotlin.b.b(r8)
            goto L60
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.b.b(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.S.a()
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowSatelliteCallTips$2 r4 = new com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowSatelliteCallTips$2
            r5 = 0
            r4.<init>(r8, r6, r7, r5)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.C1244g.g(r2, r4, r0)
            if (r0 != r1) goto L5e
            return r1
        L5e:
            r0 = r6
            r6 = r8
        L60:
            boolean r6 = r6.element
            r8 = 11
            r1 = 0
            if (r6 == 0) goto Lba
            r0.f14978j = r8
            android.widget.TextView r6 = r0.f14975g
            if (r6 == 0) goto L73
            r8 = 2132019584(0x7f140980, float:1.9677507E38)
            r6.setText(r8)
        L73:
            android.widget.ImageView r6 = r0.f14977i
            if (r6 == 0) goto L7d
            r8 = 2131232632(0x7f080778, float:1.8081379E38)
            r6.setImageResource(r8)
        L7d:
            android.widget.ImageView r6 = r0.f14977i
            if (r6 != 0) goto L82
            goto L85
        L82:
            r6.setVisibility(r1)
        L85:
            android.widget.TextView r6 = r0.f14973e
            if (r6 != 0) goto L8a
            goto L98
        L8a:
            android.content.res.Resources r7 = r7.getResources()
            r8 = 2132019849(0x7f140a89, float:1.9678045E38)
            java.lang.String r7 = r7.getString(r8)
            r6.setText(r7)
        L98:
            android.widget.TextView r6 = r0.f14973e
            if (r6 != 0) goto L9d
            goto La0
        L9d:
            r6.setVisibility(r1)
        La0:
            android.widget.TextView r6 = r0.f14976h
            if (r6 == 0) goto Laa
            r7 = 2132018394(0x7f1404da, float:1.9675093E38)
            r6.setText(r7)
        Laa:
            android.widget.TextView r6 = r0.f14976h
            if (r6 != 0) goto Laf
            goto Lb2
        Laf:
            r6.setVisibility(r1)
        Lb2:
            r0.n0()
            java.lang.Boolean r6 = p9.C1467a.a(r3)
            return r6
        Lba:
            int r6 = r0.f14978j
            if (r6 != r8) goto Lc1
            r0.J()
        Lc1:
            java.lang.Boolean r6 = p9.C1467a.a(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager.D0(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    public final ComponentActivity E() {
        return this.f14969a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E0(android.content.Context r6, kotlin.coroutines.c<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowTurnOnNumberRecognition$1
            if (r0 == 0) goto L13
            r0 = r7
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowTurnOnNumberRecognition$1 r0 = (com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowTurnOnNumberRecognition$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowTurnOnNumberRecognition$1 r0 = new com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowTurnOnNumberRecognition$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            r6 = r5
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Object r5 = r0.L$0
            com.android.contacts.dialpad.view.DialerHeaderViewManager r5 = (com.android.contacts.dialpad.view.DialerHeaderViewManager) r5
            kotlin.b.b(r7)
            goto L54
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.b.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.S.b()
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowTurnOnNumberRecognition$showTips$1 r2 = new com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowTurnOnNumberRecognition$showTips$1
            r4 = 0
            r2.<init>(r6, r4)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.C1244g.g(r7, r2, r0)
            if (r7 != r1) goto L54
            return r1
        L54:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r0 = 15
            if (r7 == 0) goto Lae
            r5.f14978j = r0
            android.widget.TextView r0 = r5.f14975g
            if (r0 == 0) goto L6a
            r1 = 2132019852(0x7f140a8c, float:1.967805E38)
            r0.setText(r1)
        L6a:
            android.widget.ImageView r0 = r5.f14977i
            if (r0 == 0) goto L74
            r1 = 2131232677(0x7f0807a5, float:1.808147E38)
            r0.setImageResource(r1)
        L74:
            android.widget.ImageView r0 = r5.f14977i
            r1 = 0
            if (r0 != 0) goto L7a
            goto L7d
        L7a:
            r0.setVisibility(r1)
        L7d:
            android.widget.TextView r0 = r5.f14973e
            if (r0 != 0) goto L82
            goto L90
        L82:
            android.content.res.Resources r6 = r6.getResources()
            r2 = 2132019334(0x7f140886, float:1.9677E38)
            java.lang.String r6 = r6.getString(r2)
            r0.setText(r6)
        L90:
            android.widget.TextView r6 = r5.f14973e
            if (r6 != 0) goto L95
            goto L98
        L95:
            r6.setVisibility(r1)
        L98:
            android.widget.TextView r6 = r5.f14976h
            if (r6 == 0) goto La2
            r0 = 2132018393(0x7f1404d9, float:1.9675091E38)
            r6.setText(r0)
        La2:
            android.widget.TextView r6 = r5.f14976h
            if (r6 != 0) goto La7
            goto Laa
        La7:
            r6.setVisibility(r1)
        Laa:
            r5.n0()
            goto Lb5
        Lae:
            int r6 = r5.f14978j
            if (r6 != r0) goto Lb5
            r5.J()
        Lb5:
            java.lang.Boolean r5 = p9.C1467a.a(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager.E0(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    public final View F() {
        return this.f14974f;
    }

    public final void F0(boolean z10) {
        ComponentActivity componentActivity;
        int color;
        float f10;
        if (this.f14974f != null && (componentActivity = this.f14969a) != null) {
            if (z10) {
                color = r.a(componentActivity);
            } else {
                color = componentActivity.getColor(R.color.coui_color_label_tertiary);
            }
            TextView textView = this.f14973e;
            if (textView != null) {
                textView.setEnabled(z10);
                textView.setTextColor(color);
            }
            TextView textView2 = this.f14976h;
            if (textView2 != null) {
                textView2.setEnabled(z10);
                textView2.setTextColor(color);
            }
            ImageView imageView = this.f14977i;
            if (imageView != null) {
                if (z10) {
                    f10 = 1.0f;
                } else {
                    f10 = 0.6f;
                }
                imageView.setAlpha(f10);
            }
            TextView textView3 = this.f14975g;
            if (textView3 != null) {
                textView3.setEnabled(z10);
            }
        }
    }

    public final int G(String str) {
        ComponentActivity componentActivity = this.f14969a;
        int i10 = 0;
        if (componentActivity != null) {
            i10 = j.b(componentActivity).getInt(str, 0);
            if (H7.a.b()) {
                H7.b.e("DialerHeaderViewManager", "getIgnoreTimes times = " + i10);
            }
        }
        return i10;
    }

    public final String H(String str) {
        if (this.f14969a == null) {
            return "";
        }
        if (!i.b("HK", str) && !i.b("MO", str) && !i.b("TW", str)) {
            String string = this.f14969a.getResources().getString(R.string.overseas_travel_emergency_call_tips);
            i.e(string, "activity.resources.getSt…avel_emergency_call_tips)");
            return string;
        }
        String string2 = this.f14969a.getResources().getString(R.string.overseas_travel_emergency_call_for_area_tips);
        i.e(string2, "{\n            activity.r…s\n            )\n        }");
        return string2;
    }

    public final boolean I(Context context, int i10) {
        if (b0.U(context, i10)) {
            int Q10 = b0.Q(context, i10);
            H7.b.e("DialerHeaderViewManager", "hasOperatorSignal slotId:" + i10 + " in " + Q10);
            if (Q10 != 0 && Q10 != -1) {
                return false;
            }
            return true;
        }
        H7.b.e("DialerHeaderViewManager", "hasOperatorSignal slotId:" + i10 + " no insert");
        return false;
    }

    public final void J() {
        K(true);
    }

    public final void K(boolean z10) {
        b bVar;
        View view = this.f14974f;
        if (view != null) {
            view.setVisibility(8);
            if (!z10 && (bVar = this.f14979k) != null && bVar != null) {
                bVar.a();
            }
        }
    }

    public final void L(boolean z10) {
        if (this.f14974f != null && this.f14978j == 4) {
            X();
            K(z10);
        }
    }

    public final void M() {
        TextView textView;
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity == null) {
            return;
        }
        View inflate = componentActivity.getLayoutInflater().inflate(R.layout.calllog_header_recommend_view, (ViewGroup) null);
        this.f14974f = inflate;
        if (inflate != null) {
            this.f14975g = (TextView) inflate.findViewById(R.id.recommend_text);
            this.f14977i = (ImageView) inflate.findViewById(R.id.icon);
            View findViewById = inflate.findViewById(R.id.action_text);
            i.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f14973e = (TextView) findViewById;
            r.e(this.f14969a, inflate.findViewById(R.id.container));
        }
        TextView textView2 = this.f14973e;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.dialpad.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialerHeaderViewManager.N(DialerHeaderViewManager.this, view);
                }
            });
        }
        View view = this.f14974f;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.dismiss_text);
        } else {
            textView = null;
        }
        this.f14976h = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.dialpad.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialerHeaderViewManager.O(DialerHeaderViewManager.this, view2);
                }
            });
        }
        J();
        C1248i.d(p.a(this.f14969a), S.b(), null, new DialerHeaderViewManager$initDialerHeaderView$4(this, null), 2, null);
    }

    public final boolean P() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity == null || Settings.Global.getInt(componentActivity.getContentResolver(), "privacy_call_software_mode_setting_enable", 0) != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r9v20, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q(android.content.Context r10, kotlin.coroutines.c<? super java.lang.Boolean> r11) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager.Q(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    public final boolean R(Context context) {
        if (CommonFeatureOption.m() || !P7.c.d(context, "com.oplus.aicall", false)) {
            return false;
        }
        if (L7.a.c()) {
            H7.b.e("DialerHeaderViewManager", "isNeedShowAICallTranslateTips return false for in super power save mode");
            return false;
        }
        if (AiCallTranslateStateController.f15829b.a().i(context)) {
            H7.b.e("DialerHeaderViewManager", "isNeedShowAICallTranslateTips isUserSetAICallAssistantFunc isEntered");
            return false;
        }
        if (j.b(context).getInt("need_show_ai_call_translate_tips", 0) != 0) {
            return false;
        }
        return true;
    }

    public final boolean S(Context context) {
        if (j.b(context).getInt("need_show_new_call_tips", 0) != 0) {
            return false;
        }
        return true;
    }

    public final boolean T() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity == null || Settings.System.getInt(componentActivity.getContentResolver(), "op_voice_call_nc_enabled", 0) != 1) {
            return false;
        }
        return true;
    }

    public final boolean U(Context context) {
        if (!VirtualSupportUtils.m() || !VirtualSupportUtils.n() || !PrimaryUserUtils.a() || VirtualSupportUtils.i(context) || G("ignore_times") >= 5) {
            return false;
        }
        return true;
    }

    public final boolean V() {
        ApplicationInfo applicationInfo;
        PackageManager packageManager;
        try {
            ComponentActivity componentActivity = this.f14969a;
            Bundle bundle = null;
            if (componentActivity != null && (packageManager = componentActivity.getPackageManager()) != null) {
                applicationInfo = packageManager.getApplicationInfo(E7.b.f739b, 128);
            } else {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                bundle = applicationInfo.metaData;
            }
            if (bundle == null) {
                return false;
            }
            if (!applicationInfo.metaData.getBoolean("isOverseasTravelSupport", false) || !OsUtils.k() || !FeatureOption.i() || !b0.V(this.f14969a)) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            H7.b.c("DialerHeaderViewManager", "e = " + e10);
            return false;
        }
    }

    public final boolean W(Context context) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        int i11;
        boolean z13;
        long D10;
        int G10;
        boolean z14 = false;
        if (!PrimaryUserUtils.a()) {
            H7.b.e("DialerHeaderViewManager", "Not primary user, don't show satellite call tip.");
            return false;
        }
        if (CommonOSPublicFeature.f() && com.android.contacts.framework.api.satellite.a.b()) {
            boolean d10 = J7.a.d();
            boolean f10 = J7.a.f();
            boolean c10 = J7.a.c();
            boolean e10 = J7.a.e();
            if (!d10 && !f10 && !c10 && !e10) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (H7.a.b()) {
                H7.b.b("DialerHeaderViewManager", "networkAvailable: " + d10 + ", wifiConnected: " + f10 + ", mobileConnected: " + c10 + ", roaming: " + e10 + ", hasNetwork: " + z10);
            }
            if (z10) {
                H7.b.e("DialerHeaderViewManager", "Network available, don't show satellite call tip.");
                return false;
            }
            boolean U10 = b0.U(context, 0);
            boolean U11 = b0.U(context, 1);
            if (U10) {
                z11 = b0.d0(context, 0);
            } else {
                z11 = false;
            }
            if (U11) {
                z12 = b0.d0(context, 1);
            } else {
                z12 = false;
            }
            if (H7.a.b()) {
                H7.b.b("DialerHeaderViewManager", "hasSimCard1: " + U10 + ", ctccOrSatelliteSim1: " + z11 + ", hasSimCard2: " + U11 + ", ctccOrSatelliteSim2: " + z12);
            }
            if (!z11 && !z12) {
                H7.b.e("DialerHeaderViewManager", "No target sim, don't show satellite call tip.");
                return false;
            }
            if (U10) {
                i10 = b0.Q(context, 0);
            } else {
                i10 = -1;
            }
            if (U11) {
                i11 = b0.Q(context, 1);
            } else {
                i11 = -1;
            }
            if (!z11 || !z12 ? !(!z11 ? !U10 ? i11 != 1 : i11 != 1 || (i10 != -1 && i10 != 1 && i10 != 3) : !U11 ? i10 != 1 : i10 != 1 || (i11 != -1 && i11 != 1 && i11 != 3)) : !((i10 != 1 || (i11 != -1 && i11 != 1 && i11 != 3)) && (i11 != 1 || (i10 != -1 && i10 != 1 && i10 != 3)))) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (H7.a.b()) {
                H7.b.b("DialerHeaderViewManager", "serviceState1: " + i10 + ", serviceState2: " + i11 + ", noservice: " + z13);
            }
            if (!z13) {
                H7.b.e("DialerHeaderViewManager", "Simservice available, don't show satellite call tip.");
                return false;
            }
            if (com.android.contacts.framework.api.satellite.a.d()) {
                H7.b.e("DialerHeaderViewManager", "In satellite mode, don't show satellite call tip.");
                return false;
            }
            boolean c11 = L7.a.c();
            if (c11) {
                D10 = D("satellite_call_ignored_timestamp_super_power");
            } else {
                D10 = D("satellite_call_ignored_timestamp_normal");
            }
            if (System.currentTimeMillis() - D10 < 86400000) {
                H7.b.e("DialerHeaderViewManager", "Ignored at " + D10 + ", don't show satellite call tip.");
                return false;
            }
            if (c11) {
                G10 = G("satellite_call_ignored_count_super_power");
            } else {
                G10 = G("satellite_call_ignored_count_normal");
            }
            if (G10 < 2) {
                z14 = true;
            }
            H7.b.e("DialerHeaderViewManager", "show satellite call tip: " + z14 + " [" + c11 + ", " + G10 + "]");
            return z14;
        }
        H7.b.e("DialerHeaderViewManager", "Not support, don't show satellite call tip.");
        return false;
    }

    public final void X() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            G0.c.p(componentActivity, 1, R0.c.f3189g, 0, 0, 16, null);
            G0.c.v(componentActivity, 1, R0.c.f3190h, "", 0, 16, null);
            G0.c.s(componentActivity, 1, "last_ted_recog_time", -1L, 0, 16, null);
        }
    }

    public final void Y(Context context) {
        SharedPreferences b10 = j.b(context);
        i.e(b10, "getDefaultSharedPreferences(context)");
        SharedPreferences.Editor edit = b10.edit();
        edit.putBoolean("dismiss_turn_on_number_recognition", true);
        edit.apply();
    }

    public final void Z() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            j.b(componentActivity).edit().putInt("need_show_breeno_call_tips", 1).apply();
        }
    }

    public final void a0() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            j.b(componentActivity).edit().putInt("need_show_call_Privacy_tips", 1).apply();
        }
    }

    public final void b0() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            j.b(componentActivity).edit().putInt("need_show_call_summary_tips", 1).apply();
        }
    }

    public final void c0() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            j.b(componentActivity).edit().putInt("need_show_new_call_tips", 1).apply();
        }
    }

    public final void d0() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            j.b(componentActivity).edit().putInt("need_show_vocal_highlight_tips", 1).apply();
        }
    }

    public final void e0() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            SharedPreferences b10 = j.b(componentActivity);
            b10.edit().putInt("need_show_overseas_travel_tips", 1).putInt("ignore_count", b10.getInt("ignore_count", 0) + 1).apply();
        }
    }

    public final void f0() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            j.b(componentActivity).edit().putInt("need_show_ai_call_assistant_tips", 1).apply();
        }
    }

    public final void g0() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            j.b(componentActivity).edit().putInt("need_show_ai_call_translate_tips", 1).apply();
        }
    }

    public final void h0(String str) {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            j.b(componentActivity).edit().putLong(str, System.currentTimeMillis()).apply();
        }
    }

    public final void i0(b listener) {
        i.f(listener, "listener");
        this.f14979k = listener;
    }

    public final void j0() {
        ComponentActivity componentActivity;
        ViewGroup viewGroup;
        View view = this.f14970b;
        if (view != null && (componentActivity = this.f14969a) != null) {
            COUISnackBar make = COUISnackBar.make(view, componentActivity.getString(R.string.to_sos_make_an_emergency_call), OplusAutoRedial.DELAY_FIVE_SECOND);
            i.e(make, "make(\n                di…TIME_5_SECS\n            )");
            ViewParent parent = make.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.setClipChildren(false);
            }
            make.setOnAction(R.string.look_over, new View.OnClickListener() { // from class: com.android.contacts.dialpad.view.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialerHeaderViewManager.k0(DialerHeaderViewManager.this, view2);
                }
            });
            make.show();
        }
    }

    public final void l0() {
        ComponentActivity componentActivity;
        ViewGroup viewGroup;
        View view = this.f14970b;
        if (view != null && (componentActivity = this.f14969a) != null) {
            COUISnackBar make = COUISnackBar.make(view, componentActivity.getString(R.string.satellite_network_guide_tip), AFConstants.BIND_SERVICE_TIMEOUTMILLIS);
            i.e(make, "make(\n                di…TIME_3_SECS\n            )");
            ViewParent parent = make.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.setClipChildren(false);
            }
            make.setOnAction(R.string.view_detail, new View.OnClickListener() { // from class: com.android.contacts.dialpad.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialerHeaderViewManager.m0(DialerHeaderViewManager.this, view2);
                }
            });
            make.show();
        }
    }

    public final void n0() {
        View view = this.f14974f;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void o0() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            Intent intent = new Intent("oplus.intent.action.LAUNCH_SOS_HELPER");
            intent.putExtra("start_type", "from_contacts");
            intent.setPackage(E7.b.f739b);
            R7.b.f(componentActivity, intent, R.string.activity_not_found, null, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p0(android.content.Context r10, kotlin.coroutines.c<? super java.lang.Boolean> r11) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager.p0(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(android.content.Context r12, kotlin.coroutines.c<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager.q0(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    public final boolean r0(Context context) {
        SharedPreferences b10 = j.b(context);
        if (this.f14974f != null && C0811w.f() && FeatureUtil.R() && !L7.a.c() && PrimaryUserUtils.a()) {
            if (b10.getInt("need_show_call_Privacy_tips", 0) == 0 && !P()) {
                this.f14978j = 16;
                ImageView imageView = this.f14977i;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.pd_ic_call_privacy_tips);
                }
                ImageView imageView2 = this.f14977i;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                TextView textView = this.f14973e;
                if (textView != null) {
                    textView.setText(context.getResources().getString(R.string.permission_guidance_dialog_open));
                }
                TextView textView2 = this.f14973e;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.f14976h;
                if (textView3 != null) {
                    textView3.setText(context.getResources().getString(R.string.ignore));
                }
                TextView textView4 = this.f14976h;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                TextView textView5 = this.f14975g;
                if (textView5 != null) {
                    textView5.setText(context.getResources().getString(R.string.call_privacy_tips));
                }
                n0();
                return true;
            }
            if (this.f14978j == 16) {
                J();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s0(android.content.Context r11, kotlin.coroutines.c<? super java.lang.Boolean> r12) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager.s0(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    public final boolean t0(Context context) {
        if (U(context)) {
            this.f14978j = 6;
            TextView textView = this.f14975g;
            if (textView != null) {
                textView.setText(R.string.virtual_share_not_in_service);
            }
            ImageView imageView = this.f14977i;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.pb_ic_communication_sharing_tips);
            }
            ImageView imageView2 = this.f14977i;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            TextView textView2 = this.f14973e;
            if (textView2 != null) {
                textView2.setText(context.getResources().getString(R.string.to_connect));
            }
            TextView textView3 = this.f14973e;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.f14976h;
            if (textView4 != null) {
                textView4.setText(R.string.ignore);
            }
            TextView textView5 = this.f14976h;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            n0();
            return true;
        }
        if (this.f14978j == 6) {
            J();
        }
        return false;
    }

    public final void u0() {
        ComponentActivity componentActivity = this.f14969a;
        if (componentActivity != null) {
            C1248i.d(p.a(componentActivity), S.c(), null, new DialerHeaderViewManager$tryShowHeaderView$1(this, null), 2, null);
        }
    }

    public final boolean v0(Context context, String defaultDialerPackage) {
        i.f(defaultDialerPackage, "defaultDialerPackage");
        if (this.f14974f != null) {
            if (context != null && !i.b(context.getPackageName(), defaultDialerPackage)) {
                this.f14978j = 1;
                if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                    TextView textView = this.f14975g;
                    if (textView != null) {
                        textView.setText(context.getResources().getString(R.string.odialer_change_default_dialer_header_title));
                    }
                } else {
                    TextView textView2 = this.f14975g;
                    if (textView2 != null) {
                        textView2.setText(context.getResources().getString(R.string.oplus_change_default_dialer_header_title));
                    }
                }
                TextView textView3 = this.f14973e;
                if (textView3 != null) {
                    textView3.setText(context.getResources().getString(R.string.oplus_button_set));
                }
                TextView textView4 = this.f14973e;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                ImageView imageView = this.f14977i;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.pb_ic_default_app_tips);
                }
                ImageView imageView2 = this.f14977i;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                TextView textView5 = this.f14976h;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
                n0();
                return true;
            }
            if (this.f14978j == 1) {
                J();
            }
        }
        return false;
    }

    public final boolean w0(Context context) {
        long j10;
        int i10;
        boolean z10 = false;
        if (this.f14974f != null) {
            String l10 = G0.c.l(context, 1, R0.c.f3190h, 0, 8, null);
            if (!TextUtils.isEmpty(l10)) {
                long h10 = G0.c.h(context, 1, "last_ted_recog_time", -1L, 0, 16, null);
                long currentTimeMillis = System.currentTimeMillis();
                if (H7.a.b()) {
                    H7.b.b("DialerHeaderViewManager", "tryShowHeaderViewForTedRecog nowTime = " + currentTimeMillis + ";lastTedReCogTime = " + h10);
                }
                if (h10 == -1) {
                    j10 = currentTimeMillis;
                    G0.c.s(context, 1, "last_ted_recog_time", currentTimeMillis, 0, 16, null);
                    h10 = j10;
                } else {
                    j10 = currentTimeMillis;
                }
                if (Math.abs(j10 - h10) > 86400000) {
                    X();
                    if (this.f14978j == 4) {
                        J();
                        return false;
                    }
                } else {
                    this.f14978j = 4;
                    TextView textView = this.f14973e;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    ImageView imageView = this.f14977i;
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.pb_ic_warning_tips);
                    }
                    ImageView imageView2 = this.f14977i;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    TextView textView2 = this.f14976h;
                    if (textView2 != null) {
                        textView2.setText(context.getResources().getString(R.string.oplus_know));
                    }
                    TextView textView3 = this.f14976h;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                    if (G0.c.d(context, 1, R0.c.f3189g, 0) == 1) {
                        z10 = true;
                    }
                    boolean x10 = E0.b.x();
                    if (z10 && x10) {
                        i10 = R.string.oplus_block_high_risk_number_tips;
                    } else if (z10) {
                        i10 = R.string.oplus_block_frade_number_tips;
                    } else if (x10) {
                        i10 = R.string.oplus_high_risk_number_tips;
                    } else {
                        i10 = R.string.oplus_frade_number_tips;
                    }
                    TextView textView4 = this.f14975g;
                    if (textView4 != null) {
                        textView4.setText(context.getResources().getString(i10, l10));
                    }
                    n0();
                    return true;
                }
            } else if (this.f14978j == 4) {
                J();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x0(android.content.Context r8, kotlin.coroutines.c<? super java.lang.Boolean> r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager.x0(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y0(android.content.Context r7, kotlin.coroutines.c<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNewCallTips$1
            if (r0 == 0) goto L13
            r0 = r8
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNewCallTips$1 r0 = (com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNewCallTips$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNewCallTips$1 r0 = new com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNewCallTips$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r6 = (kotlin.jvm.internal.Ref$BooleanRef) r6
            java.lang.Object r7 = r0.L$1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Object r0 = r0.L$0
            com.android.contacts.dialpad.view.DialerHeaderViewManager r0 = (com.android.contacts.dialpad.view.DialerHeaderViewManager) r0
            kotlin.b.b(r8)
            goto L60
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.b.b(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.S.a()
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNewCallTips$2 r4 = new com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNewCallTips$2
            r5 = 0
            r4.<init>(r8, r6, r7, r5)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.C1244g.g(r2, r4, r0)
            if (r0 != r1) goto L5e
            return r1
        L5e:
            r0 = r6
            r6 = r8
        L60:
            boolean r6 = r6.element
            r8 = 14
            r1 = 0
            if (r6 == 0) goto Lba
            r0.f14978j = r8
            android.widget.TextView r6 = r0.f14975g
            if (r6 == 0) goto L73
            r8 = 2132019807(0x7f140a5f, float:1.967796E38)
            r6.setText(r8)
        L73:
            android.widget.ImageView r6 = r0.f14977i
            if (r6 == 0) goto L7d
            r8 = 2131232608(0x7f080760, float:1.808133E38)
            r6.setImageResource(r8)
        L7d:
            android.widget.ImageView r6 = r0.f14977i
            if (r6 != 0) goto L82
            goto L85
        L82:
            r6.setVisibility(r1)
        L85:
            android.widget.TextView r6 = r0.f14973e
            if (r6 != 0) goto L8a
            goto L98
        L8a:
            android.content.res.Resources r7 = r7.getResources()
            r8 = 2132019423(0x7f1408df, float:1.967718E38)
            java.lang.String r7 = r7.getString(r8)
            r6.setText(r7)
        L98:
            android.widget.TextView r6 = r0.f14973e
            if (r6 != 0) goto L9d
            goto La0
        L9d:
            r6.setVisibility(r1)
        La0:
            android.widget.TextView r6 = r0.f14976h
            if (r6 == 0) goto Laa
            r7 = 2132018394(0x7f1404da, float:1.9675093E38)
            r6.setText(r7)
        Laa:
            android.widget.TextView r6 = r0.f14976h
            if (r6 != 0) goto Laf
            goto Lb2
        Laf:
            r6.setVisibility(r1)
        Lb2:
            r0.n0()
            java.lang.Boolean r6 = p9.C1467a.a(r3)
            return r6
        Lba:
            int r6 = r0.f14978j
            if (r6 != r8) goto Lc1
            r0.J()
        Lc1:
            java.lang.Boolean r6 = p9.C1467a.a(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager.y0(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z0(int r6, v9.InterfaceC1637a<java.lang.Boolean> r7, kotlin.coroutines.c<? super java.lang.Boolean> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTips$1
            if (r0 == 0) goto L13
            r0 = r8
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTips$1 r0 = (com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTips$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTips$1 r0 = new com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTips$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$0
            com.android.contacts.dialpad.view.DialerHeaderViewManager r5 = (com.android.contacts.dialpad.view.DialerHeaderViewManager) r5
            kotlin.b.b(r8)
            goto L51
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.b.b(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.S.b()
            com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTips$show$1 r2 = new com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTips$show$1
            r4 = 0
            r2.<init>(r7, r4)
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.C1244g.g(r8, r2, r0)
            if (r8 != r1) goto L51
            return r1
        L51:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r7 = r8.booleanValue()
            r8 = 0
            if (r7 == 0) goto La4
            r5.f14978j = r6
            android.widget.TextView r6 = r5.f14975g
            if (r6 == 0) goto L66
            r7 = 2132018792(0x7f140668, float:1.96759E38)
            r6.setText(r7)
        L66:
            android.widget.ImageView r6 = r5.f14977i
            if (r6 == 0) goto L70
            r7 = 2131232614(0x7f080766, float:1.8081342E38)
            r6.setImageResource(r7)
        L70:
            android.widget.ImageView r6 = r5.f14977i
            if (r6 != 0) goto L75
            goto L78
        L75:
            r6.setVisibility(r8)
        L78:
            android.widget.TextView r6 = r5.f14973e
            if (r6 == 0) goto L82
            r7 = 2132019813(0x7f140a65, float:1.9677971E38)
            r6.setText(r7)
        L82:
            android.widget.TextView r6 = r5.f14973e
            if (r6 != 0) goto L87
            goto L8a
        L87:
            r6.setVisibility(r8)
        L8a:
            android.widget.TextView r6 = r5.f14976h
            if (r6 == 0) goto L94
            r7 = 2132018393(0x7f1404d9, float:1.9675091E38)
            r6.setText(r7)
        L94:
            android.widget.TextView r6 = r5.f14976h
            if (r6 != 0) goto L99
            goto L9c
        L99:
            r6.setVisibility(r8)
        L9c:
            r5.n0()
            java.lang.Boolean r5 = p9.C1467a.a(r3)
            return r5
        La4:
            int r7 = r5.f14978j
            if (r7 != r6) goto Lab
            r5.J()
        Lab:
            java.lang.Boolean r5 = p9.C1467a.a(r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager.z0(int, v9.a, kotlin.coroutines.c):java.lang.Object");
    }
}
