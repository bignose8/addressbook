/**
  * 
 * Copyright (c) 2012 Ericsson (China) Communications Co.,Ltd. All rights
 * reserved. The Copyright to the computer program(s) herein is the property of
 * Ericsson (China) Communications Co.,Ltd. The program(s) may be used and/or
 * copied with the written permission from Ericsson AB or in accordance with the
 * terms and conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 */
package com.lz.ma.training;

public class AddressItem {
    private String name;
    private String address;
    private String phoneNumber;

    public AddressItem(String name, String address, String phoneNumber) {
        super();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AddressItem [name=").append(name).append(", address=").append(address).append(", phoneNumber=").append(phoneNumber).append("]");
        return builder.toString();
    }

}
