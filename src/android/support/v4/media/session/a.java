package android.support.v4.media.session;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.List;

/* compiled from: MediaControllerCompatApi21.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: MediaControllerCompatApi21.java */
    /* renamed from: android.support.v4.media.session.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0098a {
        void A();

        void a(Object obj);

        void b(int i10, int i11, int i12, int i13, int i14);

        void c(Object obj);

        void d(String str, Bundle bundle);

        void l(Bundle bundle);

        void n(List<?> list);

        void z(CharSequence charSequence);
    }

    /* compiled from: MediaControllerCompatApi21.java */
    /* loaded from: classes.dex */
    public static class b<T extends InterfaceC0098a> extends MediaController.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final T f7040a;

        public b(T t10) {
            this.f7040a = t10;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f7040a.b(playbackInfo.getPlaybackType(), c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f7040a.l(bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f7040a.a(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f7040a.c(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f7040a.n(list);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f7040a.z(charSequence);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f7040a.A();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f7040a.d(str, bundle);
        }
    }

    /* compiled from: MediaControllerCompatApi21.java */
    /* loaded from: classes.dex */
    public static class c {
        public static AudioAttributes a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return c(a(obj));
        }

        public static int c(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            int usage = audioAttributes.getUsage();
            if (usage == 13) {
                return 1;
            }
            switch (usage) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
    }

    public static Object a(InterfaceC0098a interfaceC0098a) {
        return new b(interfaceC0098a);
    }

    public static boolean b(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    public static Object c(Context context, Object obj) {
        return new MediaController(context, (MediaSession.Token) obj);
    }

    public static void d(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }
}
