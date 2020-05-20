package club.banyuan;

import java.util.List;

public interface Recommender {
    void addLikes(String name, String project);

    boolean likeBoth(String name, String oneProject, String anotherProject)throws UnknownPersonException ;

    List<String> recommendByPerson(String name);

    List<String> recommendByProject(String project);

}

