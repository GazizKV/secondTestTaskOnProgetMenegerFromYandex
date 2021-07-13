public class Asessor {
    String login;
    Integer uid;
    Integer docid;
    Short jud;
    Short cjud;
    Integer allScore = 0;
    Integer scorOfCorrectAns = 0;
    Integer scorOfInCorrectAns = 0;
    Integer scorOfDifferences = 0;

    public Asessor(String login, Integer uid, Integer docid, Short jud, Short cjud) {
        this.login = login;
        this.uid = uid;
        this.docid = docid;
        this.jud = jud;
        this.cjud = cjud;
    }
}