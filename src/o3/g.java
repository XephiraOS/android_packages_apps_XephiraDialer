package O3;

import Z3.k;
import Z3.p;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.PowerManager;
import android.os.RemoteException;
import android.provider.ContactsContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.customize.contacts.model.IdRecord;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* compiled from: ContactsProcessThreadsHelper.java */
/* loaded from: classes3.dex */
public abstract class g extends Thread implements DialogInterface.OnCancelListener {

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f2695n = {BreenoCallContract.BaseColumns._ID, "account_type", "account_name", "contact_id"};

    /* renamed from: a, reason: collision with root package name */
    public final Context f2696a;

    /* renamed from: h, reason: collision with root package name */
    public CountDownLatch f2703h;

    /* renamed from: m, reason: collision with root package name */
    public PowerManager.WakeLock f2708m;

    /* renamed from: b, reason: collision with root package name */
    public Object f2697b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f2698c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2699d = false;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f2700e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2701f = true;

    /* renamed from: g, reason: collision with root package name */
    public k f2702g = new p();

    /* renamed from: i, reason: collision with root package name */
    public int f2704i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f2705j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f2706k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f2707l = 0;

    /* compiled from: ContactsProcessThreadsHelper.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f2709a;

        /* renamed from: b, reason: collision with root package name */
        public String f2710b;

        /* renamed from: c, reason: collision with root package name */
        public String f2711c;

        /* renamed from: d, reason: collision with root package name */
        public long f2712d;

        public a(Cursor cursor) {
            this.f2709a = cursor.getLong(0);
            this.f2710b = cursor.getString(1);
            this.f2711c = cursor.getString(2);
            this.f2712d = cursor.getLong(3);
        }
    }

    public g(Context context) {
        this.f2696a = context;
    }

    public void a(int i10) {
        this.f2706k += i10;
    }

    public String b(ArrayList<Long> arrayList, int i10, int i11) {
        if (i11 > arrayList.size()) {
            i11 = arrayList.size();
        }
        int i12 = i11 - i10;
        long[] jArr = new long[i12];
        for (int i13 = 0; i13 != i12; i13++) {
            jArr[i13] = arrayList.get(i13 + i10).longValue();
        }
        return G7.b.a(jArr);
    }

    public void c() {
        this.f2700e = true;
        interrupt();
        if (H7.a.b()) {
            H7.b.b("ContactsProcessThread", "Canceled Now");
        }
    }

    public boolean d(ArrayList<ContentProviderOperation> arrayList) {
        if (arrayList.size() > 0) {
            try {
                this.f2696a.getContentResolver().applyBatch("com.android.contacts", arrayList);
            } catch (OperationApplicationException | RemoteException | Exception unused) {
                return false;
            }
        }
        return true;
    }

    public int e() {
        return this.f2705j;
    }

    public int f() {
        return this.f2707l;
    }

    public ArrayList<a> g(long j10) {
        Cursor cursor;
        try {
            cursor = this.f2696a.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, f2695n, "contact_id=" + j10, null, "sort_key");
        } catch (Exception e10) {
            H7.b.c("ContactsProcessThread", "" + e10);
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        int count = cursor.getCount();
        cursor.moveToPosition(-1);
        ArrayList<a> arrayList = new ArrayList<>(count);
        for (int i10 = 0; i10 < count; i10++) {
            if (cursor.moveToNext()) {
                arrayList.add(new a(cursor));
            }
        }
        cursor.close();
        return arrayList;
    }

    public ArrayList<String> h(ArrayList<IdRecord> arrayList, int i10) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            ArrayList<Long> arrayList2 = new ArrayList<>();
            int i11 = 0;
            for (int i12 = 0; i12 != size; i12++) {
                IdRecord idRecord = arrayList.get(i12);
                if (idRecord != null) {
                    arrayList2.add(Long.valueOf(idRecord.b()));
                }
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            while (i11 < arrayList2.size()) {
                int i13 = i11 + i10;
                arrayList3.add(b(arrayList2, i11, i13));
                i11 = i13;
            }
            return arrayList3;
        }
        return null;
    }

    public int i() {
        return this.f2706k;
    }

    public int j() {
        return this.f2704i;
    }

    public boolean k() {
        if (this.f2707l != 0) {
            return true;
        }
        return false;
    }

    public abstract void l();

    public void m(int i10) {
        this.f2705j = i10 + 1;
        if (H7.a.b()) {
            H7.b.b("ContactsProcessThread", "mCurrent = " + this.f2705j);
        }
    }

    public void n(int i10) {
        this.f2707l = i10;
    }

    public void o(k kVar) {
        if (kVar != null) {
            this.f2702g = kVar;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        c();
    }

    public void p(CountDownLatch countDownLatch) {
        if (countDownLatch != null) {
            this.f2703h = countDownLatch;
        }
    }

    public void q(int i10) {
        this.f2704i = i10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        PowerManager.WakeLock newWakeLock = ((PowerManager) this.f2696a.getSystemService("power")).newWakeLock(536870918, "Contacts:ProcessThreadWakeLock");
        this.f2708m = newWakeLock;
        newWakeLock.acquire();
        try {
            l();
            PowerManager.WakeLock wakeLock = this.f2708m;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.f2708m.release();
            }
            this.f2698c = true;
            synchronized (this.f2697b) {
                this.f2697b.notifyAll();
            }
            if (k()) {
                this.f2702g.I(4, null, null);
            } else if (this.f2700e) {
                if (this.f2701f) {
                    this.f2702g.I(5, null, null);
                } else {
                    this.f2702g.I(9, null, null);
                }
            } else {
                this.f2702g.I(3, null, null);
            }
            this.f2702g.I(6, null, null);
        } catch (Throwable th) {
            if (this.f2708m != null && this.f2708m.isHeld()) {
                this.f2708m.release();
            }
            this.f2698c = true;
            synchronized (this.f2697b) {
                this.f2697b.notifyAll();
                if (!k()) {
                    if (this.f2700e) {
                        if (this.f2701f) {
                            this.f2702g.I(5, null, null);
                        } else {
                            this.f2702g.I(9, null, null);
                        }
                    } else {
                        this.f2702g.I(3, null, null);
                    }
                } else {
                    this.f2702g.I(4, null, null);
                }
                this.f2702g.I(6, null, null);
                throw th;
            }
        }
    }
}
