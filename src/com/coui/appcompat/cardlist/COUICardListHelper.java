package com.coui.appcompat.cardlist;

import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.preference.COUICardSupportInterface;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUICardListHelper {
    public static final int FULL = 4;
    public static final int HEAD = 1;
    public static final int MIDDLE = 2;
    public static final int NONE = 0;
    public static final int TAIL = 3;

    public static int getPositionInGroup(int i10, int i11) {
        if (i10 == 1) {
            return 4;
        }
        if (i11 == 0) {
            return 1;
        }
        return i11 == i10 - 1 ? 3 : 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isSupportCard(PreferenceGroup preferenceGroup, Preference preference) {
        if (preferenceGroup instanceof PreferenceScreen) {
            if (!(preference instanceof COUICardSupportInterface) || !((COUICardSupportInterface) preference).isSupportCardUse()) {
                return false;
            }
            return true;
        }
        if (preference instanceof PreferenceCategory) {
            return false;
        }
        return true;
    }

    public static void refreshCardBg(View view, int i10) {
        if (view != null && (view instanceof COUICardListSelectedItemLayout)) {
            ((COUICardListSelectedItemLayout) view).refreshCardBg(i10);
        }
    }

    public static void setConfigurationChangeListener(View view, COUICardListSelectedItemLayout.ConfigurationChangedListener configurationChangedListener) {
        if (view != null && (view instanceof COUICardListSelectedItemLayout)) {
            ((COUICardListSelectedItemLayout) view).setConfigurationChangeListener(configurationChangedListener);
        }
    }

    public static void setItemCardBackground(View view, int i10) {
        if (view != null && (view instanceof COUICardListSelectedItemLayout)) {
            ((COUICardListSelectedItemLayout) view).setPositionInGroup(i10);
        }
    }

    public static int getPositionInGroup(Preference preference) {
        PreferenceGroup parent = preference.getParent();
        int i10 = 0;
        if (parent == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < parent.getPreferenceCount(); i11++) {
            Preference preference2 = parent.getPreference(i11);
            if (preference2.isVisible()) {
                arrayList.add(preference2);
            }
        }
        int size = arrayList.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                break;
            }
            if (preference == arrayList.get(i12)) {
                i10 = i12;
                break;
            }
            i12++;
        }
        Preference preference3 = i10 > 0 ? (Preference) arrayList.get(i10 - 1) : null;
        Preference preference4 = i10 < size - 1 ? (Preference) arrayList.get(i10 + 1) : null;
        int i13 = (preference3 == null || !isSupportCard(parent, preference3)) ? 1 : 2;
        return (preference4 == null || !isSupportCard(parent, preference4)) ? i13 == 1 ? 4 : 3 : i13;
    }
}
