package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefBoolean extends BaseField<Boolean> {
    private static final boolean DEFAULT_VALUE = ((Boolean) BaseRef.DEFAULT_TYPES.get(Boolean.class)).booleanValue();
    private static final String TAG = "RefBoolean";

    public RefBoolean(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(Object obj) {
        super.bindStub(obj);
    }

    public boolean get(Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    @Override // com.oplus.utils.reflect.BaseField, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ Class getDeclaringClass() {
        return super.getDeclaringClass();
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public boolean getWithDefault(Object obj, boolean z10) {
        try {
            return getWithException(obj);
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage());
            return z10;
        }
    }

    public boolean getWithException(Object obj) {
        return this.mField.getBoolean(checkStub(obj));
    }

    @Override // com.oplus.utils.reflect.BaseField, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public void set(Object obj, boolean z10) {
        try {
            this.mField.setBoolean(checkStub(obj), z10);
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage());
        }
    }
}
