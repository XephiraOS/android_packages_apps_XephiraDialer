package com.android.contacts.business.calllog.breenocall;

import P7.e;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import java.util.ArrayList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.F;
import kotlinx.coroutines.S;

/* compiled from: BreenoCallLogEntityUtils.kt */
/* loaded from: classes.dex */
public final class BreenoCallLogEntityUtils {
    private static final int CONTENT_INDEX = 4;
    private static final int DATE_INDEX = 6;
    private static final int EXT_1_INDEX = 7;
    private static final int EXT_2_INDEX = 8;
    private static final int EXT_3_INDEX = 9;
    private static final int EXT_4_INDEX = 10;
    private static final int ID_INDEX = 0;
    private static final int NAME_INDEX = 3;
    private static final int NORMALIZED_NUMBER_INDEX = 2;
    private static final int NOTE_INDEX = 5;
    private static final int NUMBER_INDEX = 1;
    private static final String TAG = "BreenoCallLogEntityUtils";
    public static final Companion Companion = new Companion(null);
    private static final String[] query_projection = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, BreenoCallContract.CallColumns.NAME_INFO, BreenoCallContract.CallColumns.PERSONAL_INFO, BreenoCallContract.CallColumns.NOTE_INFO, BreenoCallContract.BaseColumns.DATE, BreenoCallContract.BaseColumns.EXT_1, BreenoCallContract.BaseColumns.EXT_2, BreenoCallContract.BaseColumns.EXT_3, BreenoCallContract.BaseColumns.EXT_4};

    /* compiled from: BreenoCallLogEntityUtils.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ContentValues toContentValues(BreenoCallLogEntity breenoCallLogEntity) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("number", breenoCallLogEntity.getNumber());
            String normalized_number = breenoCallLogEntity.getNormalized_number();
            if (normalized_number != null) {
                contentValues.put(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, normalized_number);
            }
            String nameInfoListJson = breenoCallLogEntity.getNameInfoListJson();
            if (nameInfoListJson != null) {
                contentValues.put(BreenoCallContract.CallColumns.NAME_INFO, nameInfoListJson);
            }
            String personInfoJson = breenoCallLogEntity.getPersonInfoJson();
            if (personInfoJson != null) {
                contentValues.put(BreenoCallContract.CallColumns.PERSONAL_INFO, personInfoJson);
            }
            String noteInfoListJson = breenoCallLogEntity.getNoteInfoListJson();
            if (noteInfoListJson != null) {
                contentValues.put(BreenoCallContract.CallColumns.NOTE_INFO, noteInfoListJson);
            }
            contentValues.put(BreenoCallContract.BaseColumns.DATE, Long.valueOf(breenoCallLogEntity.getDate()));
            String ext1 = breenoCallLogEntity.getExt1();
            if (ext1 != null) {
                contentValues.put(BreenoCallContract.BaseColumns.EXT_1, ext1);
            }
            String ext2 = breenoCallLogEntity.getExt2();
            if (ext2 != null) {
                contentValues.put(BreenoCallContract.BaseColumns.EXT_2, ext2);
            }
            String ext3 = breenoCallLogEntity.getExt3();
            if (ext3 != null) {
                contentValues.put(BreenoCallContract.BaseColumns.EXT_3, ext3);
            }
            String ext4 = breenoCallLogEntity.getExt4();
            if (ext4 != null) {
                contentValues.put(BreenoCallContract.BaseColumns.EXT_4, ext4);
            }
            return contentValues;
        }

        public final BreenoCallLogEntity buildBreenoCallLogEntity(Cursor cursor) {
            i.f(cursor, "cursor");
            long j10 = cursor.getLong(0);
            String string = cursor.getString(1);
            i.e(string, "cursor.getString(NUMBER_INDEX)");
            return new BreenoCallLogEntity(j10, string, cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getLong(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));
        }

        public final ContentProviderOperation buildInsertOperation(BreenoCallLogEntity data) {
            i.f(data, "data");
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(BreenoCallContract.Call.CONTENT_URI);
            i.e(newInsert, "newInsert(BreenoCallContract.Call.CONTENT_URI)");
            newInsert.withValues(toContentValues(data));
            ContentProviderOperation build = newInsert.build();
            i.e(build, "builder.build()");
            return build;
        }

        public final ContentProviderOperation buildUpdateOperation(long j10, BreenoCallLogEntity data) {
            i.f(data, "data");
            ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContentUris.withAppendedId(BreenoCallContract.Call.CONTENT_URI, j10));
            i.e(newUpdate, "newUpdate(ContentUris.wi…ct.Call.CONTENT_URI, id))");
            newUpdate.withValues(toContentValues(data));
            ContentProviderOperation build = newUpdate.build();
            i.e(build, "builder.build()");
            return build;
        }

        public final void deleteBreenoCallLogEntities(Context context, ArrayList<String> phonelist) {
            i.f(context, "context");
            i.f(phonelist, "phonelist");
            if (FeatureOpt.isBreenoCallLogSupport() && (!phonelist.isEmpty())) {
                C1248i.d(F.a(S.b()), null, null, new BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntities$1(phonelist, context, null), 3, null);
            }
        }

        public final void deleteBreenoCallLogEntity(Context context, long j10) {
            i.f(context, "context");
            if (FeatureOpt.isBreenoCallLogSupport() && e.d(context)) {
                C1248i.d(F.a(S.b()), null, null, new BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntity$1(j10, context, null), 3, null);
            }
        }

        public final String[] getQuery_projection() {
            return BreenoCallLogEntityUtils.query_projection;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public static final BreenoCallLogEntity buildBreenoCallLogEntity(Cursor cursor) {
        return Companion.buildBreenoCallLogEntity(cursor);
    }

    public static final ContentProviderOperation buildInsertOperation(BreenoCallLogEntity breenoCallLogEntity) {
        return Companion.buildInsertOperation(breenoCallLogEntity);
    }

    public static final ContentProviderOperation buildUpdateOperation(long j10, BreenoCallLogEntity breenoCallLogEntity) {
        return Companion.buildUpdateOperation(j10, breenoCallLogEntity);
    }

    public static final void deleteBreenoCallLogEntities(Context context, ArrayList<String> arrayList) {
        Companion.deleteBreenoCallLogEntities(context, arrayList);
    }

    public static final void deleteBreenoCallLogEntity(Context context, long j10) {
        Companion.deleteBreenoCallLogEntity(context, j10);
    }

    private static final ContentValues toContentValues(BreenoCallLogEntity breenoCallLogEntity) {
        return Companion.toContentValues(breenoCallLogEntity);
    }
}
