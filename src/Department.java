public class Department {
    // khai báo các biến
    private final String departmentId;
    private final String departmentName;
    private int numberOfStaff;

    // get Input của người dùng
    public Department( String departmentId, String departmentName, int numberOfStaff) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.numberOfStaff = numberOfStaff;
    }
   //
    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }


    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }
    // Hàm in ra thông tin bộ phận
    public String toString(){
        return String.format("%-20s | %-20s | %-20d\n", getDepartmentId(), getDepartmentName(), getNumberOfStaff());
    }
}
