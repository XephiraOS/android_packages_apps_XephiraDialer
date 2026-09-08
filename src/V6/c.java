package V6;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0847h;
import com.oplus.utils.C0848i;
import com.oplus.utils.X;

/* compiled from: ContactInfoHelper.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4039a;

    public c(Context context) {
        this.f4039a = context;
    }

    public static boolean d(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            return false;
        }
        return true;
    }

    public final a a(String str, String str2) {
        Uri j10 = C0848i.j(this.f4039a, str);
        if (!TextUtils.isEmpty(str2)) {
            j10 = Uri.withAppendedPath(j10, str2);
        }
        if (C0846g.c()) {
            Log.d("ContactInfoHelper", "queryContactInfoForPhoneNumber, the uri is " + C0846g.h(j10));
        }
        a b10 = b(j10);
        if (b10 != null && b10 != a.f4009q) {
            b10.f4014e = str;
        }
        return b10;
    }

    public final a b(Uri uri) {
        a aVar;
        Exception e10;
        Cursor cursor;
        Cursor cursor2 = null;
        r0 = null;
        a aVar2 = null;
        try {
            cursor = this.f4039a.getContentResolver().query(uri, C0847h.b.f29147a, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            aVar = new a();
                            try {
                                long j10 = cursor.getLong(0);
                                aVar.f4011b = ContactsContract.Contacts.getLookupUri(j10, cursor.getString(7));
                                aVar.f4012c = cursor.getString(1);
                                aVar.f4013d = cursor.getString(4);
                                aVar.f4015f = cursor.getString(5);
                                aVar.f4017h = cursor.getLong(6);
                                aVar.f4018i = X.c(cursor.getString(8));
                                aVar.f4010a = j10;
                                aVar.f4014e = null;
                                aVar2 = aVar;
                            } catch (Exception e11) {
                                e10 = e11;
                                Log.w("ContactInfoHelper", "Exception: " + e10);
                                I9.a.a(cursor);
                                return aVar;
                            }
                        } else {
                            aVar2 = a.f4009q;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        I9.a.a(cursor2);
                        throw th;
                    }
                } catch (Exception e12) {
                    a aVar3 = aVar2;
                    e10 = e12;
                    aVar = aVar3;
                }
            }
            I9.a.a(cursor);
            return aVar2;
        } catch (Exception e13) {
            aVar = null;
            e10 = e13;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public a c(String str, String str2) {
        if (d(str)) {
            Log.e("ContactInfoHelper", "the number is null");
            return null;
        }
        a a10 = a(str, str2);
        if ((a10 == null || a10 == a.f4009q) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a10 = a(str, null);
        }
        if (a10 == null) {
            return null;
        }
        if (a10 == a.f4009q) {
            a aVar = new a();
            aVar.f4013d = str;
            aVar.f4014e = str;
            return aVar;
        }
        return a10;
    }
}
