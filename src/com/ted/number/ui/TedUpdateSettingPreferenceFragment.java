package com.ted.number.ui;

import C7.e;
import R7.c;
import U0.k;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.K;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.contacts.framework.baseui.highlight.HighlightSwitchPreference;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.contacts.framework.baseui.util.s;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.feature.OSPublicFeature;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.ted.number.ui.TedUpdateSettingPreferenceFragment;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class TedUpdateSettingPreferenceFragment extends V0.a implements Preference.c {

    /* renamed from: a, reason: collision with root package name */
    public HighlightSwitchPreference f29794a;

    /* renamed from: b, reason: collision with root package name */
    public COUISwitchPreference f29795b;

    /* renamed from: c, reason: collision with root package name */
    public COUISwitchPreference f29796c;

    /* renamed from: d, reason: collision with root package name */
    public COUIPreferenceCategory f29797d;

    /* renamed from: e, reason: collision with root package name */
    public COUISwitchPreference f29798e;

    /* renamed from: f, reason: collision with root package name */
    public COUIPreferenceCategory f29799f;

    /* renamed from: h, reason: collision with root package name */
    public androidx.appcompat.app.b f29801h;

    /* renamed from: i, reason: collision with root package name */
    public androidx.appcompat.app.b f29802i;

    /* renamed from: g, reason: collision with root package name */
    public Activity f29800g = null;

    /* renamed from: j, reason: collision with root package name */
    public a f29803j = null;

    /* renamed from: k, reason: collision with root package name */
    public N7.a f29804k = N7.a.a();

    /* loaded from: classes4.dex */
    public static class a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<TedUpdateSettingPreferenceFragment> f29805a;

        public a(TedUpdateSettingPreferenceFragment tedUpdateSettingPreferenceFragment) {
            this.f29805a = new WeakReference<>(tedUpdateSettingPreferenceFragment);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            Context b10 = b();
            if (b10 != null) {
                return Boolean.valueOf(NumberIdentifyUtils.e(b10));
            }
            return null;
        }

        public final Context b() {
            FragmentActivity activity;
            TedUpdateSettingPreferenceFragment tedUpdateSettingPreferenceFragment = this.f29805a.get();
            if (tedUpdateSettingPreferenceFragment != null && (activity = tedUpdateSettingPreferenceFragment.getActivity()) != null) {
                return activity.getApplicationContext();
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            TedUpdateSettingPreferenceFragment tedUpdateSettingPreferenceFragment = this.f29805a.get();
            if (tedUpdateSettingPreferenceFragment != null) {
                if (bool != null && tedUpdateSettingPreferenceFragment.isAdded()) {
                    tedUpdateSettingPreferenceFragment.w1(bool.booleanValue());
                }
                tedUpdateSettingPreferenceFragment.o1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<TedUpdateSettingPreferenceFragment> f29806a;

        public b(TedUpdateSettingPreferenceFragment tedUpdateSettingPreferenceFragment) {
            this.f29806a = new WeakReference<>(tedUpdateSettingPreferenceFragment);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            Context b10 = b();
            if (b10 != null) {
                boolean e10 = NumberIdentifyUtils.e(b10);
                if (e10 && s.h(b10)) {
                    s.i(b10);
                }
                return Boolean.valueOf(e10);
            }
            return null;
        }

        public final Context b() {
            FragmentActivity activity;
            TedUpdateSettingPreferenceFragment tedUpdateSettingPreferenceFragment = this.f29806a.get();
            if (tedUpdateSettingPreferenceFragment != null && (activity = tedUpdateSettingPreferenceFragment.getActivity()) != null) {
                return activity.getApplicationContext();
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            TedUpdateSettingPreferenceFragment tedUpdateSettingPreferenceFragment = this.f29806a.get();
            if (bool != null && tedUpdateSettingPreferenceFragment != null && tedUpdateSettingPreferenceFragment.isAdded()) {
                tedUpdateSettingPreferenceFragment.f29794a.setChecked(bool.booleanValue());
                tedUpdateSettingPreferenceFragment.x1(bool.booleanValue());
            }
        }
    }

    private void q1(PreferenceScreen preferenceScreen) {
        OSPublicFeature.H();
        this.f29794a = (HighlightSwitchPreference) findPreference("pref_key_enable_ted_net");
        this.f29797d = (COUIPreferenceCategory) findPreference("pref_key_category_number_recognition_sub_switches");
        this.f29798e = (COUISwitchPreference) findPreference("pref_key_number_recognition_experience_improvement");
        this.f29795b = (COUISwitchPreference) findPreference("pref_key_use_data_network_update");
        this.f29796c = (COUISwitchPreference) findPreference("pref_key_suspicious_number_confirmed");
        this.f29799f = (COUIPreferenceCategory) findPreference("pref_key_information_list");
        HighlightSwitchPreference highlightSwitchPreference = this.f29794a;
        if (highlightSwitchPreference != null) {
            highlightSwitchPreference.setOnPreferenceChangeListener(this);
            if (e.c(getActivity().getIntent(), "highlight_update_stranger_switch", false)) {
                this.f29794a.c(true);
            }
        }
        if (FeatureOption.o()) {
            if (!B3.a.V() || VirtualSupportUtils.m()) {
                c.a(this.f29797d, this.f29796c);
            }
            COUIPreferenceCategory cOUIPreferenceCategory = this.f29799f;
            if (cOUIPreferenceCategory != null) {
                preferenceScreen.removePreference(cOUIPreferenceCategory);
            }
        } else if (!B3.a.y() || VirtualSupportUtils.m()) {
            c.a(this.f29797d, this.f29796c);
        }
        COUISwitchPreference cOUISwitchPreference = this.f29796c;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setOnPreferenceChangeListener(this);
        }
        if (FeatureOption.o() && B3.a.V()) {
            COUISwitchPreference cOUISwitchPreference2 = this.f29795b;
            if (cOUISwitchPreference2 != null) {
                cOUISwitchPreference2.setOnPreferenceChangeListener(this);
            }
        } else {
            c.a(this.f29797d, this.f29795b);
        }
        if (FeatureUtil.P()) {
            COUISwitchPreference cOUISwitchPreference3 = this.f29798e;
            if (cOUISwitchPreference3 != null) {
                cOUISwitchPreference3.setOnPreferenceChangeListener(this);
                return;
            }
            return;
        }
        c.a(this.f29797d, this.f29798e);
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        return getString(R.string.pref_title_service_number_recognition);
    }

    @Override // androidx.preference.Preference.c
    public boolean k0(Preference preference, Object obj) {
        String key = preference.getKey();
        if (H7.a.b()) {
            H7.b.b("TedUpdateSettingPreferenceFragment", "onPreferenceChange key:" + key);
        }
        if ("pref_key_enable_ted_net".equals(key)) {
            if (this.f29803j == null) {
                a aVar = new a(this);
                this.f29803j = aVar;
                aVar.executeOnExecutor(this.f29804k, new Void[0]);
            }
            return false;
        }
        if ("pref_key_use_data_network_update".equals(key)) {
            boolean g10 = s.g(this.f29800g);
            s.c(this.f29800g, !g10);
            HashMap hashMap = new HashMap();
            hashMap.put("use_data_network_switch", Integer.valueOf(!g10 ? 1 : 0));
            m1(hashMap);
        } else if ("pref_key_suspicious_number_confirmed".equals(key)) {
            boolean f10 = s.f(this.f29800g);
            s.b(this.f29800g, !f10);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("suspicious_number_confirmed_switch", Integer.valueOf(!f10 ? 1 : 0));
            m1(hashMap2);
        } else if ("pref_key_number_recognition_experience_improvement".equals(key)) {
            s.a(this.f29800g, !s.e(this.f29800g));
        }
        return true;
    }

    public final void m1(HashMap hashMap) {
        A.a(this.f29800g, 2000318, 200034401, hashMap, false);
    }

    public final void n1(boolean z10) {
        Context applicationContext = getActivity().getApplicationContext();
        NumberIdentifyUtils.r(applicationContext, z10);
        if (z10) {
            c.b(this.f29798e, true);
            s.a(applicationContext, true);
            NumberIdentifyUtils.k(applicationContext, 1);
        }
    }

    public final void o1() {
        this.f29803j = null;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q1(getPreferenceScreen());
        this.f29800g = getActivity();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        addPreferencesFromResource(R.xml.ted_update_setting_preference);
    }

    @Override // V0.a, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        K.y0(getListView(), true);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        try {
            this.f29804k.shutdown();
            Activity activity = this.f29800g;
            if (activity != null) {
                ((TedUpdateSettingActivity) activity).p1(activity, this.f29801h);
            }
        } catch (Exception e10) {
            H7.b.b(null, "showDialog e:" + e10);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        new b(this).executeOnExecutor(this.f29804k, new Void[0]);
        COUISwitchPreference cOUISwitchPreference = this.f29795b;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(s.g(this.f29800g));
        }
        COUISwitchPreference cOUISwitchPreference2 = this.f29796c;
        if (cOUISwitchPreference2 != null) {
            cOUISwitchPreference2.setChecked(s.f(this.f29800g));
        }
        c.b(this.f29798e, s.e(this.f29800g));
    }

    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public final void t1() {
        androidx.appcompat.app.b bVar = this.f29802i;
        if (bVar != null) {
            bVar.dismiss();
            this.f29802i = null;
        }
    }

    public final /* synthetic */ void r1(DialogInterface dialogInterface, int i10) {
        NumberIdentifyUtils.k(this.f29800g, 0);
        this.f29794a.setChecked(false);
        x1(false);
    }

    public final /* synthetic */ void s1(DialogInterface dialogInterface, int i10) {
        try {
            Activity activity = this.f29800g;
            if (activity != null) {
                ((TedUpdateSettingActivity) activity).q1(activity, this.f29801h);
            }
        } catch (Exception e10) {
            H7.b.c("TedUpdateSettingPreferenceFragment", "showDialog e:" + e10);
        }
    }

    public final /* synthetic */ void u1(DialogInterface dialogInterface, int i10) {
        this.f29794a.setChecked(true);
        x1(true);
        n1(true);
        t1();
        A.c("agree");
    }

    public final /* synthetic */ void v1(DialogInterface dialogInterface, int i10) {
        n1(false);
        t1();
        A.c("disagree");
    }

    public final void w1(boolean z10) {
        if (H7.a.b()) {
            H7.b.b("TedUpdateSettingPreferenceFragment", "onPreferenceChange: before change the check is = " + z10);
        }
        if (z10 && NumberIdentifyUtils.f15874a.d() && s.d(this.f29800g) > 0) {
            y1();
            return;
        }
        if (FeatureOption.i()) {
            if (!z10) {
                if (StatementUtils.t(getActivity().getApplicationContext())) {
                    z1();
                    return;
                }
            } else {
                NumberIdentifyUtils.r(getActivity().getApplicationContext(), true);
            }
        }
        this.f29794a.setChecked(!z10);
        x1(!z10);
        s.j(this.f29800g, !z10);
        HashMap hashMap = new HashMap();
        hashMap.put("ted_update_switch", Integer.valueOf(!z10 ? 1 : 0));
        m1(hashMap);
    }

    public final void x1(boolean z10) {
        c.c(this.f29795b, z10);
        c.c(this.f29798e, z10);
    }

    public final void y1() {
        try {
            Activity activity = this.f29800g;
            if (activity != null) {
                androidx.appcompat.app.b e10 = k.e(activity, new DialogInterface.OnClickListener() { // from class: g9.t
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        TedUpdateSettingPreferenceFragment.this.r1(dialogInterface, i10);
                    }
                }, new DialogInterface.OnClickListener() { // from class: g9.u
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        TedUpdateSettingPreferenceFragment.this.s1(dialogInterface, i10);
                    }
                });
                this.f29801h = e10;
                Activity activity2 = this.f29800g;
                ((TedUpdateSettingActivity) activity2).u1(activity2, e10);
            }
        } catch (Exception e11) {
            H7.b.b(null, "showDialog e:" + e11);
        }
    }

    public final void z1() {
        t1();
        androidx.appcompat.app.b f10 = k.f(getActivity(), false, new Runnable() { // from class: g9.v
            @Override // java.lang.Runnable
            public final void run() {
                TedUpdateSettingPreferenceFragment.this.t1();
            }
        }, new DialogInterface.OnClickListener() { // from class: g9.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                TedUpdateSettingPreferenceFragment.this.u1(dialogInterface, i10);
            }
        }, new DialogInterface.OnClickListener() { // from class: g9.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                TedUpdateSettingPreferenceFragment.this.v1(dialogInterface, i10);
            }
        });
        this.f29802i = f10;
        f10.show();
    }
}
