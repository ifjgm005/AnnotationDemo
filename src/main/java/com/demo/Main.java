package com.demo;

import com.demo.bean.Company;
import com.demo.bean.Customer;
import com.demo.parse.Query;

public class Main {

    public static void main(String[] args) {
        // new  Customer，并赋值
        Customer customer1 = new Customer();
        customer1.setUserName("zhangsan");
        customer1.setAge(18);
        customer1.setEmail("xxx@163.com,xxx@qq.com,xxx@yahoo.com.cn");


        Customer customer2 = new Customer();
        customer2.setCity("hangzhou");
        customer2.setId(100);


        Company company = new Company();
        company.setCompanyName("杭州大大大泡泡糖");
        company.setEmployAcount(2000);
        company.setRegisteredCapital(100);


        //调用 query 方法，获取 sql 语句
        String sql1 = Query.query(customer1);


        String sql2 = Query.query(customer2);

        String query = Query.query(company);


        //打印sql语句
        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(query);

    }
}
