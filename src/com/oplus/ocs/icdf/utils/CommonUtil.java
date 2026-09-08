package com.oplus.ocs.icdf.utils;

import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class CommonUtil {
    public static final String DEFAULT_IP_ADDRESS = "0.0.0.0";
    public static final ScheduledExecutorService DEFAULT_SCHEDULE_EXECUTOR = new ScheduledThreadPoolExecutor(1, new a());
    private static final int IP_ADDRESS_BIT = 8;
    private static final int IP_ADDRESS_BYTES = 4;
    private static final String TAG = "ICDF.CommonUtil";

    /* loaded from: classes3.dex */
    public class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "CommonUtil");
        }
    }

    public static String getHostIpv4Address() {
        Enumeration<NetworkInterface> networkInterfaces;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e10) {
            e10.printStackTrace();
        }
        if (networkInterfaces == null) {
            return DEFAULT_IP_ADDRESS;
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            if (nextElement.getName().equals("eth0")) {
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if ((nextElement2 instanceof Inet4Address) && !nextElement2.isLoopbackAddress()) {
                        ICDFLog.i(TAG, "get Ipv4Address, eth0 " + HexUtils.hideAddress(nextElement2.getHostAddress()));
                        return nextElement2.getHostAddress();
                    }
                }
            }
        }
        Enumeration<NetworkInterface> networkInterfaces2 = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces2 == null) {
            return DEFAULT_IP_ADDRESS;
        }
        while (networkInterfaces2.hasMoreElements()) {
            NetworkInterface nextElement3 = networkInterfaces2.nextElement();
            Enumeration<InetAddress> inetAddresses2 = nextElement3.getInetAddresses();
            while (inetAddresses2.hasMoreElements()) {
                InetAddress nextElement4 = inetAddresses2.nextElement();
                if ((nextElement4 instanceof Inet4Address) && !nextElement4.isLoopbackAddress()) {
                    ICDFLog.i(TAG, "get Ipv4Address, " + nextElement3.getName() + " " + HexUtils.hideAddress(nextElement4.getHostAddress()));
                    return nextElement4.getHostAddress();
                }
            }
        }
        return DEFAULT_IP_ADDRESS;
    }

    public static String ipIntToString(int i10) {
        StringBuilder sb = new StringBuilder();
        int i11 = 0;
        boolean z10 = false;
        while (i11 < 4) {
            if (z10) {
                sb.append('.');
            }
            sb.append((i10 >> ((3 - i11) * 8)) & 255);
            i11++;
            z10 = true;
        }
        return sb.toString();
    }

    public static int ipStringToInt(String str) {
        if (isIPv4Address(str)) {
            Matcher matcher = Pattern.compile("\\d+").matcher(str);
            int i10 = 0;
            int i11 = 0;
            while (matcher.find()) {
                i10 |= Integer.parseInt(matcher.group()) << ((3 - i11) * 8);
                i11++;
            }
            return i10;
        }
        throw new RuntimeException("Invalid ip address");
    }

    private static boolean isIPv4Address(String str) {
        return Pattern.compile("(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).matches();
    }

    public static String getHostIpv4Address(String str) {
        NetworkInterface byName;
        try {
            byName = NetworkInterface.getByName(str);
        } catch (SocketException e10) {
            e10.printStackTrace();
        }
        if (byName == null) {
            ICDFLog.d(TAG, "get NetworkInterface failed: " + str);
            return DEFAULT_IP_ADDRESS;
        }
        Enumeration<InetAddress> inetAddresses = byName.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            InetAddress nextElement = inetAddresses.nextElement();
            if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                ICDFLog.d(TAG, "get HostIpv4Address succeed, " + str + " :" + HexUtils.hideAddress(nextElement.getHostAddress()));
                return nextElement.getHostAddress();
            }
        }
        ICDFLog.d(TAG, "get HostIpv4Address failed: " + str);
        return DEFAULT_IP_ADDRESS;
    }
}
