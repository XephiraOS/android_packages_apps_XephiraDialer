package com.customize.contacts.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.C0490m;
import androidx.lifecycle.Lifecycle;
import androidx.preference.Preference;
import com.android.contacts.activities.OpenSourceLicenseActivity;
import com.android.contacts.framework.baseui.util.C0637b;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;

/* compiled from: AboutFragment.kt */
/* loaded from: classes3.dex */
public final class AboutFragment extends V0.a implements Preference.d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f21120d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Context f21121a;

    /* renamed from: b, reason: collision with root package name */
    public COUIJumpPreference f21122b;

    /* renamed from: c, reason: collision with root package name */
    public COUIJumpPreference f21123c;

    /* compiled from: AboutFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void f1(AboutFragment this$0, COUIPreferenceCategory cOUIPreferenceCategory) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (FeatureOption.i() && !C0637b.h()) {
            com.android.contacts.framework.api.cloudsync.a.c();
            COUIJumpPreference cOUIJumpPreference = this$0.f21123c;
            if (cOUIJumpPreference != null) {
                cOUIJumpPreference.setOnPreferenceClickListener(this$0);
                return;
            }
            return;
        }
        COUIJumpPreference cOUIJumpPreference2 = this$0.f21123c;
        if (cOUIJumpPreference2 != null && cOUIPreferenceCategory != null) {
            cOUIPreferenceCategory.removePreference(cOUIJumpPreference2);
        }
    }

    public static final void g1(AboutFragment this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
            com.android.contacts.framework.baseui.util.A.b(activity, "about_back");
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        int i10;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            i10 = R.string.about_odialer;
        } else {
            i10 = R.string.about_contacts;
        }
        String string = getString(i10);
        kotlin.jvm.internal.i.e(string, "getString(\n            i…s\n            }\n        )");
        return string;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        super.onAttach(context);
        this.f21121a = context;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        int i10;
        final COUIPreferenceCategory cOUIPreferenceCategory;
        super.onCreatePreferences(bundle, str);
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            i10 = R.xml.odialer_about_fragment;
        } else {
            i10 = R.xml.about_fragment;
        }
        addPreferencesFromResource(i10);
        COUIJumpPreference cOUIJumpPreference = (COUIJumpPreference) findPreference("open_source_license");
        this.f21122b = cOUIJumpPreference;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.setOnPreferenceClickListener(this);
        }
        Preference findPreference = findPreference("pref_about_contacts");
        if (findPreference instanceof COUIPreferenceCategory) {
            cOUIPreferenceCategory = (COUIPreferenceCategory) findPreference;
        } else {
            cOUIPreferenceCategory = null;
        }
        this.f21123c = (COUIJumpPreference) findPreference("func_management");
        Lifecycle lifecycle = getLifecycle();
        kotlin.jvm.internal.i.e(lifecycle, "lifecycle");
        com.android.contacts.framework.api.cloudsync.a.a("AboutFragment onCreatePreferences", C0490m.a(lifecycle), new Runnable() { // from class: com.customize.contacts.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.f1(AboutFragment.this, cOUIPreferenceCategory);
            }
        });
    }

    @Override // V0.a, com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        COUIToolbar toolbar = getToolbar();
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AboutFragment.g1(AboutFragment.this, view2);
                }
            });
        }
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        Context context;
        Context context2;
        kotlin.jvm.internal.i.f(preference, "preference");
        if (C7.a.a()) {
            return true;
        }
        Context context3 = null;
        if (preference == this.f21122b) {
            Intent intent = new Intent(getActivity(), (Class<?>) OpenSourceLicenseActivity.class);
            Context context4 = this.f21121a;
            if (context4 == null) {
                kotlin.jvm.internal.i.q("mContext");
                context2 = null;
            } else {
                context2 = context4;
            }
            R7.b.f(context2, intent, 0, null, 6, null);
            Context context5 = this.f21121a;
            if (context5 == null) {
                kotlin.jvm.internal.i.q("mContext");
            } else {
                context3 = context5;
            }
            com.android.contacts.framework.baseui.util.A.b(context3, "open_source_licenses_entry");
        } else if (preference == this.f21123c) {
            Intent intent2 = new Intent();
            intent2.setAction("oplus.intent.action.CONTACTS_CLOUD_SYNC_ENABLE_SETTINGS");
            Context context6 = this.f21121a;
            if (context6 == null) {
                kotlin.jvm.internal.i.q("mContext");
                context6 = null;
            }
            intent2.setPackage(context6.getPackageName());
            Context context7 = this.f21121a;
            if (context7 == null) {
                kotlin.jvm.internal.i.q("mContext");
                context = null;
            } else {
                context = context7;
            }
            R7.b.f(context, intent2, 0, null, 6, null);
        }
        return true;
    }
}
