package vn.edu.fit.nlu.learnsqlite;

public class Student {
    private int id;
    private String fullname;
    private String malop;

    public Student(int id, String fullname, String malop) {
        this.id = id;
        this.fullname = fullname;
        this.malop = malop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }
    public Student(String fullname, String malop ){
        this.fullname = fullname;
        this.malop = malop;
    }

    @Override
    public String toString() {
        return id+" - "+fullname+" - "+malop;
    }
}
