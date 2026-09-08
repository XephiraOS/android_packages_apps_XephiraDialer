package com.android.contacts.voicemail.impl.mail.store;

import android.content.Context;
import android.net.Network;
import com.android.contacts.voicemail.impl.imap.ImapHelper;
import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.mail.e;
import com.android.contacts.voicemail.impl.mail.f;
import java.io.InputStream;
import w1.d;

/* loaded from: classes.dex */
public class ImapStore {

    /* renamed from: a, reason: collision with root package name */
    public final Context f18103a;

    /* renamed from: b, reason: collision with root package name */
    public final ImapHelper f18104b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18105c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18106d;

    /* renamed from: e, reason: collision with root package name */
    public final e f18107e;

    /* renamed from: f, reason: collision with root package name */
    public com.android.contacts.voicemail.impl.mail.store.a f18108f;

    /* loaded from: classes.dex */
    public static class ImapException extends MessagingException {
        private static final long serialVersionUID = 1;
        private final String mAlertText;
        private final String mResponseCode;
        private final String mStatus;
        private final String mStatusMessage;

        public ImapException(String str, String str2, String str3, String str4, String str5) {
            super(str);
            this.mStatus = str2;
            this.mStatusMessage = str3;
            this.mAlertText = str4;
            this.mResponseCode = str5;
        }

        public String a() {
            return this.mAlertText;
        }

        public String b() {
            return this.mStatus;
        }

        public String c() {
            return this.mStatusMessage;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: x, reason: collision with root package name */
        public b f18109x;

        public a(String str, b bVar) {
            this.f18093a = str;
            this.f18109x = bVar;
        }

        public void A(int i10) {
            this.f37593m = i10;
        }

        @Override // w1.d
        public void x(InputStream inputStream) {
            super.x(inputStream);
        }

        public void z(String str, boolean z10) {
            super.o(str, z10);
        }
    }

    public ImapStore(Context context, ImapHelper imapHelper, String str, String str2, int i10, String str3, int i11, Network network) {
        this.f18103a = context;
        this.f18104b = imapHelper;
        this.f18105c = str;
        this.f18106d = str2;
        this.f18107e = new e(context, e(), network, str3, i10, i11);
    }

    public static String h(f[] fVarArr) {
        StringBuilder sb = new StringBuilder();
        int length = fVarArr.length;
        int i10 = 0;
        boolean z10 = false;
        while (i10 < length) {
            f fVar = fVarArr[i10];
            if (z10) {
                sb.append(',');
            }
            sb.append(fVar.n());
            i10++;
            z10 = true;
        }
        return sb.toString();
    }

    public e a() {
        return this.f18107e.clone();
    }

    public void b() {
        com.android.contacts.voicemail.impl.mail.store.a aVar = this.f18108f;
        if (aVar != null) {
            aVar.a();
            this.f18108f = null;
        }
    }

    public com.android.contacts.voicemail.impl.mail.store.a c() {
        if (this.f18108f == null) {
            this.f18108f = new com.android.contacts.voicemail.impl.mail.store.a(this);
        }
        return this.f18108f;
    }

    public Context d() {
        return this.f18103a;
    }

    public ImapHelper e() {
        return this.f18104b;
    }

    public String f() {
        return this.f18106d;
    }

    public String g() {
        return this.f18105c;
    }
}
