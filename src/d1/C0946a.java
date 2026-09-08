package d1;

import android.content.Context;
import com.android.contacts.framework.bttransmission.pbapclient.ClientControler;
import com.heytap.accessory.constant.FastPairConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: FileUtils.java */
/* renamed from: d1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0946a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, String> f29923a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static String f29924b = null;

    /* renamed from: c, reason: collision with root package name */
    public static C0947b f29925c = new C0947b();

    /* renamed from: d, reason: collision with root package name */
    public static FileOutputStream f29926d = null;

    /* renamed from: e, reason: collision with root package name */
    public static FileInputStream f29927e = null;

    static {
        d();
    }

    public static void a(String str) {
        if (e(str)) {
            f29923a.remove(str);
            h();
        } else {
            C0947b.a("properties file not found ,this should not happen!!", 3);
        }
    }

    public static void b(String str) {
        String str2 = str.replace(":", "-") + ".vcf";
        Context context = P7.a.f2962b;
        if (context != null && new HashSet(Arrays.asList(context.fileList())).contains(str2)) {
            if (context.deleteFile(str2)) {
                C0947b.a("deleteVCF: delete file " + str2 + "success", 1);
                return;
            }
            C0947b.a("deleteVCF: error happened when delete file " + str2, 3);
        }
    }

    public static int c(byte b10) {
        if (b10 < 0) {
            return b10 + FastPairConstants.GO_INTENT_MIN;
        }
        return b10;
    }

    public static void d() {
        StringBuilder sb;
        Context context = P7.a.f2962b;
        if (context != null) {
            try {
                if (!new HashSet(Arrays.asList(context.fileList())).contains("deviceslist.txt")) {
                    try {
                        FileOutputStream openFileOutput = context.openFileOutput("deviceslist.txt", 0);
                        f29926d = openFileOutput;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                                return;
                            } catch (IOException e10) {
                                H7.b.c("VCFHelper", "e = " + e10);
                                return;
                            }
                        }
                        return;
                    } catch (FileNotFoundException e11) {
                        H7.b.c("VCFHelper", "Exception e: " + e11);
                        FileOutputStream fileOutputStream = f29926d;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e12) {
                                H7.b.c("VCFHelper", "e = " + e12);
                            }
                        }
                    }
                }
                try {
                    f29927e = context.openFileInput("deviceslist.txt");
                } catch (FileNotFoundException e13) {
                    H7.b.c("VCFHelper", "Exception e: " + e13);
                }
                InputStreamReader inputStreamReader = new InputStreamReader(f29927e);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                String[] split = readLine.split("#");
                                f29923a.put(split[0], split[1]);
                            } else {
                                try {
                                    bufferedReader.close();
                                    inputStreamReader.close();
                                    f29927e.close();
                                    return;
                                } catch (IOException e14) {
                                    e = e14;
                                    sb = new StringBuilder();
                                    sb.append("Exception e: ");
                                    sb.append(e);
                                    H7.b.c("VCFHelper", sb.toString());
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                                inputStreamReader.close();
                                f29927e.close();
                            } catch (IOException e15) {
                                H7.b.c("VCFHelper", "Exception e: " + e15);
                            }
                            throw th;
                        }
                    } catch (IOException e16) {
                        H7.b.c("VCFHelper", "Exception e: " + e16);
                        try {
                            bufferedReader.close();
                            inputStreamReader.close();
                            f29927e.close();
                            return;
                        } catch (IOException e17) {
                            e = e17;
                            sb = new StringBuilder();
                            sb.append("Exception e: ");
                            sb.append(e);
                            H7.b.c("VCFHelper", sb.toString());
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                FileOutputStream fileOutputStream2 = f29926d;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e18) {
                        H7.b.c("VCFHelper", "e = " + e18);
                    }
                }
                throw th2;
            }
        }
    }

    public static boolean e(String str) {
        return f29923a.containsKey(str);
    }

    public static synchronized void f() {
        synchronized (C0946a.class) {
            String address = ClientControler.y().v().getAddress();
            if (address == null) {
                return;
            }
            a(address);
            b(address);
        }
    }

    public static void g(String str) {
        f29924b = str;
    }

    public static void h() {
        Context context = P7.a.f2962b;
        if (context == null) {
            return;
        }
        if (new HashSet(Arrays.asList(context.fileList())).contains("deviceslist.txt")) {
            try {
                f29926d = context.openFileOutput("deviceslist.txt", 0);
            } catch (FileNotFoundException e10) {
                H7.b.c("VCFHelper", "Exception e: " + e10);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(f29926d));
            for (Map.Entry<String, String> entry : f29923a.entrySet()) {
                try {
                    bufferedWriter.append((CharSequence) (entry.getKey() + "#" + entry.getValue() + System.getProperty("line.separator")));
                } catch (IOException e11) {
                    H7.b.c("VCFHelper", "Exception e: " + e11);
                }
            }
            return;
        }
        throw new FileNotFoundException("properties file not found");
    }

    public static void i(String str, String str2) {
        StringBuilder sb;
        Context context = P7.a.f2962b;
        if (context == null) {
            return;
        }
        g(str2);
        String str3 = str.replace(":", "-") + ".vcf";
        try {
            f29926d = context.openFileOutput(str3, 0);
        } catch (FileNotFoundException e10) {
            H7.b.c("VCFHelper", "Exception e: " + e10);
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(f29926d);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        C0947b.a("writerVCF:create new file name" + str3, 1);
        try {
            try {
                bufferedWriter.write(str2);
                try {
                    bufferedWriter.close();
                    outputStreamWriter.close();
                    f29926d.close();
                } catch (IOException e11) {
                    e = e11;
                    sb = new StringBuilder();
                    sb.append("Exception e: ");
                    sb.append(e);
                    H7.b.c("VCFHelper", sb.toString());
                }
            } catch (IOException e12) {
                H7.b.c("VCFHelper", "Exception e: " + e12);
                try {
                    bufferedWriter.close();
                    outputStreamWriter.close();
                    f29926d.close();
                } catch (IOException e13) {
                    e = e13;
                    sb = new StringBuilder();
                    sb.append("Exception e: ");
                    sb.append(e);
                    H7.b.c("VCFHelper", sb.toString());
                }
            }
        } catch (Throwable th) {
            try {
                bufferedWriter.close();
                outputStreamWriter.close();
                f29926d.close();
            } catch (IOException e14) {
                H7.b.c("VCFHelper", "Exception e: " + e14);
            }
            throw th;
        }
    }
}
