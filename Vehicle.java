package com.credata.xiaorui.packages.p2;

import java.util.Scanner;


class Vehicle{
    String brand;
    String licensePlateNum;
    public Vehicle(){

    }
    public Vehicle(String brand,String licensePlateNum){
        this.brand = brand;
        this.licensePlateNum = licensePlateNum;
    }
    public double getSumRental(int days){
        return 0;
    }
}


class Car extends Vehicle{
    private String model;
    public Car(){

    }
    public Car(String brand,String licensePlateNum,int choice){
        super(brand,licensePlateNum);
        switch(choice){
        case 1:
            this.model = "两厢";
            break;
        case 2:
            this.model = "三厢";
            break;
        case 3:
            this.model = "越野";
        }
    }
    public String toString(){
        return "品牌:" + brand + "\n车牌号:" + licensePlateNum + "\n车型:" + model;
    }
    public double getSumRental(int days){
        double pricePerDay = 0;
        switch(model){
        case "两厢":
            pricePerDay = 300;
            break;
        case "三厢":
            pricePerDay = 350;
            break;
        case "越野":
            pricePerDay = 500;
        }
        return days * pricePerDay;
    }
}

class Bus extends Vehicle{
    private int seats;
    public Bus(){

    }
    public Bus(String brand,String licensePlateNum,int seats){
        super(brand,licensePlateNum);
        this.seats = seats;
    }
    public String toString(){
        return "品牌:" + brand + "\n车牌号:" + licensePlateNum + "\n座位数:" + seats + "座";
    }    
    public double getSumRental(int days){
        double pricePerDay = seats > 16 ? 600 : 400;
        return days * pricePerDay;
    }
}


class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入您要选择的车的品牌:");
        String brand = sc.nextLine();

        System.out.print("请输入您要选择的车的车牌号:");
        String licensePlateNum = sc.nextLine();

        System.out.print("请输入使用天数:");
        int days = sc.nextInt();
        
        System.out.print("请选择交通工具的种类:\n(1)Car\n(2)Bus\n请选择: (1/2)?");
        int choice = sc.nextInt();

        Vehicle v;
        switch(choice){
        case 1:
            System.out.println("请选择Car的车型:\n(1)两厢\n(2)三厢\n(3)越野\n请选择:(1/2/3)?");
            choice = sc.nextInt();
            v = new Car(brand,licensePlateNum,choice);
            break;
        case 2:
            System.out.println("请输入Bus的座位数:");
            int seats = sc.nextInt();
            v = new Bus(brand,licensePlateNum,seats);
            break;
        default:
            System.out.println("error input!!!");
            return;
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("您的选择是:");
        System.out.println(v);
        System.out.println("租金是:");
        System.out.println(v.getSumRental(days));
    }
}