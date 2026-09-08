package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefByte extends BaseField<Byte> {
    private static final byte DEFAULT_VALUE = ((Byte) BaseRef.DEFAULT_TYPES.get(Byte.class)).byteValue();
    private static final String TAG = "RefByte";

    public RefByte(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(Object obj) {
        super.bindStub(obj);
    }

    public byte get(Object obj) {
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

    public byte getWithDefault(Object obj, byte b10) {
        try {
            return getWithException(obj);
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage());
            return b10;
        }
    }

    public byte getWithException(Object obj) {
        return this.mField.getByte(checkStub(obj));
    }

    @Override // com.oplus.utils.reflect.BaseField, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public void set(Object obj, byte b10) {
        try {
            this.mField.setByte(checkStub(obj), b10);
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage());
        }
    }
}
