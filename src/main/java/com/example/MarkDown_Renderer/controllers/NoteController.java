package com.example.MarkDown_Renderer.controllers;
import com.example.MarkDown_Renderer.models.NoteRequest;
import com.example.MarkDown_Renderer.service.GrammarService;
import com.example.MarkDown_Renderer.service.MarkdownRenderService;
import com.example.MarkDown_Renderer.service.NoteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;
    private final GrammarService grammarService;
    private final MarkdownRenderService markdownRenderService;

    public NoteController(NoteService noteService, GrammarService grammarService, MarkdownRenderService markdownRenderService) {
        this.noteService = noteService;
        this.grammarService = grammarService;
        this.markdownRenderService = markdownRenderService;
    }

    @PostMapping
    public ResponseEntity<?> saveNote(@RequestBody NoteRequest request) {
        noteService.saveNote(request.getFilename(), request.getContent());
        return ResponseEntity.ok(Map.of("message", "Note saved successfully."));
    }

    @PostMapping("/grammar-check")
    public ResponseEntity<?> checkGrammar(@RequestBody NoteRequest request) {
        var issues = grammarService.checkGrammar(request.getContent());
        return ResponseEntity.ok(Map.of("issues", issues));
    }

    @GetMapping
    public ResponseEntity<List<String>> listNotes() {
        return ResponseEntity.ok(noteService.listNotes());
    }

    @GetMapping(value = "/{filename}/render", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> renderNote(@PathVariable String filename) {
        String content = noteService.readNote(filename);
        return ResponseEntity.ok(markdownRenderService.renderMarkdown(content));
    }
}