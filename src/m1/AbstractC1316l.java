package m1;

import android.content.Context;
import com.android.contacts.list.ContactListFilter;

/* compiled from: ContactListFilterController.java */
/* renamed from: m1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1316l {

    /* compiled from: ContactListFilterController.java */
    /* renamed from: m1.l$a */
    /* loaded from: classes.dex */
    public interface a {
        void M0();
    }

    public static AbstractC1316l d(Context context) {
        return new C1317m(context);
    }

    public static AbstractC1316l f(Context context) {
        return (AbstractC1316l) context.getApplicationContext().getSystemService("contactListFilter");
    }

    public abstract void a(a aVar);

    public abstract void b(boolean z10);

    public abstract void c(boolean z10);

    public abstract ContactListFilter e();

    public abstract void g(a aVar);

    public abstract void h(boolean z10);

    public abstract void i(ContactListFilter contactListFilter, boolean z10);
}
