// class Employee chứ các Hàm xử lý dữ liệu của employee kế thừa từ class Staff và Interface ICalculator
public class Employee extends Staff implements ICalculator {
    // Khai báo biến overtime mà Staff không có
    private final int overTime;
    // Hàm Constructor tạo employee với các thuôc tính đã được khai báo
    public Employee(String id, String name, int age, double salaryRate, String startDay, String departmentName, int dayOff, int overTime  ) {
        super(id, name, age, salaryRate, startDay,departmentName, dayOff);
        this.overTime = overTime;
    }

    public int getOverTime() {
        return overTime;
    }


    @Override
    // Hàm calculatorSalary() return về kết quả công thức tính lương
    public double calculatorSalary() {
        return (getSalaryRate()*3000000 + overTime*200000);
    }
    // return thông tin employee
    public String displayInformation(){
        return String.format("%-10s | %-15s | %-10d | %-20s | %-20s | %-15s | %-15d | %-20d\n", getId(), getName(), getAge(), getSalaryRate(), getStartDay(), getDepartment(), getDayOff(), getOverTime());
    }
    // Return Lương của nhân viên
    public String displaySalary(){
        return String.format("%10s | %15s | %,.2f\n ", getId(), getName(), calculatorSalary());
    }

}
