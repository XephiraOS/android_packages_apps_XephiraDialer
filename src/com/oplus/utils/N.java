package com.oplus.utils;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.widget.BaseExpandableListAdapter;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.blacklist.database.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import v6.C1629c;

/* compiled from: PhoneNoInquireDataUtil.java */
/* loaded from: classes3.dex */
public class N {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f29057a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f29058b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f29059c;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f29060d;

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f29061e;

    /* renamed from: f, reason: collision with root package name */
    public static CopyOnWriteArrayList<b> f29062f;

    /* renamed from: g, reason: collision with root package name */
    public static CopyOnWriteArrayList<b> f29063g;

    /* renamed from: h, reason: collision with root package name */
    public static HashMap<Long, Object> f29064h;

    /* renamed from: i, reason: collision with root package name */
    public static HashMap<Long, Boolean> f29065i;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f29066j;

    /* renamed from: k, reason: collision with root package name */
    public static int f29067k;

    /* compiled from: PhoneNoInquireDataUtil.java */
    /* loaded from: classes3.dex */
    public static class a extends c {

        /* renamed from: d, reason: collision with root package name */
        public b f29068d = null;

        public static a a(a aVar) {
            a aVar2 = new a();
            aVar2.f29071a = aVar.f29071a;
            aVar2.f29068d = aVar.f29068d;
            aVar2.f29072b = aVar.f29072b;
            return aVar2;
        }
    }

    /* compiled from: PhoneNoInquireDataUtil.java */
    /* loaded from: classes3.dex */
    public static class b extends c {

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<a> f29069d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public String f29070e = "";

        public static b b(b bVar) {
            b bVar2 = new b();
            bVar2.f29071a = bVar.f29071a;
            bVar2.f29072b = bVar.f29072b;
            return bVar2;
        }

        public int c() {
            Iterator<a> it = this.f29069d.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (it.next().f29073c) {
                    i10++;
                }
            }
            return i10;
        }

        public int d() {
            return this.f29069d.size();
        }

        public String e() {
            StringBuilder sb = new StringBuilder();
            Iterator<a> it = this.f29069d.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                a next = it.next();
                int i11 = i10 + 1;
                if (i10 >= 1) {
                    break;
                }
                sb.append(next.f29072b);
                sb.append("、");
                i10 = i11;
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                return sb2.substring(0, sb2.length() - 1);
            }
            return sb2;
        }

        public String f() {
            StringBuilder sb = new StringBuilder();
            Iterator<a> it = this.f29069d.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                a next = it.next();
                if (i10 >= 1) {
                    break;
                }
                if (next.f29073c) {
                    sb.append(next.f29072b);
                    sb.append("、");
                    i10++;
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                return sb2.substring(0, sb2.length() - 1);
            }
            return sb2;
        }

        public String g() {
            return this.f29070e;
        }

        public void h() {
            if (this.f29069d.size() == 0) {
                this.f29073c = !this.f29073c;
                N.m(this);
            } else if (c() == this.f29069d.size()) {
                j();
            } else {
                i();
            }
        }

        public void i() {
            Iterator<a> it = this.f29069d.iterator();
            while (it.hasNext()) {
                a next = it.next();
                next.f29073c = true;
                N.m(next);
            }
        }

        public void j() {
            Iterator<a> it = this.f29069d.iterator();
            while (it.hasNext()) {
                a next = it.next();
                next.f29073c = false;
                N.m(next);
            }
        }
    }

    /* compiled from: PhoneNoInquireDataUtil.java */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public long f29071a;

        /* renamed from: b, reason: collision with root package name */
        public String f29072b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f29073c = false;
    }

    /* compiled from: PhoneNoInquireDataUtil.java */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static ArrayList<b> f29074a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public static ArrayList<b> f29075b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f29076c = {OplusPhoneUtils.DeviceState.INVALID_STATUS, "-2", "-3", "-4"};

        /* renamed from: d, reason: collision with root package name */
        public static final int[] f29077d = {com.oplus.blacklistapp.u.f27647k1, com.oplus.blacklistapp.u.f27717y1, com.oplus.blacklistapp.u.f27721z0, com.oplus.blacklistapp.u.f27653l2};

        public static void a(Context context, HashMap<Long, Object> hashMap) {
            f29074a.clear();
            f29075b.clear();
            int i10 = 0;
            while (true) {
                String[] strArr = f29076c;
                if (i10 < strArr.length) {
                    String str = strArr[i10];
                    b bVar = new b();
                    bVar.f29071a = Long.parseLong(str);
                    bVar.f29072b = context.getString(f29077d[i10]);
                    f29075b.add(bVar);
                    if (hashMap.get(Long.valueOf(bVar.f29071a)) != null) {
                        bVar.f29073c = true;
                        f29074a.add(b.b(bVar));
                    }
                    Boolean bool = N.f29065i.get(Long.valueOf(bVar.f29071a));
                    if (bool != null) {
                        bVar.f29073c = bool.booleanValue();
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        String str = C1629c.f37421g;
        sb.append(str);
        sb.append("/province_and_city/");
        f29057a = Uri.parse(sb.toString());
        f29058b = Uri.parse("content://" + str + "/areano_and_citynames/");
        f29059c = a.C0236a.f26235a;
        f29060d = new String[]{BreenoCallContract.BaseColumns._ID, "province", "city"};
        f29061e = new String[]{BreenoCallContract.BaseColumns._ID, "equal_id"};
        f29062f = new CopyOnWriteArrayList<>();
        f29063g = new CopyOnWriteArrayList<>();
        f29064h = new HashMap<>();
        f29065i = new HashMap<>();
        f29066j = false;
        f29067k = -1;
    }

    public static ContentProviderOperation a(long j10) {
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(f29059c);
        newInsert.withValue("area_id", Long.valueOf(j10));
        newInsert.withValue("slot_id", Integer.valueOf(f29067k));
        return newInsert.build();
    }

    public static void b() {
        f29065i.clear();
    }

    public static void c(Context context) {
        boolean z10;
        boolean z11;
        HashMap<Long, Object> hashMap = f29064h;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = f29063g.iterator();
        while (true) {
            boolean z12 = true;
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            long j10 = next.f29071a;
            if (j10 > 0) {
                if (hashMap.get(Long.valueOf(j10)) == null) {
                    z12 = false;
                }
                boolean z13 = next.f29073c;
                if (z12 != z13) {
                    if (z13) {
                        arrayList.add(Long.valueOf(next.f29071a));
                    } else {
                        sb.append(",");
                        sb.append(next.f29071a);
                    }
                }
            } else {
                Iterator<a> it2 = next.f29069d.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (hashMap.get(Long.valueOf(next2.f29071a)) != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z14 = next2.f29073c;
                    if (z11 != z14) {
                        if (z14) {
                            arrayList.add(Long.valueOf(next2.f29071a));
                        } else {
                            sb.append(",");
                            sb.append(next2.f29071a);
                        }
                    }
                }
            }
        }
        Iterator<b> it3 = d.f29075b.iterator();
        while (it3.hasNext()) {
            b next3 = it3.next();
            if (hashMap.get(Long.valueOf(next3.f29071a)) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z15 = next3.f29073c;
            if (z10 != z15) {
                if (z15) {
                    arrayList.add(Long.valueOf(next3.f29071a));
                } else {
                    sb.append(",");
                    sb.append(next3.f29071a);
                }
            }
        }
        try {
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
                context.getContentResolver().delete(a.C0236a.f26235a, "equal_id IN (" + sb.toString() + ")", null);
            }
        } catch (Exception e10) {
            Log.e("PhoneNoInquireDataUtil", "" + e10);
        }
        if (arrayList.size() > 0) {
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>(arrayList.size());
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                arrayList2.add(a(((Long) it4.next()).longValue()));
            }
            try {
                context.getContentResolver().applyBatch(com.oplus.blacklist.database.a.f26232a, arrayList2);
            } catch (OperationApplicationException e11) {
                Log.e("PhoneNoInquireDataUtil", "dosaveAction: " + e11);
            } catch (RemoteException e12) {
                Log.e("PhoneNoInquireDataUtil", "dosaveAction: " + e12);
            } catch (Throwable th) {
                Log.e("PhoneNoInquireDataUtil", "dosaveAction: " + th);
            }
        }
    }

    public static void d(Context context) {
        try {
            h(context);
            f29066j = true;
        } catch (Exception e10) {
            Log.d("PhoneNoInquireDataUtil", "queryPhoneNoInquireData failed " + e10);
        }
    }

    public static int[] e(ArrayList<b> arrayList) {
        int[] iArr = {0, 0};
        if (arrayList == null) {
            return iArr;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f29071a == 0) {
                Iterator<a> it2 = next.f29069d.iterator();
                while (it2.hasNext()) {
                    if (it2.next().f29073c) {
                        iArr[0] = iArr[0] + 1;
                    }
                }
                iArr[1] = iArr[1] + next.f29069d.size();
            } else {
                if (next.f29073c) {
                    iArr[0] = iArr[0] + 1;
                }
                iArr[1] = iArr[1] + 1;
            }
        }
        return iArr;
    }

    public static int f(ArrayList<b> arrayList) {
        int i10 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f29071a == 0) {
                Iterator<a> it2 = next.f29069d.iterator();
                while (it2.hasNext()) {
                    if (it2.next().f29073c) {
                        i10++;
                    }
                }
            } else if (next.f29073c) {
                i10++;
            }
        }
        return i10;
    }

    public static int g(BaseExpandableListAdapter baseExpandableListAdapter, int i10, b bVar) {
        int childrenCount = baseExpandableListAdapter.getChildrenCount(i10);
        if (childrenCount == 0) {
            if (bVar.f29073c) {
                return 2;
            }
            return 0;
        }
        boolean z10 = true;
        boolean z11 = false;
        for (int i11 = 0; i11 < childrenCount; i11++) {
            if (((a) baseExpandableListAdapter.getChild(i10, i11)).f29073c) {
                z11 = true;
            } else {
                z10 = false;
            }
        }
        if (z10) {
            return 2;
        }
        if (!z11) {
            return 0;
        }
        return 1;
    }

    public static void h(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f29057a, f29060d, null, null, null);
            if (query == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            f29063g.clear();
            query.moveToPosition(-1);
            while (query.moveToNext()) {
                boolean z10 = false;
                long j10 = query.getLong(0);
                String string = query.getString(2);
                String string2 = query.getString(1);
                b bVar = (b) hashMap.get(string2);
                if (bVar == null) {
                    bVar = new b();
                } else {
                    z10 = true;
                }
                bVar.f29072b = string2;
                if (TextUtils.isEmpty(string)) {
                    bVar.f29071a = j10;
                } else {
                    a aVar = new a();
                    aVar.f29071a = j10;
                    aVar.f29072b = string;
                    aVar.f29068d = bVar;
                    bVar.f29069d.add(aVar);
                }
                if (!z10) {
                    hashMap.put(string2, bVar);
                    f29063g.add(bVar);
                }
            }
            hashMap.clear();
            query.close();
        } catch (Exception e10) {
            Log.e("PhoneNoInquireDataUtil", "queryPhoneNoInquireData: " + e10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e9, code lost:
    
        if (r8 == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.N.i(android.content.Context):void");
    }

    public static void j(ArrayList<b> arrayList, Context context) {
        if (arrayList == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f29071a == 0) {
                Iterator<a> it2 = next.f29069d.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2.f29073c) {
                        sb.append(",");
                        sb.append(next2.f29071a);
                    }
                }
            } else if (next.f29073c) {
                sb.append(",");
                sb.append(next.f29071a);
            }
        }
        try {
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
                context.getContentResolver().delete(a.C0236a.f26235a, "equal_id IN (" + sb.toString() + ") AND slot_id ='" + f29067k + "'", null);
            }
        } catch (Exception e10) {
            Log.e("PhoneNoInquireDataUtil", "" + e10);
        }
    }

    public static void k(ArrayList<b> arrayList) {
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f29071a == 0) {
                Iterator<a> it2 = next.f29069d.iterator();
                while (it2.hasNext()) {
                    it2.next().f29073c = true;
                }
            } else {
                next.f29073c = true;
            }
        }
    }

    public static void l(int i10) {
        f29067k = i10;
    }

    public static void m(c cVar) {
        Boolean bool = f29065i.get(Long.valueOf(cVar.f29071a));
        if (bool == null) {
            f29065i.put(Long.valueOf(cVar.f29071a), Boolean.valueOf(cVar.f29073c));
        } else if (bool.booleanValue() != cVar.f29073c) {
            f29065i.remove(Long.valueOf(cVar.f29071a));
        }
    }

    public static void n(ArrayList<b> arrayList) {
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f29071a == 0) {
                Iterator<a> it2 = next.f29069d.iterator();
                while (it2.hasNext()) {
                    it2.next().f29073c = false;
                }
            } else {
                next.f29073c = false;
            }
        }
    }
}
