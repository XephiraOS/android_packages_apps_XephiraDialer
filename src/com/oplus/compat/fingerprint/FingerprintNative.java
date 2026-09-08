package com.oplus.compat.fingerprint;

import S6.c;
import android.hardware.fingerprint.Fingerprint;
import android.util.Log;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.d;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;

/* loaded from: classes3.dex */
public class FingerprintNative {
    private static final String COMPONENT_NAME = "android.hardware.fingerprint.Fingerprint";
    private static final String RESULT = "result";
    private static final String TAG = "FingerprintNative";
    private final Fingerprint mFingerprint;

    /* loaded from: classes3.dex */
    public static class a {
        private static RefMethod<Integer> getBiometricId;

        static {
            RefClass.load((Class<?>) a.class, "android.hardware.biometrics.BiometricAuthenticator$Identifier");
        }
    }

    private FingerprintNative(Fingerprint fingerprint) {
        this.mFingerprint = fingerprint;
    }

    private Fingerprint getFingerprint() {
        return this.mFingerprint;
    }

    public int getBiometricId() {
        if (c.n()) {
            return ((Integer) a.getBiometricId.call(this.mFingerprint, new Object[0])).intValue();
        }
        if (c.m()) {
            Response d10 = d.o(new Request.b().c(COMPONENT_NAME).b("getBiometricId").f("fingerprint", this.mFingerprint).a()).d();
            if (d10.j()) {
                return d10.h().getInt(RESULT);
            }
            Log.e(TAG, "getBiometricId error: " + d10.i());
        }
        return 0;
    }
}
