package com.company.controller;

import com.company.model.EqualLoginException;
import com.company.model.NoteBook;
import com.company.view.View;

import java.util.Scanner;

/**
 * Created by student on 26.09.2017.
 */
public class Controller {
    private NoteBook noteBook;
    private View view;

    public Controller(NoteBook noteBook, View view) {
        this.noteBook = noteBook;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        InputNoteNoteBook inputNoteNoteBook =
                new InputNoteNoteBook(view, sc);
        boolean theSame = false;
        do {
            theSame = false;
            try {
                noteBook.addNote(inputNoteNoteBook.inputNote());
            }catch(EqualLoginException e){
                theSame = true;
                view.printMessage(e.toString());
            }

        }while(theSame);

        view.printMessage(noteBook.printNoteBook());
    }
}
