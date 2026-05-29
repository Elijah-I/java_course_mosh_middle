package me.middle;

public class Main {
    static void main() {
        var textBoxOne = new TextBox();
        textBoxOne.setText("Box 1");
        System.out.println("text: " + textBoxOne.text);

        var textBoxTwo = new TextBox();
        textBoxTwo.setText("Box 2");
        System.out.println("text: " + textBoxTwo.text);
    }
}
