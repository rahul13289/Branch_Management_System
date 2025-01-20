package com.example.BMS_BackEnd.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BMS_BackEnd.Model.BranchDetailsVehicleType;

public interface VehicleDAO extends JpaRepository<BranchDetailsVehicleType, Long> {
	List<BranchDetailsVehicleType> findByBranchId(Long branchId);
}
