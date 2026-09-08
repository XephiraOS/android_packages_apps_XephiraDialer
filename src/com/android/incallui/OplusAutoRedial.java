package com.android.incallui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.oplus.brand.BrandCenter;
import com.coui.appcompat.scrollbar.COUIScrollBar;

/* loaded from: classes.dex */
public class OplusAutoRedial {
    private static final int COUNT_WITH_MINS_DELAY = 4;
    private static final int COUNT_WITH_MIN_DELAY = 2;
    public static final int DELAY_FIVE_SECOND = 5000;
    public static final int DELAY_ONE_MIN = 60000;
    public static final int DELAY_THREE_MIN = 180000;
    public static final int DELAY_TWO_SECOND = 2000;
    private static final String LOG_TAG = "OplusAutoRedial";
    private static final int MSG_DIAL_EMERGENCY_RTT_REDIAL = 2;
    private static final int MSG_START_REDAIL = 1;
    private static final int REDIAL_COUNT = 10;
    private static final int REDIAL_COUNT_NUMBER_MISS = 1;
    private static final String RTT_ONLY_VOICE_KEY = "op_only_voice";
    private static OplusAutoRedial sOplusAutoRedial;
    private Context mContext;
    private int mCurrentRedialCount;
    private boolean mIsInAutoRedial;
    private boolean mIsNumberNotExistType;
    private String mName;
    private Handler mOplusAutoHandler = new OplusAutoHander(Looper.getMainLooper());
    private int mPhoneType;
    private String mRedialNumber;

    /* loaded from: classes.dex */
    public class OplusAutoHander extends Handler {
        public OplusAutoHander(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2 && !TextUtils.isEmpty(OplusAutoRedial.this.mRedialNumber)) {
                    final T5.a d10 = BrandCenter.f19187a.a().d();
                    if (d10 != null) {
                        OplusAutoRedial.this.mOplusAutoHandler.post(new Runnable() { // from class: com.android.incallui.OplusAutoRedial.OplusAutoHander.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast toast;
                                String I10 = d10.I(OplusAutoRedial.this.mContext);
                                if (!TextUtils.isEmpty(I10)) {
                                    toast = A2.b.b().d(I10, 0);
                                } else {
                                    toast = null;
                                }
                                if (toast != null) {
                                    toast.show();
                                }
                            }
                        });
                    }
                    OplusAutoRedial oplusAutoRedial = OplusAutoRedial.this;
                    oplusAutoRedial.redialEmergencyAfterRtt(oplusAutoRedial.mRedialNumber, true);
                    return;
                }
                return;
            }
            OplusAutoRedial.access$008(OplusAutoRedial.this);
            if (OplusAutoRedial.this.mIsNumberNotExistType) {
                OplusAutoRedial.this.doNumberNotExistRedial();
            } else {
                OplusAutoRedial.this.doOtherConditionRedial();
            }
        }
    }

    private OplusAutoRedial(Context context) {
        this.mContext = context;
    }

    public static /* synthetic */ int access$008(OplusAutoRedial oplusAutoRedial) {
        int i10 = oplusAutoRedial.mCurrentRedialCount;
        oplusAutoRedial.mCurrentRedialCount = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNumberNotExistRedial() {
        if (this.mCurrentRedialCount > 1) {
            cancelRedailTask();
        } else {
            doOneRedialTry(DELAY_FIVE_SECOND);
        }
    }

    private void doOneRedialTry(int i10) {
        log("displayAutoDialNotificationScreen");
        Bundle bundle = new Bundle();
        bundle.putString("number", this.mRedialNumber);
        bundle.putString("name", this.mName);
        bundle.putInt(OplusAutoRedialNotificationUI.TYPE, this.mPhoneType);
        bundle.putInt(OplusAutoRedialNotificationUI.CURRENT_COUNT, this.mCurrentRedialCount);
        if (this.mIsNumberNotExistType) {
            bundle.putInt(OplusAutoRedialNotificationUI.TOTAL_COUNT, 1);
        } else {
            bundle.putInt(OplusAutoRedialNotificationUI.TOTAL_COUNT, 10);
        }
        bundle.putInt(OplusAutoRedialNotificationUI.TIME, i10);
        displayAutoDialNotificationScreen(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOtherConditionRedial() {
        int i10 = this.mCurrentRedialCount;
        if (i10 > 10) {
            cancelRedailTask();
            return;
        }
        if (i10 < 2) {
            doOneRedialTry(DELAY_FIVE_SECOND);
        } else if (i10 > 4) {
            doOneRedialTry(DELAY_THREE_MIN);
        } else {
            doOneRedialTry(DELAY_ONE_MIN);
        }
    }

    public static OplusAutoRedial getInstance(Context context) {
        if (sOplusAutoRedial == null) {
            sOplusAutoRedial = new OplusAutoRedial(context);
        }
        return sOplusAutoRedial;
    }

    private void log(String str) {
        if (Log.sDebug) {
            Log.i(LOG_TAG, "info:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void redialEmergencyAfterRtt(String str, boolean z10) {
        Intent intent = new Intent(OplusPhoneUtils.ACTION_CALL_PRIVILEGED);
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(RTT_ONLY_VOICE_KEY, z10);
            intent.putExtra("android.telecom.extra.OUTGOING_CALL_EXTRAS", bundle);
            intent.setData(Uri.fromParts("tel", str, null));
            intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            OplusPhoneUtils.startSafeActivity(this.mContext, intent);
        }
    }

    public void callRedial(Bundle bundle) {
        if (bundle == null) {
            log("Redial bundle is null!");
            return;
        }
        String string = bundle.getString("number");
        if (string == null) {
            log("Redial number is null!");
            return;
        }
        if (isInAutoRedial()) {
            if (!string.equals(this.mRedialNumber)) {
                cancelRedailTask();
                return;
            }
            log("Now is another task in AutoRedail process!");
            Handler handler = this.mOplusAutoHandler;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        }
    }

    public void cancelRedailTask() {
        log("cancelRedailTask!");
        this.mIsInAutoRedial = false;
        this.mCurrentRedialCount = 0;
        this.mRedialNumber = null;
    }

    public void displayAutoDialNotificationScreen(Bundle bundle) {
        if (bundle == null) {
            endRedialTask();
        }
        Log.i(LOG_TAG, "displayAutoDialNotificationScreen()...");
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.setFlags(277086208);
        intent.setAction("com.incallui.action.autoredial");
        intent.putExtras(bundle);
        this.mContext.startActivity(intent);
    }

    public void endRedialTask() {
        log("endRedialTask mIsInAutoRedial =" + this.mIsInAutoRedial);
        if (isInAutoRedial()) {
            cancelRedailTask();
        }
    }

    public boolean isInAutoRedial() {
        return this.mIsInAutoRedial;
    }

    public void rttEmergencyAutoRedial(String str) {
        if (TextUtils.isEmpty(str)) {
            log("rttEmergencyAutoRedial number is null!");
            return;
        }
        Handler handler = this.mOplusAutoHandler;
        if (handler != null) {
            this.mRedialNumber = str;
            handler.sendEmptyMessageDelayed(2, COUIScrollBar.SCROLLER_FADE_TIMEOUT);
            log("start a rttEmergencyAutoRedial process!");
        }
    }

    public void startRedial(Bundle bundle, boolean z10) {
        if (bundle == null) {
            log("Redial bundle is null!");
            return;
        }
        String string = bundle.getString("number");
        if (string == null) {
            log("Redial number is null!");
            return;
        }
        if (isInAutoRedial()) {
            if (!string.equals(this.mRedialNumber)) {
                cancelRedailTask();
                return;
            }
            log("Now is another task in AutoRedail process!");
            Handler handler = this.mOplusAutoHandler;
            if (handler != null) {
                handler.sendEmptyMessage(1);
                return;
            }
            return;
        }
        if (this.mOplusAutoHandler != null) {
            this.mCurrentRedialCount = 0;
            this.mIsNumberNotExistType = z10;
            this.mRedialNumber = string;
            this.mName = bundle.getString("name");
            this.mPhoneType = bundle.getInt(OplusAutoRedialNotificationUI.TYPE, 0);
            this.mIsInAutoRedial = true;
            this.mOplusAutoHandler.sendEmptyMessage(1);
            log("start a new AutoRedail process!");
        }
    }
}
