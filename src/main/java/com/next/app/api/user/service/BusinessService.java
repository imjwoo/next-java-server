package com.next.app.api.user.service;

import com.next.app.api.user.entity.Business;
import com.next.app.api.user.entity.Product;
import com.next.app.api.user.repository.BusinessRepository;
import com.next.app.api.user.repository.ProductRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    // 사업자 전체 조회
    public List<Business> getAllBusiness() {
        return businessRepository.findAll();
    }
    // 사업자 단일 조회
    public Business getBusinessById(Long id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
    }
    // 사업자 생성
    public Business createBusiness(Business Business) {
        return businessRepository.save(Business);
    }
    // 사업자 수정
    public Business updateBusiness(Long id, Business updatedBusiness) {
        Business business = businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
        business.setCompanyName(updatedBusiness.getCompanyName());
        business.setRepresentativeName(updatedBusiness.getRepresentativeName());
        business.setContactEmail(updatedBusiness.getContactEmail());
        business.setContactPhone(updatedBusiness.getContactPhone());
        business.setAddress(updatedBusiness.getAddress());
        return businessRepository.save(business);
    }
    // 사업자 삭제
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }

}


