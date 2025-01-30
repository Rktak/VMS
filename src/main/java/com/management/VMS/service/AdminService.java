package com.management.VMS.service;

import com.management.VMS.dto.AddressDto;
import com.management.VMS.dto.UserDto;
import com.management.VMS.entity.Address;
import com.management.VMS.entity.Flat;
import com.management.VMS.entity.User;
import com.management.VMS.enums.Role;
import com.management.VMS.enums.UserStatus;
import com.management.VMS.repo.FlatRepo;
import com.management.VMS.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdminService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FlatRepo flatRepo;

    public Long createUser( UserDto userDto){
        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .phone(userDto.getPhone())
                .role(Role.valueOf(userDto.getRole()))
                .status(UserStatus.ACTIVE)
                .idNumber(userDto.getIdNumber())
                .build();
        if(userDto.getAddress() != null){
            AddressDto addressDto = userDto.getAddress();
            Address address = Address.builder()
                    .line1(addressDto.getLine1())
                    .line2(addressDto.getLine1())
                    .pincode(addressDto.getPincode())
                    .city(addressDto.getCity())
                    .country(addressDto.getCountry())
                    .build();
            user.setAddress(address);
        }
        if(userDto.getFlatNo()!=null){
            Flat flat = flatRepo.findByNumber(userDto.getFlatNo());
            if(flat == null){

            }
            user.setFlat(flat);
        }
        user = userRepo.save(user);
        return user.getId();
    }


}
