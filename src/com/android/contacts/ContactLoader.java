package com.android.contacts;

import W.c;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.api.numberidentify.interfaces.INAFCApi;
import com.android.contacts.framework.baseui.util.LocationUtils;
import com.android.contacts.model.Account;
import com.android.contacts.model.AccountType;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.BlackListUtils;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import n1.AbstractC1362a;
import w0.C1641a;
import w0.C1643c;

/* loaded from: classes.dex */
public class ContactLoader extends W.c<Result> {

    /* renamed from: w, reason: collision with root package name */
    public static Result f13006w;

    /* renamed from: j, reason: collision with root package name */
    public final Set<Long> f13007j;

    /* renamed from: k, reason: collision with root package name */
    public final Handler f13008k;

    /* renamed from: l, reason: collision with root package name */
    public Uri f13009l;

    /* renamed from: m, reason: collision with root package name */
    public Uri f13010m;

    /* renamed from: n, reason: collision with root package name */
    public Result f13011n;

    /* renamed from: o, reason: collision with root package name */
    public W.c<Result>.a f13012o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13013p;

    /* renamed from: q, reason: collision with root package name */
    public AtomicInteger f13014q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13015r;

    /* renamed from: s, reason: collision with root package name */
    public Executor f13016s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13017t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13018u;

    /* renamed from: v, reason: collision with root package name */
    public String f13019v;

    /* loaded from: classes.dex */
    public static class Result {

        /* renamed from: A, reason: collision with root package name */
        public String f13020A;

        /* renamed from: B, reason: collision with root package name */
        public String f13021B;

        /* renamed from: C, reason: collision with root package name */
        public String f13022C;

        /* renamed from: D, reason: collision with root package name */
        public int f13023D;

        /* renamed from: E, reason: collision with root package name */
        public ArrayList<M0> f13024E;

        /* renamed from: F, reason: collision with root package name */
        public boolean f13025F;

        /* renamed from: G, reason: collision with root package name */
        public byte[] f13026G;

        /* renamed from: H, reason: collision with root package name */
        public String f13027H;

        /* renamed from: I, reason: collision with root package name */
        public String f13028I;

        /* renamed from: J, reason: collision with root package name */
        public boolean f13029J;

        /* renamed from: K, reason: collision with root package name */
        public HashMap<Account, Long> f13030K;

        /* renamed from: L, reason: collision with root package name */
        public int f13031L;

        /* renamed from: M, reason: collision with root package name */
        public boolean f13032M;

        /* renamed from: N, reason: collision with root package name */
        public boolean f13033N;

        /* renamed from: O, reason: collision with root package name */
        public ArrayList<String> f13034O;

        /* renamed from: P, reason: collision with root package name */
        public final ArrayList<String> f13035P;

        /* renamed from: Q, reason: collision with root package name */
        public HashMap<String, String> f13036Q;

        /* renamed from: R, reason: collision with root package name */
        public String f13037R;

        /* renamed from: S, reason: collision with root package name */
        public ArrayList<String> f13038S;

        /* renamed from: T, reason: collision with root package name */
        public ArrayList<String> f13039T;

        /* renamed from: U, reason: collision with root package name */
        public String f13040U;

        /* renamed from: a, reason: collision with root package name */
        public final Uri f13041a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f13042b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f13043c;

        /* renamed from: d, reason: collision with root package name */
        public final long f13044d;

        /* renamed from: e, reason: collision with root package name */
        public final String f13045e;

        /* renamed from: f, reason: collision with root package name */
        public final long f13046f;

        /* renamed from: g, reason: collision with root package name */
        public final long f13047g;

        /* renamed from: h, reason: collision with root package name */
        public final int f13048h;

        /* renamed from: i, reason: collision with root package name */
        public final long f13049i;

        /* renamed from: j, reason: collision with root package name */
        public final String f13050j;

        /* renamed from: k, reason: collision with root package name */
        public String f13051k;

        /* renamed from: l, reason: collision with root package name */
        public String f13052l;

        /* renamed from: m, reason: collision with root package name */
        public String f13053m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f13054n;

        /* renamed from: o, reason: collision with root package name */
        public final Integer f13055o;

        /* renamed from: p, reason: collision with root package name */
        public final ArrayList<Entity> f13056p;

        /* renamed from: q, reason: collision with root package name */
        public final HashMap<Long, com.android.contacts.util.n> f13057q;

        /* renamed from: r, reason: collision with root package name */
        public final boolean f13058r;

        /* renamed from: s, reason: collision with root package name */
        public final String f13059s;

        /* renamed from: t, reason: collision with root package name */
        public String f13060t;

        /* renamed from: u, reason: collision with root package name */
        public final String f13061u;

        /* renamed from: v, reason: collision with root package name */
        public final boolean f13062v;

        /* renamed from: w, reason: collision with root package name */
        public final Status f13063w;

        /* renamed from: x, reason: collision with root package name */
        public final Exception f13064x;

        /* renamed from: y, reason: collision with root package name */
        public ConcurrentHashMap<String, String> f13065y;

        /* renamed from: z, reason: collision with root package name */
        public String f13066z;

        /* loaded from: classes.dex */
        public enum Status {
            LOADED,
            ERROR,
            NOT_FOUND
        }

        public static Result m(Uri uri, Exception exc) {
            return new Result(uri, Status.ERROR, exc);
        }

        public static Result n(Uri uri) {
            return new Result(uri, Status.NOT_FOUND, null);
        }

        public String A() {
            return this.f13020A;
        }

        public String B() {
            return this.f13051k;
        }

        public int C() {
            return this.f13048h;
        }

        public ArrayList<Entity> D() {
            return this.f13056p;
        }

        public Exception E() {
            return this.f13064x;
        }

        public String F() {
            return this.f13037R;
        }

        public ArrayList<String> G() {
            return this.f13039T;
        }

        public List<M0> H() {
            return this.f13024E;
        }

        public boolean I() {
            return this.f13032M;
        }

        public boolean J() {
            return this.f13033N;
        }

        public String K() {
            return this.f13045e;
        }

        public Uri L() {
            return this.f13042b;
        }

        public long M() {
            return this.f13047g;
        }

        public ConcurrentHashMap<String, String> N() {
            return this.f13065y;
        }

        public int O() {
            return this.f13034O.size();
        }

        public ArrayList<String> P() {
            return this.f13034O;
        }

        public String Q() {
            return this.f13053m;
        }

        public byte[] R() {
            return this.f13026G;
        }

        public long S() {
            return this.f13049i;
        }

        public String T() {
            return this.f13050j;
        }

        public Uri U() {
            return this.f13041a;
        }

        public int V() {
            return this.f13031L;
        }

        public boolean W() {
            return this.f13054n;
        }

        public HashMap<Long, com.android.contacts.util.n> X() {
            return this.f13057q;
        }

        public String Y() {
            return this.f13040U;
        }

        public HashMap<Account, Long> Z() {
            return this.f13030K;
        }

        public boolean a0() {
            Iterator<Entity> it = D().iterator();
            while (it.hasNext()) {
                ContentValues entityValues = it.next().getEntityValues();
                if (entityValues != null && !TextUtils.equals(R0.a.f3166b, entityValues.getAsString("account_type"))) {
                    return true;
                }
            }
            return false;
        }

        public boolean b0() {
            long j10 = this.f13044d;
            if (j10 != -1 && j10 != 0 && j10 != 1) {
                return true;
            }
            return false;
        }

        public boolean c0() {
            if (this.f13063w == Status.ERROR) {
                return true;
            }
            return false;
        }

        public boolean d0() {
            if (this.f13063w == Status.LOADED) {
                return true;
            }
            return false;
        }

        public boolean e0() {
            if (this.f13063w == Status.NOT_FOUND) {
                return true;
            }
            return false;
        }

        public boolean f0() {
            return this.f13029J;
        }

        public boolean g0() {
            return this.f13062v;
        }

        public void h0(String str) {
            this.f13052l = str;
        }

        public void i0(String str) {
            this.f13038S.add(str);
        }

        public final void j(M0 m02) {
            if (this.f13024E == null) {
                this.f13024E = new ArrayList<>();
            }
            this.f13024E.add(m02);
        }

        public void j0(String str) {
            this.f13060t = str;
        }

        public final void k(String str) {
            this.f13034O.add(str);
        }

        public final void k0(String str, String str2, String str3, String str4, int i10) {
            this.f13066z = str;
            this.f13020A = str2;
            this.f13021B = str3;
            this.f13022C = str4;
            this.f13023D = i10;
        }

        public boolean l(String str) {
            if (D() != null && !TextUtils.isEmpty(str)) {
                Iterator<Entity> it = D().iterator();
                while (it.hasNext()) {
                    ContentValues entityValues = it.next().getEntityValues();
                    if (entityValues != null && str.equals(entityValues.getAsString("account_name"))) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public void l0(String str) {
            this.f13051k = str;
        }

        public void m0(String str) {
            this.f13037R = str;
        }

        public final void n0(HashMap<String, Boolean> hashMap) {
            this.f13032M = hashMap.get("isBlackList").booleanValue();
            this.f13033N = hashMap.get("isWhiteList").booleanValue();
        }

        public String o() {
            return this.f13027H;
        }

        public final void o0(boolean z10) {
            this.f13025F = z10;
        }

        public String p() {
            return this.f13028I;
        }

        public void p0(HashMap<String, String> hashMap) {
            if (this.f13065y != null && hashMap != null && hashMap.size() > 0) {
                this.f13065y.putAll(hashMap);
            }
        }

        public String q() {
            return this.f13052l;
        }

        public final void q0(byte[] bArr) {
            this.f13026G = bArr;
        }

        public ArrayList<String> r() {
            return this.f13038S;
        }

        public final void r0(String str) {
            this.f13040U = str;
        }

        public ArrayList<ContentValues> s() {
            if (this.f13056p.size() != 1) {
                H7.b.c("ContactLoader", "Cannot extract content values from an aggregated contact");
                return null;
            }
            Entity entity = this.f13056p.get(0);
            ArrayList<ContentValues> arrayList = new ArrayList<>();
            ArrayList<Entity.NamedContentValues> subValues = entity.getSubValues();
            if (subValues != null) {
                int size = subValues.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Entity.NamedContentValues namedContentValues = subValues.get(i10);
                    if (ContactsContract.Data.CONTENT_URI.equals(namedContentValues.uri)) {
                        arrayList.add(namedContentValues.values);
                    }
                }
            }
            if (this.f13049i == 0 && this.f13026G != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mimetype", "vnd.android.cursor.item/photo");
                contentValues.put("data15", this.f13026G);
                arrayList.add(contentValues);
            }
            return arrayList;
        }

        public HashMap<String, String> t() {
            return this.f13036Q;
        }

        public String u() {
            return this.f13059s;
        }

        public String v() {
            return this.f13060t;
        }

        public String w() {
            return this.f13061u;
        }

        public String x(String str, String str2) {
            if (D() != null) {
                Iterator<Entity> it = D().iterator();
                while (it.hasNext()) {
                    Iterator<Entity.NamedContentValues> it2 = it.next().getSubValues().iterator();
                    while (it2.hasNext()) {
                        Entity.NamedContentValues next = it2.next();
                        if (TextUtils.equals(next.values.getAsString("mimetype"), str)) {
                            String asString = next.values.getAsString(str2);
                            if (!TextUtils.isEmpty(asString)) {
                                return asString;
                            }
                        }
                    }
                }
                return null;
            }
            return null;
        }

        public String y() {
            return this.f13066z;
        }

        public long z() {
            return this.f13044d;
        }

        public Result(Uri uri, Status status, Exception exc) {
            this.f13060t = " ";
            this.f13065y = new ConcurrentHashMap<>();
            this.f13029J = false;
            this.f13034O = new ArrayList<>();
            ArrayList<String> arrayList = new ArrayList<>();
            this.f13035P = arrayList;
            this.f13037R = null;
            this.f13038S = new ArrayList<>();
            this.f13040U = null;
            this.f13063w = status;
            this.f13064x = exc;
            this.f13041a = uri;
            this.f13042b = null;
            this.f13043c = null;
            this.f13044d = -1L;
            this.f13045e = null;
            this.f13046f = -1L;
            this.f13056p = null;
            this.f13057q = null;
            this.f13047g = -1L;
            this.f13048h = 0;
            this.f13049i = -1L;
            this.f13050j = null;
            this.f13051k = null;
            this.f13052l = null;
            this.f13053m = null;
            this.f13054n = false;
            this.f13055o = null;
            this.f13058r = false;
            this.f13059s = null;
            this.f13061u = null;
            this.f13062v = false;
            this.f13032M = false;
            this.f13034O.clear();
            this.f13065y.clear();
            arrayList.clear();
            this.f13036Q = null;
            this.f13030K = null;
            this.f13033N = false;
            this.f13039T = null;
        }

        public Result(Uri uri, Uri uri2, Uri uri3, long j10, String str, long j11, long j12, int i10, long j13, String str2, String str3, String str4, String str5, boolean z10, Integer num, boolean z11, String str6, boolean z12, String str7, String str8, int i11, String str9) {
            this.f13060t = " ";
            this.f13065y = new ConcurrentHashMap<>();
            this.f13029J = false;
            this.f13034O = new ArrayList<>();
            this.f13035P = new ArrayList<>();
            this.f13037R = null;
            this.f13038S = new ArrayList<>();
            this.f13040U = null;
            this.f13063w = Status.LOADED;
            this.f13064x = null;
            this.f13041a = uri;
            this.f13042b = uri3;
            this.f13043c = uri2;
            this.f13044d = j10;
            this.f13045e = str;
            this.f13046f = j11;
            this.f13056p = new ArrayList<>();
            this.f13057q = new HashMap<>();
            this.f13047g = j12;
            this.f13048h = i10;
            this.f13049i = j13;
            this.f13050j = str2;
            this.f13051k = str3;
            this.f13052l = str4;
            this.f13053m = str5;
            this.f13054n = z10;
            this.f13055o = num;
            this.f13058r = z11;
            this.f13059s = str6;
            this.f13062v = z12;
            this.f13027H = str7;
            this.f13028I = str8;
            this.f13036Q = new HashMap<>();
            this.f13030K = new HashMap<>();
            this.f13031L = i11;
            this.f13029J = TextUtils.equals(this.f13028I, "com.android.oplus.sim");
            this.f13061u = str9;
        }

        public Result(Result result) {
            this.f13060t = " ";
            this.f13065y = new ConcurrentHashMap<>();
            this.f13029J = false;
            this.f13034O = new ArrayList<>();
            ArrayList<String> arrayList = new ArrayList<>();
            this.f13035P = arrayList;
            this.f13037R = null;
            this.f13038S = new ArrayList<>();
            this.f13040U = null;
            this.f13063w = result.f13063w;
            this.f13064x = result.f13064x;
            this.f13041a = result.f13041a;
            this.f13042b = result.f13042b;
            this.f13043c = result.f13043c;
            this.f13044d = result.f13044d;
            this.f13045e = result.f13045e;
            this.f13046f = result.f13046f;
            this.f13056p = result.f13056p;
            this.f13057q = result.f13057q;
            this.f13047g = result.f13047g;
            this.f13048h = result.f13048h;
            this.f13049i = result.f13049i;
            this.f13050j = result.f13050j;
            this.f13051k = result.f13051k;
            this.f13052l = result.f13052l;
            this.f13053m = result.f13053m;
            this.f13054n = result.f13054n;
            this.f13055o = result.f13055o;
            this.f13058r = result.f13058r;
            this.f13059s = result.f13059s;
            this.f13062v = result.f13062v;
            this.f13066z = result.f13066z;
            this.f13020A = result.f13020A;
            this.f13021B = result.f13021B;
            this.f13022C = result.f13022C;
            this.f13023D = result.f13023D;
            this.f13024E = result.f13024E;
            this.f13025F = result.f13025F;
            this.f13026G = result.f13026G;
            this.f13027H = result.f13027H;
            this.f13028I = result.f13028I;
            this.f13065y = result.f13065y;
            this.f13036Q = result.f13036Q;
            this.f13030K = result.f13030K;
            this.f13031L = result.f13031L;
            this.f13029J = result.f13029J;
            this.f13061u = result.f13061u;
            this.f13060t = result.f13060t;
            this.f13032M = result.f13032M;
            this.f13034O = result.f13034O;
            arrayList.clear();
            arrayList.addAll(result.f13035P);
            this.f13039T = result.f13039T;
        }
    }

    /* loaded from: classes.dex */
    public class a extends AsyncTask<String, Void, byte[]> {
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public byte[] doInBackground(String... strArr) {
            Uri parse = Uri.parse(strArr[0]);
            byte[] bArr = null;
            try {
                InputStream openInputStream = ContactLoader.this.i().getContentResolver().openInputStream(parse);
                if (openInputStream != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr2 = new byte[16384];
                        while (true) {
                            int read = openInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        bArr = byteArrayOutputStream.toByteArray();
                        openInputStream.close();
                    } catch (Throwable th) {
                        openInputStream.close();
                        throw th;
                    }
                } else {
                    H7.b.h("ContactLoader", "Cannot load photo " + parse);
                }
            } catch (IOException e10) {
                H7.b.c("ContactLoader", "Cannot load photo " + parse + e10);
            }
            return bArr;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(byte[] bArr) {
            if (ContactLoader.this.f13011n != null) {
                ContactLoader contactLoader = ContactLoader.this;
                contactLoader.f13011n = new Result(contactLoader.f13011n);
                ContactLoader.this.f13011n.q0(bArr);
                ContactLoader.this.f13011n.o0(false);
                ContactLoader contactLoader2 = ContactLoader.this;
                contactLoader2.f(contactLoader2.f13011n);
            }
        }

        public a() {
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f13072a = {"name_raw_contact_id", "display_name_source", "lookup", "display_name", "display_name_alt", "phonetic_name", "photo_id", "starred", "contact_presence", "contact_status", "contact_status_ts", "contact_status_res_package", "contact_status_label", "contact_id", "raw_contact_id", "account_name", "account_type", "data_set", "account_type_and_data_set", "dirty", BRPluginConfig.VERSION, "sourceid", "sync1", "sync2", "sync3", "sync4", "deleted", "is_user_profile", "data_id", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14", "data15", "data_sync1", "data_sync2", "data_sync3", "data_sync4", "data_version", "is_primary", "is_super_primary", "mimetype", "res_package", "group_sourceid", "mode", "chat_capability", AFConstants.EXTRA_STATUS, "status_res_package", "status_icon", "status_label", "status_ts", "photo_uri", "send_to_voicemail", "custom_ringtone", "title"};

        /* renamed from: b, reason: collision with root package name */
        public static String[] f13073b;

        static {
            f13073b = new String[]{"name_raw_contact_id", "display_name_source", "lookup", "display_name", "display_name_alt", "phonetic_name", "photo_id", "starred", "contact_presence", "contact_status", "contact_status_ts", "contact_status_res_package", "contact_status_label", "contact_id", "raw_contact_id", "account_name", "account_type", "data_set", "account_type_and_data_set", "dirty", BRPluginConfig.VERSION, "sourceid", "sync1", "sync2", "sync3", "sync4", "deleted", "is_user_profile", "data_id", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14", "data15", "data_sync1", "data_sync2", "data_sync3", "data_sync4", "data_version", "is_primary", "is_super_primary", "mimetype", "res_package", "group_sourceid", "mode", "chat_capability", AFConstants.EXTRA_STATUS, "status_res_package", "status_icon", "status_label", "status_ts", "photo_uri", "send_to_voicemail", "custom_ringtone", "title", com.customize.contacts.simcontacts.b.f21805a};
            if (com.customize.contacts.manager.h.g()) {
                String[] strArr = f13073b;
                String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
                f13073b = strArr2;
                strArr2[strArr2.length - 1] = "custom_vibration";
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f13074a = {"displayName", AFConstants.EXTRA_PACKAGE_NAME, "typeResourceId", "accountType", "accountName", "exportSupport"};
    }

    /* loaded from: classes.dex */
    public final class d extends AsyncTask<Void, Void, Result> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f13075a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContactLoader contactLoader = ContactLoader.this;
                contactLoader.f(contactLoader.f13011n);
                ContactLoader.this.f13014q.decrementAndGet();
            }
        }

        public d(boolean z10) {
            this.f13075a = z10;
        }

        public final void a(Cursor cursor, ContentValues contentValues, int i10) {
            int type = cursor.getType(i10);
            if (type != 0) {
                if (type != 1) {
                    if (type != 3) {
                        if (type != 4) {
                            H7.b.c("ContactLoader", "Invalid or unhandled data type");
                            return;
                        } else {
                            contentValues.put(b.f13073b[i10], cursor.getBlob(i10));
                            return;
                        }
                    }
                    contentValues.put(b.f13073b[i10], cursor.getString(i10));
                    return;
                }
                contentValues.put(b.f13073b[i10], Long.valueOf(cursor.getLong(i10)));
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Result doInBackground(Void... voidArr) {
            Result c10;
            boolean z10;
            try {
                H7.b.e("ContactLoader", "doInBackground: mLookupUri = " + H7.a.e(ContactLoader.this.f13010m) + ", mLoadTogether = " + this.f13075a);
                ContentResolver contentResolver = ContactLoader.this.i().getContentResolver();
                ContactLoader contactLoader = ContactLoader.this;
                contactLoader.f13009l = contactLoader.f13010m;
                Uri a10 = com.android.contacts.util.h.a(contentResolver, ContactLoader.this.f13010m);
                Result result = ContactLoader.f13006w;
                ContactLoader.f13006w = null;
                if (result != null && U7.g.a(result.L(), ContactLoader.this.f13010m)) {
                    c10 = new Result(result);
                    z10 = true;
                } else {
                    c10 = c(contentResolver, a10);
                    z10 = false;
                }
                if (c10.d0()) {
                    g(c10);
                    if (!TextUtils.isEmpty(c10.u())) {
                        c10.j0(com.customize.contacts.manager.i.g(ContactLoader.this.i(), c10.u()));
                    }
                }
                if (this.f13075a && !c10.e0()) {
                    if (c10.b0() && !z10) {
                        f(c10);
                    }
                    if (!z10) {
                        h(c10);
                    }
                    if (!TextUtils.isEmpty(c10.u()) && !Settings.System.DEFAULT_RINGTONE_URI.equals(c10.u())) {
                        c10.j0(com.customize.contacts.manager.i.g(ContactLoader.this.i(), c10.u()));
                    }
                    E0.a.g(new ArrayList(new HashSet(c10.P())), new INAFCApi.a() { // from class: com.android.contacts.i
                    });
                }
                if (ContactLoader.this.f13018u && C1641a.l(ContactLoader.this.i(), FeatureOption.o())) {
                    String d10 = C1641a.d(ContactLoader.this.i(), c10.P(), ContactLoader.this.f13019v);
                    if (!TextUtils.isEmpty(d10)) {
                        c10.l0(d10);
                        c10.h0(d10);
                        c10.m0(ContactLoader.this.f13019v);
                    }
                }
                return c10;
            } catch (Exception e10) {
                H7.b.c("ContactLoader", "Error loading the contact: " + H7.a.e(ContactLoader.this.f13010m) + e10);
                return Result.m(ContactLoader.this.f13009l, e10);
            }
        }

        public final Result c(ContentResolver contentResolver, Uri uri) {
            Cursor cursor;
            Entity entity = null;
            try {
                cursor = contentResolver.query(Uri.withAppendedPath(uri, "entities"), b.f13073b, null, null, "raw_contact_id");
            } catch (Exception e10) {
                H7.b.c("ContactLoader", "query cursor exception " + e10);
                cursor = null;
            }
            if (cursor == null) {
                H7.b.c("ContactLoader", "No cursor returned in loadContactEntity");
                return Result.n(ContactLoader.this.f13009l);
            }
            try {
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return Result.n(ContactLoader.this.f13009l);
                }
                Result d10 = d(cursor, uri);
                ArrayList<Entity> D10 = d10.D();
                HashMap<Long, com.android.contacts.util.n> X10 = d10.X();
                HashMap<String, String> t10 = d10.t();
                HashMap<Account, Long> Z9 = d10.Z();
                d10.P().clear();
                d10.f13035P.clear();
                long j10 = -1;
                while (!cursor.isAfterLast()) {
                    if ("vnd.android.cursor.item/phone_v2".equals(cursor.getString(51))) {
                        String string = cursor.getString(29);
                        String string2 = cursor.getString(34);
                        if (U7.f.b(string2)) {
                            t10.put(string, string2);
                        }
                        d10.k(string);
                        String string3 = cursor.getString(32);
                        if (!TextUtils.isEmpty(string3)) {
                            d10.f13035P.add(string3);
                        }
                    }
                    if ("vnd.android.cursor.item/business_card_photo".equals(cursor.getString(51))) {
                        d10.i0(cursor.getString(29));
                    }
                    if (C1643c.w() && "vnd.android.cursor.item/im".equals(cursor.getString(51)) && TextUtils.isEmpty(d10.Y())) {
                        String string4 = cursor.getString(29);
                        if (C1643c.t(string4)) {
                            d10.r0(string4);
                        }
                    }
                    long j11 = cursor.getLong(14);
                    if (j11 != j10) {
                        entity = new Entity(i(cursor));
                        D10.add(entity);
                        j10 = j11;
                    }
                    ContactLoader.this.k0(cursor, Z9);
                    if (!cursor.isNull(28)) {
                        entity.addSubValue(ContactsContract.Data.CONTENT_URI, e(cursor));
                        if (!cursor.isNull(54) || !cursor.isNull(56)) {
                            X10.put(Long.valueOf(cursor.getLong(28)), new com.android.contacts.util.n(cursor));
                        }
                    }
                    cursor.moveToNext();
                }
                d10.p0(ContactLoader.this.e0(contentResolver, d10.P(), t10));
                if (this.f13075a) {
                    if (Z9 == null || Z9.size() <= 0) {
                        d10.n0(BlackListUtils.d(ContactLoader.this.i(), d10.P()));
                    } else if (ContactLoader.this.f13017t) {
                        boolean k10 = BlackListUtils.k(ContactLoader.this.i(), d10.P());
                        ContactLoader.this.f13017t = false;
                        if (k10) {
                            Intent intent = new Intent("com.oplus.contacts.DETAIL_UPDATE_DONE");
                            intent.putExtra("vip_remove_blacklist_tips", true);
                            X.a.b(ContactLoader.this.i()).d(intent);
                        }
                    }
                }
                return d10;
            } finally {
                cursor.close();
            }
        }

        public final Result d(Cursor cursor, Uri uri) {
            long parseLong;
            boolean z10;
            Integer valueOf;
            boolean z11;
            boolean z12;
            Uri withAppendedId;
            int i10;
            String str;
            String queryParameter = uri.getQueryParameter("directory");
            if (queryParameter == null) {
                parseLong = 0;
            } else {
                parseLong = Long.parseLong(queryParameter);
            }
            long j10 = cursor.getLong(13);
            String string = cursor.getString(2);
            long j11 = cursor.getLong(0);
            int i11 = cursor.getInt(1);
            String string2 = cursor.getString(3);
            String string3 = cursor.getString(4);
            String string4 = cursor.getString(5);
            long j12 = cursor.getLong(6);
            String string5 = cursor.getString(61);
            if (cursor.getInt(7) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (cursor.isNull(8)) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(cursor.getInt(8));
            }
            if (cursor.getInt(62) == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            String string6 = cursor.getString(63);
            if (cursor.getInt(27) == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            String string7 = cursor.getString(cursor.getColumnIndex("account_name"));
            String string8 = cursor.getString(cursor.getColumnIndex("account_type"));
            if (parseLong != 0 && parseLong != 1) {
                withAppendedId = uri;
            } else {
                withAppendedId = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, string), j10);
            }
            int columnIndex = cursor.getColumnIndex(com.customize.contacts.simcontacts.b.f21805a);
            if (columnIndex >= 0) {
                i10 = cursor.getInt(columnIndex);
            } else {
                i10 = -1;
            }
            int i12 = i10;
            int columnIndex2 = cursor.getColumnIndex("custom_vibration");
            if (columnIndex2 >= 0) {
                str = cursor.getString(columnIndex2);
            } else {
                str = null;
            }
            return new Result(ContactLoader.this.f13009l, uri, withAppendedId, parseLong, string, j10, j11, i11, j12, string5, string2, string3, string4, z10, valueOf, z11, string6, z12, string7, string8, i12, str);
        }

        public final ContentValues e(Cursor cursor) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(BreenoCallContract.BaseColumns._ID, Long.valueOf(cursor.getLong(28)));
            a(cursor, contentValues, 29);
            a(cursor, contentValues, 30);
            a(cursor, contentValues, 31);
            a(cursor, contentValues, 32);
            a(cursor, contentValues, 33);
            a(cursor, contentValues, 34);
            a(cursor, contentValues, 35);
            a(cursor, contentValues, 36);
            a(cursor, contentValues, 37);
            a(cursor, contentValues, 38);
            a(cursor, contentValues, 39);
            a(cursor, contentValues, 40);
            a(cursor, contentValues, 41);
            a(cursor, contentValues, 42);
            a(cursor, contentValues, 43);
            a(cursor, contentValues, 44);
            a(cursor, contentValues, 45);
            a(cursor, contentValues, 46);
            a(cursor, contentValues, 47);
            a(cursor, contentValues, 48);
            a(cursor, contentValues, 49);
            a(cursor, contentValues, 50);
            a(cursor, contentValues, 51);
            a(cursor, contentValues, 52);
            a(cursor, contentValues, 53);
            a(cursor, contentValues, 55);
            return contentValues;
        }

        public final void f(Result result) {
            Cursor cursor;
            String str = null;
            try {
                cursor = ContactLoader.this.i().getContentResolver().query(ContentUris.withAppendedId(ContactsContract.Directory.CONTENT_URI, result.z()), c.f13074a, null, null, null);
            } catch (Exception e10) {
                H7.b.c("ContactLoader", "" + e10);
                cursor = null;
            }
            if (cursor == null) {
                return;
            }
            try {
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    int i10 = cursor.getInt(2);
                    String string3 = cursor.getString(3);
                    String string4 = cursor.getString(4);
                    int i11 = cursor.getInt(5);
                    if (!TextUtils.isEmpty(string2)) {
                        try {
                            str = ContactLoader.this.i().getPackageManager().getResourcesForApplication(string2).getString(i10);
                        } catch (PackageManager.NameNotFoundException unused) {
                            H7.b.i("ContactLoader", "Contact directory resource not found: " + string2 + "." + i10);
                        }
                    }
                    result.k0(string, str, string3, string4, i11);
                }
            } finally {
                cursor.close();
            }
        }

        public final void g(Result result) {
            HashSet hashSet = new HashSet();
            Iterator<Entity> it = result.D().iterator();
            while (it.hasNext()) {
                Iterator<Entity.NamedContentValues> it2 = it.next().getSubValues().iterator();
                while (it2.hasNext()) {
                    ContentValues contentValues = it2.next().values;
                    String asString = contentValues.getAsString("mimetype");
                    if (asString != null && "vnd.android.cursor.item/group_membership".equals(asString)) {
                        Long asLong = contentValues.getAsLong("data1");
                        asLong.longValue();
                        hashSet.add(asLong);
                    }
                }
            }
            if (hashSet.size() <= 0) {
                return;
            }
            Cursor e10 = G7.c.e(ContactLoader.this.i().getContentResolver(), ContactsContract.Groups.CONTENT_URI, N0.f13157x, N0.V(), null, null);
            if (e10 != null) {
                try {
                    e10.moveToPosition(-1);
                    while (e10.moveToNext()) {
                        long j10 = e10.getLong(3);
                        if (hashSet.contains(Long.valueOf(j10))) {
                            result.j(new M0(e10.getString(0), e10.getString(1), e10.getString(2), j10, e10.getString(4)));
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        public final void h(Result result) {
            String T10 = result.T();
            if (T10 != null) {
                try {
                    AssetFileDescriptor openAssetFileDescriptor = ContactLoader.this.i().getContentResolver().openAssetFileDescriptor(Uri.parse(T10), "r");
                    byte[] bArr = new byte[16384];
                    FileInputStream createInputStream = openAssetFileDescriptor.createInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = createInputStream.read(bArr);
                            if (read == -1) {
                                result.q0(byteArrayOutputStream.toByteArray());
                                createInputStream.close();
                                openAssetFileDescriptor.close();
                                return;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (Throwable th) {
                            createInputStream.close();
                            openAssetFileDescriptor.close();
                            throw th;
                        }
                    }
                } catch (IOException unused) {
                }
            }
            long S10 = result.S();
            if (S10 <= 0) {
                return;
            }
            Iterator<Entity> it = result.D().iterator();
            while (it.hasNext()) {
                Iterator<Entity.NamedContentValues> it2 = it.next().getSubValues().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        ContentValues contentValues = it2.next().values;
                        if (contentValues.getAsLong(BreenoCallContract.BaseColumns._ID).longValue() == S10) {
                            if ("vnd.android.cursor.item/photo".equals(contentValues.getAsString("mimetype"))) {
                                result.q0(contentValues.getAsByteArray("data15"));
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }

        public final ContentValues i(Cursor cursor) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(BreenoCallContract.BaseColumns._ID, Long.valueOf(cursor.getLong(14)));
            a(cursor, contentValues, 15);
            a(cursor, contentValues, 16);
            a(cursor, contentValues, 17);
            a(cursor, contentValues, 18);
            a(cursor, contentValues, 19);
            a(cursor, contentValues, 20);
            a(cursor, contentValues, 21);
            a(cursor, contentValues, 22);
            a(cursor, contentValues, 23);
            a(cursor, contentValues, 24);
            a(cursor, contentValues, 25);
            a(cursor, contentValues, 26);
            a(cursor, contentValues, 13);
            a(cursor, contentValues, 7);
            a(cursor, contentValues, 63);
            a(cursor, contentValues, 65);
            if (com.customize.contacts.manager.h.g()) {
                a(cursor, contentValues, 66);
            }
            return contentValues;
        }

        @Override // android.os.AsyncTask
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Result result) {
            if (this.f13075a) {
                ContactLoader.this.l0();
                if (!ContactLoader.this.f13013p && result != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    if (ContactLoader.this.f13011n != null && ContactLoader.this.f13011n.N() != null) {
                        hashMap.putAll(ContactLoader.this.f13011n.N());
                    }
                    ContactLoader.this.f13011n = result;
                    ContactLoader.this.f13011n.p0(hashMap);
                    if (result.d0()) {
                        ContactLoader.this.f13010m = result.L();
                        if (!result.b0()) {
                            H7.b.e("ContactLoader", "Registering content observer for " + ContactLoader.this.f13010m);
                            if (ContactLoader.this.f13012o == null) {
                                ContactLoader.this.f13012o = new c.a();
                            }
                            try {
                                ContactLoader.this.i().getContentResolver().registerContentObserver(ContactLoader.this.f13010m, true, ContactLoader.this.f13012o);
                                ContactLoader.this.i().getContentResolver().registerContentObserver(R0.d.f3220g, true, ContactLoader.this.f13012o);
                            } catch (Exception e10) {
                                H7.b.c("ContactLoader", "onPostExecute error " + e10);
                            }
                        }
                        if (ContactLoader.this.f13011n.R() == null && ContactLoader.this.f13011n.T() != null) {
                            ContactLoader.this.f13011n.o0(true);
                            new a().execute(ContactLoader.this.f13011n.T());
                        }
                        ContactLoader.this.j0();
                        ContactLoader.this.f13015r = true;
                    }
                    ContactLoader.this.f13008k.postDelayed(new a(), 150L);
                    return;
                }
                return;
            }
            if (!ContactLoader.this.f13013p && result != null) {
                ContactLoader.this.f13011n = result;
                new d(true).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, null);
                if (ContactLoader.this.f13011n != null) {
                    ContactLoader contactLoader = ContactLoader.this;
                    contactLoader.f(contactLoader.f13011n);
                }
            }
        }
    }

    public ContactLoader(Context context, Uri uri) {
        super(context);
        this.f13007j = com.google.common.collect.y.d();
        this.f13008k = new Handler(Looper.getMainLooper());
        this.f13014q = new AtomicInteger(1);
        this.f13017t = false;
        this.f13018u = false;
        this.f13019v = null;
        this.f13010m = uri;
        this.f13009l = uri;
        this.f13015r = false;
        this.f13016s = Executors.newSingleThreadExecutor();
        i0(false);
    }

    public static /* synthetic */ HashMap f0(ContentResolver contentResolver, ArrayList arrayList, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        try {
            HashMap<String, String> k10 = LocationUtils.k(contentResolver, arrayList, hashMap);
            if (k10.size() > 0) {
                hashMap2.putAll(k10);
            }
        } catch (Exception e10) {
            H7.b.c("ContactLoader", "getPhoneLocationsForTime :e =  " + e10);
        }
        return hashMap2;
    }

    public void c0() {
        Result result = this.f13011n;
        if (result != null && result.d0()) {
            f13006w = this.f13011n;
        } else {
            f13006w = null;
        }
    }

    public Uri d0() {
        return this.f13010m;
    }

    public final HashMap<String, String> e0(final ContentResolver contentResolver, final ArrayList<String> arrayList, final HashMap<String, String> hashMap) {
        if (H7.a.b()) {
            H7.b.b("ContactLoader", "getPhoneLocationsForTime begin.");
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        try {
            try {
                try {
                    try {
                        hashMap2.putAll((Map) newFixedThreadPool.submit(new Callable() { // from class: com.android.contacts.e
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                HashMap f02;
                                f02 = ContactLoader.f0(contentResolver, arrayList, hashMap);
                                return f02;
                            }
                        }).get(200L, TimeUnit.MILLISECONDS));
                    } catch (TimeoutException unused) {
                        H7.b.c("ContactLoader", "getPhoneLocationsForTime is time out.");
                        m0(contentResolver, arrayList, hashMap);
                    }
                } catch (InterruptedException unused2) {
                    H7.b.c("ContactLoader", "getPhoneLocationsForTime is interrupted.");
                    m0(contentResolver, arrayList, hashMap);
                }
            } catch (Exception unused3) {
                H7.b.c("ContactLoader", "getPhoneLocationsForTime has an error.");
                m0(contentResolver, arrayList, hashMap);
            }
            if (H7.a.b()) {
                H7.b.b("ContactLoader", "getPhoneLocationsForTime end. ");
            }
            return hashMap2;
        } finally {
            newFixedThreadPool.shutdown();
        }
    }

    public final /* synthetic */ void g0(HashMap hashMap) {
        if (this.f13011n != null && hashMap.size() > 0) {
            this.f13011n.p0(hashMap);
            f(this.f13011n);
        }
    }

    public final /* synthetic */ void h0(ContentResolver contentResolver, ArrayList arrayList, HashMap hashMap) {
        final HashMap<String, String> k10 = LocationUtils.k(contentResolver, arrayList, hashMap);
        if (this.f13011n != null) {
            this.f13008k.post(new Runnable() { // from class: com.android.contacts.g
                @Override // java.lang.Runnable
                public final void run() {
                    ContactLoader.this.g0(k10);
                }
            });
        }
    }

    public final void i0(boolean z10) {
        if (this.f13014q.get() > 2) {
            return;
        }
        this.f13014q.incrementAndGet();
        new d(z10).executeOnExecutor(this.f13016s, null);
    }

    public final void j0() {
        Context i10 = i();
        Iterator<Entity> it = this.f13011n.D().iterator();
        while (it.hasNext()) {
            ContentValues entityValues = it.next().getEntityValues();
            Long asLong = entityValues.getAsLong(BreenoCallContract.BaseColumns._ID);
            long longValue = asLong.longValue();
            if (!this.f13007j.contains(asLong)) {
                this.f13007j.add(asLong);
                AccountType c10 = AbstractC1362a.h(i10).c(entityValues.getAsString("account_type"), entityValues.getAsString("data_set"));
                String m10 = c10.m();
                String str = c10.f16946c;
                if (!TextUtils.isEmpty(m10) && !TextUtils.isEmpty(str)) {
                    Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, longValue);
                    Intent intent = new Intent();
                    intent.setClassName(str, m10);
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(withAppendedId, "vnd.android.cursor.item/raw_contact");
                    try {
                        i10.startService(intent);
                    } catch (Exception e10) {
                        H7.b.c("ContactLoader", "Error sending message to source-app" + e10);
                    }
                }
            }
        }
    }

    public final void k0(Cursor cursor, HashMap<Account, Long> hashMap) {
        if (cursor != null && hashMap != null && "vnd.android.cursor.item/group_membership".equals(cursor.getString(51))) {
            long j10 = cursor.getLong(29);
            if ("Vip in ColorOS".equals(cursor.getString(64))) {
                hashMap.put(new Account(cursor.getString(15), cursor.getString(16)), Long.valueOf(j10));
            }
        }
    }

    public final void l0() {
        if (this.f13012o != null) {
            try {
                i().getContentResolver().unregisterContentObserver(this.f13012o);
                this.f13012o = null;
            } catch (Exception e10) {
                H7.b.c("ContactLoader", "" + e10);
            }
        }
    }

    public final void m0(final ContentResolver contentResolver, final ArrayList<String> arrayList, final HashMap<String, String> hashMap) {
        N7.a.b().execute(new Runnable() { // from class: com.android.contacts.f
            @Override // java.lang.Runnable
            public final void run() {
                ContactLoader.this.h0(contentResolver, arrayList, hashMap);
            }
        });
    }

    @Override // W.c
    public void q() {
        if (this.f13015r) {
            i0(true);
        }
        this.f13015r = true;
        this.f13017t = true;
    }

    @Override // W.c
    public void r() {
        l0();
        this.f13011n = null;
        this.f13013p = true;
    }

    @Override // W.c
    public void s() {
        Result result = this.f13011n;
        if (result != null) {
            f(result);
        }
        if (A() || this.f13011n == null) {
            h();
        }
    }

    public ContactLoader(Context context, Uri uri, boolean z10) {
        super(context);
        this.f13007j = com.google.common.collect.y.d();
        this.f13008k = new Handler(Looper.getMainLooper());
        this.f13014q = new AtomicInteger(1);
        this.f13017t = false;
        this.f13018u = false;
        this.f13019v = null;
        this.f13010m = uri;
        this.f13009l = uri;
        this.f13015r = false;
        this.f13016s = Executors.newSingleThreadExecutor();
        i0(z10);
    }

    public ContactLoader(Context context, Uri uri, boolean z10, boolean z11, String str) {
        this(context, uri, z10);
        this.f13018u = z11;
        this.f13019v = str;
    }
}
