package com.spring.mvcproject.database.mybatis.service;

import com.spring.mvcproject.database.mybatis.PetRepository;
import com.spring.mvcproject.database.mybatis.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 클라이언트의 요청과 응답 사이를 중간처리
@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    // 목록조회 중간 처리
    public List<Pet> getList() {
        List<Pet> petList = petRepository.findAll();
        return petList;
    }

    // 개별조회 중간처리
    public Pet getPet(Long id) {
        Pet pet = petRepository.findById(id);
        return pet;
    }

    // 생성 중간처리
    public boolean createPet(Pet pet) {
        boolean savedPet = petRepository.save(pet);
        return savedPet;
    }

    // 수정 중간처리
    public boolean updatePet(Pet pet) {
        boolean flag = petRepository.updatePet(pet);
        return flag;
    }

    // 삭제 중간처리
    public boolean delete(Long id) {
        boolean flag = petRepository.deleteById(id);
        return flag;
    }

}
