package b7;

import android.view.View;
import android.widget.ImageView;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.contacts.list.f;
import kotlin.jvm.internal.i;
import x0.k;
import y7.C1708a;

/* compiled from: ContactsMainListItemWithSectionViewHolder.kt */
/* renamed from: b7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0529b extends C1708a implements d {

    /* renamed from: b, reason: collision with root package name */
    public final k f12337b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0529b(k dataBinding) {
        super(dataBinding);
        i.f(dataBinding, "dataBinding");
        this.f12337b = dataBinding;
    }

    @Override // b7.d
    public ImageView a() {
        COUIRoundImageView cOUIRoundImageView = e().f37731G.f37724M;
        i.e(cOUIRoundImageView, "dataBinding.contentLayout.photoView");
        return cOUIRoundImageView;
    }

    @Override // b7.d
    public void b(f item) {
        i.f(item, "item");
        e().f37731G.i1(item);
    }

    @Override // b7.d
    public View c() {
        View K02 = e().f37731G.K0();
        i.e(K02, "dataBinding.contentLayout.root");
        return K02;
    }

    @Override // b7.d
    public View d() {
        ImageView imageView = e().f37731G.f37722K;
        i.e(imageView, "dataBinding.contentLayout.divider");
        return imageView;
    }

    @Override // y7.C1708a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public k e() {
        return this.f12337b;
    }
}
