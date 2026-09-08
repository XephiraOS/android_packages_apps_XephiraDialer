package android.support.v4.media.session;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    public final a f6993a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaSessionCompat.Token f6994b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet<Callback> f6995c = new HashSet<>();

    /* loaded from: classes.dex */
    public static class MediaControllerImplApi21 implements a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f7000a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f7001b = new Object();

        /* renamed from: c, reason: collision with root package name */
        public final List<Callback> f7002c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public HashMap<Callback, ExtraCallback> f7003d = new HashMap<>();

        /* renamed from: e, reason: collision with root package name */
        public final MediaSessionCompat.Token f7004e;

        /* loaded from: classes.dex */
        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            public WeakReference<MediaControllerImplApi21> f7005a;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f7005a = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i10, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f7005a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f7001b) {
                        mediaControllerImplApi21.f7004e.i(IMediaSession.Stub.N7(androidx.core.app.e.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.f7004e.j(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                        mediaControllerImplApi21.b();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public static class ExtraCallback extends Callback.StubCompat {
            public ExtraCallback(Callback callback) {
                super(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void A() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void M7(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void l(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void l4(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void n(List<MediaSessionCompat.QueueItem> list) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void z(CharSequence charSequence) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f7004e = token;
            Object c10 = android.support.v4.media.session.a.c(context, token.h());
            this.f7000a = c10;
            if (c10 != null) {
                if (token.f() == null) {
                    c();
                    return;
                }
                return;
            }
            throw new RemoteException();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public boolean a(KeyEvent keyEvent) {
            return android.support.v4.media.session.a.b(this.f7000a, keyEvent);
        }

        public void b() {
            if (this.f7004e.f() == null) {
                return;
            }
            for (Callback callback : this.f7002c) {
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.f7003d.put(callback, extraCallback);
                callback.f6997b = extraCallback;
                try {
                    this.f7004e.f().r0(extraCallback);
                    callback.i(13, null, null);
                } catch (RemoteException e10) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
                }
            }
            this.f7002c.clear();
        }

        public final void c() {
            d("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
            android.support.v4.media.session.a.d(this.f7000a, str, bundle, resultReceiver);
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        boolean a(KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    public static class b extends MediaControllerImplApi21 {
        public b(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f7006a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7007b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7008c;

        /* renamed from: d, reason: collision with root package name */
        public final int f7009d;

        /* renamed from: e, reason: collision with root package name */
        public final int f7010e;

        public d(int i10, int i11, int i12, int i13, int i14) {
            this.f7006a = i10;
            this.f7007b = i11;
            this.f7008c = i12;
            this.f7009d = i13;
            this.f7010e = i14;
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token != null) {
            this.f6994b = token;
            this.f6993a = new c(context, token);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f6993a.a(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    /* loaded from: classes.dex */
    public static abstract class Callback implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final Object f6996a = android.support.v4.media.session.a.a(new a(this));

        /* renamed from: b, reason: collision with root package name */
        public IMediaControllerCallback f6997b;

        /* loaded from: classes.dex */
        public static class a implements a.InterfaceC0098a {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference<Callback> f6999a;

            public a(Callback callback) {
                this.f6999a = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.a.InterfaceC0098a
            public void A() {
                Callback callback = this.f6999a.get();
                if (callback != null) {
                    callback.g();
                }
            }

            @Override // android.support.v4.media.session.a.InterfaceC0098a
            public void a(Object obj) {
                Callback callback = this.f6999a.get();
                if (callback != null) {
                    callback.c(MediaMetadataCompat.b(obj));
                }
            }

            @Override // android.support.v4.media.session.a.InterfaceC0098a
            public void b(int i10, int i11, int i12, int i13, int i14) {
                Callback callback = this.f6999a.get();
                if (callback != null) {
                    callback.a(new d(i10, i11, i12, i13, i14));
                }
            }

            @Override // android.support.v4.media.session.a.InterfaceC0098a
            public void c(Object obj) {
                Callback callback = this.f6999a.get();
                if (callback != null && callback.f6997b == null) {
                    callback.d(PlaybackStateCompat.b(obj));
                }
            }

            @Override // android.support.v4.media.session.a.InterfaceC0098a
            public void d(String str, Bundle bundle) {
                Callback callback = this.f6999a.get();
                if (callback != null) {
                    callback.h(str, bundle);
                }
            }

            @Override // android.support.v4.media.session.a.InterfaceC0098a
            public void l(Bundle bundle) {
                Callback callback = this.f6999a.get();
                if (callback != null) {
                    callback.b(bundle);
                }
            }

            @Override // android.support.v4.media.session.a.InterfaceC0098a
            public void n(List<?> list) {
                Callback callback = this.f6999a.get();
                if (callback != null) {
                    callback.e(MediaSessionCompat.QueueItem.d(list));
                }
            }

            @Override // android.support.v4.media.session.a.InterfaceC0098a
            public void z(CharSequence charSequence) {
                Callback callback = this.f6999a.get();
                if (callback != null) {
                    callback.f(charSequence);
                }
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            i(8, null, null);
        }

        /* loaded from: classes.dex */
        public static class StubCompat extends IMediaControllerCallback.Stub {

            /* renamed from: f, reason: collision with root package name */
            public final WeakReference<Callback> f6998f;

            public StubCompat(Callback callback) {
                this.f6998f = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void A() {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void A4(int i10) {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(9, Integer.valueOf(i10), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void B1() {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(13, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void E7(PlaybackStateCompat playbackStateCompat) {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void F7(String str, Bundle bundle) {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void M7(ParcelableVolumeInfo parcelableVolumeInfo) {
                d dVar;
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    if (parcelableVolumeInfo != null) {
                        dVar = new d(parcelableVolumeInfo.f7018a, parcelableVolumeInfo.f7019b, parcelableVolumeInfo.f7020c, parcelableVolumeInfo.f7021d, parcelableVolumeInfo.f7022e);
                    } else {
                        dVar = null;
                    }
                    callback.i(4, dVar, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void f3(boolean z10) {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(11, Boolean.valueOf(z10), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void l(Bundle bundle) {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(7, bundle, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void l4(MediaMetadataCompat mediaMetadataCompat) {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void n(List<MediaSessionCompat.QueueItem> list) {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void z(CharSequence charSequence) {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void z5(int i10) {
                Callback callback = this.f6998f.get();
                if (callback != null) {
                    callback.i(12, Integer.valueOf(i10), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void N3(boolean z10) {
            }
        }

        public void a(d dVar) {
        }

        public void b(Bundle bundle) {
        }

        public void c(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void d(PlaybackStateCompat playbackStateCompat) {
        }

        public void e(List<MediaSessionCompat.QueueItem> list) {
        }

        public void f(CharSequence charSequence) {
        }

        public void g() {
        }

        public void h(String str, Bundle bundle) {
        }

        public void i(int i10, Object obj, Bundle bundle) {
        }
    }
}
