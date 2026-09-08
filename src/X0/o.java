package x0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;

/* compiled from: FragmentSceneDialtactsBinding.java */
/* loaded from: classes.dex */
public abstract class o extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final androidx.databinding.o f37746G;

    /* renamed from: H, reason: collision with root package name */
    public final androidx.databinding.o f37747H;

    /* renamed from: I, reason: collision with root package name */
    public final COUIFloatingButton f37748I;

    /* renamed from: J, reason: collision with root package name */
    public final androidx.databinding.o f37749J;

    /* renamed from: K, reason: collision with root package name */
    public final androidx.databinding.o f37750K;

    /* renamed from: L, reason: collision with root package name */
    public final HeaderFooterRecyclerView f37751L;

    public o(Object obj, View view, int i10, androidx.databinding.o oVar, androidx.databinding.o oVar2, COUIFloatingButton cOUIFloatingButton, androidx.databinding.o oVar3, androidx.databinding.o oVar4, HeaderFooterRecyclerView headerFooterRecyclerView) {
        super(obj, view, i10);
        this.f37746G = oVar;
        this.f37747H = oVar2;
        this.f37748I = cOUIFloatingButton;
        this.f37749J = oVar3;
        this.f37750K = oVar4;
        this.f37751L = headerFooterRecyclerView;
    }

    public static o i1(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        return j1(layoutInflater, viewGroup, z10, androidx.databinding.g.g());
    }

    @Deprecated
    public static o j1(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (o) ViewDataBinding.N0(layoutInflater, R.layout.fragment_scene_dialtacts, viewGroup, z10, obj);
    }
}
