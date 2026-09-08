package com.android.incallui.oplus.share;

import A2.w;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import i2.b;
import java.util.HashMap;

/* loaded from: classes.dex */
public class OplusStatisticsService extends Service {

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context baseContext = OplusStatisticsService.this.getBaseContext();
            if (!OplusPhoneUtils.isNeedHideRecord(baseContext)) {
                HashMap hashMap = new HashMap();
                hashMap.put("all_call_audio_record", Integer.valueOf(b.f(baseContext) ? 1 : 0));
                hashMap.put("all_stranger_call_audio_record", Integer.valueOf(b.g(baseContext) ? 1 : 0));
                hashMap.put("max_audio_record_setting", Integer.valueOf(b.d(baseContext)));
                OplusPhoneUserActionStatistics.onCommon(baseContext, OplusPhoneUserActionStatistics.TAG_AUTO_RECORD, OplusPhoneUserActionStatistics.AUTO_RECORD_STATUS, hashMap);
            }
            w e10 = w.e();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("day_ui_showing_time", Long.valueOf(e10.f() / 1000));
            hashMap2.put("day_call_time", Long.valueOf(e10.d() / 1000));
            OplusPhoneUserActionStatistics.onCommon(baseContext, OplusPhoneUserActionStatistics.TAG_TECHNOLOGY_STATISTIC, OplusPhoneUserActionStatistics.DAY_UI_SHOWING_TIME, hashMap2);
            e10.i(0L);
            e10.g(0L);
            OplusStatisticsService.this.stopSelf();
        }
    }

    public final void a() {
        C2.b.a().execute(new a());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        super.onStart(intent, i10);
        Log.d("OplusStatisticsService", "OplusStatisticsService onStart");
        a();
    }
}
