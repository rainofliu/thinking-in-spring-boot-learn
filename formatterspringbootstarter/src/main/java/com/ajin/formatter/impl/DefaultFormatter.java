package com.ajin.formatter.impl;

import com.ajin.formatter.Formatter;

/**
 * @author ajin
 */

public class DefaultFormatter implements Formatter {
    @Override
    public String format(Object object) {
        // null 返回"null"
        return String.valueOf(object);
    }
}
