package F1;

/* compiled from: DialerCallListener.java */
/* loaded from: classes.dex */
public interface a {
    void onDialerCallUpdate();

    void onHandoverToWifiFailure();

    void onInternationalCallOnWifi();

    void onWiFiToLteHandover();

    default void onDialerCallChildNumberChange() {
    }

    default void onDialerCallLastForwardedNumberChange() {
    }
}
