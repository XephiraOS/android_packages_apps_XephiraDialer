package com.coui.appcompat.state;

import android.content.Context;

/* loaded from: classes.dex */
public interface IStateEffect {
    void refresh(Context context);

    void reset();

    void setAnimateEnabled(boolean z10);
}
