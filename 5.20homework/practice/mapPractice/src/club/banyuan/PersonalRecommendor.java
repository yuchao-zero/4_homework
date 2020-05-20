package club.banyuan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PersonalRecommendor implements Recommender {
    /**
     * 类包含一个名为Likes的HashMap，该HashMap将人的名字作为key， 映射到项目的（书，电影，歌曲等）名称的List。
     * 使用LinkedList类作为实现类。使用适当的访问修饰符可防止另一个类直接访问或编辑Likes。
     */
    private final HashMap<String, List<String>> Likes = new HashMap<>();


    /**
     * 接收一个人的名字和一个项目的名称，并将该项目添加到该人的List集合中
     *
     * @param name
     * @param project
     */
    @Override
    public void addLikes(String name, String project) {
        if (Likes.containsKey(name)) {
            Likes.get(name).add(project);
        } else {
            List<String> list = new LinkedList<>();
            Likes.put(name, list);
            list.add(project);
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
    public boolean likeBoth(String name, String oneProject, String anotherProject) throws UnknownPersonException {
        if (!Likes.containsKey(name)) {
            throw new UnknownPersonException("未找到该人");
        } else {
            return Likes.get(name).contains(oneProject) && Likes.get(name).contains(anotherProject);
        }
    }

    /**
     * 接收一个人名作为参数，返回项目的List
     *
     * @param name
     * @return
     */
    @Override
    public List<String> recommendByPerson(String name) {
        return Likes.get(name);
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
        List<String> recommendLikes = new LinkedList<>();
        for (List<String> likes : Likes.values()) {
            if (likes.contains(project)) {
                recommendLikes.addAll(likes);
                recommendLikes.remove(project);
            }
        }
        return recommendLikes;
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
