package com.example.MarkDown_Renderer.service;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import org.springframework.stereotype.Service;

@Service
public class MarkdownRenderService {
    private final Parser parser = Parser.builder().build();
    private final HtmlRenderer renderer = HtmlRenderer.builder().build();

    public String renderMarkdown(String markdown) {
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }
}