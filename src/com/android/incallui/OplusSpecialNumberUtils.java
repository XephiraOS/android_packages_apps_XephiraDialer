package com.android.incallui;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.incallui.ContactInfoCache;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.MissingResourceException;

/* loaded from: classes.dex */
public class OplusSpecialNumberUtils {
    private static final int EN_LANGUAGE = 1;
    private static final String TAG = "OplusSpecialNumberUtils";
    private static final int TW_LANGUAGE = 3;
    private static final int ZH_LANGUAGE = 2;
    private static OplusSpecialNumberUtils sOplusSpecialNumberUtils;
    private Context mContext;
    public static final Uri SPECIAL_NUMBER_CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "special_contacts");
    private static final String[] CALLER_ID_PROJECTION = {"number", OplusSpecialNumColumns.EN_NAME, OplusSpecialNumColumns.CN_NAME, OplusSpecialNumColumns.TW_NAME, OplusSpecialNumColumns.PHOTO_DATA};
    private String mName = null;
    private Locale mLocale = null;
    private String mLanguage = null;
    private int mLanguageInt = 1;
    private byte[] mImagedata = null;

    /* loaded from: classes.dex */
    public static class OplusSpecialNumColumns {
        public static final String CN_NAME = "cn_name";
        public static final String EN_NAME = "en_name";
        public static final String NUMBER = "number";
        public static final String PHOTO_DATA = "photo_data";
        public static final String TW_NAME = "tw_name";
    }

    public OplusSpecialNumberUtils(Context context) {
        this.mContext = context;
        getLanguage();
    }

    public static synchronized OplusSpecialNumberUtils getInstance() {
        OplusSpecialNumberUtils oplusSpecialNumberUtils;
        synchronized (OplusSpecialNumberUtils.class) {
            try {
                if (sOplusSpecialNumberUtils == null) {
                    sOplusSpecialNumberUtils = new OplusSpecialNumberUtils(OplusInCallApp.getAppContext());
                }
                oplusSpecialNumberUtils = sOplusSpecialNumberUtils;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oplusSpecialNumberUtils;
    }

    private void getLanguage() {
        Locale locale = Locale.getDefault();
        this.mLocale = locale;
        try {
            String iSO3Country = locale.getISO3Country();
            this.mLanguage = iSO3Country;
            if (iSO3Country.equals("CHN")) {
                this.mLanguageInt = 2;
            } else if (this.mLanguage.equals("USA")) {
                this.mLanguageInt = 1;
            } else if (this.mLanguage.equals("TWN")) {
                this.mLanguageInt = 3;
            }
        } catch (MissingResourceException e10) {
            Log.d(TAG, "Exception: " + e10.getMessage());
        }
    }

    public InputStream getInputStreamImageOfnumber() {
        if (this.mImagedata == null) {
            return null;
        }
        return new ByteArrayInputStream(this.mImagedata);
    }

    public String getNameOfnumber() {
        return this.mName;
    }

    public boolean isSpecialNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = str.replace("-", "").replace(" ", "");
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(SPECIAL_NUMBER_CONTENT_URI, CALLER_ID_PROJECTION, "number='" + replace + "'", null, null);
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        int i10 = this.mLanguageInt;
                        if (i10 == 1) {
                            this.mName = cursor.getString(cursor.getColumnIndex(OplusSpecialNumColumns.EN_NAME));
                        } else if (i10 == 2) {
                            this.mName = cursor.getString(cursor.getColumnIndex(OplusSpecialNumColumns.CN_NAME));
                        } else if (i10 == 3) {
                            this.mName = cursor.getString(cursor.getColumnIndex(OplusSpecialNumColumns.TW_NAME));
                        }
                        this.mImagedata = cursor.getBlob(cursor.getColumnIndex(OplusSpecialNumColumns.PHOTO_DATA));
                        cursor.close();
                        return true;
                    }
                    cursor.close();
                    return false;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Exception e10) {
                Log.d(TAG, "Exception: " + e10.toString());
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public boolean isSpecialNumberByYellowPage(Call call) {
        ContactInfoCache.ContactCacheEntry contactInfo;
        if (call == null || (contactInfo = call.getContactInfo()) == null) {
            return false;
        }
        return contactInfo.isYellowPageNumber;
    }
}
