package com.android.incallui.oplus.audiorecord;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.core.app.JobIntentService;
import com.android.incallui.Log;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import i2.b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class OplusAutoClearRecordJobIntentService extends JobIntentService {
    public static void k(Context context, Intent intent) {
        Log.d("OplusAutoClearRecordJobIntentService", "enqueue an auto clear record JobIntentService");
        JobIntentService.d(context, OplusAutoClearRecordJobIntentService.class, 10001, intent);
    }

    @Override // androidx.core.app.JobIntentService
    public void g(Intent intent) {
        j();
    }

    public final void j() {
        Log.d("OplusAutoClearRecordJobIntentService", "doAutoClear!");
        try {
            Thread.sleep(COUIScrollBar.SCROLLER_FADE_TIMEOUT);
        } catch (Exception unused) {
        }
        Cursor cursor = null;
        try {
            try {
                Cursor i10 = b.i(this);
                if (i10 != null) {
                    try {
                        int count = i10.getCount();
                        int d10 = b.d(this);
                        Log.d("OplusAutoClearRecordJobIntentService", "totalCount = " + count + " maxCount = " + d10);
                        if (d10 != 0 && count > d10) {
                            ArrayList arrayList = new ArrayList();
                            for (int i11 = 0; i11 < count - d10; i11++) {
                                i10.moveToPosition(i11);
                                arrayList.add(i10.getString(4));
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                b.b(this, (String) it.next());
                            }
                        }
                        i10.close();
                    } catch (Exception e10) {
                        e = e10;
                        cursor = i10;
                        Log.d("OplusAutoClearRecordJobIntentService", "Exception: " + e.toString());
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    } catch (Throwable th) {
                        th = th;
                        cursor = i10;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else {
                    cursor = i10;
                }
                if (cursor == null) {
                    return;
                }
            } catch (Exception e11) {
                e = e11;
            }
            cursor.close();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        Log.d("OplusAutoClearRecordJobIntentService", "onCreate");
        super.onCreate();
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onDestroy() {
        Log.d("OplusAutoClearRecordJobIntentService", "onDestroy!");
        super.onDestroy();
    }
}
