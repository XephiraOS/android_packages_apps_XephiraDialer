package B3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.customize.contacts.util.C0801l;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* compiled from: UpdateCallRecordingService.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f255a = "(mime_type in (?, ?, ?, ?)) AND (relative_path LIKE '" + com.android.contacts.framework.baseui.calllog.a.f15767b + "%') AND (_size!=0)";

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f256b = {"audio/amr", "audio/x-wav", "audio/mpeg", "audio/amr-wb"};

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.oplus.foundation.util.ui.c.c(context, context.getString(R.string.can_not_find_call_records));
        try {
            context.getContentResolver().delete(com.android.contacts.framework.baseui.calllog.a.f15766a, " path = ?", new String[]{str});
        } catch (Exception e10) {
            H7.b.c("UpdateCallRecordingService", "delete call record error" + e10);
        }
    }

    public static Cursor b(Context context) {
        try {
            return context.getContentResolver().query(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, new String[]{"number", BreenoCallContract.BaseColumns.DATE, "duration"}, null, null, null);
        } catch (Exception e10) {
            H7.b.b("UpdateCallRecordingService", "getCallLogInfo error " + e10);
            return null;
        }
    }

    public static Cursor c(Context context) {
        try {
            return context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, f255a, f256b, null);
        } catch (Exception e10) {
            H7.b.c("UpdateCallRecordingService", "getCallRecodingInfo error " + e10.getMessage());
            return null;
        }
    }

    public static boolean d(long j10, long j11, int i10) {
        long j12 = j11 / 1000;
        if (j10 >= j12 - 1 && j10 <= j12 + i10 + 15) {
            return true;
        }
        return false;
    }

    public static void e(Context context) {
        int i10;
        int i11;
        int i12;
        int i13;
        ArrayList arrayList = new ArrayList();
        try {
            Cursor c10 = c(context);
            try {
                Cursor b10 = b(context);
                if (c10 != null) {
                    try {
                        if (c10.getCount() > 0 && b10 != null && b10.getCount() > 0) {
                            int columnIndex = c10.getColumnIndex("date_modified");
                            int columnIndex2 = c10.getColumnIndex("_data");
                            int columnIndex3 = c10.getColumnIndex("duration");
                            int columnIndex4 = b10.getColumnIndex(BreenoCallContract.BaseColumns.DATE);
                            int columnIndex5 = b10.getColumnIndex("duration");
                            int columnIndex6 = b10.getColumnIndex("number");
                            while (c10.moveToNext()) {
                                long j10 = c10.getLong(columnIndex);
                                String string = c10.getString(columnIndex2);
                                int i14 = c10.getInt(columnIndex3);
                                if (b10.moveToFirst()) {
                                    i11 = columnIndex;
                                    i12 = columnIndex2;
                                    while (true) {
                                        long j11 = b10.getLong(columnIndex4);
                                        i13 = columnIndex3;
                                        int i15 = b10.getInt(columnIndex5);
                                        i10 = columnIndex5;
                                        String string2 = b10.getString(columnIndex6);
                                        if (d(j10, j11, i15)) {
                                            ContentValues contentValues = new ContentValues();
                                            contentValues.put("number", string2);
                                            contentValues.put("call_log_mapping", Long.valueOf(j11));
                                            contentValues.put(Constants.MessagerConstants.PATH_KEY, string);
                                            contentValues.put("sec_record", Integer.valueOf(i14));
                                            arrayList.add(contentValues);
                                        }
                                        if (!b10.moveToNext()) {
                                            break;
                                        }
                                        columnIndex3 = i13;
                                        columnIndex5 = i10;
                                    }
                                } else {
                                    i10 = columnIndex5;
                                    i11 = columnIndex;
                                    i12 = columnIndex2;
                                    i13 = columnIndex3;
                                }
                                columnIndex = i11;
                                columnIndex2 = i12;
                                columnIndex3 = i13;
                                columnIndex5 = i10;
                            }
                            if (arrayList.size() > 0) {
                                try {
                                    ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
                                    arrayList.toArray(contentValuesArr);
                                    context.getContentResolver().bulkInsert(com.android.contacts.framework.baseui.calllog.a.f15766a, contentValuesArr);
                                    arrayList.clear();
                                } catch (Exception e10) {
                                    H7.b.c("UpdateCallRecordingService", "batch insert call log failed." + e10);
                                }
                            }
                        }
                    } finally {
                    }
                }
                C0801l.u(context, false);
                C0801l.v(context);
                if (b10 != null) {
                    b10.close();
                }
                if (c10 != null) {
                    c10.close();
                }
            } finally {
            }
        } catch (Exception e11) {
            H7.b.c("UpdateCallRecordingService", "updateCallLogRecordTable error " + e11);
        }
    }
}
