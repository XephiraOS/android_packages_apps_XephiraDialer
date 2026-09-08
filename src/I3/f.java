package I3;

import I3.d;
import android.content.Context;
import android.text.TextUtils;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: CsvImporterForSmart2.java */
/* loaded from: classes3.dex */
public class f extends d {

    /* renamed from: n, reason: collision with root package name */
    public static final d.a[] f1332n = {new d.a("vnd.android.cursor.item/name", -1, 0, 1), new d.a("vnd.android.cursor.item/name", -1, 2, 2), new d.a("vnd.android.cursor.item/name", -1, 1, 3), new d.a("vnd.android.cursor.item/name", -1, 4, 4), new d.a("vnd.android.cursor.item/name", -1, 3, 5), new d.a("vnd.android.cursor.item/name", -1, 5, -1), new d.a("vnd.android.cursor.item/nickname", 1), new d.a("vnd.android.cursor.item/organization", 1, 0, 8), new d.a("vnd.android.cursor.item/organization", 1, 4, 9), new d.a("vnd.android.cursor.item/organization", 1, 3, -1), new d.a("vnd.android.cursor.item/phone_v2", -1, 0, 11), new d.a("vnd.android.cursor.item/phone_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/phone_v2", -1, 0, 13), new d.a("vnd.android.cursor.item/phone_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/phone_v2", -1, 0, 15), new d.a("vnd.android.cursor.item/phone_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/phone_v2", -1, 0, 17), new d.a("vnd.android.cursor.item/phone_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/phone_v2", -1, 0, 19), new d.a("vnd.android.cursor.item/phone_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/email_v2", -1, 0, 21), new d.a("vnd.android.cursor.item/email_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/email_v2", -1, 0, 23), new d.a("vnd.android.cursor.item/email_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/email_v2", -1, 0, 25), new d.a("vnd.android.cursor.item/email_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/website", -1, 0, 27), new d.a("vnd.android.cursor.item/website", -1, 1, -1), new d.a("vnd.android.cursor.item/website", -1, 0, 29), new d.a("vnd.android.cursor.item/website", -1, 1, -1), new d.a("vnd.android.cursor.item/website", -1, 0, 31), new d.a("vnd.android.cursor.item/website", -1, 1, -1), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 3, 33), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 6, 34), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 7, 35), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 8, 36), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 4, 37), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 9, 38), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 3, 40), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 6, 41), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 7, 42), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 8, 43), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 4, 44), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 9, 45), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 3, 47), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 6, 48), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 7, 49), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 8, 50), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 4, 51), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 9, 52), new d.a("vnd.android.cursor.item/postal-address_v2", -1, 1, -1), new d.a("vnd.android.cursor.item/im", -1, 0, 54), new d.a("vnd.android.cursor.item/im", -1, 4, -1), new d.a("vnd.android.cursor.item/im", -1, 0, 56), new d.a("vnd.android.cursor.item/im", -1, 4, -1), new d.a("vnd.android.cursor.item/im", -1, 0, 58), new d.a("vnd.android.cursor.item/im", -1, 4, -1), new d.a("vnd.android.cursor.item/contact_event", -1, 0, 60), new d.a("vnd.android.cursor.item/contact_event", -1, 1, -1), new d.a("vnd.android.cursor.item/contact_event", -1, 0, 62), new d.a("vnd.android.cursor.item/contact_event", -1, 1, -1), new d.a("vnd.android.cursor.item/note", -1), new d.a("vnd.android.cursor.item/group_membership", -1), new d.a(null, -1), new d.a(null, -1)};

    public f(Context context) {
        super(context);
        this.f1314b = true;
        if (H7.a.b()) {
            H7.b.b("CsvImporter", "Build CsvImporterForSmart2.");
        }
    }

    public static String[] C(String str) {
        int i10;
        String[] strArr = new String[2];
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            int indexOf = str.indexOf("[");
            int indexOf2 = str.indexOf("]");
            if (indexOf != -1 && indexOf2 != -1 && indexOf2 > (i10 = indexOf + 1)) {
                strArr[0] = str.substring(i10, indexOf2);
                int i11 = indexOf2 + 1;
                if (length > i11) {
                    strArr[1] = str.substring(i11);
                }
            }
        } else {
            strArr[0] = "7";
        }
        return strArr;
    }

    @Override // I3.d
    public void f(b bVar, String[] strArr) {
        super.f(bVar, strArr);
        int i10 = 0;
        if (strArr.length >= 1) {
            if (H7.a.b()) {
                H7.b.b("CsvImporter", "Set the diaplay name null.");
            }
            strArr[0] = null;
        }
        if (strArr.length >= 67) {
            String str = strArr[65];
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (Integer.parseInt(str) != 0) {
                        i10 = 1;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            bVar.n(i10);
            String str2 = strArr[64];
            if (!TextUtils.isEmpty(str2)) {
                x(bVar, str2);
            }
            strArr[64] = null;
        }
    }

    @Override // I3.d
    public String g(d.a aVar, String str) {
        int i10 = aVar.f1329d;
        String str2 = aVar.f1326a;
        if (i10 == 1 && !"vnd.android.cursor.item/name".equals(str2)) {
            String[] C10 = C(str);
            String str3 = C10[0];
            aVar.a(C10[1]);
            return str3;
        }
        return str;
    }

    @Override // I3.d
    public d.a[] r() {
        return f1332n;
    }

    @Override // I3.d
    public boolean w(String[] strArr) {
        if (b(strArr) && strArr != null && strArr.length >= 67) {
            return OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(strArr[66]);
        }
        return false;
    }
}
