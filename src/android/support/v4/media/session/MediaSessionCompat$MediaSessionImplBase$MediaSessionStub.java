package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import java.util.List;

/* loaded from: classes.dex */
class MediaSessionCompat$MediaSessionImplBase$MediaSessionStub extends IMediaSession.Stub {
    @Override // android.support.v4.media.session.IMediaSession
    public boolean A0() {
        return false;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void A1() {
        O7(3);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public PlaybackStateCompat C4() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void E0(RatingCompat ratingCompat) {
        Q7(19, ratingCompat);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void F5() {
        O7(7);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void G2(String str, Bundle bundle) {
        S7(9, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public int G6() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void H0(int i10, int i11, String str) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void I0(Uri uri, Bundle bundle) {
        S7(6, uri, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void J6(long j10) {
        Q7(11, Long.valueOf(j10));
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void L2() {
        O7(16);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean L3(KeyEvent keyEvent) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void L5(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
        Q7(1, new b(str, bundle, resultReceiverWrapper.f7014a));
    }

    @Override // android.support.v4.media.session.IMediaSession
    public List<MediaSessionCompat.QueueItem> M5() {
        throw null;
    }

    public void O7(int i10) {
        throw null;
    }

    public void P7(int i10, int i11) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public ParcelableVolumeInfo Q6() {
        throw null;
    }

    public void Q7(int i10, Object obj) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void R2(Uri uri, Bundle bundle) {
        S7(10, uri, bundle);
    }

    public void R7(int i10, Object obj, int i11) {
        throw null;
    }

    public void S7(int i10, Object obj, Bundle bundle) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public int T4() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void V5(int i10) {
        P7(23, i10);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void Y0(MediaDescriptionCompat mediaDescriptionCompat) {
        Q7(27, mediaDescriptionCompat);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void Z3(int i10, int i11, String str) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void a5(int i10) {
        P7(28, i10);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean b1() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void d1(MediaDescriptionCompat mediaDescriptionCompat) {
        Q7(25, mediaDescriptionCompat);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void d6() {
        O7(17);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void e3(long j10) {
        Q7(18, Long.valueOf(j10));
    }

    @Override // android.support.v4.media.session.IMediaSession
    public CharSequence f2() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void f4(RatingCompat ratingCompat, Bundle bundle) {
        S7(31, ratingCompat, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void g7(int i10) {
        P7(30, i10);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public Bundle getExtras() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public String getPackageName() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public String getTag() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public PendingIntent j1() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void j4(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        R7(26, mediaDescriptionCompat, i10);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void l0(String str, Bundle bundle) {
        S7(20, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public MediaMetadataCompat m2() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public int n1() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void n2(String str, Bundle bundle) {
        S7(4, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void next() {
        O7(14);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void o() {
        O7(12);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean o5() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void p1(String str, Bundle bundle) {
        S7(5, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void p4(boolean z10) {
        Q7(29, Boolean.valueOf(z10));
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void previous() {
        O7(15);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void q2(IMediaControllerCallback iMediaControllerCallback) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void r0(IMediaControllerCallback iMediaControllerCallback) {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void stop() {
        O7(13);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public long w6() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void x2(String str, Bundle bundle) {
        S7(8, str, bundle);
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void M6(boolean z10) {
    }
}
