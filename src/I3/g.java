package I3;

import I3.d;
import android.content.Context;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: CsvImporterForSmart.java */
/* loaded from: classes3.dex */
public class g extends d {

    /* renamed from: n, reason: collision with root package name */
    public static final d.a[] f1333n = {new d.a("vnd.android.cursor.item/name", -1, 2, 1), new d.a("vnd.android.cursor.item/name", -1, 1, 2), new d.a("vnd.android.cursor.item/name", -1, 3, 3), new d.a("vnd.android.cursor.item/name", -1, 4, 4), new d.a("vnd.android.cursor.item/name", -1, 5, -1), new d.a("vnd.android.cursor.item/nickname", 1), new d.a("vnd.android.cursor.item/organization", 1, 0, 7), new d.a("vnd.android.cursor.item/organization", 1, 4, 8), new d.a("vnd.android.cursor.item/organization", 1, 3, -1), new d.a("vnd.android.cursor.item/phone_v2", -1, 0, 10), new d.a("vnd.android.cursor.item/phone_v2", -1, 1, 11), new d.a("vnd.android.cursor.item/phone_v2", -1, 2, -1), new d.a("vnd.android.cursor.item/phone_v2", -1, 0, 13), new d.a("vnd.android.cursor.item/phone_v2", -1, 1, 14), new d.a("vnd.android.cursor.item/phone_v2", -1, 2, -1), new d.a("vnd.android.cursor.item/phone_v2", -1, 0, 16), new d.a("vnd.android.cursor.item/phone_v2", -1, 1, 17), new d.a("vnd.android.cursor.item/phone_v2", -1, 2, -1), new d.a("vnd.android.cursor.item/email_v2", -1, 0, 19), new d.a("vnd.android.cursor.item/email_v2", -1, 1, 20), new d.a("vnd.android.cursor.item/email_v2", -1, 2, -1), new d.a("vnd.android.cursor.item/email_v2", -1, 0, 22), new d.a("vnd.android.cursor.item/email_v2", -1, 1, 23), new d.a("vnd.android.cursor.item/email_v2", -1, 2, -1), new d.a("vnd.android.cursor.item/email_v2", -1, 0, 25), new d.a("vnd.android.cursor.item/email_v2", -1, 1, 26), new d.a("vnd.android.cursor.item/email_v2", -1, 2, -1), new d.a("vnd.android.cursor.item/website", -1, 0, 28), new d.a("vnd.android.cursor.item/website", -1, 1, 29), new d.a("vnd.android.cursor.item/website", -1, 2, -1), new d.a("vnd.android.cursor.item/website", -1, 0, 31), new d.a("vnd.android.cursor.item/website", -1, 1, 32), new d.a("vnd.android.cursor.item/website", -1, 2, -1), new d.a("vnd.android.cursor.item/website", -1, 0, 34), new d.a("vnd.android.cursor.item/website", -1, 1, 35), new d.a("vnd.android.cursor.item/website", -1, 2, -1), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 3, 37), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 6, 38), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 7, 39), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 8, 40), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 4, 41), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 9, 42), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 1, 43), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 2, -1), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 3, 45), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 6, 46), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 7, 47), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 8, 48), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 4, 49), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 9, 50), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 1, 51), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 2, -1), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 3, 53), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 6, 54), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 7, 55), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 8, 56), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 4, 57), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 9, 58), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 1, 59), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 2, -1), new d.a("vnd.android.cursor.item/im", -1, 0, 61), new d.a("vnd.android.cursor.item/im", -1, 1, 62), new d.a("vnd.android.cursor.item/im", -1, 4, -1), new d.a("vnd.android.cursor.item/im", -1, 0, 64), new d.a("vnd.android.cursor.item/im", -1, 1, 65), new d.a("vnd.android.cursor.item/im", -1, 4, -1), new d.a("vnd.android.cursor.item/im", -1, 0, 67), new d.a("vnd.android.cursor.item/im", -1, 1, 68), new d.a("vnd.android.cursor.item/im", -1, 4, -1), new d.a("vnd.android.cursor.item/contact_event", -1, 0, 70), new d.a("vnd.android.cursor.item/contact_event", -1, 1, 71), new d.a("vnd.android.cursor.item/contact_event", -1, 2, -1), new d.a("vnd.android.cursor.item/note", -1), new d.a("vnd.android.cursor.item/note", -1), new d.a("vnd.android.cursor.item/note", -1), new d.a("vnd.android.cursor.item/group_membership", -1), new d.a("vnd.android.cursor.item/group_membership", -1), new d.a("vnd.android.cursor.item/group_membership", -1), new d.a(null, -1), new d.a(null, -1)};

    public g(Context context) {
        super(context);
        if (H7.a.b()) {
            H7.b.b("CsvImporter", "Build CsvImporterForSmart.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // I3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(I3.b r6, java.lang.String[] r7) {
        /*
            r5 = this;
            super.f(r6, r7)
            int r0 = r7.length
            r1 = 80
            if (r0 < r1) goto L39
            r0 = 78
            r1 = r7[r0]
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L1a
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L1a
            if (r1 == 0) goto L1a
            r1 = 1
            goto L1b
        L1a:
            r1 = 0
        L1b:
            r6.n(r1)
            r6 = 75
        L20:
            if (r6 == r0) goto L39
            r1 = r7[r6]
            long r1 = r5.p(r1)
            r3 = -1
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L33
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L34
        L33:
            r1 = 0
        L34:
            r7[r6] = r1
            int r6 = r6 + 1
            goto L20
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: I3.g.f(I3.b, java.lang.String[]):void");
    }

    @Override // I3.d
    public d.a[] r() {
        return f1333n;
    }

    @Override // I3.d
    public boolean w(String[] strArr) {
        if (b(strArr) && strArr != null && strArr.length >= 80) {
            return OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(strArr[79]);
        }
        return false;
    }
}
