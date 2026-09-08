package com.customize.contacts.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.android.contacts.model.Account;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.activities.ServiceNumberActivity;
import com.customize.contacts.activities.SimContactsListActivity;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import h1.C1075d;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SimAccountFragment extends V0.a implements Preference.d {

    /* renamed from: a, reason: collision with root package name */
    public COUIJumpPreference f21273a;

    /* renamed from: b, reason: collision with root package name */
    public COUIJumpPreference f21274b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<Account> f21275c = null;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<Integer> f21276d = null;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(View view) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(0);
            activity.finish();
        }
    }

    public void f1(ArrayList<Account> arrayList) {
        this.f21275c = arrayList;
    }

    public void g1(ArrayList<Integer> arrayList) {
        this.f21276d = arrayList;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        return getString(R.string.simContacts_title);
    }

    public void h1() {
        int size = this.f21275c.size();
        COUIPreferenceCategory cOUIPreferenceCategory = (COUIPreferenceCategory) findPreference("pref_key_sim_accounts");
        if (cOUIPreferenceCategory == null) {
            return;
        }
        if (size == 0) {
            cOUIPreferenceCategory.removeAll();
            return;
        }
        if (size == 1) {
            cOUIPreferenceCategory.addItemFromInflater(this.f21273a);
            cOUIPreferenceCategory.removePreference(this.f21274b);
        }
        String I10 = b0.I(getActivity().getApplicationContext(), this.f21276d.get(0).intValue());
        String d10 = C1075d.d(getActivity().getApplicationContext(), this.f21276d.get(0).intValue());
        this.f21273a.setTitle(I10);
        if (!TextUtils.isEmpty(d10) && !TextUtils.isEmpty(d10.trim())) {
            d10 = "\u200e" + d10;
            this.f21273a.setAssignment(d10);
        }
        if (H7.a.b()) {
            H7.b.b("SimAccountFragment", "pref1 : slotId1 = " + this.f21276d.get(0) + ", number1 = " + H7.a.d(d10));
        }
        if (size == 2) {
            cOUIPreferenceCategory.addItemFromInflater(this.f21273a);
            cOUIPreferenceCategory.addItemFromInflater(this.f21274b);
            String I11 = b0.I(getActivity().getApplicationContext(), this.f21276d.get(1).intValue());
            String d11 = C1075d.d(getActivity().getApplicationContext(), this.f21276d.get(1).intValue());
            this.f21274b.setTitle(I11);
            if (!TextUtils.isEmpty(d11) && !TextUtils.isEmpty(d11.trim())) {
                d11 = "\u200e" + d11;
                this.f21274b.setAssignment(d11);
            }
            if (H7.a.b()) {
                H7.b.b("SimAccountFragment", "pref2 : slotId2 = " + this.f21276d.get(1) + ", number2 = " + H7.a.d(d11));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (340 == i10 && -1 == i11) {
            ArrayList i12 = C7.e.i(intent, "SELECTED_CONTACTS");
            if (i12.size() == 0) {
                com.oplus.foundation.util.ui.c.d(getActivity(), R.string.toast_msg_contacts_no_phone_number);
            } else if (i12.size() > 200) {
                com.oplus.foundation.util.ui.c.e(getActivity(), getString(R.string.too_many_contacts_tips, 200));
            } else {
                C0811w.k(getActivity(), i12);
                getActivity().finish();
            }
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        addPreferencesFromResource(R.xml.sim_accounts_prefs);
        this.f21273a = (COUIJumpPreference) findPreference("sim1_account");
        this.f21274b = (COUIJumpPreference) findPreference("sim2_account");
        this.f21273a.setOnPreferenceClickListener(this);
        this.f21274b.setOnPreferenceClickListener(this);
    }

    @Override // V0.a, com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        COUIToolbar toolbar = getToolbar();
        FragmentActivity activity = getActivity();
        if (activity != null && C7.e.c(activity.getIntent(), "show_sdn_service_number", false)) {
            toolbar.setTitle(R.string.oplus_sdn_serviceNumber);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.fragment.I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SimAccountFragment.this.e1(view2);
            }
        });
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        Intent intent = new Intent(getActivity(), (Class<?>) SimContactsListActivity.class);
        boolean c10 = C7.e.c(getActivity().getIntent(), "ToSMS", false);
        boolean c11 = C7.e.c(getActivity().getIntent(), "show_sdn_service_number", false);
        if (c10) {
            intent.putExtra("ToSMS", c10);
            if (this.f21273a == preference && this.f21276d.size() > 0 && this.f21275c.size() > 0 && b0.m0(getActivity(), this.f21276d.get(0).intValue())) {
                intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, this.f21275c.get(0).f16941a);
                S7.b.b(this, intent, 340, 0);
            } else if (this.f21274b == preference && this.f21276d.size() > 1 && this.f21275c.size() > 1 && b0.m0(getActivity(), this.f21276d.get(1).intValue())) {
                intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, this.f21275c.get(1).f16941a);
                S7.b.b(this, intent, 340, 0);
            } else {
                com.oplus.foundation.util.ui.c.b(getActivity(), R.string.simcard_abnormal_please_check_and_try_again);
            }
        } else if (c11) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) ServiceNumberActivity.class);
            if (this.f21273a == preference && this.f21276d.size() > 0 && this.f21275c.size() > 0 && b0.m0(getActivity(), this.f21276d.get(0).intValue())) {
                intent2.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, this.f21275c.get(0).f16941a);
                S7.b.b(this, intent2, 340, 0);
            } else if (this.f21274b == preference && this.f21276d.size() > 1 && this.f21275c.size() > 1 && b0.m0(getActivity(), this.f21276d.get(1).intValue())) {
                intent2.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, this.f21275c.get(1).f16941a);
                S7.b.b(this, intent2, 340, 0);
            }
        } else {
            boolean c12 = C7.e.c(getActivity().getIntent(), "imprort_sim_contacts", false);
            if (this.f21273a == preference && this.f21276d.size() > 0 && this.f21275c.size() > 0 && b0.m0(getActivity(), this.f21276d.get(0).intValue())) {
                if (this.f21275c.size() > 0) {
                    intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, this.f21275c.get(0).f16941a);
                } else {
                    intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, (String) null);
                }
                intent.putExtra("imprort_sim_contacts", c12);
                R7.b.c(getActivity(), intent);
            } else if (this.f21274b == preference && this.f21276d.size() > 1 && this.f21275c.size() > 1 && b0.m0(getActivity(), this.f21276d.get(1).intValue())) {
                intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, this.f21275c.get(1).f16941a);
                intent.putExtra("imprort_sim_contacts", c12);
                R7.b.c(getActivity(), intent);
            } else {
                com.oplus.foundation.util.ui.c.b(getActivity(), R.string.simcard_abnormal_please_check_and_try_again);
            }
        }
        return false;
    }
}
