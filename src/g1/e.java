package g1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.framework.omoji.utils.OmojiUtils;
import com.android.contacts.framework.omoji.view.OmojiImageView;
import com.android.contacts.framework.omoji.viewmodel.OmojiRepository;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.foundation.util.display.DisplayUtil;
import e1.C0964a;
import e1.C0965b;
import f.C0991a;
import f1.InterfaceC0995a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import o3.C1401e;
import r3.C1508b;

/* compiled from: OmojiPhotoAdapter.kt */
/* loaded from: classes.dex */
public final class e extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: f, reason: collision with root package name */
    public static final a f31828f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Context f31829a;

    /* renamed from: b, reason: collision with root package name */
    public com.android.contacts.framework.omoji.viewmodel.a f31830b;

    /* renamed from: c, reason: collision with root package name */
    public final f f31831c;

    /* renamed from: d, reason: collision with root package name */
    public final int f31832d;

    /* renamed from: e, reason: collision with root package name */
    public HashSet<String> f31833e;

    /* compiled from: OmojiPhotoAdapter.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: OmojiPhotoAdapter.kt */
    /* loaded from: classes.dex */
    public static final class b implements InterfaceC0995a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f31834a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f31835b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ C0964a.C0293a f31836c;

        public b(g gVar, e eVar, C0964a.C0293a c0293a) {
            this.f31834a = gVar;
            this.f31835b = eVar;
            this.f31836c = c0293a;
        }

        @Override // f1.InterfaceC0995a
        public void a(Pair<Integer, Boolean> pair) {
            String a10;
            Integer c10;
            i.f(pair, "pair");
            if (i.b(pair.d(), Boolean.TRUE) && (c10 = pair.c()) != null && c10.intValue() == 1) {
                EffectiveAnimationView e10 = this.f31834a.e();
                if (e10 != null) {
                    e eVar = this.f31835b;
                    if (!e10.isAnimating()) {
                        eVar.q(e10, true);
                        return;
                    }
                    return;
                }
                return;
            }
            Integer c11 = pair.c();
            if (c11 != null && c11.intValue() == 1) {
                f fVar = this.f31835b.f31831c;
                if (fVar != null) {
                    fVar.onMaterialsMissing();
                }
                C0964a.C0293a c0293a = this.f31836c;
                if (c0293a != null && (a10 = c0293a.a()) != null) {
                    e eVar2 = this.f31835b;
                    if (!eVar2.f31833e.contains(a10)) {
                        eVar2.f31833e.add(a10);
                        return;
                    }
                    return;
                }
                return;
            }
            Integer c12 = pair.c();
            if (c12 != null && c12.intValue() == 2) {
                f fVar2 = this.f31835b.f31831c;
                if (fVar2 != null) {
                    fVar2.onMaterialsOff(this.f31836c);
                    return;
                }
                return;
            }
            Integer c13 = pair.c();
            if (c13 != null && c13.intValue() == 0) {
                f fVar3 = this.f31835b.f31831c;
                if (fVar3 != null) {
                    fVar3.onPhotoClick(this.f31836c);
                    return;
                }
                return;
            }
            H7.b.e("OmojiPhotoAdapter", "materials error");
        }
    }

    public e(Context context, com.android.contacts.framework.omoji.viewmodel.a aVar, f fVar) {
        i.f(context, "context");
        this.f31829a = context;
        this.f31830b = aVar;
        this.f31831c = fVar;
        this.f31832d = (DisplayUtil.f(context, false) - this.f31829a.getResources().getDimensionPixelSize(C0965b.f30560a)) / 4;
        this.f31833e = new HashSet<>();
    }

    public static final void m(e this$0, View view) {
        i.f(this$0, "this$0");
        f fVar = this$0.f31831c;
        if (fVar != null) {
            fVar.onCreateClick();
        }
    }

    public static final void o(e this$0, g photoHolder, C0964a.C0293a c0293a, View view) {
        i.f(this$0, "this$0");
        i.f(photoHolder, "$photoHolder");
        this$0.p(photoHolder, c0293a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i10;
        List<C0964a.C0293a> a10;
        com.android.contacts.framework.omoji.viewmodel.a aVar = this.f31830b;
        if (aVar != null && (a10 = aVar.a()) != null) {
            i10 = a10.size();
        } else {
            i10 = 0;
        }
        return i10 + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (i10 == 0) {
            return 1;
        }
        return 2;
    }

    public final void l(RecyclerView.B b10) {
        i.d(b10, "null cannot be cast to non-null type com.android.contacts.framework.omoji.ui.CreateViewHolder");
        C1032a c1032a = (C1032a) b10;
        OmojiImageView e10 = c1032a.e();
        if (e10 != null) {
            e10.setContentDescription(e10.getContext().getString(e1.f.f30569a));
            com.android.contacts.framework.omoji.viewmodel.a aVar = this.f31830b;
            if (aVar != null && aVar.b()) {
                e10.setImageDrawable(C0991a.b(e10.getContext(), e1.c.f30562a));
            } else {
                e10.setImageDrawable(C0991a.b(e10.getContext(), e1.c.f30563b));
            }
        }
        OmojiImageView e11 = c1032a.e();
        if (e11 != null) {
            e11.setOnClickListener(new View.OnClickListener() { // from class: g1.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.m(e.this, view);
                }
            });
        }
    }

    public final void n(RecyclerView.B b10, int i10) {
        final C0964a.C0293a c0293a;
        String str;
        String str2;
        String str3;
        boolean u10;
        List<C0964a.C0293a> a10;
        com.android.contacts.framework.omoji.viewmodel.a aVar = this.f31830b;
        String str4 = null;
        if (aVar != null && (a10 = aVar.a()) != null) {
            c0293a = a10.get(i10 - 1);
        } else {
            c0293a = null;
        }
        i.d(b10, "null cannot be cast to non-null type com.android.contacts.framework.omoji.ui.PhotoViewHolder");
        final g gVar = (g) b10;
        EffectiveAnimationView e10 = gVar.e();
        if (e10 != null) {
            HashSet<String> hashSet = this.f31833e;
            if (c0293a != null) {
                str3 = c0293a.a();
            } else {
                str3 = null;
            }
            u10 = CollectionsKt___CollectionsKt.u(hashSet, str3);
            if (u10) {
                q(e10, true);
            } else {
                q(e10, false);
            }
        }
        OmojiImageView f10 = gVar.f();
        if (f10 != null) {
            m mVar = m.f34245a;
            String string = f10.getContext().getString(e1.f.f30570b);
            i.e(string, "context.getString(R.string.omoji_position)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
            i.e(format, "format(...)");
            f10.setContentDescription(format);
            if (c0293a != null) {
                str = c0293a.a();
            } else {
                str = null;
            }
            if (c0293a != null) {
                str2 = c0293a.b();
            } else {
                str2 = null;
            }
            C1401e a02 = new C1401e().U(f10.getDrawable()).h(e1.c.f30564c).S(this.f31832d).c().a0(new C1508b(str + str2));
            i.e(a02, "RequestOptions()\n       …ture(ObjectKey(cacheKey))");
            C1401e c1401e = a02;
            com.bumptech.glide.i t10 = com.bumptech.glide.b.t(f10.getContext());
            if (c0293a != null) {
                str4 = c0293a.b();
            }
            t10.r(str4).a(c1401e).t0(f10);
            f10.setOnClickListener(new View.OnClickListener() { // from class: g1.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.o(e.this, gVar, c0293a, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B holder, int i10) {
        i.f(holder, "holder");
        if (holder.getItemViewType() == 1) {
            l(holder);
        } else if (holder.getItemViewType() == 2) {
            n(holder, i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        if (i10 == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(e1.e.f30567a, parent, false);
            i.e(view, "view");
            return new C1032a(view);
        }
        View view2 = LayoutInflater.from(parent.getContext()).inflate(e1.e.f30568b, parent, false);
        i.e(view2, "view");
        return new g(view2);
    }

    public final void p(g gVar, C0964a.C0293a c0293a) {
        String str;
        Context context = this.f31829a;
        if (c0293a != null) {
            str = c0293a.a();
        } else {
            str = null;
        }
        OmojiUtils.f(context, str, new b(gVar, this, c0293a));
    }

    public final void q(EffectiveAnimationView effectiveAnimationView, boolean z10) {
        if (effectiveAnimationView != null) {
            if (z10) {
                effectiveAnimationView.setVisibility(0);
                effectiveAnimationView.playAnimation();
                effectiveAnimationView.setRepeatMode(1);
                effectiveAnimationView.setRepeatCount(-1);
                return;
            }
            effectiveAnimationView.cancelAnimation();
            effectiveAnimationView.setVisibility(8);
        }
    }

    public final void r() {
        this.f31833e.clear();
    }

    public final void s(com.android.contacts.framework.omoji.viewmodel.a aVar) {
        int i10;
        List<C0964a.C0293a> a10;
        List<C0964a.C0293a> a11;
        com.android.contacts.framework.omoji.viewmodel.a aVar2 = this.f31830b;
        Integer num = null;
        if (aVar2 != null && aVar != null && OmojiUtils.j(aVar2, aVar)) {
            List<C0964a.C0293a> a12 = aVar2.a();
            if (a12 != null) {
                num = Integer.valueOf(a12.size());
            }
            H7.b.e("OmojiPhotoAdapter", "isDataEqual size : " + num);
            return;
        }
        this.f31830b = aVar;
        if (aVar != null && (a11 = aVar.a()) != null) {
            i10 = a11.size();
        } else {
            i10 = 0;
        }
        H7.b.e("OmojiPhotoAdapter", "setData size : " + i10);
        if (i10 <= 0) {
            OmojiRepository omojiRepository = OmojiRepository.f16303a;
            List<C0964a.C0293a> a13 = omojiRepository.a().a();
            if (a13 != null && a13.size() > 0) {
                com.android.contacts.framework.omoji.viewmodel.a a14 = omojiRepository.a();
                this.f31830b = a14;
                if (a14 != null && (a10 = a14.a()) != null) {
                    num = Integer.valueOf(a10.size());
                }
                H7.b.e("OmojiPhotoAdapter", "hasCache size : " + num);
            }
        }
        notifyDataSetChanged();
    }
}
