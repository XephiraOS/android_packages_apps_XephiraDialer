package D6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import b9.C0539i;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.preference.COUIPreferenceFragment;
import kotlin.jvm.internal.i;

/* compiled from: BasePercentPreferenceFragment.kt */
/* loaded from: classes3.dex */
public abstract class a extends COUIPreferenceFragment {
    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public RecyclerView onCreateRecyclerView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View inflate = inflater.inflate(C0539i.f12511m, viewGroup, false);
        i.d(inflate, "null cannot be cast to non-null type androidx.recyclerview.widget.COUIRecyclerView");
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) inflate;
        cOUIRecyclerView.setEnablePointerDownAction(false);
        cOUIRecyclerView.setLayoutManager(onCreateLayoutManager());
        COUIDarkModeUtil.setForceDarkAllow(cOUIRecyclerView, false);
        return cOUIRecyclerView;
    }
}
