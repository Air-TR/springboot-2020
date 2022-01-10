package com.tr.springboot.clone;

/**
 * 深度克隆
 *
 * @author rtao
 * @date 2021/12/29 16:53
 */
public class StudentDeepClone implements Cloneable {

    public static void main(String args[]) {
        Address addr = new Address();
        addr.setAdd("杭州市");
        StudentDeepClone stu1 = new StudentDeepClone();
        stu1.setNumber(123);
        stu1.setAddr(addr);

        StudentDeepClone stu2 = (StudentDeepClone) stu1.clone();
        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());

        addr.setAdd("西湖区");
        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());

        stu1.setNumber(200);
        stu1.getAddr().setAdd("苏州市");
        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());
    }

    private int number;

    private Address addr;

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        StudentDeepClone stu = null;
        try{
            stu = (StudentDeepClone) super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }

}

class Address {

    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

}