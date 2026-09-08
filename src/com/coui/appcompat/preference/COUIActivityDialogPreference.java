package com.coui.appcompat.preference;

import android.content.Context;
import android.util.AttributeSet;
import b9.C0532b;

/* loaded from: classes.dex */
public class COUIActivityDialogPreference extends COUIListPreference {
    public COUIActivityDialogPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public COUIActivityDialogPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public COUIActivityDialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12342a);
    }

    public COUIActivityDialogPreference(Context context) {
        this(context, null);
    }
}
