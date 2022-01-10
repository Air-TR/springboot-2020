package com.tr.springboot.clone;

/**
 * 浅克隆
 *
 * @author rtao
 * @date 2021/12/29 16:48
 */
public class StudentShallowClone implements Cloneable{

    public static void main(String args[]) {
        StudentShallowClone stu1 = new StudentShallowClone();
        stu1.setNumber(12345);
        StudentShallowClone stu2 = (StudentShallowClone) stu1.clone();
        System.out.println(stu1 == stu2); // false

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());

        stu2.setNumber(54321);
        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());
    }

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        StudentShallowClone stu = null;
        try{
            stu = (StudentShallowClone)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}
