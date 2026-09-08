package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefFloat extends BaseField<Float> {
    private static final float DEFAULT_VALUE = ((Float) BaseRef.DEFAULT_TYPES.get(Float.class)).floatValue();
    private static final String TAG = "RefFloat";

    public RefFloat(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(Object obj) {
        super.bindStub(obj);
    }

    public float get(Object obj) {
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

    public float getWithDefault(Object obj, float f10) {
        try {
            return getWithException(obj);
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage());
            return f10;
        }
    }

    public float getWithException(Object obj) {
        return this.mField.getFloat(checkStub(obj));
    }

    @Override // com.oplus.utils.reflect.BaseField, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public void set(Object obj, float f10) {
        try {
            this.mField.setFloat(checkStub(obj), f10);
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage());
        }
    }
}
