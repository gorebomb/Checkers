package main.java.model.modelToView;

public class RejectCommand implements IRejectCommand {

	@Override
	public void execute() {
		System.out.println("Move rejected!");
	}

}
