package com.company;

import com.company.controller.Controller;
import com.company.model.NoteBook;
import com.company.view.View;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller controller =
                new Controller(new NoteBook(), new View());
        // Run
        controller.processUser();
    }
}
