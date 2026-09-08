package com.android.incallui;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.internal_dependency.InternalSdkDepends;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CallerInfoAsyncQuery {
    private static final boolean DBG = Log.sDebug;
    private static final boolean ENABLE_UNKNOWN_NUMBER_GEO_DESCRIPTION = true;
    private static final int EVENT_ADD_LISTENER = 2;
    private static final int EVENT_EMERGENCY_NUMBER = 4;
    private static final int EVENT_END_OF_QUEUE = 3;
    private static final int EVENT_NEW_QUERY = 1;
    private static final int EVENT_VOICEMAIL_NUMBER = 5;
    private static final String LOG_TAG = "CallerInfoAsyncQuery";
    private CallerInfoAsyncQueryHandler mHandler;

    /* loaded from: classes.dex */
    public class CallerInfoAsyncQueryHandler extends AsyncQueryHandler {
        private CallerInfo mCallerInfo;
        private Context mQueryContext;
        private Uri mQueryUri;

        /* loaded from: classes.dex */
        public class CallerInfoWorkerHandler extends AsyncQueryHandler.WorkerHandler {
            public CallerInfoWorkerHandler(Looper looper) {
                super(CallerInfoAsyncQueryHandler.this, looper);
            }

            @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
            public void handleMessage(Message message) {
                AsyncQueryHandler.WorkerArgs workerArgs = (AsyncQueryHandler.WorkerArgs) message.obj;
                CookieWrapper cookieWrapper = (CookieWrapper) workerArgs.cookie;
                if (cookieWrapper == null) {
                    Log.d(this, "Unexpected command (CookieWrapper is null): " + message.what + " ignored by CallerInfoWorkerHandler, passing onto parent.");
                    super.handleMessage(message);
                    return;
                }
                Log.d(this, "Processing event: " + cookieWrapper.event + " token (arg1): " + message.arg1 + " command: " + message.what + " query URI: " + D2.g.o(CallerInfoAsyncQuery.sanitizeUriToString(workerArgs.uri)));
                int i10 = cookieWrapper.event;
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) {
                        Message obtainMessage = workerArgs.handler.obtainMessage(message.what);
                        obtainMessage.obj = workerArgs;
                        obtainMessage.arg1 = message.arg1;
                        obtainMessage.sendToTarget();
                        return;
                    }
                    return;
                }
                super.handleMessage(message);
            }
        }

        @Override // android.content.AsyncQueryHandler
        public Handler createHandler(Looper looper) {
            return new CallerInfoWorkerHandler(looper);
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i10, Object obj, Cursor cursor) {
            CookieWrapper cookieWrapper;
            Uri uri;
            try {
                try {
                    D2.g.k(CallerInfoAsyncQuery.LOG_TAG, "##### onQueryComplete() #####   query complete for token: " + i10 + "  cookie = " + obj);
                    cookieWrapper = (CookieWrapper) obj;
                } catch (Exception e10) {
                    Log.e(this, e10.getMessage());
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                }
                if (cookieWrapper == null) {
                    Log.d(this, "Cookie is null, ignoring onQueryComplete() request.");
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                int i11 = cookieWrapper.event;
                if (i11 == 3) {
                    CallerInfoAsyncQuery.this.release();
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                if (this.mCallerInfo == null) {
                    Context context = this.mQueryContext;
                    if (context != null && (uri = this.mQueryUri) != null) {
                        if (i11 == 4) {
                            if (!context.getResources().getBoolean(R.bool.mark_emergency_call) && !"cmcc".equals(InternalSdkDepends.getSInstance().getStringSystemProperties("persist.carrier.mode", ""))) {
                                Log.d(this, "Emergency Number and Mark Emergency Number disabled");
                                this.mCallerInfo = new CallerInfo().markAsEmergency(this.mQueryContext);
                            }
                            Log.d(this, "Emergency Number and Mark Emergency Number enabled");
                            this.mCallerInfo = new CallerInfo().markAsEmergency(this.mQueryContext, cookieWrapper.number);
                        } else if (i11 == 5) {
                            this.mCallerInfo = new CallerInfo().markAsVoiceMail(this.mQueryContext);
                        } else {
                            this.mCallerInfo = CallerInfo.getCallerInfo(context, uri, cursor);
                            Log.d(this, "==> Got mCallerInfo: " + this.mCallerInfo);
                            CallerInfo doSecondaryLookupIfNecessary = CallerInfo.doSecondaryLookupIfNecessary(this.mQueryContext, cookieWrapper.number, this.mCallerInfo);
                            if (doSecondaryLookupIfNecessary != this.mCallerInfo) {
                                this.mCallerInfo = doSecondaryLookupIfNecessary;
                                Log.d(this, "#####async contact look up with numeric username" + this.mCallerInfo);
                            }
                            if (!TextUtils.isEmpty(cookieWrapper.number)) {
                                CallerInfo callerInfo = this.mCallerInfo;
                                callerInfo.phoneNumber = PhoneNumberUtils.formatNumber(cookieWrapper.number, callerInfo.normalizedNumber, InternalSdkDepends.getSInstance().getCurrentCountryIso(this.mQueryContext));
                            }
                        }
                        Log.d(this, "constructing CallerInfo object for token: " + i10);
                        CookieWrapper cookieWrapper2 = new CookieWrapper();
                        cookieWrapper2.event = 3;
                        startQuery(i10, cookieWrapper2, null, null, null, null, null);
                    } else {
                        throw new QueryPoolException("Bad context or query uri, or CallerInfoAsyncQuery already released.");
                    }
                }
                if (cookieWrapper.listener != null) {
                    Log.d(this, "notifying listener: " + cookieWrapper.listener.getClass().toString() + " for token: " + i10);
                    if (this.mCallerInfo != null) {
                        D2.g.k(CallerInfoAsyncQuery.LOG_TAG, "notifying personId = " + this.mCallerInfo.contactIdOrZero + " name = " + D2.g.o(this.mCallerInfo.name));
                    }
                    cookieWrapper.listener.onQueryComplete(i10, cookieWrapper.cookie, this.mCallerInfo);
                }
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // android.content.AsyncQueryHandler
        public void startQuery(int i10, Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            if (CallerInfoAsyncQuery.DBG) {
                android.util.Log.d(CallerInfoAsyncQuery.LOG_TAG, "InCall: startQuery: url=" + D2.g.o(uri) + " projection=[" + Arrays.toString(strArr) + "] selection=" + str + "  args=[" + Arrays.toString(strArr2) + "]");
            }
            D2.g.k(CallerInfoAsyncQuery.LOG_TAG, "start query contact info");
            super.startQuery(i10, obj, uri, strArr, str, strArr2, str2);
        }

        private CallerInfoAsyncQueryHandler(Context context) {
            super(context.getContentResolver());
        }
    }

    /* loaded from: classes.dex */
    public static final class CookieWrapper {
        public Object cookie;
        public int event;
        public OnQueryCompleteListener listener;
        public String number;

        private CookieWrapper() {
        }
    }

    /* loaded from: classes.dex */
    public interface OnQueryCompleteListener {
        void onQueryComplete(int i10, Object obj, CallerInfo callerInfo);
    }

    /* loaded from: classes.dex */
    public static class QueryPoolException extends SQLException {
        public QueryPoolException(String str) {
            super(str);
        }
    }

    private CallerInfoAsyncQuery() {
    }

    private void allocate(Context context, Uri uri) {
        if (context != null && uri != null) {
            CallerInfoAsyncQueryHandler callerInfoAsyncQueryHandler = new CallerInfoAsyncQueryHandler(context);
            this.mHandler = callerInfoAsyncQueryHandler;
            callerInfoAsyncQueryHandler.mQueryContext = context;
            this.mHandler.mQueryUri = uri;
            return;
        }
        Log.e(LOG_TAG, "Bad context or query uri.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.mHandler.mQueryContext = null;
        this.mHandler.mQueryUri = null;
        this.mHandler.mCallerInfo = null;
        this.mHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String sanitizeUriToString(Uri uri) {
        if (uri != null) {
            String uri2 = uri.toString();
            int lastIndexOf = uri2.lastIndexOf(47);
            if (lastIndexOf > 0) {
                return uri2.substring(0, lastIndexOf) + "/xxxxxxx";
            }
            return uri2;
        }
        return "";
    }

    public static CallerInfoAsyncQuery startQuery(int i10, Context context, CallerInfo callerInfo, OnQueryCompleteListener onQueryCompleteListener, Object obj) {
        Uri build;
        boolean z10 = DBG;
        if (z10) {
            Log.d(LOG_TAG, "##### CallerInfoAsyncQuery startQuery()... #####");
            Log.d(LOG_TAG, "- number: " + D2.g.l(callerInfo.phoneNumber));
        }
        if (z10) {
            Log.d(LOG_TAG, "==> info.contactRefUri: " + D2.g.o(callerInfo.contactRefUri));
        }
        Uri uri = callerInfo.contactRefUri;
        if (uri != null) {
            build = uri.buildUpon().appendQueryParameter("oppo_query", "true").appendQueryParameter("query_omoji", "true").appendQueryParameter("query_vip", "true").build();
        } else {
            build = ContactsContract.PhoneLookup.CONTENT_FILTER_URI.buildUpon().appendPath(callerInfo.phoneNumber).appendQueryParameter("oppo_query", "true").appendQueryParameter("query_omoji", "true").appendQueryParameter("query_vip", "true").build();
        }
        Uri uri2 = build;
        if (z10) {
            Log.d(LOG_TAG, "==> contactRef: " + D2.g.o(sanitizeUriToString(uri2)));
        }
        CallerInfoAsyncQuery callerInfoAsyncQuery = new CallerInfoAsyncQuery();
        if (context == null) {
            return callerInfoAsyncQuery;
        }
        callerInfoAsyncQuery.allocate(context, uri2);
        CookieWrapper cookieWrapper = new CookieWrapper();
        cookieWrapper.listener = onQueryCompleteListener;
        cookieWrapper.cookie = obj;
        cookieWrapper.number = callerInfo.phoneNumber;
        if (callerInfo.isVoiceMailNumber()) {
            cookieWrapper.event = 5;
        } else {
            cookieWrapper.event = 1;
        }
        callerInfoAsyncQuery.mHandler.startQuery(i10, cookieWrapper, uri2, null, null, null, null);
        return callerInfoAsyncQuery;
    }
}
