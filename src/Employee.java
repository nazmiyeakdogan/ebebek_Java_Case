import java.util.ArrayList;
import java.util.Scanner;

public class Employee {

    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        setName(name);
        setSalary(salary);
        setWorkHours(workHours);
        setHireYear(hireYear);
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            while (salary <= 0) {
                Scanner input = new Scanner(System.in);
                System.out.print("Invalid salary try again      : ");
                salary = input.nextInt();
            }
        }
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {

        if (workHours >= 40 && workHours <= 80) {
            this.workHours = workHours;
        } else {
            while (workHours < 40) {
                Scanner input = new Scanner(System.in);
                System.out.print("Invalid work hours try again  : ");
                workHours = input.nextInt();
            }
        }
        this.workHours = workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        if (hireYear <= 2021 && hireYear > 1995) {
            this.hireYear = hireYear;
        } else {
            while (hireYear > 2021 || hireYear < 1995) {
                Scanner input = new Scanner(System.in);
                System.out.print("Invalid hire year try agin    : ");
                hireYear = input.nextInt();
            }

        }
        this.hireYear = hireYear;
    }

    public static double tax(double salary) {

        if (salary < 1000) {
            return 0;
        }
        return salary * 0.03;
    }

    public static double bonus(int workHours) {
        int bonus = 0;
        if (workHours > 40) {
            bonus = (workHours - 40) * 30;
        }
        return bonus;
    }

    public static double raiseSalary(int hireYear, double salary, int workHours) {
        double totalRaise = 0;

        if (2021 - hireYear < 10) {
            totalRaise = (salary - tax(salary) + bonus(workHours)) * 0.05;
        } else if (2021 - hireYear > 9 && 2021 - hireYear < 20) {
            totalRaise = (salary - tax(salary) + bonus(workHours)) * 0.10;
        } else if (2021 - hireYear > 19) {
            totalRaise = (salary - tax(salary) + bonus(workHours)) * 0.15;
        }
        return totalRaise;
    }

    public static double totalSalary(double salary, int workHours) {

        return salary - tax(salary) + bonus(workHours);
    }


    public static double newSalary(double salary, int workHours, int hireYear) {

        return (salary + raiseSalary(hireYear, salary, workHours));
    }

    public static void getEmployee(ArrayList<Employee> liste) {

        Scanner input = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);

        Employee employee = new Employee();

        System.out.print("Full Name    : ");
        employee.setName(input.nextLine());

        System.out.print("Salary       : ");
        employee.setSalary(inputInt.nextDouble());

        System.out.print("Work Hours   : ");
        employee.setWorkHours(inputInt.nextInt());

        System.out.print("Hire Year    : ");
        employee.setHireYear(inputInt.nextInt());

        liste.add(employee);
    }

    public static void menu() {
        ArrayList<Employee> liste = new ArrayList<>();
        Scanner inputInt = new Scanner(System.in);

        int secim = 0;
        do {
            System.out.print("1-Add Employee\n2-List\n3-Exit\nChoose Action: ");
            secim = inputInt.nextInt();

            switch (secim) {
                case 1:
                    Employee.getEmployee(liste);
                    break;
                case 2:
                    System.out.println(liste);
                    break;
                case 3:
                    System.out.println("Log Out!");
                    break;
            }
        } while (secim < 3);
    }

    @Override
    public String toString() {
        return "\u001b[34;1m" + "Employee İnformation" + "\u001b[0m" + "\n" +

                "Employee name  = " + name + "\n" +
                "Salary         = " + salary + " TL\n" +
                "WorkHours      = " + workHours + "\n" +
                "HireYear       = " + hireYear + " TL\n" +
                "Tax            = " + tax(salary) + " TL\n" +
                "Bonus          = " + bonus(workHours) + " TL\n" +
                "Raise Salary   = " + raiseSalary(hireYear, salary, workHours) + "TL\n" +
                "Total Salary   = " + totalSalary(salary, workHours) + "TL\n" +
                "New Salary     = " + newSalary(salary, workHours, hireYear) + "TL"
                ;
    }
}
