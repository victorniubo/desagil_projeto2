import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity {
    public static void main(String[] args) {

        //A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
        //excessões sejam tratadas
        try {

            //Criação de um buffer para a ler de uma stream
            BufferedReader StrR = new BufferedReader(new FileReader("C:\\IntelliJ\\CloseCSV\\src\\main\\resources\\tabela2.csv"));

            String Str;
            String[] TableLine;

            //Essa estrutura do looping while é clássica para ler cada linha
            //do arquivo
            while((Str = StrR.readLine())!= null){
                //Aqui usamos o método split que divide a linha lida em um array de String
                //passando como parametro o divisor ";".
                TableLine = Str.split(";");

                //O foreach é usadao para imprimir cada célula do array de String.
                for (String cell : TableLine) {
                    System.out.print(cell+" ");
                }
                System.out.println("\n");
            }
            //Fechamos o buffer
            StrR.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

}


