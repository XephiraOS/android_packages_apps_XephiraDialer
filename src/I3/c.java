package I3;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.model.Account;
import com.oplus.media.OplusRecorder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ContactsDbUtils.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f1312a = {"data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14", "data15"};

    public static void a(b bVar, Account account, ArrayList<ContentProviderOperation> arrayList) {
        int i10;
        if (bVar == null) {
            return;
        }
        if (bVar.g() != 0) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.RawContacts.CONTENT_URI));
        newInsert.withValue("starred", Integer.valueOf(i10));
        if (M3.c.t(account)) {
            newInsert.withValue("aggregation_needed", 0);
            newInsert.withValue("aggregation_mode", 3);
        }
        newInsert.withValue("account_name", account.f16941a);
        newInsert.withValue("account_type", account.f16942b);
        arrayList.add(newInsert.build());
        int size = arrayList.size() - 1;
        HashMap<String, ArrayList<a>> c10 = bVar.c();
        Set<String> keySet = c10.keySet();
        int size2 = keySet.size();
        String[] strArr = new String[size2];
        Iterator<String> it = keySet.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            strArr[i11] = it.next();
            i11++;
        }
        for (int i12 = 0; i12 != size2; i12++) {
            String str = strArr[i12];
            b(str, c10.get(str), arrayList, size);
        }
    }

    public static void b(String str, ArrayList<a> arrayList, ArrayList<ContentProviderOperation> arrayList2, int i10) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i11 = 0; i11 != size; i11++) {
                a aVar = arrayList.get(i11);
                String[] b10 = aVar.b();
                if (c(b10)) {
                    ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
                    newInsert.withValueBackReference("raw_contact_id", i10);
                    newInsert.withValue("mimetype", str);
                    newInsert.withValue("is_primary", Integer.valueOf(aVar.c() ? 1 : 0));
                    newInsert.withValue("is_super_primary", Integer.valueOf(aVar.d() ? 1 : 0));
                    for (int i12 = 0; i12 != b10.length; i12++) {
                        if (!TextUtils.isEmpty(b10[i12])) {
                            newInsert.withValue(f1312a[i12], l(b10[i12], str, i12 + 1));
                        }
                    }
                    arrayList2.add(newInsert.build());
                }
            }
        }
    }

    public static boolean c(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        for (int i10 = 0; i10 != strArr.length; i10++) {
            if (!TextUtils.isEmpty(strArr[i10])) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(Context context, ArrayList<ContentProviderOperation> arrayList) {
        try {
            context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            return true;
        } catch (OperationApplicationException | RemoteException | Exception unused) {
            return false;
        }
    }

    public static Uri e(Uri uri, String str, String str2, boolean z10, String str3) {
        Uri.Builder buildUpon = uri.buildUpon();
        if (!TextUtils.isEmpty(str)) {
            buildUpon.appendQueryParameter("account_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            buildUpon.appendQueryParameter("account_type", str2);
        }
        if (z10) {
            buildUpon.appendQueryParameter("caller_is_syncadapter", "true");
        }
        if (!TextUtils.isEmpty(str3)) {
            buildUpon.appendQueryParameter("delete_reason", str3);
        }
        return buildUpon.build();
    }

    public static boolean f(Account account) {
        if (account == null) {
            return true;
        }
        if (!TextUtils.isEmpty(account.f16941a) && !TextUtils.isEmpty(account.f16942b)) {
            return true;
        }
        return false;
    }

    public static boolean g(Context context, b bVar, Account account, int[] iArr) {
        if (!f(account)) {
            return false;
        }
        boolean i10 = i(context, bVar, account, iArr);
        if (i10 && iArr.length >= 2) {
            iArr[1] = iArr[1] + 1;
        }
        return i10;
    }

    public static boolean h(Context context, b bVar, Account account) {
        ArrayList arrayList = new ArrayList();
        a(bVar, account, arrayList);
        return d(context, arrayList);
    }

    public static boolean i(Context context, b bVar, Account account, int[] iArr) {
        int i10;
        boolean h10 = h(context, bVar, account);
        if (h10) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        iArr[0] = i10;
        return h10;
    }

    public static boolean j(Context context, ArrayList<b> arrayList, Account account) {
        if (arrayList.isEmpty()) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i10 = 0; i10 != size; i10++) {
            b bVar = arrayList.get(i10);
            if (bVar != null) {
                a(bVar, account, arrayList2);
            }
            if (arrayList2.size() > 420) {
                if (!d(context, arrayList2)) {
                    return false;
                }
                arrayList2.clear();
            }
        }
        return d(context, arrayList2);
    }

    public static String k(String str, int i10) {
        if (str != null && str.length() > i10) {
            return str.substring(0, i10);
        }
        return str;
    }

    public static String l(String str, String str2, int i10) {
        int i11;
        int i12 = 1000;
        if ("vnd.android.cursor.item/name".equals(str2)) {
            if (i10 != 1) {
                i12 = 200;
            }
            return k(str, i12);
        }
        if ("vnd.android.cursor.item/postal-address_v2".equals(str2)) {
            if (i10 == 1) {
                i11 = OplusRecorder.NAMR_BYTES_P_SEC;
            } else {
                i11 = 100;
            }
            return k(str, i11);
        }
        if ("vnd.android.cursor.item/phone_v2".equals(str2)) {
            return k(str, 990);
        }
        return k(str, 1000);
    }
}
