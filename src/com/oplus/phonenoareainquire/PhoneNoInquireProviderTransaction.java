package com.oplus.phonenoareainquire;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import kotlinx.coroutines.C1244g;

/* compiled from: PhoneNoInquireProviderTransaction.kt */
/* loaded from: classes3.dex */
public final class PhoneNoInquireProviderTransaction {

    /* renamed from: a, reason: collision with root package name */
    public static final PhoneNoInquireProviderTransaction f28828a = new PhoneNoInquireProviderTransaction();

    public final void a() {
        C1244g.f(null, new PhoneNoInquireProviderTransaction$init$1(null), 1, null);
    }

    public final Cursor b(PhoneNoInquireProvider provider, String phoneNumber, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        kotlin.jvm.internal.i.f(provider, "provider");
        kotlin.jvm.internal.i.f(phoneNumber, "phoneNumber");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{BreenoCallContract.BaseColumns._ID, "areano", "cityname"}, 1);
        C1244g.f(null, new PhoneNoInquireProviderTransaction$querySingleNumber$1(provider, z10, z11, phoneNumber, str, matrixCursor, z12, z13, z14, null), 1, null);
        return matrixCursor;
    }
}
