package com.customize.contacts.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.contacts.framework.baseui.highlight.HighlightJumpPreference;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.model.Account;
import com.customize.contacts.activities.ExportContactsActivity;
import com.customize.contacts.activities.ImportContactsActivity;
import com.customize.contacts.util.b0;
import com.customize.pbap.bluetooth.pbapclient.BluetoothImportActivity;
import com.oplus.dialer.R;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ContactsImportExportFragment extends V0.a implements Preference.d {

    /* renamed from: a, reason: collision with root package name */
    public HighlightJumpPreference f21173a;

    /* renamed from: b, reason: collision with root package name */
    public HighlightJumpPreference f21174b;

    /* renamed from: c, reason: collision with root package name */
    public HighlightJumpPreference f21175c;

    /* renamed from: d, reason: collision with root package name */
    public Preference f21176d;

    /* renamed from: e, reason: collision with root package name */
    public HighlightJumpPreference f21177e;

    /* renamed from: g, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f21179g;

    /* renamed from: h, reason: collision with root package name */
    public ThreadPoolExecutor f21180h;

    /* renamed from: i, reason: collision with root package name */
    public Handler f21181i;

    /* renamed from: j, reason: collision with root package name */
    public X3.a f21182j;

    /* renamed from: k, reason: collision with root package name */
    public BroadcastReceiver f21183k;

    /* renamed from: f, reason: collision with root package name */
    public Context f21178f = null;

    /* renamed from: l, reason: collision with root package name */
    public boolean f21184l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21185m = true;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                PreferenceScreen preferenceScreen = ContactsImportExportFragment.this.getPreferenceScreen();
                if (preferenceScreen != null) {
                    preferenceScreen.removeAll();
                }
                try {
                    ContactsImportExportFragment.this.addPreferencesFromResource(R.xml.contacts_import_export_fragment);
                    ContactsImportExportFragment contactsImportExportFragment = ContactsImportExportFragment.this;
                    contactsImportExportFragment.f21173a = (HighlightJumpPreference) contactsImportExportFragment.findPreference("from_sdcard");
                    ContactsImportExportFragment contactsImportExportFragment2 = ContactsImportExportFragment.this;
                    contactsImportExportFragment2.f21174b = (HighlightJumpPreference) contactsImportExportFragment2.findPreference("from_bluetooth");
                    ContactsImportExportFragment contactsImportExportFragment3 = ContactsImportExportFragment.this;
                    contactsImportExportFragment3.f21175c = (HighlightJumpPreference) contactsImportExportFragment3.findPreference("export_sdcard");
                    ContactsImportExportFragment contactsImportExportFragment4 = ContactsImportExportFragment.this;
                    contactsImportExportFragment4.f21176d = contactsImportExportFragment4.findPreference("pref_key_export_to_google");
                    ContactsImportExportFragment contactsImportExportFragment5 = ContactsImportExportFragment.this;
                    contactsImportExportFragment5.f21177e = (HighlightJumpPreference) contactsImportExportFragment5.findPreference("share_contacts");
                    if (ContactsImportExportFragment.this.getActivity().getIntent() != null) {
                        ContactsImportExportFragment contactsImportExportFragment6 = ContactsImportExportFragment.this;
                        contactsImportExportFragment6.v1(contactsImportExportFragment6.getActivity().getIntent().getStringExtra(":settings:fragment_args_key"));
                    }
                    ContactsImportExportFragment.this.r1();
                    ContactsImportExportFragment.this.q1();
                } catch (Exception e10) {
                    H7.b.c("ContactsImportExportFragment", "Exception e: " + e10);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                H7.b.b("ContactsImportExportFragment", "the intent is null, return");
            } else if (TextUtils.equals("contacts.intent.action.SIM_STATE_CHANGED_LOCAL", intent.getAction())) {
                ContactsImportExportFragment.this.x1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        this.f21173a.setOnPreferenceClickListener(this);
        if (C0637b.h()) {
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (preferenceScreen != null) {
                preferenceScreen.removePreference(this.f21175c.getParent());
                preferenceScreen.removePreference(this.f21177e.getParent());
            }
        } else {
            if (com.android.contacts.framework.api.togoogle.a.c()) {
                w1();
            } else {
                this.f21176d.getParent().removePreference(this.f21176d);
            }
            this.f21176d.setOnPreferenceClickListener(this);
            this.f21175c.setOnPreferenceClickListener(this);
            this.f21177e.setOnPreferenceClickListener(this);
        }
        this.f21174b.setOnPreferenceClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(View view) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            com.android.contacts.framework.baseui.util.A.b(activity.getApplicationContext(), "import_export_contact_back");
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        return getString(R.string.import_and_export);
    }

    public final void o1() {
        if (com.android.contacts.framework.api.togoogle.a.c()) {
            final Context applicationContext = getContext().getApplicationContext();
            this.f21180h.execute(new Runnable() { // from class: com.customize.contacts.fragment.i
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsImportExportFragment.this.s1(applicationContext);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f21178f = activity;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21179g = new LinkedBlockingQueue<>();
        this.f21180h = new ThreadPoolExecutor(1, 1, 180L, TimeUnit.SECONDS, this.f21179g);
        this.f21181i = new a(Looper.getMainLooper());
        o1();
        u1();
    }

    @Override // V0.a, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        View findViewById = onCreateView.findViewById(android.R.id.list);
        if (findViewById != null) {
            findViewById.setPadding(0, 0, 0, 0);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f21183k != null) {
            try {
                X.a.b(this.f21178f).e(this.f21183k);
            } catch (Exception e10) {
                H7.b.c("ContactsImportExportFragment", "Exception in initSimCardPreference when register sim state receiver " + e10);
            }
            this.f21183k = null;
        }
        ThreadPoolExecutor threadPoolExecutor = this.f21180h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
            this.f21180h = null;
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (!this.f21185m) {
            o1();
        } else {
            this.f21185m = false;
        }
    }

    @Override // V0.a, com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.fragment.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactsImportExportFragment.this.t1(view2);
            }
        });
    }

    public final void p1() {
        Intent intent = new Intent(this.f21178f, (Class<?>) ExportContactsActivity.class);
        intent.putExtra("for_share_vcard", true);
        R7.b.c(this.f21178f, intent);
    }

    public final void r1() {
        X3.a aVar = new X3.a(this.f21178f, this);
        this.f21182j = aVar;
        aVar.c();
        x1();
        if (this.f21183k == null) {
            this.f21183k = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("contacts.intent.action.SIM_STATE_CHANGED_LOCAL");
            try {
                X.a.b(this.f21178f).c(this.f21183k, intentFilter);
            } catch (Exception e10) {
                H7.b.c("ContactsImportExportFragment", "Exception in initSimCardPreference when register sim state receiver " + e10);
            }
        }
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        if (C7.a.a()) {
            return false;
        }
        if (preference == this.f21177e) {
            com.android.contacts.framework.baseui.util.A.a(getActivity(), 2000314, 200030125, null, false);
            p1();
            return false;
        }
        if (preference == this.f21173a) {
            com.android.contacts.framework.baseui.util.A.a(getActivity(), 2000314, 200030109, null, false);
            R7.b.c(getActivity(), new Intent(this.f21178f, (Class<?>) ImportContactsActivity.class));
            getActivity().overridePendingTransition(0, 0);
            return false;
        }
        if (preference == this.f21175c) {
            com.android.contacts.framework.baseui.util.A.a(getActivity(), 2000314, 200030114, null, false);
            R7.b.c(getActivity(), new Intent(this.f21178f, (Class<?>) ExportContactsActivity.class));
            getActivity().overridePendingTransition(0, 0);
            return false;
        }
        if (preference == this.f21176d) {
            com.android.contacts.framework.api.togoogle.a.e(this.f21178f);
        } else if (preference == this.f21174b) {
            com.android.contacts.framework.baseui.util.A.a(getActivity(), 2000314, 200030181, null, false);
            R7.b.c(getActivity(), new Intent(getActivity(), (Class<?>) BluetoothImportActivity.class));
        }
        return false;
    }

    public final /* synthetic */ void s1(Context context) {
        boolean z10;
        if (M3.c.i(context, new Account(R0.a.f3165a, R0.a.f3166b)) > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f21184l = z10;
        this.f21181i.post(new Runnable() { // from class: com.customize.contacts.fragment.k
            @Override // java.lang.Runnable
            public final void run() {
                ContactsImportExportFragment.this.w1();
            }
        });
    }

    public final void u1() {
        this.f21181i.sendEmptyMessage(0);
    }

    public void v1(String str) {
        if (str != null) {
            H7.b.b("ContactsImportExportFragment", "highlightValue: " + str);
            char c10 = 65535;
            switch (str.hashCode()) {
                case -661672781:
                    if (str.equals("share_contacts")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 196922134:
                    if (str.equals("from_sdcard")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 213502041:
                    if (str.equals("from_bluetooth")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 1220284364:
                    if (str.equals("export_sdcard")) {
                        c10 = 3;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    HighlightJumpPreference highlightJumpPreference = this.f21177e;
                    if (highlightJumpPreference != null) {
                        highlightJumpPreference.a(true);
                        return;
                    }
                    return;
                case 1:
                    HighlightJumpPreference highlightJumpPreference2 = this.f21173a;
                    if (highlightJumpPreference2 != null) {
                        highlightJumpPreference2.a(true);
                        return;
                    }
                    return;
                case 2:
                    HighlightJumpPreference highlightJumpPreference3 = this.f21174b;
                    if (highlightJumpPreference3 != null) {
                        highlightJumpPreference3.a(true);
                        return;
                    }
                    return;
                case 3:
                    HighlightJumpPreference highlightJumpPreference4 = this.f21175c;
                    if (highlightJumpPreference4 != null) {
                        highlightJumpPreference4.a(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void w1() {
        Preference preference;
        if (isAdded() && (preference = this.f21176d) != null) {
            if (this.f21184l) {
                preference.setEnabled(true);
                this.f21176d.setSummary((CharSequence) null);
            } else {
                preference.setEnabled(false);
                this.f21176d.setSummary(R.string.on_contacts_in_local);
            }
        }
    }

    public final void x1() {
        X3.a aVar;
        boolean a02 = b0.a0(this.f21178f);
        H7.b.b("ContactsImportExportFragment", "is show sim card item : " + a02);
        if (a02 && (aVar = this.f21182j) != null) {
            aVar.h();
            this.f21182j.i();
        }
    }
}
