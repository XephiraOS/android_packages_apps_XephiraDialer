package B3;

import android.content.Context;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.contacts.util.w;
import com.oplus.foundation.util.OsUtils;

/* compiled from: GlobalSoundManager.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    public static volatile c f248f;

    /* renamed from: a, reason: collision with root package name */
    public SoundPool f249a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f250b = 0;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f251c = false;

    /* renamed from: d, reason: collision with root package name */
    public final a f252d;

    /* renamed from: e, reason: collision with root package name */
    public final HandlerThread f253e;

    /* compiled from: GlobalSoundManager.java */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (H7.a.b()) {
                H7.b.b("GlobalSoundManager", "GlobalSoundHandler: message: " + message.what);
            }
            if (message.what == 1) {
                c.this.f();
            }
        }
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread("global_sound_thread");
        this.f253e = handlerThread;
        handlerThread.start();
        this.f252d = new a(handlerThread.getLooper());
    }

    public static c d() {
        if (f248f == null) {
            synchronized (c.class) {
                try {
                    if (f248f == null) {
                        f248f = new c();
                    }
                } finally {
                }
            }
        }
        return f248f;
    }

    public static String e(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, new String[]{"_data"}, "_display_name like ?", new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(0);
                            query.close();
                            return string;
                        }
                    } finally {
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e10) {
                H7.b.c("GlobalSoundManager", "getSoundPathByProvider error:" + e10);
            }
        }
        return null;
    }

    public final SoundPool c() {
        return new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(1).build()).build();
    }

    public final void f() {
        String str;
        if (this.f251c) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            final ContactsApplication h10 = ContactsApplication.h();
            if (OsUtils.f28275a.i()) {
                str = e(h10, "global_delete.ogg");
            } else {
                str = "/system/media/audio/ui/global_delete.ogg";
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.f249a == null) {
                    this.f249a = c();
                }
                this.f250b = this.f249a.load(str, 1);
                this.f249a.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: B3.b
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public final void onLoadComplete(SoundPool soundPool, int i10, int i11) {
                        c.this.g(h10, soundPool, i10, i11);
                    }
                });
            } else {
                this.f251c = true;
                this.f253e.quitSafely();
                j();
                H7.b.i("GlobalSoundManager", "initGlobalSound: no audio source!");
            }
            if (H7.a.b()) {
                H7.b.b("GlobalSoundManager", "initGlobalSound: take: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (Exception e10) {
            H7.b.c("GlobalSoundManager", "initGlobalSound: exception: " + e10);
        }
    }

    public final /* synthetic */ void g(ContactsApplication contactsApplication, SoundPool soundPool, int i10, int i11) {
        this.f251c = true;
        this.f253e.quitSafely();
        j();
        boolean i12 = i(contactsApplication);
        if (H7.a.b()) {
            H7.b.b("GlobalSoundManager", "initGlobalSound: onComplete: source: " + this.f250b + ", on: " + i12);
        }
        int i13 = this.f250b;
        if (i13 != 0 && i12) {
            this.f249a.play(i13, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public void h() {
        H7.b.e("GlobalSoundManager", "playDeleteSound: mPrepared: " + this.f251c + ", mDeleteSource: " + this.f250b);
        try {
            if (this.f251c) {
                j();
                if (this.f250b != 0) {
                    if (i(ContactsApplication.h())) {
                        if (this.f249a == null) {
                            this.f249a = c();
                        }
                        this.f249a.play(this.f250b, 1.0f, 1.0f, 1, 0, 1.0f);
                        return;
                    }
                    H7.b.e("GlobalSoundManager", "Global deletion sound is off!");
                    return;
                }
                H7.b.i("GlobalSoundManager", "No source for deletion audio!");
                return;
            }
            boolean k10 = w.k(P7.a.f2962b, w.e());
            Message obtain = Message.obtain();
            if (k10) {
                obtain.what = 1;
            } else {
                obtain.what = 2;
                H7.b.i("GlobalSoundManager", "No access permission for deletion audio!");
            }
            this.f252d.sendMessage(obtain);
        } catch (Exception e10) {
            H7.b.c("GlobalSoundManager", "playDeleteSound: exception: " + e10);
        }
    }

    public boolean i(Context context) {
        try {
            if (G0.c.d(context, 2, "global_delete_sound", 1) == 0) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            H7.b.c("GlobalSoundManager", "exception in readGlobalSound = " + e10);
            return false;
        }
    }

    public final void j() {
    }
}
