package n1;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.accounts.OnAccountsUpdateListener;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SyncStatusObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountWithDataSet;
import com.google.common.collect.Maps;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import m1.AbstractC1316l;

/* compiled from: AccountTypeManagerImpl.java */
/* loaded from: classes.dex */
public class b extends AbstractC1362a implements OnAccountsUpdateListener, SyncStatusObserver {

    /* renamed from: a, reason: collision with root package name */
    public final e f35570a;

    /* renamed from: e, reason: collision with root package name */
    public HandlerThread f35574e;

    /* renamed from: f, reason: collision with root package name */
    public Handler f35575f;

    /* renamed from: g, reason: collision with root package name */
    public Context f35576g;

    /* renamed from: h, reason: collision with root package name */
    public AccountManager f35577h;

    /* renamed from: i, reason: collision with root package name */
    public AccountType f35578i;

    /* renamed from: j, reason: collision with root package name */
    public AccountType f35579j;

    /* renamed from: k, reason: collision with root package name */
    public AccountType f35580k;

    /* renamed from: y, reason: collision with root package name */
    public static final Map<n1.d, AccountType> f35568y = Collections.unmodifiableMap(new HashMap());

    /* renamed from: z, reason: collision with root package name */
    public static final Uri f35569z = ContactsContract.Contacts.getLookupUri(1, "xxx");

    /* renamed from: A, reason: collision with root package name */
    public static final Comparator<AccountWithDataSet> f35567A = new c();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f35571b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f35572c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public final Handler f35573d = new Handler(Looper.getMainLooper());

    /* renamed from: l, reason: collision with root package name */
    public List<AccountWithDataSet> f35581l = com.google.common.collect.n.f();

    /* renamed from: m, reason: collision with root package name */
    public List<AccountWithDataSet> f35582m = com.google.common.collect.n.f();

    /* renamed from: n, reason: collision with root package name */
    public List<AccountWithDataSet> f35583n = com.google.common.collect.n.f();

    /* renamed from: o, reason: collision with root package name */
    public Map<n1.d, AccountType> f35584o = Maps.f();

    /* renamed from: p, reason: collision with root package name */
    public Map<n1.d, AccountType> f35585p = f35568y;

    /* renamed from: q, reason: collision with root package name */
    public final Runnable f35586q = new a();

    /* renamed from: r, reason: collision with root package name */
    public BroadcastReceiver f35587r = new C0334b();

    /* renamed from: x, reason: collision with root package name */
    public volatile CountDownLatch f35588x = new CountDownLatch(1);

    /* compiled from: AccountTypeManagerImpl.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC1316l.f(b.this.f35576g).b(true);
        }
    }

    /* compiled from: AccountTypeManagerImpl.java */
    /* renamed from: n1.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0334b extends BroadcastReceiver {
        public C0334b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b.this.f35575f.sendMessage(b.this.f35575f.obtainMessage(1, intent));
        }
    }

    /* compiled from: AccountTypeManagerImpl.java */
    /* loaded from: classes.dex */
    public class c implements Comparator<AccountWithDataSet> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AccountWithDataSet accountWithDataSet, AccountWithDataSet accountWithDataSet2) {
            String str = accountWithDataSet.f16970c;
            String str2 = accountWithDataSet2.f16970c;
            if (com.google.common.base.h.a(accountWithDataSet.f16941a, accountWithDataSet2.f16941a) && com.google.common.base.h.a(accountWithDataSet.f16942b, accountWithDataSet2.f16942b) && com.google.common.base.h.a(str, str2)) {
                return 0;
            }
            String str3 = accountWithDataSet2.f16941a;
            if (str3 == null || accountWithDataSet2.f16942b == null) {
                return -1;
            }
            String str4 = accountWithDataSet.f16941a;
            if (str4 == null || accountWithDataSet.f16942b == null) {
                return 1;
            }
            int compareTo = str4.compareTo(str3);
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = accountWithDataSet.f16942b.compareTo(accountWithDataSet2.f16942b);
            if (compareTo2 != 0) {
                return compareTo2;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return str.compareTo(str2);
        }
    }

    /* compiled from: AccountTypeManagerImpl.java */
    /* loaded from: classes.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            H7.b.e("AccountTypeManager", "AccountChangeListener: Message: " + message.what);
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        b.this.u();
                        return;
                    }
                    return;
                }
                b.this.t((Intent) message.obj);
                return;
            }
            b.this.s();
        }
    }

    /* compiled from: AccountTypeManagerImpl.java */
    /* loaded from: classes.dex */
    public static final class e {
        public e() {
        }
    }

    public b(Context context) {
        this.f35576g = context;
        this.f35578i = new com.android.contacts.model.g(context);
        this.f35579j = new com.android.contacts.model.i(context);
        this.f35580k = new com.android.contacts.model.a(context);
        this.f35577h = AccountManager.get(this.f35576g);
        HandlerThread handlerThread = new HandlerThread("AccountChangeListener");
        this.f35574e = handlerThread;
        handlerThread.start();
        this.f35575f = new d(this.f35574e.getLooper());
        this.f35570a = new e();
        this.f35575f.sendEmptyMessage(2);
        this.f35577h.addOnAccountsUpdatedListener(this, this.f35575f, false);
        ContentResolver.addStatusChangeListener(1, this);
        this.f35575f.sendEmptyMessage(0);
    }

    public static Map<n1.d, AccountType> p(Context context, Collection<AccountWithDataSet> collection, Map<n1.d, AccountType> map) {
        HashMap f10 = Maps.f();
        Iterator<AccountWithDataSet> it = collection.iterator();
        while (it.hasNext()) {
            n1.d h10 = it.next().h();
            AccountType accountType = map.get(h10);
            if (accountType != null && !f10.containsKey(h10)) {
                if (Log.isLoggable("AccountTypeManager", 3)) {
                    H7.b.b("AccountTypeManager", "Type " + h10 + " inviteClass=" + accountType.i());
                }
                if (!TextUtils.isEmpty(accountType.i())) {
                    f10.put(h10, accountType);
                }
            }
        }
        return Collections.unmodifiableMap(f10);
    }

    public static AuthenticatorDescription q(AuthenticatorDescription[] authenticatorDescriptionArr, String str) {
        for (AuthenticatorDescription authenticatorDescription : authenticatorDescriptionArr) {
            if (str.equals(authenticatorDescription.type)) {
                return authenticatorDescription;
            }
        }
        return null;
    }

    @Override // n1.AbstractC1362a
    public AccountType d(n1.d dVar) {
        AccountType accountType;
        o();
        synchronized (this) {
            try {
                accountType = this.f35584o.get(dVar);
                if (TextUtils.equals(dVar.f35594a, "com.oplus.contacts.sim")) {
                    accountType = this.f35579j;
                } else if (TextUtils.equals(dVar.f35594a, "com.android.oplus.sim")) {
                    accountType = this.f35580k;
                }
                if (accountType == null) {
                    accountType = this.f35578i;
                }
            } finally {
            }
        }
        return accountType;
    }

    @Override // n1.AbstractC1362a
    public List<AccountType> f(boolean z10) {
        o();
        ArrayList f10 = com.google.common.collect.n.f();
        synchronized (this) {
            try {
                for (AccountType accountType : this.f35584o.values()) {
                    if (z10 && !accountType.b()) {
                    }
                    f10.add(accountType);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f10;
    }

    @Override // n1.AbstractC1362a
    public List<AccountWithDataSet> g(boolean z10) {
        o();
        if (z10) {
            return this.f35582m;
        }
        return this.f35581l;
    }

    @Override // n1.AbstractC1362a
    public com.android.contacts.model.c i(String str, String str2, String str3) {
        com.android.contacts.model.c cVar;
        o();
        AccountType accountType = this.f35584o.get(n1.d.a(str, str2));
        if (accountType != null) {
            cVar = accountType.j(str3);
        } else {
            cVar = null;
        }
        if (TextUtils.equals(str, "com.oplus.contacts.sim")) {
            cVar = this.f35579j.j(str3);
        } else if (TextUtils.equals(str, "com.android.oplus.sim")) {
            cVar = this.f35580k.j(str3);
        }
        if (cVar == null) {
            cVar = this.f35578i.j(str3);
        }
        if (cVar == null && H7.a.b()) {
            H7.b.i("AccountTypeManager", "Unknown type=" + str + ", mime=" + str3);
        }
        return cVar;
    }

    public final void m(AccountType accountType, Map<n1.d, AccountType> map, Map<String, List<AccountType>> map2) {
        map.put(accountType.c(), accountType);
        List<AccountType> list = map2.get(accountType.f16944a);
        if (list == null) {
            list = com.google.common.collect.n.f();
        }
        list.add(accountType);
        map2.put(accountType.f16944a, list);
    }

    public final void n(Map<String, List<AccountType>> map, List<AccountWithDataSet> list, List<AccountWithDataSet> list2, List<AccountWithDataSet> list3) {
        List<AccountType> list4 = map.get(R0.a.f3166b);
        if (list4 != null) {
            int size = list4.size();
            for (int i10 = 0; i10 < size; i10++) {
                AccountType accountType = list4.get(i10);
                AccountWithDataSet accountWithDataSet = new AccountWithDataSet(R0.a.f3165a, R0.a.f3166b, accountType.f16945b);
                list.add(accountWithDataSet);
                if (accountType.b()) {
                    list2.add(accountWithDataSet);
                }
                if (accountType.p()) {
                    list3.add(accountWithDataSet);
                }
            }
        }
    }

    public void o() {
        CountDownLatch countDownLatch = this.f35588x;
        if (countDownLatch == null) {
            return;
        }
        while (true) {
            try {
                countDownLatch.await();
                return;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // android.accounts.OnAccountsUpdateListener
    public void onAccountsUpdated(Account[] accountArr) {
        s();
    }

    @Override // android.content.SyncStatusObserver
    public void onStatusChanged(int i10) {
        this.f35575f.sendEmptyMessage(0);
    }

    public final void r(Map<n1.d, AccountType> map, Map<String, List<AccountType>> map2) {
        H7.b.b("AccountTypeManager", "Adding default local account type to the cache");
        com.android.contacts.model.g gVar = new com.android.contacts.model.g(this.f35576g);
        gVar.f16944a = R0.a.f3166b;
        gVar.f16948e = R.string.contact_editor_account_storage_phone;
        gVar.f16949f = N0.g.f1905e;
        m(gVar, map, map2);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s() {
        /*
            Method dump skipped, instructions count: 887
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.b.s():void");
    }

    public void t(Intent intent) {
        this.f35575f.sendEmptyMessage(0);
    }

    public final void u() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addDataScheme("package");
        Context context = this.f35576g;
        BroadcastReceiver broadcastReceiver = this.f35587r;
        String str = R0.b.f3175i;
        context.registerReceiver(broadcastReceiver, intentFilter, str, null, 2);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
        intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
        this.f35576g.registerReceiver(this.f35587r, intentFilter2, str, null, 2);
        this.f35576g.registerReceiver(this.f35587r, new IntentFilter("android.intent.action.LOCALE_CHANGED"), str, null, 2);
    }
}
