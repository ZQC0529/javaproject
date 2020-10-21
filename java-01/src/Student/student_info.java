package Student;

public class student_info {
    private int id;
    private String name;
    private String address;
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void printStudent(student_info STU){
        System.out.printf("名字是："+STU.getName()+'\n'+"地址是:"+STU.getAddress()+'\n'+"学号是:"+STU.getId()+'\n'+"性别是："+STU.getSex());
    }
}
