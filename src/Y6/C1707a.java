package y6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/* compiled from: EmptyFragment.java */
/* renamed from: y6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1707a extends Fragment {
    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView = new TextView(getActivity());
        textView.setText(" ");
        return textView;
    }
}
