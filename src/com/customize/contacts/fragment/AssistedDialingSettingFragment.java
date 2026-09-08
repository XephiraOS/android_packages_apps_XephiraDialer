package com.customize.contacts.fragment;

import R0.c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.android.contacts.ContactsApplication;
import com.android.contacts.dialpad.SimInfoManager;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.CountryOrAreaPickerActivity;
import com.customize.contacts.util.C0794e;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import r0.C1501d;

/* loaded from: classes3.dex */
public class AssistedDialingSettingFragment extends V0.a implements Preference.d {

    /* renamed from: b, reason: collision with root package name */
    public TelephonyManager f21125b;

    /* renamed from: c, reason: collision with root package name */
    public Context f21126c;

    /* renamed from: d, reason: collision with root package name */
    public COUIPreferenceCategory f21127d;

    /* renamed from: e, reason: collision with root package name */
    public COUISwitchPreference f21128e;

    /* renamed from: f, reason: collision with root package name */
    public COUIJumpPreference f21129f;

    /* renamed from: g, reason: collision with root package name */
    public COUIJumpPreference f21130g;

    /* renamed from: h, reason: collision with root package name */
    public COUIJumpPreference f21131h;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f21132i;

    /* renamed from: j, reason: collision with root package name */
    public List<String> f21133j;

    /* renamed from: m, reason: collision with root package name */
    public Cursor f21136m;

    /* renamed from: a, reason: collision with root package name */
    public SimInfoManager f21124a = new SimInfoManager();

    /* renamed from: k, reason: collision with root package name */
    public boolean f21134k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f21135l = false;

    /* renamed from: n, reason: collision with root package name */
    public BroadcastReceiver f21137n = new b();

    /* loaded from: classes3.dex */
    public class a implements Preference.c {
        public a() {
        }

        @Override // androidx.preference.Preference.c
        public boolean k0(Preference preference, Object obj) {
            String str;
            boolean isChecked = AssistedDialingSettingFragment.this.f21128e.isChecked();
            FragmentActivity activity = AssistedDialingSettingFragment.this.getActivity();
            String str2 = c.a.f3199e;
            if (isChecked) {
                str = "false";
            } else {
                str = "true";
            }
            G0.c.t(activity, 0, str2, str);
            C0794e.l(!isChecked);
            AssistedDialingSettingFragment.this.q1(isChecked, false);
            AssistedDialingSettingFragment.this.f21128e.setChecked(!isChecked);
            HashMap hashMap = new HashMap();
            hashMap.put("assisted_dialing_switch", String.valueOf(!isChecked));
            hashMap.put(OplusAutoRedialNotificationUI.TIME, String.valueOf(System.currentTimeMillis()));
            com.android.contacts.framework.baseui.util.A.a(AssistedDialingSettingFragment.this.getContext(), 2000303, 200030320, hashMap, false);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            AssistedDialingSettingFragment.log("onReceive: action = " + action);
            if ("android.intent.action.SIM_STATE_CHANGED".equals(action) && AssistedDialingSettingFragment.this.getActivity() != null) {
                String l10 = C7.e.l(intent, "ss");
                AssistedDialingSettingFragment.log("onReceive: simStatus = " + l10 + " mIsFirstSimStateChangeBroadcast = " + AssistedDialingSettingFragment.this.f21134k);
                if (AssistedDialingSettingFragment.this.f21134k) {
                    AssistedDialingSettingFragment.this.f21134k = false;
                    return;
                }
                if (l10.equals("ABSENT") || l10.equals("LOADED")) {
                    AssistedDialingSettingFragment.this.o1();
                    AssistedDialingSettingFragment.this.r1(false);
                    AssistedDialingSettingFragment assistedDialingSettingFragment = AssistedDialingSettingFragment.this;
                    new c(assistedDialingSettingFragment).execute(new Void[0]);
                    return;
                }
                return;
            }
            if ("android.intent.action.SIM_SETTING_INFO_CHANGED".equals(action)) {
                AssistedDialingSettingFragment.this.o1();
                AssistedDialingSettingFragment.this.f21129f.setTitle(b0.B());
                AssistedDialingSettingFragment.this.f21130g.setTitle(b0.E());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends com.android.contacts.util.D<Void, Void, String[], AssistedDialingSettingFragment> {
        public c(AssistedDialingSettingFragment assistedDialingSettingFragment) {
            super(assistedDialingSettingFragment);
        }

        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String[] a(AssistedDialingSettingFragment assistedDialingSettingFragment, Void... voidArr) {
            if (assistedDialingSettingFragment == null || !assistedDialingSettingFragment.isAdded() || assistedDialingSettingFragment.getContext() == null) {
                return null;
            }
            try {
                Cursor query = assistedDialingSettingFragment.getContext().getContentResolver().query(R0.d.f3231r, null, null, null, null);
                try {
                    AssistedDialingSettingFragment.this.f21136m = query;
                    String[] strArr = {AssistedDialingSettingFragment.this.s1(query, D7.a.p()), AssistedDialingSettingFragment.this.s1(query, D7.a.q())};
                    if (query != null) {
                        query.close();
                    }
                    return strArr;
                } finally {
                }
            } catch (Exception e10) {
                H7.b.c("AssistedDialingFragment", "e: " + e10);
                return new String[]{AssistedDialingSettingFragment.this.s1(null, D7.a.p()), AssistedDialingSettingFragment.this.s1(null, D7.a.q())};
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(AssistedDialingSettingFragment assistedDialingSettingFragment, String[] strArr) {
            if (assistedDialingSettingFragment != null && assistedDialingSettingFragment.isAdded() && assistedDialingSettingFragment.getContext() != null) {
                if (strArr != null) {
                    AssistedDialingSettingFragment.this.f21129f.setAssignment(strArr[0]);
                    AssistedDialingSettingFragment.this.f21130g.setAssignment(strArr[1]);
                } else {
                    AssistedDialingSettingFragment.this.f21129f.setAssignment(null);
                    AssistedDialingSettingFragment.this.f21130g.setAssignment(null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
        if (H7.a.b()) {
            H7.b.b("AssistedDialingFragment", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        this.f21124a.h(getActivity(), null);
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        return getString(R.string.assisted_dialing_title);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (intent != null) {
            String l10 = C7.e.l(intent, "countryIso");
            if (i10 == 0) {
                this.f21129f.setAssignment(l10);
            } else if (i10 == 1) {
                this.f21130g.setAssignment(l10);
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            HashMap hashMap = new HashMap();
            hashMap.put("sim_one_country_iso", defaultSharedPreferences.getString("sim_one_country_iso", ""));
            hashMap.put("sim_two_country_iso", defaultSharedPreferences.getString("sim_two_country_iso", ""));
            com.android.contacts.framework.baseui.util.A.a(getContext(), 2000303, 200030321, hashMap, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f21126c = context;
        boolean z10 = true;
        if (((TelephonyManager) context.getSystemService(TelephonyManager.class)).getPhoneCount() != 1) {
            z10 = false;
        }
        this.f21135l = z10;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        addPreferencesFromResource(R.xml.assisted_dialing_setting_fragment);
        this.f21125b = (TelephonyManager) getActivity().getSystemService(TelephonyManager.class);
        o1();
        this.f21132i = Arrays.asList(getResources().getStringArray(R.array.assisted_dialing_cc_values));
        this.f21133j = Arrays.asList(getResources().getStringArray(R.array.assisted_dialing_cc_entries));
        C0794e.j(getActivity(), PreferenceManager.getDefaultSharedPreferences(getActivity()));
        p1();
        if (getActivity() != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                C0811w.j(getActivity(), this.f21137n, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
                intentFilter.addAction("android.intent.action.SIM_SETTING_INFO_CHANGED");
                getActivity().registerReceiver(this.f21137n, intentFilter, R0.b.f3175i, null, 2);
            } catch (Exception e10) {
                H7.b.c("AssistedDialingFragment", "e = " + e10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            if (getActivity() != null) {
                getActivity().unregisterReceiver(this.f21137n);
            }
        } catch (Exception e10) {
            H7.b.c("AssistedDialingFragment", "e = " + e10);
        }
    }

    public void p1() {
        this.f21127d = (COUIPreferenceCategory) findPreference("show_default_country_iso");
        COUIJumpPreference cOUIJumpPreference = (COUIJumpPreference) findPreference("sim_one_country_iso_setting");
        this.f21129f = cOUIJumpPreference;
        cOUIJumpPreference.setOnPreferenceClickListener(this);
        COUIJumpPreference cOUIJumpPreference2 = (COUIJumpPreference) findPreference("sim_two_country_iso_setting");
        this.f21130g = cOUIJumpPreference2;
        cOUIJumpPreference2.setOnPreferenceClickListener(this);
        this.f21131h = (COUIJumpPreference) findPreference("show_without_sim_card");
        boolean h10 = C0794e.h();
        COUISwitchPreference cOUISwitchPreference = (COUISwitchPreference) findPreference("assisted_dialing_switch");
        this.f21128e = cOUISwitchPreference;
        cOUISwitchPreference.setChecked(h10);
        this.f21128e.setOnPreferenceChangeListener(new a());
        q1(!h10, true);
        new c(this).execute(new Void[0]);
    }

    public final void q1(boolean z10, boolean z11) {
        if (z10) {
            getPreferenceScreen().removePreference(this.f21127d);
        } else {
            r1(z11);
            getPreferenceScreen().addPreference(this.f21127d);
        }
    }

    public final void r1(boolean z10) {
        if (this.f21124a.c() == 0) {
            this.f21127d.removePreference(this.f21129f);
            this.f21127d.removePreference(this.f21130g);
            this.f21127d.addPreference(this.f21131h);
        } else if (this.f21124a.c() == 1) {
            this.f21127d.removePreference(this.f21131h);
            if (!this.f21124a.f()) {
                this.f21127d.removePreference(this.f21130g);
                this.f21127d.addPreference(this.f21129f);
                this.f21129f.setTitle(b0.B());
            } else {
                this.f21127d.removePreference(this.f21129f);
                this.f21127d.addPreference(this.f21130g);
                this.f21130g.setTitle(b0.E());
            }
        } else {
            this.f21127d.removePreference(this.f21131h);
            this.f21127d.addPreference(this.f21129f);
            this.f21127d.addPreference(this.f21130g);
            this.f21129f.setTitle(b0.B());
            this.f21130g.setTitle(b0.E());
        }
        if (z10) {
            this.f21129f.setAssignment(" ");
            this.f21130g.setAssignment(" ");
        }
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        FragmentActivity activity = getActivity();
        if (activity != null && (preference == this.f21129f || preference == this.f21130g)) {
            String str = C1501d.f36275d;
            if (com.android.contacts.framework.baseui.util.l.d(activity, str)) {
                com.android.contacts.framework.baseui.util.l.f(activity, str, null, 0);
                return true;
            }
        }
        if (preference == this.f21129f) {
            Intent intent = new Intent(this.f21126c, (Class<?>) CountryOrAreaPickerActivity.class);
            intent.putExtra("slot_id", D7.a.p());
            startActivityForResult(intent, 0);
        } else if (preference == this.f21130g) {
            Intent intent2 = new Intent(this.f21126c, (Class<?>) CountryOrAreaPickerActivity.class);
            intent2.putExtra("slot_id", D7.a.q());
            startActivityForResult(intent2, 1);
        }
        return true;
    }

    public final String s1(Cursor cursor, int i10) {
        String language;
        String str;
        StringBuilder sb;
        Context context = getContext();
        String str2 = null;
        if (isAdded() && context != null) {
            String f10 = C7.c.b(context).f();
            Locale locale = Locale.US;
            String upperCase = f10.toUpperCase(locale);
            if (!b0.m0(context, i10)) {
                return null;
            }
            int r10 = D7.c.r(context, Integer.valueOf(i10));
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            String upperCase2 = C7.c.b(context).f().toUpperCase(locale);
            log("updateSimCountryIsoAssignment: countryIso = " + upperCase2 + " slotid = " + i10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("assisted_dialing_");
            sb2.append(r10);
            String string = defaultSharedPreferences.getString(sb2.toString(), upperCase2);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToPosition(-1);
                String str3 = null;
                while (true) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    String string2 = cursor.getString(cursor.getColumnIndex("country_iso"));
                    String string3 = cursor.getString(cursor.getColumnIndex("country_name"));
                    String string4 = cursor.getString(cursor.getColumnIndex("country_code"));
                    if (ContactsApplication.f13094j) {
                        sb = new StringBuilder();
                        sb.append(string4);
                        sb.append("+");
                    } else {
                        sb = new StringBuilder();
                        sb.append("+");
                        sb.append(string4);
                    }
                    String sb3 = sb.toString();
                    if (!FeatureOption.i()) {
                        string3 = string2;
                    }
                    if (TextUtils.equals(string, string2)) {
                        str2 = string3 + " (" + sb3 + ") ";
                        break;
                    }
                    if (TextUtils.equals(upperCase, string2)) {
                        str3 = string3 + " (" + sb3 + ") ";
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    log("result is empty");
                    defaultSharedPreferences.edit().putString("assisted_dialing_" + r10, upperCase).apply();
                    return str3;
                }
                return str2;
            }
            H7.b.b("AssistedDialingFragment", "query from local data");
            if (context.getResources().getConfiguration().getLocales().get(0).getLanguage().equals("bo")) {
                language = "zh";
            } else {
                language = context.getResources().getConfiguration().getLocales().get(0).getLanguage();
            }
            ULocale build = new ULocale.Builder().setRegion(context.getResources().getConfiguration().getLocales().get(0).getCountry()).setLanguage(language).build();
            if (FeatureOption.i()) {
                str = C0794e.d(this.f21126c, new ULocale.Builder().setRegion(string).build().getDisplayCountry(build), string);
            } else {
                str = string;
            }
            List<String> list = this.f21132i;
            if (list == null || list.indexOf(string) < 0) {
                return null;
            }
            String str4 = this.f21133j.get(this.f21132i.indexOf(string));
            try {
                if (ContactsApplication.f13094j) {
                    str4 = U7.a.d(str4);
                }
            } catch (NumberFormatException e10) {
                H7.b.c("AssistedDialingFragment", "Adapted to Arabia Error: " + e10);
            }
            return str + " " + str4;
        }
        log("updateSimCountryIsoAssignment: is not added or context is null, return");
        return null;
    }
}
