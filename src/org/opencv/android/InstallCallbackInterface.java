package org.opencv.android;

/* loaded from: classes4.dex */
public interface InstallCallbackInterface {
    public static final int INSTALLATION_PROGRESS = 1;
    public static final int NEW_INSTALLATION = 0;

    void cancel();

    String getPackageName();

    void install();

    void wait_install();
}
