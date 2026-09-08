package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.j;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10550a;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, A.k.a(context, m.f10635g, R.attr.preferenceScreenStyle));
        this.f10550a = true;
    }

    public boolean a() {
        return this.f10550a;
    }

    @Override // androidx.preference.PreferenceGroup
    public boolean isOnSameScreenAsChildren() {
        return false;
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        j.b g10;
        if (getIntent() == null && getFragment() == null && getPreferenceCount() != 0 && (g10 = getPreferenceManager().g()) != null) {
            g10.onNavigateToScreen(this);
        }
    }
}
