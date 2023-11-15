package pl.zabrze.zs10.listy3psroda;
public class Produkt {
    private String nazwa;
    private float cena;

    public Produkt(String nazwa, float cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public float getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return "Produkt:" + nazwa ;
    }
}
