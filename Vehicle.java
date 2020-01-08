import java.util.Scanner;


class Vehicle{
    String brand;
    String licensePlateNum;
    public Vehicle(){}
    public double getSumRental(int days){
        return 0;
    }
}


class Car extends Vehicle{
    String model;
    public Car(){

    }
    public Car(String brand,String licensePlateNum,int choice){
        super.brand = brand;
        super.licensePlateNum = licensePlateNum;
        switch(choice){
        case 1:
            this.model = "����";
            break;
        case 2:
            this.model = "����";
            break;
        case 3:
            this.model = "ԽҰ";
        }
    }
    public String toString(){
        return "Ʒ��:" + brand + "\n���ƺ�:" + licensePlateNum + "\n����:" + model;
    }
    public double getSumRental(int days){
        double pricePerDay = 0;
        switch(model){
        case "����":
            pricePerDay = 300;
            break;
        case "����":
            pricePerDay = 350;
            break;
        case "ԽҰ":
            pricePerDay = 500;
        }
        return days * pricePerDay;
    }
}

class Bus extends Vehicle{
    int seats;
    public Bus(){

    }
    public Bus(String brand,String licensePlateNum,int seats){
        super.brand = brand;
        super.licensePlateNum = licensePlateNum;
        this.seats = seats;
    }
    public String toString(){
        return "Ʒ��:" + brand + "\n���ƺ�:" + licensePlateNum + "\n��λ��:" + seats + "��";
    }    
    public double getSumRental(int days){
        double pricePerDay = seats > 16 ? 600 : 400;
        return days * pricePerDay;
    }
}


class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("��������Ҫѡ��ĳ���Ʒ��:");
        String brand = sc.nextLine();

        System.out.print("��������Ҫѡ��ĳ��ĳ��ƺ�:");
        String licensePlateNum = sc.nextLine();

        System.out.print("������ʹ������:");
        int days = sc.nextInt();
        
        System.out.print("��ѡ��ͨ���ߵ�����:\n(1)Car\n(2)Bus\n��ѡ��: (1/2)?");
        int choice = sc.nextInt();

        switch(choice){
        case 1:
            System.out.println("��ѡ��Car�ĳ���:\n(1)����\n(2)����\n(3)ԽҰ\n��ѡ��:(1/2/3)?");
            choice = sc.nextInt();
            Car v1 = new Car(brand,licensePlateNum,choice);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("����ѡ����:");
            System.out.println(v1);
            System.out.println("�����:");
            System.out.println(v1.getSumRental(days));
            break;
        case 2:
            System.out.println("������Bus����λ��:");
            int seats = sc.nextInt();
            Bus v2 = new Bus(brand,licensePlateNum,seats);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("����ѡ����:");
            System.out.println(v2);
            System.out.println("�����:");
            System.out.println(v2.getSumRental(days));
            break;
        default:
            System.out.println("error input!!!");
            return;
        }
    }
}