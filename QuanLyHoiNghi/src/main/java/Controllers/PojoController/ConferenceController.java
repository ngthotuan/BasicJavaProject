package Controllers.PojoController;

import Model.Pojo.Conference;

import java.util.List;

public class ConferenceController extends BasicDAO{
    public static Conference getConference(int id){
        return (Conference) get(id, Conference.class);
    }
    public static List<Conference> getConferences(){
        return (List<Conference>) getAll("Conferences");
    }

    public static boolean createConference(Conference conference) {
        if(getConference(conference.getId()) != null){
            return false;
        }
        else {
            return create(conference);
        }
    }
    public static boolean updateConference(Conference conference) {
        if(getConference(conference.getId()) == null){
            return false;
        }
        else {
            return update(conference);
        }
    }
}
