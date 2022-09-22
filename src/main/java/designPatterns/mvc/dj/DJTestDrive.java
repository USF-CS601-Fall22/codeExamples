package designPatterns.mvc.dj;

/** The code is from Head First Design Patterns book **/

public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
    }
}
