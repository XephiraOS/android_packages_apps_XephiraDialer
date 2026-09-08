package org.opencv.android;

import android.util.Log;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.StringTokenizer;
import org.opencv.core.Core;

/* loaded from: classes4.dex */
class StaticHelper {
    private static final String TAG = "OpenCV/StaticHelper";

    private static native String getLibraryList();

    public static boolean initOpenCV(boolean z10) {
        String str;
        if (z10) {
            loadLibrary("cudart");
            loadLibrary("nppc");
            loadLibrary("nppi");
            loadLibrary("npps");
            loadLibrary("cufft");
            loadLibrary("cublas");
        }
        Log.d(TAG, "Trying to get library list");
        try {
            System.loadLibrary("opencv_info");
            str = getLibraryList();
        } catch (UnsatisfiedLinkError unused) {
            Log.e(TAG, "OpenCV error: Cannot load info library for OpenCV");
            str = "";
        }
        Log.d(TAG, "Library list: \"" + str + "\"");
        Log.d(TAG, "First attempt to load libs");
        if (initOpenCVLibs(str)) {
            Log.d(TAG, "First attempt to load libs is OK");
            for (String str2 : Core.getBuildInformation().split(System.getProperty("line.separator"))) {
                Log.i(TAG, str2);
            }
            return true;
        }
        Log.d(TAG, "First attempt to load libs fails");
        return false;
    }

    private static boolean initOpenCVLibs(String str) {
        Log.d(TAG, "Trying to init OpenCV libs");
        if (str != null && str.length() != 0) {
            Log.d(TAG, "Trying to load libs by dependency list");
            StringTokenizer stringTokenizer = new StringTokenizer(str, Constants.DataMigration.SPLIT_TAG);
            boolean z10 = true;
            while (stringTokenizer.hasMoreTokens()) {
                z10 &= loadLibrary(stringTokenizer.nextToken());
            }
            return z10;
        }
        return loadLibrary("opencv_java4");
    }

    private static boolean loadLibrary(String str) {
        Log.d(TAG, "Trying to load library " + str);
        try {
            System.loadLibrary(str);
            Log.d(TAG, "Library " + str + " loaded");
            return true;
        } catch (UnsatisfiedLinkError e10) {
            Log.d(TAG, "Cannot load library \"" + str + "\"");
            e10.printStackTrace();
            return false;
        }
    }
}
