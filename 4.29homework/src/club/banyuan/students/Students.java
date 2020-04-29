package club.banyuan.students;

public class Students {
    private String name;

    protected   Students(String name){
        System.out.println(name);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
    public void methodStudy(){
        System.out.println("good good study");
    }

}
