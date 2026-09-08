package com.customize.contacts.backupandrestore.plugin;

import android.net.Uri;

/* loaded from: classes3.dex */
public class TedMarkInfo {
    public static final String AUTHORITY = "com.ted.sdk.yellow.provider";
    public static final Uri TED_URI = Uri.parse("content://com.ted.sdk.yellow.provider/marker");
    private String mMarkType;
    private String mTedDataType;
    private String mTedIsManual;
    private String mTedOperationType;
    private String mTedQueryNumber;
    private String mTedUploaded;

    /* loaded from: classes3.dex */
    public static class TedBRIfo {
        static final String TED_DATA_TYPE = "data_type";
        static final String TED_IS_MANUAL = "is_manual";
        static final String TED_MARK_TYPE = "classify";
        static final String TED_NUMBER_TYPE = "phone";
        static final String TED_OPERATION_TYPE = "operation_type";
        static final String TED_QUERY_NUMBER = "ted_query_number";
        static final String TED_UPLOADED = "uploaded";
    }

    public String getMarkType() {
        return this.mMarkType;
    }

    public String getTedDataType() {
        return this.mTedDataType;
    }

    public String getTedIsManual() {
        return this.mTedIsManual;
    }

    public String getTedOperationType() {
        return this.mTedOperationType;
    }

    public String getTedUploaded() {
        return this.mTedUploaded;
    }

    public String getmTedQueryNumber() {
        return this.mTedQueryNumber;
    }

    public void setMarkType(String str) {
        this.mMarkType = str;
    }

    public void setTedDataType(String str) {
        this.mTedDataType = str;
    }

    public void setTedIsManual(String str) {
        this.mTedIsManual = str;
    }

    public void setTedOperationType(String str) {
        this.mTedOperationType = str;
    }

    public void setTedUploaded(String str) {
        this.mTedUploaded = str;
    }

    public void setmTedQueryNumber(String str) {
        this.mTedQueryNumber = str;
    }
}
