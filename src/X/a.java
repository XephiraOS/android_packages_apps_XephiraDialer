package X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.heytap.accessory.constant.AFConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f4255f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static a f4256g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4257a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f4258b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f4259c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f4260d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public final Handler f4261e;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: X.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0081a extends Handler {
        public HandlerC0081a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f4263a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<c> f4264b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f4263a = intent;
            this.f4264b = arrayList;
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final IntentFilter f4265a;

        /* renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f4266b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4267c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4268d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f4265a = intentFilter;
            this.f4266b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f4266b);
            sb.append(" filter=");
            sb.append(this.f4265a);
            if (this.f4268d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public a(Context context) {
        this.f4257a = context;
        this.f4261e = new HandlerC0081a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f4255f) {
            try {
                if (f4256g == null) {
                    f4256g = new a(context.getApplicationContext());
                }
                aVar = f4256g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f4258b) {
                try {
                    size = this.f4260d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f4260d.toArray(bVarArr);
                    this.f4260d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                int size2 = bVar.f4264b.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c cVar = bVar.f4264b.get(i11);
                    if (!cVar.f4268d) {
                        cVar.f4266b.onReceive(this.f4257a, bVar.f4263a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f4258b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList<c> arrayList = this.f4258b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.f4258b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                    String action = intentFilter.getAction(i10);
                    ArrayList<c> arrayList2 = this.f4259c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.f4259c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Intent intent) {
        boolean z10;
        int i10;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        String str3;
        synchronized (this.f4258b) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f4257a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                if ((intent.getFlags() & 8) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<c> arrayList3 = this.f4259c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z10) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                    }
                    ArrayList arrayList4 = null;
                    int i11 = 0;
                    while (i11 < arrayList3.size()) {
                        c cVar = arrayList3.get(i11);
                        if (z10) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f4265a);
                        }
                        if (cVar.f4267c) {
                            if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            i10 = i11;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i10 = i11;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = resolveTypeIfNeeded;
                            int match = cVar.f4265a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (match >= 0) {
                                if (z10) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                if (arrayList == null) {
                                    arrayList4 = new ArrayList();
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList4.add(cVar);
                                cVar.f4267c = true;
                                i11 = i10 + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                resolveTypeIfNeeded = str2;
                            } else if (z10) {
                                if (match != -4) {
                                    if (match != -3) {
                                        if (match != -2) {
                                            if (match != -1) {
                                                str3 = "unknown reason";
                                            } else {
                                                str3 = OplusAutoRedialNotificationUI.TYPE;
                                            }
                                        } else {
                                            str3 = "data";
                                        }
                                    } else {
                                        str3 = AFConstants.EXTRA_INTENT_ACTION;
                                    }
                                } else {
                                    str3 = "category";
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str3);
                            }
                        }
                        arrayList4 = arrayList;
                        i11 = i10 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        resolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                            ((c) arrayList5.get(i12)).f4267c = false;
                        }
                        this.f4260d.add(new b(intent, arrayList5));
                        if (!this.f4261e.hasMessages(1)) {
                            this.f4261e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f4258b) {
            try {
                ArrayList<c> remove = this.f4258b.remove(broadcastReceiver);
                if (remove == null) {
                    return;
                }
                for (int size = remove.size() - 1; size >= 0; size--) {
                    c cVar = remove.get(size);
                    cVar.f4268d = true;
                    for (int i10 = 0; i10 < cVar.f4265a.countActions(); i10++) {
                        String action = cVar.f4265a.getAction(i10);
                        ArrayList<c> arrayList = this.f4259c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.f4266b == broadcastReceiver) {
                                    cVar2.f4268d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f4259c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
