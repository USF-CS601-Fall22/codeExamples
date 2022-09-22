package designPatterns.mvc.simple;

public class Main {
    public static void main(String[] args) {
        StudentDataModel model = new StudentDataModel();
        Student st1 = new Student("Alice", 3.5, 0);
        Student st2 = new Student("Neal", 3.4, 1);
        model.addStudent(st1);
        model.addStudent(st2);

        Controller controller = new StudentController(model);
        StudentView view = new StudentView(model, controller);
        view.createView();

    }
}
