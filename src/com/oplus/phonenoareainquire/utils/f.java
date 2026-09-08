package com.oplus.phonenoareainquire.utils;

import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.i;

/* compiled from: ProviderUtil.kt */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f28903a = new f();

    public static final boolean a(String originFileName, String destFilePath) {
        i.f(originFileName, "originFileName");
        i.f(destFilePath, "destFilePath");
        try {
            InputStream resourceAsStream = f.class.getResourceAsStream("/assets/" + originFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(destFilePath);
            if (resourceAsStream != null) {
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = resourceAsStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        Log.d("ProviderUtil", "successfully copy file " + originFileName + " to data dir");
                        kotlin.io.a.a(resourceAsStream, null);
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        kotlin.io.a.a(fileOutputStream, th);
                        throw th2;
                    }
                }
            }
            kotlin.io.a.a(fileOutputStream, null);
            return true;
        } catch (IOException e10) {
            Log.e("ProviderUtil", "error when copy file from assets to data dir " + e10);
            return false;
        }
    }
}
