package com.trab01.model;

import com.trab01.interfaces.MenuCallback;

public class MenuOption {
    private Integer code;
    private MenuCallback callback;

    public MenuOption(Integer code, MenuCallback callback) {
        this.callback = callback;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public MenuCallback getCallback() {
        return callback;
    }

    public boolean isCode(Integer c) {
        return this.code == c;
    }
}
