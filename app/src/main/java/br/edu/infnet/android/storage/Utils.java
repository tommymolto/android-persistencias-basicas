package br.edu.infnet.android.storage;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by live.prof on 16/10/2017.
 */

public class Utils {
    public static boolean salvaArquivo(File myExternalFile, String dado){
        try {
                    /*salva no arq externo e fecha o arq*/
            FileOutputStream fos = new FileOutputStream(myExternalFile);
            fos.write(dado.getBytes());
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String leArquivo(File myExternalFile){
        try {
            String myData="";
                    /*inicia a leitura*/
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
                    /*le conteudo*/
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
            return myData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
