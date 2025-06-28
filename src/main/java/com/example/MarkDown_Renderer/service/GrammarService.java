package com.example.MarkDown_Renderer.service;

import org.languagetool.JLanguageTool;
import org.languagetool.Languages;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GrammarService {
    public List<Object> checkGrammar(String content) {
        try {
            JLanguageTool tool = new JLanguageTool(Languages.getLanguageForShortCode("en-GB"));
            List<RuleMatch> matches = tool.check(content);
            return matches.stream().map(match -> {
                return Map.of(
                        "message", match.getMessage(),
                        "offset", match.getFromPos(),
                        "length", match.getToPos() - match.getFromPos(),
                        "replacements", match.getSuggestedReplacements()
                );
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Grammar check failed", e);
        }
    }
}

