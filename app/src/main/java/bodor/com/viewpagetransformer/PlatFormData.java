package bodor.com.viewpagetransformer;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class PlatFormData {
    public int imageId;
    public String name;

    public PlatFormData(){

    }

    public PlatFormData(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
