package com.customize.contacts.activities;

import U3.f;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.android.contacts.activities.RequestPermissionsActivity;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.model.Account;
import com.oplus.dialer.R;
import com.oua.ocr.ContactInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class RecognizeNameCardActivity extends BasicActivity {

    /* renamed from: y, reason: collision with root package name */
    public static ThreadPoolExecutor f20541y;

    /* renamed from: z, reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f20542z;

    /* renamed from: q, reason: collision with root package name */
    public Context f20545q;

    /* renamed from: o, reason: collision with root package name */
    public String f20543o = "";

    /* renamed from: p, reason: collision with root package name */
    public String f20544p = "";

    /* renamed from: r, reason: collision with root package name */
    public long f20546r = -1;

    /* renamed from: x, reason: collision with root package name */
    public boolean f20547x = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: com.customize.contacts.activities.RecognizeNameCardActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0200a implements Runnable {
            public RunnableC0200a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.oplus.foundation.util.ui.c.d(RecognizeNameCardActivity.this, R.string.oplus_init_bcrsdk_failed);
                RecognizeNameCardActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (URLUtil.isContentUrl(RecognizeNameCardActivity.this.f20544p)) {
                RecognizeNameCardActivity recognizeNameCardActivity = RecognizeNameCardActivity.this;
                recognizeNameCardActivity.f20544p = recognizeNameCardActivity.z1(recognizeNameCardActivity.f20544p);
            }
            if (U3.f.i().j(RecognizeNameCardActivity.this)) {
                RecognizeNameCardActivity.this.f20547x = true;
            }
            Account account = new Account(R0.a.f3165a, R0.a.f3166b);
            long j10 = N3.b.j(RecognizeNameCardActivity.this.f20545q, "Business Card in ColorOS", account);
            if (j10 == -1) {
                j10 = N3.b.g(RecognizeNameCardActivity.this.f20545q, account);
            }
            RecognizeNameCardActivity.this.f20546r = j10;
            if (!RecognizeNameCardActivity.this.f20547x) {
                RecognizeNameCardActivity.this.runOnUiThread(new RunnableC0200a());
            }
            RecognizeNameCardActivity recognizeNameCardActivity2 = RecognizeNameCardActivity.this;
            recognizeNameCardActivity2.D1(recognizeNameCardActivity2.f20544p);
        }
    }

    private void E1(String str, boolean z10) {
        if (TextUtils.equals(str, this.f20543o) && !z10) {
            H7.b.b("RecognizeNameCardActivity", "this business card is being recognized");
            return;
        }
        this.f20543o = str;
        if (H7.a.b()) {
            H7.b.b("RecognizeNameCardActivity", "recognize path = " + str + ", offline = " + z10);
        }
        U3.f.i().h(str, new f.a() { // from class: com.customize.contacts.activities.l0
            @Override // U3.f.a
            public final void a(Object obj) {
                RecognizeNameCardActivity.this.B1((List) obj);
            }
        }, new f.a() { // from class: com.customize.contacts.activities.m0
            @Override // U3.f.a
            public final void a(Object obj) {
                RecognizeNameCardActivity.this.C1((Exception) obj);
            }
        });
    }

    public final ArrayList<ContentProviderOperation> A1(Context context, ArrayList<ContentProviderOperation> arrayList, List<ContactInfo.ContactItem> list, boolean z10) {
        ArrayList<ContentProviderOperation> arrayList2;
        ArrayList<ContentProviderOperation> arrayList3;
        int i10;
        ArrayList<? extends Parcelable> arrayList4;
        ArrayList arrayList5;
        String str;
        String str2;
        String str3;
        String str4;
        int i11;
        ArrayList<? extends Parcelable> arrayList6;
        String str5;
        ArrayList<ContentProviderOperation> arrayList7;
        int i12;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i13;
        int i14;
        RecognizeNameCardActivity recognizeNameCardActivity = this;
        H7.b.b("RecognizeNameCardActivity", "handleRecognizedResult2");
        if (list == null) {
            return null;
        }
        String str11 = "account_name";
        if (z10) {
            arrayList3 = arrayList;
            arrayList4 = new ArrayList<>();
            i10 = 0;
        } else {
            if (arrayList == null) {
                arrayList2 = new ArrayList<>();
            } else {
                arrayList2 = arrayList;
            }
            int size = arrayList2.size();
            if (size >= 100) {
                arrayList2 = new ArrayList<>();
                size = arrayList2.size();
            }
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.RawContacts.CONTENT_URI));
            newInsert.withValue("account_name", R0.a.f3165a);
            newInsert.withValue("account_type", R0.a.f3166b);
            arrayList2.add(newInsert.build());
            ContentProviderOperation.Builder newInsert2 = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
            newInsert2.withValueBackReference("raw_contact_id", size);
            newInsert2.withValue("mimetype", "vnd.android.cursor.item/group_membership");
            newInsert2.withValue("data1", Long.valueOf(recognizeNameCardActivity.f20546r));
            arrayList2.add(newInsert2.build());
            arrayList3 = arrayList2;
            i10 = size;
            arrayList4 = null;
        }
        ArrayList arrayList8 = (ArrayList) list;
        if (H7.a.b()) {
            H7.b.b("RecognizeNameCardActivity", "constructInsertOperations items size = " + arrayList8.size() + " ,backReferenceIndex = " + i10 + " ,isSingleMode = " + z10);
        }
        Iterator it = arrayList8.iterator();
        String str12 = "";
        String str13 = str12;
        String str14 = str13;
        String str15 = str14;
        ArrayList arrayList9 = null;
        while (it.hasNext()) {
            ContactInfo.ContactItem contactItem = (ContactInfo.ContactItem) it.next();
            if (contactItem == null) {
                arrayList5 = arrayList9;
                str = str12;
                str2 = str13;
                str3 = str14;
                str4 = str15;
                i11 = i10;
                arrayList6 = arrayList4;
            } else {
                if (H7.a.b()) {
                    H7.b.b("RecognizeNameCardActivity", "items type = " + contactItem.getType() + " , items value = " + contactItem.getValue());
                }
                if (contactItem.getType() == 1) {
                    ContactInfo.NameItem nameItem = (ContactInfo.NameItem) contactItem;
                    String firstName = nameItem.getFirstName();
                    String lastName = nameItem.getLastName();
                    String middleName = nameItem.getMiddleName();
                    String value = nameItem.getValue();
                    if (TextUtils.isEmpty(firstName) && TextUtils.isEmpty(middleName) && TextUtils.isEmpty(lastName)) {
                        str14 = firstName;
                        str13 = lastName;
                        str12 = middleName;
                        str15 = value;
                    } else {
                        int i15 = i10;
                        com.customize.contacts.util.P.e(lastName, middleName, firstName, null, null, arrayList4, arrayList3, z10, i15);
                        arrayList6 = arrayList4;
                        arrayList7 = arrayList3;
                        str14 = firstName;
                        str13 = lastName;
                        str12 = middleName;
                        str15 = value;
                        arrayList9 = arrayList9;
                        i12 = i15;
                    }
                } else {
                    ArrayList arrayList10 = arrayList9;
                    i11 = i10;
                    ArrayList<? extends Parcelable> arrayList11 = arrayList4;
                    if (contactItem.getType() == 4) {
                        if (arrayList10 == null) {
                            arrayList9 = new ArrayList();
                        } else {
                            arrayList9 = arrayList10;
                        }
                        arrayList9.add((ContactInfo.CompanyItem) contactItem);
                        i12 = i11;
                        arrayList6 = arrayList11;
                        arrayList7 = arrayList3;
                    } else {
                        arrayList5 = arrayList10;
                        if (contactItem.getType() == 3) {
                            ContactInfo.PhoneItem phoneItem = (ContactInfo.PhoneItem) contactItem;
                            String value2 = phoneItem.getValue();
                            int subType = phoneItem.getSubType();
                            if (TextUtils.isEmpty(value2)) {
                                arrayList6 = arrayList11;
                                str = str12;
                                str2 = str13;
                                str3 = str14;
                                str4 = str15;
                            } else {
                                str6 = str12;
                                str7 = str13;
                                str8 = str14;
                                com.customize.contacts.util.P.g(value2, subType, arrayList11, arrayList3, z10, i11);
                            }
                        } else {
                            str6 = str12;
                            str7 = str13;
                            str8 = str14;
                            if (contactItem.getType() == 2) {
                                ContactInfo.EmailItem emailItem = (ContactInfo.EmailItem) contactItem;
                                String value3 = emailItem.getValue();
                                int subType2 = emailItem.getSubType();
                                if (!TextUtils.isEmpty(value3)) {
                                    com.customize.contacts.util.P.c(value3, subType2, arrayList11, arrayList3, z10, i11);
                                }
                            } else {
                                if (contactItem.getType() == 7) {
                                    ContactInfo.IMItem iMItem = (ContactInfo.IMItem) contactItem;
                                    String value4 = iMItem.getValue();
                                    int subType3 = iMItem.getSubType() - 1;
                                    String label = iMItem.getLabel();
                                    if (!TextUtils.isEmpty(value4)) {
                                        if (H7.a.b()) {
                                            H7.b.b("RecognizeNameCardActivity", "im type = " + subType3 + " ,label = " + label);
                                        }
                                        if (subType3 > 15) {
                                            i14 = -1;
                                        } else {
                                            i14 = subType3;
                                        }
                                        if (TextUtils.isEmpty(label)) {
                                            label = recognizeNameCardActivity.f20545q.getString(R.string.contact_other);
                                        }
                                        str5 = str11;
                                        str9 = str15;
                                        com.customize.contacts.util.P.d(value4, i14, label, arrayList11, arrayList3, z10, i11);
                                    }
                                } else {
                                    str5 = str11;
                                    str9 = str15;
                                    if (contactItem.getType() == 9) {
                                        ContactInfo.SNSItem sNSItem = (ContactInfo.SNSItem) contactItem;
                                        String value5 = sNSItem.getValue();
                                        String label2 = sNSItem.getLabel();
                                        if (H7.a.b()) {
                                            H7.b.b("RecognizeNameCardActivity", "sns = " + sNSItem.getValue() + " ,getLabel = " + sNSItem.getLabel() + " ,getSubType = " + sNSItem.getSubType() + " ,getType = " + sNSItem.getType());
                                        }
                                        if (TextUtils.isEmpty(value5)) {
                                            str3 = str8;
                                            str2 = str7;
                                            arrayList7 = arrayList3;
                                            str = str6;
                                            str4 = str9;
                                            arrayList6 = arrayList11;
                                            arrayList3 = arrayList7;
                                            arrayList4 = arrayList6;
                                            arrayList9 = arrayList5;
                                            str15 = str4;
                                            str14 = str3;
                                            str11 = str5;
                                            str13 = str2;
                                            str12 = str;
                                            recognizeNameCardActivity = this;
                                            i10 = i11;
                                        } else {
                                            if (contactItem.getSubType() == 23) {
                                                label2 = recognizeNameCardActivity.f20545q.getString(R.string.imProtocolWeChat);
                                                i13 = 15;
                                            } else {
                                                i13 = -1;
                                            }
                                            if (TextUtils.isEmpty(label2)) {
                                                label2 = recognizeNameCardActivity.f20545q.getString(R.string.contact_other);
                                            }
                                            com.customize.contacts.util.P.h(value5, i13, label2, arrayList11, arrayList3, z10, i11);
                                        }
                                    } else {
                                        if (contactItem.getType() == 5) {
                                            ContactInfo.AddressItem addressItem = (ContactInfo.AddressItem) contactItem;
                                            String country = addressItem.getCountry();
                                            String province = addressItem.getProvince();
                                            String city = addressItem.getCity();
                                            String street = addressItem.getStreet();
                                            String postCode = addressItem.getPostCode();
                                            String value6 = addressItem.getValue();
                                            int subType4 = addressItem.getSubType();
                                            if (H7.a.b()) {
                                                str3 = str8;
                                                StringBuilder sb = new StringBuilder();
                                                str10 = str7;
                                                sb.append("country = ");
                                                sb.append(country);
                                                sb.append(" ,provice = ");
                                                sb.append(province);
                                                sb.append(" ,city = ");
                                                sb.append(city);
                                                sb.append(" ,street = ");
                                                sb.append(street);
                                                sb.append(" ,postcode = ");
                                                sb.append(postCode);
                                                sb.append(" ,addr = ");
                                                sb.append(addressItem.getAddress());
                                                H7.b.b("RecognizeNameCardActivity", sb.toString());
                                            } else {
                                                str3 = str8;
                                                str10 = str7;
                                            }
                                            if (TextUtils.isEmpty(country) && TextUtils.isEmpty(province) && TextUtils.isEmpty(city) && TextUtils.isEmpty(street) && TextUtils.isEmpty(postCode)) {
                                                arrayList6 = arrayList11;
                                                arrayList7 = arrayList3;
                                                str = str6;
                                                str4 = str9;
                                                str2 = str10;
                                                arrayList3 = arrayList7;
                                                arrayList4 = arrayList6;
                                                arrayList9 = arrayList5;
                                                str15 = str4;
                                                str14 = str3;
                                                str11 = str5;
                                                str13 = str2;
                                                str12 = str;
                                                recognizeNameCardActivity = this;
                                                i10 = i11;
                                            } else {
                                                arrayList6 = arrayList11;
                                                str2 = str10;
                                                str3 = str3;
                                                arrayList7 = arrayList3;
                                                str = str6;
                                                str4 = str9;
                                                i12 = i11;
                                                com.customize.contacts.util.P.a(value6, subType4, country, province, city, street, postCode, arrayList6, arrayList3, z10, i12);
                                            }
                                        } else {
                                            str3 = str8;
                                            str2 = str7;
                                            arrayList7 = arrayList3;
                                            str = str6;
                                            str4 = str9;
                                            if (contactItem.getType() == 11) {
                                                String value7 = ((ContactInfo.NickNameItem) contactItem).getValue();
                                                if (TextUtils.isEmpty(value7)) {
                                                    arrayList6 = arrayList11;
                                                    arrayList3 = arrayList7;
                                                    arrayList4 = arrayList6;
                                                    arrayList9 = arrayList5;
                                                    str15 = str4;
                                                    str14 = str3;
                                                    str11 = str5;
                                                    str13 = str2;
                                                    str12 = str;
                                                    recognizeNameCardActivity = this;
                                                    i10 = i11;
                                                } else {
                                                    arrayList6 = arrayList11;
                                                    com.customize.contacts.util.P.f(value7, arrayList6, arrayList7, true, 0);
                                                }
                                            } else {
                                                arrayList6 = arrayList11;
                                                if (contactItem.getType() == 6) {
                                                    String value8 = ((ContactInfo.WebItem) contactItem).getValue();
                                                    if (TextUtils.isEmpty(value8)) {
                                                        arrayList3 = arrayList7;
                                                        arrayList4 = arrayList6;
                                                        arrayList9 = arrayList5;
                                                        str15 = str4;
                                                        str14 = str3;
                                                        str11 = str5;
                                                        str13 = str2;
                                                        str12 = str;
                                                        recognizeNameCardActivity = this;
                                                        i10 = i11;
                                                    } else {
                                                        i12 = i11;
                                                        com.customize.contacts.util.P.i(value8, arrayList6, arrayList7, z10, i12);
                                                    }
                                                }
                                            }
                                            i12 = i11;
                                        }
                                        arrayList9 = arrayList5;
                                        str15 = str4;
                                        str14 = str3;
                                        str13 = str2;
                                        str12 = str;
                                        arrayList3 = arrayList7;
                                        arrayList4 = arrayList6;
                                        i10 = i12;
                                        str11 = str5;
                                        recognizeNameCardActivity = this;
                                    }
                                }
                                str3 = str8;
                                str2 = str7;
                                arrayList7 = arrayList3;
                                str = str6;
                                str4 = str9;
                                i12 = i11;
                                arrayList6 = arrayList11;
                                arrayList9 = arrayList5;
                                str15 = str4;
                                str14 = str3;
                                str13 = str2;
                                str12 = str;
                                arrayList3 = arrayList7;
                                arrayList4 = arrayList6;
                                i10 = i12;
                                str11 = str5;
                                recognizeNameCardActivity = this;
                            }
                            str4 = str15;
                            str3 = str8;
                            str2 = str7;
                            arrayList7 = arrayList3;
                            str = str6;
                            str5 = str11;
                            arrayList6 = arrayList11;
                            arrayList3 = arrayList7;
                            arrayList4 = arrayList6;
                            arrayList9 = arrayList5;
                            str15 = str4;
                            str14 = str3;
                            str11 = str5;
                            str13 = str2;
                            str12 = str;
                            recognizeNameCardActivity = this;
                            i10 = i11;
                        }
                        str4 = str15;
                        str3 = str8;
                        str2 = str7;
                        arrayList7 = arrayList3;
                        str = str6;
                        str5 = str11;
                        i12 = i11;
                        arrayList6 = arrayList11;
                        arrayList9 = arrayList5;
                        str15 = str4;
                        str14 = str3;
                        str13 = str2;
                        str12 = str;
                        arrayList3 = arrayList7;
                        arrayList4 = arrayList6;
                        i10 = i12;
                        str11 = str5;
                        recognizeNameCardActivity = this;
                    }
                }
                str5 = str11;
                arrayList3 = arrayList7;
                arrayList4 = arrayList6;
                i10 = i12;
                str11 = str5;
                recognizeNameCardActivity = this;
            }
            arrayList7 = arrayList3;
            str5 = str11;
            arrayList3 = arrayList7;
            arrayList4 = arrayList6;
            arrayList9 = arrayList5;
            str15 = str4;
            str14 = str3;
            str11 = str5;
            str13 = str2;
            str12 = str;
            recognizeNameCardActivity = this;
            i10 = i11;
        }
        ArrayList arrayList12 = arrayList9;
        String str16 = str12;
        String str17 = str13;
        String str18 = str14;
        String str19 = str15;
        int i16 = i10;
        ArrayList<? extends Parcelable> arrayList13 = arrayList4;
        ArrayList<ContentProviderOperation> arrayList14 = arrayList3;
        String str20 = str11;
        if (arrayList12 != null && arrayList12.size() > 0) {
            int size2 = arrayList12.size();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            for (int i17 = 0; i17 < size2; i17++) {
                ContactInfo.CompanyItem companyItem = (ContactInfo.CompanyItem) arrayList12.get(i17);
                String company = companyItem.getCompany();
                String title = companyItem.getTitle();
                String department = companyItem.getDepartment();
                if (H7.a.b()) {
                    H7.b.b("RecognizeNameCardActivity", "company = " + company + " ,title = " + title + " ,department = " + department);
                }
                if (!TextUtils.isEmpty(company)) {
                    sb2.append(company);
                    if (size2 > 1 && i17 < size2 - 1) {
                        sb2.append(" ");
                    }
                }
                if (!TextUtils.isEmpty(title)) {
                    sb3.append(title);
                    if (size2 > 1 && i17 < size2 - 1) {
                        sb3.append(" ");
                    }
                }
                if (!TextUtils.isEmpty(department)) {
                    sb4.append(department);
                    if (size2 > 1 && i17 < size2 - 1) {
                        sb4.append(" ");
                    }
                }
            }
            com.customize.contacts.util.P.b(sb2, sb4, sb3, arrayList13, arrayList14, z10, i16);
        }
        if (z10) {
            if (arrayList13.size() > 0) {
                Intent intent = new Intent(com.customize.contacts.util.k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
                intent.putExtra("name", str19);
                intent.putExtra("data2", str18);
                intent.putExtra("data3", str17);
                intent.putExtra("data5", str16);
                intent.putParcelableArrayListExtra("data", arrayList13);
                intent.putExtra("STORAGE_TYPE", R0.a.f3166b);
                intent.putExtra(str20, R0.a.f3165a);
                intent.putExtra("group_id", this.f20546r);
                intent.putExtra("business_card_photo_path", F3.f.g(getApplicationContext()).f(this));
                R7.b.c(context, intent);
            }
            return null;
        }
        return arrayList14;
    }

    public final /* synthetic */ void B1(List list) {
        H7.b.e("RecognizeNameCardActivity", "recognize getContactInfo contactItems size =" + list.size() + " contactItems=" + list);
        A1(this.f20545q, null, list, true);
        setResult(-1);
        if (list.size() == 0) {
            com.oplus.foundation.util.ui.c.b(this.f20545q, R.string.oplus_card_not_recognized);
        }
        finish();
    }

    public final /* synthetic */ void C1(Exception exc) {
        H7.b.i("RecognizeNameCardActivity", "recognize getContactInfo error");
        com.oplus.foundation.util.ui.c.b(this.f20545q, R.string.oplus_card_not_recognized);
        setResult(-1);
        finish();
    }

    public final void D1(String str) {
        E1(str, false);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String l10 = C7.e.l(intent, "picture_path");
        this.f20544p = l10;
        if (TextUtils.isEmpty(l10)) {
            H7.b.b("RecognizeNameCardActivity", "---no name card picture to recognize, finish---");
            finish();
        } else {
            if (RequestPermissionsActivity.p2(this)) {
                return;
            }
            this.f20545q = this;
            if (f20541y == null) {
                f20542z = new LinkedBlockingQueue<>();
                f20541y = new ThreadPoolExecutor(1, 1, 100L, TimeUnit.SECONDS, f20542z);
            }
            f20541y.execute(new a());
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        U3.f.i().f();
        if (f20541y != null) {
            if (H7.a.b()) {
                H7.b.b("RecognizeNameCardActivity", "onDestroy getTaskCount = " + f20541y.getTaskCount() + " ,getActiveCount = " + f20541y.getActiveCount());
            }
            if (f20541y.getActiveCount() > 0) {
                f20541y.shutdown();
                try {
                    f20541y.awaitTermination(1L, TimeUnit.SECONDS);
                } catch (InterruptedException e10) {
                    H7.b.c("RecognizeNameCardActivity", "" + e10);
                }
            }
        }
        f20541y = null;
        F3.f.g(getApplicationContext()).a();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a9 A[Catch: Exception -> 0x00a5, TRY_LEAVE, TryCatch #7 {Exception -> 0x00a5, blocks: (B:45:0x00a1, B:38:0x00a9), top: B:44:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String z1(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Exception e: "
            java.lang.String r1 = "RecognizeNameCardActivity"
            java.lang.String r2 = ""
            r3 = 0
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L74
            android.content.ContentResolver r4 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L74
            java.io.InputStream r8 = r4.openInputStream(r8)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L74
            android.content.Context r7 = r7.getApplicationContext()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            F3.f r7 = F3.f.g(r7)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r4.<init>()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.lang.String r5 = F3.b.d()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r4.append(r5)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.lang.String r5 = ".jpg"
            r4.append(r5)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.lang.String r2 = r7.b(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r3 = 102400(0x19000, float:1.43493E-40)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
        L3e:
            int r4 = r8.read(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            r5 = -1
            if (r4 == r5) goto L4f
            r5 = 0
            r7.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            goto L3e
        L4a:
            r2 = move-exception
            r3 = r7
            goto L9f
        L4d:
            r3 = move-exception
            goto L78
        L4f:
            r7.close()     // Catch: java.lang.Exception -> L56
            r8.close()     // Catch: java.lang.Exception -> L56
            goto L9e
        L56:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
        L5c:
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            H7.b.c(r1, r7)
            goto L9e
        L6a:
            r2 = move-exception
            goto L9f
        L6c:
            r7 = move-exception
            r6 = r3
            r3 = r7
            r7 = r6
            goto L78
        L71:
            r2 = move-exception
            r8 = r3
            goto L9f
        L74:
            r7 = move-exception
            r8 = r3
            r3 = r7
            r7 = r8
        L78:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r4.<init>()     // Catch: java.lang.Throwable -> L4a
            r4.append(r0)     // Catch: java.lang.Throwable -> L4a
            r4.append(r3)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L4a
            H7.b.c(r1, r3)     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L92
            r7.close()     // Catch: java.lang.Exception -> L90
            goto L92
        L90:
            r7 = move-exception
            goto L98
        L92:
            if (r8 == 0) goto L9e
            r8.close()     // Catch: java.lang.Exception -> L90
            goto L9e
        L98:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            goto L5c
        L9e:
            return r2
        L9f:
            if (r3 == 0) goto La7
            r3.close()     // Catch: java.lang.Exception -> La5
            goto La7
        La5:
            r7 = move-exception
            goto Lad
        La7:
            if (r8 == 0) goto Lbf
            r8.close()     // Catch: java.lang.Exception -> La5
            goto Lbf
        Lad:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            H7.b.c(r1, r7)
        Lbf:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.activities.RecognizeNameCardActivity.z1(java.lang.String):java.lang.String");
    }
}
