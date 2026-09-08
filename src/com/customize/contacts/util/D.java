package com.customize.contacts.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.oplus.backup.sdk.common.utils.FileUtils;
import com.oplus.dialer.R;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: FileUtils.java */
/* loaded from: classes3.dex */
public class D {
    public static int a(Context context, String str) {
        File file = new File(f(context, str));
        if (!file.exists()) {
            return 1;
        }
        if (!file.canRead()) {
            return 2;
        }
        if (file.length() == 0) {
            return 3;
        }
        return 888;
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    byte[] bArr = new byte[102400];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read > 0) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException | IllegalStateException e10) {
            H7.b.c(FileUtils.TAG, "Failed to copy file: because: " + e10);
        }
    }

    public static boolean c(File file) {
        File[] listFiles;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                c(file2);
            }
        }
        return e(file);
    }

    public static boolean d(String str) {
        return c(new File(str));
    }

    public static boolean e(File file) {
        if (file.exists()) {
            File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
            if (!file.renameTo(file2)) {
                H7.b.i(FileUtils.TAG, "deleteFile renameTo fail!");
            }
            return file2.delete();
        }
        return true;
    }

    public static String f(Context context, String str) {
        String string = context.getString(R.string.config_prefix_file_name);
        String string2 = context.getString(R.string.config_other_prefix_file_name);
        if (str.startsWith(string)) {
            return str.substring(string.length());
        }
        if (str.startsWith(string2)) {
            return str.substring(string2.length());
        }
        return str;
    }

    public static String g(Uri uri, String str) {
        if (uri.getPathSegments().size() >= 3) {
            StringBuilder sb = new StringBuilder(str);
            String lastPathSegment = uri.getLastPathSegment();
            sb.append(uri.getPathSegments().get(1));
            sb.append(File.separator);
            sb.append(lastPathSegment);
            return sb.toString();
        }
        return "";
    }

    public static int h(Context context, String str) {
        int lastIndexOf;
        if (H7.a.b()) {
            H7.b.b(FileUtils.TAG, "getFileType(), filename = " + str);
        }
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(".")) < 0) {
            return -1;
        }
        String lowerCase = str.substring(lastIndexOf).toLowerCase();
        if (lowerCase.equals(context.getString(R.string.config_csv_file_extension))) {
            return 0;
        }
        if (!lowerCase.equals(context.getString(R.string.config_vcard_file_extension))) {
            return -1;
        }
        return 1;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && !file.isDirectory() && !file.delete()) {
            H7.b.i(FileUtils.TAG, "file delete failed");
        }
        return file.mkdirs();
    }
}
