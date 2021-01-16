package com.mnykolaichuk.luv2code.springboot.thymeleafdemo.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "secure_token")
public class SecureToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "token", unique = true)
    private String token;

    @Column(name = "verification_car_id")
    private Integer verificationCarId;

    @Column(name = "verification_username")
    private String verificationUsername;

    @CreationTimestamp
    @Column(name = "time_stamp", updatable = true)
    private Timestamp timeStamp;

    @Column(name = "expire_at", updatable = false)
    @Basic(optional = false)
    private LocalDateTime expireAt;

   @ManyToOne
   @JoinColumn(name = "employee_detail_id", referencedColumnName = "id")
   private EmployeeDetail employeeDetail;

    @ManyToOne
    @JoinColumn(name = "workshop_id", referencedColumnName = "id")
    private Workshop workshop;

   @Transient
   private boolean isExpired;

    public SecureToken() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getVerificationCarId() {
        return verificationCarId;
    }

    public void setVerificationCarId(Integer verificationCarId) {
        this.verificationCarId = verificationCarId;
    }

    public String getVerificationUsername() {
        return verificationUsername;
    }

    public void setVerificationUsername(String verificationUsername) {
        this.verificationUsername = verificationUsername;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }


    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }
}
