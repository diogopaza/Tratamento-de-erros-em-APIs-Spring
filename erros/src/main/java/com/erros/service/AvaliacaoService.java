package com.erros.service;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.erros.DTO.AvaliacaoDTO;


@Service
public class AvaliacaoService {

    public byte[] create(AvaliacaoDTO dto)  {

        try {
            var myPDF = savePDF(dto);
            byte[] array = Files.readAllBytes(java.nio.file.Paths.get(myPDF));
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
