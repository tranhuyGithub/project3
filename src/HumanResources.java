
import java.util.ArrayList;
import java.util.Scanner;

public class HumanResources {
    // khai báo hàm Input
    public static Scanner scan = new Scanner(System.in);
    // khai báo arraylist Staff và Department
    public static ArrayList<Staff> staffArr = new ArrayList<>();
    public static ArrayList <Department> departmentArr = new ArrayList<>();

    // Funtion exit
    public static void enterToExit() {
        do {
            int exit = scan.nextInt();
            if (exit == 0)
                break;
        } while (true);
    }
    // Created data of department
    public static void createDepartment() {
        HumanResources.departmentArr.add(new Department("P01", "Business", 2));
        HumanResources.departmentArr.add(new Department("P02", "Technical", 2));
        HumanResources.departmentArr.add(new Department("P03", "Project", 2));
    }
    // Created data of staff
    public static void createStaff() {
        HumanResources.staffArr.add(new Employee("A1", "Employee 1", 24, 1.8, "20/10/2021", "P01", 2, 15));
        HumanResources.staffArr.add(new Employee("A2", "Employee 2", 24, 2.3, "20/10/2021", "P02", 4, 15));
        HumanResources.staffArr.add(new Employee("A3", "Employee 3", 24, 1.5, "20/10/2021", "P03", 3, 15));

        HumanResources.staffArr.add(new Manager("M1", "Manager 1", 34, 2.5, "10/03/2020", "P01", 1, "Business Leader"));
        HumanResources.staffArr.add(new Manager("M2", "Manager 2", 34, 2.6, "04/12/2020", "P02", 3, "Technical Leader"));
        HumanResources.staffArr.add(new Manager("M3", "Manager 3", 34, 2.9, "04/03/2020", "P03", 2, "Project Leader"));
    }

    // khai báo hàm Main
    public static void main(String [] args) {
        createDepartment();
        createStaff();
        featureMenu();
        }
     // Hàm hiện thị chức năng
    public static void featureMenu() {
        do {

            System.out.println("1. Company staff information");
            System.out.println("2. Department information");
            System.out.println("3. List staff in each department");
            System.out.println("4. Add new staff");
            System.out.println("5. Search staff");
            System.out.println("6. Staff salary in decrease Salary ");
            System.out.println("7. Staff salary in increase Salary");
            System.out.println("8. Exit");
            System.out.println("------------------------------------------------------------------------");
            System.out.print("Please choose a feature: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    showAllStaff();
                    break;
                case 2:
                    showAllDepartment();
                    break;
                case 3:
                    showStaffByDep();
                    break;
                case 4:
                    addStaff();
                    break;
                case 5:
                    searchStaff();
                    break;
                case 6:
                    showDecreaseSalary();
                    break;
                case 7:
                    showIncreaseSalary();
                    break;
                case 8:
                    return;

            }

        } while (true);
}

    // showAllStaff() : Chức năng 1
    // sử dụng displayInformation():  hiển thị danh sách nhân viên có trong công ty
    public static void showAllStaff() {

        System.out.println("List of all Staffs: ");
        System.out.println();
        System.out.printf("%-10s | %-15s | %-10s | %-20s | %-20s | %-15s | %-15s | %-20s | %-20s\n", "ID", "Name", "Age", "Salary Rate", "Start Date", "Department", "Days Off", "Overtime", "Position");
        // Sử dụng vòng lặp for để duyệt mảng
        for (Staff staff : staffArr) {
            System.out.println(staff.displayInformation());
        }
        System.out.println();
    }
    // showAllDepartment() : chức năng 2, toString(): hiện thị các bộ phận trong công ty
    public static void showAllDepartment(){

        System.out.println("List of Department: ");
        System.out.println();
        System.out.printf("%-20s | %-20s | %-20s |\n", "Department ID", "Department Name", "Number of Staff");
        //  sử dụng vòng lặp for để duyệt mảng

        for (Department department : departmentArr) {
            System.out.println(department.toString());
        }
        System.out.println();

    }
    // showStaffByDep():Chức năng 3: hiển thị nhân viên theo từng bộ phận
    public static void showStaffByDep(){

        // sử dụng vòng lăp for duyệt và in ra các department trong departmentArr

        for (Department department : departmentArr){
            System.out.printf("%-20s | %-20s | %-20s\n", "Department ID", "Department Name", "Number of Staff");
            System.out.println(department.toString());
            System.out.println();

            // tiếp tục dùng for để duyệt các tên bộ phận trùng nhau của nhân viên có trong mảng staffArr
            System.out.printf("%-10s | %-15s | %-10s | %-20s | %-20s | %-15s | %-15s | %-20s |\n", "ID", "Name", "Age", "Salary Rate", "Start Date", "Department", "Days Off", "Position");
            for (Staff staff : staffArr) {
                if (department.getDepartmentId().equals(staff.getDepartment())){
                    System.out.println(staff.displayInformation());
                }

            }

        }
        System.out.println();

    }
    // Chức năng 4: thêm nhân viên mới
    // Xác thực đầu vào ID
    public static boolean validateStaffById(String id){
        for (Staff staff : staffArr) {
            if (staff.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }
    // addStaff()
    public static void addStaff(){

        do {
            System.out.println("Add new Staff: ");

            //Nhập  ID
            System.out.print("ID: ");
            String id = scan.next();
                // check id đã được sử dụng chưa
            while (!validateStaffById(id)) {
                System.out.println("This an existing staff with this ID, input again!");
                System.out.print("ID: ");
                id = scan.next();
            }

            // nhập tên
            System.out.print("Name: ");
            String name = scan.next();

            // nhập tuổi
            System.out.print("Age: ");
            int age = scan.nextInt();

            // nhập hệ số lương
            System.out.print("Salary Rate: ");
            double salaryRate = scan.nextDouble();

            // nhập ngày bắt đầu làm việc
            System.out.print("Start Date (dd-mm-yyyy): ");
            String startDay = scan.next();

            // Nhận số ngày nghỉ
            System.out.print("Day Off: ");
            int dayOff = scan.nextInt();

            // nhập tên bộ phận
            System.out.print("Department : ");
            String departmentName = scan.next();
            Department department = null;
                // cộng thêm vào số thành viên trong bộ phận

            for (Department departmentX : departmentArr) {
                try{
                if (departmentX.getDepartmentName().equals(departmentName)) {
                    int num = department.getNumberOfStaff();
                    department.setNumberOfStaff(num+1);
                }
                }catch(NullPointerException e)
                {
                    System.out.print("NullPointerException Caught");
                }
            }


            // add Employee: nhập overtime, add staffArr(Employee)
            System.out.println("Please choose: 1 - Employee. 2 - Manager");
            int choice = scan.nextInt();

            if (choice == 1){
                System.out.print("Overtime Hours: ");
                int overTime = scan.nextInt();
                Employee employee = new Employee(id, name, age, salaryRate, startDay, departmentName, dayOff, overTime);
                staffArr.add(employee);
            }

            // add Manager: nhập position, add staffArr(Manager)
            if (choice == 2){
                System.out.print("Choose Position: 1 - Business Leader, 2 - Project Leader, 3 - Technical Leader");
                String position = "";
                int choose = scan.nextInt();
                switch (choose) {
                    case 1:
                        position = "Business Leader";
                        break;
                    case 2:
                        position = "Project Leader";
                        break;
                    case 3:
                        position = "Technical Leader";
                        break;

                }
                Manager manager = new Manager(id, name, age, salaryRate, startDay, departmentName, dayOff, position);
                staffArr.add(manager);
            }

            System.out.println("Do you want to continue? (Y=yes, N=no)");
            String choose = scan.next();
            if (!choose.equalsIgnoreCase("Y")){
                break;
            }

        }while (true);
    }

   // chức năng 5: searchStaff()
    public static void searchStaff(){
        System.out.println("Search Staff By: 1 - ID, 2 - Name ");
        int choice = scan.nextInt();
        scan.nextLine();
        // Sử dụng switch case để chọn phương thức tra cứu theo ID hoặc Name
        switch (choice) {
            case 1:
                // Nhập ID cần search
                System.out.print("ID: ");
                String id = scan.nextLine();
                System.out.printf("%-10s | %-15s | %-10s | %-20s | %-20s | %-15s | %-15s | %-20s | %-20s\n", "ID", "Name", "Age", "Salary Rate", "Start Date", "Department", "Days Off", "Overtime", "Position");
                boolean staffEqual = false;
                // dùng vòng lặp For để duyệt arrlist Staff, nếu trùng thì ra thông tin
                for (Staff staff : staffArr) {
                    if (id.equals(staff.getId())) {
                        System.out.println(staff.displayInformation());
                        staffEqual = true;
                    }

                }
                if (!staffEqual) {
                    System.out.println("Not Found!");
                }

                System.out.println();
                System.out.println("Input 0 to exit!");
                enterToExit();

            case 2:
                // Nhập name cần search
                System.out.print("Name: ");
                String name = scan.nextLine();
                System.out.printf("%-10s | %-15s | %-10s | %-20s | %-20s | %-15s | %-15s | %-20s | %-20s\n", "ID", "Name", "Age", "Salary Rate", "Start Date", "Department", "Days Off", "Overtime", "Position");

                // dùng vòng lặp For để duyệt arrlist Staff, nếu trùng thì ra thông tin
                boolean staffEqual2 = false;
                for (Staff staff : staffArr) {
                    if (name.equals(staff.getName())) {
                        System.out.println(staff.displayInformation());

                        staffEqual2 = true;
                    }

                }
                if (!staffEqual2) {
                    System.out.println("Not Found!");
                }

                System.out.println();
                System.out.println("Input 0 to exit!");
                enterToExit();

        }
    }
    // Chức năng 6: hiện thị lương giảm dần
    public static void showDecreaseSalary(){


        //Sắp xếp mảng staffArr.sort
        staffArr.sort((o1,o2) -> (int) (((ICalculator) o2).calculatorSalary() - ((ICalculator) o1).calculatorSalary()));
        System.out.println("Staff salary in decrease Salary: ");
        System.out.printf("%10s | %15s | %20s\n ", "ID", "Name", "Salary");
        // Dùng vòng lặp for để duyệt mảng

        for (Staff staff :  staffArr ) {
            System.out.println(staff.displaySalary());
        }
        System.out.println();

    }


    // Chức năng 7: hiện thị lương tăng dần
    public static void showIncreaseSalary(){


        //Sắp xếp mảng staffArr.sort
        staffArr.sort((o1,o2) -> (int) (((ICalculator) o1).calculatorSalary() - ((ICalculator) o2).calculatorSalary()));
        System.out.println("Staff salary in increase Salary: ");
        System.out.printf("%10s | %15s | %20s\n ", "ID", "Name", "Salary");
        // Dùng vòng lặp for để duyệt mảng
        for (Staff staff : staffArr ) {
            System.out.println(staff.displaySalary());
        }
        System.out.println();
    }

}
