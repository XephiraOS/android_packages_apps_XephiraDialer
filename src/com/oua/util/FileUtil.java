package com.oua.util;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FileUtil {
    public static String asset2String(String str, Context context) {
        InputStream open = context.getAssets().open(str);
        try {
            String iOStreamUtil = IOStreamUtil.toString(open);
            if (open != null) {
                open.close();
            }
            return iOStreamUtil;
        } catch (Throwable th) {
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String getBaseName(String str) {
        return getFileName(str).replaceFirst("[.][^.]+$", "");
    }

    public static String getExt(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            return str.substring(lastIndexOf + 1);
        }
        return "";
    }

    public static String getFileName(String str) {
        return Paths.get(str, new String[0]).getFileName().toString();
    }

    public static String getParent(String str) {
        return Paths.get(str, new String[0]).getParent().toString();
    }

    public static InputStream openFile(String str) {
        return openFile(str, null);
    }

    public static InputStream openFileAsInputStream(String str, Context context) {
        File file = new File(str);
        if (context != null && !file.isAbsolute()) {
            return context.getAssets().open(str);
        }
        if (file.exists()) {
            return new FileInputStream(file);
        }
        throw new FileNotFoundException("File does not exists: " + file.getAbsolutePath());
    }

    public static List<String> readLinesAsList(String str, Context context, boolean z10) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileAsInputStream(str, context), StandardCharsets.UTF_8));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        bufferedReader.close();
        if (z10) {
            while (((String) arrayList.get(arrayList.size() - 1)).isEmpty()) {
                arrayList.remove(arrayList.size() - 1);
            }
        }
        return arrayList;
    }

    public static byte[] toByteArray(String str, Context context) {
        PositionInputStream openFile = openFile(str, context);
        try {
            int available = openFile.available();
            byte[] bArr = new byte[available];
            if (openFile.read(bArr) == available) {
                openFile.close();
                return bArr;
            }
            throw new IOException("The number of bytes read is not equal to file size");
        } catch (Throwable th) {
            if (openFile != null) {
                try {
                    openFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static ByteBuffer toByteBuffer(String str) {
        FileChannel channel = new FileInputStream(str).getChannel();
        try {
            ByteBuffer allocate = ByteBuffer.allocate((int) channel.size());
            channel.read(allocate);
            channel.close();
            return allocate;
        } catch (Throwable th) {
            if (channel != null) {
                try {
                    channel.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static ByteBuffer toDirectBuffer(String str) {
        return toDirectBuffer(str, null);
    }

    public static void toFile(String str, String str2) {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
        try {
            bufferedWriter.write(str2);
            bufferedWriter.close();
        } catch (Throwable th) {
            try {
                bufferedWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String toString(String str) {
        InputStream openFile = openFile(str);
        try {
            String iOStreamUtil = IOStreamUtil.toString(openFile);
            if (openFile != null) {
                openFile.close();
            }
            return iOStreamUtil;
        } catch (Throwable th) {
            if (openFile != null) {
                try {
                    openFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static PositionInputStream openFile(String str, Context context) {
        return new PositionInputStream(openFileAsInputStream(str, context));
    }

    public static ByteBuffer toDirectBuffer(String str, Context context) {
        PositionInputStream openFile = openFile(str, context);
        try {
            int available = openFile.available();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(available);
            allocateDirect.order(ByteOrder.nativeOrder());
            byte[] bArr = new byte[available];
            openFile.read(bArr);
            allocateDirect.put(bArr);
            openFile.close();
            return allocateDirect;
        } catch (Throwable th) {
            if (openFile != null) {
                try {
                    openFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String toString(String str, Context context) {
        PositionInputStream openFile = openFile(str, context);
        try {
            String iOStreamUtil = IOStreamUtil.toString(openFile);
            if (openFile != null) {
                openFile.close();
            }
            return iOStreamUtil;
        } catch (Throwable th) {
            if (openFile != null) {
                try {
                    openFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static List<String> readLinesAsList(String str, Context context) {
        return readLinesAsList(str, context, true);
    }
}
