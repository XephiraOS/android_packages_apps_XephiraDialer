package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

/* loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {

    /* loaded from: classes.dex */
    public static class a extends MediaBrowserCompat.b {

        /* renamed from: c, reason: collision with root package name */
        public final Context f10531c;

        /* renamed from: d, reason: collision with root package name */
        public final Intent f10532d;

        /* renamed from: e, reason: collision with root package name */
        public final BroadcastReceiver.PendingResult f10533e;

        /* renamed from: f, reason: collision with root package name */
        public MediaBrowserCompat f10534f;

        public a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f10531c = context;
            this.f10532d = intent;
            this.f10533e = pendingResult;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void a() {
            try {
                new MediaControllerCompat(this.f10531c, this.f10534f.c()).a((KeyEvent) this.f10532d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e10) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e10);
            }
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void b() {
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void c() {
            e();
        }

        public final void e() {
            this.f10534f.b();
            this.f10533e.finish();
        }

        public void f(MediaBrowserCompat mediaBrowserCompat) {
            this.f10534f = mediaBrowserCompat;
        }
    }

    public static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (queryIntentServices.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
    }

    public static void b(Context context, Intent intent) {
        context.startForegroundService(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            ComponentName a10 = a(context, "android.intent.action.MEDIA_BUTTON");
            if (a10 != null) {
                intent.setComponent(a10);
                b(context, intent);
                return;
            }
            ComponentName a11 = a(context, "android.media.browse.MediaBrowserService");
            if (a11 != null) {
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                a aVar = new a(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, a11, aVar, null);
                aVar.f(mediaBrowserCompat);
                mediaBrowserCompat.a();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
    }
}
