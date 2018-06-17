package spring.auto_mapping.services;

import spring.auto_mapping.models.Address;

public interface AddressService {
    void saveToDb(Address address);
}
