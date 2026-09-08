package b7;

import android.view.View;
import android.widget.ImageView;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.contacts.list.f;
import kotlin.jvm.internal.i;
import x0.m;
import y7.C1708a;

/* compiled from: ContactsMainListItemWithStarSectionViewHolder.kt */
/* loaded from: classes3.dex */
public final class c extends C1708a implements d {

    /* renamed from: b, reason: collision with root package name */
    public final m f12338b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(m dataBinding) {
        super(dataBinding);
        i.f(dataBinding, "dataBinding");
        this.f12338b = dataBinding;
    }

    @Override // b7.d
    public ImageView a() {
        COUIRoundImageView cOUIRoundImageView = e().f37740G.f37724M;
        i.e(cOUIRoundImageView, "dataBinding.contentLayout.photoView");
        return cOUIRoundImageView;
    }

    @Override // b7.d
    public void b(f item) {
        i.f(item, "item");
        e().f37740G.i1(item);
    }

    @Override // b7.d
    public View c() {
        View K02 = e().f37740G.K0();
        i.e(K02, "dataBinding.contentLayout.root");
        return K02;
    }

    @Override // b7.d
    public View d() {
        ImageView imageView = e().f37740G.f37722K;
        i.e(imageView, "dataBinding.contentLayout.divider");
        return imageView;
    }

    @Override // y7.C1708a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public m e() {
        return this.f12338b;
    }
}
