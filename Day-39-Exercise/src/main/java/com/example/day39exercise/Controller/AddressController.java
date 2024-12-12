package com.example.day39exercise.Controller;

import com.example.day39exercise.ApiResponse.ApiResponse;
import com.example.day39exercise.DOT.AddressDOT;
import com.example.day39exercise.Model.Address;
import com.example.day39exercise.Model.Teacher;
import com.example.day39exercise.Repository.AddressRepository;
import com.example.day39exercise.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get-all")
    public ResponseEntity getAll (){
        return ResponseEntity.status(200).body(addressService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDOT addressDOT) {
        addressService.addAddress(addressDOT);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added address"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id,@RequestBody @Valid AddressDOT addressDOT) {
        addressService.updateAddress(addressDOT);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully updated teacher"));
    }


}
