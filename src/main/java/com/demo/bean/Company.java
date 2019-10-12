package com.demo.bean;

import com.demo.annotation.Column;
import com.demo.annotation.Table;

/**
 * Created by axes on 2019/10/12.
 */
@Table("company_info")
public class Company {
    @Column("company_name")
    private String companyName;
    @Column("employ_acount")
    private Integer employAcount;

    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployAcount() {
        return employAcount;
    }

    public void setEmployAcount(Integer employAcount) {
        this.employAcount = employAcount;
    }

    @Column("registered_capital")
    private Integer registeredCapital;
}
