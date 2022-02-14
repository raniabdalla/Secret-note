package org.launchcode.secretnote.controllers;

import org.hibernate.hql.internal.ast.ErrorReporter;
import org.launchcode.secretnote.data.NoteRepository;
import org.launchcode.secretnote.data.UserRepository;
import org.launchcode.secretnote.models.SecretNote;
import org.launchcode.secretnote.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("notes")
public class NotesController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    /**This controller is intended to be what the user sees when they log in. It will store all of their notes and allow
    them to perform CRUD actions on their notes - Caleb Roman(CR) */

    /**Displays the notes on the Dashboard Page - CR */
    @GetMapping
    public String displayNotes(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        int userID = user.getId();
        Iterable<SecretNote> notes = new ArrayList<>();
        notes = noteRepository.findAll();
        ArrayList<SecretNote> displayNotes = new ArrayList<>();
        for (SecretNote note : notes) {
            if (note.getUser().getId() == userID) {
                displayNotes.add(note);
            }
        }

        model.addAttribute("title", "All Notes");
        model.addAttribute("notes", displayNotes);
        model.addAttribute("userID", user.getId());
        model.addAttribute("user", user);

        return "notes/index";
    }


    /** Displays the form/note for new note creation - CR
     * This is located at "localhost:8080/notes/create when you run the application - CR */
    @GetMapping("/create")
    public String renderCreateNoteForm(HttpServletRequest request, Model model) {
        model.addAttribute("title", "New Note");
        model.addAttribute(new SecretNote());

            HttpSession session = request.getSession();
            User aUser = authenticationController.getUserFromSession(session);
            model.addAttribute("userID", aUser.getId());
            model.addAttribute("user", aUser);
            return "notes/create";
    }

    /** Makes sure the new note is valid and does not create errors, then saves. Takes userId as a path parameter.
     * Once you are logged in, click create note on the dashboard and your note will save with a user attached - CR */
    @PostMapping("/create")
    public String processCreateNoteForm(@ModelAttribute @Valid SecretNote newSecretNote, Errors errors, Model model,
                                        HttpServletRequest request) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "New Note");
            model.addAttribute("errors", errors);
            return "notes/create";
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        newSecretNote.setUser(user);
        noteRepository.save(newSecretNote);

        return "redirect:/notes";
    }

    /** Displays the form page for Deleting a note, this can be tweaked later to be more user friendly - CR */
//    @GetMapping("delete")
//    public String displayDeleteNoteForm(Model model) {
//        model.addAttribute("title", "Delete Note");
//        model.addAttribute("notes", noteRepository.findAll());
//        return "notes/delete";
//    }

    /** Processes deletion of notes, if ID is NOT NULL, deletes the note and returns user to dashboard - CR */
    /** BWG 2/9 - sorted out the POST parameter, and made this redirect to the dashboard when complete */
    @PostMapping("delete")
    public String processDeleteNoteForm(@ModelAttribute @Valid SecretNote newSecretNote, Errors errors, Model model,
                                        HttpServletRequest request) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "New Note");
            model.addAttribute("errors", errors);
            return "notes/create";
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        newSecretNote.setUser(user);
        noteRepository.save(newSecretNote);

        return "redirect:/notes";
    }

    /** BWG 2/9 - for saving an already existing note */
    @PostMapping("save")
    public String processEditNoteForm(@RequestParam @Valid Integer noteId,
                                      @RequestParam @Valid String content,
                                      @RequestParam @Valid String name,
                                      @RequestParam @Valid String color,
                                      Model model) {

        Optional<SecretNote> result = noteRepository.findById(noteId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Note ID: " + noteId);
        } else {
            SecretNote secretNote = result.get();
            secretNote.setContent(content);
            secretNote.setName(name);
            secretNote.setColor(color);
            noteRepository.save(secretNote);
        }

        return "redirect:/notes";
    }

    /** Displays specific note details upon clicking on a note displayed on user's dashboard - ZK */
    @GetMapping("details/{id}")
    public String displayNoteDetails(Model model, @PathVariable int id) {

        Optional<SecretNote> result = noteRepository.findById(id);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Note ID: " + id);
            return "notes/index";
        } else {
            SecretNote secretNote = result.get();
            model.addAttribute("title", secretNote.getName() + " Details");
            model.addAttribute("secretNote", secretNote);
        }
        return "notes/details";
    }


}
