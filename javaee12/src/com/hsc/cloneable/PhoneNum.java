package com.hsc.cloneable;

import java.io.Serializable;

public class PhoneNum implements Serializable {

    private static final long serialVersionUID = 2L;
    private String phone;

    public PhoneNum() {
        super();
    }

    public PhoneNum(String phone) {
        super();
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
