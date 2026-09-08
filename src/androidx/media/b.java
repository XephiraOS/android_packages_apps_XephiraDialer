package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MediaBrowserServiceCompatApi21.java */
/* loaded from: classes.dex */
public class b {

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10523a;

        /* renamed from: b, reason: collision with root package name */
        public final Bundle f10524b;
    }

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* renamed from: androidx.media.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0130b extends MediaBrowserService {

        /* renamed from: a, reason: collision with root package name */
        public final d f10525a;

        public C0130b(Context context, d dVar) {
            attachBaseContext(context);
            this.f10525a = dVar;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i10, Bundle bundle) {
            Bundle bundle2;
            MediaSessionCompat.a(bundle);
            d dVar = this.f10525a;
            if (bundle == null) {
                bundle2 = null;
            } else {
                bundle2 = new Bundle(bundle);
            }
            dVar.f(str, i10, bundle2);
            return null;
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.f10525a.c(str, new c<>(result));
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* loaded from: classes.dex */
    public static class c<T> {

        /* renamed from: a, reason: collision with root package name */
        public MediaBrowserService.Result f10526a;

        public c(MediaBrowserService.Result result) {
            this.f10526a = result;
        }

        public List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(T t10) {
            if (t10 instanceof List) {
                this.f10526a.sendResult(a((List) t10));
                return;
            }
            if (t10 instanceof Parcel) {
                Parcel parcel = (Parcel) t10;
                parcel.setDataPosition(0);
                this.f10526a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
                return;
            }
            this.f10526a.sendResult(null);
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* loaded from: classes.dex */
    public interface d {
        void c(String str, c<List<Parcel>> cVar);

        a f(String str, int i10, Bundle bundle);
    }

    public static IBinder a(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void b(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }
}
