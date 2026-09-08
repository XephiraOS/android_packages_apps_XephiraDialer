package com.android.incallui;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.incallui.WearInfoQueryUtils;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: WearInfoQueryUtils.kt */
/* loaded from: classes.dex */
public final class WearInfoQueryUtils {
    private static final String FORWARD_STATE_COLUMN = "forwardState";
    private static final String TAG = "WearInfoQueryUtils";
    private static ContentResolver mContentResolver;
    private static boolean mHideIncomingCallUiByWear;
    public static final WearInfoQueryUtils INSTANCE = new WearInfoQueryUtils();
    private static final String HEALTH_CONTENT_URI = "content://com.heytap.health.sporthealthprovider/telecom/forward";
    private static final Uri mHideInComingCallUri = Uri.parse(HEALTH_CONTENT_URI);
    private static final Object mLock = new Object();

    /* compiled from: WearInfoQueryUtils.kt */
    /* loaded from: classes.dex */
    public static final class WearThreadPoolExecutor extends ThreadPoolExecutor {
        private static final int CPU_COUNT;
        public static final Companion Companion = new Companion(null);
        private static final int INIT_THREAD_COUNT;
        private static final int MAX_THREAD_COUNT;
        private static final long SURPLUS_THREAD_LIFE = 30;
        private static final String TAG = "InCallUIThreadPoolExecutor";
        private static final int WORK_QUEUE_COUNT = 64;
        private static volatile WearThreadPoolExecutor sInstance;

        /* compiled from: WearInfoQueryUtils.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public final WearThreadPoolExecutor getInstance() {
                if (WearThreadPoolExecutor.sInstance == null) {
                    synchronized (WearThreadPoolExecutor.class) {
                        try {
                            if (WearThreadPoolExecutor.sInstance == null) {
                                WearThreadPoolExecutor.sInstance = new WearThreadPoolExecutor(WearThreadPoolExecutor.INIT_THREAD_COUNT, WearThreadPoolExecutor.MAX_THREAD_COUNT, WearThreadPoolExecutor.SURPLUS_THREAD_LIFE, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new C2.a(), null);
                            }
                            m9.q qVar = m9.q.f35511a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return WearThreadPoolExecutor.sInstance;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        static {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            CPU_COUNT = availableProcessors;
            int i10 = availableProcessors + 1;
            INIT_THREAD_COUNT = i10;
            MAX_THREAD_COUNT = i10;
        }

        public /* synthetic */ WearThreadPoolExecutor(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, kotlin.jvm.internal.f fVar) {
            this(i10, i11, j10, timeUnit, blockingQueue, threadFactory);
        }

        private WearThreadPoolExecutor(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i10, i11, j10, timeUnit, blockingQueue, threadFactory, new RejectedExecutionHandler() { // from class: com.android.incallui.b0
                @Override // java.util.concurrent.RejectedExecutionHandler
                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    Log.e(WearInfoQueryUtils.WearThreadPoolExecutor.TAG, "Task rejected, too many task!");
                }
            });
        }
    }

    private WearInfoQueryUtils() {
    }

    private final void handleQueryHideIncomingCallUiByWear() {
        Cursor cursor;
        Log.d(TAG, "handleQueryHideIncomingCallUiByWear...");
        boolean z10 = false;
        try {
            ContentResolver contentResolver = mContentResolver;
            if (contentResolver != null) {
                cursor = contentResolver.query(mHideInComingCallUri, null, null, null, null);
            } else {
                cursor = null;
            }
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0 && cursor.moveToNext()) {
                        int i10 = cursor.getInt(cursor.getColumnIndex(FORWARD_STATE_COLUMN));
                        Log.i(TAG, "query health content provider, forwarding: " + i10);
                        if (i10 == 1) {
                            z10 = true;
                        }
                    }
                } finally {
                }
            }
            m9.q qVar = m9.q.f35511a;
            kotlin.io.a.a(cursor, null);
        } catch (Throwable th) {
            Log.w(TAG, "handleQueryHideIncomingCallUiByWear, query error: " + th.getMessage());
        }
        Log.i(TAG, "handleQueryHideIncomingCallUiByWear, hide: " + z10);
        synchronized (mLock) {
            mHideIncomingCallUiByWear = z10;
            m9.q qVar2 = m9.q.f35511a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryHideIncomingCallUiByWear$lambda$0(Context context) {
        kotlin.jvm.internal.i.f(context, "$context");
        if (!I2.a.b(context)) {
            Log.i(TAG, "init, health is not installed, return.");
            return;
        }
        boolean e10 = I2.a.e(mContentResolver);
        Log.d(TAG, "handleInternalInit, queryWearInfoWhenInit: " + e10);
        if (e10) {
            INSTANCE.handleQueryHideIncomingCallUiByWear();
        } else {
            mHideIncomingCallUiByWear = false;
        }
    }

    public final boolean getMHideIncomingCallUiByWear() {
        return mHideIncomingCallUiByWear;
    }

    public final void init(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        if (mContentResolver == null && contentResolver != null) {
            mContentResolver = contentResolver;
        }
    }

    public final void queryHideIncomingCallUiByWear(final Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        WearThreadPoolExecutor companion = WearThreadPoolExecutor.Companion.getInstance();
        if (companion != null) {
            companion.execute(new Runnable() { // from class: com.android.incallui.a0
                @Override // java.lang.Runnable
                public final void run() {
                    WearInfoQueryUtils.queryHideIncomingCallUiByWear$lambda$0(context);
                }
            });
        }
    }

    public final void setMHideIncomingCallUiByWear(boolean z10) {
        mHideIncomingCallUiByWear = z10;
    }
}
