package com.android.contacts.vcard;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.provider.ContactsContract;
import com.android.contacts.activities.RequestPermissionsActivity;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.vcard.VCardEntry;
import com.android.contacts.framework.vcard.exception.VCardException;
import com.android.contacts.framework.vcard.exception.VCardVersionException;
import com.android.contacts.framework.vcard.v;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.vcard.VCardService;
import com.oplus.dialer.R;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import n1.AbstractC1362a;

/* loaded from: classes.dex */
public class NfcImportVCardActivity extends BasicActivity implements ServiceConnection, s {

    /* renamed from: o, reason: collision with root package name */
    public NdefRecord f17695o;

    /* renamed from: p, reason: collision with root package name */
    public AccountWithDataSet f17696p;

    /* loaded from: classes.dex */
    public class a extends AsyncTask<VCardService, Void, k> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k doInBackground(VCardService... vCardServiceArr) {
            k p12 = NfcImportVCardActivity.this.p1();
            if (p12 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(p12);
            vCardServiceArr[0].m(arrayList, NfcImportVCardActivity.this);
            return p12;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(k kVar) {
            NfcImportVCardActivity nfcImportVCardActivity = NfcImportVCardActivity.this;
            nfcImportVCardActivity.unbindService(nfcImportVCardActivity);
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            NfcImportVCardActivity nfcImportVCardActivity = NfcImportVCardActivity.this;
            nfcImportVCardActivity.unbindService(nfcImportVCardActivity);
        }
    }

    private void q1() {
        Intent intent = new Intent(this, (Class<?>) VCardService.class);
        startService(intent);
        bindService(intent, this, 1);
    }

    @Override // com.android.contacts.vcard.s
    public void M(k kVar, int i10, Uri uri) {
        if (isFinishing()) {
            H7.b.e("NfcImportVCardActivity", "Late import -- ignoring");
        } else if (uri != null) {
            R7.b.c(this, new Intent("android.intent.action.VIEW", ContactsContract.RawContacts.getContactLookupUri(getContentResolver(), uri)));
            C7.e.b(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1) {
            if (i11 == -1) {
                this.f17696p = new AccountWithDataSet(C7.e.l(intent, "account_name"), C7.e.l(intent, "account_type"), C7.e.l(intent, "data_set"));
                q1();
            } else {
                C7.e.b(this);
            }
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        NdefMessage ndefMessage;
        super.onCreate(bundle);
        if (RequestPermissionsActivity.p2(this)) {
            return;
        }
        Intent intent = getIntent();
        if (!"android.nfc.action.NDEF_DISCOVERED".equals(intent.getAction())) {
            H7.b.i("NfcImportVCardActivity", "Unknowon intent " + intent);
            C7.e.b(this);
        }
        Parcelable[] h10 = C7.e.h(intent, "android.nfc.extra.NDEF_MESSAGES");
        if (h10 != null && h10.length > 0) {
            ndefMessage = (NdefMessage) h10[0];
        } else {
            ndefMessage = null;
        }
        if (ndefMessage == null) {
            C7.e.b(this);
            return;
        }
        NdefRecord[] records = ndefMessage.getRecords();
        if (records != null && records.length != 0) {
            NdefRecord ndefRecord = records[0];
            String str = new String(ndefRecord.getType(), Charset.forName("UTF8"));
            if (ndefRecord.getTnf() == 2 && ("text/x-vcard".equalsIgnoreCase(str) || "text/vcard".equals(str))) {
                this.f17695o = ndefRecord;
                List<AccountWithDataSet> g10 = AbstractC1362a.h(this).g(true);
                if (g10.size() == 0) {
                    this.f17696p = null;
                } else if (g10.size() == 1) {
                    this.f17696p = g10.get(0);
                } else {
                    Q7.b.b(this, new Intent(this, (Class<?>) SelectAccountActivity.class), 1, 0);
                    return;
                }
                q1();
                return;
            }
            H7.b.i("NfcImportVCardActivity", "Not a vcard");
            return;
        }
        H7.b.i("NfcImportVCardActivity", "No records " + intent);
        C7.e.b(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new a().execute(((VCardService.b) iBinder).a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public k p1() {
        com.android.contacts.framework.vcard.j jVar;
        v vVar;
        int i10 = "NfcImportVCardActivity";
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f17695o.getPayload());
                byteArrayInputStream.mark(0);
                com.android.contacts.framework.vcard.q qVar = new com.android.contacts.framework.vcard.q();
                try {
                    try {
                        jVar = new com.android.contacts.framework.vcard.j();
                        vVar = new v();
                        qVar.a(jVar);
                        qVar.a(vVar);
                        qVar.c(byteArrayInputStream);
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused) {
                        }
                        i10 = 1;
                    } catch (VCardVersionException unused2) {
                        byteArrayInputStream.reset();
                        com.android.contacts.framework.vcard.r rVar = new com.android.contacts.framework.vcard.r();
                        try {
                            try {
                                jVar = new com.android.contacts.framework.vcard.j();
                                vVar = new v();
                                rVar.a(jVar);
                                rVar.a(vVar);
                                rVar.c(byteArrayInputStream);
                                try {
                                    byteArrayInputStream.close();
                                } catch (IOException unused3) {
                                }
                                i10 = 2;
                            } catch (VCardVersionException unused4) {
                                byteArrayInputStream.close();
                                return null;
                            }
                        } catch (IOException unused5) {
                            return null;
                        }
                    }
                    return new k(this.f17696p, this.f17695o.getPayload(), null, getString(R.string.nfc_vcard_file_name), vVar.g(), vVar.f(), i10, jVar.f());
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException unused6) {
                    }
                    throw th;
                }
            } catch (VCardException e10) {
                H7.b.c("NfcImportVCardActivity", "Error parsing vcard" + e10);
                return null;
            }
        } catch (IOException e11) {
            H7.b.c(i10, "Failed reading vcard data" + e11);
            return null;
        }
    }

    @Override // com.android.contacts.vcard.s
    public void y(k kVar) {
        if (isFinishing()) {
            H7.b.e("NfcImportVCardActivity", "Late import failure -- ignoring");
        }
    }

    @Override // com.android.contacts.vcard.s
    public void H(f fVar) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    @Override // com.android.contacts.vcard.s
    public void A(k kVar, int i10) {
    }

    @Override // com.android.contacts.vcard.s
    public void N(f fVar, int i10) {
    }

    @Override // com.android.contacts.vcard.s
    public void b(c cVar, int i10) {
    }

    @Override // com.android.contacts.vcard.s
    public void O(k kVar, int i10, int i11) {
    }

    @Override // com.android.contacts.vcard.s
    public void f(k kVar, int i10, VCardEntry vCardEntry, int i11, int i12) {
    }
}
