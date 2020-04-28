package com.synechron.healthInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechron.healthInsurance.model.ProviderList;

@Repository
public interface ProviderListRepository extends JpaRepository<ProviderList, Integer> {

}
