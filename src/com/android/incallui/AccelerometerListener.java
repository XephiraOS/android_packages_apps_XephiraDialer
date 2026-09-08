package com.android.incallui;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
public class AccelerometerListener {
    private static final boolean DEBUG = true;
    private static final int HORIZONTAL_DEBOUNCE = 500;
    private static final int ORIENTATION_CHANGED = 1234;
    public static final int ORIENTATION_HORIZONTAL = 2;
    public static final int ORIENTATION_UNKNOWN = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    private static final String TAG = "AccelerometerListener";
    private static final boolean VDEBUG = false;
    private static final double VERTICAL_ANGLE = 50.0d;
    private static final int VERTICAL_DEBOUNCE = 100;
    private int mOrientation;
    private int mPendingOrientation;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    Handler mHandler = new Handler() { // from class: com.android.incallui.AccelerometerListener.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            if (message.what == AccelerometerListener.ORIENTATION_CHANGED) {
                synchronized (this) {
                    try {
                        AccelerometerListener accelerometerListener = AccelerometerListener.this;
                        accelerometerListener.mOrientation = accelerometerListener.mPendingOrientation;
                        StringBuilder sb = new StringBuilder();
                        sb.append("orientation: ");
                        if (AccelerometerListener.this.mOrientation == 2) {
                            str = "horizontal";
                        } else if (AccelerometerListener.this.mOrientation == 1) {
                            str = "vertical";
                        } else {
                            str = "unknown";
                        }
                        sb.append(str);
                        android.util.Log.d(AccelerometerListener.TAG, sb.toString());
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    };
    SensorEventListener mSensorListener = new SensorEventListener() { // from class: com.android.incallui.AccelerometerListener.2
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            AccelerometerListener accelerometerListener = AccelerometerListener.this;
            float[] fArr = sensorEvent.values;
            accelerometerListener.onSensorEvent(fArr[0], fArr[1], fArr[2]);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }
    };

    /* loaded from: classes.dex */
    public interface OrientationListener {
        void orientationChanged(int i10);
    }

    public AccelerometerListener(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.mSensor = sensorManager.getDefaultSensor(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSensorEvent(double d10, double d11, double d12) {
        int i10;
        if (d10 != 0.0d && d11 != 0.0d && d12 != 0.0d) {
            if ((Math.atan2(Math.hypot(d10, d11), d12) * 180.0d) / 3.141592653589793d > VERTICAL_ANGLE) {
                i10 = 1;
            } else {
                i10 = 2;
            }
            setOrientation(i10);
        }
    }

    private void setOrientation(int i10) {
        int i11;
        synchronized (this) {
            try {
                if (this.mPendingOrientation == i10) {
                    return;
                }
                this.mHandler.removeMessages(ORIENTATION_CHANGED);
                if (this.mOrientation != i10) {
                    this.mPendingOrientation = i10;
                    Message obtainMessage = this.mHandler.obtainMessage(ORIENTATION_CHANGED);
                    if (i10 == 1) {
                        i11 = 100;
                    } else {
                        i11 = HORIZONTAL_DEBOUNCE;
                    }
                    this.mHandler.sendMessageDelayed(obtainMessage, i11);
                } else {
                    this.mPendingOrientation = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void enable(boolean z10) {
        android.util.Log.d(TAG, "enable(" + z10 + ")");
    }
}
