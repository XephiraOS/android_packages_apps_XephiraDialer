package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p.C1415a;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f6936b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    public final c f6937a;

    /* loaded from: classes.dex */
    public static class ItemReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public void b(int i10, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i10 == 0) {
                if (bundle != null) {
                    if (bundle.containsKey("media_item")) {
                        Parcelable parcelable = bundle.getParcelable("media_item");
                        if (parcelable != null && !(parcelable instanceof MediaItem)) {
                            throw null;
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class SearchResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public void b(int i10, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i10 == 0) {
                if (bundle != null) {
                    if (bundle.containsKey("search_results")) {
                        Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
                        if (parcelableArray != null) {
                            ArrayList arrayList = new ArrayList();
                            for (Parcelable parcelable : parcelableArray) {
                                arrayList.add((MediaItem) parcelable);
                            }
                            throw null;
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<g> f6940a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference<Messenger> f6941b;

        public a(g gVar) {
            this.f6940a = new WeakReference<>(gVar);
        }

        public void a(Messenger messenger) {
            this.f6941b = new WeakReference<>(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<Messenger> weakReference = this.f6941b;
            if (weakReference != null && weakReference.get() != null && this.f6940a.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.a(data);
                g gVar = this.f6940a.get();
                Messenger messenger = this.f6941b.get();
                try {
                    int i10 = message.what;
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                            } else {
                                Bundle bundle = data.getBundle("data_options");
                                MediaSessionCompat.a(bundle);
                                Bundle bundle2 = data.getBundle("data_notify_children_changed_options");
                                MediaSessionCompat.a(bundle2);
                                gVar.h(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle, bundle2);
                            }
                        } else {
                            gVar.i(messenger);
                        }
                    } else {
                        Bundle bundle3 = data.getBundle("data_root_hints");
                        MediaSessionCompat.a(bundle3);
                        gVar.g(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        gVar.i(messenger);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Object f6942a = android.support.v4.media.a.c(new C0095b());

        /* renamed from: b, reason: collision with root package name */
        public a f6943b;

        /* loaded from: classes.dex */
        public interface a {
            void b();

            void d();

            void e();
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0095b implements a.InterfaceC0096a {
            public C0095b() {
            }

            @Override // android.support.v4.media.a.InterfaceC0096a
            public void b() {
                a aVar = b.this.f6943b;
                if (aVar != null) {
                    aVar.b();
                }
                b.this.c();
            }

            @Override // android.support.v4.media.a.InterfaceC0096a
            public void d() {
                a aVar = b.this.f6943b;
                if (aVar != null) {
                    aVar.d();
                }
                b.this.a();
            }

            @Override // android.support.v4.media.a.InterfaceC0096a
            public void e() {
                a aVar = b.this.f6943b;
                if (aVar != null) {
                    aVar.e();
                }
                b.this.b();
            }
        }

        public void a() {
            throw null;
        }

        public void b() {
            throw null;
        }

        public void c() {
            throw null;
        }

        public void d(a aVar) {
            this.f6943b = aVar;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();

        void c();

        MediaSessionCompat.Token f();
    }

    /* loaded from: classes.dex */
    public static class e extends d {
        public e(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class f extends e {
        public f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void g(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void h(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void i(Messenger messenger);
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public Messenger f6955a;

        /* renamed from: b, reason: collision with root package name */
        public Bundle f6956b;

        public h(IBinder iBinder, Bundle bundle) {
            this.f6955a = new Messenger(iBinder);
            this.f6956b = bundle;
        }

        public void a(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.f6956b);
            b(6, bundle, messenger);
        }

        public final void b(int i10, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f6955a.send(obtain);
        }

        public void c(Messenger messenger) {
            b(7, null, messenger);
        }
    }

    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public final List<j> f6957a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final List<Bundle> f6958b = new ArrayList();

        public j a(Bundle bundle) {
            for (int i10 = 0; i10 < this.f6958b.size(); i10++) {
                if (androidx.media.a.a(this.f6958b.get(i10), bundle)) {
                    return this.f6957a.get(i10);
                }
            }
            return null;
        }

        public List<j> b() {
            return this.f6957a;
        }

        public List<Bundle> c() {
            return this.f6958b;
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        this.f6937a = new f(context, componentName, bVar, bundle);
    }

    public void a() {
        this.f6937a.a();
    }

    public void b() {
        this.f6937a.c();
    }

    public MediaSessionCompat.Token c() {
        return this.f6937a.f();
    }

    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f6938a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaDescriptionCompat f6939b;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<MediaItem> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i10) {
                return new MediaItem[i10];
            }
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
            if (mediaDescriptionCompat != null) {
                if (!TextUtils.isEmpty(mediaDescriptionCompat.f())) {
                    this.f6938a = i10;
                    this.f6939b = mediaDescriptionCompat;
                    return;
                }
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem b(Object obj) {
            if (obj != null) {
                return new MediaItem(MediaDescriptionCompat.b(a.c.a(obj)), a.c.b(obj));
            }
            return null;
        }

        public static List<MediaItem> d(List<?> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(b(it.next()));
                }
                return arrayList;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f6938a + ", mDescription=" + this.f6939b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f6938a);
            this.f6939b.writeToParcel(parcel, i10);
        }

        public MediaItem(Parcel parcel) {
            this.f6938a = parcel.readInt();
            this.f6939b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements c, g, b.a {

        /* renamed from: a, reason: collision with root package name */
        public final Context f6945a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f6946b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f6947c;

        /* renamed from: d, reason: collision with root package name */
        public final a f6948d = new a(this);

        /* renamed from: e, reason: collision with root package name */
        public final C1415a<String, i> f6949e = new C1415a<>();

        /* renamed from: f, reason: collision with root package name */
        public int f6950f;

        /* renamed from: g, reason: collision with root package name */
        public h f6951g;

        /* renamed from: h, reason: collision with root package name */
        public Messenger f6952h;

        /* renamed from: i, reason: collision with root package name */
        public MediaSessionCompat.Token f6953i;

        /* renamed from: j, reason: collision with root package name */
        public Bundle f6954j;

        public d(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            Bundle bundle2;
            this.f6945a = context;
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            this.f6947c = bundle2;
            bundle2.putInt("extra_client_version", 1);
            bVar.d(this);
            this.f6946b = android.support.v4.media.a.b(context, componentName, bVar.f6942a, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void a() {
            android.support.v4.media.a.a(this.f6946b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void b() {
            this.f6951g = null;
            this.f6952h = null;
            this.f6953i = null;
            this.f6948d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void c() {
            Messenger messenger;
            h hVar = this.f6951g;
            if (hVar != null && (messenger = this.f6952h) != null) {
                try {
                    hVar.c(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            android.support.v4.media.a.d(this.f6946b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void d() {
            Bundle e10 = android.support.v4.media.a.e(this.f6946b);
            if (e10 == null) {
                return;
            }
            this.f6950f = e10.getInt("extra_service_version", 0);
            IBinder a10 = androidx.core.app.e.a(e10, "extra_messenger");
            if (a10 != null) {
                this.f6951g = new h(a10, this.f6947c);
                Messenger messenger = new Messenger(this.f6948d);
                this.f6952h = messenger;
                this.f6948d.a(messenger);
                try {
                    this.f6951g.a(this.f6945a, this.f6952h);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
            IMediaSession N72 = IMediaSession.Stub.N7(androidx.core.app.e.a(e10, "extra_session_binder"));
            if (N72 != null) {
                this.f6953i = MediaSessionCompat.Token.d(android.support.v4.media.a.f(this.f6946b), N72);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public MediaSessionCompat.Token f() {
            if (this.f6953i == null) {
                this.f6953i = MediaSessionCompat.Token.b(android.support.v4.media.a.f(this.f6946b));
            }
            return this.f6953i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void h(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f6952h != messenger) {
                return;
            }
            i iVar = this.f6949e.get(str);
            if (iVar == null) {
                if (MediaBrowserCompat.f6936b) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            j a10 = iVar.a(bundle);
            if (a10 != null) {
                if (bundle == null) {
                    if (list == null) {
                        a10.c(str);
                        return;
                    }
                    this.f6954j = bundle2;
                    a10.a(str, list);
                    this.f6954j = null;
                    return;
                }
                if (list == null) {
                    a10.d(str, bundle);
                    return;
                }
                this.f6954j = bundle2;
                a10.b(str, list, bundle);
                this.f6954j = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void e() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void i(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void g(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class j {

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<i> f6961c;

        /* renamed from: b, reason: collision with root package name */
        public final IBinder f6960b = new Binder();

        /* renamed from: a, reason: collision with root package name */
        public final Object f6959a = android.support.v4.media.b.a(new b());

        /* loaded from: classes.dex */
        public class a implements a.d {
            public a() {
            }

            @Override // android.support.v4.media.a.d
            public void c(String str, List<?> list) {
                i iVar;
                WeakReference<i> weakReference = j.this.f6961c;
                if (weakReference == null) {
                    iVar = null;
                } else {
                    iVar = weakReference.get();
                }
                if (iVar == null) {
                    j.this.a(str, MediaItem.d(list));
                    return;
                }
                List<MediaItem> d10 = MediaItem.d(list);
                List<j> b10 = iVar.b();
                List<Bundle> c10 = iVar.c();
                for (int i10 = 0; i10 < b10.size(); i10++) {
                    Bundle bundle = c10.get(i10);
                    if (bundle == null) {
                        j.this.a(str, d10);
                    } else {
                        j.this.b(str, d(d10, bundle), bundle);
                    }
                }
            }

            public List<MediaItem> d(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i10 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i11 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i10 == -1 && i11 == -1) {
                    return list;
                }
                int i12 = i11 * i10;
                int i13 = i12 + i11;
                if (i10 >= 0 && i11 >= 1 && i12 < list.size()) {
                    if (i13 > list.size()) {
                        i13 = list.size();
                    }
                    return list.subList(i12, i13);
                }
                return Collections.emptyList();
            }

            @Override // android.support.v4.media.a.d
            public void onError(String str) {
                j.this.c(str);
            }
        }

        /* loaded from: classes.dex */
        public class b extends a implements b.a {
            public b() {
                super();
            }

            @Override // android.support.v4.media.b.a
            public void a(String str, Bundle bundle) {
                j.this.d(str, bundle);
            }

            @Override // android.support.v4.media.b.a
            public void b(String str, List<?> list, Bundle bundle) {
                j.this.b(str, MediaItem.d(list), bundle);
            }
        }

        public void c(String str) {
        }

        public void a(String str, List<MediaItem> list) {
        }

        public void d(String str, Bundle bundle) {
        }

        public void b(String str, List<MediaItem> list, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    public static class CustomActionResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public void b(int i10, Bundle bundle) {
        }
    }
}
