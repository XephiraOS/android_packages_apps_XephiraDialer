package org.opencv.android;

/* loaded from: classes4.dex */
public interface LoaderCallbackInterface {
    public static final int INCOMPATIBLE_MANAGER_VERSION = 4;
    public static final int INIT_FAILED = 255;
    public static final int INSTALL_CANCELED = 3;
    public static final int MARKET_ERROR = 2;
    public static final int SUCCESS = 0;

    void onManagerConnected(int i10);

    void onPackageInstall(int i10, InstallCallbackInterface installCallbackInterface);
}
