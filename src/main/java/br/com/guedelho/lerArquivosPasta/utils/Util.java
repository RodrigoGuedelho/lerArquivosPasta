package br.com.guedelho.lerArquivosPasta.utils;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class Util {
	public static void findAllFilesInFolder(File folder, String nameFileGenerated) throws IOException {
		List<String[]> linhas = new ArrayList<String[]>();
		String[] cabecalho = {"nome do arquivo"};
		
        for (File file : folder.listFiles()) {
                if (!file.isDirectory()) {
                	linhas.add(new String[]{file.getName()});
                } else {
                	// Gera arquio para os arquivos de sub pastas.
                    findAllFilesInFolder(file, nameFileGenerated + "_" + file.getName());
                }
        }
        
        Writer writer = Files.newBufferedWriter(Paths.get(nameFileGenerated + ".csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        csvWriter.flush();
        writer.close();
	}
}
