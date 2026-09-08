package V0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment;
import kotlin.jvm.internal.i;

/* compiled from: PreferenceWithAppbarFragment.kt */
/* loaded from: classes.dex */
public abstract class a extends COUIPreferenceWithAppbarFragment {
    public void c1(View view) {
        View findViewById;
        i.f(view, "view");
        if (A7.a.a() && (findViewById = view.findViewById(N0.i.f1936n)) != null) {
            findViewById.setVisibility(8);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        i.e(onCreateView, "super.onCreateView(infla…iner, savedInstanceState)");
        getListView().setItemAnimator(null);
        return onCreateView;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        c1(view);
    }
}
