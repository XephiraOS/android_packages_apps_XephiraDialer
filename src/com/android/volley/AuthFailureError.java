package com.android.volley;

import android.content.Intent;

/* loaded from: classes.dex */
public class AuthFailureError extends VolleyError {
    private Intent mResolutionIntent;

    public AuthFailureError(S2.e eVar) {
        super(eVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.mResolutionIntent != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
