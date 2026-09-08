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
class MediaSessionCompat$MediaSessionImplApi21$ExtraSession extends IMediaSession.Stub {
    @Override // android.support.v4.media.session.IMediaSession
    public boolean A0() {
        return false;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void A1() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public PlaybackStateCompat C4() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void E0(RatingCompat ratingCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void F5() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void G2(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public int G6() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void H0(int i10, int i11, String str) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void I0(Uri uri, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void J6(long j10) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void L2() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean L3(KeyEvent keyEvent) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void L5(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public List<MediaSessionCompat.QueueItem> M5() {
        return null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public ParcelableVolumeInfo Q6() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void R2(Uri uri, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public int T4() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void V5(int i10) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void Y0(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void Z3(int i10, int i11, String str) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void a5(int i10) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean b1() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void d1(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void d6() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void e3(long j10) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public CharSequence f2() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void f4(RatingCompat ratingCompat, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void g7(int i10) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public Bundle getExtras() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public String getPackageName() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public String getTag() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public PendingIntent j1() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void j4(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void l0(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public MediaMetadataCompat m2() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public int n1() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void n2(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void next() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void o() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public boolean o5() {
        throw null;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void p1(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void p4(boolean z10) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void previous() {
        throw new AssertionError();
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
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public long w6() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void x2(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.IMediaSession
    public void M6(boolean z10) {
    }
}
