package com.api.service;

import com.api.entity.Registration;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;
    private static ModelMapper modelMapper;


    public RegistrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }

    public List<RegistrationDto> getRegistrations(){

       List<Registration> registrations = registrationRepository.findAll();
       List<RegistrationDto> dtos= registrations.stream().map(RegistrationService::mapToDto).collect(Collectors.toList());
       return dtos;


    }

    public RegistrationDto getRegistrationById(long id){
        Registration registration = registrationRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Record doesn't exists")
        );
        return mapToDto(registration);
    }

    public RegistrationDto createRegistration(RegistrationDto registrationDto){
        //coping data from dto to entity
        Registration registration = mapToEntity(registrationDto);

        Registration reg = registrationRepository.save(registration);

        //copying data from entity to dto

        RegistrationDto dto =mapToDto(reg);

        return dto;
    }

    public void deleteRegistration(long id){
        registrationRepository.deleteById(id);
    }

    public RegistrationDto updateRegistration(long id, RegistrationDto registrationDto){
        //Optional<Registration> reg =registrationRepository.findById(id);
        //Registration r = reg.get();
        //the above two line code i'm doing in the below one line
        Registration r =registrationRepository.findById(id).get();

       r.setName(registrationDto.getName());
       r.setEmail(registrationDto.getEmail());
       r.setMobile(registrationDto.getMobile());

       Registration savedEntity = registrationRepository.save(r);
       return mapToDto(savedEntity);
    }
//this method is for converting dto to entity
    Registration mapToEntity(RegistrationDto registrationDto){

        Registration registration = modelMapper.map(registrationDto, Registration.class);

        //the above one line code is working same as below next 4 lines of code

//        Registration registration = new Registration();
//
//        registration.setName(registrationDto.getName());
//        registration.setEmail(registrationDto.getEmail());
//        registration.setMobile(registrationDto.getMobile());

        return registration;
    }
//this method is for converting entity to dto
    static RegistrationDto mapToDto(Registration registration){

        RegistrationDto dto =modelMapper.map(registration, RegistrationDto.class);

        //the above one line code is working same as below next 4 lines of code

//        RegistrationDto dto = new RegistrationDto();
//
//        dto.setName(reg.getName());
//        dto.setEmail(reg.getEmail());
//        dto.setMobile(reg.getMobile());

        return dto;
    }
}
