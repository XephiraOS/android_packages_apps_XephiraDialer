package x7;

import android.database.Cursor;
import android.widget.CheckBox;
import java.util.List;
import kotlin.jvm.internal.i;
import y7.C1708a;

/* compiled from: DragSelectCursorRecyclerAdapter.kt */
/* renamed from: x7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1685b<VH extends C1708a, E> extends f<VH> implements e {
    public abstract void r(VH vh, int i10, E e10);

    public abstract void s(VH vh, int i10, E e10, List<Object> list);

    public abstract E t(Cursor cursor, int i10);

    public abstract boolean u(E e10);

    public abstract boolean v();

    @Override // x7.AbstractC1684a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final void i(VH holder, Cursor cursor, int i10) {
        i.f(holder, "holder");
        i.f(cursor, "cursor");
        if (cursor.moveToPosition(i10)) {
            E t10 = t(cursor, i10);
            r(holder, i10, t10);
            CheckBox b10 = b(holder);
            if (b10 != null) {
                if (v()) {
                    b10.setVisibility(0);
                    b10.setChecked(u(t10));
                } else {
                    b10.setChecked(false);
                    b10.setVisibility(8);
                }
                y(holder, i10, t10, b10.isChecked());
            }
            holder.e().D0();
        }
    }

    @Override // x7.AbstractC1684a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void j(VH holder, Cursor cursor, int i10, List<Object> payloads) {
        i.f(holder, "holder");
        i.f(cursor, "cursor");
        i.f(payloads, "payloads");
        if (!payloads.isEmpty()) {
            E t10 = t(cursor, i10);
            if (i.b(payloads.get(0), "selection_change")) {
                CheckBox b10 = b(holder);
                if (b10 != null) {
                    if (v()) {
                        b10.setVisibility(0);
                        b10.setChecked(u(t10));
                    } else {
                        b10.setChecked(false);
                        b10.setVisibility(8);
                    }
                    y(holder, i10, t10, b10.isChecked());
                }
            } else {
                s(holder, i10, t10, payloads);
            }
            holder.e().D0();
            return;
        }
        i(holder, cursor, i10);
    }

    public abstract void y(VH vh, int i10, E e10, boolean z10);
}
