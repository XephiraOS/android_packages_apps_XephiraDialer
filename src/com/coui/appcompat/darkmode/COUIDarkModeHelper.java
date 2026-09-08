package com.coui.appcompat.darkmode;

import B.a;
import android.app.Application;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Color;
import android.os.Handler;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class COUIDarkModeHelper {
    private static final String KEY_BACKGROUNDMAXL = "DarkMode_BackgroundMaxL";
    private static final String KEY_DIALOGBGMAXL = "DarkMode_DialogBgMaxL";
    private static final String KEY_FOREGROUNDMINL = "DarkMode_ForegroundMinL";
    private float mSystemDarkModeDialogBgMaxL = -1.0f;
    private float mSystemDarkModeBackgroundMaxL = -1.0f;
    private float mSystemDarkModeForegroundMinL = -1.0f;
    private List<ICOUIDarkColorObserver> mObservers = new ArrayList();

    /* loaded from: classes.dex */
    public static class Holder {
        static COUIDarkModeHelper INSTANCE = new COUIDarkModeHelper();

        private Holder() {
        }
    }

    /* loaded from: classes.dex */
    public interface ICOUIDarkColorObserver {
        void onBackgroundChange();

        void onDialogBackgroundChange();

        void onForegroundChange();
    }

    public static COUIDarkModeHelper getInstance() {
        return Holder.INSTANCE;
    }

    private void initObserver(final Context context) {
        this.mSystemDarkModeDialogBgMaxL = Settings.Global.getFloat(context.getContentResolver(), KEY_DIALOGBGMAXL, -1.0f);
        this.mSystemDarkModeBackgroundMaxL = Settings.Global.getFloat(context.getContentResolver(), KEY_BACKGROUNDMAXL, -1.0f);
        this.mSystemDarkModeForegroundMinL = Settings.Global.getFloat(context.getContentResolver(), KEY_FOREGROUNDMINL, -1.0f);
        Handler handler = null;
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor(KEY_DIALOGBGMAXL), true, new ContentObserver(handler) { // from class: com.coui.appcompat.darkmode.COUIDarkModeHelper.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z10) {
                super.onChange(z10);
                COUIDarkModeHelper.this.mSystemDarkModeDialogBgMaxL = Settings.Global.getFloat(context.getContentResolver(), COUIDarkModeHelper.KEY_DIALOGBGMAXL, -1.0f);
                COUIDarkModeHelper.this.notifyDialogBackgroundObserver();
            }
        });
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor(KEY_BACKGROUNDMAXL), true, new ContentObserver(handler) { // from class: com.coui.appcompat.darkmode.COUIDarkModeHelper.2
            @Override // android.database.ContentObserver
            public void onChange(boolean z10) {
                super.onChange(z10);
                COUIDarkModeHelper.this.mSystemDarkModeBackgroundMaxL = Settings.Global.getFloat(context.getContentResolver(), COUIDarkModeHelper.KEY_BACKGROUNDMAXL, -1.0f);
                COUIDarkModeHelper.this.notifyBackgroundObserver();
            }
        });
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor(KEY_FOREGROUNDMINL), true, new ContentObserver(handler) { // from class: com.coui.appcompat.darkmode.COUIDarkModeHelper.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z10) {
                super.onChange(z10);
                COUIDarkModeHelper.this.mSystemDarkModeForegroundMinL = Settings.Global.getFloat(context.getContentResolver(), COUIDarkModeHelper.KEY_FOREGROUNDMINL, -1.0f);
                COUIDarkModeHelper.this.notifyForegroundObserver();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBackgroundObserver() {
        List<ICOUIDarkColorObserver> list = this.mObservers;
        if (list != null && list.size() != 0) {
            Iterator<ICOUIDarkColorObserver> it = this.mObservers.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundChange();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDialogBackgroundObserver() {
        List<ICOUIDarkColorObserver> list = this.mObservers;
        if (list != null && list.size() != 0) {
            Iterator<ICOUIDarkColorObserver> it = this.mObservers.iterator();
            while (it.hasNext()) {
                it.next().onDialogBackgroundChange();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyForegroundObserver() {
        List<ICOUIDarkColorObserver> list = this.mObservers;
        if (list != null && list.size() != 0) {
            Iterator<ICOUIDarkColorObserver> it = this.mObservers.iterator();
            while (it.hasNext()) {
                it.next().onForegroundChange();
            }
        }
    }

    public void addObserver(COUIDarkColorObserver cOUIDarkColorObserver) {
        if (cOUIDarkColorObserver != null && !this.mObservers.contains(cOUIDarkColorObserver)) {
            this.mObservers.add(cOUIDarkColorObserver);
        }
    }

    public void attach(Application application) {
        initObserver(application.getApplicationContext());
    }

    public int getBackgroundColor() {
        return makeDark(-1);
    }

    public int getDialogBackgroundColor() {
        return makeDialogDark(-1);
    }

    public int getForegroundColor() {
        return makeLight(-16777216);
    }

    public int makeDark(int i10) {
        float f10 = this.mSystemDarkModeBackgroundMaxL;
        double[] dArr = new double[3];
        a.n(i10, dArr);
        double d10 = dArr[0];
        double d11 = 100.0d - d10;
        if (d11 < d10) {
            if (f10 != -1.0f) {
                d11 = ((d11 / 50.0d) * (50.0f - f10)) + f10;
            }
            double d12 = d11;
            dArr[0] = d12;
            int b10 = a.b(d12, dArr[1], dArr[2]);
            return Color.argb(Color.alpha(i10), Color.red(b10), Color.green(b10), Color.blue(b10));
        }
        return i10;
    }

    public int makeDialogDark(int i10) {
        float f10 = this.mSystemDarkModeDialogBgMaxL;
        double[] dArr = new double[3];
        a.n(i10, dArr);
        double d10 = dArr[0];
        double d11 = 100.0d - d10;
        if (d11 < d10) {
            if (f10 != -1.0f) {
                d11 = ((d11 / 50.0d) * (50.0f - f10)) + f10;
            }
            double d12 = d11;
            dArr[0] = d12;
            int b10 = a.b(d12, dArr[1], dArr[2]);
            return Color.argb(Color.alpha(i10), Color.red(b10), Color.green(b10), Color.blue(b10));
        }
        return i10;
    }

    public int makeLight(int i10) {
        float f10 = this.mSystemDarkModeForegroundMinL;
        double[] dArr = new double[3];
        a.n(i10, dArr);
        double d10 = dArr[0];
        double d11 = 100.0d - d10;
        if (d11 > d10) {
            if (f10 != -1.0f) {
                d11 = (((d11 - 50.0d) / 50.0d) * (f10 - 50.0f)) + 50.0d;
            }
            double d12 = d11;
            dArr[0] = d12;
            int b10 = a.b(d12, dArr[1], dArr[2]);
            return Color.argb(Color.alpha(i10), Color.red(b10), Color.green(b10), Color.blue(b10));
        }
        return i10;
    }

    public void removeObserver(COUIDarkColorObserver cOUIDarkColorObserver) {
        if (cOUIDarkColorObserver == null) {
            return;
        }
        this.mObservers.remove(cOUIDarkColorObserver);
    }

    /* loaded from: classes.dex */
    public static abstract class COUIDarkColorObserver implements ICOUIDarkColorObserver {
        @Override // com.coui.appcompat.darkmode.COUIDarkModeHelper.ICOUIDarkColorObserver
        public void onBackgroundChange() {
        }

        @Override // com.coui.appcompat.darkmode.COUIDarkModeHelper.ICOUIDarkColorObserver
        public void onDialogBackgroundChange() {
        }

        @Override // com.coui.appcompat.darkmode.COUIDarkModeHelper.ICOUIDarkColorObserver
        public void onForegroundChange() {
        }
    }

    private void COUIDarkModeHelper() {
    }
}
