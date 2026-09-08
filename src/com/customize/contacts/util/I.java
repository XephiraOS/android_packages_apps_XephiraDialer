package com.customize.contacts.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import com.customize.contacts.widget.TouchSearchView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import m1.C1320p;

/* compiled from: IndexUtils.java */
/* loaded from: classes3.dex */
public class I {

    /* renamed from: a, reason: collision with root package name */
    public TouchSearchView f21893a;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, C1320p> f21895c;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f21894b = null;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<a> f21896d = null;

    /* compiled from: IndexUtils.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f21897a;

        /* renamed from: b, reason: collision with root package name */
        public int f21898b;

        public a() {
            this.f21897a = null;
            this.f21898b = 0;
        }
    }

    public I(TouchSearchView touchSearchView, ListView listView, ContentResolver contentResolver) {
        this.f21895c = null;
        this.f21893a = touchSearchView;
        this.f21895c = new HashMap<>();
    }

    public static final boolean g(char c10) {
        if (c10 < 'a' || c10 > 'z') {
            if (c10 >= 'A' && c10 <= 'Z') {
                return true;
            }
            return false;
        }
        return true;
    }

    public void a(a aVar) {
        if (!TextUtils.isEmpty(aVar.f21897a) && g(aVar.f21897a.charAt(0))) {
            return;
        }
        this.f21896d.add(aVar);
    }

    public int b(CharSequence charSequence) {
        int i10 = 0;
        if (c(this.f21894b) == null || c(this.f21894b).getSections() == null) {
            return 0;
        }
        Object[] sections = c(this.f21894b).getSections();
        String charSequence2 = charSequence.toString();
        while (true) {
            if (i10 != sections.length) {
                if (charSequence2.equals(sections[i10].toString())) {
                    break;
                }
                i10++;
            } else {
                i10 = -1;
                break;
            }
        }
        return c(this.f21894b).getPositionForSection(i10);
    }

    public C1320p c(CharSequence charSequence) {
        return this.f21895c.get(this.f21894b);
    }

    public CharSequence d() {
        return this.f21894b;
    }

    public void e(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        f(cursor.getExtras());
    }

    public void f(Bundle bundle) {
        String[] stringArray;
        this.f21895c.clear();
        if (bundle != null && (stringArray = bundle.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES")) != null && stringArray.length != 0) {
            for (int i10 = 0; i10 < stringArray.length; i10++) {
                if (R0.b.f3171e.matcher(stringArray[i10]).matches()) {
                    String[] stringArray2 = bundle.getStringArray(stringArray[i10] + "titles");
                    int[] intArray = bundle.getIntArray(stringArray[i10] + "counts");
                    if (stringArray2 != null && intArray != null && !this.f21895c.containsKey(stringArray[i10])) {
                        this.f21895c.put(stringArray[i10], new C1320p(stringArray2, intArray));
                    }
                }
            }
        }
    }

    public boolean h(CharSequence charSequence) {
        if (c(this.f21894b) == null || c(this.f21894b).getSections() == null) {
            return false;
        }
        return c(this.f21894b).getSections()[0].equals(charSequence);
    }

    public void i(CharSequence charSequence) {
        if (this.f21893a == null) {
            return;
        }
        if (H7.a.b()) {
            H7.b.b("IndexUtils", "startQuery ------ start key = " + ((Object) charSequence));
        }
        this.f21894b = charSequence;
        C1320p c1320p = this.f21895c.get(charSequence);
        int i10 = 0;
        if (c1320p == null) {
            if (H7.a.b()) {
                H7.b.b("IndexUtils", "startQuery ------ keyIndexer is null");
            }
            this.f21893a.setName(new String[0]);
            return;
        }
        String[] strArr = (String[]) c1320p.getSections();
        int[] a10 = c1320p.a();
        if (strArr != null && a10 != null && strArr.length == a10.length) {
            this.f21896d = new ArrayList<>();
            int length = strArr.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                String str = strArr[i11];
                a aVar = new a();
                aVar.f21897a = str;
                aVar.f21898b = a10[i12];
                a(aVar);
                i11++;
                i12++;
            }
            String[] strArr2 = new String[this.f21896d.size()];
            Iterator<a> it = this.f21896d.iterator();
            while (it.hasNext()) {
                strArr2[i10] = it.next().f21897a;
                i10++;
            }
            this.f21893a.setName(strArr2);
            if (H7.a.b()) {
                H7.b.b("IndexUtils", "startQuery ------ finished");
            }
        }
    }
}
