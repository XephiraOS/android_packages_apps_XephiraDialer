package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

/* compiled from: MediaBrowserCompatApi21.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: MediaBrowserCompatApi21.java */
    /* renamed from: android.support.v4.media.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0096a {
        void b();

        void d();

        void e();
    }

    /* compiled from: MediaBrowserCompatApi21.java */
    /* loaded from: classes.dex */
    public static class b<T extends InterfaceC0096a> extends MediaBrowser.ConnectionCallback {

        /* renamed from: a, reason: collision with root package name */
        public final T f6989a;

        public b(T t10) {
            this.f6989a = t10;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.f6989a.d();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.f6989a.e();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.f6989a.b();
        }
    }

    /* compiled from: MediaBrowserCompatApi21.java */
    /* loaded from: classes.dex */
    public static class c {
        public static Object a(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getDescription();
        }

        public static int b(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getFlags();
        }
    }

    /* compiled from: MediaBrowserCompatApi21.java */
    /* loaded from: classes.dex */
    public interface d {
        void c(String str, List<?> list);

        void onError(String str);
    }

    /* compiled from: MediaBrowserCompatApi21.java */
    /* loaded from: classes.dex */
    public static class e<T extends d> extends MediaBrowser.SubscriptionCallback {

        /* renamed from: a, reason: collision with root package name */
        public final T f6990a;

        public e(T t10) {
            this.f6990a = t10;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list) {
            this.f6990a.c(str, list);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str) {
            this.f6990a.onError(str);
        }
    }

    public static void a(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static Object b(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static Object c(InterfaceC0096a interfaceC0096a) {
        return new b(interfaceC0096a);
    }

    public static void d(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static Bundle e(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static Object f(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }
}
