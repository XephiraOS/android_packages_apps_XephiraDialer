package com.oua.ocr;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes4.dex */
public class ContactInfo {
    public static final HashSet<Integer> CJK = new HashSet<>(Arrays.asList(5, 6, 22, 23));
    static final String KEY_LABEL = "LABEL";
    static final String KEY_VALUE = "VALUE";
    public static final int TYPE_ADDRESS = 5;
    public static final int TYPE_ANNIVERSARY = 8;
    public static final int TYPE_AVATAR = 12;
    public static final int TYPE_COMPANY = 4;
    public static final int TYPE_COMPANY_REGISTER_CODE = 14;
    public static final int TYPE_EMAIL = 2;
    public static final int TYPE_IM = 7;
    public static final int TYPE_NAME = 1;
    public static final int TYPE_NICKNAME = 11;
    public static final int TYPE_NOTE = 10;
    public static final int TYPE_PHONE = 3;
    private static final int TYPE_PHOTO = 13;
    public static final int TYPE_SNS = 9;
    public static final int TYPE_WEBSITE = 6;

    /* loaded from: classes4.dex */
    public static class AddressItem extends ContactItem {
        public static final int SUBTYPE_HOME = 1;
        public static final int SUBTYPE_OTHER = 3;
        public static final int SUBTYPE_WORK = 2;
        String Address;
        String City;
        String Country;
        String PostCode;
        String Province;
        String Street;

        public AddressItem(String str) {
            super(5, 2, str, "WORK");
        }

        public String getAddress() {
            return this.Address;
        }

        public String getCity() {
            return this.City;
        }

        public String getCountry() {
            return this.Country;
        }

        public String getPostCode() {
            return this.PostCode;
        }

        public String getProvince() {
            return this.Province;
        }

        public String getStreet() {
            return this.Street;
        }

        public AddressItem(String str, String str2, String str3, String str4, String str5) {
            super(5, 2, str, "WORK");
            this.Country = str2;
            this.Province = str3;
            this.City = str4;
            this.PostCode = str5;
        }
    }

    /* loaded from: classes4.dex */
    public static class AvatarItem extends ContactItem {
        private byte[] data;

        public AvatarItem(String str, byte[] bArr) {
            super(12, 0, null, null);
            this.data = bArr;
        }

        public byte[] getData() {
            return this.data;
        }
    }

    /* loaded from: classes4.dex */
    public static class CompanyItem extends ContactItem {
        String Company;
        String Department;
        String Title;

        public CompanyItem(String str, char c10) {
            super(4, 0, null, null);
            this.Company = new String();
            this.Department = new String();
            this.Title = new String();
            if (c10 == 'c') {
                this.Company = str;
            }
            if (c10 == 't') {
                this.Title = str;
            }
            if (c10 == 'd') {
                this.Department = str;
            }
        }

        public String getCompany() {
            return this.Company;
        }

        public String getDepartment() {
            return this.Department;
        }

        public String getTitle() {
            return this.Title;
        }

        @Override // com.oua.ocr.ContactInfo.ContactItem
        public String[] getValues() {
            return new String[]{this.Company, this.Department, this.Title};
        }

        public void setCompany(String str) {
            this.Company = str;
        }

        public void setDepartment(String str) {
            this.Department = str;
        }

        public void setTitle(String str) {
            this.Title = str;
        }

        @Override // com.oua.ocr.ContactInfo.ContactItem
        public String toString() {
            return String.valueOf(this.Company) + " " + this.Department + " " + this.Title;
        }
    }

    /* loaded from: classes4.dex */
    public static class CompanyNumItem extends ContactItem {
        public CompanyNumItem(String str) {
            super(14, 0, str, null);
        }

        public CompanyNumItem(String[] strArr, String str) {
            super(strArr, str, null);
            this.type = 11;
        }
    }

    /* loaded from: classes4.dex */
    public static class EmailItem extends ContactItem {
        public static final int SUBTYPE_HOME = 1;
        public static final int SUBTYPE_MOBILE = 4;
        public static final int SUBTYPE_OTHER = 3;
        public static final int SUBTYPE_WORK = 2;

        public EmailItem(String str) {
            super(2, 2, str, "WORK");
        }

        public EmailItem(int i10, String str, String str2) {
            super(2, i10, str, str2);
        }

        public EmailItem(String[] strArr, String str) {
            super(strArr, str, null);
            this.type = 2;
        }
    }

    /* loaded from: classes4.dex */
    public static class EventItem extends ContactItem {
        public static final int SUBTYPE_ANNIVERSARY = 1;
        public static final int SUBTYPE_BIRTHDAY = 3;
        public static final int SUBTYPE_OTHER = 2;

        public EventItem(int i10, String str, String str2) {
            super(8, i10, str, str2);
        }

        public EventItem(String[] strArr, String str) {
            super(strArr, str, null);
            this.type = 8;
        }
    }

    /* loaded from: classes4.dex */
    public static class IMItem extends ContactItem {
        public static final int SUBTYPE_AIM = 1;
        public static final int SUBTYPE_CUSTOM = 0;
        public static final int SUBTYPE_GOOGLE_TALK = 6;
        public static final int SUBTYPE_ICQ = 7;
        public static final int SUBTYPE_JABBER = 8;
        public static final int SUBTYPE_MSN = 2;
        public static final int SUBTYPE_OTHER = 999;
        public static final int SUBTYPE_QQ = 5;
        public static final int SUBTYPE_SKYPE = 4;
        public static final int SUBTYPE_YAHOO = 3;

        public IMItem(int i10, String str, String str2) {
            super(7, i10, str, str2);
        }

        public IMItem(String[] strArr, String str) {
            super(strArr, str, null);
            this.type = 7;
        }
    }

    /* loaded from: classes4.dex */
    public static class NickNameItem extends ContactItem {
        public NickNameItem(String str) {
            super(11, 0, str, null);
        }

        public NickNameItem(String[] strArr, String str) {
            super(strArr, str, null);
            this.type = 11;
        }
    }

    /* loaded from: classes4.dex */
    public static class PhoneItem extends ContactItem {
        public static final int SUBTYPE_ASSISTANT = 19;
        public static final int SUBTYPE_CALLBACK = 8;
        public static final int SUBTYPE_CAR = 9;
        public static final int SUBTYPE_COMPANY_MAIN = 10;
        public static final int SUBTYPE_FAX_HOME = 5;
        public static final int SUBTYPE_FAX_WORK = 4;
        public static final int SUBTYPE_HOME = 1;
        public static final int SUBTYPE_ISDN = 11;
        public static final int SUBTYPE_MAIN = 12;
        public static final int SUBTYPE_MMS = 20;
        public static final int SUBTYPE_MOBILE = 2;
        public static final int SUBTYPE_OTHER = 7;
        public static final int SUBTYPE_OTHER_FAX = 13;
        public static final int SUBTYPE_PAGER = 6;
        public static final int SUBTYPE_RADIO = 14;
        public static final int SUBTYPE_TELEX = 15;
        public static final int SUBTYPE_TTY_TDD = 16;
        public static final int SUBTYPE_WORK = 3;
        public static final int SUBTYPE_WORK_MOBILE = 17;
        public static final int SUBTYPE_WORK_PAGER = 18;

        public PhoneItem(String str, String str2) {
            super(3, -1, str, str2);
        }

        public PhoneItem(int i10, String str, String str2) {
            super(3, i10, str, str2);
        }

        public PhoneItem(String[] strArr, String str) {
            super(strArr, str, null);
            this.type = 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class SNSItem extends ContactItem {
        public static final int SUBTYPE_BADOO = 13;
        public static final int SUBTYPE_BEBO = 6;
        public static final int SUBTYPE_CYWORLD = 20;
        public static final int SUBTYPE_FACEBOOK = 1;
        public static final int SUBTYPE_FLICKR = 5;
        public static final int SUBTYPE_GOOGLEPLUS = 22;
        public static final int SUBTYPE_GREE = 19;
        public static final int SUBTYPE_KAIXIN = 16;
        public static final int SUBTYPE_LINKEDIN = 3;
        public static final int SUBTYPE_ME2DAY = 21;
        public static final int SUBTYPE_MIXI = 18;
        public static final int SUBTYPE_MYSPACE = 4;
        public static final int SUBTYPE_NETLOG = 12;
        public static final int SUBTYPE_ORKUT = 7;
        public static final int SUBTYPE_OTHER = 999;
        public static final int SUBTYPE_RENREN = 14;
        public static final int SUBTYPE_SKYROCK = 10;
        public static final int SUBTYPE_STUDIVZ = 8;
        public static final int SUBTYPE_TUENTI = 11;
        public static final int SUBTYPE_TWITTER = 2;
        public static final int SUBTYPE_WECHAT = 23;
        public static final int SUBTYPE_WEIBO = 15;
        public static final int SUBTYPE_WHATSAPP = 24;
        public static final int SUBTYPE_WRETCH = 17;
        public static final int SUBTYPE_XING = 9;

        public SNSItem(int i10, String str, String str2) {
            super(9, i10, str, str2);
        }

        public SNSItem(String[] strArr, String str) {
            super(strArr, str, null);
            this.type = 9;
        }
    }

    /* loaded from: classes4.dex */
    public static class WebItem extends ContactItem {
        public static final int SUBTYPE_BLOG = 2;
        public static final int SUBTYPE_FTP = 6;
        public static final int SUBTYPE_HOME = 4;
        public static final int SUBTYPE_HOMEPAGE = 1;
        public static final int SUBTYPE_OTHER = 7;
        public static final int SUBTYPE_PROFILE = 3;
        public static final int SUBTYPE_WORK = 5;

        public WebItem(String str) {
            super(6, 5, str, "WORK");
        }

        public WebItem(int i10, String str, String str2) {
            super(6, i10, str, str2);
        }

        public WebItem(String[] strArr, String str) {
            super(strArr, str, null);
            this.type = 6;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class ContactItem {
        public static final int SUBTYPE_CUSTOME = 0;
        public String label;
        public int subType;
        public int type;
        private String value;

        public ContactItem(int i10, int i11, String str, String str2) {
            this.value = str;
            this.type = i10;
            this.subType = i11 == -1 ? labelToType(str2) : i11;
            this.label = i11 != -1 ? typeToLabel(i11, str2) : str2;
        }

        private int labelToType(String str) {
            try {
                for (Field field : getClass().getFields()) {
                    String name = field.getName();
                    int indexOf = name.indexOf("SUBTYPE_");
                    if (indexOf != -1 && name.substring(indexOf + 8).equals(str)) {
                        return field.getInt(this);
                    }
                }
                return 0;
            } catch (Exception e10) {
                e10.printStackTrace();
                return 0;
            }
        }

        private String typeToLabel(int i10, String str) {
            if (i10 == 0) {
                return str;
            }
            try {
                for (Field field : getClass().getFields()) {
                    String name = field.getName();
                    int indexOf = name.indexOf("SUBTYPE_");
                    if (indexOf != -1 && field.getInt(this) == i10) {
                        return name.substring(indexOf + 8);
                    }
                }
                return str;
            } catch (Exception e10) {
                e10.printStackTrace();
                return str;
            }
        }

        public String getLabel() {
            return this.label;
        }

        public int getSubType() {
            return this.subType;
        }

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }

        public String[] getValues() {
            return new String[]{this.value};
        }

        public String toString() {
            return getClass().getSimpleName() + "[" + this.subType + "] " + this.value;
        }

        private ContactItem(String[] strArr, String str) {
            this.value = strArr[0];
            int labelToType = labelToType(str);
            this.subType = labelToType;
            if (labelToType == 0) {
                this.label = str;
            }
        }

        public ContactItem(String[] strArr, String str, ContactItem contactItem) {
            this(strArr, str);
        }
    }

    /* loaded from: classes4.dex */
    public static class NameItem extends ContactItem {
        public String firstName;
        public String fullName;
        public String lastName;
        public String middleName;

        public NameItem(String str, String str2, String str3, String str4) {
            super(1, 0, str4, null);
            this.fullName = str4;
            this.firstName = str;
            this.middleName = str2;
            this.lastName = str3;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getMiddleName() {
            return this.middleName;
        }

        @Override // com.oua.ocr.ContactInfo.ContactItem
        public String getValue() {
            return this.fullName;
        }

        @Override // com.oua.ocr.ContactInfo.ContactItem
        public String[] getValues() {
            return new String[]{"", this.firstName, this.middleName, this.lastName, ""};
        }

        @Override // com.oua.ocr.ContactInfo.ContactItem
        public String toString() {
            return String.valueOf(this.firstName) + " " + this.middleName + " " + this.lastName;
        }

        public NameItem(String[] strArr, String str) {
            super(strArr, str, null);
            this.firstName = strArr[1];
            this.middleName = strArr[2];
            this.lastName = strArr[3];
            this.type = 1;
        }
    }
}
