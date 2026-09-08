package m1;

import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.android.incallui.OplusPhoneUtils;
import java.util.ArrayList;

/* compiled from: ProfileAndContactsLoader.java */
/* loaded from: classes.dex */
public class T extends W.b {

    /* renamed from: A, reason: collision with root package name */
    public boolean f34854A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f34855B;

    /* renamed from: x, reason: collision with root package name */
    public boolean f34856x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f34857y;

    /* renamed from: z, reason: collision with root package name */
    public String[] f34858z;

    public T(Context context) {
        super(context);
        this.f34854A = false;
        this.f34855B = false;
    }

    @Override // W.b, W.a
    /* renamed from: N */
    public Cursor I() {
        Cursor cursor;
        ArrayList f10 = com.google.common.collect.n.f();
        Cursor W10 = W();
        if (W10 != null) {
            f10.add(W10);
        }
        try {
            cursor = super.I();
        } catch (Exception unused) {
            cursor = null;
        }
        f10.add(cursor);
        MergeCursor mergeCursor = new MergeCursor((Cursor[]) f10.toArray(new Cursor[f10.size()]));
        X(W10, cursor, mergeCursor);
        return mergeCursor;
    }

    @Override // W.b
    public void P(String[] strArr) {
        super.P(strArr);
        this.f34858z = strArr;
    }

    public boolean U() {
        return this.f34855B;
    }

    public boolean V() {
        return this.f34857y;
    }

    public final Cursor W() {
        if (!this.f34857y) {
            return null;
        }
        return G7.c.e(i().getContentResolver(), ContactsContract.Contacts.CONTENT_URI, this.f34858z, "starred=?", new String[]{OplusPhoneUtils.DeviceState.LOCK_DEVICE}, S0.a.f3371a + " ASC");
    }

    public final void X(Cursor cursor, Cursor cursor2, Cursor cursor3) {
        int[] intArray;
        String[] stringArray;
        if (cursor2 != null) {
            Bundle extras = cursor2.getExtras();
            if (this.f34857y && cursor != null && cursor.getCount() > 0 && extras != null) {
                if (extras.containsKey("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES") && (stringArray = extras.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES")) != null) {
                    String[] strArr = new String[stringArray.length + 1];
                    strArr[0] = "*";
                    System.arraycopy(stringArray, 0, strArr, 1, stringArray.length);
                    extras.putStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES", strArr);
                }
                if (extras.containsKey("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS") && (intArray = extras.getIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS")) != null) {
                    int[] iArr = new int[intArray.length + 1];
                    iArr[0] = cursor.getCount();
                    System.arraycopy(intArray, 0, iArr, 1, intArray.length);
                    extras.putIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS", iArr);
                }
            }
            cursor3.setExtras(extras);
        }
    }

    public void Y(boolean z10) {
        this.f34855B = z10;
    }

    public void Z(boolean z10) {
        this.f34857y = z10;
    }

    public void a0(boolean z10) {
        this.f34856x = z10;
    }

    public void b0(boolean z10) {
        this.f34854A = z10;
    }

    @Override // W.c
    public void p() {
        if (this.f34854A) {
            Y(true);
        } else {
            super.p();
        }
    }
}
