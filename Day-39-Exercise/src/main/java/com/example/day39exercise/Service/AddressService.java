package com.example.day39exercise.Service;

import com.example.day39exercise.ApiResponse.ApiException;
import com.example.day39exercise.DOT.AddressDOT;
import com.example.day39exercise.Model.Address;
import com.example.day39exercise.Model.Teacher;
import com.example.day39exercise.Repository.AddressRepository;
import com.example.day39exercise.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAll (){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDOT addressDOT){
        Teacher teacher = teacherRepository.findTeacherById(addressDOT.getTeacher_id());
        if (teacher==null){
            throw new ApiException("no teacher with this id was found");
        }
        Address address = new Address(null,addressDOT.getArea(),
                addressDOT.getStreet(),addressDOT.getBuildingNumber(),
                teacher);
        addressRepository.save(address);

    }

    public void updateAddress (AddressDOT addressDOT){
        Address oldAddress = addressRepository.findAddressById(addressDOT.getTeacher_id());
        if (oldAddress == null){
            throw  new ApiException("no address with this id was found");
        }
        oldAddress.setArea(addressDOT.getArea());
        oldAddress.setStreet(addressDOT.getStreet());
        oldAddress.setBuildingNumber(addressDOT.getBuildingNumber());
        addressRepository.save(oldAddress);
    }


}
