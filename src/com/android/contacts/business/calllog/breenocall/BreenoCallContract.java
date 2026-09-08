package com.android.contacts.business.calllog.breenocall;

import android.net.Uri;

/* loaded from: classes.dex */
public class BreenoCallContract {
    public static final String AUTHORITY = "com.oplus.contacts.breeno_call_info";
    public static final Uri AUTHORITY_URI = Uri.parse("content://com.oplus.contacts.breeno_call_info");

    /* loaded from: classes.dex */
    public interface BaseColumns {
        public static final String DATE = "date";
        public static final String EXT_1 = "ext_1";
        public static final String EXT_2 = "ext_2";
        public static final String EXT_3 = "ext_3";
        public static final String EXT_4 = "ext_4";
        public static final String NORMALIZED_NUMBER = "normalized_number";
        public static final String NUMBER = "number";
        public static final String _ID = "_id";
    }

    /* loaded from: classes.dex */
    public static final class Call implements CallColumns {
        public static final Uri CONTENT_FILTER_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/breeno_call";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/breeno_calls";
        public static final Uri CONTENT_URI;

        static {
            Uri withAppendedPath = Uri.withAppendedPath(BreenoCallContract.AUTHORITY_URI, "breeno_calls");
            CONTENT_URI = withAppendedPath;
            CONTENT_FILTER_URI = Uri.withAppendedPath(withAppendedPath, "filter");
        }

        private Call() {
        }
    }

    /* loaded from: classes.dex */
    public interface CallColumns extends BaseColumns {
        public static final String NAME_INFO = "name_info";
        public static final String NOTE_INFO = "note_info";
        public static final String PERSONAL_INFO = "personal_info";
    }

    /* loaded from: classes.dex */
    public static final class IntentExtras {
        public static final String BREENO_CALL_INFO = "breeno_call_info";
    }

    /* loaded from: classes.dex */
    public static final class Summary implements SummaryColumns {
        public static final Uri CONTENT_FILTER_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/breeno_summary";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/breeno_summaries";
        public static final Uri CONTENT_URI;

        static {
            Uri withAppendedPath = Uri.withAppendedPath(BreenoCallContract.AUTHORITY_URI, "breeno_summaries");
            CONTENT_URI = withAppendedPath;
            CONTENT_FILTER_URI = Uri.withAppendedPath(withAppendedPath, "filter");
        }

        private Summary() {
        }
    }

    /* loaded from: classes.dex */
    public interface SummaryColumns extends BaseColumns {
        public static final String COUNT = "count";
        public static final String EVER_ADDED = "ever_added";
        public static final String IGNORED = "ignored";
        public static final String NAME = "name";
        public static final String WHITELIST_TIMESTAMP = "whitelist_timestamp";
    }
}
