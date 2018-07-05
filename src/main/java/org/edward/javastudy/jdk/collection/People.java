package org.edward.javastudy.jdk.collection;

public class People {

    int id;
    String name;
    People(int id){
        this.id = id;
    }

    public int hashCode(){
        return this.id%10;
    }

}
