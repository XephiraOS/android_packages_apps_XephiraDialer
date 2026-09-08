package X3;

import H7.b;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.preference.Preference;
import com.android.contacts.list.AccountFilterActivity;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.model.Account;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SimContactsImportExportPreferences.java */
/* loaded from: classes3.dex */
public class a implements Preference.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4284a;

    /* renamed from: b, reason: collision with root package name */
    public final V0.a f4285b;

    /* renamed from: c, reason: collision with root package name */
    public COUIPreferenceCategory f4286c;

    /* renamed from: d, reason: collision with root package name */
    public COUIPreferenceCategory f4287d;

    /* renamed from: e, reason: collision with root package name */
    public Preference f4288e;

    /* renamed from: f, reason: collision with root package name */
    public Preference f4289f;

    /* renamed from: g, reason: collision with root package name */
    public Preference f4290g;

    /* renamed from: h, reason: collision with root package name */
    public Preference f4291h;

    /* compiled from: SimContactsImportExportPreferences.java */
    /* renamed from: X3.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class AsyncTaskC0082a extends AsyncTask<Integer, Integer, List<ContactListFilter>> {

        /* renamed from: a, reason: collision with root package name */
        public final Account f4292a;

        /* compiled from: SimContactsImportExportPreferences.java */
        /* renamed from: X3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class DialogInterfaceOnClickListenerC0083a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f4294a;

            public DialogInterfaceOnClickListenerC0083a(List list) {
                this.f4294a = list;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                a.this.f(new Account(((ContactListFilter) this.f4294a.get(i10)).f16740d, ((ContactListFilter) this.f4294a.get(i10)).f16739c), AsyncTaskC0082a.this.f4292a);
            }
        }

        public AsyncTaskC0082a(Account account) {
            this.f4292a = account;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<ContactListFilter> doInBackground(Integer... numArr) {
            ArrayList arrayList = new ArrayList();
            List<ContactListFilter> C12 = AccountFilterActivity.C1(a.this.f4284a, ContactListFilter.h(-2), true);
            if (H7.a.b()) {
                b.b("SimContactsImportExportPreferences", "QueryAvailableAccountAsyncTask, size = " + C12.size());
            }
            int size = C12.size();
            b.b("SimContactsImportExportPreferences", "doInBackground: mDestAccount = " + this.f4292a);
            for (int i10 = size - 1; i10 > 0; i10--) {
                if (H7.a.b()) {
                    b.b("SimContactsImportExportPreferences", "the type is " + C12.get(i10).f16738b);
                }
                if (C12.get(i10).f16738b != -3 && (C12.get(i10).f16738b != 0 || !TextUtils.equals(C12.get(i10).f16739c, this.f4292a.f16942b) || !TextUtils.equals(C12.get(i10).f16740d, this.f4292a.f16941a))) {
                    arrayList.add(C12.get(i10));
                }
            }
            return arrayList;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<ContactListFilter> list) {
            if (a.this.f4284a instanceof Activity) {
                Activity activity = (Activity) a.this.f4284a;
                if (activity.isDestroyed() || activity.isFinishing()) {
                    return;
                }
            }
            if (list != null && !list.isEmpty()) {
                if (list.size() == 1) {
                    a.this.f(new Account(list.get(0).f16740d, list.get(0).f16739c), this.f4292a);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (ContactListFilter contactListFilter : list) {
                    String str = contactListFilter.f16739c;
                    if (str != null && TextUtils.equals(str, R0.a.f3166b)) {
                        arrayList.add(a.this.f4284a.getString(R.string.contact_editor_account_storage_phone));
                    } else {
                        arrayList.add(contactListFilter.f16740d);
                    }
                }
                new U0.b(a.this.f4284a, 2132083073).setMessage(R.string.export_to_sim_dialog_title).setItems((CharSequence[]) arrayList.toArray(new String[0]), (DialogInterface.OnClickListener) new DialogInterfaceOnClickListenerC0083a(list)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                return;
            }
            b.i("SimContactsImportExportPreferences", "no available account!");
        }
    }

    public a(Context context, V0.a aVar) {
        this.f4284a = context;
        this.f4285b = aVar;
    }

    public void c() {
        this.f4287d = (COUIPreferenceCategory) this.f4285b.findPreference("pref_key_import_contacts");
        this.f4290g = this.f4285b.findPreference("pref_key_import_from_sim_1");
        this.f4291h = this.f4285b.findPreference("pref_key_import_from_sim_2");
        this.f4287d.removePreference(this.f4290g);
        this.f4287d.removePreference(this.f4291h);
        this.f4286c = (COUIPreferenceCategory) this.f4285b.findPreference("pref_key_export_contacts");
        this.f4289f = this.f4285b.findPreference("pref_key_export_to_sim_1");
        this.f4288e = this.f4285b.findPreference("pref_key_export_to_sim_2");
        this.f4286c.removePreference(this.f4289f);
        this.f4286c.removePreference(this.f4288e);
    }

    public final void d(Preference preference, String str, int i10) {
        preference.setKey(str);
        preference.setTitle(i10);
        preference.setOnPreferenceClickListener(this);
    }

    public void e(Account account) {
        new AsyncTaskC0082a(account).execute(0);
    }

    public final void f(Account account, Account account2) {
        if (H7.a.b()) {
            b.b("SimContactsImportExportPreferences", "startExportToSim: destAccount = " + account2 + ", srcAccount = " + account);
        }
        Intent intent = new Intent("com.oplus.contacts.ui.SELECT_CONTACTS_EXPORT_TO_SIM");
        intent.putExtra("SRC_ACCOUNT", account);
        intent.putExtra("DEST_ACCOUNT", account2);
        R7.b.c(this.f4284a, intent);
    }

    public final void g(Account account) {
        if (H7.a.b()) {
            b.b("SimContactsImportExportPreferences", "startImportFromSim: srcAccount = " + account);
        }
        Intent intent = new Intent("com.oplus.contacts.ui.SELECT_CONTACTS_IMPORT_FROM_SIM");
        intent.putExtra("SRC_ACCOUNT", account);
        R7.b.c(this.f4284a, intent);
    }

    public void h() {
        boolean z10;
        if (!FeatureOption.k()) {
            return;
        }
        boolean z11 = true;
        boolean z12 = false;
        if (B3.a.i()) {
            z10 = b0.m0(this.f4284a, 0);
            z12 = b0.m0(this.f4284a, 1);
        } else {
            if (!b0.m0(this.f4284a, 0) && !b0.m0(this.f4284a, 1)) {
                z11 = false;
            }
            z10 = z11;
        }
        b.b("SimContactsImportExportPreferences", "has sim 1 " + z10 + " has sim 2 " + z12);
        if (z10 && z12) {
            d(this.f4289f, "pref_key_export_to_sim_1", R.string.export_to_sim_card_1);
            d(this.f4288e, "pref_key_export_to_sim_2", R.string.export_to_sim_card_2);
            this.f4286c.addPreference(this.f4289f);
            this.f4286c.addPreference(this.f4288e);
            return;
        }
        if (z10) {
            this.f4286c.removePreference(this.f4288e);
            this.f4286c.addPreference(this.f4289f);
            d(this.f4289f, "pref_key_export_to_sim_1", R.string.export_to_sim_card);
        } else if (z12) {
            this.f4286c.removePreference(this.f4289f);
            this.f4286c.addPreference(this.f4288e);
            d(this.f4288e, "pref_key_export_to_sim_2", R.string.export_to_sim_card);
        } else {
            this.f4286c.removePreference(this.f4289f);
            this.f4286c.removePreference(this.f4288e);
        }
    }

    public void i() {
        boolean z10;
        if (!FeatureOption.k()) {
            return;
        }
        boolean z11 = true;
        boolean z12 = false;
        if (B3.a.i()) {
            z10 = b0.m0(this.f4284a, 0);
            z12 = b0.m0(this.f4284a, 1);
        } else {
            if (!b0.m0(this.f4284a, 0) && !b0.m0(this.f4284a, 1)) {
                z11 = false;
            }
            z10 = z11;
        }
        b.b("SimContactsImportExportPreferences", "has sim 1 " + z10 + " has sim 2 " + z12);
        if (z10 && z12) {
            d(this.f4290g, "pref_key_import_from_sim_1", R.string.import_from_sim_card_1);
            d(this.f4291h, "pref_key_import_from_sim_2", R.string.import_from_sim_card_2);
            this.f4287d.addPreference(this.f4290g);
            this.f4287d.addPreference(this.f4291h);
            return;
        }
        if (z10) {
            this.f4287d.removePreference(this.f4291h);
            this.f4287d.addPreference(this.f4290g);
            d(this.f4290g, "pref_key_import_from_sim_1", R.string.import_from_sim);
        } else if (z12) {
            this.f4287d.removePreference(this.f4290g);
            this.f4287d.addPreference(this.f4291h);
            d(this.f4291h, "pref_key_import_from_sim_2", R.string.import_from_sim);
        } else {
            this.f4287d.removePreference(this.f4290g);
            this.f4287d.removePreference(this.f4291h);
        }
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        if (C7.a.a()) {
            return false;
        }
        if ("pref_key_import_from_sim_1".equals(preference.getKey())) {
            g(new Account(com.customize.contacts.simcontacts.b.g(0), "com.android.oplus.sim"));
        } else if ("pref_key_import_from_sim_2".equals(preference.getKey())) {
            g(new Account(com.customize.contacts.simcontacts.b.g(1), "com.android.oplus.sim"));
        } else if ("pref_key_export_to_sim_1".equals(preference.getKey())) {
            e(new Account(com.customize.contacts.simcontacts.b.g(0), "com.android.oplus.sim"));
        } else if ("pref_key_export_to_sim_2".equals(preference.getKey())) {
            e(new Account(com.customize.contacts.simcontacts.b.g(1), "com.android.oplus.sim"));
        }
        return false;
    }
}
