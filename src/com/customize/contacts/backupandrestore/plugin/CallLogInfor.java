package com.customize.contacts.backupandrestore.plugin;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CallLogInfor {
    private String mCountryIso;
    private long mDate;
    private int mDuration;
    private int mFeatures;
    private long mId;
    private byte mIsNew;
    private String mName;
    private String mNumber;
    private String mNumberlabel;
    private byte mNumbertype;
    private int mRingTime;
    private String mTedDataType;
    private String mTedIsManual;
    private String mTedMarkType;
    private String mTedOperationType;
    private String mTedQueryNumber;
    private String mTedUploaded;
    private byte mType;
    private String mVirtualCallId;
    private int mVirtualCallType = -1;

    /* loaded from: classes3.dex */
    public static class CallLogXml {
        static final String CALLS_COUNTRYISO = "countryiso";
        static final String CALLS_DATE = "date";
        static final String CALLS_DURATION = "duration";
        static final String CALLS_FEATURES = "features";
        static final String CALLS_ID = "_id";
        static final String CALLS_ISNEW = "new";
        static final String CALLS_NAME = "name";
        static final String CALLS_NUMBER = "number";
        static final String CALLS_NUMBER_LABEL = "numberlabel";
        static final String CALLS_NUMBER_TYPE = "numbertype";
        static final String CALLS_RECORD = "CALL_RECORDS";
        static final String CALLS_RING_TIME = "ring_time";
        static final String CALLS_TYPE = "type";
        static final String CALLS_VIRTUAL_CALL_ID = "virtual_call_id";
        static final String CALLS_VIRTUAL_CALL_TYPE = "virtual_call_type";
    }

    public String getCountryIso() {
        return this.mCountryIso;
    }

    public long getDate() {
        return this.mDate;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getFeatures() {
        return this.mFeatures;
    }

    public long getId() {
        return this.mId;
    }

    public byte getIsNew() {
        return this.mIsNew;
    }

    public String getName() {
        String str = this.mName;
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    public String getNumber() {
        String str = this.mNumber;
        if (str == null) {
            return " ";
        }
        return str;
    }

    public String getNumberlabel() {
        String str = this.mNumberlabel;
        if (str == null) {
            return " ";
        }
        return str;
    }

    public byte getNumbertype() {
        return this.mNumbertype;
    }

    public int getRingTime() {
        return this.mRingTime;
    }

    public String getTedDataType() {
        return this.mTedDataType;
    }

    public String getTedIsManual() {
        return this.mTedIsManual;
    }

    public String getTedMarkType() {
        return this.mTedMarkType;
    }

    public String getTedOperationType() {
        return this.mTedOperationType;
    }

    public String getTedUploaded() {
        return this.mTedUploaded;
    }

    public byte getType() {
        return this.mType;
    }

    public String getVirtualCallId() {
        return this.mVirtualCallId;
    }

    public int getVirtualCallType() {
        return this.mVirtualCallType;
    }

    public String getmTedQueryNumber() {
        return this.mTedQueryNumber;
    }

    public void setCountryIso(String str) {
        this.mCountryIso = str;
    }

    public void setDate(long j10) {
        this.mDate = j10;
    }

    public void setDuration(int i10) {
        this.mDuration = i10;
    }

    public void setFeatures(int i10) {
        this.mFeatures = i10;
    }

    public void setId(long j10) {
        this.mId = j10;
    }

    public void setIsNew(byte b10) {
        this.mIsNew = b10;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNumber(String str) {
        this.mNumber = str;
    }

    public void setNumberlabel(String str) {
        this.mNumberlabel = str;
    }

    public void setNumbertype(byte b10) {
        this.mNumbertype = b10;
    }

    public void setRingTime(int i10) {
        this.mRingTime = i10;
    }

    public void setTedDataType(String str) {
        this.mTedDataType = str;
    }

    public void setTedIsManual(String str) {
        this.mTedIsManual = str;
    }

    public void setTedMarkType(String str) {
        this.mTedMarkType = str;
    }

    public void setTedOperationType(String str) {
        this.mTedOperationType = str;
    }

    public void setTedUploaded(String str) {
        this.mTedUploaded = str;
    }

    public void setType(byte b10) {
        this.mType = b10;
    }

    public void setVirtualCallId(String str) {
        this.mVirtualCallId = str;
    }

    public void setVirtualCallType(int i10) {
        this.mVirtualCallType = i10;
    }

    public void setmTedQueryNumber(String str) {
        this.mTedQueryNumber = str;
    }
}
