package com.android.contacts.framework.api.numberidentify.interfaces;

import android.os.Parcelable;
import java.util.List;

/* compiled from: IRecognitionNumber.kt */
/* loaded from: classes.dex */
public interface IRecognitionNumber extends Parcelable {
    IMarkerData B();

    String S();

    boolean a();

    int c();

    String c0();

    String e();

    String getAddress();

    String getName();

    List<IRelevantNumber> o0();

    List<IContactMenu> r();
}
