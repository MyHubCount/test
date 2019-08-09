package mybatis.bean;

/**
 * 学生实体类
 */
public class Student {

    private int id ;

    private  String  name;

    private String  sex;

    private int  age;

    private  String school;

    private  String  grade;

    private int  count;



    public Student(int id, String name, String sex, int age, String school, String grade, int count) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.school = school;
        this.grade = grade;
        this.count=count;
    }

    public Student() {
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
