package com.juphoon;

/* loaded from: classes3.dex */
public class FfmpegApp {
    static {
        System.loadLibrary("ffmpeg_jni");
        System.loadLibrary("ffmpegApp");
    }

    public static native void FfmpegCmd(String str);
}
