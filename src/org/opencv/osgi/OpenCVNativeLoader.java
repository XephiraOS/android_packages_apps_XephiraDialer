package org.opencv.osgi;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public class OpenCVNativeLoader implements OpenCVInterface {
    public void init() {
        System.loadLibrary("opencv_java4");
        Logger.getLogger("org.opencv.osgi").log(Level.INFO, "Successfully loaded OpenCV native library.");
    }
}
