package io.grpc.internal;

import io.grpc.internal.DnsNameResolver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/* loaded from: classes4.dex */
public final class JndiResourceResolverFactory implements DnsNameResolver.d {

    /* renamed from: a, reason: collision with root package name */
    public static final Throwable f32603a = d();

    /* loaded from: classes4.dex */
    public static final class JndiRecordFetcher implements RecordFetcher {
        public static void b() {
            if (JndiResourceResolverFactory.f32603a == null) {
            } else {
                throw new UnsupportedOperationException("JNDI is not currently available", JndiResourceResolverFactory.f32603a);
            }
        }

        public static void c(NamingEnumeration<?> namingEnumeration, NamingException namingException) {
            try {
                namingEnumeration.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        public static void d(DirContext dirContext, NamingException namingException) {
            try {
                dirContext.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        @Override // io.grpc.internal.JndiResourceResolverFactory.RecordFetcher
        public List<String> a(String str, String str2) {
            b();
            String[] strArr = {str};
            ArrayList arrayList = new ArrayList();
            Hashtable hashtable = new Hashtable();
            hashtable.put("com.sun.jndi.ldap.connect.timeout", "5000");
            hashtable.put("com.sun.jndi.ldap.read.timeout", "5000");
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            try {
                NamingEnumeration all = initialDirContext.getAttributes(str2, strArr).getAll();
                while (all.hasMore()) {
                    try {
                        NamingEnumeration all2 = ((Attribute) all.next()).getAll();
                        while (all2.hasMore()) {
                            try {
                                arrayList.add(String.valueOf(all2.next()));
                            } catch (NamingException e10) {
                                c(all2, e10);
                            }
                        }
                        all2.close();
                    } catch (NamingException e11) {
                        c(all, e11);
                    }
                }
                all.close();
            } catch (NamingException e12) {
                d(initialDirContext, e12);
            }
            initialDirContext.close();
            return arrayList;
        }
    }

    /* loaded from: classes4.dex */
    public static final class JndiResourceResolver implements DnsNameResolver.ResourceResolver {

        /* renamed from: b, reason: collision with root package name */
        public static final Logger f32604b = Logger.getLogger(JndiResourceResolver.class.getName());

        /* renamed from: c, reason: collision with root package name */
        public static final Pattern f32605c = Pattern.compile("\\s+");

        /* renamed from: a, reason: collision with root package name */
        public final RecordFetcher f32606a;

        public JndiResourceResolver(RecordFetcher recordFetcher) {
            this.f32606a = recordFetcher;
        }

        public static String unquote(String str) {
            StringBuilder sb = new StringBuilder(str.length());
            int i10 = 0;
            boolean z10 = false;
            while (i10 < str.length()) {
                char charAt = str.charAt(i10);
                if (!z10) {
                    if (charAt != ' ') {
                        if (charAt == '\"') {
                            z10 = true;
                        }
                        sb.append(charAt);
                    }
                } else if (charAt == '\"') {
                    z10 = false;
                } else {
                    if (charAt == '\\') {
                        i10++;
                        charAt = str.charAt(i10);
                    }
                    sb.append(charAt);
                }
                i10++;
            }
            return sb.toString();
        }

        @Override // io.grpc.internal.DnsNameResolver.ResourceResolver
        public List<String> a(String str) {
            Logger logger = f32604b;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                logger.log(level, "About to query TXT records for {0}", new Object[]{str});
            }
            List<String> a10 = this.f32606a.a("TXT", "dns:///" + str);
            if (logger.isLoggable(level)) {
                logger.log(level, "Found {0} TXT records", new Object[]{Integer.valueOf(a10.size())});
            }
            ArrayList arrayList = new ArrayList(a10.size());
            Iterator<String> it = a10.iterator();
            while (it.hasNext()) {
                arrayList.add(unquote(it.next()));
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    /* loaded from: classes4.dex */
    public interface RecordFetcher {
        List<String> a(String str, String str2);
    }

    public static Throwable d() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException | Error | RuntimeException e10) {
            return e10;
        }
    }

    @Override // io.grpc.internal.DnsNameResolver.d
    public DnsNameResolver.ResourceResolver a() {
        if (b() != null) {
            return null;
        }
        return new JndiResourceResolver(new JndiRecordFetcher());
    }

    @Override // io.grpc.internal.DnsNameResolver.d
    public Throwable b() {
        return f32603a;
    }
}
