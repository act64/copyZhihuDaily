package usst.lei.copyzhihudaily.readcontent.mvp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hchen on 2016/3/15.
 */
public class LatestModel implements Serializable {
    /**
     * date : 20160315
     * stories : [{"images":["http://pic1.zhimg.com/8f449451cb53cb5fd9b7bf4eda880920.jpg"],"type":0,"id":8005211,"ga_prefix":"031515","title":"章鱼小丸子，鸡蛋仔，自己做，成功率挺高"},{"images":["http://pic3.zhimg.com/56ea46c7152e8383797c9db2f68f582a.jpg"],"type":0,"id":8004953,"ga_prefix":"031514","title":"国税局说以后二手房交易得交增值税，先不要慌"},{"images":["http://pic1.zhimg.com/b919a4655b9e574e1b323893d194cfc4.jpg"],"type":0,"id":8004555,"ga_prefix":"031513","title":"借着「人机大战」，聊一聊「欺骗」 AlphaGo 这类人工智能的方法"},{"images":["http://pic2.zhimg.com/8e2a9b75a592ccceaee97d63e78f12b1.jpg"],"type":0,"id":7947899,"ga_prefix":"031512","title":"做着手术麻醉醒了，能听见呼吸声谈话声，却无法动弹"},{"images":["http://pic3.zhimg.com/9325e8ee69aea02026de93335fc2f5ae.jpg"],"type":0,"id":8004194,"ga_prefix":"031511","title":"不吹牛不吓唬人，教你些家庭用电安全的常识"},{"images":["http://pic1.zhimg.com/fd7361acdf4a67f7e110fa9fe40a2530.jpg"],"type":0,"id":7999495,"ga_prefix":"031510","title":"为什么牛津大学的赛艇那么厉害？"},{"images":["http://pic2.zhimg.com/90aff61cb0f8fc113f29330bf177a339.jpg"],"type":0,"id":8000283,"ga_prefix":"031509","title":"第一次，中国科学家造出了神秘的「反物质」"},{"images":["http://pic4.zhimg.com/bc6bde0761b0fdc246bcf29026ea4587.jpg"],"type":0,"id":8000734,"ga_prefix":"031508","title":"以后还想狂办银行卡，恐怕不能那么随意了"},{"images":["http://pic4.zhimg.com/993339d68e86827591138322aa63db6f.jpg"],"type":0,"id":7969782,"ga_prefix":"031507","title":"这些神秘而古老的家族，厉害得不行"},{"images":["http://pic2.zhimg.com/30688ddd5bee94f60c106f2ed5e9e325.jpg"],"type":0,"id":8000117,"ga_prefix":"031507","title":"昂山素季下台后，接任缅甸总统的是她的私人司机？"},{"images":["http://pic4.zhimg.com/9d63b68ce4d200df6b44d6c13aaade67.jpg"],"type":0,"id":8000641,"ga_prefix":"031507","title":"父母催你生孩子，你却想选择丁克，是不孝吗？"},{"images":["http://pic4.zhimg.com/780e57e7c4c02bdc5be1bf96abbd5297.jpg"],"type":0,"id":8002732,"ga_prefix":"031507","title":"读读日报 24 小时热门 · 谁能告诉我这是怎么回事"},{"images":["http://pic1.zhimg.com/f4ba4aa1719f15eb7c7cda21e3fa953c.jpg"],"type":0,"id":7985077,"ga_prefix":"031506","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic3.zhimg.com/188af9104637a4244becca9fa829669a.jpg","type":0,"id":8004555,"ga_prefix":"031513","title":"借着「人机大战」，聊一聊「欺骗」 AlphaGo 这类人工智能的方法"},{"image":"http://pic2.zhimg.com/d16113def96c915ddfeadf195f504909.jpg","type":0,"id":8000734,"ga_prefix":"031508","title":"以后还想狂办银行卡，恐怕不能那么随意了"},{"image":"http://pic4.zhimg.com/fd92e64a13c66f91e682496e6213be53.jpg","type":0,"id":8000641,"ga_prefix":"031507","title":"父母催你生孩子，你却想选择丁克，是不孝吗？"},{"image":"http://pic4.zhimg.com/1a8c3c46f7eda37a4e80d0e84c25e3a3.jpg","type":0,"id":7984500,"ga_prefix":"031421","title":"一个优等生，捐掉去哈佛读书的钱，扔掉汽车，还烧了现金"},{"image":"http://pic2.zhimg.com/67c98b9530c814c2d778439e5d13f1ad.jpg","type":0,"id":8002732,"ga_prefix":"031507","title":"读读日报 24 小时热门 · 谁能告诉我这是怎么回事"}]
     */

    private String date;
    /**
     * images : ["http://pic1.zhimg.com/8f449451cb53cb5fd9b7bf4eda880920.jpg"]
     * type : 0
     * id : 8005211
     * ga_prefix : 031515
     * title : 章鱼小丸子，鸡蛋仔，自己做，成功率挺高
     */

    private List<StoriesEntity> stories;
    /**
     * image : http://pic3.zhimg.com/188af9104637a4244becca9fa829669a.jpg
     * type : 0
     * id : 8004555
     * ga_prefix : 031513
     * title : 借着「人机大战」，聊一聊「欺骗」 AlphaGo 这类人工智能的方法
     */

    private List<TopStoriesEntity> top_stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<StoriesEntity> stories) {
        this.stories = stories;
    }

    public void setTop_stories(List<TopStoriesEntity> top_stories) {
        this.top_stories = top_stories;
    }

    public String getDate() {
        return date;
    }

    public List<StoriesEntity> getStories() {
        return stories;
    }

    public List<TopStoriesEntity> getTop_stories() {
        return top_stories;
    }

    public static class StoriesEntity implements Serializable{
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public List<String> getImages() {
            return images;
        }
    }

    public static class TopStoriesEntity implements Serializable {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public void setImage(String image) {
            this.image = image;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getTitle() {
            return title;
        }
    }
}
