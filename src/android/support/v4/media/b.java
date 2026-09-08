package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.a;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

/* compiled from: MediaBrowserCompatApi26.java */
/* loaded from: classes.dex */
public class b {

    /* compiled from: MediaBrowserCompatApi26.java */
    /* loaded from: classes.dex */
    public interface a extends a.d {
        void a(String str, Bundle bundle);

        void b(String str, List<?> list, Bundle bundle);
    }

    /* compiled from: MediaBrowserCompatApi26.java */
    /* renamed from: android.support.v4.media.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0097b<T extends a> extends a.e<T> {
        public C0097b(T t10) {
            super(t10);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((a) this.f6990a).b(str, list, bundle);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((a) this.f6990a).a(str, bundle);
        }
    }

    public static Object a(a aVar) {
        return new C0097b(aVar);
    }
}
