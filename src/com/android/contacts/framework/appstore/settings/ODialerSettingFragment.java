package com.android.contacts.framework.appstore.settings;

import H0.d;
import H0.e;
import L0.c;
import R7.b;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.android.contacts.framework.appstore.appinfo.AppInfoCompatApiImpl;
import com.android.incallui.BuildConfig;
import com.android.incallui.OplusPhoneCapabilities;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: ODialerSettingFragment.kt */
/* loaded from: classes.dex */
public final class ODialerSettingFragment extends V0.a implements Preference.d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15651a = new a(null);

    /* compiled from: ODialerSettingFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final void d1() {
        Context context = getContext();
        if (context != null) {
            Intent intent = new Intent("oplus.intent.action.contacts.ASSISTED_DIALING_SETTINGS");
            intent.setPackage(requireContext().getPackageName());
            b.f(context, intent, 0, null, 6, null);
        }
    }

    public final void e1() {
        Context context = getContext();
        if (context != null) {
            try {
                Intent intent = new Intent("oplus.intent.action.BROWSE_FILE");
                intent.putExtra("package", BuildConfig.LIBRARY_PACKAGE_NAME);
                context.startActivity(intent);
                q qVar = q.f35511a;
            } catch (ActivityNotFoundException unused) {
                Intent intent2 = new Intent("oppo.filemanager.intent.action.BROWSER_FILE");
                intent2.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
                intent2.putExtra("CurrentDir", "/Music/Recordings/Call Recordings");
                b.f(context, intent2, 0, null, 6, null);
            }
        }
    }

    public final void f1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (AppInfoCompatApiImpl.f15636b.d()) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setClassName("com.android.phone", "com.android.phone.OplusCallCarrierSetting");
                b.f(activity, intent, 0, null, 6, null);
                return;
            }
            c.f1709a.b(activity);
        }
    }

    public final void g1() {
        Context context = getContext();
        if (context != null) {
            Intent intent = new Intent("com.android.contacts.dialpad.SpeedDialManageActivity");
            intent.setPackage(requireContext().getPackageName());
            b.f(context, intent, 0, null, 6, null);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        String string = getString(d.f1220h);
        i.e(string, "getString(R.string.oplus_button_set)");
        return string;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        COUIPreferenceCategory cOUIPreferenceCategory;
        addPreferencesFromResource(e.f1224a);
        Preference findPreference = findPreference("all_settings");
        if (findPreference instanceof COUIPreferenceCategory) {
            cOUIPreferenceCategory = (COUIPreferenceCategory) findPreference;
        } else {
            cOUIPreferenceCategory = null;
        }
        Preference findPreference2 = findPreference("oplus_speed_dial");
        if (findPreference2 != null) {
            findPreference2.setOnPreferenceClickListener(this);
        }
        Preference findPreference3 = findPreference("assisted_dialing");
        if (findPreference3 != null) {
            findPreference3.setOnPreferenceClickListener(this);
        }
        Preference findPreference4 = findPreference("more_setting");
        if (findPreference4 != null) {
            findPreference4.setOnPreferenceClickListener(this);
        }
        Preference findPreference5 = findPreference("call_recording");
        if (findPreference5 != null) {
            findPreference5.setOnPreferenceClickListener(this);
            if (cOUIPreferenceCategory != null && !AppInfoCompatApiImpl.f15636b.a()) {
                cOUIPreferenceCategory.removePreference(findPreference5);
            }
        }
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        i.f(preference, "preference");
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1437526704:
                    if (key.equals("call_recording")) {
                        e1();
                        break;
                    }
                    break;
                case 544197478:
                    if (key.equals("more_setting")) {
                        f1();
                        break;
                    }
                    break;
                case 1157967838:
                    if (key.equals("oplus_speed_dial")) {
                        g1();
                        break;
                    }
                    break;
                case 1200459259:
                    if (key.equals("assisted_dialing")) {
                        d1();
                        break;
                    }
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }
}
