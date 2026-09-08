package R3;

import R3.b;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.EntityIterator;
import android.net.Uri;
import android.os.CancellationSignal;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.core.os.OperationCanceledException;
import com.android.contacts.ContactLoader;
import com.android.contacts.framework.vcard.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: VcardMecardUtil.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public List<String> f3337a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public List<String> f3338b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public List<String> f3339c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public List<String> f3340d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public List<String> f3341e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public List<String> f3342f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public List<String> f3343g = new ArrayList();

    /* compiled from: VcardMecardUtil.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f3344a;

        /* renamed from: b, reason: collision with root package name */
        public long f3345b;

        public a(String str, long j10) {
            this.f3344a = str;
            this.f3345b = j10;
        }
    }

    public static void c(List<String> list) {
        if (list != null) {
            list.clear();
        }
    }

    public static void e(com.android.contacts.framework.vcard.c cVar, List<ContentValues> list, List<String> list2) {
        c.a T10;
        if (list != null) {
            for (ContentValues contentValues : list) {
                if (cVar == null || (T10 = cVar.T(contentValues)) == null) {
                    return;
                }
                String str = T10.f16500c;
                String asString = contentValues.getAsString("data1");
                if (!TextUtils.isEmpty(asString)) {
                    str = asString;
                }
                if (str != null) {
                    str = str.replaceAll(";+", "").trim();
                }
                if (!TextUtils.isEmpty(str) && !list2.contains(str)) {
                    list2.add(str);
                }
            }
        }
    }

    public static void f(List<ContentValues> list, List<String> list2, String str) {
        if (list != null) {
            for (ContentValues contentValues : list) {
                String asString = contentValues.getAsString(str);
                String asString2 = contentValues.getAsString("data2");
                String asString3 = contentValues.getAsString("data3");
                if (asString != null) {
                    asString = asString.trim();
                }
                if (!TextUtils.isEmpty(asString)) {
                    String str2 = asString + "<-&&&&&&&&&&->" + asString2 + "<-&&&&&&&&&&->" + asString3;
                    if (!list2.contains(str2)) {
                        list2.add(str2);
                    }
                }
            }
        }
    }

    public static void g(List<ContentValues> list, List<String> list2, String str) {
        if (list != null) {
            Iterator<ContentValues> it = list.iterator();
            while (it.hasNext()) {
                String asString = it.next().getAsString(str);
                if (asString != null) {
                    asString = asString.trim();
                }
                if (!TextUtils.isEmpty(asString) && !list2.contains(asString)) {
                    list2.add(asString);
                }
            }
        }
    }

    public static void h(List<ContentValues> list, List<String> list2, List<String> list3, ContactLoader.Result result) {
        ArrayList<ContentValues> s10;
        if (list != null) {
            for (ContentValues contentValues : list) {
                String asString = contentValues.getAsString("data1");
                if (asString != null) {
                    asString = asString.trim();
                }
                String asString2 = contentValues.getAsString("data4");
                if (asString2 != null) {
                    asString2 = asString2.trim();
                }
                if (!TextUtils.isEmpty(asString)) {
                    list2.add(asString);
                }
                if (!TextUtils.isEmpty(asString2)) {
                    list3.add(asString2);
                }
            }
            return;
        }
        if (result == null || (s10 = result.s()) == null) {
            return;
        }
        Iterator<ContentValues> it = s10.iterator();
        while (it.hasNext()) {
            ContentValues next = it.next();
            if ("vnd.android.cursor.item/organization".equals(next.getAsString("mimetype"))) {
                String asString3 = next.getAsString("data1");
                String asString4 = next.getAsString("data4");
                if (!TextUtils.isEmpty(asString3)) {
                    list2.add(asString3);
                }
                if (!TextUtils.isEmpty(asString4)) {
                    list3.add(asString4);
                }
            }
        }
    }

    public static void i(List<ContentValues> list, List<String> list2, String str) {
        if (list != null) {
            for (ContentValues contentValues : list) {
                String asString = contentValues.getAsString(str);
                String asString2 = contentValues.getAsString("data2");
                String asString3 = contentValues.getAsString("data3");
                if (asString != null) {
                    asString = asString.replaceAll("-+", "").trim();
                }
                if (!TextUtils.isEmpty(asString)) {
                    String str2 = asString + "<-&&&&&&&&&&->" + asString2 + "<-&&&&&&&&&&->" + asString3;
                    if (!list2.contains(str2)) {
                        list2.add(str2);
                    }
                }
            }
        }
    }

    public static void j(Map<String, List<ContentValues>> map, EntityIterator entityIterator, long j10, CancellationSignal cancellationSignal) {
        String asString;
        HashMap hashMap = new HashMap();
        while (entityIterator.hasNext() && !cancellationSignal.isCanceled()) {
            Iterator<Entity.NamedContentValues> it = ((Entity) entityIterator.next()).getSubValues().iterator();
            while (it.hasNext()) {
                ContentValues contentValues = it.next().values;
                if (contentValues == null) {
                    return;
                }
                if (!TextUtils.isEmpty(contentValues.getAsString("data1")) && (asString = contentValues.getAsString("mimetype")) != null) {
                    String asString2 = contentValues.getAsString("data1");
                    List<ContentValues> list = map.get(asString);
                    if (list == null) {
                        list = new ArrayList<>();
                        map.put(asString, list);
                        list.add(contentValues);
                    }
                    Set set = (Set) hashMap.get(asString);
                    if (set == null) {
                        set = new HashSet();
                        hashMap.put(asString, set);
                        set.add(asString2);
                    }
                    if (!set.contains(asString2)) {
                        list.add(contentValues);
                        set.add(asString2);
                    }
                }
            }
        }
    }

    public static Map<String, List<ContentValues>> k(Uri uri, Context context, a aVar, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        EntityIterator entityIterator = null;
        try {
            entityIterator = ContactsContract.RawContacts.newEntityIterator(context.getContentResolver().query(uri, null, "contact_id=?", new String[]{String.valueOf(aVar.f3345b)}, null, cancellationSignal));
            j(hashMap, entityIterator, aVar.f3345b, cancellationSignal);
            if (entityIterator != null) {
                entityIterator.close();
            }
        } catch (OperationCanceledException unused) {
            if (entityIterator != null) {
                entityIterator.close();
            }
        } catch (Throwable unused2) {
            if (entityIterator != null) {
                entityIterator.close();
            }
        }
        return hashMap;
    }

    public final String a(Map<String, List<ContentValues>> map, CancellationSignal cancellationSignal, ContactLoader.Result result) {
        String str;
        String str2;
        String str3 = "";
        if (map == null || cancellationSignal.isCanceled()) {
            return "";
        }
        com.android.contacts.framework.vcard.c cVar = new com.android.contacts.framework.vcard.c(null, -1073741823, "UTF-8");
        List<ContentValues> list = map.get("vnd.android.cursor.item/name");
        List<ContentValues> list2 = map.get("vnd.android.cursor.item/phone_v2");
        List<ContentValues> list3 = map.get("vnd.android.cursor.item/email_v2");
        List<ContentValues> list4 = map.get("vnd.android.cursor.item/postal-address_v2");
        List<ContentValues> list5 = map.get("vnd.android.cursor.item/organization");
        List<ContentValues> list6 = map.get("vnd.android.cursor.item/website");
        g(list, this.f3337a, "data1");
        i(list2, this.f3338b, "data1");
        f(list3, this.f3339c, "data1");
        g(list6, this.f3343g, "data1");
        e(cVar, list4, this.f3340d);
        h(list5, this.f3341e, this.f3342f, result);
        b.a e10 = b.e();
        if (this.f3337a.size() <= 0) {
            str = "";
        } else {
            str = this.f3337a.get(0);
        }
        b.a a10 = e10.h(str).d(this.f3338b, 5).b(this.f3339c, 3).e(this.f3343g, 1).a(this.f3340d, 1);
        if (this.f3341e.size() <= 0) {
            str2 = "";
        } else {
            str2 = this.f3341e.get(0);
        }
        b.a i10 = a10.i(str2);
        if (this.f3342f.size() > 0) {
            str3 = this.f3342f.get(0);
        }
        return i10.j(str3).f().d();
    }

    public void b() {
        H7.b.b("VcardMecardUtil", "clearList");
        c(this.f3337a);
        c(this.f3338b);
        c(this.f3339c);
        c(this.f3340d);
        c(this.f3341e);
        c(this.f3342f);
        c(this.f3343g);
    }

    public String d(Uri uri, Context context, a aVar, ContactLoader.Result result) {
        CancellationSignal cancellationSignal = new CancellationSignal();
        return a(k(uri, context, aVar, cancellationSignal), cancellationSignal, result);
    }
}
