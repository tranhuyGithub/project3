// Class abstract Staff

public abstract class Staff {
    // KHai báo các biến chung của nhân viên và quản lý
    private final String id;
    private final String name;
    private final int age;
    private final double salaryRate;
    private final String startDay;
    private final String department;
    private final int dayOff;
    // Hàm Constructor của Staff với các thuộc tính được khai báo
    public Staff(String id, String name, int age, double salaryRate, String startDay, String department, int dayOff){
            this.age = age;
            this.id = id;
            this.name = name;
            this.salaryRate = salaryRate;
            this.startDay = startDay;
            this.department = department;
            this.dayOff = dayOff;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }



    public double getSalaryRate() {
        return salaryRate;
    }



    public String getStartDay() {
        return startDay;
    }



    public String getDepartment() {
        return department;
    }



    public int getDayOff() {
        return dayOff;
    }

    // Phương thức hiển thị thông tin
    public abstract String displayInformation();

    // Phương thức hiển thị số lương
    public abstract String displaySalary();
}
