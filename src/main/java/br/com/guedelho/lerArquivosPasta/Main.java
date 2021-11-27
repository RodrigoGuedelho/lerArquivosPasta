package br.com.guedelho.lerArquivosPasta;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.io.Writer;
import com.opencsv.CSVWriter;

import br.com.guedelho.lerArquivosPasta.utils.Util;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {	
    public static void main(String[] args)  {
    	String caminhoPasta = JOptionPane.showInputDialog("Digite o caminho da pasta que você desaja mapear os arquivos \n"
    			+ "\n Exemplo: /home/rodrigo/Imagens");
    	String nomeArquivoGerado = JOptionPane.showInputDialog("Digite o caminho seguido do nome do aruqivo que deve ser gerado. \n"
    			+ "\n Exemplo: /home/rodrigo/Documentos/arquivo");
    	try {
    		File folder = new File(caminhoPasta);
        	Util.findAllFilesInFolder(folder, nomeArquivoGerado);
        	JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo.");
		}
    	
    }
}
