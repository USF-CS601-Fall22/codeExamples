package designPatterns.mvc.simple;

public class StudentController implements Controller {

    private Model model;

    public StudentController(Model model) {
        this.model = model;
    }


    @Override
    public void changeStudentName(String name1, String name2) {
        if (!name1.isEmpty() && !name2.isEmpty() && (!name1.equals(name2)))
            // can perform other checks
            model.changeName(name1, name2);
    }
}
