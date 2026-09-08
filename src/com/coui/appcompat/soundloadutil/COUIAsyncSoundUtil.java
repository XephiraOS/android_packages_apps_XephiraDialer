package com.coui.appcompat.soundloadutil;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.provider.Settings;
import android.util.Log;
import android.util.SparseIntArray;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.soundloadutil.COUIAsyncSoundUtil;
import com.coui.appcompat.uiutil.COUIWorkHandler;

/* loaded from: classes.dex */
public class COUIAsyncSoundUtil {
    private static final boolean COUI_DEBUG;
    public static final int FLAG_BYPASS_MUTE = 128;
    private static final String TAG = "COUIAsyncSoundUtil";
    private static COUIAsyncSoundUtil sInstance;
    private final Context mContext;
    private volatile SoundPool mSoundPool = null;
    private final SparseIntArray mSoundMap = new SparseIntArray();

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        COUI_DEBUG = z10;
    }

    private COUIAsyncSoundUtil(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private static void ensureSoundPoolInstance() {
        if (sInstance.mSoundPool == null) {
            if (COUI_DEBUG) {
                Log.d(TAG, "init sound pool");
            }
            sInstance.initSoundPool();
        }
    }

    private void initSoundPool() {
        boolean z10 = COUI_DEBUG;
        if (z10) {
            Log.d(TAG, "init sound pool begin");
        }
        SoundPool.Builder builder = new SoundPool.Builder();
        AudioAttributes build = new AudioAttributes.Builder().setFlags(128).setLegacyStreamType(1).build();
        builder.setMaxStreams(10);
        builder.setAudioAttributes(build);
        this.mSoundPool = builder.build();
        if (z10) {
            Log.d(TAG, "init sound pool end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$register$0(int[] iArr) {
        ensureSoundPoolInstance();
        if (COUI_DEBUG) {
            Log.d(TAG, "sound pool initialized, load sound file");
        }
        for (int i10 : iArr) {
            COUIAsyncSoundUtil cOUIAsyncSoundUtil = sInstance;
            cOUIAsyncSoundUtil.loadSoundFile(cOUIAsyncSoundUtil.mContext, i10);
        }
    }

    private void loadSoundFile(Context context, int i10) {
        boolean z10 = COUI_DEBUG;
        if (z10) {
            Log.d(TAG, "load sound file id = " + i10);
        }
        if (this.mSoundMap.indexOfKey(i10) >= 0 && this.mSoundMap.get(i10) != 0) {
            if (z10) {
                Log.d(TAG, i10 + " already loaded");
                return;
            }
            return;
        }
        this.mSoundMap.put(i10, this.mSoundPool.load(context, i10, 0));
    }

    public static void play(Context context, int i10, float f10, float f11, int i11, int i12, float f12) {
        if (sInstance.mSoundPool != null && querySoundEffectsEnabled(context)) {
            sInstance.playSound(i10, f10, f11, i11, i12, f12);
        }
    }

    private void playSound(int i10, float f10, float f11, int i11, int i12, float f12) {
        int i13 = this.mSoundMap.get(i10);
        if (COUI_DEBUG) {
            Log.d(TAG, "soundId = " + i13);
        }
        if (i13 != 0) {
            this.mSoundPool.play(i13, f10, f11, i11, i12, f12);
        }
    }

    private static boolean querySoundEffectsEnabled(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "sound_effects_enabled", 0) == 0) {
            return false;
        }
        return true;
    }

    public static void register(Context context, final int... iArr) {
        boolean z10 = COUI_DEBUG;
        if (z10) {
            Log.d(TAG, "register, sound file num: " + iArr.length);
        }
        if (sInstance == null) {
            if (z10) {
                Log.d(TAG, "init util");
            }
            sInstance = new COUIAsyncSoundUtil(context);
        }
        COUIWorkHandler.getInstance(1).start(new Runnable() { // from class: z3.a
            @Override // java.lang.Runnable
            public final void run() {
                COUIAsyncSoundUtil.lambda$register$0(iArr);
            }
        });
    }
}
