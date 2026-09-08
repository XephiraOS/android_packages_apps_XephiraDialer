package m1;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.ContactsContract;
import com.heytap.accessory.constant.AFConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProviderStatusWatcher.java */
/* loaded from: classes.dex */
public class U extends ContentObserver {

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f34859i = {AFConstants.EXTRA_STATUS};

    /* renamed from: j, reason: collision with root package name */
    public static U f34860j;

    /* renamed from: a, reason: collision with root package name */
    public final Context f34861a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f34862b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f34863c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<c> f34864d;

    /* renamed from: e, reason: collision with root package name */
    public int f34865e;

    /* renamed from: f, reason: collision with root package name */
    public b f34866f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f34867g;

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f34868h;

    /* compiled from: ProviderStatusWatcher.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            U.this.o(true);
        }
    }

    /* compiled from: ProviderStatusWatcher.java */
    /* loaded from: classes.dex */
    public class b extends AsyncTask<Void, Void, Boolean> {
        public final void a() {
            U.this.f34866f = null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                try {
                    if (isCancelled()) {
                        H7.b.i("ProviderStatusWatcher", "LoaderTask doInBackground isCancelled");
                        Boolean bool = Boolean.FALSE;
                        synchronized (U.this.f34863c) {
                            U.this.f34863c.notifyAll();
                        }
                        return bool;
                    }
                    if (H7.a.b()) {
                        H7.b.b("ProviderStatusWatcher", "doInBackground begin query");
                    }
                    Cursor query = U.this.f34861a.getContentResolver().query(ContactsContract.ProviderStatus.CONTENT_URI, U.f34859i, null, null, null);
                    if (query != null) {
                        try {
                            if (isCancelled()) {
                                H7.b.i("ProviderStatusWatcher", "LoaderTask doInBackground isCancelled");
                                Boolean bool2 = Boolean.FALSE;
                                synchronized (U.this.f34863c) {
                                    U.this.f34863c.notifyAll();
                                }
                                return bool2;
                            }
                            if (query.moveToFirst()) {
                                if (isCancelled()) {
                                    H7.b.i("ProviderStatusWatcher", "LoaderTask doInBackground isCancelled");
                                    Boolean bool3 = Boolean.FALSE;
                                    synchronized (U.this.f34863c) {
                                        U.this.f34863c.notifyAll();
                                    }
                                    return bool3;
                                }
                                U.this.f34867g = Integer.valueOf(query.getInt(0));
                                Boolean bool4 = Boolean.TRUE;
                                synchronized (U.this.f34863c) {
                                    U.this.f34863c.notifyAll();
                                }
                                return bool4;
                            }
                            query.close();
                        } finally {
                            query.close();
                        }
                    } else {
                        H7.b.i("ProviderStatusWatcher", "LoaderTask doInBackground cursor is null");
                    }
                    Boolean bool5 = Boolean.FALSE;
                    synchronized (U.this.f34863c) {
                        U.this.f34863c.notifyAll();
                    }
                    return bool5;
                } catch (Throwable th) {
                    synchronized (U.this.f34863c) {
                        U.this.f34863c.notifyAll();
                        throw th;
                    }
                }
            } catch (Exception e10) {
                H7.b.c("ProviderStatusWatcher", "" + e10);
                Boolean bool6 = Boolean.FALSE;
                synchronized (U.this.f34863c) {
                    U.this.f34863c.notifyAll();
                    return bool6;
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Boolean bool) {
            a();
        }

        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            a();
            if (H7.a.b()) {
                H7.b.b("ProviderStatusWatcher", "onPostExecute loaded=" + bool);
            }
            if (bool != null && bool.booleanValue()) {
                U.this.k();
            }
        }

        public b() {
        }
    }

    /* compiled from: ProviderStatusWatcher.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    public U(Context context) {
        super(null);
        this.f34862b = new Handler();
        this.f34863c = new Object();
        this.f34864d = com.google.common.collect.n.f();
        this.f34868h = new a();
        this.f34861a = context;
    }

    public static synchronized U h(Context context) {
        U u10;
        synchronized (U.class) {
            try {
                if (f34860j == null) {
                    f34860j = new U(context);
                }
                u10 = f34860j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return u10;
    }

    public void g(c cVar) {
        this.f34864d.add(cVar);
    }

    public int i() {
        q();
        Integer num = this.f34867g;
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public final boolean j() {
        if (this.f34865e > 0) {
            return true;
        }
        return false;
    }

    public final void k() {
        if (H7.a.b()) {
            H7.b.b("ProviderStatusWatcher", "notifyListeners: " + this.f34864d.size());
        }
        if (j()) {
            Iterator<c> it = this.f34864d.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void l(c cVar) {
        this.f34864d.remove(cVar);
    }

    public void m() {
        int i10 = this.f34865e + 1;
        this.f34865e = i10;
        if (i10 == 1) {
            try {
                this.f34861a.getContentResolver().registerContentObserver(ContactsContract.ProviderStatus.CONTENT_URI, false, this);
            } catch (Throwable th) {
                H7.b.c("ProviderStatusWatcher", "e = " + th);
            }
            n();
            if (H7.a.b()) {
                H7.b.b("ProviderStatusWatcher", "Start observing");
                return;
            }
            return;
        }
        if (this.f34867g != null) {
            H7.b.b("ProviderStatusWatcher", "Already exist listener, notifyListeners");
            k();
        }
    }

    public final void n() {
        o(false);
    }

    public final void o(boolean z10) {
        b bVar = this.f34866f;
        if (bVar != null) {
            if (z10) {
                bVar.cancel(true);
            } else {
                return;
            }
        }
        if (H7.a.b()) {
            H7.b.b("ProviderStatusWatcher", "Start loading");
        }
        b bVar2 = new b();
        this.f34866f = bVar2;
        bVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10, Uri uri) {
        if (!ContactsContract.ProviderStatus.CONTENT_URI.equals(uri)) {
            return;
        }
        H7.b.e("ProviderStatusWatcher", "Provider status changed.");
        this.f34862b.removeCallbacks(this.f34868h);
        this.f34862b.post(this.f34868h);
    }

    public void p() {
        if (!j()) {
            H7.b.c("ProviderStatusWatcher", "Already stopped");
            return;
        }
        int i10 = this.f34865e - 1;
        this.f34865e = i10;
        if (i10 == 0) {
            this.f34862b.removeCallbacks(this.f34868h);
            try {
                this.f34861a.getContentResolver().unregisterContentObserver(this);
            } catch (Exception e10) {
                H7.b.c("ProviderStatusWatcher", "unregisterContentObserver: " + e10);
            }
            if (H7.a.b()) {
                H7.b.b("ProviderStatusWatcher", "Stop observing");
            }
        }
    }

    public final void q() {
        if (this.f34867g == null) {
            if (this.f34866f == null) {
                n();
            }
            synchronized (this.f34863c) {
                try {
                    this.f34863c.wait(800L);
                } catch (Exception e10) {
                    H7.b.c("ProviderStatusWatcher", "waitForLoaded wait error " + e10);
                }
            }
        }
    }
}
