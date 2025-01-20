package com.example.BMS_BackEnd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BMS_BackEnd.DAO.BankDAO;
import com.example.BMS_BackEnd.DAO.BranchDAO;
import com.example.BMS_BackEnd.DAO.VehicleDAO;
import com.example.BMS_BackEnd.Model.BankDetails;
import com.example.BMS_BackEnd.Model.BranchDetails;
import com.example.BMS_BackEnd.Model.BranchDetailsVehicleType;

@Service
public class BranchService {

	@Autowired
	private BranchDAO branch;

	@Autowired
	private BankDAO bank;

	@Autowired
	private VehicleDAO vehicle;

	public void addBranchDetails(BranchDetails branchDetails) {

		branch.save(branchDetails);

		List<BankDetails> bankDetailsList = branchDetails.getBankDetails();
		List<BranchDetailsVehicleType> vehicleTypeList = branchDetails.getVehicleTypes();

		String branchCode = branchDetails.getBranchCode();
		if (bankDetailsList != null && !bankDetailsList.isEmpty()) {
			for (BankDetails bankDetail : bankDetailsList) {
				bankDetail.setBranchCode(branchCode);
				bank.save(bankDetail);
			}
		}

		if (vehicleTypeList != null && !vehicleTypeList.isEmpty()) {
			for (BranchDetailsVehicleType vehicleType : vehicleTypeList) {
				
				vehicleType.setBranch(branchDetails);
			}
			vehicle.saveAll(vehicleTypeList); 
		}
	}

	public List<BranchDetails> getAllBranches() {
		return branch.findAll();
	}

	public BranchDetails getBranchByCode(String branchCode) {
		BranchDetails br = branch.findByBranchCode(branchCode);

		Long branchId = br.getId();

		List<BranchDetailsVehicleType> vehicleTypes =vehicle.findByBranchId(branchId);

		List<BankDetails> bankDetails = bank.findByBranchCode(branchCode);

		br.setVehicleTypes(vehicleTypes);
		br.setBankDetails(bankDetails);

		return br;
	}

}