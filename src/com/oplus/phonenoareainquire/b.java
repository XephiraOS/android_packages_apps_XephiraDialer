package com.oplus.phonenoareainquire;

import android.util.Log;
import com.oplus.backup.sdk.common.utils.FileUtils;
import java.io.File;

/* compiled from: FileUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static File a(String str) {
        File file = new File(str);
        b(file);
        file.createNewFile();
        return file;
    }

    public static void b(File file) {
        if (file == null) {
            return;
        }
        try {
            c(file);
        } catch (StackOverflowError e10) {
            Log.e(FileUtils.TAG, "StackOverflowError = " + e10);
        }
    }

    public static void c(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.delete();
                return;
            }
            for (File file2 : listFiles) {
                c(file2);
            }
            return;
        }
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        android.util.Log.e(com.oplus.backup.sdk.common.utils.FileUtils.TAG, "e = " + r3);
     */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.b.d():java.lang.String");
    }
}
