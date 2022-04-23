package com.godydev.demjdbc;

public class Driver extends Crud{
    public static void main(String[] args){
        Crud c = new Crud();
        c.insertData();
        c.readData();
        c.deleteData();
    }
}
