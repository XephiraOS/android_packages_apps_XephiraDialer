package com.oplus.blacklistapp.callintercept.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0863y;
import com.oplus.utils.StatisticsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import v6.C1632f;
import v9.InterfaceC1637a;

/* compiled from: NonBlockedRulesSettingFragment.kt */
/* loaded from: classes3.dex */
public final class NonBlockedRulesSettingFragment extends v implements Preference.c {

    /* renamed from: o, reason: collision with root package name */
    public static final a f26802o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final m9.d f26803a;

    /* renamed from: b, reason: collision with root package name */
    public final m9.d f26804b;

    /* renamed from: c, reason: collision with root package name */
    public final m9.d f26805c;

    /* renamed from: d, reason: collision with root package name */
    public final m9.d f26806d;

    /* renamed from: e, reason: collision with root package name */
    public COUIJumpPreference f26807e;

    /* renamed from: f, reason: collision with root package name */
    public com.oplus.blacklistapp.callintercept.widget.a f26808f;

    /* renamed from: g, reason: collision with root package name */
    public Context f26809g;

    /* renamed from: h, reason: collision with root package name */
    public Intent f26810h;

    /* renamed from: i, reason: collision with root package name */
    public int f26811i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f26812j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f26813k;

    /* renamed from: l, reason: collision with root package name */
    public SharedPreferences.OnSharedPreferenceChangeListener f26814l;

    /* renamed from: m, reason: collision with root package name */
    public ContentObserver f26815m;

    /* renamed from: n, reason: collision with root package name */
    public Handler f26816n;

    /* compiled from: NonBlockedRulesSettingFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: NonBlockedRulesSettingFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            if (!NonBlockedRulesSettingFragment.this.isAdded()) {
                return;
            }
            int i10 = msg.what;
            if (i10 == 101) {
                NonBlockedRulesSettingFragment.this.r1();
                C0849j.z(NonBlockedRulesSettingFragment.this.getActivity());
            } else {
                if (i10 == 102) {
                    com.oplus.blacklistapp.callintercept.widget.a aVar = NonBlockedRulesSettingFragment.this.f26808f;
                    if (aVar != null) {
                        aVar.e();
                    }
                    C0849j.z(NonBlockedRulesSettingFragment.this.getActivity());
                    return;
                }
                Log.w("CallHarassInterceptMarkedNumberFragment", "Message not expected: " + i10);
            }
        }
    }

    /* compiled from: NonBlockedRulesSettingFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c extends ContentObserver {
        public c() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            NonBlockedRulesSettingFragment.this.f26816n.removeMessages(102);
            NonBlockedRulesSettingFragment.this.f26816n.sendEmptyMessageDelayed(102, 200L);
            NonBlockedRulesSettingFragment.this.f26816n.removeMessages(101);
            NonBlockedRulesSettingFragment.this.f26816n.sendEmptyMessageDelayed(101, 200L);
        }
    }

    public NonBlockedRulesSettingFragment() {
        m9.d b10;
        m9.d b11;
        m9.d b12;
        m9.d b13;
        b10 = kotlin.a.b(new InterfaceC1637a<COUIPreferenceCategory>() { // from class: com.oplus.blacklistapp.callintercept.settings.NonBlockedRulesSettingFragment$mNonBlockedCategory$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final COUIPreferenceCategory invoke() {
                Preference findPreference = NonBlockedRulesSettingFragment.this.findPreference("non_blocked_rules_category");
                kotlin.jvm.internal.i.d(findPreference, "null cannot be cast to non-null type com.coui.appcompat.preference.COUIPreferenceCategory");
                return (COUIPreferenceCategory) findPreference;
            }
        });
        this.f26803a = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<COUISwitchPreference>() { // from class: com.oplus.blacklistapp.callintercept.settings.NonBlockedRulesSettingFragment$mNotHarassInterceptRepeat$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final COUISwitchPreference invoke() {
                Preference findPreference = NonBlockedRulesSettingFragment.this.findPreference("repeat_call");
                kotlin.jvm.internal.i.d(findPreference, "null cannot be cast to non-null type com.coui.appcompat.preference.COUISwitchPreference");
                return (COUISwitchPreference) findPreference;
            }
        });
        this.f26804b = b11;
        b12 = kotlin.a.b(new InterfaceC1637a<COUISwitchPreference>() { // from class: com.oplus.blacklistapp.callintercept.settings.NonBlockedRulesSettingFragment$mHarassInterceptCredibleStrangers$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final COUISwitchPreference invoke() {
                Preference findPreference = NonBlockedRulesSettingFragment.this.findPreference("credible_strangers_number");
                kotlin.jvm.internal.i.d(findPreference, "null cannot be cast to non-null type com.coui.appcompat.preference.COUISwitchPreference");
                return (COUISwitchPreference) findPreference;
            }
        });
        this.f26805c = b12;
        b13 = kotlin.a.b(new InterfaceC1637a<COUISwitchPreference>() { // from class: com.oplus.blacklistapp.callintercept.settings.NonBlockedRulesSettingFragment$mAutoOpenAndClose$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final COUISwitchPreference invoke() {
                Preference findPreference = NonBlockedRulesSettingFragment.this.findPreference("auto_open_and_close_key");
                kotlin.jvm.internal.i.d(findPreference, "null cannot be cast to non-null type com.coui.appcompat.preference.COUISwitchPreference");
                return (COUISwitchPreference) findPreference;
            }
        });
        this.f26806d = b13;
        this.f26816n = new b(Looper.getMainLooper());
    }

    private final void log(String str) {
        C0846g.i("NonBlockedRulesSettingFragment", str);
    }

    public static final void p1(NonBlockedRulesSettingFragment this$0, SharedPreferences sharedPreferences, String str) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (kotlin.jvm.internal.i.b(str, "not_intercept_repeat_call") || kotlin.jvm.internal.i.b(str, "not_intercept_credible_strangers")) {
            this$0.f26816n.removeMessages(101);
            this$0.f26816n.sendEmptyMessageDelayed(101, 200L);
            return;
        }
        if (!kotlin.jvm.internal.i.b(str, "auto_open_and_close")) {
            if (!kotlin.jvm.internal.i.b(str, "open_days_" + this$0.f26811i)) {
                if (!kotlin.jvm.internal.i.b(str, "open_start_hour_" + this$0.f26811i)) {
                    if (!kotlin.jvm.internal.i.b(str, "open_start_minute_" + this$0.f26811i)) {
                        if (!kotlin.jvm.internal.i.b(str, "open_end_hour_" + this$0.f26811i)) {
                            if (!kotlin.jvm.internal.i.b(str, "open_end_minute_" + this$0.f26811i)) {
                                return;
                            }
                        }
                    }
                }
            }
        }
        this$0.f26816n.removeMessages(102);
        this$0.f26816n.sendEmptyMessageDelayed(102, 200L);
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void P0(int i10) {
        log("handleHotPlugIn...");
    }

    public final void g1(String str, int i10) {
        log("addUserAction tag = " + str + " value = " + i10);
        Context context = this.f26809g;
        if (context == null) {
            kotlin.jvm.internal.i.q("mContext");
            context = null;
        }
        StatisticsUtils.a(context, 2010804, 201082006, StatisticsUtils.f(str, i10, this.f26812j, this.f26811i), false);
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        String string = getString(com.oplus.blacklistapp.u.f27695u);
        kotlin.jvm.internal.i.e(string, "getString(R.string.anti_non_blocked_rules)");
        return string;
    }

    public final void h1(COUISwitchPreference cOUISwitchPreference) {
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(false);
            cOUISwitchPreference.setEnabled(false);
        }
    }

    public final void i1() {
        COUISwitchPreference j12 = j1();
        if (j12 != null) {
            j12.setEnabled(true);
        }
        COUISwitchPreference m12 = m1();
        if (m12 != null) {
            m12.setEnabled(true);
        }
        COUISwitchPreference k12 = k1();
        if (k12 != null) {
            k12.setEnabled(true);
        }
    }

    public final COUISwitchPreference j1() {
        return (COUISwitchPreference) this.f26806d.getValue();
    }

    @Override // androidx.preference.Preference.c
    public boolean k0(Preference preference, Object obj) {
        String str;
        String str2;
        String str3;
        kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Context context = null;
        if (preference != null) {
            str = preference.getKey();
        } else {
            str = null;
        }
        log("harass_intercept_all_strangers_calls click ,key = " + str);
        if (preference != null) {
            str2 = preference.getKey();
        } else {
            str2 = null;
        }
        if (kotlin.jvm.internal.i.b("repeat_call", str2)) {
            log("harass_intercept_not_repeat click ,isChecked = " + booleanValue);
            q1("not_intercept_repeat_call", booleanValue, 0);
            Context context2 = this.f26809g;
            if (context2 == null) {
                kotlin.jvm.internal.i.q("mContext");
            } else {
                context = context2;
            }
            g1("do_not_block_repeated_calls", androidx.preference.j.b(context.getApplicationContext()).getInt("not_intercept_repeat_call", 0));
            return true;
        }
        if (preference != null) {
            str3 = preference.getKey();
        } else {
            str3 = null;
        }
        if (kotlin.jvm.internal.i.b("credible_strangers_number", str3)) {
            log("harass_intercept_credible click ,isChecked = " + booleanValue);
            q1("not_intercept_credible_strangers", booleanValue, 3);
            Context context3 = this.f26809g;
            if (context3 == null) {
                kotlin.jvm.internal.i.q("mContext");
            } else {
                context = context3;
            }
            g1("do_not_block_special_numbers", androidx.preference.j.b(context.getApplicationContext()).getInt("not_intercept_credible_strangers", 3));
            return true;
        }
        com.oplus.blacklistapp.callintercept.widget.a aVar = this.f26808f;
        if (aVar != null && aVar != null) {
            aVar.f(preference, obj);
            return true;
        }
        return true;
    }

    public final COUISwitchPreference k1() {
        return (COUISwitchPreference) this.f26805c.getValue();
    }

    public final COUIPreferenceCategory l1() {
        return (COUIPreferenceCategory) this.f26803a.getValue();
    }

    public final COUISwitchPreference m1() {
        return (COUISwitchPreference) this.f26804b.getValue();
    }

    public boolean n1(String str, int i10) {
        Context context = this.f26809g;
        if (context == null) {
            kotlin.jvm.internal.i.q("mContext");
            context = null;
        }
        return C1632f.C(androidx.preference.j.b(context.getApplicationContext()), str, i10, this.f26811i);
    }

    public final void o1(Intent intent) {
        kotlin.jvm.internal.i.f(intent, "intent");
        this.f26810h = intent;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        super.onAttach(context);
        this.f26809g = context;
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f26811i = C0863y.b(this.f26810h, "slotId", 0);
        this.f26812j = C0863y.a(this.f26810h, "is_single_sim", false);
        Context context = this.f26809g;
        if (context == null) {
            kotlin.jvm.internal.i.q("mContext");
            context = null;
        }
        this.f26813k = androidx.preference.j.b(context).getBoolean("has_attribution_data_" + this.f26811i, false);
        addPreferencesFromResource(com.oplus.blacklistapp.w.f27740f);
        COUISwitchPreference k12 = k1();
        if (k12 != null) {
            k12.setOnPreferenceChangeListener(this);
        }
        COUISwitchPreference m12 = m1();
        if (m12 != null) {
            m12.setOnPreferenceChangeListener(this);
        }
        Preference findPreference = findPreference("days_setting");
        kotlin.jvm.internal.i.d(findPreference, "null cannot be cast to non-null type com.coui.appcompat.preference.COUIJumpPreference");
        this.f26807e = (COUIJumpPreference) findPreference;
        if (l7.b.f34737e) {
            l1().removePreference(k1());
        }
        com.oplus.blacklistapp.callintercept.widget.a aVar = new com.oplus.blacklistapp.callintercept.widget.a(getActivity(), getPreferenceScreen(), this);
        this.f26808f = aVar;
        aVar.h(this.f26811i, this.f26812j);
        r1();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        getListView().setItemAnimator(null);
        return onCreateView;
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        StatisticsUtils.e(getActivity(), "non_blocked_rules_back");
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.i.f(item, "item");
        if (item.getItemId() == 16908332) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return true;
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Context context = getContext();
        if (context != null) {
            if (this.f26814l == null) {
                this.f26814l = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.oplus.blacklistapp.callintercept.settings.w
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                        NonBlockedRulesSettingFragment.p1(NonBlockedRulesSettingFragment.this, sharedPreferences, str);
                    }
                };
            }
            getPreferenceManager().l().registerOnSharedPreferenceChangeListener(this.f26814l);
            ArrayList arrayList = new ArrayList();
            Uri h10 = z6.b.h(1, C1632f.f37464r, 0, 4, null);
            if (h10 != null) {
                arrayList.add(h10);
            }
            Uri h11 = z6.b.h(1, C1632f.f37467u, 0, 4, null);
            if (h11 != null) {
                arrayList.add(h11);
            }
            if (!arrayList.isEmpty()) {
                ContentResolver contentResolver = context.getContentResolver();
                c cVar = new c();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    contentResolver.registerContentObserver((Uri) it.next(), true, cVar);
                }
                this.f26815m = cVar;
            }
        }
        com.oplus.blacklistapp.callintercept.widget.a aVar = this.f26808f;
        if (aVar != null) {
            aVar.e();
        }
        r1();
        StatisticsUtils.c(getActivity(), "non_blocked_rules_entry", this.f26812j, this.f26811i);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onStop() {
        Context context = getContext();
        if (context != null) {
            if (this.f26814l != null) {
                getPreferenceManager().l().registerOnSharedPreferenceChangeListener(this.f26814l);
                this.f26814l = null;
            }
            ContentObserver contentObserver = this.f26815m;
            if (contentObserver != null) {
                context.getContentResolver().unregisterContentObserver(contentObserver);
                this.f26815m = null;
            }
        }
        super.onStop();
    }

    public void q1(String str, boolean z10, int i10) {
        Context context = this.f26809g;
        if (context == null) {
            kotlin.jvm.internal.i.q("mContext");
            context = null;
        }
        u.d(androidx.preference.j.b(context.getApplicationContext()), this.f26811i, str, z10, i10);
    }

    public final void r1() {
        i1();
        Context context = this.f26809g;
        Context context2 = null;
        if (context == null) {
            kotlin.jvm.internal.i.q("mContext");
            context = null;
        }
        boolean B10 = C1632f.B(context, C1632f.f37464r, 0, this.f26811i);
        Context context3 = this.f26809g;
        if (context3 == null) {
            kotlin.jvm.internal.i.q("mContext");
        } else {
            context2 = context3;
        }
        boolean B11 = C1632f.B(context2, C1632f.f37467u, 0, this.f26811i);
        boolean n12 = n1("not_intercept_repeat_call", 0);
        log("updateSwitchState isNotHarassInterceptRepeat = " + n12);
        COUISwitchPreference m12 = m1();
        if (m12 != null) {
            m12.setChecked(n12);
        }
        if (!l7.b.f34737e) {
            boolean n13 = n1("not_intercept_credible_strangers", 3);
            log("updateSwitchState isHarassInterceptCredibleStrangers = " + n13);
            COUISwitchPreference k12 = k1();
            if (k12 != null) {
                k12.setChecked(n13);
            }
        }
        if (!B10 && !B11) {
            com.oplus.blacklistapp.callintercept.widget.a aVar = this.f26808f;
            if (aVar != null) {
                aVar.n(false);
            }
            h1(j1());
            if (!this.f26813k) {
                h1(k1());
                return;
            }
            return;
        }
        if (B10) {
            h1(k1());
            h1(m1());
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void u(int i10) {
        log("handleHotPlugOut...");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
