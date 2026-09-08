package com.android.incallui;

import android.os.Bundle;
import com.android.incallui.Ui;

/* loaded from: classes.dex */
public abstract class Presenter<U extends Ui> {
    private U mUi;

    public U getUi() {
        return this.mUi;
    }

    public final void onUiDestroy(U u10) {
        onUiUnready(u10);
        this.mUi = null;
    }

    public void onUiReady(U u10) {
        this.mUi = u10;
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onUiUnready(U u10) {
    }
}
