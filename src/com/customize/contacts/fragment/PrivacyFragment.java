package com.customize.contacts.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.oplus.dialer.R;

/* compiled from: PrivacyFragment.kt */
/* loaded from: classes3.dex */
public final class PrivacyFragment extends V0.a implements Preference.d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f21256b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public COUIJumpPreference f21257a;

    /* compiled from: PrivacyFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        String string = getString(R.string.about_privacy);
        kotlin.jvm.internal.i.e(string, "getString(R.string.about_privacy)");
        return string;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        PreferenceCategory preferenceCategory;
        super.onCreatePreferences(bundle, str);
        addPreferencesFromResource(R.xml.privacy_fragment);
        COUIJumpPreference cOUIJumpPreference = (COUIJumpPreference) findPreference("pref_key_ted_secret_policy");
        this.f21257a = cOUIJumpPreference;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.setOnPreferenceClickListener(this);
        }
        COUIJumpPreference cOUIJumpPreference2 = (COUIJumpPreference) findPreference("personal_information_sharing_third_party_list");
        Preference findPreference = findPreference("pref_about_privacy");
        if (findPreference instanceof PreferenceCategory) {
            preferenceCategory = (PreferenceCategory) findPreference;
        } else {
            preferenceCategory = null;
        }
        if (preferenceCategory != null && cOUIJumpPreference2 != null) {
            preferenceCategory.removePreference(cOUIJumpPreference2);
        }
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        Context context;
        kotlin.jvm.internal.i.f(preference, "preference");
        if (!C7.a.a() && preference == this.f21257a && (context = getContext()) != null) {
            StatementUtils.B(context, 17, false, 0, 8, null);
        }
        return true;
    }
}
