package com.android.incallui;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Handler;
import android.os.PowerManager;
import android.telecom.DisconnectCause;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusProximitySensor;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.internal_dependency.InternalSdkDepends;

/* loaded from: classes.dex */
public class OplusProximitySensor extends ProximitySensor implements CallList.Listener {
    private static final String LOG_TAG = "OplusProximitySensor";
    private static final int OPLUS_TIME_DELAY_UPDATE_PROXIMITY = 100;
    private static final int TYPE_FUSION_PROXIMITY = 33171067;
    private AudioManager mAudioManager;
    private DisconnectCause mDisconnectCause;
    private boolean mHasVideoCall;
    private boolean mIsPhoneRing;
    private boolean mIsProximityNear;
    private long mNearCount;
    private Sensor mProximity;
    private final SensorEventListener mProximitySensorListener;
    private SensorManager mSensorManager;

    public OplusProximitySensor(Context context, AudioModeProvider audioModeProvider) {
        super(context, audioModeProvider);
        this.mIsProximityNear = false;
        this.mIsPhoneRing = false;
        this.mDisconnectCause = new DisconnectCause(0);
        this.mHasVideoCall = false;
        this.mNearCount = 0L;
        this.mProximitySensorListener = new AnonymousClass1();
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(TYPE_FUSION_PROXIMITY, true);
        this.mProximity = defaultSensor;
        if (defaultSensor == null) {
            K2.a.i(LOG_TAG, "mProximity TYPE_FUSION_PROXIMITY null");
            this.mProximity = this.mSensorManager.getDefaultSensor(8);
        }
        if (this.mProximity != null) {
            K2.a.i(LOG_TAG, "mProximity name:" + this.mProximity.getName() + ",mProximity type:" + this.mProximity.getType());
        }
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        CallList.getInstance().addListener(this);
    }

    public static /* synthetic */ long access$108(OplusProximitySensor oplusProximitySensor) {
        long j10 = oplusProximitySensor.mNearCount;
        oplusProximitySensor.mNearCount = 1 + j10;
        return j10;
    }

    private boolean isAutoScreenOff() {
        if (proximitySensorModeEnabled()) {
            synchronized (this.mProximityWakeLock) {
                try {
                    if (this.mUiShowing && !OplusPhoneUtils.isScreenOn(this.mContext)) {
                        if (Log.sDebug) {
                            Log.d(LOG_TAG, "when the screen is off, report far away not release WakeLock");
                        }
                        return true;
                    }
                    return false;
                } finally {
                }
            }
        }
        return false;
    }

    private boolean isNotNeedSensorForFoldScreen() {
        if (!OplusFeatureOption.FEATURE_FOLD) {
            return false;
        }
        return L1.c.f() ^ ResponsiveConfigRepository.f18540a.F1();
    }

    private boolean isWiredHeadSet() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                int type = audioDeviceInfo.getType();
                Log.d(LOG_TAG, "device type " + type);
                if (type == 3 || type == 4 || type == 22) {
                    return true;
                }
            }
        }
        return false;
    }

    private void postDelayedUpdateProximityRunnable(int i10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "postDelayedUpdateProximityRunnable time = " + i10);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.android.incallui.OplusProximitySensor.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Log.sDebug) {
                        Log.d(OplusProximitySensor.LOG_TAG, "do update proximity runnable");
                    }
                    OplusProximitySensor.this.oplusUpdateProximitySensorMode();
                }
            }, i10);
        }
    }

    private void releaseWakeLock(int i10) {
        try {
            PowerManager.WakeLock wakeLock = this.mProximityWakeLock;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.mProximityWakeLock.release(i10);
            }
        } catch (IllegalStateException e10) {
            Log.e(Log.TAG, "release Wake lock exception " + e10.getMessage());
        }
    }

    private void turnOffProximitySensor(boolean z10) {
        if (this.mProximityWakeLock.isHeld()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "turning off proximity sensor: releasing");
            }
            int i10 = 0;
            if (this.mDisconnectCause.getCode() != 3 && this.mDisconnectCause.getCode() != 9 && this.mDisconnectCause.getCode() != 7) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "turning off proximity sensor: releasing 0");
                }
                K2.a.i(LOG_TAG, "turning off proximity sensor 0 state = " + M2.a.c().b());
                releaseWakeLock(0);
                this.mSensorManager.unregisterListener(this.mProximitySensorListener);
                return;
            }
            int i11 = !z10 ? 1 : 0;
            if (Log.sDebug) {
                Log.d(LOG_TAG, "turning off proximity sensor: releasing mIsProximityNear:" + this.mIsProximityNear);
            }
            K2.a.i(LOG_TAG, "turning off proximity sensor state = " + M2.a.c().b() + " flags = " + i11);
            if (this.mIsProximityNear) {
                i10 = i11;
            }
            releaseWakeLock(i10);
            this.mSensorManager.unregisterListener(this.mProximitySensorListener);
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "turning off proximity sensor: already released");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnOffProximitySwipeUpGesture() {
        OplusInCallPresenter oplusInCallPresenter = (OplusInCallPresenter) InCallPresenter.getInstance();
        if (oplusInCallPresenter == null || oplusInCallPresenter.getActivity() == null || oplusInCallPresenter.getActivity().mIsForegroundActivity || isAutoScreenOff()) {
            return;
        }
        turnOffProximitySensor(true);
    }

    private void turnOnProximitySensor() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "turning on proximity sensor: Ring mProximityWakeLock=" + this.mProximityWakeLock);
            Log.d(LOG_TAG, "turning on proximity sensor: Ring isHeld=" + this.mProximityWakeLock.isHeld());
        }
        if (!this.mProximityWakeLock.isHeld()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "turning on proximity sensor: acquiring");
            }
            K2.a.i(LOG_TAG, "turning on proximity sensor state = " + M2.a.c().b());
            this.mProximityWakeLock.acquire();
            this.mSensorManager.registerListener(this.mProximitySensorListener, this.mProximity, 0);
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "turning on proximity sensor: already acquired");
        }
    }

    public void delayToAcquireIncomingProximitySensor() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "delayToAcquireIncomingProximitySensor");
        }
        if (!this.mHandler.hasMessages(1000)) {
            this.mHandler.sendEmptyMessageDelayed(1000, 1500L);
        }
    }

    @Override // com.android.incallui.ProximitySensor
    public void inCallActivityChangeFocus() {
        if (this.mHandler.hasMessages(1000)) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "inCallActivityHasFocus  update proximity");
            }
            removeUpdateIncomingProximityMsg();
            postDelayedUpdateProximityRunnable(0);
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onDisconnect(Call call) {
        if (call != null) {
            this.mDisconnectCause = call.getDisconnectCause();
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "calls.disconnect cause = " + this.mDisconnectCause);
        }
    }

    @Override // com.android.incallui.ProximitySensor
    public void onInCallShowing(boolean z10) {
        if (z10) {
            this.mUiShowing = true;
        } else if (this.mPowerManager.isInteractive()) {
            this.mUiShowing = false;
        }
        Log.d(this, "onInCallShowing updateProximityState showing = " + z10 + " mUiShowing = " + this.mUiShowing);
        updateProximitySensorMode();
    }

    @Override // com.android.incallui.CallList.Listener
    public void onIncomingCall(Call call) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onIncomingCall");
        }
        this.mIsPhoneOffhook = false;
        this.mIsPhoneRing = true;
        this.mOrientation = 0;
        this.mAccelerometerListener.enable(true);
        if (proximitySensorModeEnabled()) {
            synchronized (this.mProximityWakeLock) {
                this.mSensorManager.registerListener(this.mProximitySensorListener, this.mProximity, 0);
            }
        }
        updateProximitySensorMode();
    }

    @Override // com.android.incallui.ProximitySensor, com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        boolean z10;
        boolean z11;
        boolean z12 = true;
        if ((InCallPresenter.InCallState.INCALL == inCallState2 || InCallPresenter.InCallState.PENDING_OUTGOING == inCallState2 || InCallPresenter.InCallState.OUTGOING == inCallState2) && callList.getDisconnectingCall() == null && callList.getDisconnectedCall() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (InCallPresenter.InCallState.INCOMING == inCallState2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "OplusProximitySensor onStateChange state = " + inCallState2);
        }
        boolean hasVideoCall = OplusPhoneUtils.hasVideoCall();
        if (inCallState2 == InCallPresenter.InCallState.NO_CALLS) {
            removeUpdateIncomingProximityMsg();
            this.mUiShowing = false;
        }
        if (z10 != this.mIsPhoneOffhook || z11 != this.mIsPhoneRing || hasVideoCall != this.mHasVideoCall) {
            this.mHasVideoCall = hasVideoCall;
            this.mIsPhoneOffhook = z10;
            this.mIsPhoneRing = z11;
            this.mOrientation = 0;
            AccelerometerListener accelerometerListener = this.mAccelerometerListener;
            if (!z10 && !z11) {
                z12 = false;
            }
            accelerometerListener.enable(z12);
            if (Log.sDebug) {
                Log.d(LOG_TAG, "onStateChange updateProximityState mIsPhoneOffhook = " + this.mIsPhoneOffhook);
            }
            updateProximitySensorMode();
        }
    }

    @Override // com.android.incallui.ProximitySensor
    public void oplusOnInCallShowing(boolean z10, boolean z11) {
        this.mIsPhoneOffhook = z11;
        onInCallShowing(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:9:0x0014, B:11:0x002a, B:13:0x002e, B:15:0x0032, B:19:0x003d, B:21:0x0067, B:25:0x0072, B:28:0x007b, B:30:0x007f, B:32:0x009f, B:33:0x00a5, B:35:0x00bf, B:39:0x00ca, B:42:0x00d3, B:44:0x00d7, B:46:0x0188, B:47:0x01b5, B:52:0x018c, B:56:0x019a, B:59:0x01a0, B:61:0x0196, B:65:0x01ae, B:66:0x01a8, B:69:0x01b2, B:71:0x00a2), top: B:8:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7 A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:9:0x0014, B:11:0x002a, B:13:0x002e, B:15:0x0032, B:19:0x003d, B:21:0x0067, B:25:0x0072, B:28:0x007b, B:30:0x007f, B:32:0x009f, B:33:0x00a5, B:35:0x00bf, B:39:0x00ca, B:42:0x00d3, B:44:0x00d7, B:46:0x0188, B:47:0x01b5, B:52:0x018c, B:56:0x019a, B:59:0x01a0, B:61:0x0196, B:65:0x01ae, B:66:0x01a8, B:69:0x01b2, B:71:0x00a2), top: B:8:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0188 A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:9:0x0014, B:11:0x002a, B:13:0x002e, B:15:0x0032, B:19:0x003d, B:21:0x0067, B:25:0x0072, B:28:0x007b, B:30:0x007f, B:32:0x009f, B:33:0x00a5, B:35:0x00bf, B:39:0x00ca, B:42:0x00d3, B:44:0x00d7, B:46:0x0188, B:47:0x01b5, B:52:0x018c, B:56:0x019a, B:59:0x01a0, B:61:0x0196, B:65:0x01ae, B:66:0x01a8, B:69:0x01b2, B:71:0x00a2), top: B:8:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018c A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:9:0x0014, B:11:0x002a, B:13:0x002e, B:15:0x0032, B:19:0x003d, B:21:0x0067, B:25:0x0072, B:28:0x007b, B:30:0x007f, B:32:0x009f, B:33:0x00a5, B:35:0x00bf, B:39:0x00ca, B:42:0x00d3, B:44:0x00d7, B:46:0x0188, B:47:0x01b5, B:52:0x018c, B:56:0x019a, B:59:0x01a0, B:61:0x0196, B:65:0x01ae, B:66:0x01a8, B:69:0x01b2, B:71:0x00a2), top: B:8:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a2 A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:9:0x0014, B:11:0x002a, B:13:0x002e, B:15:0x0032, B:19:0x003d, B:21:0x0067, B:25:0x0072, B:28:0x007b, B:30:0x007f, B:32:0x009f, B:33:0x00a5, B:35:0x00bf, B:39:0x00ca, B:42:0x00d3, B:44:0x00d7, B:46:0x0188, B:47:0x01b5, B:52:0x018c, B:56:0x019a, B:59:0x01a0, B:61:0x0196, B:65:0x01ae, B:66:0x01a8, B:69:0x01b2, B:71:0x00a2), top: B:8:0x0014 }] */
    @Override // com.android.incallui.ProximitySensor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void oplusUpdateProximitySensorMode() {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.OplusProximitySensor.oplusUpdateProximitySensorMode():void");
    }

    public void removeUpdateIncomingProximityMsg() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "removeUpdateIncomingProximityMsg...");
        }
        if (this.mHandler.hasMessages(1000)) {
            this.mHandler.removeMessages(1000);
        }
    }

    @Override // com.android.incallui.ProximitySensor
    public void tearDown() {
        oplusUpdateProximitySensorMode();
        super.tearDown();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "tearDown......");
        }
        this.mSensorManager.unregisterListener(this.mProximitySensorListener);
    }

    @Override // com.android.incallui.ProximitySensor
    public void updateProximitySensorMode() {
        int i10;
        if (OplusTelephonyCapabilities.isOplusEnabled()) {
            if (!InternalSdkDepends.getSInstance().getBooleanSystemProperties("persist.oplus.hold_proximity_wl", true)) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "not use proximity");
                    return;
                }
                return;
            } else {
                if (!this.mIsProximityNear && this.mIsPhoneRing) {
                    delayToAcquireIncomingProximitySensor();
                    return;
                }
                if (this.mIsPhoneOffhook) {
                    i10 = 0;
                } else {
                    i10 = 100;
                }
                postDelayedUpdateProximityRunnable(i10);
                return;
            }
        }
        super.updateProximitySensorMode();
    }

    @Override // com.android.incallui.CallList.Listener
    public void onCallListChange(CallList callList) {
    }

    @Override // com.android.incallui.CallList.Listener
    public void onUpgradeToVideo(Call call) {
    }

    /* renamed from: com.android.incallui.OplusProximitySensor$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements SensorEventListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSensorChanged$0() {
            OplusProximitySensor.this.turnOffProximitySwipeUpGesture();
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str;
            boolean z10 = false;
            if (sensorEvent.values[0] == 0.0f) {
                z10 = true;
            }
            if (Log.sDebug) {
                StringBuilder sb = new StringBuilder();
                sb.append("mProximitySensorListener: distance = ");
                if (z10) {
                    str = "near";
                } else {
                    str = "far away";
                }
                sb.append(str);
                K2.a.i(OplusProximitySensor.LOG_TAG, sb.toString());
            }
            if (z10 != OplusProximitySensor.this.mIsProximityNear) {
                OplusProximitySensor.this.mIsProximityNear = z10;
            }
            if (z10) {
                OplusProximitySensor.access$108(OplusProximitySensor.this);
            } else {
                OplusProximitySensor.this.mHandler.postDelayed(new Runnable() { // from class: com.android.incallui.Z
                    @Override // java.lang.Runnable
                    public final void run() {
                        OplusProximitySensor.AnonymousClass1.this.lambda$onSensorChanged$0();
                    }
                }, 100L);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }
    }
}
