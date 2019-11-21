package main.java.model.modelToView;

import jdk.swing.interop.SwingInterOpUtils;

public class Command implements ICommand {
    @Override
    public void setTokenAt(int row, int col, int player) {
        //TODO: implement
        System.out.println("setting player " + (player+1) + " set token at "+ row + " " + col);
    }

    @Override
    public void clearTokenAt(int row, int col) {
        //TODO: implement
        System.out.println("token at " + row + " " + col +" was cleared");
    }

    @Override
    public void setMessage(String s) {
        //TODO: implement
        System.out.println("message was set to " + s);
    }
}
