package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefDouble extends BaseField<Double> {
    private static final double DEFAULT_VALUE = ((Double) BaseRef.DEFAULT_TYPES.get(Double.class)).doubleValue();
    private static final String TAG = "RefDouble";

    public RefDouble(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(Object obj) {
        super.bindStub(obj);
    }

    public double get(Object obj) {
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

    public double getWithDefault(Object obj, double d10) {
        try {
            return getWithException(obj);
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage());
            return d10;
        }
    }

    public double getWithException(Object obj) {
        return this.mField.getDouble(checkStub(obj));
    }

    @Override // com.oplus.utils.reflect.BaseField, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public void set(Object obj, double d10) {
        try {
            this.mField.setDouble(checkStub(obj), d10);
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage());
        }
    }
}
