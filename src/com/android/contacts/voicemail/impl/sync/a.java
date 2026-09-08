package com.android.contacts.voicemail.impl.sync;

import H7.b;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.android.contacts.voicemail.impl.ActivationTask;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.Voicemail;
import com.android.contacts.voicemail.impl.c;
import com.android.contacts.voicemail.impl.imap.ImapHelper;
import com.android.contacts.voicemail.impl.mail.store.b;
import com.android.contacts.voicemail.impl.scheduling.BaseTask;
import com.android.contacts.voicemail.impl.sync.VvmNetworkRequest;
import java.util.List;
import java.util.Map;
import s1.C1523a;
import t1.C1580a;
import u1.C1602a;

/* compiled from: OmtpVvmSyncService.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f18202c = "a";

    /* renamed from: a, reason: collision with root package name */
    public final Context f18203a;

    /* renamed from: b, reason: collision with root package name */
    public B1.a f18204b;

    /* compiled from: OmtpVvmSyncService.java */
    /* renamed from: com.android.contacts.voicemail.impl.sync.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0178a {

        /* renamed from: a, reason: collision with root package name */
        public Context f18205a;

        /* renamed from: b, reason: collision with root package name */
        public Voicemail f18206b;

        public C0178a(Context context, Voicemail voicemail) {
            this.f18205a = context;
            this.f18206b = voicemail;
        }

        public void a(String str) {
            new B1.a(this.f18205a).n(this.f18206b, str);
        }
    }

    public a(Context context) {
        this.f18203a = context;
        this.f18204b = new B1.a(context);
    }

    public static boolean f(Context context, PhoneAccountHandle phoneAccountHandle) {
        if (!C1523a.b(context.getApplicationContext()).c(context)) {
            b.e("isArchiveAllowedAndEnabled", "voicemail archive is not available");
            return false;
        }
        if (!C1.b.a(context, phoneAccountHandle)) {
            b.e("isArchiveAllowedAndEnabled", "voicemail archive is turned off");
            return false;
        }
        if (!C1.b.c(context, phoneAccountHandle)) {
            b.e("isArchiveAllowedAndEnabled", "voicemail is turned off");
            return false;
        }
        return true;
    }

    public final void a(ImapHelper imapHelper, PhoneAccountHandle phoneAccountHandle) {
        if (!f(this.f18203a, phoneAccountHandle)) {
            b.e(f18202c, "autoDeleteAndArchiveVM is turned off");
            return;
        }
        b.C0177b S10 = imapHelper.S();
        if (S10 == null) {
            H7.b.c(f18202c, "autoDeleteAndArchiveVM failed - Can't retrieve Imap quota.");
        } else if (S10.f18124a / S10.f18125b > 0.75f) {
            c(imapHelper, S10);
            imapHelper.g0();
        } else {
            H7.b.e(f18202c, "no need to archive and auto delete VM, quota below threshold");
        }
    }

    public final Map<String, Voicemail> b(List<Voicemail> list) {
        ArrayMap arrayMap = new ArrayMap();
        for (Voicemail voicemail : list) {
            arrayMap.put(voicemail.k(), voicemail);
        }
        return arrayMap;
    }

    public final void c(ImapHelper imapHelper, b.C0177b c0177b) {
        C1580a.e(true);
        int i10 = c0177b.f18124a - ((int) (c0177b.f18125b * 0.75f));
        List<Voicemail> m10 = this.f18204b.m(i10);
        String str = f18202c;
        H7.b.i(str, "number of voicemails to delete " + i10);
        if (!m10.isEmpty()) {
            this.f18204b.i(m10);
            imapHelper.X(m10);
            H7.b.e(str, String.format("successfully archived and deleted %d voicemails", Integer.valueOf(m10.size())));
            return;
        }
        H7.b.i(str, "remote voicemail server is empty");
    }

    public final void d(BaseTask baseTask, Network network, PhoneAccountHandle phoneAccountHandle, Voicemail voicemail, String str, c.b bVar) {
        boolean k10;
        try {
            ImapHelper imapHelper = new ImapHelper(this.f18203a, phoneAccountHandle, network, bVar);
            try {
                if (voicemail == null) {
                    k10 = j(str, imapHelper, phoneAccountHandle);
                } else {
                    k10 = k(imapHelper, voicemail, phoneAccountHandle);
                }
                if (k10) {
                    imapHelper.g0();
                    a(imapHelper, phoneAccountHandle);
                    imapHelper.U(OmtpEvents.DATA_IMAP_OPERATION_COMPLETED);
                } else {
                    baseTask.j();
                }
                imapHelper.close();
            } finally {
            }
        } catch (ImapHelper.InitializingException e10) {
            H7.b.i(f18202c, "Can't retrieve Imap credentials." + e10);
        }
    }

    public final boolean e(ImapHelper imapHelper, PhoneAccountHandle phoneAccountHandle) {
        List<Voicemail> r10 = imapHelper.r();
        List<Voicemail> c10 = this.f18204b.c(phoneAccountHandle);
        if (c10 == null || r10 == null) {
            return false;
        }
        Map<String, Voicemail> b10 = b(r10);
        for (int i10 = 0; i10 < c10.size(); i10++) {
            Voicemail voicemail = c10.get(i10);
            Voicemail remove = b10.remove(voicemail.k());
            if (remove == null) {
                this.f18204b.b(voicemail);
            } else {
                if (remove.t() && !voicemail.t()) {
                    this.f18204b.l(voicemail);
                }
                if (!TextUtils.isEmpty(remove.p()) && TextUtils.isEmpty(voicemail.p())) {
                    this.f18204b.n(voicemail, remove.p());
                }
            }
        }
        boolean h10 = h(phoneAccountHandle, imapHelper);
        for (Voicemail voicemail2 : b10.values()) {
            Uri b11 = C1.c.b(this.f18203a, voicemail2);
            if (h10) {
                imapHelper.B(new C1602a(this.f18203a, b11, phoneAccountHandle), voicemail2.k());
            }
        }
        return true;
    }

    public final void g(BaseTask baseTask, PhoneAccountHandle phoneAccountHandle, Voicemail voicemail, String str, c.b bVar) {
        if (!C1.b.c(this.f18203a, phoneAccountHandle)) {
            H7.b.h(f18202c, "Sync requested for disabled account");
            return;
        }
        if (!B1.b.e(this.f18203a, phoneAccountHandle)) {
            ActivationTask.v(this.f18203a, phoneAccountHandle, null);
            return;
        }
        com.android.contacts.voicemail.impl.b bVar2 = new com.android.contacts.voicemail.impl.b(this.f18203a, phoneAccountHandle);
        bVar2.r(c.c(this.f18203a, phoneAccountHandle), OmtpEvents.DATA_IMAP_OPERATION_STARTED);
        try {
            VvmNetworkRequest.b a10 = VvmNetworkRequest.a(bVar2, phoneAccountHandle, bVar);
            try {
                if (a10 == null) {
                    H7.b.c(f18202c, "unable to acquire network");
                    baseTask.j();
                    if (a10 != null) {
                        a10.close();
                        return;
                    }
                    return;
                }
                d(baseTask, a10.a(), phoneAccountHandle, voicemail, str, bVar);
                a10.close();
            } finally {
            }
        } catch (VvmNetworkRequest.RequestFailedException unused) {
            bVar2.r(bVar, OmtpEvents.DATA_NO_CONNECTION_CELLULAR_REQUIRED);
            baseTask.j();
        }
    }

    public final boolean h(PhoneAccountHandle phoneAccountHandle, ImapHelper imapHelper) {
        if (new com.android.contacts.voicemail.impl.b(this.f18203a, phoneAccountHandle).v() && !imapHelper.V()) {
            return true;
        }
        return false;
    }

    public void i(BaseTask baseTask, String str, PhoneAccountHandle phoneAccountHandle, Voicemail voicemail, c.b bVar) {
        boolean z10;
        if (phoneAccountHandle != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        C1580a.e(z10);
        H7.b.h(f18202c, "Sync requested: " + str + " - for account: " + phoneAccountHandle);
        g(baseTask, phoneAccountHandle, voicemail, str, bVar);
    }

    public final boolean j(String str, ImapHelper imapHelper, PhoneAccountHandle phoneAccountHandle) {
        boolean l10;
        boolean e10;
        if (!"full_sync".equals(str) && !"upload_only".equals(str)) {
            l10 = true;
        } else {
            l10 = l(phoneAccountHandle, imapHelper);
        }
        if (!"full_sync".equals(str) && !"download_only".equals(str)) {
            e10 = true;
        } else {
            e10 = e(imapHelper, phoneAccountHandle);
        }
        H7.b.h(f18202c, "upload succeeded: [" + String.valueOf(l10) + "] download succeeded: [" + String.valueOf(e10) + "]");
        if (l10 && e10) {
            return true;
        }
        return false;
    }

    public final boolean k(ImapHelper imapHelper, Voicemail voicemail, PhoneAccountHandle phoneAccountHandle) {
        if (h(phoneAccountHandle, imapHelper)) {
            imapHelper.B(new C1602a(this.f18203a, voicemail.q(), phoneAccountHandle), voicemail.k());
        }
        return imapHelper.u(new C0178a(this.f18203a, voicemail), voicemail.k());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(android.telecom.PhoneAccountHandle r5, com.android.contacts.voicemail.impl.imap.ImapHelper r6) {
        /*
            r4 = this;
            B1.a r0 = r4.f18204b
            java.util.List r0 = r0.f(r5)
            B1.a r1 = r4.f18204b
            java.util.List r5 = r1.d(r5)
            r1 = 0
            if (r5 == 0) goto L23
            int r2 = r5.size()
            if (r2 <= 0) goto L23
            boolean r2 = r6.X(r5)
            if (r2 == 0) goto L21
            B1.a r2 = r4.f18204b
            r2.a(r5)
            goto L23
        L21:
            r5 = r1
            goto L24
        L23:
            r5 = 1
        L24:
            if (r0 == 0) goto L43
            int r2 = r0.size()
            if (r2 <= 0) goto L43
            java.lang.String r2 = com.android.contacts.voicemail.impl.sync.a.f18202c
            java.lang.String r3 = "Marking voicemails as read"
            H7.b.e(r2, r3)
            boolean r6 = r6.Z(r0)
            if (r6 == 0) goto L44
            java.lang.String r6 = "Marking voicemails as clean"
            H7.b.e(r2, r6)
            B1.a r4 = r4.f18204b
            r4.j(r0)
        L43:
            r1 = r5
        L44:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.voicemail.impl.sync.a.l(android.telecom.PhoneAccountHandle, com.android.contacts.voicemail.impl.imap.ImapHelper):boolean");
    }
}
