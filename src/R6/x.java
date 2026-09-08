package r6;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusNumberMarkUtils;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0847h;
import com.oplus.utils.C0856q;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

/* compiled from: Conversation.java */
/* loaded from: classes3.dex */
public class x {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f36497m;

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f36498n = {"*", "us-ascii", "iso-8859-1", "iso-8859-2", "iso-8859-3", "iso-8859-4", "iso-8859-5", "iso-8859-6", "iso-8859-7", "iso-8859-8", "iso-8859-9", "shift_JIS", "utf-8", "big5", "iso-10646-ucs-2", "utf-16"};

    /* renamed from: o, reason: collision with root package name */
    public static final HashMap<Integer, String> f36499o = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public long f36500a;

    /* renamed from: b, reason: collision with root package name */
    public String f36501b;

    /* renamed from: c, reason: collision with root package name */
    public long f36502c;

    /* renamed from: d, reason: collision with root package name */
    public String f36503d;

    /* renamed from: e, reason: collision with root package name */
    public int f36504e;

    /* renamed from: f, reason: collision with root package name */
    public int f36505f;

    /* renamed from: g, reason: collision with root package name */
    public String f36506g;

    /* renamed from: h, reason: collision with root package name */
    public SpannableStringBuilder f36507h;

    /* renamed from: i, reason: collision with root package name */
    public String f36508i;

    /* renamed from: j, reason: collision with root package name */
    public String f36509j;

    /* renamed from: k, reason: collision with root package name */
    public String f36510k;

    /* renamed from: l, reason: collision with root package name */
    public String f36511l;

    /* compiled from: Conversation.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f36512a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f36513b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f36514c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f36515d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f36516e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f36517f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f36518g = -1;

        /* renamed from: h, reason: collision with root package name */
        public int f36519h = -1;

        /* renamed from: i, reason: collision with root package name */
        public int f36520i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f36521j = -1;

        public void a(Cursor cursor) {
            this.f36512a = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
            this.f36514c = cursor.getColumnIndex(BreenoCallContract.BaseColumns.DATE);
            this.f36513b = cursor.getColumnIndex(C0847h.c.f29152b);
            this.f36515d = cursor.getColumnIndex(C0847h.c.f29151a);
            this.f36516e = cursor.getColumnIndex(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE);
            this.f36518g = cursor.getColumnIndex("service_name");
            this.f36519h = cursor.getColumnIndex("service_number");
            this.f36520i = cursor.getColumnIndex("service_logo");
            this.f36521j = cursor.getColumnIndex("attachment_type");
            this.f36517f = cursor.getColumnIndex("ted_service_id");
        }
    }

    static {
        int[] iArr = {0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 17, 106, 2026, 1000, 1015};
        f36497m = iArr;
        int length = iArr.length - 1;
        for (int i10 = 0; i10 <= length; i10++) {
            f36499o.put(Integer.valueOf(f36497m[i10]), f36498n[i10]);
        }
    }

    public static String a(Cursor cursor) {
        int i10;
        int columnIndex = cursor.getColumnIndex("snippet");
        int columnIndex2 = cursor.getColumnIndex("snippet_cs");
        String string = cursor.getString(columnIndex);
        if (columnIndex2 >= 0) {
            i10 = cursor.getInt(columnIndex2);
        } else {
            i10 = 0;
        }
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (i10 == 0) {
            return string;
        }
        byte[] d10 = d(string);
        byte[] bArr = new byte[d10.length];
        System.arraycopy(d10, 0, bArr, 0, d10.length);
        return t(i10, bArr);
    }

    public static x b(Context context, Cursor cursor, a aVar) {
        x xVar = new x();
        xVar.f36500a = cursor.getLong(aVar.f36512a);
        xVar.f36502c = cursor.getLong(aVar.f36514c);
        xVar.f36501b = cursor.getString(aVar.f36513b);
        xVar.f36504e = cursor.getInt(aVar.f36515d);
        xVar.f36505f = cursor.getInt(aVar.f36516e);
        xVar.f36503d = a(cursor);
        xVar.f36508i = cursor.getString(aVar.f36518g);
        xVar.f36509j = cursor.getString(aVar.f36519h);
        xVar.f36510k = cursor.getString(aVar.f36520i);
        xVar.f36506g = c(context, xVar.f36502c);
        int i10 = cursor.getInt(aVar.f36521j);
        if (C0846g.c()) {
            Log.d("Blacklist/Conversation", "attachType = " + i10 + " ,conv.mBlockType = " + xVar.f36505f);
        }
        if (TextUtils.isEmpty(xVar.f36503d)) {
            xVar.f36503d = s(context, i10);
        }
        xVar.f36507h = r(context, xVar.f36505f, C0856q.g(context, xVar.f36503d));
        int i11 = aVar.f36517f;
        if (i11 != -1) {
            xVar.f36511l = cursor.getString(i11);
        }
        return xVar;
    }

    public static String c(Context context, long j10) {
        if (y(j10)) {
            return u(context, j10);
        }
        if (z(j10)) {
            return context.getResources().getString(com.oplus.blacklistapp.u.f27704v3);
        }
        return e(context, j10);
    }

    public static byte[] d(String str) {
        try {
            return str.getBytes("iso-8859-1");
        } catch (UnsupportedEncodingException e10) {
            Log.e("Blacklist/Conversation", "ISO_8859_1 must be supported!", e10);
            return new byte[0];
        }
    }

    public static String e(Context context, long j10) {
        Date g10 = g(j10);
        if (g10 != null) {
            return f(g10);
        }
        return "";
    }

    public static String f(Date date) {
        return DateFormat.getDateInstance(3).format(date);
    }

    public static Date g(long j10) {
        try {
            return new Date(j10);
        } catch (Exception unused) {
            Log.e("Blacklist/Conversation", "Format date error, time:" + j10);
            return null;
        }
    }

    public static String j(int i10) {
        String str = f36499o.get(Integer.valueOf(i10));
        if (str != null) {
            return str;
        }
        Log.e("CharacterSets", "Unsupported charset code is " + i10);
        throw new UnsupportedEncodingException();
    }

    public static String k(Context context, int i10) {
        String string;
        int i11 = i10 - 100;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 != 5) {
                            if (i11 != 8) {
                                if (i11 != 9) {
                                    if (i11 != 1001) {
                                        string = "";
                                    } else {
                                        string = context.getString(com.oplus.blacklistapp.u.f27525I1);
                                    }
                                } else {
                                    string = context.getString(com.oplus.blacklistapp.u.f27517G1);
                                }
                            } else {
                                string = context.getString(com.oplus.blacklistapp.u.f27541M1);
                            }
                        } else {
                            string = context.getString(com.oplus.blacklistapp.u.f27529J1);
                        }
                    } else {
                        string = context.getString(com.oplus.blacklistapp.u.f27537L1);
                    }
                } else {
                    string = context.getString(com.oplus.blacklistapp.u.f27545N1);
                }
            } else {
                string = context.getString(com.oplus.blacklistapp.u.f27521H1);
            }
        } else {
            string = context.getString(com.oplus.blacklistapp.u.f27533K1);
        }
        if (!TextUtils.isEmpty(string)) {
            return x(string);
        }
        return string;
    }

    public static SpannableStringBuilder r(Context context, int i10, String str) {
        String string;
        if (i10 != 23) {
            switch (i10) {
                case 11:
                    string = context.getString(com.oplus.blacklistapp.u.f27676q0);
                    break;
                case 12:
                case 13:
                case 15:
                    string = context.getString(com.oplus.blacklistapp.u.f27666o0);
                    break;
                case 14:
                    string = context.getString(com.oplus.blacklistapp.u.f27661n0);
                    break;
                case 16:
                    string = context.getString(com.oplus.blacklistapp.u.f27656m0);
                    break;
                case 17:
                    string = context.getString(com.oplus.blacklistapp.u.f27513F1);
                    break;
                case 18:
                    string = context.getString(com.oplus.blacklistapp.u.f27627g1);
                    break;
                case 19:
                    string = context.getString(com.oplus.blacklistapp.u.f27635i);
                    break;
                case 20:
                    string = context.getString(com.oplus.blacklistapp.u.f27697u1);
                    break;
                default:
                    string = "";
                    break;
            }
        } else {
            string = context.getString(com.oplus.blacklistapp.u.f27671p0);
        }
        if (!TextUtils.isEmpty(string)) {
            string = x(string);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((CharSequence) string) + str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getColor(com.oplus.blacklistapp.m.f27273a)), 0, string.length(), 33);
        return spannableStringBuilder;
    }

    public static String s(Context context, int i10) {
        if (i10 >= 100) {
            return k(context, i10);
        }
        String string = context.getString(com.oplus.blacklistapp.u.f27549O1);
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 == 5) {
                            return x(context.getString(com.oplus.blacklistapp.u.f27720z));
                        }
                        return string;
                    }
                    return x(context.getString(com.oplus.blacklistapp.u.f27715y));
                }
                return x(context.getString(com.oplus.blacklistapp.u.f27705w));
            }
            return x(context.getString(com.oplus.blacklistapp.u.f27491A));
        }
        return x(context.getString(com.oplus.blacklistapp.u.f27710x));
    }

    public static String t(int i10, byte[] bArr) {
        if (i10 == 0) {
            return new String(bArr);
        }
        try {
            try {
                return new String(bArr, j(i10));
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr, "iso-8859-1");
            }
        } catch (UnsupportedEncodingException unused2) {
            return new String(bArr);
        }
    }

    public static String u(Context context, long j10) {
        Date g10 = g(j10);
        if (g10 != null) {
            return v(g10);
        }
        return "";
    }

    public static String v(Date date) {
        return DateFormat.getTimeInstance(3).format(date);
    }

    public static String x(CharSequence charSequence) {
        return "[" + charSequence + "]";
    }

    public static boolean y(long j10) {
        Time time = new Time();
        time.set(j10);
        Time time2 = new Time();
        time2.setToNow();
        if (time.year == time2.year && time.yearDay == time2.yearDay) {
            return true;
        }
        return false;
    }

    public static boolean z(long j10) {
        Time time = new Time();
        time.set(j10);
        Time time2 = new Time();
        time2.setToNow();
        int i10 = time.year;
        int i11 = time2.year;
        if ((i10 == i11 && time2.yearDay - time.yearDay == 1) || (i11 - i10 == 1 && time.month == 11 && time.monthDay == 31 && time2.month == 0 && time2.monthDay == 1)) {
            return true;
        }
        return false;
    }

    public String h() {
        return this.f36506g;
    }

    public SpannableStringBuilder i() {
        return this.f36507h;
    }

    public String l() {
        return this.f36501b;
    }

    public String m() {
        return this.f36511l;
    }

    public String n() {
        return this.f36510k;
    }

    public String o() {
        return this.f36508i;
    }

    public String p() {
        return this.f36509j;
    }

    public String q() {
        return this.f36503d;
    }

    public int w() {
        return this.f36504e;
    }
}
