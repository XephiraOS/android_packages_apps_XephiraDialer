package com.android.incallui;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class InCallVideoCallCallbackNotifier {
    public static final int CALL_SESSION_INVALID_EVENT = -1;
    private static InCallVideoCallCallbackNotifier sInstance = new InCallVideoCallCallbackNotifier();
    private final Set<SessionModificationListener> mSessionModificationListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private final Set<VideoEventListener> mVideoEventListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private final Set<SurfaceChangeListener> mSurfaceChangeListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private int mCallSessionEvent = -1;
    private Call mCall = null;

    /* loaded from: classes.dex */
    public interface SessionModificationListener {
        void onDowngradeToAudio(Call call);

        void onUpgradeToVideoFail(int i10, Call call);

        void onUpgradeToVideoRequest(Call call, int i10);

        void onUpgradeToVideoSuccess(Call call);
    }

    /* loaded from: classes.dex */
    public interface SurfaceChangeListener {
        void onCameraDimensionsChange(Call call, int i10, int i11);

        void onPeerDimensionsWithAngleChanged(Call call, int i10, int i11, int i12);

        void onUpdatePeerDimensions(Call call, int i10, int i11);
    }

    /* loaded from: classes.dex */
    public interface VideoEventListener {
        void onCallDataUsageChange(long j10);

        void onCallSessionEvent(Call call, int i10);

        void onVideoQualityChanged(Call call, int i10);
    }

    private InCallVideoCallCallbackNotifier() {
    }

    public static InCallVideoCallCallbackNotifier getInstance() {
        return sInstance;
    }

    public void addSessionModificationListener(SessionModificationListener sessionModificationListener) {
        com.google.common.base.k.o(sessionModificationListener);
        this.mSessionModificationListeners.add(sessionModificationListener);
    }

    public void addSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener) {
        com.google.common.base.k.o(surfaceChangeListener);
        this.mSurfaceChangeListeners.add(surfaceChangeListener);
    }

    public void addVideoEventListener(VideoEventListener videoEventListener) {
        com.google.common.base.k.o(videoEventListener);
        this.mVideoEventListeners.add(videoEventListener);
    }

    public void callDataUsageChanged(long j10) {
        Iterator<VideoEventListener> it = this.mVideoEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onCallDataUsageChange(j10);
        }
    }

    public void callSessionEvent(Call call, int i10) {
        Call call2;
        this.mCallSessionEvent = i10;
        this.mCall = call;
        Iterator<VideoEventListener> it = this.mVideoEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onCallSessionEvent(this.mCall, this.mCallSessionEvent);
        }
        if (this.mVideoEventListeners.isEmpty() && (call2 = this.mCall) != null) {
            this.mCall.setIsVideoResume(OplusPhoneUtils.getVideoResumeState(call2.getIsVideoResume(), i10));
        }
    }

    public void cameraDimensionsChanged(Call call, int i10, int i11) {
        Iterator<SurfaceChangeListener> it = this.mSurfaceChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onCameraDimensionsChange(call, i10, i11);
        }
    }

    public void downgradeToAudio(Call call) {
        Iterator<SessionModificationListener> it = this.mSessionModificationListeners.iterator();
        while (it.hasNext()) {
            it.next().onDowngradeToAudio(call);
        }
    }

    public void peerDimensionsChanged(Call call, int i10, int i11) {
        Iterator<SurfaceChangeListener> it = this.mSurfaceChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpdatePeerDimensions(call, i10, i11);
        }
        if (this.mSurfaceChangeListeners.isEmpty() && call != null) {
            call.setOplusPeerVideoRatio(i10, i11);
        }
    }

    public void removeSessionModificationListener(SessionModificationListener sessionModificationListener) {
        if (sessionModificationListener != null) {
            this.mSessionModificationListeners.remove(sessionModificationListener);
        }
    }

    public void removeSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener) {
        if (surfaceChangeListener != null) {
            this.mSurfaceChangeListeners.remove(surfaceChangeListener);
        }
    }

    public void removeVideoEventListener(VideoEventListener videoEventListener) {
        if (videoEventListener != null) {
            this.mVideoEventListeners.remove(videoEventListener);
        }
    }

    public void upgradeToVideoFail(int i10, Call call) {
        Iterator<SessionModificationListener> it = this.mSessionModificationListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpgradeToVideoFail(i10, call);
        }
    }

    public void upgradeToVideoRequest(Call call, int i10) {
        Log.d(this, "upgradeToVideoRequest call = " + call + " new video state = " + i10);
        Iterator<SessionModificationListener> it = this.mSessionModificationListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpgradeToVideoRequest(call, i10);
        }
    }

    public void upgradeToVideoSuccess(Call call) {
        Iterator<SessionModificationListener> it = this.mSessionModificationListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpgradeToVideoSuccess(call);
        }
    }

    public void videoQualityChanged(Call call, int i10) {
        Iterator<VideoEventListener> it = this.mVideoEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoQualityChanged(call, i10);
        }
    }
}
