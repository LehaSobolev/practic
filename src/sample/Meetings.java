package sample;

public class Meetings {
    public int idMeeting;
    public int idCommission;
    public String DateM;
    public String Zero;
    public String Place;
    public String Organizer;


    public Meetings(int idCommission, int idMeeting,
                              String DateM, String Zero,String Place,String Organizer) {
        this.idCommission = idCommission;
        this.idMeeting = idMeeting;
        this.DateM = DateM;
        this.Zero = Zero;
        this.Place = Place;
        this.Organizer = Organizer;

    }
}
