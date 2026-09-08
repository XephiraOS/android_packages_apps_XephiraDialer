package w7;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.i;

/* compiled from: RecyclerViewItemClickController.kt */
/* loaded from: classes3.dex */
public final class d implements View.OnTouchListener, View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public float f37619a = Float.NaN;

    /* renamed from: b, reason: collision with root package name */
    public float f37620b = Float.NaN;

    /* renamed from: c, reason: collision with root package name */
    public int f37621c = -1;

    /* renamed from: d, reason: collision with root package name */
    public c f37622d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f37623e;

    public final void a(View view, int i10, boolean z10, c cVar) {
        i.f(view, "view");
        view.setOnTouchListener(this);
        view.setOnLongClickListener(this);
        view.setOnClickListener(this);
        this.f37623e = z10;
        this.f37621c = i10;
        this.f37622d = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        i.f(v10, "v");
        c cVar = this.f37622d;
        if (cVar != null) {
            cVar.onItemClick(v10, this.f37621c);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v10) {
        i.f(v10, "v");
        if (this.f37623e) {
            return false;
        }
        c cVar = this.f37622d;
        if (cVar != null) {
            return cVar.H(v10, this.f37621c, (int) this.f37619a, (int) this.f37620b);
        }
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        i.f(event, "event");
        this.f37619a = event.getX();
        this.f37620b = event.getY();
        return false;
    }
}
