package klasser;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class ArrangementRegister {
    
    private ArrayList<Arrangement> arrangementer;

    public ArrangementRegister() {
        this.arrangementer = new ArrayList<Arrangement>();
    }

    @Override
    public String toString() {
        StringBuilder stringbuffer = new StringBuilder("Arrangementer:\n");
        for (Arrangement arrangement : this.arrangementer) {
            stringbuffer.append(arrangement);
            stringbuffer.append("\n");
        }

        return stringbuffer.toString();
    }

    public void registrerArrangement(String navn, String sted, String arrangør, String type, long tidspunkt) {
        this.arrangementer.add(new Arrangement(this.arrangementer.size(), 
                                               navn, sted, arrangør, type, tidspunkt));
    }

    public ArrayList<Arrangement> finnArrangementPåSted(String sted) {
        ArrayList<Arrangement> resultatbuffer = new ArrayList<Arrangement>();
        
        for (Arrangement arrangement : this.arrangementer) {
            if (arrangement.getSted().equals(sted)) {
                resultatbuffer.add(arrangement);
            }
        }

        return resultatbuffer;
    }

    public ArrayList<Arrangement> finnArrangementPåDato(int dato) {
        String datoString = String.valueOf(dato);
        
        if (datoString.length() != 8) {
            throw new InvalidParameterException(String.format("Date misformatted! Expected an integer on the format YYYYMMDD, but %d was passed", dato));
        }

        ArrayList<Arrangement> resultatbuffer = new ArrayList<Arrangement>();

        for (Arrangement arrangement : this.arrangementer) {
            if (String.valueOf(arrangement.getTidspunkt()).substring(0, 8).equals(datoString)) {
                resultatbuffer.add(arrangement);
            }
        }

        return resultatbuffer;
    }

    public ArrayList<Arrangement> finnArrangementMellomDatoer(int start, int slutt) {
        String startDatoString = String.valueOf(start);
        String sluttDatoString = String.valueOf(slutt);

        if (startDatoString.length() != 8 || sluttDatoString.length() != 8) {
            throw new InvalidParameterException("Date misformatted! Expected an integer on the format YYYYMMDD");
        }

        LocalDate startDato = LocalDate.of(Integer.parseInt(startDatoString.substring(0, 4)),
                                           Integer.parseInt(startDatoString.substring(4, 6)),
                                           Integer.parseInt(startDatoString.substring(6, 8)));
        
        LocalDate sluttDato = LocalDate.of(Integer.parseInt(sluttDatoString.substring(0, 4)),
                                           Integer.parseInt(sluttDatoString.substring(4, 6)),
                                           Integer.parseInt(sluttDatoString.substring(6, 8)));

        ArrayList<Arrangement> resultatbuffer = new ArrayList<Arrangement>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");

        for (LocalDate dato = startDato; dato.isBefore(sluttDato.plusDays(1)); dato = dato.plusDays(1)) {
            resultatbuffer.addAll(this.finnArrangementPåDato(Integer.parseInt(dato.format(formatter))));
        }

        return resultatbuffer;
    }

    public ArrayList<Arrangement> sorterPåTidspunkt() {
        ArrayList<Arrangement> resultatbuffer = new ArrayList<Arrangement>();
        ArrayList<Arrangement> arrangementkopi = new ArrayList<Arrangement>(this.arrangementer);
        ArrayList<Long> tidspunkter = new ArrayList<Long>();

        for (Arrangement arrangement : this.arrangementer) {
            if (!tidspunkter.contains(arrangement.getTidspunkt())) {
                tidspunkter.add(arrangement.getTidspunkt());
            }
        }

        tidspunkter.sort(Comparator.naturalOrder());

        for (long tidspunkt : tidspunkter) {
            for (Arrangement arrangement : arrangementkopi) {
                if (tidspunkt == arrangement.getTidspunkt()) {
                    resultatbuffer.add(arrangement);
                }
            }
        }

        return resultatbuffer;
    }

    public ArrayList<Arrangement> sorterPåSted() {
        ArrayList<Arrangement> resultatbuffer = new ArrayList<Arrangement>();
        ArrayList<Arrangement> arrangementkopi = new ArrayList<Arrangement>(this.arrangementer);
        ArrayList<String> steder = new ArrayList<String>();

        for (Arrangement arrangement : this.arrangementer) {
            if (!steder.contains(arrangement.getSted())) {
                steder.add(arrangement.getSted());
            }
        }

        steder.sort(Comparator.naturalOrder());

        for (String sted : steder) {
            for (Arrangement arrangement : arrangementkopi) {
                if (sted.equals(arrangement.getSted())) {
                    resultatbuffer.add(arrangement);
                }
            }
        }

        return resultatbuffer;
    }

    public ArrayList<Arrangement> sorterPåType() {
        ArrayList<Arrangement> resultatbuffer = new ArrayList<Arrangement>();
        ArrayList<Arrangement> arrangementkopi = new ArrayList<Arrangement>(this.arrangementer);
        ArrayList<String> typer = new ArrayList<String>();

        for (Arrangement arrangement : this.arrangementer) {
            if (!typer.contains(arrangement.getEventType())) {
                typer.add(arrangement.getEventType());
            }
        }

        typer.sort(Comparator.naturalOrder());

        for (String type : typer) {
            for (Arrangement arrangement : arrangementkopi) {
                if (type.equals(arrangement.getEventType())) {
                    resultatbuffer.add(arrangement);
                }
            }
        }

        return resultatbuffer;
    }
}
