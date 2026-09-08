package com.android.contacts.voicemail.impl.fetch;

import B1.e;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Network;
import android.net.Uri;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.contacts.voicemail.impl.c;
import com.android.contacts.voicemail.impl.imap.ImapHelper;
import java.util.concurrent.Executors;
import s1.C1523a;
import u1.C1602a;
import w0.C1643c;

/* loaded from: classes.dex */
public class FetchVoicemailReceiver extends BroadcastReceiver {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f18037h = {"source_data", "subscription_id", "subscription_component_name"};

    /* renamed from: a, reason: collision with root package name */
    public ContentResolver f18038a;

    /* renamed from: b, reason: collision with root package name */
    public Uri f18039b;

    /* renamed from: c, reason: collision with root package name */
    public e f18040c;

    /* renamed from: d, reason: collision with root package name */
    public Context f18041d;

    /* renamed from: e, reason: collision with root package name */
    public String f18042e;

    /* renamed from: f, reason: collision with root package name */
    public PhoneAccountHandle f18043f;

    /* renamed from: g, reason: collision with root package name */
    public int f18044g = 3;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Network f18045a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c.b f18046b;

        public a(Network network, c.b bVar) {
            this.f18045a = network;
            this.f18046b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (C1643c.q()) {
                    C1643c.h(FetchVoicemailReceiver.this.f18041d, FetchVoicemailReceiver.this.f18042e, FetchVoicemailReceiver.this.f18039b);
                } else {
                    while (FetchVoicemailReceiver.this.f18044g > 0) {
                        H7.b.e("FetchVoicemailReceiver", "fetching voicemail, retry count=" + FetchVoicemailReceiver.this.f18044g);
                        try {
                            ImapHelper imapHelper = new ImapHelper(FetchVoicemailReceiver.this.f18041d, FetchVoicemailReceiver.this.f18043f, this.f18045a, this.f18046b);
                            try {
                                if (!imapHelper.B(new C1602a(FetchVoicemailReceiver.this.f18041d, FetchVoicemailReceiver.this.f18039b, FetchVoicemailReceiver.this.f18043f), FetchVoicemailReceiver.this.f18042e) && FetchVoicemailReceiver.this.f18044g > 0) {
                                    H7.b.e("FetchVoicemailReceiver", "fetch voicemail failed, retrying");
                                    FetchVoicemailReceiver fetchVoicemailReceiver = FetchVoicemailReceiver.this;
                                    fetchVoicemailReceiver.f18044g--;
                                    imapHelper.close();
                                } else {
                                    imapHelper.close();
                                    if (FetchVoicemailReceiver.this.f18040c != null) {
                                        FetchVoicemailReceiver.this.f18040c.g();
                                        return;
                                    }
                                    return;
                                }
                            } finally {
                                try {
                                    imapHelper.close();
                                } catch (Throwable th) {
                                    th.addSuppressed(th);
                                }
                            }
                        } catch (ImapHelper.InitializingException e10) {
                            H7.b.i("FetchVoicemailReceiver", "Can't retrieve Imap credentials " + e10);
                            if (FetchVoicemailReceiver.this.f18040c != null) {
                                FetchVoicemailReceiver.this.f18040c.g();
                                return;
                            }
                            return;
                        }
                    }
                }
                if (FetchVoicemailReceiver.this.f18040c != null) {
                    FetchVoicemailReceiver.this.f18040c.g();
                }
            } catch (Throwable th2) {
                if (FetchVoicemailReceiver.this.f18040c != null) {
                    FetchVoicemailReceiver.this.f18040c.g();
                }
                throw th2;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends e {
        public b(Context context, PhoneAccountHandle phoneAccountHandle) {
            super(context, phoneAccountHandle, c.c(context, phoneAccountHandle));
        }

        @Override // B1.e, android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            FetchVoicemailReceiver.this.i(network, e());
        }
    }

    public static PhoneAccountHandle j(Context context, PhoneAccountHandle phoneAccountHandle) {
        for (PhoneAccountHandle phoneAccountHandle2 : ((TelecomManager) context.getSystemService(TelecomManager.class)).getCallCapablePhoneAccounts()) {
            if (k(phoneAccountHandle2.getId()).equals(phoneAccountHandle.getId())) {
                return phoneAccountHandle2;
            }
        }
        return null;
    }

    public static String k(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (!Character.isDigit(str.charAt(i10))) {
                return str.substring(0, i10);
            }
        }
        return str;
    }

    public final void i(Network network, c.b bVar) {
        Executors.newCachedThreadPool().execute(new a(network, bVar));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C1523a.b(context).a() && "android.intent.action.FETCH_VOICEMAIL".equals(intent.getAction())) {
            H7.b.e("FetchVoicemailReceiver", "ACTION_FETCH_VOICEMAIL received");
            this.f18041d = context;
            this.f18038a = context.getContentResolver();
            Uri data = intent.getData();
            this.f18039b = data;
            if (data == null) {
                H7.b.i("FetchVoicemailReceiver", "android.intent.action.FETCH_VOICEMAIL intent sent with no data");
                return;
            }
            if (!context.getPackageName().equals(this.f18039b.getQueryParameter("source_package"))) {
                H7.b.c("FetchVoicemailReceiver", "ACTION_FETCH_VOICEMAIL from foreign pacakge " + context.getPackageName());
                return;
            }
            Cursor query = this.f18038a.query(this.f18039b, f18037h, null, null, null);
            if (query == null) {
                H7.b.e("FetchVoicemailReceiver", "ACTION_FETCH_VOICEMAIL query returned null");
                return;
            }
            try {
                if (query.moveToFirst()) {
                    this.f18042e = query.getString(0);
                    String string = query.getString(1);
                    if (TextUtils.isEmpty(string)) {
                        if (com.android.contacts.framework.api.permission.a.b()) {
                            string = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
                        }
                        if (TextUtils.isEmpty(string)) {
                            H7.b.c("FetchVoicemailReceiver", "Account null and no default sim found.");
                            query.close();
                            return;
                        }
                    }
                    this.f18043f = new PhoneAccountHandle(ComponentName.unflattenFromString(query.getString(2)), query.getString(1));
                    if (((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(this.f18043f) == null) {
                        H7.b.c("FetchVoicemailReceiver", "account no longer valid, cannot retrieve message");
                        query.close();
                        return;
                    }
                    if (!B1.b.e(context, this.f18043f)) {
                        PhoneAccountHandle j10 = j(context, this.f18043f);
                        this.f18043f = j10;
                        if (j10 == null) {
                            H7.b.i("FetchVoicemailReceiver", "Account not registered - cannot retrieve message.");
                            query.close();
                            return;
                        }
                        H7.b.e("FetchVoicemailReceiver", "Fetching voicemail with Marshmallow PhoneAccountHandle");
                    }
                    H7.b.e("FetchVoicemailReceiver", "Requesting network to fetch voicemail");
                    b bVar = new b(context, this.f18043f);
                    this.f18040c = bVar;
                    bVar.h();
                }
                query.close();
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
    }
}
