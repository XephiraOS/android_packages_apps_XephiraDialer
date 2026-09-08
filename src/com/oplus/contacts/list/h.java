package com.oplus.contacts.list;

import android.database.Cursor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.i;
import v7.C1634a;

/* compiled from: ContactsMainListSectionCountIndexer.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    public static final a f28022c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, C1634a> f28023a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f28024b;

    /* compiled from: ContactsMainListSectionCountIndexer.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public final int a(CharSequence secondaryIndexerKey) {
        C1634a c1634a;
        i.f(secondaryIndexerKey, "secondaryIndexerKey");
        CharSequence charSequence = this.f28024b;
        if (charSequence != null && (c1634a = this.f28023a.get(charSequence)) != null) {
            String obj = secondaryIndexerKey.toString();
            String[] sections = c1634a.getSections();
            int length = sections.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = i11 + 1;
                if (i.b(sections[i10], obj)) {
                    return c1634a.getPositionForSection(i11);
                }
                i10++;
                i11 = i12;
            }
        }
        return -1;
    }

    public final CharSequence b() {
        return this.f28024b;
    }

    public final String[] c(CharSequence primaryIndexerKey) {
        i.f(primaryIndexerKey, "primaryIndexerKey");
        this.f28024b = primaryIndexerKey;
        C1634a c1634a = this.f28023a.get(primaryIndexerKey);
        if (c1634a == null) {
            return new String[0];
        }
        String[] sections = c1634a.getSections();
        if (sections.length != c1634a.a().length) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (String str : sections) {
            if (str.length() == 0 || !U7.e.a(Character.valueOf(str.charAt(0)))) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final void d(Cursor cursor) {
        Bundle extras;
        if (cursor != null && (extras = cursor.getExtras()) != null) {
            e(extras);
        }
    }

    public final void e(Bundle bundle) {
        this.f28023a.clear();
        if (bundle != null) {
            String[] stringArray = bundle.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES");
            if (stringArray != null && stringArray.length != 0) {
                for (String section : stringArray) {
                    if (R0.b.f3171e.matcher(section).matches()) {
                        String[] stringArray2 = bundle.getStringArray(section + "titles");
                        int[] intArray = bundle.getIntArray(section + "counts");
                        if (stringArray2 != null && intArray != null && !this.f28023a.containsKey(section)) {
                            Map<String, C1634a> map = this.f28023a;
                            i.e(section, "section");
                            map.put(section, new C1634a(stringArray2, intArray));
                        }
                    }
                }
                return;
            }
            H7.b.i("ContactsMainListSectionCountIndexer", "updateSectionCountIndexer error!");
        }
    }
}
