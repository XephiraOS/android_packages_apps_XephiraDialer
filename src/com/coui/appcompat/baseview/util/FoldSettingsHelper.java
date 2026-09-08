package com.coui.appcompat.baseview.util;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.coui.appcompat.baseview.util.FoldSettingsHelper;
import com.coui.appcompat.log.COUILog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.i;

/* compiled from: FoldSettingsHelper.kt */
/* loaded from: classes.dex */
public final class FoldSettingsHelper {
    public static final int SYSTEM_FOLDING_MODE_CLOSE = 0;
    public static final String SYSTEM_FOLDING_MODE_KEY = "oplus_system_folding_mode";
    public static final int SYSTEM_FOLDING_MODE_OPEN = 1;
    public static final int SYSTEM_FOLDING_MODE_UNSUPPORTED = -1;
    private static final String TAG = "FoldSettingsHelper";
    private static Context appContext;
    private static ContentObserver observer;
    public static final FoldSettingsHelper INSTANCE = new FoldSettingsHelper();
    private static int foldStatus = -1;
    private static final ArrayList<FoldSettingsObserver> foldObservers = new ArrayList<>();

    /* compiled from: FoldSettingsHelper.kt */
    /* loaded from: classes.dex */
    public interface FoldSettingsObserver {
        void observe(int i10);
    }

    private FoldSettingsHelper() {
    }

    public final int getFoldStatus() {
        return foldStatus;
    }

    public final void init(Context context) {
        i.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        i.e(applicationContext, "context.applicationContext");
        appContext = applicationContext;
        if (applicationContext == null) {
            i.q("appContext");
            applicationContext = null;
        }
        foldStatus = Settings.Global.getInt(applicationContext.getContentResolver(), SYSTEM_FOLDING_MODE_KEY, -1);
    }

    public final boolean isSupportFoldScreen() {
        if (foldStatus != -1) {
            return true;
        }
        return false;
    }

    public final void registerFoldObserver(FoldSettingsObserver observer2) {
        i.f(observer2, "observer");
        if (observer == null) {
            final Handler handler = new Handler(Looper.getMainLooper());
            ContentObserver contentObserver = new ContentObserver(handler) { // from class: com.coui.appcompat.baseview.util.FoldSettingsHelper$registerFoldObserver$1
                @Override // android.database.ContentObserver
                public void onChange(boolean z10) {
                    Context context;
                    ArrayList arrayList;
                    super.onChange(z10);
                    FoldSettingsHelper foldSettingsHelper = FoldSettingsHelper.INSTANCE;
                    context = FoldSettingsHelper.appContext;
                    if (context == null) {
                        i.q("appContext");
                        context = null;
                    }
                    foldSettingsHelper.setFoldStatus(Settings.Global.getInt(context.getContentResolver(), FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY, -1));
                    COUILog.d("FoldSettingsHelper", "FoldSettings.onChange=" + foldSettingsHelper.getFoldStatus());
                    arrayList = FoldSettingsHelper.foldObservers;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((FoldSettingsHelper.FoldSettingsObserver) it.next()).observe(FoldSettingsHelper.INSTANCE.getFoldStatus());
                    }
                }
            };
            Context context = appContext;
            if (context == null) {
                i.q("appContext");
                context = null;
            }
            context.getContentResolver().registerContentObserver(Settings.Global.getUriFor(SYSTEM_FOLDING_MODE_KEY), false, contentObserver);
            observer = contentObserver;
        }
        foldObservers.add(observer2);
    }

    public final void setFoldStatus(int i10) {
        foldStatus = i10;
    }

    public final void unregisterFoldObserver(FoldSettingsObserver observer2) {
        i.f(observer2, "observer");
        ArrayList<FoldSettingsObserver> arrayList = foldObservers;
        arrayList.remove(observer2);
        if (arrayList.isEmpty()) {
            ContentObserver contentObserver = observer;
            if (contentObserver != null) {
                Context context = appContext;
                if (context == null) {
                    i.q("appContext");
                    context = null;
                }
                context.getContentResolver().unregisterContentObserver(contentObserver);
            }
            observer = null;
        }
    }
}
