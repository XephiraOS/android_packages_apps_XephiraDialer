package S3;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.framework.vcard.VCardEntry;
import com.android.contacts.model.Account;
import com.customize.contacts.util.k0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Navigator.java */
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ void c(Activity activity, Intent intent) {
        R7.b.c(activity, intent);
        activity.finish();
    }

    public static /* synthetic */ void d(Activity activity, Intent intent) {
        R7.b.c(activity, intent);
        activity.finish();
    }

    public void e(R3.b bVar, final Activity activity, Handler handler) {
        H7.b.b("Navigator", "navigateToEditorAct MeCard");
        List<String> f10 = bVar.f();
        List<String> g10 = bVar.g();
        String h10 = bVar.h();
        String i10 = bVar.i();
        List<String> j10 = bVar.j();
        String k10 = bVar.k();
        List<String> l10 = bVar.l();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (String str : j10) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put("data1", str);
            contentValues.put("data2", (Integer) 2);
            arrayList.add(contentValues);
        }
        for (String str2 : g10) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("mimetype", "vnd.android.cursor.item/email_v2");
            contentValues2.put("data1", str2);
            contentValues2.put("data2", (Integer) 1);
            arrayList.add(contentValues2);
        }
        for (String str3 : l10) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/website");
            contentValues3.put("data1", str3);
            contentValues3.put("data2", (Integer) 5);
            arrayList.add(contentValues3);
        }
        for (String str4 : f10) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues4.put("data2", (Integer) 1);
            contentValues4.put("data1", str4);
            arrayList.add(contentValues4);
        }
        ContentValues contentValues5 = new ContentValues();
        contentValues5.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues5.put("data2", (Integer) 1);
        contentValues5.put("data1", i10);
        contentValues5.put("data4", k10);
        arrayList.add(contentValues5);
        final Intent intent = new Intent(k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("name", h10);
        intent.putParcelableArrayListExtra("data", arrayList);
        String str5 = R0.a.f3166b;
        intent.putExtra("STORAGE_TYPE", str5);
        String str6 = R0.a.f3165a;
        intent.putExtra("account_name", str6);
        intent.putExtra("group_id", N3.b.j(activity, "Business Card in ColorOS", new Account(str6, str5)));
        intent.putExtra("scan_qrcode", true);
        if (activity != null) {
            handler.post(new Runnable() { // from class: S3.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.c(activity, intent);
                }
            });
        }
    }

    public void f(VCardEntry vCardEntry, final Activity activity, Handler handler) {
        H7.b.b("Navigator", "navigateToEditorAct vcard");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        List<VCardEntry.q> W10 = vCardEntry.W();
        List<VCardEntry.f> O10 = vCardEntry.O();
        List<VCardEntry.w> c02 = vCardEntry.c0();
        List<VCardEntry.s> Y9 = vCardEntry.Y();
        List<VCardEntry.p> V10 = vCardEntry.V();
        VCardEntry.m S10 = vCardEntry.S();
        if (W10 != null && W10.size() > 0) {
            for (VCardEntry.q qVar : W10) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
                contentValues.put("data1", qVar.h());
                contentValues.put("data2", Integer.valueOf(qVar.i()));
                arrayList.add(contentValues);
            }
        }
        if (O10 != null && O10.size() > 0) {
            for (VCardEntry.f fVar : O10) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("mimetype", "vnd.android.cursor.item/email_v2");
                contentValues2.put("data1", fVar.h());
                contentValues2.put("data2", Integer.valueOf(fVar.i()));
                arrayList.add(contentValues2);
            }
        }
        if (c02 != null && c02.size() > 0) {
            for (VCardEntry.w wVar : c02) {
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("mimetype", "vnd.android.cursor.item/website");
                contentValues3.put("data1", wVar.g());
                contentValues3.put("data2", (Integer) 5);
                arrayList.add(contentValues3);
            }
        }
        if (Y9 != null && Y9.size() > 0) {
            for (VCardEntry.s sVar : Y9) {
                ContentValues contentValues4 = new ContentValues();
                contentValues4.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
                contentValues4.put("data2", Integer.valueOf(sVar.i()));
                contentValues4.put("data1", sVar.h(1));
                arrayList.add(contentValues4);
            }
        }
        if (V10 != null && V10.size() > 0) {
            for (VCardEntry.p pVar : V10) {
                ContentValues contentValues5 = new ContentValues();
                contentValues5.put("mimetype", "vnd.android.cursor.item/organization");
                contentValues5.put("data2", Integer.valueOf(pVar.q()));
                contentValues5.put("data1", pVar.o());
                contentValues5.put("data4", pVar.p());
                arrayList.add(contentValues5);
            }
        }
        ContentValues contentValues6 = new ContentValues();
        contentValues6.put("mimetype", "vnd.android.cursor.item/name");
        String B10 = S10.B();
        String E10 = S10.E();
        String D10 = S10.D();
        String F10 = S10.F();
        String G10 = S10.G();
        String C10 = S10.C();
        final Intent intent = new Intent(k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
        if (TextUtils.isEmpty(C10) && !TextUtils.isEmpty(B10)) {
            C10 = B10;
        }
        if (!TextUtils.isEmpty(C10)) {
            intent.putExtra("name", C10);
            contentValues6.put("data1", C10);
        }
        if (!TextUtils.isEmpty(B10)) {
            intent.putExtra("data3", B10);
            contentValues6.put("data3", B10);
        }
        if (!TextUtils.isEmpty(E10)) {
            intent.putExtra("data5", E10);
            contentValues6.put("data5", E10);
        }
        if (!TextUtils.isEmpty(D10)) {
            intent.putExtra("data2", D10);
            contentValues6.put("data2", D10);
        }
        if (!TextUtils.isEmpty(F10)) {
            intent.putExtra("data4", F10);
            contentValues6.put("data4", F10);
        }
        if (!TextUtils.isEmpty(G10)) {
            intent.putExtra("data6", G10);
            contentValues6.put("data6", G10);
        }
        arrayList.add(contentValues6);
        intent.putParcelableArrayListExtra("data", arrayList);
        String str = R0.a.f3166b;
        intent.putExtra("STORAGE_TYPE", str);
        String str2 = R0.a.f3165a;
        intent.putExtra("account_name", str2);
        intent.putExtra("group_id", N3.b.j(activity, "Business Card in ColorOS", new Account(str2, str)));
        intent.putExtra("scan_qrcode", true);
        if (activity != null) {
            handler.post(new Runnable() { // from class: S3.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.d(activity, intent);
                }
            });
        }
    }
}
