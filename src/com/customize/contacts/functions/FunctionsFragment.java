package com.customize.contacts.functions;

import C7.e;
import H7.b;
import M3.c;
import R0.c;
import U0.n;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.C0490m;
import androidx.lifecycle.K;
import androidx.preference.Preference;
import com.android.contacts.activities.AboutActivity;
import com.android.contacts.framework.baseui.highlight.HighlightJumpPreference;
import com.android.contacts.framework.baseui.highlight.HighlightSwitchPreference;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.contacts.framework.baseui.util.q;
import com.android.contacts.framework.baseui.widget.RedDotPreference;
import com.android.contacts.framework.router.helpfeedback.HelpFeedbackUtils;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.model.Account;
import com.android.contacts.util.C0700a;
import com.android.contacts.util.w;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.PreciseClickHelper;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIMenuPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsImportExportActivity;
import com.customize.contacts.activities.SimAccountsListActivity;
import com.customize.contacts.activities.SimContactsListActivity;
import com.customize.contacts.combine.MergeSameInfoContactsActivity;
import com.customize.contacts.functions.FunctionsFragment;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.U;
import com.customize.contacts.util.b0;
import com.oplus.contacts.list.cloudsync.CloudSyncViewModel;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import m1.AbstractC1316l;
import o1.C1393c;

/* loaded from: classes3.dex */
public class FunctionsFragment extends V0.a implements Preference.d, Preference.c {

    /* renamed from: a, reason: collision with root package name */
    public COUIJumpPreference f21338a;

    /* renamed from: b, reason: collision with root package name */
    public Preference f21339b;

    /* renamed from: c, reason: collision with root package name */
    public Context f21340c;

    /* renamed from: d, reason: collision with root package name */
    public RedDotPreference f21341d;

    /* renamed from: e, reason: collision with root package name */
    public Preference f21342e;

    /* renamed from: f, reason: collision with root package name */
    public COUIPreferenceCategory f21343f;

    /* renamed from: g, reason: collision with root package name */
    public HighlightSwitchPreference f21344g;

    /* renamed from: h, reason: collision with root package name */
    public HighlightSwitchPreference f21345h;

    /* renamed from: i, reason: collision with root package name */
    public COUISwitchPreference f21346i;

    /* renamed from: j, reason: collision with root package name */
    public HighlightJumpPreference f21347j;

    /* renamed from: k, reason: collision with root package name */
    public HighlightJumpPreference f21348k;

    /* renamed from: l, reason: collision with root package name */
    public COUIMenuPreference f21349l;

    /* renamed from: m, reason: collision with root package name */
    public COUIMenuPreference f21350m;

    /* renamed from: n, reason: collision with root package name */
    public HighlightJumpPreference f21351n;

    /* renamed from: o, reason: collision with root package name */
    public Preference f21352o;

    /* renamed from: p, reason: collision with root package name */
    public Preference f21353p;

    /* renamed from: q, reason: collision with root package name */
    public C1393c f21354q;

    /* renamed from: r, reason: collision with root package name */
    public String[] f21355r;

    /* renamed from: x, reason: collision with root package name */
    public String[] f21356x;

    /* renamed from: y, reason: collision with root package name */
    public CloudSyncViewModel f21357y;

    /* renamed from: z, reason: collision with root package name */
    public final N7.a f21358z = N7.a.a();

    /* renamed from: A, reason: collision with root package name */
    public final Handler f21336A = new Handler(Looper.getMainLooper());

    /* renamed from: B, reason: collision with root package name */
    public BroadcastReceiver f21337B = new a();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SIM_STATE_CHANGED".equals(intent.getAction()) && FunctionsFragment.this.getActivity() != null) {
                b0.H0();
                if (FunctionsFragment.this.f21348k != null) {
                    FunctionsFragment.this.f21348k.setEnabled(b0.l0(FunctionsFragment.this.getActivity()));
                }
            }
        }
    }

    public static boolean C1(Resources resources) {
        if (resources.getInteger(R.integer.product_flavor) == 1) {
            return false;
        }
        if (!FeatureOption.i() && resources.getBoolean(R.bool.config_sort_order_user_changeable)) {
            return false;
        }
        return true;
    }

    public static boolean D1(Resources resources) {
        if (resources.getInteger(R.integer.product_flavor) == 1) {
            return false;
        }
        if (!FeatureOption.i() && resources.getBoolean(R.bool.config_sort_order_user_changeable)) {
            return false;
        }
        return true;
    }

    public void A1() {
        b.e("FunctionsFragment", "onSimPreferenceClick() ------------ ");
        A.a(getActivity(), 2000315, 200030094, null, false);
        ArrayList<Account> m10 = c.m(this.f21340c);
        int size = m10.size();
        if (size == 1) {
            Intent intent = new Intent(this.f21340c, (Class<?>) SimContactsListActivity.class);
            intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, m10.get(0).f16941a);
            R7.b.c(this.f21340c, intent);
        } else if (size > 1) {
            R7.b.c(this.f21340c, new Intent(this.f21340c, (Class<?>) SimAccountsListActivity.class));
        } else if (b0.O() > 0) {
            com.oplus.foundation.util.ui.c.b(this.f21340c, R.string.oplus_refreshing_sim_data);
        } else {
            com.oplus.foundation.util.ui.c.b(this.f21340c, R.string.simcard_abnormal_please_check_and_try_again);
        }
    }

    public void B1(String str) {
        b.b("FunctionsFragment", "searchHighlight=" + str);
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1465916851:
                if (str.equals("contacts_photo_switch")) {
                    c10 = 0;
                    break;
                }
                break;
            case -557044614:
                if (str.equals("merge_contacts")) {
                    c10 = 1;
                    break;
                }
                break;
            case -97524498:
                if (str.equals("only_show_contacts_with_numbers")) {
                    c10 = 2;
                    break;
                }
                break;
            case 92611469:
                if (str.equals("about")) {
                    c10 = 3;
                    break;
                }
                break;
            case 221387990:
                if (str.equals("contacts_display")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1836209851:
                if (str.equals("sim_contacts")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                HighlightSwitchPreference highlightSwitchPreference = this.f21344g;
                if (highlightSwitchPreference != null) {
                    highlightSwitchPreference.c(true);
                    return;
                }
                return;
            case 1:
                RedDotPreference redDotPreference = this.f21341d;
                if (redDotPreference != null) {
                    redDotPreference.d(true);
                    return;
                }
                return;
            case 2:
                HighlightSwitchPreference highlightSwitchPreference2 = this.f21345h;
                if (highlightSwitchPreference2 != null) {
                    highlightSwitchPreference2.c(true);
                    return;
                }
                return;
            case 3:
                HighlightJumpPreference highlightJumpPreference = this.f21351n;
                if (highlightJumpPreference != null) {
                    highlightJumpPreference.a(true);
                    return;
                }
                return;
            case 4:
                HighlightJumpPreference highlightJumpPreference2 = this.f21347j;
                if (highlightJumpPreference2 != null) {
                    highlightJumpPreference2.a(true);
                    return;
                }
                return;
            case 5:
                HighlightJumpPreference highlightJumpPreference3 = this.f21348k;
                if (highlightJumpPreference3 != null) {
                    highlightJumpPreference3.a(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void E1(View view, int i10, int i11) {
        if (!isAdded()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(q.a(this.f21340c.getString(R.string.merge_name_duplicate)));
        arrayList.add(q.a(this.f21340c.getString(R.string.merge_number_duplicate)));
        final COUIPopupListWindow cOUIPopupListWindow = new COUIPopupListWindow(this.f21340c);
        cOUIPopupListWindow.setItemList(arrayList);
        cOUIPopupListWindow.setDismissTouchOutside(true);
        cOUIPopupListWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: M3.i
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i12, long j10) {
                FunctionsFragment.this.v1(cOUIPopupListWindow, adapterView, view2, i12, j10);
            }
        });
        cOUIPopupListWindow.show(view, i10, i11);
    }

    public final void F1() {
        com.android.contacts.framework.api.cloudsync.a.a("FunctionsFragment updateCloudSyncPreferenceState ", C0490m.a(getLifecycle()), new Runnable() { // from class: M3.d
            @Override // java.lang.Runnable
            public final void run() {
                FunctionsFragment.this.w1();
            }
        });
    }

    public final void G1() {
        getListView().post(new Runnable() { // from class: M3.e
            @Override // java.lang.Runnable
            public final void run() {
                FunctionsFragment.this.x1();
            }
        });
    }

    public final void H1() {
        this.f21358z.execute(new Runnable() { // from class: M3.k
            @Override // java.lang.Runnable
            public final void run() {
                FunctionsFragment.this.y1();
            }
        });
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        return getString(R.string.menu_contact_manage);
    }

    @Override // androidx.preference.Preference.c
    public boolean k0(Preference preference, Object obj) {
        String str;
        String str2 = "ON";
        if ("contacts_photo_switch".equals(preference.getKey())) {
            boolean isChecked = this.f21344g.isChecked();
            HashMap hashMap = new HashMap();
            try {
                Context context = this.f21340c;
                String str3 = c.a.f3197c;
                if (isChecked) {
                    str = "false";
                } else {
                    str = "true";
                }
                G0.c.t(context, 0, str3, str);
                if (isChecked) {
                    str2 = "Off";
                }
                hashMap.put("show_profile_picture_switch", str2);
                A.a(this.f21340c, 2000323, 200035404, hashMap, false);
                U.f(this.f21340c, !isChecked);
                X.a.b(getContext()).d(new Intent("com.android.contacts.photo_switch"));
            } catch (Exception e10) {
                b.c("FunctionsFragment", "Exception e: " + e10);
            }
            return true;
        }
        if ("contacts_kana_sort_switch".equals(preference.getKey())) {
            this.f21354q.n(!this.f21346i.isChecked());
            return true;
        }
        if ("only_show_contacts_with_numbers".equals(preference.getKey())) {
            boolean z10 = !this.f21345h.isChecked();
            AbstractC1316l c10 = C0700a.c();
            if (c10 == null) {
                c10 = AbstractC1316l.f(this.f21340c);
            }
            ContactListFilter n10 = ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(this.f21340c));
            n10.f16744h = z10;
            if (n10.f16738b == -3) {
                c10.h(z10);
            } else {
                c10.i(n10, true);
            }
            HashMap hashMap2 = new HashMap();
            if (!z10) {
                str2 = "Off";
            }
            hashMap2.put("show_number_contact_switch", str2);
            A.a(this.f21340c, 2000323, 200035404, hashMap2, false);
            return true;
        }
        if ("sortOrder".equals(preference.getKey())) {
            this.f21354q.o(Arrays.asList(this.f21356x).indexOf(obj) + 1);
            this.f21349l.setAssignment(String.valueOf(obj));
            return true;
        }
        if ("displayOrder".equals(preference.getKey())) {
            this.f21354q.m(Arrays.asList(this.f21355r).indexOf(obj) + 1);
            this.f21350m.setAssignment(String.valueOf(obj));
        }
        return true;
    }

    public final void o1() {
        this.f21357y = (CloudSyncViewModel) new K(this).a(CloudSyncViewModel.class);
        com.android.contacts.framework.api.cloudsync.a.a("FunctionsFragment initCloudSync", C0490m.a(getLifecycle()), new Runnable() { // from class: M3.j
            @Override // java.lang.Runnable
            public final void run() {
                FunctionsFragment.this.q1();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f21340c = activity;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String l10 = e.l(getActivity().getIntent(), ":settings:fragment_args_key");
        if (l10 != null) {
            B1(l10);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        String str2;
        addPreferencesFromResource(R.xml.contacts_functions);
        p1();
        if (getActivity() != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                C0811w.j(getActivity(), this.f21337B, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
                FragmentActivity activity = getActivity();
                BroadcastReceiver broadcastReceiver = this.f21337B;
                if (OsUtils.f28279e) {
                    str2 = null;
                } else {
                    str2 = R0.b.f3175i;
                }
                activity.registerReceiver(broadcastReceiver, intentFilter, str2, null, 2);
            } catch (Exception e10) {
                b.c("FunctionsFragment", "e = " + e10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        N7.a aVar = this.f21358z;
        if (aVar != null) {
            aVar.shutdown();
        }
        Handler handler = this.f21336A;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        n.h();
        try {
            if (getActivity() != null) {
                getActivity().unregisterReceiver(this.f21337B);
            }
        } catch (Exception e10) {
            b.c("FunctionsFragment", "e = " + e10);
        }
    }

    @Override // androidx.preference.g, androidx.preference.j.c
    public boolean onPreferenceTreeClick(Preference preference) {
        return super.onPreferenceTreeClick(preference);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f21349l.setAssignment(this.f21356x[this.f21354q.h() - 1]);
        this.f21349l.setValue(this.f21356x[this.f21354q.h() - 1]);
        this.f21350m.setValue(this.f21355r[this.f21354q.g() - 1]);
        this.f21350m.setAssignment(this.f21355r[this.f21354q.g() - 1]);
        F1();
        G1();
        this.f21357y.o();
    }

    @Override // V0.a, com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() { // from class: M3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FunctionsFragment.this.u1(view2);
            }
        });
        o1();
    }

    public void p1() {
        int i10;
        this.f21354q = new C1393c(this.f21340c);
        this.f21355r = new String[]{getResources().getString(R.string.display_options_view_given_name_first), getResources().getString(R.string.display_options_view_family_name_first)};
        this.f21356x = new String[]{getResources().getString(R.string.contacts_display_options_sort_by_family_name), getResources().getString(R.string.contacts_display_options_sort_by_given_name)};
        COUIJumpPreference cOUIJumpPreference = (COUIJumpPreference) findPreference("contacts_cloud_sync");
        this.f21338a = cOUIJumpPreference;
        cOUIJumpPreference.setOnPreferenceClickListener(this);
        COUIPreferenceCategory cOUIPreferenceCategory = (COUIPreferenceCategory) findPreference("pref_contact_cloud_sync");
        this.f21343f = cOUIPreferenceCategory;
        if (cOUIPreferenceCategory != null && FeatureOption.o()) {
            this.f21343f.setVisible(false);
        }
        F1();
        COUIPreferenceCategory cOUIPreferenceCategory2 = (COUIPreferenceCategory) findPreference("pref_contact_setting");
        COUIPreferenceCategory cOUIPreferenceCategory3 = (COUIPreferenceCategory) findPreference("pref_contact_manage");
        COUIPreferenceCategory cOUIPreferenceCategory4 = (COUIPreferenceCategory) findPreference("other_setting");
        COUIPreferenceCategory cOUIPreferenceCategory5 = (COUIPreferenceCategory) findPreference("about_privacy");
        this.f21341d = (RedDotPreference) findPreference("merge_contacts");
        if (R0.a.f3166b == null && !com.android.contacts.framework.api.appstore.appinfo.a.o()) {
            cOUIPreferenceCategory3.removePreference(this.f21341d);
        } else {
            this.f21341d.setOnPreciseClickListener(new PreciseClickHelper.OnPreciseClickListener() { // from class: M3.g
                @Override // com.coui.appcompat.poplist.PreciseClickHelper.OnPreciseClickListener
                public final void onClick(View view, int i11, int i12) {
                    FunctionsFragment.this.E1(view, i11, i12);
                }
            });
            if (TextUtils.equals(e.l(getActivity().getIntent(), "notification_string_id"), "duplicate contacts")) {
                this.f21341d.d(true);
            }
        }
        Preference findPreference = findPreference("help_and_feedback");
        this.f21342e = findPreference;
        findPreference.setOnPreferenceClickListener(this);
        if (!CommonOSPublicFeature.i() || (OsUtils.c() && CommonFeatureOption.j())) {
            cOUIPreferenceCategory4.removePreference(this.f21342e);
            if (cOUIPreferenceCategory4.getPreferenceCount() == 0) {
                b.b("FunctionsFragment", "getPreferenceCount() == 0");
                getPreferenceScreen().removePreference(cOUIPreferenceCategory4);
            }
        }
        if (C0637b.h()) {
            cOUIPreferenceCategory3.removePreference(this.f21341d);
        }
        HighlightJumpPreference highlightJumpPreference = (HighlightJumpPreference) findPreference("contacts_display");
        this.f21347j = highlightJumpPreference;
        highlightJumpPreference.setOnPreferenceClickListener(this);
        Preference findPreference2 = findPreference("import_and_export_contacts");
        this.f21339b = findPreference2;
        findPreference2.setOnPreferenceClickListener(this);
        HighlightJumpPreference highlightJumpPreference2 = (HighlightJumpPreference) findPreference("sim_contacts");
        this.f21348k = highlightJumpPreference2;
        highlightJumpPreference2.setOnPreferenceClickListener(this);
        this.f21348k.setEnabled(b0.l0(this.f21340c));
        COUIMenuPreference cOUIMenuPreference = (COUIMenuPreference) findPreference("displayOrder");
        this.f21350m = cOUIMenuPreference;
        cOUIMenuPreference.setEntryValues(this.f21355r);
        this.f21350m.setOnPreferenceChangeListener(this);
        COUIMenuPreference cOUIMenuPreference2 = (COUIMenuPreference) findPreference("sortOrder");
        this.f21349l = cOUIMenuPreference2;
        cOUIMenuPreference2.setEntryValues(this.f21356x);
        this.f21349l.setOnPreferenceChangeListener(this);
        Resources resources = getResources();
        if (D1(resources)) {
            cOUIPreferenceCategory2.removePreference(this.f21349l);
        }
        if (C1(resources)) {
            cOUIPreferenceCategory2.removePreference(this.f21350m);
        }
        boolean e10 = U.e(this.f21340c);
        HighlightSwitchPreference highlightSwitchPreference = (HighlightSwitchPreference) findPreference("contacts_photo_switch");
        this.f21344g = highlightSwitchPreference;
        highlightSwitchPreference.setChecked(e10);
        this.f21344g.setOnPreferenceChangeListener(this);
        boolean z10 = PreferenceManager.getDefaultSharedPreferences(this.f21340c).getBoolean("filter.onlyPhone", false);
        HighlightSwitchPreference highlightSwitchPreference2 = (HighlightSwitchPreference) findPreference("only_show_contacts_with_numbers");
        this.f21345h = highlightSwitchPreference2;
        highlightSwitchPreference2.setChecked(z10);
        this.f21345h.setOnPreferenceChangeListener(this);
        if (FeatureOption.k() || !CommonFeatureOption.j() || VirtualSupportUtils.m()) {
            cOUIPreferenceCategory3.removePreference(this.f21348k);
        }
        this.f21346i = (COUISwitchPreference) findPreference("contacts_kana_sort_switch");
        if (com.customize.contacts.util.K.f()) {
            this.f21346i.setChecked(this.f21354q.j());
            this.f21346i.setOnPreferenceChangeListener(this);
        } else {
            cOUIPreferenceCategory2.removePreference(this.f21346i);
        }
        HighlightJumpPreference highlightJumpPreference3 = (HighlightJumpPreference) findPreference("about");
        this.f21351n = highlightJumpPreference3;
        highlightJumpPreference3.setOnPreferenceClickListener(this);
        HighlightJumpPreference highlightJumpPreference4 = this.f21351n;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            i10 = R.string.about_odialer;
        } else {
            i10 = R.string.about_contacts;
        }
        highlightJumpPreference4.setTitle(i10);
        this.f21352o = findPreference("pref_personal_policy");
        this.f21353p = findPreference("pref_info_collect_list");
        if (!FeatureOption.o() && CommonFeatureOption.j()) {
            this.f21352o.setOnPreferenceClickListener(this);
            this.f21353p.setOnPreferenceClickListener(this);
        } else {
            cOUIPreferenceCategory5.removePreference(this.f21352o);
            cOUIPreferenceCategory5.removePreference(this.f21353p);
        }
    }

    public final /* synthetic */ void q1() {
        if (com.android.contacts.framework.api.cloudsync.a.g()) {
            z1();
        }
    }

    public final /* synthetic */ void r1(Boolean bool) {
        G1();
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        if (preference == this.f21347j) {
            A.b(this.f21340c, "contact_to_display_entry");
            C0700a.f(this, 6);
        } else if (preference == this.f21339b) {
            A.a(getActivity(), 2000314, 200030093, null, false);
            A.b(this.f21340c, "import_export_contact_entry");
            R7.b.c(this.f21340c, new Intent(this.f21340c, (Class<?>) ContactsImportExportActivity.class));
        } else if (preference == this.f21348k) {
            if (FeatureOption.o()) {
                boolean k10 = w.k(this.f21340c, "android.permission.READ_PHONE_NUMBERS");
                b.e("FunctionsFragment", "hasPermission = " + k10);
                if (!k10) {
                    androidx.core.app.a.q((Activity) this.f21340c, new String[]{"android.permission.READ_PHONE_NUMBERS"}, 1);
                    return false;
                }
            }
            A1();
        } else if (preference == this.f21342e) {
            if (CommonOSPublicFeature.i() && !C7.a.a()) {
                HelpFeedbackUtils.a(1);
                b.b("FunctionsFragment", "go to ContactsHelpFeedbackActivity");
                A.b(this.f21340c, "feedback_entry");
            }
        } else if (preference == this.f21351n) {
            R7.b.c(this.f21340c, new Intent(getActivity(), (Class<?>) AboutActivity.class));
            A.b(this.f21340c, "about_entry");
        } else if (preference == this.f21338a) {
            com.android.contacts.framework.api.cloudsync.a.a("FunctionsFragment onPreferenceClick", C0490m.a(getLifecycle()), new Runnable() { // from class: M3.f
                @Override // java.lang.Runnable
                public final void run() {
                    FunctionsFragment.this.t1();
                }
            });
        } else if (preference == this.f21352o) {
            StatementUtils.A(this.f21340c, 17, false, 0);
        } else if (preference == this.f21353p) {
            com.android.contacts.framework.api.infocollection.a.d(this.f21340c);
        }
        return true;
    }

    public final /* synthetic */ void s1(Boolean bool) {
        G1();
    }

    public final /* synthetic */ void t1() {
        com.android.contacts.framework.api.cloudsync.a.i(this.f21340c, !FeatureOption.i());
    }

    public final /* synthetic */ void u1(View view) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            A.b(activity, "setting_back");
        }
    }

    public final /* synthetic */ void v1(COUIPopupListWindow cOUIPopupListWindow, AdapterView adapterView, View view, int i10, long j10) {
        cOUIPopupListWindow.dismiss();
        A.a(getActivity(), 2000317, 200030096, null, false);
        Intent intent = new Intent(getActivity(), (Class<?>) MergeSameInfoContactsActivity.class);
        intent.putExtra("notification_string_id", "duplicate contacts");
        if (i10 != 0) {
            if (i10 == 1) {
                intent.putExtra("operation_mode", 2);
            }
        } else {
            intent.putExtra("operation_mode", 0);
        }
        R7.b.c(this.f21340c, intent);
    }

    public final /* synthetic */ void w1() {
        if (this.f21343f == null) {
            return;
        }
        if (!com.android.contacts.framework.api.cloudsync.a.g()) {
            this.f21343f.setVisible(false);
        } else if (FeatureOption.o()) {
            H1();
        } else {
            com.android.contacts.framework.api.cloudsync.a.c();
            this.f21343f.setVisible(true);
        }
    }

    public final /* synthetic */ void x1() {
        boolean z10;
        int i10;
        if (isAdded() && this.f21338a != null) {
            if (this.f21357y.w() && this.f21357y.v()) {
                z10 = true;
            } else {
                z10 = false;
            }
            COUIJumpPreference cOUIJumpPreference = this.f21338a;
            if (z10) {
                i10 = R.string.state_opened;
            } else {
                i10 = R.string.state_closed;
            }
            cOUIJumpPreference.setAssignment(getString(i10));
        }
    }

    public final /* synthetic */ void y1() {
        com.android.contacts.framework.api.cloudsync.a.c();
    }

    public final void z1() {
        this.f21357y.u().i(getViewLifecycleOwner(), new androidx.lifecycle.w() { // from class: M3.l
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                FunctionsFragment.this.r1((Boolean) obj);
            }
        });
        this.f21357y.q().i(getViewLifecycleOwner(), new androidx.lifecycle.w() { // from class: M3.m
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                FunctionsFragment.this.s1((Boolean) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
    }
}
