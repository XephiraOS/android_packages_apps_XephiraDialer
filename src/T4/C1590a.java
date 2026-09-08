package t4;

import android.content.ContentResolver;
import android.provider.Settings;

/* compiled from: AnimatorDurationScaleProvider.java */
/* renamed from: t4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1590a {
    public float a(ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
