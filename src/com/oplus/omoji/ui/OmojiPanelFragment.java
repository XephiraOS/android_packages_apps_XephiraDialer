package com.oplus.omoji.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.InterfaceC0485h;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import c.C0542c;
import c.C0543d;
import com.android.contacts.framework.baseui.fragment.PanelFragment;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.r;
import com.android.contacts.framework.baseui.widget.LinearLayoutCardView;
import com.android.contacts.framework.baseui.widget.SelectedCardView;
import com.android.contacts.framework.omoji.utils.OmojiUtils;
import com.android.contacts.framework.omoji.viewmodel.OmojiRepository;
import com.android.contacts.framework.omoji.viewmodel.OmojiViewModule;
import com.android.contacts.util.i;
import com.android.contacts.util.w;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.panel.COUIBottomSheetDialogFragment;
import com.coui.appcompat.panel.COUIPanelFragment;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import com.oplus.networklib.NetworkMonitor;
import e1.C0964a;
import g1.C1033b;
import kotlin.Result;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: OmojiPanelFragment.kt */
/* loaded from: classes3.dex */
public final class OmojiPanelFragment extends PanelFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String DIALOG_FRAGMENT_TAG = "bottom_sheet";
    private static final String TAG = "OmojiPanelFragment";
    private COUIBottomSheetDialogFragment bottomSheetDialogFragment;
    private final androidx.activity.result.b<Intent> createOmojiActivityResultLauncher;
    private final androidx.activity.result.b<Intent> cropPhotoActivityResultLauncher;
    private Uri croppedPhotoUri;
    private androidx.appcompat.app.b deletePhotoDialog;
    private ImageView guideView;
    private boolean hasPhoto;
    private boolean isTakePhoto;
    private boolean isUserProfile;
    private final BroadcastReceiver listDownloadBroadCastReceiver;
    private final BroadcastReceiver materialsDownloadBroadCastReceiver;
    private final androidx.activity.result.b<Intent> materialsOffActivityResultLauncher;
    private androidx.appcompat.app.b materialsOffDialog;
    private final androidx.activity.result.b<Intent> moreSettingActivityResultLauncher;
    private TextView moreSettingView;
    private g1.e omojiPhotoAdapter;
    private final androidx.activity.result.b<Intent> pickPhotoActivityResultLauncher;
    private COUIRecyclerView recyclerView;
    private final androidx.activity.result.b<String> requestActivityResultLauncher;
    private Bundle savedBundle;
    private int sourceType;
    private COUIButton startButton;
    private Uri tempPhotoUri;
    private final androidx.activity.result.b<Intent> useOmojiActivityResultLauncher;
    private final m9.d viewModel$delegate;

    /* compiled from: OmojiPanelFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public OmojiPanelFragment() {
        final InterfaceC1637a<Fragment> interfaceC1637a = new InterfaceC1637a<Fragment>() { // from class: com.oplus.omoji.ui.OmojiPanelFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel$delegate = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(OmojiViewModule.class), new InterfaceC1637a<M>() { // from class: com.oplus.omoji.ui.OmojiPanelFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final M invoke() {
                M viewModelStore = ((N) InterfaceC1637a.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.i.e(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new InterfaceC1637a<K.b>() { // from class: com.oplus.omoji.ui.OmojiPanelFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final K.b invoke() {
                Object invoke = InterfaceC1637a.this.invoke();
                InterfaceC0485h interfaceC0485h = invoke instanceof InterfaceC0485h ? (InterfaceC0485h) invoke : null;
                K.b defaultViewModelProviderFactory = interfaceC0485h != null ? interfaceC0485h.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                kotlin.jvm.internal.i.e(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.sourceType = -1;
        androidx.activity.result.b<Intent> registerForActivityResult = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.omoji.ui.a
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                OmojiPanelFragment.materialsOffActivityResultLauncher$lambda$16(OmojiPanelFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult, "registerForActivityResul… = false)\n        }\n    }");
        this.materialsOffActivityResultLauncher = registerForActivityResult;
        androidx.activity.result.b<Intent> registerForActivityResult2 = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.omoji.ui.c
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                OmojiPanelFragment.moreSettingActivityResultLauncher$lambda$17(OmojiPanelFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult2, "registerForActivityResul…, useCache = false)\n    }");
        this.moreSettingActivityResultLauncher = registerForActivityResult2;
        androidx.activity.result.b<Intent> registerForActivityResult3 = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.omoji.ui.d
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                OmojiPanelFragment.createOmojiActivityResultLauncher$lambda$18(OmojiPanelFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult3, "registerForActivityResul… = false)\n        }\n    }");
        this.createOmojiActivityResultLauncher = registerForActivityResult3;
        androidx.activity.result.b<Intent> registerForActivityResult4 = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.omoji.ui.e
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                OmojiPanelFragment.useOmojiActivityResultLauncher$lambda$19(OmojiPanelFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult4, "registerForActivityResul…esult(it)\n        }\n    }");
        this.useOmojiActivityResultLauncher = registerForActivityResult4;
        androidx.activity.result.b<Intent> registerForActivityResult5 = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.omoji.ui.f
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                OmojiPanelFragment.pickPhotoActivityResultLauncher$lambda$22(OmojiPanelFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult5, "registerForActivityResul…        }\n        }\n    }");
        this.pickPhotoActivityResultLauncher = registerForActivityResult5;
        androidx.activity.result.b<Intent> registerForActivityResult6 = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.omoji.ui.g
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                OmojiPanelFragment.cropPhotoActivityResultLauncher$lambda$23(OmojiPanelFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult6, "registerForActivityResul…ssPanel()\n        }\n    }");
        this.cropPhotoActivityResultLauncher = registerForActivityResult6;
        androidx.activity.result.b<String> registerForActivityResult7 = registerForActivityResult(new C0542c(), new androidx.activity.result.a() { // from class: com.oplus.omoji.ui.h
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                OmojiPanelFragment.requestActivityResultLauncher$lambda$24(OmojiPanelFragment.this, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult7, "registerForActivityResul…Activity)\n        }\n    }");
        this.requestActivityResultLauncher = registerForActivityResult7;
        this.listDownloadBroadCastReceiver = new BroadcastReceiver() { // from class: com.oplus.omoji.ui.OmojiPanelFragment$listDownloadBroadCastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                OmojiViewModule viewModel;
                if (intent != null) {
                    str = intent.getStringExtra("omoji_list_download");
                } else {
                    str = null;
                }
                String valueOf = String.valueOf(str);
                H7.b.e("OmojiPanelFragment", "status = " + valueOf);
                if (!kotlin.jvm.internal.i.b(valueOf, "start") && kotlin.jvm.internal.i.b(valueOf, "end")) {
                    viewModel = OmojiPanelFragment.this.getViewModel();
                    viewModel.h(context, false, false);
                }
            }
        };
        this.materialsDownloadBroadCastReceiver = new BroadcastReceiver() { // from class: com.oplus.omoji.ui.OmojiPanelFragment$materialsDownloadBroadCastReceiver$1
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
            
                r1 = r1.this$0.omojiPhotoAdapter;
             */
            @Override // android.content.BroadcastReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onReceive(android.content.Context r2, android.content.Intent r3) {
                /*
                    r1 = this;
                    if (r3 == 0) goto L9
                    java.lang.String r2 = "omoji_materials_download"
                    java.lang.String r2 = r3.getStringExtra(r2)
                    goto La
                L9:
                    r2 = 0
                La:
                    java.lang.String r2 = java.lang.String.valueOf(r2)
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r0 = "materialStatus = "
                    r3.append(r0)
                    r3.append(r2)
                    java.lang.String r3 = r3.toString()
                    java.lang.String r0 = "OmojiPanelFragment"
                    H7.b.e(r0, r3)
                    int r3 = r2.hashCode()
                    r0 = 100571(0x188db, float:1.4093E-40)
                    if (r3 == r0) goto L6d
                    r0 = 106440182(0x65825f6, float:4.0652974E-35)
                    if (r3 == r0) goto L4d
                    r0 = 109757538(0x68ac462, float:5.219839E-35)
                    if (r3 == r0) goto L38
                    goto L8c
                L38:
                    java.lang.String r3 = "start"
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L41
                    goto L8c
                L41:
                    com.oplus.omoji.ui.OmojiPanelFragment r1 = com.oplus.omoji.ui.OmojiPanelFragment.this
                    g1.e r1 = com.oplus.omoji.ui.OmojiPanelFragment.access$getOmojiPhotoAdapter$p(r1)
                    if (r1 == 0) goto L8c
                    r1.notifyDataSetChanged()
                    goto L8c
                L4d:
                    java.lang.String r3 = "pause"
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L56
                    goto L8c
                L56:
                    com.oplus.omoji.ui.OmojiPanelFragment r2 = com.oplus.omoji.ui.OmojiPanelFragment.this
                    g1.e r2 = com.oplus.omoji.ui.OmojiPanelFragment.access$getOmojiPhotoAdapter$p(r2)
                    if (r2 == 0) goto L61
                    r2.r()
                L61:
                    com.oplus.omoji.ui.OmojiPanelFragment r1 = com.oplus.omoji.ui.OmojiPanelFragment.this
                    g1.e r1 = com.oplus.omoji.ui.OmojiPanelFragment.access$getOmojiPhotoAdapter$p(r1)
                    if (r1 == 0) goto L8c
                    r1.notifyDataSetChanged()
                    goto L8c
                L6d:
                    java.lang.String r3 = "end"
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L76
                    goto L8c
                L76:
                    com.oplus.omoji.ui.OmojiPanelFragment r2 = com.oplus.omoji.ui.OmojiPanelFragment.this
                    g1.e r2 = com.oplus.omoji.ui.OmojiPanelFragment.access$getOmojiPhotoAdapter$p(r2)
                    if (r2 == 0) goto L81
                    r2.r()
                L81:
                    com.oplus.omoji.ui.OmojiPanelFragment r1 = com.oplus.omoji.ui.OmojiPanelFragment.this
                    g1.e r1 = com.oplus.omoji.ui.OmojiPanelFragment.access$getOmojiPhotoAdapter$p(r1)
                    if (r1 == 0) goto L8c
                    r1.notifyDataSetChanged()
                L8c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.omoji.ui.OmojiPanelFragment$materialsDownloadBroadCastReceiver$1.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createOmojiActivityResultLauncher$lambda$18(OmojiPanelFragment this$0, ActivityResult it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (it.d() == -1) {
            h0.S(this$0.getContext(), this$0.sourceType, "state", "3");
            kotlin.jvm.internal.i.e(it, "it");
            this$0.handleOmojiActivityResult(it);
        } else if (it.d() == 0) {
            this$0.getViewModel().h(this$0.getContext(), false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cropPhotoActivityResultLauncher$lambda$23(OmojiPanelFragment this$0, ActivityResult activityResult) {
        String str;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (activityResult.d() == -1) {
            if (this$0.isTakePhoto) {
                str = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
            } else {
                str = "2";
            }
            h0.S(this$0.getContext(), this$0.sourceType, "state", str);
            com.android.contacts.util.i.q(this$0.getContext(), activityResult.b(), this$0.croppedPhotoUri);
            Bundle bundle = new Bundle();
            bundle.putInt("panel_request_type", 1);
            bundle.putBoolean("delete_temp_photo_uri", true);
            bundle.putBoolean("is_from_document", false);
            this$0.setFragmentResult(bundle);
            this$0.dismissPanel();
        }
    }

    private final void dismissDeletePhotoDialog() {
        androidx.appcompat.app.b bVar;
        androidx.appcompat.app.b bVar2 = this.deletePhotoDialog;
        if (bVar2 != null && bVar2.isShowing() && (bVar = this.deletePhotoDialog) != null) {
            bVar.dismiss();
        }
        this.deletePhotoDialog = null;
    }

    private final void dismissPanel() {
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment;
        if (this.savedBundle != null) {
            COUIToolbar toolbar = getToolbar();
            if (toolbar != null) {
                toolbar.post(new Runnable() { // from class: com.oplus.omoji.ui.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        OmojiPanelFragment.dismissPanel$lambda$25(OmojiPanelFragment.this);
                    }
                });
                return;
            }
            return;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof COUIBottomSheetDialogFragment) {
            cOUIBottomSheetDialogFragment = (COUIBottomSheetDialogFragment) parentFragment;
        } else {
            cOUIBottomSheetDialogFragment = null;
        }
        if (cOUIBottomSheetDialogFragment != null) {
            cOUIBottomSheetDialogFragment.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissPanel$lambda$25(OmojiPanelFragment this$0) {
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Fragment parentFragment = this$0.getParentFragment();
        if (parentFragment instanceof COUIBottomSheetDialogFragment) {
            cOUIBottomSheetDialogFragment = (COUIBottomSheetDialogFragment) parentFragment;
        } else {
            cOUIBottomSheetDialogFragment = null;
        }
        if (cOUIBottomSheetDialogFragment != null) {
            cOUIBottomSheetDialogFragment.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OmojiViewModule getViewModel() {
        return (OmojiViewModule) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMaterialsMissing() {
        Context context = getContext();
        if (context != null) {
            boolean d10 = NetworkMonitor.d(context);
            H7.b.e(TAG, "connect = " + d10);
            if (d10) {
                OmojiUtils.o(context);
            } else {
                com.oplus.foundation.util.ui.c.b(context, R.string.materials_miss_update_with_network);
            }
        }
    }

    private final void handleOmojiActivityResult(ActivityResult activityResult) {
        Intent b10 = activityResult.b();
        String l10 = C7.e.l(b10, "contact_photo_uri");
        String l11 = C7.e.l(b10, "dial_photo_uri");
        String l12 = C7.e.l(b10, "dial_photo_bg_color");
        Bundle bundle = new Bundle();
        bundle.putInt("panel_request_type", 2);
        bundle.putString("contact_photo_uri", l10);
        bundle.putString("dial_photo_uri", l11);
        bundle.putString("dial_photo_bg_color", l12);
        H7.b.e(TAG, "contactPhotoUri = " + l10 + ", dialPhotoUri = " + l11 + ", dialPhotoBgColor = " + l12);
        setFragmentResult(bundle);
        dismissPanel();
    }

    private final void initAdapter() {
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        g1.e eVar = new g1.e(requireContext, null, new g1.f() { // from class: com.oplus.omoji.ui.OmojiPanelFragment$initAdapter$1
            @Override // g1.f
            public void onCreateClick() {
                OmojiViewModule viewModel;
                int i10;
                androidx.activity.result.b bVar;
                viewModel = OmojiPanelFragment.this.getViewModel();
                com.android.contacts.framework.omoji.viewmodel.a value = viewModel.g().getValue();
                if (value != null && value.b()) {
                    com.oplus.foundation.util.ui.c.b(OmojiPanelFragment.this.getContext(), R.string.number_of_omoji_reached_maximum);
                    return;
                }
                Context context = OmojiPanelFragment.this.getContext();
                i10 = OmojiPanelFragment.this.sourceType;
                h0.S(context, i10, "add_way", "create");
                Intent i11 = OmojiUtils.i(1, null);
                bVar = OmojiPanelFragment.this.createOmojiActivityResultLauncher;
                T7.b.b(bVar, OmojiPanelFragment.this.getContext(), i11, 0);
                C0636a.a(OmojiPanelFragment.this.getActivity());
            }

            @Override // g1.f
            public void onMaterialsMissing() {
                OmojiPanelFragment.this.handleMaterialsMissing();
            }

            @Override // g1.f
            public void onMaterialsOff(C0964a.C0293a c0293a) {
                OmojiPanelFragment.this.showMaterialsOffDialog(c0293a);
            }

            @Override // g1.f
            public void onPhotoClick(C0964a.C0293a c0293a) {
                int i10;
                String str;
                androidx.activity.result.b bVar;
                Context context = OmojiPanelFragment.this.getContext();
                i10 = OmojiPanelFragment.this.sourceType;
                h0.S(context, i10, "add_way", "use_omoji");
                if (c0293a != null) {
                    str = c0293a.a();
                } else {
                    str = null;
                }
                Intent i11 = OmojiUtils.i(2, str);
                bVar = OmojiPanelFragment.this.useOmojiActivityResultLauncher;
                T7.b.b(bVar, OmojiPanelFragment.this.getContext(), i11, 0);
            }
        });
        this.omojiPhotoAdapter = eVar;
        eVar.s(null);
    }

    private final void initDeleteView(View view, boolean z10) {
        SelectedCardView selectedCardView;
        int i10;
        if (view != null && (selectedCardView = (SelectedCardView) view.findViewById(R.id.delete_layout)) != null) {
            selectedCardView.setOnClickListener(this);
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            selectedCardView.setVisibility(i10);
        }
    }

    private final void initOmojiView(View view) {
        RelativeLayout relativeLayout;
        if (view != null && (relativeLayout = (RelativeLayout) view.findViewById(R.id.omoji_layout)) != null) {
            this.guideView = (ImageView) relativeLayout.findViewById(R.id.guide);
            COUIButton cOUIButton = (COUIButton) relativeLayout.findViewById(R.id.start_use);
            this.startButton = cOUIButton;
            if (cOUIButton != null) {
                cOUIButton.setOnClickListener(this);
            }
            this.recyclerView = (COUIRecyclerView) relativeLayout.findViewById(R.id.omoji_list);
        }
        COUIRecyclerView cOUIRecyclerView = this.recyclerView;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.setLayoutManager(new GridLayoutManager(cOUIRecyclerView.getContext(), 4));
            cOUIRecyclerView.setAdapter(this.omojiPhotoAdapter);
            Context context = cOUIRecyclerView.getContext();
            kotlin.jvm.internal.i.e(context, "context");
            cOUIRecyclerView.addItemDecoration(new C1033b(context));
        }
    }

    private final void initPanelTop(View view) {
        if (view != null) {
            LinearLayoutCardView linearLayoutCardView = (LinearLayoutCardView) view.findViewById(R.id.take_photo_layout);
            if (linearLayoutCardView != null) {
                kotlin.jvm.internal.i.e(linearLayoutCardView, "findViewById<LinearLayou…>(R.id.take_photo_layout)");
                linearLayoutCardView.setOnClickListener(this);
            }
            LinearLayoutCardView linearLayoutCardView2 = (LinearLayoutCardView) view.findViewById(R.id.pick_photo_layout);
            if (linearLayoutCardView2 != null) {
                kotlin.jvm.internal.i.e(linearLayoutCardView2, "findViewById<LinearLayou…>(R.id.pick_photo_layout)");
                linearLayoutCardView2.setOnClickListener(this);
            }
            TextView textView = (TextView) view.findViewById(R.id.more_setting);
            this.moreSettingView = textView;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
        }
    }

    private final void initToolbar(View view) {
        COUIToolbar cOUIToolbar;
        String string;
        if (view != null && (cOUIToolbar = (COUIToolbar) view.findViewById(R.id.toolbar)) != null) {
            if (this.isUserProfile) {
                string = cOUIToolbar.getContext().getResources().getString(R.string.my_photo);
            } else {
                string = cOUIToolbar.getContext().getResources().getString(R.string.contact_photo);
            }
            cOUIToolbar.setTitle(string);
            cOUIToolbar.setIsTitleCenterStyle(true);
            cOUIToolbar.inflateMenu(R.menu.cancel_null_menu);
            MenuItem findItem = cOUIToolbar.getMenu().findItem(R.id.cancel);
            if (findItem != null) {
                kotlin.jvm.internal.i.e(findItem, "findItem(R.id.cancel)");
                findItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.oplus.omoji.ui.b
                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        boolean initToolbar$lambda$8$lambda$7$lambda$6;
                        initToolbar$lambda$8$lambda$7$lambda$6 = OmojiPanelFragment.initToolbar$lambda$8$lambda$7$lambda$6(OmojiPanelFragment.this, menuItem);
                        return initToolbar$lambda$8$lambda$7$lambda$6;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initToolbar$lambda$8$lambda$7$lambda$6(OmojiPanelFragment this$0, MenuItem it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(it, "it");
        this$0.dismissPanel();
        return true;
    }

    private final void initViewModel() {
        getViewModel().g().i(getViewLifecycleOwner(), new OmojiPanelFragment$sam$androidx_lifecycle_Observer$0(new v9.l<com.android.contacts.framework.omoji.viewmodel.a, q>() { // from class: com.oplus.omoji.ui.OmojiPanelFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(com.android.contacts.framework.omoji.viewmodel.a aVar) {
                invoke2(aVar);
                return q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.android.contacts.framework.omoji.viewmodel.a aVar) {
                g1.e eVar;
                eVar = OmojiPanelFragment.this.omojiPhotoAdapter;
                if (eVar != null) {
                    OmojiPanelFragment omojiPanelFragment = OmojiPanelFragment.this;
                    H7.b.e("OmojiPanelFragment", "observe ------------");
                    omojiPanelFragment.updateView(false);
                    eVar.s(aVar);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void materialsOffActivityResultLauncher$lambda$16(OmojiPanelFragment this$0, ActivityResult it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (it.d() == -1) {
            kotlin.jvm.internal.i.e(it, "it");
            this$0.handleOmojiActivityResult(it);
        } else if (it.d() == 0) {
            this$0.getViewModel().h(this$0.getContext(), false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moreSettingActivityResultLauncher$lambda$17(OmojiPanelFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.getViewModel().h(this$0.getContext(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pickPhotoActivityResultLauncher$lambda$22(OmojiPanelFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        i.a r10 = com.android.contacts.util.i.r(this$0.getContext(), activityResult.b(), activityResult.d(), this$0.tempPhotoUri, this$0.croppedPhotoUri);
        if (!r10.f17568a) {
            if (r10.f17570c != null) {
                androidx.activity.result.b<Intent> bVar = this$0.cropPhotoActivityResultLauncher;
                Context context = this$0.getContext();
                Intent intent = r10.f17569b;
                kotlin.jvm.internal.i.e(intent, "result.mCropIntent");
                T7.b.b(bVar, context, intent, 0);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("panel_request_type", 1);
            bundle.putBoolean("delete_temp_photo_uri", false);
            Uri uri = r10.f17571d;
            if (uri != null) {
                bundle.putString("new_crop_photo_uri", uri.toString());
            }
            bundle.putBoolean("is_from_document", true);
            this$0.setFragmentResult(bundle);
            this$0.dismissPanel();
        }
    }

    private final void regisListDownLoadReceiver() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.omoji.LIST_DOWNLOAD");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.registerReceiver(this.listDownloadBroadCastReceiver, intentFilter, 2);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
        }
    }

    private final void regisMaterialsDownLoadReceiver() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.omoji.MATERIALS_DOWNLOAD");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.registerReceiver(this.materialsDownloadBroadCastReceiver, intentFilter, 2);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
        }
    }

    private final void registerReceiver() {
        regisListDownLoadReceiver();
        regisMaterialsDownLoadReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestActivityResultLauncher$lambda$24(OmojiPanelFragment this$0, Boolean it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(it, "it");
        if (it.booleanValue()) {
            androidx.activity.result.b<Intent> bVar = this$0.pickPhotoActivityResultLauncher;
            Context context = this$0.getContext();
            Intent p10 = com.android.contacts.util.i.p(this$0.tempPhotoUri);
            kotlin.jvm.internal.i.e(p10, "getTakePhotoIntent(tempPhotoUri)");
            T7.b.b(bVar, context, p10, 0);
            return;
        }
        if (!this$0.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            String string = this$0.getString(R.string.people);
            kotlin.jvm.internal.i.e(string, "getString(R.string.people)");
            w.D(this$0.getActivity(), false, string, null, new String[]{"android.permission.CAMERA"}, this$0.getActivity() instanceof ContactsTabActivity);
        }
    }

    private final void setFragmentResult(Bundle bundle) {
        FragmentManager parentFragmentManager;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragmentManager = parentFragment.getParentFragmentManager()) != null) {
            if (this.sourceType == 2) {
                parentFragmentManager.A1("panel_request_key_for_edit", bundle);
            } else {
                parentFragmentManager.A1("panel_request_key_for_detail", bundle);
            }
        }
    }

    private final void showDeletePhotoDialog() {
        int i10;
        if (!isAdded()) {
            return;
        }
        dismissDeletePhotoDialog();
        final Context context = getContext();
        if (context == null) {
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.oplus.omoji.ui.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                OmojiPanelFragment.showDeletePhotoDialog$lambda$34(context, this, dialogInterface, i11);
            }
        };
        U0.b bVar = new U0.b(context, 2132083073);
        if (this.isUserProfile) {
            i10 = R.string.delete_my_business_card_icon;
        } else {
            i10 = R.string.delete_contact_photo;
        }
        bVar.setTitle(i10);
        bVar.setNeutralButton(R.string.delete_button, onClickListener);
        Button button = null;
        bVar.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        androidx.appcompat.app.b show = bVar.show();
        this.deletePhotoDialog = show;
        if (show != null) {
            button = show.b(-1);
        }
        if (button != null) {
            button.setTextColor(r.d(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeletePhotoDialog$lambda$34(Context context, OmojiPanelFragment this$0, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(context, "$context");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        h0.S(context, this$0.sourceType, "state", "5");
        Bundle bundle = new Bundle();
        bundle.putInt("panel_request_type", 0);
        this$0.setFragmentResult(bundle);
        this$0.dismissPanel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMaterialsOffDialog$lambda$29(Context context, OmojiPanelFragment this$0, C0964a.C0293a c0293a, DialogInterface dialogInterface, int i10) {
        String str;
        kotlin.jvm.internal.i.f(context, "$context");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        h0.R(context, this$0.sourceType, "click_item", "edit");
        if (c0293a != null) {
            str = c0293a.a();
        } else {
            str = null;
        }
        T7.b.b(this$0.materialsOffActivityResultLauncher, context, OmojiUtils.i(0, str), 0);
    }

    private final void unRegisListDownLoadReceiver() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.unregisterReceiver(this.listDownloadBroadCastReceiver);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
        }
    }

    private final void unRegisMaterialsDownLoadReceiver() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.unregisterReceiver(this.materialsDownloadBroadCastReceiver);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
        }
    }

    private final void unRegisterReceiver() {
        unRegisListDownLoadReceiver();
        unRegisMaterialsDownLoadReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView(boolean z10) {
        if (z10) {
            TextView textView = this.moreSettingView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            COUIRecyclerView cOUIRecyclerView = this.recyclerView;
            if (cOUIRecyclerView != null) {
                cOUIRecyclerView.setVisibility(8);
            }
            ImageView imageView = this.guideView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            COUIButton cOUIButton = this.startButton;
            if (cOUIButton != null) {
                cOUIButton.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView2 = this.moreSettingView;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        COUIRecyclerView cOUIRecyclerView2 = this.recyclerView;
        if (cOUIRecyclerView2 != null) {
            cOUIRecyclerView2.setVisibility(0);
        }
        ImageView imageView2 = this.guideView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        COUIButton cOUIButton2 = this.startButton;
        if (cOUIButton2 != null) {
            cOUIButton2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void useOmojiActivityResultLauncher$lambda$19(OmojiPanelFragment this$0, ActivityResult it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (it.d() == -1) {
            h0.S(this$0.getContext(), this$0.sourceType, "state", "4");
            kotlin.jvm.internal.i.e(it, "it");
            this$0.handleOmojiActivityResult(it);
        }
    }

    public final void init(Uri uri, Uri uri2, boolean z10, boolean z11, int i10) {
        this.tempPhotoUri = uri;
        this.croppedPhotoUri = uri2;
        this.hasPhoto = z10;
        this.isUserProfile = z11;
        this.sourceType = i10;
    }

    @Override // com.coui.appcompat.panel.COUIPanelFragment
    public void initView(View view) {
        View view2;
        ViewGroup viewGroup;
        COUIToolbar toolbar = getToolbar();
        if (toolbar != null) {
            toolbar.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            view2 = LayoutInflater.from(activity).inflate(R.layout.photo_panel_layout, (ViewGroup) null, false);
        } else {
            view2 = null;
        }
        if (view2 != null) {
            hideDragView();
            initToolbar(view2);
            initPanelTop(view2);
            initAdapter();
            initDeleteView(view2, this.hasPhoto);
            initOmojiView(view2);
        }
        View contentView = getContentView();
        if (contentView instanceof ViewGroup) {
            viewGroup = (ViewGroup) contentView;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.addView(view2);
        }
        View dragView = getDragView();
        if (dragView != null) {
            dragView.setVisibility(4);
        }
        initViewModel();
        if (OmojiUtils.k(getContext())) {
            OmojiRepository.f16303a.a().d(null);
            updateView(true);
        } else {
            updateView(false);
            H7.b.e(TAG, "initView getOmojiList------------");
            getViewModel().h(getContext(), true, true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        kotlin.jvm.internal.i.f(v10, "v");
        switch (v10.getId()) {
            case R.id.delete_layout /* 2131427851 */:
                h0.S(getContext(), this.sourceType, "add_way", "delete");
                showDeletePhotoDialog();
                return;
            case R.id.more_setting /* 2131428430 */:
                h0.R(getContext(), this.sourceType, "click_item", "more");
                T7.b.b(this.moreSettingActivityResultLauncher, getContext(), OmojiUtils.g(), 0);
                return;
            case R.id.pick_photo_layout /* 2131428679 */:
                this.isTakePhoto = false;
                h0.S(getContext(), this.sourceType, "add_way", "photo");
                Context requireContext = requireContext();
                kotlin.jvm.internal.i.e(requireContext, "requireContext()");
                h0.y(requireContext, "photo", this.isUserProfile);
                androidx.activity.result.b<Intent> bVar = this.pickPhotoActivityResultLauncher;
                Context context = getContext();
                Intent n10 = com.android.contacts.util.i.n(getContext(), this.tempPhotoUri);
                kotlin.jvm.internal.i.e(n10, "getPhotoIntent(context, tempPhotoUri)");
                T7.b.b(bVar, context, n10, 0);
                C0636a.a(getActivity());
                return;
            case R.id.start_use /* 2131429065 */:
                getViewModel().h(getContext(), true, false);
                return;
            case R.id.take_photo_layout /* 2131429150 */:
                this.isTakePhoto = true;
                com.android.contacts.util.i.c(getContext(), this.isUserProfile, this.requestActivityResultLauncher, new f1.c() { // from class: com.oplus.omoji.ui.OmojiPanelFragment$onClick$1
                    @Override // f1.c
                    public void onGranted() {
                        int i10;
                        androidx.activity.result.b bVar2;
                        Uri uri;
                        Context context2 = OmojiPanelFragment.this.getContext();
                        i10 = OmojiPanelFragment.this.sourceType;
                        h0.S(context2, i10, "add_way", "camera");
                        bVar2 = OmojiPanelFragment.this.pickPhotoActivityResultLauncher;
                        Context context3 = OmojiPanelFragment.this.getContext();
                        uri = OmojiPanelFragment.this.tempPhotoUri;
                        Intent p10 = com.android.contacts.util.i.p(uri);
                        kotlin.jvm.internal.i.e(p10, "getTakePhotoIntent(tempPhotoUri)");
                        T7.b.b(bVar2, context3, p10, 0);
                    }
                });
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        ViewTreeObserver viewTreeObserver;
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        COUIRecyclerView cOUIRecyclerView = this.recyclerView;
        if (cOUIRecyclerView != null && (viewTreeObserver = cOUIRecyclerView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new OmojiPanelFragment$onConfigurationChanged$1(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.tempPhotoUri = Uri.parse(bundle.getString("temp_photo_uri"));
            this.croppedPhotoUri = Uri.parse(bundle.getString("cropped_photo_uri"));
            this.hasPhoto = bundle.getBoolean("has_photo", false);
            this.isUserProfile = bundle.getBoolean("is_user_profile", false);
            this.sourceType = bundle.getInt("source_type", -1);
            this.isTakePhoto = bundle.getBoolean("take_photo", false);
            this.savedBundle = bundle;
        }
        registerReceiver();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        androidx.appcompat.app.b bVar = this.materialsOffDialog;
        if (bVar != null) {
            bVar.dismiss();
        }
        this.materialsOffDialog = null;
        dismissDeletePhotoDialog();
        unRegisterReceiver();
    }

    @Override // com.coui.appcompat.panel.COUIPanelFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        super.onSaveInstanceState(outState);
        Uri uri = this.tempPhotoUri;
        if (uri != null) {
            outState.putString("temp_photo_uri", uri.toString());
        }
        Uri uri2 = this.croppedPhotoUri;
        if (uri2 != null) {
            outState.putString("cropped_photo_uri", uri2.toString());
        }
        outState.putBoolean("has_photo", this.hasPhoto);
        outState.putBoolean("is_user_profile", this.isUserProfile);
        outState.putInt("source_type", this.sourceType);
        outState.putBoolean("take_photo", this.isTakePhoto);
    }

    public final void showMaterialsOffDialog(final C0964a.C0293a c0293a) {
        if (!isAdded()) {
            return;
        }
        androidx.appcompat.app.b bVar = this.materialsOffDialog;
        if (bVar != null) {
            bVar.dismiss();
        }
        final Context context = getContext();
        if (context == null) {
            return;
        }
        this.materialsOffDialog = new COUIAlertDialogBuilder(context).setTitle(R.string.materials_offline).setPositiveButton(R.string.oplus_menu_edit, new DialogInterface.OnClickListener() { // from class: com.oplus.omoji.ui.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                OmojiPanelFragment.showMaterialsOffDialog$lambda$29(context, this, c0293a, dialogInterface, i10);
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    public final boolean showPanelFragment(FragmentManager fragmentManager, COUIPanelFragment panelFragment) {
        Object b10;
        q qVar;
        kotlin.jvm.internal.i.f(panelFragment, "panelFragment");
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = this.bottomSheetDialogFragment;
        if (cOUIBottomSheetDialogFragment != null) {
            cOUIBottomSheetDialogFragment.dismiss();
        }
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment2 = new COUIBottomSheetDialogFragment();
        this.bottomSheetDialogFragment = cOUIBottomSheetDialogFragment2;
        cOUIBottomSheetDialogFragment2.setMainPanelFragment(panelFragment);
        if (fragmentManager != null) {
            try {
                Result.a aVar = Result.f34166a;
                COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment3 = this.bottomSheetDialogFragment;
                if (cOUIBottomSheetDialogFragment3 != null) {
                    cOUIBottomSheetDialogFragment3.show(fragmentManager, DIALOG_FRAGMENT_TAG);
                    qVar = q.f35511a;
                } else {
                    qVar = null;
                }
                b10 = Result.b(qVar);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c(TAG, "showPanelFragment onFailure " + d10);
            }
            Result.a(b10);
            return true;
        }
        return true;
    }
}
