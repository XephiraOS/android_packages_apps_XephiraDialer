package N3;

import U0.k;
import Z3.b;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import android.view.KeyEvent;
import com.android.contacts.model.Account;
import com.customize.contacts.activities.ViewGroupActivity;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.C0811w;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: MoveoutGroupMemberTask.java */
/* loaded from: classes3.dex */
public class i<T extends Z3.b> extends AsyncTask<Void, Void, Integer> implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final List<T> f2348a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2349b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2350c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2351d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2352e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2353f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference<Activity> f2354g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2355h;

    /* renamed from: i, reason: collision with root package name */
    public long f2356i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap<Account, Long> f2357j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.appcompat.app.b f2358k;

    /* compiled from: MoveoutGroupMemberTask.java */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                i.this.e();
                return false;
            }
            return false;
        }
    }

    /* compiled from: MoveoutGroupMemberTask.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Integer f2360a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f2361b;

        public b(Integer num, Activity activity) {
            this.f2360a = num;
            this.f2361b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            int intValue;
            i.this.f();
            i iVar = i.this;
            Integer num = this.f2360a;
            if (num == null) {
                intValue = 888;
            } else {
                intValue = num.intValue();
            }
            iVar.k(intValue);
            if (1 == i.this.f2352e) {
                ((ViewGroupActivity) this.f2361b).Z3();
            }
        }
    }

    public i(Activity activity, List<T> list, long j10) {
        this.f2355h = false;
        this.f2356i = 0L;
        this.f2357j = null;
        this.f2358k = null;
        this.f2354g = new WeakReference<>(activity);
        this.f2350c = j10;
        this.f2349b = 0L;
        this.f2348a = list;
        this.f2352e = 0;
        this.f2353f = "";
        this.f2351d = 666;
    }

    public final boolean d(ArrayList<ContentProviderOperation> arrayList) {
        Activity activity = this.f2354g.get();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            try {
                activity.getContentResolver().applyBatch("com.android.contacts", arrayList);
                if (arrayList.size() <= 0) {
                    return false;
                }
                return true;
            } catch (RemoteException e10) {
                H7.b.c("MoveoutGroupMemberTask", "Exception e: " + e10);
            } catch (Exception e11) {
                H7.b.c("MoveoutGroupMemberTask", "Exception e: " + e11);
                return false;
            }
        }
        return false;
    }

    public void e() {
        this.f2355h = true;
        cancel(true);
    }

    public final void f() {
        Activity activity = this.f2354g.get();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            androidx.appcompat.app.b bVar = this.f2358k;
            if (bVar != null && bVar.isShowing()) {
                this.f2358k.dismiss();
            }
            this.f2358k = null;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        Activity activity = this.f2354g.get();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            int i10 = this.f2351d;
            int i11 = 666;
            if (888 == i10) {
                if (N3.b.i(activity, this.f2349b, this.f2350c)) {
                    i11 = 888;
                }
                return Integer.valueOf(i11);
            }
            if (666 == i10) {
                if (1 == this.f2352e) {
                    return Integer.valueOf(i(this.f2348a, this.f2353f));
                }
                return Integer.valueOf(h(this.f2348a));
            }
        }
        return null;
    }

    public final int h(List<T> list) {
        HashMap<Long, ArrayList<IdRecord>> hashMap;
        ArrayList<ContentProviderOperation> c10;
        Activity activity = this.f2354g.get();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (C0811w.g(list)) {
                return 888;
            }
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < list.size(); i10++) {
                sb.append(list.get(i10).b());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            HashMap<Long, ArrayList<Long>> hashMap2 = null;
            if (this.f2352e == 4) {
                hashMap = N3.b.o(activity.getContentResolver(), sb.toString(), null, list.size());
            } else {
                hashMap2 = N3.b.p(activity.getContentResolver(), sb.toString(), null, null, list.size());
                hashMap = null;
            }
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            for (T t10 : list) {
                if (this.f2352e == 4) {
                    c10 = N3.b.d(activity, hashMap.get(Long.valueOf(t10.b())), this.f2357j);
                } else {
                    c10 = N3.b.c(activity, hashMap2.get(Long.valueOf(t10.b())), this.f2350c);
                }
                if (!C0811w.g(c10)) {
                    arrayList.addAll(c10);
                }
                if (this.f2355h) {
                    return 666;
                }
            }
            return l(arrayList);
        }
        return 777;
    }

    public final int i(List<T> list, String str) {
        Activity activity = this.f2354g.get();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (C0811w.g(list)) {
                return 888;
            }
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < list.size(); i10++) {
                sb.append(list.get(i10).b());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb.length() <= 0) {
                return 888;
            }
            return l(N3.b.e(activity, sb.toString(), str));
        }
        return 777;
    }

    @Override // android.os.AsyncTask
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        Activity activity = this.f2354g.get();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            long currentTimeMillis = 1100 - (System.currentTimeMillis() - this.f2356i);
            if (currentTimeMillis < 0) {
                currentTimeMillis = 0;
            }
            new Handler(activity.getMainLooper()).postDelayed(new b(num, activity), currentTimeMillis);
        }
    }

    public final void k(int i10) {
        Activity activity = this.f2354g.get();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (H7.a.b()) {
                H7.b.b("MoveoutGroupMemberTask", "showPromptMessage, result = " + i10);
            }
            int i11 = -1;
            if (888 == i10) {
                B3.c.d().h();
            } else if (666 != i10) {
                i11 = R.string.oplus_move_out_group_failed;
            }
            if (i11 > 0) {
                com.oplus.foundation.util.ui.c.d(activity, i11);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x004f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0052 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(java.util.ArrayList<android.content.ContentProviderOperation> r6) {
        /*
            r5 = this;
            int r0 = r6.size()
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 >= r1) goto Ld
            boolean r5 = r5.d(r6)
            goto L4d
        Ld:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 199(0xc7, float:2.79E-43)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
            r2 = 1
        L19:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L3d
            java.lang.Object r3 = r6.next()
            android.content.ContentProviderOperation r3 = (android.content.ContentProviderOperation) r3
            boolean r4 = r5.f2355h
            if (r4 == 0) goto L2c
            r5 = 666(0x29a, float:9.33E-43)
            return r5
        L2c:
            r0.add(r3)
            int r3 = r0.size()
            if (r3 < r1) goto L19
            boolean r2 = r5.d(r0)
            r0.clear()
            goto L19
        L3d:
            int r6 = r0.size()
            if (r6 <= 0) goto L4c
            if (r2 == 0) goto L52
            boolean r5 = r5.d(r0)
            if (r5 == 0) goto L52
            goto L4f
        L4c:
            r5 = r2
        L4d:
            if (r5 == 0) goto L52
        L4f:
            r5 = 888(0x378, float:1.244E-42)
            goto L54
        L52:
            r5 = 777(0x309, float:1.089E-42)
        L54:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.i.l(java.util.ArrayList):int");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        f();
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        f();
        if (H7.a.b()) {
            H7.b.b("MoveoutGroupMemberTask", "onCancelled()");
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.f2356i = System.currentTimeMillis();
        Activity activity = this.f2354g.get();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            androidx.appcompat.app.b o10 = k.o(activity, activity.getString(R.string.oplus_moveing_out_group_member));
            this.f2358k = o10;
            o10.setOnKeyListener(new a());
        }
    }

    public i(Activity activity, List<T> list, int i10, String str) {
        this.f2355h = false;
        this.f2356i = 0L;
        this.f2357j = null;
        this.f2358k = null;
        this.f2354g = new WeakReference<>(activity);
        this.f2352e = i10;
        this.f2353f = str;
        this.f2349b = 0L;
        this.f2348a = list;
        this.f2350c = 0L;
        this.f2351d = 666;
    }

    public i(Activity activity, List<T> list, HashMap<Account, Long> hashMap) {
        this.f2355h = false;
        this.f2356i = 0L;
        this.f2357j = null;
        this.f2358k = null;
        this.f2354g = new WeakReference<>(activity);
        this.f2357j = hashMap;
        this.f2349b = 0L;
        this.f2348a = list;
        this.f2352e = 4;
        this.f2353f = "";
        this.f2350c = 0L;
        this.f2351d = 666;
    }
}
