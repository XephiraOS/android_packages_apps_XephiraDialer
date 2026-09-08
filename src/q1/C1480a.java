package q1;

import C7.e;
import H7.b;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.model.Account;
import com.android.contacts.statistics.InputFieldUploadStatus;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.h0;
import java.util.HashMap;

/* compiled from: EditorStatistics.java */
/* renamed from: q1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1480a {
    public static void a(Context context, Account account) {
        String f10 = f(account);
        if (!TextUtils.isEmpty(f10)) {
            h0.G(context, f10);
        }
    }

    public static void b(Context context, Account account) {
        String f10 = f(account);
        if (!TextUtils.isEmpty(f10)) {
            h0.H(context, f10);
        }
    }

    public static void c(Context context, boolean z10, String str) {
        String str2;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1569536764:
                if (str.equals("vnd.android.cursor.item/email_v2")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1328682538:
                if (str.equals("vnd.android.cursor.item/contact_event")) {
                    c10 = 1;
                    break;
                }
                break;
            case -601229436:
                if (str.equals("vnd.android.cursor.item/postal-address_v2")) {
                    c10 = 2;
                    break;
                }
                break;
            case 684173810:
                if (str.equals("vnd.android.cursor.item/phone_v2")) {
                    c10 = 3;
                    break;
                }
                break;
            case 950831081:
                if (str.equals("vnd.android.cursor.item/im")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1409846529:
                if (str.equals("vnd.android.cursor.item/relation")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                str2 = "email";
                break;
            case 1:
                str2 = BreenoCallContract.BaseColumns.DATE;
                break;
            case 2:
                str2 = "address";
                break;
            case 3:
                str2 = "number";
                break;
            case 4:
                str2 = "instant_message";
                break;
            case 5:
                str2 = "affiliated_person";
                break;
            default:
                str2 = "";
                break;
        }
        h0.N(context, z10, str2);
    }

    public static void d(Context context, boolean z10, String str) {
        String str2;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1569536764:
                if (str.equals("vnd.android.cursor.item/email_v2")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1328682538:
                if (str.equals("vnd.android.cursor.item/contact_event")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1079210633:
                if (str.equals("vnd.android.cursor.item/note")) {
                    c10 = 2;
                    break;
                }
                break;
            case -601229436:
                if (str.equals("vnd.android.cursor.item/postal-address_v2")) {
                    c10 = 3;
                    break;
                }
                break;
            case 456415478:
                if (str.equals("vnd.android.cursor.item/website")) {
                    c10 = 4;
                    break;
                }
                break;
            case 684173810:
                if (str.equals("vnd.android.cursor.item/phone_v2")) {
                    c10 = 5;
                    break;
                }
                break;
            case 950831081:
                if (str.equals("vnd.android.cursor.item/im")) {
                    c10 = 6;
                    break;
                }
                break;
            case 1409846529:
                if (str.equals("vnd.android.cursor.item/relation")) {
                    c10 = 7;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                str2 = "email";
                break;
            case 1:
                str2 = BreenoCallContract.BaseColumns.DATE;
                break;
            case 2:
                str2 = "note";
                break;
            case 3:
                str2 = "address";
                break;
            case 4:
                str2 = "website";
                break;
            case 5:
                str2 = "number";
                break;
            case 6:
                str2 = "instant_message";
                break;
            case 7:
                str2 = "affiliated_person";
                break;
            default:
                str2 = "";
                break;
        }
        if (!TextUtils.isEmpty(str2)) {
            h0.K(context, z10, str2);
        }
    }

    public static void e(Context context, boolean z10, InputFieldUploadStatus inputFieldUploadStatus, String str, String str2) {
        str2.hashCode();
        char c10 = 65535;
        switch (str2.hashCode()) {
            case -1569536764:
                if (str2.equals("vnd.android.cursor.item/email_v2")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1328682538:
                if (str2.equals("vnd.android.cursor.item/contact_event")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1079224304:
                if (str2.equals("vnd.android.cursor.item/name")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1079210633:
                if (str2.equals("vnd.android.cursor.item/note")) {
                    c10 = 3;
                    break;
                }
                break;
            case -994507090:
                if (str2.equals("#phoneticName")) {
                    c10 = 4;
                    break;
                }
                break;
            case -601229436:
                if (str2.equals("vnd.android.cursor.item/postal-address_v2")) {
                    c10 = 5;
                    break;
                }
                break;
            case 456415478:
                if (str2.equals("vnd.android.cursor.item/website")) {
                    c10 = 6;
                    break;
                }
                break;
            case 684173810:
                if (str2.equals("vnd.android.cursor.item/phone_v2")) {
                    c10 = 7;
                    break;
                }
                break;
            case 689862072:
                if (str2.equals("vnd.android.cursor.item/organization")) {
                    c10 = '\b';
                    break;
                }
                break;
            case 950831081:
                if (str2.equals("vnd.android.cursor.item/im")) {
                    c10 = '\t';
                    break;
                }
                break;
            case 1409846529:
                if (str2.equals("vnd.android.cursor.item/relation")) {
                    c10 = '\n';
                    break;
                }
                break;
            case 1937076842:
                if (str2.equals("#displayName")) {
                    c10 = 11;
                    break;
                }
                break;
            case 2034973555:
                if (str2.equals("vnd.android.cursor.item/nickname")) {
                    c10 = '\f';
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                if (inputFieldUploadStatus.i()) {
                    h0.L(context, z10, "email");
                    inputFieldUploadStatus.N(false);
                    return;
                }
                return;
            case 1:
                if (inputFieldUploadStatus.h()) {
                    h0.L(context, z10, BreenoCallContract.BaseColumns.DATE);
                    inputFieldUploadStatus.M(false);
                    return;
                }
                return;
            case 2:
            case 4:
            case 11:
                if ("data1".equals(str)) {
                    if (inputFieldUploadStatus.A()) {
                        h0.L(context, z10, "name");
                        inputFieldUploadStatus.n0(false);
                        return;
                    }
                    return;
                }
                if ("data4".equals(str)) {
                    if (inputFieldUploadStatus.x()) {
                        h0.L(context, z10, "name_prefix");
                        inputFieldUploadStatus.k0(false);
                        return;
                    }
                    return;
                }
                if ("data3".equals(str)) {
                    if (inputFieldUploadStatus.q()) {
                        h0.L(context, z10, "last_name");
                        inputFieldUploadStatus.b0(false);
                        return;
                    }
                    return;
                }
                if ("data5".equals(str)) {
                    if (inputFieldUploadStatus.v()) {
                        h0.L(context, z10, "middle_name");
                        inputFieldUploadStatus.e0(false);
                        return;
                    }
                    return;
                }
                if ("data2".equals(str)) {
                    if (inputFieldUploadStatus.k()) {
                        h0.L(context, z10, "first_name");
                        inputFieldUploadStatus.Q(false);
                        return;
                    }
                    return;
                }
                if ("data6".equals(str)) {
                    if (inputFieldUploadStatus.z()) {
                        h0.L(context, z10, "name_suffix");
                        inputFieldUploadStatus.l0(false);
                        return;
                    }
                    return;
                }
                if ("#phoneticName".equals(str)) {
                    if (inputFieldUploadStatus.w()) {
                        h0.L(context, z10, "name_pinyin");
                        inputFieldUploadStatus.i0(false);
                        return;
                    }
                    return;
                }
                if ("data9".equals(str)) {
                    if (inputFieldUploadStatus.p()) {
                        h0.L(context, z10, "last_name_pinyin");
                        inputFieldUploadStatus.Y(false);
                        return;
                    }
                    return;
                }
                if ("data8".equals(str)) {
                    if (inputFieldUploadStatus.t()) {
                        h0.L(context, z10, "middle_name_pinyin");
                        inputFieldUploadStatus.d0(false);
                        return;
                    }
                    return;
                }
                if ("data7".equals(str) && inputFieldUploadStatus.j()) {
                    h0.L(context, z10, "first_name_pinyin");
                    inputFieldUploadStatus.P(false);
                    return;
                }
                return;
            case 3:
                if (inputFieldUploadStatus.D()) {
                    h0.L(context, z10, "note");
                    inputFieldUploadStatus.q0(false);
                    return;
                }
                return;
            case 5:
                if (inputFieldUploadStatus.b()) {
                    h0.L(context, z10, "address");
                    inputFieldUploadStatus.H(false);
                    return;
                }
                return;
            case 6:
                if (inputFieldUploadStatus.F()) {
                    h0.L(context, z10, "website");
                    inputFieldUploadStatus.s0(false);
                    return;
                }
                return;
            case 7:
                if (inputFieldUploadStatus.E()) {
                    h0.L(context, z10, "number");
                    inputFieldUploadStatus.r0(false);
                    return;
                }
                return;
            case '\b':
                if ("data1".equals(str)) {
                    if (inputFieldUploadStatus.f()) {
                        h0.L(context, z10, "company");
                        inputFieldUploadStatus.K(false);
                        return;
                    }
                    return;
                }
                if ("data4".equals(str) && inputFieldUploadStatus.n()) {
                    h0.L(context, z10, "job");
                    inputFieldUploadStatus.W(false);
                    return;
                }
                return;
            case '\t':
                if (inputFieldUploadStatus.m()) {
                    h0.L(context, z10, "instant_message");
                    inputFieldUploadStatus.R(false);
                    return;
                }
                return;
            case '\n':
                if (inputFieldUploadStatus.d()) {
                    h0.L(context, z10, "affiliated_person");
                    inputFieldUploadStatus.J(false);
                    return;
                }
                return;
            case '\f':
                if (inputFieldUploadStatus.C()) {
                    h0.L(context, z10, "nickname");
                    inputFieldUploadStatus.p0(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static String f(Account account) {
        if (TextUtils.equals("com.android.oplus.sim", account.f16942b)) {
            if (b0.O() == 1) {
                return "sim";
            }
            if (TextUtils.equals("SIM1", account.f16941a)) {
                return "sim1";
            }
            if (TextUtils.equals("SIM2", account.f16941a)) {
                return "sim2";
            }
            return "";
        }
        if (TextUtils.equals(R0.a.f3166b, account.f16942b)) {
            return "phone";
        }
        return "internet_account";
    }

    public static void g(Context context, int i10, int i11, int i12) {
        HashMap hashMap = new HashMap();
        hashMap.put("contact_editor_type", Integer.valueOf(i10));
        hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(i11));
        hashMap.put("account_count", Integer.valueOf(i12));
        A.a(context, 2000310, 200030073, hashMap, false);
    }

    public static void h(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (e.c(intent, "scan_qrcode", false)) {
                    A.a(context, 2000324, 200032404, null, false);
                }
            } catch (Exception e10) {
                b.c("EditorStatistics", e10.toString());
            }
        }
    }
}
