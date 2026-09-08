package com.heytap.accessory.discovery;

import java.util.function.Consumer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((IManagerCallback) obj).onReleased();
    }
}
