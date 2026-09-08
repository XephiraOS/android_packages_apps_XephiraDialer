package com.customize.contacts.util;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.provider.ContactsContract;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: NameCardParseUtils.java */
/* loaded from: classes3.dex */
public class P {
    public static void a(String str, int i10, String str2, String str3, String str4, String str5, String str6, ArrayList<ContentValues> arrayList, ArrayList<ContentProviderOperation> arrayList2, boolean z10, int i11) {
        ContentValues contentValues = new ContentValues();
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
        if (z10) {
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data2", Integer.valueOf(i10));
        } else {
            newInsert.withValueBackReference("raw_contact_id", i11);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/postal-address_v2");
            newInsert.withValue("data2", Integer.valueOf(i10));
        }
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                contentValues.put("data1", str);
            } else {
                newInsert.withValue("data1", str);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if (z10) {
                contentValues.put("data10", str2);
            } else {
                newInsert.withValue("data10", str2);
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            if (z10) {
                contentValues.put("data8", str3);
            } else {
                newInsert.withValue("data8", str3);
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            if (z10) {
                contentValues.put("data7", str4);
            } else {
                newInsert.withValue("data7", str4);
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            if (z10) {
                contentValues.put("data4", str5);
            } else {
                newInsert.withValue("data4", str5);
            }
        }
        if (!TextUtils.isEmpty(str6)) {
            if (z10) {
                contentValues.put("data9", str6);
            } else {
                newInsert.withValue("data9", str6);
            }
        }
        if (z10) {
            arrayList.add(contentValues);
        } else {
            arrayList2.add(newInsert.build());
        }
    }

    public static void b(StringBuilder sb, StringBuilder sb2, StringBuilder sb3, ArrayList<ContentValues> arrayList, ArrayList<ContentProviderOperation> arrayList2, boolean z10, int i10) {
        StringBuilder sb4 = new StringBuilder();
        if (sb2.length() > 0) {
            sb4.append(sb2.toString());
        }
        if (sb3.length() > 0) {
            if (sb4.length() > 0) {
                sb4.append(" ");
            }
            sb4.append(sb3.toString());
        }
        if (sb.length() > 0 || sb4.length() > 0) {
            ContentValues contentValues = new ContentValues();
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
            if (z10) {
                contentValues.put("mimetype", "vnd.android.cursor.item/organization");
            } else {
                newInsert.withValueBackReference("raw_contact_id", i10);
                newInsert.withValue("mimetype", "vnd.android.cursor.item/organization");
            }
            if (sb.length() > 0) {
                if (z10) {
                    contentValues.put("data1", sb.toString());
                } else {
                    newInsert.withValue("data1", sb.toString());
                }
            }
            if (sb4.length() > 0) {
                if (z10) {
                    contentValues.put("data4", sb4.toString());
                } else {
                    newInsert.withValue("data4", sb4.toString());
                }
            }
            if (z10) {
                arrayList.add(contentValues);
            } else {
                arrayList2.add(newInsert.build());
            }
        }
    }

    public static void c(String str, int i10, ArrayList<ContentValues> arrayList, ArrayList<ContentProviderOperation> arrayList2, boolean z10, int i11) {
        if (z10) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/email_v2");
            contentValues.put("data1", str);
            if (i10 == -1) {
                contentValues.put("data2", (Integer) 2);
            } else {
                contentValues.put("data2", Integer.valueOf(i10));
            }
            arrayList.add(contentValues);
            return;
        }
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
        newInsert.withValueBackReference("raw_contact_id", i11);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/email_v2");
        newInsert.withValue("data1", str);
        if (i10 == -1) {
            newInsert.withValue("data2", 2);
        } else {
            newInsert.withValue("data2", Integer.valueOf(i10));
        }
        arrayList2.add(newInsert.build());
    }

    public static void d(String str, int i10, String str2, ArrayList<ContentValues> arrayList, ArrayList<ContentProviderOperation> arrayList2, boolean z10, int i11) {
        if (z10) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/im");
            contentValues.put("data1", str);
            if (i10 == -1) {
                contentValues.put("data2", (Integer) 2);
                contentValues.put("data5", (Integer) (-1));
                contentValues.put("data6", str2);
            } else {
                contentValues.put("data2", (Integer) 3);
                contentValues.put("data5", Integer.valueOf(i10));
                contentValues.put("data6", str2);
            }
            arrayList.add(contentValues);
            return;
        }
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
        newInsert.withValueBackReference("raw_contact_id", i11);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/im");
        newInsert.withValue("data1", str);
        if (i10 == -1) {
            newInsert.withValue("data2", 2);
            newInsert.withValue("data5", -1);
            newInsert.withValue("data6", str2);
        } else {
            newInsert.withValue("data2", 3);
            newInsert.withValue("data5", Integer.valueOf(i10));
            newInsert.withValue("data6", str2);
        }
        arrayList2.add(newInsert.build());
    }

    public static void e(String str, String str2, String str3, String str4, String str5, ArrayList<ContentValues> arrayList, ArrayList<ContentProviderOperation> arrayList2, boolean z10, int i10) {
        ContentValues contentValues = new ContentValues();
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
        if (z10) {
            contentValues.put("mimetype", "vnd.android.cursor.item/name");
        } else {
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
        }
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                contentValues.put("data3", str);
            } else {
                newInsert.withValue("data3", str);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if (z10) {
                contentValues.put("data5", str2);
            } else {
                newInsert.withValue("data5", str2);
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            if (z10) {
                contentValues.put("data2", str3);
            } else {
                newInsert.withValue("data2", str3);
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            if (z10) {
                contentValues.put("data4", str4);
            } else {
                newInsert.withValue("data4", str4);
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            if (z10) {
                contentValues.put("data6", str5);
            } else {
                newInsert.withValue("data6", str5);
            }
        }
        if (z10) {
            arrayList.add(contentValues);
        } else {
            arrayList2.add(newInsert.build());
        }
    }

    public static void f(String str, ArrayList<ContentValues> arrayList, ArrayList<ContentProviderOperation> arrayList2, boolean z10, int i10) {
        if (z10) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
            contentValues.put("data1", str);
            arrayList.add(contentValues);
            return;
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
        }
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
        newInsert.withValueBackReference("raw_contact_id", i10);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/website");
        newInsert.withValue("data1", str);
        arrayList2.add(newInsert.build());
    }

    public static void g(String str, int i10, ArrayList<ContentValues> arrayList, ArrayList<ContentProviderOperation> arrayList2, boolean z10, int i11) {
        if (z10) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data1", str);
            contentValues.put("data2", Integer.valueOf(i10));
            arrayList.add(contentValues);
            return;
        }
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
        newInsert.withValueBackReference("raw_contact_id", i11);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        newInsert.withValue("data1", str);
        newInsert.withValue("data2", Integer.valueOf(i10));
        arrayList2.add(newInsert.build());
    }

    public static void h(String str, int i10, String str2, ArrayList<ContentValues> arrayList, ArrayList<ContentProviderOperation> arrayList2, boolean z10, int i11) {
        if (z10) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/im");
            contentValues.put("data1", str);
            if (i10 == -1) {
                contentValues.put("data2", (Integer) 2);
                contentValues.put("data5", (Integer) (-1));
                contentValues.put("data6", str2);
            } else {
                contentValues.put("data2", (Integer) 3);
                contentValues.put("data5", Integer.valueOf(i10));
                contentValues.put("data6", str2);
            }
            arrayList.add(contentValues);
            return;
        }
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
        newInsert.withValueBackReference("raw_contact_id", i11);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/im");
        newInsert.withValue("data1", str);
        if (i10 == -1) {
            newInsert.withValue("data2", 2);
            newInsert.withValue("data5", -1);
            newInsert.withValue("data6", str2);
        } else {
            newInsert.withValue("data2", 3);
            newInsert.withValue("data5", Integer.valueOf(i10));
            newInsert.withValue("data6", str2);
        }
        arrayList2.add(newInsert.build());
    }

    public static void i(String str, ArrayList<ContentValues> arrayList, ArrayList<ContentProviderOperation> arrayList2, boolean z10, int i10) {
        if (z10) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/website");
            contentValues.put("data1", str);
            arrayList.add(contentValues);
            return;
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
        }
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
        newInsert.withValueBackReference("raw_contact_id", i10);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/website");
        newInsert.withValue("data1", str);
        arrayList2.add(newInsert.build());
    }
}
