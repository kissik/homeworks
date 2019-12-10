package com.company.model;

import com.company.controller.InputNoteNoteBook;
import com.company.model.entity.Model;

import java.util.ArrayList;
import java.util.List;

import static com.company.view.TextConstant.*;

public class NoteBook {
    List<Model> list;

    public NoteBook(){
        list = new ArrayList<>();
        list.add(new Model("Irochka","login123456"));
        list.add(new Model("Student","student8"));
    }

    public void addNote(InputNoteNoteBook inputNoteNoteBook) throws EqualLoginException {
        boolean isAdded = true;
        for(Model note : list){
            if (note.getLogin().equals(inputNoteNoteBook.getLogin()) == true)
                throw new EqualLoginException("This login already exists: ", note.getLogin());
        }
        list.add(new Model(inputNoteNoteBook.getFirstName(), inputNoteNoteBook.getLogin()));
    }

    public String printNoteBook(){
        StringBuffer printedNoteBook = new StringBuffer(STRING_BUFFER);
        printedNoteBook.append("-----> The Note Book <-----");
        for(Model note : list)
            printedNoteBook
                    .append(NEW_LINE)
                    .append(note.getLogin())
                    .append(" - ")
                    .append(note.getFirstName());

        return printedNoteBook.toString();
    }
}
