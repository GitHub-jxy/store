package com.jxy.store.service;

import com.jxy.store.entity.Address;

public interface AddressService {

    void addNewAddress(Integer uid, String username, Address address);

    Integer updateByIsDefault(Integer uid);
}
