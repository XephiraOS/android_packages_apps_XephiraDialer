package s1;

import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.oplus.dialer.R;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: VoicemailPlaybackFragment.java */
/* loaded from: classes.dex */
public class s extends Fragment {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f36667c = {"has_content"};

    /* renamed from: a, reason: collision with root package name */
    public ScheduledExecutorService f36668a;

    /* renamed from: b, reason: collision with root package name */
    public View f36669b;

    public final ScheduledExecutorService c1() {
        return Executors.newScheduledThreadPool(2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f36668a = c1();
        Bundle arguments = getArguments();
        com.google.common.base.k.p(arguments, "fragment must be started with arguments");
        com.google.common.base.k.p((Uri) arguments.getParcelable("EXTRA_VOICEMAIL_URI"), "fragment must contain EXTRA_VOICEMAIL_URI");
        arguments.getBoolean("EXTRA_VOICEMAIL_START_PLAYBACK", false);
        ((PowerManager) getActivity().getSystemService("power")).newWakeLock(6, getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.playback_layout, (ViewGroup) null);
        this.f36669b = inflate;
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f36668a.shutdown();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
