package com.datum.mapping.model;

import javax.persistence.Column;
import
        javax.persistence.Entity;
import javax.persistence.Id;
import
        javax.persistence.Table;

@Entity
@Table(name = "personal_info", schema = "customer")
public class PersonalInfo {

    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
