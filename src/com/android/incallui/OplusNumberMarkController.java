package com.android.incallui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.android.incallui.OplusNumberMarkView;

/* loaded from: classes.dex */
public class OplusNumberMarkController {
    private static final int AUTO_DISMISS_DELAYMILLS = 5000;
    private static final String IS_FIRST_IN_DATA = "is_first_in_data";
    private static final String NEED_SHOW_CHECKBOX = "needShowCheckbox";
    private static final String NEVER_SHOW_CHECKBOX = "neverShowCheckbox";
    private static final String SHOW_NUMBER_MARK_COUNT = "showNumberMarkCount";
    private static final int SHOW_NUMBER_MARK_COUNT_DEFAULT_VALUE = 1;
    private static final int SHOW_NUMBER_MARK_COUNT_MAX_VALUE = 3;
    private static final String TAG = "OplusNumberMarkController";
    private static boolean mIsViewAdded = false;
    private final Context mContext;
    private HomeListenerReceiver mHomeListenerReceiver;
    private OplusNumberMarkView mNumberMarkView;
    private WindowManager mWindowManager = null;
    private boolean mHasRegistHomeListener = false;
    private final Handler myHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class HomeListenerReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_HOME_KEY;
        final String SYSTEM_DIALOG_REASON_KEY;
        final String SYSTEM_DIALOG_REASON_RECENTAPPS;

        private HomeListenerReceiver() {
            this.SYSTEM_DIALOG_REASON_KEY = "reason";
            this.SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
            this.SYSTEM_DIALOG_REASON_RECENTAPPS = "recentapps";
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("reason");
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                if ("homekey".equals(stringExtra) || "recentapps".equals(stringExtra)) {
                    OplusNumberMarkController.this.hideNumberMarkView();
                }
            }
        }
    }

    public OplusNumberMarkController(Context context) {
        this.mContext = L1.c.b(context, 2009);
        initWindowParams();
    }

    private void initWindowParams() {
        this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        this.mNumberMarkView = new OplusNumberMarkView(this.mContext, new OplusNumberMarkView.AnimationListener() { // from class: com.android.incallui.OplusNumberMarkController.1
            @Override // com.android.incallui.OplusNumberMarkView.AnimationListener
            public void onExitAnimationEnd(boolean z10) {
                OplusPhoneUtils.setNeedMarkNumber(false, null);
                if (OplusNumberMarkController.mIsViewAdded) {
                    if (OplusNumberMarkController.this.mWindowManager != null) {
                        OplusNumberMarkController.this.mWindowManager.removeView(OplusNumberMarkController.this.mNumberMarkView);
                    }
                    boolean unused = OplusNumberMarkController.mIsViewAdded = false;
                    Log.d(OplusNumberMarkController.TAG, "onExitAnimationEnd");
                    SharedPreferences sharedPreferences = OplusNumberMarkController.this.mContext.getSharedPreferences(OplusNumberMarkController.IS_FIRST_IN_DATA, 0);
                    boolean z11 = sharedPreferences.getBoolean(OplusNumberMarkController.NEVER_SHOW_CHECKBOX, false);
                    Log.d(OplusNumberMarkController.TAG, "neverShowCheckbox: " + z11);
                    if (!z11) {
                        int i10 = sharedPreferences.getInt(OplusNumberMarkController.SHOW_NUMBER_MARK_COUNT, 1);
                        boolean z12 = sharedPreferences.getBoolean(OplusNumberMarkController.NEED_SHOW_CHECKBOX, false);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        if (!z12) {
                            if (z10) {
                                edit.putInt(OplusNumberMarkController.SHOW_NUMBER_MARK_COUNT, 1);
                            } else if (i10 == 3) {
                                edit.putBoolean(OplusNumberMarkController.NEED_SHOW_CHECKBOX, true);
                            } else {
                                edit.putInt(OplusNumberMarkController.SHOW_NUMBER_MARK_COUNT, i10 + 1);
                            }
                        } else if (z10) {
                            edit.putBoolean(OplusNumberMarkController.NEED_SHOW_CHECKBOX, false);
                            edit.putBoolean(OplusNumberMarkController.NEVER_SHOW_CHECKBOX, true);
                        }
                        edit.apply();
                    }
                    OplusNumberMarkController.this.mNumberMarkView = null;
                }
            }
        });
    }

    public WindowManager.LayoutParams getWindowParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.oplus_number_mark_view_height), 2009, 263712, -2);
        layoutParams.gravity = 80;
        layoutParams.verticalMargin = 0.0f;
        layoutParams.screenOrientation = 3;
        return layoutParams;
    }

    public void hideNumberMarkView() {
        Log.d(TAG, "hideNumberMarkView: ");
        if (this.mNumberMarkView != null) {
            unRegisterHomeListenerReceiver();
            this.mNumberMarkView.setNumberMarkViewVis(false);
        }
        Log.d(TAG, "hideNumberMarkView mIsViewAdded =" + mIsViewAdded);
    }

    public void registerHomeListenerReceiver() {
        if (!this.mHasRegistHomeListener && this.mContext != null) {
            if (Log.sDebug) {
                Log.d(TAG, "registerHomeListenerReceiver...");
            }
            this.mHasRegistHomeListener = true;
            this.mHomeListenerReceiver = new HomeListenerReceiver();
            try {
                this.mContext.registerReceiver(this.mHomeListenerReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
            } catch (Exception e10) {
                Log.d(TAG, "Exception: " + e10.toString());
            }
        }
    }

    public void showNumberMarkView() {
        Log.d(TAG, "showNumberMarkView: ");
        if (this.mNumberMarkView != null) {
            Log.d(TAG, "showNumberMarkView  mIsViewAdded =" + mIsViewAdded);
            if (!mIsViewAdded) {
                if (this.mWindowManager != null) {
                    registerHomeListenerReceiver();
                    try {
                        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mNumberMarkView, getWindowParams());
                    } catch (Exception e10) {
                        Log.i(TAG, "showFloatingWindow exception: " + e10.getMessage());
                    }
                }
                mIsViewAdded = true;
            }
            this.mNumberMarkView.setNumberMarkViewVis(true);
            Handler handler = this.myHandler;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.android.incallui.S
                    @Override // java.lang.Runnable
                    public final void run() {
                        OplusNumberMarkController.this.hideNumberMarkView();
                    }
                }, 5000L);
            }
        }
    }

    public void unRegisterHomeListenerReceiver() {
        if (this.mHasRegistHomeListener && this.mHomeListenerReceiver != null && this.mContext != null) {
            if (Log.sDebug) {
                Log.d(TAG, "unRegisterHomeListenerReceiver...");
            }
            this.mHasRegistHomeListener = false;
            try {
                this.mContext.unregisterReceiver(this.mHomeListenerReceiver);
                this.mHomeListenerReceiver = null;
            } catch (IllegalArgumentException e10) {
                Log.d(TAG, "HomeListener IllegalArgumentException: " + e10.toString());
            }
        }
    }
}
