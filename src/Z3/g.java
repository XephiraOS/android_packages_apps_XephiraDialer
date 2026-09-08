package Z3;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.android.contacts.editor.RawContactEditorView;
import com.android.contacts.model.Account;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.calendar.COUIDateMonthView;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import n1.AbstractC1362a;

/* compiled from: CustomizeFormater.java */
/* loaded from: classes3.dex */
public class g {

    /* compiled from: CustomizeFormater.java */
    /* loaded from: classes3.dex */
    public static final class a extends ArrayAdapter<b> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f5923a;

        public a(Context context, int i10, List<b> list) {
            super(context, i10, list);
            this.f5923a = context;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) this.f5923a.getSystemService("layout_inflater")).inflate(R.layout.item_textview_insert_resolver, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            TextView textView2 = (TextView) view.findViewById(android.R.id.text2);
            TextView textView3 = (TextView) view.findViewById(R.id.text3);
            b bVar = (b) getItem(i10);
            String str = bVar.f5924a;
            if (str != null) {
                textView.setText(str);
            }
            if (bVar.f5926c) {
                textView2.setVisibility(0);
                textView2.setText(bVar.a(this.f5923a));
            } else {
                textView2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bVar.f5925b)) {
                textView3.setVisibility(0);
                textView3.setText(bVar.f5925b);
            } else {
                textView3.setVisibility(8);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            return true;
        }
    }

    /* compiled from: CustomizeFormater.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f5924a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f5925b = null;

        /* renamed from: c, reason: collision with root package name */
        public boolean f5926c = true;

        /* renamed from: d, reason: collision with root package name */
        public int f5927d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f5928e = -1;

        /* renamed from: f, reason: collision with root package name */
        public Account f5929f;

        public String a(Context context) {
            int i10 = this.f5928e;
            if (-1 == i10) {
                return "";
            }
            return g.d(context, i10, this.f5927d);
        }
    }

    /* compiled from: CustomizeFormater.java */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public int f5930a;

        /* renamed from: b, reason: collision with root package name */
        public int f5931b;

        /* renamed from: c, reason: collision with root package name */
        public int f5932c;

        public c(int i10, int i11, int i12) {
            this.f5930a = i10;
            this.f5931b = i11;
            this.f5932c = i12;
        }

        public static String a(int i10, int i11, int i12) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i10);
            stringBuffer.append("-");
            stringBuffer.append(i11);
            stringBuffer.append("-");
            stringBuffer.append(i12);
            return stringBuffer.toString();
        }

        public static String b(int i10, int i11, int i12, boolean z10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i10);
            if (i11 <= 9) {
                stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                stringBuffer.append(i11);
            } else {
                stringBuffer.append(i11);
            }
            if (i12 <= 9) {
                stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                stringBuffer.append(i12);
            } else {
                stringBuffer.append(i12);
            }
            if (z10) {
                stringBuffer.append(0);
            } else {
                stringBuffer.append(1);
            }
            return stringBuffer.toString();
        }

        public static String c(int i10, int i11, int i12) {
            return F7.a.a(i10, i11, i12);
        }

        public static c d(String str) {
            if (TextUtils.isEmpty(str)) {
                return f();
            }
            if (str.contains("-")) {
                return j(str);
            }
            return i(str);
        }

        public static c f() {
            Calendar calendar = Calendar.getInstance();
            return new c(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        }

        public static c i(String str) {
            if (str.length() >= 8) {
                String substring = str.substring(0, 4);
                String substring2 = str.substring(4, 6);
                String substring3 = str.substring(6, 8);
                if (H7.a.b()) {
                    H7.b.b("CustomizeFormater", "praseDateWithNoSplit(), year = " + substring + " , month = " + substring2 + ", day = " + substring3);
                }
                if (g.e(substring) && g.e(substring2) && g.e(substring3)) {
                    return new c(Integer.parseInt(substring), Integer.parseInt(substring2), Integer.parseInt(substring3));
                }
                return f();
            }
            return f();
        }

        public static c j(String str) {
            if (H7.a.b()) {
                H7.b.b("CustomizeFormater", "praseDateWithSplit(), dateString = " + str);
            }
            String[] split = str.split("-");
            if (split.length >= 3) {
                String str2 = split[0];
                String str3 = split[1];
                String str4 = split[2];
                if (H7.a.b()) {
                    H7.b.b("CustomizeFormater", "praseDateWithSplit(), year = " + str2 + ", month = " + str3 + " , day = " + str4);
                }
                if (g.e(str2) && g.e(str3) && g.e(str4)) {
                    return new c(Integer.parseInt(str2), Integer.parseInt(str3), Integer.parseInt(str4));
                }
                if (g.e(str2) && g.g(str3) != null && g.f(str4) != null) {
                    return new c(Integer.parseInt(str2), g.g(str3).intValue(), g.f(str4).intValue());
                }
                return f();
            }
            Calendar q10 = F7.b.q(str, false);
            if (q10 == null) {
                if (split.length >= 2 && g.g(split[0]) != null && g.f(split[1]) != null) {
                    return new c(Calendar.getInstance().get(1), g.g(split[0]).intValue(), g.f(split[1]).intValue());
                }
                return f();
            }
            if (F7.b.p(q10)) {
                return new c(q10.get(1), q10.get(2) + 1, q10.get(5));
            }
            return new c(Calendar.getInstance().get(1), q10.get(2) + 1, q10.get(5));
        }

        public int e() {
            return this.f5932c;
        }

        public int g() {
            return this.f5931b;
        }

        public int h() {
            return this.f5930a;
        }

        public void k(int i10) {
            this.f5932c = i10;
        }

        public void l(int i10) {
            this.f5931b = i10;
        }

        public void m(int i10) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = COUIDateMonthView.MIN_YEAR;
            }
            this.f5930a = i10;
        }

        public String toString() {
            return a(this.f5930a, this.f5931b, this.f5932c);
        }
    }

    public static String c(Context context, int i10) {
        if (i10 <= 0) {
            return context.getString(R.string.group_no_member);
        }
        return String.format(context.getResources().getQuantityText(R.plurals.group_member_count_tips, i10).toString(), Integer.valueOf(i10));
    }

    public static String d(Context context, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        if (-1 == i11) {
            stringBuffer.append(i10);
        } else {
            stringBuffer.append(i10);
            stringBuffer.append("/");
            stringBuffer.append(i11);
        }
        return stringBuffer.toString();
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isDigit(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static Integer f(String str) {
        return RawContactEditorView.getLunarDaysMap().get(str);
    }

    public static Integer g(String str) {
        return RawContactEditorView.getLunarMonthsMap().get(str);
    }

    public static void h(Context context, ArrayList<Account> arrayList, List<b> list) {
        String str;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        AbstractC1362a h10 = AbstractC1362a.h(context);
        for (int i10 = 0; i10 != size; i10++) {
            Account account = arrayList.get(i10);
            b bVar = new b();
            bVar.f5929f = account;
            if (M3.c.s(account)) {
                bVar.f5926c = true;
                str = context.getString(R.string.contact_editor_account_storage_phone);
                bVar.f5928e = M3.c.k(context, account);
                bVar.f5927d = -1;
            } else if (M3.c.t(account)) {
                bVar.f5926c = true;
                str = M3.c.c(context, account, 0, false);
                bVar.f5928e = b0.H(context, account.f16941a);
                bVar.f5927d = b0.N(context, account.f16941a);
            } else if (M3.c.p(context, account)) {
                bVar.f5926c = true;
                str = account.f16941a;
                bVar.f5928e = M3.c.k(context, account);
                bVar.f5927d = -1;
            } else {
                bVar.f5926c = true;
                str = (String) h10.c(account.f16942b, null).f(context);
                bVar.f5925b = account.f16941a;
                bVar.f5928e = M3.c.k(context, account);
                bVar.f5927d = -1;
            }
            bVar.f5924a = str;
            list.add(bVar);
        }
    }
}
