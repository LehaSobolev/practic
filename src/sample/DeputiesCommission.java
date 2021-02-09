package sample;

public class DeputiesCommission {
    public int idCommission;
    public int idDeputy;
    public String DateIn;
    public String DateOut;


    public DeputiesCommission(int idCommission, int idDeputy,
                   String DateIn, String DateOut) {
        this.idCommission = idCommission;
        this.idDeputy = idDeputy;
        this.DateIn = DateIn;
        this.DateOut = DateOut;
    }
}
