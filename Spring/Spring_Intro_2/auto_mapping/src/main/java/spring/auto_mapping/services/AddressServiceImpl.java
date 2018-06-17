package spring.auto_mapping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.auto_mapping.models.Address;
import spring.auto_mapping.repositories.AddressRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void saveToDb(Address address) {
        this.addressRepository.save(address);
    }
}
