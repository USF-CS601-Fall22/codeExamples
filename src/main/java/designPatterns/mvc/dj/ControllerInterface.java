package designPatterns.mvc.dj;
/** The code is from Head First Design Patterns book **/  

public interface ControllerInterface {
	void start();
	void stop();
	void increaseBPM();
	void decreaseBPM();
 	void setBPM(int bpm);
}
