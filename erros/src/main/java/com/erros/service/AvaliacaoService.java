package com.erros.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import org.springframework.stereotype.Service;
import com.erros.DTO.AvaliacaoDTO;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class AvaliacaoService {
    public String create(AvaliacaoDTO avaliacao) {
        System.out.println("AVALIACAO: ");
        savePDF(avaliacao);
        return "create";

    }

    public String savePDF(AvaliacaoDTO avaliacao) {
        var document = new Document();
        try {
            var data = LocalDateTime.now();
            DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd-MM-uuuu-hh-mm");
            String dataFormatada = formatterData.format(data);           
            var arquivoPDF = String.format(".\\%s-%s.pdf", avaliacao.getNome(),dataFormatada).replaceAll(" ", "");            
            PdfWriter.getInstance(document, new FileOutputStream(arquivoPDF));
            document.open();
            document.add(new Paragraph(avaliacao.getNome()));
            document.add(new Paragraph(avaliacao.getNota()));
            document.close();
            return "create";
        } catch (DocumentException ex) {
            System.out.println("Erro ao gerar PDF" + ex);
            return "erro";
        } catch (IOException ioe) {
            System.out.println("Erro ao gerar PDF 2 " + ioe);
            return "erro";
        }
    }
}
