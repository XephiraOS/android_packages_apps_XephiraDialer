package com.android.incallui;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.android.incallui.AccelerometerListener;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.InCallPresenter;

/* loaded from: classes.dex */
public class ProximitySensor implements AccelerometerListener.OrientationListener, InCallPresenter.InCallStateListener, AudioModeProvider.AudioModeListener {
    protected static final int MSG_DELAY_TO_UPDATE_INCOMING_PROXIMITY = 1000;
    protected static final int OPLUS_TIME_DELAY_UPDATE_INCOMING_PROXIMITY = 1500;
    private static final String TAG = "ProximitySensor";
    protected final AccelerometerListener mAccelerometerListener;
    protected final AudioModeProvider mAudioModeProvider;
    protected Context mContext;
    protected boolean mDialpadVisible;
    protected boolean mIsHardKeyboardOpen;
    protected final PowerManager mPowerManager;
    protected PowerManager.WakeLock mProximityWakeLock;
    protected int mOrientation = 0;
    protected boolean mUiShowing = false;
    protected boolean mIsPhoneOffhook = false;
    protected Handler mHandler = new Handler(Looper.myLooper()) { // from class: com.android.incallui.ProximitySensor.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1000) {
                if (Log.sDebug) {
                    Log.d(ProximitySensor.TAG, "MSG_DELAY_TO_UPDATE_INCOMING_PROXIMITY");
                }
                ProximitySensor.this.oplusUpdateProximitySensorMode();
            }
        }
    };

    public ProximitySensor(Context context, AudioModeProvider audioModeProvider) {
        this.mContext = context;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        this.mPowerManager = powerManager;
        if (powerManager.isWakeLockLevelSupported(32)) {
            this.mProximityWakeLock = powerManager.newWakeLock(32, TAG);
        } else {
            this.mProximityWakeLock = null;
        }
        Log.d(this, "onCreate: mProximityWakeLock: ", this.mProximityWakeLock);
        this.mAccelerometerListener = new AccelerometerListener(context);
        this.mAudioModeProvider = audioModeProvider;
        audioModeProvider.addListener(this);
    }

    public boolean isScreenReallyOff() {
        return !this.mPowerManager.isScreenOn();
    }

    @Override // com.android.incallui.AudioModeProvider.AudioModeListener
    public void onAudioMode(int i10) {
        Log.d(this, "onAudioMode updateProximityState mode = " + i10);
        updateProximitySensorMode();
    }

    public void onConfigurationChanged(Configuration configuration) {
        boolean z10 = true;
        if (configuration.hardKeyboardHidden != 1) {
            z10 = false;
        }
        this.mIsHardKeyboardOpen = z10;
        Log.d(this, "onConfigurationChanged updateProximityState newConfig = " + D2.g.o(configuration));
        updateProximitySensorMode();
    }

    public void onDialpadVisible(boolean z10) {
        Log.d(this, "onDialpadVisible updateProximityState visible = " + z10);
        this.mDialpadVisible = z10;
        updateProximitySensorMode();
    }

    public void onInCallShowing(boolean z10) {
        if (z10) {
            this.mUiShowing = true;
        } else if (this.mPowerManager.isInteractive()) {
            this.mUiShowing = false;
        }
        Log.d(this, "onInCallShowing updateProximityState mUiShowing = " + this.mUiShowing);
        updateProximitySensorMode();
    }

    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        boolean z10;
        boolean z11 = true;
        if (InCallPresenter.InCallState.INCALL == inCallState2 && callList.hasLiveCall()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (InCallPresenter.InCallState.OUTGOING != inCallState2 && !z10) {
            z11 = false;
        }
        if (z11 != this.mIsPhoneOffhook) {
            this.mIsPhoneOffhook = z11;
            this.mOrientation = 0;
            this.mAccelerometerListener.enable(z11);
            updateProximitySensorMode();
        }
    }

    @Override // com.android.incallui.AccelerometerListener.OrientationListener
    public void orientationChanged(int i10) {
        Log.d(this, "orientationChanged updateProximityState orientation = " + i10);
        this.mOrientation = i10;
        updateProximitySensorMode();
    }

    public boolean proximitySensorModeEnabled() {
        if (this.mProximityWakeLock != null) {
            return true;
        }
        return false;
    }

    public void tearDown() {
        this.mAudioModeProvider.removeListener(this);
        this.mAccelerometerListener.enable(false);
        PowerManager.WakeLock wakeLock = this.mProximityWakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.mProximityWakeLock.release();
        }
        this.mProximityWakeLock = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:6:0x0009, B:13:0x001f, B:17:0x002a, B:20:0x0031, B:24:0x003a, B:28:0x0042, B:31:0x0078, B:33:0x0080, B:34:0x00af, B:39:0x008c, B:40:0x0093, B:42:0x009b, B:43:0x00a9), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:6:0x0009, B:13:0x001f, B:17:0x002a, B:20:0x0031, B:24:0x003a, B:28:0x0042, B:31:0x0078, B:33:0x0080, B:34:0x00af, B:39:0x008c, B:40:0x0093, B:42:0x009b, B:43:0x00a9), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateProximitySensorMode() {
        /*
            r14 = this;
            boolean r0 = r14.proximitySensorModeEnabled()
            if (r0 == 0) goto Lb3
            android.os.PowerManager$WakeLock r0 = r14.mProximityWakeLock
            monitor-enter(r0)
            com.android.incallui.AudioModeProvider r1 = r14.mAudioModeProvider     // Catch: java.lang.Throwable -> L26
            int r1 = r1.getAudioMode()     // Catch: java.lang.Throwable -> L26
            r2 = 4
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == r1) goto L29
            r2 = 8
            if (r2 == r1) goto L29
            if (r3 == r1) goto L29
            r2 = 64
            if (r2 == r1) goto L29
            boolean r2 = r14.mIsHardKeyboardOpen     // Catch: java.lang.Throwable -> L26
            if (r2 == 0) goto L24
            goto L29
        L24:
            r2 = r5
            goto L2a
        L26:
            r14 = move-exception
            goto Lb1
        L29:
            r2 = r4
        L2a:
            int r6 = r14.mOrientation     // Catch: java.lang.Throwable -> L26
            if (r6 != r3) goto L30
            r3 = r4
            goto L31
        L30:
            r3 = r5
        L31:
            boolean r6 = r14.mUiShowing     // Catch: java.lang.Throwable -> L26
            if (r6 != 0) goto L39
            if (r3 == 0) goto L39
            r6 = r4
            goto L3a
        L39:
            r6 = r5
        L3a:
            r2 = r2 | r6
            boolean r6 = r14.mDialpadVisible     // Catch: java.lang.Throwable -> L26
            if (r6 == 0) goto L42
            if (r3 == 0) goto L42
            r5 = r4
        L42:
            r2 = r2 | r5
            java.lang.String r5 = com.android.incallui.ProximitySensor.TAG     // Catch: java.lang.Throwable -> L26
            java.lang.String r6 = "screenOnImmediately: %b, hardKeyboardOpen: %b, dialPadVisible: %b, offHook: %b, horizontal: %b, uiShowing: %b, audioRoute: %s"
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L26
            boolean r8 = r14.mIsHardKeyboardOpen     // Catch: java.lang.Throwable -> L26
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L26
            boolean r9 = r14.mDialpadVisible     // Catch: java.lang.Throwable -> L26
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> L26
            boolean r10 = r14.mIsPhoneOffhook     // Catch: java.lang.Throwable -> L26
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Throwable -> L26
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L26
            boolean r3 = r14.mUiShowing     // Catch: java.lang.Throwable -> L26
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L26
            java.lang.String r13 = android.telecom.CallAudioState.audioRouteToString(r1)     // Catch: java.lang.Throwable -> L26
            java.lang.Object[] r1 = new java.lang.Object[]{r7, r8, r9, r10, r11, r12, r13}     // Catch: java.lang.Throwable -> L26
            com.android.incallui.Log.i(r5, r6, r1)     // Catch: java.lang.Throwable -> L26
            boolean r1 = r14.mIsPhoneOffhook     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L93
            if (r2 != 0) goto L93
            android.os.PowerManager$WakeLock r1 = r14.mProximityWakeLock     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L8c
            java.lang.String r1 = "turning on proximity sensor: acquiring"
            com.android.incallui.Log.i(r14, r1)     // Catch: java.lang.Throwable -> L26
            android.os.PowerManager$WakeLock r14 = r14.mProximityWakeLock     // Catch: java.lang.Throwable -> L26
            r14.acquire()     // Catch: java.lang.Throwable -> L26
            goto Laf
        L8c:
            java.lang.String r1 = "turning on proximity sensor: already acquired"
            com.android.incallui.Log.i(r14, r1)     // Catch: java.lang.Throwable -> L26
            goto Laf
        L93:
            android.os.PowerManager$WakeLock r1 = r14.mProximityWakeLock     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto La9
            java.lang.String r1 = "turning off proximity sensor: releasing"
            com.android.incallui.Log.i(r14, r1)     // Catch: java.lang.Throwable -> L26
            r1 = r2 ^ 1
            android.os.PowerManager$WakeLock r14 = r14.mProximityWakeLock     // Catch: java.lang.Throwable -> L26
            r14.release(r1)     // Catch: java.lang.Throwable -> L26
            goto Laf
        La9:
            java.lang.String r1 = "turning off proximity sensor: already released"
            com.android.incallui.Log.i(r14, r1)     // Catch: java.lang.Throwable -> L26
        Laf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L26
            goto Lb3
        Lb1:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L26
            throw r14
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.ProximitySensor.updateProximitySensorMode():void");
    }

    public void inCallActivityChangeFocus() {
    }

    @Override // com.android.incallui.AudioModeProvider.AudioModeListener
    public void onMute(boolean z10) {
    }

    @Override // com.android.incallui.AudioModeProvider.AudioModeListener
    public void onSupportedAudioMode(int i10) {
    }

    public void oplusUpdateProximitySensorMode() {
    }

    public void oplusOnInCallShowing(boolean z10, boolean z11) {
    }
}
