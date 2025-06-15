package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reserva;

/**
 *
 * @author felip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    // EXECUÇÃO DO PROGRAMA TRATADA, E NÃO PROPAGADA COMO ANTES (THROWS)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        //------------ VARIAVEIS
        int num;
        Date checkIn, checkOut;
        Reserva r1;

        try {

            System.out.println("Número do quarto:");
            num = sc.nextInt();

            System.out.println("Data do check-In: (dd/MM/yyyy)  ");
            checkIn = fmt.parse(sc.next());
            System.out.println("Data do check-Out: (dd/MM/yyyy)  ");
            checkOut = fmt.parse(sc.next());

            r1 = new Reserva(num, checkIn, checkOut);
            System.out.println("RESERVA REALIZADA ----> " + r1.toString());

            System.out.println("");
            System.out.println("----------------------- Informe novas datas para atualizar a RESERVA -----------------------");

            System.out.println("Data do check-In: (dd/MM/yyyy)  ");
            checkIn = fmt.parse(sc.next());
            System.out.println("Data do check-Out: (dd/MM/yyyy)  ");
            checkOut = fmt.parse(sc.next());

            r1.atualizaDatas(checkIn, checkOut);

            System.out.println("NOVA RESERVA REALIZADA ----> " + r1.toString());

        } catch (ParseException e) {
            System.out.println("FORMATO DE DATE INVÁLIDO ----> " + e);

        } catch (IllegalArgumentException e) {
            System.out.println("ERRO NA RESERVA ----> " + e.getMessage());
        }

        sc.close();

    }

}
