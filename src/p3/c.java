package P3;

import android.database.Cursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.model.IdRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

/* compiled from: ContactsSelectManager.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final DataSetObservable f2889a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    public boolean f2890b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2891c = false;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<IdRecord> f2892d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f2893e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f2894f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f2895g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f2896h = -1;

    /* renamed from: i, reason: collision with root package name */
    public Cursor f2897i = null;

    /* renamed from: j, reason: collision with root package name */
    public int f2898j = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2899k = false;

    /* renamed from: l, reason: collision with root package name */
    public HashMap<Long, Boolean> f2900l;

    /* renamed from: m, reason: collision with root package name */
    public HashMap<Long, IdRecord> f2901m;

    /* renamed from: n, reason: collision with root package name */
    public HashSet<Long> f2902n;

    /* compiled from: ContactsSelectManager.java */
    /* loaded from: classes3.dex */
    public class a implements ToLongFunction<Long> {
        public a() {
        }

        @Override // java.util.function.ToLongFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public long applyAsLong(Long l10) {
            return l10.longValue();
        }
    }

    public c() {
        this.f2900l = null;
        this.f2901m = null;
        this.f2902n = null;
        this.f2901m = new HashMap<>();
        this.f2900l = new HashMap<>();
        this.f2902n = new HashSet<>();
    }

    public void A() {
        this.f2895g = 0;
        this.f2894f = 0;
        this.f2893e = 0;
        this.f2891c = false;
        this.f2901m.clear();
        this.f2900l.clear();
        this.f2902n.clear();
        this.f2890b = false;
    }

    public void B() {
        this.f2895g = 0;
        this.f2893e = 0;
        this.f2890b = false;
    }

    public void C(boolean z10) {
        Cursor cursor = this.f2897i;
        if (t(cursor)) {
            return;
        }
        try {
            if (z10) {
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    long j10 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
                    try {
                        if (!this.f2900l.containsKey(Long.valueOf(j10))) {
                            y(cursor, j10);
                        }
                        this.f2901m.put(Long.valueOf(j10), a(cursor));
                    } catch (IllegalStateException unused) {
                        H7.b.c("ContactsSelectManager", "Selected contacts are SIM contacts");
                    }
                }
                this.f2893e = cursor.getCount();
            } else {
                if (this.f2896h == -1) {
                    int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
                    this.f2896h = columnIndex;
                    if (columnIndex == -1) {
                        if (H7.a.b()) {
                            H7.b.b("ContactsSelectManager", "The cursor should contain a column named '_id'!");
                            return;
                        }
                        return;
                    }
                }
                HashMap<Long, IdRecord> hashMap = this.f2901m;
                if (hashMap != null && hashMap.size() > 0) {
                    if (H7.a.b()) {
                        H7.b.b("ContactsSelectManager", "mSelectedContacts is not null and mSelectedContacts.size = " + this.f2901m.size());
                    }
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        long j11 = cursor.getLong(this.f2896h);
                        if (this.f2900l.containsKey(Long.valueOf(j11))) {
                            this.f2900l.remove(Long.valueOf(j11));
                        }
                        if (this.f2901m.containsKey(Long.valueOf(j11))) {
                            this.f2901m.remove(Long.valueOf(j11));
                        }
                    }
                } else if (H7.a.b()) {
                    H7.b.b("ContactsSelectManager", "mSelectedContacts is null or mSelectedContacts.size is 0");
                }
                this.f2893e = 0;
            }
        } catch (IllegalStateException e10) {
            H7.b.c("ContactsSelectManager", "" + e10);
        }
        HashMap<Long, IdRecord> hashMap2 = this.f2901m;
        if (hashMap2 != null) {
            this.f2895g = hashMap2.size();
        }
        int i10 = this.f2895g;
        if (i10 > this.f2894f) {
            this.f2894f = i10;
        }
        v();
    }

    public void D(long j10, int i10, boolean z10) {
        try {
            Cursor cursor = this.f2897i;
            if (t(cursor)) {
                return;
            }
            cursor.moveToPosition(i10);
            long j11 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
            if (z10) {
                if (!this.f2900l.containsKey(Long.valueOf(j11))) {
                    y(cursor, j11);
                }
                this.f2901m.put(Long.valueOf(j11), a(cursor));
                this.f2902n.remove(Long.valueOf(j11));
            } else {
                this.f2902n.add(Long.valueOf(j11));
                this.f2901m.remove(Long.valueOf(j10));
                if (this.f2900l.containsKey(Long.valueOf(j10))) {
                    this.f2900l.remove(Long.valueOf(j10));
                }
            }
            Q(z10);
        } catch (Exception e10) {
            H7.b.b("ContactsSelectManager", "setChecked position error: " + e10);
        }
    }

    public void E(long j10, boolean z10) {
        F(j10, z10, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        if (r5.f2900l.containsKey(java.lang.Long.valueOf(r2)) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        y(r0, r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092 A[Catch: Exception -> 0x0035, TRY_LEAVE, TryCatch #2 {Exception -> 0x0035, blocks: (B:9:0x000e, B:10:0x0011, B:12:0x0017, B:16:0x0025, B:18:0x0031, B:21:0x003c, B:29:0x0054, B:30:0x0037, B:23:0x0092, B:33:0x0069, B:35:0x0075, B:36:0x007e), top: B:6:0x000b, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(long r6, boolean r8, boolean r9) {
        /*
            r5 = this;
            android.database.Cursor r0 = r5.f2897i
            boolean r1 = r5.t(r0)
            if (r1 == 0) goto L9
            return
        L9:
            java.lang.String r1 = "ContactsSelectManager"
            if (r8 == 0) goto L69
            r2 = -1
            r0.moveToPosition(r2)     // Catch: java.lang.Exception -> L35
        L11:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Exception -> L35
            if (r2 == 0) goto L90
            java.lang.String r2 = "_id"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Exception -> L35
            long r2 = r0.getLong(r2)     // Catch: java.lang.Exception -> L35
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 != 0) goto L11
            java.util.HashMap<java.lang.Long, java.lang.Boolean> r6 = r5.f2900l     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L37
            java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L37
            boolean r6 = r6.containsKey(r7)     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L37
            if (r6 != 0) goto L3c
            r5.y(r0, r2)     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L37
            goto L3c
        L35:
            r5 = move-exception
            goto L96
        L37:
            java.lang.String r6 = "Selected contacts are SIM contacts"
            H7.b.c(r1, r6)     // Catch: java.lang.Exception -> L35
        L3c:
            java.util.HashMap<java.lang.Long, com.customize.contacts.model.IdRecord> r6 = r5.f2901m     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L53
            java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L53
            com.customize.contacts.model.IdRecord r0 = r5.a(r0)     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L53
            r6.put(r7, r0)     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L53
            java.util.HashSet<java.lang.Long> r6 = r5.f2902n     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L53
            java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L53
            r6.remove(r7)     // Catch: java.lang.Exception -> L35 java.lang.IllegalStateException -> L53
            goto L90
        L53:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r7.<init>()     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = ""
            r7.append(r0)     // Catch: java.lang.Exception -> L35
            r7.append(r6)     // Catch: java.lang.Exception -> L35
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Exception -> L35
            H7.b.c(r1, r6)     // Catch: java.lang.Exception -> L35
            goto L90
        L69:
            java.util.HashMap<java.lang.Long, java.lang.Boolean> r0 = r5.f2900l     // Catch: java.lang.Exception -> L35
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L35
            boolean r0 = r0.containsKey(r2)     // Catch: java.lang.Exception -> L35
            if (r0 == 0) goto L7e
            java.util.HashMap<java.lang.Long, java.lang.Boolean> r0 = r5.f2900l     // Catch: java.lang.Exception -> L35
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L35
            r0.remove(r2)     // Catch: java.lang.Exception -> L35
        L7e:
            java.util.HashMap<java.lang.Long, com.customize.contacts.model.IdRecord> r0 = r5.f2901m     // Catch: java.lang.Exception -> L35
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L35
            r0.remove(r2)     // Catch: java.lang.Exception -> L35
            java.util.HashSet<java.lang.Long> r0 = r5.f2902n     // Catch: java.lang.Exception -> L35
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L35
            r0.add(r6)     // Catch: java.lang.Exception -> L35
        L90:
            if (r9 == 0) goto Laa
            r5.Q(r8)     // Catch: java.lang.Exception -> L35
            goto Laa
        L96:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "setChecked error :"
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            H7.b.b(r1, r5)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.c.F(long, boolean, boolean):void");
    }

    public final void G(ArrayList<IdRecord> arrayList, boolean z10) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i10 = 0;
        if (z10) {
            HashMap hashMap = new HashMap();
            while (i10 != size) {
                long b10 = arrayList.get(i10).b();
                hashMap.put(Long.valueOf(b10), Long.valueOf(b10));
                i10++;
            }
            try {
                Cursor cursor = this.f2897i;
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    long j10 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
                    if (hashMap.containsKey(Long.valueOf(j10))) {
                        this.f2901m.put(Long.valueOf(j10), a(cursor));
                        Q(z10);
                    }
                }
                return;
            } catch (Exception e10) {
                H7.b.b("ContactsSelectManager", "setInitChecked error" + e10);
                return;
            }
        }
        while (i10 != size) {
            this.f2901m.remove(Long.valueOf(arrayList.get(i10).b()));
            Q(z10);
            i10++;
        }
    }

    public void H(boolean z10) {
        this.f2890b = z10;
    }

    public void I(boolean z10) {
        this.f2899k = z10;
    }

    public void J() {
        int i10;
        if (this.f2890b) {
            i10 = l();
        } else {
            i10 = 0;
        }
        this.f2895g = i10;
        this.f2893e = i10;
    }

    public void K(long j10, int i10, boolean z10) {
        try {
            Cursor cursor = this.f2897i;
            if (t(cursor)) {
                return;
            }
            cursor.moveToPosition(i10);
            long j11 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
            if (z10) {
                if (!this.f2900l.containsKey(Long.valueOf(j11))) {
                    y(cursor, j11);
                }
                if (!this.f2901m.containsKey(Long.valueOf(j11))) {
                    this.f2901m.put(Long.valueOf(j11), a(cursor));
                    this.f2895g++;
                    this.f2893e++;
                }
                if (this.f2902n.contains(Long.valueOf(j11))) {
                    this.f2902n.remove(Long.valueOf(j11));
                }
            } else {
                if (this.f2900l.containsKey(Long.valueOf(j10))) {
                    this.f2900l.remove(Long.valueOf(j10));
                }
                if (this.f2901m.containsKey(Long.valueOf(j10))) {
                    this.f2901m.remove(Long.valueOf(j10));
                    this.f2895g--;
                    this.f2893e--;
                }
                if (!this.f2902n.contains(Long.valueOf(j11))) {
                    this.f2902n.add(Long.valueOf(j10));
                }
            }
            int l10 = l();
            int i11 = this.f2895g;
            if (i11 > l10) {
                this.f2895g = l10;
            } else if (i11 < 0) {
                this.f2895g = 0;
            }
            int h10 = h();
            int i12 = this.f2893e;
            if (i12 > h10) {
                this.f2893e = h10;
            } else if (i12 < 0) {
                this.f2893e = 0;
            }
            int i13 = this.f2893e;
            if (i13 > this.f2894f) {
                this.f2894f = i13;
            }
            v();
        } catch (Exception e10) {
            H7.b.b("ContactsSelectManager", "setScrollChecked position error" + e10);
        }
    }

    public void L(HashMap<Long, IdRecord> hashMap) {
        if (this.f2901m == null) {
            this.f2901m = new HashMap<>();
        }
        this.f2901m.clear();
        this.f2901m.putAll(hashMap);
        this.f2895g = this.f2901m.size();
        if (H7.a.b()) {
            H7.b.b("ContactsSelectManager", "setSelectedContacts the size of mSelectedContacts is " + this.f2901m.size());
        }
    }

    public void M(ArrayList<IdRecord> arrayList) {
        if (!this.f2891c && arrayList != null && arrayList.size() != 0) {
            this.f2892d = arrayList;
        } else {
            this.f2892d = null;
        }
    }

    public void N(long[] jArr) {
        if (jArr != null && jArr.length > 0) {
            this.f2902n.clear();
            this.f2902n.addAll((Set) Arrays.stream(jArr).boxed().collect(Collectors.toSet()));
            int size = this.f2894f - this.f2902n.size();
            this.f2895g = size;
            this.f2893e = size;
        }
    }

    public void O(DataSetObserver dataSetObserver) {
        this.f2889a.unregisterObserver(dataSetObserver);
    }

    public void P(Cursor cursor, boolean z10) {
        HashMap hashMap;
        HashSet hashSet;
        if (t(cursor)) {
            v();
            return;
        }
        try {
            if (z10) {
                r(cursor, z10);
            } else {
                boolean z11 = false;
                try {
                    this.f2897i = cursor;
                    this.f2894f = cursor.getCount();
                    hashMap = new HashMap();
                    hashSet = new HashSet();
                } catch (Exception e10) {
                    H7.b.c("ContactsSelectManager", "Exception: " + e10);
                }
                if (this.f2901m.size() <= 0) {
                    if (this.f2902n.size() > 0) {
                    }
                    int i10 = this.f2895g;
                    if (!this.f2899k && this.f2890b) {
                        int size = this.f2894f - this.f2902n.size();
                        this.f2895g = size;
                        this.f2893e = size;
                    } else {
                        int size2 = this.f2901m.size();
                        this.f2895g = size2;
                        this.f2893e = size2;
                    }
                    if (!z11 || i10 != this.f2895g) {
                        v();
                    }
                }
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    long j10 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
                    if (this.f2901m.containsKey(Long.valueOf(j10))) {
                        hashMap.put(Long.valueOf(j10), this.f2901m.get(Long.valueOf(j10)));
                    }
                    if (this.f2902n.contains(Long.valueOf(j10))) {
                        hashSet.add(Long.valueOf(j10));
                    }
                }
                this.f2901m.clear();
                this.f2901m.putAll(hashMap);
                hashMap.clear();
                this.f2902n.clear();
                this.f2902n.addAll(hashSet);
                hashSet.clear();
                z11 = true;
                int i102 = this.f2895g;
                if (!this.f2899k) {
                }
                int size22 = this.f2901m.size();
                this.f2895g = size22;
                this.f2893e = size22;
                if (!z11) {
                }
                v();
            }
            if (H7.a.b()) {
                H7.b.b("ContactsSelectManager", "intiCurrentContactsChecked(), cursor count = " + cursor.getCount() + "intiCurrentContactsChecked(), mCurrentListMarkCount = " + this.f2893e);
            }
            ArrayList<IdRecord> arrayList = this.f2892d;
            if (arrayList != null) {
                G(arrayList, true);
            }
        } catch (Exception e11) {
            H7.b.c("ContactsSelectManager", "Exception e: " + e11);
        }
    }

    public void Q(boolean z10) {
        int i10;
        int i11 = this.f2895g;
        int i12 = -1;
        if (z10) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        this.f2895g = i11 + i10;
        int l10 = l();
        int i13 = this.f2895g;
        if (i13 > l10) {
            this.f2895g = l10;
        } else if (i13 < 0) {
            this.f2895g = 0;
        }
        int i14 = this.f2893e;
        if (z10) {
            i12 = 1;
        }
        this.f2893e = i14 + i12;
        int h10 = h();
        int i15 = this.f2893e;
        if (i15 > h10) {
            this.f2893e = h10;
        } else if (i15 < 0) {
            this.f2893e = 0;
        }
        int i16 = this.f2893e;
        if (i16 > this.f2894f) {
            this.f2894f = i16;
        }
        v();
    }

    public final IdRecord a(Cursor cursor) {
        boolean z10;
        long j10;
        int i10 = this.f2898j;
        if (i10 != 0) {
            boolean z11 = false;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    long j11 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
                    return new IdRecord(j11, j11, false, true);
                }
                long j12 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
                if (cursor.getColumnIndex("name_raw_contact_id") != -1) {
                    j10 = cursor.getLong(cursor.getColumnIndex("name_raw_contact_id"));
                } else {
                    j10 = -1;
                }
                IdRecord idRecord = new IdRecord(j12, j10, true, TextUtils.equals("com.android.oplus.sim", cursor.getString(cursor.getColumnIndex("account_type"))));
                int columnIndex = cursor.getColumnIndex("starred");
                if (columnIndex >= 0) {
                    if (cursor.getInt(columnIndex) == 1) {
                        z11 = true;
                    }
                    idRecord.t(z11);
                }
                return idRecord;
            }
            long j13 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
            String string = cursor.getString(cursor.getColumnIndex("lookup"));
            if (cursor.getInt(cursor.getColumnIndex("starred")) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            return new IdRecord(j13, true, string, z10);
        }
        return new IdRecord(cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID)), cursor.getLong(cursor.getColumnIndex("name_raw_contact_id")), false, "com.oplus.contacts.sim".equals(cursor.getString(cursor.getColumnIndex("account_type"))));
    }

    public void b() {
        this.f2901m.clear();
        this.f2900l.clear();
    }

    public void c() {
        this.f2902n.clear();
    }

    public void d() {
        HashMap<Long, IdRecord> hashMap = this.f2901m;
        if (hashMap != null) {
            hashMap.clear();
            this.f2901m = null;
        }
        HashMap<Long, Boolean> hashMap2 = this.f2900l;
        if (hashMap2 != null) {
            hashMap2.clear();
            this.f2900l = null;
        }
        ArrayList<IdRecord> arrayList = this.f2892d;
        if (arrayList != null) {
            arrayList.clear();
            this.f2892d = null;
        }
        HashSet<Long> hashSet = this.f2902n;
        if (hashSet != null) {
            hashSet.clear();
            this.f2902n = null;
        }
    }

    public boolean e(long j10) {
        return this.f2901m.containsKey(Long.valueOf(j10));
    }

    public boolean f(long j10) {
        return this.f2902n.contains(Long.valueOf(j10));
    }

    public int g() {
        if (this.f2899k && this.f2890b) {
            return l() - this.f2902n.size();
        }
        return this.f2893e;
    }

    public int h() {
        try {
            if (t(this.f2897i)) {
                return 0;
            }
            return this.f2897i.getCount();
        } catch (Exception e10) {
            H7.b.b("ContactsSelectManager", "getCurrentListTotalCount error" + e10);
            return 0;
        }
    }

    public int i() {
        if (this.f2899k && this.f2890b) {
            return l() - this.f2902n.size();
        }
        return this.f2895g;
    }

    public HashMap<Long, IdRecord> j() {
        return this.f2901m;
    }

    public ArrayList<IdRecord> k() {
        ArrayList<IdRecord> arrayList = new ArrayList<>();
        HashMap<Long, IdRecord> hashMap = this.f2901m;
        if (hashMap != null) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    public int l() {
        try {
            if (this.f2898j == 1) {
                if (t(this.f2897i)) {
                    return 0;
                }
                return this.f2897i.getCount();
            }
            if (t(this.f2897i)) {
                return this.f2894f;
            }
            int count = this.f2897i.getCount();
            int i10 = this.f2894f;
            if (count > i10) {
                int count2 = this.f2897i.getCount();
                this.f2894f = count2;
                return count2;
            }
            return i10;
        } catch (Exception e10) {
            H7.b.b("ContactsSelectManager", "getTotalCount error" + e10);
            return 0;
        }
    }

    public long[] m() {
        HashSet<Long> hashSet = this.f2902n;
        if (hashSet != null && !hashSet.isEmpty()) {
            return this.f2902n.stream().mapToLong(new a()).toArray();
        }
        return null;
    }

    public final void n(Cursor cursor, boolean z10) {
        try {
            if (this.f2896h == -1) {
                int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
                this.f2896h = columnIndex;
                if (columnIndex == -1) {
                    H7.b.b("ContactsSelectManager", "The cursor should contain a column named '_id'!");
                    return;
                }
            }
            this.f2898j = 2;
            this.f2897i = cursor;
        } catch (Exception e10) {
            H7.b.b("ContactsSelectManager", "init error" + e10);
        }
        if (this.f2901m == null) {
            this.f2901m = new HashMap<>();
            return;
        }
        HashMap<Long, IdRecord> hashMap = new HashMap<>();
        if (this.f2901m.size() > 0) {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                long j10 = cursor.getLong(this.f2896h);
                if (this.f2901m.containsKey(Long.valueOf(j10))) {
                    hashMap.put(Long.valueOf(j10), new IdRecord(j10, z10));
                }
            }
            this.f2901m.clear();
            this.f2901m = hashMap;
            if (H7.a.b()) {
                H7.b.b("ContactsSelectManager", "init(), cursor count = " + cursor.getCount());
            }
        }
        if (H7.a.b()) {
            H7.b.b("ContactsSelectManager", "init(), mSelectedContacts count = " + this.f2901m.size());
            H7.b.b("ContactsSelectManager", "init(), notifyDatasetChanged");
        }
        ArrayList<IdRecord> arrayList = this.f2892d;
        if (arrayList != null) {
            G(arrayList, true);
        }
        v();
    }

    public void o() {
        Cursor cursor = this.f2897i;
        if (t(cursor)) {
            return;
        }
        try {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
            while (cursor.moveToNext()) {
                long j10 = cursor.getLong(columnIndex);
                if (!this.f2901m.containsKey(Long.valueOf(j10))) {
                    this.f2901m.put(Long.valueOf(j10), a(cursor));
                }
            }
            cursor.moveToPosition(position);
        } catch (Exception e10) {
            H7.b.c("ContactsSelectManager", "initAllSelectedContacts error " + e10);
        }
    }

    public void p() {
        Cursor cursor = this.f2897i;
        if (t(cursor)) {
            return;
        }
        try {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
            while (cursor.moveToNext()) {
                long j10 = cursor.getLong(columnIndex);
                if (this.f2902n.contains(Long.valueOf(j10))) {
                    if (this.f2901m.containsKey(Long.valueOf(j10))) {
                        this.f2901m.remove(Long.valueOf(j10));
                    }
                    if (this.f2900l.containsKey(Long.valueOf(j10))) {
                        this.f2900l.remove(Long.valueOf(j10));
                    }
                } else {
                    if (!this.f2900l.containsKey(Long.valueOf(j10))) {
                        y(cursor, j10);
                    }
                    if (!this.f2901m.containsKey(Long.valueOf(j10))) {
                        this.f2901m.put(Long.valueOf(j10), a(cursor));
                    }
                }
            }
            cursor.moveToPosition(position);
        } catch (Exception e10) {
            H7.b.c("ContactsSelectManager", "getClickMarkAllSelectedContactsIds error " + e10);
        }
    }

    public void q(Cursor cursor, boolean z10) {
        this.f2897i = cursor;
        if (!t(cursor) && this.f2897i.getCount() != 0) {
            if (!this.f2891c) {
                this.f2894f = this.f2897i.getCount();
                n(this.f2897i, z10);
                this.f2891c = true;
                return;
            }
            return;
        }
        this.f2898j = 2;
        v();
    }

    public void r(Cursor cursor, boolean z10) {
        int i10 = 0;
        if (!t(cursor) && cursor.getCount() != 0) {
            this.f2897i = cursor;
            if (this.f2896h == -1) {
                int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
                this.f2896h = columnIndex;
                if (columnIndex == -1) {
                    return;
                }
            }
            if (z10) {
                try {
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        if (this.f2901m.containsKey(Long.valueOf(cursor.getLong(this.f2896h))) && (i10 = i10 + 1) >= this.f2901m.size()) {
                            break;
                        }
                    }
                    if (H7.a.b()) {
                        H7.b.b("ContactsSelectManager", "intiCurrentContactsChecked(), cursor count = " + cursor.getCount());
                    }
                } catch (Exception e10) {
                    H7.b.b("ContactsSelectManager", "initCurrentContactsChecked error" + e10);
                }
            } else {
                this.f2901m.clear();
            }
            this.f2893e = i10;
            v();
            if (H7.a.b()) {
                H7.b.b("ContactsSelectManager", "intiCurrentContactsChecked(), mCurrentListMarkCount = " + this.f2893e);
                return;
            }
            return;
        }
        this.f2893e = 0;
        v();
    }

    public void s(Cursor cursor) {
        if (!t(cursor) && cursor.getCount() != 0) {
            if (this.f2901m == null) {
                this.f2901m = new HashMap<>();
            }
            this.f2898j = 3;
            this.f2901m.clear();
            this.f2893e = 0;
            try {
                this.f2894f = cursor.getCount();
                this.f2897i = cursor;
                int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
                this.f2896h = columnIndex;
                if (columnIndex == -1 && H7.a.b()) {
                    H7.b.b("ContactsSelectManager", "The cursor should contain a column named '_id'!");
                    return;
                }
                return;
            } catch (Exception e10) {
                H7.b.c("ContactsSelectManager", "Exception e: " + e10);
                return;
            }
        }
        this.f2894f = 0;
        v();
    }

    public boolean t(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            return false;
        }
        return true;
    }

    public boolean u() {
        return this.f2890b;
    }

    public final void v() {
        this.f2889a.notifyChanged();
    }

    public void w(boolean z10) {
        c();
        b();
        H(z10);
        J();
        v();
    }

    public void x() {
        c();
        b();
        B();
    }

    public final void y(Cursor cursor, long j10) {
        int columnIndex;
        if (H7.a.b()) {
            H7.b.b("ContactsSelectManager", "contactId = " + j10);
        }
        if (cursor == null || (columnIndex = cursor.getColumnIndex("account_type")) == -1) {
            return;
        }
        String string = cursor.getString(columnIndex);
        if (TextUtils.equals(R0.a.f3166b, string)) {
            return;
        }
        if (FeatureOption.k() && TextUtils.equals("com.android.oplus.sim", string)) {
            return;
        }
        this.f2900l.put(Long.valueOf(j10), Boolean.TRUE);
    }

    public void z(DataSetObserver dataSetObserver) {
        this.f2889a.registerObserver(dataSetObserver);
    }
}
