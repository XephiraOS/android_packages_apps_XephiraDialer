package I3;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.model.Account;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: CsvImporter.java */
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: d, reason: collision with root package name */
    public HashSet<String> f1316d;

    /* renamed from: e, reason: collision with root package name */
    public int f1317e;

    /* renamed from: f, reason: collision with root package name */
    public int f1318f;

    /* renamed from: g, reason: collision with root package name */
    public Account f1319g;

    /* renamed from: h, reason: collision with root package name */
    public Context f1320h;

    /* renamed from: j, reason: collision with root package name */
    public String[] f1322j;

    /* renamed from: k, reason: collision with root package name */
    public String f1323k;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1313a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1314b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1315c = false;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<String[]> f1324l = null;

    /* renamed from: m, reason: collision with root package name */
    public HashMap<String, Long> f1325m = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    public a[] f1321i = r();

    /* compiled from: CsvImporter.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f1326a;

        /* renamed from: b, reason: collision with root package name */
        public int f1327b;

        /* renamed from: c, reason: collision with root package name */
        public String f1328c;

        /* renamed from: d, reason: collision with root package name */
        public int f1329d;

        /* renamed from: e, reason: collision with root package name */
        public int f1330e;

        public a(String str, int i10) {
            this(str, i10, 0, -1);
        }

        public void a(String str) {
            this.f1328c = str;
        }

        public a(String str, int i10, int i11, int i12) {
            this.f1326a = str;
            this.f1327b = i10;
            this.f1329d = i11;
            this.f1330e = i12;
        }
    }

    public d(Context context) {
        this.f1320h = context;
        t();
        I3.a.f(context);
        this.f1316d = new HashSet<>();
    }

    public static Uri e(Context context, String str, Account account) {
        String str2;
        String str3;
        String str4 = R0.a.f3165a;
        String str5 = R0.a.f3166b;
        ContentValues contentValues = new ContentValues();
        if (account != null && (str2 = account.f16941a) != null && (str3 = account.f16942b) != null) {
            str5 = str3;
            str4 = str2;
        }
        contentValues.put("account_name", str4);
        contentValues.put("account_type", str5);
        contentValues.put("title", str);
        return G7.c.d(context.getContentResolver(), R0.d.a(ContactsContract.Groups.CONTENT_URI), contentValues);
    }

    public static d m(Context context, String str, String[] strArr) {
        if (context.getString(R.string.csv_smart_title).equals(str)) {
            return new g(context);
        }
        if (!context.getString(R.string.csv_smart_title2).equals(str) && !context.getString(R.string.csv_smart_title2_en).equals(str)) {
            return new e(context, strArr);
        }
        return new f(context);
    }

    public void A(Account account) {
        this.f1319g = account;
    }

    public void B(String[] strArr) {
        this.f1322j = strArr;
    }

    public void a() {
        if (this.f1316d.size() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("csv_not_support_title", TextUtils.join("|", this.f1316d));
            A.a(this.f1320h, 2000302, 200030264, hashMap, false);
        }
    }

    public boolean b(String[] strArr) {
        if (this.f1324l == null) {
            this.f1324l = new ArrayList<>();
        }
        if (strArr != null) {
            String[] k10 = k(strArr);
            if (!u(k10)) {
                this.f1324l.add(k10);
                return true;
            }
            return false;
        }
        return false;
    }

    public final b c(String[] strArr) {
        if (strArr == null || this.f1321i == null) {
            return null;
        }
        b f10 = b.f(this.f1320h);
        f(f10, strArr);
        for (int i10 = 0; i10 != strArr.length; i10++) {
            a[] aVarArr = this.f1321i;
            if (i10 >= aVarArr.length) {
                break;
            }
            String str = strArr[i10];
            a aVar = aVarArr[i10];
            if (!TextUtils.isEmpty(str) && !str.equals("\"\"") && !TextUtils.isEmpty(aVar.f1326a)) {
                I3.a aVar2 = new I3.a();
                aVar2.g(aVar.f1329d, str);
                aVar2.i(aVar.f1326a);
                int i11 = aVar.f1327b;
                if (i11 != -1) {
                    aVar2.j(i11);
                }
                aVar2.h(aVar.f1328c);
                strArr[i10] = null;
                int i12 = aVar.f1330e;
                while (i12 != -1) {
                    a[] aVarArr2 = this.f1321i;
                    if (i12 >= aVarArr2.length || i12 >= strArr.length) {
                        break;
                    }
                    String str2 = strArr[i12];
                    a aVar3 = aVarArr2[i12];
                    if (!TextUtils.isEmpty(str2) && !str2.equals("\"\"")) {
                        aVar2.g(aVar3.f1329d, g(aVar3, str2));
                        aVar2.h(aVar3.f1328c);
                    } else if (this.f1314b) {
                        aVar2.g(aVar3.f1329d, g(aVar3, str2));
                        aVar2.h(aVar3.f1328c);
                    }
                    strArr[i12] = null;
                    i12 = aVar3.f1330e;
                }
                f10.k(aVar2);
            }
        }
        return f10;
    }

    public b d(ArrayList<String[]> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            String[] strArr = {"vnd.android.cursor.item/name"};
            int size = arrayList.size();
            b c10 = c(arrayList.get(0));
            int i10 = 1;
            while (i10 < size) {
                b c11 = c(arrayList.get(i10));
                i10++;
                if (c10 != null) {
                    c10.j(c11, strArr);
                }
            }
            return c10;
        }
        return null;
    }

    public void h() {
        this.f1321i = null;
        HashMap<String, Long> hashMap = this.f1325m;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f1325m = null;
        ArrayList<String[]> arrayList = this.f1324l;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f1324l = null;
        HashSet<String> hashSet = this.f1316d;
        if (hashSet != null) {
            hashSet.clear();
            this.f1316d = null;
        }
    }

    public final boolean i(b bVar) {
        int[] iArr = new int[2];
        boolean g10 = c.g(this.f1320h, bVar, this.f1319g, iArr);
        this.f1317e = iArr[0];
        this.f1318f = iArr[1];
        return g10;
    }

    public boolean j(ArrayList<b> arrayList) {
        boolean j10 = c.j(this.f1320h, arrayList, this.f1319g);
        if (j10) {
            this.f1318f = arrayList.size();
        } else {
            this.f1318f = 0;
        }
        return j10;
    }

    public int l() {
        return this.f1318f;
    }

    public b n() {
        b d10 = d(this.f1324l);
        y();
        return d10;
    }

    public String o() {
        return this.f1323k;
    }

    public long p(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        if (this.f1325m.containsKey(str)) {
            return this.f1325m.get(str).longValue();
        }
        Uri e10 = e(this.f1320h, str, this.f1319g);
        if (e10 == null) {
            return -1L;
        }
        long parseId = ContentUris.parseId(e10);
        this.f1325m.put(str, Long.valueOf(parseId));
        return parseId;
    }

    public int q() {
        return this.f1317e;
    }

    public abstract a[] r();

    public String[] s() {
        return this.f1322j;
    }

    public final void t() {
        Cursor cursor;
        try {
            cursor = this.f1320h.getContentResolver().query(ContactsContract.Groups.CONTENT_URI, new String[]{BreenoCallContract.BaseColumns._ID, "title"}, "deleted=0", null, BreenoCallContract.BaseColumns._ID);
        } catch (Exception e10) {
            H7.b.c("CsvImporter", "" + e10);
            cursor = null;
        }
        if (cursor == null) {
            return;
        }
        while (cursor.moveToNext()) {
            try {
                long j10 = cursor.getLong(0);
                String string = cursor.getString(1);
                if (!this.f1325m.containsKey(string)) {
                    this.f1325m.put(string, Long.valueOf(j10));
                }
            } finally {
                cursor.close();
            }
        }
    }

    public boolean u(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean v() {
        return this.f1313a;
    }

    public boolean w(String[] strArr) {
        return b(strArr);
    }

    public void x(b bVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String valueOf = String.valueOf('\t');
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(valueOf);
        if (indexOf == -1) {
            arrayList.add(str);
        } else {
            while (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                if (substring.length() > 0) {
                    arrayList.add(substring);
                }
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(valueOf);
            }
            if (indexOf == -1 && str.length() > 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList<I3.a> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i10 = 0; i10 != size; i10++) {
            long p10 = p((String) arrayList.get(i10));
            if (p10 != -1) {
                I3.a aVar = new I3.a();
                aVar.g(0, String.valueOf(p10));
                arrayList2.add(aVar);
            }
        }
        if (!arrayList2.isEmpty()) {
            bVar.l("vnd.android.cursor.item/group_membership", arrayList2);
        }
    }

    public void y() {
        ArrayList<String[]> arrayList = this.f1324l;
        if (arrayList != null) {
            arrayList.clear();
            this.f1324l.trimToSize();
        } else {
            this.f1324l = new ArrayList<>();
        }
    }

    public boolean z() {
        b d10 = d(this.f1324l);
        if (d10 != null) {
            this.f1323k = d10.e();
        }
        y();
        return i(d10);
    }

    public String[] k(String[] strArr) {
        return strArr;
    }

    public void f(b bVar, String[] strArr) {
    }

    public String g(a aVar, String str) {
        return str;
    }
}
