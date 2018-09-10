package com.ccr.library;

/**
 * @Created on 2018/9/1.
 * @autthor Acheng
 * @Email 345887272@qq.com
 * @Description
 */

public interface AFBridgeProxy<T> {
    void call(T source, String id, Object... params);
}
