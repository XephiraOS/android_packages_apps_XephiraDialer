package c0;

import android.database.Cursor;
import androidx.room.Index$Order;
import com.android.incallui.OplusAutoRedialNotificationUI;
import e0.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: TableInfo.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f12685a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, a> f12686b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<b> f12687c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<d> f12688d;

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f12689a;

        /* renamed from: b, reason: collision with root package name */
        public final String f12690b;

        /* renamed from: c, reason: collision with root package name */
        public final int f12691c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f12692d;

        /* renamed from: e, reason: collision with root package name */
        public final int f12693e;

        /* renamed from: f, reason: collision with root package name */
        public final String f12694f;

        /* renamed from: g, reason: collision with root package name */
        public final int f12695g;

        public a(String str, String str2, boolean z10, int i10, String str3, int i11) {
            this.f12689a = str;
            this.f12690b = str2;
            this.f12692d = z10;
            this.f12693e = i10;
            this.f12691c = c(str2);
            this.f12694f = str3;
            this.f12695g = i11;
        }

        public static boolean a(String str) {
            if (str.length() == 0) {
                return false;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < str.length(); i11++) {
                char charAt = str.charAt(i11);
                if (i11 == 0 && charAt != '(') {
                    return false;
                }
                if (charAt == '(') {
                    i10++;
                } else if (charAt == ')' && i10 - 1 == 0 && i11 != str.length() - 1) {
                    return false;
                }
            }
            if (i10 != 0) {
                return false;
            }
            return true;
        }

        public static boolean b(String str, String str2) {
            if (str2 == null) {
                return false;
            }
            if (str.equals(str2)) {
                return true;
            }
            if (!a(str)) {
                return false;
            }
            return str.substring(1, str.length() - 1).trim().equals(str2);
        }

        public static int c(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (!upperCase.contains("CHAR") && !upperCase.contains("CLOB") && !upperCase.contains("TEXT")) {
                if (upperCase.contains("BLOB")) {
                    return 5;
                }
                if (!upperCase.contains("REAL") && !upperCase.contains("FLOA") && !upperCase.contains("DOUB")) {
                    return 1;
                }
                return 4;
            }
            return 2;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f12693e != aVar.f12693e || !this.f12689a.equals(aVar.f12689a) || this.f12692d != aVar.f12692d) {
                return false;
            }
            if (this.f12695g == 1 && aVar.f12695g == 2 && (str3 = this.f12694f) != null && !b(str3, aVar.f12694f)) {
                return false;
            }
            if (this.f12695g == 2 && aVar.f12695g == 1 && (str2 = aVar.f12694f) != null && !b(str2, this.f12694f)) {
                return false;
            }
            int i10 = this.f12695g;
            if ((i10 == 0 || i10 != aVar.f12695g || ((str = this.f12694f) == null ? aVar.f12694f == null : b(str, aVar.f12694f))) && this.f12691c == aVar.f12691c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int hashCode = ((this.f12689a.hashCode() * 31) + this.f12691c) * 31;
            if (this.f12692d) {
                i10 = 1231;
            } else {
                i10 = 1237;
            }
            return ((hashCode + i10) * 31) + this.f12693e;
        }

        public String toString() {
            return "Column{name='" + this.f12689a + "', type='" + this.f12690b + "', affinity='" + this.f12691c + "', notNull=" + this.f12692d + ", primaryKeyPosition=" + this.f12693e + ", defaultValue='" + this.f12694f + "'}";
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f12696a;

        /* renamed from: b, reason: collision with root package name */
        public final String f12697b;

        /* renamed from: c, reason: collision with root package name */
        public final String f12698c;

        /* renamed from: d, reason: collision with root package name */
        public final List<String> f12699d;

        /* renamed from: e, reason: collision with root package name */
        public final List<String> f12700e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f12696a = str;
            this.f12697b = str2;
            this.f12698c = str3;
            this.f12699d = Collections.unmodifiableList(list);
            this.f12700e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f12696a.equals(bVar.f12696a) || !this.f12697b.equals(bVar.f12697b) || !this.f12698c.equals(bVar.f12698c) || !this.f12699d.equals(bVar.f12699d)) {
                return false;
            }
            return this.f12700e.equals(bVar.f12700e);
        }

        public int hashCode() {
            return (((((((this.f12696a.hashCode() * 31) + this.f12697b.hashCode()) * 31) + this.f12698c.hashCode()) * 31) + this.f12699d.hashCode()) * 31) + this.f12700e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f12696a + "', onDelete='" + this.f12697b + "', onUpdate='" + this.f12698c + "', columnNames=" + this.f12699d + ", referenceColumnNames=" + this.f12700e + '}';
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class c implements Comparable<c> {

        /* renamed from: a, reason: collision with root package name */
        public final int f12701a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12702b;

        /* renamed from: c, reason: collision with root package name */
        public final String f12703c;

        /* renamed from: d, reason: collision with root package name */
        public final String f12704d;

        public c(int i10, int i11, String str, String str2) {
            this.f12701a = i10;
            this.f12702b = i11;
            this.f12703c = str;
            this.f12704d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int i10 = this.f12701a - cVar.f12701a;
            if (i10 == 0) {
                return this.f12702b - cVar.f12702b;
            }
            return i10;
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f12705a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f12706b;

        /* renamed from: c, reason: collision with root package name */
        public final List<String> f12707c;

        /* renamed from: d, reason: collision with root package name */
        public final List<String> f12708d;

        public d(String str, boolean z10, List<String> list, List<String> list2) {
            this.f12705a = str;
            this.f12706b = z10;
            this.f12707c = list;
            this.f12708d = (list2 == null || list2.size() == 0) ? Collections.nCopies(list.size(), Index$Order.ASC.name()) : list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f12706b != dVar.f12706b || !this.f12707c.equals(dVar.f12707c) || !this.f12708d.equals(dVar.f12708d)) {
                return false;
            }
            if (this.f12705a.startsWith("index_")) {
                return dVar.f12705a.startsWith("index_");
            }
            return this.f12705a.equals(dVar.f12705a);
        }

        public int hashCode() {
            int hashCode;
            if (this.f12705a.startsWith("index_")) {
                hashCode = -1184239155;
            } else {
                hashCode = this.f12705a.hashCode();
            }
            return (((((hashCode * 31) + (this.f12706b ? 1 : 0)) * 31) + this.f12707c.hashCode()) * 31) + this.f12708d.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f12705a + "', unique=" + this.f12706b + ", columns=" + this.f12707c + ", orders=" + this.f12708d + '}';
        }
    }

    public f(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        Set<d> unmodifiableSet;
        this.f12685a = str;
        this.f12686b = Collections.unmodifiableMap(map);
        this.f12687c = Collections.unmodifiableSet(set);
        if (set2 == null) {
            unmodifiableSet = null;
        } else {
            unmodifiableSet = Collections.unmodifiableSet(set2);
        }
        this.f12688d = unmodifiableSet;
    }

    public static f a(g gVar, String str) {
        return new f(str, b(gVar, str), d(gVar, str), f(gVar, str));
    }

    public static Map<String, a> b(g gVar, String str) {
        boolean z10;
        Cursor b10 = gVar.b("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (b10.getColumnCount() > 0) {
                int columnIndex = b10.getColumnIndex("name");
                int columnIndex2 = b10.getColumnIndex(OplusAutoRedialNotificationUI.TYPE);
                int columnIndex3 = b10.getColumnIndex("notnull");
                int columnIndex4 = b10.getColumnIndex("pk");
                int columnIndex5 = b10.getColumnIndex("dflt_value");
                while (b10.moveToNext()) {
                    String string = b10.getString(columnIndex);
                    String string2 = b10.getString(columnIndex2);
                    if (b10.getInt(columnIndex3) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    hashMap.put(string, new a(string, string2, z10, b10.getInt(columnIndex4), b10.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            b10.close();
        }
    }

    public static List<c> c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < count; i10++) {
            cursor.moveToPosition(i10);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Set<b> d(g gVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor b10 = gVar.b("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = b10.getColumnIndex("id");
            int columnIndex2 = b10.getColumnIndex("seq");
            int columnIndex3 = b10.getColumnIndex("table");
            int columnIndex4 = b10.getColumnIndex("on_delete");
            int columnIndex5 = b10.getColumnIndex("on_update");
            List<c> c10 = c(b10);
            int count = b10.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                b10.moveToPosition(i10);
                if (b10.getInt(columnIndex2) == 0) {
                    int i11 = b10.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : c10) {
                        if (cVar.f12701a == i11) {
                            arrayList.add(cVar.f12703c);
                            arrayList2.add(cVar.f12704d);
                        }
                    }
                    hashSet.add(new b(b10.getString(columnIndex3), b10.getString(columnIndex4), b10.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            b10.close();
            return hashSet;
        } catch (Throwable th) {
            b10.close();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static d e(g gVar, String str, boolean z10) {
        String str2;
        Cursor b10 = gVar.b("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = b10.getColumnIndex("seqno");
            int columnIndex2 = b10.getColumnIndex("cid");
            int columnIndex3 = b10.getColumnIndex("name");
            int columnIndex4 = b10.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (b10.moveToNext()) {
                    if (b10.getInt(columnIndex2) >= 0) {
                        int i10 = b10.getInt(columnIndex);
                        String string = b10.getString(columnIndex3);
                        if (b10.getInt(columnIndex4) > 0) {
                            str2 = "DESC";
                        } else {
                            str2 = "ASC";
                        }
                        treeMap.put(Integer.valueOf(i10), string);
                        treeMap2.put(Integer.valueOf(i10), str2);
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                ArrayList arrayList2 = new ArrayList(treeMap2.size());
                arrayList2.addAll(treeMap2.values());
                d dVar = new d(str, z10, arrayList, arrayList2);
                b10.close();
                return dVar;
            }
            b10.close();
            return null;
        } catch (Throwable th) {
            b10.close();
            throw th;
        }
    }

    public static Set<d> f(g gVar, String str) {
        Cursor b10 = gVar.b("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = b10.getColumnIndex("name");
            int columnIndex2 = b10.getColumnIndex("origin");
            int columnIndex3 = b10.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (b10.moveToNext()) {
                    if ("c".equals(b10.getString(columnIndex2))) {
                        String string = b10.getString(columnIndex);
                        boolean z10 = true;
                        if (b10.getInt(columnIndex3) != 1) {
                            z10 = false;
                        }
                        d e10 = e(gVar, string, z10);
                        if (e10 == null) {
                            return null;
                        }
                        hashSet.add(e10);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            b10.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f12685a;
        if (str == null ? fVar.f12685a != null : !str.equals(fVar.f12685a)) {
            return false;
        }
        Map<String, a> map = this.f12686b;
        if (map == null ? fVar.f12686b != null : !map.equals(fVar.f12686b)) {
            return false;
        }
        Set<b> set2 = this.f12687c;
        if (set2 == null ? fVar.f12687c != null : !set2.equals(fVar.f12687c)) {
            return false;
        }
        Set<d> set3 = this.f12688d;
        if (set3 == null || (set = fVar.f12688d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        int i10;
        int i11;
        String str = this.f12685a;
        int i12 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i13 = i10 * 31;
        Map<String, a> map = this.f12686b;
        if (map != null) {
            i11 = map.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i13 + i11) * 31;
        Set<b> set = this.f12687c;
        if (set != null) {
            i12 = set.hashCode();
        }
        return i14 + i12;
    }

    public String toString() {
        return "TableInfo{name='" + this.f12685a + "', columns=" + this.f12686b + ", foreignKeys=" + this.f12687c + ", indices=" + this.f12688d + '}';
    }
}
