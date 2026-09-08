package b7;

import android.view.View;
import android.widget.ImageView;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.contacts.list.f;
import kotlin.jvm.internal.i;
import x0.AbstractC1671i;
import y7.C1708a;

/* compiled from: ContactsMainListItemViewHolder.kt */
/* renamed from: b7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0528a extends C1708a implements d {

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1671i f12336b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0528a(AbstractC1671i dataBinding) {
        super(dataBinding);
        i.f(dataBinding, "dataBinding");
        this.f12336b = dataBinding;
    }

    @Override // b7.d
    public ImageView a() {
        COUIRoundImageView cOUIRoundImageView = e().f37724M;
        i.e(cOUIRoundImageView, "dataBinding.photoView");
        return cOUIRoundImageView;
    }

    @Override // b7.d
    public void b(f item) {
        i.f(item, "item");
        e().i1(item);
    }

    @Override // b7.d
    public View c() {
        View K02 = e().K0();
        i.e(K02, "dataBinding.root");
        return K02;
    }

    @Override // b7.d
    public View d() {
        ImageView imageView = e().f37722K;
        i.e(imageView, "dataBinding.divider");
        return imageView;
    }

    @Override // y7.C1708a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC1671i e() {
        return this.f12336b;
    }
}
