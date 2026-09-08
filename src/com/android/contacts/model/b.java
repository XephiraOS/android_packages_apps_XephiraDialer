package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.util.Log;
import com.android.contacts.detail.i0;
import com.android.contacts.model.AccountType;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.customize.contacts.util.K;
import com.google.common.collect.Maps;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: BaseAccountType.java */
/* loaded from: classes.dex */
public abstract class b extends AccountType {

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static abstract class a implements AccountType.e {
        @Override // com.android.contacts.model.AccountType.e
        public CharSequence a(Context context, ContentValues contentValues) {
            return d(context.getResources(), contentValues.getAsInteger(c()), contentValues.getAsString(b()));
        }

        public String b() {
            return "data3";
        }

        public String c() {
            return "data2";
        }

        public CharSequence d(Resources resources, Integer num, CharSequence charSequence) {
            int e10 = e(num);
            if (num == null) {
                return resources.getText(e10);
            }
            if (f(num)) {
                if (charSequence == null) {
                    charSequence = "";
                }
                return resources.getString(e10, charSequence);
            }
            return resources.getText(e10);
        }

        public abstract int e(Integer num);

        public boolean f(Integer num) {
            if (num.intValue() == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* renamed from: com.android.contacts.model.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0173b extends a {
        @Override // com.android.contacts.model.b.a
        public int e(Integer num) {
            if (num == null) {
                return R.string.email;
            }
            int intValue = num.intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        if (intValue != 4) {
                            return R.string.email_custom;
                        }
                        return R.string.email_mobile;
                    }
                    return R.string.email_other;
                }
                return R.string.email_work;
            }
            return R.string.email_home;
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class c extends i {
        @Override // com.android.contacts.model.b.i
        public AccountType.c a(AttributeSet attributeSet, String str) {
            if ("home".equals(str)) {
                return b.O(1);
            }
            if ("work".equals(str)) {
                return b.O(2);
            }
            if ("other".equals(str)) {
                return b.O(3);
            }
            if ("mobile".equals(str)) {
                return b.O(4);
            }
            if ("custom".equals(str)) {
                return b.O(0).b(true).a("data3");
            }
            return null;
        }

        @Override // com.android.contacts.model.b.i
        public String b() {
            return "email";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/email_v2", "data2", R.string.emailLabelsGroup, 15, R.layout.text_fields_editor_view, new C0173b(), new v("data1"), R.string.oplus_add_emailLabelsGroup);
            c10.f17018q.add(new AccountType.b("data1", R.string.emailLabelsGroup, 33));
            return com.google.common.collect.n.i(c10);
        }

        public c() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class d extends a {
        @Override // com.android.contacts.model.b.a
        public int e(Integer num) {
            return ContactsContract.CommonDataKinds.Event.getTypeResource(num);
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class e extends i {
        @Override // com.android.contacts.model.b.i
        public AccountType.c a(AttributeSet attributeSet, String str) {
            boolean Y9 = b.Y(attributeSet, "yearOptional", false);
            if ("birthday".equals(str)) {
                return b.P(3, Y9);
            }
            if ("anniversary".equals(str)) {
                return b.P(1, Y9);
            }
            if ("other".equals(str)) {
                return b.P(2, Y9);
            }
            if ("custom".equals(str)) {
                return b.P(0, Y9).b(true).a("data3");
            }
            return null;
        }

        @Override // com.android.contacts.model.b.i
        public String b() {
            return "event";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, true, "vnd.android.cursor.item/contact_event", "data2", R.string.eventLabelsGroup, 35, R.layout.event_field_editor_view, new d(), new v("data1"), R.string.oplus_add_eventLabelsGroup);
            ArrayList f10 = com.google.common.collect.n.f();
            c10.f17017p = f10;
            f10.add(b.P(3, true).c(1));
            c10.f17017p.add(b.R(1000, true).c(1));
            c10.f17017p.add(b.P(1, true));
            c10.f17017p.add(b.P(2, true));
            c10.f17017p.add(b.P(0, true).b(true).a("data3"));
            c10.f17018q.add(new AccountType.b("data1", R.string.eventLabelsGroup, 1));
            if (b.Y(attributeSet, "dateWithTime", false)) {
                c10.f17020x = F7.b.f1007e;
                c10.f17021y = F7.b.f1006d;
            } else {
                c10.f17020x = F7.b.f1004b;
                c10.f17021y = F7.b.f1005c;
            }
            return com.google.common.collect.n.i(c10);
        }

        public e() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class f extends i {
        @Override // com.android.contacts.model.b.i
        public String b() {
            return "group_membership";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/group_membership", null, R.string.groupsLabel, 20, -1, null, null, R.string.oplus_add_groupsLabel);
            c10.f17018q.add(new AccountType.b("data1", -1, -1));
            g(c10);
            return com.google.common.collect.n.i(c10);
        }

        public f() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class g extends a {
        @Override // com.android.contacts.model.b.a
        public String b() {
            return "data6";
        }

        @Override // com.android.contacts.model.b.a
        public String c() {
            return "data5";
        }

        @Override // com.android.contacts.model.b.a
        public int e(Integer num) {
            if (num == null) {
                return R.string.chat;
            }
            switch (num.intValue()) {
                case 0:
                    return R.string.chat_aim;
                case 1:
                    return R.string.chat_msn;
                case 2:
                    return R.string.chat_yahoo;
                case 3:
                    return R.string.chat_skype;
                case 4:
                    return R.string.chat_qq;
                case 5:
                    return R.string.chat_gtalk;
                case 6:
                    return R.string.chat_icq;
                case 7:
                    return R.string.chat_jabber;
                default:
                    return R.string.chat;
            }
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class h extends i {
        @Override // com.android.contacts.model.b.i
        public AccountType.c a(AttributeSet attributeSet, String str) {
            if ("aim".equals(str)) {
                return b.Q(0);
            }
            if ("msn".equals(str)) {
                return b.Q(1);
            }
            if ("yahoo".equals(str)) {
                return b.Q(2);
            }
            if ("skype".equals(str)) {
                return b.Q(3);
            }
            if ("qq".equals(str)) {
                return b.Q(4);
            }
            if ("google_talk".equals(str)) {
                return b.Q(5);
            }
            if ("icq".equals(str)) {
                return b.Q(6);
            }
            if ("jabber".equals(str)) {
                return b.Q(7);
            }
            if ("custom".equals(str)) {
                return b.Q(-1).b(true).a("data6");
            }
            return null;
        }

        @Override // com.android.contacts.model.b.i
        public String b() {
            return "im";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/im", "data5", R.string.imLabelsGroup, 32, R.layout.text_fields_editor_view, new g(), new v("data1"), R.string.oplus_add_imLabelsGroup);
            c10.f17018q.add(new AccountType.b("data1", R.string.imLabelsGroup, 33));
            ContentValues contentValues = new ContentValues();
            c10.f17019r = contentValues;
            contentValues.put("data2", (Integer) 3);
            return com.google.common.collect.n.i(c10);
        }

        public h() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static abstract class i {
        public i() {
        }

        public AccountType.c a(AttributeSet attributeSet, String str) {
            return null;
        }

        public abstract String b();

        public final com.android.contacts.model.c c(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, boolean z10, String str, String str2, int i10, int i11, int i12, AccountType.e eVar, AccountType.e eVar2, int i13) {
            if (Log.isLoggable("BaseAccountType", 3)) {
                H7.b.b("BaseAccountType", "Adding DataKind: " + str);
            }
            com.android.contacts.model.c cVar = new com.android.contacts.model.c(str, i10, i11, true, i12, i13);
            cVar.f17015n = str2;
            cVar.f17011j = eVar;
            cVar.f17013l = eVar2;
            cVar.f17018q = com.google.common.collect.n.f();
            if (!z10) {
                cVar.f17016o = b.W(attributeSet, "maxOccurs", -1);
                if (cVar.f17015n != null) {
                    cVar.f17017p = com.google.common.collect.n.f();
                    f(context, xmlPullParser, attributeSet, cVar, true);
                    if (cVar.f17017p.size() == 0) {
                        H7.b.c("BaseAccountType", "Kind " + cVar.f17004c + " must have at least one type");
                    }
                } else {
                    f(context, xmlPullParser, attributeSet, cVar, false);
                }
            }
            return cVar;
        }

        public abstract List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet);

        public final AccountType.c e(XmlPullParser xmlPullParser, AttributeSet attributeSet, com.android.contacts.model.c cVar) {
            AccountType.c a10 = a(attributeSet, b.X(attributeSet, OplusAutoRedialNotificationUI.TYPE));
            if (a10 == null) {
                return null;
            }
            a10.f16963d = b.W(attributeSet, "maxOccurs", -1);
            return a10;
        }

        public final void f(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, com.android.contacts.model.c cVar, boolean z10) {
            int i10;
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next != 1) {
                    if (next != 3 || xmlPullParser.getDepth() > depth) {
                        int depth2 = xmlPullParser.getDepth();
                        if (next == 2 && depth2 == depth + 1) {
                            String name = xmlPullParser.getName();
                            if ("Type".equals(name)) {
                                if (z10) {
                                    AccountType.c e10 = e(xmlPullParser, attributeSet, cVar);
                                    if (e10 != null) {
                                        int size = cVar.f17017p.size();
                                        if (this instanceof h) {
                                            i10 = -1;
                                        } else {
                                            i10 = 0;
                                        }
                                        if (size > 0) {
                                            int i11 = size - 1;
                                            if (cVar.f17017p.get(i11).f16960a == i10) {
                                                cVar.f17017p.add(i11, e10);
                                            }
                                        }
                                        cVar.f17017p.add(e10);
                                    }
                                } else {
                                    H7.b.c("BaseAccountType", "Kind " + cVar.f17004c + " can't have types");
                                }
                            } else {
                                H7.b.c("BaseAccountType", "Unknown tag: " + name);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final void g(com.android.contacts.model.c cVar) {
            if (cVar.f17016o != 1) {
                H7.b.c("BaseAccountType", "Kind " + cVar.f17004c + " must have 'overallMax=\"1\"'");
            }
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: b, reason: collision with root package name */
        public static final j f16998b = new j();

        /* renamed from: a, reason: collision with root package name */
        public final Map<String, i> f16999a = Maps.f();

        /* JADX WARN: Multi-variable type inference failed */
        public j() {
            a(new k());
            a(new l());
            a(new q());
            a(new c());
            a(new x());
            a(new h());
            a(new n());
            a(new r());
            a(new m());
            a(new y());
            a(new w());
            a(new f());
            a(new e());
            a(new u());
        }

        public final void a(i iVar) {
            this.f16999a.put(iVar.b(), iVar);
        }

        public List<com.android.contacts.model.c> b(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            String X10 = b.X(attributeSet, "kind");
            i iVar = this.f16999a.get(X10);
            if (iVar != null) {
                return iVar.d(context, xmlPullParser, attributeSet);
            }
            H7.b.c("BaseAccountType", "Undefined data kind '" + X10 + "'");
            return null;
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class k extends i {
        public static void h(boolean z10, String str) {
            if (!z10) {
                H7.b.c("BaseAccountType", str + " must be true");
            }
        }

        @Override // com.android.contacts.model.b.i
        public String b() {
            return "name";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            boolean z10 = context.getResources().getBoolean(R.bool.config_editor_field_order_primary);
            boolean Y9 = b.Y(attributeSet, "supportsDisplayName", false);
            boolean Y10 = b.Y(attributeSet, "supportsPrefix", false);
            boolean Y11 = b.Y(attributeSet, "supportsMiddleName", false);
            boolean Y12 = b.Y(attributeSet, "supportsSuffix", false);
            boolean Y13 = b.Y(attributeSet, "supportsPhoneticFamilyName", false);
            boolean Y14 = b.Y(attributeSet, "supportsPhoneticMiddleName", false);
            boolean Y15 = b.Y(attributeSet, "supportsPhoneticGivenName", false);
            h(Y9, "supportsDisplayName");
            h(Y10, "supportsPrefix");
            h(Y11, "supportsMiddleName");
            h(Y12, "supportsSuffix");
            h(Y13, "supportsPhoneticFamilyName");
            h(Y14, "supportsPhoneticMiddleName");
            h(Y15, "supportsPhoneticGivenName");
            ArrayList f10 = com.google.common.collect.n.f();
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/name", null, R.string.nameLabelsGroup, -1, R.layout.structured_name_editor_view, new v(R.string.nameLabelsGroup), new v("data1"), R.string.oplus_add_nameLabelsGroup);
            g(c10);
            f10.add(c10);
            c10.f17018q.add(new AccountType.b("data1", R.string.full_name, 8289));
            c10.f17018q.add(new AccountType.b("data4", R.string.name_prefix, 8289).a(true));
            c10.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289).a(true));
            c10.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289).a(true));
            c10.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289).a(true));
            c10.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289).a(true));
            c10.f17018q.add(new AccountType.b("data9", R.string.name_phonetic_family, 193));
            c10.f17018q.add(new AccountType.b("data8", R.string.name_phonetic_middle, 193));
            c10.f17018q.add(new AccountType.b("data7", R.string.name_phonetic_given, 193));
            com.android.contacts.model.c c11 = c(context, xmlPullParser, attributeSet, true, "#displayName", null, R.string.nameLabelsGroup, -1, R.layout.text_fields_editor_view, new v(R.string.nameLabelsGroup), new v("data1"), R.string.oplus_add_nameLabelsGroup);
            c11.f17016o = 1;
            f10.add(c11);
            c11.f17018q.add(new AccountType.b("data1", R.string.full_name, 8289).c(true));
            if (!z10) {
                c11.f17018q.add(new AccountType.b("data4", R.string.name_prefix, 8289).a(true));
                c11.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289).a(true));
                c11.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289).a(true));
                c11.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289).a(true));
                c11.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289).a(true));
            } else {
                c11.f17018q.add(new AccountType.b("data4", R.string.name_prefix, 8289).a(true));
                c11.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289).a(true));
                c11.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289).a(true));
                c11.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289).a(true));
                c11.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289).a(true));
            }
            com.android.contacts.model.c c12 = c(context, xmlPullParser, attributeSet, true, "#phoneticName", null, R.string.name_phonetic, -1, R.layout.phonetic_name_editor_view, new v(R.string.nameLabelsGroup), new v("data1"), R.string.oplus_add_name_phonetic);
            c12.f17016o = 1;
            f10.add(c12);
            c12.f17018q.add(new AccountType.b("#phoneticName", R.string.name_phonetic, 193).c(true));
            c12.f17018q.add(new AccountType.b("data9", R.string.name_phonetic_family, 193).a(true));
            c12.f17018q.add(new AccountType.b("data8", R.string.name_phonetic_middle, 193).a(true));
            c12.f17018q.add(new AccountType.b("data7", R.string.name_phonetic_given, 193).a(true));
            return f10;
        }

        public k() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class l extends i {
        @Override // com.android.contacts.model.b.i
        public String b() {
            return "nickname";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/nickname", null, R.string.nicknameLabelsGroup, 115, R.layout.text_fields_editor_view, new v(R.string.nicknameLabelsGroup), new v("data1"), R.string.oplus_add_nicknameLabelsGroup);
            c10.f17018q.add(new AccountType.b("data1", R.string.nicknameLabelsGroup, 8289));
            ContentValues contentValues = new ContentValues();
            c10.f17019r = contentValues;
            contentValues.put("data2", (Integer) 1);
            g(c10);
            return com.google.common.collect.n.i(c10);
        }

        public l() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class m extends i {
        @Override // com.android.contacts.model.b.i
        public String b() {
            return "note";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/note", null, R.string.label_notes, 130, R.layout.text_fields_editor_view, new v(R.string.label_notes), new v("data1"), R.string.oplus_add_label_notes);
            c10.f17018q.add(new AccountType.b("data1", R.string.label_notes, 147457));
            g(c10);
            return com.google.common.collect.n.i(c10);
        }

        public m() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class n extends i {
        @Override // com.android.contacts.model.b.i
        public String b() {
            return "organization";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/organization", null, R.string.organizationLabelsGroup, 22, R.layout.customize_text_fields_editor_view, new v("data1"), new v("data4"), R.string.oplus_add_organizationLabelsGroup);
            c10.f17018q.add(new AccountType.b("data1", R.string.ghostData_company, 8193));
            c10.f17018q.add(new AccountType.b("data4", R.string.ghostData_title, 8193));
            g(c10);
            return com.google.common.collect.n.i(c10);
        }

        public n() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class o extends a {
        @Override // com.android.contacts.model.b.a
        public int e(Integer num) {
            if (num == null) {
                return R.string.sms_other;
            }
            switch (num.intValue()) {
                case 1:
                    return R.string.sms_home;
                case 2:
                    return R.string.sms_mobile;
                case 3:
                    return R.string.sms_work;
                case 4:
                    return R.string.sms_fax_work;
                case 5:
                    return R.string.sms_fax_home;
                case 6:
                    return R.string.sms_pager;
                case 7:
                    return R.string.sms_other;
                case 8:
                    return R.string.sms_callback;
                case 9:
                    return R.string.sms_car;
                case 10:
                    return R.string.sms_company_main;
                case 11:
                    return R.string.sms_isdn;
                case 12:
                    return R.string.sms_main;
                case 13:
                    return R.string.sms_other_fax;
                case 14:
                    return R.string.sms_radio;
                case 15:
                    return R.string.sms_telex;
                case 16:
                    return R.string.sms_tty_tdd;
                case 17:
                    return R.string.sms_work_mobile;
                case 18:
                    return R.string.sms_work_pager;
                case 19:
                    return R.string.sms_assistant;
                case 20:
                    return R.string.sms_mms;
                default:
                    return R.string.sms_custom;
            }
        }

        @Override // com.android.contacts.model.b.a
        public boolean f(Integer num) {
            if (num.intValue() != 0 && num.intValue() != 19) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class p extends a {
        @Override // com.android.contacts.model.b.a
        public int e(Integer num) {
            if (num == null) {
                return R.string.call_other;
            }
            switch (num.intValue()) {
                case 1:
                    return R.string.call_home;
                case 2:
                    return R.string.call_mobile;
                case 3:
                    return R.string.call_work;
                case 4:
                    return R.string.call_fax_work;
                case 5:
                    return R.string.call_fax_home;
                case 6:
                    return R.string.call_pager;
                case 7:
                    return R.string.call_other;
                case 8:
                    return R.string.call_callback;
                case 9:
                    return R.string.call_car;
                case 10:
                    return R.string.call_company_main;
                case 11:
                    return R.string.call_isdn;
                case 12:
                    return R.string.call_main;
                case 13:
                    return R.string.call_other_fax;
                case 14:
                    return R.string.call_radio;
                case 15:
                    return R.string.call_telex;
                case 16:
                    return R.string.call_tty_tdd;
                case 17:
                    return R.string.call_work_mobile;
                case 18:
                    return R.string.call_work_pager;
                case 19:
                    return R.string.call_assistant;
                case 20:
                    return R.string.call_mms;
                default:
                    return R.string.call_custom;
            }
        }

        @Override // com.android.contacts.model.b.a
        public boolean f(Integer num) {
            if (num.intValue() != 0 && num.intValue() != 19) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class q extends i {
        public static AccountType.c h(int i10, boolean z10) {
            return new AccountType.c(i10, ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(i10)).b(z10);
        }

        @Override // com.android.contacts.model.b.i
        public AccountType.c a(AttributeSet attributeSet, String str) {
            if ("home".equals(str)) {
                return h(1, false);
            }
            if ("mobile".equals(str)) {
                return h(2, false);
            }
            if ("work".equals(str)) {
                return h(3, false);
            }
            if ("fax_work".equals(str)) {
                return h(4, true);
            }
            if ("fax_home".equals(str)) {
                return h(5, true);
            }
            if ("pager".equals(str)) {
                return h(6, true);
            }
            if ("other".equals(str)) {
                return h(7, true);
            }
            if ("callback".equals(str)) {
                return h(8, true);
            }
            if ("car".equals(str)) {
                return h(9, true);
            }
            if ("company_main".equals(str)) {
                return h(10, true);
            }
            if ("isdn".equals(str)) {
                return h(11, true);
            }
            if ("main".equals(str)) {
                return h(12, true);
            }
            if ("other_fax".equals(str)) {
                return h(13, true);
            }
            if ("radio".equals(str)) {
                return h(14, true);
            }
            if ("telex".equals(str)) {
                return h(15, true);
            }
            if ("tty_tdd".equals(str)) {
                return h(16, true);
            }
            if ("work_mobile".equals(str)) {
                return h(17, true);
            }
            if ("work_pager".equals(str)) {
                return h(18, true);
            }
            if ("assistant".equals(str)) {
                return h(19, true);
            }
            if ("mms".equals(str)) {
                return h(20, true);
            }
            if ("custom".equals(str)) {
                return h(0, true).a("data3");
            }
            return null;
        }

        @Override // com.android.contacts.model.b.i
        public String b() {
            return "phone";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/phone_v2", "data2", R.string.phoneLabelsGroup, 10, R.layout.text_fields_editor_view, new p(), new v("data1"), R.string.oplus_add_phoneLabelsGroup);
            c10.f17007f = R.drawable.pb_dr_detail_sms;
            c10.f17008g = R.string.send_sms;
            c10.f17012k = new o();
            c10.f17018q.add(new AccountType.b("data1", R.string.phoneLabelsGroup, 3));
            return com.google.common.collect.n.i(c10);
        }

        public q() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class r extends i {
        @Override // com.android.contacts.model.b.i
        public String b() {
            return "photo";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/photo", null, -1, -1, -1, null, null, -1);
            c10.f17018q.add(new AccountType.b("data15", -1, -1));
            g(c10);
            return com.google.common.collect.n.i(c10);
        }

        public r() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class s extends a {
        @Override // com.android.contacts.model.b.a
        public int e(Integer num) {
            if (num == null) {
                return R.string.map_other;
            }
            int intValue = num.intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue == 3) {
                        return R.string.map_other;
                    }
                    return R.string.map_custom;
                }
                return R.string.map_work;
            }
            return R.string.map_home;
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class t extends a {
        @Override // com.android.contacts.model.b.a
        public int e(Integer num) {
            if (num == null) {
                return ContactsContract.CommonDataKinds.Relation.getTypeLabelResource(0);
            }
            int intValue = num.intValue();
            if (intValue != 10) {
                if (intValue != 11) {
                    return ContactsContract.CommonDataKinds.Relation.getTypeLabelResource(num.intValue());
                }
                return R.string.introducer;
            }
            return R.string.client;
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class u extends i {
        @Override // com.android.contacts.model.b.i
        public AccountType.c a(AttributeSet attributeSet, String str) {
            if ("assistant".equals(str)) {
                return b.V(1);
            }
            if ("brother".equals(str)) {
                return b.V(2);
            }
            if ("child".equals(str)) {
                return b.V(3);
            }
            if ("domestic_partner".equals(str)) {
                return b.V(4);
            }
            if ("father".equals(str)) {
                return b.V(5);
            }
            if ("friend".equals(str)) {
                return b.V(6);
            }
            if ("manager".equals(str)) {
                return b.V(7);
            }
            if ("mother".equals(str)) {
                return b.V(8);
            }
            if ("parent".equals(str)) {
                return b.V(9);
            }
            if ("partner".equals(str)) {
                return b.V(10);
            }
            if ("referred_by".equals(str)) {
                return b.V(11);
            }
            if ("relative".equals(str)) {
                return b.V(12);
            }
            if ("sister".equals(str)) {
                return b.V(13);
            }
            if ("spouse".equals(str)) {
                return b.V(14);
            }
            if ("custom".equals(str)) {
                return b.V(0).b(true).a("data3");
            }
            return null;
        }

        @Override // com.android.contacts.model.b.i
        public String b() {
            return "relationship";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/relation", "data2", R.string.oplus_relation, 40, R.layout.text_fields_editor_view, new t(), new v("data1"), R.string.oplus_add_oplus_relation);
            c10.f17018q.add(new AccountType.b("data1", R.string.relationLabelsGroup, 8289));
            ContentValues contentValues = new ContentValues();
            c10.f17019r = contentValues;
            contentValues.put("data2", (Integer) 14);
            return com.google.common.collect.n.i(c10);
        }

        public u() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class v implements AccountType.e {

        /* renamed from: a, reason: collision with root package name */
        public final int f17000a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17001b;

        public v(int i10) {
            this(i10, null);
        }

        @Override // com.android.contacts.model.AccountType.e
        public CharSequence a(Context context, ContentValues contentValues) {
            boolean z10;
            CharSequence charSequence;
            String str;
            if (contentValues != null && context != null) {
                boolean containsKey = contentValues.containsKey(this.f17001b);
                int i10 = this.f17000a;
                if (i10 > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    charSequence = context.getText(i10);
                } else {
                    charSequence = null;
                }
                if (containsKey) {
                    str = contentValues.getAsString(this.f17001b);
                } else {
                    str = null;
                }
                if (z10 && containsKey) {
                    return String.format(charSequence.toString(), str);
                }
                if (z10) {
                    return charSequence;
                }
                if (containsKey) {
                    return str;
                }
            }
            return null;
        }

        public String toString() {
            return getClass().getSimpleName() + " mStringRes=" + this.f17000a + " mColumnName" + this.f17001b;
        }

        public v(String str) {
            this(-1, str);
        }

        public v(int i10, String str) {
            this.f17000a = i10;
            this.f17001b = str;
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class w extends i {
        @Override // com.android.contacts.model.b.i
        public String b() {
            return "sip_address";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/sip_address", null, R.string.label_sip_address, 30, R.layout.text_fields_editor_view, new v(R.string.label_sip_address), new v("data1"), R.string.oplus_add_label_sip_address);
            c10.f17018q.add(new AccountType.b("data1", R.string.label_sip_address, 33));
            g(c10);
            return com.google.common.collect.n.i(c10);
        }

        public w() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class x extends i {
        @Override // com.android.contacts.model.b.i
        public AccountType.c a(AttributeSet attributeSet, String str) {
            if ("home".equals(str)) {
                return b.U(1);
            }
            if ("work".equals(str)) {
                return b.U(2);
            }
            if ("other".equals(str)) {
                return b.U(3);
            }
            if ("custom".equals(str)) {
                return b.U(0).b(true).a("data3");
            }
            return null;
        }

        @Override // com.android.contacts.model.b.i
        public String b() {
            return "postal";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/postal-address_v2", "data2", R.string.postalLabelsGroup, 25, R.layout.text_fields_editor_view, new s(), new v("data1"), R.string.oplus_add_postalLabelsGroup);
            if (b.Y(attributeSet, "needsStructured", false)) {
                if (K.c()) {
                    c10.f17018q.add(new AccountType.b("data10", R.string.postal_country, 139377).b(true));
                    c10.f17018q.add(new AccountType.b("data9", R.string.postal_postcode, 139377));
                    c10.f17018q.add(new AccountType.b("data8", R.string.postal_region, 139377));
                    c10.f17018q.add(new AccountType.b("data7", R.string.postal_city, 139377));
                    c10.f17018q.add(new AccountType.b("data4", R.string.postal_street, 139377));
                } else {
                    c10.f17018q.add(new AccountType.b("data4", R.string.postal_street, 139377));
                    c10.f17018q.add(new AccountType.b("data7", R.string.postal_city, 139377));
                    c10.f17018q.add(new AccountType.b("data8", R.string.postal_region, 139377));
                    c10.f17018q.add(new AccountType.b("data9", R.string.postal_postcode, 139377));
                    c10.f17018q.add(new AccountType.b("data10", R.string.postal_country, 139377).b(true));
                }
            } else {
                c10.f17018q.add(new AccountType.b("data1", R.string.postal_address, 139377));
            }
            return com.google.common.collect.n.i(c10);
        }

        public x() {
            super();
        }
    }

    /* compiled from: BaseAccountType.java */
    /* loaded from: classes.dex */
    public static class y extends i {
        @Override // com.android.contacts.model.b.i
        public String b() {
            return "website";
        }

        @Override // com.android.contacts.model.b.i
        public List<com.android.contacts.model.c> d(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
            com.android.contacts.model.c c10 = c(context, xmlPullParser, attributeSet, false, "vnd.android.cursor.item/website", null, R.string.websiteLabelsGroup, 120, R.layout.text_fields_editor_view, new v(R.string.websiteLabelsGroup), new v("data1"), R.string.oplus_add_websiteLabelsGroup);
            c10.f17018q.add(new AccountType.b("data1", R.string.websiteLabelsGroup, 17));
            ContentValues contentValues = new ContentValues();
            c10.f17019r = contentValues;
            contentValues.put("data2", (Integer) 7);
            return com.google.common.collect.n.i(c10);
        }

        public y() {
            super();
        }
    }

    public b() {
        this.f16944a = null;
        this.f16945b = null;
        this.f16948e = R.string.account_phone_tablet;
        this.f16949f = N0.g.f1905e;
    }

    public static AccountType.c O(int i10) {
        return new AccountType.c(i10, ContactsContract.CommonDataKinds.Email.getTypeLabelResource(i10));
    }

    public static AccountType.c P(int i10, boolean z10) {
        return new AccountType.d(i10, i0.l.c(Integer.valueOf(i10))).e(z10);
    }

    public static AccountType.c Q(int i10) {
        if (i10 != 15) {
            return new AccountType.c(i10, ContactsContract.CommonDataKinds.Im.getProtocolLabelResource(i10));
        }
        return new AccountType.c(i10, R.string.imProtocolWeChat);
    }

    public static AccountType.c R(int i10, boolean z10) {
        return new AccountType.d(i10, i0.l.c(Integer.valueOf(i10))).e(z10);
    }

    public static AccountType.c S(int i10) {
        return new AccountType.c(i10, ContactsContract.CommonDataKinds.Organization.getTypeLabelResource(i10));
    }

    public static AccountType.c T(int i10) {
        return new AccountType.c(i10, ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(i10));
    }

    public static AccountType.c U(int i10) {
        return new AccountType.c(i10, ContactsContract.CommonDataKinds.StructuredPostal.getTypeLabelResource(i10));
    }

    public static AccountType.c V(int i10) {
        if (i10 != 10) {
            if (i10 != 11) {
                return new AccountType.c(i10, ContactsContract.CommonDataKinds.Relation.getTypeLabelResource(i10));
            }
            return new AccountType.c(i10, R.string.introducer);
        }
        return new AccountType.c(i10, R.string.client);
    }

    public static int W(AttributeSet attributeSet, String str, int i10) {
        return attributeSet.getAttributeIntValue(null, str, i10);
    }

    public static String X(AttributeSet attributeSet, String str) {
        return attributeSet.getAttributeValue(null, str);
    }

    public static boolean Y(AttributeSet attributeSet, String str, boolean z10) {
        return attributeSet.getAttributeBooleanValue(null, str, z10);
    }

    public com.android.contacts.model.c A(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/note", R.string.label_notes, 130, true, R.layout.text_fields_editor_view, R.string.oplus_add_label_notes));
        a10.f17016o = 1;
        a10.f17011j = new v(R.string.label_notes);
        a10.f17013l = new v("data1");
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.label_notes, 147457));
        return a10;
    }

    public com.android.contacts.model.c B(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/organization", R.string.organizationLabelsGroup, 22, true, R.layout.customize_text_fields_editor_view, R.string.oplus_add_organizationLabelsGroup));
        a10.f17011j = new v("data1");
        a10.f17013l = new v("data4");
        a10.f17016o = 1;
        a10.f17015n = "data2";
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17017p = f10;
        f10.add(S(1));
        ArrayList f11 = com.google.common.collect.n.f();
        a10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.ghostData_company, 8193));
        a10.f17018q.add(new AccountType.b("data4", R.string.ghostData_title, 8193));
        return a10;
    }

    public com.android.contacts.model.c C(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/phone_v2", R.string.phoneLabelsGroup, 10, true, R.layout.text_fields_editor_view, R.string.oplus_add_phoneLabelsGroup));
        a10.f17007f = R.drawable.pb_dr_detail_sms;
        a10.f17008g = R.string.send_sms;
        a10.f17011j = new p();
        a10.f17012k = new o();
        a10.f17013l = new v("data1");
        a10.f17015n = "data2";
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17017p = f10;
        f10.add(T(2));
        a10.f17017p.add(T(3));
        a10.f17017p.add(T(1));
        a10.f17017p.add(T(12));
        a10.f17017p.add(T(4));
        a10.f17017p.add(T(5));
        a10.f17017p.add(T(6));
        a10.f17017p.add(T(7));
        a10.f17017p.add(T(0).b(true).a("data3"));
        ArrayList f11 = com.google.common.collect.n.f();
        a10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.phoneLabelsGroup, 3));
        return a10;
    }

    public com.android.contacts.model.c D(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("#phoneticName", R.string.name_phonetic, -1, true, R.layout.phonetic_name_editor_view, R.string.oplus_add_name_phonetic));
        a10.f17011j = new v(R.string.nameLabelsGroup);
        a10.f17013l = new v("data1");
        a10.f17016o = 1;
        a10.f17018q = com.google.common.collect.n.f();
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("#phoneticName", R.string.name_phonetic, 193).c(true));
        a10.f17018q.add(new AccountType.b("data9", R.string.name_phonetic_family, 193).a(true));
        a10.f17018q.add(new AccountType.b("data8", R.string.name_phonetic_middle, 193).a(true));
        a10.f17018q.add(new AccountType.b("data7", R.string.name_phonetic_given, 193).a(true));
        return a10;
    }

    public com.android.contacts.model.c E(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/photo", -1, -1, true, -1, -1));
        a10.f17016o = 1;
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data15", -1, -1));
        return a10;
    }

    public com.android.contacts.model.c F(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("#prefixName", R.string.name_prefix, -1, true, R.layout.text_fields_editor_view, R.string.oplus_add_name_prefix));
        a10.f17011j = new v(R.string.name_prefix);
        a10.f17013l = new v("data1");
        a10.f17016o = 1;
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data4", R.string.name_prefix, 8289));
        a10.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289));
        a10.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289));
        a10.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289));
        a10.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289));
        return a10;
    }

    public com.android.contacts.model.c G(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/relation", R.string.oplus_relation, 40, true, R.layout.text_fields_editor_view, R.string.oplus_add_oplus_relation));
        a10.f17011j = new t();
        a10.f17013l = new v("data1");
        a10.f17015n = "data2";
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17017p = f10;
        f10.add(V(6));
        a10.f17017p.add(V(7));
        a10.f17017p.add(V(1));
        a10.f17017p.add(V(11));
        a10.f17017p.add(V(10));
        a10.f17017p.add(V(2));
        a10.f17017p.add(V(13));
        a10.f17017p.add(V(5));
        a10.f17017p.add(V(8));
        a10.f17017p.add(V(14));
        a10.f17017p.add(V(3));
        a10.f17017p.add(V(0).b(true).a("data3"));
        ContentValues contentValues = new ContentValues();
        a10.f17019r = contentValues;
        contentValues.put("data2", (Integer) 14);
        ArrayList f11 = com.google.common.collect.n.f();
        a10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.relationLabelsGroup, 8289));
        return a10;
    }

    public com.android.contacts.model.c H(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/custom_ringtone", R.string.oplus_incoming_ring, 13, true, -1, R.string.oplus_incoming_ring));
        a10.f17016o = 1;
        a10.f17011j = new v(R.string.oplus_incoming_ring);
        a10.f17013l = new v("data1");
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", -1, -1));
        return a10;
    }

    public com.android.contacts.model.c I(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/sip_address", R.string.label_sip_address, 30, true, R.layout.text_fields_editor_view, R.string.oplus_add_label_sip_address));
        a10.f17016o = 1;
        a10.f17011j = new v(R.string.label_sip_address);
        a10.f17013l = new v("data1");
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.label_sip_address, 33));
        return a10;
    }

    public com.android.contacts.model.c J(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/name", R.string.nameLabelsGroup, -1, true, R.layout.structured_name_editor_view, R.string.oplus_add_nameLabelsGroup));
        a10.f17011j = new v(R.string.nameLabelsGroup);
        a10.f17013l = new v("data1");
        a10.f17016o = 1;
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.full_name, 8289));
        a10.f17018q.add(new AccountType.b("data4", R.string.name_prefix, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data9", R.string.name_phonetic_family, 193));
        a10.f17018q.add(new AccountType.b("data8", R.string.name_phonetic_middle, 193));
        a10.f17018q.add(new AccountType.b("data7", R.string.name_phonetic_given, 193));
        return a10;
    }

    public com.android.contacts.model.c K(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/postal-address_v2", R.string.postalLabelsGroup, 25, true, R.layout.text_fields_editor_view, R.string.oplus_add_postalLabelsGroup));
        a10.f17011j = new s();
        a10.f17013l = new v("data1");
        a10.f17015n = "data2";
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17017p = f10;
        f10.add(U(1));
        a10.f17017p.add(U(2));
        a10.f17017p.add(U(3));
        a10.f17017p.add(U(0).b(true).a("data3"));
        ArrayList f11 = com.google.common.collect.n.f();
        a10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.postal_address, 139377));
        return a10;
    }

    public com.android.contacts.model.c L(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("#suffixName", R.string.name_suffix, -1, true, R.layout.text_fields_editor_view, R.string.oplus_add_name_suffix));
        a10.f17011j = new v(R.string.name_suffix);
        a10.f17013l = new v("data1");
        a10.f17016o = 1;
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data4", R.string.name_prefix, 8289));
        a10.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289));
        a10.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289));
        a10.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289));
        a10.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289));
        return a10;
    }

    public com.android.contacts.model.c M(Context context) {
        if (com.customize.contacts.manager.h.g()) {
            com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/custom_vibration", R.string.incoming_call_vibration_title, 14, true, -1, R.string.incoming_call_vibration_title));
            a10.f17016o = 1;
            a10.f17011j = new v(R.string.incoming_call_vibration_title);
            a10.f17013l = new v("data1");
            ArrayList f10 = com.google.common.collect.n.f();
            a10.f17018q = f10;
            f10.add(new AccountType.b("data1", -1, -1));
            return a10;
        }
        return null;
    }

    public com.android.contacts.model.c N(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/website", R.string.websiteLabelsGroup, 120, true, R.layout.text_fields_editor_view, R.string.oplus_add_websiteLabelsGroup));
        a10.f17011j = new v(R.string.websiteLabelsGroup);
        a10.f17013l = new v("data1");
        ContentValues contentValues = new ContentValues();
        a10.f17019r = contentValues;
        contentValues.put("data2", (Integer) 7);
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.websiteLabelsGroup, 17));
        return a10;
    }

    public final void Z(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                if (next != 3 || xmlPullParser.getDepth() > depth) {
                    int depth2 = xmlPullParser.getDepth();
                    if (next == 2 && depth2 == depth + 1) {
                        String name = xmlPullParser.getName();
                        if ("DataKind".equals(name)) {
                            List<com.android.contacts.model.c> b10 = j.f16998b.b(context, xmlPullParser, attributeSet);
                            if (b10 != null) {
                                Iterator<com.android.contacts.model.c> it = b10.iterator();
                                while (it.hasNext()) {
                                    a(it.next());
                                }
                            }
                        } else {
                            H7.b.i("BaseAccountType", "Skipping unknown tag " + name);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.android.contacts.model.AccountType
    public boolean p() {
        return false;
    }

    public com.android.contacts.model.c u(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/email_v2", R.string.emailLabelsGroup, 15, true, R.layout.text_fields_editor_view, R.string.oplus_add_emailLabelsGroup));
        a10.f17011j = new C0173b();
        a10.f17013l = new v("data1");
        a10.f17015n = "data2";
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17017p = f10;
        f10.add(O(1));
        a10.f17017p.add(O(2));
        a10.f17017p.add(O(3));
        a10.f17017p.add(O(0).b(true).a("data3"));
        ArrayList f11 = com.google.common.collect.n.f();
        a10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.emailLabelsGroup, 33));
        return a10;
    }

    public com.android.contacts.model.c v(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/group_membership", R.string.groupsLabel, 20, true, -1, R.string.oplus_add_groupsLabel));
        a10.f17016o = 1;
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", -1, -1));
        return a10;
    }

    public com.android.contacts.model.c w(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/im", R.string.imLabelsGroup, 32, true, R.layout.text_fields_editor_view, R.string.oplus_add_imLabelsGroup));
        a10.f17011j = new g();
        a10.f17013l = new v("data1");
        ContentValues contentValues = new ContentValues();
        a10.f17019r = contentValues;
        contentValues.put("data2", (Integer) 3);
        a10.f17015n = "data5";
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17017p = f10;
        f10.add(Q(4));
        a10.f17017p.add(Q(5));
        a10.f17017p.add(Q(3));
        a10.f17017p.add(Q(1));
        a10.f17017p.add(Q(2));
        a10.f17017p.add(Q(0));
        a10.f17017p.add(Q(6));
        a10.f17017p.add(Q(7));
        a10.f17017p.add(Q(-1).b(true).a("data6"));
        ArrayList f11 = com.google.common.collect.n.f();
        a10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.imLabelsGroup, 33));
        return a10;
    }

    public com.android.contacts.model.c x(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("#middleName", R.string.name_middle, -1, true, R.layout.text_fields_editor_view, R.string.oplus_add_name_middle));
        a10.f17011j = new v(R.string.name_middle);
        a10.f17013l = new v("data1");
        a10.f17016o = 1;
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data4", R.string.name_prefix, 8289));
        a10.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289));
        a10.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289));
        a10.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289));
        a10.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289));
        return a10;
    }

    public com.android.contacts.model.c y(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("#displayName", R.string.nameLabelsGroup, -1, true, R.layout.text_fields_editor_view, R.string.oplus_add_nameLabelsGroup));
        a10.f17011j = new v(R.string.nameLabelsGroup);
        a10.f17013l = new v("data1");
        a10.f17016o = 1;
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.full_name, 8289).c(true));
        if (context != null && context.getResources() != null && context.getResources().getBoolean(R.bool.config_editor_field_order_primary)) {
            a10.f17018q.add(new AccountType.b("data4", R.string.name_prefix, 8289).a(true));
            a10.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289).a(true));
            a10.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289).a(true));
            a10.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289).a(true));
            a10.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289).a(true));
        } else {
            a10.f17018q.add(new AccountType.b("data4", R.string.name_prefix, 8289).a(true));
            a10.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289).a(true));
            a10.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289).a(true));
            a10.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289).a(true));
            a10.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289).a(true));
        }
        return a10;
    }

    public com.android.contacts.model.c z(Context context) {
        com.android.contacts.model.c a10 = a(new com.android.contacts.model.c("vnd.android.cursor.item/nickname", R.string.nicknameLabelsGroup, 115, true, R.layout.text_fields_editor_view, R.string.oplus_add_nicknameLabelsGroup));
        a10.f17016o = 1;
        a10.f17011j = new v(R.string.nicknameLabelsGroup);
        a10.f17013l = new v("data1");
        ContentValues contentValues = new ContentValues();
        a10.f17019r = contentValues;
        contentValues.put("data2", (Integer) 1);
        ArrayList f10 = com.google.common.collect.n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.nicknameLabelsGroup, 8289));
        return a10;
    }
}
