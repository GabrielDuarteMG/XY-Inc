package xy.inc;
import java.util.*;
import org.ini4j.*;
import java.io.*;
/**
 *
 * @author Gabriel Duarte
 */
public class XYInc {
    public static int QntTotal = 0;
    static ArrayList < String > Locais = new ArrayList < String > ();
    static ArrayList < Integer > CordsX = new ArrayList < Integer > ();
    static ArrayList < Integer > CordsY = new ArrayList < Integer > ();
    public static void main(String[] args) {
        Importar();
        Scanner input = new Scanner(System.in);
        System.out.printf("GPS System - XY Inc. \n1-Consultar todos os pontos\n2-Cadastrar ponto\n3-Buscar pontos proximos\n0-Sair\nDigite a opcao desejada:");
        int escolha = input.nextInt();
        if (escolha == 1)
            printAll();
        else if (escolha == 2) {
            Scanner input2 = new Scanner(System.in);
            System.out.printf("\n\nDigite o nome do ponto de interesse: ");
            String NomePonto = input2.next();
            Scanner input3 = new Scanner(System.in);
            int PontoX;
            System.out.printf("\nDigite a cordenada X do ponto de interesse: ");
            PontoX = input3.nextInt();
            Scanner input4 = new Scanner(System.in);
            int PontoY;
            System.out.printf("\nDigite a cordenada Y do ponto de interesse: ");
            PontoY = input4.nextInt();
            if (PontoY > -1 && PontoX > -1) {
                Registrar(NomePonto, PontoX, PontoY);
                Exportar();
            }
        } else if (escolha == 3) {
            Scanner input2 = new Scanner(System.in);
            int PontoX;
            System.out.printf("\nDigite a cordenada X: ");
            PontoX = input2.nextInt();
            Scanner input3 = new Scanner(System.in);
            int PontoY;
            System.out.printf("\nDigite a cordenada Y: ");
            PontoY = input3.nextInt();
            Scanner input4 = new Scanner(System.in);
            int Raio;
            System.out.printf("\nDigite o raio: ");
            Raio = input4.nextInt();
            for (int x = 0; x < Locais.size(); x++) {
                int contX = CordsX.get(x) - PontoX;
                int contY = CordsY.get(x) - PontoY;
                if (contX <= Raio && contY <= Raio)
                    System.out.printf("\n" + Locais.get(x));
            }
        } else
            Exportar();
    }
    static void Exportar() {
        try {
            SaveDataBase();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
        } finally {
            return;
        }
    }
    static void Importar() {
        try {
            LoadDataBase();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
        } finally {
            return;
        }
    }
    static void LoadDataBase() throws IOException {
        final String dir = System.getProperty("user.dir");
        File inioutfile = new File(dir + "/Base.ini");
        Wini Arquivo = new Wini(new File(inioutfile.getAbsolutePath()));
        for (int x = 0; x < Arquivo.get("Config", "CordsTotal", int.class); x++) {
            Registrar(Arquivo.get(Integer.toString(x), "Local"), Arquivo.get(Integer.toString(x), "CordX", int.class), Arquivo.get(Integer.toString(x), "CordY", int.class));
        }
        QntTotal = Locais.size();
    }
    static void SaveDataBase() throws IOException {

        final String dir = System.getProperty("user.dir");
        File inioutfile = new File(dir + "/Base.ini");
        if (!inioutfile.exists()) {
            if (!inioutfile.createNewFile()) return;
        }
        Wini Arquivo = new Wini(new File(inioutfile.getAbsolutePath()));
        Arquivo.put("Config", "CordsTotal", QntTotal);
        for (int x = 0; x < Locais.size(); x++) {
            Arquivo.put(Integer.toString(x), "Local", Locais.get(x));
            Arquivo.put(Integer.toString(x), "CordX", CordsX.get(x));
            Arquivo.put(Integer.toString(x), "CordY", CordsY.get(x));
        }
        Arquivo.store();

    }
    public static void printAll() {
        for (int x = 0; x < Locais.size(); x++) {
            System.out.printf("\n'" + Locais.get(x) + "'(" + CordsX.get(x) + "," + CordsY.get(x) + ")");
        }
    }
    public static void Registrar(String Nome, int X, int Y) {
        int QntAtual = QntTotal;
        QntTotal++;
        Locais.add(Nome);
        CordsX.add(X);
        CordsY.add(Y);
    }
}
