package com.android.incallui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class InCallUIAide {
    private static final String LOG_TAG = "InCallUIAide";
    public static final int MSG_FONT_CHANGED = 101;
    private static InCallUIAide sInCallUIAide = new InCallUIAide();
    private Context mContext;
    private final Set<FontChangeListener> mFontChangeListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private Typeface mRegularType = null;
    private Typeface mMediumType = null;
    private Typeface mNumberFontRegularType = null;
    private int mFlipFont = -1;
    private boolean mFontLoading = false;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.android.incallui.InCallUIAide.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 101) {
                InCallUIAide.this.notifyFontChanged();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface FontChangeListener {
        void onFontChanged(Typeface typeface);
    }

    public static InCallUIAide getInstance() {
        return sInCallUIAide;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFont() {
        try {
            this.mMediumType = Typeface.createFromFile("system/fonts/ColorFont-Medium.ttf");
        } catch (Exception e10) {
            this.mMediumType = Typeface.DEFAULT;
            if (Log.sDebug) {
                Log.d(LOG_TAG, "sMediumType exception : " + e10);
            }
        }
        try {
            this.mRegularType = Typeface.createFromFile("system/fonts/ColorFont-Regular.ttf");
        } catch (Exception e11) {
            this.mRegularType = Typeface.DEFAULT;
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Regular exception : " + e11);
            }
        }
        this.mNumberFontRegularType = this.mContext.getResources().getFont(R.font.oplus_number_font_regular);
    }

    public void addFontChangeListener(FontChangeListener fontChangeListener) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "addListener = " + fontChangeListener);
        }
        this.mFontChangeListeners.add(fontChangeListener);
    }

    public void checkFontChange() {
        if (this.mFontLoading) {
            return;
        }
        this.mFontLoading = true;
        C2.b.a().execute(new Runnable() { // from class: com.android.incallui.InCallUIAide.2
            @Override // java.lang.Runnable
            public void run() {
                InCallUIAide.this.mFontLoading = true;
                Configuration configuration = InCallUIAide.this.mContext.getResources().getConfiguration();
                if (configuration != null) {
                    int b10 = A2.d.b(configuration);
                    if (Log.sDebug) {
                        Log.d(InCallUIAide.LOG_TAG, "checkFontChange, newConfig newFlipFont = " + b10 + " sFlipFont = " + InCallUIAide.this.mFlipFont);
                    }
                    if (b10 != InCallUIAide.this.mFlipFont) {
                        InCallUIAide.this.loadFont();
                        InCallUIAide.this.mFlipFont = b10;
                        if (InCallUIAide.this.mHandler != null) {
                            InCallUIAide.this.mHandler.sendEmptyMessage(101);
                        }
                    }
                }
                InCallUIAide.this.mFontLoading = false;
            }
        });
    }

    public void clearFontChangeListener() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "clearFontChangeListener ");
        }
        this.mFontChangeListeners.clear();
    }

    public Typeface getMediumType() {
        return this.mMediumType;
    }

    public Typeface getNumberFontRegularType() {
        return this.mNumberFontRegularType;
    }

    public Typeface getRegularType() {
        return this.mRegularType;
    }

    public void notifyFontChanged() {
        Iterator<FontChangeListener> it = this.mFontChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onFontChanged(null);
        }
    }

    public void removeFontChangeListener(FontChangeListener fontChangeListener) {
        if (fontChangeListener != null && this.mFontChangeListeners.contains(fontChangeListener)) {
            this.mFontChangeListeners.remove(fontChangeListener);
        }
    }

    public void setUp(Context context) {
        this.mContext = context;
    }
}
