package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: d, reason: collision with root package name */
    public static String f9369d;

    /* renamed from: g, reason: collision with root package name */
    public static d f9372g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f9373a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f9374b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f9368c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static Set<String> f9370e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f9371f = new Object();

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        public static NotificationChannel b(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        public final String f9375a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9376b;

        /* renamed from: c, reason: collision with root package name */
        public final String f9377c;

        /* renamed from: d, reason: collision with root package name */
        public final Notification f9378d;

        public b(String str, int i10, String str2, Notification notification) {
            this.f9375a = str;
            this.f9376b = i10;
            this.f9377c = str2;
            this.f9378d = notification;
        }

        @Override // androidx.core.app.i.e
        public void a(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.o7(this.f9375a, this.f9376b, this.f9377c, this.f9378d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f9375a + ", id:" + this.f9376b + ", tag:" + this.f9377c + "]";
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f9379a;

        /* renamed from: b, reason: collision with root package name */
        public final IBinder f9380b;

        public c(ComponentName componentName, IBinder iBinder) {
            this.f9379a = componentName;
            this.f9380b = iBinder;
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class d implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final Context f9381a;

        /* renamed from: b, reason: collision with root package name */
        public final HandlerThread f9382b;

        /* renamed from: c, reason: collision with root package name */
        public final Handler f9383c;

        /* renamed from: d, reason: collision with root package name */
        public final Map<ComponentName, a> f9384d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public Set<String> f9385e = new HashSet();

        /* compiled from: NotificationManagerCompat.java */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final ComponentName f9386a;

            /* renamed from: c, reason: collision with root package name */
            public INotificationSideChannel f9388c;

            /* renamed from: b, reason: collision with root package name */
            public boolean f9387b = false;

            /* renamed from: d, reason: collision with root package name */
            public ArrayDeque<e> f9389d = new ArrayDeque<>();

            /* renamed from: e, reason: collision with root package name */
            public int f9390e = 0;

            public a(ComponentName componentName) {
                this.f9386a = componentName;
            }
        }

        public d(Context context) {
            this.f9381a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f9382b = handlerThread;
            handlerThread.start();
            this.f9383c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f9387b) {
                return true;
            }
            boolean bindService = this.f9381a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f9386a), this, 33);
            aVar.f9387b = bindService;
            if (bindService) {
                aVar.f9390e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f9386a);
                this.f9381a.unbindService(this);
            }
            return aVar.f9387b;
        }

        public final void b(a aVar) {
            if (aVar.f9387b) {
                this.f9381a.unbindService(this);
                aVar.f9387b = false;
            }
            aVar.f9388c = null;
        }

        public final void c(e eVar) {
            j();
            for (a aVar : this.f9384d.values()) {
                aVar.f9389d.add(eVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = this.f9384d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f9384d.get(componentName);
            if (aVar != null) {
                aVar.f9388c = INotificationSideChannel.Stub.N7(iBinder);
                aVar.f9390e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = this.f9384d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f9386a + ", " + aVar.f9389d.size() + " queued tasks");
            }
            if (aVar.f9389d.isEmpty()) {
                return;
            }
            if (a(aVar) && aVar.f9388c != null) {
                while (true) {
                    e peek = aVar.f9389d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.a(aVar.f9388c);
                        aVar.f9389d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f9386a);
                        }
                    } catch (RemoteException e10) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f9386a, e10);
                    }
                }
                if (!aVar.f9389d.isEmpty()) {
                    i(aVar);
                    return;
                }
                return;
            }
            i(aVar);
        }

        public void h(e eVar) {
            this.f9383c.obtainMessage(0, eVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return false;
                        }
                        d((ComponentName) message.obj);
                        return true;
                    }
                    f((ComponentName) message.obj);
                    return true;
                }
                c cVar = (c) message.obj;
                e(cVar.f9379a, cVar.f9380b);
                return true;
            }
            c((e) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f9383c.hasMessages(3, aVar.f9386a)) {
                return;
            }
            int i10 = aVar.f9390e;
            int i11 = i10 + 1;
            aVar.f9390e = i11;
            if (i11 > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + aVar.f9389d.size() + " tasks to " + aVar.f9386a + " after " + aVar.f9390e + " retries");
                aVar.f9389d.clear();
                return;
            }
            int i12 = (1 << i10) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i12 + " ms");
            }
            this.f9383c.sendMessageDelayed(this.f9383c.obtainMessage(3, aVar.f9386a), i12);
        }

        public final void j() {
            Set<String> d10 = i.d(this.f9381a);
            if (d10.equals(this.f9385e)) {
                return;
            }
            this.f9385e = d10;
            List<ResolveInfo> queryIntentServices = this.f9381a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (d10.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f9384d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f9384d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f9384d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f9383c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f9383c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(INotificationSideChannel iNotificationSideChannel);
    }

    public i(Context context) {
        this.f9373a = context;
        this.f9374b = (NotificationManager) context.getSystemService("notification");
    }

    public static i c(Context context) {
        return new i(context);
    }

    public static Set<String> d(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f9368c) {
            if (string != null) {
                try {
                    if (!string.equals(f9369d)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet.add(unflattenFromString.getPackageName());
                            }
                        }
                        f9370e = hashSet;
                        f9369d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f9370e;
        }
        return set;
    }

    public static boolean h(Notification notification) {
        Bundle a10 = h.a(notification);
        if (a10 != null && a10.getBoolean("android.support.useSideChannel")) {
            return true;
        }
        return false;
    }

    public void a(String str, int i10) {
        this.f9374b.cancel(str, i10);
    }

    public void b(NotificationChannel notificationChannel) {
        a.a(this.f9374b, notificationChannel);
    }

    public NotificationChannel e(String str) {
        return a.b(this.f9374b, str);
    }

    public void f(String str, int i10, Notification notification) {
        if (h(notification)) {
            g(new b(this.f9373a.getPackageName(), i10, str, notification));
            this.f9374b.cancel(str, i10);
        } else {
            this.f9374b.notify(str, i10, notification);
        }
    }

    public final void g(e eVar) {
        synchronized (f9371f) {
            try {
                if (f9372g == null) {
                    f9372g = new d(this.f9373a.getApplicationContext());
                }
                f9372g.h(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
