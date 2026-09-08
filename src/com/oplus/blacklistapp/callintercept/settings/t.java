package com.oplus.blacklistapp.callintercept.settings;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.BlockedNumberContract;
import android.provider.Telephony;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import c7.C0565a;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.oplus.blacklistapp.framework.baseui.util.highlight.HighLightJumpPreference;
import com.oplus.blacklistapp.framework.baseui.util.highlight.HighLightMenuPreference;
import com.oplus.blacklistapp.framework.baseui.util.highlight.HighLightSwitchPreference;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import com.oplus.utils.C0863y;
import com.oplus.utils.D;
import com.oplus.utils.F;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import v6.C1628b;
import v6.C1629c;
import v6.C1632f;
import v6.C1633g;

/* compiled from: HarassInterceptSettingFragment.java */
/* loaded from: classes3.dex */
public class t extends v implements Preference.c, DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public COUIPreferenceCategory f26936a;

    /* renamed from: b, reason: collision with root package name */
    public COUIJumpPreference f26937b;

    /* renamed from: c, reason: collision with root package name */
    public HighLightJumpPreference f26938c;

    /* renamed from: d, reason: collision with root package name */
    public HighLightJumpPreference f26939d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f26940e;

    /* renamed from: f, reason: collision with root package name */
    public HighLightJumpPreference f26941f;

    /* renamed from: g, reason: collision with root package name */
    public HighLightJumpPreference f26942g;

    /* renamed from: h, reason: collision with root package name */
    public HighLightSwitchPreference f26943h;

    /* renamed from: i, reason: collision with root package name */
    public Preference f26944i;

    /* renamed from: j, reason: collision with root package name */
    public HighLightMenuPreference f26945j;

    /* renamed from: k, reason: collision with root package name */
    public String[] f26946k;

    /* renamed from: m, reason: collision with root package name */
    public Context f26948m;

    /* renamed from: z, reason: collision with root package name */
    public static final String f26935z = F6.e.M();

    /* renamed from: A, reason: collision with root package name */
    public static final String f26934A = "content://" + com.oplus.blacklist.database.a.f26232a + "/bl_list";

    /* renamed from: l, reason: collision with root package name */
    public String f26947l = null;

    /* renamed from: n, reason: collision with root package name */
    public Dialog f26949n = null;

    /* renamed from: o, reason: collision with root package name */
    public boolean f26950o = true;

    /* renamed from: p, reason: collision with root package name */
    public ContentObserver f26951p = null;

    /* renamed from: q, reason: collision with root package name */
    public ContentObserver f26952q = null;

    /* renamed from: r, reason: collision with root package name */
    public ContentObserver f26953r = null;

    /* renamed from: x, reason: collision with root package name */
    public ExecutorService f26954x = null;

    /* renamed from: y, reason: collision with root package name */
    public Handler f26955y = new f(Looper.getMainLooper());

    /* compiled from: HarassInterceptSettingFragment.java */
    /* loaded from: classes3.dex */
    public class a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f26956a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, Uri uri) {
            super(handler);
            this.f26956a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            if (this.f26956a.equals(uri)) {
                t.this.H1();
            }
        }
    }

    /* compiled from: HarassInterceptSettingFragment.java */
    /* loaded from: classes3.dex */
    public class b extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f26958a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Handler handler, Uri uri) {
            super(handler);
            this.f26958a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            if (this.f26958a.equals(uri)) {
                t.this.f26943h.setChecked(D.a(t.this.f26948m));
            }
        }
    }

    /* compiled from: HarassInterceptSettingFragment.java */
    /* loaded from: classes3.dex */
    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            t.this.F1();
        }
    }

    /* compiled from: HarassInterceptSettingFragment.java */
    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            D.b(t.this.f26948m, 1);
            F.b(t.this.f26948m, true);
            t.this.f26943h.setChecked(true);
            t.this.r1();
        }
    }

    /* compiled from: HarassInterceptSettingFragment.java */
    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            t.this.r1();
        }
    }

    /* compiled from: HarassInterceptSettingFragment.java */
    /* loaded from: classes3.dex */
    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!t.this.isAdded()) {
                t.log("fragment is not added, return");
                return;
            }
            int i10 = message.what;
            if (i10 != 1000) {
                if (i10 == 1001) {
                    t.log("MSG_REFRESH_HARASS_PREFERENCE_STATE");
                    t.this.x1();
                    return;
                } else {
                    Log.w("HarassInterceptSetting", "Message not expected: " + message.what);
                    return;
                }
            }
            if (message.arg2 == 1 && t.this.f26938c != null) {
                int i11 = message.arg1;
                String string = t.this.getString(com.oplus.blacklistapp.u.f27712x1);
                if (i11 != 0) {
                    string = String.format(t.this.getResources().getQuantityText(com.oplus.blacklistapp.t.f27484f, i11).toString(), Integer.valueOf(i11));
                }
                t.this.f26938c.setAssignment(string);
                return;
            }
            if (message.arg2 == 2 && t.this.f26939d != null) {
                int i12 = message.arg1;
                String string2 = t.this.getString(com.oplus.blacklistapp.u.f27712x1);
                if (i12 != 0) {
                    string2 = String.format(t.this.getResources().getQuantityText(com.oplus.blacklistapp.t.f27485g, i12).toString(), Integer.valueOf(i12));
                }
                t.this.f26939d.setAssignment(string2);
            }
        }
    }

    /* compiled from: HarassInterceptSettingFragment.java */
    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnKeyListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                return true;
            }
            return false;
        }
    }

    private void G1() {
        if (this.f26936a != null && this.f26937b != null) {
            if (com.oplus.blacklistapp.framework.api.sync.a.e()) {
                this.f26936a.setVisible(true);
                if (this.f26954x == null) {
                    this.f26954x = Executors.newSingleThreadExecutor();
                }
                this.f26954x.execute(new Runnable() { // from class: com.oplus.blacklistapp.callintercept.settings.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.this.w1();
                    }
                });
                return;
            }
            this.f26936a.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
        C0846g.i("HarassInterceptSetting", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        Dialog dialog = this.f26949n;
        if (dialog != null) {
            dialog.dismiss();
            this.f26949n = null;
        }
    }

    private void s1() {
        log("finish");
        requireActivity().finish();
        if (TextUtils.isEmpty(this.f26947l)) {
            C1632f.U(getActivity());
        }
    }

    private HashMap<String, String> t1(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(str, str2);
        return hashMap;
    }

    public static boolean u1(Context context) {
        String str;
        try {
            str = Telephony.Sms.getDefaultSmsPackage(context);
        } catch (Exception e10) {
            Log.e("HarassInterceptSetting", "isSmsEnabled has en error." + e10);
            str = null;
        }
        Log.e("HarassInterceptSetting", "isSmsEnabled defaultSmsApplication = " + str);
        if (str != null && str.equals("com.android.mms")) {
            return true;
        }
        return false;
    }

    public final void A1(boolean z10) {
        HighLightJumpPreference highLightJumpPreference = this.f26941f;
        if (highLightJumpPreference != null) {
            highLightJumpPreference.setEnabled(z10);
        }
        HighLightJumpPreference highLightJumpPreference2 = this.f26942g;
        if (highLightJumpPreference2 != null) {
            highLightJumpPreference2.setEnabled(z10);
        }
    }

    public final void B1(Intent intent) {
        if ("anti_fraud_center".equals(C0863y.d(intent, "navigate_item_name"))) {
            this.f26943h.a(true);
        }
        String stringExtra = intent.getStringExtra(":settings:fragment_args_key");
        log("searchHighlight=" + stringExtra);
        if (stringExtra != null) {
            char c10 = 65535;
            switch (stringExtra.hashCode()) {
                case -1904689218:
                    if (stringExtra.equals("blacklist_intercept_blacklist")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1703976278:
                    if (stringExtra.equals("blacklist_intercept_notification")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -596584728:
                    if (stringExtra.equals("blacklist_intercept_whitelist")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 1430136226:
                    if (stringExtra.equals("blacklist_intercept_settings_nation_anti_fraud")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 1880805212:
                    if (stringExtra.equals("blacklist_anti_harassment_call")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 2014193262:
                    if (stringExtra.equals("blacklist_anti_harassment_information")) {
                        c10 = 5;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    HighLightJumpPreference highLightJumpPreference = this.f26938c;
                    if (highLightJumpPreference != null) {
                        highLightJumpPreference.a(true);
                        return;
                    }
                    return;
                case 1:
                    HighLightMenuPreference highLightMenuPreference = this.f26945j;
                    if (highLightMenuPreference != null) {
                        highLightMenuPreference.a(true);
                        return;
                    }
                    return;
                case 2:
                    HighLightJumpPreference highLightJumpPreference2 = this.f26939d;
                    if (highLightJumpPreference2 != null) {
                        highLightJumpPreference2.a(true);
                        return;
                    }
                    return;
                case 3:
                    HighLightSwitchPreference highLightSwitchPreference = this.f26943h;
                    if (highLightSwitchPreference != null) {
                        highLightSwitchPreference.a(true);
                        return;
                    }
                    return;
                case 4:
                    HighLightJumpPreference highLightJumpPreference3 = this.f26941f;
                    if (highLightJumpPreference3 != null) {
                        highLightJumpPreference3.a(true);
                        return;
                    }
                    return;
                case 5:
                    HighLightJumpPreference highLightJumpPreference4 = this.f26942g;
                    if (highLightJumpPreference4 != null) {
                        highLightJumpPreference4.a(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void C1(int i10) {
        HighLightMenuPreference highLightMenuPreference = this.f26945j;
        if (highLightMenuPreference != null) {
            highLightMenuPreference.setAssignment(this.f26946k[i10]);
        }
        z6.b.i(this.f26948m, 1, f26935z, i10);
        n1(201110038, "notifications_record", this.f26946k[i10]);
    }

    public final void D1() {
        if (requireActivity().getIntent() == null) {
            C0846g.i("HarassInterceptSetting", "showDialogByIntent ");
            return;
        }
        r1();
        Dialog p12 = p1();
        this.f26949n = p12;
        if (p12 != null) {
            p12.show();
        }
    }

    public final void E1() {
        r1();
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(requireActivity());
        cOUIAlertDialogBuilder.setTitle((CharSequence) getString(com.oplus.blacklistapp.u.f27645k));
        cOUIAlertDialogBuilder.setMessage((CharSequence) getString(com.oplus.blacklistapp.u.f27607c1));
        cOUIAlertDialogBuilder.setPositiveButton(com.oplus.blacklistapp.u.f27640j, (DialogInterface.OnClickListener) new d());
        cOUIAlertDialogBuilder.setNegativeButton(com.oplus.blacklistapp.u.f27723z2, (DialogInterface.OnClickListener) new e());
        androidx.appcompat.app.b create = cOUIAlertDialogBuilder.create();
        this.f26949n = create;
        create.show();
        cOUIAlertDialogBuilder.updateViewAfterShown();
    }

    public final void F1() {
        String str;
        if (C0844e.f29134b) {
            str = BlockedNumberContract.BlockedNumbers.CONTENT_URI.toString();
        } else {
            str = f26934A;
        }
        C1632f.V(this.f26948m, str, this.f26955y, -1, 1);
        C1632f.V(this.f26948m, f26934A, this.f26955y, -1, 2);
    }

    public final void H1() {
        int i10;
        int i11 = 2;
        if (I6.b.d()) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int c10 = z6.b.c(getActivity(), 1, f26935z, i10);
        HighLightMenuPreference highLightMenuPreference = this.f26945j;
        if (highLightMenuPreference != null) {
            highLightMenuPreference.setAssignment(this.f26946k[c10]);
            if (c10 != 1) {
                if (c10 == 2) {
                    i11 = 1;
                } else {
                    i11 = c10;
                }
            }
            this.f26945j.setValueIndex(i11);
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void P0(int i10) {
        log("handleHotPlugIn...");
        y1();
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        return getString(com.oplus.blacklistapp.u.f27651l0);
    }

    @Override // androidx.preference.Preference.c
    public boolean k0(Preference preference, Object obj) {
        if ("intercept_notification_key".equals(preference.getKey())) {
            int parseInt = Integer.parseInt((String) obj);
            C0846g.i("HarassInterceptSetting", "Intercept Notification Clicked, item = " + parseInt);
            C1(parseInt);
            return true;
        }
        if ("intercept_settings_nation_anti_fraud_key".equals(preference.getKey())) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            if (booleanValue && !F.a(this.f26948m)) {
                E1();
                return false;
            }
            D.b(this.f26948m, booleanValue ? 1 : 0);
            return true;
        }
        return true;
    }

    public void m1(int i10, String str) {
        log("addUserAction type = " + i10 + " tag = " + str);
        C1628b.a(this.f26948m, "2011101", i10, t1(str, String.valueOf(true)));
    }

    public void n1(int i10, String str, String str2) {
        log("addUserAction type = " + i10 + " tag = " + str + "value = " + str2);
        C1628b.a(this.f26948m, "2011101", i10, t1(str, str2));
    }

    public final void o1() {
        String string;
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            if (u1(getActivity())) {
                Preference preference = this.f26944i;
                if (preference != null) {
                    preferenceScreen.removePreference(preference);
                    return;
                }
                return;
            }
            if (l7.b.f34742j) {
                Preference preference2 = this.f26944i;
                if (preference2 != null) {
                    preferenceScreen.removePreference(preference2);
                    return;
                }
                return;
            }
            Preference preference3 = this.f26944i;
            if (preference3 != null) {
                preferenceScreen.addPreference(preference3);
                if (l7.b.f34743k) {
                    string = getString(com.oplus.blacklistapp.u.f27552P0);
                } else {
                    string = getString(com.oplus.blacklistapp.u.f27548O0);
                }
                this.f26944i.setSummary(string);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f26948m = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        Log.d("HarassInterceptSetting", "onClick id = " + i10);
        if (i10 == -1) {
            C1632f.c0(getContext());
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        HighLightJumpPreference highLightJumpPreference;
        HighLightJumpPreference highLightJumpPreference2;
        HighLightJumpPreference highLightJumpPreference3;
        HighLightJumpPreference highLightJumpPreference4;
        COUIPreferenceCategory cOUIPreferenceCategory;
        super.onCreate(bundle);
        log("Creating HarassInterceptSetting");
        addPreferencesFromResource(com.oplus.blacklistapp.w.f27739e);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        this.f26938c = (HighLightJumpPreference) findPreference("intercept_crank_call");
        this.f26939d = (HighLightJumpPreference) findPreference("intercept_whitelist_key");
        this.f26941f = (HighLightJumpPreference) findPreference("anti_harassment_call");
        this.f26942g = (HighLightJumpPreference) findPreference("anti_harassment_information");
        this.f26944i = findPreference("default_sms_summary_key");
        this.f26943h = (HighLightSwitchPreference) findPreference("intercept_settings_nation_anti_fraud_key");
        this.f26945j = (HighLightMenuPreference) findPreference("intercept_notification_key");
        q1(preferenceScreen);
        if (l7.b.c(this.f26948m) && (cOUIPreferenceCategory = (COUIPreferenceCategory) findPreference("pref_key_intercept_black_white")) != null) {
            cOUIPreferenceCategory.setVisible(false);
        }
        String[] stringArray = getResources().getStringArray(com.oplus.blacklistapp.j.f27268d);
        this.f26946k = stringArray;
        String str = stringArray[1];
        stringArray[1] = stringArray[2];
        stringArray[2] = str;
        HighLightMenuPreference highLightMenuPreference = this.f26945j;
        if (highLightMenuPreference != null) {
            highLightMenuPreference.setOnPreferenceChangeListener(this);
            this.f26945j.setAssignment(" ");
            Uri f10 = z6.b.f(1, f26935z);
            if (f10 != null) {
                this.f26952q = new a(this.f26955y, f10);
                requireContext().getContentResolver().registerContentObserver(f10, true, this.f26952q);
            }
        }
        H1();
        HighLightJumpPreference highLightJumpPreference5 = this.f26938c;
        if (highLightJumpPreference5 != null && !l7.b.f34743k) {
            highLightJumpPreference5.setAssignment(" ");
        }
        HighLightJumpPreference highLightJumpPreference6 = this.f26939d;
        if (highLightJumpPreference6 != null) {
            highLightJumpPreference6.setAssignment(" ");
        }
        if (l7.b.k()) {
            HighLightJumpPreference highLightJumpPreference7 = this.f26938c;
            if (highLightJumpPreference7 != null) {
                highLightJumpPreference7.setSummary(com.oplus.blacklistapp.u.f27583X);
            }
            HighLightJumpPreference highLightJumpPreference8 = this.f26939d;
            if (highLightJumpPreference8 != null) {
                highLightJumpPreference8.setSummary(com.oplus.blacklistapp.u.f27694t3);
            }
        }
        Intent intent = requireActivity().getIntent();
        Preference preference = this.f26944i;
        if (preference != null) {
            preferenceScreen.removePreference(preference);
        }
        if (intent != null) {
            String d10 = C0863y.d(intent, "package");
            log("onCreate end fromPackage = " + d10);
            n1(201110018, "start_harass_type", d10);
            B1(intent);
        }
        x1();
        z1();
        Context context = getContext();
        String str2 = C1629c.f37417c;
        if (C0848i.p(context, str2) && !str2.equals(C1632f.p(requireContext()))) {
            D1();
        }
        if (l7.b.f34742j || l7.b.e()) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("pref_key_intercept_settings");
            if (preferenceCategory != null && (highLightJumpPreference2 = this.f26942g) != null) {
                preferenceCategory.removePreference(highLightJumpPreference2);
                this.f26942g = null;
            }
            HighLightJumpPreference highLightJumpPreference9 = this.f26939d;
            if (highLightJumpPreference9 != null) {
                highLightJumpPreference9.setSummary(getString(com.oplus.blacklistapp.u.f27617e1));
            }
            if (l7.b.p() && (highLightJumpPreference = this.f26938c) != null) {
                highLightJumpPreference.setSummary(com.oplus.blacklistapp.u.f27596a0);
            }
        }
        if (l7.b.f34743k) {
            PreferenceCategory preferenceCategory2 = (PreferenceCategory) findPreference("pref_key_intercept_settings");
            if (preferenceCategory2 != null && (highLightJumpPreference4 = this.f26941f) != null) {
                preferenceCategory2.removePreference(highLightJumpPreference4);
            }
            PreferenceCategory preferenceCategory3 = (PreferenceCategory) findPreference("pref_key_intercept_black_white");
            if (preferenceCategory3 != null && (highLightJumpPreference3 = this.f26939d) != null) {
                preferenceCategory3.removePreference(highLightJumpPreference3);
            }
        }
        this.f26936a = (COUIPreferenceCategory) findPreference("pref_key_sync_settings");
        this.f26937b = (COUIJumpPreference) findPreference("blacklist_cloud_sync");
        G1();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f26947l = C1633g.b(getActivity(), requireActivity().getIntent());
        getListView().setItemAnimator(null);
        return onCreateView;
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f26951p != null) {
            requireContext().getContentResolver().unregisterContentObserver(this.f26951p);
            this.f26951p = null;
        }
        if (this.f26952q != null) {
            requireContext().getContentResolver().unregisterContentObserver(this.f26952q);
            this.f26952q = null;
        }
        ExecutorService executorService = this.f26954x;
        if (executorService != null) {
            executorService.shutdown();
            this.f26954x = null;
        }
        r1();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            s1();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        log("onPause");
        if (this.f26953r != null) {
            requireContext().getContentResolver().unregisterContentObserver(this.f26953r);
        }
        super.onPause();
    }

    @Override // androidx.preference.g, androidx.preference.j.c
    public boolean onPreferenceTreeClick(Preference preference) {
        if (preference == null) {
            log("onPreferenceTreeClick preference is null, return");
            return true;
        }
        log("preference.getKey() = " + preference.getKey());
        if ("intercept_crank_call".equals(preference.getKey())) {
            if (l7.b.f34743k) {
                Intent intent = new Intent();
                intent.setAction("android.telecom.action.MANAGE_BLOCKED_NUMBERS");
                intent.setPackage("com.android.server.telecom");
                C1632f.g0(getActivity(), intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("navigate_parent_package", requireContext().getPackageName());
                intent2.putExtra("navigate_title_id", com.oplus.blacklistapp.u.f27632h1);
                intent2.putExtra(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, 1);
                C0846g.i("HarassInterceptSetting", "NavigateUtils.NAVIGATE_UP_PACKAGE == " + requireContext().getPackageName());
                intent2.setPackage(this.f26948m.getPackageName());
                intent2.setAction("oplus.intent.action.blacklist.view_black_list");
                C1632f.g0(getActivity(), intent2);
                m1(201110025, "intercept_crank_call");
            }
            return true;
        }
        if ("anti_harassment_information".equals(preference.getKey())) {
            Intent intent3 = new Intent();
            intent3.putExtra("navigate_parent_package", requireContext().getPackageName());
            intent3.putExtra("navigate_title_id", com.oplus.blacklistapp.u.f27632h1);
            C0846g.i("HarassInterceptSetting", "NavigateUtils.NAVIGATE_UP_PACKAGE == " + requireContext().getPackageName());
            intent3.setAction(F6.a.f());
            C1632f.g0(getActivity(), intent3);
            m1(201110035, "anti_harassment_information");
            return true;
        }
        if ("intercept_whitelist_key".equals(preference.getKey())) {
            Intent intent4 = new Intent();
            intent4.putExtra("navigate_parent_package", requireContext().getPackageName());
            intent4.putExtra("navigate_title_id", com.oplus.blacklistapp.u.f27632h1);
            intent4.putExtra(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, 2);
            C0846g.i("HarassInterceptSetting", "NavigateUtils.NAVIGATE_UP_PACKAGE == " + requireContext().getPackageName());
            intent4.setPackage(this.f26948m.getPackageName());
            intent4.setAction("oplus.intent.action.blacklist.view_white_list");
            C1632f.g0(getActivity(), intent4);
            return true;
        }
        return super.onPreferenceTreeClick(preference);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        log("onResume");
        super.onResume();
        if (!l7.b.f34743k) {
            F1();
            this.f26953r = new c(this.f26955y);
            requireContext().getContentResolver().registerContentObserver(Uri.withAppendedPath(com.oplus.blacklist.database.a.f26233b, OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE), true, this.f26953r);
        }
        if (!this.f26940e) {
            this.f26940e = true;
        }
        o1();
        u.c(getActivity(), 0, C1632f.f37431F, true, 0);
        H1();
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f26950o) {
            this.f26950o = false;
        } else {
            G1();
        }
    }

    public final Dialog p1() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        String p10 = C1632f.p(context);
        if (TextUtils.isEmpty(p10)) {
            p10 = C1629c.f37417c;
        }
        String k10 = C1632f.k(context.getPackageManager(), p10);
        androidx.appcompat.app.b create = new COUIAlertDialogBuilder(context).create();
        create.setTitle(context.getString(com.oplus.blacklistapp.u.f27500C0));
        create.h(context.getString(com.oplus.blacklistapp.u.f27504D0, k10));
        create.d(-2, context.getString(com.oplus.blacklistapp.u.f27716y0), this);
        create.d(-1, context.getString(com.oplus.blacklistapp.u.f27496B0), this);
        create.setOnKeyListener(new g());
        Window window = create.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        C0565a.a(window, attributes);
        window.setAttributes(attributes);
        return create;
    }

    public final void q1(PreferenceScreen preferenceScreen) {
        boolean c10 = D.c(this.f26948m);
        boolean d10 = D.d(this.f26948m);
        if (!c10 && !d10) {
            preferenceScreen.removePreferenceRecursively("intercept_settings_nation_anti_fraud_category_key");
            return;
        }
        Uri g10 = z6.b.g(0, "national_anti_fraud_service_enabled", 1);
        if (g10 != null) {
            this.f26951p = new b(this.f26955y, g10);
            requireContext().getContentResolver().registerContentObserver(g10, true, this.f26951p);
        }
        this.f26943h.setChecked(D.a(this.f26948m));
        this.f26943h.setOnPreferenceChangeListener(this);
        if (c10 && d10) {
            this.f26943h.setSummary(com.oplus.blacklistapp.u.f27677q1);
        } else if (d10) {
            this.f26943h.setSummary(com.oplus.blacklistapp.u.f27687s1);
        } else {
            this.f26943h.setSummary(com.oplus.blacklistapp.u.f27682r1);
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.v, com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void u(int i10) {
        log("handleHotPlugOut...");
        y1();
    }

    public final /* synthetic */ void v1(boolean z10) {
        if (isAdded()) {
            if (z10) {
                this.f26937b.setAssignment(getString(com.oplus.blacklistapp.u.f27591Z));
            } else {
                this.f26937b.setAssignment(getString(com.oplus.blacklistapp.u.f27587Y));
            }
        }
    }

    public final /* synthetic */ void w1() {
        final boolean z10;
        boolean b10 = C6.a.b(getPreferenceManager().l());
        log("syncEnable = " + b10);
        String b11 = com.oplus.blacklistapp.framework.api.sync.a.b();
        if (b10 && b11 != null && !com.oplus.blacklistapp.framework.api.sync.a.f(b11) && com.oplus.blacklistapp.framework.api.sync.a.g()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f26955y.post(new Runnable() { // from class: com.oplus.blacklistapp.callintercept.settings.s
            @Override // java.lang.Runnable
            public final void run() {
                t.this.v1(z10);
            }
        });
    }

    public void x1() {
        boolean z10;
        List<SubscriptionInfo> i10 = C1632f.i(this.f26948m);
        if (i10 != null && i10.size() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        A1(z10);
    }

    public final void y1() {
        log("sendRefreshHarassPreferenceMsg");
        if (this.f26955y.hasMessages(1001)) {
            this.f26955y.removeMessages(1001);
        }
        this.f26955y.sendEmptyMessageDelayed(1001, 1000L);
    }

    public void z1() {
        HighLightJumpPreference highLightJumpPreference = this.f26941f;
        if (highLightJumpPreference != null) {
            Intent intent = highLightJumpPreference.getIntent();
            intent.setClass(getContext(), CallHarassInterceptSetting.class);
            intent.setPackage(this.f26948m.getPackageName());
            this.f26941f.setIntent(intent);
        }
    }
}
