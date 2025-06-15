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

    public void atualizaDatas(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Quarto " + rooNumber + ", check-In: " + fmt.format(checkIn) + ", check-Out: " + fmt.format(checkOut) + ", " + duracao() + " noites.";
    }

}
