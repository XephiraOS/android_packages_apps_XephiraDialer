package com.android.contacts.voicemail.impl.scheduling;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: Tasks.java */
/* loaded from: classes.dex */
public final class g {
    public static Intent a(Context context, Class<? extends e> cls) {
        Intent intent = new Intent(context, (Class<?>) TaskReceiver.class);
        intent.setPackage(context.getPackageName());
        intent.putExtra("extra_class_name", cls.getName());
        return intent;
    }

    public static e b(Context context, Bundle bundle) {
        bundle.setClassLoader(context.getClassLoader());
        String string = bundle.getString("extra_class_name");
        H7.b.e("Task.createTask", "create task:" + string);
        if (string != null) {
            try {
                e eVar = (e) Class.forName(string).getDeclaredConstructor(null).newInstance(null);
                eVar.e(context, bundle);
                return eVar;
            } catch (ReflectiveOperationException e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        throw new IllegalArgumentException("EXTRA_CLASS_NAME expected");
    }

    public static Bundle c(e eVar) {
        Bundle f10 = eVar.f();
        f10.putString("extra_class_name", eVar.getClass().getName());
        return f10;
    }
}
