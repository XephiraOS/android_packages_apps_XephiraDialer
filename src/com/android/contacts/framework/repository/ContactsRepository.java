package com.android.contacts.framework.repository;

import R0.d;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import com.oplus.foundation.util.io.b;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.jvm.internal.i;
import m9.q;
import p9.C1467a;
import v9.l;

/* compiled from: ContactsRepository.kt */
/* loaded from: classes.dex */
public final class ContactsRepository {

    /* renamed from: a, reason: collision with root package name */
    public static final ContactsRepository f16324a = new ContactsRepository();

    /* compiled from: ContactsRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f16325a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f16326b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<String> f16327c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList<String> f16328d;

        public a(long j10, boolean z10, ArrayList<String> phoneList, ArrayList<String> emailList) {
            i.f(phoneList, "phoneList");
            i.f(emailList, "emailList");
            this.f16325a = j10;
            this.f16326b = z10;
            this.f16327c = phoneList;
            this.f16328d = emailList;
        }

        public final ArrayList<String> a() {
            return this.f16328d;
        }

        public final ArrayList<String> b() {
            return this.f16327c;
        }

        public final boolean c() {
            return this.f16326b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f16325a == aVar.f16325a && this.f16326b == aVar.f16326b && i.b(this.f16327c, aVar.f16327c) && i.b(this.f16328d, aVar.f16328d)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = Long.hashCode(this.f16325a) * 31;
            boolean z10 = this.f16326b;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            return ((((hashCode + i10) * 31) + this.f16327c.hashCode()) * 31) + this.f16328d.hashCode();
        }

        public String toString() {
            return "ContactPhoneEmailInfo(contactId=" + this.f16325a + ", isVip=" + this.f16326b + ", phoneList=" + this.f16327c + ", emailList=" + this.f16328d + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0304 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0139 A[Catch: all -> 0x0156, TryCatch #3 {all -> 0x0156, blocks: (B:43:0x0130, B:45:0x0139, B:49:0x01d0, B:52:0x0140, B:54:0x0146, B:55:0x015a, B:57:0x0160, B:58:0x016d, B:60:0x0173, B:64:0x017a, B:65:0x017f, B:66:0x0180, B:68:0x0186, B:69:0x0193, B:71:0x0199, B:72:0x01a6, B:74:0x01ac, B:76:0x01b2, B:78:0x01b7, B:79:0x01bc, B:80:0x01bd, B:82:0x01c3, B:83:0x01dc, B:87:0x026f, B:89:0x01e3, B:91:0x01e9, B:92:0x01f9, B:94:0x01ff, B:95:0x020c, B:97:0x0212, B:101:0x0219, B:102:0x021e, B:103:0x021f, B:105:0x0225, B:106:0x0232, B:108:0x0238, B:109:0x0245, B:111:0x024b, B:113:0x0251, B:115:0x0256, B:116:0x025b, B:117:0x025c, B:119:0x0262, B:169:0x0280), top: B:42:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01dc A[Catch: all -> 0x0156, TryCatch #3 {all -> 0x0156, blocks: (B:43:0x0130, B:45:0x0139, B:49:0x01d0, B:52:0x0140, B:54:0x0146, B:55:0x015a, B:57:0x0160, B:58:0x016d, B:60:0x0173, B:64:0x017a, B:65:0x017f, B:66:0x0180, B:68:0x0186, B:69:0x0193, B:71:0x0199, B:72:0x01a6, B:74:0x01ac, B:76:0x01b2, B:78:0x01b7, B:79:0x01bc, B:80:0x01bd, B:82:0x01c3, B:83:0x01dc, B:87:0x026f, B:89:0x01e3, B:91:0x01e9, B:92:0x01f9, B:94:0x01ff, B:95:0x020c, B:97:0x0212, B:101:0x0219, B:102:0x021e, B:103:0x021f, B:105:0x0225, B:106:0x0232, B:108:0x0238, B:109:0x0245, B:111:0x024b, B:113:0x0251, B:115:0x0256, B:116:0x025b, B:117:0x025c, B:119:0x0262, B:169:0x0280), top: B:42:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(android.content.Context r22, long r23, android.os.CancellationSignal r25, v9.l<? super com.android.contacts.framework.repository.ContactsRepository.a, m9.q> r26, kotlin.coroutines.c<? super m9.q> r27) {
        /*
            Method dump skipped, instructions count: 807
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.repository.ContactsRepository.a(android.content.Context, long, android.os.CancellationSignal, v9.l, kotlin.coroutines.c):java.lang.Object");
    }

    public static final Object b(Context context, long j10, CancellationSignal cancellationSignal, l<? super Boolean, q> lVar, c<? super q> cVar) {
        Object b10;
        boolean z10 = false;
        try {
            Result.a aVar = Result.f34166a;
            Cursor query = context.getContentResolver().query(d.f3217d, new String[]{"contact_id"}, "contact_id=?", new String[]{String.valueOf(j10)}, null, cancellationSignal);
            try {
                if (b.a(query) > 0) {
                    z10 = true;
                }
                q qVar = q.f35511a;
                kotlin.io.a.a(query, null);
                b10 = Result.b(q.f35511a);
            } finally {
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.i("ContactsRepository", "exception in query vip with contactId " + j10 + ". e:" + d10.getMessage());
        }
        if (cancellationSignal != null && !cancellationSignal.isCanceled()) {
            lVar.invoke(C1467a.a(z10));
        }
        return q.f35511a;
    }
}
