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
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        //------------ VARIAVEIS
        int num;
        Date checkIn, checkOut;
        String erro;
        Reserva r1;

        System.out.println("Número do quarto:");
        num = sc.nextInt();

        System.out.println("Data do check-In: (dd/MM/yyyy)  ");
        checkIn = fmt.parse(sc.next());

        System.out.println("Data do check-Out: (dd/MM/yyyy)  ");
        checkOut = fmt.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("--------- ERRO NA RESERVA; DATA DO CHECK-OUT DEVE SER POSTERIOR A DATA DO CHECK-IN ---------");
        } else {
            r1 = new Reserva(num, checkIn, checkOut);
            System.out.println("RESERVA REALIZADA ----> " + r1.toString());

            System.out.println("");
            System.out.println("----------------------- Informe novas datas para atualizar a RESERVA -----------------------");

            System.out.println("Data do check-In: (dd/MM/yyyy)  ");
            checkIn = fmt.parse(sc.next());

            System.out.println("Data do check-Out: (dd/MM/yyyy)  ");
            checkOut = fmt.parse(sc.next());

            //---------- ATUALIZARdATAS RETORNA UMA STRING
            erro = r1.atualizaDatas(checkIn, checkOut);
            if (erro != null) {
                System.out.println("ERRO ----> " + erro);
            } else {
                System.out.println("NOVA RESERVA REALIZADA ----> " + r1.toString());
            }

        }

        sc.close();

    }

}
