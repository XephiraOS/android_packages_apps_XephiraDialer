package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.b;
import androidx.media.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p.C1415a;

/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f10436f = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    public g f10437a;

    /* renamed from: c, reason: collision with root package name */
    public f f10439c;

    /* renamed from: e, reason: collision with root package name */
    public MediaSessionCompat.Token f10441e;

    /* renamed from: b, reason: collision with root package name */
    public final C1415a<IBinder, f> f10438b = new C1415a<>();

    /* renamed from: d, reason: collision with root package name */
    public final p f10440d = new p();

    /* loaded from: classes.dex */
    public class a extends l<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f10442f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f10443g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Bundle f10444h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Bundle f10445i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f10442f = fVar;
            this.f10443g = str;
            this.f10444h = bundle;
            this.f10445i = bundle2;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List<MediaBrowserCompat.MediaItem> list) {
            if (MediaBrowserServiceCompat.this.f10438b.get(this.f10442f.f10458f.asBinder()) != this.f10442f) {
                if (MediaBrowserServiceCompat.f10436f) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f10442f.f10453a + " id=" + this.f10443g);
                    return;
                }
                return;
            }
            if ((a() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, this.f10444h);
            }
            try {
                this.f10442f.f10458f.a(this.f10443g, list, this.f10444h, this.f10445i);
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.f10443g + " package=" + this.f10442f.f10453a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends l<MediaBrowserCompat.MediaItem> {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f10447f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f10447f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(MediaBrowserCompat.MediaItem mediaItem) {
            if ((a() & 2) != 0) {
                this.f10447f.d(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", mediaItem);
            this.f10447f.d(0, bundle);
        }
    }

    /* loaded from: classes.dex */
    public class c extends l<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f10449f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f10449f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List<MediaBrowserCompat.MediaItem> list) {
            if ((a() & 4) == 0 && list != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                this.f10449f.d(0, bundle);
                return;
            }
            this.f10449f.d(-1, null);
        }
    }

    /* loaded from: classes.dex */
    public class d extends l<Bundle> {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f10451f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f10451f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.l
        public void c(Bundle bundle) {
            this.f10451f.d(-1, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(Bundle bundle) {
            this.f10451f.d(0, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static final class e {
    }

    /* loaded from: classes.dex */
    public class f implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final String f10453a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10454b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10455c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.media.f f10456d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f10457e;

        /* renamed from: f, reason: collision with root package name */
        public final n f10458f;

        /* renamed from: g, reason: collision with root package name */
        public final HashMap<String, List<I.d<IBinder, Bundle>>> f10459g = new HashMap<>();

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                MediaBrowserServiceCompat.this.f10438b.remove(fVar.f10458f.asBinder());
            }
        }

        public f(String str, int i10, int i11, Bundle bundle, n nVar) {
            this.f10453a = str;
            this.f10454b = i10;
            this.f10455c = i11;
            this.f10456d = new androidx.media.f(str, i10, i11);
            this.f10457e = bundle;
            this.f10458f = nVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f10440d.post(new a());
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a();

        IBinder d(Intent intent);
    }

    /* loaded from: classes.dex */
    public class h implements g, b.d {

        /* renamed from: a, reason: collision with root package name */
        public final List<Bundle> f10462a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public Object f10463b;

        /* renamed from: c, reason: collision with root package name */
        public Messenger f10464c;

        /* loaded from: classes.dex */
        public class a extends l<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b.c f10466f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, b.c cVar) {
                super(obj);
                this.f10466f = cVar;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f10466f.b(arrayList);
            }
        }

        public h() {
        }

        @Override // androidx.media.b.d
        public void c(String str, b.c<List<Parcel>> cVar) {
            MediaBrowserServiceCompat.this.f(str, new a(str, cVar));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public IBinder d(Intent intent) {
            return androidx.media.b.a(this.f10463b, intent);
        }

        @Override // androidx.media.b.d
        public b.a f(String str, int i10, Bundle bundle) {
            IBinder asBinder;
            if (bundle != null && bundle.getInt("extra_client_version", 0) != 0) {
                bundle.remove("extra_client_version");
                this.f10464c = new Messenger(MediaBrowserServiceCompat.this.f10440d);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                androidx.core.app.e.b(bundle2, "extra_messenger", this.f10464c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f10441e;
                if (token != null) {
                    IMediaSession f10 = token.f();
                    if (f10 == null) {
                        asBinder = null;
                    } else {
                        asBinder = f10.asBinder();
                    }
                    androidx.core.app.e.b(bundle2, "extra_session_binder", asBinder);
                } else {
                    this.f10462a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f10439c = new f(str, -1, i10, bundle, null);
            MediaBrowserServiceCompat.this.e(str, i10, bundle);
            MediaBrowserServiceCompat.this.f10439c = null;
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class i extends h implements androidx.media.d {

        /* loaded from: classes.dex */
        public class a extends l<MediaBrowserCompat.MediaItem> {

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b.c f10469f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, b.c cVar) {
                super(obj);
                this.f10469f = cVar;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f10469f.b(null);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                this.f10469f.b(obtain);
            }
        }

        public i() {
            super();
        }

        @Override // androidx.media.d
        public void b(String str, b.c<Parcel> cVar) {
            MediaBrowserServiceCompat.this.h(str, new a(str, cVar));
        }
    }

    /* loaded from: classes.dex */
    public class j extends i implements e.c {

        /* loaded from: classes.dex */
        public class a extends l<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ e.b f10472f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, e.b bVar) {
                super(obj);
                this.f10472f = bVar;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f10472f.b(arrayList, a());
            }
        }

        public j() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void a() {
            Object a10 = androidx.media.e.a(MediaBrowserServiceCompat.this, this);
            this.f10463b = a10;
            androidx.media.b.b(a10);
        }

        @Override // androidx.media.e.c
        public void e(String str, e.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.g(str, new a(str, bVar), bundle);
        }
    }

    /* loaded from: classes.dex */
    public class k extends j {
        public k() {
            super();
        }
    }

    /* loaded from: classes.dex */
    public static class l<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f10475a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10476b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10477c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10478d;

        /* renamed from: e, reason: collision with root package name */
        public int f10479e;

        public l(Object obj) {
            this.f10475a = obj;
        }

        public int a() {
            return this.f10479e;
        }

        public boolean b() {
            if (!this.f10476b && !this.f10477c && !this.f10478d) {
                return false;
            }
            return true;
        }

        public void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f10475a);
        }

        public void d(T t10) {
            throw null;
        }

        public void e(Bundle bundle) {
            if (!this.f10477c && !this.f10478d) {
                this.f10478d = true;
                c(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f10475a);
            }
        }

        public void f(T t10) {
            if (!this.f10477c && !this.f10478d) {
                this.f10477c = true;
                d(t10);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f10475a);
            }
        }

        public void g(int i10) {
            this.f10479e = i10;
        }
    }

    /* loaded from: classes.dex */
    public class m {

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f10481a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f10482b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f10483c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f10484d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Bundle f10485e;

            public a(n nVar, String str, int i10, int i11, Bundle bundle) {
                this.f10481a = nVar;
                this.f10482b = str;
                this.f10483c = i10;
                this.f10484d = i11;
                this.f10485e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaBrowserServiceCompat.this.f10438b.remove(this.f10481a.asBinder());
                f fVar = new f(this.f10482b, this.f10483c, this.f10484d, this.f10485e, this.f10481a);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f10439c = fVar;
                mediaBrowserServiceCompat.e(this.f10482b, this.f10484d, this.f10485e);
                MediaBrowserServiceCompat.this.f10439c = null;
                Log.i("MBServiceCompat", "No root for client " + this.f10482b + " from service " + getClass().getName());
                try {
                    this.f10481a.b();
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f10482b);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f10487a;

            public b(n nVar) {
                this.f10487a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f remove = MediaBrowserServiceCompat.this.f10438b.remove(this.f10487a.asBinder());
                if (remove != null) {
                    remove.f10458f.asBinder().unlinkToDeath(remove, 0);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f10489a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f10490b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IBinder f10491c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Bundle f10492d;

            public c(n nVar, String str, IBinder iBinder, Bundle bundle) {
                this.f10489a = nVar;
                this.f10490b = str;
                this.f10491c = iBinder;
                this.f10492d = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10438b.get(this.f10489a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f10490b);
                    return;
                }
                MediaBrowserServiceCompat.this.a(this.f10490b, fVar, this.f10491c, this.f10492d);
            }
        }

        /* loaded from: classes.dex */
        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f10494a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f10495b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IBinder f10496c;

            public d(n nVar, String str, IBinder iBinder) {
                this.f10494a = nVar;
                this.f10495b = str;
                this.f10496c = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10438b.get(this.f10494a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f10495b);
                    return;
                }
                if (!MediaBrowserServiceCompat.this.p(this.f10495b, fVar, this.f10496c)) {
                    Log.w("MBServiceCompat", "removeSubscription called for " + this.f10495b + " which is not subscribed");
                }
            }
        }

        /* loaded from: classes.dex */
        public class e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f10498a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f10499b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f10500c;

            public e(n nVar, String str, ResultReceiver resultReceiver) {
                this.f10498a = nVar;
                this.f10499b = str;
                this.f10500c = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10438b.get(this.f10498a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f10499b);
                    return;
                }
                MediaBrowserServiceCompat.this.n(this.f10499b, fVar, this.f10500c);
            }
        }

        /* loaded from: classes.dex */
        public class f implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f10502a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f10503b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f10504c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f10505d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Bundle f10506e;

            public f(n nVar, String str, int i10, int i11, Bundle bundle) {
                this.f10502a = nVar;
                this.f10503b = str;
                this.f10504c = i10;
                this.f10505d = i11;
                this.f10506e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder asBinder = this.f10502a.asBinder();
                MediaBrowserServiceCompat.this.f10438b.remove(asBinder);
                f fVar = new f(this.f10503b, this.f10504c, this.f10505d, this.f10506e, this.f10502a);
                MediaBrowserServiceCompat.this.f10438b.put(asBinder, fVar);
                try {
                    asBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
            }
        }

        /* loaded from: classes.dex */
        public class g implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f10508a;

            public g(n nVar) {
                this.f10508a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder asBinder = this.f10508a.asBinder();
                f remove = MediaBrowserServiceCompat.this.f10438b.remove(asBinder);
                if (remove != null) {
                    asBinder.unlinkToDeath(remove, 0);
                }
            }
        }

        /* loaded from: classes.dex */
        public class h implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f10510a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f10511b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f10512c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f10513d;

            public h(n nVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f10510a = nVar;
                this.f10511b = str;
                this.f10512c = bundle;
                this.f10513d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10438b.get(this.f10510a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f10511b);
                    return;
                }
                MediaBrowserServiceCompat.this.o(this.f10511b, this.f10512c, fVar, this.f10513d);
            }
        }

        /* loaded from: classes.dex */
        public class i implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f10515a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f10516b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f10517c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f10518d;

            public i(n nVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f10515a = nVar;
                this.f10516b = str;
                this.f10517c = bundle;
                this.f10518d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10438b.get(this.f10515a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f10516b + ", extras=" + this.f10517c);
                    return;
                }
                MediaBrowserServiceCompat.this.l(this.f10516b, this.f10517c, fVar, this.f10518d);
            }
        }

        public m() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, n nVar) {
            MediaBrowserServiceCompat.this.f10440d.a(new c(nVar, str, iBinder, bundle));
        }

        public void b(String str, int i10, int i11, Bundle bundle, n nVar) {
            if (MediaBrowserServiceCompat.this.c(str, i11)) {
                MediaBrowserServiceCompat.this.f10440d.a(new a(nVar, str, i10, i11, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i11 + " package=" + str);
        }

        public void c(n nVar) {
            MediaBrowserServiceCompat.this.f10440d.a(new b(nVar));
        }

        public void d(String str, ResultReceiver resultReceiver, n nVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f10440d.a(new e(nVar, str, resultReceiver));
            }
        }

        public void e(n nVar, String str, int i10, int i11, Bundle bundle) {
            MediaBrowserServiceCompat.this.f10440d.a(new f(nVar, str, i10, i11, bundle));
        }

        public void f(String str, IBinder iBinder, n nVar) {
            MediaBrowserServiceCompat.this.f10440d.a(new d(nVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, n nVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f10440d.a(new h(nVar, str, bundle, resultReceiver));
            }
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, n nVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f10440d.a(new i(nVar, str, bundle, resultReceiver));
            }
        }

        public void i(n nVar) {
            MediaBrowserServiceCompat.this.f10440d.a(new g(nVar));
        }
    }

    /* loaded from: classes.dex */
    public interface n {
        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        void b();
    }

    /* loaded from: classes.dex */
    public static class o implements n {

        /* renamed from: a, reason: collision with root package name */
        public final Messenger f10520a;

        public o(Messenger messenger) {
            this.f10520a = messenger;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) {
            ArrayList<? extends Parcelable> arrayList;
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                if (list instanceof ArrayList) {
                    arrayList = (ArrayList) list;
                } else {
                    arrayList = new ArrayList<>(list);
                }
                bundle3.putParcelableArrayList("data_media_item_list", arrayList);
            }
            c(3, bundle3);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public IBinder asBinder() {
            return this.f10520a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public void b() {
            c(2, null);
        }

        public final void c(int i10, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f10520a.send(obtain);
        }
    }

    /* loaded from: classes.dex */
    public final class p extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final m f10521a;

        public p() {
            this.f10521a = new m();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    this.f10521a.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new o(message.replyTo));
                    return;
                case 2:
                    this.f10521a.c(new o(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    this.f10521a.a(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), bundle2, new o(message.replyTo));
                    return;
                case 4:
                    this.f10521a.f(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), new o(message.replyTo));
                    return;
                case 5:
                    this.f10521a.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    this.f10521a.e(new o(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.f10521a.i(new o(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.a(bundle4);
                    this.f10521a.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.a(bundle5);
                    this.f10521a.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j10) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j10);
        }
    }

    public void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<I.d<IBinder, Bundle>> list = fVar.f10459g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (I.d<IBinder, Bundle> dVar : list) {
            if (iBinder == dVar.f1295a && androidx.media.a.a(bundle, dVar.f1296b)) {
                return;
            }
        }
        list.add(new I.d<>(iBinder, bundle));
        fVar.f10459g.put(str, list);
        m(str, fVar, bundle, null);
        this.f10439c = fVar;
        j(str, bundle);
        this.f10439c = null;
    }

    public List<MediaBrowserCompat.MediaItem> b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
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

    public boolean c(String str, int i10) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i10)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(String str, Bundle bundle, l<Bundle> lVar) {
        lVar.e(null);
    }

    public abstract e e(String str, int i10, Bundle bundle);

    public abstract void f(String str, l<List<MediaBrowserCompat.MediaItem>> lVar);

    public void g(String str, l<List<MediaBrowserCompat.MediaItem>> lVar, Bundle bundle) {
        lVar.g(1);
        f(str, lVar);
    }

    public void h(String str, l<MediaBrowserCompat.MediaItem> lVar) {
        lVar.g(2);
        lVar.f(null);
    }

    public void i(String str, Bundle bundle, l<List<MediaBrowserCompat.MediaItem>> lVar) {
        lVar.g(4);
        lVar.f(null);
    }

    public void l(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.f10439c = fVar;
        d(str, bundle, dVar);
        this.f10439c = null;
        if (dVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    public void m(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.f10439c = fVar;
        if (bundle == null) {
            f(str, aVar);
        } else {
            g(str, aVar, bundle);
        }
        this.f10439c = null;
        if (aVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.f10453a + " id=" + str);
    }

    public void n(String str, f fVar, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.f10439c = fVar;
        h(str, bVar);
        this.f10439c = null;
        if (bVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    public void o(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.f10439c = fVar;
        i(str, bundle, cVar);
        this.f10439c = null;
        if (cVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f10437a.d(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        k kVar = new k();
        this.f10437a = kVar;
        kVar.a();
    }

    public boolean p(String str, f fVar, IBinder iBinder) {
        boolean z10 = false;
        try {
            if (iBinder == null) {
                if (fVar.f10459g.remove(str) != null) {
                    z10 = true;
                }
            } else {
                List<I.d<IBinder, Bundle>> list = fVar.f10459g.get(str);
                if (list != null) {
                    Iterator<I.d<IBinder, Bundle>> it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == it.next().f1295a) {
                            it.remove();
                            z10 = true;
                        }
                    }
                    if (list.size() == 0) {
                        fVar.f10459g.remove(str);
                    }
                }
            }
            return z10;
        } finally {
            this.f10439c = fVar;
            k(str);
            this.f10439c = null;
        }
    }

    public void k(String str) {
    }

    public void j(String str, Bundle bundle) {
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
