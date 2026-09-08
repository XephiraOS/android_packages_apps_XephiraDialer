package com.coui.appcompat.statusbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.view.COUICompatUtil;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class COUIStatusBarResponseUtil {
    public static final int DELAY = 1000;
    private static final int MSG_REGISTER = 0;
    private static final int MSG_UNREGISTER = 1;
    private static final int RECEIVER_EXPORTED = 2;
    private static final int RECEIVER_NOT_EXPORTED = 4;
    private BroadcastDelayRunnable mBroadcastDelayRunnable;
    private Context mContext;
    private Handler mH;
    private boolean mIsRegistered;
    private StatusBarClickListener mStatusBarClickListener;
    private BroadcastReceiver myReceiver;
    private final String TAG = "COUIStatusBarResponseUtil";
    private int mDelay = 0;

    /* loaded from: classes.dex */
    public class BroadcastDelayRunnable implements Runnable {
        private WeakReference<Context> mContextRef;
        private int mMsg;

        public BroadcastDelayRunnable(Context context) {
            this.mContextRef = new WeakReference<>(context);
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.mContextRef.get();
            if (context == null) {
                COUILog.e("COUIStatusBarResponseUtil", "lost mContextRef , failed to execute mBroadcastDelayRunnable");
            } else if (this.mMsg == 0) {
                COUIStatusBarResponseUtil.this.initReceiver(context);
            } else {
                COUIStatusBarResponseUtil.this.unregisterRegister(context);
                this.mContextRef.clear();
            }
        }

        public void setMsg(int i10) {
            this.mMsg = i10;
        }
    }

    /* loaded from: classes.dex */
    public interface StatusBarClickListener {
        void onStatusBarClicked();
    }

    public COUIStatusBarResponseUtil(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initReceiver(Context context) {
        if (!this.mIsRegistered) {
            this.myReceiver = new BroadcastReceiver() { // from class: com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    COUILog.i("COUIStatusBarResponseUtil", "The broadcast receiver was registered successfully and receives the broadcast");
                    if (COUIStatusBarResponseUtil.this.mStatusBarClickListener != null) {
                        COUIStatusBarResponseUtil.this.mStatusBarClickListener.onStatusBarClicked();
                        COUILog.i("COUIStatusBarResponseUtil", "onStatusBarClicked is called at time :" + System.currentTimeMillis());
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.clicktop");
            intentFilter.addAction(COUICompatUtil.getInstance().getClickTopName());
            this.mIsRegistered = true;
            context.registerReceiver(this.myReceiver, intentFilter, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterRegister(Context context) {
        if (this.mIsRegistered) {
            this.mIsRegistered = false;
            context.unregisterReceiver(this.myReceiver);
        }
    }

    public void onPause() {
        Handler handler = this.mH;
        if (handler != null) {
            handler.removeCallbacks(this.mBroadcastDelayRunnable);
            this.mBroadcastDelayRunnable.setMsg(1);
            this.mH.postDelayed(this.mBroadcastDelayRunnable, this.mDelay);
            this.mH = null;
            this.mBroadcastDelayRunnable = null;
        }
    }

    public void onResume() {
        if (this.mH == null && this.mBroadcastDelayRunnable == null) {
            this.mH = new Handler(Looper.myLooper());
            BroadcastDelayRunnable broadcastDelayRunnable = new BroadcastDelayRunnable(this.mContext);
            this.mBroadcastDelayRunnable = broadcastDelayRunnable;
            broadcastDelayRunnable.setMsg(0);
            this.mH.postDelayed(this.mBroadcastDelayRunnable, this.mDelay);
            return;
        }
        COUILog.e("COUIStatusBarResponseUtil", "onResume call multiple times");
    }

    public void setDelay(int i10) {
        this.mDelay = i10;
    }

    public void setStatusBarClickListener(StatusBarClickListener statusBarClickListener) {
        this.mStatusBarClickListener = statusBarClickListener;
    }
}
