package club.banyuan;

import java.util.List;
import java.util.Set;

public interface Recommender {
    void addLikes(String name, String project);

    boolean likeBoth(String name, String oneProject, String anotherProject) ;

    List<String> recommendByPerson(String name);

    List<String> recommendByProject(String project);

}

