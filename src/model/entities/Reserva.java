package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author felip
 */
public class Reserva {

    private Integer rooNumber;
    private Date checkIn, checkOut;
    private static Date agora;

    private static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    //---------- CONSTRUTORES
    public Reserva() {
    }

    public Reserva(Integer rooNumber, Date checkIn, Date checkOut) {
        this.rooNumber = rooNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    //---------- GETs
    public Integer getRooNumber() {
        return rooNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    //----------- SETs
    public void setRooNumber(Integer rooNumber) {
        this.rooNumber = rooNumber;
    }

    public long duracao() {
        //---- DIFERENCA DAS DATAS EM MILISEGUNDOS
        long diff = checkOut.getTime() - checkIn.getTime();

        //--- CONVERTE E RETORNA OS MILISEDUNDOS E RETORNA EM DIAS (INT)
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }

    public String atualizaDatas(Date checkIn, Date checkOut) {

        // RECEBE A DATA ATUAL DO SISTEMA
        agora = new Date();

        if (checkIn.before(agora) || checkOut.before(agora)) {
            return "--------- ERRO NA RESERVA; NOVAS DATAS DEVEM SER FUTURAS DATAS ---------";
        }

        if (!checkOut.after(checkIn)) {
            return "--------- ERRO NA RESERVA; DATA DO CHECK-OUT DEVE SER POSTERIOR A DATA DO CHECK-IN ---------";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        //----------- CASO DÊ TUDO CERTO RETORNA NULL
        return null;
    }

    @Override
    public String toString() {
        return "Quarto " + rooNumber + ", check-In: " + fmt.format(checkIn) + ", check-Out: " + fmt.format(checkOut) + ", " + duracao() + " noites.";
    }

}
