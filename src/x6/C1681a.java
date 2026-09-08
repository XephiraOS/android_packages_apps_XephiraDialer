package x6;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.oplus.blacklist.database.a;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.u;
import com.oplus.utils.C0846g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import v6.C1629c;

/* compiled from: PhoneNoInquireDataForCountryUtil.java */
/* renamed from: x6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1681a {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f38001a = a.b.f26236a;

    /* renamed from: b, reason: collision with root package name */
    public static CopyOnWriteArrayList<c> f38002b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public static CopyOnWriteArrayList<c> f38003c = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<String, Object> f38004d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public static HashMap<String, Boolean> f38005e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public static HashMap<String, Boolean> f38006f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public static HashMap<String, Boolean> f38007g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public static final Uri f38008h = Uri.parse("content://" + C1629c.f37421g + "/country_list/");

    /* renamed from: i, reason: collision with root package name */
    public static boolean f38009i = false;

    /* renamed from: j, reason: collision with root package name */
    public static int f38010j = -1;

    /* renamed from: k, reason: collision with root package name */
    public static PhoneNumberUtil f38011k;

    /* compiled from: PhoneNoInquireDataForCountryUtil.java */
    /* renamed from: x6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0379a implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            if (cVar.b() > cVar2.b()) {
                return 1;
            }
            return -1;
        }
    }

    /* compiled from: PhoneNoInquireDataForCountryUtil.java */
    /* renamed from: x6.a$b */
    /* loaded from: classes3.dex */
    public class b implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            if (C1681a.a().z(cVar.c()) > C1681a.a().z(cVar2.c())) {
                return 1;
            }
            return -1;
        }
    }

    /* compiled from: PhoneNoInquireDataForCountryUtil.java */
    /* renamed from: x6.a$c */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f38012a;

        /* renamed from: b, reason: collision with root package name */
        public String f38013b;

        /* renamed from: c, reason: collision with root package name */
        public String f38014c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f38015d = false;

        public static c a(c cVar) {
            c cVar2 = new c();
            cVar2.f38012a = cVar.f38012a;
            cVar2.f38014c = cVar.f38014c;
            cVar2.f38013b = cVar.f38013b;
            return cVar2;
        }

        public int b() {
            return Integer.parseInt(this.f38014c);
        }

        public String c() {
            return this.f38012a;
        }

        public String d() {
            return this.f38013b;
        }

        public boolean e() {
            return this.f38015d;
        }

        public void f(boolean z10) {
            this.f38015d = z10;
        }
    }

    /* compiled from: PhoneNoInquireDataForCountryUtil.java */
    /* renamed from: x6.a$d */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f38016a = {"-101"};

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f38017b = {"OTHERS"};

        /* renamed from: c, reason: collision with root package name */
        public static final int[] f38018c = {u.f27650l};

        /* renamed from: d, reason: collision with root package name */
        public static ArrayList<c> f38019d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public static ArrayList<c> f38020e = new ArrayList<>();

        public static void a(Context context, HashMap<String, Object> hashMap) {
            f38019d.clear();
            f38020e.clear();
            int i10 = 0;
            while (true) {
                String[] strArr = f38016a;
                if (i10 < strArr.length) {
                    c cVar = new c();
                    cVar.f38014c = strArr[i10];
                    cVar.f38012a = f38017b[i10];
                    cVar.f38013b = context.getString(f38018c[i10]);
                    f38020e.add(cVar);
                    if (hashMap.get(cVar.f38014c) != null) {
                        cVar.f38015d = true;
                        f38019d.add(c.a(cVar));
                    }
                    Boolean bool = C1681a.f38005e.get(cVar.f38012a);
                    if (bool != null) {
                        cVar.f38015d = bool.booleanValue();
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public static /* bridge */ /* synthetic */ PhoneNumberUtil a() {
        return j();
    }

    public static ContentProviderOperation b(String str) {
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(f38001a);
        newInsert.withValue("country_code", str);
        newInsert.withValue("slot_id", Integer.valueOf(f38010j));
        return newInsert.build();
    }

    public static void c() {
        f38007g.clear();
    }

    public static void d() {
        f38006f.clear();
    }

    public static void e() {
        f38005e.clear();
    }

    public static void f(Context context) {
        boolean z10;
        HashMap<String, Object> hashMap = f38004d;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        Iterator<c> it = f38003c.iterator();
        while (true) {
            boolean z11 = false;
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            String str = next.f38012a;
            if (str != null) {
                if (hashMap.get(str) == null) {
                    z11 = true;
                }
                boolean z12 = next.f38015d;
                if (z11 == z12) {
                    if (z12) {
                        arrayList2.add(next.f38012a);
                    } else {
                        arrayList.add(next.f38012a);
                        sb.append(",");
                        sb.append("?");
                    }
                }
            }
        }
        Iterator<c> it2 = d.f38020e.iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            String str2 = next2.f38012a;
            if (str2 != null) {
                if (hashMap.get(str2) == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z13 = next2.f38015d;
                if (z10 == z13) {
                    if (z13) {
                        arrayList2.add(next2.f38012a);
                    } else {
                        arrayList.add(next2.f38012a);
                        sb.append(",");
                        sb.append("?");
                    }
                }
            }
        }
        try {
            if (!arrayList.isEmpty()) {
                context.getContentResolver().delete(a.b.f26236a, "country_code IN (" + sb.substring(1) + ")", (String[]) arrayList.toArray(new String[0]));
            }
        } catch (Exception e10) {
            Log.e("PhoneNoInquireDataUtil", "" + e10);
        }
        if (arrayList2.size() > 0) {
            ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>(arrayList2.size());
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(b((String) it3.next()));
            }
            try {
                context.getContentResolver().applyBatch(com.oplus.blacklist.database.a.f26232a, arrayList3);
            } catch (OperationApplicationException e11) {
                Log.e("PhoneNoInquireDataUtil", "e = " + e11);
            } catch (RemoteException e12) {
                Log.e("PhoneNoInquireDataUtil", "e = " + e12);
            } catch (Throwable th) {
                Log.e("PhoneNoInquireDataUtil", "e = " + th);
            }
        }
    }

    public static void g(Context context) {
        try {
            l(context);
            f38009i = true;
        } catch (Exception e10) {
            Log.d("PhoneNoInquireDataUtil", "queryPhoneNoInquireData failed " + e10);
        }
    }

    public static HashMap<String, Object> h(Context context, int i10) {
        try {
            Cursor query = context.getContentResolver().query(f38001a, new String[]{"country_code"}, "slot_id ='" + i10 + "'", null, null);
            if (query == null) {
                return null;
            }
            int i11 = -1;
            query.moveToPosition(-1);
            HashMap<String, Object> hashMap = new HashMap<>();
            Object obj = new Object();
            while (query.moveToNext()) {
                hashMap.put(query.getString(query.getColumnIndex("country_code")), obj);
            }
            query.close();
            d.a(context, hashMap);
            f38004d = hashMap;
            HashSet hashSet = new HashSet();
            try {
                Cursor query2 = context.getContentResolver().query(f38008h, null, null, null, null);
                if (query2 != null) {
                    try {
                        i11 = query2.getCount();
                        while (query2.moveToNext()) {
                            hashSet.add(query2.getString(query2.getColumnIndex("country_iso")));
                        }
                    } finally {
                    }
                }
                if (query2 != null) {
                    query2.close();
                }
            } catch (Exception e10) {
                Log.e("PhoneNoInquireDataUtil", "querySavedArea: " + e10);
            }
            if (hashSet.size() > 0 && hashSet.size() == i11) {
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (!entry.getKey().equals("country_code") && !hashSet.contains(entry.getKey())) {
                        arrayList.add(entry.getKey());
                        sb.append(",");
                        sb.append("?");
                    }
                }
                try {
                    if (arrayList.size() > 0) {
                        context.getContentResolver().delete(a.b.f26236a, "country_code IN (" + sb.substring(1) + ")", (String[]) arrayList.toArray(new String[0]));
                    }
                } catch (Exception e11) {
                    Log.e("PhoneNoInquireDataUtil", "" + e11);
                }
            }
            return hashMap;
        } catch (Exception e12) {
            Log.e("PhoneNoInquireDataUtil", "e = " + e12);
            return null;
        }
    }

    public static void i() {
        Iterator<c> it = f38003c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && f38006f.get(next.f38012a) != null) {
                next.f38015d = true;
            }
        }
        Iterator<c> it2 = d.f38020e.iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null) {
                if (next2.f38012a.equals("OTHERS")) {
                    next2.f38015d = false;
                } else if (f38006f.get(next2.f38012a) != null) {
                    next2.f38015d = true;
                }
            }
        }
        f38006f.clear();
    }

    public static synchronized PhoneNumberUtil j() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (C1681a.class) {
            try {
                if (f38011k == null) {
                    f38011k = PhoneNumberUtil.C();
                }
                phoneNumberUtil = f38011k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return phoneNumberUtil;
    }

    public static int k(ArrayList<c> arrayList) {
        int i10 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().f38015d) {
                i10++;
            }
        }
        return i10;
    }

    public static void l(Context context) {
        StringBuilder sb;
        boolean z10;
        HashMap hashMap = new HashMap();
        C0379a c0379a = new C0379a();
        try {
            Cursor query = context.getContentResolver().query(f38008h, null, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        C0846g.i("PhoneNoInquireDataUtil", "queryPhoneNoInquireData cursor size:" + query.getCount());
                        f38003c.clear();
                        query.moveToPosition(-1);
                        while (query.moveToNext()) {
                            String string = query.getString(query.getColumnIndex("country_iso"));
                            String string2 = query.getString(query.getColumnIndex("country_code"));
                            if (BlackListAppUtil.f26245b) {
                                sb = new StringBuilder();
                                sb.append(string2);
                                sb.append("+");
                            } else {
                                sb = new StringBuilder();
                                sb.append("+");
                                sb.append(string2);
                            }
                            String sb2 = sb.toString();
                            String str = string + sb2;
                            c cVar = (c) hashMap.get(str);
                            if (cVar == null) {
                                cVar = new c();
                                z10 = false;
                            } else {
                                z10 = true;
                            }
                            cVar.f38012a = string;
                            cVar.f38014c = sb2;
                            cVar.f38013b = string + " (" + sb2 + ")";
                            if (!z10) {
                                hashMap.put(str, cVar);
                                f38003c.add(cVar);
                            }
                        }
                        C0846g.i("PhoneNoInquireDataUtil", "queryPhoneNoInquireData  sAllDatas size:" + f38003c.size());
                        if (query.getCount() > f38003c.size()) {
                            C0846g.i("PhoneNoInquireDataUtil", "cursor size is more than sAllDatas`s, need to check them");
                        }
                        query.close();
                        f38003c.sort(c0379a);
                        hashMap.clear();
                        return;
                    }
                } finally {
                }
            }
            m(context);
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            Log.e("PhoneNoInquireDataUtil", "queryPhoneNoInquireData: " + e10);
            m(context);
        }
    }

    public static void m(Context context) {
        boolean z10;
        C0846g.i("PhoneNoInquireDataUtil", "queryPhoneNoInquireDataFromGoogle");
        HashMap hashMap = new HashMap();
        f38003c.clear();
        Set<String> P10 = j().P();
        b bVar = new b();
        for (String str : P10) {
            int z11 = j().z(str);
            c cVar = (c) hashMap.get(str);
            if (cVar == null) {
                cVar = new c();
                z10 = false;
            } else {
                z10 = true;
            }
            cVar.f38012a = str;
            cVar.f38013b = str + " (+" + z11 + ")";
            if (!z10) {
                hashMap.put(str, cVar);
                f38003c.add(cVar);
            }
        }
        f38003c.sort(bVar);
        hashMap.clear();
    }

    public static void n(Context context) {
        HashMap<String, Object> h10 = h(context, f38010j);
        CopyOnWriteArrayList<c> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        if (h10 == null) {
            return;
        }
        if (f38007g.containsKey("OTHERS") && f38007g.get("OTHERS").booleanValue()) {
            Iterator<c> it = f38003c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    next.f38015d = false;
                }
            }
            Iterator<c> it2 = d.f38020e.iterator();
            while (it2.hasNext()) {
                c next2 = it2.next();
                if (next2 != null && next2.f38012a.equals("OTHERS")) {
                    next2.f38015d = true;
                }
            }
            return;
        }
        Iterator<c> it3 = f38003c.iterator();
        while (it3.hasNext()) {
            c next3 = it3.next();
            if (next3 != null) {
                c a10 = c.a(next3);
                if (h10.get(next3.f38012a) != null) {
                    next3.f38015d = true;
                    Boolean bool = f38005e.get(a10.f38012a);
                    if (bool != null) {
                        a10.f38015d = bool.booleanValue();
                    }
                    copyOnWriteArrayList.add(a10);
                }
                Boolean bool2 = f38005e.get(next3.f38012a);
                if (bool2 != null) {
                    next3.f38015d = bool2.booleanValue();
                }
            }
        }
        Iterator<c> it4 = d.f38020e.iterator();
        while (it4.hasNext()) {
            c next4 = it4.next();
            if (next4 != null) {
                c a11 = c.a(next4);
                if (h10.get(next4.f38012a) != null) {
                    next4.f38015d = true;
                    Boolean bool3 = f38005e.get(a11.f38012a);
                    if (bool3 != null) {
                        a11.f38015d = bool3.booleanValue();
                    }
                    Boolean bool4 = f38007g.get(a11.f38012a);
                    if (bool4 != null) {
                        a11.f38015d = bool4.booleanValue();
                    }
                    copyOnWriteArrayList.add(a11);
                }
                Boolean bool5 = f38005e.get(next4.f38012a);
                if (bool5 != null) {
                    next4.f38015d = bool5.booleanValue();
                }
                Boolean bool6 = f38007g.get(next4.f38012a);
                if (bool6 != null) {
                    next4.f38015d = bool6.booleanValue();
                }
            }
        }
        f38002b = copyOnWriteArrayList;
    }

    public static void o(ConcurrentHashMap<Integer, c> concurrentHashMap, Context context) {
        if (concurrentHashMap == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : concurrentHashMap.keySet()) {
            num.intValue();
            c cVar = concurrentHashMap.get(num);
            sb.append(",");
            sb.append("'");
            sb.append(cVar.f38012a);
            sb.append("'");
        }
        try {
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
                context.getContentResolver().delete(a.b.f26236a, "country_code IN (" + sb.toString() + ") AND slot_id ='" + f38010j + "'", null);
            }
        } catch (Exception e10) {
            Log.e("PhoneNoInquireDataUtil", "" + e10);
        }
    }

    public static void p(c cVar) {
        Boolean bool = f38007g.get(cVar.f38012a);
        if (bool == null) {
            f38007g.put(cVar.f38012a, Boolean.valueOf(cVar.f38015d));
        } else if (bool.booleanValue() != cVar.f38015d) {
            f38007g.remove(cVar.f38012a);
        }
    }

    public static void q() {
        Iterator<c> it = f38003c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null) {
                if (f38004d.get(next.f38012a) != null) {
                    if (next.f38015d) {
                        f38006f.put(next.f38012a, Boolean.TRUE);
                    } else {
                        f38006f.remove(next.f38012a);
                    }
                    Boolean bool = f38005e.get(next.f38012a);
                    if (bool != null && !bool.booleanValue()) {
                        f38006f.remove(next.f38012a);
                    }
                }
                Boolean bool2 = f38005e.get(next.f38012a);
                if (bool2 != null && bool2.booleanValue()) {
                    f38006f.put(next.f38012a, Boolean.TRUE);
                }
                next.f38015d = false;
            }
        }
        Iterator<c> it2 = d.f38020e.iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null) {
                if (next2.f38012a.equals("OTHERS")) {
                    next2.f38015d = true;
                } else {
                    if (f38004d.get(next2.f38012a) != null) {
                        if (next2.f38015d) {
                            f38006f.put(next2.f38012a, Boolean.TRUE);
                        } else {
                            f38006f.remove(next2.f38012a);
                        }
                        Boolean bool3 = f38005e.get(next2.f38012a);
                        if (bool3 != null && !bool3.booleanValue()) {
                            f38006f.remove(next2.f38012a);
                        }
                    }
                    Boolean bool4 = f38005e.get(next2.f38012a);
                    if (bool4 != null && bool4.booleanValue()) {
                        f38006f.put(next2.f38012a, Boolean.TRUE);
                    }
                    next2.f38015d = false;
                }
            }
        }
    }

    public static void r(int i10) {
        f38010j = i10;
    }

    public static void s(c cVar) {
        Boolean bool = f38005e.get(cVar.f38012a);
        if (bool == null) {
            f38005e.put(cVar.f38012a, Boolean.valueOf(cVar.f38015d));
        } else if (bool.booleanValue() != cVar.f38015d) {
            f38005e.remove(cVar.f38012a);
        }
    }
}
