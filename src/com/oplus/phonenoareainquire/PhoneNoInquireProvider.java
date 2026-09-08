package com.oplus.phonenoareainquire;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import b8.C0530a;
import c8.C0568b;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.OplusPhoneUtils;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import com.oplus.media.OplusRecorder;
import com.oplus.os.OplusBuild;
import com.oplus.phonenoareainquire.service.OplusLocaleChangeJobIntentService;
import com.oplus.phonenoareainquire.utils.LogUtil;
import com.oplus.phonenoareainquire.utils.SelfHealUtil;
import com.oplus.phonenoareainquire.utils.e;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class PhoneNoInquireProvider extends ContentProvider {

    /* renamed from: A, reason: collision with root package name */
    public static String f28791A;

    /* renamed from: B, reason: collision with root package name */
    public static String f28792B;

    /* renamed from: C, reason: collision with root package name */
    public static String f28793C;

    /* renamed from: D, reason: collision with root package name */
    public static String f28794D;

    /* renamed from: E, reason: collision with root package name */
    public static String f28795E;

    /* renamed from: F, reason: collision with root package name */
    public static String f28796F;

    /* renamed from: G, reason: collision with root package name */
    public static String f28797G;

    /* renamed from: H, reason: collision with root package name */
    public static final UriMatcher f28798H;

    /* renamed from: I, reason: collision with root package name */
    public static final String f28799I;

    /* renamed from: J, reason: collision with root package name */
    public static final Pattern f28800J;

    /* renamed from: K, reason: collision with root package name */
    public static WeakReference<PhoneNoInquireProvider> f28801K;

    /* renamed from: L, reason: collision with root package name */
    public static boolean f28802L;

    /* renamed from: r, reason: collision with root package name */
    public static final Uri f28803r;

    /* renamed from: x, reason: collision with root package name */
    public static final Uri f28804x;

    /* renamed from: y, reason: collision with root package name */
    public static final String[] f28805y;

    /* renamed from: z, reason: collision with root package name */
    public static String f28806z;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, Integer> f28807a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f28808b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, Integer> f28809c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f28810d;

    /* renamed from: e, reason: collision with root package name */
    public volatile CountDownLatch f28811e;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<String> f28815i;

    /* renamed from: j, reason: collision with root package name */
    public d f28816j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<String> f28817k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<String> f28818l;

    /* renamed from: m, reason: collision with root package name */
    public PhoneNumberUtil f28819m;

    /* renamed from: n, reason: collision with root package name */
    public W7.a f28820n;

    /* renamed from: o, reason: collision with root package name */
    public Locale f28821o;

    /* renamed from: p, reason: collision with root package name */
    public Handler f28822p;

    /* renamed from: f, reason: collision with root package name */
    public e f28812f = null;

    /* renamed from: g, reason: collision with root package name */
    public SQLiteDatabase f28813g = null;

    /* renamed from: h, reason: collision with root package name */
    public String f28814h = null;

    /* renamed from: q, reason: collision with root package name */
    public boolean f28823q = false;

    /* loaded from: classes3.dex */
    public class a extends HandlerThread {
        public a(String str, int i10) {
            super(str, i10);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.d("PhoneNoProvider", "ContactsProviderWorker is running");
            super.run();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataInputStream f28825a;

        public b(DataInputStream dataInputStream) {
            this.f28825a = dataInputStream;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            StringBuilder sb;
            InputStream inputStream;
            boolean z10;
            try {
                try {
                    String a10 = com.oplus.phonenoareainquire.utils.c.a();
                    if (com.oplus.phonenoareainquire.utils.c.c(a10)) {
                        a10 = "US";
                    }
                    String str = a10;
                    int available = this.f28825a.available();
                    byte[] bArr = new byte[2000];
                    byte[] bArr2 = new byte[OplusRecorder.NWAV_SAMPLERATE];
                    this.f28825a.skip(available - 12002);
                    this.f28825a.read(new byte[2]);
                    this.f28825a.read(bArr);
                    this.f28825a.read(bArr2);
                    this.f28825a.read(new byte[2000]);
                    try {
                        inputStream = PhoneNumberAreaApplication.b("Multi_Language_Table.txt", PhoneNoInquireProvider.f28795E);
                    } catch (Exception e10) {
                        try {
                            inputStream = PhoneNumberAreaApplication.b("Multi_Language_Table.txt", PhoneNoInquireProvider.f28795E);
                        } catch (Exception e11) {
                            Log.e("PhoneNoProvider", "e = " + e11);
                            inputStream = null;
                        }
                        Log.e("PhoneNoProvider", "e = " + e10);
                    }
                    HashMap hashMap = new HashMap();
                    int i10 = 0;
                    if (inputStream != null) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        boolean z11 = false;
                        int i11 = 1;
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null || readLine.trim().length() <= 0) {
                                    break;
                                }
                                String trim = readLine.trim();
                                if (trim.length() <= 0) {
                                    break;
                                }
                                if (!z11) {
                                    String[] split = trim.split("\t");
                                    for (int i12 = 1; i12 < split.length; i12++) {
                                        if (split[i12].equals(str)) {
                                            i11 = i12;
                                        }
                                    }
                                    z11 = true;
                                } else {
                                    String[] split2 = trim.split("\t");
                                    hashMap.put(split2[0], split2[i11]);
                                }
                            } catch (Exception e12) {
                                Log.e("PhoneNoProvider", "e = " + e12);
                                z10 = true;
                            }
                        }
                        z10 = false;
                        inputStreamReader.close();
                        bufferedReader.close();
                        if (z10 || hashMap.size() <= 10) {
                            SelfHealUtil.e(PhoneNoInquireProvider.this.getContext());
                        }
                    }
                    while (i10 < 400) {
                        String trim2 = new String(bArr, i10 * 5, 5).trim();
                        String trim3 = new String(bArr2, i10 * 20, 20, "gbk").trim();
                        if (trim2.equals("") && trim3.equals("")) {
                            break;
                        }
                        i10++;
                        String valueOf = String.valueOf(i10);
                        d c10 = d.c();
                        if (hashMap.get(valueOf) != null) {
                            trim3 = (String) hashMap.get(valueOf);
                        }
                        c10.d(valueOf, trim3, trim2);
                    }
                } catch (Exception e13) {
                    Log.e("PhoneNoProvider", "" + e13);
                    try {
                        DataInputStream dataInputStream = this.f28825a;
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                    } catch (Exception e14) {
                        e = e14;
                        sb = new StringBuilder();
                        sb.append("");
                        sb.append(e);
                        Log.e("PhoneNoProvider", sb.toString());
                        SelfHealUtil.d();
                        return null;
                    }
                }
                try {
                    DataInputStream dataInputStream2 = this.f28825a;
                    if (dataInputStream2 != null) {
                        dataInputStream2.close();
                    }
                } catch (Exception e15) {
                    e = e15;
                    sb = new StringBuilder();
                    sb.append("");
                    sb.append(e);
                    Log.e("PhoneNoProvider", sb.toString());
                    SelfHealUtil.d();
                    return null;
                }
                SelfHealUtil.d();
                return null;
            } catch (Throwable th) {
                try {
                    DataInputStream dataInputStream3 = this.f28825a;
                    if (dataInputStream3 != null) {
                        dataInputStream3.close();
                    }
                } catch (Exception e16) {
                    Log.e("PhoneNoProvider", "" + e16);
                }
                SelfHealUtil.d();
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PhoneNoInquireProvider.this.J(message.what, message.obj);
        }
    }

    static {
        Uri parse = Uri.parse("content://com.oplus.dialer.inquirenoarea");
        f28803r = parse;
        f28804x = Uri.parse(parse + "/areano_and_citynames");
        f28805y = new String[]{"17951", "12593", "125831", "125832", "125833", "+86125831", "+86125832", "+86125833", "0086125831", "0086125832", "0086125833", "17910", "17911", "10193", "10131", "96531", "17900", "17901", "17909", "11808"};
        UriMatcher uriMatcher = new UriMatcher(-1);
        f28798H = uriMatcher;
        f28799I = null;
        f28800J = Pattern.compile("^(0{2})|^[+＋]+");
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", "phoneno/*", 0);
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", "areano_and_citynames", 1);
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", "areano_and_citynames/#", 2);
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", BRPluginConfig.VERSION, 5);
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", "international_phoneno/*", 6);
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", "province_and_city/", 7);
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", "oppo_location_groups/", 11);
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", "location_groups/", 11);
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", "phone_numbers", 8);
        uriMatcher.addURI("com.oplus.dialer.inquirenoarea", "country_list", 9);
    }

    public static boolean E() {
        if (OplusBuild.getOplusOSVERSION() <= 22) {
            return "TW".equals(C0530a.a("ro.vendor.oplus.regionmark", "CN"));
        }
        return "TW".equals(C0568b.a());
    }

    public static void O(String str) {
        f28806z = str;
    }

    public static void Q(PhoneNoInquireProvider phoneNoInquireProvider) {
        f28801K = new WeakReference<>(phoneNoInquireProvider);
    }

    public static PhoneNoInquireProvider h() {
        WeakReference<PhoneNoInquireProvider> weakReference = f28801K;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static ArrayList<String> i() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(FastPairConstants.STATUS_CONNECT_RESULT_FAIL);
        arrayList.add(FastPairConstants.STATUS_CONNECT_RESULT_CANCEL);
        return arrayList;
    }

    public static String r() {
        return f28806z;
    }

    public static ArrayList<String> x(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("+86");
        arrayList.add("0086");
        return arrayList;
    }

    public static String y(String str, Locale locale) {
        if (str == null || str.equals("ZZ") || str.equals(FastPairConstants.STATUS_CONNECT_RESULT_FAIL)) {
            return "";
        }
        return new Locale("", str).getDisplayCountry(locale);
    }

    public final String A(String str) {
        int length = str.length();
        if ((!str.startsWith("2") && !str.startsWith("3") && !str.startsWith("5") && !str.startsWith("7") && !str.startsWith("8")) || length < 3 || length > 5) {
            if (str.startsWith("6") && length >= 3 && length <= 6) {
                return OplusPhoneUtils.DeviceState.LOCK_DEVICE;
            }
            return null;
        }
        return OplusPhoneUtils.DeviceState.LOCK_DEVICE;
    }

    public final String B(String str, String str2) {
        int n10 = n(str, str2);
        if (n10 == 852) {
            return OplusPhoneUtils.DeviceState.INVALID_STATUS;
        }
        if (n10 == 853) {
            return "-2";
        }
        if (n10 == 886) {
            return "-3";
        }
        return "-4";
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0021: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:34), block:B:49:0x0021 */
    public void C(Context context) {
        DataInputStream dataInputStream;
        NumberFormatException e10;
        DataInputStream dataInputStream2;
        int available;
        DataInputStream dataInputStream3 = null;
        DataInputStream dataInputStream4 = null;
        try {
            try {
                try {
                    dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(f28793C)));
                    try {
                        HashMap<String, Integer> hashMap = this.f28809c;
                        if (hashMap == null) {
                            this.f28809c = new HashMap<>();
                        } else {
                            hashMap.clear();
                        }
                        ArrayList<String> arrayList = this.f28815i;
                        if (arrayList == null) {
                            this.f28815i = new ArrayList<>();
                        } else {
                            arrayList.clear();
                        }
                        while (true) {
                            available = dataInputStream.available();
                            if (available <= 0) {
                                break;
                            }
                            String readUTF = dataInputStream.readUTF();
                            String readUTF2 = dataInputStream.readUTF();
                            this.f28815i.add(readUTF);
                            this.f28809c.put(readUTF, Integer.valueOf(readUTF2));
                        }
                        dataInputStream.close();
                        try {
                            dataInputStream.close();
                            dataInputStream3 = available;
                        } catch (IOException e11) {
                            e = e11;
                            e.printStackTrace();
                            SelfHealUtil.d();
                        }
                    } catch (NumberFormatException e12) {
                        e10 = e12;
                        Log.e("PhoneNoProvider", "Exception: " + e10);
                        SelfHealUtil.e(getContext());
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e13) {
                                e = e13;
                                e.printStackTrace();
                                SelfHealUtil.d();
                            }
                        }
                        SelfHealUtil.d();
                    } catch (Exception e14) {
                        e = e14;
                        dataInputStream4 = dataInputStream;
                        Log.e("PhoneNoProvider", "Exception when init extend number data : " + e);
                        dataInputStream3 = dataInputStream4;
                        if (dataInputStream4 != null) {
                            try {
                                dataInputStream4.close();
                                dataInputStream3 = dataInputStream4;
                            } catch (IOException e15) {
                                e = e15;
                                e.printStackTrace();
                                SelfHealUtil.d();
                            }
                        }
                        SelfHealUtil.d();
                    }
                } catch (Throwable th) {
                    th = th;
                    dataInputStream3 = dataInputStream2;
                    if (dataInputStream3 != null) {
                        try {
                            dataInputStream3.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                    SelfHealUtil.d();
                    throw th;
                }
            } catch (NumberFormatException e17) {
                dataInputStream = null;
                e10 = e17;
            } catch (Exception e18) {
                e = e18;
            }
            SelfHealUtil.d();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean D(String str) {
        if (!Pattern.compile("-?[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0408 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0320 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0292 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0272 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0261 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x041a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0435 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[Catch: all -> 0x0276, SYNTHETIC, TRY_LEAVE, TryCatch #37 {all -> 0x0276, blocks: (B:170:0x0272, B:57:0x041a, B:64:0x0432, B:63:0x0420, B:120:0x03d9, B:124:0x03df, B:174:0x027a), top: B:169:0x0272, inners: #2, #6, #33 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02fd A[EDGE_INSN: B:78:0x02fd->B:79:0x02fd BREAK  A[LOOP:3: B:45:0x02e7->B:51:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0341 A[Catch: all -> 0x03a9, Exception -> 0x03af, TRY_ENTER, TryCatch #50 {Exception -> 0x03af, all -> 0x03a9, blocks: (B:85:0x0311, B:89:0x0344, B:95:0x035d, B:96:0x0370, B:88:0x0341), top: B:84:0x0311 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0353 A[Catch: all -> 0x0338, Exception -> 0x033d, TRY_ENTER, TRY_LEAVE, TryCatch #47 {Exception -> 0x033d, all -> 0x0338, blocks: (B:138:0x0320, B:92:0x0353, B:98:0x0376), top: B:137:0x0320 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0376 A[Catch: all -> 0x0338, Exception -> 0x033d, TRY_ENTER, TRY_LEAVE, TryCatch #47 {Exception -> 0x033d, all -> 0x0338, blocks: (B:138:0x0320, B:92:0x0353, B:98:0x0376), top: B:137:0x0320 }] */
    /* JADX WARN: Type inference failed for: r14v22, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v30, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v36 */
    /* JADX WARN: Type inference failed for: r14v37, types: [java.lang.Object, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v38 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r21v0, types: [android.content.ContentProvider, com.oplus.phonenoareainquire.PhoneNoInquireProvider] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F() {
        /*
            Method dump skipped, instructions count: 1102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.PhoneNoInquireProvider.F():void");
    }

    public final String G(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 2) {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            if (length > 7) {
                sb.append(str.substring(0, 3));
                sb.append("****");
                sb.append(str.substring(length - 4));
                return sb.toString();
            }
            if (length > 2) {
                sb.append(str.substring(0, 1));
                sb.append("****");
                sb.append(str.substring(length - 1));
                return sb.toString();
            }
            sb.append(str.substring(0, 1));
            sb.append("*");
            return sb.toString();
        }
        return str;
    }

    public void H() {
        this.f28811e = new CountDownLatch(1);
        com.oplus.phonenoareainquire.utils.b bVar = com.oplus.phonenoareainquire.utils.b.f28881a;
        com.oplus.phonenoareainquire.utils.b.i(getContext(), this.f28810d, this.f28811e);
        R();
    }

    public final Phonenumber$PhoneNumber I(String str, String str2) {
        try {
            return w().p0(str, str2);
        } catch (NumberParseException unused) {
            return null;
        }
    }

    public void J(int i10, Object obj) {
        LogUtil.c("PhoneNoProvider", "performBackgroundTask : " + i10);
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    OplusLocaleChangeJobIntentService.l();
                    return;
                }
                return;
            }
            c();
            return;
        }
        R();
    }

    public void K(DataInputStream dataInputStream) {
        try {
            new b(dataInputStream).execute(new Void[0]);
        } catch (Exception e10) {
            Log.e("PhoneNoProvider", "Exception execute readPhoneNumberData async task " + e10);
        }
    }

    public void L() {
        Handler handler = this.f28822p;
        if (handler != null) {
            handler.removeMessages(2);
        }
    }

    public final String M(String str, String str2) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str2, "CN")) {
            int i10 = 0;
            while (true) {
                String[] strArr = f28805y;
                if (i10 < strArr.length) {
                    if (str.startsWith(strArr[i10])) {
                        return str.substring(strArr[i10].length());
                    }
                    i10++;
                } else {
                    return str;
                }
            }
        } else {
            return str;
        }
    }

    public void N(int i10, long j10) {
        LogUtil.c("PhoneNoProvider", "scheduleBackgroundTask : " + i10);
        Handler handler = this.f28822p;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(i10, j10);
        }
    }

    public void P(CountDownLatch countDownLatch) {
        this.f28811e = countDownLatch;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        r7.setLocale(java.util.Locale.getDefault());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006e, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006f, code lost:
    
        android.util.Log.e("PhoneNoProvider", "Exception when setLocale " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004a, code lost:
    
        if (r3 != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R() {
        /*
            r7 = this;
            java.lang.String r0 = "PhoneNoProvider"
            com.oplus.phonenoareainquire.e r7 = r7.f28812f
            android.database.sqlite.SQLiteDatabase r7 = r7.getWritableDatabase()
            r1 = 0
            java.lang.String r2 = "SELECT locale FROM android_metadata ORDER BY locale DESC LIMIT 1"
            android.database.Cursor r1 = r7.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3 = 1
            if (r2 <= 0) goto L47
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r2 = 0
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r5.<init>()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r5.append(r4)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r6 = "  "
            r5.append(r6)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r5.append(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            com.oplus.phonenoareainquire.utils.LogUtil.a(r0, r5)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3 = r3 ^ r2
            goto L47
        L43:
            r7 = move-exception
            goto La2
        L45:
            r2 = move-exception
            goto L4d
        L47:
            r1.close()
            if (r3 == 0) goto L83
            goto L66
        L4d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            r3.<init>()     // Catch: java.lang.Throwable -> L43
            java.lang.String r4 = "updateLocaleTask : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L43
            r3.append(r2)     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L43
            com.oplus.phonenoareainquire.utils.LogUtil.b(r0, r2)     // Catch: java.lang.Throwable -> L43
            if (r1 == 0) goto L66
            r1.close()
        L66:
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch: java.lang.Exception -> L6e
            r7.setLocale(r1)     // Catch: java.lang.Exception -> L6e
            goto L83
        L6e:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Exception when setLocale "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            android.util.Log.e(r0, r7)
        L83:
            com.oplus.phonenoareainquire.utils.e.h()     // Catch: java.lang.Throwable -> L87
            goto L9c
        L87:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Exception when init PortabilityNumbersUtil "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            android.util.Log.e(r0, r7)
        L9c:
            java.lang.String r7 = "updateLocaleTask run finished"
            com.oplus.phonenoareainquire.utils.LogUtil.a(r0, r7)
            return
        La2:
            if (r1 == 0) goto La7
            r1.close()
        La7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.PhoneNoInquireProvider.R():void");
    }

    public final String a(String str, String str2) {
        String b10;
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (this.f28810d) {
            Locale locale = Locale.getDefault();
            b10 = locale.getLanguage() + "_" + locale.getCountry();
        } else {
            b10 = com.oplus.phonenoareainquire.utils.c.b();
        }
        LogUtil.a("PhoneNoProvider", "addChina " + b10);
        com.oplus.phonenoareainquire.utils.b bVar = com.oplus.phonenoareainquire.utils.b.f28881a;
        return com.oplus.phonenoareainquire.utils.b.h(str2, b10, this.f28810d);
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase writableDatabase = this.f28812f.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
            writableDatabase.setTransactionSuccessful();
            return applyBatch;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void b(StringBuilder sb, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f28812f.getWritableDatabase().execSQL("INSERT OR REPLACE INTO area_presence_db.presence_numbers_table(_id ,display_name ,data1 ,phonebook_bucket ,_index ,cityname ,photo_id ,areano) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", new String[]{str, str2, str3, str4, str5, str6, str8, str7});
    }

    public final void c() {
        try {
            PhoneNoInquireProviderTransaction.f28828a.a();
            this.f28813g = this.f28812f.getReadableDatabase();
            com.oplus.phonenoareainquire.utils.e eVar = com.oplus.phonenoareainquire.utils.e.f28898a;
            com.oplus.phonenoareainquire.utils.e.c(getContext().getAssets().open("PortabilityNumberData.dat"));
            LogUtil.a("PhoneNoProvider", "background init finished");
        } catch (Throwable th) {
            Log.e("PhoneNoProvider", "Exception when copy portability number file to data dir " + th);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        if ("refresh_province_and_city_table".equals(str)) {
            this.f28812f.o(this.f28812f.getWritableDatabase());
        } else if ("update_city_code".equals(str)) {
            try {
                this.f28812f.r(this.f28812f.getWritableDatabase());
            } catch (Throwable th) {
                Log.e("PhoneNoProvider", "updateCityCode fail : " + th.getMessage());
            }
        }
        return super.call(str, str2, bundle);
    }

    public final InputStream d(InputStream inputStream) {
        int available = inputStream.available();
        byte[] bArr = new byte[available];
        int i10 = 0;
        while (i10 < available) {
            i10 += inputStream.read(bArr, i10, available - i10);
        }
        return new ByteArrayInputStream(bArr);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (!getContext().getPackageName().equals(getCallingPackage())) {
            return 0;
        }
        SQLiteDatabase writableDatabase = this.f28812f.getWritableDatabase();
        writableDatabase.delete(BRPluginConfig.VERSION, null, null);
        writableDatabase.delete("areano_and_citynames", null, null);
        return 1;
    }

    public void e() {
        HashMap<String, Integer> hashMap = this.f28807a;
        if (hashMap != null && hashMap.size() <= 32) {
            SelfHealUtil.e(getContext());
        }
        HashMap<String, Integer> hashMap2 = this.f28807a;
        int i10 = 0;
        if (hashMap2 != null) {
            Iterator<Map.Entry<String, Integer>> it = hashMap2.entrySet().iterator();
            while (it.hasNext()) {
                i10 = Math.max(i10, it.next().getValue().intValue());
            }
        }
        byte[] bArr = this.f28808b;
        if (bArr != null && bArr.length < i10) {
            LogUtil.a("PhoneNoProvider", "the source data may have encounter error ");
            SelfHealUtil.e(getContext());
        }
        SelfHealUtil.d();
    }

    public final String[] f(String str, String str2) {
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {"", ""};
        Phonenumber$PhoneNumber I10 = I(str, str2);
        String t10 = t(I10);
        if (TextUtils.isEmpty(t10)) {
            return null;
        }
        String a10 = a(str2, t10);
        if (!TextUtils.isEmpty(a10)) {
            str3 = "-" + String.valueOf(I10.f());
        }
        strArr[0] = str3;
        strArr[1] = a10;
        return strArr;
    }

    public final String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains(" ")) {
            str = str.replace(" ", "");
        }
        if (str.contains("-")) {
            str = str.replace("-", "");
        }
        if (str.contains("(")) {
            str = str.replace("(", "");
        }
        if (str.contains(")")) {
            return str.replace(")", "");
        }
        return str;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        UriMatcher uriMatcher = f28798H;
        if (uriMatcher == null) {
            return null;
        }
        int match = uriMatcher.match(uri);
        if (match != 0) {
            if (match != 1) {
                if (match != 2) {
                    if (match != 5) {
                        return null;
                    }
                    return "vnd.android.cursor.item/version";
                }
                return "vnd.android.cursor.item/areano_and_citynames";
            }
            return "vnd.android.cursor.dir/areano_and_citynames";
        }
        return "vnd.android.cursor.item/phoneno";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        long insert;
        this.f28813g = this.f28812f.getWritableDatabase();
        int match = f28798H.match(uri);
        if (match != 1) {
            if (match != 5) {
                insert = 0;
            } else {
                insert = this.f28813g.insert(BRPluginConfig.VERSION, null, contentValues);
            }
        } else {
            insert = this.f28813g.insert("areano_and_citynames", null, contentValues);
        }
        if (insert <= 0) {
            return null;
        }
        return ContentUris.withAppendedId(uri, insert);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.database.Cursor j(java.lang.String r6, java.lang.String r7, java.lang.Boolean r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.PhoneNoInquireProvider.j(java.lang.String, java.lang.String, java.lang.Boolean, boolean, boolean):android.database.Cursor");
    }

    public String k(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = q();
            }
            String replace = str.replace("#", "").replace("-", "");
            if (!TextUtils.equals("CN", o(replace, str2))) {
                return null;
            }
            PhoneNumberUtil C10 = PhoneNumberUtil.C();
            if (replace.length() > 17) {
                replace = replace.substring(0, 17);
            }
            return V7.a.b().c(PhoneNumberUtil.C().r0(com.oplus.phonenoareainquire.utils.d.d(C10.r0(replace, str2).i()), str2), Locale.getDefault());
        } catch (Exception e10) {
            Log.e("PhoneNoProvider", e10 + "");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x01ff, code lost:
    
        r0 = r13.f28809c.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0207, code lost:
    
        if (r0 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0209, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0212, code lost:
    
        if (r14.length() >= r0.intValue()) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0214, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0215, code lost:
    
        r0 = r14.substring(0, r0.intValue());
        r2 = r0.substring(0, r1.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0225, code lost:
    
        r1 = r0.substring(r1.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x022e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x023a, code lost:
    
        android.util.Log.e("PhoneNoProvider", "" + r0);
        r0 = null;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011d, code lost:
    
        if (r14.startsWith(com.android.incallui.OplusPhoneUtils.DeviceState.UNLOCK_DEVICE) != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0125, code lost:
    
        if (r14.startsWith(com.android.incallui.OplusPhoneUtils.DeviceState.LOCK_DEVICE) != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0127, code lost:
    
        r14 = com.android.incallui.OplusPhoneUtils.DeviceState.UNLOCK_DEVICE + r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0117, code lost:
    
        if (r14.startsWith("10") == false) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0250 A[Catch: Exception -> 0x0183, TryCatch #3 {Exception -> 0x0183, blocks: (B:83:0x0168, B:87:0x0172, B:89:0x0180, B:93:0x0186, B:95:0x0190, B:97:0x0196, B:99:0x019f, B:102:0x01a6, B:104:0x01ac, B:107:0x01b5, B:110:0x01bc, B:111:0x01c5, B:113:0x01c1, B:114:0x01d5, B:116:0x01db, B:139:0x0250, B:140:0x025c, B:142:0x0266, B:144:0x027f, B:146:0x028c, B:151:0x0294, B:154:0x02b4, B:157:0x02b8, B:159:0x02c0, B:161:0x02c6, B:163:0x02d0, B:165:0x02da, B:167:0x02f9, B:171:0x023a), top: B:82:0x0168 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0266 A[Catch: Exception -> 0x0183, TryCatch #3 {Exception -> 0x0183, blocks: (B:83:0x0168, B:87:0x0172, B:89:0x0180, B:93:0x0186, B:95:0x0190, B:97:0x0196, B:99:0x019f, B:102:0x01a6, B:104:0x01ac, B:107:0x01b5, B:110:0x01bc, B:111:0x01c5, B:113:0x01c1, B:114:0x01d5, B:116:0x01db, B:139:0x0250, B:140:0x025c, B:142:0x0266, B:144:0x027f, B:146:0x028c, B:151:0x0294, B:154:0x02b4, B:157:0x02b8, B:159:0x02c0, B:161:0x02c6, B:163:0x02d0, B:165:0x02da, B:167:0x02f9, B:171:0x023a), top: B:82:0x0168 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x027f A[Catch: Exception -> 0x0183, TryCatch #3 {Exception -> 0x0183, blocks: (B:83:0x0168, B:87:0x0172, B:89:0x0180, B:93:0x0186, B:95:0x0190, B:97:0x0196, B:99:0x019f, B:102:0x01a6, B:104:0x01ac, B:107:0x01b5, B:110:0x01bc, B:111:0x01c5, B:113:0x01c1, B:114:0x01d5, B:116:0x01db, B:139:0x0250, B:140:0x025c, B:142:0x0266, B:144:0x027f, B:146:0x028c, B:151:0x0294, B:154:0x02b4, B:157:0x02b8, B:159:0x02c0, B:161:0x02c6, B:163:0x02d0, B:165:0x02da, B:167:0x02f9, B:171:0x023a), top: B:82:0x0168 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.database.Cursor l(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.PhoneNoInquireProvider.l(java.lang.String):android.database.Cursor");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x020a, code lost:
    
        if (r10 != null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x030e, code lost:
    
        if (r10 != null) goto L120;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.database.Cursor m(java.lang.String[] r26, java.lang.String r27, boolean r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 983
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.PhoneNoInquireProvider.m(java.lang.String[], java.lang.String, boolean, java.lang.String):android.database.Cursor");
    }

    public final int n(String str, String str2) {
        int i10 = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                Phonenumber$PhoneNumber r02 = PhoneNumberUtil.C().r0(str, str2);
                if (r02 != null) {
                    if (str.startsWith("00")) {
                        i10 = r02.f();
                    } else if (r02.g() != Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD) {
                        i10 = r02.f();
                    }
                }
            } catch (NumberParseException unused) {
            }
        }
        return i10;
    }

    public final String o(String str, String str2) {
        return p(str, str2, false);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        boolean z10;
        Log.d("PhoneNoProvider", "onCreate");
        Q(this);
        Context context = getContext();
        O(context.getDatabasePath("inquirenoarea.db").getAbsolutePath().replace("inquirenoarea.db", ""));
        f28791A = f28806z + "PhoneNumberData_Revert.dat";
        f28792B = f28806z + "PhoneNumberData_3_1_0.dat";
        f28793C = f28806z + "ExtendNumber.dat";
        f28794D = f28806z + "city_name_table.txt";
        f28795E = f28806z + "Multi_Language_Table.txt";
        f28796F = f28806z + "PortabilityNumberData.dat";
        f28797G = f28806z + "CountryNameMappingFile.dat";
        e g10 = e.g(context);
        this.f28812f = g10;
        try {
            g10.getReadableDatabase();
        } catch (Throwable th) {
            Log.e("PhoneNoProvider", "exception when get database : " + th);
            SelfHealUtil.e(getContext());
        }
        this.f28817k = x(getContext());
        this.f28818l = i();
        this.f28821o = context.getResources().getConfiguration().locale;
        this.f28810d = C0568b.e();
        if (!C0568b.d() && (context.getResources().getInteger(h.f28859a) != 1 || !E())) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f28823q = z10;
        this.f28816j = d.c();
        a aVar = new a("ContactsProviderWorker", 10);
        aVar.start();
        Looper looper = aVar.getLooper();
        if (looper != null) {
            this.f28822p = new c(looper);
        }
        N(1, 0L);
        N(0, 0L);
        N(2, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
        if (this.f28807a == null || this.f28808b == null) {
            F();
        }
        if (this.f28809c == null) {
            C(context);
        }
        e();
        this.f28811e = new CountDownLatch(1);
        com.oplus.phonenoareainquire.utils.b.i(getContext(), this.f28810d, this.f28811e);
        Log.d("PhoneNoProvider", "onCreate  finish");
        return true;
    }

    public final String p(String str, String str2, boolean z10) {
        if (f28802L) {
            Log.d("PhoneNoProvider", "getCountryCodeOfNumber countryIso = " + str2);
        }
        List<String> list = null;
        if (!TextUtils.isEmpty(str)) {
            PhoneNumberUtil C10 = PhoneNumberUtil.C();
            try {
                Phonenumber$PhoneNumber r02 = C10.r0(str, str2);
                if (r02 != null) {
                    Phonenumber$PhoneNumber.CountryCodeSource g10 = r02.g();
                    if (f28802L) {
                        Log.d("PhoneNoProvider", "getCountryCodeOfNumber countryCodeSource = " + g10);
                    }
                    if (z10 && g10 == Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN && r02.f() == 1) {
                        return "unknown_number_country_code";
                    }
                    if (g10 != Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD) {
                        list = C10.O(r02.f());
                    }
                    if (list == null && str.startsWith("00")) {
                        String l10 = r02.l();
                        if (!TextUtils.isEmpty(l10)) {
                            if (l10.startsWith("00" + r02.f())) {
                                list = C10.O(r02.f());
                            }
                        }
                    }
                }
            } catch (NumberParseException e10) {
                Log.e("PhoneNoProvider", "e = " + e10);
            }
        }
        if (list == null) {
            return str2;
        }
        if (list.contains(str2)) {
            return str2;
        }
        return list.get(0);
    }

    public final String q() {
        return com.oplus.phonenoareainquire.a.b(getContext()).a();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011f A[SYNTHETIC] */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.database.Cursor query(android.net.Uri r22, java.lang.String[] r23, java.lang.String r24, java.lang.String[] r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.PhoneNoInquireProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public final Cursor s(String str, String str2) {
        int i10;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = q();
        }
        if (f28802L) {
            Log.d("PhoneNoProvider", "number = " + G(str) + ", countryIso = " + str2);
        }
        Phonenumber$PhoneNumber I10 = I(str, str2);
        String t10 = t(I10);
        if (!TextUtils.isEmpty(t10)) {
            if (t10.equals("Cina")) {
                t10 = "China";
            } else if (t10.startsWith("Nam D") && t10.endsWith("ng")) {
                t10 = "Indonesia";
            }
            t10 = a(o(str, str2), t10);
        }
        if (!TextUtils.isEmpty(t10)) {
            String B10 = B(str, str2);
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{BreenoCallContract.BaseColumns._ID, "areano", "cityname"}, 1);
            matrixCursor.addRow(new String[]{OplusPhoneUtils.DeviceState.INVALID_STATUS, B10, t10});
            return matrixCursor;
        }
        if (TextUtils.equals(str2, "CN") || TextUtils.equals(str2, "HK") || TextUtils.equals(str2, "MO") || TextUtils.equals(str2, "TW")) {
            if (I10 != null) {
                i10 = I10.f();
            } else {
                i10 = 0;
            }
            if (i10 != 86 && i10 != 852 && i10 != 853 && i10 != 886 && i10 != 0) {
                MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{BreenoCallContract.BaseColumns._ID, "areano", "cityname"}, 1);
                matrixCursor2.addRow(new String[]{OplusPhoneUtils.DeviceState.INVALID_STATUS, "-4", t10});
                return matrixCursor2;
            }
        }
        return null;
    }

    public String t(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        if (phonenumber$PhoneNumber != null) {
            if (getContext() != null) {
                this.f28821o = getContext().getResources().getConfiguration().locale;
            } else {
                Log.e("PhoneNoProvider", "getGeocodedLocationFor getContext is null");
            }
            return v().b(phonenumber$PhoneNumber, this.f28821o);
        }
        return null;
    }

    public e.a u(String str) {
        try {
            String o10 = o(str, q());
            Phonenumber$PhoneNumber r02 = PhoneNumberUtil.C().r0(str, o10);
            String a10 = com.oplus.phonenoareainquire.utils.c.a();
            if (!TextUtils.equals(o10, "CN") || (!TextUtils.equals(a10, "CN") && !TextUtils.equals(a10, "TW") && !TextUtils.equals(a10, "HK") && !com.oplus.phonenoareainquire.utils.c.c(a10))) {
                return null;
            }
            return com.oplus.phonenoareainquire.utils.e.g(r02.i(), a10);
        } catch (Exception e10) {
            Log.e("PhoneNoProvider", "exception when getCarrierForNumberFromDatabase " + e10);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f28812f.getWritableDatabase();
        if (f28798H.match(uri) != 5) {
            return 0;
        }
        return writableDatabase.update(BRPluginConfig.VERSION, contentValues, null, null);
    }

    public final synchronized W7.a v() {
        try {
            if (this.f28820n == null) {
                this.f28820n = W7.a.d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f28820n;
    }

    public final synchronized PhoneNumberUtil w() {
        try {
            if (this.f28819m == null) {
                this.f28819m = PhoneNumberUtil.C();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f28819m;
    }

    public Cursor z(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            Log.i("PhoneNoProvider", "phoneNo is empty return null ");
            return null;
        }
        String replace = str.replace("-", "").replace(" ", "");
        if (TextUtils.isEmpty(replace)) {
            return null;
        }
        int length = replace.length();
        if (!replace.startsWith("2") && !replace.startsWith("3") && !replace.startsWith("5") && !replace.startsWith("7") && !replace.startsWith("8")) {
            if (replace.startsWith("6") && length >= 3 && length <= 6) {
                string = getContext().getString(j.f28865e);
            }
            string = null;
        } else if (length == 3) {
            string = getContext().getString(j.f28864d);
        } else {
            if (length == 4 || length == 5) {
                string = getContext().getString(j.f28865e);
            }
            string = null;
        }
        if (string == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{BreenoCallContract.BaseColumns._ID, "areano", "cityname"}, 1);
        matrixCursor.addRow(new String[]{OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, "9999", string});
        return matrixCursor;
    }
}
