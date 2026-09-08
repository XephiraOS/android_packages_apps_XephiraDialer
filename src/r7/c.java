package R7;

import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.TwoStatePreference;

/* compiled from: PreferenceExt.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final void a(PreferenceGroup preferenceGroup, Preference preference) {
        if (preference != null && preferenceGroup != null) {
            preferenceGroup.removePreference(preference);
        }
    }

    public static final void b(TwoStatePreference twoStatePreference, boolean z10) {
        if (twoStatePreference != null) {
            twoStatePreference.setChecked(z10);
        }
    }

    public static final void c(Preference preference, boolean z10) {
        if (preference != null) {
            preference.setEnabled(z10);
        }
    }
}
