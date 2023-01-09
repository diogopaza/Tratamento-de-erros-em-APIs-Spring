package com.erros.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.clipper.Paths;

import org.apache.pdfbox.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erros.DTO.AvaliacaoDTO;

import lombok.AllArgsConstructor;

@Service
public class AvaliacaoService {

    public byte[] create(AvaliacaoDTO dto)  {

        try {
            var myPDF = savePDF(dto);
            byte[] array = Files22.readAllBytes(java.nio.file.Paths.get(myPDF));
            return array;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Async
    public String savePDF(AvaliacaoDTO avaliacao) {
        var document = new Document();
        try {
            var data = LocalDateTime.now();
            DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd-MM-uuuu-hh-mm");
            String dataFormatada = formatterData.format(data);
            var arquivoPDF = String.format("./%s-%s.pdf", avaliacao.getNome(), dataFormatada).replaceAll(" ", "");
            PdfWriter.getInstance(document, new FileOutputStream(arquivoPDF));
            document.open();
            document.add(new Paragraph(avaliacao.getNome()));
            document.add(new Paragraph(avaliacao.getNota()));
            document.close();
            return arquivoPDF;
        } catch (DocumentException ex) {
            System.out.println("Erro ao gerar PDF" + ex);
            return "erro";
        } catch (IOException ioe) {
            System.out.println("Erro ao gerar PDF 2 " + ioe);
            return "erro";
        }
    }
}
