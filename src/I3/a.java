package I3;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.dialer.R;
import java.util.HashMap;

/* compiled from: ContactCommon.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap<String, Integer> f1305e = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public boolean f1306a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1307b;

    /* renamed from: c, reason: collision with root package name */
    public String f1308c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f1309d = new String[15];

    public static void f(Context context) {
        HashMap<String, Integer> hashMap = f1305e;
        hashMap.put(context.getString(R.string.LAST_NAME), 2);
        hashMap.put(context.getString(R.string.FIRST_NAME), 0);
        hashMap.put(context.getString(R.string.MIDDLE_NAME), 1);
        hashMap.put(context.getString(R.string.FULL_NAME), 2);
        hashMap.put(context.getString(R.string.FULL_NAME_1), 2);
        hashMap.put(context.getString(R.string.CN_NAME), 2);
        hashMap.put(context.getString(R.string.NICK_NAME), 5);
        hashMap.put("Nickname", 5);
        hashMap.put(context.getString(R.string.PREFIX_NAME), 3);
        hashMap.put(context.getString(R.string.SUFFIX_NAME), 4);
        hashMap.put("Prefix", 3);
        hashMap.put("Name Prefix", 3);
        hashMap.put("Title", 3);
        hashMap.put("Suffix", 4);
        hashMap.put("Name Suffix", 4);
        hashMap.put("FullName", 2);
        hashMap.put("Name", 9);
        hashMap.put("LastName", 2);
        hashMap.put("Last Name", 2);
        hashMap.put("Given Name", 2);
        hashMap.put("Middle Name", 1);
        hashMap.put("MiddleName", 1);
        hashMap.put("Additional Name", 1);
        hashMap.put("First Name", 0);
        hashMap.put("FirstName", 0);
        hashMap.put("Family Name", 0);
        hashMap.put("Given Name Yomi", 6);
        hashMap.put("Additional Name Yomi", 7);
        hashMap.put("Family Name Yomi", 8);
        hashMap.put(context.getString(R.string.CELL_PHONE_1), 13);
        hashMap.put(context.getString(R.string.CELL_PHONE_2), 13);
        hashMap.put(context.getString(R.string.CELL_PHONE_3), 13);
        hashMap.put(context.getString(R.string.CELL_PHONE_4), 13);
        hashMap.put(context.getString(R.string.CELL_PHONE_5), 13);
        hashMap.put(context.getString(R.string.CELL_PHONE_6), 13);
        hashMap.put(context.getString(R.string.CELL_PHONE_7), 13);
        hashMap.put("Mobile", 13);
        hashMap.put("Mobile Phone", 13);
        hashMap.put("Cell Phone", 13);
        hashMap.put(context.getString(R.string.HOME_PHONE_1), 14);
        hashMap.put(context.getString(R.string.HOME_PHONE_2), 14);
        hashMap.put(context.getString(R.string.HOME_PHONE_3), 14);
        hashMap.put(context.getString(R.string.HOME_PHONE_4), 14);
        hashMap.put("Home Phone", 14);
        hashMap.put("Home Phone 2", 14);
        hashMap.put("Primary Phone", 14);
        hashMap.put(context.getString(R.string.WORK_PHONE_1), 15);
        hashMap.put(context.getString(R.string.WORK_PHONE_2), 15);
        hashMap.put(context.getString(R.string.WORK_PHONE_3), 15);
        hashMap.put(context.getString(R.string.WORK_PHONE_4), 15);
        hashMap.put(context.getString(R.string.WORK_PHONE_5), 15);
        hashMap.put(context.getString(R.string.WORK_PHONE_6), 15);
        hashMap.put(context.getString(R.string.WORK_PHONE_7), 15);
        hashMap.put("Business Phone", 15);
        hashMap.put("Business Phone 2", 15);
        hashMap.put("Work Phone", 15);
        hashMap.put("Primary Phone", 17);
        hashMap.put(context.getString(R.string.MAIN_PHONE_1), 17);
        hashMap.put("pager", 18);
        hashMap.put(context.getString(R.string.PAGER_PHONE_1), 18);
        hashMap.put(context.getString(R.string.OTHER_PHONE_1), 16);
        hashMap.put(context.getString(R.string.OTHER_PHONE_2), 16);
        hashMap.put(context.getString(R.string.OTHER_PHONE_3), 16);
        hashMap.put(context.getString(R.string.OTHER_PHONE_4), 16);
        hashMap.put(context.getString(R.string.OTHER_PHONE_5), 16);
        hashMap.put("Other Phone", 16);
        hashMap.put("Other number", 16);
        hashMap.put(context.getString(R.string.HOME_FAX_1), 22);
        hashMap.put(context.getString(R.string.HOME_FAX_2), 22);
        hashMap.put(context.getString(R.string.HOME_FAX_3), 22);
        hashMap.put(context.getString(R.string.WORK_FAX_1), 23);
        hashMap.put(context.getString(R.string.WORK_FAX_2), 23);
        hashMap.put(context.getString(R.string.WORK_FAX_3), 23);
        hashMap.put(context.getString(R.string.WORK_FAX_4), 23);
        hashMap.put(context.getString(R.string.OTHER_FAX_1), 16);
        hashMap.put(context.getString(R.string.OTHER_FAX_2), 16);
        hashMap.put(context.getString(R.string.OTHER_FAX_3), 16);
        hashMap.put("Home Fax", 22);
        hashMap.put("Business Fax", 23);
        hashMap.put("Work Fax", 23);
        hashMap.put("Other Fax", 16);
        hashMap.put("Fax", 16);
        hashMap.put(context.getString(R.string.HOME_EMAIL_1), 28);
        hashMap.put(context.getString(R.string.HOME_EMAIL_2), 28);
        hashMap.put(context.getString(R.string.HOME_EMAIL_3), 28);
        hashMap.put(context.getString(R.string.HOME_EMAIL_4), 28);
        hashMap.put(context.getString(R.string.HOME_EMAIL_5), 28);
        hashMap.put(context.getString(R.string.WORK_EMAIL_1), 29);
        hashMap.put(context.getString(R.string.WORK_EMAIL_2), 29);
        hashMap.put("Email", 28);
        hashMap.put("Home Email", 28);
        hashMap.put("E-mail Address", 28);
        hashMap.put("E-mail 2 Address", 28);
        hashMap.put("E-mail 3 Address", 28);
        hashMap.put("Home e-mail", 28);
        hashMap.put("Business e-mail", 29);
        hashMap.put("E-mail", 28);
        hashMap.put("E-mail2", 29);
        hashMap.put("Office Email", 29);
        hashMap.put("Others Email", 29);
        hashMap.put(context.getString(R.string.HOME_ADDR_STREET), 44);
        hashMap.put(context.getString(R.string.HOME_ADDR_CITY), 45);
        hashMap.put(context.getString(R.string.HOME_ADDR_POSTCODE), 46);
        hashMap.put(context.getString(R.string.HOME_ADDR_REGION), 47);
        hashMap.put(context.getString(R.string.HOME_ADDR_COUNTRY), 48);
        hashMap.put(context.getString(R.string.EXT_DATA_2), 62);
        hashMap.put("Address", 62);
        hashMap.put("Home Address", 62);
        hashMap.put("General extension", 62);
        hashMap.put("Home Address(addr)", 62);
        hashMap.put("Office Address(addr)", 62);
        hashMap.put("Others Address(addr)", 62);
        hashMap.put(context.getString(R.string.HOME_ADDR_STREET_2), 44);
        hashMap.put("Street", 44);
        hashMap.put("Home Street", 44);
        hashMap.put("Home Street 2", 44);
        hashMap.put("Home Street 3", 44);
        hashMap.put("General street", 44);
        hashMap.put(context.getString(R.string.HOME_ADDR_CITY_2), 45);
        hashMap.put("City", 45);
        hashMap.put("Home City", 45);
        hashMap.put("General city", 45);
        hashMap.put(context.getString(R.string.HOME_ADDR_POSTCODE_2), 46);
        hashMap.put("Postal/ZIP code", 46);
        hashMap.put("General postal", 46);
        hashMap.put("Home Postal Code", 46);
        hashMap.put(context.getString(R.string.HOME_ADDR_REGION_2), 47);
        hashMap.put("State/province", 47);
        hashMap.put("General state/province", 47);
        hashMap.put("Home State", 47);
        hashMap.put(context.getString(R.string.HOME_ADDR_COUNTRY_2), 48);
        hashMap.put("Country", 48);
        hashMap.put("General country", 48);
        hashMap.put("Home Country", 48);
        hashMap.put("Home Address PO Box", 49);
        hashMap.put(context.getString(R.string.HOME_ADDR_POBOX_3), 49);
        hashMap.put(context.getString(R.string.HOME_ADDR_STREET_3), 44);
        hashMap.put(context.getString(R.string.HOME_ADDR_CITY_3), 45);
        hashMap.put(context.getString(R.string.HOME_ADDR_POSTCODE_3), 46);
        hashMap.put(context.getString(R.string.HOME_ADDR_REGION_3), 47);
        hashMap.put(context.getString(R.string.HOME_ADDR_COUNTRY_3), 48);
        hashMap.put(context.getString(R.string.HOME_ADDR_POBOX_4), 49);
        hashMap.put(context.getString(R.string.HOME_ADDR_STREET_4), 44);
        hashMap.put(context.getString(R.string.HOME_ADDR_CITY_4), 45);
        hashMap.put(context.getString(R.string.HOME_ADDR_POSTCODE_4), 46);
        hashMap.put(context.getString(R.string.HOME_ADDR_REGION_4), 47);
        hashMap.put(context.getString(R.string.HOME_ADDR_COUNTRY_4), 48);
        hashMap.put("Business Street", 50);
        hashMap.put("Business Street 2", 50);
        hashMap.put("Business Street 3", 50);
        hashMap.put("Business City", 51);
        hashMap.put("Business Postal Code", 52);
        hashMap.put("Business State", 53);
        hashMap.put("Business Country", 54);
        hashMap.put("Business Postal Code", 55);
        hashMap.put(context.getString(R.string.WORK_ADDR_STREET), 50);
        hashMap.put(context.getString(R.string.WORK_ADDR_CITY), 51);
        hashMap.put(context.getString(R.string.WORK_ADDR_POSTCODE), 52);
        hashMap.put(context.getString(R.string.WORK_ADDR_REGION), 53);
        hashMap.put(context.getString(R.string.WORK_ADDR_COUNTRY), 54);
        hashMap.put(context.getString(R.string.WORK_ADDRESS), 50);
        hashMap.put(context.getString(R.string.WORK_ADDR_POBOX_2), 55);
        hashMap.put(context.getString(R.string.WORK_ADDR_STREET_2), 50);
        hashMap.put(context.getString(R.string.WORK_ADDR_CITY_2), 51);
        hashMap.put(context.getString(R.string.WORK_ADDR_POSTCODE_2), 52);
        hashMap.put(context.getString(R.string.WORK_ADDR_REGION_2), 53);
        hashMap.put(context.getString(R.string.WORK_ADDR_COUNTRY_2), 54);
        hashMap.put(context.getString(R.string.HOME_WEB_1), 33);
        hashMap.put(context.getString(R.string.HOME_WEB_2), 33);
        hashMap.put("URL", 33);
        hashMap.put(context.getString(R.string.HOME_WEB_3), 33);
        hashMap.put(context.getString(R.string.HOME_WEB_4), 33);
        hashMap.put(context.getString(R.string.HOME_WEB_5), 33);
        hashMap.put(context.getString(R.string.WORK_WEB_1), 34);
        hashMap.put(context.getString(R.string.WORK_WEB_2), 34);
        hashMap.put(context.getString(R.string.OTHER_WEB_1), 35);
        hashMap.put("VOIP", 35);
        hashMap.put("General VOIP address", 35);
        hashMap.put("Web Page", 33);
        hashMap.put("Internet Free Busy", 34);
        hashMap.put("Home Page", 33);
        hashMap.put("Blog", 33);
        hashMap.put("Work Website", 33);
        hashMap.put("Others Website", 35);
        hashMap.put(context.getString(R.string.ORG_NAME), 71);
        hashMap.put(context.getString(R.string.ORG_NAME_2), 71);
        hashMap.put(context.getString(R.string.ORG_TITLE), 72);
        hashMap.put("Position", 72);
        hashMap.put("Company", 71);
        hashMap.put("Job Title", 72);
        hashMap.put("Job title", 72);
        hashMap.put(context.getString(R.string.PERSON_NOTE_1), 39);
        hashMap.put(context.getString(R.string.PERSON_NOTE_2), 39);
        hashMap.put(context.getString(R.string.PERSON_NOTE_3), 39);
        hashMap.put("Note", 39);
        hashMap.put("Notes", 40);
        hashMap.put(context.getString(R.string.BIRTHDAY_DATA), 76);
        hashMap.put("Birthday", 76);
        hashMap.put("Date of birth", 76);
        hashMap.put(context.getString(R.string.ANNIVERSARY_DATA), 77);
        hashMap.put(context.getString(R.string.GROUPS_DATA), 66);
        hashMap.put("Group", 66);
        hashMap.put("Group Membership", 67);
        hashMap.put(context.getString(R.string.NICKNAME_DATA), 81);
        hashMap.put("Nickname", 81);
    }

    public String a(int i10) {
        return this.f1309d[i10];
    }

    public String[] b() {
        return this.f1309d;
    }

    public boolean c() {
        return this.f1306a;
    }

    public boolean d() {
        return this.f1307b;
    }

    public String e() {
        return this.f1308c;
    }

    public void g(int i10, String str) {
        this.f1309d[i10] = str;
    }

    public void h(String str) {
        if (!TextUtils.isEmpty(str)) {
            g(2, str);
        }
    }

    public void i(String str) {
        this.f1308c = str;
    }

    public void j(int i10) {
        g(1, String.valueOf(i10));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        while (true) {
            String[] strArr = this.f1309d;
            if (i10 != strArr.length) {
                if (!TextUtils.isEmpty(strArr[i10])) {
                    sb.append("data");
                    sb.append(String.valueOf(i10 + 1));
                    sb.append(" = ");
                    sb.append(this.f1309d[i10]);
                    sb.append(", ");
                }
                i10++;
            } else {
                return sb.toString();
            }
        }
    }
}
