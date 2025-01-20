package com.example.BMS_BackEnd.Model;

import jakarta.persistence.*;

@Entity
public class BranchDetailsVehicleType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleType;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private BranchDetails branch;  

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public BranchDetails getBranch() {
        return branch;
    }

    public void setBranch(BranchDetails branch) {
        this.branch = branch;
    }

}
