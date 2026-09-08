package com.coui.appcompat.soundloadutil;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.provider.Settings;
import java.util.HashMap;

/* loaded from: classes.dex */
public class COUISoundLoadUtil {
    public static final int FLAG_BYPASS_MUTE = 128;
    private static COUISoundLoadUtil sInstance;
    private HashMap<Integer, Integer> mSoundMap = new HashMap<>();
    private SoundPool mSoundPool;

    private COUISoundLoadUtil() {
        initSoundPool();
    }

    public static synchronized COUISoundLoadUtil getInstance() {
        COUISoundLoadUtil cOUISoundLoadUtil;
        synchronized (COUISoundLoadUtil.class) {
            try {
                if (sInstance == null) {
                    sInstance = new COUISoundLoadUtil();
                }
                cOUISoundLoadUtil = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cOUISoundLoadUtil;
    }

    private void initSoundPool() {
        SoundPool.Builder builder = new SoundPool.Builder();
        AudioAttributes build = new AudioAttributes.Builder().setFlags(128).setLegacyStreamType(1).build();
        builder.setMaxStreams(10);
        builder.setAudioAttributes(build);
        this.mSoundPool = builder.build();
    }

    private boolean querySoundEffectsEnabled(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "sound_effects_enabled", 0) == 0) {
            return false;
        }
        return true;
    }

    public int loadFile(String str, int i10) {
        return this.mSoundPool.load(str, i10);
    }

    public int loadSoundFile(Context context, int i10) {
        if (this.mSoundMap.containsKey(Integer.valueOf(i10))) {
            return this.mSoundMap.get(Integer.valueOf(i10)).intValue();
        }
        int load = this.mSoundPool.load(context, i10, 0);
        this.mSoundMap.put(Integer.valueOf(i10), Integer.valueOf(load));
        return load;
    }

    public void play(Context context, int i10, float f10, float f11, int i11, int i12, float f12) {
        if (querySoundEffectsEnabled(context)) {
            this.mSoundPool.play(i10, f10, f11, i11, i12, f12);
        }
    }

    public void setCompleteListener(SoundPool.OnLoadCompleteListener onLoadCompleteListener) {
        this.mSoundPool.setOnLoadCompleteListener(onLoadCompleteListener);
    }
}
