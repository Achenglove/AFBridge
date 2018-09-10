package com.ccr.library;

import android.support.v4.util.ArrayMap;

import java.lang.ref.SoftReference;


/**
 * @Created on 2018/9/1.
 * @autthor Acheng
 * @Email 345887272@qq.com
 * @Description
 */

public class AFBridge {
    private static final String SUFFIX = "$$AFBridgeProxy";

    private static ArrayMap<String, SoftReference<AFBridgeProxy>> mCache = new ArrayMap<>();

    public static void call(Object host, String id, Object... params) {
        AFBridgeProxy AFBridgeProxy = findAFBridgeProxy(host);
        AFBridgeProxy.call(host, id, params);
    }

    private static AFBridgeProxy findAFBridgeProxy(Object host) {
        try {
            Class clazz = host.getClass();
            String className = clazz.getName() + SUFFIX;
            SoftReference<AFBridgeProxy> fabridgeRef = null;
            synchronized (AFBridge.class) {
                fabridgeRef = mCache.get(className);
            }
            if (fabridgeRef == null || fabridgeRef.get() == null) {
                Class injectorClazz = Class.forName(className);
                AFBridgeProxy AFBridgeProxy = (AFBridgeProxy) injectorClazz.newInstance();
                fabridgeRef = new SoftReference<AFBridgeProxy>(AFBridgeProxy);
                synchronized (AFBridge.class) {
                    mCache.put(className, fabridgeRef);
                }
                return AFBridgeProxy;
            } else {
                return fabridgeRef.get();
            }
        } catch (ClassNotFoundException e) {
            return new AFBridgeProxy() {
                @Override
                public void call(Object source, String id, Object... params) {

                }
            };
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new RuntimeException(String.format("can not find %s , something wrong when compiler.", host.getClass().getSimpleName() + SUFFIX));
    }
}

