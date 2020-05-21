package club.banyuan;

import java.util.*;

public class PersonalRecommendor implements Recommender {
    /**
     * 类包含一个名为Likes的HashMap，该HashMap将人的名字作为key， 映射到项目的（书，电影，歌曲等）名称的List。
     * 使用LinkedList类作为实现类。使用适当的访问修饰符可防止另一个类直接访问或编辑Likes。
     */
    private final Map<String, Set<String>> likes = new HashMap<>();


    /**
     * 接收一个人的名字和一个项目的名称，并将该项目添加到该人的List集合中
     *
     * @param name
     * @param project
     */
    @Override
    public void addLikes(String name, String project) {
        if (likes.containsKey(name)) {
            likes.get(name).add(project);
        } else {
            Set<String> set = new HashSet<>();
            likes.put(name, set);
            set.add(project);
        }
    }

    /**
     * 接收一个人的名字和两个项目的名称，
     * 并返回一个布尔值，表示该人是否喜欢这两个项目。
     * 如果HashMap中没有给定名称的人，
     * likesBoth应该抛出UnknownPersonException以报告未找到该人
     *
     * @param name
     * @param oneProject
     * @param anotherProject
     * @return
     */
    @Override
    public boolean likeBoth(String name, String oneProject, String anotherProject) {
        if (!likes.containsKey(name)) {
            throw new UnknownPersonException("未找到该人");
        }
        return likes.get(name).contains(oneProject) && likes.get(name).contains(anotherProject);
        //Set<String> projects = likes.get(name);
        //return projects.containsAll(set.of(oneProject,anotherProject));
        
    }

    /**
     * 接收一个人名作为参数，返回项目的List
     *
     * @param name
     * @return
     */
    @Override
    public List<String> recommendByPerson(String name) {
        return new ArrayList<>(likes.get(name));
        //return likes.get(name);
    }

    /**
     * 接收一个项目名作为参数，返回项目的List
     * 该List中的项目是所有Likes中包含的人中包含有给定项目名称的其他项目的集合
     *
     * @param project
     * @return
     */
    @Override
    public List<String> recommendByProject(String project) {
        Set<String> recommendLikes = new HashSet<>();
        for (Set<String> likes : likes.values()) {
            if (likes.contains(project)) {
                recommendLikes.addAll(likes);
            }
        }
        recommendLikes.remove(project);
        return new ArrayList<>(recommendLikes);
    }

    public static void main(String[] args) {
        PersonalRecommendor personalRecommendor = new PersonalRecommendor();
        personalRecommendor.addLikes("张三", "java");
        personalRecommendor.addLikes("张三", "c++");
        personalRecommendor.addLikes("张三", "php");
        personalRecommendor.addLikes("李四", "python");
        personalRecommendor.addLikes("李四", "golang");
        personalRecommendor.addLikes("李四", "php");
        personalRecommendor.addLikes("王五", "c#");
        personalRecommendor.addLikes("王五", "php");
        personalRecommendor.addLikes("王五", "pascal");
        try {
            System.out.println(personalRecommendor.likeBoth("张三", "java", "c++"));
            System.out.println(personalRecommendor.recommendByPerson("李四"));
            System.out.println(personalRecommendor.recommendByProject("php"));
        } catch (UnknownPersonException e) {
            System.out.println(e.getMessage());
        }
    }
}
