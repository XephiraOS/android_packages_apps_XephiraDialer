package com.android.contacts.business.calllog.breenocall.summary;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: AutoCallSummaryEntity.kt */
/* loaded from: classes.dex */
public final class AutoCallSummaryEntity {
    private static final int COUNT_INDEX = 6;
    private static final int EVER_ADDED_INDEX = 5;
    private static final int IGNORED_INDEX = 7;
    private static final int MAX_IN_CLAUSE_LENGTH = 1000;
    private static final int MAX_NUMBER_COUNT = 100;
    private static final int NAME_INDEX = 3;
    private static final int NORMALIZED_NUMBER_INDEX = 2;
    private static final int NUMBER_INDEX = 1;
    private static final String TAG = "AutoCallSummaryEntity";
    private static final int WHITELIST_TIMESTAMP_INDEX = 4;
    private static final int _ID_INDEX = 0;
    private long count;
    private long date;
    private long everAdded;
    private final String ext1;
    private final String ext2;
    private final String ext3;
    private final String ext4;
    private final long id;
    private long ignored;
    private final String name;
    private final String normalizedNumber;
    private final String number;
    private long whitelistTimestamp;
    public static final Companion Companion = new Companion(null);
    private static final String[] PROJECTION = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "name", BreenoCallContract.SummaryColumns.WHITELIST_TIMESTAMP, BreenoCallContract.SummaryColumns.EVER_ADDED, BreenoCallContract.SummaryColumns.COUNT, BreenoCallContract.SummaryColumns.IGNORED};

    /* compiled from: AutoCallSummaryEntity.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AutoCallSummaryEntity fromCursor(Cursor cursor) {
            long j10 = cursor.getLong(0);
            String string = cursor.getString(1);
            i.e(string, "cursor.getString(NUMBER_INDEX)");
            return new AutoCallSummaryEntity(j10, string, cursor.getString(2), cursor.getString(3), cursor.getLong(4), cursor.getLong(5), cursor.getLong(6), cursor.getLong(7), 0L, null, null, null, null, 7936, null);
        }

        public static /* synthetic */ ArrayList getSummaryEntities$default(Companion companion, Context context, ArrayList arrayList, ArrayList arrayList2, String str, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                str = null;
            }
            return companion.getSummaryEntities(context, arrayList, arrayList2, str);
        }

        public final ArrayList<AutoCallSummaryEntity> getSummaryEntities(Context context, ArrayList<String> numbers, ArrayList<String> arrayList, String str) {
            Object b10;
            String str2;
            String str3;
            String str4;
            Cursor query;
            i.f(context, "context");
            i.f(numbers, "numbers");
            ArrayList<AutoCallSummaryEntity> arrayList2 = new ArrayList<>();
            try {
                Result.a aVar = Result.f34166a;
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            if (!numbers.isEmpty() || (arrayList != null && !arrayList.isEmpty())) {
                q qVar = null;
                if (!numbers.isEmpty()) {
                    str2 = G7.a.e(numbers);
                    if (numbers.size() > 100 || str2.length() > 1000) {
                        H7.b.i(AutoCallSummaryEntity.TAG, "getSummaryEntities: too many numbers, size: " + numbers.size() + ", length: " + str2.length());
                        return arrayList2;
                    }
                } else {
                    str2 = null;
                }
                if (arrayList != null && (!arrayList.isEmpty())) {
                    str3 = G7.a.e(arrayList);
                    if (arrayList.size() > 100 || str3.length() > 1000) {
                        H7.b.i(AutoCallSummaryEntity.TAG, "getSummaryEntities: too many normalizedNumbers, size: " + arrayList.size() + ", length: " + str3.length());
                        return arrayList2;
                    }
                } else {
                    str3 = null;
                }
                if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                    H7.b.i(AutoCallSummaryEntity.TAG, "getSummaryEntities: inclause1 and inclause2 are empty.");
                    return arrayList2;
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    str4 = "(number IN " + str2 + " OR normalized_number IN " + str3 + ")";
                } else if (!TextUtils.isEmpty(str2)) {
                    str4 = "(number IN " + str2 + ")";
                } else {
                    str4 = "(normalized_number IN " + str3 + ")";
                }
                if (!TextUtils.isEmpty(str)) {
                    str4 = str4 + " AND (" + str + ")";
                }
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null && (query = contentResolver.query(BreenoCallContract.Summary.CONTENT_URI, AutoCallSummaryEntity.PROJECTION, str4, null, "_id ASC")) != null) {
                    try {
                        if (H7.a.b()) {
                            H7.b.b(AutoCallSummaryEntity.TAG, "selectionClause: " + str4 + ", count: " + query.getCount());
                        }
                        while (query.moveToNext()) {
                            arrayList2.add(AutoCallSummaryEntity.Companion.fromCursor(query));
                        }
                        q qVar2 = q.f35511a;
                        kotlin.io.a.a(query, null);
                        qVar = q.f35511a;
                    } finally {
                    }
                }
                b10 = Result.b(qVar);
                Throwable d10 = Result.d(b10);
                if (d10 != null) {
                    H7.b.c(AutoCallSummaryEntity.TAG, "getSummaryEntities: exception: " + d10);
                }
                return arrayList2;
            }
            H7.b.i(AutoCallSummaryEntity.TAG, "getSummaryEntities: no numbers and no normalizedNumbers.");
            return arrayList2;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public AutoCallSummaryEntity(long j10, String number, String str, String str2, long j11, long j12, long j13, long j14, long j15, String str3, String str4, String str5, String str6) {
        i.f(number, "number");
        this.id = j10;
        this.number = number;
        this.normalizedNumber = str;
        this.name = str2;
        this.whitelistTimestamp = j11;
        this.everAdded = j12;
        this.count = j13;
        this.ignored = j14;
        this.date = j15;
        this.ext1 = str3;
        this.ext2 = str4;
        this.ext3 = str5;
        this.ext4 = str6;
    }

    private static final AutoCallSummaryEntity fromCursor(Cursor cursor) {
        return Companion.fromCursor(cursor);
    }

    public static final ArrayList<AutoCallSummaryEntity> getSummaryEntities(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str) {
        return Companion.getSummaryEntities(context, arrayList, arrayList2, str);
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.ext1;
    }

    public final String component11() {
        return this.ext2;
    }

    public final String component12() {
        return this.ext3;
    }

    public final String component13() {
        return this.ext4;
    }

    public final String component2() {
        return this.number;
    }

    public final String component3() {
        return this.normalizedNumber;
    }

    public final String component4() {
        return this.name;
    }

    public final long component5() {
        return this.whitelistTimestamp;
    }

    public final long component6() {
        return this.everAdded;
    }

    public final long component7() {
        return this.count;
    }

    public final long component8() {
        return this.ignored;
    }

    public final long component9() {
        return this.date;
    }

    public final AutoCallSummaryEntity copy(long j10, String number, String str, String str2, long j11, long j12, long j13, long j14, long j15, String str3, String str4, String str5, String str6) {
        i.f(number, "number");
        return new AutoCallSummaryEntity(j10, number, str, str2, j11, j12, j13, j14, j15, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutoCallSummaryEntity)) {
            return false;
        }
        AutoCallSummaryEntity autoCallSummaryEntity = (AutoCallSummaryEntity) obj;
        if (this.id == autoCallSummaryEntity.id && i.b(this.number, autoCallSummaryEntity.number) && i.b(this.normalizedNumber, autoCallSummaryEntity.normalizedNumber) && i.b(this.name, autoCallSummaryEntity.name) && this.whitelistTimestamp == autoCallSummaryEntity.whitelistTimestamp && this.everAdded == autoCallSummaryEntity.everAdded && this.count == autoCallSummaryEntity.count && this.ignored == autoCallSummaryEntity.ignored && this.date == autoCallSummaryEntity.date && i.b(this.ext1, autoCallSummaryEntity.ext1) && i.b(this.ext2, autoCallSummaryEntity.ext2) && i.b(this.ext3, autoCallSummaryEntity.ext3) && i.b(this.ext4, autoCallSummaryEntity.ext4)) {
            return true;
        }
        return false;
    }

    public final long getCount() {
        return this.count;
    }

    public final long getDate() {
        return this.date;
    }

    public final long getEverAdded() {
        return this.everAdded;
    }

    public final String getExt1() {
        return this.ext1;
    }

    public final String getExt2() {
        return this.ext2;
    }

    public final String getExt3() {
        return this.ext3;
    }

    public final String getExt4() {
        return this.ext4;
    }

    public final long getId() {
        return this.id;
    }

    public final long getIgnored() {
        return this.ignored;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNormalizedNumber() {
        return this.normalizedNumber;
    }

    public final String getNumber() {
        return this.number;
    }

    public final long getWhitelistTimestamp() {
        return this.whitelistTimestamp;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6 = ((Long.hashCode(this.id) * 31) + this.number.hashCode()) * 31;
        String str = this.normalizedNumber;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = (hashCode6 + hashCode) * 31;
        String str2 = this.name;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int hashCode7 = (((((((((((i11 + hashCode2) * 31) + Long.hashCode(this.whitelistTimestamp)) * 31) + Long.hashCode(this.everAdded)) * 31) + Long.hashCode(this.count)) * 31) + Long.hashCode(this.ignored)) * 31) + Long.hashCode(this.date)) * 31;
        String str3 = this.ext1;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i12 = (hashCode7 + hashCode3) * 31;
        String str4 = this.ext2;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i13 = (i12 + hashCode4) * 31;
        String str5 = this.ext3;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i14 = (i13 + hashCode5) * 31;
        String str6 = this.ext4;
        if (str6 != null) {
            i10 = str6.hashCode();
        }
        return i14 + i10;
    }

    public final void setCount(long j10) {
        this.count = j10;
    }

    public final void setDate(long j10) {
        this.date = j10;
    }

    public final void setEverAdded(long j10) {
        this.everAdded = j10;
    }

    public final void setIgnored(long j10) {
        this.ignored = j10;
    }

    public final void setWhitelistTimestamp(long j10) {
        this.whitelistTimestamp = j10;
    }

    public String toString() {
        return "AutoCallSummaryEntity(id=" + this.id + ", number=" + this.number + ", normalizedNumber=" + this.normalizedNumber + ", name=" + this.name + ", whitelistTimestamp=" + this.whitelistTimestamp + ", everAdded=" + this.everAdded + ", count=" + this.count + ", ignored=" + this.ignored + ", date=" + this.date + ", ext1=" + this.ext1 + ", ext2=" + this.ext2 + ", ext3=" + this.ext3 + ", ext4=" + this.ext4 + ")";
    }

    public /* synthetic */ AutoCallSummaryEntity(long j10, String str, String str2, String str3, long j11, long j12, long j13, long j14, long j15, String str4, String str5, String str6, String str7, int i10, f fVar) {
        this(j10, str, str2, str3, (i10 & 16) != 0 ? 0L : j11, (i10 & 32) != 0 ? 0L : j12, (i10 & 64) != 0 ? 0L : j13, (i10 & 128) != 0 ? 0L : j14, (i10 & 256) != 0 ? 0L : j15, (i10 & 512) != 0 ? null : str4, (i10 & 1024) != 0 ? null : str5, (i10 & 2048) != 0 ? null : str6, (i10 & 4096) != 0 ? null : str7);
    }
}
