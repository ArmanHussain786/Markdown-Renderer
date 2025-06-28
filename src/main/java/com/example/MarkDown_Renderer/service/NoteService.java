package com.example.MarkDown_Renderer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Value("${notes.storage.path:./notes}")
    private String notesDir;

    public void saveNote(String filename, String content) {
        try {
            Path path = Paths.get(notesDir, sanitizeFilename(filename));
            Files.createDirectories(path.getParent());
            Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Could not save note", e);
        }
    }

    public String readNote(String filename) {
        try {
            Path path = Paths.get(notesDir, sanitizeFilename(filename));
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not read note", e);
        }
    }

    public List<String> listNotes() {
        try {
            return Files.list(Paths.get(notesDir))
                    .filter(Files::isRegularFile)
                    .map(p -> p.getFileName().toString())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Could not list notes", e);
        }
    }

    private String sanitizeFilename(String filename) {
        return filename.replaceAll("[^a-zA-Z0-9._-]", "_");
    }
}
