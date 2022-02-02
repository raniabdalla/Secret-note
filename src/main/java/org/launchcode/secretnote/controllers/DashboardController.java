package org.launchcode.secretnote.controllers;

import org.launchcode.secretnote.data.NoteRepository;
import org.launchcode.secretnote.models.SecretNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("notes")
public class DashboardController {

    @Autowired
    private NoteRepository noteRepository;

    /**This controller is intended to be what the user sees when they log in. It will store all of their notes and allow
    them to perform CRUD actions on their notes - Caleb Roman(CR) */

    /**Displays the notes on the Dashboard Page - CR */
    @GetMapping public String displayNotes(Model model) {
        model.addAttribute("title", "All Notes");
        model.addAttribute("notes", noteRepository.findAll());
        return "notes/index";
    }


    /** Displays the form/note for new note creation - CR */
    @GetMapping("create")
    public String renderCreateNoteForm(Model model) {
        model.addAttribute("title", "New Note");
        model.addAttribute(new SecretNote());
        return "notes/create";
    }

    /** Makes sure the new note is valid and does not create errors, then saves - CR */
    @PostMapping("create")
    public String processCreateNoteForm(@ModelAttribute @Valid SecretNote newSecretNote, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "New Note");
            return "notes/create";
        }

        noteRepository.save(newSecretNote);
        return "dashboard";
    }

    /** Displays the form page for Deleting a note, this can be tweaked later to be more user friendly - CR */
    @GetMapping("delete")
    public String displayDeleteNoteForm(Model model) {
        model.addAttribute("title", "Delete Note");
        model.addAttribute("notes", noteRepository.findAll());
        return "notes/delete";
    }

    /** Processes deletion of notes, if ID is NOT NULL, deletes the note and returns user to dashboard - CR */
    @PostMapping("delete")
    public String processDeleteNoteForm(@RequestParam(required = false) String[] noteIds) {

        if (noteIds !=null) {
            for (String id : noteIds) {
                noteRepository.deleteById(id);
            }
        }
        return "dashboard";

    }

    /** Displays specific note details upon clicking on a note displayed on user's dashboard - ZK */
    @GetMapping("details")
    public String displayNoteDetails(Model model, @RequestParam String id) {

        Optional<SecretNote> result = noteRepository.findById(id);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Note ID: " + id);
            return "redirect:../";
        } else {
            SecretNote secretNote = result.get();
            model.addAttribute("title", secretNote.getName() + " Details");
            model.addAttribute("secretNote", secretNote);
        }
        return "notes/details";
    }
}
