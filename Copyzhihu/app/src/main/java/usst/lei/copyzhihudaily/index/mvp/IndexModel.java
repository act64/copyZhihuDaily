package usst.lei.copyzhihudaily.index.mvp;

import java.io.Serializable;

/**
 * Created by hchen on 2016/3/14.
 */
public class IndexModel implements Serializable {
    private static final long serialVersionUID = 6517266942540869108L;

    /**
     * text : © Fido Dido
     * img : http://p2.zhimg.com/10/7b/107bb4894b46d75a892da6fa80ef504a.jpg
     */

    private String text;
    private String img;

    public void setText(String text) {
        this.text = text;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public String getImg() {
        return img;
    }
}
