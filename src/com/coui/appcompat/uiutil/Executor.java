package com.coui.appcompat.uiutil;

import com.coui.appcompat.uiutil.Domain;
import com.coui.appcompat.uiutil.Rule;

/* loaded from: classes3.dex */
public interface Executor<T extends Rule<? extends Domain>, U extends Domain> {
    Executor<T, U> execute(T t10, U u10);
}
