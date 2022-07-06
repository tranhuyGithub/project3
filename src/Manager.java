// Class Manager chứa các hàm xử lý dữ liệu của manager kế thừa từ class Staff và Interface ICalculator
public class Manager extends Staff implements ICalculator {
    // khai báo biến position mà Staff không có
    private final String position;

    // Hàm constructor  tạo manager với các thông tin dữ liệu truyền vào
    public Manager(String id, String name, int age, double salaryRate, String startDay, String department, int dayOff,String position){
        super(id, name, age, salaryRate, startDay, department, dayOff );
        this.position = position;
    }


    public String getPosition() {
        return position;
    }

    @Override
    // Hàm return kết quả tính lương của manager
    public double calculatorSalary() {
        if(getPosition().equalsIgnoreCase("Business Leader")){
            return getSalaryRate() * 5000000 + 8000000;
        } else if (getPosition().equalsIgnoreCase("Project Leader")) {
            return getSalaryRate() * 5000000 + 5000000;
        } else if (getPosition().equalsIgnoreCase("Technical Leader")) {
            return getSalaryRate() * 5000000 + 6000000;
        } else {
            return 0;
        }
    }
    // Hàm hiển thị thông tin
    public String displayInformation() {

        return String.format("%-10s | %-15s | %-10d | %-20s | %-20s | %-15s | %-15d | %-20s | %-20s\n", getId(), getName(), getAge(), getSalaryRate(), getStartDay(), getDepartment(), getDayOff(), "", getPosition());
    }
    // Hàm hiển thị lương
    public String displaySalary(){
        return String.format("%10s | %15s | %,.2f\n ", getId(), getName(), calculatorSalary());
    }
}
