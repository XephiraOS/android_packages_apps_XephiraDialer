package com.android.contacts.voicemail.impl.imap;

import android.content.Context;
import android.net.Network;
import android.net.NetworkInfo;
import android.telecom.PhoneAccountHandle;
import android.util.Base64;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.Voicemail;
import com.android.contacts.voicemail.impl.c;
import com.android.contacts.voicemail.impl.mail.Address;
import com.android.contacts.voicemail.impl.mail.FetchProfile;
import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.mail.f;
import com.android.contacts.voicemail.impl.mail.g;
import com.android.contacts.voicemail.impl.mail.j;
import com.android.contacts.voicemail.impl.mail.store.ImapStore;
import com.android.contacts.voicemail.impl.mail.store.b;
import com.android.contacts.voicemail.impl.sync.a;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import u1.C1602a;

/* loaded from: classes.dex */
public class ImapHelper implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public com.android.contacts.voicemail.impl.mail.store.b f18049a;

    /* renamed from: b, reason: collision with root package name */
    public ImapStore f18050b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f18051c;

    /* renamed from: d, reason: collision with root package name */
    public final PhoneAccountHandle f18052d;

    /* renamed from: e, reason: collision with root package name */
    public final Network f18053e;

    /* renamed from: f, reason: collision with root package name */
    public final c.b f18054f;

    /* renamed from: g, reason: collision with root package name */
    public D1.c f18055g;

    /* renamed from: h, reason: collision with root package name */
    public final com.android.contacts.voicemail.impl.b f18056h;

    /* loaded from: classes.dex */
    public static class InitializingException extends Exception {
        public InitializingException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public v1.c f18057a;

        @Override // com.android.contacts.voicemail.impl.mail.store.b.a
        public void a(f fVar) {
            C1.a.a("ImapHelper", "Fetched message body for ");
            C1.a.a("ImapHelper", "Message retrieved: ");
            try {
                this.f18057a = c(fVar);
            } catch (MessagingException e10) {
                C1.a.b("ImapHelper", "messageRetrieved Messaging Exception: " + e10);
            } catch (IOException e11) {
                C1.a.b("ImapHelper", "messageRetrieved IO Exception: " + e11);
            }
        }

        public v1.c b() {
            return this.f18057a;
        }

        public final v1.c c(f fVar) {
            g gVar = (g) fVar.b();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < gVar.d(); i10++) {
                com.android.contacts.voicemail.impl.mail.b b10 = gVar.b(i10);
                String lowerCase = b10.a().toLowerCase();
                arrayList.add(lowerCase);
                if (lowerCase.startsWith("audio/")) {
                    byte[] L10 = ImapHelper.this.L(b10.b());
                    C1.a.a("ImapHelper", String.format("Fetched %s bytes of data", Integer.valueOf(L10.length)));
                    return new v1.c(lowerCase, L10);
                }
            }
            C1.a.b("ImapHelper", "No audio attachment found on this voicemail, mimeTypes:" + arrayList);
            return null;
        }

        public a() {
        }
    }

    /* loaded from: classes.dex */
    public final class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public c f18059a;

        public b() {
        }

        @Override // com.android.contacts.voicemail.impl.mail.store.b.a
        public void a(f fVar) {
            C1.a.a("ImapHelper", "Fetched message structure for ");
            C1.a.a("ImapHelper", "Message retrieved: ");
            try {
                c b10 = b(fVar);
                this.f18059a = b10;
                if (b10 == null) {
                    C1.a.a("ImapHelper", "This voicemail does not have an attachment...");
                }
            } catch (MessagingException e10) {
                C1.a.b("ImapHelper", "messageRetrieved Messaging Exception " + e10);
                ImapHelper.this.g();
            }
        }

        public final c b(f fVar) {
            if (!fVar.a().startsWith("multipart/")) {
                C1.a.f("ImapHelper", "Ignored non multi-part message");
                return null;
            }
            c cVar = new c();
            g gVar = (g) fVar.b();
            for (int i10 = 0; i10 < gVar.d(); i10++) {
                com.android.contacts.voicemail.impl.mail.b b10 = gVar.b(i10);
                String lowerCase = b10.a().toLowerCase();
                C1.a.a("ImapHelper", "bodyPart mime type: " + lowerCase);
                if (lowerCase.startsWith("audio/")) {
                    cVar.f18061a = fVar;
                } else if (lowerCase.startsWith("text/")) {
                    cVar.f18062b = b10;
                } else {
                    H7.b.h("ImapHelper", "Unknown bodyPart MIME: " + lowerCase);
                }
            }
            if (cVar.f18061a == null) {
                return null;
            }
            return cVar;
        }

        public c c() {
            return this.f18059a;
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public f f18061a;

        /* renamed from: b, reason: collision with root package name */
        public com.android.contacts.voicemail.impl.mail.b f18062b;
    }

    /* loaded from: classes.dex */
    public final class d implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public String f18063a;

        @Override // com.android.contacts.voicemail.impl.mail.store.b.a
        public void a(f fVar) {
            C1.a.a("ImapHelper", "Fetched transcription for " + fVar.n());
            try {
                this.f18063a = new String(ImapHelper.this.L(fVar.b()));
            } catch (MessagingException e10) {
                C1.a.b("ImapHelper", "messageRetrieved Messaging Exception: " + e10);
            } catch (IOException e11) {
                C1.a.b("ImapHelper", "messageRetrieved IO Exception: " + e11);
            }
        }

        public String b() {
            return this.f18063a;
        }

        public d() {
        }
    }

    public ImapHelper(Context context, PhoneAccountHandle phoneAccountHandle, Network network, c.b bVar) {
        this(context, new com.android.contacts.voicemail.impl.b(context, phoneAccountHandle), phoneAccountHandle, network, bVar);
    }

    public static int G(x1.g gVar) {
        if (gVar.B()) {
            if (!gVar.y()) {
                String k10 = gVar.n(1).k();
                C1.a.a("ImapHelper", "change PIN failed: " + k10);
                if ("password too short".equals(k10)) {
                    return 1;
                }
                if ("password too long".equals(k10)) {
                    return 2;
                }
                if ("password too weak".equals(k10)) {
                    return 3;
                }
                if ("old password mismatch".equals(k10)) {
                    return 4;
                }
                if ("password contains invalid characters".equals(k10)) {
                    return 5;
                }
                return 6;
            }
            C1.a.a("ImapHelper", "change PIN succeeded");
            return 0;
        }
        throw new MessagingException(19, "tagged response expected");
    }

    public boolean B(C1602a c1602a, String str) {
        try {
            com.android.contacts.voicemail.impl.mail.store.b a02 = a0("mode_read_write");
            this.f18049a = a02;
            if (a02 == null) {
                return false;
            }
            f i10 = a02.i(str);
            if (i10 == null) {
                return false;
            }
            c1602a.a(y(i10));
            g();
            return true;
        } catch (MessagingException unused) {
            return false;
        } finally {
            g();
        }
    }

    public com.android.contacts.voicemail.impl.b I() {
        return this.f18056h;
    }

    public final byte[] L(com.android.contacts.voicemail.impl.mail.a aVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        try {
            aVar.writeTo(bufferedOutputStream);
            return Base64.decode(byteArrayOutputStream.toByteArray(), 0);
        } finally {
            try {
                bufferedOutputStream.close();
            } catch (Exception e10) {
                C1.a.b("ImapHelper", "Exception = " + e10);
            }
        }
    }

    public final String O(Address[] addressArr) {
        if (addressArr != null && addressArr.length > 0) {
            if (addressArr.length != 1) {
                C1.a.f("ImapHelper", "More than one from addresses found. Using the first one.");
            }
            String address = addressArr[0].getAddress();
            int indexOf = address.indexOf(64);
            if (indexOf != -1) {
                return address.substring(0, indexOf);
            }
            return address;
        }
        return null;
    }

    public b.C0177b S() {
        try {
            com.android.contacts.voicemail.impl.mail.store.b a02 = a0("mode_read_only");
            this.f18049a = a02;
            if (a02 == null) {
                C1.a.b("ImapHelper", "Unable to open folder");
                return null;
            }
            return a02.l();
        } catch (MessagingException e10) {
            C1.a.b("ImapHelper", "getQuota Messaging Exception " + e10);
            return null;
        } finally {
            g();
        }
    }

    public final Voicemail T(c cVar) {
        long j10;
        f fVar = cVar.f18061a;
        d dVar = new d();
        if (cVar.f18062b != null) {
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(cVar.f18062b);
            this.f18049a.g(new f[]{fVar}, fetchProfile, dVar);
        }
        Date m10 = fVar.m();
        if (m10 != null) {
            j10 = m10.getTime();
        } else {
            j10 = 0;
        }
        String O10 = O(fVar.l());
        boolean contains = Arrays.asList(fVar.k()).contains("seen");
        Long i10 = fVar.i();
        Voicemail.b j11 = Voicemail.b(j10, O10).f(this.f18052d).h(this.f18051c.getPackageName()).g(fVar.n()).d(contains).j(dVar.b());
        if (i10 != null) {
            j11.b(i10.longValue());
        }
        return j11.a();
    }

    public void U(OmtpEvents omtpEvents) {
        this.f18056h.r(this.f18054f, omtpEvents);
    }

    public boolean V() {
        NetworkInfo networkInfo = J7.a.a().getNetworkInfo(this.f18053e);
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isRoaming();
    }

    public boolean X(List<Voicemail> list) {
        return c0(list, "deleted");
    }

    public boolean Z(List<Voicemail> list) {
        return c0(list, "seen");
    }

    public final com.android.contacts.voicemail.impl.mail.store.b a0(String str) {
        try {
            if (this.f18050b == null) {
                return null;
            }
            com.android.contacts.voicemail.impl.mail.store.b bVar = new com.android.contacts.voicemail.impl.mail.store.b(this.f18050b, "INBOX");
            bVar.r(str);
            return bVar;
        } catch (MessagingException e10) {
            C1.a.b("ImapHelper", "openImapFolder Messaging Exception " + e10);
            return null;
        }
    }

    public final boolean c0(List<Voicemail> list, String... strArr) {
        if (list.size() == 0) {
            return false;
        }
        try {
            com.android.contacts.voicemail.impl.mail.store.b a02 = a0("mode_read_write");
            this.f18049a = a02;
            if (a02 == null) {
                return false;
            }
            a02.u(o(list), strArr, true);
            return true;
        } catch (MessagingException e10) {
            C1.a.b("ImapHelper", "setFlags Messaging exception " + e10);
            return false;
        } finally {
            g();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18050b.b();
    }

    public int e(String str, String str2) {
        com.android.contacts.voicemail.impl.mail.store.a c10 = this.f18050b.c();
        try {
            try {
                c10.s(String.format(Locale.US, I().l().b("XCHANGE_TUI_PWD PWD=%1$s OLD_PWD=%2$s"), str2, str), true);
                return G(c10.r());
            } catch (IOException e10) {
                H7.b.c("ImapHelper", "changePin: ioe = " + e10);
                c10.d();
                return 6;
            }
        } finally {
            c10.d();
        }
    }

    public void f(String str) {
        com.android.contacts.voicemail.impl.mail.store.a c10 = this.f18050b.c();
        try {
            try {
                c10.s(String.format(Locale.US, I().l().b("XCHANGE_VM_LANG LANG=%1$s"), str), true);
            } catch (IOException e10) {
                C1.a.b("ImapHelper", "changeVoicemailTuiLanguage error " + e10);
            }
        } finally {
            c10.d();
        }
    }

    public final void f0(b.C0177b c0177b) {
        if (c0177b == null) {
            C1.a.d("ImapHelper", "quota was null");
            return;
        }
        C1.a.d("ImapHelper", "Updating Voicemail status table with quota occupied: " + c0177b.f18124a + " new quota total:" + c0177b.f18125b);
        com.android.contacts.voicemail.impl.c.c(this.f18051c, this.f18052d).g(c0177b.f18124a, c0177b.f18125b).a();
        C1.a.d("ImapHelper", "Updated quota occupied and total");
    }

    public final void g() {
        com.android.contacts.voicemail.impl.mail.store.b bVar = this.f18049a;
        if (bVar != null) {
            bVar.b(true);
        }
    }

    public void g0() {
        com.android.contacts.voicemail.impl.mail.store.b a02;
        try {
            try {
                a02 = a0("mode_read_write");
                this.f18049a = a02;
            } catch (MessagingException e10) {
                C1.a.b("ImapHelper", "updateQuota Messaging Exception " + e10);
            }
            if (a02 == null) {
                return;
            }
            h0(a02);
        } finally {
            g();
        }
    }

    public final void h0(com.android.contacts.voicemail.impl.mail.store.b bVar) {
        f0(bVar.l());
    }

    public void l() {
        com.android.contacts.voicemail.impl.mail.store.a c10 = this.f18050b.c();
        try {
            try {
                c10.j(I().l().b("XCLOSE_NUT"), false);
            } catch (IOException e10) {
                throw new MessagingException(19, e10.toString());
            }
        } finally {
            c10.d();
        }
    }

    public final f[] o(List<Voicemail> list) {
        f[] fVarArr = new f[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            w1.d dVar = new w1.d();
            fVarArr[i10] = dVar;
            dVar.r(list.get(i10).k());
        }
        return fVarArr;
    }

    public List<Voicemail> r() {
        ArrayList arrayList = new ArrayList();
        try {
            com.android.contacts.voicemail.impl.mail.store.b a02 = a0("mode_read_write");
            this.f18049a = a02;
            if (a02 == null) {
                return null;
            }
            for (f fVar : a02.j(null)) {
                c s10 = s(fVar);
                if (s10 != null) {
                    arrayList.add(T(s10));
                }
            }
            return arrayList;
        } catch (MessagingException e10) {
            C1.a.b("ImapHelper", "fetchAllVoicemails Messaging Exception " + e10);
            return null;
        } finally {
            g();
        }
    }

    public final c s(f fVar) {
        C1.a.a("ImapHelper", "Fetching message structure for ");
        b bVar = new b();
        FetchProfile fetchProfile = new FetchProfile();
        fetchProfile.addAll(Arrays.asList(FetchProfile.Item.FLAGS, FetchProfile.Item.ENVELOPE, FetchProfile.Item.STRUCTURE));
        this.f18049a.g(new f[]{fVar}, fetchProfile, bVar);
        return bVar.c();
    }

    public boolean u(a.C0178a c0178a, String str) {
        try {
            com.android.contacts.voicemail.impl.mail.store.b a02 = a0("mode_read_write");
            this.f18049a = a02;
            if (a02 == null) {
                return false;
            }
            f i10 = a02.i(str);
            if (i10 == null) {
                return false;
            }
            c s10 = s(i10);
            if (s10 != null) {
                d dVar = new d();
                if (s10.f18062b != null) {
                    FetchProfile fetchProfile = new FetchProfile();
                    fetchProfile.add(s10.f18062b);
                    this.f18049a.g(new f[]{i10}, fetchProfile, dVar);
                    c0178a.a(dVar.b());
                }
            }
            g();
            return true;
        } catch (MessagingException e10) {
            C1.a.b("ImapHelper", "fetchTranscription Messaging Exception " + e10);
            return false;
        } finally {
            g();
        }
    }

    public final v1.c y(f fVar) {
        C1.a.a("ImapHelper", "Fetching message body for ");
        a aVar = new a();
        FetchProfile fetchProfile = new FetchProfile();
        fetchProfile.add(FetchProfile.Item.BODY);
        this.f18049a.g(new f[]{fVar}, fetchProfile, aVar);
        return aVar.b();
    }

    public ImapHelper(Context context, com.android.contacts.voicemail.impl.b bVar, PhoneAccountHandle phoneAccountHandle, Network network, c.b bVar2) {
        int i10;
        int i11;
        this.f18051c = context;
        this.f18052d = phoneAccountHandle;
        this.f18053e = network;
        this.f18054f = bVar2;
        this.f18056h = bVar;
        this.f18055g = new D1.c(context, phoneAccountHandle);
        try {
            j.b(context);
            String h10 = this.f18055g.h("u", null);
            String h11 = this.f18055g.h("pw", null);
            String h12 = this.f18055g.h("srv", null);
            int parseInt = Integer.parseInt(this.f18055g.g("ipt"));
            int m10 = bVar.m();
            if (m10 != 0) {
                i11 = m10;
                i10 = 1;
            } else {
                i10 = 0;
                i11 = parseInt;
            }
            this.f18050b = new ImapStore(context, this, h10, h11, i11, h12, i10, network);
        } catch (NumberFormatException e10) {
            U(OmtpEvents.DATA_INVALID_PORT);
            C1.a.f("ImapHelper", "Could not parse port number");
            throw new InitializingException("cannot initialize ImapHelper:" + e10.toString());
        }
    }
}
