package com.android.incallui;

import android.content.Context;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class InCallCameraManager {
    private Context mContext;
    private String mFrontFacingCameraId;
    private String mRearFacingCameraId;
    private final Set<Listener> mCameraSelectionListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private boolean mIsInitialized = false;
    private boolean mUseFrontFacingCamera = true;

    /* loaded from: classes.dex */
    public interface Listener {
        void onActiveCameraSelectionChanged(boolean z10);
    }

    public InCallCameraManager(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void maybeInitializeCameraList(android.content.Context r7) {
        /*
            r6 = this;
            boolean r0 = r6.mIsInitialized
            if (r0 != 0) goto Lba
            if (r7 != 0) goto L8
            goto Lba
        L8:
            java.lang.String r0 = "initializeCameraList"
            com.android.incallui.Log.v(r6, r0)
            java.lang.String r0 = "camera"
            java.lang.Object r7 = r7.getSystemService(r0)     // Catch: java.lang.Exception -> Lb5
            android.hardware.camera2.CameraManager r7 = (android.hardware.camera2.CameraManager) r7     // Catch: java.lang.Exception -> Lb5
            if (r7 != 0) goto L18
            return
        L18:
            java.lang.String[] r0 = r7.getCameraIdList()     // Catch: android.hardware.camera2.CameraAccessException -> L1d
            goto L3b
        L1d:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Could not access camera: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.android.incallui.Log.e(r6, r0)
            r0 = 200(0xc8, double:9.9E-322)
            java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> L9f
            java.lang.String[] r0 = r7.getCameraIdList()     // Catch: java.lang.Exception -> L9f
        L3b:
            r1 = 0
        L3c:
            int r2 = r0.length
            r3 = 1
            if (r1 >= r2) goto L97
            r2 = r0[r1]     // Catch: java.lang.Exception -> L47 android.hardware.camera2.CameraAccessException -> L49 java.lang.IllegalArgumentException -> L78
            android.hardware.camera2.CameraCharacteristics r2 = r7.getCameraCharacteristics(r2)     // Catch: java.lang.Exception -> L47 android.hardware.camera2.CameraAccessException -> L49 java.lang.IllegalArgumentException -> L78
            goto L79
        L47:
            r2 = move-exception
            goto L4b
        L49:
            r2 = move-exception
            goto L64
        L4b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "initializeCameraList Exception: "
            r4.append(r5)
            java.lang.String r2 = r2.getMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.android.incallui.Log.e(r6, r2)
            goto L78
        L64:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "initializeCameraList CameraAccessException: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.android.incallui.Log.e(r6, r2)
        L78:
            r2 = 0
        L79:
            if (r2 == 0) goto L94
            android.hardware.camera2.CameraCharacteristics$Key r4 = android.hardware.camera2.CameraCharacteristics.LENS_FACING
            java.lang.Object r2 = r2.get(r4)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 != 0) goto L8e
            r2 = r0[r1]
            r6.mFrontFacingCameraId = r2
            goto L94
        L8e:
            if (r2 != r3) goto L94
            r2 = r0[r1]
            r6.mRearFacingCameraId = r2
        L94:
            int r1 = r1 + 1
            goto L3c
        L97:
            r6.mIsInitialized = r3
            java.lang.String r7 = "initializeCameraList : done"
            com.android.incallui.Log.v(r6, r7)
            return
        L9f:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Could not access camera again: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.android.incallui.Log.e(r6, r7)
            return
        Lb5:
            java.lang.String r7 = "Could not get camera service."
            com.android.incallui.Log.e(r6, r7)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.InCallCameraManager.maybeInitializeCameraList(android.content.Context):void");
    }

    public void addCameraSelectionListener(Listener listener) {
        if (listener != null) {
            this.mCameraSelectionListeners.add(listener);
        }
    }

    public String getActiveCameraId() {
        maybeInitializeCameraList(this.mContext);
        if (this.mUseFrontFacingCamera) {
            return this.mFrontFacingCameraId;
        }
        return this.mRearFacingCameraId;
    }

    public boolean isUsingFrontFacingCamera() {
        return this.mUseFrontFacingCamera;
    }

    public void removeCameraSelectionListener(Listener listener) {
        if (listener != null) {
            this.mCameraSelectionListeners.remove(listener);
        }
    }

    public void setUseFrontFacingCamera(boolean z10) {
        this.mUseFrontFacingCamera = z10;
        Iterator<Listener> it = this.mCameraSelectionListeners.iterator();
        while (it.hasNext()) {
            it.next().onActiveCameraSelectionChanged(this.mUseFrontFacingCamera);
        }
    }
}
