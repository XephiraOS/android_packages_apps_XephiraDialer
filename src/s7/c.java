package s7;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: ToolbarPopupMenuWindow.kt */
/* loaded from: classes3.dex */
public final class c extends COUIPopupListWindow implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final Context f36867a;

    /* renamed from: b, reason: collision with root package name */
    public List<C1557b> f36868b;

    /* renamed from: c, reason: collision with root package name */
    public a f36869c;

    /* compiled from: ToolbarPopupMenuWindow.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void N0(C1557b c1557b);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        i.f(context, "context");
        this.f36867a = context;
        setOnItemClickListener(this);
    }

    public final void c(a aVar) {
        this.f36869c = aVar;
    }

    public final void d(List<C1557b> list) {
        setItemList(list);
        this.f36868b = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        int i11;
        List<C1557b> list;
        C1557b c1557b;
        a aVar;
        if (view != null) {
            i11 = view.getId();
        } else {
            i11 = 0;
        }
        if (!C7.a.b(i11) && (list = this.f36868b) != null && (c1557b = list.get(i10)) != null && view != null && view.isEnabled() && (aVar = this.f36869c) != null) {
            aVar.N0(c1557b);
        }
    }
}
