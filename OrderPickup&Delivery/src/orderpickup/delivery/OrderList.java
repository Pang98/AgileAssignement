/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderpickup.delivery;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class OrderList {
    int orderid;
    String name, contact, address, orderType, status;
    Date odate,pdate;
    public OrderList(int orderid, String name, String contact){
        this.orderid=orderid;
        this.name=name;
        this.contact=contact;
    }
    
    public OrderList(int orderid, String name, String contact, String address){
        this.orderid=orderid;
        this.name=name;
        this.contact=contact;
        this.address=address;
    }
    
    public OrderList(int orderid, String name,Date odate,String orderType, Date pdate,String status){
        this.orderid=orderid;
        this.name=name;
        this.odate=odate;
        this.orderType=orderType;
        this.pdate=pdate;
        this.status=status;
    }
    
    public int getId(){
        return this.orderid;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getContact(){
        return this.contact;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    @Override
    public String toString(){
        if(this.address==null){
            return orderid+"                  "+name+"             "+contact;
        }
        return "Name: "+name+"             Contact: "+contact+ "           Address:"+address;
    }
    
    
}
