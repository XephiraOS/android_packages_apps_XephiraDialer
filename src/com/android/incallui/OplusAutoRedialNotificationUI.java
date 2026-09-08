package com.android.incallui;

import android.content.AsyncQueryHandler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.incallui.oplus.widgets.COUIThemeActivity;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class OplusAutoRedialNotificationUI extends COUIThemeActivity implements View.OnClickListener {
    public static final String CURRENT_COUNT = "current_count";
    private static final int DEFAULT_DELAY_TIME = 5000;
    private static final int DIAL_CALL = 1;
    private static final String LOG_TAG = "OplusAutoRedialNotificationUI";
    public static final String NAME = "name";
    public static final String NUMBER = "number";
    private static final int OPLUS_MSG_DELAY_FINISH = 2;
    private static final long OPLUS_TIME_DELAY_FINISH = 150;
    private static final String POWER_TAG = "InCallUI:AutoRedialNotificationUI";
    private static final int SINGLE_QUERY_NONAME_TOKEN = 1;
    private static final int SINGLE_QUERY_TOKEN = 0;
    private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    public static final String TIME = "time";
    public static final String TOTAL_COUNT = "total_count";
    public static final String TYPE = "type";
    private Button mCancelBtn;
    private TextView mCountText;
    private int mCurrentCount;
    private int mDelayTime;
    private IntentFilter mFilter;
    private Handler mHandler = new Handler() { // from class: com.android.incallui.OplusAutoRedialNotificationUI.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                OplusAutoRedialNotificationUI.this.dialCall();
            } else if (i10 == 2) {
                OplusAutoRedialNotificationUI.this.finish();
            }
        }
    };
    private BroadcastReceiver mHomeRecevier = new BroadcastReceiver() { // from class: com.android.incallui.OplusAutoRedialNotificationUI.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                String stringExtra = intent.getStringExtra(OplusAutoRedialNotificationUI.SYSTEM_DIALOG_REASON_KEY);
                if (Log.sDebug) {
                    Log.d(OplusAutoRedialNotificationUI.LOG_TAG, "action:" + action + ",reason:" + stringExtra);
                }
                if (stringExtra != null && stringExtra.equals(OplusAutoRedialNotificationUI.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                    OplusAutoRedialNotificationUI.this.toNotifierCancelRedial();
                    OplusAutoRedialNotificationUI.this.cancelMsgAndFinishScreen();
                }
            }
        }
    };
    private String mName;
    private TextView mNameText;
    private String mNumber;
    private QueryHandler mOplusAysnQuery;
    private PowerManager.WakeLock mPartialWakeLock;
    private TextView mPhoneLableText;
    private TextView mPhoneTypeText;
    private TextView mTimeText;
    private int mTotalCount;
    private int mType;

    /* loaded from: classes.dex */
    public final class QueryHandler extends AsyncQueryHandler {
        HashMap<String, String> mLocation;

        /* loaded from: classes.dex */
        public class CatchingWorkerHandler extends AsyncQueryHandler.WorkerHandler {
            public CatchingWorkerHandler(Looper looper) {
                super(QueryHandler.this, looper);
            }

            @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
            public void handleMessage(Message message) {
                try {
                    super.handleMessage(message);
                } catch (SQLiteDatabaseCorruptException e10) {
                    Log.e(OplusAutoRedialNotificationUI.LOG_TAG, "Exception on background worker thread" + e10);
                } catch (SQLiteDiskIOException e11) {
                    Log.e(OplusAutoRedialNotificationUI.LOG_TAG, "Exception on background worker thread" + e11);
                } catch (SQLiteFullException e12) {
                    Log.e(OplusAutoRedialNotificationUI.LOG_TAG, "Exception on background worker thread" + e12);
                }
            }
        }

        public QueryHandler(Context context) {
            super(context.getContentResolver());
            this.mLocation = new HashMap<>();
        }

        public void clearCachLocation() {
            this.mLocation.clear();
        }

        @Override // android.content.AsyncQueryHandler
        public Handler createHandler(Looper looper) {
            return new CatchingWorkerHandler(looper);
        }

        public String getCachLocation(String str) {
            if (str == null) {
                return null;
            }
            return this.mLocation.get(str);
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i10, Object obj, Cursor cursor) {
            try {
                String string = OplusAutoRedialNotificationUI.this.getResources().getString(R.string.unknown);
                String str = (String) obj;
                try {
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                string = cursor.getString(cursor.getColumnIndex("cityname"));
                            }
                        } catch (Exception e10) {
                            Log.d(OplusAutoRedialNotificationUI.LOG_TAG, "Exception: " + e10.toString());
                            if (!cursor.isClosed()) {
                            }
                        }
                    }
                    this.mLocation.put(str, string);
                    this.mLocation.put(PhoneNumberUtils.formatNumber(str, Locale.getDefault().getCountry()), string);
                    if (Log.sDebug) {
                        Log.i(OplusAutoRedialNotificationUI.LOG_TAG, "home:" + PhoneNumberUtils.formatNumber(str, Locale.getDefault().getCountry()) + string);
                    }
                    if (i10 == 0) {
                        OplusAutoRedialNotificationUI.this.mPhoneLableText.setText(str + "(" + string + ")");
                        return;
                    }
                    if (i10 != 1) {
                        Log.e(OplusAutoRedialNotificationUI.LOG_TAG, "unknown case!");
                    } else {
                        OplusAutoRedialNotificationUI.this.mPhoneLableText.setText(string);
                    }
                } finally {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } catch (Exception unused) {
                Log.e(OplusAutoRedialNotificationUI.LOG_TAG, "QUERY COMPLETE EXCEPTION!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dialCall() {
        log("dialCall(): Number = " + D2.g.l(this.mNumber) + "  PhoneId = " + this.mType);
        if (TextUtils.isEmpty(this.mNumber)) {
            toNotifierCancelRedial();
            cancelMsgAndFinishScreen();
            return;
        }
        Intent intent = new Intent(OplusPhoneUtils.ACTION_CALL_PRIVILEGED);
        intent.setData(Uri.fromParts("tel", this.mNumber, null));
        intent.putExtra(OplusPhoneUtils.SUBSCRIPTION_KEY, SubscriptionManager.getSlotIndex(this.mType));
        intent.setComponent(new ComponentName("com.android.server.telecom", "com.android.server.telecom.components.UserCallActivity"));
        intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        OplusPhoneUtils.startSafeActivity(this, intent);
        this.mHandler.sendEmptyMessageDelayed(2, 150L);
    }

    private String getTimeStr(int i10) {
        if (i10 != 5000) {
            if (i10 != 60000) {
                if (i10 != 180000) {
                    return getResources().getString(R.string.oplus_five_second);
                }
                return getResources().getString(R.string.oplus_three_mins);
            }
            return getResources().getString(R.string.oplus_one_min);
        }
        return getResources().getString(R.string.oplus_five_second);
    }

    private void initFromIntent(Intent intent) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                toNotifierCancelRedial();
                finish();
                return;
            }
            this.mNumber = extras.getString("number");
            log("mNumber=" + D2.g.l(this.mNumber));
            if (TextUtils.isEmpty(this.mNumber)) {
                toNotifierCancelRedial();
                finish();
                return;
            }
            this.mName = extras.getString("name");
            this.mType = extras.getInt(TYPE, 0);
            this.mCurrentCount = extras.getInt(CURRENT_COUNT);
            this.mTotalCount = extras.getInt(TOTAL_COUNT);
            this.mDelayTime = extras.getInt(TIME, 5000);
            return;
        }
        toNotifierCancelRedial();
        finish();
    }

    private void initWidget() {
        this.mNameText = (TextView) findViewById(R.id.oplus_single_name);
        this.mPhoneTypeText = (TextView) findViewById(R.id.oplus_single_phonelabel);
        this.mPhoneLableText = (TextView) findViewById(R.id.oplus_single_label);
        this.mCountText = (TextView) findViewById(R.id.oplus_auto_redial_count);
        this.mTimeText = (TextView) findViewById(R.id.oplus_auto_redial_time);
        Button button = (Button) findViewById(R.id.oplus_cancel);
        this.mCancelBtn = button;
        if (button != null) {
            button.setOnClickListener(this);
        }
    }

    private void log(String str) {
        if (Log.sDebug) {
            Log.i(LOG_TAG, "info:" + str);
        }
    }

    private void refreshNoNameTitle() {
        log("mName=" + D2.g.o(this.mName) + " mType=" + this.mType + "mNumber " + D2.g.l(this.mNumber));
        String str = this.mName;
        if (str != null) {
            this.mNameText.setText(str);
        } else {
            this.mNameText.setText(this.mNumber);
        }
        this.mNameText.setVisibility(0);
        this.mPhoneTypeText.setVisibility(4);
        String cachLocation = this.mOplusAysnQuery.getCachLocation(this.mNumber);
        if (cachLocation != null) {
            this.mPhoneLableText.setText(cachLocation);
            return;
        }
        startQueryLocation(1);
        this.mPhoneLableText.setText(getResources().getString(R.string.unknown));
    }

    private void refreshRedailInfoWidget() {
        TextView textView = this.mCountText;
        if (textView != null) {
            textView.setText(getResources().getString(R.string.oplus_auto_redial_count, this.mCurrentCount + "/" + this.mTotalCount));
            this.mTimeText.setText(getResources().getString(R.string.oplus_auto_redial_time, getTimeStr(this.mDelayTime)));
        }
    }

    private void refreshTitle() {
        refreshNoNameTitle();
    }

    private void startQueryLocation(int i10) {
        this.mOplusAysnQuery.startQuery(i10, this.mNumber, Uri.withAppendedPath(Uri.parse(ConfigurationConstants.getInquirenoareaAuthority()), PhoneNumberUtils.stripSeparators(this.mNumber)), null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toNotifierCancelRedial() {
        if (OplusAutoRedial.getInstance(this).isInAutoRedial()) {
            OplusAutoRedial.getInstance(this).cancelRedailTask();
        }
    }

    public void cancelMsgAndFinishScreen() {
        log("cancelMsgAndFinishScreen()");
        Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(1)) {
            log("cancelMsgAndFinishScreen()+ removeMessages +DIAL_CALL");
            this.mHandler.removeMessages(1);
        }
        if (!isFinishing()) {
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        log("onBackPressed");
        toNotifierCancelRedial();
        cancelMsgAndFinishScreen();
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.oplus_cancel) {
            OplusInCallActivity activity = ((OplusInCallPresenter) InCallPresenter.getInstance()).getActivity();
            if (activity != null) {
                if (Log.sDebug) {
                    log("finish activity...");
                }
                activity.finish();
            }
            toNotifierCancelRedial();
            cancelMsgAndFinishScreen();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(67108864, 67108864);
        setContentView(R.layout.oplus_auto_redial_notification);
        this.mOplusAysnQuery = new QueryHandler(this);
        InCallPresenter.getInstance().realInstance().setOplusAutoRedialNotificationInstance(this);
        initWidget();
        initFromIntent(getIntent());
        refreshRedailInfoWidget();
        refreshTitle();
        this.mHandler.sendEmptyMessageDelayed(1, this.mDelayTime);
        PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(536870913, POWER_TAG);
        this.mPartialWakeLock = newWakeLock;
        newWakeLock.acquire();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.mFilter = intentFilter;
        registerReceiver(this.mHomeRecevier, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
        log("onCreate:" + this.mDelayTime);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (Log.sDebug) {
            log("onDestroy()...");
        }
        super.onDestroy();
        QueryHandler queryHandler = this.mOplusAysnQuery;
        if (queryHandler != null) {
            queryHandler.clearCachLocation();
        }
        Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(1)) {
            log("cancelMsgAndFinishScreen()+ removeMessages +DIAL_CALL");
            this.mHandler.removeMessages(1);
        }
        InCallPresenter.getInstance().realInstance().setOplusAutoRedialNotificationInstance(null);
        if (this.mPartialWakeLock.isHeld()) {
            try {
                this.mPartialWakeLock.release();
            } catch (Exception unused) {
                if (Log.sDebug) {
                    log("onDestroy()...mPartialWakeLock.release()");
                }
            }
        }
        unregisterReceiver(this.mHomeRecevier);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initFromIntent(getIntent());
        refreshRedailInfoWidget();
        refreshTitle();
        this.mHandler.sendEmptyMessageDelayed(1, this.mDelayTime);
        log("onNewIntent:" + this.mDelayTime);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
