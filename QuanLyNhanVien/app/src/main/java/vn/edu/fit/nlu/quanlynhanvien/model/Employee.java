package vn.edu.fit.nlu.quanlynhanvien.model;

public class Employee {
    private String id, name;
    private int dayNum;
    private boolean isPartTime;

    public Employee() {
    }

    public Employee(String id, String name, int dayNum, boolean isPartTime) {
        this.id = id;
        this.name = name;
        this.dayNum = dayNum;
        this.isPartTime = isPartTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public boolean isPartTime() {
        return isPartTime;
    }

    public void setPartTime(boolean partTime) {
        isPartTime = partTime;
    }

    private double salary() {
        return dayNum * (isPartTime ? 150 : 500);
    }

    @Override
    public String toString() {
        return id+" - "+name+"-"+dayNum+"-->"+ (isPartTime ? "PartTime" : "FullTime")+"="+salary();
    }
}
